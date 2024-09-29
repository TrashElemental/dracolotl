package net.trashelemental.dracolotl.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.trashelemental.dracolotl.dracolotl;
import net.trashelemental.dracolotl.entity.custom.DracolotlEntity;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, dracolotl.MOD_ID);


    public static final RegistryObject<EntityType<DracolotlEntity>> DRACOLOTL =
            ENTITY_TYPES.register("dracolotl", () -> EntityType.Builder.of(DracolotlEntity::new, MobCategory.CREATURE)
                    .sized(0.75F, 1F).build("dracolotl"));



    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
