package net.trashelemental.infested.datagen.tags;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.trashelemental.infested.InfestedSwarmsAndSpiders;
import net.trashelemental.infested.block.ModBlocks;
import net.trashelemental.infested.util.ModTags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, InfestedSwarmsAndSpiders.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

        this.tag(ModTags.Blocks.INFESTED_BLOCKS)
                .add(Blocks.INFESTED_COBBLESTONE)
                .add(Blocks.INFESTED_CHISELED_STONE_BRICKS)
                .add(Blocks.INFESTED_DEEPSLATE)
                .add(Blocks.INFESTED_STONE)
                .add(Blocks.INFESTED_STONE_BRICKS)
                .add(Blocks.INFESTED_CRACKED_STONE_BRICKS)
                .add(Blocks.INFESTED_MOSSY_STONE_BRICKS);

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.CHITIN_BLOCK.get())
                .add(ModBlocks.CHITIN_BRICKS.get())
                .add(ModBlocks.SILVERFISH_TRAP.get())
                .add(ModBlocks.SPIDER_TRAP.get())
                .add(ModBlocks.SPINNERET.get());

        this.tag(BlockTags.WALLS)
                .add(ModBlocks.CHITIN_WALL.get())
                .add(ModBlocks.CHITIN_BRICK_WALL.get());


    }

}

