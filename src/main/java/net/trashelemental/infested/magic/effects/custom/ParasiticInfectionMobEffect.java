package net.trashelemental.infested.magic.effects.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.level.LevelAccessor;
import net.trashelemental.infested.InfestedSwarmsAndSpiders;
import net.trashelemental.infested.entity.ModEntities;
import net.trashelemental.infested.magic.effects.ModMobEffects;

public class ParasiticInfectionMobEffect extends MobEffect {
    public ParasiticInfectionMobEffect() {
        super(MobEffectCategory.HARMFUL, -13434109);
    }


    @Override
    public void onMobRemoved(LivingEntity livingEntity, int amplifier, Entity.RemovalReason reason) {

        if (reason == Entity.RemovalReason.KILLED) {
            execute(livingEntity.level(), livingEntity, amplifier);
        }
    }

    private static void execute(LevelAccessor world, Entity entity, int amplifier) {
        if (entity == null || world == null) return;

        InfestedSwarmsAndSpiders.queueServerWork(10, () -> {
            if (world instanceof ServerLevel level) {

                level.sendParticles(ParticleTypes.POOF,
                        entity.getX(), entity.getY(), entity.getZ(),
                        10,
                        0.5, 0.5, 0.5,
                        0.1);

                level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()),
                        SoundEvents.SNIFFER_EGG_HATCH,
                        SoundSource.NEUTRAL, 1, 2);

                EntityType<?> crimsonBeetle = ModEntities.CRIMSON_BEETLE.get();
                Entity beetleEntity = crimsonBeetle.create(level);
                if (beetleEntity != null) {
                    beetleEntity.moveTo(entity.getX(), entity.getY(), entity.getZ(), world.getRandom().nextFloat() * 360F, 0);
                    level.addFreshEntity(beetleEntity);
                }
            }
        });
    }


    public ResourceLocation getIcon() {
        return InfestedSwarmsAndSpiders.prefix("textures/mob_effect/parasitic_infection.png");
    }
}


