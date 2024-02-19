package cn.gtcommunity.epimorphism.api.transfer.item;

import com.lowdragmc.lowdraglib.misc.ItemStackTransfer;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class LockableItemStackTransfer extends ItemStackTransfer {
    private byte[] lock;

    public LockableItemStackTransfer(int size) {
        super(size);
        this.lock = new byte[size];
    }

    @Override
    public boolean isItemValid(int slot, @NotNull ItemStack stack) {
        return !isLock(slot) && super.isItemValid(slot, stack);
    }

    @Override
    public CompoundTag serializeNBT() {
        var tag = super.serializeNBT();
        tag.putByteArray("Lock", lock);
        return tag;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        super.deserializeNBT(nbt);
        if (nbt.contains("Lock", Tag.TAG_BYTE_ARRAY)) {
            this.lock = nbt.getByteArray("Lock");
        }
    }

    public void setLock(int slot, boolean isLock) {
        if (slot >= 0 && slot < lock.length) {
            this.lock[slot] = (byte) (isLock ? 1 : 0);
            onContentsChanged(slot);
        }
    }

    public boolean isLock(int slot) {
        if (slot >= 0 && slot < lock.length) {
            return this.lock[slot] == 1;
        }
        return false;
    }
}
