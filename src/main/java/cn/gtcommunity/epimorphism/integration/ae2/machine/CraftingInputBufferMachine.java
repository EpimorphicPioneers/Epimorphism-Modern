package cn.gtcommunity.epimorphism.integration.ae2.machine;

import appeng.api.crafting.IPatternDetails;
import appeng.api.crafting.PatternDetailsHelper;
import appeng.api.networking.crafting.ICraftingProvider;
import appeng.api.stacks.*;
import appeng.api.storage.MEStorage;
import appeng.api.storage.StorageHelper;
import appeng.crafting.pattern.EncodedPatternItem;
import appeng.crafting.pattern.ProcessingPatternItem;
import cn.gtcommunity.epimorphism.Epimorphism;
import cn.gtcommunity.epimorphism.api.gui.EPGuiTextures;
import com.epimorphismmc.monomorphism.utility.MONBTUtils;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.gregtechceu.gtceu.api.capability.recipe.FluidRecipeCapability;
import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.capability.recipe.ItemRecipeCapability;
import com.gregtechceu.gtceu.api.capability.recipe.RecipeCapability;
import com.gregtechceu.gtceu.api.gui.GuiTextures;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.trait.IRecipeHandlerTrait;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;
import com.gregtechceu.gtceu.api.recipe.ingredient.FluidIngredient;
import com.lowdragmc.lowdraglib.gui.widget.SlotWidget;
import com.lowdragmc.lowdraglib.gui.widget.Widget;
import com.lowdragmc.lowdraglib.gui.widget.WidgetGroup;
import com.lowdragmc.lowdraglib.misc.ItemStackTransfer;
import com.lowdragmc.lowdraglib.side.fluid.FluidStack;
import com.lowdragmc.lowdraglib.syncdata.IContentChangeAware;
import com.lowdragmc.lowdraglib.syncdata.ISubscription;
import com.lowdragmc.lowdraglib.syncdata.ITagSerializable;
import com.lowdragmc.lowdraglib.syncdata.annotation.Persisted;
import com.lowdragmc.lowdraglib.syncdata.field.ManagedFieldHolder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import lombok.Getter;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.TickTask;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import org.apache.commons.lang3.ArrayUtils;
import org.jetbrains.annotations.Nullable;

import java.util.*;
import java.util.stream.Collectors;

public class CraftingInputBufferMachine extends MEPartMachine implements ICraftingProvider {

    protected static final ManagedFieldHolder MANAGED_FIELD_HOLDER = new ManagedFieldHolder(CraftingInputBufferMachine.class, MEPartMachine.MANAGED_FIELD_HOLDER);

    private static final int MAX_PATTERN_COUNT = 4 * 9;

    @Getter
    @Persisted
    private final ItemStackTransfer patternInventory = new ItemStackTransfer(MAX_PATTERN_COUNT);
    @Persisted
    private final InternalSlot[] internalInventory = new InternalSlot[MAX_PATTERN_COUNT];
    private final BiMap<IPatternDetails, InternalSlot> patternDetailsPatternSlotMap = HashBiMap.create(MAX_PATTERN_COUNT);
    @Persisted
    private ResourceLocation lockedRecipeId;
    @Persisted
    private int lockedSlot;
    private boolean needPatternSync = true;

    public CraftingInputBufferMachine(IMachineBlockEntity holder, Object... args) {
        super(holder, IO.BOTH, args);
        this.patternInventory.setFilter(stack -> stack.getItem() instanceof ProcessingPatternItem);
        for (int i = 0; i < this.internalInventory.length; i++) {
            this.internalInventory[i] = new InternalSlot(null);
        }
        getMainNode().addService(ICraftingProvider.class, this);
    }

    @Override
    public void onLoad() {
        super.onLoad();
        if (getLevel() instanceof ServerLevel serverLevel) {
            serverLevel.getServer().tell(new TickTask(1, () -> {
                for (int i = 0; i < patternInventory.getSlots(); i++) {
                    var pattern = patternInventory.getStackInSlot(i);
                    var patternDetails = PatternDetailsHelper.decodePattern(pattern, getLevel());
                    if (patternDetails != null) {
                        this.patternDetailsPatternSlotMap.put(patternDetails, this.internalInventory[i]);
                    }
                }
            }));
        }
    }

    @Override
    protected void update() {
        super.update();
        if (needPatternSync) {
            ICraftingProvider.requestUpdate(getMainNode());
            this.needPatternSync = false;
        }
    }

//    protected void autoIO() {
//        if (getLevel().isClientSide) return;
//        if (!this.isWorkingEnabled()) return;
//        if (!this.shouldSyncME()) return;
//
//        if (this.updateMEStatus()) {
//            if (!this.internalBuffer.isEmpty()) {
//                MEStorage aeNetwork = this.getMainNode().getGrid().getStorageService().getInventory();
//                for (int slot = 0; slot < this.internalBuffer.size(); ++slot) {
//                    GenericStack item = this.internalBuffer.getStack(slot);
//                    if (item == null) continue;
//                    long inserted = aeNetwork.insert(item.what(), item.amount(), Actionable.MODULATE, this.actionSource);
//                    if (inserted > 0) {
//                        item = new GenericStack(item.what(), (item.amount() - inserted));
//                    }
//                    this.internalBuffer.setStack(slot, item);
//                }
//            }
//            this.updateTankSubscription();
//        }
//    }

//    @Override
//    protected void updateTankSubscription() {
//        if (isWorkingEnabled() && !internalBuffer.isEmpty() && this.getLevel() != null
//                && GridHelper.getNodeHost(getLevel(), getPos().relative(getFrontFacing())) != null) {
//            autoIOSubs = subscribeServerTick(autoIOSubs, this::autoIO);
//        } else if (autoIOSubs != null) {
//            autoIOSubs.unsubscribe();
//            autoIOSubs = null;
//        }
//    }

    public List<Ingredient> handleItemInner(GTRecipe recipe, List<Ingredient> left, boolean simulate) {
        if (recipe.id.equals(lockedRecipeId)) {
            return internalInventory[lockedSlot].handleItemInternal(left, simulate);
        } else {
            this.lockedRecipeId = recipe.id;
            List<Ingredient> contents = copyIngredients(left);
            for (int i = 0; i < internalInventory.length; i++) {
                contents = internalInventory[lockedSlot].handleItemInternal(contents, simulate);
                if (contents == null) {
                    this.lockedSlot = i;
                    return contents;
                }
                contents = copyIngredients(left);
            }
            this.lockedSlot = -1;
            return left;
        }
    }
// TODO 配方检测跳过空Slot
    public List<FluidIngredient> handleFluidInner(GTRecipe recipe, List<FluidIngredient> left, boolean simulate) {
        if (recipe.id.equals(lockedRecipeId) && lockedSlot >= 0) {
            return internalInventory[lockedSlot].handleFluidInternal(left, simulate);
        } else {
            this.lockedRecipeId = recipe.id;
            List<FluidIngredient> contents = copyFluidIngredients(left);
            for (int i = 0; i < internalInventory.length; i++) {
                contents = internalInventory[i].handleFluidInternal(contents, simulate);
                if (contents == null) {
                    this.lockedSlot = i;
                    return contents;
                }
                contents = copyFluidIngredients(left);
            }
            this.lockedSlot = -1;
            return left;
        }
    }

    private List<Ingredient> copyIngredients(List<Ingredient> ingredients) {
        List<Ingredient> result = new ObjectArrayList<>(ingredients.size());
        for (Ingredient ingredient : ingredients) {
            result.add(ItemRecipeCapability.CAP.copyInner(ingredient));
        }
        return result;
    }

    private List<FluidIngredient> copyFluidIngredients(List<FluidIngredient> ingredients) {
        List<FluidIngredient> result = new ObjectArrayList<>(ingredients.size());
        for (FluidIngredient ingredient : ingredients) {
            result.add(FluidRecipeCapability.CAP.copyInner(ingredient));
        }
        return result;
    }

    @Override
    public Widget createUIWidget() {
        int rowSize = 9;
        int colSize = 4;
        var group = new WidgetGroup(0, 0, 18 * rowSize + 16, 18 * colSize + 16);
        int index = 0;
        for(int y = 0; y < colSize; ++y) {
            for (int x = 0; x < rowSize; ++x) {
                int finalI = index;
                var slot = new SlotWidget(patternInventory, index++, 4 + x * 18, 4 + y * 18)
                        .setItemHook(stack -> {
                            if (!stack.isEmpty() && stack.getItem() instanceof EncodedPatternItem iep) {
                                final ItemStack out = iep.getOutput(stack);
                                if (!out.isEmpty()) {
                                    return out;
                                }
                            }
                            return stack;
                        })
                        .setChangeListener(() -> onPatternChange(finalI))
                        .setBackground(GuiTextures.SLOT, EPGuiTextures.PATTERN_OVERLAY);
                group.addWidget(slot);
            }
        }

        return group;
    }

    private void onPatternChange(int index) {
        if (isRemote()) return;

        // remove old if applicable
        var internalInv = internalInventory[index];
        var newPattern = patternInventory.getStackInSlot(index);
        var newPatternDetails = PatternDetailsHelper.decodePattern(newPattern, getLevel());
        var oldPatternDetails = patternDetailsPatternSlotMap.inverse().get(internalInv);
        patternDetailsPatternSlotMap.forcePut(newPatternDetails, internalInv);
        if (oldPatternDetails != null && !oldPatternDetails.equals(newPatternDetails)) {
            internalInv.refund();
        }

        needPatternSync = true;
    }

    @Override
    public List<IPatternDetails> getAvailablePatterns() {
        return patternDetailsPatternSlotMap.keySet().stream()
                .filter(Objects::nonNull)
                .toList();
    }

    @Override
    public boolean pushPattern(IPatternDetails patternDetails, KeyCounter[] inputHolder) {
        if (!getMainNode().isActive()
                || !patternDetailsPatternSlotMap.containsKey(patternDetails)
                || !checkInput(inputHolder)) {
            return false;
        }

        var slot = patternDetailsPatternSlotMap.get(patternDetails);
        if (slot != null) {
            slot.pushPattern(patternDetails, inputHolder);
            return true;
        }
        return false;
    }

    private boolean checkInput(KeyCounter[] inputHolder) {
        for (KeyCounter input : inputHolder) {
            var illegal = input.keySet().stream()
                    .map(AEKey::getType)
                    .map(AEKeyType::getId)
                    .anyMatch(id -> !id.equals(AEKeyType.items().getId()) && !id.equals(AEKeyType.fluids().getId()));
            if (illegal) return false;
        }
        return true;
    }

    @Override
    public boolean isBusy() {
        return false;
    }

    @Override
    public ManagedFieldHolder getFieldHolder() {
        return MANAGED_FIELD_HOLDER;
    }

    @Override
    public List<IRecipeHandlerTrait> getRecipeHandlers() {
        var handlers = new ArrayList<>(super.getRecipeHandlers());
        handlers.add(new ItemRecipeHandler());
        handlers.add(new FluidRecipeHandler());
        return handlers;
    }

    protected class InternalSlot implements ITagSerializable<CompoundTag>, IContentChangeAware {

        public interface SharedItemGetter {

            ItemStack[] getSharedItem();
        }

        private final List<ItemStack> itemInventory; //TODO 合并相同的Item
        private final List<FluidStack> fluidInventory; //TODO 合并相同的Fluid
        private final SharedItemGetter sharedItemGetter;

        public InternalSlot(SharedItemGetter getter) {
            this.itemInventory = new ArrayList<>();
            this.fluidInventory = new ArrayList<>();
            this.sharedItemGetter = getter;
        }

        private boolean isEmpty() {
            // if one item / fluid is empty then it should be safe to assume all other is empty,
            // or at least won't require a recipe check, as long as the pattern is sane
            if (!itemInventory.isEmpty()) {
                return itemInventory.get(0) == null || itemInventory.get(0).isEmpty();
            }

            if (!fluidInventory.isEmpty()) {
                return fluidInventory.get(0) == null || fluidInventory.get(0).isEmpty();
            }
            return true;
        }

        public ItemStack[] getItemInputs() {
//            if (isEmpty()) return new ItemStack[0];
            return ArrayUtils.addAll(itemInventory.toArray(new ItemStack[0])/*, sharedItemGetter.getSharedItem()*/);
        }

        public FluidStack[] getFluidInputs() {
//            if (isEmpty()) return new FluidStack[0];
            return fluidInventory.toArray(new FluidStack[0]);
        }

        public void refund() {
            var network = getMainNode().getGrid();
            if (network != null) {
                MEStorage networkInv = network.getStorageService().getInventory();
                var energy = network.getEnergyService();
                for (ItemStack stack : itemInventory) {
                    if (stack == null) continue;

                    var key = AEItemKey.of(stack);
                    if (key == null) continue;

                    long inserted = StorageHelper.poweredInsert(
                            energy, networkInv,
                            key, stack.getCount(),
                            actionSource);
                    if (inserted > 0) {
                        stack.shrink((int) inserted);
                    }
                }

                for (FluidStack stack : fluidInventory) {
                    if (stack == null || stack.isEmpty()) continue;

                    long inserted = StorageHelper.poweredInsert(
                            energy, networkInv,
                            AEFluidKey.of(stack.getFluid(), stack.getTag()),
                            stack.getAmount(), actionSource);
                    if (inserted > 0) {
                        stack.shrink(inserted);
                    }
                }
            }
        }

        public void pushPattern(IPatternDetails patternDetails, KeyCounter[] inputHolder) {
            patternDetails.pushInputsToExternalInventory(inputHolder, (what, amount) -> {
                if (what instanceof AEFluidKey key) {
                    fluidInventory.add(AEUtils.toFluidStack(key, amount));
                }

                if (what instanceof AEItemKey key) {
                    itemInventory.addAll(List.of(AEUtils.toItemStack(key, amount)));
                }
            });
        }

        List<Ingredient> handleItemInternal(List<Ingredient> left, boolean simulate) {
            Iterator<Ingredient> iterator = left.iterator();
            while (iterator.hasNext()) {
                Ingredient ingredient = iterator.next();
                SLOT_LOOKUP:
                for (ItemStack stack : itemInventory) {
                    if (ingredient.test(stack)) {
                        ItemStack[] ingredientStacks = ingredient.getItems();
                        for (ItemStack ingredientStack : ingredientStacks) {
                            if (ingredientStack.is(stack.getItem())) {
                                int extracted = Math.min(ingredientStack.getCount(), stack.getCount());
                                if (!simulate) {
                                    stack.shrink(extracted); // TODO 把空的ItemStack移除
                                }
                                ingredientStack.shrink(extracted);
                                if (ingredientStack.isEmpty()) {
                                    iterator.remove();
                                    break SLOT_LOOKUP;
                                }
                            }
                        }
                    }
                }
            }
            return left.isEmpty() ? null : left;
        }
        // TODO 是否要提前结束循环

        List<FluidIngredient> handleFluidInternal(List<FluidIngredient> left, boolean simulate) {
            Iterator<FluidIngredient> iterator = left.iterator();
            while (iterator.hasNext()) {
                FluidIngredient fluidStack = iterator.next();
                if (fluidStack.isEmpty()) {
                    iterator.remove();
                    continue;
                }
                boolean found = false;
                FluidStack foundStack = null;
                for (FluidStack stack : fluidInventory) {
                    if (!fluidStack.test(stack)) {
                        continue;
                    }
                    found = true;
                    foundStack = stack;
                }
                if (!found) continue;
                long drained = Math.min(foundStack.getAmount(), fluidStack.getAmount());
                if (!simulate) {
                    foundStack.shrink(drained); // TODO 把空的FluidStack移除
                }

                fluidStack.setAmount(fluidStack.getAmount() - drained);
                if (fluidStack.getAmount() <= 0) {
                    iterator.remove();
                }
            }
            return left.isEmpty() ? null : left;
        }

        @Override
        public void setOnContentsChanged(Runnable onContentChanged) {

        }

        @Override
        public Runnable getOnContentsChanged() {
            return () -> {};
        }

        @Override
        public CompoundTag serializeNBT() {
            CompoundTag tag = new CompoundTag();

            ListTag itemInventoryTag = new ListTag();
            for (ItemStack itemStack : this.itemInventory) {
                itemInventoryTag.add(MONBTUtils.writeItemStack(itemStack, new CompoundTag()));
            }
            tag.put("inventory", itemInventoryTag);

            ListTag fluidInventoryTag = new ListTag();
            for (FluidStack fluidStack : fluidInventory) {
                fluidInventoryTag.add(fluidStack.saveToTag(new CompoundTag()));
            }
            tag.put("fluidInventory", fluidInventoryTag);

            return tag;
        }

        @Override
        public void deserializeNBT(CompoundTag tag) {
            ListTag inv = tag.getList("inventory", Tag.TAG_COMPOUND);
            for (int i = 0; i < inv.size(); i++) {
                CompoundTag tagItemStack = inv.getCompound(i);
                var item = MONBTUtils.readItemStack(tagItemStack);
                if (item != null) {
                    if (!item.isEmpty()) {
                        itemInventory.add(item);
                    }
                } else {
                    Epimorphism.logger().warn("An error occurred while loading contents of ME Crafting Input Bus. This item has been voided: " + tagItemStack);
                }
            }
            ListTag fluidInv = tag.getList("fluidInventory", Tag.TAG_COMPOUND);
            for (int i = 0; i < fluidInv.size(); i++) {
                CompoundTag tagFluidStack = fluidInv.getCompound(i);
                var fluid = FluidStack.loadFromTag(tagFluidStack);
                if (fluid != null) {
                    if (!fluid.isEmpty()) {
                        fluidInventory.add(fluid);
                    }
                } else {
                    Epimorphism.logger().warn("An error occurred while loading contents of ME Crafting Input Bus. This fluid has been voided: " + tagFluidStack);
                }
            }
        }
    }

    public class ItemRecipeHandler implements IRecipeHandlerTrait<Ingredient> {
        @Override
        public IO getHandlerIO() {
            return IO.IN;
        }

        @Override
        public ISubscription addChangedListener(Runnable listener) {
            return () -> {};
        }

        @Override
        public List<Ingredient> handleRecipeInner(IO io, GTRecipe recipe, List<Ingredient> left, @Nullable String slotName, boolean simulate) {
            if (io != IO.IN) return left;
            return handleItemInner(recipe, copyIngredients(left), simulate);
        }

        @Override
        public List<Object> getContents() {
            return Arrays.stream(internalInventory)
                    .map(InternalSlot::getItemInputs)
                    .flatMap(Arrays::stream)
                    .collect(Collectors.toList());
        }

        @Override
        public double getTotalContentAmount() {
            return Arrays.stream(internalInventory)
                    .map(InternalSlot::getItemInputs)
                    .flatMap(Arrays::stream)
                    .mapToLong(ItemStack::getCount)
                    .sum();
        }

        @Override
        public int getPriority() {
            return Integer.MAX_VALUE;
        }

        @Override
        public boolean isDistinct() {
            return true;
        }

        @Override
        public RecipeCapability<Ingredient> getCapability() {
            return ItemRecipeCapability.CAP;
        }
    }

    public class FluidRecipeHandler implements IRecipeHandlerTrait<FluidIngredient> {
        @Override
        public IO getHandlerIO() {
            return IO.IN;
        }

        @Override
        public ISubscription addChangedListener(Runnable listener) {
            return () -> {};
        }

        @Override
        public List<FluidIngredient> handleRecipeInner(IO io, GTRecipe recipe, List<FluidIngredient> left, @Nullable String slotName, boolean simulate) {
            if (io != IO.IN) return left;
            return handleFluidInner(recipe, copyFluidIngredients(left), simulate);
        }

        @Override
        public List<Object> getContents() {
            return Arrays.stream(internalInventory)
                    .map(InternalSlot::getFluidInputs)
                    .flatMap(Arrays::stream)
                    .collect(Collectors.toList());
        }

        @Override
        public double getTotalContentAmount() {
            return Arrays.stream(internalInventory)
                    .map(InternalSlot::getFluidInputs)
                    .flatMap(Arrays::stream)
                    .mapToLong(FluidStack::getAmount)
                    .sum();
        }

        @Override
        public int getPriority() {
            return Integer.MAX_VALUE;
        }

        @Override
        public boolean isDistinct() {
            return true;
        }

        @Override
        public RecipeCapability<FluidIngredient> getCapability() {
            return FluidRecipeCapability.CAP;
        }
    }
}
