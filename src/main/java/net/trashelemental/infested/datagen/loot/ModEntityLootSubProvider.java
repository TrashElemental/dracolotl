package net.trashelemental.infested.datagen.loot;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.EntityLootSubProvider;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.flag.FeatureFlags;
import net.trashelemental.infested.entity.ModEntities;

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
