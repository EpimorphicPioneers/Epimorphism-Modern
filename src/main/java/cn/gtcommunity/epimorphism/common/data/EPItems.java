package cn.gtcommunity.epimorphism.common.data;

import cn.gtcommunity.epimorphism.Epimorphism;
import cn.gtcommunity.epimorphism.common.data.items.*;
import cn.gtcommunity.epimorphism.common.item.GrindBallItem;
import cn.gtcommunity.epimorphism.common.item.VajraItem;
import cn.gtcommunity.epimorphism.common.item.behaviors.GrindBallBehaviour;
import cn.gtcommunity.epimorphism.common.item.behaviors.OrganismCaptureBehavior;
import cn.gtcommunity.epimorphism.common.item.behaviors.StructureWriteBehavior;
import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.item.ComponentItem;
import com.gregtechceu.gtceu.api.item.component.ElectricStats;
import com.gregtechceu.gtceu.api.item.component.ICustomRenderer;
import com.gregtechceu.gtceu.api.item.component.IItemComponent;
import com.gregtechceu.gtceu.api.item.component.IMaterialPartItem;
import com.gregtechceu.gtceu.common.data.GTItems;
import com.gregtechceu.gtceu.common.item.CoverPlaceBehavior;
import com.gregtechceu.gtceu.common.item.TooltipBehavior;
import com.gregtechceu.gtceu.data.recipe.CustomTags;
import com.lowdragmc.lowdraglib.Platform;
import com.tterrag.registrate.Registrate;
import com.tterrag.registrate.builders.ItemBuilder;
import com.tterrag.registrate.util.entry.ItemEntry;
import com.tterrag.registrate.util.nullness.NonNullConsumer;
import com.tterrag.registrate.util.nullness.NonNullFunction;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.List;

import static cn.gtcommunity.epimorphism.Epimorphism.registrate;

public class EPItems {

    static {
        registrate().creativeModeTab(() -> EPCreativeModeTabs.EP_ITEM);
    }

    //  Boards
    public final static ItemEntry<ComponentItem> GOOWARE_BOARD = registerItemWithTooltip("board.gooware", 1).register();
    public final static ItemEntry<ComponentItem> OPTICAL_BOARD = registerItemWithTooltip("board.optical", 1).register();
    public final static ItemEntry<ComponentItem> SPINTRONIC_BOARD = registerItemWithTooltip("board.spintronic", 1).register();
    public final static ItemEntry<ComponentItem> GOOWARE_CIRCUIT_BOARD = registerItemWithTooltip("circuit_board.gooware", 1).register();
    public final static ItemEntry<ComponentItem> OPTICAL_CIRCUIT_BOARD = registerItemWithTooltip("circuit_board.optical", 1).register();
    public final static ItemEntry<ComponentItem> SPINTRONIC_CIRCUIT_BOARD = registerItemWithTooltip("circuit_board.spintronic", 1).register();

    //  Circuits
    public final static ItemEntry<ComponentItem> GOOWARE_PROCESSOR = registerItemWithTooltip("circuit.gooware_processor", 1, Component.translatable("item.epimorphism.circuit.zpm.desc")).tag(CustomTags.ZPM_CIRCUITS).register();
    public final static ItemEntry<ComponentItem> GOOWARE_ASSEMBLY = registerItemWithTooltip("circuit.gooware_assembly", 1, Component.translatable("item.epimorphism.circuit.uv.desc")).tag(CustomTags.UV_CIRCUITS).register();
    public final static ItemEntry<ComponentItem> GOOWARE_COMPUTER = registerItemWithTooltip("circuit.gooware_computer", 1, Component.translatable("item.epimorphism.circuit.uhv.desc")).tag(CustomTags.UHV_CIRCUITS).register();
    public final static ItemEntry<ComponentItem> GOOWARE_MAINFRAME = registerItemWithTooltip("circuit.gooware_mainframe", 1, Component.translatable("item.epimorphism.circuit.uev.desc")).tag(CustomTags.UEV_CIRCUITS).register();
    public final static ItemEntry<ComponentItem> OPTICAL_PROCESSOR = registerItemWithTooltip("circuit.optical_processor", 1, Component.translatable("item.epimorphism.circuit.uv.desc")).tag(CustomTags.UV_CIRCUITS).register();
    public final static ItemEntry<ComponentItem> OPTICAL_ASSEMBLY = registerItemWithTooltip("circuit.optical_assembly", 1, Component.translatable("item.epimorphism.circuit.uhv.desc")).tag(CustomTags.UHV_CIRCUITS).register();
    public final static ItemEntry<ComponentItem> OPTICAL_COMPUTER = registerItemWithTooltip("circuit.optical_computer", 1, Component.translatable("item.epimorphism.circuit.uev.desc")).tag(CustomTags.UEV_CIRCUITS).register();
    public final static ItemEntry<ComponentItem> OPTICAL_MAINFRAME = registerItemWithTooltip("circuit.optical_mainframe", 1, Component.translatable("item.epimorphism.circuit.uiv.desc")).tag(CustomTags.UIV_CIRCUITS).register();
    public final static ItemEntry<ComponentItem> SPINTRONIC_PROCESSOR = registerItemWithTooltip("circuit.spintronic_processor", 1, Component.translatable("item.epimorphism.circuit.uhv.desc")).tag(CustomTags.UHV_CIRCUITS).register();
    public final static ItemEntry<ComponentItem> SPINTRONIC_ASSEMBLY = registerItemWithTooltip("circuit.spintronic_assembly", 1, Component.translatable("item.epimorphism.circuit.uev.desc")).tag(CustomTags.UEV_CIRCUITS).register();
    public final static ItemEntry<ComponentItem> SPINTRONIC_COMPUTER = registerItemWithTooltip("circuit.spintronic_computer", 1, Component.translatable("item.epimorphism.circuit.uiv.desc")).tag(CustomTags.UIV_CIRCUITS).register();
    public final static ItemEntry<ComponentItem> SPINTRONIC_MAINFRAME = registerItemWithTooltip("circuit.spintronic_mainframe", 1, Component.translatable("item.epimorphism.circuit.uxv.desc")).tag(CustomTags.UXV_CIRCUITS).register();
    public final static ItemEntry<ComponentItem> COSMIC_PROCESSOR = registerItemWithTooltip("circuit.cosmic_processor", 1, Component.translatable("item.epimorphism.circuit.uev.desc")).tag(CustomTags.UEV_CIRCUITS).register();
    public final static ItemEntry<ComponentItem> COSMIC_ASSEMBLY = registerItemWithTooltip("circuit.cosmic_assembly", 1, Component.translatable("item.epimorphism.circuit.uiv.desc")).tag(CustomTags.UIV_CIRCUITS).register();
    public final static ItemEntry<ComponentItem> COSMIC_COMPUTER = registerItemWithTooltip("circuit.cosmic_computer", 1, Component.translatable("item.epimorphism.circuit.uxv.desc")).tag(CustomTags.UXV_CIRCUITS).register();
    public final static ItemEntry<ComponentItem> COSMIC_MAINFRAME = registerItemWithTooltip("circuit.cosmic_mainframe", 1, Component.translatable("item.epimorphism.circuit.opv.desc")).tag(CustomTags.OpV_CIRCUITS).register();
    public final static ItemEntry<ComponentItem> SUPRACAUSAL_PROCESSOR = registerItemWithTooltip("circuit.supracausal_processor", 1, Component.translatable("item.epimorphism.circuit.uiv.desc")).tag(CustomTags.UIV_CIRCUITS).register();
    public final static ItemEntry<ComponentItem> SUPRACAUSAL_ASSEMBLY = registerItemWithTooltip("circuit.supracausal_assembly", 1, Component.translatable("item.epimorphism.circuit.uxv.desc")).tag(CustomTags.UXV_CIRCUITS).register();
    public final static ItemEntry<ComponentItem> SUPRACAUSAL_COMPUTER = registerItemWithTooltip("circuit.supracausal_computer", 1, Component.translatable("item.epimorphism.circuit.opv.desc")).tag(CustomTags.OpV_CIRCUITS).register();
    public final static ItemEntry<ComponentItem> SUPRACAUSAL_MAINFRAME = registerItemWithTooltip("circuit.supracausal_mainframe", 1, Component.translatable("item.epimorphism.circuit.max.desc")).tag(CustomTags.MAX_CIRCUITS).register();

    //  Components
    public final static ItemEntry<ComponentItem> OPTICAL_TRANSISTOR = registerItemWithTooltip("component.optical_smd.transistor", 1).register();
    public final static ItemEntry<ComponentItem> OPTICAL_RESISTOR = registerItemWithTooltip("component.optical_smd.resistor", 1).register();
    public final static ItemEntry<ComponentItem> OPTICAL_CAPACITOR = registerItemWithTooltip("component.optical_smd.capacitor", 1).register();
    public final static ItemEntry<ComponentItem> OPTICAL_DIODE = registerItemWithTooltip("component.optical_smd.diode", 1).register();
    public final static ItemEntry<ComponentItem> OPTICAL_INDUCTOR = registerItemWithTooltip("component.optical_smd.inductor", 1).register();
    public final static ItemEntry<ComponentItem> SPINTRONIC_TRANSISTOR = registerItemWithTooltip("component.spintronic_smd.transistor", 1).register();
    public final static ItemEntry<ComponentItem> SPINTRONIC_RESISTOR = registerItemWithTooltip("component.spintronic_smd.resistor", 1).register();
    public final static ItemEntry<ComponentItem> SPINTRONIC_CAPACITOR = registerItemWithTooltip("component.spintronic_smd.capacitor", 1).register();
    public final static ItemEntry<ComponentItem> SPINTRONIC_DIODE = registerItemWithTooltip("component.spintronic_smd.diode", 1).register();
    public final static ItemEntry<ComponentItem> SPINTRONIC_INDUCTOR = registerItemWithTooltip("component.spintronic_smd.inductor", 1).register();
    public final static ItemEntry<ComponentItem> COSMIC_TRANSISTOR = registerItemWithTooltip("component.cosmic_smd.transistor", 1).register();
    public final static ItemEntry<ComponentItem> COSMIC_RESISTOR = registerItemWithTooltip("component.cosmic_smd.resistor", 1).register();
    public final static ItemEntry<ComponentItem> COSMIC_CAPACITOR = registerItemWithTooltip("component.cosmic_smd.capacitor", 1).register();
    public final static ItemEntry<ComponentItem> COSMIC_DIODE = registerItemWithTooltip("component.cosmic_smd.diode", 1).register();
    public final static ItemEntry<ComponentItem> COSMIC_INDUCTOR = registerItemWithTooltip("component.cosmic_smd.inductor", 1).register();
    public final static ItemEntry<ComponentItem> SUPRACAUSAL_TRANSISTOR = registerItemWithTooltip("component.supracausal_smd.transistor", 1).register();
    public final static ItemEntry<ComponentItem> SUPRACAUSAL_RESISTOR = registerItemWithTooltip("component.supracausal_smd.resistor", 1).register();
    public final static ItemEntry<ComponentItem> SUPRACAUSAL_CAPACITOR = registerItemWithTooltip("component.supracausal_smd.capacitor", 1).register();
    public final static ItemEntry<ComponentItem> SUPRACAUSAL_DIODE = registerItemWithTooltip("component.supracausal_smd.diode", 1).register();
    public final static ItemEntry<ComponentItem> SUPRACAUSAL_INDUCTOR = registerItemWithTooltip("component.supracausal_smd.inductor", 1).register();

    //  Gooware Components
//    public final static ItemEntry<ComponentItem> BZ_REACTION_CHAMBER = EP_REGISTRATE.item("component.gooware.reaction_chamber", ComponentItem::create)
//            .lang("Belousov-Zhabotinsky Reaction Chamber")
//            .register();
//    public final static ItemEntry<ComponentItem> NONLINEAR_CHEMICAL_OSCILLATOR = registerItemWithTooltip("component.gooware.nonlinear_chemical_oscillator", ComponentItem::create)
//            .lang("Nonlinear Chemical Oscillator")
//            .onRegister(attach(new TooltipBehavior(lines -> {
//                lines.add(Component.translatable("item.epimorphism.component.gooware.nonlinear_chemical_oscillator.tooltip"));
//            })))
//            .register();

    //  Optical Components
//    public final static ItemEntry<ComponentItem> OPTICAL_LASER_CONTROL_UNIT = registerItemWithTooltip("component.optical.optical_laser_control_unit", ComponentItem::create)
//            .lang("Optical Laser Control Unit")
//            .onRegister(attach(new TooltipBehavior(lines -> {
//                lines.add(Component.translatable("item.epimorphism.component.optical.optical_laser_control_unit.tooltip"));
//            })))
//            .register();

    //  Spintronic Components
//    public final static ItemEntry<ComponentItem> ESR_COMPUTATION_UNIT = registerItemWithTooltip("component.spintronic.esr_computation_unit", ComponentItem::create)
//            .lang("ESR Computation Unit")
//            .onRegister(attach(new TooltipBehavior(lines -> {
//                lines.add(Component.translatable("item.epimorphism.component.spintronic.esr_computation_unit.tooltip"));
//            })))
//            .register();

    //  Cosmic Components
//    public final static ItemEntry<ComponentItem> COSMIC_INFORMATION_MODULE = registerItemWithTooltip("component.cosmic.information_module", ComponentItem::create)
//            .lang("Cosmic Information Module")
//            .onRegister(attach(new TooltipBehavior(lines -> {
//                lines.add(Component.translatable("item.epimorphism.component.cosmic.information_module.tooltip"));
//            })))
//            .register();
//    public final static ItemEntry<ComponentItem> HOLOGRAPHIC_INFORMATION_IMC = registerItemWithTooltip("component.cosmic.holographic_imc", ComponentItem::create)
//            .lang("Holographic IMC")
//            .onRegister(attach(new TooltipBehavior(lines -> {
//                lines.add(Component.translatable("item.epimorphism.component.cosmic.holographic_imc.tooltip"));
//            })))
//            .register();

    //  Supracausal Components
//    public final static ItemEntry<ComponentItem> SPACETIME_CONDENSER = registerItemWithTooltip("component.supracausal.spacetime_condenser", ComponentItem::create)
//            .lang("Supracausal SpaceTime Condenser")
//            .onRegister(attach(new TooltipBehavior(lines -> {
//                lines.add(Component.translatable("item.epimorphism.component.supracausal.spacetime_condenser.tooltip"));
//            })))
//            .register();
//    public final static ItemEntry<ComponentItem> LIGHT_CONE_MODULE = registerItemWithTooltip("component.supracausal.light_cone_module", ComponentItem::create)
//            .lang("Spacetime Light cone Stabilization Module")
//            .onRegister(attach(new TooltipBehavior(lines -> {
//                lines.add(Component.translatable("item.epimorphism.component.supracausal.light_cone_module.tooltip"));
//            })))
//            .register();

    //  Lasers
    public final static ItemEntry<ComponentItem> OPTICAL_FIBER = registerItemWithTooltip("laser.optical_fiber", 1).lang("Optical Fiber").register();
    public final static ItemEntry<ComponentItem> DIELECTRIC_MIRROR = registerItemWithTooltip("laser.dielectric_mirror", 1).lang("Dielectric Mirror").register();
    public final static ItemEntry<ComponentItem> EMPTY_LASER_ASSEMBLY = registerItemWithTooltip("laser.emitter.empty", 1).lang("Empty Laser Assembly").register();
    public final static ItemEntry<ComponentItem> HELIUM_LASER = registerComponentItem("laser.emitter.helium").lang("Helium Laser Emitter").register();
    public final static ItemEntry<ComponentItem> NEON_LASER = registerComponentItem("laser.emitter.neon").lang("Neon Laser Emitter").register();
    public final static ItemEntry<ComponentItem> ARGON_LASER = registerComponentItem("laser.emitter.argon").lang("Argon Laser Emitter").register();
    public final static ItemEntry<ComponentItem> KRYPTON_LASER = registerComponentItem("laser.emitter.krypton").lang("Krypton Laser Emitter").register();
    public final static ItemEntry<ComponentItem> XENON_LASER = registerComponentItem("laser.emitter.xenon").lang("Xenon Laser Emitter").register();
    public final static ItemEntry<ComponentItem> HELIUM_NEON_LASER = registerItemWithTooltip("laser.emitter.helium_neon", 1).lang("Helium-Neon Laser").register();
    public final static ItemEntry<ComponentItem> ND_YAG_LASER = registerItemWithTooltip("laser.emitter.nd_yag", 1).lang("Nd:YAG Laser Emitter")
            .register();

    //  Condenser Components
//    public final static ItemEntry<ComponentItem> TOPOLOGICAL_INSULATOR_TUBE = registerItemWithTooltip("tube.topological_insulator", ComponentItem::create)
//            .lang("Topological Insulator Tube")
//            .onRegister(attach(new TooltipBehavior(lines -> {
//                lines.add(Component.translatable("item.epimorphism.tube.topological_insulator.tooltip"));
//            })))
//            .register();
    public final static ItemEntry<ComponentItem> BOSE_EINSTEIN_CONDENSATE_CONTAINMENT_UNIT = registerItemWithTooltip("containment_unit.bose_einstein_condensate", 1).lang("Bose-Einstein Condensate Containment Unit").register();
    public final static ItemEntry<ComponentItem> BOSE_EINSTEIN_CONDENSATE = registerItemWithTooltip("bose_einstein_condensate", 1).lang("Bose-Einstein Condensate").register();

    //  Wafers
//    public final static ItemEntry<ComponentItem> PHASE_CHANGE_MEMORY = registerItemWithTooltip("wafer.chip.phase_change_memory", ComponentItem::create)
//            .lang("PRAM")
//            .onRegister(attach(new TooltipBehavior(lines -> {
//                lines.add(Component.translatable("item.epimorphism.wafer.chip.phase_change_memory.tooltip"));
//            })))
//            .register();
//    public final static ItemEntry<ComponentItem> OPTICAL_NOR_MEMORY_CHIP = registerItemWithTooltip("wafer.chip.optical_nor_memory_chip", ComponentItem::create)
//            .lang("ACNOR")
//            .onRegister(attach(new TooltipBehavior(lines -> {
//                lines.add(Component.translatable("item.epimorphism.wafer.chip.optical_nor_memory_chip.tooltip"));
//            })))
//            .register();
//    public final static ItemEntry<ComponentItem> SPIN_TRANSFER_TORQUE_MEMORY = registerItemWithTooltip("wafer.chip.spin_transfer_torque_memory", ComponentItem::create)
//            .lang("STTRAM")
//            .onRegister(attach(new TooltipBehavior(lines -> {
//                lines.add(Component.translatable("item.epimorphism.wafer.chip.spin_transfer_torque_memory.tooltip"));
//            })))
//            .register();
//    public final static ItemEntry<ComponentItem> SPINTRONIC_NAND_MEMORY_CHIP = registerItemWithTooltip("wafer.chip.spintronic_nand_memory_chip", ComponentItem::create)
//            .lang("MDNAND")
//            .onRegister(attach(new TooltipBehavior(lines -> {
//                lines.add(Component.translatable("item.epimorphism.wafer.chip.spintronic_nand_memory_chip.tooltip"));
//            })))
//            .register();
    public final static ItemEntry<ComponentItem> NANO_PIC_WAFER = registerItemWithTooltip("wafer.nano_pic", 1).lang("NPIC Wafer").register();
    public final static ItemEntry<ComponentItem> NANO_PIC_CHIP = registerItemWithTooltip("wafer.chip.nano_pic", 1).lang("NPIC").register();
    public final static ItemEntry<ComponentItem> PICO_PIC_WAFER = registerItemWithTooltip("wafer.pico_pic", 1).lang("PPIC Wafer").register();
    public final static ItemEntry<ComponentItem> PICO_PIC_CHIP = registerItemWithTooltip("wafer.chip.pico_pic", 1).lang("PPIC").register();
//    public final static ItemEntry<ComponentItem> FEMTO_PIC_WAFER = registerItemWithTooltip("wafer.femto_pic", ComponentItem::create)
//            .lang("FPIC Wafer")
//            .onRegister(attach(new TooltipBehavior(lines -> {
//                lines.add(Component.translatable("item.epimorphism.wafer.femto_pic.tooltip"));
//            })))
//            .register();
//    public final static ItemEntry<ComponentItem> FEMTO_PIC_CHIP = registerItemWithTooltip("wafer.chip.femto_pic", ComponentItem::create)
//            .lang("FPIC")
//            .onRegister(attach(new TooltipBehavior(lines -> {
//                lines.add(Component.translatable("item.epimorphism.wafer.chip.femto_pic.tooltip"));
//            })))
//            .register();
//    public final static ItemEntry<ComponentItem> ATTO_PIC_WAFER = registerItemWithTooltip("wafer.atto_pic", ComponentItem::create)
//            .lang("APIC Wafer")
//            .onRegister(attach(new TooltipBehavior(lines -> {
//                lines.add(Component.translatable("item.epimorphism.wafer.atto_pic.tooltip"));
//            })))
//            .register();
//    public final static ItemEntry<ComponentItem> ATTO_PIC_CHIP = registerItemWithTooltip("wafer.chip.atto_pic", ComponentItem::create)
//            .lang("APIC")
//            .onRegister(attach(new TooltipBehavior(lines -> {
//                lines.add(Component.translatable("item.epimorphism.wafer.chip.atto_pic.tooltip"));
//            })))
//            .register();
//    public final static ItemEntry<ComponentItem> ZEPTO_PIC_WAFER = registerItemWithTooltip("wafer.zepto_pic", ComponentItem::create)
//            .lang("ZPIC Wafer")
//            .onRegister(attach(new TooltipBehavior(lines -> {
//                lines.add(Component.translatable("item.epimorphism.wafer.zepto_pic.tooltip"));
//            })))
//            .register();
//    public final static ItemEntry<ComponentItem> ZEPTO_PIC_CHIP = registerItemWithTooltip("wafer.chip.zepto_pic", ComponentItem::create)
//            .lang("ZPIC")
//            .onRegister(attach(new TooltipBehavior(lines -> {
//                lines.add(Component.translatable("item.epimorphism.wafer.chip.zepto_pic.tooltip"));
//            })))
//            .register();
    public final static ItemEntry<ComponentItem> DUBNIUM_BOULE = registerItemWithTooltip("boule.dubnium", 1).lang("Dubnium-doped Monocrystalline Silicon Boule").register();
    public final static ItemEntry<ComponentItem> DUBNIUM_WAFER = registerItemWithTooltip("wafer.dubnium", 1).lang("Dubnium-doped Wafer").register();
    public final static ItemEntry<ComponentItem> CUBIC_ZIRCONIA_EUROPIUM_BOULE = registerItemWithTooltip("boule.cubic_zirconia.europium", 1).lang("Europium-doped Monocrystalline Cubic Zirconia Boule").register();
    public final static ItemEntry<ComponentItem> CUBIC_ZIRCONIA_EUROPIUM_WAFER = registerItemWithTooltip("wafer.cubic_zirconia.europium", 1).lang("Europium-doped Cubic Zirconia Wafer").register();
    public final static ItemEntry<ComponentItem> CRYSTAL_INTERFACE_WAFER = registerItemWithTooltip("wafer.crystal_interface", 1).lang("Crystal Interface Wafer").register();
//    public final static ItemEntry<ComponentItem> CRYSTAL_INTERFACE_CHIP = registerItemWithTooltip("wafer.chip.crystal_interface", ComponentItem::create)
//            .lang("Infinite Circuit Board")
//            .onRegister(attach(new TooltipBehavior(lines -> {
//                lines.add(Component.translatable("item.epimorphism.wafer.chip.crystal_interface.tooltip"));
//            })))
//            .register();
//    public final static ItemEntry<ComponentItem> UHASOC_WAFER = registerItemWithTooltip("wafer.uhasoc", ComponentItem::create)
//            .lang("Infinite Circuit Board")
//            .onRegister(attach(new TooltipBehavior(lines -> {
//                lines.add(Component.translatable("item.epimorphism.wafer.uhasoc.tooltip"));
//            })))
//            .register();
//    public final static ItemEntry<ComponentItem> UHASOC_CHIP = registerItemWithTooltip("wafer.chip.uhasoc", ComponentItem::create)
//            .lang("Infinite Circuit Board")
//            .onRegister(attach(new TooltipBehavior(lines -> {
//                lines.add(Component.translatable("item.epimorphism.wafer.chip.uhasoc.tooltip"));
//            })))
//            .register();
    public final static ItemEntry<ComponentItem> INTRAVITAL_SOC = registerItemWithTooltip("component.gooware.intravital_soc", 1).lang("Intravital SoC").register();
    public final static ItemEntry<ComponentItem> STRONTIUM_CARBONATE_BOHRIUM_BOULE = registerItemWithTooltip("boule.strontium_carbonate.bohrium", 1).lang("Bohrium-doped Monocrystalline Strontium Carbonate Boule").register();
    public final static ItemEntry<ComponentItem> STRONTIUM_CARBONATE_BOHRIUM_WAFER = registerItemWithTooltip("wafer.strontium_carbonate.bohrium", 1).lang("Bohrium-doped Strontium Carbonate Wafer").register();
    public final static ItemEntry<ComponentItem> STRONTIUM_CARBONATE_OPTICAL_WAFER = registerItemWithTooltip("component.optical.strontium_carbonate_wafer", 1).lang("Coated Strontium Carbonate Wafer").register();
    public final static ItemEntry<ComponentItem> OPTICAL_IMC_BOARD = registerItemWithTooltip("component.optical.optical_imc_board", 1).lang("Preassembled Photoelectric Circuit Board").register();
    public final static ItemEntry<ComponentItem> PHOTOELECTRON_SOC = registerItemWithTooltip("component.optical.photoelectron_soc", 1).lang("Photoelectric SoC").register();
    //  Others
//    public final static ItemEntry<Item> MAGNETRON;
    public final static ItemEntry<ComponentItem> VOLTAGE_COIL_UHV = registerItemWithTooltip("uhv_voltage_coil", 1).lang("Ultra High Voltage Coil").register();
    public final static ItemEntry<ComponentItem> VOLTAGE_COIL_UEV = registerItemWithTooltip("uev_voltage_coil", 1).lang("Ultra Excessive Voltage Coil").register();
    public final static ItemEntry<ComponentItem> VOLTAGE_COIL_UIV = registerItemWithTooltip("uiv_voltage_coil", 1).lang("Ultra Immense Voltage Coil").register();
    public final static ItemEntry<ComponentItem> VOLTAGE_COIL_UXV = registerItemWithTooltip("uxv_voltage_coil", 1).lang("Ultra Extreme Voltage Coil").register();
    public final static ItemEntry<ComponentItem> VOLTAGE_COIL_OPV = registerItemWithTooltip("opv_voltage_coil", 1).lang("Overpowered Voltage Coil").register();
    //    public final static ItemEntry<ComponentItem> VOLTAGE_COIL_MAX;
//    public final static ItemEntry<Item> CARBON_ALLOTROPE;
//    public final static ItemEntry<Item> GRAPHENE_ALIGNED;
//    public final static ItemEntry<Item> BORON_NITRIDE_GRINDER;
//    public final static ItemEntry<Item> VACUUM_TUBE_COMPONENT;
//    public final static ItemEntry<Item> SEPARATION_ELECTROMAGNET;
    public final static ItemEntry<Item> PROTONATED_FULLERENE_SIEVING_MATRIX = registerItem("protonated_fullerene_sieving_matrix").lang("Protonated Fullerene Sieving Matrix").register();
    public final static ItemEntry<Item> SATURATED_FULLERENE_SIEVING_MATRIX = registerItem("saturated_fullerene_sieving_matrix").lang("Saturated Fullerene Sieving Matrix").register();
    public static ItemEntry<ComponentItem> INVERTER = registerItemWithTooltip("inverter", 1).lang("Inverter").register();
    public final static ItemEntry<Item> METASTABLE_SELF_HEALING_ADHESIVE = registerItem("metastable_self_healing_adhesive").lang("Metastable Self-healing Adhesive").register();
    public final static ItemEntry<Item> HYPERDIMENSIONAL_TACHYON_CONDENSED_MATTER = registerItem("hyperdimensional_tachyon_condensed_matter").lang("Hyperdimensional Tachyon Condensed Matter").register();
    public final static ItemEntry<Item> UNSTABLE_STAR = registerItem("unstable_star").lang("Unstable Star").register();
    public final static ItemEntry<Item> CLADDED_OPTICAL_FIBER_CORE = registerItem("component.cosmic.cladded_optical_fiber_core").lang("Cladded Optical Fiber Core").register();
//    public final static ItemEntry<Item> CLOSED_TIMELIKE_CURVE_COMPUTATIONAL_UNIT;
//    public final static ItemEntry<Item> CLOSED_TIMELIKE_CURVE_GUIDANCE_UNIT;
//    public final static ItemEntry<Item> NUCLEAR_CLOCK;
//    public final static ItemEntry<Item> MANIFOLD_OSCILLATORY_POWER_CELL;
//    public final static ItemEntry<Item> SCINTILLATOR = registerItem("scintillator", Item::new).lang("Scintillator").register();
    public final static ItemEntry<Item> SCINTILLATOR_CRYSTAL = registerItem("scintillator_crystal").lang("Scintillator Crystal").register();

    //  Crystal Components
    public final static ItemEntry<ComponentItem> DIAMOND_CHIP = registerItemWithTooltip("crystal.diamond_chip", 1).lang("Engraved Diamond Crystal Chip").register();
    public final static ItemEntry<ComponentItem> RUBY_CHIP = registerItemWithTooltip("crystal.ruby_chip", 1).lang("Engraved Ruby Crystal Chip").register();
    public final static ItemEntry<ComponentItem> SAPPHIRE_CHIP = registerItemWithTooltip("crystal.sapphire_chip", 1).lang("Engraved Sapphire Crystal Chip").register();
//    public final static ItemEntry<Item> DIAMOND_MODULATOR;
//    public final static ItemEntry<Item> RUBY_MODULATOR;
//    public final static ItemEntry<Item> SAPPHIRE_MODULATOR;
//    public final static ItemEntry<Item> CRYSTAL_SOC_SOCKET;


    //  Covers
    public final static ItemEntry<ComponentItem> ELECTRIC_PUMP_MAX = registerComponentItem("max_electric_pump")
            .onRegister(attach(new CoverPlaceBehavior(EPCovers.ELECTRIC_PUMP_MAX)))
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("item.gtceu.electric.pump.tooltip"));
                lines.add(Component.translatable("gtceu.universal.tooltip.fluid_transfer_rate", 1280 * 64 * 64 * 4 / 20));
            })))
            .register();
    public static ItemEntry<ComponentItem> FLUID_REGULATOR_MAX = registerComponentItem("max_fluid_regulator")
            .onRegister(attach(new CoverPlaceBehavior(EPCovers.FLUID_REGULATORS_MAX)))
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("item.gtceu.fluid.regulator.tooltip"));
                lines.add(Component.translatable("gtceu.universal.tooltip.fluid_transfer_rate", 1280 * 64 * 64 * 4 / 20));
            })))
            .register();
    public final static ItemEntry<ComponentItem> CONVEYOR_MODULE_MAX = registerComponentItem("max_conveyor_module")
            .onRegister(attach(new CoverPlaceBehavior(EPCovers.CONVEYOR_MODULE_MAX)))
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("item.gtceu.conveyor.module.tooltip"));
                lines.add(Component.translatable("gtceu.universal.tooltip.item_transfer_rate_stacks", 16));
            })))
            .register();
    public final static ItemEntry<ComponentItem> ROBOT_ARM_MAX = registerComponentItem("max_robot_arm")
            .onRegister(attach(new CoverPlaceBehavior(EPCovers.ROBOT_ARM_MAX)))
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("item.gtceu.robot.arm.tooltip"));
                lines.add(Component.translatable("gtceu.universal.tooltip.item_transfer_rate_stacks", 16));
            })))
            .register();
    public final static ItemEntry<Item> ELECTRIC_MOTOR_MAX = registerItem("max_electric_motor").register();
    public final static ItemEntry<Item> ELECTRIC_PISTON_MAX = registerItem("max_electric_piston").register();
    public final static ItemEntry<Item> EMITTER_MAX = registerItem("max_emitter").register();
    public final static ItemEntry<Item> SENSOR_MAX = registerItem("max_sensor").register();
    public final static ItemEntry<Item> FIELD_GENERATOR_MAX = registerItem("max_field_generator").register();

    //  Debug
    public final static ItemEntry<ComponentItem> DEBUG_STRUCTURE_WRITER = registerItemWithTooltip("debug.structure_writer", 1).lang("Debug Structure Writer").onRegister(attach(StructureWriteBehavior.INSTANCE)).register();

    //  Tool
    public final static ItemEntry<ComponentItem> ORGANISM_CAPTURE_TOOL = registerComponentItem("organism_capture_tool")
            .lang("Organism Capture Tool")
            .model(EPModels::captureToolModel)
            .onRegister(attach(new TooltipBehavior(lines -> lines.add(Component.translatable("item.epimorphism.organism_capture_tool.desc"))) {
                @Override
                public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltipComponents, TooltipFlag isAdvanced) {
                    super.appendHoverText(stack, level, tooltipComponents, isAdvanced);
                    tooltipComponents.add(Component.translatable("item.epimorphism.organism_capture_tool.desc.info", OrganismCaptureBehavior.getEntityName(stack)));
                }
            }))
            .onRegister(attach(OrganismCaptureBehavior.INSTANCE))
            .onRegister(GTItems.modelPredicate(Epimorphism.id("organism_capture_tool"), itemStack -> OrganismCaptureBehavior.hasEntity(itemStack) ? 1f : 0f))
            .register();

    public final static ItemEntry<VajraItem> VAJRA = registrate().item("tool.vajra", VajraItem::new)
            .lang("Vajra")
            .model(EPModels.simpleCustomModel(Epimorphism.id("item/tool_vajra"), Epimorphism.id("item/tool.vajra")))
            .onRegister(attach(ElectricStats.createElectricItem(20_000_000_000L, GTValues.UV)))
            .register();

    public final static ItemEntry<ComponentItem> MITTS = registerItemWithTooltip("tool.mitts", 1)
            .lang("Mitts")
            .properties(p -> p.stacksTo(1).durability(2000))
            .register();

    // Grind Ball
    public static ItemEntry<GrindBallItem> GRIND_BALL = registrate().item("grind_ball", GrindBallItem::new)
            .properties(p -> p.stacksTo(1))
            .color(() -> IMaterialPartItem::getItemStackColor)
            .model(EPModels.simpleCustomModel(new ResourceLocation("item/generated"), Epimorphism.id("item/grind_ball/base")))
            .onRegister(attach(new GrindBallBehaviour()))
            .register();

    private EPItems() {/**/}

    public static void init() {
        EPWrapItem.init();
        EPPhysicsItems.init();
        EPBiologyItems.init();
        EPChemistryItem.init();
    }

    public static ItemBuilder<ComponentItem, Registrate> registerComponentItem(String name) {
        return registrate().item(name, ComponentItem::create);
    }

    public static ItemBuilder<Item, Registrate> registerItem(String name) {
        return registrate().item(name, Item::new);
    }

    public static ItemBuilder<ComponentItem, Registrate> registerItemWithTooltip(String name, int num) {
        return registerItemWithTooltip(name, ComponentItem::create, num);
    }

    public static ItemBuilder<ComponentItem, Registrate> registerItemWithTooltip(String name, int num, Component... other) {
        return registerItemWithTooltip(name, ComponentItem::create, num, other);
    }

    public static <T extends ComponentItem> ItemBuilder<T, Registrate> registerItemWithTooltip(String name, NonNullFunction<Item.Properties, T> factory, int num) {
        return registrate().item(name, factory)
                .onRegister(attach(new TooltipBehavior(lines -> {
                    if (num <= 0) return;

                    if (num == 1) {
                        lines.add(Component.translatable("item.%s.%s.desc".formatted(registrate().getModid(), name)));
                    } else {
                        for (int i = 0; i < num; i++) {
                            lines.add(Component.translatable("item.%s.%s.desc.%s".formatted(registrate().getModid(), name, i)));
                        }
                    }
                })));
    }

    public static <T extends ComponentItem> ItemBuilder<T, Registrate> registerItemWithTooltip(String name, NonNullFunction<Item.Properties, T> factory, int num, Component... other) {
        return registrate().item(name, factory)
                .onRegister(attach(new TooltipBehavior(lines -> {
                    if (num <= 0) return;

                    if (num == 1) {
                        lines.add(Component.translatable("item.%s.%s.desc".formatted(registrate().getModid(), name)));
                        lines.addAll(Arrays.asList(other));
                    } else {
                        for (int i = 0; i < num; i++) {
                            lines.add(Component.translatable("item.%s.%s.desc.%s".formatted(registrate().getModid(), name, i)));
                        }
                        lines.addAll(Arrays.asList(other));
                    }
                })));
    }

    public static <T extends ComponentItem> NonNullConsumer<T> attach(IItemComponent... components) {
        return (item) -> item.attachComponents(components);
    }
    public static <T extends ComponentItem> NonNullConsumer<T> attachRenderer(ICustomRenderer customRenderer) {
        return !Platform.isClient() ? NonNullConsumer.noop() : (item) -> item.attachComponents(customRenderer);
    }
}
