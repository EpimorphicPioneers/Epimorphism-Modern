package cn.gtcommunity.epimorphism.common.data;

import cn.gtcommunity.epimorphism.Epimorphism;
import cn.gtcommunity.epimorphism.common.data.items.*;
import com.gregtechceu.gtceu.common.data.GTCreativeModeTabs;
import com.tterrag.registrate.util.entry.RegistryEntry;
import net.minecraft.world.item.CreativeModeTab;

import static cn.gtcommunity.epimorphism.Epimorphism.registrate;

public class EPCreativeModeTabs {
    public final static RegistryEntry<CreativeModeTab> EP_ITEM = registrate().defaultCreativeTab("item",
                    builder -> builder.displayItems(new GTCreativeModeTabs.RegistrateDisplayItemsGenerator("item", registrate()))
                            .title(registrate().addLang("itemGroup", Epimorphism.id("item"), Epimorphism.NAME + " | Item"))
                            .icon(EPItems.GOOWARE_BOARD::asStack)
                            .build())
            .register();
    public final static RegistryEntry<CreativeModeTab> EP_BLOCK = registrate().defaultCreativeTab("block",
                    builder -> builder.displayItems(new GTCreativeModeTabs.RegistrateDisplayItemsGenerator("block", registrate()))
                            .title(registrate().addLang("itemGroup", Epimorphism.id("block"), Epimorphism.NAME + " | Block"))
                            .icon(EPBlocks.IRIDIUM_CASING::asStack)
                            .build())
            .register();
    public final static RegistryEntry<CreativeModeTab> EP_MACHINE = registrate().defaultCreativeTab("machine",
                    builder -> builder.displayItems(new GTCreativeModeTabs.RegistrateDisplayItemsGenerator("machine", registrate()))
                            .title(registrate().addLang("itemGroup", Epimorphism.id("machine"), Epimorphism.NAME + " | Machine"))
                            .icon(EPMachines.CHEMICAL_PLANT::asStack)
                            .build())
            .register();
    public final static RegistryEntry<CreativeModeTab> EP_CIRCUIT_REFORM = registrate().defaultCreativeTab("circuit_reform",
                    builder -> builder.displayItems(new GTCreativeModeTabs.RegistrateDisplayItemsGenerator("circuit_reform", registrate()))
                            .title(registrate().addLang("itemGroup", Epimorphism.id("circuit_reform"), Epimorphism.NAME + " | Circuit Reform"))
                            .icon(EPWrapItem.WRAP_BOARD_GOOWARE::asStack)
                            .build())
            .register();
    public final static RegistryEntry<CreativeModeTab> EP_PHYSICS = registrate().defaultCreativeTab("physics",
                    builder -> builder.displayItems(new GTCreativeModeTabs.RegistrateDisplayItemsGenerator("physics", registrate()))
                            .title(registrate().addLang("itemGroup", Epimorphism.id("physics"), Epimorphism.NAME + " | Physics"))
                            .icon(EPPhysicsItems.EMPTY_PARTICLE_CAPSULE::asStack)
                            .build())
            .register();
    public final static RegistryEntry<CreativeModeTab> EP_BIOLOGY = registrate().defaultCreativeTab("biology",
                    builder -> builder.displayItems(new GTCreativeModeTabs.RegistrateDisplayItemsGenerator("biology", registrate()))
                            .title(registrate().addLang("itemGroup", Epimorphism.id("biology"), Epimorphism.NAME + " | Biology"))
                            .icon(EPBiologyItems.STERILIZED_PETRI_DISH::asStack)
                            .build())
            .register();
    public final static RegistryEntry<CreativeModeTab> EP_CHEMISTRY = registrate().defaultCreativeTab("chemistry",
                    builder -> builder.displayItems(new GTCreativeModeTabs.RegistrateDisplayItemsGenerator("chemistry", registrate()))
                            .title(registrate().addLang("itemGroup", Epimorphism.id("chemistry"), Epimorphism.NAME + " | Chemistry"))
                            .icon(EPChemistryItem.CATALYST_CARRIER::asStack)
                            .build())
            .register();
    public static void init() {/**/}
}
