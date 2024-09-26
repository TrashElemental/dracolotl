package net.trashelemental.dracolotl.compat.JEI;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.trashelemental.dracolotl.dracolotl;
import net.trashelemental.dracolotl.item.ModItems;

import java.util.List;

@JeiPlugin
public class JEIDracolotlPlugin implements IModPlugin {
    @Override
    public ResourceLocation getPluginUid() {
        return ResourceLocation.fromNamespaceAndPath(dracolotl.MOD_ID, "jei_plugin");
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {


        registration.addIngredientInfo(List.of(
                        new ItemStack(ModItems.BUCKET_OF_DRACOLOTL.get()),
                        new ItemStack(ModItems.DRACOLOTL_SPAWN_EGG.get())),
                VanillaTypes.ITEM_STACK, Component.translatable("jei.dracolotl.dracolotl_info"));


    }

}
