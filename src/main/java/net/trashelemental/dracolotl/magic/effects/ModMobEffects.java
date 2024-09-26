package net.trashelemental.dracolotl.magic.effects;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffect;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.trashelemental.dracolotl.dracolotl;

public class ModMobEffects {
    public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(Registries.MOB_EFFECT, dracolotl.MOD_ID);





    public static void register(IEventBus eventBus) {
        REGISTRY.register(eventBus);
    }
}
