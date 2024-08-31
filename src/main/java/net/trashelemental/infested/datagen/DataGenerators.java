package net.trashelemental.infested.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.trashelemental.infested.datagen.loot.ModLootTableProvider;
import net.trashelemental.infested.datagen.tags.ModBlockTagGenerator;
import net.trashelemental.infested.datagen.tags.ModEntityTagGenerator;
import net.trashelemental.infested.datagen.tags.ModItemTagGenerator;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, modid = "infested_swarms_spiders")
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {

        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();


        generator.addProvider(event.includeServer(), new ModRecipeProvider(output, lookupProvider));
        generator.addProvider(event.includeClient(), new ModBlockStateProvider(output, existingFileHelper));
        generator.addProvider(event.includeClient(), new ModItemModelProvider(output, existingFileHelper));
        ModBlockTagGenerator blockTagGenerator = generator.addProvider(event.includeServer(),
                new ModBlockTagGenerator(output, lookupProvider, existingFileHelper));
        generator.addProvider(event.includeServer(), new ModItemTagGenerator(output, lookupProvider, blockTagGenerator.contentsGetter()));
        generator.addProvider(event.includeServer(), new ModEntityTagGenerator(output, lookupProvider, existingFileHelper));
        generator.addProvider(event.includeServer(), new ModAdvancementProvider(output, lookupProvider, existingFileHelper));

        generator.addProvider(event.includeServer(), (DataProvider.Factory<ModLootTableProvider>) providerOutput ->
                new ModLootTableProvider(providerOutput, lookupProvider)
        );

    }
}
