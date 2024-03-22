package cn.gtcommunity.epimorphism.common.data;

import cn.gtcommunity.epimorphism.Epimorphism;
import cn.gtcommunity.epimorphism.common.item.behaviors.CleanCultureBehavior;
import com.gregtechceu.gtceu.api.item.ComponentItem;
import com.gregtechceu.gtceu.api.item.component.IMaterialPartItem;
import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.resources.ResourceLocation;

import static cn.gtcommunity.epimorphism.api.registry.EPRegistries.EP_REGISTRATE;
import static cn.gtcommunity.epimorphism.common.data.EPItems.*;

public class EPBiologyItems {

    static {
        EP_REGISTRATE.creativeModeTab(() -> EPCreativeModeTabs.EP_BIOLOGY);
    }

    //  Biological Components
    public final static ItemEntry<ComponentItem> ELECTROCHEMICAL_GRADIENT_RECORDER = registerItemWithTooltip("biological.components.electrochemical_gradient_recorder", ComponentItem::create, 1).lang("Electrochemical Gradient Recorder").register();
    public final static ItemEntry<ComponentItem> ULTRA_MICRO_PHASE_SEPARATOR = registerItemWithTooltip("biological.components.ultra_micro_phase_separator", ComponentItem::create, 1).lang("Ultra-micro Phase Separator").register();
    public final static ItemEntry<ComponentItem> QUANTUM_TUNNELING_MICROTUBULE = registerItemWithTooltip("biological.components.quantum_tunneling_microtubule", ComponentItem::create, 1).lang("Quantum Tunneling Microtubule").register();
    public final static ItemEntry<ComponentItem> HYPERRIBOSOME = registerItemWithTooltip("biological.components.hyperribosome", ComponentItem::create, 1).lang("Hyperribosome").register();
    public final static ItemEntry<ComponentItem> NEUTRON_ABSORBING_PROTEIN = registerItemWithTooltip("biological.components.neutron_absorbing_protein", ComponentItem::create, 1).lang("Neutron Absorbing Protein").register();
    public final static ItemEntry<ComponentItem> SUPEREXCITED_CONDUCTIVE_POLYMER = registerItemWithTooltip("biological.components.superexcited_conductive_polymer", ComponentItem::create, 1).lang("Superexcited Conductive Polymer").register();
//    public final static ItemEntry<Item> DNA_ENCODER = REGISTRATE.item(307, "biological.components.dna_encoder");
//    public final static ItemEntry<Item> DNA_DECODER = REGISTRATE.item(308, "biological.components.dna_decoder");
//    public final static ItemEntry<Item> DNA_DECODE_ENCODER = REGISTRATE.item(309, "biological.components.dna_decode_encoder");

    public final static ItemEntry<ComponentItem> STERILIZED_PETRI_DISH = registerItemWithTooltip("sterilized_petri_dish", ComponentItem::create, 1).lang("Sterilized Petri Dish").register();

//    public static ItemEntry<ComponentItem> CLEAN_CULTURE = EP_REGISTRATE.item("clean_culture", ComponentItem::create)
//            .color(() -> IMaterialPartItem::getItemStackColor)
//            .model(EPModels.simpleCustomModel(new ResourceLocation("item/generated"), Epimorphism.id("item/grind_ball/base")))
//            .onRegister(attach(new CleanCultureBehavior()))
//            .register();

    private EPBiologyItems() {/**/}

    public static void init() {

    }
}
