package cn.gtcommunity.epimorphism.common.item.fabric;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.capability.GTCapabilityHelper;
import com.gregtechceu.gtceu.api.item.ComponentItem;
import com.gregtechceu.gtceu.api.item.fabric.ComponentItemImpl;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class VajraItemImpl extends ComponentItemImpl {
    private static final long DESTROY_ENERGY = 3000L;
    private VajraItemImpl(Properties properties) {
        super(properties);
    }

    public static ComponentItem create(Item.Properties properties) {
        return new VajraItemImpl(properties);
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        var electricItem = GTCapabilityHelper.getElectricItem(stack);
        if (electricItem != null) {
            electricItem.discharge(DESTROY_ENERGY, GTValues.UV, true, false, false);
        }
        return true;
    }

    @Override
    public boolean isCorrectToolForDrops(BlockState block) {
        return true;
    }

    @Override
    public float getDestroySpeed(ItemStack stack, BlockState state) {
        return 0;
    }

    @Override
    public boolean isEnchantable(ItemStack stack) {
        return false;
    }

    public static boolean canDestroyBlock(ItemStack stack) {
        var electricItem = GTCapabilityHelper.getElectricItem(stack);
        if (electricItem != null) {
            return electricItem.discharge(DESTROY_ENERGY, GTValues.UV, true, false, true) >= DESTROY_ENERGY;
        }
        return false;
    }

    public static void discharge(ItemStack stack) {
        var electricItem = GTCapabilityHelper.getElectricItem(stack);
        if (electricItem != null) {
            electricItem.discharge(DESTROY_ENERGY, GTValues.UV, true, false, false);
        }
    }
}
