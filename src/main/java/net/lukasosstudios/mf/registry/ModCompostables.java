package net.lukasosstudios.mf.registry;

import net.fabricmc.fabric.api.registry.CompostableRegistry;
import net.lukasosstudios.mf.MoldovanFoods;

public class ModCompostables {
    public static void register() {
        CompostableRegistry.INSTANCE.add(ModItems.MARAR, 0.65f);
        CompostableRegistry.INSTANCE.add(ModItems.MARAR_SEEDS, 0.30f);
        MoldovanFoods.LOGGER.info("Registering compostables for " + MoldovanFoods.MOD_ID);
    }
}
