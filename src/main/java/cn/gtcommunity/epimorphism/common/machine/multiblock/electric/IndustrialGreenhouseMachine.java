package cn.gtcommunity.epimorphism.common.machine.multiblock.electric;

import cn.gtcommunity.epimorphism.common.machine.multiblock.storage.TFFTMachine;
import com.gregtechceu.gtceu.api.gui.fancy.ConfiguratorPanel;
import com.gregtechceu.gtceu.api.gui.fancy.IFancyUIProvider;
import com.gregtechceu.gtceu.api.gui.fancy.TooltipsPanel;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.feature.IFancyUIMachine;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableMultiblockMachine;
import com.lowdragmc.lowdraglib.gui.texture.IGuiTexture;
import com.lowdragmc.lowdraglib.gui.widget.Widget;
import com.lowdragmc.lowdraglib.gui.widget.WidgetGroup;

import java.util.ArrayList;
import java.util.List;

public class IndustrialGreenhouseMachine extends WorkableMultiblockMachine implements IFancyUIMachine/*, IDisplayUIMachine */{

    public IndustrialGreenhouseMachine(IMachineBlockEntity holder, Object... args) {
        super(holder, args);
    }

    //////////////////////////////////////
    //***        Multiblock UI       ***//
    //////////////////////////////////////

    @Override
    public List<IFancyUIProvider> getSubTabs() {
        List<IFancyUIProvider> list = new ArrayList<>();

        list.add(new IFancyUIProvider() {
            @Override
            public Widget createMainPage() {
                return new WidgetGroup(0, 0, 170 + 8, 129 + 8);
            }

            @Override
            public IGuiTexture getTabIcon() {
                return IndustrialGreenhouseMachine.this.getTabIcon();
            }

            @Override
            public void attachConfigurators(ConfiguratorPanel configuratorPanel) {

            }

            @Override
            public void attachTooltips(TooltipsPanel tooltipsPanel) {

            }
        });

        list.addAll(getParts().stream().filter(IFancyUIProvider.class::isInstance).map(IFancyUIProvider.class::cast).toList());
        return list;
    }

}
