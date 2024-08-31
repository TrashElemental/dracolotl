package net.trashelemental.infested.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.trashelemental.infested.InfestedSwarmsAndSpiders;
import net.trashelemental.infested.block.ModBlocks;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, InfestedSwarmsAndSpiders.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {

        BlockWithItem(ModBlocks.CHITIN_BLOCK);
        slabBlock(((SlabBlock) ModBlocks.CHITIN_SLAB.get()), blockTexture(ModBlocks.CHITIN_BLOCK.get()), blockTexture(ModBlocks.CHITIN_BLOCK.get()));
        stairsBlock(((StairBlock) ModBlocks.CHITIN_STAIRS.get()), blockTexture(ModBlocks.CHITIN_BLOCK.get()));
        wallBlock(((WallBlock) ModBlocks.CHITIN_WALL.get()), blockTexture(ModBlocks.CHITIN_BLOCK.get()));
        BlockWithItem(ModBlocks.CHITIN_BRICKS);
        slabBlock(((SlabBlock) ModBlocks.CHITIN_BRICK_SLAB.get()), blockTexture(ModBlocks.CHITIN_BRICKS.get()), blockTexture(ModBlocks.CHITIN_BRICKS.get()));
        stairsBlock(((StairBlock) ModBlocks.CHITIN_BRICK_STAIRS.get()), blockTexture(ModBlocks.CHITIN_BRICKS.get()));
        wallBlock(((WallBlock) ModBlocks.CHITIN_BRICK_WALL.get()), blockTexture(ModBlocks.CHITIN_BRICKS.get()));

        axisBlock(
                (RotatedPillarBlock) ModBlocks.CHISELED_CHITIN_BRICKS.get(),
                modLoc("block/chiseled_chitin_bricks"),       //Sides
                modLoc("block/chiseled_chitin_bricks_top")    //Top and bottom
        );

        blockItem(ModBlocks.CHISELED_CHITIN_BRICKS);

        BlockWithItem(ModBlocks.SILVERFISH_TRAP);
        BlockWithItem(ModBlocks.SPIDER_TRAP);

        simpleBlock(ModBlocks.COBWEB_TRAP.get(),
                new ModelFile.UncheckedModelFile(modLoc("block/cobweb_trap")));

    }

    private void blockItem(DeferredBlock<Block> blockRegistryObject) {
        ResourceLocation blockId = blockRegistryObject.getId();
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile(modLoc("block/" + blockId.getPath())));
    }

    private void BlockWithItem(DeferredBlock<Block> blockRegistryObject) {
        ResourceLocation blockId = blockRegistryObject.getId();
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
