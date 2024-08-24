package net.trashelemental.infested.magic.effects;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffect;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.trashelemental.infested.InfestedSwarmsAndSpiders;
import net.trashelemental.infested.magic.effects.custom.AmbushCooldownMobEffect;
import net.trashelemental.infested.magic.effects.custom.AmbushMobEffect;
import net.trashelemental.infested.magic.effects.custom.ParasiticInfectionMobEffect;

public class ModMobEffects {
    public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(Registries.MOB_EFFECT, InfestedSwarmsAndSpiders.MOD_ID);


    public static final DeferredHolder<MobEffect, MobEffect> AMBUSH = REGISTRY.register("ambush", AmbushMobEffect::new);
    public static final DeferredHolder<MobEffect, MobEffect> AMBUSH_COOLDOWN = REGISTRY.register("ambush_cooldown", AmbushCooldownMobEffect::new);
    public static final DeferredHolder<MobEffect, MobEffect> PARASITIC_INFECTION = REGISTRY.register("parasitic_infection", ParasiticInfectionMobEffect::new);


    public static void register(IEventBus eventBus) {
        REGISTRY.register(eventBus);
    }
}
