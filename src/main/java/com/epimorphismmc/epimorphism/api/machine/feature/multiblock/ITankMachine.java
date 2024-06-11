package com.epimorphismmc.epimorphism.api.machine.feature.multiblock;

import com.gregtechceu.gtceu.api.machine.feature.IMachineFeature;

import com.lowdragmc.lowdraglib.side.fluid.FluidStack;

public interface ITankMachine extends IMachineFeature {
    FluidStack getFluid();
}
