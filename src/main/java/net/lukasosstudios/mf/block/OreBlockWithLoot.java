package net.lukasosstudios.mf.block;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;

import java.util.Optional;

public class OreBlockWithLoot extends Block {
    private final ResourceKey<LootTable> lootTableKey;

    public OreBlockWithLoot(Properties properties, String modId, String path) {
        super(properties);
        this.lootTableKey = ResourceKey.create(
                Registries.LOOT_TABLE,
                Identifier.fromNamespaceAndPath(modId, "blocks/" + path)
        );
    }

    @Override
    public Optional<ResourceKey<LootTable>> getLootTable() {
        return Optional.of(lootTableKey);
    }
}
