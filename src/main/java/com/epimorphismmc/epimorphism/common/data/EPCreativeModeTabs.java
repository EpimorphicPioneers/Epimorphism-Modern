package com.epimorphismmc.epimorphism.common.data;

import com.epimorphismmc.epimorphism.Epimorphism;
import com.epimorphismmc.epimorphism.common.data.items.EPBiologyItems;
import com.epimorphismmc.epimorphism.common.data.items.EPChemistryItem;
import com.epimorphismmc.epimorphism.common.data.items.EPPhysicsItems;
import com.epimorphismmc.epimorphism.common.data.items.EPWrapItem;

import com.gregtechceu.gtceu.api.data.chemical.ChemicalHelper;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.api.item.tool.GTToolType;
import com.gregtechceu.gtceu.api.item.tool.ToolHelper;
import com.gregtechceu.gtceu.common.data.GTCreativeModeTabs;

import com.gregtechceu.gtceu.common.data.GTItems;
import com.gregtechceu.gtceu.common.pipelike.cable.Insulation;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.CreativeModeTab;

import com.tterrag.registrate.util.entry.RegistryEntry;
import net.minecraft.world.item.ItemStack;

import static com.epimorphismmc.epimorphism.Epimorphism.registrate;

public class EPCreativeModeTabs {
    public static final RegistryEntry<CreativeModeTab> EP_ITEM = registrate()
            .defaultCreativeTab("item", builder -> builder
                    .displayItems(
                            new GTCreativeModeTabs.RegistrateDisplayItemsGenerator("item", registrate()))
                    .title(registrate()
                            .addLang("itemGroup", Epimorphism.id("item"), Epimorphism.NAME + " | Item"))
                    .icon(EPItems.GOOWARE_BOARD::asStack)
                    .build())
            .register();
    public static final RegistryEntry<CreativeModeTab> EP_BLOCK = registrate()
            .defaultCreativeTab("block", builder -> builder
                    .displayItems(
                            new GTCreativeModeTabs.RegistrateDisplayItemsGenerator("block", registrate()))
                    .title(registrate()
                            .addLang("itemGroup", Epimorphism.id("block"), Epimorphism.NAME + " | Block"))
                    .icon(EPBlocks.IRIDIUM_CASING::asStack)
                    .withTabsBefore(EP_ITEM.getKey())
                    .build())
            .register();
    public static final RegistryEntry<CreativeModeTab> EP_MACHINE = registrate()
            .defaultCreativeTab("machine", builder -> builder
                    .displayItems(
                            new GTCreativeModeTabs.RegistrateDisplayItemsGenerator("machine", registrate()))
                    .title(registrate()
                            .addLang("itemGroup", Epimorphism.id("machine"), Epimorphism.NAME + " | Machine"))
                    .icon(EPMachines.CHEMICAL_PLANT::asStack)
                    .withTabsBefore(EP_BLOCK.getKey())
                    .build())
            .register();
    public static final RegistryEntry<CreativeModeTab> EP_CIRCUIT_REFORM = registrate()
            .defaultCreativeTab("circuit_reform", builder -> builder
                    .displayItems(new GTCreativeModeTabs.RegistrateDisplayItemsGenerator(
                            "circuit_reform", registrate()))
                    .title(registrate()
                            .addLang(
                                    "itemGroup",
                                    Epimorphism.id("circuit_reform"),
                                    Epimorphism.NAME + " | Circuit Reform"))
                    .icon(EPWrapItem.WRAP_BOARD_GOOWARE::asStack)
                    .withTabsBefore(EP_MACHINE.getKey())
                    .build())
            .register();
    public static final RegistryEntry<CreativeModeTab> EP_PHYSICS = registrate()
            .defaultCreativeTab("physics", builder -> builder
                    .displayItems(
                            new GTCreativeModeTabs.RegistrateDisplayItemsGenerator("physics", registrate()))
                    .title(registrate()
                            .addLang("itemGroup", Epimorphism.id("physics"), Epimorphism.NAME + " | Physics"))
                    .icon(EPPhysicsItems.EMPTY_PARTICLE_CAPSULE::asStack)
                    .withTabsBefore(EP_CIRCUIT_REFORM.getKey())
                    .build())
            .register();
    public static final RegistryEntry<CreativeModeTab> EP_BIOLOGY = registrate()
            .defaultCreativeTab("biology", builder -> builder
                    .displayItems(
                            new GTCreativeModeTabs.RegistrateDisplayItemsGenerator("biology", registrate()))
                    .title(registrate()
                            .addLang("itemGroup", Epimorphism.id("biology"), Epimorphism.NAME + " | Biology"))
                    .icon(EPBiologyItems.STERILIZED_PETRI_DISH::asStack)
                    .withTabsBefore(EP_PHYSICS.getKey())
                    .build())
            .register();
    public static final RegistryEntry<CreativeModeTab> EP_CHEMISTRY = registrate()
            .defaultCreativeTab("chemistry", builder -> builder
                    .displayItems(
                            new GTCreativeModeTabs.RegistrateDisplayItemsGenerator("chemistry", registrate()))
                    .title(registrate()
                            .addLang("itemGroup", Epimorphism.id("chemistry"), Epimorphism.NAME + " | Chemistry"))
                    .icon(EPChemistryItem.CATALYST_CARRIER::asStack)
                    .withTabsBefore(EP_BIOLOGY.getKey())
                    .build())
            .register();
    public static final RegistryEntry<CreativeModeTab> EP_MATERIAL_BLOCK = registrate()
            .defaultCreativeTab("material_block", builder -> builder
                    .displayItems(new GTCreativeModeTabs.RegistrateDisplayItemsGenerator("material_block", registrate()))
                    .title(registrate().addLang("itemGroup", Epimorphism.id("material_block"), Epimorphism.NAME + " | Material Block"))
                    .icon(() -> ChemicalHelper.get(TagPrefix.block, EPMaterials.PedotTMA))
                    .withTabsBefore(EP_CHEMISTRY.getKey())
                    .build()
            )
            .register();
    public static final RegistryEntry<CreativeModeTab> EP_MATERIAL_ITEM = registrate()
            .defaultCreativeTab("material_item", builder -> builder
                    .displayItems(new GTCreativeModeTabs.RegistrateDisplayItemsGenerator("material_item", registrate()))
                    .title(registrate().addLang("itemGroup", Epimorphism.id("material_item"), Epimorphism.NAME + " | Material Item"))
                    .icon(() -> ChemicalHelper.get(TagPrefix.ingot, EPMaterials.PedotPSS))
                    .withTabsBefore(EP_MATERIAL_BLOCK.getKey())
                    .build()
            )
            .register();
    public static final RegistryEntry<CreativeModeTab> EP_MATERIAL_PIPE = registrate()
            .defaultCreativeTab("material_pipe", builder -> builder
                    .displayItems(new GTCreativeModeTabs.RegistrateDisplayItemsGenerator("material_pipe", registrate()))
                    .title(registrate().addLang("itemGroup", Epimorphism.id("material_pipe"), Epimorphism.NAME + " | Material Pipe"))
                    .icon(() -> ChemicalHelper.get(Insulation.WIRE_DOUBLE.tagPrefix, EPMaterials.PedotTMA))
                    .withTabsBefore(EP_MATERIAL_ITEM.getKey())
                    .build()
            )
            .register();
    public static final RegistryEntry<CreativeModeTab> EP_MATERIAL_FLUID = registrate()
            .defaultCreativeTab("material_fluid", builder -> builder
                    .displayItems(new GTCreativeModeTabs.RegistrateDisplayItemsGenerator("material_fluid", registrate()))
                    .title(registrate().addLang("itemGroup", Epimorphism.id("material_fluid"), Epimorphism.NAME + " | Material Fluid"))
                    .icon(() -> {
                        ItemStack stack = GTItems.FLUID_CELL.asStack();
                        CompoundTag tag = stack.getOrCreateTag();
                        CompoundTag fluidTag = new CompoundTag();
                        fluidTag.putString("FluidName", Epimorphism.id("pedot_pss").toString());
                        fluidTag.putInt("Amount", 1000);
                        tag.put("Fluid", fluidTag);
                        return stack;
                    })
                    .withTabsBefore(EP_MATERIAL_PIPE.getKey())
                    .build()
            )
            .register();

    public static final RegistryEntry<CreativeModeTab> EP_TOOL = registrate()
            .defaultCreativeTab("tool", builder -> builder
                    .displayItems(new GTCreativeModeTabs.RegistrateDisplayItemsGenerator("tool", registrate()))
                    .title(registrate().addLang("itemGroup", Epimorphism.id("tool"), Epimorphism.NAME + " | Tool"))
                    .icon(() -> ToolHelper.get(GTToolType.WRENCH, EPMaterials.Draconium))
                    .withTabsBefore(EP_MATERIAL_PIPE.getKey())
                    .build()
            )
            .register();


    public static void init() {
        /**/
    }
}
