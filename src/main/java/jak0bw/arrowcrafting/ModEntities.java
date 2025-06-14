package jak0bw.arrowcrafting;

import jak0bw.arrowcrafting.entity.CustomArrowEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

/**
 * Handles registration of custom entities for the SteelCrafting mod.
 */
public class ModEntities {
    
    /**
     * Custom Arrow Entity Type - extends ArrowEntity with increased damage
     */
    public static final EntityType<CustomArrowEntity> CUSTOM_ARROW = Registry.register(
        Registries.ENTITY_TYPE,
        Identifier.of(ArrowCrafting.MOD_ID, "custom_arrow"),
        EntityType.Builder.<CustomArrowEntity>create(CustomArrowEntity::new, SpawnGroup.MISC)
            .dimensions(0.5f, 0.5f)
            .maxTrackingRange(4)
            .trackingTickInterval(20)
            .build(RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(ArrowCrafting.MOD_ID, "custom_arrow")))
    );
    
    /**
     * Registers all mod entities.
     * Should be called during mod initialization.
     */
    public static void registerModEntities() {
        ArrowCrafting.LOGGER.info("Registering Mod Entities for " + ArrowCrafting.MOD_ID);
    }
} 