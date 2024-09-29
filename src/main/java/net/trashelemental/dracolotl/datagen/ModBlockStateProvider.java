package net.trashelemental.dracolotl.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.trashelemental.dracolotl.dracolotl;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, dracolotl.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {



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
