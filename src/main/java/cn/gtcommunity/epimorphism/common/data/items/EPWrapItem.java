package cn.gtcommunity.epimorphism.common.data.items;

import cn.gtcommunity.epimorphism.Epimorphism;
import cn.gtcommunity.epimorphism.common.data.EPItems;
import cn.gtcommunity.epimorphism.common.data.EPModels;
import cn.gtcommunity.epimorphism.common.item.behaviors.renderer.TierRenderItemBehavior;
import cn.gtcommunity.epimorphism.config.EPConfigHolder;
import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.item.ComponentItem;
import com.tterrag.registrate.util.entry.ItemEntry;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;

import static cn.gtcommunity.epimorphism.Epimorphism.registrate;
import static cn.gtcommunity.epimorphism.common.data.EPCreativeModeTabs.*;
import static cn.gtcommunity.epimorphism.common.data.EPItems.*;
import static com.gregtechceu.gtceu.common.data.GTItems.*;
import static com.gregtechceu.gtceu.data.recipe.CustomTags.*;

public class EPWrapItem {
    public final static Object2ObjectOpenHashMap<ItemLike, ItemLike> WRAP_ITEM_MAP = new Object2ObjectOpenHashMap<>();
    public final static Object2ObjectOpenHashMap<TagKey<Item>, ItemLike> WRAP_CIRCUIT_MAP = new Object2ObjectOpenHashMap<>();

    static {
        registrate().creativeModeTab(() -> EP_CIRCUIT_REFORM);
    }

    //  Wrap Circuits
    public final static ItemEntry<ComponentItem> WRAP_CIRCUIT_ULV = registerWrapCircuit("wrap.circuit.ulv", GTCEu.id("item/nand_chip"), ULV_CIRCUITS);
    public final static ItemEntry<ComponentItem> WRAP_CIRCUIT_LV = registerWrapCircuit("wrap.circuit.lv", GTCEu.id("item/microchip_processor"), LV_CIRCUITS);
    public final static ItemEntry<ComponentItem> WRAP_CIRCUIT_MV = registerWrapCircuit("wrap.circuit.mv", GTCEu.id("item/micro_processor"), MV_CIRCUITS);
    public final static ItemEntry<ComponentItem> WRAP_CIRCUIT_HV = registerWrapCircuit("wrap.circuit.hv", GTCEu.id("item/nano_processor"), HV_CIRCUITS);
    public final static ItemEntry<ComponentItem> WRAP_CIRCUIT_EV = registerWrapCircuit("wrap.circuit.ev", GTCEu.id("item/quantum_processor"), EV_CIRCUITS);
    public final static ItemEntry<ComponentItem> WRAP_CIRCUIT_IV = registerWrapCircuit("wrap.circuit.iv", GTCEu.id("item/crystal_processor"), IV_CIRCUITS);
    public final static ItemEntry<ComponentItem> WRAP_CIRCUIT_LuV = registerWrapCircuit("wrap.circuit.luv", GTCEu.id("item/wetware_processor"), LuV_CIRCUITS);
    public final static ItemEntry<ComponentItem> WRAP_CIRCUIT_ZPM = registerWrapCircuit("wrap.circuit.zpm", Epimorphism.id("item/circuit.gooware_processor"), ZPM_CIRCUITS);
    public final static ItemEntry<ComponentItem> WRAP_CIRCUIT_UV = registerWrapCircuit("wrap.circuit.uv", Epimorphism.id("item/circuit.optical_processor"), UV_CIRCUITS);
    public final static ItemEntry<ComponentItem> WRAP_CIRCUIT_UHV = registerWrapCircuit("wrap.circuit.uhv", Epimorphism.id("item/circuit.spintronic_processor"), UHV_CIRCUITS);
    public final static ItemEntry<ComponentItem> WRAP_CIRCUIT_UEV = registerWrapCircuit("wrap.circuit.uev", Epimorphism.id("item/circuit.cosmic_processor"), UEV_CIRCUITS);
    public final static ItemEntry<ComponentItem> WRAP_CIRCUIT_UIV = registerWrapCircuit("wrap.circuit.uiv", Epimorphism.id("item/circuit.supracausal_processor"), UIV_CIRCUITS);
    public final static ItemEntry<ComponentItem> WRAP_CIRCUIT_UXV = registerWrapCircuit("wrap.circuit.uxv", Epimorphism.id("item/circuit.supracausal_assembly"), UXV_CIRCUITS);
    public final static ItemEntry<ComponentItem> WRAP_CIRCUIT_OpV = registerWrapCircuit("wrap.circuit.opv", Epimorphism.id("item/circuit.supracausal_computer"), OpV_CIRCUITS);
    public final static ItemEntry<ComponentItem> CIRCUIT_MAX = registerWrapCircuit("wrap.circuit.max", Epimorphism.id("item/circuit.supracausal_mainframe"), MAX_CIRCUITS);

    public static ItemEntry<ComponentItem> WRAP_BOARD_COATED = registerWrapItemWithNumber("wrap.board.resin", GTCEu.id("item/resin_circuit_board"), COATED_BOARD, 1);
    public static ItemEntry<ComponentItem> WRAP_BOARD_PHENOLIC = registerWrapItemWithNumber("wrap.board.phenolic", GTCEu.id("item/phenolic_circuit_board"), PHENOLIC_BOARD, 2);
    public static ItemEntry<ComponentItem> WRAP_BOARD_PLASTIC = registerWrapItemWithNumber("wrap.board.plastic", GTCEu.id("item/plastic_circuit_board"), PLASTIC_BOARD, 3);
    public static ItemEntry<ComponentItem> WRAP_BOARD_EPOXY = registerWrapItemWithNumber("wrap.board.epoxy", GTCEu.id("item/epoxy_circuit_board"), EPOXY_BOARD, 4);
    public static ItemEntry<ComponentItem> WRAP_BOARD_FIBER = registerWrapItemWithNumber("wrap.board.fiber_reinforced", GTCEu.id("item/fiber_reinforced_circuit_board"), FIBER_BOARD, 5);
    public static ItemEntry<ComponentItem> WRAP_BOARD_MULTILAYER_FIBER = registerWrapItemWithNumber("wrap.board.multilayer_fiber_reinforced", GTCEu.id("item/multilayer_fiber_reinforced_circuit_board"), MULTILAYER_FIBER_BOARD, 6);
    public static ItemEntry<ComponentItem> WRAP_BOARD_WETWARE = registerWrapItemWithNumber("wrap.board.wetware", GTCEu.id("item/wetware_circuit_board"), WETWARE_BOARD, 7);
    public static ItemEntry<ComponentItem> WRAP_BOARD_GOOWARE = registerWrapItemWithNumber("wrap.board.gooware", Epimorphism.id("item/board.gooware"), GOOWARE_BOARD, 8);
    public static ItemEntry<ComponentItem> WRAP_BOARD_OPTICAL = registerWrapItemWithNumber("wrap.board.optical", Epimorphism.id("item/board.optical"), OPTICAL_BOARD, 9);
    public static ItemEntry<ComponentItem> WRAP_BOARD_SPINTRONIC = registerWrapItemWithNumber("wrap.board.spintronic", Epimorphism.id("item/board.spintronic"), SPINTRONIC_BOARD, 10);

    public static ItemEntry<ComponentItem> WRAP_CIRCUIT_BOARD_BASIC = registerWrapItemWithNumber("wrap.circuit_board.resin", GTCEu.id("item/resin_printed_circuit_board"), BASIC_CIRCUIT_BOARD, 1);
    public static ItemEntry<ComponentItem> WRAP_CIRCUIT_BOARD_GOOD = registerWrapItemWithNumber("wrap.circuit_board.phenolic", GTCEu.id("item/phenolic_printed_circuit_board"), GOOD_CIRCUIT_BOARD, 2);
    public static ItemEntry<ComponentItem> WRAP_CIRCUIT_BOARD_PLASTIC = registerWrapItemWithNumber("wrap.circuit_board.plastic", GTCEu.id("item/plastic_printed_circuit_board"), PLASTIC_CIRCUIT_BOARD, 3);
    public static ItemEntry<ComponentItem> WRAP_CIRCUIT_BOARD_ADVANCED = registerWrapItemWithNumber("wrap.circuit_board.epoxy", GTCEu.id("item/epoxy_printed_circuit_board"), ADVANCED_CIRCUIT_BOARD, 4);
    public static ItemEntry<ComponentItem> WRAP_CIRCUIT_BOARD_EXTREME = registerWrapItemWithNumber("wrap.circuit_board.fiber_reinforced", GTCEu.id("item/fiber_reinforced_printed_circuit_board"), EXTREME_CIRCUIT_BOARD, 5);
    public static ItemEntry<ComponentItem> WRAP_CIRCUIT_BOARD_ELITE = registerWrapItemWithNumber("wrap.circuit_board.multilayer_fiber_reinforced", GTCEu.id("item/multilayer_fiber_reinforced_printed_circuit_board"), ELITE_CIRCUIT_BOARD, 6);
    public static ItemEntry<ComponentItem> WRAP_CIRCUIT_BOARD_WETWARE = registerWrapItemWithNumber("wrap.circuit_board.wetware", GTCEu.id("item/wetware_printed_circuit_board"), WETWARE_CIRCUIT_BOARD, 7);
    public static ItemEntry<ComponentItem> WRAP_CIRCUIT_BOARD_GOOWARE = registerWrapItemWithNumber("wrap.circuit_board.gooware", Epimorphism.id("item/circuit_board.gooware"), GOOWARE_CIRCUIT_BOARD, 8);
    public static ItemEntry<ComponentItem> WRAP_CIRCUIT_BOARD_OPTICAL = registerWrapItemWithNumber("wrap.circuit_board.optical", Epimorphism.id("item/circuit_board.optical"), OPTICAL_CIRCUIT_BOARD, 9);
    public static ItemEntry<ComponentItem> WRAP_CIRCUIT_BOARD_SPINTRONIC = registerWrapItemWithNumber("wrap.circuit_board.spintronic", Epimorphism.id("item/circuit_board.spintronic"), SPINTRONIC_CIRCUIT_BOARD, 10);

    public static ItemEntry<ComponentItem> WRAP_SMD_TRANSISTOR = registerWrapItemWithNumber("wrap.component.smd_transistor", GTCEu.id("item/smd_transistor"), SMD_TRANSISTOR, 1);
    public static ItemEntry<ComponentItem> WRAP_SMD_RESISTOR = registerWrapItemWithNumber("wrap.component.smd_resistor", GTCEu.id("item/smd_resistor"), SMD_RESISTOR, 1);
    public static ItemEntry<ComponentItem> WRAP_SMD_CAPACITOR = registerWrapItemWithNumber("wrap.component.smd_capacitor", GTCEu.id("item/smd_capacitor"), SMD_CAPACITOR, 1);
    public static ItemEntry<ComponentItem> WRAP_SMD_DIODE = registerWrapItemWithNumber("wrap.component.smd_diode", GTCEu.id("item/smd_diode"), SMD_DIODE, 1);
    public static ItemEntry<ComponentItem> WRAP_SMD_INDUCTOR = registerWrapItemWithNumber("wrap.component.smd_inductor", GTCEu.id("item/smd_inductor"), SMD_INDUCTOR, 1);

    public static ItemEntry<ComponentItem> WRAP_SMD_TRANSISTOR_ADVANCED = registerWrapItemWithNumber("wrap.component.advanced_smd_transistor", GTCEu.id("item/advanced_smd_transistor"), ADVANCED_SMD_TRANSISTOR, 2);
    public static ItemEntry<ComponentItem> WRAP_SMD_RESISTOR_ADVANCED = registerWrapItemWithNumber("wrap.component.advanced_smd_resistor", GTCEu.id("item/advanced_smd_resistor"), ADVANCED_SMD_RESISTOR, 2);
    public static ItemEntry<ComponentItem> WRAP_SMD_CAPACITOR_ADVANCED = registerWrapItemWithNumber("wrap.component.advanced_smd_capacitor", GTCEu.id("item/advanced_smd_capacitor"), ADVANCED_SMD_CAPACITOR, 2);
    public static ItemEntry<ComponentItem> WRAP_SMD_DIODE_ADVANCED = registerWrapItemWithNumber("wrap.component.advanced_smd_diode", GTCEu.id("item/advanced_smd_diode"), ADVANCED_SMD_DIODE, 2);
    public static ItemEntry<ComponentItem> WRAP_SMD_INDUCTOR_ADVANCED = registerWrapItemWithNumber("wrap.component.advanced_smd_inductor", GTCEu.id("item/advanced_smd_inductor"), ADVANCED_SMD_INDUCTOR, 2);

    public static ItemEntry<ComponentItem> WRAP_SMD_TRANSISTOR_OPTICAL = registerWrapItemWithNumber("wrap.component.optical_smd.transistor", Epimorphism.id("item/component.optical_smd.transistor"), OPTICAL_TRANSISTOR, 3);
    public static ItemEntry<ComponentItem> WRAP_SMD_RESISTOR_OPTICAL = registerWrapItemWithNumber("wrap.component.optical_smd.resistor", Epimorphism.id("item/component.optical_smd.resistor"), OPTICAL_RESISTOR, 3);
    public static ItemEntry<ComponentItem> WRAP_SMD_CAPACITOR_OPTICAL = registerWrapItemWithNumber("wrap.component.optical_smd.capacitor", Epimorphism.id("item/component.optical_smd.capacitor"), OPTICAL_CAPACITOR, 3);
    public static ItemEntry<ComponentItem> WRAP_SMD_DIODE_OPTICAL = registerWrapItemWithNumber("wrap.component.optical_smd.diode", Epimorphism.id("item/component.optical_smd.diode"), OPTICAL_DIODE, 3);
    public static ItemEntry<ComponentItem> WRAP_SMD_INDUCTOR_OPTICAL = registerWrapItemWithNumber("wrap.component.optical_smd.inductor", Epimorphism.id("item/component.optical_smd.inductor"), OPTICAL_INDUCTOR, 3);

    public static ItemEntry<ComponentItem> WRAP_SMD_TRANSISTOR_SPINTRONIC = registerWrapItemWithNumber("wrap.component.spintronic_smd.transistor", Epimorphism.id("item/component.spintronic_smd.transistor"), SPINTRONIC_TRANSISTOR, 4);
    public static ItemEntry<ComponentItem> WRAP_SMD_RESISTOR_SPINTRONIC = registerWrapItemWithNumber("wrap.component.spintronic_smd.resistor", Epimorphism.id("item/component.spintronic_smd.resistor"), SPINTRONIC_RESISTOR, 4);
    public static ItemEntry<ComponentItem> WRAP_SMD_CAPACITOR_SPINTRONIC = registerWrapItemWithNumber("wrap.component.spintronic_smd.capacitor", Epimorphism.id("item/component.spintronic_smd.capacitor"), SPINTRONIC_CAPACITOR, 4);
    public static ItemEntry<ComponentItem> WRAP_SMD_DIODE_SPINTRONIC = registerWrapItemWithNumber("wrap.component.spintronic_smd.diode", Epimorphism.id("item/component.spintronic_smd.diode"), SPINTRONIC_DIODE, 4);
    public static ItemEntry<ComponentItem> WRAP_SMD_INDUCTOR_SPINTRONIC = registerWrapItemWithNumber("wrap.component.spintronic_smd.inductor", Epimorphism.id("item/component.spintronic_smd.inductor"), SPINTRONIC_INDUCTOR, 4);

    public static ItemEntry<ComponentItem> WRAP_SMD_TRANSISTOR_COSMIC = registerWrapItemWithNumber("wrap.component.cosmic_smd.transistor", Epimorphism.id("item/component.cosmic_smd.transistor"), COSMIC_TRANSISTOR, 5);
    public static ItemEntry<ComponentItem> WRAP_SMD_RESISTOR_COSMIC = registerWrapItemWithNumber("wrap.component.cosmic_smd.resistor", Epimorphism.id("item/component.cosmic_smd.resistor"), COSMIC_RESISTOR, 5);
    public static ItemEntry<ComponentItem> WRAP_SMD_CAPACITOR_COSMIC = registerWrapItemWithNumber("wrap.component.cosmic_smd.capacitor", Epimorphism.id("item/component.cosmic_smd.capacitor"), COSMIC_CAPACITOR, 5);
    public static ItemEntry<ComponentItem> WRAP_SMD_DIODE_COSMIC = registerWrapItemWithNumber("wrap.component.cosmic_smd.diode", Epimorphism.id("item/component.cosmic_smd.diode"), COSMIC_DIODE, 5);
    public static ItemEntry<ComponentItem> WRAP_SMD_INDUCTOR_COSMIC = registerWrapItemWithNumber("wrap.component.cosmic_smd.inductor", Epimorphism.id("item/component.cosmic_smd.inductor"), COSMIC_INDUCTOR, 5);

    public static void init() {/**/}

    private static ItemEntry<Item> registerWrapItem(String id, ResourceLocation wrappedTexture, ItemEntry<?> wrappedItem) {
        var itemEntry = registrate().item(id, Item::new)
            .model(EPModels.wrapItemModel(wrappedTexture))
            .register();
        WRAP_ITEM_MAP.put(wrappedItem, itemEntry);
        return itemEntry;
    }

    private static ItemEntry<ComponentItem> registerWrapItemWithNumber(String id, ResourceLocation wrappedTexture, ItemEntry<?> wrappedItem, int number) {
        var itemEntry = registrate().item(id, ComponentItem::create)
            .model(EPModels.wrapItemModel(wrappedTexture))
            .onRegister(EPItems.attachRenderer(new TierRenderItemBehavior(
                EPConfigHolder.INSTANCE.items.perfRomanSubscript
                    ? Epimorphism.id("item/number_overlay/roman/%s".formatted(number))
                    : Epimorphism.id("item/number_overlay/%s".formatted(number))
            )))
            .register();
        WRAP_ITEM_MAP.put(wrappedItem, itemEntry);
        return itemEntry;
    }

    private static ItemEntry<ComponentItem> registerWrapCircuit(String id, ResourceLocation wrappedTexture, TagKey<Item> wrappedCircuit) {
        String key = wrappedCircuit.location().getPath().split("/")[1];
        var itemEntry = registrate().item(id, ComponentItem::create)
            .model(EPModels.wrapItemModel(wrappedTexture))
            .onRegister(EPItems.attachRenderer(new TierRenderItemBehavior(Epimorphism.id("item/voltage_overlay/%s".formatted(key)))))
            .register();
        WRAP_CIRCUIT_MAP.put(wrappedCircuit, itemEntry);
        return itemEntry;
    }
}
