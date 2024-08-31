package net.trashelemental.infested.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.trashelemental.infested.InfestedSwarmsAndSpiders;
import net.trashelemental.infested.block.custom.*;
import net.trashelemental.infested.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(InfestedSwarmsAndSpiders.MOD_ID);

//Building Blocks
    public static final DeferredBlock<Block> CHITIN_BLOCK = registerBlock("chitin_block",
        () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COAL_BLOCK)));

    public static final DeferredBlock<Block> CHITIN_SLAB = registerBlock("chitin_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.COAL_BLOCK)));

    public static final DeferredBlock<Block> CHITIN_STAIRS = registerBlock("chitin_stairs",
            () -> new StairBlock(ModBlocks.CHITIN_BLOCK.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.COAL_BLOCK)));

    public static final DeferredBlock<Block> CHITIN_WALL = registerBlock("chitin_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.COAL_BLOCK)));

    public static final DeferredBlock<Block> CHITIN_BRICKS = registerBlock("chitin_bricks",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COAL_BLOCK)));

    public static final DeferredBlock<Block> CHITIN_BRICK_SLAB = registerBlock("chitin_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.COAL_BLOCK)));

    public static final DeferredBlock<Block> CHITIN_BRICK_STAIRS = registerBlock("chitin_brick_stairs",
            () -> new StairBlock(ModBlocks.CHITIN_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.COAL_BLOCK)));

    public static final DeferredBlock<Block> CHITIN_BRICK_WALL = registerBlock("chitin_brick_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.COAL_BLOCK)));

    public static final DeferredBlock<Block> CHISELED_CHITIN_BRICKS = registerBlock("chiseled_chitin_bricks",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_PILLAR)));



//Functional Blocks
    public static final DeferredBlock<Block> SILVERFISH_TRAP = registerBlock("silverfish_trap",
        () -> new SilverfishTrapBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)));

    public static final DeferredBlock<Block> SPIDER_TRAP = registerBlock("spider_trap",
            () -> new SpiderTrapBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)));

    public static final DeferredBlock<Block> SPINNERET = registerBlock("spinneret",
            () -> new SpinneretBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)));

    public static final DeferredBlock<Block> COBWEB_TRAP = registerBlock("cobweb_trap",
            () -> new CobwebTrapBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.COBWEB)));



    private static <T extends Block>DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
