package cn.gtcommunity.epimorphism.common.data;

import com.gregtechceu.gtceu.api.item.ComponentItem;
import com.gregtechceu.gtceu.api.item.component.IItemComponent;
import com.gregtechceu.gtceu.common.item.TooltipBehavior;
import com.gregtechceu.gtceu.data.recipe.CustomTags;
import com.tterrag.registrate.util.entry.ItemEntry;
import com.tterrag.registrate.util.nullness.NonNullConsumer;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;

import java.util.List;

import static cn.gtcommunity.epimorphism.api.registry.EPRegistries.*;
import static cn.gtcommunity.epimorphism.common.data.EPCreativeModeTabs.*;
import static com.gregtechceu.gtceu.common.data.GTCreativeModeTabs.ITEM;

public class EPItems {
    //  Boards
    public static ItemEntry<ComponentItem> GOOWARE_BOARD;
    public static ItemEntry<ComponentItem> OPTICAL_BOARD;
    public static ItemEntry<ComponentItem> SPINTRONIC_BOARD;
    public static ItemEntry<ComponentItem> GOOWARE_CIRCUIT_BOARD;
    public static ItemEntry<ComponentItem> OPTICAL_CIRCUIT_BOARD;
    public static ItemEntry<ComponentItem> SPINTRONIC_CIRCUIT_BOARD;

    //  Circuits
    public static ItemEntry<ComponentItem> GOOWARE_PROCESSOR;
    public static ItemEntry<ComponentItem> GOOWARE_ASSEMBLY;
    public static ItemEntry<ComponentItem> GOOWARE_COMPUTER;
    public static ItemEntry<ComponentItem> GOOWARE_MAINFRAME;
    public static ItemEntry<ComponentItem> OPTICAL_PROCESSOR;
    public static ItemEntry<ComponentItem> OPTICAL_ASSEMBLY;
    public static ItemEntry<ComponentItem> OPTICAL_COMPUTER;
    public static ItemEntry<ComponentItem> OPTICAL_MAINFRAME;
    public static ItemEntry<ComponentItem> SPINTRONIC_PROCESSOR;
    public static ItemEntry<ComponentItem> SPINTRONIC_ASSEMBLY;
    public static ItemEntry<ComponentItem> SPINTRONIC_COMPUTER;
    public static ItemEntry<ComponentItem> SPINTRONIC_MAINFRAME;
    public static ItemEntry<ComponentItem> COSMIC_PROCESSOR;
    public static ItemEntry<ComponentItem> COSMIC_ASSEMBLY;
    public static ItemEntry<ComponentItem> COSMIC_COMPUTER;
    public static ItemEntry<ComponentItem> COSMIC_MAINFRAME;
    public static ItemEntry<ComponentItem> SUPRACAUSAL_PROCESSOR;
    public static ItemEntry<ComponentItem> SUPRACAUSAL_ASSEMBLY;
    public static ItemEntry<ComponentItem> SUPRACAUSAL_COMPUTER;
    public static ItemEntry<ComponentItem> SUPRACAUSAL_MAINFRAME;

    //  Components
    public static ItemEntry<ComponentItem> OPTICAL_TRANSISTOR;
    public static ItemEntry<ComponentItem> OPTICAL_RESISTOR;
    public static ItemEntry<ComponentItem> OPTICAL_CAPACITOR;
    public static ItemEntry<ComponentItem> OPTICAL_DIODE;
    public static ItemEntry<ComponentItem> OPTICAL_INDUCTOR;
    public static ItemEntry<ComponentItem> SPINTRONIC_TRANSISTOR;
    public static ItemEntry<ComponentItem> SPINTRONIC_RESISTOR;
    public static ItemEntry<ComponentItem> SPINTRONIC_CAPACITOR;
    public static ItemEntry<ComponentItem> SPINTRONIC_DIODE;
    public static ItemEntry<ComponentItem> SPINTRONIC_INDUCTOR;
    public static ItemEntry<ComponentItem> COSMIC_TRANSISTOR;
    public static ItemEntry<ComponentItem> COSMIC_RESISTOR;
    public static ItemEntry<ComponentItem> COSMIC_CAPACITOR;
    public static ItemEntry<ComponentItem> COSMIC_DIODE;
    public static ItemEntry<ComponentItem> COSMIC_INDUCTOR;
    public static ItemEntry<ComponentItem> SUPRACAUSAL_TRANSISTOR;
    public static ItemEntry<ComponentItem> SUPRACAUSAL_RESISTOR;
    public static ItemEntry<ComponentItem> SUPRACAUSAL_CAPACITOR;
    public static ItemEntry<ComponentItem> SUPRACAUSAL_DIODE;
    public static ItemEntry<ComponentItem> SUPRACAUSAL_INDUCTOR;

    //  Gooware Components
    public static ItemEntry<ComponentItem> BZ_REACTION_CHAMBER;
    public static ItemEntry<ComponentItem> NONLINEAR_CHEMICAL_OSCILLATOR;

    //  Optical Components
    public static ItemEntry<ComponentItem> OPTICAL_LASER_CONTROL_UNIT;

    //  Spintronic Components
    public static ItemEntry<ComponentItem> ESR_COMPUTATION_UNIT;

    //  Cosmic Components
    public static ItemEntry<ComponentItem> COSMIC_INFORMATION_MODULE;
    public static ItemEntry<ComponentItem> HOLOGRAPHIC_INFORMATION_IMC;

    //  Supracausal Components
    public static ItemEntry<ComponentItem> SPACETIME_CONDENSER;
    public static ItemEntry<ComponentItem> LIGHT_CONE_MODULE;

    //  Lasers
    public static ItemEntry<ComponentItem> OPTICAL_FIBER;
    public static ItemEntry<ComponentItem> DIELECTRIC_MIRROR;
    public static ItemEntry<ComponentItem> EMPTY_LASER_ASSEMBLY;
    public static ItemEntry<ComponentItem> HELIUM_LASER;
    public static ItemEntry<ComponentItem> NEON_LASER;
    public static ItemEntry<ComponentItem> ARGON_LASER;
    public static ItemEntry<ComponentItem> KRYPTON_LASER;
    public static ItemEntry<ComponentItem> XENON_LASER;
    public static ItemEntry<ComponentItem> HELIUM_NEON_LASER;
    public static ItemEntry<ComponentItem> ND_YAG_LASER;

    //  Condenser Components
    public static ItemEntry<ComponentItem> TOPOLOGICAL_INSULATOR_TUBE;
    public static ItemEntry<ComponentItem> BOSE_EINSTEIN_CONDENSATE_CONTAINMENT_UNIT;
    public static ItemEntry<ComponentItem> BOSE_EINSTEIN_CONDENSATE;

    //  Wafers
    public static ItemEntry<ComponentItem> PHASE_CHANGE_MEMORY;
    public static ItemEntry<ComponentItem> OPTICAL_NOR_MEMORY_CHIP;
    public static ItemEntry<ComponentItem> SPIN_TRANSFER_TORQUE_MEMORY;
    public static ItemEntry<ComponentItem> SPINTRONIC_NAND_MEMORY_CHIP;
    public static ItemEntry<ComponentItem> NANO_PIC_WAFER;
    public static ItemEntry<ComponentItem> NANO_PIC_CHIP;
    public static ItemEntry<ComponentItem> PICO_PIC_WAFER;
    public static ItemEntry<ComponentItem> PICO_PIC_CHIP;
    public static ItemEntry<ComponentItem> FEMTO_PIC_WAFER;
    public static ItemEntry<ComponentItem> FEMTO_PIC_CHIP;
    public static ItemEntry<ComponentItem> ATTO_PIC_WAFER;
    public static ItemEntry<ComponentItem> ATTO_PIC_CHIP;
    public static ItemEntry<ComponentItem> ZEPTO_PIC_WAFER;
    public static ItemEntry<ComponentItem> ZEPTO_PIC_CHIP;
    public static ItemEntry<ComponentItem> DUBNIUM_BOULE;
    public static ItemEntry<ComponentItem> DUBNIUM_WAFER;
    public static ItemEntry<ComponentItem> CUBIC_ZIRCONIA_EUROPIUM_BOULE;
    public static ItemEntry<ComponentItem> CUBIC_ZIRCONIA_EUROPIUM_WAFER;
    public static ItemEntry<ComponentItem> CRYSTAL_INTERFACE_WAFER;
    public static ItemEntry<ComponentItem> CRYSTAL_INTERFACE_CHIP;
    public static ItemEntry<ComponentItem> UHASOC_WAFER;
    public static ItemEntry<ComponentItem> UHASOC_CHIP;
    public static ItemEntry<ComponentItem> INTRAVITAL_SOC;
    public static ItemEntry<ComponentItem> STRONTIUM_CARBONATE_BOHRIUM_BOULE;
    public static ItemEntry<ComponentItem> STRONTIUM_CARBONATE_BOHRIUM_WAFER;
    public static ItemEntry<ComponentItem> STRONTIUM_CARBONATE_OPTICAL_WAFER;
    public static ItemEntry<ComponentItem> OPTICAL_IMC_BOARD;
    public static ItemEntry<ComponentItem> PHOTOELECTRON_SOC;

    //  Others
    public static ItemEntry<Item> MAGNETRON;
    public static ItemEntry<Item> VOLTAGE_COIL_UHV;
    public static ItemEntry<Item> VOLTAGE_COIL_UEV;
    public static ItemEntry<Item> VOLTAGE_COIL_UIV;
    public static ItemEntry<Item> VOLTAGE_COIL_UXV;
    public static ItemEntry<Item> VOLTAGE_COIL_OPV;
    public static ItemEntry<Item> VOLTAGE_COIL_MAX;
    public static ItemEntry<Item> CARBON_ALLOTROPE;
    public static ItemEntry<Item> GRAPHENE_ALIGNED;
    public static ItemEntry<Item> BORON_NITRIDE_GRINDER;
    public static ItemEntry<Item> VACUUM_TUBE_COMPONENT;
    public static ItemEntry<Item> SEPARATION_ELECTROMAGNET;
    public static ItemEntry<Item> PROTONATED_FULLERENE_SIEVING_MATRIX;
    public static ItemEntry<Item> SATURATED_FULLERENE_SIEVING_MATRIX;
    public static ItemEntry<Item> NULL;
    public static ItemEntry<Item> METASTABLE_SELF_HEALING_ADHESIVE;
    public static ItemEntry<Item> HYPERDIMENSIONAL_TACHYON_CONDENSED_MATTER;
    public static ItemEntry<Item> UNSTABLE_STAR;
    public static ItemEntry<Item> CLADDED_OPTICAL_FIBER_CORE;
    public static ItemEntry<Item> CLOSED_TIMELIKE_CURVE_COMPUTATIONAL_UNIT;
    public static ItemEntry<Item> CLOSED_TIMELIKE_CURVE_GUIDANCE_UNIT;
    public static ItemEntry<Item> NUCLEAR_CLOCK;
    public static ItemEntry<Item> MANIFOLD_OSCILLATORY_POWER_CELL;

    public static ItemEntry<Item> SCINTILLATOR;
    public static ItemEntry<Item> SCINTILLATOR_CRYSTAL;

    //  Crystal Components
    public static ItemEntry<Item> DIAMOND_CHIP;
    public static ItemEntry<Item> RUBY_CHIP;
    public static ItemEntry<Item> SAPPHIRE_CHIP;
    public static ItemEntry<Item> DIAMOND_MODULATOR;
    public static ItemEntry<Item> RUBY_MODULATOR;
    public static ItemEntry<Item> SAPPHIRE_MODULATOR;
    public static ItemEntry<Item> CRYSTAL_SOC_SOCKET;

    //  Covers
    public static ItemEntry<Item> ELECTRIC_MOTOR_ULV;
    public static ItemEntry<Item> ELECTRIC_PISTON_ULV;
    public static ItemEntry<Item> ELECTRIC_PUMP_ULV;
    public static ItemEntry<Item> CONVEYOR_MODULE_ULV;
    public static ItemEntry<Item> ROBOT_ARM_ULV;
    public static ItemEntry<Item> EMITTER_ULV;
    public static ItemEntry<Item> SENSOR_ULV;
    public static ItemEntry<Item> FIELD_GENERATOR_ULV;
    public static ItemEntry<Item> ELECTRIC_MOTOR_MAX;
    public static ItemEntry<Item> ELECTRIC_PISTON_MAX;
    public static ItemEntry<Item> ELECTRIC_PUMP_MAX;
    public static ItemEntry<Item> CONVEYOR_MODULE_MAX;
    public static ItemEntry<Item> ROBOT_ARM_MAX;
    public static ItemEntry<Item> EMITTER_MAX;
    public static ItemEntry<Item> SENSOR_MAX;
    public static ItemEntry<Item> FIELD_GENERATOR_MAX;

    //  High Energy Physics items
    public static ItemEntry<Item> PLASMA_CONTAINMENT_CELL;
    public static ItemEntry<Item> RHENIUM_PLASMA_CONTAINMENT_CELL;
    public static ItemEntry<Item> NEUTRON_PLASMA_CONTAINMENT_CELL;
    public static ItemEntry<Item> HYPOGEN_PLASMA_CONTAINMENT_CELL;
    public static ItemEntry<Item> ACTINIUM_SUPERHYDRIDE_PLASMA_CONTAINMENT_CELL;
    public static ItemEntry<Item> QUANTUM_ANOMALY;

    //  Biological
    public static ItemEntry<Item> ELECTROCHEMICAL_GRADIENT_RECORDER;
    public static ItemEntry<Item> ULTRA_MICRO_PHASE_SEPARATOR;
    public static ItemEntry<Item> QUANTUM_TUNNELING_MICROTUBULE;
    public static ItemEntry<Item> HYPERRIBOSOME;
    public static ItemEntry<Item> NEUTRON_ABSORBING_PROTEIN;
    public static ItemEntry<Item> SUPEREXCITED_CONDUCTIVE_POLYMER;
    public static ItemEntry<Item> DNA_ENCODER;
    public static ItemEntry<Item> DNA_DECODER;
    public static ItemEntry<Item> DNA_DECODE_ENCODER;
    public static ItemEntry<Item> GRINDBALL_SOAPSTONE;
    public static ItemEntry<Item> GRINDBALL_ALUMINIUM;
    public static ItemEntry<Item> ORDINARY_ALGAE;
    public static ItemEntry<Item> RED_ALGA;
    public static ItemEntry<Item> GREEN_ALGA;
    public static ItemEntry<Item> CHRYSOPHYCEAE;
    public static ItemEntry<Item> BROWN_ALGA;

    //  Wrap Items
    public static ItemEntry<Item> WRAP_CIRCUIT_ULV;
    public static ItemEntry<Item> WRAP_CIRCUIT_LV;
    public static ItemEntry<Item> WRAP_CIRCUIT_MV;
    public static ItemEntry<Item> WRAP_CIRCUIT_HV;
    public static ItemEntry<Item> WRAP_CIRCUIT_EV;
    public static ItemEntry<Item> WRAP_CIRCUIT_IV;
    public static ItemEntry<Item> WRAP_CIRCUIT_LuV;
    public static ItemEntry<Item> WRAP_CIRCUIT_ZPM;
    public static ItemEntry<Item> WRAP_CIRCUIT_UV;
    public static ItemEntry<Item> WRAP_CIRCUIT_UHV;
    public static ItemEntry<Item> WRAP_CIRCUIT_UEV;
    public static ItemEntry<Item> WRAP_CIRCUIT_UIV;
    public static ItemEntry<Item> WRAP_CIRCUIT_UXV;
    public static ItemEntry<Item> WRAP_CIRCUIT_OpV;
    public static ItemEntry<Item> WRAP_CIRCUIT_MAX;

    //  Debug
    public static ItemEntry<Item> DEBUG_STRUCTURE_WRITER;
    public static ItemEntry<Item> DEBUG_STRUCTURE_BUILDER;
    private EPItems() {}

    public static void init()
    {

        REGISTRATE.creativeModeTab(() -> EP_ITEM);

        //  Boards
        GOOWARE_BOARD = REGISTRATE.item("board.gooware", ComponentItem::create)
                .lang("Kapton™ Board")
                .onRegister(attach(new TooltipBehavior(lines -> {
                    lines.add(Component.translatable("item.epimorphism.board.gooware.tooltip"));
                })))
                .register();
        OPTICAL_BOARD = REGISTRATE.item("board.optical", ComponentItem::create)
                .lang("Gallium Nitride Semiconducting Board")
                .onRegister(attach(new TooltipBehavior(lines -> {
                    lines.add(Component.translatable("item.epimorphism.board.optical.tooltip"));
                })))
                .register();
        SPINTRONIC_BOARD = REGISTRATE.item("board.spintronic", ComponentItem::create)
                .lang("Carbon Nanotube Magnetic storage Board")
                .onRegister(attach(new TooltipBehavior(lines -> {
                    lines.add(Component.translatable("item.epimorphism.board.spintronic.tooltip"));
                })))
                .register();
        GOOWARE_CIRCUIT_BOARD = REGISTRATE.item("circuit_board.gooware", ComponentItem::create)
                .lang("Super Circuit Board")
                .onRegister(attach(new TooltipBehavior(lines -> {
                    lines.add(Component.translatable("item.epimorphism.circuit_board.gooware.tooltip"));
                })))
                .register();
        OPTICAL_CIRCUIT_BOARD = REGISTRATE.item("circuit_board.optical", ComponentItem::create)
                .lang("Ultimate Circuit Board")
                .onRegister(attach(new TooltipBehavior(lines -> {
                    lines.add(Component.translatable("item.epimorphism.circuit_board.optical.tooltip"));
                })))
                .register();
        SPINTRONIC_CIRCUIT_BOARD = REGISTRATE.item("circuit_board.spintronic", ComponentItem::create)
                .lang("Infinite Circuit Board")
                .onRegister(attach(new TooltipBehavior(lines -> {
                    lines.add(Component.translatable("item.epimorphism.circuit_board.spintronic.tooltip"));
                })))
                .register();

        //  Circuits
        GOOWARE_PROCESSOR = REGISTRATE.item("circuit.gooware_processor", ComponentItem::create)
                .lang("Gooware Processor")
                .tag(CustomTags.ZPM_CIRCUITS)
                .onRegister(attach(new TooltipBehavior(lines -> {
                    lines.add(Component.translatable("item.epimorphism.circuit.gooware_processor.tooltip"));
                    lines.add(Component.translatable("item.epimorphism.circuit.zpm.tooltip"));
                })))
                .register();
        GOOWARE_ASSEMBLY = REGISTRATE.item("circuit.gooware_assembly", ComponentItem::create)
                .lang("Gooware Assembly")
                .tag(CustomTags.UV_CIRCUITS)
                .onRegister(attach(new TooltipBehavior(lines -> {
                    lines.add(Component.translatable("item.epimorphism.circuit.gooware_assembly.tooltip"));
                    lines.add(Component.translatable("item.epimorphism.circuit.uv.tooltip"));
                })))
                .register();
        GOOWARE_COMPUTER = REGISTRATE.item("circuit.gooware_computer", ComponentItem::create)
                .lang("Gooware Supercomputer")
                .tag(CustomTags.UHV_CIRCUITS)
                .onRegister(attach(new TooltipBehavior(lines -> {
                    lines.add(Component.translatable("item.epimorphism.circuit.gooware_computer.tooltip"));
                    lines.add(Component.translatable("item.epimorphism.circuit.uhv.tooltip"));
                })))
                .register();
        GOOWARE_MAINFRAME = REGISTRATE.item("circuit.gooware_mainframe", ComponentItem::create)
                .lang("Gooware Mainframe")
                .tag(CustomTags.UEV_CIRCUITS)
                .onRegister(attach(new TooltipBehavior(lines -> {
                    lines.add(Component.translatable("item.epimorphism.circuit.gooware_mainframe.tooltip"));
                    lines.add(Component.translatable("item.epimorphism.circuit.uev.tooltip"));
                })))
                .register();
        OPTICAL_PROCESSOR = REGISTRATE.item("circuit.optical_processor", ComponentItem::create)
                .lang("Optical IMC Processor")
                .tag(CustomTags.UV_CIRCUITS)
                .onRegister(attach(new TooltipBehavior(lines -> {
                    lines.add(Component.translatable("item.epimorphism.circuit.optical_processor.tooltip"));
                    lines.add(Component.translatable("item.epimorphism.circuit.uv.tooltip"));
                })))
                .register();
        OPTICAL_ASSEMBLY = REGISTRATE.item("circuit.optical_assembly", ComponentItem::create)
                .lang("Optical IMC Assembly")
                .tag(CustomTags.UHV_CIRCUITS)
                .onRegister(attach(new TooltipBehavior(lines -> {
                    lines.add(Component.translatable("item.epimorphism.circuit.optical_assembly.tooltip"));
                    lines.add(Component.translatable("item.epimorphism.circuit.uhv.tooltip"));
                })))
                .register();
        OPTICAL_COMPUTER = REGISTRATE.item("circuit.optical_computer", ComponentItem::create)
                .lang("Optical IMC Supercomputer")
                .tag(CustomTags.UEV_CIRCUITS)
                .onRegister(attach(new TooltipBehavior(lines -> {
                    lines.add(Component.translatable("item.epimorphism.circuit.optical_computer.tooltip"));
                    lines.add(Component.translatable("item.epimorphism.circuit.uev.tooltip"));
                })))
                .register();
        OPTICAL_MAINFRAME = REGISTRATE.item("circuit.optical_mainframe", ComponentItem::create)
                .lang("Optical IMC Mainframe")
                .tag(CustomTags.UIV_CIRCUITS)
                .onRegister(attach(new TooltipBehavior(lines -> {
                    lines.add(Component.translatable("item.epimorphism.circuit.optical_mainframe.tooltip"));
                    lines.add(Component.translatable("item.epimorphism.circuit.uiv.tooltip"));
                })))
                .register();
        SPINTRONIC_PROCESSOR = REGISTRATE.item("circuit.spintronic_processor", ComponentItem::create)
                .lang("Spintronic IMC Processor")
                .tag(CustomTags.UHV_CIRCUITS)
                .onRegister(attach(new TooltipBehavior(lines -> {
                    lines.add(Component.translatable("item.epimorphism.circuit.spintronic_processor.tooltip"));
                    lines.add(Component.translatable("item.epimorphism.circuit.uhv.tooltip"));
                })))
                .register();
        SPINTRONIC_ASSEMBLY = REGISTRATE.item("circuit.spintronic_assembly", ComponentItem::create)
                .lang("Spintronic IMC Assembly")
                .tag(CustomTags.UEV_CIRCUITS)
                .onRegister(attach(new TooltipBehavior(lines -> {
                    lines.add(Component.translatable("item.epimorphism.circuit.spintronic_assembly.tooltip"));
                    lines.add(Component.translatable("item.epimorphism.circuit.uev.tooltip"));
                })))
                .register();
        SPINTRONIC_COMPUTER = REGISTRATE.item("circuit.spintronic_computer", ComponentItem::create)
                .lang("Spintronic IMC Supercomputer")
                .tag(CustomTags.UIV_CIRCUITS)
                .onRegister(attach(new TooltipBehavior(lines -> {
                    lines.add(Component.translatable("item.epimorphism.circuit.spintronic_computer.tooltip"));
                    lines.add(Component.translatable("item.epimorphism.circuit.uiv.tooltip"));
                })))
                .register();
        SPINTRONIC_MAINFRAME = REGISTRATE.item("circuit.spintronic_mainframe", ComponentItem::create)
                .lang("Spintronic IMC Mainframe")
                .tag(CustomTags.UXV_CIRCUITS)
                .onRegister(attach(new TooltipBehavior(lines -> {
                    lines.add(Component.translatable("item.epimorphism.circuit.spintronic_mainframe.tooltip"));
                    lines.add(Component.translatable("item.epimorphism.circuit.uxv.tooltip"));
                })))
                .register();
        COSMIC_PROCESSOR = REGISTRATE.item("circuit.cosmic_processor", ComponentItem::create)
                .lang("Cosmic Planetary Processor")
                .tag(CustomTags.UEV_CIRCUITS)
                .onRegister(attach(new TooltipBehavior(lines -> {
                    lines.add(Component.translatable("item.epimorphism.circuit.cosmic_processor.tooltip"));
                    lines.add(Component.translatable("item.epimorphism.circuit.uev.tooltip"));
                })))
                .register();
        COSMIC_ASSEMBLY = REGISTRATE.item("circuit.cosmic_assembly", ComponentItem::create)
                .lang("Cosmic Planetary Assembly")
                .tag(CustomTags.UIV_CIRCUITS)
                .onRegister(attach(new TooltipBehavior(lines -> {
                    lines.add(Component.translatable("item.epimorphism.circuit.cosmic_assembly.tooltip"));
                    lines.add(Component.translatable("item.epimorphism.circuit.uiv.tooltip"));
                })))
                .register();
        COSMIC_COMPUTER = REGISTRATE.item("circuit.cosmic_computer", ComponentItem::create)
                .lang("Cosmic Planetary Supercomputer")
                .tag(CustomTags.UXV_CIRCUITS)
                .onRegister(attach(new TooltipBehavior(lines -> {
                    lines.add(Component.translatable("item.epimorphism.circuit.cosmic_computer.tooltip"));
                    lines.add(Component.translatable("item.epimorphism.circuit.uxv.tooltip"));
                })))
                .register();
        COSMIC_MAINFRAME = REGISTRATE.item("circuit.cosmic_mainframe", ComponentItem::create)
                .lang("Cosmic Planetary Mainframe")
                .tag(CustomTags.OpV_CIRCUITS)
                .onRegister(attach(new TooltipBehavior(lines -> {
                    lines.add(Component.translatable("item.epimorphism.circuit.cosmic_mainframe.tooltip"));
                    lines.add(Component.translatable("item.epimorphism.circuit.opv.tooltip"));
                })))
                .register();
        SUPRACAUSAL_PROCESSOR = REGISTRATE.item("circuit.supracausal_processor", ComponentItem::create)
                .lang("Supracausal Galactic Processor")
                .tag(CustomTags.UIV_CIRCUITS)
                .onRegister(attach(new TooltipBehavior(lines -> {
                    lines.add(Component.translatable("item.epimorphism.circuit.supracausal_processor.tooltip"));
                    lines.add(Component.translatable("item.epimorphism.circuit.uiv.tooltip"));
                })))
                .register();
        SUPRACAUSAL_ASSEMBLY = REGISTRATE.item("circuit.supracausal_assembly", ComponentItem::create)
                .lang("Supracausal Galactic Assembly")
                .tag(CustomTags.UXV_CIRCUITS)
                .onRegister(attach(new TooltipBehavior(lines -> {
                    lines.add(Component.translatable("item.epimorphism.circuit.supracausal_assembly.tooltip"));
                    lines.add(Component.translatable("item.epimorphism.circuit.uxv.tooltip"));
                })))
                .register();
        SUPRACAUSAL_COMPUTER = REGISTRATE.item("circuit.supracausal_computer", ComponentItem::create)
                .lang("Supracausal Galactic Supercomputer")
                .tag(CustomTags.OpV_CIRCUITS)
                .onRegister(attach(new TooltipBehavior(lines -> {
                    lines.add(Component.translatable("item.epimorphism.circuit.supracausal_computer.tooltip"));
                    lines.add(Component.translatable("item.epimorphism.circuit.opv.tooltip"));
                })))
                .register();
        SUPRACAUSAL_MAINFRAME = REGISTRATE.item("circuit.supracausal_mainframe", ComponentItem::create)
                .lang("Supracausal Galactic Mainframe")
                .tag(CustomTags.MAX_CIRCUITS)
                .onRegister(attach(new TooltipBehavior(lines -> {
                    lines.add(Component.translatable("item.epimorphism.circuit.supracausal_mainframe.tooltip"));
                    lines.add(Component.translatable("item.epimorphism.circuit.max.tooltip"));
                })))
                .register();

        //  Components
        OPTICAL_TRANSISTOR = REGISTRATE.item("component.optical_smd.transistor", ComponentItem::create)
                .lang("Phototransistor")
                .onRegister(attach(new TooltipBehavior(lines -> {
                    lines.add(Component.translatable("item.epimorphism.component.optical_smd.transistor.tooltip"));
                })))
                .register();
        OPTICAL_RESISTOR = REGISTRATE.item("component.optical_smd.resistor", ComponentItem::create)
                .lang("Photoresistor")
                .onRegister(attach(new TooltipBehavior(lines -> {
                    lines.add(Component.translatable("item.epimorphism.component.optical_smd.resistor.tooltip"));
                })))
                .register();
        OPTICAL_CAPACITOR = REGISTRATE.item("component.optical_smd.capacitor", ComponentItem::create)
                .lang("Optical Integrator")
                .onRegister(attach(new TooltipBehavior(lines -> {
                    lines.add(Component.translatable("item.epimorphism.component.optical_smd.capacitor.tooltip"));
                })))
                .register();
        OPTICAL_DIODE = REGISTRATE.item("component.optical_smd.diode", ComponentItem::create)
                .lang("Optical Isolator")
                .onRegister(attach(new TooltipBehavior(lines -> {
                    lines.add(Component.translatable("item.epimorphism.component.optical_smd.diode.tooltip"));
                })))
                .register();
        OPTICAL_INDUCTOR = REGISTRATE.item("component.optical_smd.inductor", ComponentItem::create)
                .lang("Optical Polarizer")
                .onRegister(attach(new TooltipBehavior(lines -> {
                    lines.add(Component.translatable("item.epimorphism.component.optical_smd.inductor.tooltip"));
                })))
                .register();
        SPINTRONIC_TRANSISTOR = REGISTRATE.item("component.spintronic_smd.transistor", ComponentItem::create)
                .lang("MOSFET")
                .onRegister(attach(new TooltipBehavior(lines -> {
                    lines.add(Component.translatable("item.epimorphism.component.spintronic_smd.transistor.tooltip"));
                })))
                .register();
        SPINTRONIC_RESISTOR = REGISTRATE.item("component.spintronic_smd.resistor", ComponentItem::create)
                .lang("Magnetoresistor")
                .onRegister(attach(new TooltipBehavior(lines -> {
                    lines.add(Component.translatable("item.epimorphism.component.spintronic_smd.resistor.tooltip"));
                })))
                .register();
        SPINTRONIC_CAPACITOR = REGISTRATE.item("component.spintronic_smd.capacitor", ComponentItem::create)
                .lang("Ultracapacitor")
                .onRegister(attach(new TooltipBehavior(lines -> {
                    lines.add(Component.translatable("item.epimorphism.component.spintronic_smd.capacitor.tooltip"));
                })))
                .register();
        SPINTRONIC_DIODE = REGISTRATE.item("component.spintronic_smd.diode", ComponentItem::create)
                .lang("Schottky Diode")
                .onRegister(attach(new TooltipBehavior(lines -> {
                    lines.add(Component.translatable("item.epimorphism.component.spintronic_smd.diode.tooltip"));
                })))
                .register();
        SPINTRONIC_INDUCTOR = REGISTRATE.item("component.spintronic_smd.inductor", ComponentItem::create)
                .lang("Spin Polarizer")
                .onRegister(attach(new TooltipBehavior(lines -> {
                    lines.add(Component.translatable("item.epimorphism.component.spintronic_smd.inductor.tooltip"));
                })))
                .register();
        COSMIC_TRANSISTOR = REGISTRATE.item("component.cosmic_smd.transistor", ComponentItem::create)
                .lang("Crystal Information Payload")
                .onRegister(attach(new TooltipBehavior(lines -> {
                    lines.add(Component.translatable("item.epimorphism.component.cosmic_smd.transistor.tooltip"));
                })))
                .register();
        COSMIC_RESISTOR = REGISTRATE.item("component.cosmic_smd.resistor", ComponentItem::create)
                .lang("Micro Interstellar material Information Wall")
                .onRegister(attach(new TooltipBehavior(lines -> {
                    lines.add(Component.translatable("item.epimorphism.component.cosmic_smd.resistor.tooltip"));
                })))
                .register();
        COSMIC_CAPACITOR = REGISTRATE.item("component.cosmic_smd.capacitor", ComponentItem::create)
                .lang("Holographic Energy Charge")
                .onRegister(attach(new TooltipBehavior(lines -> {
                    lines.add(Component.translatable("item.epimorphism.component.cosmic_smd.capacitor.tooltip"));
                })))
                .register();
        COSMIC_DIODE = REGISTRATE.item("component.cosmic_smd.diode", ComponentItem::create)
                .lang("Cosmic Ion Diode")
                .onRegister(attach(new TooltipBehavior(lines -> {
                    lines.add(Component.translatable("item.epimorphism.component.cosmic_smd.diode.tooltip"));
                })))
                .register();
        COSMIC_INDUCTOR = REGISTRATE.item("component.cosmic_smd.inductor", ComponentItem::create)
                .lang("Zenith Polarizer")
                .onRegister(attach(new TooltipBehavior(lines -> {
                    lines.add(Component.translatable("item.epimorphism.component.cosmic_smd.inductor.tooltip"));
                })))
                .register();
        SUPRACAUSAL_TRANSISTOR = REGISTRATE.item("component.supracausal_smd.transistor", ComponentItem::create)
                .lang("Kaluza-Klein Extradimensional Dilator Field Effect Transistor")
                .onRegister(attach(new TooltipBehavior(lines -> {
                    lines.add(Component.translatable("item.epimorphism.component.supracausal_smd.transistor.tooltip"));
                })))
                .register();
        SUPRACAUSAL_RESISTOR = REGISTRATE.item("component.supracausal_smd.resistor", ComponentItem::create)
                .lang("Non anomalous Quantum Main Constraint Generator")
                .onRegister(attach(new TooltipBehavior(lines -> {
                    lines.add(Component.translatable("item.epimorphism.component.supracausal_smd.resistor.tooltip"));
                })))
                .register();
        SUPRACAUSAL_CAPACITOR = REGISTRATE.item("component.supracausal_smd.capacitor", ComponentItem::create)
                .lang("Energy-Momentum-Stress Tensor Memory")
                .onRegister(attach(new TooltipBehavior(lines -> {
                    lines.add(Component.translatable("item.epimorphism.component.supracausal_smd.capacitor.tooltip"));
                })))
                .register();
        SUPRACAUSAL_DIODE = REGISTRATE.item("component.supracausal_smd.diode", ComponentItem::create)
                .lang("Spin network Carrier Diode")
                .onRegister(attach(new TooltipBehavior(lines -> {
                    lines.add(Component.translatable("item.epimorphism.component.supracausal_smd.diode.tooltip"));
                })))
                .register();
        SUPRACAUSAL_INDUCTOR = REGISTRATE.item("component.supracausal_smd.inductor", ComponentItem::create)
                .lang("Supersymmetric Conformal Polarizer")
                .onRegister(attach(new TooltipBehavior(lines -> {
                    lines.add(Component.translatable("item.epimorphism.component.supracausal_smd.inductor.tooltip"));
                })))
                .register();

        //  Gooware Components
        BZ_REACTION_CHAMBER = REGISTRATE.item("component.gooware.reaction_chamber", ComponentItem::create)
                .lang("Belousov-Zhabotinsky Reaction Chamber")
                .register();
        NONLINEAR_CHEMICAL_OSCILLATOR = REGISTRATE.item("component.gooware.nonlinear_chemical_oscillator", ComponentItem::create)
                .lang("Nonlinear Chemical Oscillator")
                .onRegister(attach(new TooltipBehavior(lines -> {
                    lines.add(Component.translatable("item.epimorphism.component.gooware.nonlinear_chemical_oscillator.tooltip"));
                })))
                .register();

        //  Optical Components
        OPTICAL_LASER_CONTROL_UNIT = REGISTRATE.item("component.optical.optical_laser_control_unit", ComponentItem::create)
                .lang("Optical Laser Control Unit")
                .onRegister(attach(new TooltipBehavior(lines -> {
                    lines.add(Component.translatable("item.epimorphism.component.optical.optical_laser_control_unit.tooltip"));
                })))
                .register();

        //  Spintronic Components
        ESR_COMPUTATION_UNIT = REGISTRATE.item("component.spintronic.esr_computation_unit", ComponentItem::create)
                .lang("ESR Computation Unit")
                .onRegister(attach(new TooltipBehavior(lines -> {
                    lines.add(Component.translatable("item.epimorphism.component.spintronic.esr_computation_unit.tooltip"));
                })))
                .register();

        //  Cosmic Components
        COSMIC_INFORMATION_MODULE = REGISTRATE.item("component.cosmic.information_module", ComponentItem::create)
                .lang("Cosmic Information Module")
                .onRegister(attach(new TooltipBehavior(lines -> {
                    lines.add(Component.translatable("item.epimorphism.component.cosmic.information_module.tooltip"));
                })))
                .register();
        HOLOGRAPHIC_INFORMATION_IMC = REGISTRATE.item("component.cosmic.holographic_imc", ComponentItem::create)
                .lang("Holographic IMC")
                .onRegister(attach(new TooltipBehavior(lines -> {
                    lines.add(Component.translatable("item.epimorphism.component.cosmic.holographic_imc.tooltip"));
                })))
                .register();

        //  Supracausal Components
        SPACETIME_CONDENSER = REGISTRATE.item("component.supracausal.spacetime_condenser", ComponentItem::create)
                .lang("Supracausal SpaceTime Condenser")
                .onRegister(attach(new TooltipBehavior(lines -> {
                    lines.add(Component.translatable("item.epimorphism.component.supracausal.spacetime_condenser.tooltip"));
                })))
                .register();
        LIGHT_CONE_MODULE = REGISTRATE.item("component.supracausal.light_cone_module", ComponentItem::create)
                .lang("Spacetime Light cone Stabilization Module")
                .onRegister(attach(new TooltipBehavior(lines -> {
                    lines.add(Component.translatable("item.epimorphism.component.supracausal.light_cone_module.tooltip"));
                })))
                .register();

        //  Lasers
        OPTICAL_FIBER = REGISTRATE.item("laser.optical_fiber", ComponentItem::create)
                .lang("Optical Fiber")
                .onRegister(attach(new TooltipBehavior(lines -> {
                    lines.add(Component.translatable("item.epimorphism.laser.optical_fiber.tooltip"));
                })))
                .register();
        DIELECTRIC_MIRROR = REGISTRATE.item("laser.dielectric_mirror", ComponentItem::create)
                .lang("Dielectric Mirror")
                .onRegister(attach(new TooltipBehavior(lines -> {
                    lines.add(Component.translatable("item.epimorphism.laser.dielectric_mirror.tooltip"));
                })))
                .register();
        EMPTY_LASER_ASSEMBLY = REGISTRATE.item("laser.emitter.empty", ComponentItem::create)
                .lang("Empty Laser Assembly")
                .onRegister(attach(new TooltipBehavior(lines -> {
                    lines.add(Component.translatable("item.epimorphism.laser.emitter.empty.tooltip"));
                })))
                .register();
        HELIUM_LASER = REGISTRATE.item("laser.emitter.helium", ComponentItem::create)
                .lang("Helium Laser Emitter")
                .register();
        NEON_LASER = REGISTRATE.item("laser.emitter.neon", ComponentItem::create)
                .lang("Neon Laser Emitter")
                .register();
        ARGON_LASER = REGISTRATE.item("laser.emitter.argon", ComponentItem::create)
                .lang("Argon Laser Emitter")
                .register();
        KRYPTON_LASER = REGISTRATE.item("laser.emitter.krypton", ComponentItem::create)
                .lang("Krypton Laser Emitter")
                .register();
        XENON_LASER = REGISTRATE.item("laser.emitter.xenon", ComponentItem::create)
                .lang("Xenon Laser Emitter")
                .register();
        HELIUM_NEON_LASER = REGISTRATE.item("laser.emitter.helium_neon", ComponentItem::create)
                .lang("Helium-Neon Laser")
                .onRegister(attach(new TooltipBehavior(lines -> {
                    lines.add(Component.translatable("item.epimorphism.laser.emitter.helium_neon.tooltip"));
                })))
                .register();
        ND_YAG_LASER = REGISTRATE.item("laser.emitter.nd_yag", ComponentItem::create)
                .lang("Nd:YAG Laser Emitter")
                .onRegister(attach(new TooltipBehavior(lines -> {
                    lines.add(Component.translatable("item.epimorphism.laser.emitter.nd_yag.tooltip"));
                })))
                .register();

        //  Condenser Components
        TOPOLOGICAL_INSULATOR_TUBE = REGISTRATE.item("tube.topological_insulator", ComponentItem::create)
                .lang("Topological Insulator Tube")
                .onRegister(attach(new TooltipBehavior(lines -> {
                    lines.add(Component.translatable("item.epimorphism.tube.topological_insulator.tooltip"));
                })))
                .register();
        BOSE_EINSTEIN_CONDENSATE_CONTAINMENT_UNIT = REGISTRATE.item("containment_unit.bose_einstein_condensate", ComponentItem::create)
                .lang("Bose-Einstein Condensate Containment Unit")
                .onRegister(attach(new TooltipBehavior(lines -> {
                    lines.add(Component.translatable("item.epimorphism.containment_unit.bose_einstein_condensate.tooltip"));
                })))
                .register();
        BOSE_EINSTEIN_CONDENSATE = REGISTRATE.item("bose_einstein_condensate", ComponentItem::create)
                .lang("Bose-Einstein Condensate")
                .onRegister(attach(new TooltipBehavior(lines -> {
                    lines.add(Component.translatable("item.epimorphism.bose_einstein_condensate.tooltip"));
                })))
                .register();

        //  Wafers
        PHASE_CHANGE_MEMORY = REGISTRATE.item("wafer.chip.phase_change_memory", ComponentItem::create)
                .lang("PRAM")
                .onRegister(attach(new TooltipBehavior(lines -> {
                    lines.add(Component.translatable("item.epimorphism.wafer.chip.phase_change_memory.tooltip"));
                })))
                .register();
        OPTICAL_NOR_MEMORY_CHIP = REGISTRATE.item("wafer.chip.optical_nor_memory_chip", ComponentItem::create)
                .lang("ACNOR")
                .onRegister(attach(new TooltipBehavior(lines -> {
                    lines.add(Component.translatable("item.epimorphism.wafer.chip.optical_nor_memory_chip.tooltip"));
                })))
                .register();
        SPIN_TRANSFER_TORQUE_MEMORY = REGISTRATE.item("wafer.chip.spin_transfer_torque_memory", ComponentItem::create)
                .lang("STTRAM")
                .onRegister(attach(new TooltipBehavior(lines -> {
                    lines.add(Component.translatable("item.epimorphism.wafer.chip.spin_transfer_torque_memory.tooltip"));
                })))
                .register();
        SPINTRONIC_NAND_MEMORY_CHIP = REGISTRATE.item("wafer.chip.spintronic_nand_memory_chip", ComponentItem::create)
                .lang("MDNAND")
                .onRegister(attach(new TooltipBehavior(lines -> {
                    lines.add(Component.translatable("item.epimorphism.wafer.chip.spintronic_nand_memory_chip.tooltip"));
                })))
                .register();
        NANO_PIC_WAFER = REGISTRATE.item("wafer.nano_pic", ComponentItem::create)
                .lang("NPIC Wafer")
                .onRegister(attach(new TooltipBehavior(lines -> {
                    lines.add(Component.translatable("item.epimorphism.wafer.nano_pic.tooltip"));
                })))
                .register();
        NANO_PIC_CHIP = REGISTRATE.item("wafer.chip.nano_pic", ComponentItem::create)
                .lang("NPIC")
                .onRegister(attach(new TooltipBehavior(lines -> {
                    lines.add(Component.translatable("item.epimorphism.wafer.chip.nano_pic.tooltip"));
                })))
                .register();
        PICO_PIC_WAFER = REGISTRATE.item("wafer.pico_pic", ComponentItem::create)
                .lang("PPIC Wafer")
                .onRegister(attach(new TooltipBehavior(lines -> {
                    lines.add(Component.translatable("item.epimorphism.wafer.pico_pic.tooltip"));
                })))
                .register();
        PICO_PIC_CHIP = REGISTRATE.item("wafer.chip.pico_pic", ComponentItem::create)
                .lang("PPIC")
                .onRegister(attach(new TooltipBehavior(lines -> {
                    lines.add(Component.translatable("item.epimorphism.wafer.chip.pico_pic.tooltip"));
                })))
                .register();
        FEMTO_PIC_WAFER = REGISTRATE.item("wafer.femto_pic", ComponentItem::create)
                .lang("FPIC Wafer")
                .onRegister(attach(new TooltipBehavior(lines -> {
                    lines.add(Component.translatable("item.epimorphism.wafer.femto_pic.tooltip"));
                })))
                .register();
        FEMTO_PIC_CHIP = REGISTRATE.item("wafer.chip.femto_pic", ComponentItem::create)
                .lang("FPIC")
                .onRegister(attach(new TooltipBehavior(lines -> {
                    lines.add(Component.translatable("item.epimorphism.wafer.chip.femto_pic.tooltip"));
                })))
                .register();
        ATTO_PIC_WAFER = REGISTRATE.item("wafer.atto_pic", ComponentItem::create)
                .lang("APIC Wafer")
                .onRegister(attach(new TooltipBehavior(lines -> {
                    lines.add(Component.translatable("item.epimorphism.wafer.atto_pic.tooltip"));
                })))
                .register();
        ATTO_PIC_CHIP = REGISTRATE.item("wafer.chip.atto_pic", ComponentItem::create)
                .lang("APIC")
                .onRegister(attach(new TooltipBehavior(lines -> {
                    lines.add(Component.translatable("item.epimorphism.wafer.chip.atto_pic.tooltip"));
                })))
                .register();
        ZEPTO_PIC_WAFER = REGISTRATE.item("wafer.zepto_pic", ComponentItem::create)
                .lang("ZPIC Wafer")
                .onRegister(attach(new TooltipBehavior(lines -> {
                    lines.add(Component.translatable("item.epimorphism.wafer.zepto_pic.tooltip"));
                })))
                .register();
        ZEPTO_PIC_CHIP = REGISTRATE.item("wafer.chip.zepto_pic", ComponentItem::create)
                .lang("ZPIC")
                .onRegister(attach(new TooltipBehavior(lines -> {
                    lines.add(Component.translatable("item.epimorphism.wafer.chip.zepto_pic.tooltip"));
                })))
                .register();
        DUBNIUM_BOULE = REGISTRATE.item("boule.dubnium", ComponentItem::create)
                .lang("Dubnium-doped Monocrystalline Silicon Boule")
                .onRegister(attach(new TooltipBehavior(lines -> {
                    lines.add(Component.translatable("item.epimorphism.boule.dubnium.tooltip"));
                })))
                .register();
        DUBNIUM_WAFER = REGISTRATE.item("wafer.dubnium", ComponentItem::create)
                .lang("Dubnium-doped Wafer")
                .onRegister(attach(new TooltipBehavior(lines -> {
                    lines.add(Component.translatable("item.epimorphism.wafer.dubnium.tooltip"));
                })))
                .register();
        CUBIC_ZIRCONIA_EUROPIUM_BOULE = REGISTRATE.item("boule.cubic_zirconia.europium", ComponentItem::create)
                .lang("Europium-doped Monocrystalline Cubic Zirconia Boule")
                .onRegister(attach(new TooltipBehavior(lines -> {
                    lines.add(Component.translatable("item.epimorphism.boule.cubic_zirconia.europium.tooltip"));
                })))
                .register();
        CUBIC_ZIRCONIA_EUROPIUM_WAFER = REGISTRATE.item("wafer.cubic_zirconia.europium", ComponentItem::create)
                .lang("Europium-doped Cubic Zirconia Wafer")
                .onRegister(attach(new TooltipBehavior(lines -> {
                    lines.add(Component.translatable("item.epimorphism.wafer.cubic_zirconia.europium.tooltip"));
                })))
                .register();
        CRYSTAL_INTERFACE_WAFER = REGISTRATE.item("wafer.crystal_interface", ComponentItem::create)
                .lang("Crystal Interface Wafer")
                .onRegister(attach(new TooltipBehavior(lines -> {
                    lines.add(Component.translatable("item.epimorphism.wafer.crystal_interface.tooltip"));
                })))
                .register();
        CRYSTAL_INTERFACE_CHIP = REGISTRATE.item("wafer.chip.crystal_interface", ComponentItem::create)
                .lang("Infinite Circuit Board")
                .onRegister(attach(new TooltipBehavior(lines -> {
                    lines.add(Component.translatable("item.epimorphism.wafer.chip.crystal_interface.tooltip"));
                })))
                .register();
        UHASOC_WAFER = REGISTRATE.item("wafer.uhasoc", ComponentItem::create)
                .lang("Infinite Circuit Board")
                .onRegister(attach(new TooltipBehavior(lines -> {
                    lines.add(Component.translatable("item.epimorphism.wafer.uhasoc.tooltip"));
                })))
                .register();
        UHASOC_CHIP = REGISTRATE.item("wafer.chip.uhasoc", ComponentItem::create)
                .lang("Infinite Circuit Board")
                .onRegister(attach(new TooltipBehavior(lines -> {
                    lines.add(Component.translatable("item.epimorphism.wafer.chip.uhasoc.tooltip"));
                })))
                .register();
        INTRAVITAL_SOC = REGISTRATE.item("component.gooware.intravital_soc", ComponentItem::create)
                .lang("Infinite Circuit Board")
                .onRegister(attach(new TooltipBehavior(lines -> {
                    lines.add(Component.translatable("item.epimorphism.component.gooware.intravital_soc.tooltip"));
                })))
                .register();
        STRONTIUM_CARBONATE_BOHRIUM_BOULE = REGISTRATE.item("boule.strontium_carbonate.bohrium", ComponentItem::create)
                .lang("Infinite Circuit Board")
                .onRegister(attach(new TooltipBehavior(lines -> {
                    lines.add(Component.translatable("item.epimorphism.boule.strontium_carbonate.bohrium.tooltip"));
                })))
                .register();
        STRONTIUM_CARBONATE_BOHRIUM_WAFER = REGISTRATE.item("wafer.strontium_carbonate.bohrium", ComponentItem::create)
                .lang("Infinite Circuit Board")
                .onRegister(attach(new TooltipBehavior(lines -> {
                    lines.add(Component.translatable("item.epimorphism.wafer.strontium_carbonate.bohrium.tooltip"));
                })))
                .register();
        STRONTIUM_CARBONATE_OPTICAL_WAFER = REGISTRATE.item("component.optical.strontium_carbonate_wafer", ComponentItem::create)
                .lang("Infinite Circuit Board")
                .onRegister(attach(new TooltipBehavior(lines -> {
                    lines.add(Component.translatable("item.epimorphism.component.optical.strontium_carbonate_wafer.tooltip"));
                })))
                .register();
        OPTICAL_IMC_BOARD = REGISTRATE.item("component.optical.optical_imc_board", ComponentItem::create)
                .lang("Infinite Circuit Board")
                .onRegister(attach(new TooltipBehavior(lines -> {
                    lines.add(Component.translatable("item.epimorphism.component.optical.optical_imc_board.tooltip"));
                })))
                .register();
        PHOTOELECTRON_SOC = REGISTRATE.item("component.optical.photoelectron_soc", ComponentItem::create)
                .lang("Infinite Circuit Board")
                .onRegister(attach(new TooltipBehavior(lines -> {
                    lines.add(Component.translatable("item.epimorphism.component.optical.photoelectron_soc.tooltip"));
                })))
                .register();
//
//        //  Others
//        MAGNETRON = REGISTRATE.item(100, "magnetron");
//        VOLTAGE_COIL_UHV = REGISTRATE.item(101, "voltage_coil.uhv");
//        VOLTAGE_COIL_UEV = REGISTRATE.item(102, "voltage_coil.uev");
//        VOLTAGE_COIL_UIV = REGISTRATE.item(103, "voltage_coil.uiv");
//        VOLTAGE_COIL_UXV = REGISTRATE.item(104, "voltage_coil.uxv");
//        VOLTAGE_COIL_OPV = REGISTRATE.item(105, "voltage_coil.opv");
//        VOLTAGE_COIL_MAX = REGISTRATE.item(106, "voltage_coil.max");
//        CARBON_ALLOTROPE = REGISTRATE.item(107, "carbon_allotrope");
//        GRAPHENE_ALIGNED = REGISTRATE.item(108, "graphene_aligned");
//        BORON_NITRIDE_GRINDER = REGISTRATE.item(109, "grinder.boron_nitride");
//        VACUUM_TUBE_COMPONENT = REGISTRATE.item(110, "component.vacuum_tube");
//        SEPARATION_ELECTROMAGNET = REGISTRATE.item(111, "separation_electromagnet");
//        PROTONATED_FULLERENE_SIEVING_MATRIX = REGISTRATE.item(112, "protonated_fullerene_sieving_matrix");
//        SATURATED_FULLERENE_SIEVING_MATRIX = REGISTRATE.item( 113, "saturated_fullerene_sieving_matrix");
//        NULL = REGISTRATE.item(114, "null").addComponents(new CosmicRenderItemBehavior(() -> EPTextures.MASK_INGOT, 1));
//        METASTABLE_SELF_HEALING_ADHESIVE = REGISTRATE.item(115, "metastable_self_healing_adhesive");
//        HYPERDIMENSIONAL_TACHYON_CONDENSED_MATTER = REGISTRATE.item(116, "hyperdimensional_tachyon_condensed_matter");
//
//        UNSTABLE_STAR = REGISTRATE.item(120, "unstable_star");
//
//        CLADDED_OPTICAL_FIBER_CORE = REGISTRATE.item(130, "component.cosmic.cladded_optical_fiber_core");
//        CLOSED_TIMELIKE_CURVE_COMPUTATIONAL_UNIT = addItem(131, "component.cosmic.closed_timelike_curve_computational_unit");
//        CLOSED_TIMELIKE_CURVE_GUIDANCE_UNIT = addItem(132, "component.cosmic.closed_timelike_curve_guidance_unit");
//        NUCLEAR_CLOCK = addItem(133, "component.cosmic.nuclear_clock");
//        MANIFOLD_OSCILLATORY_POWER_CELL = addItem(134, "component.cosmic.manifold_oscillatory_power_cell");
//
//
//        SCINTILLATOR = addItem(140, "scintillator");
//        SCINTILLATOR_CRYSTAL = addItem(141, "scintillator_crystal");
//
//        //  Crystal Components
//        DIAMOND_CHIP = REGISTRATE.item(150, "crystal.diamond_chip");
//        RUBY_CHIP = REGISTRATE.item(151, "crystal.ruby_chip");
//        SAPPHIRE_CHIP = REGISTRATE.item(152, "crystal.sapphire_chip");
//        DIAMOND_MODULATOR = REGISTRATE.item(153, "crystal.diamond_modulator");
//        RUBY_MODULATOR = REGISTRATE.item(154, "crystal.ruby_modulator");
//        SAPPHIRE_MODULATOR = REGISTRATE.item(155, "crystal.sapphire_modulator");
//        CRYSTAL_SOC_SOCKET = REGISTRATE.item(156, "crystal.system_on_chip_socket");
//
//        //  Covers
//        ELECTRIC_MOTOR_ULV = REGISTRATE.item(200, "cover.electric_motor.ulv");
//        ELECTRIC_PISTON_ULV = REGISTRATE.item(201, "cover.electric_piston.ulv");
//        ELECTRIC_PUMP_ULV = REGISTRATE.item(202, "cover.electric_pump.ulv");
//        CONVEYOR_MODULE_ULV = REGISTRATE.item(203, "cover.conveyor_module.ulv");
//        ROBOT_ARM_ULV = REGISTRATE.item(204, "cover.robot_arm.ulv");
//        EMITTER_ULV = REGISTRATE.item(205, "cover.emitter.ulv");
//        SENSOR_ULV = REGISTRATE.item(206, "cover.sensor.ulv");
//        FIELD_GENERATOR_ULV = REGISTRATE.item(207, "cover.field_generator.ulv");
//        ELECTRIC_MOTOR_MAX = REGISTRATE.item(208, "cover.electric_motor.max");
//        ELECTRIC_PISTON_MAX = REGISTRATE.item(209, "cover.electric_piston.max");
//        ELECTRIC_PUMP_MAX = REGISTRATE.item(210, "cover.electric_pump.max");
//        CONVEYOR_MODULE_MAX = REGISTRATE.item(211, "cover.conveyor_module.max");
//        ROBOT_ARM_MAX = REGISTRATE.item(212, "cover.robot_arm.max");
//        EMITTER_MAX = REGISTRATE.item(213, "cover.emitter.max");
//        SENSOR_MAX = REGISTRATE.item(214, "cover.sensor.max");
//        FIELD_GENERATOR_MAX = REGISTRATE.item(215, "cover.field_generator.max");
//
//        //  High Energy Physics items
//        PLASMA_CONTAINMENT_CELL = REGISTRATE.item(250, "plasma_containment_cell");
//        RHENIUM_PLASMA_CONTAINMENT_CELL = REGISTRATE.item(251, "rhenium_plasma_containment_cell");
//        NEUTRON_PLASMA_CONTAINMENT_CELL = REGISTRATE.item(252, "neutron_plasma_containment_cell");
//        HYPOGEN_PLASMA_CONTAINMENT_CELL = REGISTRATE.item(253, "hypogen_plasma_containment_cell");
//        ACTINIUM_SUPERHYDRIDE_PLASMA_CONTAINMENT_CELL = REGISTRATE.item(254, "actinium_superhydride_plasma_containment_cell");
//
//        QUANTUM_ANOMALY = REGISTRATE.item(260, "quantum_anomaly");
//
//        //  Biological Components
//        ELECTROCHEMICAL_GRADIENT_RECORDER = REGISTRATE.item(301, "biological.components.electrochemical_gradient_recorder");
//        ULTRA_MICRO_PHASE_SEPARATOR = REGISTRATE.item(302, "biological.components.ultra_micro_phase_separator");
//        QUANTUM_TUNNELING_MICROTUBULE = REGISTRATE.item(303, "biological.components.quantum_tunneling_microtubule");
//        HYPERRIBOSOME = REGISTRATE.item(304, "biological.components.hyperribosome");
//        NEUTRON_ABSORBING_PROTEIN = REGISTRATE.item(305, "biological.components.neutron_absorbing_protein");
//        SUPEREXCITED_CONDUCTIVE_POLYMER = REGISTRATE.item(306, "biological.components.superexcited_conductive_polymer");
//        DNA_ENCODER = REGISTRATE.item(307, "biological.components.dna_encoder");
//        DNA_DECODER = REGISTRATE.item(308, "biological.components.dna_decoder");
//        DNA_DECODE_ENCODER = REGISTRATE.item(309, "biological.components.dna_decode_encoder");
//        ORDINARY_ALGAE = REGISTRATE.item(350, "algae.ordinary_algae");
//        RED_ALGA = REGISTRATE.item(351, "algae.red_alga");
//        GREEN_ALGA = REGISTRATE.item(352, "algae.green_alga");
//        CHRYSOPHYCEAE = REGISTRATE.item(353, "algae.chrysophyceae");
//        BROWN_ALGA = REGISTRATE.item(354, "algae.brown_alga");
//
//        //  Mill Balls
//        GRINDBALL_SOAPSTONE = REGISTRATE.item(370, "mill.grindball_soapstone").setMaxStackSize(1).addComponents(new MillBallBehavior());
//        GRINDBALL_ALUMINIUM = REGISTRATE.item(371, "mill.grindball_aluminium").setMaxStackSize(1).addComponents(new MillBallBehavior());
//
        //  Wrap Circuits
        WRAP_CIRCUIT_ULV = REGISTRATE.item("wrap.circuit.ulv", Item::new)
                .lang("Infinite Circuit Board")
                .register();
        WRAP_CIRCUIT_LV = REGISTRATE.item("wrap.circuit.lv", Item::new)
                .lang("Infinite Circuit Board")
                .register();
        WRAP_CIRCUIT_MV = REGISTRATE.item("wrap.circuit.mv", Item::new)
                .lang("Infinite Circuit Board")
                .register();
        WRAP_CIRCUIT_HV = REGISTRATE.item("wrap.circuit.hv", Item::new)
                .lang("Infinite Circuit Board")
                .register();
        WRAP_CIRCUIT_EV = REGISTRATE.item("wrap.circuit.ev", Item::new)
                .lang("Infinite Circuit Board")
                .register();
        WRAP_CIRCUIT_IV = REGISTRATE.item("wrap.circuit.iv", Item::new)
                .lang("Infinite Circuit Board")
                .register();
        WRAP_CIRCUIT_LuV = REGISTRATE.item("wrap.circuit.luv", Item::new)
                .lang("Infinite Circuit Board")
                .register();
        WRAP_CIRCUIT_ZPM = REGISTRATE.item("wrap.circuit.zpm", Item::new)
                .lang("Infinite Circuit Board")
                .register();
        WRAP_CIRCUIT_UV = REGISTRATE.item("wrap.circuit.uv", Item::new)
                .lang("Infinite Circuit Board")
                .register();
        WRAP_CIRCUIT_UHV = REGISTRATE.item("wrap.circuit.uhv", Item::new)
                .lang("Infinite Circuit Board")
                .register();
        WRAP_CIRCUIT_UEV = REGISTRATE.item("wrap.circuit.uev", Item::new)
                .lang("Infinite Circuit Board")
                .register();
        WRAP_CIRCUIT_UIV = REGISTRATE.item("wrap.circuit.uiv", Item::new)
                .lang("Infinite Circuit Board")
                .register();
        WRAP_CIRCUIT_UXV = REGISTRATE.item("wrap.circuit.uxv", Item::new)
                .lang("Infinite Circuit Board")
                .register();
        WRAP_CIRCUIT_OpV = REGISTRATE.item("wrap.circuit.opv", Item::new)
                .lang("Infinite Circuit Board")
                .register();
        WRAP_CIRCUIT_MAX = REGISTRATE.item("wrap.circuit.max", Item::new)
                .lang("Infinite Circuit Board")
                .register();
//
//        // Debug
//        DEBUG_STRUCTURE_WRITER = REGISTRATE.item(9999, "debug.structure_writer").addComponents(StructureWriteBehavior.INSTANCE);
//        DEBUG_STRUCTURE_BUILDER = REGISTRATE.item(10000, "debug.structure_builder");
    }

    public static <T extends ComponentItem> NonNullConsumer<T> attach(IItemComponent... components) {
        return (item) -> {
            item.attachComponents(components);
        };
    }
}
