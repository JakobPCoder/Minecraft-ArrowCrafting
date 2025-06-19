package jak0bw.arrowcrafting;

import jak0bw.arrowcrafting.item.CustomArrowHeadItem;
import jak0bw.arrowcrafting.item.CustomArrowItem;


import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;
import net.minecraft.item.ItemGroups;

/**
 * Handles registration and creative tab assignment for all SteelCrafting mod items.
 */
public class ModItems {

    /**
     * Registers an item with the given name, factory, and settings.
     *
     * @param name     Path part of the identifier (e.g., "steel_ingot")
     * @param factory  Function to create the item from settings
     * @param settings Item settings
     * @return The registered Item
     */
    private static Item registerItem(String name, Function<Item.Settings, Item> factory, Item.Settings settings, String... dependencies) {
        for (String modId : dependencies) {
            if (!FabricLoader.getInstance().isModLoaded(modId)) {
                return null; 
            }
        }
    
        Identifier id = Identifier.of(ArrowCrafting.MOD_ID, name);
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, id);
        return Items.register(key, factory, settings);
    }


    
    // Wooden Arrow Head item
    public static final Item WOODEN_ARROW_HEAD = registerItem(
        "wooden_arrow_head",
        settings -> new CustomArrowHeadItem(settings),
        new Item.Settings()
    );

    // Stone Arrow Head item (generic)
    public static final Item STONE_ARROW_HEAD = registerItem(
        "stone_arrow_head",
        settings -> new CustomArrowHeadItem(settings),
        new Item.Settings()
    );


    // Flint Arrow Head item (generic)
    public static final Item FLINT_ARROW_HEAD = registerItem(
        "flint_arrow_head",
        settings -> new CustomArrowHeadItem(settings),
        new Item.Settings()
    );

    // Gold Arrow Head item
    public static final Item GOLD_ARROW_HEAD = registerItem(
        "gold_arrow_head",
        settings -> new CustomArrowHeadItem(settings),
        new Item.Settings()
    );

    // Copper Arrow Head item
    public static final Item COPPER_ARROW_HEAD = registerItem(
        "copper_arrow_head",
        settings -> new CustomArrowHeadItem(settings),
        new Item.Settings(),
        "coppercrafting"
    );

    // Iron Arrow Head item (generic)
    public static final Item IRON_ARROW_HEAD = registerItem(
        "iron_arrow_head",
        settings -> new CustomArrowHeadItem(settings),
        new Item.Settings()
    );

    // Steel Arrow Head item
    public static final Item STEEL_ARROW_HEAD = registerItem(
        "steel_arrow_head",
        settings -> new CustomArrowHeadItem(settings),
        new Item.Settings(),
        "steelcrafting"
    );

    // Diamond Arrow Head item
    public static final Item DIAMOND_ARROW_HEAD = registerItem(
        "diamond_arrow_head",
        settings -> new CustomArrowHeadItem(settings),
        new Item.Settings()
    );



    // Wooden Arrow item
    public static final Item WOODEN_ARROW = registerItem(
        "wooden_arrow",
        settings -> new CustomArrowItem(settings, 0.4),
        new Item.Settings()
    );

    // Stone Arrow item (generic)
    public static final Item STONE_ARROW = registerItem(
        "stone_arrow",
        settings -> new CustomArrowItem(settings, 0.7),
        new Item.Settings()
    );

    // Flint Arrow item (generic)
    public static final Item FLINT_ARROW = registerItem(
        "flint_arrow",
        settings -> new CustomArrowItem(settings, 1.0),
        new Item.Settings()
    );

    // Gold Arrow item
    public static final Item GOLD_ARROW = registerItem(
        "gold_arrow",
        settings -> new CustomArrowItem(settings, 1.2),
        new Item.Settings()
    );

    // Copper Arrow item
    public static final Item COPPER_ARROW = registerItem(
        "copper_arrow",
        settings -> new CustomArrowItem(settings, 1.3),
        new Item.Settings(),
        "coppercrafting"
    );

    // Iron Arrow item (generic)
    public static final Item IRON_ARROW = registerItem(
        "iron_arrow",
        settings -> new CustomArrowItem(settings, 1.5),
        new Item.Settings()
    );

    // Steel Arrow item
    public static final Item STEEL_ARROW = registerItem(
        "steel_arrow",
        settings -> new CustomArrowItem(settings, 1.6),
        new Item.Settings(),
        "steelcrafting"
    );

    // Diamond Arrow item
    public static final Item DIAMOND_ARROW = registerItem(
        "diamond_arrow",
        settings -> new CustomArrowItem(settings, 2.0),
        new Item.Settings()
    );


    // Arrow Shaft item
    public static final Item ARROW_SHAFT = registerItem(
        "arrow_shaft",
        settings -> new Item(settings),
        new Item.Settings()
    );

    // Arrow Fletching item
    public static final Item ARROW_FLETCHING = registerItem(
        "arrow_fletching",
        settings -> new Item(settings),
        new Item.Settings()
    );


    // --- TAB-SPECIFIC REGISTRATION WRAPPERS ---

    // INGREDIENTS TAB

    private static void registerIngredientsTabItems() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(WOODEN_ARROW_HEAD);
            entries.add(STONE_ARROW_HEAD);
            entries.add(FLINT_ARROW_HEAD);
            entries.add(GOLD_ARROW_HEAD);
        });

        if (FabricLoader.getInstance().isModLoaded("coppercrafting")) 
            ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> { entries.add(COPPER_ARROW_HEAD); });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> { entries.add(IRON_ARROW_HEAD); });
        if (FabricLoader.getInstance().isModLoaded("steelcrafting")) 
            ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> { entries.add(STEEL_ARROW_HEAD); });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(DIAMOND_ARROW_HEAD);
            entries.add(ARROW_SHAFT);
            entries.add(ARROW_FLETCHING);
        });
    }


    private static void registerCombatTabItems() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries -> {
            entries.add(WOODEN_ARROW);
            entries.add(STONE_ARROW);
            entries.add(FLINT_ARROW);
            entries.add(GOLD_ARROW);
        });

        if (FabricLoader.getInstance().isModLoaded("coppercrafting")) 
            ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries -> { entries.add(COPPER_ARROW); });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries -> { entries.add(IRON_ARROW); });
        if (FabricLoader.getInstance().isModLoaded("steelcrafting")) 
            ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries -> { entries.add(STEEL_ARROW); });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries -> { entries.add(DIAMOND_ARROW); });
    }

    /**
     * Registers all mod items to their respective creative tabs.
     * Should be called during mod initialization.
     */
    public static void registerModItems() {
        ArrowCrafting.LOGGER.info("Adding Mod Items to creative tabs for " + ArrowCrafting.MOD_ID);
        registerIngredientsTabItems();
        registerCombatTabItems();
    }

} 