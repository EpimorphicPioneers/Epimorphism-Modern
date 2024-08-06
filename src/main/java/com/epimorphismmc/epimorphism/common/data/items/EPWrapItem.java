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
import static com.epimorphismmc.epimorphism.common.data.EPItems.COSMIC_CAPACITOR;
import static com.epimorphismmc.epimorphism.common.data.EPItems.COSMIC_DIODE;
import static com.epimorphismmc.epimorphism.common.data.EPItems.COSMIC_INDUCTOR;
import static com.epimorphismmc.epimorphism.common.data.EPItems.COSMIC_RESISTOR;
import static com.epimorphismmc.epimorphism.common.data.EPItems.COSMIC_TRANSISTOR;
import static com.epimorphismmc.epimorphism.common.data.EPItems.GOOWARE_BOARD;
import static com.epimorphismmc.epimorphism.common.data.EPItems.GOOWARE_CIRCUIT_BOARD;
import static com.epimorphismmc.epimorphism.common.data.EPItems.OPTICAL_BOARD;
import static com.epimorphismmc.epimorphism.common.data.EPItems.OPTICAL_CAPACITOR;
import static com.epimorphismmc.epimorphism.common.data.EPItems.OPTICAL_CIRCUIT_BOARD;
import static com.epimorphismmc.epimorphism.common.data.EPItems.OPTICAL_DIODE;
import static com.epimorphismmc.epimorphism.common.data.EPItems.OPTICAL_INDUCTOR;
import static com.epimorphismmc.epimorphism.common.data.EPItems.OPTICAL_RESISTOR;
import static com.epimorphismmc.epimorphism.common.data.EPItems.OPTICAL_TRANSISTOR;
import static com.epimorphismmc.epimorphism.common.data.EPItems.SPINTRONIC_BOARD;
import static com.epimorphismmc.epimorphism.common.data.EPItems.SPINTRONIC_CAPACITOR;
import static com.epimorphismmc.epimorphism.common.data.EPItems.SPINTRONIC_CIRCUIT_BOARD;
import static com.epimorphismmc.epimorphism.common.data.EPItems.SPINTRONIC_DIODE;
import static com.epimorphismmc.epimorphism.common.data.EPItems.SPINTRONIC_INDUCTOR;
import static com.epimorphismmc.epimorphism.common.data.EPItems.SPINTRONIC_RESISTOR;
import static com.epimorphismmc.epimorphism.common.data.EPItems.SPINTRONIC_TRANSISTOR;
import static com.gregtechceu.gtceu.api.GTValues.EV;
import static com.gregtechceu.gtceu.api.GTValues.HV;
import static com.gregtechceu.gtceu.api.GTValues.IV;
import static com.gregtechceu.gtceu.api.GTValues.LV;
import static com.gregtechceu.gtceu.api.GTValues.LuV;
import static com.gregtechceu.gtceu.api.GTValues.MAX;
import static com.gregtechceu.gtceu.api.GTValues.MV;
import static com.gregtechceu.gtceu.api.GTValues.OpV;
import static com.gregtechceu.gtceu.api.GTValues.UEV;
import static com.gregtechceu.gtceu.api.GTValues.UHV;
import static com.gregtechceu.gtceu.api.GTValues.UIV;
import static com.gregtechceu.gtceu.api.GTValues.ULV;
import static com.gregtechceu.gtceu.api.GTValues.UV;
import static com.gregtechceu.gtceu.api.GTValues.UXV;
import static com.gregtechceu.gtceu.api.GTValues.ZPM;
import static com.gregtechceu.gtceu.common.data.GTItems.ADVANCED_CIRCUIT_BOARD;
import static com.gregtechceu.gtceu.common.data.GTItems.ADVANCED_SMD_CAPACITOR;
import static com.gregtechceu.gtceu.common.data.GTItems.ADVANCED_SMD_DIODE;
import static com.gregtechceu.gtceu.common.data.GTItems.ADVANCED_SMD_INDUCTOR;
import static com.gregtechceu.gtceu.common.data.GTItems.ADVANCED_SMD_RESISTOR;
import static com.gregtechceu.gtceu.common.data.GTItems.ADVANCED_SMD_TRANSISTOR;
import static com.gregtechceu.gtceu.common.data.GTItems.BASIC_CIRCUIT_BOARD;
import static com.gregtechceu.gtceu.common.data.GTItems.COATED_BOARD;
import static com.gregtechceu.gtceu.common.data.GTItems.ELITE_CIRCUIT_BOARD;
import static com.gregtechceu.gtceu.common.data.GTItems.EPOXY_BOARD;
import static com.gregtechceu.gtceu.common.data.GTItems.EXTREME_CIRCUIT_BOARD;
import static com.gregtechceu.gtceu.common.data.GTItems.FIBER_BOARD;
import static com.gregtechceu.gtceu.common.data.GTItems.GOOD_CIRCUIT_BOARD;
import static com.gregtechceu.gtceu.common.data.GTItems.MULTILAYER_FIBER_BOARD;
import static com.gregtechceu.gtceu.common.data.GTItems.PHENOLIC_BOARD;
import static com.gregtechceu.gtceu.common.data.GTItems.PLASTIC_BOARD;
import static com.gregtechceu.gtceu.common.data.GTItems.PLASTIC_CIRCUIT_BOARD;
import static com.gregtechceu.gtceu.common.data.GTItems.SMD_CAPACITOR;
import static com.gregtechceu.gtceu.common.data.GTItems.SMD_DIODE;
import static com.gregtechceu.gtceu.common.data.GTItems.SMD_INDUCTOR;
import static com.gregtechceu.gtceu.common.data.GTItems.SMD_RESISTOR;
import static com.gregtechceu.gtceu.common.data.GTItems.SMD_TRANSISTOR;
import static com.gregtechceu.gtceu.common.data.GTItems.WETWARE_BOARD;
import static com.gregtechceu.gtceu.common.data.GTItems.WETWARE_CIRCUIT_BOARD;

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
            registerWrapCircuit("wrap.circuit.ulv", GTCEu.id("item/nand_chip"), ULV);
    public static final ItemEntry<ComponentItem> WRAP_CIRCUIT_LV =
            registerWrapCircuit("wrap.circuit.lv", GTCEu.id("item/microchip_processor"), LV);
    public static final ItemEntry<ComponentItem> WRAP_CIRCUIT_MV =
            registerWrapCircuit("wrap.circuit.mv", GTCEu.id("item/micro_processor"), MV);
    public static final ItemEntry<ComponentItem> WRAP_CIRCUIT_HV =
            registerWrapCircuit("wrap.circuit.hv", GTCEu.id("item/nano_processor"), HV);
    public static final ItemEntry<ComponentItem> WRAP_CIRCUIT_EV =
            registerWrapCircuit("wrap.circuit.ev", GTCEu.id("item/quantum_processor"), EV);
    public static final ItemEntry<ComponentItem> WRAP_CIRCUIT_IV =
            registerWrapCircuit("wrap.circuit.iv", GTCEu.id("item/crystal_processor"), IV);
    public static final ItemEntry<ComponentItem> WRAP_CIRCUIT_LuV =
            registerWrapCircuit("wrap.circuit.luv", GTCEu.id("item/wetware_processor"), LuV);
    public static final ItemEntry<ComponentItem> WRAP_CIRCUIT_ZPM = registerWrapCircuit(
            "wrap.circuit.zpm", Epimorphism.id("item/circuit.gooware_processor"), ZPM);
    public static final ItemEntry<ComponentItem> WRAP_CIRCUIT_UV =
            registerWrapCircuit("wrap.circuit.uv", Epimorphism.id("item/circuit.optical_processor"), UV);
    public static final ItemEntry<ComponentItem> WRAP_CIRCUIT_UHV = registerWrapCircuit(
            "wrap.circuit.uhv", Epimorphism.id("item/circuit.spintronic_processor"), UHV);
    public static final ItemEntry<ComponentItem> WRAP_CIRCUIT_UEV =
            registerWrapCircuit("wrap.circuit.uev", Epimorphism.id("item/circuit.cosmic_processor"), UEV);
    public static final ItemEntry<ComponentItem> WRAP_CIRCUIT_UIV = registerWrapCircuit(
            "wrap.circuit.uiv", Epimorphism.id("item/circuit.supracausal_processor"), UIV);
    public static final ItemEntry<ComponentItem> WRAP_CIRCUIT_UXV = registerWrapCircuit(
            "wrap.circuit.uxv", Epimorphism.id("item/circuit.supracausal_assembly"), UXV);
    public static final ItemEntry<ComponentItem> WRAP_CIRCUIT_OpV = registerWrapCircuit(
            "wrap.circuit.opv", Epimorphism.id("item/circuit.supracausal_computer"), OpV);
    public static final ItemEntry<ComponentItem> CIRCUIT_MAX = registerWrapCircuit(
            "wrap.circuit.max", Epimorphism.id("item/circuit.supracausal_mainframe"), MAX);

    public static ItemEntry<ComponentItem> WRAP_BOARD_COATED =
            registerWrapItem("wrap.board.resin", COATED_BOARD, 1);
    public static ItemEntry<ComponentItem> WRAP_BOARD_PHENOLIC =
            registerWrapItem("wrap.board.phenolic", PHENOLIC_BOARD, 2);
    public static ItemEntry<ComponentItem> WRAP_BOARD_PLASTIC =
            registerWrapItem("wrap.board.plastic", PLASTIC_BOARD, 3);
    public static ItemEntry<ComponentItem> WRAP_BOARD_EPOXY =
            registerWrapItem("wrap.board.epoxy", EPOXY_BOARD, 4);
    public static ItemEntry<ComponentItem> WRAP_BOARD_FIBER =
            registerWrapItem("wrap.board.fiber_reinforced", FIBER_BOARD, 5);
    public static ItemEntry<ComponentItem> WRAP_BOARD_MULTILAYER_FIBER =
            registerWrapItem("wrap.board.multilayer_fiber_reinforced", MULTILAYER_FIBER_BOARD, 6);
    public static ItemEntry<ComponentItem> WRAP_BOARD_WETWARE =
            registerWrapItem("wrap.board.wetware", WETWARE_BOARD, 7);
    public static ItemEntry<ComponentItem> WRAP_BOARD_GOOWARE =
            registerWrapItem("wrap.board.gooware", GOOWARE_BOARD, 8);
    public static ItemEntry<ComponentItem> WRAP_BOARD_OPTICAL =
            registerWrapItem("wrap.board.optical", OPTICAL_BOARD, 9);
    public static ItemEntry<ComponentItem> WRAP_BOARD_SPINTRONIC =
            registerWrapItem("wrap.board.spintronic", SPINTRONIC_BOARD, 10);

    public static ItemEntry<ComponentItem> WRAP_CIRCUIT_BOARD_BASIC =
            registerWrapItem("wrap.circuit_board.resin", BASIC_CIRCUIT_BOARD, 1);
    public static ItemEntry<ComponentItem> WRAP_CIRCUIT_BOARD_GOOD =
            registerWrapItem("wrap.circuit_board.phenolic", GOOD_CIRCUIT_BOARD, 2);
    public static ItemEntry<ComponentItem> WRAP_CIRCUIT_BOARD_PLASTIC =
            registerWrapItem("wrap.circuit_board.plastic", PLASTIC_CIRCUIT_BOARD, 3);
    public static ItemEntry<ComponentItem> WRAP_CIRCUIT_BOARD_ADVANCED =
            registerWrapItem("wrap.circuit_board.epoxy", ADVANCED_CIRCUIT_BOARD, 4);
    public static ItemEntry<ComponentItem> WRAP_CIRCUIT_BOARD_EXTREME =
            registerWrapItem("wrap.circuit_board.fiber_reinforced", EXTREME_CIRCUIT_BOARD, 5);
    public static ItemEntry<ComponentItem> WRAP_CIRCUIT_BOARD_ELITE =
            registerWrapItem("wrap.circuit_board.multilayer_fiber_reinforced", ELITE_CIRCUIT_BOARD, 6);
    public static ItemEntry<ComponentItem> WRAP_CIRCUIT_BOARD_WETWARE =
            registerWrapItem("wrap.circuit_board.wetware", WETWARE_CIRCUIT_BOARD, 7);
    public static ItemEntry<ComponentItem> WRAP_CIRCUIT_BOARD_GOOWARE =
            registerWrapItem("wrap.circuit_board.gooware", GOOWARE_CIRCUIT_BOARD, 8);
    public static ItemEntry<ComponentItem> WRAP_CIRCUIT_BOARD_OPTICAL =
            registerWrapItem("wrap.circuit_board.optical", OPTICAL_CIRCUIT_BOARD, 9);
    public static ItemEntry<ComponentItem> WRAP_CIRCUIT_BOARD_SPINTRONIC =
            registerWrapItem("wrap.circuit_board.spintronic", SPINTRONIC_CIRCUIT_BOARD, 10);

    public static ItemEntry<ComponentItem> WRAP_SMD_TRANSISTOR =
            registerWrapItem("wrap.component.smd_transistor", SMD_TRANSISTOR, 1);
    public static ItemEntry<ComponentItem> WRAP_SMD_RESISTOR =
            registerWrapItem("wrap.component.smd_resistor", SMD_RESISTOR, 1);
    public static ItemEntry<ComponentItem> WRAP_SMD_CAPACITOR =
            registerWrapItem("wrap.component.smd_capacitor", SMD_CAPACITOR, 1);
    public static ItemEntry<ComponentItem> WRAP_SMD_DIODE =
            registerWrapItem("wrap.component.smd_diode", SMD_DIODE, 1);
    public static ItemEntry<ComponentItem> WRAP_SMD_INDUCTOR =
            registerWrapItem("wrap.component.smd_inductor", SMD_INDUCTOR, 1);

    public static ItemEntry<ComponentItem> WRAP_SMD_TRANSISTOR_ADVANCED =
            registerWrapItem("wrap.component.advanced_smd_transistor", ADVANCED_SMD_TRANSISTOR, 2);
    public static ItemEntry<ComponentItem> WRAP_SMD_RESISTOR_ADVANCED =
            registerWrapItem("wrap.component.advanced_smd_resistor", ADVANCED_SMD_RESISTOR, 2);
    public static ItemEntry<ComponentItem> WRAP_SMD_CAPACITOR_ADVANCED =
            registerWrapItem("wrap.component.advanced_smd_capacitor", ADVANCED_SMD_CAPACITOR, 2);
    public static ItemEntry<ComponentItem> WRAP_SMD_DIODE_ADVANCED =
            registerWrapItem("wrap.component.advanced_smd_diode", ADVANCED_SMD_DIODE, 2);
    public static ItemEntry<ComponentItem> WRAP_SMD_INDUCTOR_ADVANCED =
            registerWrapItem("wrap.component.advanced_smd_inductor", ADVANCED_SMD_INDUCTOR, 2);

    public static ItemEntry<ComponentItem> WRAP_SMD_TRANSISTOR_OPTICAL =
            registerWrapItem("wrap.component.optical_smd.transistor", OPTICAL_TRANSISTOR, 3);
    public static ItemEntry<ComponentItem> WRAP_SMD_RESISTOR_OPTICAL =
            registerWrapItem("wrap.component.optical_smd.resistor", OPTICAL_RESISTOR, 3);
    public static ItemEntry<ComponentItem> WRAP_SMD_CAPACITOR_OPTICAL =
            registerWrapItem("wrap.component.optical_smd.capacitor", OPTICAL_CAPACITOR, 3);
    public static ItemEntry<ComponentItem> WRAP_SMD_DIODE_OPTICAL =
            registerWrapItem("wrap.component.optical_smd.diode", OPTICAL_DIODE, 3);
    public static ItemEntry<ComponentItem> WRAP_SMD_INDUCTOR_OPTICAL =
            registerWrapItem("wrap.component.optical_smd.inductor", OPTICAL_INDUCTOR, 3);

    public static ItemEntry<ComponentItem> WRAP_SMD_TRANSISTOR_SPINTRONIC =
            registerWrapItem("wrap.component.spintronic_smd.transistor", SPINTRONIC_TRANSISTOR, 4);
    public static ItemEntry<ComponentItem> WRAP_SMD_RESISTOR_SPINTRONIC =
            registerWrapItem("wrap.component.spintronic_smd.resistor", SPINTRONIC_RESISTOR, 4);
    public static ItemEntry<ComponentItem> WRAP_SMD_CAPACITOR_SPINTRONIC =
            registerWrapItem("wrap.component.spintronic_smd.capacitor", SPINTRONIC_CAPACITOR, 4);
    public static ItemEntry<ComponentItem> WRAP_SMD_DIODE_SPINTRONIC =
            registerWrapItem("wrap.component.spintronic_smd.diode", SPINTRONIC_DIODE, 4);
    public static ItemEntry<ComponentItem> WRAP_SMD_INDUCTOR_SPINTRONIC =
            registerWrapItem("wrap.component.spintronic_smd.inductor", SPINTRONIC_INDUCTOR, 4);

    public static ItemEntry<ComponentItem> WRAP_SMD_TRANSISTOR_COSMIC =
            registerWrapItem("wrap.component.cosmic_smd.transistor", COSMIC_TRANSISTOR, 5);
    public static ItemEntry<ComponentItem> WRAP_SMD_RESISTOR_COSMIC =
            registerWrapItem("wrap.component.cosmic_smd.resistor", COSMIC_RESISTOR, 5);
    public static ItemEntry<ComponentItem> WRAP_SMD_CAPACITOR_COSMIC =
            registerWrapItem("wrap.component.cosmic_smd.capacitor", COSMIC_CAPACITOR, 5);
    public static ItemEntry<ComponentItem> WRAP_SMD_DIODE_COSMIC =
            registerWrapItem("wrap.component.cosmic_smd.diode", COSMIC_DIODE, 5);
    public static ItemEntry<ComponentItem> WRAP_SMD_INDUCTOR_COSMIC =
            registerWrapItem("wrap.component.cosmic_smd.inductor", COSMIC_INDUCTOR, 5);

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
