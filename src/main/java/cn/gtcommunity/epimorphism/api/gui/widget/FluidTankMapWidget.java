package cn.gtcommunity.epimorphism.api.gui.widget;

import cn.gtcommunity.epimorphism.api.gui.EPGuiTextures;
import cn.gtcommunity.epimorphism.common.machine.multiblock.storage.TFFTMachine;
import com.gregtechceu.gtceu.api.gui.GuiTextures;
import com.gregtechceu.gtceu.api.gui.widget.ToggleButtonWidget;
import com.lowdragmc.lowdraglib.gui.editor.ColorPattern;
import com.lowdragmc.lowdraglib.gui.texture.IGuiTexture;
import com.lowdragmc.lowdraglib.gui.texture.ResourceTexture;
import com.lowdragmc.lowdraglib.gui.widget.DraggableScrollableWidgetGroup;
import com.lowdragmc.lowdraglib.gui.widget.SearchComponentWidget;
import com.lowdragmc.lowdraglib.gui.widget.SelectableWidgetGroup;
import com.lowdragmc.lowdraglib.gui.widget.WidgetGroup;
import com.lowdragmc.lowdraglib.side.fluid.FluidHelper;
import com.lowdragmc.lowdraglib.side.fluid.FluidStack;
import net.minecraft.core.registries.BuiltInRegistries;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;

public class FluidTankMapWidget extends WidgetGroup implements SearchComponentWidget.IWidgetSearch<Object> {
    private final DraggableScrollableWidgetGroup fluidList;

    private final Map<String, SelectableWidgetGroup> selectedMap = new ConcurrentHashMap<>();

    public FluidTankMapWidget(int xPosition, int yPosition, int width, int height, TFFTMachine.TankStorage[] storages) {
        super(xPosition, yPosition, width, height);
        var group = (WidgetGroup) new WidgetGroup(xPosition, yPosition + 28, width, height - 28).setBackground(GuiTextures.BACKGROUND_INVERSE);
        group.addWidget(fluidList = new DraggableScrollableWidgetGroup(3, 3, group.getSize().width - 6, group.getSize().height - 6)
                .setYScrollBarWidth(4).setYBarStyle(null, EPGuiTextures.BUTTON_NO_BORDER_LIGHT));
        addWidget(new SearchComponentWidget<>(34, 6, group.getSize().width - 33, 18, this));
        Arrays.stream(storages).filter(TFFTMachine.TankStorage::hasFluid).forEach(this::addNewFluid);
        addWidget(group);
    }

    private void addNewFluid(TFFTMachine.TankStorage storage) {
        var fluid = storage.getFluid();
        String uniqueID = getUniqueID(fluid);
        String renderingName = getDescriptionId(fluid);
        IGuiTexture icon = ResourceTexture.fromSpirit(FluidHelper.getStillTexture(fluid).contents().name());
        int color = 0;

        if (!selectedMap.containsKey(uniqueID)) {
            var index = fluidList.widgets.size();
            var selectableWidgetGroup = new SelectableWidgetGroup(0, index * 24, fluidList.getSize().width - 4, 24);
            var size = selectableWidgetGroup.getSize();

            selectableWidgetGroup.setBackground(EPGuiTextures.BUTTON_HALF_NO_BORDER);
            selectableWidgetGroup.setSelectedTexture(ColorPattern.WHITE.borderTexture(-1));

            selectableWidgetGroup.addWidget(new ToggleButtonWidget(111, 3, 18, 18, EPGuiTextures.TOGGLE_BUTTON_LOCK, storage::isLocked, storage::setLocked));
            selectableWidgetGroup.addWidget(new ToggleButtonWidget(131, 3, 18, 18, EPGuiTextures.TOGGLE_BUTTON_VOID, storage::isVoiding, storage::setVoiding));
            selectableWidgetGroup.addWidget(new ToggleButtonWidget(151, 3, 18, 18, EPGuiTextures.TOGGLE_BUTTON_SELECTED, storage::isSelected, storage::setSelected));
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

    public String getDescriptionId(FluidStack fluid) {
        return fluid.getDisplayName().getString();
    }

    public String getUniqueID(FluidStack fluid) {
        return BuiltInRegistries.FLUID.getKey(fluid.getFluid()).toString();
    }
}
