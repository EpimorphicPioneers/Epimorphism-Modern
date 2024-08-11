package com.epimorphismmc.epimorphism.common.data.items;

import com.epimorphismmc.epimorphism.Epimorphism;
import com.epimorphismmc.epimorphism.common.data.EPItems;
import com.epimorphismmc.epimorphism.common.data.EPModels;
import com.epimorphismmc.epimorphism.common.item.behaviors.renderer.SuperscriptItemBehavior;

import com.epimorphismmc.monomorphism.data.recipe.MOCustomTags;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.item.ComponentItem;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;

import com.tterrag.registrate.util.entry.ItemEntry;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;

import static com.epimorphismmc.epimorphism.EpimorphismCommon.registrate;
import static com.epimorphismmc.epimorphism.common.data.EPCreativeModeTabs.EP_CIRCUIT_REFORM;
import static com.epimorphismmc.epimorphism.common.data.EPItems.*;
import static com.gregtechceu.gtceu.api.GTValues.*;
import static com.gregtechceu.gtceu.common.data.GTItems.*;

public class EPWrapItem {
    public static final Object2ObjectOpenHashMap<ItemLike, ItemLike> WRAP_ITEM_MAP =
            new Object2ObjectOpenHashMap<>();
    public static final Object2ObjectOpenHashMap<TagKey<Item>, ItemLike> WRAP_CIRCUIT_MAP =
            new Object2ObjectOpenHashMap<>();

    static {
        registrate().creativeModeTab(() -> EP_CIRCUIT_REFORM);
    }

    //  Wrap Circuits
    public static final ItemEntry<ComponentItem> WRAP_CIRCUIT_ULV =
            registerWrapCircuit("ulv_wrap_circuit", GTCEu.id("item/nand_chip"), ULV);
    public static final ItemEntry<ComponentItem> WRAP_CIRCUIT_LV =
            registerWrapCircuit("lv_wrap_circuit", GTCEu.id("item/microchip_processor"), LV);
    public static final ItemEntry<ComponentItem> WRAP_CIRCUIT_MV =
            registerWrapCircuit("mv_wrap_circuit", GTCEu.id("item/micro_processor"), MV);
    public static final ItemEntry<ComponentItem> WRAP_CIRCUIT_HV =
            registerWrapCircuit("hv_wrap_circuit", GTCEu.id("item/nano_processor"), HV);
    public static final ItemEntry<ComponentItem> WRAP_CIRCUIT_EV =
            registerWrapCircuit("ev_wrap_circuit", GTCEu.id("item/quantum_processor"), EV);
    public static final ItemEntry<ComponentItem> WRAP_CIRCUIT_IV =
            registerWrapCircuit("iv_wrap_circuit", GTCEu.id("item/crystal_processor"), IV);
    public static final ItemEntry<ComponentItem> WRAP_CIRCUIT_LuV =
            registerWrapCircuit("luv_wrap_circuit", GTCEu.id("item/wetware_processor"), LuV);
    public static final ItemEntry<ComponentItem> WRAP_CIRCUIT_ZPM =
            registerWrapCircuit("zpm_wrap_circuit", Epimorphism.id("item/gooware_processor"), ZPM);
    public static final ItemEntry<ComponentItem> WRAP_CIRCUIT_UV =
            registerWrapCircuit("uv_wrap_circuit", Epimorphism.id("item/optical_processor"), UV);
    public static final ItemEntry<ComponentItem> WRAP_CIRCUIT_UHV =
            registerWrapCircuit("uhv_wrap_circuit", Epimorphism.id("item/spintronic_processor"), UHV);
    public static final ItemEntry<ComponentItem> WRAP_CIRCUIT_UEV =
            registerWrapCircuit("uev_wrap_circuit", Epimorphism.id("item/cosmic_processor"), UEV);
    public static final ItemEntry<ComponentItem> WRAP_CIRCUIT_UIV =
            registerWrapCircuit("uiv_wrap_circuit", Epimorphism.id("item/supracausal_processor"), UIV);
    public static final ItemEntry<ComponentItem> WRAP_CIRCUIT_UXV =
            registerWrapCircuit("uxv_wrap_circuit", Epimorphism.id("item/supracausal_assembly"), UXV);
    public static final ItemEntry<ComponentItem> WRAP_CIRCUIT_OpV =
            registerWrapCircuit("opv_wrap_circuit", Epimorphism.id("item/supracausal_computer"), OpV);
    public static final ItemEntry<ComponentItem> CIRCUIT_MAX =
            registerWrapCircuit("max_wrap_circuit", Epimorphism.id("item/supracausal_mainframe"), MAX);

    public static final ItemEntry<ComponentItem> WRAP_BOARD_COATED =
            registerWrapItem("resin_wrap_circuit_board", COATED_BOARD, 1);
    public static final ItemEntry<ComponentItem> WRAP_BOARD_PHENOLIC =
            registerWrapItem("phenolic_wrap_circuit_board", PHENOLIC_BOARD, 2);
    public static final ItemEntry<ComponentItem> WRAP_BOARD_PLASTIC =
            registerWrapItem("plastic_wrap_circuit_board", PLASTIC_BOARD, 3);
    public static final ItemEntry<ComponentItem> WRAP_BOARD_EPOXY =
            registerWrapItem("epoxy_wrap_circuit_board", EPOXY_BOARD, 4);
    public static final ItemEntry<ComponentItem> WRAP_BOARD_FIBER =
            registerWrapItem("fiber_reinforced_wrap_circuit_board", FIBER_BOARD, 5);
    public static final ItemEntry<ComponentItem> WRAP_BOARD_MULTILAYER_FIBER =
            registerWrapItem("multilayer_fiber_reinforced_wrap_circuit_board", MULTILAYER_FIBER_BOARD, 6);
    public static final ItemEntry<ComponentItem> WRAP_BOARD_WETWARE =
            registerWrapItem("wetware_wrap_circuit_board", WETWARE_BOARD, 7);
    public static final ItemEntry<ComponentItem> WRAP_BOARD_GOOWARE =
            registerWrapItem("gooware_wrap_circuit_board", GOOWARE_BOARD, 8);
    public static final ItemEntry<ComponentItem> WRAP_BOARD_OPTICAL =
            registerWrapItem("optical_wrap_circuit_board", OPTICAL_BOARD, 9);
    public static final ItemEntry<ComponentItem> WRAP_BOARD_SPINTRONIC =
            registerWrapItem("spintronic_wrap_circuit_board", SPINTRONIC_BOARD, 10);

    public static final ItemEntry<ComponentItem> WRAP_CIRCUIT_BOARD_BASIC =
            registerWrapItem("resin_wrap_printed_circuit_board", BASIC_CIRCUIT_BOARD, 1);
    public static final ItemEntry<ComponentItem> WRAP_CIRCUIT_BOARD_GOOD =
            registerWrapItem("phenolic_wrap_printed_circuit_board", GOOD_CIRCUIT_BOARD, 2);
    public static final ItemEntry<ComponentItem> WRAP_CIRCUIT_BOARD_PLASTIC =
            registerWrapItem("plastic_wrap_printed_circuit_board", PLASTIC_CIRCUIT_BOARD, 3);
    public static final ItemEntry<ComponentItem> WRAP_CIRCUIT_BOARD_ADVANCED =
            registerWrapItem("epoxy_wrap_printed_circuit_board", ADVANCED_CIRCUIT_BOARD, 4);
    public static final ItemEntry<ComponentItem> WRAP_CIRCUIT_BOARD_EXTREME =
            registerWrapItem("fiber_reinforced_wrap_printed_circuit_board", EXTREME_CIRCUIT_BOARD, 5);
    public static final ItemEntry<ComponentItem> WRAP_CIRCUIT_BOARD_ELITE = registerWrapItem(
            "multilayer_fiber_reinforced_wrap_printed_circuit_board", ELITE_CIRCUIT_BOARD, 6);
    public static final ItemEntry<ComponentItem> WRAP_CIRCUIT_BOARD_WETWARE =
            registerWrapItem("wetware_wrap_printed_circuit_board", WETWARE_CIRCUIT_BOARD, 7);
    public static final ItemEntry<ComponentItem> WRAP_CIRCUIT_BOARD_GOOWARE =
            registerWrapItem("gooware_wrap_printed_circuit_board", GOOWARE_PRINTED_CIRCUIT_BOARD, 8);
    public static final ItemEntry<ComponentItem> WRAP_CIRCUIT_BOARD_OPTICAL =
            registerWrapItem("optical_wrap_printed_circuit_board", OPTICAL_PRINTED_CIRCUIT_BOARD, 9);
    public static final ItemEntry<ComponentItem> WRAP_CIRCUIT_BOARD_SPINTRONIC = registerWrapItem(
            "spintronic_wrap_printed_circuit_board", SPINTRONIC_PRINTED_CIRCUIT_BOARD, 10);

    public static final ItemEntry<ComponentItem> WRAP_SMD_TRANSISTOR =
            registerWrapItem("wrap_smd_transistor", SMD_TRANSISTOR, 1);
    public static final ItemEntry<ComponentItem> WRAP_SMD_RESISTOR =
            registerWrapItem("wrap_smd_resistor", SMD_RESISTOR, 1);
    public static final ItemEntry<ComponentItem> WRAP_SMD_CAPACITOR =
            registerWrapItem("wrap_smd_capacitor", SMD_CAPACITOR, 1);
    public static final ItemEntry<ComponentItem> WRAP_SMD_DIODE =
            registerWrapItem("wrap_smd_diode", SMD_DIODE, 1);
    public static final ItemEntry<ComponentItem> WRAP_SMD_INDUCTOR =
            registerWrapItem("wrap_smd_inductor", SMD_INDUCTOR, 1);

    public static final ItemEntry<ComponentItem> WRAP_SMD_TRANSISTOR_ADVANCED =
            registerWrapItem("wrap_advanced_smd_transistor", ADVANCED_SMD_TRANSISTOR, 2);
    public static final ItemEntry<ComponentItem> WRAP_SMD_RESISTOR_ADVANCED =
            registerWrapItem("wrap_advanced_smd_resistor", ADVANCED_SMD_RESISTOR, 2);
    public static final ItemEntry<ComponentItem> WRAP_SMD_CAPACITOR_ADVANCED =
            registerWrapItem("wrap_advanced_smd_capacitor", ADVANCED_SMD_CAPACITOR, 2);
    public static final ItemEntry<ComponentItem> WRAP_SMD_DIODE_ADVANCED =
            registerWrapItem("wrap_advanced_smd_diode", ADVANCED_SMD_DIODE, 2);
    public static final ItemEntry<ComponentItem> WRAP_SMD_INDUCTOR_ADVANCED =
            registerWrapItem("wrap_advanced_smd_inductor", ADVANCED_SMD_INDUCTOR, 2);

    public static final ItemEntry<ComponentItem> WRAP_SMD_TRANSISTOR_OPTICAL =
            registerWrapItem("wrap_optical_smd_transistor", OPTICAL_TRANSISTOR, 3);
    public static final ItemEntry<ComponentItem> WRAP_SMD_RESISTOR_OPTICAL =
            registerWrapItem("wrap_optical_smd_resistor", OPTICAL_RESISTOR, 3);
    public static final ItemEntry<ComponentItem> WRAP_SMD_CAPACITOR_OPTICAL =
            registerWrapItem("wrap_optical_smd_capacitor", OPTICAL_CAPACITOR, 3);
    public static final ItemEntry<ComponentItem> WRAP_SMD_DIODE_OPTICAL =
            registerWrapItem("wrap_optical_smd_diode", OPTICAL_DIODE, 3);
    public static final ItemEntry<ComponentItem> WRAP_SMD_INDUCTOR_OPTICAL =
            registerWrapItem("wrap_optical_smd_inductor", OPTICAL_INDUCTOR, 3);

    public static final ItemEntry<ComponentItem> WRAP_SMD_TRANSISTOR_SPINTRONIC =
            registerWrapItem("wrap_spintronic_smd_transistor", SPINTRONIC_TRANSISTOR, 4);
    public static final ItemEntry<ComponentItem> WRAP_SMD_RESISTOR_SPINTRONIC =
            registerWrapItem("wrap_spintronic_smd_resistor", SPINTRONIC_RESISTOR, 4);
    public static final ItemEntry<ComponentItem> WRAP_SMD_CAPACITOR_SPINTRONIC =
            registerWrapItem("wrap_spintronic_smd_capacitor", SPINTRONIC_CAPACITOR, 4);
    public static final ItemEntry<ComponentItem> WRAP_SMD_DIODE_SPINTRONIC =
            registerWrapItem("wrap_spintronic_smd_diode", SPINTRONIC_DIODE, 4);
    public static final ItemEntry<ComponentItem> WRAP_SMD_INDUCTOR_SPINTRONIC =
            registerWrapItem("wrap_spintronic_smd_inductor", SPINTRONIC_INDUCTOR, 4);

    public static final ItemEntry<ComponentItem> WRAP_SMD_TRANSISTOR_COSMIC =
            registerWrapItem("wrap_cosmic_smd_transistor", COSMIC_TRANSISTOR, 5);
    public static final ItemEntry<ComponentItem> WRAP_SMD_RESISTOR_COSMIC =
            registerWrapItem("wrap_cosmic_smd_resistor", COSMIC_RESISTOR, 5);
    public static final ItemEntry<ComponentItem> WRAP_SMD_CAPACITOR_COSMIC =
            registerWrapItem("wrap_cosmic_smd_capacitor", COSMIC_CAPACITOR, 5);
    public static final ItemEntry<ComponentItem> WRAP_SMD_DIODE_COSMIC =
            registerWrapItem("wrap_cosmic_smd_diode", COSMIC_DIODE, 5);
    public static final ItemEntry<ComponentItem> WRAP_SMD_INDUCTOR_COSMIC =
            registerWrapItem("wrap_cosmic_smd_inductor", COSMIC_INDUCTOR, 5);

    public static final ItemEntry<Item> WRAP_CPU_CHIP = registerWrapItem("warp_cpu_chip", CENTRAL_PROCESSING_UNIT);
    public static final ItemEntry<Item> WRAP_RAM_CHIP = registerWrapItem("warp_ram_chip", RANDOM_ACCESS_MEMORY);
    public static final ItemEntry<Item> WRAP_ILC_CHIP = registerWrapItem("wrap_ilc_chip", INTEGRATED_LOGIC_CIRCUIT);
    public static final ItemEntry<Item> WARP_NANO_CPU_CHIP = registerWrapItem("warp_nano_cpu_chip", NANO_CENTRAL_PROCESSING_UNIT);
    public static final ItemEntry<Item> WARP_QBIT_CPU_CHIP = registerWrapItem("warp_qbit_cpu_chip", QUBIT_CENTRAL_PROCESSING_UNIT);
    public static final ItemEntry<Item> WARP_SIMPLE_SOC = registerWrapItem("warp_simple_soc", SIMPLE_SYSTEM_ON_CHIP);
    public static final ItemEntry<Item> WARP_SOC = registerWrapItem("warp_soc", SYSTEM_ON_CHIP);
    public static final ItemEntry<Item> WARP_ADVANCED_SOC = registerWrapItem("warp_advanced_soc", ADVANCED_SYSTEM_ON_CHIP);
    public static final ItemEntry<Item> WARP_HIGHLY_ADVANCED_SOC = registerWrapItem("warp_highly_advanced_soc", HIGHLY_ADVANCED_SOC);
    public static final ItemEntry<Item> WARP_NAND_MEMORY_CHIP = registerWrapItem("warp_nand_memory_chip", NAND_MEMORY_CHIP);
    public static final ItemEntry<Item> WARP_NOR_MEMORY_CHIP = registerWrapItem("warp_nor_memory_chip", NOR_MEMORY_CHIP);

    public static void init() {
        /**/
    }

    private static ItemEntry<Item> registerWrapItem(String id, ItemEntry<?> wrappedItem) {
        var itemEntry = registrate()
                .item(id, Item::new)
                .model(EPModels.wrapItemModel(wrappedItem.getId().withPrefix("item/")))
                .register();
        WRAP_ITEM_MAP.put(wrappedItem, itemEntry);
        return itemEntry;
    }

    private static ItemEntry<ComponentItem> registerWrapItem(
            String id, ItemEntry<?> wrappedItem, int tier) {
        var itemEntry = registrate()
                .item(id, ComponentItem::create)
                .model(EPModels.wrapItemModel(wrappedItem.getId().withPrefix("item/")))
                .onRegister(EPItems.attachRenderer(new SuperscriptItemBehavior.Number(tier)))
                .register();
        WRAP_ITEM_MAP.put(wrappedItem, itemEntry);
        return itemEntry;
    }

    private static ItemEntry<ComponentItem> registerWrapCircuit(
            String id, ResourceLocation wrappedTexture, int voltage) {
        var itemEntry = registrate()
                .item(id, ComponentItem::create)
                .model(EPModels.wrapItemModel(wrappedTexture))
                .onRegister(EPItems.attachRenderer(new SuperscriptItemBehavior.Voltage(voltage)))
                .register();
        WRAP_CIRCUIT_MAP.put(MOCustomTags.CIRCUITS[voltage], itemEntry);
        return itemEntry;
    }
}
