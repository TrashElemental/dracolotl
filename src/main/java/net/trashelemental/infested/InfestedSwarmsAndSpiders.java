package net.trashelemental.infested;

import net.minecraft.util.Tuple;
import net.neoforged.fml.util.thread.SidedThreadGroups;
import net.trashelemental.infested.block.ModBlocks;
import net.trashelemental.infested.entity.ModEntities;
import net.trashelemental.infested.item.ModCreativeModeTabs;
import net.trashelemental.infested.item.ModItems;
import net.trashelemental.infested.magic.brewing.ModPotions;
import net.trashelemental.infested.magic.effects.ModMobEffects;
import net.trashelemental.infested.magic.enchantments.ModEnchantments;
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
        ModEnchantments.register(modEventBus);
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



        }
    }



//    private static final Collection<Tuple<Runnable, Integer>> workQueue = new ConcurrentLinkedQueue<>();

//    public static void queueServerWork(int tick, Runnable action) {
 //       if (Thread.currentThread().getThreadGroup() == SidedThreadGroups.SERVER)
 //           workQueue.add(new Tuple<>(action, tick));
//    }

 //   @SubscribeEvent
 //   public void tick(TickEvent.ServerTickEvent event) {
  //      if (event.phase == TickEvent.Phase.END) {
  //          List<Tuple<Runnable, Integer>> actions = new ArrayList<>();
  //          workQueue.forEach(work -> {
  //              work.setB(work.getB() - 1);
   //             if (work.getB() == 0)
   //                 actions.add(work);
   //         });
    //        actions.forEach(e -> e.getA().run());
    //        workQueue.removeAll(actions);
   //     }
    //}

}
