package cn.gtcommunity.epimorphism.integration.ae2.machine;

import appeng.api.stacks.AEFluidKey;
import appeng.api.stacks.AEItemKey;
import appeng.api.stacks.GenericStack;
import com.lowdragmc.lowdraglib.side.fluid.FluidStack;
import it.unimi.dsi.fastutil.ints.IntArrayList;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public class AEUtils {

    @Nullable
    public static GenericStack fromFluidStack(FluidStack stack) {
        if (stack == null || stack.isEmpty()) return null;
        var key = AEFluidKey.of(stack.getFluid(), stack.getTag());
        return new GenericStack(key, stack.getAmount());
    }

    public static FluidStack toFluidStack(AEFluidKey key, long amount) {
        return FluidStack.create(key.getFluid(), amount, key.getTag());
    }

    public static ItemStack[] toItemStack(AEItemKey key, long amount) {
        var ints = split(amount);
        var itemStacks = new ItemStack[ints.length];
        for (int i = 0; i < ints.length; i++) {
            itemStacks[i] = key.toStack(ints[i]);
        }
        return itemStacks;
    }

    public static int[] split(long value) {
        IntArrayList result = new IntArrayList();
        while (value > 0) {
            int intValue = (int) Math.min(value, Integer.MAX_VALUE);
            result.add(intValue);
            value -= intValue;
        }
        return result.toIntArray();
    }

    public static boolean matches(AEFluidKey key, FluidStack stack) {
        return !stack.isEmpty() && key.getFluid().isSame(stack.getFluid()) && Objects.equals(key.getTag(), stack.getTag());
    }

}
