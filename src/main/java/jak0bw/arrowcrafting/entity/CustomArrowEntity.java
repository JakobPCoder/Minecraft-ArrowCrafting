package jak0bw.arrowcrafting.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;


/**
 * Custom Arrow Entity
 * 
 * This class extends the ArrowEntity class and adds a damage multiplier to the arrow.
 * 
 * @author jak0bw
 */
public class CustomArrowEntity extends ArrowEntity { 

    private double arrowDamageMultiplier;

    public CustomArrowEntity(EntityType<? extends ArrowEntity> entityType, World world) {
        super(entityType, world);
        this.arrowDamageMultiplier = 1.0;
     }
  
    public CustomArrowEntity(World world, double x, double y, double z, ItemStack stack, @Nullable ItemStack shotFrom) {
        super(world, x, y, z, stack, shotFrom);
        this.arrowDamageMultiplier = 1.0;
        this.setPosition(x, y, z); 
        this.setStack(stack.copy());
        // // Apply steel damage multiplier to the base damage
        this.setDamage(this.getDamage() * this.arrowDamageMultiplier);
    }

    public CustomArrowEntity(World world, LivingEntity owner, ItemStack stack, @Nullable ItemStack shotFrom) {
        super(world, owner, stack, shotFrom);
        this.arrowDamageMultiplier = 1.0;
        this.setOwner(owner);
        this.setPosition(owner.getX(), owner.getEyeY() - 0.1F, owner.getZ());
        this.setStack(stack.copy());
        // // Apply steel damage multiplier to the base damage
        this.setDamage(this.getDamage() * this.arrowDamageMultiplier);
    }

    public CustomArrowEntity(double arrowDamageMultiplier, EntityType<? extends ArrowEntity> entityType, World world) {
        super(entityType, world);
        this.arrowDamageMultiplier = arrowDamageMultiplier;
     }

    public CustomArrowEntity(double arrowDamageMultiplier, World world, double x, double y, double z, ItemStack stack, @Nullable ItemStack shotFrom) {
        super(world, x, y, z, stack, shotFrom);
        this.arrowDamageMultiplier = arrowDamageMultiplier;
        this.setPosition(x, y, z); 
        this.setStack(stack.copy());
        // // Apply steel damage multiplier to the base damage
        this.setDamage(this.getDamage() * this.arrowDamageMultiplier);
    }

    public CustomArrowEntity(double arrowDamageMultiplier, World world, LivingEntity owner, ItemStack stack, @Nullable ItemStack shotFrom) {
        super(world, owner, stack, shotFrom);
        this.arrowDamageMultiplier = arrowDamageMultiplier;
        this.setOwner(owner);
        this.setPosition(owner.getX(), owner.getEyeY() - 0.1F, owner.getZ());
        this.setStack(stack.copy());
        // // Apply steel damage multiplier to the base damage
        this.setDamage(this.getDamage() * this.arrowDamageMultiplier);
    }   
} 