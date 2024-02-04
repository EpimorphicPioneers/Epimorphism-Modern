package cn.gtcommunity.epimorphism.common.data;

import cn.gtcommunity.epimorphism.Epimorphism;
import com.gregtechceu.gtceu.common.data.GTCreativeModeTabs;
import com.tterrag.registrate.util.entry.RegistryEntry;
import net.minecraft.world.item.CreativeModeTab;

import static cn.gtcommunity.epimorphism.api.registry.EPRegistries.*;

public class EPCreativeModeTabs {
    public final static RegistryEntry<CreativeModeTab> EP_ITEM = EP_REGISTRATE.defaultCreativeTab("item",
                    builder -> builder.displayItems(new GTCreativeModeTabs.RegistrateDisplayItemsGenerator("item", EP_REGISTRATE))
                            .title(EP_REGISTRATE.addLang("itemGroup", Epimorphism.id("item"), Epimorphism.NAME + " | Item"))
                            .icon(EPItems.GOOWARE_BOARD::asStack)
                            .build())
                    .register();
    public final static RegistryEntry<CreativeModeTab> EP_BLOCK = EP_REGISTRATE.defaultCreativeTab("block",
                    builder -> builder.displayItems(new GTCreativeModeTabs.RegistrateDisplayItemsGenerator("block", EP_REGISTRATE))
                            .title(EP_REGISTRATE.addLang("itemGroup", Epimorphism.id("block"), Epimorphism.NAME + " | Block"))
                            .icon(EPItems.GOOWARE_BOARD::asStack)
                            .build())
                    .register();
    public final static RegistryEntry<CreativeModeTab> EP_CIRCUIT_REFORM = EP_REGISTRATE.defaultCreativeTab("circuit_reform",
                    builder -> builder.displayItems(new GTCreativeModeTabs.RegistrateDisplayItemsGenerator("circuit_reform", EP_REGISTRATE))
                            .title(EP_REGISTRATE.addLang("itemGroup", Epimorphism.id("circuit_reform"), Epimorphism.NAME + " | Circuit Reform"))
                            .icon(EPItems.GOOWARE_BOARD::asStack)
                            .build())
                    .register();
    public final static RegistryEntry<CreativeModeTab> EP_PHYSICS = EP_REGISTRATE.defaultCreativeTab("physics",
                    builder -> builder.displayItems(new GTCreativeModeTabs.RegistrateDisplayItemsGenerator("physics", EP_REGISTRATE))
                            .title(EP_REGISTRATE.addLang("itemGroup", Epimorphism.id("physics"), Epimorphism.NAME + " | Physics"))
                            .icon(EPItems.GOOWARE_BOARD::asStack)
                            .build())
                    .register();
    public final static RegistryEntry<CreativeModeTab> EP_AGRICULTURE = EP_REGISTRATE.defaultCreativeTab("agriculture",
                    builder -> builder.displayItems(new GTCreativeModeTabs.RegistrateDisplayItemsGenerator("agriculture", EP_REGISTRATE))
                            .title(EP_REGISTRATE.addLang("itemGroup", Epimorphism.id("agriculture"), Epimorphism.NAME + " | Agriculture"))
                            .icon(EPItems.GOOWARE_BOARD::asStack)
                            .build())
                    .register();

    public static void init() {/**/}
}
