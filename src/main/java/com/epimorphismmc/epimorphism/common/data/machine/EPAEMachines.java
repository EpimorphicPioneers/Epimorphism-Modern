package com.epimorphismmc.epimorphism.common.data.machine;

import com.epimorphismmc.epimorphism.api.machine.multiblock.EPPartAbility;
import com.epimorphismmc.epimorphism.integration.ae2.machine.TankAccessHatchMachine;

import com.gregtechceu.gtceu.api.data.RotationState;
import com.gregtechceu.gtceu.api.machine.MachineDefinition;

import net.minecraft.network.chat.Component;

import static com.epimorphismmc.epimorphism.EpimorphismCommon.registrate;
import static com.gregtechceu.gtceu.api.GTValues.UHV;

public class EPAEMachines {

    public static final MachineDefinition TANK_ACCESS_HATCH = registrate()
            .machine("tank_access_hatch", TankAccessHatchMachine::new)
            .langValue("Tank Access Hatch")
            .tier(UHV)
            .rotationState(RotationState.ALL)
            .abilities(EPPartAbility.TANK_ACCESS)
            .overlayTieredHullRenderer("tank_access_hatch")
            .tooltips(Component.translatable("block.epimorphism.tank_access_hatch.desc.0"))
            .register();

    public static void init() {}
}
