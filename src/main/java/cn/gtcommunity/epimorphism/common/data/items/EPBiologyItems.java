package cn.gtcommunity.epimorphism.common.data.items;

import cn.gtcommunity.epimorphism.common.data.EPCreativeModeTabs;
import com.gregtechceu.gtceu.api.item.ComponentItem;
import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.world.item.Item;

import static cn.gtcommunity.epimorphism.Epimorphism.registrate;
import static cn.gtcommunity.epimorphism.common.data.EPItems.*;

public class EPBiologyItems {

    static {
        registrate().creativeModeTab(() -> EPCreativeModeTabs.EP_BIOLOGY);
    }

    public final static ItemEntry<Item> ORDINARY_ALGAE = registerItem("algae.ordinary_algae").register();
    public final static ItemEntry<Item> RED_ALGA = registerItem("algae.red_alga").register();
    public final static ItemEntry<Item> GREEN_ALGA = registerItem("algae.green_alga").register();
    public final static ItemEntry<Item> CHRYSOPHYCEAE = registerItem("algae.chrysophyceae").register();
    public final static ItemEntry<Item> BROWN_ALGA = registerItem("algae.brown_alga").register();

    public final static ItemEntry<Item> PINECONE = registerItem("pinecone").register();

    //  Biological Components
    public final static ItemEntry<ComponentItem> ELECTROCHEMICAL_GRADIENT_RECORDER = registerItemWithTooltip("biological.components.electrochemical_gradient_recorder", 1).register();
    public final static ItemEntry<ComponentItem> ULTRA_MICRO_PHASE_SEPARATOR = registerItemWithTooltip("biological.components.ultra_micro_phase_separator", 1).register();
    public final static ItemEntry<ComponentItem> QUANTUM_TUNNELING_MICROTUBULE = registerItemWithTooltip("biological.components.quantum_tunneling_microtubule", 1).register();
    public final static ItemEntry<ComponentItem> HYPERRIBOSOME = registerItemWithTooltip("biological.components.hyperribosome", 1).register();
    public final static ItemEntry<ComponentItem> NEUTRON_ABSORBING_PROTEIN = registerItemWithTooltip("biological.components.neutron_absorbing_protein", 1).register();
    public final static ItemEntry<ComponentItem> SUPEREXCITED_CONDUCTIVE_POLYMER = registerItemWithTooltip("biological.components.superexcited_conductive_polymer", 1).register();

    public final static ItemEntry<ComponentItem> STERILIZED_PETRI_DISH = registerItemWithTooltip("sterilized_petri_dish", 1).register();

//    public static ItemEntry<ComponentItem> CLEAN_CULTURE = registrate().item("clean_culture", ComponentItem::create)
//            .color(() -> IMaterialPartItem::getItemStackColor)
//            .model(EPModels.simpleCustomModel(new ResourceLocation("item/generated"), Epimorphism.id("item/grind_ball/base")))
//            .onRegister(attach(new CleanCultureBehavior()))
//            .register();

    private EPBiologyItems() {/**/}

    public static void init() {

    }
}
