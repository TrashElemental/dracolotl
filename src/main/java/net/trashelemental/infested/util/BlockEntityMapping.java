package net.trashelemental.infested.util;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.trashelemental.infested.entity.ModEntities;

import java.util.HashMap;
import java.util.Map;

public class BlockEntityMapping {
    public static final Map<Block, JewelBeetleSpawnInfo> BLOCK_ENTITY_MAP = new HashMap<>();

    static {
        BLOCK_ENTITY_MAP.put(Blocks.SHORT_GRASS, new JewelBeetleSpawnInfo(ModEntities.HARVEST_BEETLE.get(), 0.05));
        BLOCK_ENTITY_MAP.put(Blocks.TALL_GRASS, new JewelBeetleSpawnInfo(ModEntities.HARVEST_BEETLE.get(), 0.05));
        BLOCK_ENTITY_MAP.put(Blocks.FERN, new JewelBeetleSpawnInfo(ModEntities.HARVEST_BEETLE.get(), 0.05));
        BLOCK_ENTITY_MAP.put(Blocks.LARGE_FERN, new JewelBeetleSpawnInfo(ModEntities.HARVEST_BEETLE.get(), 0.05));
        BLOCK_ENTITY_MAP.put(Blocks.DEAD_BUSH, new JewelBeetleSpawnInfo(ModEntities.HARVEST_BEETLE.get(), 0.05));

        BLOCK_ENTITY_MAP.put(Blocks.DEEPSLATE_COAL_ORE, new JewelBeetleSpawnInfo(ModEntities.JEWEL_BEETLE.get(), 0.05));
        BLOCK_ENTITY_MAP.put(Blocks.DEEPSLATE_COPPER_ORE, new JewelBeetleSpawnInfo(ModEntities.JEWEL_BEETLE.get(), 0.05));
        BLOCK_ENTITY_MAP.put(Blocks.DEEPSLATE_GOLD_ORE, new JewelBeetleSpawnInfo(ModEntities.JEWEL_BEETLE.get(), 0.05));
        BLOCK_ENTITY_MAP.put(Blocks.DEEPSLATE_LAPIS_ORE, new JewelBeetleSpawnInfo(ModEntities.JEWEL_BEETLE.get(), 0.05));
        BLOCK_ENTITY_MAP.put(Blocks.DEEPSLATE_IRON_ORE, new JewelBeetleSpawnInfo(ModEntities.JEWEL_BEETLE.get(), 0.05));
        BLOCK_ENTITY_MAP.put(Blocks.DEEPSLATE_DIAMOND_ORE, new JewelBeetleSpawnInfo(ModEntities.JEWEL_BEETLE.get(), 0.05));
        BLOCK_ENTITY_MAP.put(Blocks.DEEPSLATE_EMERALD_ORE, new JewelBeetleSpawnInfo(ModEntities.JEWEL_BEETLE.get(), 0.05));
        BLOCK_ENTITY_MAP.put(Blocks.DEEPSLATE_REDSTONE_ORE, new JewelBeetleSpawnInfo(ModEntities.JEWEL_BEETLE.get(), 0.05));

        BLOCK_ENTITY_MAP.put(Blocks.END_STONE, new JewelBeetleSpawnInfo(ModEntities.CHORUS_BEETLE.get(), 0.03));

        BLOCK_ENTITY_MAP.put(Blocks.NETHERRACK, new JewelBeetleSpawnInfo(ModEntities.ANCIENT_DEBREETLE.get(), 0.01));
    }

}
