package net.trashelemental.infested.item.armor.events;

import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.Event;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.trashelemental.infested.InfestedSwarmsAndSpiders;
import net.trashelemental.infested.block.ModBlocks;
import net.trashelemental.infested.entity.ModEntities;
import net.trashelemental.infested.item.ModItems;

import javax.annotation.Nullable;

@EventBusSubscriber
public class SpiderArmorEvents {


    @SubscribeEvent
    public static void onLivingAttack(LivingDamageEvent.Post event) {
        if (event.getEntity() != null && event.getSource().getEntity() instanceof LivingEntity sourceEntity) {
            execute(event, event.getEntity().level(), event.getEntity(), sourceEntity);
        }
    }

    private static void execute(@Nullable Event event, Level world, Entity entity, LivingEntity sourceEntity) {
        if (entity == null || sourceEntity == null) return;


        //When the player takes damage, they place a Cobweb Trap on the ground
        if (entity instanceof Player player) {
            if (isWearingFullSpiderSet(player)) {
                BlockPos pos = player.blockPosition();
                placeCobwebTrap(player.level(), pos);
            }
        }

        //When the player deals damage to an entity that is standing inside Cobweb or Cobweb Trap, the entity takes an additional 3 damage
        if (entity instanceof LivingEntity target) {
            if (sourceEntity instanceof Player player && isWearingFullSpiderSet(player)) {
                BlockPos pos = target.blockPosition();
                if (isInCobwebOrTrap(target.level(), pos)) {
                    entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(
                            Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.PLAYER_ATTACK)), 3);
                }
            }
        }


    }


    @SubscribeEvent
    public static void onEntityDeath(LivingDeathEvent event) {
        if (event != null && event.getEntity() != null && event.getSource().getEntity() != null) {
            execute(event, event.getEntity().level(), event.getEntity(), event.getSource().getEntity());
        }
    }

    private static void execute(@Nullable Event event, Level world, Entity entity, Entity sourceEntity) {


        //When the player kills an entity that is standing inside Cobweb or Cobweb Trap, a Spider Minion will be spawned.
        //Works if the target has slowness or weaving as well
        if (entity instanceof LivingEntity target && sourceEntity instanceof Player player) {
            if (isWearingFullSpiderSet(player)) {
                BlockPos pos = target.blockPosition();
                if (isInCobwebOrTrap(world, pos) || target.hasEffect(MobEffects.MOVEMENT_SLOWDOWN) || target.hasEffect(MobEffects.WEAVING)) {
                    InfestedSwarmsAndSpiders.queueServerWork(20, () -> {

                        if (world instanceof ServerLevel serverLevel) {
                            spawnSpider(serverLevel, entity, sourceEntity);
                        }
                    });
                }
            }
        }
    }

    //When the player right-clicks a block while wearing the full spider set and
    //crouching, they will sacrifice some durability to get four spider traps
    //I know it says two, but it runs twice basically because of the ticks
    @SubscribeEvent
    public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
        Player player = event.getEntity();
        Level level = event.getLevel();

        ItemStack head = player.getItemBySlot(EquipmentSlot.HEAD);
        ItemStack chest = player.getItemBySlot(EquipmentSlot.CHEST);
        ItemStack legs = player.getItemBySlot(EquipmentSlot.LEGS);
        ItemStack feet = player.getItemBySlot(EquipmentSlot.FEET);

        if (isWearingFullSpiderSet(player) && player.isShiftKeyDown()) {

            level.playSound(null, player.blockPosition(),
                    SoundEvents.SNOW_GOLEM_SHEAR, SoundSource.PLAYERS, 1.0F, 1.0F);

            if (!level.isClientSide()) {
                player.addItem(new ItemStack(ModBlocks.COBWEB_TRAP.get(), 2));
            }

            head.hurtAndBreak(5, player, EquipmentSlot.HEAD);
            chest.hurtAndBreak(5, player, EquipmentSlot.CHEST);
            legs.hurtAndBreak(5, player, EquipmentSlot.LEGS);
            feet.hurtAndBreak(5, player, EquipmentSlot.FEET);


        }
    }


    private static boolean isWearingFullSpiderSet(Player player) {
        return player.getItemBySlot(EquipmentSlot.HEAD).getItem() == ModItems.SPIDER_HELMET.get() &&
                player.getItemBySlot(EquipmentSlot.CHEST).getItem() == ModItems.SPIDER_CHESTPLATE.get() &&
                player.getItemBySlot(EquipmentSlot.LEGS).getItem() == ModItems.SPIDER_LEGGINGS.get() &&
                player.getItemBySlot(EquipmentSlot.FEET).getItem() == ModItems.SPIDER_BOOTS.get();
    }

    private static void placeCobwebTrap(Level level, BlockPos pos) {
        BlockState cobwebTrapState = ModBlocks.COBWEB_TRAP.get().defaultBlockState();

        if (cobwebTrapState.canSurvive(level, pos)) {
            level.setBlock(pos, cobwebTrapState, 3);
        }
    }

    private static boolean isInCobwebOrTrap(Level level, BlockPos pos) {
        BlockState state = level.getBlockState(pos);
        return state.is(Blocks.COBWEB) || state.is(ModBlocks.COBWEB_TRAP.get());
    }

    private static void spawnSpider(ServerLevel serverLevel, Entity entity, Entity sourceEntity) {
        Entity spider = ModEntities.SPIDER_MINION.get().create(serverLevel);
        if (spider instanceof TamableAnimal spiderMinion) {
            spiderMinion.setPos(entity.getX(), entity.getY(), entity.getZ());
            spiderMinion.setTame(true, false);
            spiderMinion.setAge(600);
            spiderMinion.setOwnerUUID(sourceEntity.getUUID());
            serverLevel.addFreshEntity(spiderMinion);
            serverLevel.playSound(null, entity.blockPosition(),
                    SoundEvents.SNIFFER_EGG_HATCH, SoundSource.NEUTRAL, 1, 3);
        }
    }




}
