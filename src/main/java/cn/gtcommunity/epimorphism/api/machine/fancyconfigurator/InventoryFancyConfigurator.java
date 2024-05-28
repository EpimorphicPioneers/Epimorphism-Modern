package cn.gtcommunity.epimorphism.api.machine.fancyconfigurator;

import cn.gtcommunity.epimorphism.api.gui.EPGuiTextures;
import com.gregtechceu.gtceu.api.gui.GuiTextures;
import com.gregtechceu.gtceu.api.gui.fancy.IFancyConfigurator;
import com.lowdragmc.lowdraglib.gui.texture.IGuiTexture;
import com.lowdragmc.lowdraglib.gui.widget.SlotWidget;
import com.lowdragmc.lowdraglib.gui.widget.Widget;
import com.lowdragmc.lowdraglib.gui.widget.WidgetGroup;
import com.lowdragmc.lowdraglib.jei.IngredientIO;
import com.lowdragmc.lowdraglib.misc.ItemStackTransfer;
import net.minecraft.network.chat.Component;

import java.util.ArrayList;
import java.util.List;

public class InventoryFancyConfigurator implements IFancyConfigurator {

    private final ItemStackTransfer inventory;

    public InventoryFancyConfigurator(ItemStackTransfer inventory) {
        this.inventory = inventory;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("gui.epimorphism.inventory.title");
    }

    @Override
    public IGuiTexture getIcon() {
        return EPGuiTextures.OVERLAY_INVENTORY_CONFIGURATOR;
    }

    @Override
    public Widget createConfigurator() {
        int rowSize = (int) Math.sqrt(inventory.getSlots());
        int colSize = rowSize;
        if (inventory.getSlots() == 8) {
            rowSize = 4;
            colSize = 2;
        }
        var group = new WidgetGroup(0, 0, 18 * rowSize + 16, 18 * colSize + 16);
        var container = new WidgetGroup(4, 4, 18 * rowSize + 8, 18 * colSize + 8);
        int index = 0;
        for (int y = 0; y < colSize; y++) {
            for (int x = 0; x < rowSize; x++) {
                container.addWidget(new SlotWidget(inventory, index++, 4 + x * 18, 4 + y * 18, true, true)
                        .setBackgroundTexture(GuiTextures.SLOT)
                        .setIngredientIO(IngredientIO.INPUT));
            }
        }

        container.setBackground(GuiTextures.BACKGROUND_INVERSE);
        group.addWidget(container);

        return group;
    }

    @Override
    public List<Component> getTooltips() {
        List<Component> tooltip = new ArrayList<>();
        tooltip.add(Component.translatable("gui.epimorphism.inventory.desc"));
        return tooltip;
    }
}
