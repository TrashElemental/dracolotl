package net.trashelemental.infested.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LevelEvent;
import net.minecraft.world.level.block.state.BlockState;
import net.trashelemental.infested.entity.ModEntities;

public class SilverfishTrapBlock extends Block {
    public SilverfishTrapBlock(Properties properties) {
        super(properties);
    }

    //Suppressing the warning because it looks like all the block methods are deprecated.
    //But I'm a dumb idiot baby who doesn't know java so idk this could be something to worry about.
    @Override
    public void neighborChanged(BlockState state, Level world, BlockPos pos, Block block, BlockPos fromPos, boolean isMoving) {
        super.neighborChanged(state, world, pos, block, fromPos, isMoving);

        if (world.getBestNeighborSignal(pos) > 0) {

            world.levelEvent(LevelEvent.PARTICLES_DESTROY_BLOCK, pos, Block.getId(world.getBlockState(pos)));
            world.destroyBlock(pos, false);

            if (world instanceof ServerLevel serverLevel) {
                RandomSource random = serverLevel.random;
                int count = Mth.nextInt(random, 5, 8);

                for (int i = 0; i < count; i++) {
                    Entity entity = ModEntities.ATTACK_SILVERFISH.get().create(serverLevel);
                    if (entity != null) {
                        entity.moveTo(pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5, 0, 0);
                        serverLevel.addFreshEntity(entity);
                    }
                }
            }
        }
    }
}
