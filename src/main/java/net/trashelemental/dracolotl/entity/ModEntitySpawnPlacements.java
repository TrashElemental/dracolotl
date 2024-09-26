package net.trashelemental.dracolotl.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.level.LevelAccessor;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;

public class ModEntitySpawnPlacements {

    @SubscribeEvent
    public static void spawnPlacements(RegisterSpawnPlacementsEvent event) {


    }

    public static boolean checkAnimalSpawnRules(EntityType<? extends Animal> entityType, LevelAccessor level, MobSpawnType spawnType, BlockPos position, RandomSource random) {
        return Animal.checkAnimalSpawnRules(entityType, level, spawnType, position, random);
    }



}
