package com.epimorphismmc.epimorphism.api.gui.widget;

import com.epimorphismmc.epimorphism.api.gui.EPGuiTextures;

import com.gregtechceu.gtceu.api.gui.GuiTextures;

import com.lowdragmc.lowdraglib.gui.widget.SlotWidget;
import com.lowdragmc.lowdraglib.side.item.IItemTransfer;

import net.minecraft.client.Minecraft;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import com.mojang.blaze3d.platform.InputConstants;
import org.lwjgl.glfw.GLFW;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class LockableSlotWidget extends SlotWidget {

    protected Supplier<Boolean> isLock;
    protected Consumer<Boolean> setLock;

    public LockableSlotWidget(
            IItemTransfer itemHandler,
            int slotIndex,
            int xPosition,
            int yPosition,
            Supplier<Boolean> isLock,
            Consumer<Boolean> setLock) {
        super(itemHandler, slotIndex, xPosition, yPosition);
        this.isLock = isLock;
        this.setLock = setLock;
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public boolean mouseClicked(double mouseX, double mouseY, int button) {

        if (slotReference != null && isMouseOverElement(mouseX, mouseY) && gui != null) {

            if (slotReference.hasItem()) return super.mouseClicked(mouseX, mouseY, button);

            long id = Minecraft.getInstance().getWindow().getWindow();
            boolean isShiftClick = InputConstants.isKeyDown(id, GLFW.GLFW_KEY_LEFT_SHIFT)
                    || InputConstants.isKeyDown(id, GLFW.GLFW_KEY_RIGHT_SHIFT);
            if (isShiftClick) {
                setLock.accept(!isLock.get());
                if (isLock.get()) setBackground(GuiTextures.SLOT, EPGuiTextures.SLOT_LOCK_OVERLAY);
                else setBackground(GuiTextures.SLOT, EPGuiTextures.BALL_OVERLAY);
                writeClientAction(1, friendlyByteBuf -> {});
                playButtonClickSound();
                return true;
            }
        }
        return false;
    }

    @Override
    public void handleClientAction(int id, FriendlyByteBuf buffer) {
        super.handleClientAction(id, buffer);
        if (id == 1) {
            setLock.accept(!isLock.get());
        }
    }

    @Override
    public void writeInitialData(FriendlyByteBuf buffer) {
        super.writeInitialData(buffer);
        buffer.writeBoolean(isLock.get());
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void readInitialData(FriendlyByteBuf buffer) {
        super.readInitialData(buffer);
        setLock.accept(buffer.readBoolean());
        if (isLock.get()) setBackground(GuiTextures.SLOT, EPGuiTextures.SLOT_LOCK_OVERLAY);
    }
}
