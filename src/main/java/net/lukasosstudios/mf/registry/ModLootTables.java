package net.lukasosstudios.mf.registry;

import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.lukasosstudios.mf.MoldovanFoods;

public class ModLootTables {

    private static final ResourceKey<LootTable> VILLAGE_PLAINS_HOUSE = ResourceKey.create(
            Registries.LOOT_TABLE, Identifier.withDefaultNamespace("chests/village/village_plains_house"));
    private static final ResourceKey<LootTable> VILLAGE_DESERT_HOUSE = ResourceKey.create(
            Registries.LOOT_TABLE, Identifier.withDefaultNamespace("chests/village/village_desert_house"));
    private static final ResourceKey<LootTable> SHIPWRECK_SUPPLY = ResourceKey.create(
            Registries.LOOT_TABLE, Identifier.withDefaultNamespace("chests/shipwreck_supply"));

    public static void register() {
        LootTableEvents.MODIFY.register((key, tableBuilder, source, registries) -> {
            if (!source.isBuiltin()) {
                return;
            }

            if (Blocks.SHORT_GRASS.getLootTable().orElse(null) == key) {
                LootPool.Builder pool = LootPool.lootPool()
                        .add(LootItem.lootTableItem(ModItems.MARAR_SEEDS))
                        .when(LootItemRandomChanceCondition.randomChance(0.2f));
                tableBuilder.withPool(pool);
            }

            if (VILLAGE_PLAINS_HOUSE.equals(key) || VILLAGE_DESERT_HOUSE.equals(key)) {
                LootPool.Builder pool = LootPool.lootPool()
                        .setRolls(UniformGenerator.between(0, 1))
                        .add(LootItem.lootTableItem(ModItems.LAVAS))
                        .add(LootItem.lootTableItem(ModItems.ZACUSCA))
                        .add(LootItem.lootTableItem(ModItems.SARE)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2))));
                tableBuilder.withPool(pool);
            }

            if (SHIPWRECK_SUPPLY.equals(key)) {
                LootPool.Builder pool = LootPool.lootPool()
                        .setRolls(UniformGenerator.between(0, 1))
                        .add(LootItem.lootTableItem(ModItems.KEBAB))
                        .add(LootItem.lootTableItem(ModItems.PAINE_CU_ZACUSCA));
                tableBuilder.withPool(pool);
            }
        });
        MoldovanFoods.LOGGER.info("Registering loot table modifications for " + MoldovanFoods.MOD_ID);
    }
                             }
