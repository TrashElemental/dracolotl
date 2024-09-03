package net.trashelemental.infested.entity.ai;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;
import net.trashelemental.infested.block.ModBlocks;
import net.trashelemental.infested.entity.custom.minions.AttackSpiderEntity;
import net.trashelemental.infested.entity.custom.minions.SpiderMinionEntity;

@EventBusSubscriber
public class PlaceCobwebTrapOnDeathEvent {

    @SubscribeEvent
    public static void onEntityDeath(LivingDeathEvent event) {
        LivingEntity entity = event.getEntity();
        Level level = entity.level();
        BlockPos entityPos = entity.blockPosition();

        if (entity instanceof SpiderMinionEntity || entity instanceof AttackSpiderEntity) {
            placeCobwebTrap(level, entityPos);
        }
    }

    private static void placeCobwebTrap(Level level, BlockPos pos) {

        BlockState cobwebTrapState = ModBlocks.COBWEB_TRAP.get().defaultBlockState();

        if (cobwebTrapState.canSurvive(level, pos)) {
            level.setBlock(pos, cobwebTrapState, 3);
        }
    }
}

