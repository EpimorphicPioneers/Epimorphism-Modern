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
                            .icon(EPBlocks.IRIDIUM_CASING::asStack)
                            .build())
            .register();
    public final static RegistryEntry<CreativeModeTab> EP_MACHINE = EP_REGISTRATE.defaultCreativeTab("machine",
                    builder -> builder.displayItems(new GTCreativeModeTabs.RegistrateDisplayItemsGenerator("machine", EP_REGISTRATE))
                            .title(EP_REGISTRATE.addLang("itemGroup", Epimorphism.id("machine"), Epimorphism.NAME + " | Machine"))
                            .icon(EPMachines.CHEMICAL_PLANT::asStack)
                            .build())
            .register();
    public final static RegistryEntry<CreativeModeTab> EP_CIRCUIT_REFORM = EP_REGISTRATE.defaultCreativeTab("circuit_reform",
                    builder -> builder.displayItems(new GTCreativeModeTabs.RegistrateDisplayItemsGenerator("circuit_reform", EP_REGISTRATE))
                            .title(EP_REGISTRATE.addLang("itemGroup", Epimorphism.id("circuit_reform"), Epimorphism.NAME + " | Circuit Reform"))
                            .icon(EPWrapItem.WRAP_BOARD_GOOWARE::asStack)
                            .build())
            .register();
    public final static RegistryEntry<CreativeModeTab> EP_PHYSICS = EP_REGISTRATE.defaultCreativeTab("physics",
                    builder -> builder.displayItems(new GTCreativeModeTabs.RegistrateDisplayItemsGenerator("physics", EP_REGISTRATE))
                            .title(EP_REGISTRATE.addLang("itemGroup", Epimorphism.id("physics"), Epimorphism.NAME + " | Physics"))
                            .icon(EPPhysicsItems.EMPTY_PARTICLE_CAPSULE::asStack)
                            .build())
            .register();
    public final static RegistryEntry<CreativeModeTab> EP_BIOLOGY = EP_REGISTRATE.defaultCreativeTab("biology",
                    builder -> builder.displayItems(new GTCreativeModeTabs.RegistrateDisplayItemsGenerator("biology", EP_REGISTRATE))
                            .title(EP_REGISTRATE.addLang("itemGroup", Epimorphism.id("biology"), Epimorphism.NAME + " | Biology"))
                            .icon(EPBiologyItems.STERILIZED_PETRI_DISH::asStack)
                            .build())
            .register();
    public final static RegistryEntry<CreativeModeTab> EP_AGRICULTURE = EP_REGISTRATE.defaultCreativeTab("agriculture",
                    builder -> builder.displayItems(new GTCreativeModeTabs.RegistrateDisplayItemsGenerator("agriculture", EP_REGISTRATE))
                            .title(EP_REGISTRATE.addLang("itemGroup", Epimorphism.id("agriculture"), Epimorphism.NAME + " | Agriculture"))
                            .icon(EPBlocks.FERTILIZED_DIRT::asStack)
                            .build())
            .register();
    public final static RegistryEntry<CreativeModeTab> EP_GALAXY = EP_REGISTRATE.defaultCreativeTab("galaxy",
                    builder -> builder.displayItems(new GTCreativeModeTabs.RegistrateDisplayItemsGenerator("galaxy", EP_REGISTRATE))
                            .title(EP_REGISTRATE.addLang("itemGroup", Epimorphism.id("galaxy"), Epimorphism.NAME + " | Galaxy"))
                            .icon(EPBlocks.FERTILIZED_DIRT::asStack)
                            .build())
            .register();
    public static void init() {/**/}
}
