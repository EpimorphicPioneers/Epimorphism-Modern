package cn.gtcommunity.epimorphism.common.data.items;

import cn.gtcommunity.epimorphism.Epimorphism;
import cn.gtcommunity.epimorphism.common.data.EPCreativeModeTabs;
import cn.gtcommunity.epimorphism.common.data.EPItems;
import cn.gtcommunity.epimorphism.common.data.EPModels;
import cn.gtcommunity.epimorphism.common.item.behaviors.CatalystBehavior;
import com.gregtechceu.gtceu.api.item.ComponentItem;
import com.gregtechceu.gtceu.utils.FormattingUtil;
import com.tterrag.registrate.Registrate;
import com.tterrag.registrate.builders.ItemBuilder;
import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.resources.ResourceLocation;

import static cn.gtcommunity.epimorphism.Epimorphism.registrate;
import static cn.gtcommunity.epimorphism.common.data.EPMaterials.*;
import static cn.gtcommunity.epimorphism.common.data.EPItems.*;

public class EPChemistryItem {

    static {
        registrate().creativeModeTab(() -> EPCreativeModeTabs.EP_CHEMISTRY);
    }

    // Catalysts
    public final static ItemEntry<ComponentItem> CATALYST_CARRIER = registerItemWithTooltip("catalyst_carrier", 1).register();
    public final static ItemEntry<ComponentItem> TI_AL_CATALYST = registerCatalyst("ti_al", TiAlCatalyst.getMaterialRGB()).register();
    public final static ItemEntry<ComponentItem> PALLADIUM_CARBON_CATALYST = registerCatalyst("palladium_carbon", PalladiumOnCarbon.getMaterialRGB()).register();



    private static ItemBuilder<ComponentItem, Registrate> registerCatalyst(String name, int color) {
        return registrate().item("catalyst." + name, ComponentItem::create)
                .color(() -> CatalystBehavior.getItemStackColor(color))
                .model(EPModels.simpleCustomModel(new ResourceLocation("item/generated"), Epimorphism.id("item/catalyst/base"), Epimorphism.id("item/catalyst/overlay")))
                .onRegister(EPItems.attach(new CatalystBehavior(50)));
    }

    private static ItemBuilder<ComponentItem, Registrate> registerCatalyst(String name, int color, int maxDurability) {
        return registrate().item("catalyst." + name, ComponentItem::create)
                .lang(FormattingUtil.toEnglishName(name) + "Catalyst")
                .color(() -> CatalystBehavior.getItemStackColor(color))
                .model(EPModels.simpleCustomModel(new ResourceLocation("item/generated"), Epimorphism.id("item/catalyst/base"), Epimorphism.id("item/catalyst/overlay")))
                .onRegister(EPItems.attach(new CatalystBehavior(maxDurability)));
    }

    private EPChemistryItem() {/**/}

    public static void init() {

    }
}
