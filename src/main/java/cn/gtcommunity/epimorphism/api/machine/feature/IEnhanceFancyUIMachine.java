package cn.gtcommunity.epimorphism.api.machine.feature;

import cn.gtcommunity.epimorphism.api.machine.fancyconfigurator.MachineParallelFancyConfigurator;
import cn.gtcommunity.epimorphism.api.machine.feature.multiblock.stats.IParallelMachine;
import com.gregtechceu.gtceu.api.gui.fancy.ConfiguratorPanel;
import com.gregtechceu.gtceu.api.machine.feature.IFancyUIMachine;

public interface IEnhanceFancyUIMachine extends IFancyUIMachine {
    @Override
    default void attachConfigurators(ConfiguratorPanel configuratorPanel) {
        IFancyUIMachine.super.attachConfigurators(configuratorPanel);
        if (this instanceof IParallelMachine parallelMachine) {
            configuratorPanel.attachConfigurators(new MachineParallelFancyConfigurator(parallelMachine));
        }
    }
}
