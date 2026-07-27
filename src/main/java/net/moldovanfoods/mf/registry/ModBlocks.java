package net.moldovanfoods.mf.registry;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;

import net.moldovanfoods.mf.MoldovanFoods;
import net.moldovanfoods.mf.block.MararCropBlock;

public class ModBlocks {

    public static final Block MARAR_CROP = register(
            "marar_crop",
            new MararCropBlock(
                    BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT)
                            .noCollision()
                            .sound(SoundType.CROP)
            )
    );

    public static final Block SALT_ORE = register(
            "salt_ore",
            new Block(
                    BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_ORE)
                            .sound(SoundType.STONE)
            )
    );

    public static final Block DEEPSLATE_SALT_ORE = register(
            "deepslate_salt_ore",
            new Block(
                    BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_IRON_ORE)
                            .sound(SoundType.DEEPSLATE)
            )
    );

    private static Block register(String path, Block block) {
        Identifier id = Identifier.fromNamespaceAndPath(
                MoldovanFoods.MOD_ID,
                path
        );

        return Registry.register(
                BuiltInRegistries.BLOCK,
                id,
                block
        );
    }

    public static void register() {
        MoldovanFoods.LOGGER.info("Registering Moldovan Foods blocks");
    }
}
