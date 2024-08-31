package net.trashelemental.infested.datagen.loot;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.trashelemental.infested.block.ModBlocks;

import java.util.Set;

public class ModBlockLootSubProvider extends BlockLootSubProvider {
    public ModBlockLootSubProvider(HolderLookup.Provider lookupProvider) {
        super(Set.of(), FeatureFlags.DEFAULT_FLAGS, lookupProvider);
    }


    @Override
    protected void generate() {

        this.dropSelf(ModBlocks.CHITIN_BLOCK.get());
        this.add(ModBlocks.CHITIN_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.CHITIN_SLAB.get()));
        this.dropSelf(ModBlocks.CHITIN_STAIRS.get());
        this.dropSelf(ModBlocks.CHITIN_WALL.get());
        this.dropSelf(ModBlocks.CHITIN_BRICKS.get());
        this.add(ModBlocks.CHITIN_BRICK_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.CHITIN_BRICK_SLAB.get()));
        this.dropSelf(ModBlocks.CHITIN_BRICK_STAIRS.get());
        this.dropSelf(ModBlocks.CHITIN_BRICK_WALL.get());
        this.dropSelf(ModBlocks.CHISELED_CHITIN_BRICKS.get());

        this.dropSelf(ModBlocks.SILVERFISH_TRAP.get());
        this.dropSelf(ModBlocks.SPIDER_TRAP.get());
        this.dropSelf(ModBlocks.SPINNERET.get());
        this.add(ModBlocks.COBWEB_TRAP.get(),
                block -> LootTable.lootTable());

    }


    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries()
                .stream().map(e -> (Block) e.value()).toList();
    }
}
