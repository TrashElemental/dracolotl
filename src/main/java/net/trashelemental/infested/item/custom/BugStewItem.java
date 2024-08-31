package net.trashelemental.infested.item.custom;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

public class BugStewItem extends Item {
    public BugStewItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level world, LivingEntity entity) {
        ItemStack itemstack = super.finishUsingItem(stack, world, entity);

        if (entity instanceof Player player) {
            if (!player.isCreative()) {
                if (!player.getInventory().add(new ItemStack(Items.BOWL))) {
                    player.drop(new ItemStack(Items.BOWL), false);
                }
            }
        }

        return itemstack;
    }

}
