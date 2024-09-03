package net.trashelemental.infested.item.armor.custom;

import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.trashelemental.infested.item.ModItems;
import net.trashelemental.infested.magic.effects.ModMobEffects;

public class ChitinArmorItem extends ArmorItem {

    public ChitinArmorItem(Holder<ArmorMaterial> material, ArmorItem.Type type, Item.Properties properties) {
        super(material, type, properties);
    }


    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int slotId, boolean isSelected) {
        super.inventoryTick(stack, level, entity, slotId, isSelected);

        if (level.isClientSide) return;

        //Applies Ambush to the player when they crouch if they haven't performed an Ambush attack recently.
        if (entity instanceof Player player) {
            if (isWearingFullChitinSet(player) && player.isCrouching()) {
                if (!player.hasEffect(ModMobEffects.AMBUSH_COOLDOWN)) {
                    player.addEffect(new MobEffectInstance(ModMobEffects.AMBUSH, 15 * 20));
                }
            }
        }
    }

    private boolean isWearingFullChitinSet(Player player) {
        return player.getItemBySlot(EquipmentSlot.HEAD).getItem() == ModItems.CHITIN_HELMET.get() &&
                player.getItemBySlot(EquipmentSlot.CHEST).getItem() == ModItems.CHITIN_CHESTPLATE.get() &&
                player.getItemBySlot(EquipmentSlot.LEGS).getItem() == ModItems.CHITIN_LEGGINGS.get() &&
                player.getItemBySlot(EquipmentSlot.FEET).getItem() == ModItems.CHITIN_BOOTS.get();
    }

}












