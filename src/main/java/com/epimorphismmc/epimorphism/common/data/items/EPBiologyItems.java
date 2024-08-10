package com.epimorphismmc.epimorphism.common.data.items;

import com.epimorphismmc.epimorphism.common.data.EPCreativeModeTabs;

import com.gregtechceu.gtceu.api.item.ComponentItem;

import net.minecraft.world.item.Item;

import com.tterrag.registrate.util.entry.ItemEntry;

import static com.epimorphismmc.epimorphism.EpimorphismCommon.registrate;
import static com.epimorphismmc.epimorphism.common.data.EPItems.*;

public class EPBiologyItems {

    static {
        registrate().creativeModeTab(() -> EPCreativeModeTabs.EP_BIOLOGY);
    }

    public static final ItemEntry<Item> ORDINARY_ALGAE =
            registerItem("ordinary_algae").register();
    public static final ItemEntry<Item> RED_ALGA = registerItem("red_alga").register();
    public static final ItemEntry<Item> GREEN_ALGA = registerItem("green_alga").register();
    public static final ItemEntry<Item> CHRYSOPHYCEAE =
            registerItem("chrysophyceae").register();
    public static final ItemEntry<Item> BROWN_ALGA = registerItem("brown_alga").register();

    public static final ItemEntry<Item> PINECONE = registerItem("pinecone").register();

    //  Biological Components
    public static final ItemEntry<ComponentItem> ELECTROCHEMICAL_GRADIENT_RECORDER =
            registerItemWithTooltip("electrochemical_gradient_recorder", 1).register();
    public static final ItemEntry<ComponentItem> ULTRA_MICRO_PHASE_SEPARATOR =
            registerItemWithTooltip("ultra_micro_phase_separator", 1).register();
    public static final ItemEntry<ComponentItem> QUANTUM_TUNNELING_MICROTUBULE =
            registerItemWithTooltip("quantum_tunneling_microtubule", 1).register();
    public static final ItemEntry<ComponentItem> HYPERRIBOSOME =
            registerItemWithTooltip("hyperribosome", 1).register();
    public static final ItemEntry<ComponentItem> NEUTRON_ABSORBING_PROTEIN =
            registerItemWithTooltip("neutron_absorbing_protein", 1).register();
    public static final ItemEntry<ComponentItem> SUPEREXCITED_CONDUCTIVE_POLYMER =
            registerItemWithTooltip("superexcited_conductive_polymer", 1).register();

    public static final ItemEntry<ComponentItem> STERILIZED_PETRI_DISH =
            registerItemWithTooltip("sterilized_petri_dish", 1).register();

    //    public static ItemEntry<ComponentItem> CLEAN_CULTURE = registrate().item("clean_culture",
    // ComponentItem::create)
    //            .color(() -> IMaterialPartItem::getItemStackColor)
    //            .model(EPModels.simpleCustomModel(new ResourceLocation("item/generated"),
    // Epimorphism.id("item/grind_ball/base")))
    //            .onRegister(attach(new CleanCultureBehavior()))
    //            .register();

    private EPBiologyItems() {
        /**/
    }

    public static void init() {}
}
