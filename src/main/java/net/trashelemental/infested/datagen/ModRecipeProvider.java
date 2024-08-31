package net.trashelemental.infested.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.brewing.BrewingRecipe;
import net.trashelemental.infested.block.ModBlocks;
import net.trashelemental.infested.item.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider {

    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider);
    }

    @Override
    protected void buildRecipes(RecipeOutput output) {

        //Items

        //Crafting Items
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.CHITIN.get(), 4)
                .requires(ModBlocks.CHITIN_BLOCK.get())
                .unlockedBy("has_chitin_block", has(ModBlocks.CHITIN_BLOCK.get()))
                .save(output, ResourceLocation.fromNamespaceAndPath("infested_swarms_spiders", "chitin_from_chitin_block"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.CHITIN.get(), 9)
                .requires(ModBlocks.CHITIN_BRICKS.get())
                .unlockedBy("has_chitin_bricks", has(ModBlocks.CHITIN_BRICKS.get()))
                .save(output, ResourceLocation.fromNamespaceAndPath("infested_swarms_spiders", "chitin_from_chitin_bricks"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.INSECT_TEMPLATE.get())
                .pattern("aba")
                .pattern("aca")
                .pattern("aaa")
                .define('a', ModItems.CHITIN.get())
                .define('b', ModItems.SILVERFISH_EGGS.get())
                .define('c', Items.INFESTED_STONE)
                .unlockedBy("has_silverfish_eggs", has(ModItems.SILVERFISH_EGGS.get()))
                .save(output, ResourceLocation.fromNamespaceAndPath("infested_swarms_spiders", "insect_template"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.SPIDER_TEMPLATE.get())
                .pattern("aba")
                .pattern("aca")
                .pattern("aaa")
                .define('a', Items.STRING)
                .define('b', ModItems.SPIDER_EGG.get())
                .define('c', Items.STONE)
                .unlockedBy(getHasName(ModItems.SPIDER_EGG.get()), has(ModItems.SPIDER_EGG.get()))
                .save(output, ResourceLocation.fromNamespaceAndPath("infested_swarms_spiders", "spider_template"));


        //Food Items
        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModItems.BUG_STEW.get())
                .pattern("abc")
                .pattern(" d ")
                .pattern("   ")
                .define('a', Items.CRIMSON_FUNGUS)
                .define('b', ModItems.FRIED_GRUB.get())
                .define('c', ModItems.SILVERFISH_EGGS.get())
                .define('d', Items.BOWL)
                .unlockedBy(getHasName(ModItems.FRIED_GRUB.get()), has(ModItems.FRIED_GRUB.get()))
                .save(output, ResourceLocation.fromNamespaceAndPath("infested_swarms_spiders", "bug_stew_with_silverfish_eggs"));

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModItems.BUG_STEW.get())
                .pattern("abc")
                .pattern(" d ")
                .pattern("   ")
                .define('a', Items.CRIMSON_FUNGUS)
                .define('b', ModItems.FRIED_GRUB.get())
                .define('c', ModItems.SPIDER_EGG.get())
                .define('d', Items.BOWL)
                .unlockedBy(getHasName(ModItems.FRIED_GRUB.get()), has(ModItems.FRIED_GRUB.get()))
                .save(output, ResourceLocation.fromNamespaceAndPath("infested_swarms_spiders", "bug_stew_with_spider_egg"));

        SimpleCookingRecipeBuilder.smelting(
                        Ingredient.of(ModItems.RAW_GRUB.get()),
                        RecipeCategory.FOOD,
                        ModItems.FRIED_GRUB.get(),
                        0.35f,
                        200)
                .unlockedBy("has_raw_grub", has(ModItems.RAW_GRUB.get()))
                .save(output, ResourceLocation.fromNamespaceAndPath("infested_swarms_spiders", "fried_grub_smelting"));

        SimpleCookingRecipeBuilder.campfireCooking(
                        Ingredient.of(ModItems.RAW_GRUB.get()),
                        RecipeCategory.FOOD,
                        ModItems.FRIED_GRUB.get(),
                        0.35f,
                        600)
                .unlockedBy("has_raw_grub", has(ModItems.RAW_GRUB.get()))
                .save(output, ResourceLocation.fromNamespaceAndPath("infested_swarms_spiders", "fried_grub_campfire_cooking"));

        SimpleCookingRecipeBuilder.smoking(
                        Ingredient.of(ModItems.RAW_GRUB.get()),
                        RecipeCategory.FOOD,
                        ModItems.FRIED_GRUB.get(),
                        0.35f,
                        100)
                .unlockedBy("has_raw_grub", has(ModItems.RAW_GRUB.get()))
                .save(output, ResourceLocation.fromNamespaceAndPath("infested_swarms_spiders", "fried_grub_smoking"));


        //Armor Items

        //Chitin Set
        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ModItems.INSECT_TEMPLATE.get()),
                        Ingredient.of(Items.LEATHER_HELMET),
                        Ingredient.of(ModItems.CHITIN.get()),
                        RecipeCategory.MISC,
                        ModItems.CHITIN_HELMET.get()
                )
                .unlocks("has_insect_template", has(ModItems.INSECT_TEMPLATE.get()))
                .save(output, ResourceLocation.fromNamespaceAndPath("infested_swarms_spiders", "chitin_helmet"));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ModItems.INSECT_TEMPLATE.get()),
                        Ingredient.of(Items.LEATHER_CHESTPLATE),
                        Ingredient.of(ModItems.CHITIN.get()),
                        RecipeCategory.MISC,
                        ModItems.CHITIN_CHESTPLATE.get()
                )
                .unlocks("has_insect_template", has(ModItems.INSECT_TEMPLATE.get()))
                .save(output, ResourceLocation.fromNamespaceAndPath("infested_swarms_spiders", "chitin_chestplate"));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ModItems.INSECT_TEMPLATE.get()),
                        Ingredient.of(Items.LEATHER_LEGGINGS),
                        Ingredient.of(ModItems.CHITIN.get()),
                        RecipeCategory.MISC,
                        ModItems.CHITIN_LEGGINGS.get()
                )
                .unlocks("has_insect_template", has(ModItems.INSECT_TEMPLATE.get()))
                .save(output, ResourceLocation.fromNamespaceAndPath("infested_swarms_spiders", "chitin_leggings"));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ModItems.INSECT_TEMPLATE.get()),
                        Ingredient.of(Items.LEATHER_BOOTS),
                        Ingredient.of(ModItems.CHITIN.get()),
                        RecipeCategory.MISC,
                        ModItems.CHITIN_BOOTS.get()
                )
                .unlocks("has_insect_template", has(ModItems.INSECT_TEMPLATE.get()))
                .save(output, ResourceLocation.fromNamespaceAndPath("infested_swarms_spiders", "chitin_boots"));

        //Spider Set
        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ModItems.SPIDER_TEMPLATE.get()),
                        Ingredient.of(Items.LEATHER_HELMET),
                        Ingredient.of(Items.COBWEB),
                        RecipeCategory.MISC,
                        ModItems.SPIDER_HELMET.get()
                )
                .unlocks("has_spider_template", has(ModItems.SPIDER_TEMPLATE.get()))
                .save(output, ResourceLocation.fromNamespaceAndPath("infested_swarms_spiders", "spider_helmet"));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ModItems.SPIDER_TEMPLATE.get()),
                        Ingredient.of(Items.LEATHER_CHESTPLATE),
                        Ingredient.of(Items.COBWEB),
                        RecipeCategory.MISC,
                        ModItems.SPIDER_CHESTPLATE.get()
                )
                .unlocks("has_spider_template", has(ModItems.SPIDER_TEMPLATE.get()))
                .save(output, ResourceLocation.fromNamespaceAndPath("infested_swarms_spiders", "spider_chestplate"));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ModItems.SPIDER_TEMPLATE.get()),
                        Ingredient.of(Items.LEATHER_LEGGINGS),
                        Ingredient.of(Items.COBWEB),
                        RecipeCategory.MISC,
                        ModItems.SPIDER_LEGGINGS.get()
                )
                .unlocks("has_spider_template", has(ModItems.SPIDER_TEMPLATE.get()))
                .save(output, ResourceLocation.fromNamespaceAndPath("infested_swarms_spiders", "spider_leggings"));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ModItems.SPIDER_TEMPLATE.get()),
                        Ingredient.of(Items.LEATHER_BOOTS),
                        Ingredient.of(Items.COBWEB),
                        RecipeCategory.MISC,
                        ModItems.SPIDER_BOOTS.get()
                )
                .unlocks("has_spider_template", has(ModItems.SPIDER_TEMPLATE.get()))
                .save(output, ResourceLocation.fromNamespaceAndPath("infested_swarms_spiders", "spider_boots"));




        //Blocks

        //Building Blocks
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHITIN_BLOCK.get())
                .pattern("aa ")
                .pattern("aa ")
                .pattern("   ")
                .define('a', ModItems.CHITIN.get())
                .unlockedBy(getHasName(ModItems.CHITIN.get()), has(ModItems.CHITIN.get()))
                .save(output, ResourceLocation.fromNamespaceAndPath("infested_swarms_spiders", "chitin_block"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHITIN_SLAB.get())
                .pattern("   ")
                .pattern("aaa")
                .pattern("   ")
                .define('a', ModBlocks.CHITIN_BLOCK.get())
                .unlockedBy(getHasName(ModItems.CHITIN.get()), has(ModItems.CHITIN.get()))
                .save(output, ResourceLocation.fromNamespaceAndPath("infested_swarms_spiders", "chitin_slab"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHITIN_STAIRS.get())
                .pattern("a  ")
                .pattern("aa ")
                .pattern("aaa")
                .define('a', ModBlocks.CHITIN_BLOCK.get())
                .unlockedBy(getHasName(ModItems.CHITIN.get()), has(ModItems.CHITIN.get()))
                .save(output, ResourceLocation.fromNamespaceAndPath("infested_swarms_spiders", "chitin_stairs"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHITIN_WALL.get())
                .pattern("   ")
                .pattern("aaa")
                .pattern("aaa")
                .define('a', ModBlocks.CHITIN_BLOCK.get())
                .unlockedBy(getHasName(ModItems.CHITIN.get()), has(ModItems.CHITIN.get()))
                .save(output, ResourceLocation.fromNamespaceAndPath("infested_swarms_spiders", "chitin_wall"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHITIN_BRICKS.get())
                .pattern("aaa")
                .pattern("aaa")
                .pattern("aaa")
                .define('a', ModItems.CHITIN.get())
                .unlockedBy(getHasName(ModItems.CHITIN.get()), has(ModItems.CHITIN.get()))
                .save(output, ResourceLocation.fromNamespaceAndPath("infested_swarms_spiders", "chitin_bricks"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHITIN_BRICK_SLAB.get())
                .pattern("   ")
                .pattern("aaa")
                .pattern("   ")
                .define('a', ModBlocks.CHITIN_BRICKS.get())
                .unlockedBy(getHasName(ModItems.CHITIN.get()), has(ModItems.CHITIN.get()))
                .save(output, ResourceLocation.fromNamespaceAndPath("infested_swarms_spiders", "chitin_brick_slab"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHITIN_BRICK_STAIRS.get())
                .pattern("a  ")
                .pattern("aa ")
                .pattern("aaa")
                .define('a', ModBlocks.CHITIN_BRICKS.get())
                .unlockedBy(getHasName(ModItems.CHITIN.get()), has(ModItems.CHITIN.get()))
                .save(output, ResourceLocation.fromNamespaceAndPath("infested_swarms_spiders", "chitin_brick_stairs"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHITIN_BRICK_WALL.get())
                .pattern("   ")
                .pattern("aaa")
                .pattern("aaa")
                .define('a', ModBlocks.CHITIN_BRICKS.get())
                .unlockedBy(getHasName(ModItems.CHITIN.get()), has(ModItems.CHITIN.get()))
                .save(output, ResourceLocation.fromNamespaceAndPath("infested_swarms_spiders", "chitin_brick_wall"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_CHITIN_BRICKS.get())
                .pattern("   ")
                .pattern(" a ")
                .pattern(" a ")
                .define('a', ModBlocks.CHITIN_BRICK_SLAB.get())
                .unlockedBy(getHasName(ModItems.CHITIN.get()), has(ModItems.CHITIN.get()))
                .save(output, ResourceLocation.fromNamespaceAndPath("infested_swarms_spiders", "chiseled_chitin_bricks"));


        //Functional Blocks
        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, ModBlocks.SILVERFISH_TRAP.get())
                .pattern("aba")
                .pattern("bab")
                .pattern("bcb")
                .define('a', ModItems.SILVERFISH_EGGS.get())
                .define('b', Items.COBBLESTONE)
                .define('c', Items.REDSTONE)
                .unlockedBy(getHasName(ModItems.SILVERFISH_EGGS.get()), has(ModItems.SILVERFISH_EGGS.get()))
                .save(output, ResourceLocation.fromNamespaceAndPath("infested_swarms_spiders", "silverfish_trap"));

        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, ModBlocks.SPIDER_TRAP.get())
                .pattern("aba")
                .pattern("bab")
                .pattern("bcb")
                .define('a', ModItems.SPIDER_EGG.get())
                .define('b', Items.COBBLESTONE)
                .define('c', Items.REDSTONE)
                .unlockedBy(getHasName(ModItems.SPIDER_EGG.get()), has(ModItems.SPIDER_EGG.get()))
                .save(output, ResourceLocation.fromNamespaceAndPath("infested_swarms_spiders", "spider_trap"));

        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, ModBlocks.SPINNERET.get())
                .pattern("dbd")
                .pattern("bab")
                .pattern("bcb")
                .define('a', ModItems.SPIDER_EGG.get())
                .define('b', Items.COBBLESTONE)
                .define('c', Items.REDSTONE)
                .define('d', Items.STRING)
                .unlockedBy(getHasName(ModItems.SPIDER_EGG.get()), has(ModItems.SPIDER_EGG.get()))
                .save(output, ResourceLocation.fromNamespaceAndPath("infested_swarms_spiders", "spinneret"));


//Added Recipes for Vanilla Items
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.COBWEB)
                .pattern("a a")
                .pattern(" b ")
                .pattern("a a")
                .define('a', Items.STRING)
                .define('b', ModItems.SPIDER_EGG.get())
                .unlockedBy(getHasName(ModItems.SPIDER_EGG.get()), has(ModItems.SPIDER_EGG.get()))
                .save(output, ResourceLocation.fromNamespaceAndPath("infested_swarms_spiders", "cobweb_from_spider_egg"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.INFESTED_STONE)
                .pattern("ab ")
                .pattern("   ")
                .pattern("   ")
                .define('a', ModItems.SILVERFISH_EGGS.get())
                .define('b', Items.STONE)
                .unlockedBy(getHasName(ModItems.SILVERFISH_EGGS.get()), has(ModItems.SILVERFISH_EGGS.get()))
                .save(output, ResourceLocation.fromNamespaceAndPath("infested_swarms_spiders", "infested_stone_from_silverfish_eggs"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.INFESTED_STONE_BRICKS)
                .pattern("ab ")
                .pattern("   ")
                .pattern("   ")
                .define('a', ModItems.SILVERFISH_EGGS.get())
                .define('b', Items.STONE_BRICKS)
                .unlockedBy(getHasName(ModItems.SILVERFISH_EGGS.get()), has(ModItems.SILVERFISH_EGGS.get()))
                .save(output, ResourceLocation.fromNamespaceAndPath("infested_swarms_spiders", "infested_stone_bricks_from_silverfish_eggs"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.INFESTED_CHISELED_STONE_BRICKS)
                .pattern("ab ")
                .pattern("   ")
                .pattern("   ")
                .define('a', ModItems.SILVERFISH_EGGS.get())
                .define('b', Items.CHISELED_STONE_BRICKS)
                .unlockedBy(getHasName(ModItems.SILVERFISH_EGGS.get()), has(ModItems.SILVERFISH_EGGS.get()))
                .save(output, ResourceLocation.fromNamespaceAndPath("infested_swarms_spiders", "infested_chiseled_stone_bricks_from_silverfish_eggs"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.INFESTED_CRACKED_STONE_BRICKS)
                .pattern("ab ")
                .pattern("   ")
                .pattern("   ")
                .define('a', ModItems.SILVERFISH_EGGS.get())
                .define('b', Items.CRACKED_STONE_BRICKS)
                .unlockedBy(getHasName(ModItems.SILVERFISH_EGGS.get()), has(ModItems.SILVERFISH_EGGS.get()))
                .save(output, ResourceLocation.fromNamespaceAndPath("infested_swarms_spiders", "infested_cracked_stone_bricks_from_silverfish_eggs"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.INFESTED_MOSSY_STONE_BRICKS)
                .pattern("ab ")
                .pattern("   ")
                .pattern("   ")
                .define('a', ModItems.SILVERFISH_EGGS.get())
                .define('b', Items.MOSSY_STONE_BRICKS)
                .unlockedBy(getHasName(ModItems.SILVERFISH_EGGS.get()), has(ModItems.SILVERFISH_EGGS.get()))
                .save(output, ResourceLocation.fromNamespaceAndPath("infested_swarms_spiders", "infested_mossy_stone_bricks_from_silverfish_eggs"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.INFESTED_COBBLESTONE)
                .pattern("ab ")
                .pattern("   ")
                .pattern("   ")
                .define('a', ModItems.SILVERFISH_EGGS.get())
                .define('b', Items.COBBLESTONE)
                .unlockedBy(getHasName(ModItems.SILVERFISH_EGGS.get()), has(ModItems.SILVERFISH_EGGS.get()))
                .save(output, ResourceLocation.fromNamespaceAndPath("infested_swarms_spiders", "infested_cobblestone_from_silverfish_eggs"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.INFESTED_DEEPSLATE)
                .pattern("ab ")
                .pattern("   ")
                .pattern("   ")
                .define('a', ModItems.SILVERFISH_EGGS.get())
                .define('b', Items.DEEPSLATE)
                .unlockedBy(getHasName(ModItems.SILVERFISH_EGGS.get()), has(ModItems.SILVERFISH_EGGS.get()))
                .save(output, ResourceLocation.fromNamespaceAndPath("infested_swarms_spiders", "infested_deepslate_from_silverfish_eggs"));
    }
}
