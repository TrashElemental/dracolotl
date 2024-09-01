package net.trashelemental.infested;

import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.event.tick.ServerTickEvent;
import net.trashelemental.infested.block.ModBlocks;
import net.trashelemental.infested.entity.ModEntities;
import net.trashelemental.infested.entity.client.renderers.TamedSpiderRenderer;
import net.trashelemental.infested.entity.client.renderers.minions.AttackSilverfishRenderer;
import net.trashelemental.infested.entity.client.renderers.minions.AttackSpiderRenderer;
import net.trashelemental.infested.entity.client.renderers.minions.SilverfishMinionRenderer;
import net.trashelemental.infested.entity.client.renderers.minions.SpiderMinionRenderer;
import net.trashelemental.infested.item.ModCreativeModeTabs;
import net.trashelemental.infested.item.ModItems;
import net.trashelemental.infested.magic.brewing.ModPotions;
import net.trashelemental.infested.magic.effects.ModMobEffects;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

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

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

@Mod(InfestedSwarmsAndSpiders.MOD_ID)
public class InfestedSwarmsAndSpiders
{

    public static final String MOD_ID = "infested_swarms_spiders";
    private static final Logger LOGGER = LogUtils.getLogger();

    public InfestedSwarmsAndSpiders(IEventBus modEventBus, ModContainer modContainer) {

        modEventBus.addListener(this::commonSetup);
        NeoForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);

        ModCreativeModeTabs.register(modEventBus);
        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModPotions.register(modEventBus);
        ModMobEffects.register(modEventBus);
        ModEntities.register(modEventBus);

    }

    private void commonSetup(final FMLCommonSetupEvent event) {



    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {



    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {



    }

    @EventBusSubscriber(modid = MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

            EntityRenderers.register(ModEntities.SILVERFISH_MINION.get(), SilverfishMinionRenderer::new);
            EntityRenderers.register(ModEntities.ATTACK_SILVERFISH.get(), AttackSilverfishRenderer::new);
            EntityRenderers.register(ModEntities.SPIDER_MINION.get(), SpiderMinionRenderer::new);
            EntityRenderers.register(ModEntities.ATTACK_SPIDER.get(), AttackSpiderRenderer::new);
            EntityRenderers.register(ModEntities.TAMED_SPIDER.get(), TamedSpiderRenderer::new);

//            EntityRenderers.register(ModEntities.CRIMSON_BEETLE.get(), CrimsonBeetleRenderer::new);
//            EntityRenderers.register(ModEntities.GRUB.get(), GrubRenderer::new);
//            EntityRenderers.register(ModEntities.BRILLIANT_BEETLE.get(), BrilliantBeetleRenderer::new);
//            EntityRenderers.register(ModEntities.MANTIS.get(), MantisRenderer::new);
//            EntityRenderers.register(ModEntities.ORCHID_MANTIS.get(), OrchidMantisRenderer::new);

//            EntityRenderers.register(ModEntities.HARVEST_BEETLE.get(), HarvestBeetleRenderer::new);
//            EntityRenderers.register(ModEntities.JEWEL_BEETLE.get(), JewelBeetleRenderer::new);
//            EntityRenderers.register(ModEntities.CHORUS_BEETLE.get(), ChorusBeetleRenderer::new);
//            EntityRenderers.register(ModEntities.ANCIENT_DEBREETLE.get(), AncientDebreetleRenderer::new);

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
