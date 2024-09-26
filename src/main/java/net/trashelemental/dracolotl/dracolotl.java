package net.trashelemental.dracolotl;

import com.mojang.logging.LogUtils;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.neoforged.neoforge.event.tick.ServerTickEvent;
import net.trashelemental.dracolotl.entity.ModEntities;
import net.trashelemental.dracolotl.entity.ModEntityClientEvents;
import net.trashelemental.dracolotl.entity.client.renderers.DracolotlRenderer;
import net.trashelemental.dracolotl.item.ModItems;
import net.trashelemental.dracolotl.magic.effects.ModMobEffects;
import org.slf4j.Logger;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

@Mod(dracolotl.MOD_ID)
public class dracolotl
{

    public static final String MOD_ID = "dracolotl";
    private static final Logger LOGGER = LogUtils.getLogger();

    public dracolotl(IEventBus modEventBus, ModContainer modContainer) {

        modEventBus.addListener(this::commonSetup);
        NeoForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);

        ModItems.register(modEventBus);
        ModMobEffects.register(modEventBus);
        ModEntities.register(modEventBus);

    }

    private void commonSetup(final FMLCommonSetupEvent event) {



    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {

        if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {

            event.insertAfter(
                    new ItemStack(Items.AXOLOTL_BUCKET),
                    new ItemStack(ModItems.BUCKET_OF_DRACOLOTL.get()),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

        }

        if (event.getTabKey() == CreativeModeTabs.SPAWN_EGGS) {

                    event.accept(ModItems.DRACOLOTL_SPAWN_EGG.get());

                }

    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {



    }

    @EventBusSubscriber(modid = MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

            EntityRenderers.register(ModEntities.DRACOLOTL.get(), DracolotlRenderer::new);

        }
    }



    private static final Collection<AbstractMap.SimpleEntry<Runnable, Integer>> workQueue = new ConcurrentLinkedQueue<>();

    public static void queueServerWork(int tickDelay, Runnable action) {
        workQueue.add(new AbstractMap.SimpleEntry<>(action, tickDelay));
    }

    @SubscribeEvent
    public void onServerTick(ServerTickEvent.Post event) {
        List<AbstractMap.SimpleEntry<Runnable, Integer>> actionsToRun = new ArrayList<>();
        workQueue.forEach(work -> {
            work.setValue(work.getValue() - 1);
            if (work.getValue() <= 0) {
                actionsToRun.add(work);
            }
        });
        actionsToRun.forEach(work -> work.getKey().run());
        workQueue.removeAll(actionsToRun);
    }

    public static ResourceLocation prefix(String string) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, string);
    }

}
