package com.epimorphismmc.epimorphism.common.machine.multiblock.noenergy;

import com.epimorphismmc.monomorphism.machine.multiblock.NoEnergyMultiblockMachine;

import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;

import net.minecraft.MethodsReturnNonnullByDefault;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class IndustrialPBFMachine extends NoEnergyMultiblockMachine {
    public IndustrialPBFMachine(IMachineBlockEntity holder, Object... args) {
        super(holder, args);
    }
}
