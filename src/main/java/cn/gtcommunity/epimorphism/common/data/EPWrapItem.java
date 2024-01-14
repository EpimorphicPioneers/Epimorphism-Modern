package cn.gtcommunity.epimorphism.common.data;

import cn.gtcommunity.epimorphism.Epimorphism;
import com.gregtechceu.gtceu.GTCEu;
import com.tterrag.registrate.util.entry.ItemEntry;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;

import static cn.gtcommunity.epimorphism.api.registry.EPRegistries.EP_REGISTRATE;
import static cn.gtcommunity.epimorphism.common.data.EPCreativeModeTabs.*;
import static cn.gtcommunity.epimorphism.common.data.EPItems.*;
import static com.gregtechceu.gtceu.common.data.GTItems.*;
import static com.gregtechceu.gtceu.data.recipe.CustomTags.*;

public class EPWrapItem {
    public final static Object2ObjectOpenHashMap<ItemLike, ItemLike> WRAP_ITEM_MAP = new Object2ObjectOpenHashMap<>();
    public final static Object2ObjectOpenHashMap<TagKey<Item>, ItemLike> WRAP_CIRCUIT_MAP = new Object2ObjectOpenHashMap<>();

    static {
        EP_REGISTRATE.creativeModeTab(() -> EP_CIRCUIT_REFORM);
    }
    //  Wrap Circuits
    public final static ItemEntry<Item> WRAP_CIRCUIT_ULV = registerWrapCircuit("wrap.circuit.ulv", "Infinite Circuit Board", GTCEu.id("item/nand_chip"), ULV_CIRCUITS);
    public final static ItemEntry<Item> WRAP_CIRCUIT_LV = registerWrapCircuit("wrap.circuit.lv", "Infinite Circuit Board", GTCEu.id("item/microchip_processor"), LV_CIRCUITS);
    public final static ItemEntry<Item> WRAP_CIRCUIT_MV = registerWrapCircuit("wrap.circuit.mv", "Infinite Circuit Board", GTCEu.id("item/micro_processor"), MV_CIRCUITS);
    public final static ItemEntry<Item> WRAP_CIRCUIT_HV = registerWrapCircuit("wrap.circuit.hv", "Infinite Circuit Board", GTCEu.id("item/nano_processor"), HV_CIRCUITS);
    public final static ItemEntry<Item> WRAP_CIRCUIT_EV = registerWrapCircuit("wrap.circuit.ev", "Infinite Circuit Board", GTCEu.id("item/quantum_processor"), EV_CIRCUITS);
    public final static ItemEntry<Item> WRAP_CIRCUIT_IV = registerWrapCircuit("wrap.circuit.iv", "Infinite Circuit Board", GTCEu.id("item/crystal_processor"), IV_CIRCUITS);
    public final static ItemEntry<Item> WRAP_CIRCUIT_LuV = registerWrapCircuit("wrap.circuit.luv", "Infinite Circuit Board", GTCEu.id("item/wetware_processor"), LuV_CIRCUITS);
    public final static ItemEntry<Item> WRAP_CIRCUIT_ZPM = registerWrapCircuit("wrap.circuit.zpm", "Infinite Circuit Board", Epimorphism.id("item/circuit.gooware_processor"), ZPM_CIRCUITS);
    public final static ItemEntry<Item> WRAP_CIRCUIT_UV = registerWrapCircuit("wrap.circuit.uv", "Infinite Circuit Board", Epimorphism.id("item/circuit.optical_processor"), UV_CIRCUITS);
    public final static ItemEntry<Item> WRAP_CIRCUIT_UHV = registerWrapCircuit("wrap.circuit.uhv", "Infinite Circuit Board", Epimorphism.id("item/circuit.spintronic_processor"), UHV_CIRCUITS);
    public final static ItemEntry<Item> WRAP_CIRCUIT_UEV = registerWrapCircuit("wrap.circuit.uev", "Infinite Circuit Board", Epimorphism.id("item/circuit.cosmic_processor"), UEV_CIRCUITS);
    public final static ItemEntry<Item> WRAP_CIRCUIT_UIV = registerWrapCircuit("wrap.circuit.uiv", "Infinite Circuit Board", Epimorphism.id("item/circuit.supracausal_processor"), UIV_CIRCUITS);
    public final static ItemEntry<Item> WRAP_CIRCUIT_UXV = registerWrapCircuit("wrap.circuit.uxv", "Infinite Circuit Board", Epimorphism.id("item/circuit.supracausal_assembly"), UXV_CIRCUITS);
    public final static ItemEntry<Item> WRAP_CIRCUIT_OpV = registerWrapCircuit("wrap.circuit.opv", "Infinite Circuit Board", Epimorphism.id("item/circuit.supracausal_computer"), OpV_CIRCUITS);
    public final static ItemEntry<Item> CIRCUIT_MAX = registerWrapCircuit("wrap.circuit.max", "Infinite Circuit Board", Epimorphism.id("item/circuit.supracausal_mainframe"), MAX_CIRCUITS);

    public static ItemEntry<Item> WRAP_BOARD_COATED = registerWrapItem("wrap.board.resin", "Infinite Circuit Board", GTCEu.id("item/resin_circuit_board"), COATED_BOARD);
    public static ItemEntry<Item> WRAP_BOARD_PHENOLIC = registerWrapItem("wrap.board.phenolic", "Infinite Circuit Board", GTCEu.id("item/phenolic_circuit_board"), PHENOLIC_BOARD);
    public static ItemEntry<Item> WRAP_BOARD_PLASTIC = registerWrapItem("wrap.board.plastic", "Infinite Circuit Board", GTCEu.id("item/plastic_circuit_board"), PLASTIC_BOARD);
    public static ItemEntry<Item> WRAP_BOARD_EPOXY = registerWrapItem("wrap.board.epoxy", "Infinite Circuit Board", GTCEu.id("item/epoxy_circuit_board"), EPOXY_BOARD);
    public static ItemEntry<Item> WRAP_BOARD_FIBER = registerWrapItem("wrap.board.fiber_reinforced", "Infinite Circuit Board", GTCEu.id("item/fiber_reinforced_circuit_board"), FIBER_BOARD);
    public static ItemEntry<Item> WRAP_BOARD_MULTILAYER_FIBER = registerWrapItem("wrap.board.multilayer_fiber_reinforced", "Infinite Circuit Board", GTCEu.id("item/multilayer_fiber_reinforced_circuit_board"), MULTILAYER_FIBER_BOARD);
    public static ItemEntry<Item> WRAP_BOARD_WETWARE = registerWrapItem("wrap.board.wetware", "Infinite Circuit Board", GTCEu.id("item/wetware_circuit_board"), WETWARE_BOARD);
    public static ItemEntry<Item> WRAP_BOARD_GOOWARE = registerWrapItem("wrap.board.gooware", "Infinite Circuit Board", Epimorphism.id("item/board.gooware"), GOOWARE_BOARD);
    public static ItemEntry<Item> WRAP_BOARD_OPTICAL = registerWrapItem("wrap.board.optical", "Infinite Circuit Board", Epimorphism.id("item/board.optical"), OPTICAL_BOARD);
    public static ItemEntry<Item> WRAP_BOARD_SPINTRONIC = registerWrapItem("wrap.board.spintronic", "Infinite Circuit Board", Epimorphism.id("item/board.spintronic"), SPINTRONIC_BOARD);

    public static ItemEntry<Item> WRAP_CIRCUIT_BOARD_BASIC = registerWrapItem("wrap.circuit_board.resin", "Infinite Circuit Board", GTCEu.id("item/resin_printed_circuit_board"), BASIC_CIRCUIT_BOARD);
    public static ItemEntry<Item> WRAP_CIRCUIT_BOARD_GOOD = registerWrapItem("wrap.circuit_board.phenolic", "Infinite Circuit Board", GTCEu.id("item/phenolic_printed_circuit_board"), GOOD_CIRCUIT_BOARD);
    public static ItemEntry<Item> WRAP_CIRCUIT_BOARD_PLASTIC = registerWrapItem("wrap.circuit_board.plastic", "Infinite Circuit Board", GTCEu.id("item/plastic_printed_circuit_board"), PLASTIC_CIRCUIT_BOARD);
    public static ItemEntry<Item> WRAP_CIRCUIT_BOARD_ADVANCED = registerWrapItem("wrap.circuit_board.epoxy", "Infinite Circuit Board", GTCEu.id("item/epoxy_printed_circuit_board"), ADVANCED_CIRCUIT_BOARD);
    public static ItemEntry<Item> WRAP_CIRCUIT_BOARD_EXTREME = registerWrapItem("wrap.circuit_board.fiber_reinforced", "Infinite Circuit Board", GTCEu.id("item/fiber_reinforced_printed_circuit_board"), EXTREME_CIRCUIT_BOARD);
    public static ItemEntry<Item> WRAP_CIRCUIT_BOARD_ELITE = registerWrapItem("wrap.circuit_board.multilayer_fiber_reinforced", "Infinite Circuit Board", GTCEu.id("item/multilayer_fiber_reinforced_printed_circuit_board"), ELITE_CIRCUIT_BOARD);
    public static ItemEntry<Item> WRAP_CIRCUIT_BOARD_WETWARE = registerWrapItem("wrap.circuit_board.wetware", "Infinite Circuit Board", GTCEu.id("item/wetware_printed_circuit_board"), WETWARE_CIRCUIT_BOARD);
    public static ItemEntry<Item> WRAP_CIRCUIT_BOARD_GOOWARE = registerWrapItem("wrap.circuit_board.gooware", "Infinite Circuit Board", Epimorphism.id("item/circuit_board.gooware"), GOOWARE_CIRCUIT_BOARD);
    public static ItemEntry<Item> WRAP_CIRCUIT_BOARD_OPTICAL = registerWrapItem("wrap.circuit_board.optical", "Infinite Circuit Board", Epimorphism.id("item/circuit_board.optical"), OPTICAL_CIRCUIT_BOARD);
    public static ItemEntry<Item> WRAP_CIRCUIT_BOARD_SPINTRONIC = registerWrapItem("wrap.circuit_board.spintronic", "Infinite Circuit Board", Epimorphism.id("item/circuit_board.spintronic"), SPINTRONIC_CIRCUIT_BOARD);

    public static ItemEntry<Item> WRAP_SMD_TRANSISTOR = registerWrapItem("wrap.component.smd_transistor", "Infinite Circuit Board", GTCEu.id("item/smd_transistor"), SMD_TRANSISTOR);
    public static ItemEntry<Item> WRAP_SMD_RESISTOR = registerWrapItem("wrap.component.smd_resistor", "Infinite Circuit Board", GTCEu.id("item/smd_resistor"), SMD_RESISTOR);
    public static ItemEntry<Item> WRAP_SMD_CAPACITOR = registerWrapItem("wrap.component.smd_capacitor", "Infinite Circuit Board", GTCEu.id("item/smd_capacitor"), SMD_CAPACITOR);
    public static ItemEntry<Item> WRAP_SMD_DIODE = registerWrapItem("wrap.component.smd_diode", "Infinite Circuit Board", GTCEu.id("item/smd_diode"), SMD_DIODE);
    public static ItemEntry<Item> WRAP_SMD_INDUCTOR = registerWrapItem("wrap.component.smd_inductor", "Infinite Circuit Board", GTCEu.id("item/smd_inductor"), SMD_INDUCTOR);
    public static ItemEntry<Item> WRAP_SMD_TRANSISTOR_ADVANCED = registerWrapItem("wrap.component.advanced_smd_transistor", "Infinite Circuit Board", GTCEu.id("item/advanced_smd_transistor"), ADVANCED_SMD_TRANSISTOR);
    public static ItemEntry<Item> WRAP_SMD_RESISTOR_ADVANCED = registerWrapItem("wrap.component.advanced_smd_resistor", "Infinite Circuit Board", GTCEu.id("item/advanced_smd_resistor"), ADVANCED_SMD_RESISTOR);
    public static ItemEntry<Item> WRAP_SMD_CAPACITOR_ADVANCED = registerWrapItem("wrap.component.advanced_smd_capacitor", "Infinite Circuit Board", GTCEu.id("item/advanced_smd_capacitor"), ADVANCED_SMD_CAPACITOR);
    public static ItemEntry<Item> WRAP_SMD_DIODE_ADVANCED = registerWrapItem("wrap.component.advanced_smd_diode", "Infinite Circuit Board", GTCEu.id("item/advanced_smd_diode"), ADVANCED_SMD_DIODE);
    public static ItemEntry<Item> WRAP_SMD_INDUCTOR_ADVANCED = registerWrapItem("wrap.component.advanced_smd_inductor", "Infinite Circuit Board", GTCEu.id("item/advanced_smd_inductor"), ADVANCED_SMD_INDUCTOR);
    public static ItemEntry<Item> WRAP_SMD_TRANSISTOR_OPTICAL = registerWrapItem("wrap.component.optical_smd.transistor", "Infinite Circuit Board", Epimorphism.id("item/component.optical_smd.transistor"), OPTICAL_TRANSISTOR);
    public static ItemEntry<Item> WRAP_SMD_RESISTOR_OPTICAL = registerWrapItem("wrap.component.optical_smd.resistor", "Infinite Circuit Board", Epimorphism.id("item/component.optical_smd.resistor"), OPTICAL_RESISTOR);
    public static ItemEntry<Item> WRAP_SMD_CAPACITOR_OPTICAL = registerWrapItem("wrap.component.optical_smd.capacitor", "Infinite Circuit Board", Epimorphism.id("item/component.optical_smd.capacitor"), OPTICAL_CAPACITOR);
    public static ItemEntry<Item> WRAP_SMD_DIODE_OPTICAL = registerWrapItem("wrap.component.optical_smd.diode", "Infinite Circuit Board", Epimorphism.id("item/component.optical_smd.diode"), OPTICAL_DIODE);
    public static ItemEntry<Item> WRAP_SMD_INDUCTOR_OPTICAL = registerWrapItem("wrap.component.optical_smd.inductor", "Infinite Circuit Board", Epimorphism.id("item/component.optical_smd.inductor"), OPTICAL_INDUCTOR);
    public static ItemEntry<Item> WRAP_SMD_TRANSISTOR_SPINTRONIC = registerWrapItem("wrap.component.spintronic_smd.transistor", "Infinite Circuit Board", Epimorphism.id("item/component.spintronic_smd.transistor"), SPINTRONIC_TRANSISTOR);
    public static ItemEntry<Item> WRAP_SMD_RESISTOR_SPINTRONIC = registerWrapItem("wrap.component.spintronic_smd.resistor", "Infinite Circuit Board", Epimorphism.id("item/component.spintronic_smd.resistor"), SPINTRONIC_RESISTOR);
    public static ItemEntry<Item> WRAP_SMD_CAPACITOR_SPINTRONIC = registerWrapItem("wrap.component.spintronic_smd.capacitor", "Infinite Circuit Board", Epimorphism.id("item/component.spintronic_smd.capacitor"), SPINTRONIC_CAPACITOR);
    public static ItemEntry<Item> WRAP_SMD_DIODE_SPINTRONIC = registerWrapItem("wrap.component.spintronic_smd.diode", "Infinite Circuit Board", Epimorphism.id("item/component.spintronic_smd.diode"), SPINTRONIC_DIODE);
    public static ItemEntry<Item> WRAP_SMD_INDUCTOR_SPINTRONIC = registerWrapItem("wrap.component.spintronic_smd.inductor", "Infinite Circuit Board", Epimorphism.id("item/component.spintronic_smd.inductor"), SPINTRONIC_INDUCTOR);
    public static ItemEntry<Item> WRAP_SMD_TRANSISTOR_COSMIC = registerWrapItem("wrap.component.cosmic_smd.transistor", "Infinite Circuit Board", Epimorphism.id("item/component.cosmic_smd.transistor"), COSMIC_TRANSISTOR);
    public static ItemEntry<Item> WRAP_SMD_RESISTOR_COSMIC = registerWrapItem("wrap.component.cosmic_smd.resistor", "Infinite Circuit Board", Epimorphism.id("item/component.cosmic_smd.resistor"), COSMIC_RESISTOR);
    public static ItemEntry<Item> WRAP_SMD_CAPACITOR_COSMIC = registerWrapItem("wrap.component.cosmic_smd.capacitor", "Infinite Circuit Board", Epimorphism.id("item/component.cosmic_smd.capacitor"), COSMIC_CAPACITOR);
    public static ItemEntry<Item> WRAP_SMD_DIODE_COSMIC = registerWrapItem("wrap.component.cosmic_smd.diode", "Infinite Circuit Board", Epimorphism.id("item/component.cosmic_smd.diode"), COSMIC_DIODE);
    public static ItemEntry<Item> WRAP_SMD_INDUCTOR_COSMIC = registerWrapItem("wrap.component.cosmic_smd.inductor", "Infinite Circuit Board", Epimorphism.id("item/component.cosmic_smd.inductor"), COSMIC_INDUCTOR);

    public static void init() {/**/}

    private static ItemEntry<Item> registerWrapItem(String id, String lang, ResourceLocation wrappedTexture, ItemEntry<?> wrappedItem) {
        var itemEntry = EP_REGISTRATE.item(id, Item::new)
                .lang(lang)
                .model(EPModels.wrapCircuitModel(wrappedTexture))
                .register();
        WRAP_ITEM_MAP.put(wrappedItem, itemEntry);
        return itemEntry;
    }

    private static ItemEntry<Item> registerWrapCircuit(String id, String lang, ResourceLocation wrappedTexture, TagKey<Item> wrappedCircuit) {
        var itemEntry = EP_REGISTRATE.item(id, Item::new)
                .lang(lang)
                .model(EPModels.wrapCircuitModel(wrappedTexture))
                .register();
        WRAP_CIRCUIT_MAP.put(wrappedCircuit, itemEntry);
        return itemEntry;
    }
}
