package net.trashelemental.infested.entity;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.trashelemental.infested.InfestedSwarmsAndSpiders;
import net.trashelemental.infested.entity.custom.TamedSpiderEntity;
import net.trashelemental.infested.entity.custom.minions.AttackSilverfishEntity;
import net.trashelemental.infested.entity.custom.minions.AttackSpiderEntity;
import net.trashelemental.infested.entity.custom.minions.SilverfishMinionEntity;
import net.trashelemental.infested.entity.custom.minions.SpiderMinionEntity;

@EventBusSubscriber(modid = InfestedSwarmsAndSpiders.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class ModEntityClientEvents {

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
//        event.put(ModEntities.CRIMSON_BEETLE.get(), CrimsonBeetleEntity.createAttributes().build());
//        event.put(ModEntities.GRUB.get(), GrubEntity.createAttributes().build());
//        event.put(ModEntities.BRILLIANT_BEETLE.get(), BrilliantBeetleEntity.createAttributes().build());
//        event.put(ModEntities.MANTIS.get(), MantisEntity.createAttributes().build());
//        event.put(ModEntities.ORCHID_MANTIS.get(), OrchidMantisEntity.createAttributes().build());
//
//        event.put(ModEntities.HARVEST_BEETLE.get(), HarvestBeetleEntity.createAttributes().build());
//        event.put(ModEntities.JEWEL_BEETLE.get(), JewelBeetleEntity.createAttributes().build());
//        event.put(ModEntities.CHORUS_BEETLE.get(), ChorusBeetleEntity.createAttributes().build());
//        event.put(ModEntities.ANCIENT_DEBREETLE.get(), AncientDebreetleEntity.createAttributes().build());
//
//
        event.put(ModEntities.SILVERFISH_MINION.get(), SilverfishMinionEntity.createAttributes().build());
        event.put(ModEntities.ATTACK_SILVERFISH.get(), AttackSilverfishEntity.createAttributes().build());
        event.put(ModEntities.TAMED_SPIDER.get(), TamedSpiderEntity.createAttributes().build());
        event.put(ModEntities.SPIDER_MINION.get(), SpiderMinionEntity.createAttributes().build());
        event.put(ModEntities.ATTACK_SPIDER.get(), AttackSpiderEntity.createAttributes().build());
    }

    @SubscribeEvent
    public static void commonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(ModEntityClientEvents::registerSpawnPlacements);
    }

    public static void registerSpawnPlacements() {
//        registerSpawnPlacements(ModEntities.MANTIS.get(),
//                SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, MantisEntity::canSpawn);
//
//        registerSpawnPlacements(ModEntities.ORCHID_MANTIS.get(),
//                SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, OrchidMantisEntity::canSpawn);
//
//        registerSpawnPlacements(ModEntities.BRILLIANT_BEETLE.get(),
//                SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, BrilliantBeetleEntity::canSpawn);
//
//        registerSpawnPlacements(ModEntities.CRIMSON_BEETLE.get(),
//                SpawnPlacementTypes.NO_RESTRICTIONS, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, CrimsonBeetleEntity::canSpawn);
//
//        registerSpawnPlacements(ModEntities.GRUB.get(),
//                SpawnPlacementTypes.NO_RESTRICTIONS, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, GrubEntity::canSpawn);
    }

//    public static final ModelLayerLocation CRIMSON_BEETLE_LAYER = new ModelLayerLocation(
//            ResourceLocation.fromNamespaceAndPath(InfestedSwarmsAndSpiders.MOD_ID, "crimson_beetle_layer"), "main");
//
//    public static final ModelLayerLocation GRUB_LAYER = new ModelLayerLocation(
//            ResourceLocation.fromNamespaceAndPath(InfestedSwarmsAndSpiders.MOD_ID, "grub_layer"), "main");
//
//    public static final ModelLayerLocation HARVEST_BEETLE_LAYER = new ModelLayerLocation(
//            ResourceLocation.fromNamespaceAndPath(InfestedSwarmsAndSpiders.MOD_ID, "harvest_beetle_layer"), "main");
//
//    public static final ModelLayerLocation JEWEL_BEETLE_LAYER = new ModelLayerLocation(
//            ResourceLocation.fromNamespaceAndPath(InfestedSwarmsAndSpiders.MOD_ID, "jewel_beetle_layer"), "main");
//
//    public static final ModelLayerLocation CHORUS_BEETLE_LAYER = new ModelLayerLocation(
//            ResourceLocation.fromNamespaceAndPath(InfestedSwarmsAndSpiders.MOD_ID, "chorus_beetle_layer"), "main");
//
//    public static final ModelLayerLocation ANCIENT_DEBREETLE_LAYER = new ModelLayerLocation(
//            ResourceLocation.fromNamespaceAndPath(InfestedSwarmsAndSpiders.MOD_ID, "ancient_debreetle_layer"), "main");
//
//    public static final ModelLayerLocation BRILLIANT_BEETLE_LAYER = new ModelLayerLocation(
//            ResourceLocation.fromNamespaceAndPath(InfestedSwarmsAndSpiders.MOD_ID, "brilliant_beetle_layer"), "main");
//
//    public static final ModelLayerLocation MANTIS_LAYER = new ModelLayerLocation(
//            ResourceLocation.fromNamespaceAndPath(InfestedSwarmsAndSpiders.MOD_ID, "mantis_layer"), "main");
//
//    public static final ModelLayerLocation ORCHID_MANTIS_LAYER = new ModelLayerLocation(
//            ResourceLocation.fromNamespaceAndPath(InfestedSwarmsAndSpiders.MOD_ID, "orchid_mantis_layer"), "main");

    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event) {

//        event.registerLayerDefinition(ModModelLayers.CRIMSON_BEETLE_LAYER, CrimsonBeetleModel::createBodyLayer);
//        event.registerLayerDefinition(ModModelLayers.GRUB_LAYER, GrubModel::createBodyLayer);
//        event.registerLayerDefinition(ModModelLayers.BRILLIANT_BEETLE_LAYER, BrilliantBeetleModel::createBodyLayer);
//        event.registerLayerDefinition(ModModelLayers.MANTIS_LAYER, MantisModel::createBodyLayer);
//        event.registerLayerDefinition(ModModelLayers.ORCHID_MANTIS_LAYER, MantisModel::createBodyLayer);
//
//        event.registerLayerDefinition(ModModelLayers.HARVEST_BEETLE_LAYER, JewelBeetleModel::createBodyLayer);
//        event.registerLayerDefinition(ModModelLayers.JEWEL_BEETLE_LAYER, JewelBeetleModel::createBodyLayer);
//        event.registerLayerDefinition(ModModelLayers.CHORUS_BEETLE_LAYER, JewelBeetleModel::createBodyLayer);
//        event.registerLayerDefinition(ModModelLayers.ANCIENT_DEBREETLE_LAYER, JewelBeetleModel::createBodyLayer);

    }


}
