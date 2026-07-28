package net.moldovanfoods.mf;

import net.fabricmc.api.ModInitializer;
import net.moldovanfoods.mf.registry.ModBlocks;
import net.moldovanfoods.mf.registry.ModItemGroups;
import net.moldovanfoods.mf.registry.ModItems;
import net.moldovanfoods.mf.registry.ModLootTables;
import net.moldovanfoods.mf.registry.ModWorldGen;
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
