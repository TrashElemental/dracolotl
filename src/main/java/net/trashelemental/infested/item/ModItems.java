package net.trashelemental.infested.item;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.trashelemental.infested.InfestedSwarmsAndSpiders;
import net.trashelemental.infested.item.armor.custom.ChitinArmorItem;
import net.trashelemental.infested.item.armor.custom.SpiderArmorItem;
import net.trashelemental.infested.item.custom.BugStewItem;
import net.trashelemental.infested.item.custom.SilverfishEggsItem;
import net.trashelemental.infested.item.custom.SpiderEggItem;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(InfestedSwarmsAndSpiders.MOD_ID);


    //Crafting Items
    public static final DeferredItem<Item> CHITIN = ITEMS.register("chitin",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> INSECT_TEMPLATE = ITEMS.register("insect_template",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> SPIDER_TEMPLATE = ITEMS.register("spider_template",
            () -> new Item(new Item.Properties()));


    //Food Items
    public static final DeferredItem<Item> RAW_GRUB = ITEMS.register("raw_grub",
            () -> new Item(new Item.Properties().food(ModFoods.RAW_GRUB)));

    public static final DeferredItem<Item> FRIED_GRUB = ITEMS.register("fried_grub",
            () -> new Item(new Item.Properties().food(ModFoods.FRIED_GRUB)));

    public static final DeferredItem<Item> BUG_STEW = ITEMS.register("bug_stew",
            () -> new BugStewItem(new Item.Properties().food(ModFoods.BUG_STEW)));


    //Functional Items
    public static final DeferredItem<Item> SILVERFISH_EGGS = ITEMS.register("silverfish_eggs",
            () -> new SilverfishEggsItem(new Item.Properties()));

    public static final DeferredItem<Item> SPIDER_EGG = ITEMS.register("spider_egg",
            () -> new SpiderEggItem(new Item.Properties()));


    //Armor Items
    public static final DeferredItem<Item> CHITIN_HELMET = ITEMS.register("chitin_helmet",
            () -> new ChitinArmorItem(new Item.Properties()));
         //   ChitinArmorItem.Helmet::new);
    public static final DeferredItem<Item> CHITIN_CHESTPLATE = ITEMS.register("chitin_chestplate",
                 () -> new ChitinArmorItem(new Item.Properties()));
           // ChitinArmorItem.Chestplate::new);
    public static final DeferredItem<Item> CHITIN_LEGGINGS = ITEMS.register("chitin_leggings",
                   () -> new ChitinArmorItem(new Item.Properties()));
            // ChitinArmorItem.Leggings::new);
    public static final DeferredItem<Item> CHITIN_BOOTS = ITEMS.register("chitin_boots",
                    () -> new ChitinArmorItem(new Item.Properties()));
            // ChitinArmorItem.Boots::new);

    public static final DeferredItem<Item> SPIDER_HELMET = ITEMS.register("spider_helmet",
            () -> new SpiderArmorItem(new Item.Properties()));
    public static final DeferredItem<Item> SPIDER_CHESTPLATE = ITEMS.register("spider_chestplate",
            () -> new SpiderArmorItem(new Item.Properties()));
    public static final DeferredItem<Item> SPIDER_LEGGINGS = ITEMS.register("spider_leggings",
            () -> new SpiderArmorItem(new Item.Properties()));
    public static final DeferredItem<Item> SPIDER_BOOTS = ITEMS.register("spider_boots",
            () -> new SpiderArmorItem(new Item.Properties()));


    //Spawn Eggs
    //public static final DeferredItem<Item> CRIMSON_BEETLE_SPAWN_EGG = ITEMS.register("crimson_beetle_spawn_egg",
    //        () -> new ForgeSpawnEggItem(ModEntities.CRIMSON_BEETLE, -7271926, -14415607, new Item.Properties()));
   // public static final RegistryObject<Item> GRUB_SPAWN_EGG = ITEMS.register("grub_spawn_egg",
   //         () -> new ForgeSpawnEggItem(ModEntities.GRUB, -3361401, -7720655, new Item.Properties()));
   // public static final RegistryObject<Item> BRILLIANT_BEETLE_SPAWN_EGG = ITEMS.register("brilliant_beetle_spawn_egg",
    //        () -> new ForgeSpawnEggItem(ModEntities.BRILLIANT_BEETLE, -12109477, -16723242, new Item.Properties()));
    //public static final RegistryObject<Item> MANTIS_SPAWN_EGG = ITEMS.register("mantis_spawn_egg",
    //        () -> new ForgeSpawnEggItem(ModEntities.MANTIS, -16751104, -13382656, new Item.Properties()));
   // public static final RegistryObject<Item> ORCHID_MANTIS_SPAWN_EGG = ITEMS.register("orchid_mantis_spawn_egg",
    //        () -> new ForgeSpawnEggItem(ModEntities.ORCHID_MANTIS, -1270065, -6666, new Item.Properties()));

   // public static final RegistryObject<Item> HARVEST_BEETLE_SPAWN_EGG = ITEMS.register("harvest_beetle_spawn_egg",
    //        () -> new ForgeSpawnEggItem(ModEntities.HARVEST_BEETLE, -13408768, -6684826, new Item.Properties()));
   // public static final RegistryObject<Item> JEWEL_BEETLE_SPAWN_EGG = ITEMS.register("jewel_beetle_spawn_egg",
   //         () -> new ForgeSpawnEggItem(ModEntities.JEWEL_BEETLE, -6711040, -103, new Item.Properties()));
   // public static final RegistryObject<Item> CHORUS_BEETLE_SPAWN_EGG = ITEMS.register("chorus_beetle_spawn_egg",
   //         () -> new ForgeSpawnEggItem(ModEntities.CHORUS_BEETLE, -6983240, -13057, new Item.Properties()));
   // public static final RegistryObject<Item> ANCIENT_DEBREETLE_SPAWN_EGG = ITEMS.register("ancient_debreetle_spawn_egg",
    //        () -> new ForgeSpawnEggItem(ModEntities.ANCIENT_DEBREETLE, -12308191, -8705266, new Item.Properties()));



    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
