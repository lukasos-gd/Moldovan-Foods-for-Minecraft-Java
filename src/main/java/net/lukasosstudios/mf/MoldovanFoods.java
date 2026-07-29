package net.lukasosstudios.mf;

import net.fabricmc.api.ModInitializer;
import net.lukasosstudios.mf.registry.ModBlocks;
import net.lukasosstudios.mf.registry.ModItemGroups;
import net.lukasosstudios.mf.registry.ModItems;
import net.lukasosstudios.mf.registry.ModLootTables;
import net.lukasosstudios.mf.registry.ModWorldGen;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MoldovanFoods implements ModInitializer {
    public static final String MOD_ID = "mf";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("Initializing Moldovan Foods");

        ModBlocks.register();
        ModItems.register();
        ModItemGroups.register();
        ModWorldGen.register();
        ModLootTables.register();
    }
}
