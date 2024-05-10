package cn.gtcommunity.epimorphism.common.machine.multiblock.part;

import cn.gtcommunity.epimorphism.api.gui.EPGuiTextures;
import cn.gtcommunity.epimorphism.api.recipe.SlotNames;
import cn.gtcommunity.epimorphism.common.item.behaviors.CatalystBehavior;
import cn.gtcommunity.epimorphism.common.machine.multiblock.electric.ChemicalPlantMachine;
import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.gui.GuiTextures;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.TickableSubscription;
import com.gregtechceu.gtceu.api.machine.multiblock.part.TieredIOPartMachine;
import com.gregtechceu.gtceu.api.machine.trait.NotifiableItemStackHandler;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;
import com.lowdragmc.lowdraglib.gui.widget.ImageWidget;
import com.lowdragmc.lowdraglib.gui.widget.SlotWidget;
import com.lowdragmc.lowdraglib.gui.widget.Widget;
import com.lowdragmc.lowdraglib.gui.widget.WidgetGroup;
import com.lowdragmc.lowdraglib.misc.ItemStackTransfer;
import com.lowdragmc.lowdraglib.side.item.IItemTransfer;
import com.lowdragmc.lowdraglib.syncdata.ISubscription;
import com.lowdragmc.lowdraglib.syncdata.annotation.Persisted;
import com.lowdragmc.lowdraglib.syncdata.field.ManagedFieldHolder;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;

import java.util.*;

import static com.gregtechceu.gtceu.api.GTValues.*;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class CatalystHatchPartMachine extends TieredIOPartMachine {

    protected static final ManagedFieldHolder MANAGED_FIELD_HOLDER = new ManagedFieldHolder(CatalystHatchPartMachine.class, TieredIOPartMachine.MANAGED_FIELD_HOLDER);

    @Persisted
    public final NotifiableItemStackHandler buffer;
    @Persisted
    public final NotifiableItemStackHandler inventory;

    private ISubscription bufferSubs;
    private ISubscription inventorySubs;
    private TickableSubscription transferSubs;

    public CatalystHatchPartMachine(IMachineBlockEntity holder) {
        super(holder, IV, IO.IN);
        this.buffer = new NotifiableItemStackHandler(this, 16, IO.NONE, IO.BOTH);
        this.inventory = createInventory();
    }

    //////////////////////////////////////
    //*****     Initialization    ******//
    //////////////////////////////////////

    @Override
    public void onLoad() {
        super.onLoad();
        if (!isRemote()) {
            bufferSubs = this.buffer.addChangedListener(this::onInventoryChanged);
            inventorySubs = this.inventory.addChangedListener(this::onInventoryChanged);
        }
    }

    @Override
    public void onUnload() {
        super.onUnload();
        if (bufferSubs != null) {
            bufferSubs.unsubscribe();
        }
        if (inventorySubs != null) {
            inventorySubs.unsubscribe();
        }
    }

    protected NotifiableItemStackHandler createInventory() {
        return new NotifiableItemStackHandler(this, 16, IO.IN, IO.OUT, slots -> new ItemStackTransfer(slots) {
            @Override
            public int getSlotLimit(int slot) {
                return 1;
            }

        }) {

            @Override
            public Set<String> getSlotNames() {
                return Collections.singleton(SlotNames.CATALYST);
            }

            @Override
            @Nullable
            public List<Ingredient> handleRecipeInner(IO io, GTRecipe recipe, List<Ingredient> left, @Nullable String slotName, boolean simulate) {
                if (io != handlerIO) return left;
                if (slotName != null && !slotName.equals(SlotNames.CATALYST)) return left;

                var capability = simulate ? storage.copy() : storage;
                Iterator<Ingredient> iterator = left.iterator();
                if (io == IO.IN) {
                    while (iterator.hasNext()) {
                        Ingredient ingredient = iterator.next();
                        SLOT_LOOKUP:
                        for (int i = 0; i < capability.getSlots(); i++) {
                            ItemStack itemStack = capability.getStackInSlot(i);
                            //Does not look like a good implementation, but I think it's at least equal to vanilla Ingredient::test
                            if (ingredient.test(itemStack)) {
                                ItemStack[] ingredientStacks = ingredient.getItems();
                                for (ItemStack ingredientStack : ingredientStacks) {
                                    if (ingredientStack.is(itemStack.getItem())) {
                                        var behavior = CatalystBehavior.getBehaviour(itemStack);
                                        int count = ingredientStack.getCount();
                                        if (!simulate) {
                                            float chance = getChance();
                                            double u = count * chance;
                                            double e = count * chance * (1 - chance);
                                            count = (int) Math.ceil(Math.sqrt(e) * RNG.nextGaussian() + u);
                                        }
                                        if (behavior != null) {
                                            int damage = Math.min(count, behavior.getDurability(itemStack));
                                            behavior.applyDamage(itemStack, damage);
                                            ingredientStack.shrink(damage);
                                        } else {
                                            ItemStack extracted = capability.extractItem(i, count, false);
                                            ingredientStack.shrink(extracted.getCount());
                                        }
                                        if (ingredientStack.isEmpty()) {
                                            iterator.remove();
                                            break SLOT_LOOKUP;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                return left.isEmpty() ? null : left;
            }
        };
    }

    //////////////////////////////////////
    //********   Subscriptions  ********//
    //////////////////////////////////////

    private void onInventoryChanged() {
        if (isWorkingEnabled() && !buffer.isEmpty()) {
            transferSubs = subscribeServerTick(transferSubs, this::transferItems);
        } else unsubscribe();
    }

    private void transferItems() {
        for (int i = 0; i < buffer.getSlots(); i++) {
            var stack = buffer.getStackInSlot(i);
            if (stack.isEmpty() || !inventory.getStackInSlot(i).isEmpty()) continue;
            if (!buffer.extractItem(i, 1, true).isEmpty()) {
                var copy = stack.copyWithCount(1);
                if (inventory.insertItemInternal(i, copy, true).isEmpty()) {
                    buffer.extractItem(i, 1, false);
                    inventory.insertItemInternal(i, copy, false);
                }
            }
        }
        unsubscribe();
    }

    private void unsubscribe() {
        if (transferSubs != null) {
            transferSubs.unsubscribe();
            transferSubs = null;
        }
    }

    //////////////////////////////////////
    //**********     GUI     ***********//
    //////////////////////////////////////
    @Override
    public Widget createUIWidget() {
        var group = new WidgetGroup(0, 0, 18 * 8 + 31, 18 * 4 + 16);
        var slotsContainer = new WidgetGroup(4, 4, 18 * 8 + 23, 18 * 4 + 8);
        slotsContainer.addWidget(new ImageWidget(75, 31, 18, 18, EPGuiTextures.SMALL_ARROW_OVERLAY));
        addSlots(slotsContainer, buffer, 4, 4, true);
        addSlots(slotsContainer, inventory, 91, 4, false);
        slotsContainer.setBackground(GuiTextures.BACKGROUND_INVERSE);
        group.addWidget(slotsContainer);
        return group;
    }

    private void addSlots(WidgetGroup container, IItemTransfer handler, int x, int y, boolean canPutItems) {
        int index = 0;
        for (int j = 0; j < 4; j++) {
            for (int i = 0; i < 4; i++) {
                container.addWidget(new SlotWidget(handler, index++, x + i * 18, y + j * 18, true, canPutItems)
                        .setBackground(GuiTextures.SLOT));
            }
        }
    }

    //////////////////////////////////////
    //**********     Data     **********//
    //////////////////////////////////////

    protected float getChance() {
        for (var controller : getControllers()) {
            if (controller instanceof ChemicalPlantMachine chemicalPlant) {
                return chemicalPlant.getChance() / 100F;
            }
        }
        return 1;
    }

    @Override
    public void setWorkingEnabled(boolean workingEnabled) {
        super.setWorkingEnabled(workingEnabled);
        onInventoryChanged();
    }

    @Override
    public ManagedFieldHolder getFieldHolder() {
        return MANAGED_FIELD_HOLDER;
    }
}
