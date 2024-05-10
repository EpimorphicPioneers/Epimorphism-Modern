package cn.gtcommunity.epimorphism.common.machine.multiblock.electric.galaxy.elevatormodules;

import cn.gtcommunity.epimorphism.api.machine.feature.IModuleMachine;
import cn.gtcommunity.epimorphism.common.machine.multiblock.electric.galaxy.SpaceElevatorMachine;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableElectricMultiblockMachine;
import org.jetbrains.annotations.Nullable;

public class ModuleMultiblockMachine extends WorkableElectricMultiblockMachine implements IModuleMachine<SpaceElevatorMachine> {
    public ModuleMultiblockMachine(IMachineBlockEntity holder, Object... args) {
        super(holder, args);
    }

    @Override
    public @Nullable SpaceElevatorMachine getHost() {
        return null;
    }

    @Override
    public void setHost(SpaceElevatorMachine provider) {

    }
}
