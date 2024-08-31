package net.trashelemental.infested.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.trashelemental.infested.InfestedSwarmsAndSpiders;

public class ModTags {

    public static class Blocks {

        public static final TagKey<Block> INFESTED_BLOCKS = tag("infested_blocks");


        private static TagKey<Block> tag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(InfestedSwarmsAndSpiders.MOD_ID, name));
        }
    }


    public static class Items {


        private static TagKey<Item> tag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(InfestedSwarmsAndSpiders.MOD_ID, name));
        }
    }

}
