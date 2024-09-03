package net.trashelemental.infested.magic.enchantments.events;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.neoforged.bus.api.Event;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;
import net.trashelemental.infested.InfestedSwarmsAndSpiders;
import net.trashelemental.infested.entity.ModEntities;
import net.trashelemental.infested.item.ModItems;
import net.trashelemental.infested.magic.enchantments.ModEnchantments;

import javax.annotation.Nullable;

@EventBusSubscriber
public class ParasitoidEnchantmentEvent {

    @SubscribeEvent
    public static void onEntityDeath(LivingDeathEvent event) {
        if (event != null && event.getEntity() != null) {
            execute(event, event.getEntity().level(), event.getEntity(), event.getSource().getEntity());
        }
    }

    public static void execute(LevelAccessor world, Entity entity, Entity sourceEntity) {
        execute(null, world, entity, sourceEntity);
    }

    private static void execute(@Nullable Event event, LevelAccessor world, Entity entity, @Nullable Entity sourceEntity) {
        if (entity == null || sourceEntity == null)
            return;

        if (!(sourceEntity instanceof LivingEntity livingSource))
            return;

        ItemStack weapon = livingSource.getMainHandItem();

        int enchantmentLevel = weapon.getEnchantmentLevel(entity.level().holderOrThrow(ModEnchantments.PARASITOID));

        ItemStack chestArmor = livingSource.getItemBySlot(EquipmentSlot.CHEST);
        ItemStack spiderChestplate = new ItemStack(ModItems.SPIDER_CHESTPLATE.get());
        ItemStack chitinChestplate = new ItemStack(ModItems.CHITIN_CHESTPLATE.get());

        if (chestArmor.getItem() == chitinChestplate.getItem()) {                   //Free Parasitoid level from Chitin Chestplate
            InfestedSwarmsAndSpiders.queueServerWork(20, () -> {

                if (world instanceof ServerLevel serverLevel) {
                    spawnSilverfishFromChitinSet(serverLevel, entity, sourceEntity);
                }
            });

        }

        if (enchantmentLevel > 0) {
            InfestedSwarmsAndSpiders.queueServerWork(20, () -> {

                if (world instanceof ServerLevel serverLevel) {

                    if (chestArmor.getItem() == spiderChestplate.getItem()) {
                        spawnSpider(serverLevel, entity, sourceEntity, enchantmentLevel);       //Spiders if wearing spider chestplate
                    }

                    else {
                        spawnSilverfish(serverLevel, entity, sourceEntity, enchantmentLevel);   //Default (silverfish)
                    }
                }

            });

            weapon.hurtAndBreak(2, (LivingEntity) sourceEntity, EquipmentSlot.MAINHAND);

        }
    }

    private static void spawnSilverfish(ServerLevel serverLevel, Entity entity, Entity sourceEntity, int enchantmentLevel) {
        for (int i = 0; i < enchantmentLevel; i++) {
            Entity silverfishEntity = ModEntities.SILVERFISH_MINION.get().create(serverLevel);
            if (silverfishEntity instanceof TamableAnimal tamedSilverfish) {
                tamedSilverfish.setPos(entity.getX(), entity.getY(), entity.getZ());
                tamedSilverfish.setTame(true, false);
                tamedSilverfish.setAge(-300);
                tamedSilverfish.setOwnerUUID(sourceEntity.getUUID());
                serverLevel.addFreshEntity(tamedSilverfish);
                serverLevel.playSound(null, entity.blockPosition(),
                        SoundEvents.TURTLE_EGG_HATCH, SoundSource.NEUTRAL, 1, 3);
            }
        }
    }

    private static void spawnSilverfishFromChitinSet(ServerLevel serverLevel, Entity entity, Entity sourceEntity) {
        Entity silverfishEntity = ModEntities.SILVERFISH_MINION.get().create(serverLevel);
        if (silverfishEntity instanceof TamableAnimal tamedSilverfish) {
            tamedSilverfish.setPos(entity.getX(), entity.getY(), entity.getZ());
            tamedSilverfish.setTame(true, false);
            tamedSilverfish.setAge(-300);
            tamedSilverfish.setOwnerUUID(sourceEntity.getUUID());
            serverLevel.addFreshEntity(tamedSilverfish);
            serverLevel.playSound(null, entity.blockPosition(),
                    SoundEvents.TURTLE_EGG_HATCH, SoundSource.NEUTRAL, 1, 3);
        }
    }

    private static void spawnSpider(ServerLevel serverLevel, Entity entity, Entity sourceEntity, int enchantmentLevel) {
        for (int i = 0; i < enchantmentLevel; i++) {
            Entity spider = ModEntities.SPIDER_MINION.get().create(serverLevel);
            if (spider instanceof TamableAnimal spiderMinion) {
                spiderMinion.setPos(entity.getX(), entity.getY(), entity.getZ());
                spiderMinion.setTame(true, false);
                spiderMinion.setAge(300);
                spiderMinion.setOwnerUUID(sourceEntity.getUUID());
                serverLevel.addFreshEntity(spiderMinion);
                serverLevel.playSound(null, entity.blockPosition(),
                        SoundEvents.SNIFFER_EGG_HATCH, SoundSource.NEUTRAL, 1, 3);
            }
        }
    }
}
