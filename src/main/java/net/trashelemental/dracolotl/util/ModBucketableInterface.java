package net.trashelemental.dracolotl.util;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.trashelemental.dracolotl.entity.custom.DracolotlEntity;

import java.util.Optional;

public interface ModBucketableInterface {
    boolean fromBucket();

    static void setFromBucket(boolean var1) {

    }

    void saveToBucketTag(ItemStack var1);

    static void loadFromBucketTag(CompoundTag var1) {

    }

    ItemStack getBucketItemStack();

    SoundEvent getPickupSound();


    @Deprecated
    static void saveDefaultDataToBucketTag(Mob pMob, ItemStack pBucket) {
        CompoundTag tag = pBucket.getOrCreateTag();
        if (pMob.hasCustomName()) {
            pBucket.setHoverName(pMob.getCustomName());
        }

        if (pMob.isNoAi()) {
            tag.putBoolean("NoAI", pMob.isNoAi());
        }

        if (pMob.isSilent()) {
            tag.putBoolean("Silent", pMob.isSilent());
        }

        if (pMob.isNoGravity()) {
            tag.putBoolean("NoGravity", pMob.isNoGravity());
        }

        if (pMob.hasGlowingTag()) {
            tag.putBoolean("Glowing", pMob.hasGlowingTag());
        }

        if (pMob.isInvulnerable()) {
            tag.putBoolean("Invulnerable", pMob.isInvulnerable());
        }

        tag.putFloat("Health", pMob.getHealth());
    }


    static void loadDefaultDataFromBucketTag(DracolotlEntity mob, CompoundTag tag) {
        if (tag.contains("NoAI")) {
            mob.setNoAi(tag.getBoolean("NoAI"));
        }

        if (tag.contains("Silent")) {
            mob.setSilent(tag.getBoolean("Silent"));
        }

        if (tag.contains("NoGravity")) {
            mob.setNoGravity(tag.getBoolean("NoGravity"));
        }

        if (tag.contains("Glowing")) {
            mob.setGlowingTag(tag.getBoolean("Glowing"));
        }

        if (tag.contains("Invulnerable")) {
            mob.setInvulnerable(tag.getBoolean("Invulnerable"));
        }

        if (tag.contains("Health", 99)) {
            mob.setHealth(tag.getFloat("Health"));
        }



    }

    static <T extends LivingEntity & ModBucketableInterface> Optional<InteractionResult> bucketMobPickup(Player player, InteractionHand hand, T entity) {
        ItemStack itemstack = player.getItemInHand(hand);
        if (itemstack.getItem() == Items.BUCKET && entity.isAlive()) {
            entity.playSound(entity.getPickupSound(), 1.0F, 1.0F);
            ItemStack itemstack1 = entity.getBucketItemStack();
            entity.saveToBucketTag(itemstack1);
            ItemStack itemstack2 = ItemUtils.createFilledResult(itemstack, player, itemstack1, false);
            player.setItemInHand(hand, itemstack2);
            Level level = entity.level();
            if (!level.isClientSide) {
                CriteriaTriggers.FILLED_BUCKET.trigger((ServerPlayer) player, itemstack1);
            }

            entity.discard();
            return Optional.of(InteractionResult.sidedSuccess(level.isClientSide));
        } else {
            return Optional.empty();
        }
    }


}
