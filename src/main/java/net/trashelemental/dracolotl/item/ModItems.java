package net.trashelemental.dracolotl.item;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.trashelemental.dracolotl.dracolotl;
import net.trashelemental.dracolotl.entity.ModEntities;
import net.trashelemental.dracolotl.item.custom.DracolotlBucketItem;

import java.util.function.Supplier;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(dracolotl.MOD_ID);


    public static final DeferredItem<Item> BUCKET_OF_DRACOLOTL = ITEMS.register("bucket_of_dracolotl",
            () -> new DracolotlBucketItem(ModEntities.DRACOLOTL.get(), SoundEvents.BUCKET_EMPTY_AXOLOTL, new Item.Properties().stacksTo(1)));

    public static final Supplier<DeferredSpawnEggItem> DRACOLOTL_SPAWN_EGG = ITEMS.register("dracolotl_spawn_egg",
            () -> new DeferredSpawnEggItem(ModEntities.DRACOLOTL, -13948117, -3506983, new Item.Properties()));




    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
