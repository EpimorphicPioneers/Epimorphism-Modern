package cn.gtcommunity.epimorphism.common.data;

import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.world.item.Item;

import static cn.gtcommunity.epimorphism.api.registry.EPRegistries.EP_REGISTRATE;

public class EPAgricultureItem {

    static {
        EP_REGISTRATE.creativeModeTab(() -> EPCreativeModeTabs.EP_AGRICULTURE);
    }

    public final static ItemEntry<Item> ORDINARY_ALGAE = EP_REGISTRATE.item("algae.ordinary_algae", Item::new).lang("Ordinary Algae").register();
    public final static ItemEntry<Item> RED_ALGA = EP_REGISTRATE.item("algae.red_alga", Item::new).lang("Red Alga").register();
    public final static ItemEntry<Item> GREEN_ALGA = EP_REGISTRATE.item("algae.green_alga", Item::new).lang("Green Alga").register();
    public final static ItemEntry<Item> CHRYSOPHYCEAE = EP_REGISTRATE.item("algae.chrysophyceae", Item::new).lang("Chrysophyceae").register();
    public final static ItemEntry<Item> BROWN_ALGA = EP_REGISTRATE.item("algae.brown_alga", Item::new).lang("Brown Alga").register();

    public final static ItemEntry<Item> PINECONE = EP_REGISTRATE.item("pinecone", Item::new).lang("Pinecone").register();

    private EPAgricultureItem() {/**/}

    public static void init() {

    }
}
