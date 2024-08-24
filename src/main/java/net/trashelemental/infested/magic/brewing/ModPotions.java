package net.trashelemental.infested.magic.brewing;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.alchemy.Potion;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.trashelemental.infested.InfestedSwarmsAndSpiders;

public class ModPotions {
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
}
