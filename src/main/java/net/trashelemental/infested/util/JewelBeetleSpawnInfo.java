package net.trashelemental.infested.util;

import net.minecraft.world.entity.EntityType;

public class JewelBeetleSpawnInfo {
    public final EntityType<?> entityType;
    public final double spawnChance;

    public JewelBeetleSpawnInfo(EntityType<?> entityType, double spawnChance) {
        this.entityType = entityType;
        this.spawnChance = spawnChance;
    }
}
