package net.trashelemental.dracolotl.entity;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.trashelemental.dracolotl.dracolotl;
import net.trashelemental.dracolotl.entity.custom.DracolotlEntity;


public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(Registries.ENTITY_TYPE, dracolotl.MOD_ID);



    public static final DeferredHolder<EntityType<?>, EntityType<DracolotlEntity>> DRACOLOTL =
            ENTITY_TYPES.register("dracolotl", () -> EntityType.Builder.of(DracolotlEntity::new, MobCategory.CREATURE)
                    .sized(0.75F, 1F).build("dracolotl"));




    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
