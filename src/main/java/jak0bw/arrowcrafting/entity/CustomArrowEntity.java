package jak0bw.arrowcrafting.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import net.minecraft.client.render.entity.ArrowEntityRenderer;

/**
 * Custom Arrow Entity
 * 
 * This class extends the ArrowEntity class and adds a damage multiplier to the arrow.
 * 
 * @author jak0bw
 */
public class CustomArrowEntity extends ArrowEntity { 

    private double arrow_base_damage = 2.0;
    private double arrowDamageMultiplier;



    public CustomArrowEntity(EntityType<? extends ArrowEntity> entityType, World world) {
        super(entityType, world);
        this.arrowDamageMultiplier = 1.0;
        System.out.println("CustomArrowEntity Base constructor 1 called");
     }
  
    public CustomArrowEntity(World world, double x, double y, double z, ItemStack stack, @Nullable ItemStack shotFrom) {
        super(world, x, y, z, stack, shotFrom);
        this.arrowDamageMultiplier = 1.0;
        this.setPosition(x, y, z); 
        this.setStack(stack.copy());
        // // Apply steel damage multiplier to the base damage
        this.setDamage(this.arrow_base_damage * this.arrowDamageMultiplier);
        System.out.println("CustomArrowEntity Base constructor 2 called");
    }

    public CustomArrowEntity(World world, LivingEntity owner, ItemStack stack, @Nullable ItemStack shotFrom) {
        super(world, owner, stack, shotFrom);
        this.arrowDamageMultiplier = 1.0;
        this.setOwner(owner);
        this.setPosition(owner.getX(), owner.getEyeY() - 0.1F, owner.getZ());
        this.setStack(stack.copy());
        // // Apply steel damage multiplier to the base damage
        this.setDamage(this.arrow_base_damage * this.arrowDamageMultiplier);
        System.out.println("CustomArrowEntity Base constructor 3 called");
    }



    
    public CustomArrowEntity(double arrowDamageMultiplier, EntityType<? extends ArrowEntity> entityType, World world) {
        super(entityType, world);
        this.arrowDamageMultiplier = arrowDamageMultiplier;
        System.out.println("CustomArrowEntity constructor 1 called");
     }

    public CustomArrowEntity(double arrowDamageMultiplier, World world, double x, double y, double z, ItemStack stack, @Nullable ItemStack shotFrom) {
        super(world, x, y, z, stack, shotFrom);
        this.arrowDamageMultiplier = arrowDamageMultiplier;
        this.setPosition(x, y, z); 
        this.setStack(stack.copy());
        // // Apply steel damage multiplier to the base damage
        this.setDamage(this.arrow_base_damage * this.arrowDamageMultiplier);
        System.out.println("CustomArrowEntity constructor 2 called");
    }

    public CustomArrowEntity(double arrowDamageMultiplier, World world, LivingEntity owner, ItemStack stack, @Nullable ItemStack shotFrom) {
        super(world, owner, stack, shotFrom);
        this.arrowDamageMultiplier = arrowDamageMultiplier;
        this.setOwner(owner);
        this.setPosition(owner.getX(), owner.getEyeY() - 0.1F, owner.getZ());
        this.setStack(stack.copy());
        // // Apply steel damage multiplier to the base damage
        this.setDamage(this.arrow_base_damage * this.arrowDamageMultiplier);
        System.out.println("CustomArrowEntity constructor 3 called");
    }   
} 