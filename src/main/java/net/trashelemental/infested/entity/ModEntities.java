package net.trashelemental.infested.entity;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.trashelemental.infested.InfestedSwarmsAndSpiders;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(Registries.ENTITY_TYPE, InfestedSwarmsAndSpiders.MOD_ID);









    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
