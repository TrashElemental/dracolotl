package net.trashelemental.infested.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.Shapes;
import net.trashelemental.infested.block.ModBlocks;

public class SpinneretBlock extends Block {
    private boolean activated;

    public SpinneretBlock(Properties properties) {
        super(properties);
        this.activated = false;
    }

    @Override
    public void neighborChanged(BlockState state, Level world, BlockPos pos, Block block, BlockPos fromPos, boolean isMoving) {
        super.neighborChanged(state, world, pos, block, fromPos, isMoving);

        boolean powered = world.getBestNeighborSignal(pos) > 0;

        if (powered) {

            if (!activated) {

                world.playSound(null, pos, SoundEvents.DISPENSER_DISPENSE, SoundSource.BLOCKS, 1.0F, 1.0F);

                for (int x = -2; x <= 2; x++) {
                    for (int z = -2; z <= 2; z++) {
                        for (int y = 0; y <= 1; y++) {
                            BlockPos checkPos = pos.offset(x, y, z);
                            BlockState checkState = world.getBlockState(checkPos);
                            BlockState belowState = world.getBlockState(checkPos.below());

                            if (belowState.getShape(world, checkPos.below()).equals(Shapes.block()) &&
                                    checkState.getBlock() == Blocks.AIR) {
                                world.setBlock(checkPos, ModBlocks.COBWEB_TRAP.get().defaultBlockState(), 3);
                            }
                        }
                    }
                }
                activated = true;
            }
        } else {
            activated = false;
        }
    }
}
