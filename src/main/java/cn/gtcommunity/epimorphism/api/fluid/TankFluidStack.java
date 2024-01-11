package cn.gtcommunity.epimorphism.api.fluid;

import com.lowdragmc.lowdraglib.side.fluid.FluidHelper;
import com.lowdragmc.lowdraglib.side.fluid.FluidStack;
import lombok.Getter;
import lombok.Setter;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;

import javax.annotation.Nonnull;
import java.math.BigInteger;
import java.util.Objects;

public class TankFluidStack {
    public static TankFluidStack empty() {
        return EMPTY;
    }

    public static TankFluidStack create(Fluid fluid, BigInteger amount, CompoundTag nbt) {
        return new TankFluidStack(fluid, amount, nbt);
    }

    public static TankFluidStack create(Fluid fluid, BigInteger amount) {
        return create(fluid, amount, null);
    }

    public static TankFluidStack create(FluidStack stack, BigInteger amount) {
        return create(stack.getFluid(), amount, stack.getTag());
    }

    public static TankFluidStack create(TankFluidStack stack, BigInteger amount) {
        return create(stack.getFluid(), amount, stack.getTag());
    }

    private static final TankFluidStack EMPTY = new TankFluidStack(Fluids.EMPTY, BigInteger.ZERO, null);
    private boolean isEmpty;
    private BigInteger amount;
    @Getter
    private CompoundTag tag;
    @Setter
    private Fluid fluid;

    private TankFluidStack(Fluid fluid, BigInteger amount, CompoundTag nbt) {
        this.fluid = fluid;
        this.amount = amount;
        if (nbt != null) {
            tag = nbt.copy();
        }
        updateEmpty();

    }

    public static TankFluidStack loadFromTag(CompoundTag nbt) {
        if (nbt == null) {
            return EMPTY;
        }
        if (!nbt.contains("FluidName", Tag.TAG_STRING)) {
            return EMPTY;
        }

        ResourceLocation fluidName = new ResourceLocation(nbt.getString("FluidName"));
        Fluid fluid = BuiltInRegistries.FLUID.get(fluidName);
        if (fluid == Fluids.EMPTY) {
            return EMPTY;
        }
        var stack = TankFluidStack.create(fluid, new BigInteger(nbt.getString("Amount")));

        if (nbt.contains("Tag", Tag.TAG_COMPOUND)) {
            stack.setTag(nbt.getCompound("Tag"));
        }
        return stack;
    }

    public static TankFluidStack readFromBuf(FriendlyByteBuf buf) {
        Fluid fluid = BuiltInRegistries.FLUID.get(new ResourceLocation(buf.readUtf()));
        BigInteger amount = new BigInteger(buf.readUtf());
        CompoundTag tag = buf.readNbt();
        if (fluid == Fluids.EMPTY) return EMPTY;
        return TankFluidStack.create(fluid, amount, tag);
    }

    protected void updateEmpty() {
        isEmpty = getRawFluid() == Fluids.EMPTY || amount.compareTo(BigInteger.ZERO) <= 0;
    }

    public CompoundTag saveToTag(CompoundTag nbt) {
        nbt.putString("FluidName", BuiltInRegistries.FLUID.getKey(fluid).toString());
        nbt.putString("Amount", amount.toString());

        if (tag != null) {
            nbt.put("Tag", tag);
        }
        return nbt;
    }

    public void writeToBuf(FriendlyByteBuf buf) {
        buf.writeUtf(BuiltInRegistries.FLUID.getKey(fluid).toString());
        buf.writeUtf(getAmount().toString());
        buf.writeNbt(tag);
    }

    public Fluid getFluid() {
        return isEmpty ? Fluids.EMPTY : fluid;
    }

    public final Fluid getRawFluid() {
        return fluid;
    }

    public BigInteger getAmount() {
        return isEmpty ? BigInteger.ZERO : amount;
    }

    public void setAmount(BigInteger amount) {
        if (fluid == Fluids.EMPTY) throw new IllegalStateException("Can't modify the empty stack.");
        this.amount = amount;
        updateEmpty();
    }

    public boolean hasTag() {
        return tag != null;
    }

    public void setTag(CompoundTag tag) {
        if (getRawFluid() == Fluids.EMPTY) throw new IllegalStateException("Can't modify the empty stack.");
        this.tag = tag;
    }

    public boolean isEmpty() {
        return getAmount().equals(BigInteger.ZERO) || this == empty();
    }

    public Component getDisplayName() {
        return FluidHelper.getDisplayName(FluidStack.create(getFluid(), 1));
    }

    public TankFluidStack copy() {
        return create(getFluid(), getAmount(), getTag());
    }

    public TankFluidStack copy(BigInteger amount) {
        return create(getFluid(), amount, getTag());
    }

    public boolean isFluidEqual(@Nonnull FluidStack other) {
        return getFluid() == other.getFluid() && Objects.equals(getTag(), other.getTag());
    }

    public boolean isFluidEqual(@Nonnull TankFluidStack other) {
        return getFluid() == other.getFluid() && Objects.equals(getTag(), other.getTag());
    }

    public boolean isFluidStackEqual(@Nonnull FluidStack other) {
        return isFluidEqual(other) && getAmount().equals(BigInteger.valueOf(other.getAmount()));
    }

    public boolean isFluidStackEqual(@Nonnull TankFluidStack other) {
        return isFluidEqual(other) && getAmount().equals(other.getAmount());
    }

    public void grow(BigInteger amount) {
        setAmount(this.getAmount().add(amount));
    }

    public void shrink(BigInteger amount) {
        setAmount(this.getAmount().subtract(amount));
    }
}
