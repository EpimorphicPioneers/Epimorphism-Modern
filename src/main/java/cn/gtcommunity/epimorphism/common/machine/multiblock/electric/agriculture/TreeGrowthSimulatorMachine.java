package cn.gtcommunity.epimorphism.common.machine.multiblock.electric.agriculture;

import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.feature.IFancyUIMachine;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableMultiblockMachine;

public class TreeGrowthSimulatorMachine extends WorkableMultiblockMachine implements IFancyUIMachine {

    public TreeGrowthSimulatorMachine(IMachineBlockEntity holder, Object... args) {
        super(holder, args);
    }
}
