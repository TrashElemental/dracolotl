package net.trashelemental.infested.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.trashelemental.infested.InfestedSwarmsAndSpiders;
import net.trashelemental.infested.block.ModBlocks;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, InfestedSwarmsAndSpiders.MOD_ID);

    public static final Supplier<CreativeModeTab> INFESTED_TAB = CREATIVE_MODE_TAB.register("infested_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.INSECT_TEMPLATE.get()))
                    .title(Component.translatable("creativetab.infested_swarms_spiders.infested"))
                    .displayItems(((itemDisplayParameters, output) -> {

                        output.accept(ModItems.CHITIN.get());
                        output.accept(ModItems.RAW_GRUB.get());
                        output.accept(ModItems.FRIED_GRUB.get());
                        output.accept(ModItems.BUG_STEW.get());
                        output.accept(ModItems.SILVERFISH_EGGS.get());
                        output.accept(ModItems.SPIDER_EGG.get());

                        output.accept(ModItems.INSECT_TEMPLATE.get());
                        output.accept(ModItems.CHITIN_HELMET.get());
                        output.accept(ModItems.CHITIN_CHESTPLATE.get());
                        output.accept(ModItems.CHITIN_LEGGINGS.get());
                        output.accept(ModItems.CHITIN_BOOTS.get());

                        output.accept(ModItems.SPIDER_TEMPLATE.get());
                        output.accept(ModItems.SPIDER_HELMET.get());
                        output.accept(ModItems.SPIDER_CHESTPLATE.get());
                        output.accept(ModItems.SPIDER_LEGGINGS.get());
                        output.accept(ModItems.SPIDER_BOOTS.get());

                        output.accept(ModBlocks.SILVERFISH_TRAP.get());
                        output.accept(ModBlocks.SPIDER_TRAP.get());
                        output.accept(ModBlocks.SPINNERET.get());
                        output.accept(ModBlocks.COBWEB_TRAP.get());

                        output.accept(ModBlocks.CHITIN_BLOCK.get());
                        output.accept(ModBlocks.CHITIN_SLAB.get());
                        output.accept(ModBlocks.CHITIN_STAIRS.get());
                        output.accept(ModBlocks.CHITIN_WALL.get());
                        output.accept(ModBlocks.CHITIN_BRICKS.get());
                        output.accept(ModBlocks.CHITIN_BRICK_SLAB.get());
                        output.accept(ModBlocks.CHITIN_BRICK_STAIRS.get());
                        output.accept(ModBlocks.CHITIN_BRICK_WALL.get());
                        output.accept(ModBlocks.CHISELED_CHITIN_BRICKS.get());

                    //    output.accept(ModItems.GRUB_SPAWN_EGG.get());
                   //     output.accept(ModItems.CRIMSON_BEETLE_SPAWN_EGG.get());
                    //    output.accept(ModItems.BRILLIANT_BEETLE_SPAWN_EGG.get());
                    //    output.accept(ModItems.MANTIS_SPAWN_EGG.get());
                    //    output.accept(ModItems.ORCHID_MANTIS_SPAWN_EGG.get());

                    //    output.accept(ModItems.HARVEST_BEETLE_SPAWN_EGG.get());
                    //    output.accept(ModItems.JEWEL_BEETLE_SPAWN_EGG.get());
                    //    output.accept(ModItems.CHORUS_BEETLE_SPAWN_EGG.get());
                    //    output.accept(ModItems.ANCIENT_DEBREETLE_SPAWN_EGG.get());

                    })).build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
