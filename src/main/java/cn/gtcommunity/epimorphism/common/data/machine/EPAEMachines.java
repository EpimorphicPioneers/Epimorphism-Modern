package cn.gtcommunity.epimorphism.common.data.machine;

import cn.gtcommunity.epimorphism.api.machine.multiblock.EPPartAbility;
import cn.gtcommunity.epimorphism.integration.ae2.machine.TankAccessHatchMachine;
import com.gregtechceu.gtceu.api.data.RotationState;
import com.gregtechceu.gtceu.api.machine.MachineDefinition;
import net.minecraft.network.chat.Component;

import static cn.gtcommunity.epimorphism.common.registry.EPRegistration.EP_REGISTRATE;
import static com.gregtechceu.gtceu.api.GTValues.*;

public class EPAEMachines {

    /*public final static MachineDefinition TANK_ACCESS_HATCH = EP_REGISTRATE.machine("tank_access_hatch", TankAccessHatchMachine::new)
          .langValue("Tank Access Hatch")
          .tier(UHV)
          .rotationState(RotationState.ALL)
          .abilities(EPPartAbility.TANK_ACCESS)
          .overlayTieredHullRenderer("tank_access_hatch")
          .tooltips(Component.translatable("block.epimorphism.tank_hatch.desc.0"))
          .register();*/

    public static void init() {

    }
}
