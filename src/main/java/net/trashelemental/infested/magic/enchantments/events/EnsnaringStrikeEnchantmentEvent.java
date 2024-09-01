package net.trashelemental.infested.magic.enchantments.events;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.neoforged.bus.api.Event;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.trashelemental.infested.magic.enchantments.ModEnchantments;

import javax.annotation.Nullable;

@EventBusSubscriber
public class EnsnaringStrikeEnchantmentEvent {

    @SubscribeEvent
    public static void onLivingAttack(LivingDamageEvent.Post event) {
        if (event.getEntity() != null && event.getSource().getEntity() instanceof LivingEntity sourceEntity) {
            execute(event, event.getEntity().level(), event.getEntity(), sourceEntity);
        }
    }

    private static void execute(@Nullable Event event, Level world, Entity entity, LivingEntity sourceEntity) {
        if (entity == null || sourceEntity == null) return;

        ItemStack weapon = sourceEntity.getMainHandItem();
        if (weapon.isEmpty()) return;

        int enchantmentLevel = weapon.getEnchantmentLevel(entity.level().holderOrThrow(ModEnchantments.ENSNARING_STRIKE));

        if (enchantmentLevel > 0 && entity instanceof LivingEntity target) {
            int duration = 20 * enchantmentLevel;
            target.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, duration, 3));

            if (!(sourceEntity instanceof Player) || !((Player) sourceEntity).getAbilities().instabuild) {
                weapon.hurtAndBreak(5, sourceEntity, EquipmentSlot.MAINHAND);
            }

        }
    }

}
