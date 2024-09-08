package net.trashelemental.infested.datagen.tags;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.trashelemental.infested.item.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModItemTagGenerator extends ItemTagsProvider {
    public ModItemTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> blockTags) {
        super(output, lookupProvider, blockTags);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

        this.tag(ItemTags.HEAD_ARMOR)
                .add(ModItems.CHITIN_HELMET.get())
                .add(ModItems.SPIDER_HELMET.get());

        this.tag(ItemTags.CHEST_ARMOR)
                .add(ModItems.CHITIN_CHESTPLATE.get())
                .add(ModItems.SPIDER_CHESTPLATE.get());

        this.tag(ItemTags.LEG_ARMOR)
                .add(ModItems.CHITIN_LEGGINGS.get())
                .add(ModItems.SPIDER_LEGGINGS.get());

        this.tag(ItemTags.FOOT_ARMOR)
                .add(ModItems.CHITIN_BOOTS.get())
                .add(ModItems.SPIDER_BOOTS.get());

    }
}
