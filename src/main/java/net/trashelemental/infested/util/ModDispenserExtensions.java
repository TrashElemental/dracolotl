package net.trashelemental.infested.util;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.dispenser.BlockSource;
import net.minecraft.core.dispenser.OptionalDispenseItemBehavior;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.DispenserBlock;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.trashelemental.infested.InfestedSwarmsAndSpiders;
import net.trashelemental.infested.entity.ModEntities;
import net.trashelemental.infested.entity.custom.minions.AttackSilverfishEntity;
import net.trashelemental.infested.entity.custom.minions.AttackSpiderEntity;
import net.trashelemental.infested.item.ModItems;

@EventBusSubscriber(modid = InfestedSwarmsAndSpiders.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class ModDispenserExtensions {

    @SubscribeEvent
    public static void init(FMLCommonSetupEvent event) {

        event.enqueueWork(() -> DispenserBlock.registerBehavior(ModItems.SILVERFISH_EGGS.get(), new OptionalDispenseItemBehavior() {
            @Override
            public ItemStack execute(BlockSource blockSource, ItemStack stack) {

                Level world = blockSource.level();
                Direction direction = blockSource.state().getValue(DispenserBlock.FACING);
                BlockPos dispenserPos = blockSource.pos();

                BlockPos spawnPos = dispenserPos.relative(direction);

                if (world instanceof ServerLevel serverWorld) {
                    AttackSilverfishEntity silverfish = ModEntities.ATTACK_SILVERFISH.get().create(serverWorld);
                    if (silverfish != null) {
                        silverfish.moveTo(spawnPos.getX() + 0.5, spawnPos.getY(), spawnPos.getZ() + 0.5, direction.toYRot(), 0.0F);
                        serverWorld.addFreshEntity(silverfish);
                    }
                }

                ItemStack itemstack = stack.copy();
                itemstack.shrink(1);

                return itemstack;
            }
        }));

        event.enqueueWork(() -> DispenserBlock.registerBehavior(ModItems.SPIDER_EGG.get(), new OptionalDispenseItemBehavior() {
            @Override
            public ItemStack execute(BlockSource blockSource, ItemStack stack) {

                Level world = blockSource.level();
                Direction direction = blockSource.state().getValue(DispenserBlock.FACING);
                BlockPos dispenserPos = blockSource.pos();

                BlockPos spawnPos = dispenserPos.relative(direction);

                if (world instanceof ServerLevel serverWorld) {
                    AttackSpiderEntity spider = ModEntities.ATTACK_SPIDER.get().create(serverWorld);
                    if (spider != null) {
                        spider.moveTo(spawnPos.getX() + 0.5, spawnPos.getY(), spawnPos.getZ() + 0.5, direction.toYRot(), 0.0F);
                        serverWorld.addFreshEntity(spider);
                    }
                }

                ItemStack itemstack = stack.copy();
                itemstack.shrink(1);

                return itemstack;
            }
        }));
    }

}
