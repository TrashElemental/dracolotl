package net.trashelemental.infested.magic.enchantments.events;

import net.minecraft.core.Holder;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.neoforged.bus.api.Event;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.neoforged.neoforge.event.entity.living.LivingShieldBlockEvent;
import net.trashelemental.infested.InfestedSwarmsAndSpiders;
import net.trashelemental.infested.entity.ModEntities;
import net.trashelemental.infested.entity.custom.minions.SilverfishMinionEntity;
import net.trashelemental.infested.entity.custom.minions.SpiderMinionEntity;
import net.trashelemental.infested.item.ModItems;
import net.trashelemental.infested.magic.enchantments.ModEnchantments;

import javax.annotation.Nullable;

@EventBusSubscriber
public class InfestedEnchantmentEvent {

    @SubscribeEvent
    public static void onLivingAttack(LivingDamageEvent.Post event) {
        if (event.getEntity() instanceof LivingEntity entity &&
                event.getSource().getEntity() instanceof LivingEntity sourceEntity) {
            execute(event, entity.level(), entity, sourceEntity);
        }
    }

    private static void execute(LivingDamageEvent event, Level world, Entity entity, LivingEntity sourceEntity) {
        if (entity instanceof LivingEntity livingEntity) {

            ItemStack chestArmor = livingEntity.getItemBySlot(EquipmentSlot.CHEST);
            ItemStack spiderChestplate = new ItemStack(ModItems.SPIDER_CHESTPLATE.get());
            ItemStack chitinChestplate = new ItemStack(ModItems.CHITIN_CHESTPLATE.get());

            int enchantmentLevel = chestArmor.getEnchantmentLevel(entity.level().holderOrThrow(ModEnchantments.INFESTED));


            //Free Infested proc from Chitin Chestplate
            if (chestArmor.is(chitinChestplate.getItem())) {
                world.playSound(null, livingEntity.getX(), livingEntity.getY(), livingEntity.getZ(),
                        SoundEvents.BEEHIVE_EXIT, SoundSource.NEUTRAL, 1.0F, 1.0F);

                if (world instanceof ServerLevel serverLevel) {
                    serverLevel.sendParticles(ParticleTypes.POOF, livingEntity.getX(), livingEntity.getY(), livingEntity.getZ(), 5, 0.5, 0.5, 0.5, 0.0);
                }
                spawnSilverfishFromChitinSet(world, livingEntity);
            }

            //Infested Enchant
            if (enchantmentLevel > 0) {
                world.playSound(null, livingEntity.getX(), livingEntity.getY(), livingEntity.getZ(),
                        SoundEvents.BEEHIVE_EXIT, SoundSource.NEUTRAL, 1.0F, 1.0F);

                if (world instanceof ServerLevel serverLevel) {
                    serverLevel.sendParticles(ParticleTypes.POOF, livingEntity.getX(), livingEntity.getY(), livingEntity.getZ(), 5, 0.5, 0.5, 0.5, 0.0);
                }

                if (chestArmor.is(spiderChestplate.getItem())) {
                    spawnSpider(world, livingEntity, enchantmentLevel);             //Spiders if they're wearing the Spider Armor.
                } else {
                    spawnSilverfish(world, livingEntity, enchantmentLevel);         //Default (silverfish)
                }

                chestArmor.hurtAndBreak(2, livingEntity, EquipmentSlot.CHEST);
            }
        }
    }



    @SubscribeEvent
    public static void whenEntityBlocksWithShield(LivingShieldBlockEvent event) {
        if (event != null && event.getEntity() != null) {
            executeShieldEvent(event, event.getEntity().level(), event.getEntity());
        }
    }

    private static void executeShieldEvent(@Nullable Event event, Level world, Entity entity) {
        if (entity == null) return;

        if (entity instanceof LivingEntity livingEntity) {
            ItemStack shield = livingEntity.getUseItem();
            int enchantmentLevel = shield.getEnchantmentLevel(entity.level().holderOrThrow(ModEnchantments.INFESTED));

            if (enchantmentLevel > 0) {
                InfestedActivate(world, livingEntity, enchantmentLevel);
                shield.hurtAndBreak(2, livingEntity, EquipmentSlot.OFFHAND);
            }
        }
    }

    private static void InfestedActivate(Level world, LivingEntity livingEntity, int enchantmentLevel) {
        world.playSound(null, livingEntity.getX(), livingEntity.getY(), livingEntity.getZ(),
                SoundEvents.BEEHIVE_EXIT, SoundSource.NEUTRAL, 1.0F, 1.0F);

        ItemStack chestArmor = livingEntity.getItemBySlot(EquipmentSlot.CHEST);
        ItemStack spiderChestplate = new ItemStack(ModItems.SPIDER_CHESTPLATE.get());

        if (world instanceof ServerLevel serverLevel) {
            serverLevel.sendParticles(ParticleTypes.POOF, livingEntity.getX(), livingEntity.getY(), livingEntity.getZ(), 5, 0.5, 0.5, 0.5, 0.0);

            if (chestArmor.is(spiderChestplate.getItem())) {                //Checks for spider chestplate
                spawnSpider(world, livingEntity, enchantmentLevel);
            } else {
                spawnSilverfish(world, livingEntity, enchantmentLevel);     //Default (silverfish)
            }

        }
    }




    private static void spawnSilverfish(Level world, LivingEntity livingEntity, int enchantmentLevel) {
        if (world instanceof ServerLevel serverLevel) {
            for (int i = 0; i < enchantmentLevel; i++) {
                SilverfishMinionEntity silverfish = ModEntities.SILVERFISH_MINION.get().create(serverLevel);
                if (silverfish != null) {
                    silverfish.moveTo(livingEntity.getX(), livingEntity.getY(), livingEntity.getZ(), world.getRandom().nextFloat() * 360F, 0);
                    silverfish.setTame(true, false);
                    silverfish.setOwnerUUID(livingEntity.getUUID());
                    silverfish.setAge(-200);
                    serverLevel.addFreshEntity(silverfish);
                }
            }
        }
    }

    private static void spawnSilverfishFromChitinSet(Level world, LivingEntity livingEntity) {
        if (world instanceof ServerLevel serverLevel) {
            SilverfishMinionEntity silverfish = ModEntities.SILVERFISH_MINION.get().create(serverLevel);
            if (silverfish != null) {
                silverfish.moveTo(livingEntity.getX(), livingEntity.getY(), livingEntity.getZ(), world.getRandom().nextFloat() * 360F, 0);
                silverfish.setTame(true, false);
                silverfish.setOwnerUUID(livingEntity.getUUID());
                silverfish.setAge(-200);
                serverLevel.addFreshEntity(silverfish);
            }
        }
    }

    private static void spawnSpider(Level world, LivingEntity livingEntity, int enchantmentLevel) {
        if (world instanceof ServerLevel serverLevel) {
            for (int i = 0; i < enchantmentLevel; i++) {
                SpiderMinionEntity spider = ModEntities.SPIDER_MINION.get().create(serverLevel);
                if (spider != null) {
                    spider.moveTo(livingEntity.getX(), livingEntity.getY(), livingEntity.getZ(), world.getRandom().nextFloat() * 360F, 0);
                    spider.setTame(true, false);
                    spider.setOwnerUUID(livingEntity.getUUID());
                    spider.setAge(200);
                    serverLevel.addFreshEntity(spider);
                }
            }
        }
    }
}
