package net.lukasosstudios.mf.registry;

import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.lukasosstudios.mf.MoldovanFoods;

public class ModItemGroups {

    public static final ResourceKey<CreativeModeTab> MOLDOVAN_FOODS_TAB_KEY = ResourceKey.create(
            BuiltInRegistries.CREATIVE_MODE_TAB.key(),
            Identifier.fromNamespaceAndPath(MoldovanFoods.MOD_ID, "moldovan_foods")
    );

    public static final CreativeModeTab MOLDOVAN_FOODS_TAB = FabricCreativeModeTab.builder()
            .icon(() -> new ItemStack(ModItems.KEBAB))
            .title(Component.translatable("itemGroup.mf.main"))
            .displayItems((params, output) -> {
                output.accept(ModItems.KEBAB);
                output.accept(ModItems.BORS);
                output.accept(ModItems.ZACUSCA);
                output.accept(ModItems.PAINE_CU_ZACUSCA);
                output.accept(ModItems.CASTRON_DE_PELIMENE);
                output.accept(ModItems.BURGER_BUN);
                output.accept(ModItems.BURGER);
                output.accept(ModItems.CHEESE);
                output.accept(ModItems.CASTRON);
                output.accept(ModItems.PACHET);
                output.accept(ModItems.PACHET_DE_PELIMENE);
                output.accept(ModItems.ALUAT);
                output.accept(ModItems.DROJDIE);
                output.accept(ModItems.LAVAS);
                output.accept(ModItems.SARE);
                output.accept(ModItems.MARAR);
                output.accept(ModItems.MARAR_SEEDS);
                output.accept(ModItems.SALT_ORE);
                output.accept(ModItems.DEEPSLATE_SALT_ORE);
            })
            .build();

    public static void register() {
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, MOLDOVAN_FOODS_TAB_KEY, MOLDOVAN_FOODS_TAB);
        MoldovanFoods.LOGGER.info("Registering item groups for " + MoldovanFoods.MOD_ID);
    }
}
