package net.trashelemental.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.trashelemental.infested.block.ModBlocks;
import net.trashelemental.infested.item.ModItems;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {

    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {

//Items

        //Crafting Items
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.CHITIN.get(), 4)
                .requires(ModBlocks.CHITIN_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.CHITIN_BLOCK.get()), has(ModBlocks.CHITIN_BLOCK.get()))
                .save(pWriter, new ResourceLocation("infested", "chitin_from_chitin_block"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.CHITIN.get(), 9)
                .requires(ModBlocks.CHITIN_BRICKS.get())
                .unlockedBy(getHasName(ModBlocks.CHITIN_BRICKS.get()), has(ModBlocks.CHITIN_BRICKS.get()))
                .save(pWriter, new ResourceLocation("infested", "chitin_from_chitin_bricks"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.INSECT_TEMPLATE.get())
                .pattern("aba")
                .pattern("aca")
                .pattern("aaa")
                .define('a', ModItems.CHITIN.get())
                .define('b', ModItems.SILVERFISH_EGGS.get())
                .define('c', Items.INFESTED_STONE)
                .unlockedBy(getHasName(ModItems.SILVERFISH_EGGS.get()), has(ModItems.SILVERFISH_EGGS.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.SPIDER_TEMPLATE.get())
                .pattern("aba")
                .pattern("aca")
                .pattern("aaa")
                .define('a', Items.STRING)
                .define('b', ModItems.SPIDER_EGG.get())
                .define('c', Items.STONE)
                .unlockedBy(getHasName(ModItems.SPIDER_EGG.get()), has(ModItems.SPIDER_EGG.get()))
                .save(pWriter);


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
                .save(pWriter, new ResourceLocation("infested", "bug_stew_from_silverfish_eggs"));

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModItems.BUG_STEW.get())
                .pattern("abc")
                .pattern(" d ")
                .pattern("   ")
                .define('a', Items.CRIMSON_FUNGUS)
                .define('b', ModItems.FRIED_GRUB.get())
                .define('c', ModItems.SPIDER_EGG.get())
                .define('d', Items.BOWL)
                .unlockedBy(getHasName(ModItems.FRIED_GRUB.get()), has(ModItems.FRIED_GRUB.get()))
                .save(pWriter, new ResourceLocation("infested", "bug_stew_from_spider_egg"));

        SimpleCookingRecipeBuilder.smelting(
                        Ingredient.of(ModItems.RAW_GRUB.get()),
                        RecipeCategory.FOOD,
                        ModItems.FRIED_GRUB.get(),
                        0.35f,
                        200)
                .unlockedBy("has_raw_grub", has(ModItems.RAW_GRUB.get()))
                .save(pWriter, new ResourceLocation("infested", "fried_grub_smelting"));

        SimpleCookingRecipeBuilder.campfireCooking(
                        Ingredient.of(ModItems.RAW_GRUB.get()),
                        RecipeCategory.FOOD,
                        ModItems.FRIED_GRUB.get(),
                        0.35f,
                        600)
                .unlockedBy("has_raw_grub", has(ModItems.RAW_GRUB.get()))
                .save(pWriter, new ResourceLocation("infested", "fried_grub_campfire"));

        SimpleCookingRecipeBuilder.smoking(
                        Ingredient.of(ModItems.RAW_GRUB.get()),
                        RecipeCategory.FOOD,
                        ModItems.FRIED_GRUB.get(),
                        0.35f,
                        100)
                .unlockedBy("has_raw_grub", has(ModItems.RAW_GRUB.get()))
                .save(pWriter, new ResourceLocation("infested", "fried_grub_smoking"));



//Blocks

        //Building Blocks
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHITIN_BLOCK.get())
                .pattern("aa ")
                .pattern("aa ")
                .pattern("   ")
                .define('a', ModItems.CHITIN.get())
                .unlockedBy(getHasName(ModItems.CHITIN.get()), has(ModItems.CHITIN.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHITIN_BRICKS.get())
                .pattern("aaa")
                .pattern("aaa")
                .pattern("aaa")
                .define('a', ModItems.CHITIN.get())
                .unlockedBy(getHasName(ModItems.CHITIN.get()), has(ModItems.CHITIN.get()))
                .save(pWriter);


        //Functional Blocks
        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, ModBlocks.SILVERFISH_TRAP.get())
                .pattern("aba")
                .pattern("bab")
                .pattern("bcb")
                .define('a', ModItems.SILVERFISH_EGGS.get())
                .define('b', Items.COBBLESTONE)
                .define('c', Items.REDSTONE)
                .unlockedBy(getHasName(ModItems.SILVERFISH_EGGS.get()), has(ModItems.SILVERFISH_EGGS.get()))
                .save(pWriter);


//Added Recipes for Vanilla Items
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.COBWEB)
                .pattern("a a")
                .pattern(" b ")
                .pattern("a a")
                .define('a', Items.STRING)
                .define('b', ModItems.SPIDER_EGG.get())
                .unlockedBy(getHasName(ModItems.SPIDER_EGG.get()), has(ModItems.SPIDER_EGG.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.INFESTED_STONE)
                .pattern("ab ")
                .pattern("   ")
                .pattern("   ")
                .define('a', ModItems.SILVERFISH_EGGS.get())
                .define('b', Items.STONE)
                .unlockedBy(getHasName(ModItems.SILVERFISH_EGGS.get()), has(ModItems.SILVERFISH_EGGS.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.INFESTED_STONE_BRICKS)
                .pattern("ab ")
                .pattern("   ")
                .pattern("   ")
                .define('a', ModItems.SILVERFISH_EGGS.get())
                .define('b', Items.STONE_BRICKS)
                .unlockedBy(getHasName(ModItems.SILVERFISH_EGGS.get()), has(ModItems.SILVERFISH_EGGS.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.INFESTED_CHISELED_STONE_BRICKS)
                .pattern("ab ")
                .pattern("   ")
                .pattern("   ")
                .define('a', ModItems.SILVERFISH_EGGS.get())
                .define('b', Items.CHISELED_STONE_BRICKS)
                .unlockedBy(getHasName(ModItems.SILVERFISH_EGGS.get()), has(ModItems.SILVERFISH_EGGS.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.INFESTED_CRACKED_STONE_BRICKS)
                .pattern("ab ")
                .pattern("   ")
                .pattern("   ")
                .define('a', ModItems.SILVERFISH_EGGS.get())
                .define('b', Items.CRACKED_STONE_BRICKS)
                .unlockedBy(getHasName(ModItems.SILVERFISH_EGGS.get()), has(ModItems.SILVERFISH_EGGS.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.INFESTED_MOSSY_STONE_BRICKS)
                .pattern("ab ")
                .pattern("   ")
                .pattern("   ")
                .define('a', ModItems.SILVERFISH_EGGS.get())
                .define('b', Items.MOSSY_STONE_BRICKS)
                .unlockedBy(getHasName(ModItems.SILVERFISH_EGGS.get()), has(ModItems.SILVERFISH_EGGS.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.INFESTED_COBBLESTONE)
                .pattern("ab ")
                .pattern("   ")
                .pattern("   ")
                .define('a', ModItems.SILVERFISH_EGGS.get())
                .define('b', Items.COBBLESTONE)
                .unlockedBy(getHasName(ModItems.SILVERFISH_EGGS.get()), has(ModItems.SILVERFISH_EGGS.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.INFESTED_DEEPSLATE)
                .pattern("ab ")
                .pattern("   ")
                .pattern("   ")
                .define('a', ModItems.SILVERFISH_EGGS.get())
                .define('b', Items.DEEPSLATE)
                .unlockedBy(getHasName(ModItems.SILVERFISH_EGGS.get()), has(ModItems.SILVERFISH_EGGS.get()))
                .save(pWriter);


    }

}



