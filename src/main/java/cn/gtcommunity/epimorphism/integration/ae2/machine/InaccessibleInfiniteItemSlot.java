package cn.gtcommunity.epimorphism.integration.ae2.machine;

import appeng.api.config.Actionable;
import appeng.api.networking.security.IActionSource;
import appeng.api.stacks.GenericStack;
import appeng.helpers.externalstorage.GenericStackInv;
import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.machine.MetaMachine;
import com.gregtechceu.gtceu.api.machine.trait.NotifiableItemStackHandler;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;
import com.gregtechceu.gtceu.integration.ae2.machine.MEBusPartMachine;
import com.lowdragmc.lowdraglib.misc.ItemStackTransfer;
import com.lowdragmc.lowdraglib.side.item.IItemTransfer;
import com.lowdragmc.lowdraglib.syncdata.field.ManagedFieldHolder;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class InaccessibleInfiniteItemSlot extends NotifiableItemStackHandler implements IItemTransfer {
    protected static final ManagedFieldHolder MANAGED_FIELD_HOLDER = new ManagedFieldHolder(InaccessibleInfiniteItemSlot.class);

    private final GenericStackInv internalBuffer;

    public InaccessibleInfiniteItemSlot(MetaMachine holder, GenericStackInv internalBuffer) {
        super(holder, internalBuffer.size(), IO.OUT);
        this.internalBuffer = internalBuffer;
    }

    @Override
    public void setStackInSlot(int slot, @NotNull ItemStack stack) {
        GenericStack stack1 = GenericStack.fromItemStack(stack);
        this.internalBuffer.insert(slot, stack1.what(), stack1.amount(), Actionable.MODULATE);
        this.machine.onChanged();
    }

    @Override
    public List<Ingredient> handleRecipeInner(IO io, GTRecipe recipe, List<Ingredient> left, @Nullable String slotName, boolean simulate) {
        return handleIngredient(io, recipe, left, simulate, this.handlerIO, new ItemStackTransfer(16) {
            @NotNull
            @Override
            public ItemStack insertItem(int slot, @NotNull ItemStack stack, boolean simulate, boolean notifyChanges) {
                return InaccessibleInfiniteItemSlot.this.insertItem(slot, stack, simulate, notifyChanges);
            }
        });
    }

    @NotNull
    @Override
    public ItemStack insertItem(int slot, @NotNull ItemStack stack, boolean simulate, boolean notifyChanges) {
        if (stack.isEmpty()) {
            return ItemStack.EMPTY;
        }
        if (!simulate) {
            GenericStack stack1 = GenericStack.fromItemStack(stack);
            this.internalBuffer.insert(stack1.what(), stack1.amount(), Actionable.MODULATE, this.machine instanceof MEPartMachine host ? host.actionSource : IActionSource.empty());
            this.machine.onChanged();
        }
        return ItemStack.EMPTY;
    }

    @Override
    public int getSlots() {
        return 1;
    }

    @NotNull
    @Override
    public ItemStack getStackInSlot(int slot) {
        return ItemStack.EMPTY;
    }

    @NotNull
    @Override
    public ItemStack extractItem(int slot, int amount, boolean simulate, boolean notifyChanges) {
        return ItemStack.EMPTY;
    }

    @Override
    public int getSlotLimit(int slot) {
        return Integer.MAX_VALUE - 1;
    }

    @Override
    public boolean isItemValid(int slot, @NotNull ItemStack stack) {
        return false;
    }

    @NotNull
    @Override
    public Object createSnapshot() {
        GenericStack[] stacks = new GenericStack[this.internalBuffer.size()];
        for (int i = 0; i < this.internalBuffer.size(); ++i) {
            stacks[i] = this.internalBuffer.getStack(i);
        }
        return stacks;
    }

    @Override
    public void restoreFromSnapshot(Object snapshot) {
        if (snapshot instanceof GenericStack[] stacks) {
            this.internalBuffer.beginBatch();
            for (int i = 0; i < stacks.length; ++i) {
                GenericStack stack = stacks[i];
                if (stack == null) continue;
                this.internalBuffer.insert(i, stack.what(), stack.amount(), Actionable.MODULATE);
            }
            this.internalBuffer.endBatch();
        }
    }

    @Override
    public ManagedFieldHolder getFieldHolder() {
        return MANAGED_FIELD_HOLDER;
    }
}
