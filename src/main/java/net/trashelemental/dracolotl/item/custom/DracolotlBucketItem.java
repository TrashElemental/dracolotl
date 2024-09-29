package net.trashelemental.dracolotl.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.component.DataComponents;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.trashelemental.dracolotl.entity.custom.DracolotlEntity;

import javax.annotation.Nullable;

public class DracolotlBucketItem extends Item {
    private final EntityType<?> type;
    private final SoundEvent emptySound;

    public DracolotlBucketItem(EntityType<?> type, SoundEvent emptySound, Item.Properties properties) {
        super(properties);
        this.type = type;
        this.emptySound = emptySound;
    }

    protected void playEmptySound(@Nullable Player player, LevelAccessor level, BlockPos pos) {
        level.playSound(player, pos, this.emptySound, SoundSource.NEUTRAL, 1.0F, 1.0F);
    }

    private void spawn(ServerLevel serverLevel, ItemStack bucketedMobStack, BlockPos pos) {
        Entity entity = this.type.spawn(serverLevel, bucketedMobStack, null, pos, MobSpawnType.BUCKET, true, false);

        if (entity instanceof DracolotlEntity dracolotl) {
            CustomData customData = (CustomData) bucketedMobStack.getOrDefault(DataComponents.BUCKET_ENTITY_DATA, CustomData.EMPTY);

            dracolotl.loadFromBucketTag(customData.copyTag());
            dracolotl.setFromBucket(true);
        }
    }

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

        ItemStack itemStack = context.getItemInHand();
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

        this.spawn((ServerLevel) level, itemStack, spawnPos);

        this.playEmptySound(player, level, blockPos);

        if (!player.isCreative()) {
            itemStack.shrink(1);
            player.getInventory().add(new ItemStack(Items.BUCKET));
        }

        level.gameEvent(player, GameEvent.ENTITY_PLACE, blockPos);

        return InteractionResult.CONSUME;
    }
}

