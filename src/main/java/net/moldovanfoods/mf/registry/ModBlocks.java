package net.moldovanfoods.mf.registry;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;

import net.moldovanfoods.mf.MoldovanFoods;
import net.moldovanfoods.mf.block.MararCropBlock;

public class ModBlocks {

    public static final Block MARAR_CROP = register(
            "marar_crop",
            MararCropBlock::new,
            BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT)
                    .noCollision()
                    .sound(SoundType.CROP)
    );

    public static final Block SALT_ORE = register(
            "salt_ore",
            Block::new,
            BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_ORE)
                    .sound(SoundType.STONE)
                    .lootFrom(() -> SALT_ORE)
    );

    public static final Block DEEPSLATE_SALT_ORE = register(
            "deepslate_salt_ore",
            Block::new,
            BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_IRON_ORE)
                    .sound(SoundType.DEEPSLATE)
                    .lootFrom(() -> DEEPSLATE_SALT_ORE)
    );

    private static Block register(String path, java.util.function.Function<BlockBehaviour.Properties, Block> factory, BlockBehaviour.Properties properties) {
        ResourceKey<Block> key = ResourceKey.create(
                Registries.BLOCK,
                Identifier.fromNamespaceAndPath(MoldovanFoods.MOD_ID, path)
        );

        Block block = factory.apply(properties.setId(key));

        return Registry.register(BuiltInRegistries.BLOCK, key, block);
    }

    public static void register() {
        MoldovanFoods.LOGGER.info("Registering blocks for " + MoldovanFoods.MOD_ID);
    }
}
