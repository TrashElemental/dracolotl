package net.trashelemental.infested.magic.brewing;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionBrewing;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.brewing.RegisterBrewingRecipesEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.trashelemental.infested.InfestedSwarmsAndSpiders;
import net.trashelemental.infested.item.ModItems;

@EventBusSubscriber
public class ModAlchemy {
    public static final DeferredRegister<Potion> REGISTRY = DeferredRegister.create(Registries.POTION, InfestedSwarmsAndSpiders.MOD_ID);



    public static final DeferredHolder<Potion, Potion> RESISTANCE_POTION = REGISTRY.register("resistance_potion", () ->
            new Potion(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 900, 0, false, true)));

    public static final DeferredHolder<Potion, Potion> RESISTANCE_POTION_LONG = REGISTRY.register("resistance_potion_long", () ->
            new Potion(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 1800, 0, false, true)));

    public static final DeferredHolder<Potion, Potion> RESISTANCE_POTION_STRONG = REGISTRY.register("resistance_potion_strong", () ->
            new Potion(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 440, 1, false, true)));



    public static void register(IEventBus eventBus) {
        REGISTRY.register(eventBus);
    }


    @SubscribeEvent
    public static void registerBrewingRecipes(RegisterBrewingRecipesEvent event) {


        //Potions
        PotionBrewing.Builder ResistancePotion = event.getBuilder();
        ResistancePotion.addMix(
                Potions.AWKWARD,            //Item in the bottom slot
                ModItems.CHITIN.get(),      //Item in the top slot / Ingredient
                RESISTANCE_POTION           //Result
        );

        PotionBrewing.Builder ResistancePotionLong = event.getBuilder();
        ResistancePotionLong.addMix(
                RESISTANCE_POTION,
                Items.REDSTONE,
                RESISTANCE_POTION_LONG
        );

        PotionBrewing.Builder ResistancePotionStrong = event.getBuilder();
        ResistancePotionStrong.addMix(
                RESISTANCE_POTION,
                Items.GLOWSTONE_DUST,
                RESISTANCE_POTION_STRONG
        );


        //Non-Potions
        PotionBrewing.Builder SilverfishEggs = event.getBuilder();
        SilverfishEggs.addRecipe(
                Ingredient.of(Items.EGG),
                Ingredient.of(ModItems.CHITIN.get()),
                ModItems.SILVERFISH_EGGS.toStack()
        );

        PotionBrewing.Builder SpiderEgg = event.getBuilder();
        SpiderEgg.addRecipe(
                Ingredient.of(Items.EGG),
                Ingredient.of(Items.FERMENTED_SPIDER_EYE),
                ModItems.SPIDER_EGG.toStack()
        );





    }
}
