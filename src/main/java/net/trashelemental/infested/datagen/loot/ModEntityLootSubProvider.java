package net.trashelemental.infested.datagen.loot;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.EntityLootSubProvider;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.trashelemental.infested.entity.ModEntities;
import net.trashelemental.infested.item.ModItems;

import java.util.stream.Stream;

public class ModEntityLootSubProvider extends EntityLootSubProvider {
    public ModEntityLootSubProvider(HolderLookup.Provider lookupProvider) {
        super(FeatureFlags.DEFAULT_FLAGS, lookupProvider);
    }



    @Override
    public void generate() {


    }





    @Override
    protected Stream<EntityType<?>> getKnownEntityTypes() {
        return Stream.of(



        );
    }
}
