package jak0bw.arrowcrafting;

import jak0bw.arrowcrafting.item.CustomArrowHeadItem;
import jak0bw.arrowcrafting.item.CustomArrowItem;


import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import net.minecraft.item.ItemGroups;

/**
 * Handles registration and creative tab assignment for all SteelCrafting mod items.
 */
public class ModItems {
    // Holds all group addEntry actions to be performed at mod item registration
    private static List<Runnable> groupAddEntryActions = new ArrayList<>();

    /**
     * Registers an item with optional mod dependencies and creative tab groups.
     * Delays the registration of the item until the mod is fully initialized,
     * by adding it to a list of actions to be performed at mod item registration.
     *
     * @param name The name of the item to register.
     * @param factory A function that creates the item from the given Item.Settings.
     * @param settings The settings to use for the item.
     * @param groups The creative tab groups to which the item should be added.
     * @param dependencies Optional mod IDs that must be loaded for this item to be registered.
     * @return The registered Item, or null if any dependency is missing.
     */
    private static Item registerItem(String name, Function<Item.Settings, Item> factory, 
                                   Item.Settings settings, List<RegistryKey<ItemGroup>> groups, String... dependencies) {
        // Check dependencies
        if (java.util.Arrays.stream(dependencies).anyMatch(modId -> !FabricLoader.getInstance().isModLoaded(modId))) return null;
        // Register item
        Item item = Items.register(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(ArrowCrafting.MOD_ID, name)), factory, settings);
        // Registers the item in the game's item registry under the mod's namespace.
        if (groups != null) groups.forEach(group -> 
            groupAddEntryActions.add(() -> ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item))));
        return item;
    }


    // Wooden Arrow Head item
    public static final Item WOODEN_ARROW_HEAD = registerItem(
        "wooden_arrow_head",
        settings -> new CustomArrowHeadItem(settings),
        new Item.Settings(),
        List.of(ItemGroups.INGREDIENTS)
    );

    // Stone Arrow Head item (generic)
    public static final Item STONE_ARROW_HEAD = registerItem(
        "stone_arrow_head",
        settings -> new CustomArrowHeadItem(settings),
        new Item.Settings(),
        List.of(ItemGroups.INGREDIENTS)
    );


    // Flint Arrow Head item (generic)
    public static final Item FLINT_ARROW_HEAD = registerItem(
        "flint_arrow_head",
        settings -> new CustomArrowHeadItem(settings),
        new Item.Settings(),
        List.of(ItemGroups.INGREDIENTS)
    );

    // Gold Arrow Head item
    public static final Item GOLD_ARROW_HEAD = registerItem(
        "gold_arrow_head",
        settings -> new CustomArrowHeadItem(settings),
        new Item.Settings(),
        List.of(ItemGroups.INGREDIENTS)
    );

    // Copper Arrow Head item
    public static final Item COPPER_ARROW_HEAD = registerItem(
        "copper_arrow_head",
        settings -> new CustomArrowHeadItem(settings),
        new Item.Settings(),
        List.of(ItemGroups.INGREDIENTS)
    );

    // Iron Arrow Head item (generic)
    public static final Item IRON_ARROW_HEAD = registerItem(
        "iron_arrow_head",
        settings -> new CustomArrowHeadItem(settings),
        new Item.Settings(),
        List.of(ItemGroups.INGREDIENTS)
    );

    // Diamond Arrow Head item
    public static final Item DIAMOND_ARROW_HEAD = registerItem(
        "diamond_arrow_head",
        settings -> new CustomArrowHeadItem(settings),
        new Item.Settings(),
        List.of(ItemGroups.INGREDIENTS)
    );

    // Netherite Arrow Head item
    public static final Item NETHERITE_ARROW_HEAD = registerItem(
        "netherite_arrow_head",
        settings -> new CustomArrowHeadItem(settings),
        new Item.Settings(),
        List.of(ItemGroups.INGREDIENTS)
    );


    // Wooden Arrow item
    public static final Item WOODEN_ARROW = registerItem(
        "wooden_arrow",
        settings -> new CustomArrowItem(settings, 0.4),
        new Item.Settings(),
        List.of(ItemGroups.COMBAT)
    );

    // Stone Arrow item (generic)
    public static final Item STONE_ARROW = registerItem(
        "stone_arrow",
        settings -> new CustomArrowItem(settings, 0.7),
        new Item.Settings(),
        List.of(ItemGroups.COMBAT)
    );

    // Flint Arrow item (generic)
    public static final Item FLINT_ARROW = registerItem(
        "flint_arrow",
        settings -> new CustomArrowItem(settings, 1.0),
        new Item.Settings(),
        List.of(ItemGroups.COMBAT)
    );

    // Gold Arrow item
    public static final Item GOLD_ARROW = registerItem(
        "gold_arrow",
        settings -> new CustomArrowItem(settings, 1.0),
        new Item.Settings(),
        List.of(ItemGroups.COMBAT)
    );

    // Copper Arrow item
    public static final Item COPPER_ARROW = registerItem(
        "copper_arrow",
        settings -> new CustomArrowItem(settings, 1.2),
        new Item.Settings(),
        List.of(ItemGroups.COMBAT)
    );

    // Iron Arrow item (generic)
    public static final Item IRON_ARROW = registerItem(
        "iron_arrow",
        settings -> new CustomArrowItem(settings, 1.4),
        new Item.Settings(),
        List.of(ItemGroups.COMBAT)
    );

    // Diamond Arrow item
    public static final Item DIAMOND_ARROW = registerItem(
        "diamond_arrow",
        settings -> new CustomArrowItem(settings, 1.6),
        new Item.Settings(),
        List.of(ItemGroups.COMBAT)
    );

    // Netherite Arrow item
    public static final Item NETHERITE_ARROW = registerItem(
        "netherite_arrow",
        settings -> new CustomArrowItem(settings, 2.0),
        new Item.Settings(),
        List.of(ItemGroups.COMBAT)
    );


    // Arrow Shaft item
    public static final Item ARROW_SHAFT = registerItem(
        "arrow_shaft",
        settings -> new Item(settings),
        new Item.Settings(),
        List.of(ItemGroups.INGREDIENTS)
    );

    // Arrow Fletching item
    public static final Item ARROW_FLETCHING = registerItem(
        "arrow_fletching",
        settings -> new Item(settings),
        new Item.Settings(),
        List.of(ItemGroups.INGREDIENTS)
    );


    public static void registerModItems() {
        ArrowCrafting.LOGGER.info("Adding Mod Items to creative tabs for " + ArrowCrafting.MOD_ID);
        for (Runnable action : groupAddEntryActions) {
            action.run();
        }
    }

} 