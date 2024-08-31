package net.trashelemental.infested.datagen;

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
import net.trashelemental.infested.InfestedSwarmsAndSpiders;
import net.trashelemental.infested.block.ModBlocks;
import net.trashelemental.infested.item.ModItems;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, InfestedSwarmsAndSpiders.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {

        simpleItem(ModItems.CHITIN);
        simpleItem(ModItems.INSECT_TEMPLATE);
        simpleItem(ModItems.SPIDER_TEMPLATE);

        simpleItem(ModItems.RAW_GRUB);
        simpleItem(ModItems.FRIED_GRUB);
        simpleItem(ModItems.BUG_STEW);

        simpleItem(ModItems.SILVERFISH_EGGS);
        simpleItem(ModItems.SPIDER_EGG);

        simpleItem(ModItems.CHITIN_HELMET);
        simpleItem(ModItems.CHITIN_CHESTPLATE);
        simpleItem(ModItems.CHITIN_LEGGINGS);
        simpleItem(ModItems.CHITIN_BOOTS);
        simpleItem(ModItems.SPIDER_HELMET);
        simpleItem(ModItems.SPIDER_CHESTPLATE);
        simpleItem(ModItems.SPIDER_LEGGINGS);
        simpleItem(ModItems.SPIDER_BOOTS);

        wallItem(ModBlocks.CHITIN_WALL, ModBlocks.CHITIN_BLOCK);
        wallItem(ModBlocks.CHITIN_BRICK_WALL, ModBlocks.CHITIN_BRICKS);
        evenSimplerBlockItem(ModBlocks.CHITIN_SLAB);
        evenSimplerBlockItem(ModBlocks.CHITIN_BRICK_SLAB);
        evenSimplerBlockItem(ModBlocks.CHITIN_STAIRS);
        evenSimplerBlockItem(ModBlocks.CHITIN_BRICK_STAIRS);

        withExistingParent(ModBlocks.COBWEB_TRAP.getId().getPath(),
                modLoc("item/cobweb_trap_item"));

       // withExistingParent(ModItems.CRIMSON_BEETLE_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
        //withExistingParent(ModItems.GRUB_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
       // withExistingParent(ModItems.BRILLIANT_BEETLE_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
       // withExistingParent(ModItems.MANTIS_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
        //withExistingParent(ModItems.ORCHID_MANTIS_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));

        //withExistingParent(ModItems.HARVEST_BEETLE_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
        //withExistingParent(ModItems.JEWEL_BEETLE_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
        //withExistingParent(ModItems.CHORUS_BEETLE_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
        //withExistingParent(ModItems.ANCIENT_DEBREETLE_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));



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

}
