package net.trashelemental.infested.brewing;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.common.brewing.IBrewingRecipe;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.trashelemental.infested.item.ModItems;

@Mod.EventBusSubscriber(modid = "infested", bus = Mod.EventBusSubscriber.Bus.MOD)
public class ResistancePotionLongBrewingRecipe implements IBrewingRecipe {
    @SubscribeEvent
    public static void init(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> BrewingRecipeRegistry.addRecipe(new ResistancePotionLongBrewingRecipe()));
    }

    @Override
    public boolean isInput(ItemStack input) {
        Ingredient awkwardPotions = Ingredient.of(
                PotionUtils.setPotion(new ItemStack(Items.POTION), ModPotions.RESISTANCE_POTION.get()),
                PotionUtils.setPotion(new ItemStack(Items.SPLASH_POTION), ModPotions.RESISTANCE_POTION.get()),
                PotionUtils.setPotion(new ItemStack(Items.LINGERING_POTION), ModPotions.RESISTANCE_POTION.get())
        );
        return awkwardPotions.test(input);
    }

    @Override
    public boolean isIngredient(ItemStack ingredient) {
        return Ingredient.of(new ItemStack(Items.REDSTONE)).test(ingredient);
    }

    @Override
    public ItemStack getOutput(ItemStack input, ItemStack ingredient) {
        if (isInput(input) && isIngredient(ingredient)) {
            return PotionUtils.setPotion(new ItemStack(input.getItem()), ModPotions.RESISTANCE_POTION_LONG.get());
        }
        return ItemStack.EMPTY;
    }
}
