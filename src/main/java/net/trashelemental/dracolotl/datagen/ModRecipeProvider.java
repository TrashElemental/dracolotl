package net.trashelemental.dracolotl.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.trashelemental.dracolotl.Config;
import net.trashelemental.dracolotl.item.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider {

    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider);
    }

    @Override
    protected void buildRecipes(RecipeOutput output) {


        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.BUCKET_OF_DRACOLOTL.get())
                .pattern("cbc")
                .pattern("bab")
                .pattern("cbc")
                .define('a', Items.AXOLOTL_BUCKET)
                .define('b', Items.END_CRYSTAL)
                .define('c', Items.CHORUS_FLOWER)
                .unlockedBy("has_chorus_flower", has(Items.CHORUS_FLOWER))
                .save(output, ResourceLocation.fromNamespaceAndPath("dracolotl", "bucket_of_dracolotl"));


        
    }
}
