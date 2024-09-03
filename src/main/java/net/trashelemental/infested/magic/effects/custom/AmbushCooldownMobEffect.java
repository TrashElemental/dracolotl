package net.trashelemental.infested.magic.effects.custom;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.trashelemental.infested.InfestedSwarmsAndSpiders;

public class AmbushCooldownMobEffect extends MobEffect {
    public AmbushCooldownMobEffect() {
        super(MobEffectCategory.BENEFICIAL, -10774487);
    }



    public ResourceLocation getIcon() {
        return InfestedSwarmsAndSpiders.prefix("textures/mob_effect/ambush_cooldown.png");
    }

}
