package net.lukasosstudios.mf.registry;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.lukasosstudios.mf.MoldovanFoods;

public class ModItems {

    public static final Item CASTRON = register("castron", Item.Properties::new);
    public static final Item PACHET = register("pachet", Item.Properties::new);
    public static final Item PACHET_DE_PELIMENE = register("pachet_de_pelimene", Item.Properties::new);
    public static final Item ALUAT = register("aluat", Item.Properties::new);
    public static final Item DROJDIE = register("drojdie", Item.Properties::new);
    public static final Item SARE = register("sare", Item.Properties::new);
    public static final Item MARAR = register("marar", Item.Properties::new);
    public static final Item LAVAS = register("lavas", Item.Properties::new);

    public static final Item KEBAB = register("kebab", () -> new Item.Properties()
            .food(new FoodProperties.Builder()
                    .nutrition(4)
                    .saturationModifier(0.6f)
                    .build()));

    public static final Item BORS = register("bors", () -> new Item.Properties()
            .stacksTo(1)
            .food(new FoodProperties.Builder()
                    .nutrition(3)
                    .saturationModifier(0.3f)
                    .build()));

    public static final Item ZACUSCA = register("zacusca", () -> new Item.Properties()
            .food(new FoodProperties.Builder()
                    .nutrition(5)
                    .saturationModifier(0.6f)
                    .build()));

    public static final Item PAINE_CU_ZACUSCA = register("paine_cu_zacusca", () -> new Item.Properties()
            .food(new FoodProperties.Builder()
                    .nutrition(6)
                    .saturationModifier(0.7f)
                    .build()));

    public static final Item CASTRON_DE_PELIMENE = register("castron_de_pelimene", () -> new Item.Properties()
            .stacksTo(1)
            .food(new FoodProperties.Builder()
                    .nutrition(6)
                    .saturationModifier(0.8f)
                    .build()));

    public static final Item PAINE_DE_BURGER = register("paine_de_burger", () -> new Item.Properties()
            .food(new FoodProperties.Builder()
                    .nutrition(5)
                    .saturationModifier(0.6f)
                    .build()));

    public static final Item BURGER = register("burger", () -> new Item.Properties()
            .food(new FoodProperties.Builder()
                    .nutrition(9)
                    .saturationModifier(0.9f)
                    .build()));

    public static final Item CASCAVAL = register("cascaval", () -> new Item.Properties()
            .food(new FoodProperties.Builder()
                    .nutrition(5)
                    .saturationModifier(0.4f)
                    .build()));

    public static final Item MARAR_SEEDS = registerBlockItem("marar_seeds", ModBlocks.MARAR_CROP);

    public static final Item SALT_ORE = registerBlockItem("salt_ore", ModBlocks.SALT_ORE);
    public static final Item DEEPSLATE_SALT_ORE = registerBlockItem("deepslate_salt_ore", ModBlocks.DEEPSLATE_SALT_ORE);

    private static Item register(String path, java.util.function.Supplier<Item.Properties> propertiesSupplier) {
        ResourceKey<Item> key = ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MoldovanFoods.MOD_ID, path));
        Item item = new Item(propertiesSupplier.get().setId(key));
        return Registry.register(BuiltInRegistries.ITEM, key, item);
    }

    private static Item registerBlockItem(String path, net.minecraft.world.level.block.Block block) {
        ResourceKey<Item> key = ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MoldovanFoods.MOD_ID, path));
        Item item = new BlockItem(block, new Item.Properties().setId(key));
        return Registry.register(BuiltInRegistries.ITEM, key, item);
    }

    public static void register() {
        MoldovanFoods.LOGGER.info("Registering items for " + MoldovanFoods.MOD_ID);
    }
}
