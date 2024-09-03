package net.trashelemental.infested.entity;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.SpawnPlacementTypes;
import net.minecraft.world.level.levelgen.Heightmap;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;
import net.trashelemental.infested.InfestedSwarmsAndSpiders;
import net.trashelemental.infested.entity.client.models.*;
import net.trashelemental.infested.entity.custom.*;
import net.trashelemental.infested.entity.custom.jewel_beetles.AncientDebreetleEntity;
import net.trashelemental.infested.entity.custom.jewel_beetles.ChorusBeetleEntity;
import net.trashelemental.infested.entity.custom.jewel_beetles.HarvestBeetleEntity;
import net.trashelemental.infested.entity.custom.jewel_beetles.JewelBeetleEntity;
import net.trashelemental.infested.entity.custom.minions.AttackSilverfishEntity;
import net.trashelemental.infested.entity.custom.minions.AttackSpiderEntity;
import net.trashelemental.infested.entity.custom.minions.SilverfishMinionEntity;
import net.trashelemental.infested.entity.custom.minions.SpiderMinionEntity;

@EventBusSubscriber(modid = InfestedSwarmsAndSpiders.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class ModEntityClientEvents {

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.CRIMSON_BEETLE.get(), CrimsonBeetleEntity.createAttributes().build());
        event.put(ModEntities.GRUB.get(), GrubEntity.createAttributes().build());
        event.put(ModEntities.BRILLIANT_BEETLE.get(), BrilliantBeetleEntity.createAttributes().build());
        event.put(ModEntities.MANTIS.get(), MantisEntity.createAttributes().build());
        event.put(ModEntities.ORCHID_MANTIS.get(), OrchidMantisEntity.createAttributes().build());

        event.put(ModEntities.HARVEST_BEETLE.get(), HarvestBeetleEntity.createAttributes().build());
        event.put(ModEntities.JEWEL_BEETLE.get(), JewelBeetleEntity.createAttributes().build());
        event.put(ModEntities.CHORUS_BEETLE.get(), ChorusBeetleEntity.createAttributes().build());
        event.put(ModEntities.ANCIENT_DEBREETLE.get(), AncientDebreetleEntity.createAttributes().build());


        event.put(ModEntities.SILVERFISH_MINION.get(), SilverfishMinionEntity.createAttributes().build());
        event.put(ModEntities.ATTACK_SILVERFISH.get(), AttackSilverfishEntity.createAttributes().build());
        event.put(ModEntities.TAMED_SPIDER.get(), TamedSpiderEntity.createAttributes().build());
        event.put(ModEntities.SPIDER_MINION.get(), SpiderMinionEntity.createAttributes().build());
        event.put(ModEntities.ATTACK_SPIDER.get(), AttackSpiderEntity.createAttributes().build());
    }

    public static final ModelLayerLocation CRIMSON_BEETLE_LAYER = new ModelLayerLocation(
            InfestedSwarmsAndSpiders.prefix("crimson_beetle_layer"), "main");

    public static final ModelLayerLocation GRUB_LAYER = new ModelLayerLocation(
            InfestedSwarmsAndSpiders.prefix("grub_layer"), "main");

    public static final ModelLayerLocation HARVEST_BEETLE_LAYER = new ModelLayerLocation(
            InfestedSwarmsAndSpiders.prefix("harvest_beetle_layer"), "main");

    public static final ModelLayerLocation JEWEL_BEETLE_LAYER = new ModelLayerLocation(
            InfestedSwarmsAndSpiders.prefix("jewel_beetle_layer"), "main");

    public static final ModelLayerLocation CHORUS_BEETLE_LAYER = new ModelLayerLocation(
            InfestedSwarmsAndSpiders.prefix("chorus_beetle_layer"), "main");

    public static final ModelLayerLocation ANCIENT_DEBREETLE_LAYER = new ModelLayerLocation(
            InfestedSwarmsAndSpiders.prefix("ancient_debreetle_layer"), "main");

    public static final ModelLayerLocation BRILLIANT_BEETLE_LAYER = new ModelLayerLocation(
        InfestedSwarmsAndSpiders.prefix("brilliant_beetle_layer"), "main");

    public static final ModelLayerLocation MANTIS_LAYER = new ModelLayerLocation(
            InfestedSwarmsAndSpiders.prefix("mantis_layer"), "main");

    public static final ModelLayerLocation ORCHID_MANTIS_LAYER = new ModelLayerLocation(
            InfestedSwarmsAndSpiders.prefix("orchid_mantis_layer"), "main");

    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event) {

        event.registerLayerDefinition(CRIMSON_BEETLE_LAYER, CrimsonBeetleModel::createBodyLayer);
        event.registerLayerDefinition(GRUB_LAYER, GrubModel::createBodyLayer);
        event.registerLayerDefinition(BRILLIANT_BEETLE_LAYER, BrilliantBeetleModel::createBodyLayer);
        event.registerLayerDefinition(MANTIS_LAYER, MantisModel::createBodyLayer);
        event.registerLayerDefinition(ORCHID_MANTIS_LAYER, MantisModel::createBodyLayer);

        event.registerLayerDefinition(HARVEST_BEETLE_LAYER, JewelBeetleModel::createBodyLayer);
        event.registerLayerDefinition(JEWEL_BEETLE_LAYER, JewelBeetleModel::createBodyLayer);
        event.registerLayerDefinition(CHORUS_BEETLE_LAYER, JewelBeetleModel::createBodyLayer);
        event.registerLayerDefinition(ANCIENT_DEBREETLE_LAYER, JewelBeetleModel::createBodyLayer);

    }


}
