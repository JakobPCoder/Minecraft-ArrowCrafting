package jak0bw.arrowcrafting.item;

import jak0bw.arrowcrafting.entity.CustomArrowEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.ArrowItem;
import net.minecraft.item.SwordItem;

import net.minecraft.item.Item;
import net.minecraft.item.TridentItem;

import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.util.Formatting;
import net.minecraft.text.Text;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Position;
import net.minecraft.world.World;

import java.util.List;

import org.jetbrains.annotations.Nullable;


/**
 * Custom Arrow Item
 * 
 * This class extends the ArrowItem class and adds a damage multiplier to the arrow.
 * It also spawns a CustomArrowEntity instead of a regular ArrowEntity, that uses the arrowDamageMultiplier to calculate its damage.
 * 
 * @author jak0bw
 */
public class CustomArrowItem extends ArrowItem {

    private double arrowDamageMultiplier;

    public CustomArrowItem(Item.Settings settings, double arrowDamageMultiplier) {
        super(settings);
        this.arrowDamageMultiplier = arrowDamageMultiplier;
    }
    
    @Override
    public PersistentProjectileEntity createArrow(World world, ItemStack stack, LivingEntity shooter, @Nullable ItemStack shotFrom) {
        return new CustomArrowEntity(this.arrowDamageMultiplier, world, shooter, stack.copyWithCount(1), shotFrom);
    }

    @Override
    public ProjectileEntity createEntity(World world, Position pos, ItemStack stack, Direction direction) {
        CustomArrowEntity arrowEntity = new CustomArrowEntity(this.arrowDamageMultiplier, world, pos.getX(), pos.getY(), pos.getZ(), stack.copyWithCount(1), null);
        arrowEntity.pickupType = PersistentProjectileEntity.PickupPermission.ALLOWED;
        return arrowEntity;
    }
    
    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.translatable("item.arrowcrafting.arrow.damage", (int)(100 * this.arrowDamageMultiplier) + "%")
            .formatted(Formatting.BLUE, Formatting.ITALIC));
    }
} 