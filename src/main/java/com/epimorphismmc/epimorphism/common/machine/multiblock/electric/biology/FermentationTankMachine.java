package com.epimorphismmc.epimorphism.common.machine.multiblock.electric.biology;

import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableElectricMultiblockMachine;

import com.lowdragmc.lowdraglib.syncdata.field.ManagedFieldHolder;

import org.jetbrains.annotations.NotNull;

public class FermentationTankMachine extends WorkableElectricMultiblockMachine {
    protected static final ManagedFieldHolder MANAGED_FIELD_HOLDER = new ManagedFieldHolder(
            FermentationTankMachine.class, WorkableElectricMultiblockMachine.MANAGED_FIELD_HOLDER);

    public FermentationTankMachine(IMachineBlockEntity holder, Object... args) {
        super(holder, args);
    }

    //////////////////////////////////////
    // ***       Multiblock Data      ***//
    //////////////////////////////////////

    @Override
    public @NotNull ManagedFieldHolder getFieldHolder() {
        return MANAGED_FIELD_HOLDER;
    }
}
