package cn.gtcommunity.epimorphism.common.data.items;

import cn.gtcommunity.epimorphism.Epimorphism;
import cn.gtcommunity.epimorphism.api.data.chemical.material.properties.EPPropertyKeys;
import cn.gtcommunity.epimorphism.common.data.EPCreativeModeTabs;
import cn.gtcommunity.epimorphism.common.data.EPModels;
import cn.gtcommunity.epimorphism.common.item.behaviors.CatalystBehavior;
import com.epimorphismmc.monomorphism.item.behaviors.TagPrefixBehavior;
import com.google.common.collect.ImmutableTable;
import com.google.common.collect.Table;
import com.gregtechceu.gtceu.api.GTCEuAPI;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.registry.MaterialRegistry;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.api.item.ComponentItem;
import com.gregtechceu.gtceu.utils.FormattingUtil;
import com.tterrag.registrate.Registrate;
import com.tterrag.registrate.builders.ItemBuilder;
import com.tterrag.registrate.providers.ProviderType;
import com.tterrag.registrate.util.entry.ItemEntry;
import com.tterrag.registrate.util.nullness.NonNullBiConsumer;
import net.minecraft.resources.ResourceLocation;

import static cn.gtcommunity.epimorphism.Epimorphism.registrate;
import static cn.gtcommunity.epimorphism.api.data.tag.EPTagPrefix.catalyst;
import static cn.gtcommunity.epimorphism.common.data.EPItems.registerItemWithTooltip;
import static com.gregtechceu.gtceu.common.data.GTItems.attach;
import static com.gregtechceu.gtceu.common.data.GTItems.unificationItem;

public class EPChemistryItem {

    static {
        registrate().creativeModeTab(() -> EPCreativeModeTabs.EP_CHEMISTRY);
    }

    public static Table<TagPrefix, Material, ItemEntry<ComponentItem>> CATALYST_ITEMS;

    // Catalysts
    public final static ItemEntry<ComponentItem> CATALYST_CARRIER = registerItemWithTooltip("catalyst_carrier", 1).register();

    public static void generateCatalystItems() {
        registrate().creativeModeTab(() -> EPCreativeModeTabs.EP_CHEMISTRY);
        ImmutableTable.Builder<TagPrefix, Material, ItemEntry<ComponentItem>> builder = ImmutableTable.builder();
        for (MaterialRegistry registry : GTCEuAPI.materialManager.getRegistries()) {
            for (Material material : registry.getAllMaterials()) {
                if (material.hasProperty(EPPropertyKeys.CATALYST)) {
                    builder.put(catalyst, material, registrate()
                            .item(catalyst.idPattern().formatted(material.getName()), ComponentItem::create)
                            .setData(ProviderType.LANG, NonNullBiConsumer.noop())
                            .transform(unificationItem(catalyst, material))
                            .properties(p -> p.stacksTo(catalyst.maxStackSize()))
                            .model(NonNullBiConsumer.noop())
                            .color(() -> TagPrefixBehavior::tintColor)
                            .onRegister(attach(new CatalystBehavior(material.getProperty(EPPropertyKeys.CATALYST).getMaxDurability())))
                            .onRegister(attach(new TagPrefixBehavior(catalyst, material)))
                            .register());
                }
            }
        }
        CATALYST_ITEMS = builder.build();
    }


    private static ItemBuilder<ComponentItem, Registrate> registerCatalyst(String name, int color) {
        return registrate().item("catalyst." + name, ComponentItem::create)
                .color(() -> CatalystBehavior.getItemStackColor(color))
                .model(EPModels.simpleCustomModel(new ResourceLocation("item/generated"), Epimorphism.id("item/catalyst/base"), Epimorphism.id("item/catalyst/overlay")))
                .onRegister(attach(new CatalystBehavior(50)));
    }

    private static ItemBuilder<ComponentItem, Registrate> registerCatalyst(String name, int color, int maxDurability) {
        return registrate().item("catalyst." + name, ComponentItem::create)
                .lang(FormattingUtil.toEnglishName(name) + "Catalyst")
                .color(() -> CatalystBehavior.getItemStackColor(color))
                .model(EPModels.simpleCustomModel(new ResourceLocation("item/generated"), Epimorphism.id("item/catalyst/base"), Epimorphism.id("item/catalyst/overlay")))
                .onRegister(attach(new CatalystBehavior(maxDurability)));
    }

    private EPChemistryItem() {/**/}

    public static void init() {
        generateCatalystItems();
    }
}
