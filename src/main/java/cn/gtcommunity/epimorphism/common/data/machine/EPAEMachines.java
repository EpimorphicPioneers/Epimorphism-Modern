package cn.gtcommunity.epimorphism.common.data.machine;

import cn.gtcommunity.epimorphism.api.machine.multiblock.EPPartAbility;
import cn.gtcommunity.epimorphism.integration.ae2.machine.CraftingInputBufferMachine;
import cn.gtcommunity.epimorphism.integration.ae2.machine.TankAccessHatchMachine;
import com.gregtechceu.gtceu.api.data.RotationState;
import com.gregtechceu.gtceu.api.machine.MachineDefinition;
import com.gregtechceu.gtceu.api.machine.multiblock.PartAbility;
import net.minecraft.network.chat.Component;

import static cn.gtcommunity.epimorphism.Epimorphism.registrate;
import static com.gregtechceu.gtceu.api.GTValues.*;

public class EPAEMachines {

    public final static MachineDefinition TANK_ACCESS_HATCH = registrate().machine("tank_access_hatch", TankAccessHatchMachine::new)
            .langValue("Tank Access Hatch")
            .tier(UHV)
            .rotationState(RotationState.ALL)
            .abilities(EPPartAbility.TANK_ACCESS)
            .overlayTieredHullRenderer("tank_access_hatch")
            .tooltips(Component.translatable("block.epimorphism.tank_hatch.desc.0"))
            .register();

    public final static MachineDefinition CRAFTING_INPUT_BUFFER = registrate().machine("crafting_input_buffer", CraftingInputBufferMachine::new)
            .langValue("Tank Access Hatch")
            .tier(UHV)
            .rotationState(RotationState.ALL)
            .abilities(PartAbility.IMPORT_ITEMS, PartAbility.IMPORT_FLUIDS, PartAbility.EXPORT_ITEMS, PartAbility.EXPORT_FLUIDS)
            .overlayTieredHullRenderer("crafting_input_buffer")
            .tooltips(Component.translatable("block.epimorphism.crafting_input_buffer.desc.0"))
            .register();

    public static void init() {

    }
}
