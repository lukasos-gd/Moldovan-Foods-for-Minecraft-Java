package net.moldovanfoods.mf.registry;

import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.moldovanfoods.mf.MoldovanFoods;

public class ModLootTables {

    public static void register() {
        LootTableEvents.MODIFY.register((key, tableBuilder, source, registries) -> {
            if (source.isBuiltin() && Blocks.SHORT_GRASS.getLootTable() == key) {
                LootPool.Builder pool = LootPool.lootPool()
                        .add(LootItem.lootTableItem(ModItems.MARAR_SEEDS))
                        .when(LootItemRandomChanceCondition.randomChance(0.2f));
                tableBuilder.withPool(pool);
            }
        });
        MoldovanFoods.LOGGER.info("Registering loot table modifications for " + MoldovanFoods.MOD_ID);
    }
}
