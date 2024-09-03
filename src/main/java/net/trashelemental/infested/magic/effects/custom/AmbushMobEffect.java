package net.trashelemental.infested.magic.effects.custom;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.trashelemental.infested.InfestedSwarmsAndSpiders;

public class AmbushMobEffect extends MobEffect {
    public AmbushMobEffect() {
        super(MobEffectCategory.BENEFICIAL, -10774487);
    }


    @Override
    public void onEffectAdded(LivingEntity livingEntity, int amplifier) {
        if (!livingEntity.level().isClientSide())  {
            if (!livingEntity.hasEffect(MobEffects.INVISIBILITY)) {
                livingEntity.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 300, 0, false, false));
            }
            if (!livingEntity.hasEffect(MobEffects.MOVEMENT_SLOWDOWN)) {
                livingEntity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 300, 2, false, false));
            }
        }
    }


    public ResourceLocation getIcon() {
        return InfestedSwarmsAndSpiders.prefix("textures/mob_effect/ambush.png");
    }
}
