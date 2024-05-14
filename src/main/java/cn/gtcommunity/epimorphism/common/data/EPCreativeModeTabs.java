package cn.gtcommunity.epimorphism.common.data;

import cn.gtcommunity.epimorphism.Epimorphism;
import cn.gtcommunity.epimorphism.common.registry.EPRegistration;
import cn.gtcommunity.epimorphism.common.data.items.*;
import com.gregtechceu.gtceu.common.data.GTCreativeModeTabs;
import com.tterrag.registrate.util.entry.RegistryEntry;
import net.minecraft.world.item.CreativeModeTab;

public class EPCreativeModeTabs {
    public final static RegistryEntry<CreativeModeTab> EP_ITEM = EPRegistration.EP_REGISTRATE.defaultCreativeTab("item",
                    builder -> builder.displayItems(new GTCreativeModeTabs.RegistrateDisplayItemsGenerator("item", EPRegistration.EP_REGISTRATE))
                            .title(EPRegistration.EP_REGISTRATE.addLang("itemGroup", Epimorphism.id("item"), Epimorphism.NAME + " | Item"))
                            .icon(EPItems.GOOWARE_BOARD::asStack)
                            .build())
            .register();
    public final static RegistryEntry<CreativeModeTab> EP_BLOCK = EPRegistration.EP_REGISTRATE.defaultCreativeTab("block",
                    builder -> builder.displayItems(new GTCreativeModeTabs.RegistrateDisplayItemsGenerator("block", EPRegistration.EP_REGISTRATE))
                            .title(EPRegistration.EP_REGISTRATE.addLang("itemGroup", Epimorphism.id("block"), Epimorphism.NAME + " | Block"))
                            .icon(EPBlocks.IRIDIUM_CASING::asStack)
                            .build())
            .register();
    public final static RegistryEntry<CreativeModeTab> EP_MACHINE = EPRegistration.EP_REGISTRATE.defaultCreativeTab("machine",
                    builder -> builder.displayItems(new GTCreativeModeTabs.RegistrateDisplayItemsGenerator("machine", EPRegistration.EP_REGISTRATE))
                            .title(EPRegistration.EP_REGISTRATE.addLang("itemGroup", Epimorphism.id("machine"), Epimorphism.NAME + " | Machine"))
                            .icon(EPMachines.CHEMICAL_PLANT::asStack)
                            .build())
            .register();
    public final static RegistryEntry<CreativeModeTab> EP_CIRCUIT_REFORM = EPRegistration.EP_REGISTRATE.defaultCreativeTab("circuit_reform",
                    builder -> builder.displayItems(new GTCreativeModeTabs.RegistrateDisplayItemsGenerator("circuit_reform", EPRegistration.EP_REGISTRATE))
                            .title(EPRegistration.EP_REGISTRATE.addLang("itemGroup", Epimorphism.id("circuit_reform"), Epimorphism.NAME + " | Circuit Reform"))
                            .icon(EPWrapItem.WRAP_BOARD_GOOWARE::asStack)
                            .build())
            .register();
    public final static RegistryEntry<CreativeModeTab> EP_PHYSICS = EPRegistration.EP_REGISTRATE.defaultCreativeTab("physics",
                    builder -> builder.displayItems(new GTCreativeModeTabs.RegistrateDisplayItemsGenerator("physics", EPRegistration.EP_REGISTRATE))
                            .title(EPRegistration.EP_REGISTRATE.addLang("itemGroup", Epimorphism.id("physics"), Epimorphism.NAME + " | Physics"))
                            .icon(EPPhysicsItems.EMPTY_PARTICLE_CAPSULE::asStack)
                            .build())
            .register();
    public final static RegistryEntry<CreativeModeTab> EP_BIOLOGY = EPRegistration.EP_REGISTRATE.defaultCreativeTab("biology",
                    builder -> builder.displayItems(new GTCreativeModeTabs.RegistrateDisplayItemsGenerator("biology", EPRegistration.EP_REGISTRATE))
                            .title(EPRegistration.EP_REGISTRATE.addLang("itemGroup", Epimorphism.id("biology"), Epimorphism.NAME + " | Biology"))
                            .icon(EPBiologyItems.STERILIZED_PETRI_DISH::asStack)
                            .build())
            .register();
    public final static RegistryEntry<CreativeModeTab> EP_CHEMISTRY = EPRegistration.EP_REGISTRATE.defaultCreativeTab("chemistry",
                    builder -> builder.displayItems(new GTCreativeModeTabs.RegistrateDisplayItemsGenerator("chemistry", EPRegistration.EP_REGISTRATE))
                            .title(EPRegistration.EP_REGISTRATE.addLang("itemGroup", Epimorphism.id("chemistry"), Epimorphism.NAME + " | Chemistry"))
                            .icon(EPChemistryItem.CATALYST_CARRIER::asStack)
                            .build())
            .register();
    public final static RegistryEntry<CreativeModeTab> EP_AGRICULTURE = EPRegistration.EP_REGISTRATE.defaultCreativeTab("agriculture",
                    builder -> builder.displayItems(new GTCreativeModeTabs.RegistrateDisplayItemsGenerator("agriculture", EPRegistration.EP_REGISTRATE))
                            .title(EPRegistration.EP_REGISTRATE.addLang("itemGroup", Epimorphism.id("agriculture"), Epimorphism.NAME + " | Agriculture"))
                            .icon(EPChemistryItem.CATALYST_CARRIER::asStack)
                            .build())
            .register();
    public final static RegistryEntry<CreativeModeTab> EP_GALAXY = EPRegistration.EP_REGISTRATE.defaultCreativeTab("galaxy",
                    builder -> builder.displayItems(new GTCreativeModeTabs.RegistrateDisplayItemsGenerator("galaxy", EPRegistration.EP_REGISTRATE))
                            .title(EPRegistration.EP_REGISTRATE.addLang("itemGroup", Epimorphism.id("galaxy"), Epimorphism.NAME + " | Galaxy"))
                            .icon(EPChemistryItem.CATALYST_CARRIER::asStack)
                            .build())
            .register();
    public static void init() {/**/}
}
