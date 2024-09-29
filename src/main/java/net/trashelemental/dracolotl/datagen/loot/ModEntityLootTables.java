package net.trashelemental.dracolotl.datagen.loot;

import net.minecraft.data.loot.EntityLootSubProvider;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.LootingEnchantFunction;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.trashelemental.dracolotl.entity.ModEntities;

import java.util.stream.Stream;

public class ModEntityLootTables extends EntityLootSubProvider {
    public ModEntityLootTables() {
        super(FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    public void generate() {
        add(ModEntities.DRACOLOTL.get(), createDracolotlLootTable());
    }

    private LootTable.Builder createDracolotlLootTable() {
        return LootTable.lootTable()
                .withPool(LootPool.lootPool()
                        .setRolls(UniformGenerator.between(1.0F, 1.0F))
                        .add(LootItem.lootTableItem(Items.DRAGON_EGG)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 1)))));
    }



    @Override
    protected Stream<EntityType<?>> getKnownEntityTypes() {
        return Stream.of(
            ModEntities.DRACOLOTL.get()
        );
    }
}
