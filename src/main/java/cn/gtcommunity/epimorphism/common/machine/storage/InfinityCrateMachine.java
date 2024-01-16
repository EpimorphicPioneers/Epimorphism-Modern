package cn.gtcommunity.epimorphism.common.machine.storage;

import cn.gtcommunity.epimorphism.api.gui.utils.EPDrawerHelper;
import cn.gtcommunity.epimorphism.api.gui.widget.PagedWidgetGroup;
import cn.gtcommunity.epimorphism.utils.EPLangUtil;
import cn.gtcommunity.epimorphism.utils.EPNBTUtil;
import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.gui.GuiTextures;
import com.gregtechceu.gtceu.api.gui.UITemplate;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.MetaMachine;
import com.gregtechceu.gtceu.api.machine.feature.IMachineModifyDrops;
import com.gregtechceu.gtceu.api.machine.feature.IUIMachine;
import com.gregtechceu.gtceu.api.machine.trait.NotifiableItemStackHandler;
import com.lowdragmc.lowdraglib.gui.modular.ModularUI;
import com.lowdragmc.lowdraglib.gui.modular.ModularUIGuiContainer;
import com.lowdragmc.lowdraglib.gui.texture.GuiTextureGroup;
import com.lowdragmc.lowdraglib.gui.texture.TextTexture;
import com.lowdragmc.lowdraglib.gui.util.DrawerHelper;
import com.lowdragmc.lowdraglib.gui.widget.*;
import com.lowdragmc.lowdraglib.misc.ItemStackTransfer;
import com.lowdragmc.lowdraglib.side.item.IItemTransfer;
import com.lowdragmc.lowdraglib.syncdata.annotation.Persisted;
import com.lowdragmc.lowdraglib.syncdata.field.ManagedFieldHolder;
import com.lowdragmc.lowdraglib.utils.LocalizationUtils;
import com.lowdragmc.lowdraglib.utils.Position;
import com.lowdragmc.lowdraglib.utils.Size;
import com.mojang.blaze3d.systems.RenderSystem;
import lombok.Getter;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class InfinityCrateMachine extends MetaMachine implements IUIMachine, IMachineModifyDrops {
    public static final ManagedFieldHolder MANAGED_FIELD_HOLDER = new ManagedFieldHolder(InfinityCrateMachine.class, MetaMachine.MANAGED_FIELD_HOLDER);

    @Getter
    private final Material material;
    @Getter
    private final int inventorySize;

    @Persisted
    public final NotifiableItemStackHandler inventory;

    public InfinityCrateMachine(IMachineBlockEntity holder, Material material, int inventorySize) {
        super(holder);
        this.material = material;
        this.inventorySize = inventorySize;
        this.inventory = new NotifiableItemStackHandler(this, inventorySize, IO.BOTH, IO.BOTH, slots -> new ItemStackTransfer(slots) {
            @Override
            public int getSlotLimit(int slot) {
                return Integer.MAX_VALUE;
            }

            @Override
            protected int getStackLimit(int slot, @NotNull ItemStack stack) {
                if (stack.hasTag()) return 0;
                return stack.isStackable() ? Integer.MAX_VALUE : 1;
            }

            @Override
            public CompoundTag serializeNBT() {
                ListTag nbtTagList = new ListTag();
                for (int i = 0; i < stacks.size(); i++) {
                    if (!stacks.get(i).isEmpty()) {
                        CompoundTag itemTag = new CompoundTag();
                        itemTag.putInt("Slot", i);
                        EPNBTUtil.saveItemStack(stacks.get(i), itemTag);
                        nbtTagList.add(itemTag);
                    }
                }
                CompoundTag nbt = new CompoundTag();
                nbt.put("Items", nbtTagList);
                nbt.putInt("Size", stacks.size());
                return nbt;
            }

            @Override
            public void deserializeNBT(CompoundTag nbt) {
                setSize(nbt.contains("Size", Tag.TAG_INT) ? nbt.getInt("Size") : stacks.size());
                ListTag tagList = nbt.getList("Items", Tag.TAG_COMPOUND);
                for (int i = 0; i < tagList.size(); i++) {
                    CompoundTag itemTags = tagList.getCompound(i);
                    int slot = itemTags.getInt("Slot");

                    if (slot >= 0 && slot < stacks.size()) {
                        stacks.set(slot, EPNBTUtil.loadItemStack(itemTags));
                    }
                }
                onLoad();
            }
        });
    }

    @Override
    public ModularUI createUI(Player entityPlayer) {
        int size = inventorySize / 2;
        int xOffset = size >= 90 ? 162 : 0;
        int yOverflow = xOffset > 0 ? 18 : 9;
        int yOffset = size > 3 * yOverflow ? (size - 3 * yOverflow - (size - 3 * yOverflow) % yOverflow) / yOverflow * 18 : 0;
        var pagedGroup = new PagedWidgetGroup(Position.ORIGIN, new Size(176 + xOffset, 166 + yOffset));
        var modularUI = new ModularUI(pagedGroup, this, entityPlayer)
                .background(GuiTextures.BACKGROUND)
                .widget(new LabelWidget(5, 5, () -> String.format("%s#%s", LocalizationUtils.format(getBlockState().getBlock().getDescriptionId()), pagedGroup.getPageIndex() + 1)))
                .widget(UITemplate.bindPlayerInventory(entityPlayer.getInventory(), GuiTextures.SLOT, 7 + xOffset / 2, 82 + yOffset, true))
                .widget(new ButtonWidget(64, 154, 20, 20, new GuiTextureGroup(GuiTextures.BUTTON, new TextTexture("<")), clickData -> pagedGroup.pageUp()))
                .widget(new ButtonWidget(254, 154, 20, 20, new GuiTextureGroup(GuiTextures.BUTTON, new TextTexture(">")), clickData -> pagedGroup.pageDown()));

        var page1 = new WidgetGroup(Position.ORIGIN, new Size(176 + xOffset, 166 + yOffset));
        var page2 = new WidgetGroup(Position.ORIGIN, new Size(176 + xOffset, 166 + yOffset));

        addSlot(page1, size, 0, yOverflow);
        addSlot(page2, inventorySize, size, yOverflow);

        pagedGroup.addPage(page1);
        pagedGroup.addPage(page2);
        return modularUI;
    }

    private void addSlot(WidgetGroup widgetGroup, int slots, int start, int yOverflow) {
        int x = 0;
        int y = 0;
        for (int slot = start; slot < slots; slot++) {
            widgetGroup.addWidget(widget(x, y, slot));
            x++;
            if (x == yOverflow) {
                x = 0;
                y++;
            }
        }
    }

    private Widget widget(int x, int y, int slot) {
        return new SlotWidget(inventory, slot, x * 18 + 7, y * 18 + 17) {
            @Override
            protected Slot createSlot(IItemTransfer itemHandler, int index) {
                return new WidgetSlotItemTransfer(itemHandler, index, 0, 0) {
                    @Override
                    public int getMaxStackSize(@Nonnull ItemStack stack) {
                        if (stack.hasTag()) return 0;
                        ItemStack maxAdd = stack.copy();
                        int maxInput = stack.isStackable() ? Integer.MAX_VALUE : 1;
                        maxAdd.setCount(maxInput);
                        ItemStack currentStack = inventory.getStackInSlot(index);
                        inventory.setStackInSlot(index, ItemStack.EMPTY);
                        ItemStack remainder = inventory.insertItem(index, maxAdd, true);
                        inventory.setStackInSlot(index, currentStack);
                        return maxInput - remainder.getCount();
                    }
                };
            }

            @Override
            @OnlyIn(Dist.CLIENT)
            public void drawInBackground(@NotNull GuiGraphics graphics, int mouseX, int mouseY, float partialTicks) {
                drawBackgroundTexture(graphics, mouseX, mouseY);
                Position pos = getPosition();
                if (slotReference != null)  {
                    ItemStack itemStack = getRealStack(slotReference.getItem());
                    ModularUIGuiContainer modularUIGui = gui == null ? null : gui.getModularUIGui();
                    if (itemStack.isEmpty() && modularUIGui!= null && modularUIGui.getQuickCrafting() && modularUIGui.getQuickCraftSlots().contains(slotReference)) { // draw split
                        int splitSize = modularUIGui.getQuickCraftSlots().size();
                        itemStack = gui.getModularUIContainer().getCarried();
                        if (!itemStack.isEmpty() && splitSize > 1 && AbstractContainerMenu.canItemQuickReplace(slotReference, itemStack, true)) {
                            itemStack = itemStack.copy();
                            itemStack.grow(AbstractContainerMenu.getQuickCraftPlaceCount(modularUIGui.getQuickCraftSlots(), modularUIGui.dragSplittingLimit, itemStack));
                            int k = Math.min(itemStack.getMaxStackSize(), slotReference.getMaxStackSize(itemStack));
                            if (itemStack.getCount() > k) {
                                itemStack.setCount(k);
                            }
                        }
                    }
                    if (!itemStack.isEmpty()) {
                        DrawerHelper.drawItemStack(graphics, itemStack, pos.x+ 1, pos.y + 1, -1, " ");
                        if (itemStack.getCount() > 1) {
                            EPDrawerHelper.renderStackCount(graphics, EPLangUtil.abbreviate(itemStack.getCount()), pos.x+ 1, pos.y + 1);
                        }
                    }
                }
                if (overlay != null) {
                    overlay.draw(graphics, mouseX, mouseY, pos.x, pos.y, 18, 18);
                }
                if (drawHoverOverlay && isMouseOverElement(mouseX, mouseY) && getHoverElement(mouseX, mouseY) == this) {
                    RenderSystem.colorMask(true, true, true, false);
                    DrawerHelper.drawSolidRect(graphics,getPosition().x + 1, getPosition().y + 1, 16, 16, 0x80FFFFFF);
                    RenderSystem.colorMask(true, true, true, true);
                }
            }
        }.setBackgroundTexture(GuiTextures.SLOT);
    }

    @Override
    public void onDrops(List<ItemStack> drops, Player entity) {
        MetaMachine.clearInventory(drops, inventory.storage);
    }

    @Override
    public ManagedFieldHolder getFieldHolder() {
        return MANAGED_FIELD_HOLDER;
    }
}