package net.lukasosstudios.mf.registry;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.lukasosstudios.mf.MoldovanFoods;

public class ModWorldGen {

    public static final ResourceKey<PlacedFeature> SALT_ORE_PLACED_KEY = ResourceKey.create(
            Registries.PLACED_FEATURE,
            Identifier.fromNamespaceAndPath(MoldovanFoods.MOD_ID, "salt_ore")
    );

    public static void register() {
        BiomeModifications.addFeature(
                BiomeSelectors.foundInOverworld(),
                GenerationStep.Decoration.UNDERGROUND_ORES,
                SALT_ORE_PLACED_KEY
        );
        MoldovanFoods.LOGGER.info("Registering world generation for " + MoldovanFoods.MOD_ID);
    }
}
