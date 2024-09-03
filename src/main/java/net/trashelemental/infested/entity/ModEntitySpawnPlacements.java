package net.trashelemental.infested.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnPlacementTypes;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.monster.hoglin.Hoglin;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.material.FluidState;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;

import java.util.Arrays;
import java.util.List;

public class ModEntitySpawnPlacements {

    @SubscribeEvent
    public static void spawnPlacements(RegisterSpawnPlacementsEvent event) {
        event.register(ModEntities.MANTIS.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                ModEntitySpawnPlacements::checkAnimalSpawnRules, RegisterSpawnPlacementsEvent.Operation.OR);

        event.register(ModEntities.ORCHID_MANTIS.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                ModEntitySpawnPlacements::checkAnimalSpawnRules, RegisterSpawnPlacementsEvent.Operation.OR);

        event.register(ModEntities.BRILLIANT_BEETLE.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                ModEntitySpawnPlacements::checkAnimalSpawnRules, RegisterSpawnPlacementsEvent.Operation.OR);

        event.register(ModEntities.CRIMSON_BEETLE.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                ModEntitySpawnPlacements::checkNetherAnimalSpawnRules, RegisterSpawnPlacementsEvent.Operation.OR);

        event.register(ModEntities.GRUB.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                ModEntitySpawnPlacements::checkNetherAnimalSpawnRules, RegisterSpawnPlacementsEvent.Operation.OR);

    }

    public static boolean checkAnimalSpawnRules(EntityType<? extends Animal> entityType, LevelAccessor level, MobSpawnType spawnType, BlockPos position, RandomSource random) {
        return Animal.checkAnimalSpawnRules(entityType, level, spawnType, position, random);
    }

    public static boolean checkNetherAnimalSpawnRules(EntityType<? extends Animal> entityType, LevelAccessor level, MobSpawnType spawnType, BlockPos position, RandomSource random) {
        BlockPos blockBelowPos = position.below();
        BlockState blockBelow = level.getBlockState(blockBelowPos);

        List<Block> prohibitedBlocks = Arrays.asList(
                Blocks.NETHER_WART_BLOCK,
                Blocks.SHROOMLIGHT,
                Blocks.WEEPING_VINES,
                Blocks.WEEPING_VINES_PLANT,
                Blocks.GLOWSTONE,
                Blocks.AIR,
                Blocks.CRIMSON_STEM,
                Blocks.LAVA,
                Blocks.MAGMA_BLOCK,
                Blocks.FIRE
        );

        if (prohibitedBlocks.contains(blockBelow.getBlock())) {
            return false;
        }

        FluidState fluidStateBelow = level.getFluidState(blockBelowPos);
        if (fluidStateBelow.is(FluidTags.LAVA)) {
            return false;
        }

        return true;
    }

}
