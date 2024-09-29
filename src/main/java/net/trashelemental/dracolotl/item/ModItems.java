package net.trashelemental.dracolotl.item;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.trashelemental.dracolotl.dracolotl;
import net.trashelemental.dracolotl.entity.ModEntities;
import net.trashelemental.dracolotl.item.custom.DracolotlBucketItem;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, dracolotl.MOD_ID);


    public static final RegistryObject<Item> BUCKET_OF_DRACOLOTL = ITEMS.register("bucket_of_dracolotl",
            () -> new DracolotlBucketItem(() -> ModEntities.DRACOLOTL.get(),() -> SoundEvents.BUCKET_EMPTY_AXOLOTL, new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> DRACOLOTL_SPAWN_EGG = ITEMS.register("dracolotl_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.DRACOLOTL, -13948117, -3506983, new Item.Properties()));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
