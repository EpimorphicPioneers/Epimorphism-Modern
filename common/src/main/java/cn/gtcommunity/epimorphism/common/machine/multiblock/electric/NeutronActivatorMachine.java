package cn.gtcommunity.epimorphism.common.machine.multiblock.electric;

import cn.gtcommunity.epimorphism.api.machine.multiblock.NoEnergyMultiblockMachine;
import com.gregtechceu.gtceu.api.gui.fancy.ConfiguratorPanel;
import com.gregtechceu.gtceu.api.gui.fancy.IFancyUIProvider;
import com.gregtechceu.gtceu.api.gui.fancy.TooltipsPanel;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.lowdragmc.lowdraglib.gui.texture.IGuiTexture;
import com.lowdragmc.lowdraglib.gui.widget.Widget;

import java.util.ArrayList;
import java.util.List;

public class NeutronActivatorMachine extends NoEnergyMultiblockMachine {
    public NeutronActivatorMachine(IMachineBlockEntity holder, Object... args) {
        super(holder, args);
    }

    //////////////////////////////////////
    //***        Multiblock UI       ***//
    //////////////////////////////////////

    @Override
    public List<IFancyUIProvider> getSubTabs() {
        var list = new ArrayList<>(super.getSubTabs());

        list.add(new IFancyUIProvider() {
            @Override
            public Widget createMainPage() {
                return NeutronActivatorMachine.this.createMainPage();
            }

            @Override
            public IGuiTexture getTabIcon() {
                return NeutronActivatorMachine.this.getTabIcon();
            }

            @Override
            public void attachConfigurators(ConfiguratorPanel configuratorPanel) {

            }

            @Override
            public void attachTooltips(TooltipsPanel tooltipsPanel) {

            }
        });
        return list;
    }
}
