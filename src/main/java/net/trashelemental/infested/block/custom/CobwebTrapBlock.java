package net.trashelemental.infested.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.trashelemental.infested.InfestedSwarmsAndSpiders;
import net.trashelemental.infested.item.ModItems;

public class CobwebTrapBlock extends Block {

    public CobwebTrapBlock(Properties pProperties) {
        super(BlockBehaviour.Properties.of()
                .sound(SoundType.ROOTS)
                .strength(4f, 10f)
                .noCollission()
                .noOcclusion()
                .forceSolidOn()
                .pushReaction(PushReaction.DESTROY));
    }

    @Override
    public VoxelShape getVisualShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return Shapes.empty();
    }

    @Override
    public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
        return 100;
    }

    @Override
    public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
        return 60;
    }

    //Cobweb slowing
    @Override
    public void entityInside(BlockState pState, Level pLevel, BlockPos pPos, Entity pEntity) {

        if (pEntity.getName().getString().toLowerCase().contains("spider")) {
            return;
        }

        if (pEntity instanceof Player) {
            Player player = (Player) pEntity;
            if (player.getItemBySlot(EquipmentSlot.FEET).getItem() == ModItems.SPIDER_BOOTS.get()) {
                return;
            }
        }

        pEntity.makeStuckInBlock(pState, new Vec3(0.25, 0.05000000074505806, 0.25));
    }

    //Is destroyed ten seconds after being placed.
    @Override
    public void onPlace(BlockState pState, Level pLevel, BlockPos pPos, BlockState pOldState, boolean pMovedByPiston) {
        super.onPlace(pState, pLevel, pPos, pOldState, pMovedByPiston);

        InfestedSwarmsAndSpiders.queueServerWork(200, () -> {
            BlockState currentState = pLevel.getBlockState(pPos);
            if (currentState.getBlock() == this) {
                pLevel.destroyBlock(pPos, false);
            }
        });
    }

    //Valid spawn conditions
    @Override
    public boolean canSurvive(BlockState state, LevelReader world, BlockPos pos) {
        BlockState belowState = world.getBlockState(pos.below());
        return belowState.getShape(world, pos.below()).equals(Shapes.block());
    }

    @Override
    public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor world, BlockPos currentPos, BlockPos facingPos) {
        return !state.canSurvive(world, currentPos) ? Blocks.AIR.defaultBlockState() : super.updateShape(state, facing, facingState, world, currentPos, facingPos);
    }

    //Shape stuff
    public static final VoxelShape SHAPE = Block.box(0, 0, 0, 16, 1, 16);

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE;
    }

    @Override
    public RenderShape getRenderShape(BlockState pState) {
        return RenderShape.MODEL;
    }

}
