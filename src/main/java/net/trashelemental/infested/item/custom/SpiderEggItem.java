package net.trashelemental.infested.item.custom;

import net.minecraft.world.item.Item;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.trashelemental.infested.entity.ModEntities;
import net.trashelemental.infested.entity.custom.TamedSpiderEntity;

import java.util.Random;

public class SpiderEggItem extends Item {
    public SpiderEggItem(Properties pProperties) {
        super(pProperties);
    }

    private static final Random RANDOM = new Random();

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        if (!(level instanceof ServerLevel)) {
            return InteractionResult.FAIL;
        }

        Player player = context.getPlayer();
        if (player == null) {
            return InteractionResult.FAIL;
        }

        ItemStack itemstack = context.getItemInHand();
        BlockPos blockPos = context.getClickedPos();
        Direction direction = context.getClickedFace();
        BlockState blockState = level.getBlockState(blockPos);

        BlockPos spawnPos;
        if (blockState.getCollisionShape(level, blockPos).isEmpty()) {
            spawnPos = blockPos;
        } else {
            spawnPos = blockPos.relative(direction);
        }

        if (!level.getBlockState(spawnPos).isAir()) {
            return InteractionResult.FAIL;
        }

        Random random = new Random();
        TamedSpiderEntity spider = new TamedSpiderEntity(ModEntities.TAMED_SPIDER.get(), level);
        spider.setTame(true, false);
        spider.moveTo(spawnPos.getX() + random.nextDouble(), spawnPos.getY(), spawnPos.getZ() + random.nextDouble(), random.nextFloat() * 360F, 0);
        ((ServerLevel) level).addFreshEntity(spider);
        spider.setOwnerUUID(player.getUUID());

        if (!player.isCreative()) {
            itemstack.shrink(1);
        }

        level.gameEvent(player, GameEvent.ENTITY_PLACE, blockPos);

        level.playSound(null, blockPos,
                SoundEvents.SNIFFER_EGG_HATCH, SoundSource.PLAYERS, 1.0F, 1.0F);

        ((ServerLevel) level).sendParticles(ParticleTypes.POOF,
                spider.getX(), spider.getY(), spider.getZ(),
                10, 0.5, 0.5, 0.5, 0.1
        );

        return InteractionResult.CONSUME;
    }

}
