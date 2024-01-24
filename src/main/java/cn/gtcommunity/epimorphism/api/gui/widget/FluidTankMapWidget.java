package cn.gtcommunity.epimorphism.api.gui.widget;

import cn.gtcommunity.epimorphism.api.gui.EPGuiTextures;
import com.gregtechceu.gtceu.api.gui.GuiTextures;
import com.gregtechceu.gtceu.api.gui.widget.ToggleButtonWidget;
import com.lowdragmc.lowdraglib.gui.editor.ColorPattern;
import com.lowdragmc.lowdraglib.gui.texture.IGuiTexture;
import com.lowdragmc.lowdraglib.gui.widget.*;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;

public class FluidTankMapWidget extends WidgetGroup implements SearchComponentWidget.IWidgetSearch<Object> {
    private final DraggableScrollableWidgetGroup fluidList;

    private final Map<String, SelectableWidgetGroup> selectedMap = new ConcurrentHashMap<>();

    public FluidTankMapWidget(int xPosition, int yPosition, int width, int height) {
        super(xPosition, yPosition, width, height);
        var group = (WidgetGroup) new WidgetGroup(xPosition, yPosition + 28, width, height - 28).setBackground(GuiTextures.BACKGROUND_INVERSE);
        group.addWidget(fluidList = new DraggableScrollableWidgetGroup(3, 3, group.getSize().width - 6, group.getSize().height - 6)
                .setYScrollBarWidth(4).setYBarStyle(null, EPGuiTextures.BUTTON_NO_BORDER));
        addWidget(new SearchComponentWidget<>(34, 6, group.getSize().width - 33, 18, this));
        addWidget(group);
    }

    private void addNewFluid(String uniqueID, String renderingName, IGuiTexture icon, int color) {
        if (!selectedMap.containsKey(uniqueID)) {
            var index = fluidList.widgets.size();
            var selectableWidgetGroup = new SelectableWidgetGroup(0, index * 24, fluidList.getSize().width - 4, 24);
            var size = selectableWidgetGroup.getSize();

            selectableWidgetGroup.setBackground(EPGuiTextures.BUTTON_HALF_NO_BORDER);
            selectableWidgetGroup.setSelectedTexture(ColorPattern.WHITE.borderTexture(-1));
            selectableWidgetGroup.addWidget(new ToggleButtonWidget(99, 3, 18, 18, EPGuiTextures.TOGGLE_BUTTON_LOCK, () -> false, c -> {}));
            selectableWidgetGroup.addWidget(new ToggleButtonWidget(119, 3, 18, 18, EPGuiTextures.TOGGLE_BUTTON_VOID, () -> false, c -> {}));
            selectableWidgetGroup.addWidget(new ToggleButtonWidget(139, 3, 18, 18, EPGuiTextures.TOGGLE_BUTTON_SELECTED, () -> false, c -> {}));
            fluidList.addWidget(selectableWidgetGroup);
            selectedMap.put(uniqueID, selectableWidgetGroup);
        }
    }

    @Override
    public String resultDisplay(Object value) {
        return null;
    }

    @Override
    public void selectResult(Object value) {

    }

    @Override
    public void search(String s, Consumer<Object> consumer) {

    }

    @Override
    public void detectAndSendChanges() {
        super.detectAndSendChanges();
    }


}
