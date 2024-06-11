package com.epimorphismmc.epimorphism.api.machine.feature.multiblock;

import com.epimorphismmc.epimorphism.common.machine.multiblock.generator.MegaTurbineMachine;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.machine.feature.multiblock.IRotorHolderMachine;
import com.gregtechceu.gtceu.common.item.TurbineRotorBehaviour;

import org.jetbrains.annotations.Nullable;

public interface IReinforcedRotorHolder extends IRotorHolderMachine {

    @Nullable MegaTurbineMachine getTurbine();

    int getTier();

    default Material getRotorMaterial() {
        var rotor = getRotorStack();
        var rotorBehaviour = TurbineRotorBehaviour.getBehaviour(rotor);
        if (rotorBehaviour == null) return null;
        return rotorBehaviour.getPartMaterial(rotor);
    }

    @Override
    default int getTierDifference() {
        var turbine = getTurbine();
        return turbine != null ? getTier() - turbine.getTier() : -1;
    }

    @Override
    default int getMaxRotorHolderSpeed() {
        var turbine = getTurbine();
        return turbine != null ? turbine.getMaxRotorHolderSpeed() : 0;
    }

    @Override
    default int getRotorSpeed() {
        var turbine = getTurbine();
        return turbine != null ? turbine.getRotorSpeed() : 0;
    }

    @Override
    default void setRotorSpeed(int speed) {}
}
