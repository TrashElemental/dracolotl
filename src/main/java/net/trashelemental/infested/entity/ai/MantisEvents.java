package net.trashelemental.infested.entity.ai;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.neoforged.bus.api.Event;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingChangeTargetEvent;
import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;
import net.trashelemental.infested.InfestedSwarmsAndSpiders;
import net.trashelemental.infested.entity.custom.MantisEntity;
import net.trashelemental.infested.entity.custom.OrchidMantisEntity;
import net.trashelemental.infested.magic.effects.ModMobEffects;

import javax.annotation.Nullable;

@EventBusSubscriber
public class MantisEvents {

    @SubscribeEvent
    public static void onEntityDeath(LivingDeathEvent event) {
        if (event != null && event.getEntity() != null && event.getSource().getEntity() != null) {
            execute(event, event.getEntity().level(), event.getEntity(), event.getSource().getEntity());
        }
    }

    private static void execute(@Nullable Event event, Level world, Entity entity, Entity sourceEntity) {

        //When the mantis kills an arthropod, it is healed to max health.
        if (entity instanceof LivingEntity killedEntity &&
                (sourceEntity instanceof MantisEntity || sourceEntity instanceof OrchidMantisEntity)) {

            LivingEntity mantis = (LivingEntity) sourceEntity;

            if (killedEntity.getType().is(EntityTypeTags.ARTHROPOD)) {

                mantis.setHealth(mantis.getMaxHealth());

                ((ServerLevel) world).sendParticles(
                        ParticleTypes.HAPPY_VILLAGER,
                        mantis.getX(), mantis.getY() + 1, mantis.getZ(),
                        10, 0.5, 0.5, 0.5, 0.1);

                world.playSound(null, mantis.blockPosition(),
                        SoundEvents.GENERIC_EAT, SoundSource.NEUTRAL, 1.0F, 1.0F);
                InfestedSwarmsAndSpiders.queueServerWork(5, () -> world.playSound(null, mantis.blockPosition(),
                        SoundEvents.GENERIC_EAT, SoundSource.NEUTRAL, 1.0F, 1.0F));
                InfestedSwarmsAndSpiders.queueServerWork(10, () -> world.playSound(null, mantis.blockPosition(),
                        SoundEvents.GENERIC_EAT, SoundSource.NEUTRAL, 1.0F, 1.0F));
            }
        }
    }

    //When the mantis attacks, it tries to enter an Ambush if it hasn't recently
    @SubscribeEvent
    public static void onEntitySetsAttackTarget(LivingChangeTargetEvent event) {
        execute(event, event.getEntity());
    }

    public static void execute(Entity sourceentity) {
        execute(null, sourceentity);
    }

    private static void execute(@Nullable Event event, Entity sourceentity) {
        if (!(sourceentity instanceof MantisEntity || sourceentity instanceof OrchidMantisEntity)) {
            return;
        }

        LivingEntity mantis = (LivingEntity) sourceentity;

        if (!mantis.hasEffect(ModMobEffects.AMBUSH_COOLDOWN)) {
            mantis.addEffect(new MobEffectInstance(ModMobEffects.AMBUSH, 300, 0, false, true));
        }
    }

}
