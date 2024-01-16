package cn.gtcommunity.epimorphism.common.data.materials;

import cn.gtcommunity.epimorphism.common.data.EPElements;
import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconSet;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.BlastProperty;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.ToolProperty;
import com.gregtechceu.gtceu.api.fluids.FluidBuilder;
import com.gregtechceu.gtceu.api.fluids.store.FluidStorageKeys;
import com.gregtechceu.gtceu.common.data.GTElements;
import cn.gtcommunity.epimorphism.common.data.EPMaterials;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import net.minecraft.world.item.enchantment.Enchantments;

import static cn.gtcommunity.epimorphism.api.chemical.material.info.EPMaterialFlags.*;
import static cn.gtcommunity.epimorphism.api.chemical.material.info.EPMaterialIconSet.*;

public class EPElementMaterials {
    public static void register() {

        //  26001 Draconium
        EPMaterials.Draconium = new Material.Builder("draconium")
                .ingot()
                .fluid()
                .color(0xbe49ed)
                .iconSet(MaterialIconSet.SHINY)
                .flags(MaterialFlags.GENERATE_PLATE, MaterialFlags.GENERATE_ROTOR, MaterialFlags.GENERATE_ROD, MaterialFlags.GENERATE_GEAR, MaterialFlags.GENERATE_SMALL_GEAR, MaterialFlags.GENERATE_FRAME, GENERATE_CURVED_PLATE, MaterialFlags.GENERATE_DENSE)
                .element(EPElements.Draconium)
                .toolStats(ToolProperty.Builder.of(7.0F, 25.0F, 17000, 22)
                                       .magnetic()
                                       .enchantment(Enchantments.BLOCK_EFFICIENCY, 5)
                                       .enchantment(Enchantments.BLOCK_FORTUNE, 5)
                                       .build())
                .blastTemp(10800, BlastProperty.GasTier.HIGHEST, GTValues.VA[GTValues.UHV])
                .buildAndRegister();
        //  26002 Awakened Draconium
        EPMaterials.AwakenedDraconium = new Material.Builder("awakened_draconium")
                .ingot()
                .fluid()
                .color(0xf58742)
                .iconSet(MaterialIconSet.BRIGHT)
                .flags(MaterialFlags.GENERATE_PLATE, MaterialFlags.GENERATE_FOIL, MaterialFlags.GENERATE_FINE_WIRE)
                .element(EPElements.AwakenedDraconium)
                .blastTemp(10800, BlastProperty.GasTier.HIGHEST, GTValues.VA[GTValues.UV])
                .cableProperties(GTValues.V[GTValues.UHV], 16, 4)
                .buildAndRegister();
        //  26003 Chaotic Draconium
        EPMaterials.ChaoticDraconium = new Material.Builder("chaotic_draconium")
                .ingot()
                .fluid()
                .color(0x2C195A)
                .iconSet(MaterialIconSet.SHINY)
                .flags(MaterialFlags.NO_SMELTING, MaterialFlags.GENERATE_PLATE)
                .element(EPElements.ChaoticDraconium)
                .cableProperties(GTValues.V[GTValues.UEV], 32, 16)
                .buildAndRegister();
        //  Pay attention to these materials, they are just foil (not foil in gregtech)!
        //  26004 Orichalcum
        EPMaterials.Orichalcum = new Material.Builder("orichalcum")
                .ingot()
                .fluid()
                .color(0x72A0C1)
                .iconSet(MaterialIconSet.METALLIC)
                .element(EPElements.Orichalcum)
                .flags(MaterialFlags.GENERATE_PLATE, MaterialFlags.GENERATE_ROD, MaterialFlags.GENERATE_FRAME, MaterialFlags.GENERATE_GEAR)
                .blastTemp(9000, BlastProperty.GasTier.HIGH)
                .buildAndRegister();
        //  26005 Vibranium
        EPMaterials.Vibranium = new Material.Builder("vibranium")
                .ingot()
                .fluid()
                .plasma()
                .color(0xC880FF)
                .iconSet(MaterialIconSet.SHINY)
                .flags(MaterialFlags.GENERATE_PLATE, MaterialFlags.GENERATE_FOIL, MaterialFlags.GENERATE_FINE_WIRE, MaterialFlags.GENERATE_FRAME, GENERATE_COIL, MaterialFlags.GENERATE_BOLT_SCREW)
                .element(EPElements.Vibranium)
                .blastTemp(4852, BlastProperty.GasTier.HIGH)
                .buildAndRegister();
        //  26006 Adamantium
        EPMaterials.Adamantium = new Material.Builder("adamantium")
                .ingot()
                .fluid()
                .plasma()
                .color(0xFF0040)
                .iconSet(MaterialIconSet.METALLIC)
                .flags(MaterialFlags.GENERATE_PLATE, MaterialFlags.GENERATE_ROTOR, MaterialFlags.GENERATE_ROD, MaterialFlags.GENERATE_LONG_ROD, MaterialFlags.GENERATE_FRAME, MaterialFlags.GENERATE_GEAR, MaterialFlags.GENERATE_SMALL_GEAR, MaterialFlags.GENERATE_ROUND, MaterialFlags.GENERATE_SPRING, GENERATE_CURVED_PLATE)
                .element(EPElements.Adamantium)
                .blastTemp(5225, BlastProperty.GasTier.HIGH)
                .cableProperties(GTValues.VA[GTValues.UHV], 18, 9, false)
                .buildAndRegister();
        //  26007 Taranium
        EPMaterials.Taranium = new Material.Builder("taranium")
                .ingot()
                .fluid()
                .plasma()
                .color(0x4F404F)
                .iconSet(MaterialIconSet.METALLIC)
                .element(EPElements.Taranium)
                .flags(MaterialFlags.GENERATE_PLATE)
                .buildAndRegister();
        //  26008 Plutonium-244
        EPMaterials.Plutonium244 = new Material.Builder("plutonium_244")
                .ingot()
                .fluid()
                .color(0xF03232)
                .iconSet(MaterialIconSet.SHINY)
                .element(EPElements.Plutonium244)
                .buildAndRegister();
        //  26009 Metastable Oganesson
        EPMaterials.MetastableOganesson = new Material.Builder("metastable_oganesson")
                .ingot()
                .gas()
                .color(0xE61C24)
                .iconSet(MaterialIconSet.SHINY)
                .element(GTElements.Og)
                .flags(MaterialFlags.GENERATE_PLATE)
                .blastTemp(10380)
                .buildAndRegister();
        //  TODO Radium-Radon Mixture + Scandium-Titanium-50 Mixture -> Metastable Hassium
        //  26010 Metastable Hassium
        EPMaterials.MetastableHassium = new Material.Builder("metastable_hassium")
                .ingot()
                .fluid()
                .color(0x2D3A9D)
                .iconSet(MaterialIconSet.BRIGHT)
                .element(GTElements.Hs)
                .flags(MaterialFlags.GENERATE_ROD, MaterialFlags.GENERATE_PLATE)
                .blastTemp(11240, BlastProperty.GasTier.HIGHEST)
                .buildAndRegister();
        //  26011 Metastable Flerovium
        EPMaterials.MetastableFlerovium = new Material.Builder("metastable_flerovium")
                .ingot()
                .fluid()
                .color(0x521973)
                .iconSet(MaterialIconSet.SHINY)
                .element(GTElements.Fl)
                .flags(MaterialFlags.GENERATE_ROD)
                .buildAndRegister();
        //  26012 Cosmic Neutronium
        EPMaterials.CosmicNeutronium = new Material.Builder("cosmic_neutronium")
                .ingot()
                .fluid(FluidStorageKeys.LIQUID, new FluidBuilder().temperature(2000000000))
                .iconSet(CUSTOM_NEUTRONIUM)
                .flags(MaterialFlags.NO_SMELTING, MaterialFlags.NO_SMASHING, MaterialFlags.GENERATE_FINE_WIRE)
                .element(EPElements.CosmicNeutronium)
                .cableProperties(GTValues.V[GTValues.UIV], 256, 128, false)
                .buildAndRegister();
        //  26013 Degenerate Rhenium
//        DegenerateRhenium = new Material.Builder("degenerate_rhenium")
//                .dust()
//                .fluid(FluidStorageKeys.LIQUID, new FluidBuilder().temperature((int) V[UV]))
//                .plasma()
//                .color(0x6666FF)
//                .iconSet(CUSTOM_DEGENERATE_RHENIUM)
//                .element(GTElements.Rh)
//                .flags(GENERATE_PLATE)
//                .buildAndRegister()
//                .setFormula("§cR§de", false);
        //  26014 Infinity
        EPMaterials.Infinity = new Material.Builder("infinity")
                .ingot()
                .fluid(FluidStorageKeys.LIQUID, new FluidBuilder().temperature((int) GTValues.V[GTValues.UIV]))
                .iconSet(CUSTOM_INFINITY)
                .element(EPElements.Infinity)
                .blastTemp(12600, BlastProperty.GasTier.HIGHEST, GTValues.VA[GTValues.UHV], 5901)
                .flags(MaterialFlags.GENERATE_PLATE, MaterialFlags.GENERATE_ROD, MaterialFlags.GENERATE_LONG_ROD, MaterialFlags.GENERATE_RING, MaterialFlags.GENERATE_ROUND, MaterialFlags.GENERATE_BOLT_SCREW, MaterialFlags.GENERATE_FRAME, MaterialFlags.GENERATE_GEAR, MaterialFlags.GENERATE_SMALL_GEAR, MaterialFlags.GENERATE_FOIL, MaterialFlags.GENERATE_FINE_WIRE)
                .buildAndRegister();
        //  26015 Rhugnor
        EPMaterials.Rhugnor = new Material.Builder("rhugnor")
                .ingot()
                .fluid(FluidStorageKeys.LIQUID, new FluidBuilder().temperature((int) (GTValues.V[GTValues.UIV] - GTValues.V[GTValues.UV])))
                .color(0xBE00FF)
                .iconSet(MaterialIconSet.BRIGHT)
                .element(EPElements.Rhugnor)
                .blastTemp(12000, BlastProperty.GasTier.HIGHEST, GTValues.VA[GTValues.UHV], 3340)
                .flags(MaterialFlags.GENERATE_PLATE)
                .buildAndRegister();
        //  26016 Hypogen
//        Hypogen = new Material.Builder("hypogen")
//                .ingot()
//                .fluid(FluidStorageKeys.LIQUID, new FluidBuilder().temperature((int) (V[UXV] - V[LuV])))
//                .plasma()
//                .element(EPElements.Hypogen)
//                .color(0xDC784B)
//                .iconSet(CUSTOM_HYPOGEN)
//                .toolStats(ToolProperty.Builder.of(20.0F, 200.0F, 2000000, 200)
//                                       .unbreakable()
//                                       .enchantability(33)
//                                       .magnetic()
//                                       .enchantment(Enchantments.SHARPNESS, 10)
//                                       .enchantment(Enchantments.MOB_LOOTING, 5)
//                                       .enchantment(Enchantments.SWEEPING_EDGE, 3).build())
//                .flags(GENERATE_PLATE)
//                .buildAndRegister();
        //  26017 Californium-252
        EPMaterials.Californium252 = new Material.Builder("californium_252")
                .ingot()
                .fluid()
                .iconSet(MaterialIconSet.SHINY)
                .element(EPElements.Californium252)
                .color(GTMaterials.Californium.getMaterialRGB())
                .buildAndRegister();
        //  26018 Astral Titanium
        EPMaterials.AstralTitanium = new Material.Builder("astral_titanium")
                .ingot()
                .fluid()
                .plasma()
                .color(0xDCA0F0)
                .iconSet(MaterialIconSet.BRIGHT)
                //  TODO may be re-balance
                .blastTemp(12000, BlastProperty.GasTier.HIGHEST, GTValues.VA[GTValues.UHV])
                .element(EPElements.AstralTitanium)
                .flags(MaterialFlags.GENERATE_PLATE, MaterialFlags.GENERATE_FOIL)
                .buildAndRegister();
        //  26019 Celestial Tungsten
        EPMaterials.CelestialTungsten = new Material.Builder("celestial_tungsten")
                .ingot()
                .fluid()
                .plasma()
                .color(0x323232)
                .iconSet(MaterialIconSet.BRIGHT)
                //  TODO may be re-balance
                .blastTemp(12000, BlastProperty.GasTier.HIGHEST, GTValues.VA[GTValues.UHV])
                .element(EPElements.CelestialTungsten)
                .flags(MaterialFlags.GENERATE_PLATE, MaterialFlags.GENERATE_FOIL, MaterialFlags.GENERATE_ROD, MaterialFlags.GENERATE_BOLT_SCREW)
                .buildAndRegister();
        //  26020 Ytterbium-178
        EPMaterials.Ytterbium178 = new Material.Builder("ytterbium_178")
                .dust()
                .fluid()
                .color(GTMaterials.Ytterbium.getMaterialRGB())
                .iconSet(MaterialIconSet.SHINY)
                .element(EPElements.Ytterbium178)
                .buildAndRegister();
        //  26021 Ichorium
        EPMaterials.Ichorium = new Material.Builder("ichorium")
                .ingot()
                .fluid()
                .color(0xE5A559)
                .iconSet(MaterialIconSet.BRIGHT)
                .blastTemp(10800, BlastProperty.GasTier.HIGHEST, GTValues.VA[GTValues.UV])
                .element(EPElements.Ichorium)
                .flags(MaterialFlags.GENERATE_PLATE)
                .buildAndRegister();
        //  26022 Ichor Liquid
        EPMaterials.IchorLiquid = new Material.Builder("ichor_liquid")
                .fluid(FluidStorageKeys.LIQUID, new FluidBuilder().temperature(214748))
                .plasma()
                .color(0xE5A559)
                .element(EPElements.IchorLiquid)
                .buildAndRegister();
        //  26023 Crystal Matrix
        EPMaterials.CrystalMatrix = new Material.Builder("crystal_matrix")
                .ingot()
                .fluid(FluidStorageKeys.LIQUID, new FluidBuilder().temperature(660450))
                .color(0x70ecff)
                .iconSet(MaterialIconSet.BRIGHT)
                .element(EPElements.CrystalMatrix)
                .buildAndRegister();
        //  26024 Void Metal
        EPMaterials.VoidMetal = new Material.Builder("void_metal")
                .ingot()
                .fluid(FluidStorageKeys.LIQUID, new FluidBuilder().temperature(/*0*/1))
                .color(0x20142C)
                .iconSet(MaterialIconSet.DULL)
                .element(EPElements.VoidMetal)
                .buildAndRegister();
        //  26025 Mithril
        EPMaterials.Mithril = new Material.Builder("mithril")
                .ingot()
                .fluid(FluidStorageKeys.LIQUID, new FluidBuilder().temperature(4550))
                .plasma()
                .color(0x428fdb)
                .iconSet(MaterialIconSet.DULL)
                .blastTemp(10900, BlastProperty.GasTier.HIGHEST, GTValues.VA[GTValues.UHV])
                .element(EPElements.Mithril)
                .flags(MaterialFlags.GENERATE_PLATE, MaterialFlags.GENERATE_FOIL, MaterialFlags.GENERATE_FINE_WIRE)
                .buildAndRegister();
        //  26026 Bismuth-209
        EPMaterials.Bismuth209 = new Material.Builder("bismuth_209")
                .fluid()
                .color(GTMaterials.Bismuth.getMaterialRGB())
                .element(EPElements.Bismuth209)
                .buildAndRegister();
        //  26027 Lead-209
        EPMaterials.Lead209 = new Material.Builder("lead_209")
                .fluid()
                .color(GTMaterials.Lead.getMaterialRGB())
                .element(EPElements.Lead209)
                .buildAndRegister();
    }
}