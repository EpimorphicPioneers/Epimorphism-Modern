package com.epimorphismmc.epimorphism.common.machine.multiblock.generator;

import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableElectricMultiblockMachine;

import net.minecraft.MethodsReturnNonnullByDefault;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class RocketEngineMachine extends WorkableElectricMultiblockMachine {

    public RocketEngineMachine(IMachineBlockEntity holder, Object... args) {
        super(holder, args);
    }
}
