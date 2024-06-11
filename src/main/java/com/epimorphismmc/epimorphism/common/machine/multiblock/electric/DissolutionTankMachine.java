package com.epimorphismmc.epimorphism.common.machine.multiblock.electric;

import com.epimorphismmc.epimorphism.api.machine.feature.multiblock.ITankMachine;

import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableElectricMultiblockMachine;

import com.lowdragmc.lowdraglib.side.fluid.FluidStack;

import net.minecraft.MethodsReturnNonnullByDefault;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class DissolutionTankMachine extends WorkableElectricMultiblockMachine
        implements ITankMachine {
    public DissolutionTankMachine(IMachineBlockEntity holder, Object... args) {
        super(holder, args);
    }

    @Override
    public FluidStack getFluid() {
        return null;
    }
}
