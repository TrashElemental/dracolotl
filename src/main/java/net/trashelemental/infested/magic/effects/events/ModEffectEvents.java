package net.trashelemental.infested.magic.effects.events;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.MobEffectEvent;
import net.trashelemental.infested.InfestedSwarmsAndSpiders;
import net.trashelemental.infested.entity.ModEntities;
import net.trashelemental.infested.magic.effects.ModMobEffects;

@EventBusSubscriber
public class ModEffectEvents {

    @SubscribeEvent
    public static void onMobEffectExpired(MobEffectEvent.Expired event) {
        LivingEntity entity = event.getEntity();
        MobEffectInstance effectInstance = event.getEffectInstance();

        if (effectInstance != null && effectInstance.getEffect().equals(ModMobEffects.PARASITIC_INFECTION) )
         {
            execute(event.getEntity().level(), entity);
        }
    }

    private static void execute(LevelAccessor world, Entity entity) {
        if (entity == null || world == null) return;

        entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(
                Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)), 30);

        InfestedSwarmsAndSpiders.queueServerWork(20, () -> {
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
}
