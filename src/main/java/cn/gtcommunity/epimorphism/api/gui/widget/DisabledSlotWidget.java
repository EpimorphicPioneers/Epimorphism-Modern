package cn.gtcommunity.epimorphism.api.gui.widget;

import cn.gtcommunity.epimorphism.api.gui.EPGuiTextures;
import com.gregtechceu.gtceu.api.gui.GuiTextures;
import com.lowdragmc.lowdraglib.gui.texture.IGuiTexture;
import com.lowdragmc.lowdraglib.gui.widget.SlotWidget;
import com.lowdragmc.lowdraglib.side.item.IItemTransfer;
import java.util.function.Consumer;
import java.util.function.Supplier;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class DisabledSlotWidget extends SlotWidget {
    protected Supplier<Boolean> isDisable;
    protected Consumer<Boolean> setDisable;
    private boolean isDisabled;

    public DisabledSlotWidget(IItemTransfer itemHandler, int slotIndex, int xPosition, int yPosition, Supplier<Boolean> isLock, Consumer<Boolean> setLock) {
        super(itemHandler, slotIndex, xPosition, yPosition);
        this.isDisable = isLock;
        this.setDisable = setLock;
    }

    public void detectAndSendChanges() {
        super.detectAndSendChanges();
        boolean newValue = this.isDisable.get();
        if (newValue != this.isDisabled) {
            this.isDisabled = newValue;
            this.writeUpdateInfo(0, (buf) -> {
                buf.writeBoolean(this.isDisabled);
            });
        }

    }

    @OnlyIn(Dist.CLIENT)
    public void readUpdateInfo(int id, FriendlyByteBuf buffer) {
        super.readUpdateInfo(id, buffer);
        if (id == 0) {
            if (buffer.readBoolean()) {
                this.setBackground(GuiTextures.SLOT, EPGuiTextures.SLOT_DISABLE_OVERLAY);
            } else {
                this.setBackground(GuiTextures.SLOT);
            }
        }

    }

    public void writeInitialData(FriendlyByteBuf buffer) {
        super.writeInitialData(buffer);
        buffer.writeBoolean(this.isDisable.get());
    }

    @OnlyIn(Dist.CLIENT)
    public void readInitialData(FriendlyByteBuf buffer) {
        super.readInitialData(buffer);
        this.setDisable.accept(buffer.readBoolean());
        if (this.isDisable.get()) {
            this.setBackground(GuiTextures.SLOT, EPGuiTextures.SLOT_LOCK_OVERLAY);
        }

    }
}
