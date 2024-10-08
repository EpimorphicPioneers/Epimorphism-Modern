package com.epimorphismmc.epimorphism.common.data;

import com.epimorphismmc.epimorphism.Epimorphism;
import com.epimorphismmc.epimorphism.common.data.items.EPBiologyItems;
import com.epimorphismmc.epimorphism.common.data.items.EPChemistryItem;
import com.epimorphismmc.epimorphism.common.data.items.EPCircuitItems;
import com.epimorphismmc.epimorphism.common.data.items.EPPhysicsItems;
import com.epimorphismmc.epimorphism.common.data.items.EPWrapItem;
import com.epimorphismmc.epimorphism.common.item.GrindBallItem;
import com.epimorphismmc.epimorphism.common.item.VajraItem;
import com.epimorphismmc.epimorphism.common.item.behaviors.GrindBallBehaviour;
import com.epimorphismmc.epimorphism.common.item.behaviors.OrganismCaptureBehavior;
import com.epimorphismmc.epimorphism.common.item.behaviors.StructureWriteBehavior;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.item.ComponentItem;
import com.gregtechceu.gtceu.api.item.component.ElectricStats;
import com.gregtechceu.gtceu.api.item.component.ICustomRenderer;
import com.gregtechceu.gtceu.api.item.component.IMaterialPartItem;
import com.gregtechceu.gtceu.common.data.GTItems;
import com.gregtechceu.gtceu.common.item.CoverPlaceBehavior;
import com.gregtechceu.gtceu.common.item.TooltipBehavior;
import com.gregtechceu.gtceu.data.recipe.CustomTags;

import com.lowdragmc.lowdraglib.Platform;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import com.tterrag.registrate.Registrate;
import com.tterrag.registrate.builders.ItemBuilder;
import com.tterrag.registrate.util.entry.ItemEntry;
import com.tterrag.registrate.util.nullness.NonNullConsumer;
import com.tterrag.registrate.util.nullness.NonNullFunction;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.List;

import static com.epimorphismmc.epimorphism.EpimorphismCommon.registrate;
import static com.gregtechceu.gtceu.common.data.GTItems.*;

public class EPItems {

    static {
        registrate().creativeModeTab(() -> EPCreativeModeTabs.EP_ITEM);
    }

    //  Boards
    public static final ItemEntry<ComponentItem> GOOWARE_BOARD =
            registerItemWithTooltip("gooware_circuit_board", 1).register();
    public static final ItemEntry<ComponentItem> OPTICAL_BOARD =
            registerItemWithTooltip("optical_circuit_board", 1).register();
    public static final ItemEntry<ComponentItem> SPINTRONIC_BOARD =
            registerItemWithTooltip("spintronic_circuit_board", 1).register();
    public static final ItemEntry<ComponentItem> GOOWARE_PRINTED_CIRCUIT_BOARD =
            registerItemWithTooltip("gooware_printed_circuit_board", 1).register();
    public static final ItemEntry<ComponentItem> OPTICAL_PRINTED_CIRCUIT_BOARD =
            registerItemWithTooltip("optical_printed_circuit_board", 1).register();
    public static final ItemEntry<ComponentItem> SPINTRONIC_PRINTED_CIRCUIT_BOARD =
            registerItemWithTooltip("spintronic_printed_circuit_board", 1).register();

    //  Circuits
    public static final ItemEntry<ComponentItem> GOOWARE_PROCESSOR = registerItemWithTooltip(
                    "gooware_processor", 1, Component.translatable("item.epimorphism.circuit.zpm.desc"))
            .tag(CustomTags.ZPM_CIRCUITS)
            .register();
    public static final ItemEntry<ComponentItem> GOOWARE_ASSEMBLY = registerItemWithTooltip(
                    "gooware_assembly", 1, Component.translatable("item.epimorphism.circuit.uv.desc"))
            .tag(CustomTags.UV_CIRCUITS)
            .register();
    public static final ItemEntry<ComponentItem> GOOWARE_COMPUTER = registerItemWithTooltip(
                    "gooware_computer", 1, Component.translatable("item.epimorphism.circuit.uhv.desc"))
            .tag(CustomTags.UHV_CIRCUITS)
            .register();
    public static final ItemEntry<ComponentItem> GOOWARE_MAINFRAME = registerItemWithTooltip(
                    "gooware_mainframe", 1, Component.translatable("item.epimorphism.circuit.uev.desc"))
            .tag(CustomTags.UEV_CIRCUITS)
            .register();
    public static final ItemEntry<ComponentItem> OPTICAL_PROCESSOR = registerItemWithTooltip(
                    "optical_processor", 1, Component.translatable("item.epimorphism.circuit.uv.desc"))
            .tag(CustomTags.UV_CIRCUITS)
            .register();
    public static final ItemEntry<ComponentItem> OPTICAL_ASSEMBLY = registerItemWithTooltip(
                    "optical_assembly", 1, Component.translatable("item.epimorphism.circuit.uhv.desc"))
            .tag(CustomTags.UHV_CIRCUITS)
            .register();
    public static final ItemEntry<ComponentItem> OPTICAL_COMPUTER = registerItemWithTooltip(
                    "optical_computer", 1, Component.translatable("item.epimorphism.circuit.uev.desc"))
            .tag(CustomTags.UEV_CIRCUITS)
            .register();
    public static final ItemEntry<ComponentItem> OPTICAL_MAINFRAME = registerItemWithTooltip(
                    "optical_mainframe", 1, Component.translatable("item.epimorphism.circuit.uiv.desc"))
            .tag(CustomTags.UIV_CIRCUITS)
            .register();
    public static final ItemEntry<ComponentItem> SPINTRONIC_PROCESSOR = registerItemWithTooltip(
                    "spintronic_processor", 1, Component.translatable("item.epimorphism.circuit.uhv.desc"))
            .tag(CustomTags.UHV_CIRCUITS)
            .register();
    public static final ItemEntry<ComponentItem> SPINTRONIC_ASSEMBLY = registerItemWithTooltip(
                    "spintronic_assembly", 1, Component.translatable("item.epimorphism.circuit.uev.desc"))
            .tag(CustomTags.UEV_CIRCUITS)
            .register();
    public static final ItemEntry<ComponentItem> SPINTRONIC_COMPUTER = registerItemWithTooltip(
                    "spintronic_computer", 1, Component.translatable("item.epimorphism.circuit.uiv.desc"))
            .tag(CustomTags.UIV_CIRCUITS)
            .register();
    public static final ItemEntry<ComponentItem> SPINTRONIC_MAINFRAME = registerItemWithTooltip(
                    "spintronic_mainframe", 1, Component.translatable("item.epimorphism.circuit.uxv.desc"))
            .tag(CustomTags.UXV_CIRCUITS)
            .register();
    public static final ItemEntry<ComponentItem> COSMIC_PROCESSOR = registerItemWithTooltip(
                    "cosmic_processor", 1, Component.translatable("item.epimorphism.circuit.uev.desc"))
            .tag(CustomTags.UEV_CIRCUITS)
            .register();
    public static final ItemEntry<ComponentItem> COSMIC_ASSEMBLY = registerItemWithTooltip(
                    "cosmic_assembly", 1, Component.translatable("item.epimorphism.circuit.uiv.desc"))
            .tag(CustomTags.UIV_CIRCUITS)
            .register();
    public static final ItemEntry<ComponentItem> COSMIC_COMPUTER = registerItemWithTooltip(
                    "cosmic_computer", 1, Component.translatable("item.epimorphism.circuit.uxv.desc"))
            .tag(CustomTags.UXV_CIRCUITS)
            .register();
    public static final ItemEntry<ComponentItem> COSMIC_MAINFRAME = registerItemWithTooltip(
                    "cosmic_mainframe", 1, Component.translatable("item.epimorphism.circuit.opv.desc"))
            .tag(CustomTags.OpV_CIRCUITS)
            .register();
    public static final ItemEntry<ComponentItem> SUPRACAUSAL_PROCESSOR = registerItemWithTooltip(
                    "supracausal_processor", 1, Component.translatable("item.epimorphism.circuit.uiv.desc"))
            .tag(CustomTags.UIV_CIRCUITS)
            .register();
    public static final ItemEntry<ComponentItem> SUPRACAUSAL_ASSEMBLY = registerItemWithTooltip(
                    "supracausal_assembly", 1, Component.translatable("item.epimorphism.circuit.uxv.desc"))
            .tag(CustomTags.UXV_CIRCUITS)
            .register();
    public static final ItemEntry<ComponentItem> SUPRACAUSAL_COMPUTER = registerItemWithTooltip(
                    "supracausal_computer", 1, Component.translatable("item.epimorphism.circuit.opv.desc"))
            .tag(CustomTags.OpV_CIRCUITS)
            .register();
    public static final ItemEntry<ComponentItem> SUPRACAUSAL_MAINFRAME = registerItemWithTooltip(
                    "supracausal_mainframe", 1, Component.translatable("item.epimorphism.circuit.max.desc"))
            .tag(CustomTags.MAX_CIRCUITS)
            .register();

    //  Components
    public static final ItemEntry<ComponentItem> OPTICAL_TRANSISTOR =
            registerItemWithTooltip("optical_smd_transistor", 1).register();
    public static final ItemEntry<ComponentItem> OPTICAL_RESISTOR =
            registerItemWithTooltip("optical_smd_resistor", 1).register();
    public static final ItemEntry<ComponentItem> OPTICAL_CAPACITOR =
            registerItemWithTooltip("optical_smd_capacitor", 1).register();
    public static final ItemEntry<ComponentItem> OPTICAL_DIODE =
            registerItemWithTooltip("optical_smd_diode", 1).register();
    public static final ItemEntry<ComponentItem> OPTICAL_INDUCTOR =
            registerItemWithTooltip("optical_smd_inductor", 1).register();
    public static final ItemEntry<ComponentItem> SPINTRONIC_TRANSISTOR =
            registerItemWithTooltip("spintronic_smd_transistor", 1).register();
    public static final ItemEntry<ComponentItem> SPINTRONIC_RESISTOR =
            registerItemWithTooltip("spintronic_smd_resistor", 1).register();
    public static final ItemEntry<ComponentItem> SPINTRONIC_CAPACITOR =
            registerItemWithTooltip("spintronic_smd_capacitor", 1).register();
    public static final ItemEntry<ComponentItem> SPINTRONIC_DIODE =
            registerItemWithTooltip("spintronic_smd_diode", 1).register();
    public static final ItemEntry<ComponentItem> SPINTRONIC_INDUCTOR =
            registerItemWithTooltip("spintronic_smd_inductor", 1).register();
    public static final ItemEntry<ComponentItem> COSMIC_TRANSISTOR =
            registerItemWithTooltip("cosmic_smd_transistor", 1).register();
    public static final ItemEntry<ComponentItem> COSMIC_RESISTOR =
            registerItemWithTooltip("cosmic_smd_resistor", 1).register();
    public static final ItemEntry<ComponentItem> COSMIC_CAPACITOR =
            registerItemWithTooltip("cosmic_smd_capacitor", 1).register();
    public static final ItemEntry<ComponentItem> COSMIC_DIODE =
            registerItemWithTooltip("cosmic_smd_diode", 1).register();
    public static final ItemEntry<ComponentItem> COSMIC_INDUCTOR =
            registerItemWithTooltip("cosmic_smd_inductor", 1).register();
    public static final ItemEntry<ComponentItem> SUPRACAUSAL_TRANSISTOR =
            registerItemWithTooltip("supracausal_smd_transistor", 1).register();
    public static final ItemEntry<ComponentItem> SUPRACAUSAL_RESISTOR =
            registerItemWithTooltip("supracausal_smd_resistor", 1).register();
    public static final ItemEntry<ComponentItem> SUPRACAUSAL_CAPACITOR =
            registerItemWithTooltip("supracausal_smd_capacitor", 1).register();
    public static final ItemEntry<ComponentItem> SUPRACAUSAL_DIODE =
            registerItemWithTooltip("supracausal_smd_diode", 1).register();
    public static final ItemEntry<ComponentItem> SUPRACAUSAL_INDUCTOR =
            registerItemWithTooltip("supracausal_smd_inductor", 1).register();

    //  Gooware Components
    //    public final static ItemEntry<ComponentItem> BZ_REACTION_CHAMBER =
    // EP_REGISTRATE.item("component.gooware.reaction_chamber", ComponentItem::create)
    //            .lang("Belousov-Zhabotinsky Reaction Chamber")
    //            .register();
    //    public final static ItemEntry<ComponentItem> NONLINEAR_CHEMICAL_OSCILLATOR =
    // registerItemWithTooltip("component.gooware.nonlinear_chemical_oscillator",
    // ComponentItem::create)
    //            .lang("Nonlinear Chemical Oscillator")
    //            .onRegister(attach(new TooltipBehavior(lines -> {
    //
    // lines.add(Component.translatable("item.epimorphism.component.gooware.nonlinear_chemical_oscillator.tooltip"));
    //            })))
    //            .register();

    //  Optical Components
    //    public final static ItemEntry<ComponentItem> OPTICAL_LASER_CONTROL_UNIT =
    // registerItemWithTooltip("component.optical.optical_laser_control_unit", ComponentItem::create)
    //            .lang("Optical Laser Control Unit")
    //            .onRegister(attach(new TooltipBehavior(lines -> {
    //
    // lines.add(Component.translatable("item.epimorphism.component.optical.optical_laser_control_unit.tooltip"));
    //            })))
    //            .register();

    //  Spintronic Components
    //    public final static ItemEntry<ComponentItem> ESR_COMPUTATION_UNIT =
    // registerItemWithTooltip("component.spintronic.esr_computation_unit", ComponentItem::create)
    //            .lang("ESR Computation Unit")
    //            .onRegister(attach(new TooltipBehavior(lines -> {
    //
    // lines.add(Component.translatable("item.epimorphism.component.spintronic.esr_computation_unit.tooltip"));
    //            })))
    //            .register();

    //  Cosmic Components
    //    public final static ItemEntry<ComponentItem> COSMIC_INFORMATION_MODULE =
    // registerItemWithTooltip("component.cosmic.information_module", ComponentItem::create)
    //            .lang("Cosmic Information Module")
    //            .onRegister(attach(new TooltipBehavior(lines -> {
    //
    // lines.add(Component.translatable("item.epimorphism.component.cosmic.information_module.tooltip"));
    //            })))
    //            .register();
    //    public final static ItemEntry<ComponentItem> HOLOGRAPHIC_INFORMATION_IMC =
    // registerItemWithTooltip("component.cosmic.holographic_imc", ComponentItem::create)
    //            .lang("Holographic IMC")
    //            .onRegister(attach(new TooltipBehavior(lines -> {
    //
    // lines.add(Component.translatable("item.epimorphism.component.cosmic.holographic_imc.tooltip"));
    //            })))
    //            .register();

    //  Supracausal Components
    //    public final static ItemEntry<ComponentItem> SPACETIME_CONDENSER =
    // registerItemWithTooltip("component.supracausal.spacetime_condenser", ComponentItem::create)
    //            .lang("Supracausal SpaceTime Condenser")
    //            .onRegister(attach(new TooltipBehavior(lines -> {
    //
    // lines.add(Component.translatable("item.epimorphism.component.supracausal.spacetime_condenser.tooltip"));
    //            })))
    //            .register();
    //    public final static ItemEntry<ComponentItem> LIGHT_CONE_MODULE =
    // registerItemWithTooltip("component.supracausal.light_cone_module", ComponentItem::create)
    //            .lang("Spacetime Light cone Stabilization Module")
    //            .onRegister(attach(new TooltipBehavior(lines -> {
    //
    // lines.add(Component.translatable("item.epimorphism.component.supracausal.light_cone_module.tooltip"));
    //            })))
    //            .register();
    public static final ItemEntry<ComponentItem> MANIFOLD_OSCILLATORY_POWER_CELL =
            registerItemWithTooltip("manifold_oscillatory_power_cell", 1).register();

    //  Halide Lamps
    public static final ItemEntry<ComponentItem> GREEN_LAMP_CORE =
            registerComponentItem("green_lamp_core").register();
    public static final ItemEntry<ComponentItem> GREEN_HALIDE_LAMP =
            registerComponentItem("green_halide_lamp").register();
    public static final ItemEntry<ComponentItem> RED_LAMP_CORE =
            registerComponentItem("red_lamp_core").register();
    public static final ItemEntry<ComponentItem> RED_HALIDE_LAMP =
            registerComponentItem("red_halide_lamp").register();
    public static final ItemEntry<ComponentItem> BLUE_LAMP_CORE =
            registerComponentItem("blue_lamp_core").register();
    public static final ItemEntry<ComponentItem> BLUE_HALIDE_LAMP =
            registerComponentItem("blue_halide_lamp").register();
    public static final ItemEntry<ComponentItem> WHITE_LAMP_CORE =
            registerComponentItem("white_lamp_core").register();
    public static final ItemEntry<ComponentItem> WHITE_HALIDE_LAMP =
            registerComponentItem("white_halide_lamp").register();
    public static final ItemEntry<ComponentItem> UVA_LAMP_CORE =
            registerComponentItem("uva_lamp_core").register();

    //  Lasers
    public static final ItemEntry<ComponentItem> DIELECTRIC_MIRROR =
            registerItemWithTooltip("dielectric_mirror", 1).register();
    public static final ItemEntry<ComponentItem> EMPTY_GAS_LASER_EMITTER =
            registerItemWithTooltip("empty_gas_laser_emitter", 1).register();
    public static final ItemEntry<ComponentItem> OPTICAL_FIBER =
            registerItemWithTooltip("optical_fiber", 1).register();
    public static final ItemEntry<Item> CLADDED_OPTICAL_FIBER_CORE =
            registerItem("cladded_optical_fiber_core").register();

    public static final ItemEntry<ComponentItem> ROTATING_TRANSPARENT_SURFACE =
            registerItemWithTooltip("rotating_transparent_surface", 1).register();
    public static final ItemEntry<ComponentItem> PERIODICALLY_POLED_LITHIUM_NIOBATE_BOULE =
            registerItemWithTooltip("periodically_poled_lithium_niobate_boule", 1).register();
    public static final ItemEntry<ComponentItem> NON_LINEAR_OPTICAL_LENS =
            registerItemWithTooltip("non_linear_optical_lens", 1).register();

    //  Condenser Components
    //    public final static ItemEntry<ComponentItem> TOPOLOGICAL_INSULATOR_TUBE =
    // registerItemWithTooltip("tube.topological_insulator", ComponentItem::create)
    //            .lang("Topological Insulator Tube")
    //            .onRegister(attach(new TooltipBehavior(lines -> {
    //
    // lines.add(Component.translatable("item.epimorphism.tube.topological_insulator.tooltip"));
    //            })))
    //            .register();
    public static final ItemEntry<ComponentItem> BOSE_EINSTEIN_CONDENSATE_CONTAINMENT_UNIT =
            registerItemWithTooltip("bose_einstein_condensate_containment_unit", 1).register();
    public static final ItemEntry<ComponentItem> BOSE_EINSTEIN_CONDENSATE =
            registerItemWithTooltip("bose_einstein_condensate", 1).register();

    //  Wafers
    //    public final static ItemEntry<ComponentItem> PHASE_CHANGE_MEMORY =
    // registerItemWithTooltip("wafer.chip.phase_change_memory", ComponentItem::create)
    //            .lang("PRAM")
    //            .onRegister(attach(new TooltipBehavior(lines -> {
    //
    // lines.add(Component.translatable("item.epimorphism.wafer.chip.phase_change_memory.tooltip"));
    //            })))
    //            .register();
    //    public final static ItemEntry<ComponentItem> OPTICAL_NOR_MEMORY_CHIP =
    // registerItemWithTooltip("wafer.chip.optical_nor_memory_chip", ComponentItem::create)
    //            .lang("ACNOR")
    //            .onRegister(attach(new TooltipBehavior(lines -> {
    //
    // lines.add(Component.translatable("item.epimorphism.wafer.chip.optical_nor_memory_chip.tooltip"));
    //            })))
    //            .register();
    //    public final static ItemEntry<ComponentItem> SPIN_TRANSFER_TORQUE_MEMORY =
    // registerItemWithTooltip("wafer.chip.spin_transfer_torque_memory", ComponentItem::create)
    //            .lang("STTRAM")
    //            .onRegister(attach(new TooltipBehavior(lines -> {
    //
    // lines.add(Component.translatable("item.epimorphism.wafer.chip.spin_transfer_torque_memory.tooltip"));
    //            })))
    //            .register();
    //    public final static ItemEntry<ComponentItem> SPINTRONIC_NAND_MEMORY_CHIP =
    // registerItemWithTooltip("wafer.chip.spintronic_nand_memory_chip", ComponentItem::create)
    //            .lang("MDNAND")
    //            .onRegister(attach(new TooltipBehavior(lines -> {
    //
    // lines.add(Component.translatable("item.epimorphism.wafer.chip.spintronic_nand_memory_chip.tooltip"));
    //            })))
    //            .register();
    public static final ItemEntry<ComponentItem> NANO_PIC_WAFER =
            registerItemWithTooltip("nano_pic_wafer", 1).register();
    public static final ItemEntry<ComponentItem> NANO_PIC_CHIP =
            registerItemWithTooltip("nano_pic_chip", 1).register();
    public static final ItemEntry<ComponentItem> PICO_PIC_WAFER =
            registerItemWithTooltip("pico_pic_wafer", 1).register();
    public static final ItemEntry<ComponentItem> PICO_PIC_CHIP =
            registerItemWithTooltip("pico_pic_chip", 1).register();
    //    public final static ItemEntry<ComponentItem> FEMTO_PIC_WAFER =
    // registerItemWithTooltip("wafer.femto_pic", ComponentItem::create)
    //            .lang("FPIC Wafer")
    //            .onRegister(attach(new TooltipBehavior(lines -> {
    //                lines.add(Component.translatable("item.epimorphism.wafer.femto_pic.tooltip"));
    //            })))
    //            .register();
    //    public final static ItemEntry<ComponentItem> FEMTO_PIC_CHIP =
    // registerItemWithTooltip("wafer.chip.femto_pic", ComponentItem::create)
    //            .lang("FPIC")
    //            .onRegister(attach(new TooltipBehavior(lines -> {
    //
    // lines.add(Component.translatable("item.epimorphism.wafer.chip.femto_pic.tooltip"));
    //            })))
    //            .register();
    //    public final static ItemEntry<ComponentItem> ATTO_PIC_WAFER =
    // registerItemWithTooltip("wafer.atto_pic", ComponentItem::create)
    //            .lang("APIC Wafer")
    //            .onRegister(attach(new TooltipBehavior(lines -> {
    //                lines.add(Component.translatable("item.epimorphism.wafer.atto_pic.tooltip"));
    //            })))
    //            .register();
    //    public final static ItemEntry<ComponentItem> ATTO_PIC_CHIP =
    // registerItemWithTooltip("wafer.chip.atto_pic", ComponentItem::create)
    //            .lang("APIC")
    //            .onRegister(attach(new TooltipBehavior(lines -> {
    //
    // lines.add(Component.translatable("item.epimorphism.wafer.chip.atto_pic.tooltip"));
    //            })))
    //            .register();
    //    public final static ItemEntry<ComponentItem> ZEPTO_PIC_WAFER =
    // registerItemWithTooltip("wafer.zepto_pic", ComponentItem::create)
    //            .lang("ZPIC Wafer")
    //            .onRegister(attach(new TooltipBehavior(lines -> {
    //                lines.add(Component.translatable("item.epimorphism.wafer.zepto_pic.tooltip"));
    //            })))
    //            .register();
    //    public final static ItemEntry<ComponentItem> ZEPTO_PIC_CHIP =
    // registerItemWithTooltip("wafer.chip.zepto_pic", ComponentItem::create)
    //            .lang("ZPIC")
    //            .onRegister(attach(new TooltipBehavior(lines -> {
    //
    // lines.add(Component.translatable("item.epimorphism.wafer.chip.zepto_pic.tooltip"));
    //            })))
    //            .register();
    public static final ItemEntry<ComponentItem> DUBNIUM_BOULE =
            registerItemWithTooltip("dubnium_boule", 1).register();
    public static final ItemEntry<ComponentItem> DUBNIUM_WAFER =
            registerItemWithTooltip("dubnium_wafer", 1).register();
    public static final ItemEntry<ComponentItem> EUROPIUM_CUBIC_ZIRCONIA_BOULE =
            registerItemWithTooltip("europium_cubic_zirconia_boule", 1).register();
    public static final ItemEntry<ComponentItem> EUROPIUM_CUBIC_ZIRCONIA_WAFER =
            registerItemWithTooltip("europium_cubic_zirconia_wafer", 1).register();
    public static final ItemEntry<ComponentItem> CRYSTAL_INTERFACE_WAFER =
            registerItemWithTooltip("crystal_interface_wafer", 1).register();
    //    public final static ItemEntry<ComponentItem> CRYSTAL_INTERFACE_CHIP =
    // registerItemWithTooltip("wafer.chip.crystal_interface", ComponentItem::create)
    //            .lang("Infinite Circuit Board")
    //            .onRegister(attach(new TooltipBehavior(lines -> {
    //
    // lines.add(Component.translatable("item.epimorphism.wafer.chip.crystal_interface.tooltip"));
    //            })))
    //            .register();
    //    public final static ItemEntry<ComponentItem> UHASOC_WAFER =
    // registerItemWithTooltip("wafer.uhasoc", ComponentItem::create)
    //            .lang("Infinite Circuit Board")
    //            .onRegister(attach(new TooltipBehavior(lines -> {
    //                lines.add(Component.translatable("item.epimorphism.wafer.uhasoc.tooltip"));
    //            })))
    //            .register();
    //    public final static ItemEntry<ComponentItem> UHASOC_CHIP =
    // registerItemWithTooltip("wafer.chip.uhasoc", ComponentItem::create)
    //            .lang("Infinite Circuit Board")
    //            .onRegister(attach(new TooltipBehavior(lines -> {
    //                lines.add(Component.translatable("item.epimorphism.wafer.chip.uhasoc.tooltip"));
    //            })))
    //            .register();
    public static final ItemEntry<ComponentItem> INTRAVITAL_SOC =
            registerItemWithTooltip("intravital_soc", 1).register();
    public static final ItemEntry<ComponentItem> BOHRIUM_STRONTIUM_CARBONATE_BOULE =
            registerItemWithTooltip("bohrium_strontium_carbonate_boule", 1).register();
    public static final ItemEntry<ComponentItem> BOHRIUM_STRONTIUM_CARBONATE_WAFER =
            registerItemWithTooltip("bohrium_strontium_carbonate_wafer", 1).register();
    public static final ItemEntry<ComponentItem> STRONTIUM_CARBONATE_WAFER =
            registerItemWithTooltip("strontium_carbonate_wafer", 1).register();
    public static final ItemEntry<ComponentItem> OPTICAL_IMC_BOARD =
            registerItemWithTooltip("optical_imc_board", 1).register();
    public static final ItemEntry<ComponentItem> PHOTOELECTRON_SOC =
            registerItemWithTooltip("photoelectron_soc", 1).register();
    //  Others
    //    public final static ItemEntry<Item> MAGNETRON;
    public static final ItemEntry<ComponentItem> VOLTAGE_COIL_UHV =
            registerItemWithTooltip("uhv_voltage_coil", 1).register();
    public static final ItemEntry<ComponentItem> VOLTAGE_COIL_UEV =
            registerItemWithTooltip("uev_voltage_coil", 1).register();
    public static final ItemEntry<ComponentItem> VOLTAGE_COIL_UIV =
            registerItemWithTooltip("uiv_voltage_coil", 1).register();
    public static final ItemEntry<ComponentItem> VOLTAGE_COIL_UXV =
            registerItemWithTooltip("uxv_voltage_coil", 1).register();
    public static final ItemEntry<ComponentItem> VOLTAGE_COIL_OPV =
            registerItemWithTooltip("opv_voltage_coil", 1).register();
    //    public final static ItemEntry<ComponentItem> VOLTAGE_COIL_MAX;
    //    public final static ItemEntry<Item> CARBON_ALLOTROPE;
    //    public final static ItemEntry<Item> GRAPHENE_ALIGNED;
    //    public final static ItemEntry<Item> BORON_NITRIDE_GRINDER;
    //    public final static ItemEntry<Item> VACUUM_TUBE_COMPONENT;
    //    public final static ItemEntry<Item> SEPARATION_ELECTROMAGNET;
    public static final ItemEntry<Item> PROTONATED_FULLERENE_SIEVING_MATRIX =
            registerItem("protonated_fullerene_sieving_matrix").register();
    public static final ItemEntry<Item> SATURATED_FULLERENE_SIEVING_MATRIX =
            registerItem("saturated_fullerene_sieving_matrix").register();
    public static ItemEntry<ComponentItem> INVERTER =
            registerItemWithTooltip("inverter", 1).lang("Inverter").register();
    public static final ItemEntry<Item> METASTABLE_SELF_HEALING_ADHESIVE =
            registerItem("metastable_self_healing_adhesive").register();
    public static final ItemEntry<Item> HYPERDIMENSIONAL_TACHYON_CONDENSED_MATTER =
            registerItem("hyperdimensional_tachyon_condensed_matter").register();
    public static final ItemEntry<ComponentItem> LEPTON_TRAP_CRYSTAL =
            registerItemWithTooltip("lepton_trap_crystal", 1).register();
    public static final ItemEntry<ComponentItem> CHARGED_LEPTON_TRAP_CRYSTAL =
            registerItemWithTooltip("charged_lepton_trap_crystal", 1).register();
    public static final ItemEntry<ComponentItem> UNSTABLE_STAR =
            registerItemWithTooltip("unstable_star", 1).register();
    public static final ItemEntry<ComponentItem> ZENITH_STAR =
            registerItemWithTooltip("zenith_star", 1).register();

    public static final ItemEntry<ComponentItem> NEUTRONIUM_SPHERET =
            registerItemWithTooltip("neutronium_spheret", 1).register();
    public static final ItemEntry<ComponentItem> TRIPLET_NEUTRONIUM_SPHERET =
            registerItemWithTooltip("triplet_neutronium_spheret", 1).register();
    public static final ItemEntry<ComponentItem> CHARGED_TRIPLET_NEUTRONIUM_SPHERE =
            registerItemWithTooltip("charged_triplet_neutronium_sphere", 1).register();

    //    public final static ItemEntry<Item> CLOSED_TIMELIKE_CURVE_COMPUTATIONAL_UNIT;
    //    public final static ItemEntry<Item> CLOSED_TIMELIKE_CURVE_GUIDANCE_UNIT;
    //    public final static ItemEntry<Item> NUCLEAR_CLOCK;
    //    public final static ItemEntry<Item> MANIFOLD_OSCILLATORY_POWER_CELL;
    //    public final static ItemEntry<Item> SCINTILLATOR = registerItem("scintillator",
    // Item::new).lang("Scintillator").register();
    public static final ItemEntry<ComponentItem> SCINTILLATOR_CRYSTAL =
            registerItemWithTooltip("scintillator_crystal", 1).register();

    //  Crystal Components
    public static final ItemEntry<ComponentItem> DIAMOND_CHIP =
            registerItemWithTooltip("diamond_chip", 1).register();
    public static final ItemEntry<ComponentItem> RUBY_CHIP =
            registerItemWithTooltip("ruby_chip", 1).register();
    public static final ItemEntry<ComponentItem> SAPPHIRE_CHIP =
            registerItemWithTooltip("sapphire_chip", 1).register();
    public static final ItemEntry<ComponentItem> DIAMOND_MODULATOR =
            registerItemWithTooltip("diamond_modulator", 1).register();
    public static final ItemEntry<ComponentItem> RUBY_MODULATOR =
            registerItemWithTooltip("ruby_modulator", 1).register();
    public static final ItemEntry<ComponentItem> SAPPHIRE_MODULATOR =
            registerItemWithTooltip("sapphire_modulator", 1).register();
    //    public final static ItemEntry<Item> CRYSTAL_SOC_SOCKET;

    //  Covers
    public static final ItemEntry<ComponentItem> ELECTRIC_PUMP_MAX = registerComponentItem(
                    "max_electric_pump")
            .onRegister(attach(new CoverPlaceBehavior(EPCovers.ELECTRIC_PUMP_MAX)))
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("item.gtceu.electric.pump.tooltip"));
                lines.add(Component.translatable(
                        "gtceu.universal.tooltip.fluid_transfer_rate", 1280 * 64 * 64 * 4 / 20));
            })))
            .register();
    public static ItemEntry<ComponentItem> FLUID_REGULATOR_MAX = registerComponentItem(
                    "max_fluid_regulator")
            .onRegister(attach(new CoverPlaceBehavior(EPCovers.FLUID_REGULATORS_MAX)))
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("item.gtceu.fluid.regulator.tooltip"));
                lines.add(Component.translatable(
                        "gtceu.universal.tooltip.fluid_transfer_rate", 1280 * 64 * 64 * 4 / 20));
            })))
            .register();
    public static final ItemEntry<ComponentItem> CONVEYOR_MODULE_MAX = registerComponentItem(
                    "max_conveyor_module")
            .onRegister(attach(new CoverPlaceBehavior(EPCovers.CONVEYOR_MODULE_MAX)))
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("item.gtceu.conveyor.module.tooltip"));
                lines.add(Component.translatable("gtceu.universal.tooltip.item_transfer_rate_stacks", 16));
            })))
            .register();
    public static final ItemEntry<ComponentItem> ROBOT_ARM_MAX = registerComponentItem(
                    "max_robot_arm")
            .onRegister(attach(new CoverPlaceBehavior(EPCovers.ROBOT_ARM_MAX)))
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("item.gtceu.robot.arm.tooltip"));
                lines.add(Component.translatable("gtceu.universal.tooltip.item_transfer_rate_stacks", 16));
            })))
            .register();
    public static final ItemEntry<Item> ELECTRIC_MOTOR_MAX =
            registerItem("max_electric_motor").register();
    public static final ItemEntry<Item> ELECTRIC_PISTON_MAX =
            registerItem("max_electric_piston").register();
    public static final ItemEntry<Item> EMITTER_MAX = registerItem("max_emitter").register();
    public static final ItemEntry<Item> SENSOR_MAX = registerItem("max_sensor").register();
    public static final ItemEntry<Item> FIELD_GENERATOR_MAX =
            registerItem("max_field_generator").register();

    //  Debug
    public static final ItemEntry<ComponentItem> DEBUG_STRUCTURE_WRITER = registerItemWithTooltip(
                    "debug_structure_writer", 1)
            .onRegister(GTItems.attach(StructureWriteBehavior.INSTANCE))
            .register();

    //  Tool
    public static final ItemEntry<ComponentItem> ORGANISM_CAPTURE_TOOL = registerComponentItem(
                    "organism_capture_tool")
            .model(EPModels::captureToolModel)
            .onRegister(attach(
                    new TooltipBehavior(lines ->
                            lines.add(Component.translatable("item.epimorphism.organism_capture_tool.desc"))) {
                        @Override
                        public void appendHoverText(
                                ItemStack stack,
                                @Nullable Level level,
                                List<Component> tooltipComponents,
                                TooltipFlag isAdvanced) {
                            super.appendHoverText(stack, level, tooltipComponents, isAdvanced);
                            tooltipComponents.add(Component.translatable(
                                    "item.epimorphism.organism_capture_tool.desc.info",
                                    OrganismCaptureBehavior.getEntityName(stack)));
                        }
                    }))
            .onRegister(attach(OrganismCaptureBehavior.INSTANCE))
            .onRegister(GTItems.modelPredicate(
                    Epimorphism.id("organism_capture_tool"),
                    itemStack -> OrganismCaptureBehavior.hasEntity(itemStack) ? 1f : 0f))
            .register();

    // Grind Ball
    public static ItemEntry<GrindBallItem> GRIND_BALL = registrate()
            .item("grind_ball", GrindBallItem::new)
            .properties(p -> p.stacksTo(1))
            .color(() -> IMaterialPartItem::getItemStackColor)
            .model(EPModels.simpleCustomModel(
                    new ResourceLocation("item/generated"), Epimorphism.id("item/grind_ball/base")))
            .onRegister(GTItems.attach(new GrindBallBehaviour()))
            .register();

    // Tools
    static {
        registrate().creativeModeTab(EPCreativeModeTabs.EP_TOOL);
    }

    public static final ItemEntry<VajraItem> VAJRA = registrate()
            .item("vajra", VajraItem::new)
            .properties(p -> p.stacksTo(1))
            .model(EPModels.simpleCustomModel(
                    Epimorphism.id("item/tool_vajra"), Epimorphism.id("item/vajra")))
            .onRegister(attach(ElectricStats.createElectricItem(20_000_000_000L, GTValues.UV)))
            .register();

    public static final ItemEntry<ComponentItem> MITTS = registerItemWithTooltip("mitts", 1)
            .lang("Mitts")
            .properties(p -> p.stacksTo(1).durability(2000))
            .register();

    private EPItems() {
        /**/
    }

    public static void init() {
        EPWrapItem.init();
        EPPhysicsItems.init();
        EPBiologyItems.init();
        EPChemistryItem.init();
        EPCircuitItems.init();
    }

    public static ItemBuilder<ComponentItem, Registrate> registerComponentItem(String name) {
        return registrate().item(name, ComponentItem::create);
    }

    public static ItemBuilder<Item, Registrate> registerItem(String name) {
        return registrate().item(name, Item::new);
    }

    public static ItemBuilder<ComponentItem, Registrate> registerItemWithTooltip(
            String name, int num) {
        return registerItemWithTooltip(name, ComponentItem::create, num);
    }

    public static ItemBuilder<ComponentItem, Registrate> registerItemWithTooltip(
            String name, int num, Component... other) {
        return registerItemWithTooltip(name, ComponentItem::create, num, other);
    }

    public static <T extends ComponentItem> ItemBuilder<T, Registrate> registerItemWithTooltip(
            String name, NonNullFunction<Item.Properties, T> factory, int num) {
        return registrate().item(name, factory).onRegister(attach(new TooltipBehavior(lines -> {
            if (num <= 0) return;

            if (num == 1) {
                lines.add(
                        Component.translatable("item.%s.%s.desc".formatted(registrate().getModid(), name)));
            } else {
                for (int i = 0; i < num; i++) {
                    lines.add(Component.translatable(
                            "item.%s.%s.desc.%s".formatted(registrate().getModid(), name, i)));
                }
            }
        })));
    }

    public static <T extends ComponentItem> ItemBuilder<T, Registrate> registerItemWithTooltip(
            String name, NonNullFunction<Item.Properties, T> factory, int num, Component... other) {
        return registrate().item(name, factory).onRegister(attach(new TooltipBehavior(lines -> {
            if (num <= 0) return;

            if (num == 1) {
                lines.add(
                        Component.translatable("item.%s.%s.desc".formatted(registrate().getModid(), name)));
                lines.addAll(Arrays.asList(other));
            } else {
                for (int i = 0; i < num; i++) {
                    lines.add(Component.translatable(
                            "item.%s.%s.desc.%s".formatted(registrate().getModid(), name, i)));
                }
                lines.addAll(Arrays.asList(other));
            }
        })));
    }

    public static <T extends ComponentItem> NonNullConsumer<T> attachRenderer(
            ICustomRenderer customRenderer) {
        return !Platform.isClient()
                ? NonNullConsumer.noop()
                : item -> item.attachComponents(customRenderer);
    }
}
