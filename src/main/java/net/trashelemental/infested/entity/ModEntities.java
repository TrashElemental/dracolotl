package net.trashelemental.infested.entity;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.trashelemental.infested.InfestedSwarmsAndSpiders;
import net.trashelemental.infested.entity.custom.*;
import net.trashelemental.infested.entity.custom.jewel_beetles.AncientDebreetleEntity;
import net.trashelemental.infested.entity.custom.jewel_beetles.ChorusBeetleEntity;
import net.trashelemental.infested.entity.custom.jewel_beetles.HarvestBeetleEntity;
import net.trashelemental.infested.entity.custom.jewel_beetles.JewelBeetleEntity;
import net.trashelemental.infested.entity.custom.minions.AttackSilverfishEntity;
import net.trashelemental.infested.entity.custom.minions.AttackSpiderEntity;
import net.trashelemental.infested.entity.custom.minions.SilverfishMinionEntity;
import net.trashelemental.infested.entity.custom.minions.SpiderMinionEntity;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(Registries.ENTITY_TYPE, InfestedSwarmsAndSpiders.MOD_ID);


//Naturally Spawning Mobs
    public static final DeferredHolder<EntityType<?>, EntityType<CrimsonBeetleEntity>> CRIMSON_BEETLE =
            ENTITY_TYPES.register("crimson_beetle", () -> EntityType.Builder.of(CrimsonBeetleEntity::new, MobCategory.AMBIENT)
                    .sized(0.6f, 0.5f).build("crimson_beetle"));
    public static final DeferredHolder<EntityType<?>, EntityType<GrubEntity>> GRUB =
            ENTITY_TYPES.register("grub", () -> EntityType.Builder.of(GrubEntity::new, MobCategory.AMBIENT)
                    .sized(0.4f, 0.3f).build("grub"));
    public static final DeferredHolder<EntityType<?>, EntityType<BrilliantBeetleEntity>> BRILLIANT_BEETLE =
            ENTITY_TYPES.register("brilliant_beetle", () -> EntityType.Builder.of(BrilliantBeetleEntity::new, MobCategory.CREATURE)
                    .sized(1.5f, 1f).build("brilliant_beetle"));
    public static final DeferredHolder<EntityType<?>, EntityType<MantisEntity>> MANTIS =
            ENTITY_TYPES.register("mantis", () -> EntityType.Builder.of(MantisEntity::new, MobCategory.CREATURE)
                    .sized(1.5f, 1f).build("mantis"));
    public static final DeferredHolder<EntityType<?>, EntityType<OrchidMantisEntity>> ORCHID_MANTIS =
            ENTITY_TYPES.register("orchid_mantis", () -> EntityType.Builder.of(OrchidMantisEntity::new, MobCategory.CREATURE)
                    .sized(1.5f, 1f).build("orchid_mantis"));

//Jewel Beetles
    public static final DeferredHolder<EntityType<?>, EntityType<HarvestBeetleEntity>> HARVEST_BEETLE =
            ENTITY_TYPES.register("harvest_beetle", () -> EntityType.Builder.of(HarvestBeetleEntity::new, MobCategory.CREATURE)
                    .sized(0.8f, 0.8f).build("harvest_beetle"));
    public static final DeferredHolder<EntityType<?>, EntityType<JewelBeetleEntity>> JEWEL_BEETLE =
            ENTITY_TYPES.register("jewel_beetle", () -> EntityType.Builder.of(JewelBeetleEntity::new, MobCategory.CREATURE)
                    .sized(0.8f, 0.8f).build("jewel_beetle"));
    public static final DeferredHolder<EntityType<?>, EntityType<ChorusBeetleEntity>> CHORUS_BEETLE =
            ENTITY_TYPES.register("chorus_beetle", () -> EntityType.Builder.of(ChorusBeetleEntity::new, MobCategory.CREATURE)
                    .sized(0.8f, 0.8f).build("chorus_beetle"));
    public static final DeferredHolder<EntityType<?>, EntityType<AncientDebreetleEntity>> ANCIENT_DEBREETLE =
            ENTITY_TYPES.register("ancient_debreetle", () -> EntityType.Builder.of(AncientDebreetleEntity::new, MobCategory.CREATURE)
                    .sized(0.8f, 0.8f).build("ancient_debreetle"));

//Minions and Temporary Mobs
    public static final DeferredHolder<EntityType<?>, EntityType<SilverfishMinionEntity>> SILVERFISH_MINION =
            ENTITY_TYPES.register("silverfish_minion", () -> EntityType.Builder.of(SilverfishMinionEntity::new, MobCategory.CREATURE)
                    .sized(0.4f, 0.3f).build("silverfish_minion"));
    public static final DeferredHolder<EntityType<?>, EntityType<AttackSilverfishEntity>> ATTACK_SILVERFISH =
            ENTITY_TYPES.register("attack_silverfish", () -> EntityType.Builder.of(AttackSilverfishEntity::new, MobCategory.CREATURE)
                    .sized(0.4f, 0.3f).build("attack_silverfish"));
    public static final DeferredHolder<EntityType<?>, EntityType<TamedSpiderEntity>> TAMED_SPIDER =
            ENTITY_TYPES.register("tamed_spider", () -> EntityType.Builder.of(TamedSpiderEntity::new, MobCategory.CREATURE)
                    .sized(1.4f, 0.6f).build("tamed_spider"));
    public static final DeferredHolder<EntityType<?>, EntityType<SpiderMinionEntity>> SPIDER_MINION =
            ENTITY_TYPES.register("spider_minion", () -> EntityType.Builder.of(SpiderMinionEntity::new, MobCategory.CREATURE)
                    .sized(0.7f, 0.3f).build("spider_minion"));
    public static final DeferredHolder<EntityType<?>, EntityType<AttackSpiderEntity>> ATTACK_SPIDER =
            ENTITY_TYPES.register("attack_spider", () -> EntityType.Builder.of(AttackSpiderEntity::new, MobCategory.CREATURE)
                    .sized(0.7f, 0.3f).build("attack_spider"));




    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
