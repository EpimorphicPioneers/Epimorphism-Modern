package com.epimorphismmc.epimorphism.common.data.items;

import com.epimorphismmc.epimorphism.Epimorphism;
import com.epimorphismmc.epimorphism.common.data.EPModels;
import com.epimorphismmc.epimorphism.common.item.EtchedItem;
import com.tterrag.registrate.util.entry.ItemEntry;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

import static com.epimorphismmc.epimorphism.EpimorphismCommon.registrate;
import static com.epimorphismmc.epimorphism.common.data.EPCreativeModeTabs.EP_CIRCUIT_REFORM;
import static com.gregtechceu.gtceu.common.data.GTItems.*;

public class EPCircuitItems {

    public static final Object2ObjectOpenHashMap<ItemEntry<? extends Item>, ItemEntry<EtchedItem>> ETCHED_CIRCUIT_MAP = new Object2ObjectOpenHashMap<>();
    public static final Object2ObjectOpenHashMap<ItemEntry<? extends Item>, ItemEntry<EtchedItem>> ETCHED_CIRCUIT_BOARD_MAP = new Object2ObjectOpenHashMap<>();
    public static final Object2ObjectOpenHashMap<ItemEntry<? extends Item>, ItemEntry<EtchedItem>> ETCHED_CIRCUIT_BASE_MAP = new Object2ObjectOpenHashMap<>();

    static {
        registrate().creativeModeTab(() -> EP_CIRCUIT_REFORM);
    }

    // etched circuit
    // Micro
    public static final ItemEntry<EtchedItem> ETCHED_MICRO_PROCESSOR = registerEtchedCircuit(
            PROCESSOR_MV, Epimorphism.id("item/etched/micro"), "processor", "mv");
    public static final ItemEntry<EtchedItem> ETCHED_MICRO_PROCESSOR_ASSEMBLY = registerEtchedCircuit(
            PROCESSOR_ASSEMBLY_HV, Epimorphism.id("item/etched/micro"), "processor_assembly", "hv");
    public static final ItemEntry<EtchedItem> ETCHED_MICRO_COMPUTER = registerEtchedCircuit(
            WORKSTATION_EV, Epimorphism.id("item/etched/micro"), "computer", "ev");
    public static final ItemEntry<EtchedItem> ETCHED_MICRO_MAINFRAME = registerEtchedCircuit(
            MAINFRAME_IV, Epimorphism.id("item/etched/micro"), "mainframe", "iv");

    public static final ItemEntry<EtchedItem> ETCHED_MICRO_PROCESSOR_BOARD = registerEtchedCircuitBoard(
            PROCESSOR_MV, Epimorphism.id("item/etched_board/micro"), "processor", "mv");
    public static final ItemEntry<EtchedItem> ETCHED_MICRO_PROCESSOR_ASSEMBLY_BOARD = registerEtchedCircuitBoard(
            PROCESSOR_ASSEMBLY_HV, Epimorphism.id("item/etched_board/micro"), "processor_assembly", "hv");
    public static final ItemEntry<EtchedItem> ETCHED_MICRO_COMPUTER_BOARD = registerEtchedCircuitBoard(
            WORKSTATION_EV, Epimorphism.id("item/etched_board/micro"), "computer", "ev");
    public static final ItemEntry<EtchedItem> ETCHED_MICRO_MAINFRAME_BOARD = registerEtchedCircuitBoard(
            MAINFRAME_IV, Epimorphism.id("item/etched_board/micro"), "mainframe", "iv");

    public static final ItemEntry<EtchedItem> ETCHED_MICRO_PROCESSOR_BASE = registerEtchedCircuitBase(
            PROCESSOR_MV, Epimorphism.id("item/etched_base/micro"), "processor", "mv");
    public static final ItemEntry<EtchedItem> ETCHED_MICRO_PROCESSOR_ASSEMBLY_BASE = registerEtchedCircuitBase(
            PROCESSOR_ASSEMBLY_HV, Epimorphism.id("item/etched_base/micro"), "processor_assembly", "hv");
    public static final ItemEntry<EtchedItem> ETCHED_MICRO_COMPUTER_BASE = registerEtchedCircuitBase(
            WORKSTATION_EV, Epimorphism.id("item/etched_base/micro"), "computer", "ev");
    public static final ItemEntry<EtchedItem> ETCHED_MICRO_MAINFRAME_BASE = registerEtchedCircuitBase(
            MAINFRAME_IV, Epimorphism.id("item/etched_base/micro"), "mainframe", "iv");

    // Nano
    public static final ItemEntry<EtchedItem> ETCHED_NANO_PROCESSOR = registerEtchedCircuit(
            NANO_PROCESSOR_HV, Epimorphism.id("item/etched/nano"), "processor", "hv");
    public static final ItemEntry<EtchedItem> ETCHED_NANO_PROCESSOR_ASSEMBLY = registerEtchedCircuit(
            NANO_PROCESSOR_ASSEMBLY_EV, Epimorphism.id("item/etched/nano"), "processor_assembly", "ev");
    public static final ItemEntry<EtchedItem> ETCHED_NANO_COMPUTER = registerEtchedCircuit(
            NANO_COMPUTER_IV, Epimorphism.id("item/etched/nano"), "computer", "iv");
    public static final ItemEntry<EtchedItem> ETCHED_NANO_MAINFRAME = registerEtchedCircuit(
            NANO_MAINFRAME_LUV, Epimorphism.id("item/etched/nano"), "mainframe", "luv");

    public static final ItemEntry<EtchedItem> ETCHED_NANO_PROCESSOR_BOARD = registerEtchedCircuitBoard(
            NANO_PROCESSOR_HV, Epimorphism.id("item/etched_board/nano"), "processor", "hv");
    public static final ItemEntry<EtchedItem> ETCHED_NANO_PROCESSOR_ASSEMBLY_BOARD = registerEtchedCircuitBoard(
            NANO_PROCESSOR_ASSEMBLY_EV, Epimorphism.id("item/etched_board/nano"), "processor_assembly", "ev");
    public static final ItemEntry<EtchedItem> ETCHED_NANO_COMPUTER_BOARD = registerEtchedCircuitBoard(
            NANO_COMPUTER_IV, Epimorphism.id("item/etched_board/nano"), "computer", "iv");
    public static final ItemEntry<EtchedItem> ETCHED_NANO_MAINFRAME_BOARD = registerEtchedCircuitBoard(
            NANO_MAINFRAME_LUV, Epimorphism.id("item/etched_board/nano"), "mainframe", "luv");

    public static final ItemEntry<EtchedItem> ETCHED_NANO_PROCESSOR_BASE = registerEtchedCircuitBase(
            NANO_PROCESSOR_HV, Epimorphism.id("item/etched_base/nano"), "processor", "hv");
    public static final ItemEntry<EtchedItem> ETCHED_NANO_PROCESSOR_ASSEMBLY_BASE = registerEtchedCircuitBase(
            NANO_PROCESSOR_ASSEMBLY_EV, Epimorphism.id("item/etched_base/nano"), "processor_assembly", "ev");
    public static final ItemEntry<EtchedItem> ETCHED_NANO_COMPUTER_BASE = registerEtchedCircuitBase(
            NANO_COMPUTER_IV, Epimorphism.id("item/etched_base/nano"), "computer", "iv");
    public static final ItemEntry<EtchedItem> ETCHED_NANO_MAINFRAME_BASE = registerEtchedCircuitBase(
            NANO_MAINFRAME_LUV, Epimorphism.id("item/etched_base/nano"), "mainframe", "luv");

    // Quantum
    public static final ItemEntry<EtchedItem> ETCHED_QUANTUM_PROCESSOR = registerEtchedCircuit(
            QUANTUM_PROCESSOR_EV, Epimorphism.id("item/etched/quantum"), "processor", "ev");
    public static final ItemEntry<EtchedItem> ETCHED_QUANTUM_PROCESSOR_ASSEMBLY = registerEtchedCircuit(
            QUANTUM_ASSEMBLY_IV, Epimorphism.id("item/etched/quantum"), "processor_assembly", "iv");
    public static final ItemEntry<EtchedItem> ETCHED_QUANTUM_COMPUTER = registerEtchedCircuit(
            QUANTUM_COMPUTER_LUV, Epimorphism.id("item/etched/quantum"), "computer", "luv");
    public static final ItemEntry<EtchedItem> ETCHED_QUANTUM_MAINFRAME = registerEtchedCircuit(
            QUANTUM_MAINFRAME_ZPM, Epimorphism.id("item/etched/quantum"), "mainframe", "zpm");

    public static final ItemEntry<EtchedItem> ETCHED_QUANTUM_PROCESSOR_BOARD = registerEtchedCircuitBoard(
            QUANTUM_PROCESSOR_EV, Epimorphism.id("item/etched_board/quantum"), "processor", "ev");
    public static final ItemEntry<EtchedItem> ETCHED_QUANTUM_PROCESSOR_ASSEMBLY_BOARD = registerEtchedCircuitBoard(
            QUANTUM_ASSEMBLY_IV, Epimorphism.id("item/etched_board/quantum"), "processor_assembly", "iv");
    public static final ItemEntry<EtchedItem> ETCHED_QUANTUM_COMPUTER_BOARD = registerEtchedCircuitBoard(
            QUANTUM_COMPUTER_LUV, Epimorphism.id("item/etched_board/quantum"), "computer", "luv");
    public static final ItemEntry<EtchedItem> ETCHED_QUANTUM_MAINFRAME_BOARD = registerEtchedCircuitBoard(
            QUANTUM_MAINFRAME_ZPM, Epimorphism.id("item/etched_board/quantum"), "mainframe", "zpm");

    public static final ItemEntry<EtchedItem> ETCHED_QUANTUM_PROCESSOR_BASE = registerEtchedCircuitBase(
            QUANTUM_PROCESSOR_EV, Epimorphism.id("item/etched_base/quantum"), "processor", "ev");
    public static final ItemEntry<EtchedItem> ETCHED_QUANTUM_PROCESSOR_ASSEMBLY_BASE = registerEtchedCircuitBase(
            QUANTUM_ASSEMBLY_IV, Epimorphism.id("item/etched_base/quantum"), "processor_assembly", "iv");
    public static final ItemEntry<EtchedItem> ETCHED_QUANTUM_COMPUTER_BASE = registerEtchedCircuitBase(
            QUANTUM_COMPUTER_LUV, Epimorphism.id("item/etched_base/quantum"), "computer", "luv");
    public static final ItemEntry<EtchedItem> ETCHED_QUANTUM_MAINFRAME_BASE = registerEtchedCircuitBase(
            QUANTUM_MAINFRAME_ZPM, Epimorphism.id("item/etched_base/quantum"), "mainframe", "zpm");

    // Crystal
    public static final ItemEntry<EtchedItem> ETCHED_CRYSTAL_PROCESSOR = registerEtchedCircuit(
            CRYSTAL_PROCESSOR_IV, Epimorphism.id("item/etched/crystal"), "processor", "iv");
    public static final ItemEntry<EtchedItem> ETCHED_CRYSTAL_PROCESSOR_ASSEMBLY = registerEtchedCircuit(
            CRYSTAL_ASSEMBLY_LUV, Epimorphism.id("item/etched/crystal"), "processor_assembly", "luv");
    public static final ItemEntry<EtchedItem> ETCHED_CRYSTAL_COMPUTER = registerEtchedCircuit(
            CRYSTAL_COMPUTER_ZPM, Epimorphism.id("item/etched/crystal"), "computer", "zpm");
    public static final ItemEntry<EtchedItem> ETCHED_CRYSTAL_MAINFRAME = registerEtchedCircuit(
            CRYSTAL_MAINFRAME_UV, Epimorphism.id("item/etched/crystal"), "mainframe", "uv");

    public static final ItemEntry<EtchedItem> ETCHED_CRYSTAL_PROCESSOR_BOARD = registerEtchedCircuitBoard(
            CRYSTAL_PROCESSOR_IV, Epimorphism.id("item/etched_board/crystal"), "processor", "iv");
    public static final ItemEntry<EtchedItem> ETCHED_CRYSTAL_PROCESSOR_ASSEMBLY_BOARD = registerEtchedCircuitBoard(
            CRYSTAL_ASSEMBLY_LUV, Epimorphism.id("item/etched_board/crystal"), "processor_assembly", "luv");
    public static final ItemEntry<EtchedItem> ETCHED_CRYSTAL_COMPUTER_BOARD = registerEtchedCircuitBoard(
            CRYSTAL_COMPUTER_ZPM, Epimorphism.id("item/etched_board/crystal"), "computer", "zpm");
    public static final ItemEntry<EtchedItem> ETCHED_CRYSTAL_MAINFRAME_BOARD = registerEtchedCircuitBoard(
            CRYSTAL_MAINFRAME_UV, Epimorphism.id("item/etched_board/crystal"), "mainframe", "uv");

    public static final ItemEntry<EtchedItem> ETCHED_CRYSTAL_PROCESSOR_BASE = registerEtchedCircuitBase(
            CRYSTAL_PROCESSOR_IV, Epimorphism.id("item/etched_base/crystal"), "processor", "iv");
    public static final ItemEntry<EtchedItem> ETCHED_CRYSTAL_PROCESSOR_ASSEMBLY_BASE = registerEtchedCircuitBase(
            CRYSTAL_ASSEMBLY_LUV, Epimorphism.id("item/etched_base/crystal"), "processor_assembly", "luv");
    public static final ItemEntry<EtchedItem> ETCHED_CRYSTAL_COMPUTER_BASE = registerEtchedCircuitBase(
            CRYSTAL_COMPUTER_ZPM, Epimorphism.id("item/etched_base/crystal"), "computer", "zpm");
    public static final ItemEntry<EtchedItem> ETCHED_CRYSTAL_MAINFRAME_BASE = registerEtchedCircuitBase(
            CRYSTAL_MAINFRAME_UV, Epimorphism.id("item/etched_base/crystal"), "mainframe", "uv");

    // Wetware
    public static final ItemEntry<EtchedItem> ETCHED_WETWARE_PROCESSOR = registerEtchedCircuit(
            WETWARE_PROCESSOR_LUV, Epimorphism.id("item/etched/wetware"), "processor", "luv");
    public static final ItemEntry<EtchedItem> ETCHED_WETWARE_PROCESSOR_ASSEMBLY = registerEtchedCircuit(
            WETWARE_PROCESSOR_ASSEMBLY_ZPM, Epimorphism.id("item/etched/wetware"), "processor_assembly", "zpm");
    public static final ItemEntry<EtchedItem> ETCHED_WETWARE_COMPUTER = registerEtchedCircuit(
            WETWARE_SUPER_COMPUTER_UV, Epimorphism.id("item/etched/wetware"), "computer", "uv");
    public static final ItemEntry<EtchedItem> ETCHED_WETWARE_MAINFRAME = registerEtchedCircuit(
            WETWARE_MAINFRAME_UHV, Epimorphism.id("item/etched/wetware"), "mainframe", "uhv");

    public static final ItemEntry<EtchedItem> ETCHED_WETWARE_PROCESSOR_BOARD = registerEtchedCircuitBoard(
            WETWARE_PROCESSOR_LUV, Epimorphism.id("item/etched_board/wetware"), "processor", "luv");
    public static final ItemEntry<EtchedItem> ETCHED_WETWARE_PROCESSOR_ASSEMBLY_BOARD = registerEtchedCircuitBoard(
            WETWARE_PROCESSOR_ASSEMBLY_ZPM, Epimorphism.id("item/etched_board/wetware"), "processor_assembly", "zpm");
    public static final ItemEntry<EtchedItem> ETCHED_WETWARE_COMPUTER_BOARD = registerEtchedCircuitBoard(
            WETWARE_SUPER_COMPUTER_UV, Epimorphism.id("item/etched_board/wetware"), "computer", "uv");
    public static final ItemEntry<EtchedItem> ETCHED_WETWARE_MAINFRAME_BOARD = registerEtchedCircuitBoard(
            WETWARE_MAINFRAME_UHV, Epimorphism.id("item/etched_board/wetware"), "mainframe", "uhv");

    public static final ItemEntry<EtchedItem> ETCHED_WETWARE_PROCESSOR_BASE = registerEtchedCircuitBase(
            WETWARE_PROCESSOR_LUV, Epimorphism.id("item/etched_base/wetware"), "processor", "luv");
    public static final ItemEntry<EtchedItem> ETCHED_WETWARE_PROCESSOR_ASSEMBLY_BASE = registerEtchedCircuitBase(
            WETWARE_PROCESSOR_ASSEMBLY_ZPM, Epimorphism.id("item/etched_base/wetware"), "processor_assembly", "zpm");
    public static final ItemEntry<EtchedItem> ETCHED_WETWARE_COMPUTER_BASE = registerEtchedCircuitBase(
            WETWARE_SUPER_COMPUTER_UV, Epimorphism.id("item/etched_base/wetware"), "computer", "uv");
    public static final ItemEntry<EtchedItem> ETCHED_WETWARE_MAINFRAME_BASE = registerEtchedCircuitBase(
            WETWARE_MAINFRAME_UHV, Epimorphism.id("item/etched_base/wetware"), "mainframe", "uhv");


    public static void init() {
        /**/
    }

    public static ItemEntry<EtchedItem> registerEtchedCircuit(ItemEntry<?> circuit, ResourceLocation baseTexture, String circuitType, String voltage) {
        ItemEntry<EtchedItem> entry = registrate()
                .item("etched_" + circuit.getId().getPath(), p -> new EtchedItem(p,  () -> circuit, "etched"))
                .model(EPModels.simpleCustomModel(
                        new ResourceLocation("item/generated"),
                        baseTexture,
                        Epimorphism.id("item/voltage_overlay/" + voltage)
                ))
                .register();
        ETCHED_CIRCUIT_MAP.put(circuit, entry);
        return entry;
    }

    public static ItemEntry<EtchedItem> registerEtchedCircuitBoard(ItemEntry<?> circuit, ResourceLocation baseTexture, String circuitType, String voltage) {
        ItemEntry<EtchedItem> entry = registrate()
                .item("etched_" + circuit.getId().getPath() + "_board", p -> new EtchedItem(p,  () -> circuit, "etched_board"))
                .model(EPModels.simpleCustomModel(
                        new ResourceLocation("item/generated"),
                        baseTexture,
                        Epimorphism.id("item/voltage_overlay/" + voltage)
                )).register();
        ETCHED_CIRCUIT_BOARD_MAP.put(circuit, entry);
        return entry;
    }

    public static ItemEntry<EtchedItem> registerEtchedCircuitBase(ItemEntry<?> circuit, ResourceLocation baseTexture, String circuitType, String voltage) {
        ItemEntry<EtchedItem> entry = registrate()
                .item("etched_" + circuit.getId().getPath() + "_base", p -> new EtchedItem(p,  () -> circuit, "etched_base"))
                .model(EPModels.simpleCustomModel(
                        new ResourceLocation("item/generated"),
                        baseTexture,
                        Epimorphism.id("item/voltage_overlay/" + voltage)
                )).register();
        ETCHED_CIRCUIT_BASE_MAP.put(circuit, entry);
        return entry;
    }
}
