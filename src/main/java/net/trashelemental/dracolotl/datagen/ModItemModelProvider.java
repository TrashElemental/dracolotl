package net.trashelemental.dracolotl.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.trashelemental.dracolotl.dracolotl;
import net.trashelemental.dracolotl.item.ModItems;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, dracolotl.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {

        simpleItem(ModItems.BUCKET_OF_DRACOLOTL);
        SpawnEggItem("dracolotl");

    }


    private ItemModelBuilder simpleItem(DeferredItem<Item> item) {
        return getBuilder(item.getId().getPath())
                .parent(new ModelFile.UncheckedModelFile(mcLoc("item/generated")))
                .texture("layer0", modLoc("item/" + item.getId().getPath()));
    }

    public void evenSimplerBlockItem(DeferredBlock<Block> block) {
        ResourceLocation blockId = block.getId();
        withExistingParent(blockId.getPath(), modLoc("block/" + blockId.getPath()));
    }

    public void wallItem(DeferredBlock<Block> block, DeferredBlock<Block> baseBlock) {
        ResourceLocation blockId = block.getId();
        ResourceLocation baseBlockId = baseBlock.getId();

        withExistingParent(blockId.getPath(), mcLoc("block/wall_inventory"))
                .texture("wall", modLoc("block/" + baseBlockId.getPath()));
    }

    private void SpawnEggItem(String entityName) {
        withExistingParent(entityName + "_spawn_egg", "item/template_spawn_egg");
    }

}
