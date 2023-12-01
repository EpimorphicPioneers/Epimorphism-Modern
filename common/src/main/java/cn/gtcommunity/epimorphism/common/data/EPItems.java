package cn.gtcommunity.epimorphism.common.data;

import com.gregtechceu.gtceu.api.item.ComponentItem;
import com.gregtechceu.gtceu.api.item.component.IItemComponent;
import com.gregtechceu.gtceu.common.item.CoverPlaceBehavior;
import com.gregtechceu.gtceu.common.item.TooltipBehavior;
import com.gregtechceu.gtceu.data.recipe.CustomTags;
import com.tterrag.registrate.util.entry.ItemEntry;
import com.tterrag.registrate.util.nullness.NonNullConsumer;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;

import static cn.gtcommunity.epimorphism.api.registry.EPRegistries.*;
import static cn.gtcommunity.epimorphism.common.data.EPCreativeModeTabs.*;

public class EPItems {

    static {
        EP_REGISTRATE.creativeModeTab(() -> EP_ITEM);
    }

    //  Boards
    public final static ItemEntry<ComponentItem> GOOWARE_BOARD = EP_REGISTRATE.item("board.gooware", ComponentItem::create)
            .lang("Kapton™ Board")
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("item.epimorphism.board.gooware.tooltip"));
            })))
            .register();
    public final static ItemEntry<ComponentItem> OPTICAL_BOARD = EP_REGISTRATE.item("board.optical", ComponentItem::create)
            .lang("Gallium Nitride Semiconducting Board")
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("item.epimorphism.board.optical.tooltip"));
            })))
            .register();
    public final static ItemEntry<ComponentItem> SPINTRONIC_BOARD = EP_REGISTRATE.item("board.spintronic", ComponentItem::create)
            .lang("Carbon Nanotube Magnetic storage Board")
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("item.epimorphism.board.spintronic.tooltip"));
            })))
            .register();
    public final static ItemEntry<ComponentItem> GOOWARE_CIRCUIT_BOARD = EP_REGISTRATE.item("circuit_board.gooware", ComponentItem::create)
            .lang("Super Circuit Board")
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("item.epimorphism.circuit_board.gooware.tooltip"));
            })))
            .register();
    public final static ItemEntry<ComponentItem> OPTICAL_CIRCUIT_BOARD = EP_REGISTRATE.item("circuit_board.optical", ComponentItem::create)
            .lang("Ultimate Circuit Board")
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("item.epimorphism.circuit_board.optical.tooltip"));
            })))
            .register();
    public final static ItemEntry<ComponentItem> SPINTRONIC_CIRCUIT_BOARD = EP_REGISTRATE.item("circuit_board.spintronic", ComponentItem::create)
            .lang("Infinite Circuit Board")
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("item.epimorphism.circuit_board.spintronic.tooltip"));
            })))
            .register();

    //  Circuits
    public final static ItemEntry<ComponentItem> GOOWARE_PROCESSOR = EP_REGISTRATE.item("circuit.gooware_processor", ComponentItem::create)
            .lang("Gooware Processor")
            .tag(CustomTags.ZPM_CIRCUITS)
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("item.epimorphism.circuit.gooware_processor.tooltip"));
                lines.add(Component.translatable("item.epimorphism.circuit.zpm.tooltip"));
            })))
            .register();
    public final static ItemEntry<ComponentItem> GOOWARE_ASSEMBLY = EP_REGISTRATE.item("circuit.gooware_assembly", ComponentItem::create)
            .lang("Gooware Assembly")
            .tag(CustomTags.UV_CIRCUITS)
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("item.epimorphism.circuit.gooware_assembly.tooltip"));
                lines.add(Component.translatable("item.epimorphism.circuit.uv.tooltip"));
            })))
            .register();
    public final static ItemEntry<ComponentItem> GOOWARE_COMPUTER = EP_REGISTRATE.item("circuit.gooware_computer", ComponentItem::create)
            .lang("Gooware Supercomputer")
            .tag(CustomTags.UHV_CIRCUITS)
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("item.epimorphism.circuit.gooware_computer.tooltip"));
                lines.add(Component.translatable("item.epimorphism.circuit.uhv.tooltip"));
            })))
            .register();
    public final static ItemEntry<ComponentItem> GOOWARE_MAINFRAME = EP_REGISTRATE.item("circuit.gooware_mainframe", ComponentItem::create)
            .lang("Gooware Mainframe")
            .tag(CustomTags.UEV_CIRCUITS)
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("item.epimorphism.circuit.gooware_mainframe.tooltip"));
                lines.add(Component.translatable("item.epimorphism.circuit.uev.tooltip"));
            })))
            .register();
    public final static ItemEntry<ComponentItem> OPTICAL_PROCESSOR = EP_REGISTRATE.item("circuit.optical_processor", ComponentItem::create)
            .lang("Optical IMC Processor")
            .tag(CustomTags.UV_CIRCUITS)
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("item.epimorphism.circuit.optical_processor.tooltip"));
                lines.add(Component.translatable("item.epimorphism.circuit.uv.tooltip"));
            })))
            .register();
    public final static ItemEntry<ComponentItem> OPTICAL_ASSEMBLY = EP_REGISTRATE.item("circuit.optical_assembly", ComponentItem::create)
            .lang("Optical IMC Assembly")
            .tag(CustomTags.UHV_CIRCUITS)
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("item.epimorphism.circuit.optical_assembly.tooltip"));
                lines.add(Component.translatable("item.epimorphism.circuit.uhv.tooltip"));
            })))
            .register();
    public final static ItemEntry<ComponentItem> OPTICAL_COMPUTER = EP_REGISTRATE.item("circuit.optical_computer", ComponentItem::create)
            .lang("Optical IMC Supercomputer")
            .tag(CustomTags.UEV_CIRCUITS)
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("item.epimorphism.circuit.optical_computer.tooltip"));
                lines.add(Component.translatable("item.epimorphism.circuit.uev.tooltip"));
            })))
            .register();
    public final static ItemEntry<ComponentItem> OPTICAL_MAINFRAME = EP_REGISTRATE.item("circuit.optical_mainframe", ComponentItem::create)
            .lang("Optical IMC Mainframe")
            .tag(CustomTags.UIV_CIRCUITS)
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("item.epimorphism.circuit.optical_mainframe.tooltip"));
                lines.add(Component.translatable("item.epimorphism.circuit.uiv.tooltip"));
            })))
            .register();
    public final static ItemEntry<ComponentItem> SPINTRONIC_PROCESSOR = EP_REGISTRATE.item("circuit.spintronic_processor", ComponentItem::create)
            .lang("Spintronic IMC Processor")
            .tag(CustomTags.UHV_CIRCUITS)
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("item.epimorphism.circuit.spintronic_processor.tooltip"));
                lines.add(Component.translatable("item.epimorphism.circuit.uhv.tooltip"));
            })))
            .register();
    public final static ItemEntry<ComponentItem> SPINTRONIC_ASSEMBLY = EP_REGISTRATE.item("circuit.spintronic_assembly", ComponentItem::create)
            .lang("Spintronic IMC Assembly")
            .tag(CustomTags.UEV_CIRCUITS)
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("item.epimorphism.circuit.spintronic_assembly.tooltip"));
                lines.add(Component.translatable("item.epimorphism.circuit.uev.tooltip"));
            })))
            .register();
    public final static ItemEntry<ComponentItem> SPINTRONIC_COMPUTER = EP_REGISTRATE.item("circuit.spintronic_computer", ComponentItem::create)
            .lang("Spintronic IMC Supercomputer")
            .tag(CustomTags.UIV_CIRCUITS)
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("item.epimorphism.circuit.spintronic_computer.tooltip"));
                lines.add(Component.translatable("item.epimorphism.circuit.uiv.tooltip"));
            })))
            .register();
    public final static ItemEntry<ComponentItem> SPINTRONIC_MAINFRAME = EP_REGISTRATE.item("circuit.spintronic_mainframe", ComponentItem::create)
            .lang("Spintronic IMC Mainframe")
            .tag(CustomTags.UXV_CIRCUITS)
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("item.epimorphism.circuit.spintronic_mainframe.tooltip"));
                lines.add(Component.translatable("item.epimorphism.circuit.uxv.tooltip"));
            })))
            .register();
    public final static ItemEntry<ComponentItem> COSMIC_PROCESSOR = EP_REGISTRATE.item("circuit.cosmic_processor", ComponentItem::create)
            .lang("Cosmic Planetary Processor")
            .tag(CustomTags.UEV_CIRCUITS)
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("item.epimorphism.circuit.cosmic_processor.tooltip"));
                lines.add(Component.translatable("item.epimorphism.circuit.uev.tooltip"));
            })))
            .register();
    public final static ItemEntry<ComponentItem> COSMIC_ASSEMBLY = EP_REGISTRATE.item("circuit.cosmic_assembly", ComponentItem::create)
            .lang("Cosmic Planetary Assembly")
            .tag(CustomTags.UIV_CIRCUITS)
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("item.epimorphism.circuit.cosmic_assembly.tooltip"));
                lines.add(Component.translatable("item.epimorphism.circuit.uiv.tooltip"));
            })))
            .register();
    public final static ItemEntry<ComponentItem> COSMIC_COMPUTER = EP_REGISTRATE.item("circuit.cosmic_computer", ComponentItem::create)
            .lang("Cosmic Planetary Supercomputer")
            .tag(CustomTags.UXV_CIRCUITS)
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("item.epimorphism.circuit.cosmic_computer.tooltip"));
                lines.add(Component.translatable("item.epimorphism.circuit.uxv.tooltip"));
            })))
            .register();
    public final static ItemEntry<ComponentItem> COSMIC_MAINFRAME = EP_REGISTRATE.item("circuit.cosmic_mainframe", ComponentItem::create)
            .lang("Cosmic Planetary Mainframe")
            .tag(CustomTags.OpV_CIRCUITS)
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("item.epimorphism.circuit.cosmic_mainframe.tooltip"));
                lines.add(Component.translatable("item.epimorphism.circuit.opv.tooltip"));
            })))
            .register();
    public final static ItemEntry<ComponentItem> SUPRACAUSAL_PROCESSOR = EP_REGISTRATE.item("circuit.supracausal_processor", ComponentItem::create)
            .lang("Supracausal Galactic Processor")
            .tag(CustomTags.UIV_CIRCUITS)
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("item.epimorphism.circuit.supracausal_processor.tooltip"));
                lines.add(Component.translatable("item.epimorphism.circuit.uiv.tooltip"));
            })))
            .register();
    public final static ItemEntry<ComponentItem> SUPRACAUSAL_ASSEMBLY = EP_REGISTRATE.item("circuit.supracausal_assembly", ComponentItem::create)
            .lang("Supracausal Galactic Assembly")
            .tag(CustomTags.UXV_CIRCUITS)
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("item.epimorphism.circuit.supracausal_assembly.tooltip"));
                lines.add(Component.translatable("item.epimorphism.circuit.uxv.tooltip"));
            })))
            .register();
    public final static ItemEntry<ComponentItem> SUPRACAUSAL_COMPUTER = EP_REGISTRATE.item("circuit.supracausal_computer", ComponentItem::create)
            .lang("Supracausal Galactic Supercomputer")
            .tag(CustomTags.OpV_CIRCUITS)
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("item.epimorphism.circuit.supracausal_computer.tooltip"));
                lines.add(Component.translatable("item.epimorphism.circuit.opv.tooltip"));
            })))
            .register();
    public final static ItemEntry<ComponentItem> SUPRACAUSAL_MAINFRAME = EP_REGISTRATE.item("circuit.supracausal_mainframe", ComponentItem::create)
            .lang("Supracausal Galactic Mainframe")
            .tag(CustomTags.MAX_CIRCUITS)
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("item.epimorphism.circuit.supracausal_mainframe.tooltip"));
                lines.add(Component.translatable("item.epimorphism.circuit.max.tooltip"));
            })))
            .register();

    //  Components
    public final static ItemEntry<ComponentItem> OPTICAL_TRANSISTOR = EP_REGISTRATE.item("component.optical_smd.transistor", ComponentItem::create)
            .lang("Phototransistor")
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("item.epimorphism.component.optical_smd.transistor.tooltip"));
            })))
            .register();
    public final static ItemEntry<ComponentItem> OPTICAL_RESISTOR = EP_REGISTRATE.item("component.optical_smd.resistor", ComponentItem::create)
            .lang("Photoresistor")
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("item.epimorphism.component.optical_smd.resistor.tooltip"));
            })))
            .register();
    public final static ItemEntry<ComponentItem> OPTICAL_CAPACITOR = EP_REGISTRATE.item("component.optical_smd.capacitor", ComponentItem::create)
            .lang("Optical Integrator")
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("item.epimorphism.component.optical_smd.capacitor.tooltip"));
            })))
            .register();
    public final static ItemEntry<ComponentItem> OPTICAL_DIODE = EP_REGISTRATE.item("component.optical_smd.diode", ComponentItem::create)
            .lang("Optical Isolator")
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("item.epimorphism.component.optical_smd.diode.tooltip"));
            })))
            .register();
    public final static ItemEntry<ComponentItem> OPTICAL_INDUCTOR = EP_REGISTRATE.item("component.optical_smd.inductor", ComponentItem::create)
            .lang("Optical Polarizer")
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("item.epimorphism.component.optical_smd.inductor.tooltip"));
            })))
            .register();
    public final static ItemEntry<ComponentItem> SPINTRONIC_TRANSISTOR = EP_REGISTRATE.item("component.spintronic_smd.transistor", ComponentItem::create)
            .lang("MOSFET")
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("item.epimorphism.component.spintronic_smd.transistor.tooltip"));
            })))
            .register();
    public final static ItemEntry<ComponentItem> SPINTRONIC_RESISTOR = EP_REGISTRATE.item("component.spintronic_smd.resistor", ComponentItem::create)
            .lang("Magnetoresistor")
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("item.epimorphism.component.spintronic_smd.resistor.tooltip"));
            })))
            .register();
    public final static ItemEntry<ComponentItem> SPINTRONIC_CAPACITOR = EP_REGISTRATE.item("component.spintronic_smd.capacitor", ComponentItem::create)
            .lang("Ultracapacitor")
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("item.epimorphism.component.spintronic_smd.capacitor.tooltip"));
            })))
            .register();
    public final static ItemEntry<ComponentItem> SPINTRONIC_DIODE = EP_REGISTRATE.item("component.spintronic_smd.diode", ComponentItem::create)
            .lang("Schottky Diode")
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("item.epimorphism.component.spintronic_smd.diode.tooltip"));
            })))
            .register();
    public final static ItemEntry<ComponentItem> SPINTRONIC_INDUCTOR = EP_REGISTRATE.item("component.spintronic_smd.inductor", ComponentItem::create)
            .lang("Spin Polarizer")
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("item.epimorphism.component.spintronic_smd.inductor.tooltip"));
            })))
            .register();
    public final static ItemEntry<ComponentItem> COSMIC_TRANSISTOR = EP_REGISTRATE.item("component.cosmic_smd.transistor", ComponentItem::create)
            .lang("Crystal Information Payload")
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("item.epimorphism.component.cosmic_smd.transistor.tooltip"));
            })))
            .register();
    public final static ItemEntry<ComponentItem> COSMIC_RESISTOR = EP_REGISTRATE.item("component.cosmic_smd.resistor", ComponentItem::create)
            .lang("Micro Interstellar material Information Wall")
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("item.epimorphism.component.cosmic_smd.resistor.tooltip"));
            })))
            .register();
    public final static ItemEntry<ComponentItem> COSMIC_CAPACITOR = EP_REGISTRATE.item("component.cosmic_smd.capacitor", ComponentItem::create)
            .lang("Holographic Energy Charge")
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("item.epimorphism.component.cosmic_smd.capacitor.tooltip"));
            })))
            .register();
    public final static ItemEntry<ComponentItem> COSMIC_DIODE = EP_REGISTRATE.item("component.cosmic_smd.diode", ComponentItem::create)
            .lang("Cosmic Ion Diode")
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("item.epimorphism.component.cosmic_smd.diode.tooltip"));
            })))
            .register();
    public final static ItemEntry<ComponentItem> COSMIC_INDUCTOR = EP_REGISTRATE.item("component.cosmic_smd.inductor", ComponentItem::create)
            .lang("Zenith Polarizer")
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("item.epimorphism.component.cosmic_smd.inductor.tooltip"));
            })))
            .register();
    public final static ItemEntry<ComponentItem> SUPRACAUSAL_TRANSISTOR = EP_REGISTRATE.item("component.supracausal_smd.transistor", ComponentItem::create)
            .lang("Kaluza-Klein Extradimensional Dilator Field Effect Transistor")
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("item.epimorphism.component.supracausal_smd.transistor.tooltip"));
            })))
            .register();
    public final static ItemEntry<ComponentItem> SUPRACAUSAL_RESISTOR = EP_REGISTRATE.item("component.supracausal_smd.resistor", ComponentItem::create)
            .lang("Non anomalous Quantum Main Constraint Generator")
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("item.epimorphism.component.supracausal_smd.resistor.tooltip"));
            })))
            .register();
    public final static ItemEntry<ComponentItem> SUPRACAUSAL_CAPACITOR = EP_REGISTRATE.item("component.supracausal_smd.capacitor", ComponentItem::create)
            .lang("Energy-Momentum-Stress Tensor Memory")
                .onRegister(attach(new TooltipBehavior(lines -> {
        lines.add(Component.translatable("item.epimorphism.component.supracausal_smd.capacitor.tooltip"));
    })))
            .register();
    public final static ItemEntry<ComponentItem> SUPRACAUSAL_DIODE = EP_REGISTRATE.item("component.supracausal_smd.diode", ComponentItem::create)
            .lang("Spin network Carrier Diode")
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("item.epimorphism.component.supracausal_smd.diode.tooltip"));
            })))
            .register();
    public final static ItemEntry<ComponentItem> SUPRACAUSAL_INDUCTOR = EP_REGISTRATE.item("component.supracausal_smd.inductor", ComponentItem::create)
            .lang("Supersymmetric Conformal Polarizer")
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("item.epimorphism.component.supracausal_smd.inductor.tooltip"));
            })))
            .register();

    //  Gooware Components
    public final static ItemEntry<ComponentItem> BZ_REACTION_CHAMBER = EP_REGISTRATE.item("component.gooware.reaction_chamber", ComponentItem::create)
            .lang("Belousov-Zhabotinsky Reaction Chamber")
            .register();
    public final static ItemEntry<ComponentItem> NONLINEAR_CHEMICAL_OSCILLATOR = EP_REGISTRATE.item("component.gooware.nonlinear_chemical_oscillator", ComponentItem::create)
            .lang("Nonlinear Chemical Oscillator")
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("item.epimorphism.component.gooware.nonlinear_chemical_oscillator.tooltip"));
            })))
            .register();

    //  Optical Components
    public final static ItemEntry<ComponentItem> OPTICAL_LASER_CONTROL_UNIT = EP_REGISTRATE.item("component.optical.optical_laser_control_unit", ComponentItem::create)
            .lang("Optical Laser Control Unit")
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("item.epimorphism.component.optical.optical_laser_control_unit.tooltip"));
            })))
            .register();

    //  Spintronic Components
    public final static ItemEntry<ComponentItem> ESR_COMPUTATION_UNIT = EP_REGISTRATE.item("component.spintronic.esr_computation_unit", ComponentItem::create)
            .lang("ESR Computation Unit")
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("item.epimorphism.component.spintronic.esr_computation_unit.tooltip"));
            })))
            .register();

    //  Cosmic Components
    public final static ItemEntry<ComponentItem> COSMIC_INFORMATION_MODULE = EP_REGISTRATE.item("component.cosmic.information_module", ComponentItem::create)
            .lang("Cosmic Information Module")
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("item.epimorphism.component.cosmic.information_module.tooltip"));
            })))
            .register();
    public final static ItemEntry<ComponentItem> HOLOGRAPHIC_INFORMATION_IMC = EP_REGISTRATE.item("component.cosmic.holographic_imc", ComponentItem::create)
            .lang("Holographic IMC")
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("item.epimorphism.component.cosmic.holographic_imc.tooltip"));
            })))
            .register();

    //  Supracausal Components
    public final static ItemEntry<ComponentItem> SPACETIME_CONDENSER = EP_REGISTRATE.item("component.supracausal.spacetime_condenser", ComponentItem::create)
            .lang("Supracausal SpaceTime Condenser")
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("item.epimorphism.component.supracausal.spacetime_condenser.tooltip"));
            })))
            .register();
    public final static ItemEntry<ComponentItem> LIGHT_CONE_MODULE = EP_REGISTRATE.item("component.supracausal.light_cone_module", ComponentItem::create)
            .lang("Spacetime Light cone Stabilization Module")
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("item.epimorphism.component.supracausal.light_cone_module.tooltip"));
            })))
            .register();

    //  Lasers
    public final static ItemEntry<ComponentItem> OPTICAL_FIBER = EP_REGISTRATE.item("laser.optical_fiber", ComponentItem::create)
            .lang("Optical Fiber")
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("item.epimorphism.laser.optical_fiber.tooltip"));
            })))
            .register();
    public final static ItemEntry<ComponentItem> DIELECTRIC_MIRROR = EP_REGISTRATE.item("laser.dielectric_mirror", ComponentItem::create)
            .lang("Dielectric Mirror")
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("item.epimorphism.laser.dielectric_mirror.tooltip"));
            })))
            .register();
    public final static ItemEntry<ComponentItem> EMPTY_LASER_ASSEMBLY = EP_REGISTRATE.item("laser.emitter.empty", ComponentItem::create)
            .lang("Empty Laser Assembly")
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("item.epimorphism.laser.emitter.empty.tooltip"));
            })))
            .register();
    public final static ItemEntry<ComponentItem> HELIUM_LASER = EP_REGISTRATE.item("laser.emitter.helium", ComponentItem::create)
            .lang("Helium Laser Emitter")
            .register();
    public final static ItemEntry<ComponentItem> NEON_LASER = EP_REGISTRATE.item("laser.emitter.neon", ComponentItem::create)
            .lang("Neon Laser Emitter")
            .register();
    public final static ItemEntry<ComponentItem> ARGON_LASER = EP_REGISTRATE.item("laser.emitter.argon", ComponentItem::create)
            .lang("Argon Laser Emitter")
            .register();
    public final static ItemEntry<ComponentItem> KRYPTON_LASER = EP_REGISTRATE.item("laser.emitter.krypton", ComponentItem::create)
            .lang("Krypton Laser Emitter")
            .register();
    public final static ItemEntry<ComponentItem> XENON_LASER = EP_REGISTRATE.item("laser.emitter.xenon", ComponentItem::create)
            .lang("Xenon Laser Emitter")
            .register();
    public final static ItemEntry<ComponentItem> HELIUM_NEON_LASER = EP_REGISTRATE.item("laser.emitter.helium_neon", ComponentItem::create)
            .lang("Helium-Neon Laser")
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("item.epimorphism.laser.emitter.helium_neon.tooltip"));
            })))
            .register();
    public final static ItemEntry<ComponentItem> ND_YAG_LASER = EP_REGISTRATE.item("laser.emitter.nd_yag", ComponentItem::create)
            .lang("Nd:YAG Laser Emitter")
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("item.epimorphism.laser.emitter.nd_yag.tooltip"));
            })))
            .register();

    //  Condenser Components
    public final static ItemEntry<ComponentItem> TOPOLOGICAL_INSULATOR_TUBE = EP_REGISTRATE.item("tube.topological_insulator", ComponentItem::create)
            .lang("Topological Insulator Tube")
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("item.epimorphism.tube.topological_insulator.tooltip"));
            })))
            .register();
    public final static ItemEntry<ComponentItem> BOSE_EINSTEIN_CONDENSATE_CONTAINMENT_UNIT = EP_REGISTRATE.item("containment_unit.bose_einstein_condensate", ComponentItem::create)
            .lang("Bose-Einstein Condensate Containment Unit")
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("item.epimorphism.containment_unit.bose_einstein_condensate.tooltip"));
            })))
            .register();
    public final static ItemEntry<ComponentItem> BOSE_EINSTEIN_CONDENSATE = EP_REGISTRATE.item("bose_einstein_condensate", ComponentItem::create)
            .lang("Bose-Einstein Condensate")
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("item.epimorphism.bose_einstein_condensate.tooltip"));
            })))
            .register();

    //  Wafers
    public final static ItemEntry<ComponentItem> PHASE_CHANGE_MEMORY = EP_REGISTRATE.item("wafer.chip.phase_change_memory", ComponentItem::create)
            .lang("PRAM")
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("item.epimorphism.wafer.chip.phase_change_memory.tooltip"));
            })))
            .register();
    public final static ItemEntry<ComponentItem> OPTICAL_NOR_MEMORY_CHIP = EP_REGISTRATE.item("wafer.chip.optical_nor_memory_chip", ComponentItem::create)
            .lang("ACNOR")
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("item.epimorphism.wafer.chip.optical_nor_memory_chip.tooltip"));
            })))
            .register();
    public final static ItemEntry<ComponentItem> SPIN_TRANSFER_TORQUE_MEMORY = EP_REGISTRATE.item("wafer.chip.spin_transfer_torque_memory", ComponentItem::create)
            .lang("STTRAM")
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("item.epimorphism.wafer.chip.spin_transfer_torque_memory.tooltip"));
            })))
            .register();
    public final static ItemEntry<ComponentItem> SPINTRONIC_NAND_MEMORY_CHIP = EP_REGISTRATE.item("wafer.chip.spintronic_nand_memory_chip", ComponentItem::create)
            .lang("MDNAND")
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("item.epimorphism.wafer.chip.spintronic_nand_memory_chip.tooltip"));
            })))
            .register();
    public final static ItemEntry<ComponentItem> NANO_PIC_WAFER = EP_REGISTRATE.item("wafer.nano_pic", ComponentItem::create)
            .lang("NPIC Wafer")
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("item.epimorphism.wafer.nano_pic.tooltip"));
            })))
            .register();
    public final static ItemEntry<ComponentItem> NANO_PIC_CHIP = EP_REGISTRATE.item("wafer.chip.nano_pic", ComponentItem::create)
            .lang("NPIC")
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("item.epimorphism.wafer.chip.nano_pic.tooltip"));
            })))
            .register();
    public final static ItemEntry<ComponentItem> PICO_PIC_WAFER = EP_REGISTRATE.item("wafer.pico_pic", ComponentItem::create)
            .lang("PPIC Wafer")
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("item.epimorphism.wafer.pico_pic.tooltip"));
            })))
            .register();
    public final static ItemEntry<ComponentItem> PICO_PIC_CHIP = EP_REGISTRATE.item("wafer.chip.pico_pic", ComponentItem::create)
            .lang("PPIC")
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("item.epimorphism.wafer.chip.pico_pic.tooltip"));
            })))
            .register();
    public final static ItemEntry<ComponentItem> FEMTO_PIC_WAFER = EP_REGISTRATE.item("wafer.femto_pic", ComponentItem::create)
            .lang("FPIC Wafer")
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("item.epimorphism.wafer.femto_pic.tooltip"));
            })))
            .register();
    public final static ItemEntry<ComponentItem> FEMTO_PIC_CHIP = EP_REGISTRATE.item("wafer.chip.femto_pic", ComponentItem::create)
            .lang("FPIC")
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("item.epimorphism.wafer.chip.femto_pic.tooltip"));
            })))
            .register();
    public final static ItemEntry<ComponentItem> ATTO_PIC_WAFER = EP_REGISTRATE.item("wafer.atto_pic", ComponentItem::create)
            .lang("APIC Wafer")
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("item.epimorphism.wafer.atto_pic.tooltip"));
            })))
            .register();
    public final static ItemEntry<ComponentItem> ATTO_PIC_CHIP = EP_REGISTRATE.item("wafer.chip.atto_pic", ComponentItem::create)
            .lang("APIC")
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("item.epimorphism.wafer.chip.atto_pic.tooltip"));
            })))
            .register();
    public final static ItemEntry<ComponentItem> ZEPTO_PIC_WAFER = EP_REGISTRATE.item("wafer.zepto_pic", ComponentItem::create)
            .lang("ZPIC Wafer")
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("item.epimorphism.wafer.zepto_pic.tooltip"));
            })))
            .register();
    public final static ItemEntry<ComponentItem> ZEPTO_PIC_CHIP = EP_REGISTRATE.item("wafer.chip.zepto_pic", ComponentItem::create)
            .lang("ZPIC")
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("item.epimorphism.wafer.chip.zepto_pic.tooltip"));
            })))
            .register();
    public final static ItemEntry<ComponentItem> DUBNIUM_BOULE = EP_REGISTRATE.item("boule.dubnium", ComponentItem::create)
            .lang("Dubnium-doped Monocrystalline Silicon Boule")
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("item.epimorphism.boule.dubnium.tooltip"));
            })))
            .register();
    public final static ItemEntry<ComponentItem> DUBNIUM_WAFER = EP_REGISTRATE.item("wafer.dubnium", ComponentItem::create)
            .lang("Dubnium-doped Wafer")
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("item.epimorphism.wafer.dubnium.tooltip"));
            })))
            .register();
    public final static ItemEntry<ComponentItem> CUBIC_ZIRCONIA_EUROPIUM_BOULE = EP_REGISTRATE.item("boule.cubic_zirconia.europium", ComponentItem::create)
            .lang("Europium-doped Monocrystalline Cubic Zirconia Boule")
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("item.epimorphism.boule.cubic_zirconia.europium.tooltip"));
            })))
            .register();
    public final static ItemEntry<ComponentItem> CUBIC_ZIRCONIA_EUROPIUM_WAFER = EP_REGISTRATE.item("wafer.cubic_zirconia.europium", ComponentItem::create)
            .lang("Europium-doped Cubic Zirconia Wafer")
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("item.epimorphism.wafer.cubic_zirconia.europium.tooltip"));
            })))
            .register();
    public final static ItemEntry<ComponentItem> CRYSTAL_INTERFACE_WAFER = EP_REGISTRATE.item("wafer.crystal_interface", ComponentItem::create)
            .lang("Crystal Interface Wafer")
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("item.epimorphism.wafer.crystal_interface.tooltip"));
            })))
            .register();
    public final static ItemEntry<ComponentItem> CRYSTAL_INTERFACE_CHIP = EP_REGISTRATE.item("wafer.chip.crystal_interface", ComponentItem::create)
            .lang("Infinite Circuit Board")
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("item.epimorphism.wafer.chip.crystal_interface.tooltip"));
            })))
            .register();
    public final static ItemEntry<ComponentItem> UHASOC_WAFER = EP_REGISTRATE.item("wafer.uhasoc", ComponentItem::create)
            .lang("Infinite Circuit Board")
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("item.epimorphism.wafer.uhasoc.tooltip"));
            })))
            .register();
    public final static ItemEntry<ComponentItem> UHASOC_CHIP = EP_REGISTRATE.item("wafer.chip.uhasoc", ComponentItem::create)
            .lang("Infinite Circuit Board")
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("item.epimorphism.wafer.chip.uhasoc.tooltip"));
            })))
            .register();
    public final static ItemEntry<ComponentItem> INTRAVITAL_SOC = EP_REGISTRATE.item("component.gooware.intravital_soc", ComponentItem::create)
            .lang("Infinite Circuit Board")
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("item.epimorphism.component.gooware.intravital_soc.tooltip"));
            })))
            .register();
    public final static ItemEntry<ComponentItem> STRONTIUM_CARBONATE_BOHRIUM_BOULE = EP_REGISTRATE.item("boule.strontium_carbonate.bohrium", ComponentItem::create)
            .lang("Infinite Circuit Board")
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("item.epimorphism.boule.strontium_carbonate.bohrium.tooltip"));
            })))
            .register();
    public final static ItemEntry<ComponentItem> STRONTIUM_CARBONATE_BOHRIUM_WAFER = EP_REGISTRATE.item("wafer.strontium_carbonate.bohrium", ComponentItem::create)
            .lang("Infinite Circuit Board")
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("item.epimorphism.wafer.strontium_carbonate.bohrium.tooltip"));
            })))
            .register();
    public final static ItemEntry<ComponentItem> STRONTIUM_CARBONATE_OPTICAL_WAFER = EP_REGISTRATE.item("component.optical.strontium_carbonate_wafer", ComponentItem::create)
            .lang("Infinite Circuit Board")
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("item.epimorphism.component.optical.strontium_carbonate_wafer.tooltip"));
            })))
            .register();
    public final static ItemEntry<ComponentItem> OPTICAL_IMC_BOARD = EP_REGISTRATE.item("component.optical.optical_imc_board", ComponentItem::create)
            .lang("Infinite Circuit Board")
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("item.epimorphism.component.optical.optical_imc_board.tooltip"));
            })))
            .register();
    public final static ItemEntry<ComponentItem> PHOTOELECTRON_SOC  = EP_REGISTRATE.item("component.optical.photoelectron_soc", ComponentItem::create)
            .lang("Infinite Circuit Board")
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("item.epimorphism.component.optical.photoelectron_soc.tooltip"));
            })))
            .register();;

//    //  Others
//    public final static ItemEntry<Item> MAGNETRON;
//    public final static ItemEntry<Item> VOLTAGE_COIL_UHV;
//    public final static ItemEntry<Item> VOLTAGE_COIL_UEV;
//    public final static ItemEntry<Item> VOLTAGE_COIL_UIV;
//    public final static ItemEntry<Item> VOLTAGE_COIL_UXV;
//    public final static ItemEntry<Item> VOLTAGE_COIL_OPV;
//    public final static ItemEntry<Item> VOLTAGE_COIL_MAX;
//    public final static ItemEntry<Item> CARBON_ALLOTROPE;
//    public final static ItemEntry<Item> GRAPHENE_ALIGNED;
//    public final static ItemEntry<Item> BORON_NITRIDE_GRINDER;
//    public final static ItemEntry<Item> VACUUM_TUBE_COMPONENT;
//    public final static ItemEntry<Item> SEPARATION_ELECTROMAGNET;
//    public final static ItemEntry<Item> PROTONATED_FULLERENE_SIEVING_MATRIX;
//    public final static ItemEntry<Item> SATURATED_FULLERENE_SIEVING_MATRIX;
//    public final static ItemEntry<Item> NULL;
//    public final static ItemEntry<Item> METASTABLE_SELF_HEALING_ADHESIVE;
//    public final static ItemEntry<Item> HYPERDIMENSIONAL_TACHYON_CONDENSED_MATTER;
//    public final static ItemEntry<Item> UNSTABLE_STAR;
//    public final static ItemEntry<Item> CLADDED_OPTICAL_FIBER_CORE;
//    public final static ItemEntry<Item> CLOSED_TIMELIKE_CURVE_COMPUTATIONAL_UNIT;
//    public final static ItemEntry<Item> CLOSED_TIMELIKE_CURVE_GUIDANCE_UNIT;
//    public final static ItemEntry<Item> NUCLEAR_CLOCK;
//    public final static ItemEntry<Item> MANIFOLD_OSCILLATORY_POWER_CELL;
//
//    public final static ItemEntry<Item> SCINTILLATOR;
//    public final static ItemEntry<Item> SCINTILLATOR_CRYSTAL;
//
//    //  Crystal Components
//    public final static ItemEntry<Item> DIAMOND_CHIP;
//    public final static ItemEntry<Item> RUBY_CHIP;
//    public final static ItemEntry<Item> SAPPHIRE_CHIP;
//    public final static ItemEntry<Item> DIAMOND_MODULATOR;
//    public final static ItemEntry<Item> RUBY_MODULATOR;
//    public final static ItemEntry<Item> SAPPHIRE_MODULATOR;
//    public final static ItemEntry<Item> CRYSTAL_SOC_SOCKET;
//
//
//    //  High Energy Physics items
//    public final static ItemEntry<Item> PLASMA_CONTAINMENT_CELL;
//    public final static ItemEntry<Item> RHENIUM_PLASMA_CONTAINMENT_CELL;
//    public final static ItemEntry<Item> NEUTRON_PLASMA_CONTAINMENT_CELL;
//    public final static ItemEntry<Item> HYPOGEN_PLASMA_CONTAINMENT_CELL;
//    public final static ItemEntry<Item> ACTINIUM_SUPERHYDRIDE_PLASMA_CONTAINMENT_CELL;
//    public final static ItemEntry<Item> QUANTUM_ANOMALY;
//
//    //  Biological
//    public final static ItemEntry<Item> ELECTROCHEMICAL_GRADIENT_RECORDER;
//    public final static ItemEntry<Item> ULTRA_MICRO_PHASE_SEPARATOR;
//    public final static ItemEntry<Item> QUANTUM_TUNNELING_MICROTUBULE;
//    public final static ItemEntry<Item> HYPERRIBOSOME;
//    public final static ItemEntry<Item> NEUTRON_ABSORBING_PROTEIN;
//    public final static ItemEntry<Item> SUPEREXCITED_CONDUCTIVE_POLYMER;
//    public final static ItemEntry<Item> DNA_ENCODER;
//    public final static ItemEntry<Item> DNA_DECODER;
//    public final static ItemEntry<Item> DNA_DECODE_ENCODER;
//    public final static ItemEntry<Item> GRINDBALL_SOAPSTONE;
//    public final static ItemEntry<Item> GRINDBALL_ALUMINIUM;
//    public final static ItemEntry<Item> ORDINARY_ALGAE;
//    public final static ItemEntry<Item> RED_ALGA;
//    public final static ItemEntry<Item> GREEN_ALGA;
//    public final static ItemEntry<Item> CHRYSOPHYCEAE;
//    public final static ItemEntry<Item> BROWN_ALGA;

    //  Covers
    public final static ItemEntry<Item> ELECTRIC_MOTOR_ULV = EP_REGISTRATE.item("cover.electric_motor.ulv", Item::new)
            .lang("ULV Electric Motor")
            .register();
    public final static ItemEntry<Item> ELECTRIC_PISTON_ULV = EP_REGISTRATE.item("cover.electric_piston.ulv", Item::new)
            .lang("ULV Electric Motor")
            .register();
    public final static ItemEntry<ComponentItem> ELECTRIC_PUMP_ULV = EP_REGISTRATE.item("cover.electric_pump.ulv", ComponentItem::create)
            .lang("ULV Electric Motor")
            .onRegister(attach(new CoverPlaceBehavior(EPCovers.ELECTRIC_PUMP_ULV)))
            .register();
    public final static ItemEntry<ComponentItem> CONVEYOR_MODULE_ULV = EP_REGISTRATE.item("cover.conveyor_module.ulv", ComponentItem::create)
            .lang("ULV Electric Motor")
            .onRegister(attach(new CoverPlaceBehavior(EPCovers.CONVEYOR_MODULE_ULV)))
            .register();
    public final static ItemEntry<ComponentItem> ROBOT_ARM_ULV = EP_REGISTRATE.item("cover.robot_arm.ulv", ComponentItem::create)
            .lang("ULV Electric Motor")
            .onRegister(attach(new CoverPlaceBehavior(EPCovers.ROBOT_ARM_ULV)))
            .register();
    public final static ItemEntry<Item> EMITTER_ULV = EP_REGISTRATE.item("cover.emitter.ulv", Item::new)
            .lang("ULV Electric Motor")
            .register();
    public final static ItemEntry<Item> SENSOR_ULV = EP_REGISTRATE.item("cover.sensor.ulv", Item::new)
            .lang("ULV Electric Motor")
            .register();
    public final static ItemEntry<Item> FIELD_GENERATOR_ULV = EP_REGISTRATE.item("cover.field_generator.ulv", Item::new)
            .lang("ULV Electric Motor")
            .register();
    public final static ItemEntry<Item> ELECTRIC_MOTOR_MAX = EP_REGISTRATE.item("cover.electric_motor.max", Item::new)
            .lang("MAX Electric Motor")
            .register();
    public final static ItemEntry<Item> ELECTRIC_PISTON_MAX = EP_REGISTRATE.item("cover.electric_piston.max", Item::new)
            .lang("MAX Electric Motor")
            .register();
    public final static ItemEntry<ComponentItem> ELECTRIC_PUMP_MAX = EP_REGISTRATE.item("cover.electric_pump.max", ComponentItem::create)
            .lang("MAX Electric Motor")
            .onRegister(attach(new CoverPlaceBehavior(EPCovers.ELECTRIC_PUMP_MAX)))
            .register();
    public final static ItemEntry<ComponentItem> CONVEYOR_MODULE_MAX = EP_REGISTRATE.item("cover.conveyor_module.max", ComponentItem::create)
            .lang("MAX Electric Motor")
            .onRegister(attach(new CoverPlaceBehavior(EPCovers.CONVEYOR_MODULE_MAX)))
            .register();
    public final static ItemEntry<ComponentItem> ROBOT_ARM_MAX = EP_REGISTRATE.item("cover.robot_arm.max", ComponentItem::create)
            .lang("MAX Electric Motor")
            .onRegister(attach(new CoverPlaceBehavior(EPCovers.ROBOT_ARM_MAX)))
            .register();
    public final static ItemEntry<Item> EMITTER_MAX = EP_REGISTRATE.item("cover.emitter.max", Item::new)
            .lang("MAX Electric Motor")
            .register();
    public final static ItemEntry<Item> SENSOR_MAX = EP_REGISTRATE.item("cover.sensor.max", Item::new)
            .lang("MAX Electric Motor")
            .register();
    public final static ItemEntry<Item> FIELD_GENERATOR_MAX = EP_REGISTRATE.item("cover.field_generator.max", Item::new)
            .lang("MAX Electric Motor")
            .register();


    //  Wrap Circuits
    public final static ItemEntry<Item> WRAP_CIRCUIT_ULV = EP_REGISTRATE.item("wrap.circuit.ulv", Item::new)
            .lang("Infinite Circuit Board")
            .register();
    public final static ItemEntry<Item> WRAP_CIRCUIT_LV = EP_REGISTRATE.item("wrap.circuit.lv", Item::new)
            .lang("Infinite Circuit Board")
            .register();
    public final static ItemEntry<Item> WRAP_CIRCUIT_MV = EP_REGISTRATE.item("wrap.circuit.mv", Item::new)
            .lang("Infinite Circuit Board")
            .register();
    public final static ItemEntry<Item> WRAP_CIRCUIT_HV = EP_REGISTRATE.item("wrap.circuit.hv", Item::new)
            .lang("Infinite Circuit Board")
            .register();
    public final static ItemEntry<Item> WRAP_CIRCUIT_EV = EP_REGISTRATE.item("wrap.circuit.ev", Item::new)
            .lang("Infinite Circuit Board")
            .register();
    public final static ItemEntry<Item> WRAP_CIRCUIT_IV = EP_REGISTRATE.item("wrap.circuit.iv", Item::new)
            .lang("Infinite Circuit Board")
            .register();
    public final static ItemEntry<Item> WRAP_CIRCUIT_LuV = EP_REGISTRATE.item("wrap.circuit.luv", Item::new)
            .lang("Infinite Circuit Board")
            .register();
    public final static ItemEntry<Item> WRAP_CIRCUIT_ZPM = EP_REGISTRATE.item("wrap.circuit.zpm", Item::new)
            .lang("Infinite Circuit Board")
            .register();
    public final static ItemEntry<Item> WRAP_CIRCUIT_UV = EP_REGISTRATE.item("wrap.circuit.uv", Item::new)
            .lang("Infinite Circuit Board")
            .register();
    public final static ItemEntry<Item> WRAP_CIRCUIT_UHV = EP_REGISTRATE.item("wrap.circuit.uhv", Item::new)
            .lang("Infinite Circuit Board")
            .register();
    public final static ItemEntry<Item> WRAP_CIRCUIT_UEV = EP_REGISTRATE.item("wrap.circuit.uev", Item::new)
            .lang("Infinite Circuit Board")
            .register();
    public final static ItemEntry<Item> WRAP_CIRCUIT_UIV = EP_REGISTRATE.item("wrap.circuit.uiv", Item::new)
            .lang("Infinite Circuit Board")
            .register();
    public final static ItemEntry<Item> WRAP_CIRCUIT_UXV = EP_REGISTRATE.item("wrap.circuit.uxv", Item::new)
            .lang("Infinite Circuit Board")
            .register();
    public final static ItemEntry<Item> WRAP_CIRCUIT_OpV = EP_REGISTRATE.item("wrap.circuit.opv", Item::new)
            .lang("Infinite Circuit Board")
            .register();
    public final static ItemEntry<Item> WRAP_CIRCUIT_MAX = EP_REGISTRATE.item("wrap.circuit.max", Item::new)
            .lang("Infinite Circuit Board")
            .register();
//    //  Debug
//    public final static ItemEntry<Item> DEBUG_STRUCTURE_WRITER;
//    public final static ItemEntry<Item> DEBUG_STRUCTURE_BUILDER;

    private EPItems() {/**/}

    public static void init()
    {
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
