package cn.gtcommunity.epimorphism.common.data.materials;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconSet;
import com.gregtechceu.gtceu.api.fluids.FluidBuilder;
import com.gregtechceu.gtceu.api.fluids.attribute.FluidAttributes;
import com.gregtechceu.gtceu.api.fluids.store.FluidStorageKeys;
import cn.gtcommunity.epimorphism.common.data.EPMaterials;
import com.gregtechceu.gtceu.common.data.GTMaterials;

public class EPOrganicChemistryMaterials {
    public static void register() {
        //  25000 Kapton-K
        EPMaterials.KaptonK = new Material.Builder("kapton_k")
                .ingot()
                .fluid()
                .color(16764498)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION, MaterialFlags.NO_SMASHING, MaterialFlags.NO_SMELTING, MaterialFlags.GENERATE_PLATE, MaterialFlags.GENERATE_FOIL)
                .components(GTMaterials.Carbon, 12, GTMaterials.Hydrogen, 12, GTMaterials.Nitrogen, 2, GTMaterials.Oxygen, 1)
                .buildAndRegister()
                .setFormula("(C7H2N2O4)(O(C6H4)2)", true);
        //  25001 Kapton-E
        EPMaterials.KaptonE = new Material.Builder("kapton_e")
                .ingot()
                .fluid()
                .color(16768908)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION, MaterialFlags.GENERATE_PLATE, MaterialFlags.NO_SMASHING, MaterialFlags.NO_SMELTING, MaterialFlags.GENERATE_FOIL)
                .components(GTMaterials.Carbon, 12, GTMaterials.Hydrogen, 12, GTMaterials.Nitrogen, 2, GTMaterials.Oxygen, 1)
                .buildAndRegister()
                .setFormula("O(C6H4NH2)2", true);
        //  25002  EDOT
        EPMaterials.Edot = new Material.Builder("edot")
                .fluid()
                .color(11665367)
                .components(GTMaterials.Carbon, 6, GTMaterials.Hydrogen, 6, GTMaterials.Oxygen, 2, GTMaterials.Sulfur, 1)
                .buildAndRegister();
        //  25003 Polystyrene
        EPMaterials.Polystyrene = new Material.Builder("polystyrene")
                .fluid()
                .color(14795458)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .components(GTMaterials.Carbon, 8, GTMaterials.Hydrogen, 8)
                .buildAndRegister();
        //  25004 PolystyreneSulfonate
        EPMaterials.PolystyreneSulfonate = new Material.Builder("polystyrene_sulfonate")
                .ingot()
                .fluid()
                .color(14777458)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION, MaterialFlags.GENERATE_PLATE)
                .components(GTMaterials.Carbon, 8, GTMaterials.Hydrogen, 8, GTMaterials.Sulfur, 1, GTMaterials.Oxygen, 3)
                .buildAndRegister();
        //  25005  PEDOT:PSS
        EPMaterials.PedotPSS = new Material.Builder("pedot_pss")
                .ingot()
                .fluid()
                .color(14771623)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION, MaterialFlags.GENERATE_FINE_WIRE)
                .components(EPMaterials.Edot, 1, EPMaterials.PolystyreneSulfonate, 1)
                .cableProperties(GTValues.V[GTValues.UHV], 24, 6, false)
                .buildAndRegister();
        //  25006  PMMA
        EPMaterials.PMMA = new Material.Builder("polymethylmethacrylate")
                .ingot()
                .fluid()
                .color(9554657)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION, MaterialFlags.NO_SMASHING, MaterialFlags.NO_SMELTING, MaterialFlags.GENERATE_PLATE)
                .components(GTMaterials.Carbon, 5, GTMaterials.Hydrogen, 8, GTMaterials.Oxygen, 2)
                .buildAndRegister();
        //  25007  PEDOT-TMA
        EPMaterials.PedotTMA = new Material.Builder("pedot_tma")
                .ingot()
                .fluid()
                .color(6201057)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION, MaterialFlags.GENERATE_ROD, MaterialFlags.GENERATE_SPRING, MaterialFlags.GENERATE_LONG_ROD, MaterialFlags.GENERATE_FINE_WIRE)
                .components(EPMaterials.Edot, 1, EPMaterials.PMMA, 2)
                .cableProperties(GTValues.V[GTValues.UEV], 8, 6)
                .buildAndRegister();
        //  25008 Tetramethylammonium Hydroxide
        EPMaterials.TetramethylammoniumHydroxide = new Material.Builder("tetramethylammonium_hydroxide")
                .fluid()
                .color(4259798)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .components(GTMaterials.Nitrogen, 1, GTMaterials.Carbon, 4, GTMaterials.Hydrogen, 12, GTMaterials.Oxygen, 1, GTMaterials.Hydrogen, 1)
                .buildAndRegister()
                .setFormula("N(CH3)4OH", true);
        //  25009 Potassium Hydroxide
        EPMaterials.PotassiumHydroxide = new Material.Builder("potassium_hydroxide")
                .dust()
                .fluid(FluidStorageKeys.LIQUID, new FluidBuilder().temperature(633))
                .color(0xFA9849)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .components(GTMaterials.Potassium, 1, GTMaterials.Oxygen, 1, GTMaterials.Hydrogen, 1)
                .buildAndRegister();
        //  25010 Potassium Bromate
        EPMaterials.PotassiumBromate = new Material.Builder("potassium_bromate")
                .dust()
                .color(0x782828)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .iconSet(MaterialIconSet.ROUGH)
                .components(GTMaterials.Potassium, 1, GTMaterials.Bromine, 1, GTMaterials.Oxygen, 3)
                .buildAndRegister();
        //  25011 Malonic Acid
        EPMaterials.MalonicAcid = new Material.Builder("malonic_acid")
                .dust()
                .color(0x61932E)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .iconSet(MaterialIconSet.SHINY)
                .components(GTMaterials.Carbon, 3, GTMaterials.Hydrogen, 4, GTMaterials.Oxygen, 4)
                .buildAndRegister();
        //  25012 Chloroacetic Acid
        EPMaterials.ChloroaceticAcid = new Material.Builder("chloroacetic_acid")
                .dust()
                .color(0x38541A)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .iconSet(MaterialIconSet.SHINY)
                .components(GTMaterials.Carbon, 2, GTMaterials.Hydrogen, 3, GTMaterials.Chlorine, 1, GTMaterials.Oxygen, 2)
                .buildAndRegister();
        //  25013 Trichloroethylene
        EPMaterials.Trichloroethylene = new Material.Builder("trichloroethylene")
                .fluid()
                .color(0xB685B1)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .components(GTMaterials.Carbon, 2, GTMaterials.Hydrogen, 1, GTMaterials.Chlorine, 3)
                .buildAndRegister();
        //  25014 Dichloroethane
        EPMaterials.Dichloroethane = new Material.Builder("dichloroethane")
                .fluid()
                .color(0xDAAED3)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .components(GTMaterials.Carbon, 2, GTMaterials.Hydrogen, 4, GTMaterials.Chlorine, 2)
                .buildAndRegister();
        //  25015 Hydrobromic Acid
        EPMaterials.HydrobromicAcid = new Material.Builder("hydrobromic_acid")
                .fluid(FluidStorageKeys.LIQUID, new FluidBuilder().attribute(FluidAttributes.ACID))
                .color(0x8D1212)
                .components(GTMaterials.Hydrogen, 1, GTMaterials.Bromine, 1)
                .buildAndRegister();
        //  25016 Butanediol
        EPMaterials.Butanediol = new Material.Builder("butanediol")
                .fluid()
                .color(0xAAC4DA)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .components(GTMaterials.Carbon, 4, GTMaterials.Hydrogen, 10, GTMaterials.Oxygen, 2)
                .buildAndRegister()
                .setFormula("C4H8(OH)2", true);
        //  25017 Diacetyl
        EPMaterials.Diacetyl = new Material.Builder( "diacetyl")
                .fluid()
                .color(0xF7FF65)
                .components(GTMaterials.Carbon, 4, GTMaterials.Hydrogen, 6, GTMaterials.Oxygen, 2)
                .buildAndRegister();
        //  25018 Ethylene Glycol
        EPMaterials.EthyleneGlycol = new Material.Builder("ethylene_glycol")
                .fluid()
                .color(0x286632)
                .components(GTMaterials.Carbon, 2, GTMaterials.Hydrogen, 6, GTMaterials.Oxygen, 2)
                .buildAndRegister()
                .setFormula("C2H4(OH)2", true);
        //  25019 Sulfur Dichloride
        EPMaterials.SulfurDichloride = new Material.Builder("sulfur_dichloride")
                .fluid()
                .color(0x761410)
                .components(GTMaterials.Sulfur, 1, GTMaterials.Chlorine, 2)
                .buildAndRegister();
        //  25020 Acetone Cyanohydrin
        EPMaterials.AcetoneCyanohydrin = new Material.Builder("acetone_cyanohydrin")
                .fluid()
                .color(0xA1FFD0)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .components(GTMaterials.Carbon, 4, GTMaterials.Hydrogen, 7, GTMaterials.Nitrogen, 1, GTMaterials.Oxygen, 1)
                .buildAndRegister();
        //  25021 Para Xylene
        EPMaterials.ParaXylene = new Material.Builder("para_xylene")
                .fluid()
                .color(0x666040)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .components(GTMaterials.Carbon, 8, GTMaterials.Hydrogen, 10)
                .buildAndRegister()
                .setFormula("C6H4(CH3)2", true);
        //  25022 Cycloparaphenylene
        EPMaterials.Cycloparaphenylene = new Material.Builder("cycloparaphenylene")
                .fluid()
                .color(0x60545A)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .components(GTMaterials.Carbon, 6, GTMaterials.Hydrogen, 4)
                .buildAndRegister();
        //  25023 Dichlorocyclooctadieneplatinium
        EPMaterials.Dichlorocyclooctadieneplatinium = new Material.Builder("dichlorocyclooctadieneplatinium")
                .dust()
                .color(0xD4E982)
                .iconSet(MaterialIconSet.BRIGHT)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .components(GTMaterials.Carbon, 8, GTMaterials.Hydrogen, 12, GTMaterials.Chlorine, 2, GTMaterials.Platinum, 1)
                .buildAndRegister()
                .setFormula("C8H12Cl2Pt", true);
        //  25024 Diiodobiphenyl
        EPMaterials.Diiodobiphenyl = new Material.Builder("diiodobiphenyl")
                .dust()
                .color(0x000C52)
                .iconSet(MaterialIconSet.METALLIC)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .components(GTMaterials.Carbon, 12, GTMaterials.Hydrogen, 8, GTMaterials.Iodine, 2)
                .buildAndRegister()
                .setFormula("C12H8I2", true);
        //  25025 Bipyridine
        EPMaterials.Bipyridine = new Material.Builder("bipyridine")
                .dust()
                .color(0x716449)
                .iconSet(MaterialIconSet.DULL)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .components(GTMaterials.Carbon, 10, GTMaterials.Hydrogen, 8, GTMaterials.Nitrogen, 2)
                .buildAndRegister()
                .setFormula("C10H8N2", true);
        //  25026 Palladium Bisdibenzylidieneacetone
        EPMaterials.PalladiumBisdibenzylidieneacetone = new Material.Builder("palladium_bisdibenzylidieneacetone")
                .dust()
                .color(0x996881)
                .iconSet(MaterialIconSet.METALLIC)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .components(GTMaterials.Carbon, 51, GTMaterials.Hydrogen, 42, GTMaterials.Oxygen, 3, GTMaterials.Palladium, 2)
                .buildAndRegister()
                .setFormula("C51H42O3Pd2", true);
        //  25027 1-Octene
        EPMaterials.Octene = new Material.Builder("1_octene")
                .fluid()
                .color(0x818022)
                .components(GTMaterials.Carbon, 8, GTMaterials.Hydrogen, 16)
                .buildAndRegister();
        //  25028 Acetylene
        EPMaterials.Acetylene = new Material.Builder("acetylene")
                .fluid()
                .color(0x959C60)
                .components(GTMaterials.Carbon, 2, GTMaterials.Hydrogen, 2)
                .buildAndRegister();
        //  25029 Cyclooctadiene
        EPMaterials.Cyclooctadiene = new Material.Builder("cyclooctadiene")
                .fluid()
                .color(0x40AC40)
                .components(GTMaterials.Carbon, 8, GTMaterials.Hydrogen, 12)
                .buildAndRegister();
        //  25030 Pyridine
        EPMaterials.Pyridine = new Material.Builder("pyridine")
                .fluid()
                .color(0x716449)
                .components(GTMaterials.Carbon, 10, GTMaterials.Hydrogen, 8, GTMaterials.Nitrogen, 2)
                .buildAndRegister();
        //  25031 Formaldehyde
        EPMaterials.Formaldehyde = new Material.Builder("formaldehyde")
                .fluid()
                .color(0x858F40)
                .components(GTMaterials.Carbon, 1, GTMaterials.Hydrogen, 2, GTMaterials.Oxygen, 1)
                .buildAndRegister();
        //  25032 Dibenzylideneacetone
        EPMaterials.Dibenzylideneacetone = new Material.Builder("dibenzylideneacetone")
                .fluid()
                .color(0xA44545)
                .components(GTMaterials.Carbon, 17, GTMaterials.Hydrogen, 14, GTMaterials.Oxygen, 1)
                .buildAndRegister();
        //  25033 Benzaldehyde
        EPMaterials.Benzaldehyde = new Material.Builder("benzaldehyde")
                .fluid()
                .color(0x957D53)
                .components(GTMaterials.Carbon, 7, GTMaterials.Hydrogen, 6, GTMaterials.Oxygen, 1)
                .buildAndRegister();
        //  25034 Benzoyl Chloride
        EPMaterials.BenzoylChloride = new Material.Builder("benzoyl_chloride")
                .fluid()
                .color(0xABE1FF)
                .components(GTMaterials.Carbon, 7, GTMaterials.Hydrogen, 5, GTMaterials.Chlorine, 1, GTMaterials.Oxygen, 1)
                .buildAndRegister();
        //  25035 Thionyl Chloride
        EPMaterials.ThionylChloride = new Material.Builder("thionyl_chloride")
                .fluid()
                .color(0xDBC2C2)
                .components(GTMaterials.Sulfur, 1, GTMaterials.Oxygen, 1, GTMaterials.Chlorine, 2)
                .buildAndRegister()
                .setFormula("SOCl2", true);
        //  25036 Polyetheretherketone (PEEK)
        EPMaterials.Polyetheretherketone = new Material.Builder("polyetheretherketone")
                .polymer()
                .color(0x45433D)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION, MaterialFlags.NO_SMASHING, MaterialFlags.NO_SMELTING, MaterialFlags.GENERATE_PLATE)
                .components(GTMaterials.Carbon, 20, GTMaterials.Hydrogen, 12, GTMaterials.Oxygen, 3)
                .buildAndRegister();
        //  25037 Difluorobenzophenone
        EPMaterials.Difluorobenzophenone = new Material.Builder("difluorobenzophenone")
                .dust()
                .color(0xC44DA5)
                .iconSet(MaterialIconSet.SHINY)
                .components(GTMaterials.Carbon, 13, GTMaterials.Hydrogen, 8, GTMaterials.Oxygen, 1, GTMaterials.Fluorine, 2)
                .buildAndRegister()
                .setFormula("(FC6H4)2CO", true);
        //  25038 Hydroquinone
        EPMaterials.Hydroquinone = new Material.Builder("hydroquinone")
                .fluid()
                .color(0x83251A)
                .components(GTMaterials.Carbon, 6, GTMaterials.Hydrogen, 6, GTMaterials.Oxygen, 2)
                .buildAndRegister()
                .setFormula("C6H4(OH)2", true);
        //  25039 Resorcinol
        EPMaterials.Resorcinol = new Material.Builder("resorcinol")
                .fluid()
                .color(0x9DA38D)
                .components(GTMaterials.Carbon, 6, GTMaterials.Hydrogen, 6, GTMaterials.Oxygen, 2)
                .buildAndRegister();
        //  25040 Fluorobenzene
        EPMaterials.Fluorobenzene = new Material.Builder("fluorobenzene")
                .fluid()
                .color(0x7CCA88)
                .components(GTMaterials.Carbon, 6, GTMaterials.Hydrogen, 5, GTMaterials.Fluorine, 1)
                .buildAndRegister();
        //  25041 Fluorotoluene
        EPMaterials.Fluorotoluene = new Material.Builder("fluorotoluene")
                .fluid()
                .color(0x6EC5B8)
                .components(GTMaterials.Carbon, 7, GTMaterials.Hydrogen, 7, GTMaterials.Fluorine, 1)
                .buildAndRegister();
        //  25042 Kevlar
        EPMaterials.Kevlar = new Material.Builder("kevlar")
                .polymer()
                .color(0xF0F078)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION, MaterialFlags.NO_SMASHING, MaterialFlags.NO_SMELTING, MaterialFlags.GENERATE_PLATE)
                .components(GTMaterials.Carbon, 14, GTMaterials.Hydrogen, 10, GTMaterials.Nitrogen, 2, GTMaterials.Oxygen, 2)
                .buildAndRegister()
                .setFormula("(C6H4)2(CO)2(NH)2", true);
        //  25043 Para Phenylenediamine
        EPMaterials.ParaPhenylenediamine = new Material.Builder("para_phenylenediamine")
                .dust()
                .color(0x4A8E7B)
                .iconSet(MaterialIconSet.ROUGH)
                .components(GTMaterials.Carbon, 6, GTMaterials.Hydrogen, 8, GTMaterials.Nitrogen, 2)
                .buildAndRegister()
                .setFormula("H2NC6H4NH2", true);
        //  25044 Terephthaloyl Chloride
        EPMaterials.TerephthaloylChloride = new Material.Builder("terephthaloyl_chloride")
                .dust()
                .color(0xFAC4DA)
                .iconSet(MaterialIconSet.SHINY)
                .components(GTMaterials.Carbon, 8, GTMaterials.Hydrogen, 4, GTMaterials.Oxygen, 2, GTMaterials.Chlorine, 2)
                .buildAndRegister()
                .setFormula("C6H4(COCl)2", true);
        //  25045 N-Methyl Pyrrolidone
        EPMaterials.NMethylPyrrolidone = new Material.Builder("n_methyl_pyrrolidone")
                .fluid()
                .color(0xA504D6)
                .components(GTMaterials.Carbon, 5, GTMaterials.Hydrogen, 9, GTMaterials.Nitrogen, 1, GTMaterials.Oxygen, 1)
                .buildAndRegister();
        //  25046 Nitroaniline
        EPMaterials.Nitroaniline = new Material.Builder("nitroaniline")
                .fluid()
                .color(0x2A6E68)
                .components(GTMaterials.Carbon, 6, GTMaterials.Hydrogen, 6, GTMaterials.Nitrogen, 2, GTMaterials.Oxygen, 2)
                .buildAndRegister()
                .setFormula("H2NC6H4NO2", true);
        //  25047 Durene
        EPMaterials.Durene = new Material.Builder("durene")
                .dust()
                .color(0x336040)
                .iconSet(MaterialIconSet.FINE)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .components(GTMaterials.Carbon, 10, GTMaterials.Hydrogen, 14)
                .buildAndRegister()
                .setFormula("C6H2(CH3)4", true);
        //  25048 Pyromellitic Dianhydride
        EPMaterials.PyromelliticDianhydride = new Material.Builder("pyromellitic_dianhydride")
                .dust()
                .color(0xF0EAD6)
                .iconSet(MaterialIconSet.ROUGH)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .components(GTMaterials.Carbon, 10, GTMaterials.Hydrogen, 2, GTMaterials.Oxygen, 6)
                .buildAndRegister()
                .setFormula("C6H2(C2O3)2", true);
        //  25049 Oxydianiline
        EPMaterials.Oxydianiline = new Material.Builder("oxydianiline")
                .dust()
                .color(0xF0E130)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .components(GTMaterials.Carbon, 12, GTMaterials.Hydrogen, 12, GTMaterials.Nitrogen, 2, GTMaterials.Oxygen, 1)
                .buildAndRegister()
                .setFormula("O(C6H4NH2)2", true);
        //  25050 Dimethylformamide
        EPMaterials.Dimethylformamide = new Material.Builder("dimethylformamide")
                .fluid()
                .color(0x42BDFF)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .components(GTMaterials.Carbon, 3, GTMaterials.Hydrogen, 7, GTMaterials.Nitrogen, 1, GTMaterials.Oxygen, 1)
                .buildAndRegister()
                .setFormula("(CH3)2NC(O)H", true);
        //  25051 Phthalic Anhydride
        EPMaterials.PhthalicAnhydride = new Material.Builder("phthalic_anhydride")
                .dust()
                .color(0xEEAAEE)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .components(GTMaterials.Carbon, 8, GTMaterials.Hydrogen, 4, GTMaterials.Oxygen, 3)
                .buildAndRegister()
                .setFormula("C6H4(CO)2O", true);
        //  25052 Biphenyl Tetracarboxylic Acid Dianhydride
        EPMaterials.BiphenylTetracarboxylicAcidDianhydride = new Material.Builder("biphenyl_tetracarboxylic_acid_dianhydride")
                .dust()
                .color(0xFF7F50)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .components(GTMaterials.Carbon, 16, GTMaterials.Hydrogen, 6, GTMaterials.Oxygen, 6)
                .buildAndRegister()
                .setFormula("(C8H3O3)2", true);
        //  25053 Bistrichloromethylbenzene
        EPMaterials.Bistrichloromethylbenzene = new Material.Builder("bistrichloromethylbenzene")
                .fluid()
                .color(0xCF8498)
                .components(GTMaterials.Carbon, 8, GTMaterials.Hydrogen, 4, GTMaterials.Chlorine, 6)
                .buildAndRegister()
                .setFormula("C6H4(CCl3)2", true);
        //  25054 Tetrabromoethane
        EPMaterials.Tetrabromoethane = new Material.Builder("tetrabromoethane")
                .fluid()
                .color(0x5AAADA)
                .components(GTMaterials.Carbon, 2, GTMaterials.Hydrogen, 2, GTMaterials.Bromine, 4)
                .buildAndRegister();
        //  25055 Terephthalic Acid
        EPMaterials.TerephthalicAcid = new Material.Builder("terephthalic_acid")
                .dust()
                .color(0x5ACCDA)
                .iconSet(MaterialIconSet.ROUGH)
                .components(GTMaterials.Carbon, 8, GTMaterials.Hydrogen, 6, GTMaterials.Oxygen, 4)
                .buildAndRegister()
                .setFormula("C6H4(CO2H)2", true);
        //  25056 γ-Butyrolactone
        EPMaterials.GammaButyrolactone = new Material.Builder("gamma_butyrolactone")
                .fluid()
                .color(0xAF04D6)
                .components(GTMaterials.Carbon, 4, GTMaterials.Hydrogen, 6, GTMaterials.Oxygen, 2)
                .buildAndRegister();
        //  25057 Methylamine
        EPMaterials.Methylamine = new Material.Builder("methylamine")
                .gas()
                .color(0xAA6600)
                .components(GTMaterials.Carbon, 1, GTMaterials.Hydrogen, 5, GTMaterials.Nitrogen, 1)
                .buildAndRegister()
                .setFormula("CH3NH2", true);
        //  25058 Trimethylaluminium
        EPMaterials.Trimethylaluminium = new Material.Builder("trimethylaluminium")
                .fluid()
                .color(0x6ECCFF)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .components(GTMaterials.Aluminium, 2, GTMaterials.Carbon, 6, GTMaterials.Hydrogen, 18)
                .buildAndRegister()
                .setFormula("Al2(CH3)6", true);
        //  25059 Trimethylgallium
        EPMaterials.Trimethylgallium = new Material.Builder("trimethylgallium")
                .fluid()
                .color(0x4F92FF)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .components(GTMaterials.Gallium, 1, GTMaterials.Carbon, 3, GTMaterials.Hydrogen, 9)
                .buildAndRegister()
                .setFormula("Ga(CH3)3", true);
        //  25060 Benzophenanthrenylacetonitrile
        EPMaterials.Benzophenanthrenylacetonitrile = new Material.Builder("benzophenanthrenylacetonitrile")
                .dust()
                .color(0xBB58E9)
                .iconSet(MaterialIconSet.ROUGH)
                .components(GTMaterials.Carbon, 20, GTMaterials.Hydrogen, 13, GTMaterials.Nitrogen, 1)
                .buildAndRegister();
        //  25061 Methylbenzophenanthrene
        EPMaterials.Methylbenzophenanthrene = new Material.Builder("methylbenzophenanthrene")
                .dust()
                .color(0xEA236B)
                .iconSet(MaterialIconSet.DULL)
                .components(GTMaterials.Carbon, 19, GTMaterials.Hydrogen, 14)
                .buildAndRegister();
        //  25062 Bromo Succinimide
        EPMaterials.BromoSuccinimide = new Material.Builder("bromo_succinimide")
                .dust()
                .color(0x00BF8C)
                .iconSet(MaterialIconSet.ROUGH)
                .components(GTMaterials.Carbon, 4, GTMaterials.Hydrogen, 4, GTMaterials.Bromine, 1, GTMaterials.Nitrogen, 1, GTMaterials.Oxygen, 2)
                .buildAndRegister();
        //  25063 Succinimide
        EPMaterials.Succinimide = new Material.Builder("succinimide")
                .dust()
                .color(0x1774B6)
                .iconSet(MaterialIconSet.ROUGH)
                .components(GTMaterials.Carbon, 4, GTMaterials.Hydrogen, 5, GTMaterials.Nitrogen, 1, GTMaterials.Oxygen, 2)
                .buildAndRegister();
        //  25064 Succinic Acid
        EPMaterials.SuccinicAcid = new Material.Builder("succinic_acid")
                .dust()
                .color(0x0C3A5B)
                .iconSet(MaterialIconSet.DULL)
                .components(GTMaterials.Carbon, 4, GTMaterials.Hydrogen, 6, GTMaterials.Oxygen, 4)
                .buildAndRegister();
        //  25065 Maleic Anhydride
        EPMaterials.MaleicAnhydride = new Material.Builder("maleic_anhydride")
                .fluid()
                .color(0x610C2F)
                .components(GTMaterials.Carbon, 4, GTMaterials.Hydrogen, 2, GTMaterials.Oxygen, 3)
                .buildAndRegister();
        //  25066 Naphthaldehyde
        EPMaterials.Naphthaldehyde = new Material.Builder("naphthaldehyde")
                .fluid()
                .color(0x00FFED)
                .components(GTMaterials.Carbon, 11, GTMaterials.Hydrogen, 8, GTMaterials.Oxygen, 1)
                .buildAndRegister()
                .setFormula("C10H7CHO", true);
        //  25067 Butanol
        EPMaterials.Butanol = new Material.Builder("butanol")
                .fluid()
                .color(0xC7AF2E)
                .components(GTMaterials.Carbon, 4, GTMaterials.Hydrogen, 10, GTMaterials.Oxygen, 1)
                .buildAndRegister()
                .setFormula("C4H9OH", true);
        //  25068 Bromobutane
        EPMaterials.Bromobutane = new Material.Builder("bromobutane")
                .fluid()
                .color(0xAE0E39)
                .components(GTMaterials.Carbon, 4, GTMaterials.Hydrogen, 9, GTMaterials.Bromine, 1)
                .buildAndRegister()
                .setFormula("CH3(CH2)3Br", true);
        //  25069 Cyanonaphthalene
        EPMaterials.Cyanonaphthalene = new Material.Builder("cyanonaphthalene")
                .dust()
                .color(0xDE992D)
                .iconSet(MaterialIconSet.DULL)
                .components(GTMaterials.Carbon, 11, GTMaterials.Hydrogen, 7, GTMaterials.Nitrogen, 1)
                .buildAndRegister();
        //  25070 Triphenylphosphine
        EPMaterials.Triphenylphosphine = new Material.Builder("triphenylphosphine")
                .dust()
                .color(0x8F2C6B)
                .iconSet(MaterialIconSet.BRIGHT)
                .components(GTMaterials.Carbon, 18, GTMaterials.Hydrogen, 15, GTMaterials.Phosphorus, 1)
                .buildAndRegister()
                .setFormula("(C6H5)3P", true);
        //  25071 Ethylanthraquinone
        EPMaterials.Ethylanthraquinone = new Material.Builder("ethylanthraquinone")
                .fluid()
                .color(0xCC865A)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .components(GTMaterials.Carbon, 16, GTMaterials.Hydrogen, 12, GTMaterials.Oxygen, 2)
                .buildAndRegister()
                .setFormula("C6H4(CO)2C6H3Et", true);
        //  25072 Ethylanthrahydroquinone
        EPMaterials.Ethylanthrahydroquinone = new Material.Builder("ethylanthrahydroquinone")
                .fluid()
                .color(0xAD531A)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .components(GTMaterials.Carbon, 16, GTMaterials.Hydrogen, 18, GTMaterials.Oxygen, 2)
                .buildAndRegister()
                .setFormula("C6H4(CH2OH)2C6H3Et", true);
        //  25073 Ethylenediamine
        EPMaterials.Ethylenediamine = new Material.Builder("ethylenediamine")
                .fluid()
                .color(0xD00ED0)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .components(GTMaterials.Carbon, 2, GTMaterials.Hydrogen, 8, GTMaterials.Nitrogen, 2)
                .buildAndRegister()
                .setFormula("C2H4(NH2)2", true);
        //  25074 Tetrasodium EDTA
        EPMaterials.TetrasodiumEDTA = new Material.Builder("tetrasodium_edta")
                .dust()
                .color(0x8890E0)
                .iconSet(MaterialIconSet.SHINY)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .components(GTMaterials.Carbon, 10, GTMaterials.Hydrogen, 12, GTMaterials.Nitrogen, 2, GTMaterials.Oxygen, 8, GTMaterials.Sodium, 4)
                .buildAndRegister();
        //  25075 EthylenediaminetetraaceticAcid
        EPMaterials.EthylenediaminetetraaceticAcid = new Material.Builder("ethylenediaminetetraacetic_acid")
                .dust()
                .fluid()
                .color(0x87E6D9)
                .iconSet(MaterialIconSet.ROUGH)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .components(GTMaterials.Carbon, 10, GTMaterials.Hydrogen, 16, GTMaterials.Nitrogen, 2, GTMaterials.Oxygen, 8)
                .buildAndRegister();
        //  25076 Tetramethylammonium Chloride
        EPMaterials.TetramethylammoniumChloride = new Material.Builder("tetramethylammonium_chloride")
                .dust()
                .color(0x27FF81)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .iconSet(MaterialIconSet.METALLIC)
                .components(GTMaterials.Carbon, 4, GTMaterials.Hydrogen, 12, GTMaterials.Nitrogen, 1, GTMaterials.Chlorine, 1)
                .buildAndRegister()
                .setFormula("N(CH3)4Cl", true);
        //  25077 Trimethylamine
        EPMaterials.Trimethylamine = new Material.Builder("trimethylamine")
                .gas()
                .color(0xBB7700)
                .components(GTMaterials.Carbon, 3, GTMaterials.Hydrogen, 9, GTMaterials.Nitrogen, 1)
                .buildAndRegister()
                .setFormula("(CH3)3N", true);
        //  25078 Pyrocatechol
        EPMaterials.Pyrocatechol = new Material.Builder("pyrocatechol")
                .dust()
                .color(0x784421)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .iconSet(MaterialIconSet.DULL)
                .components(GTMaterials.Carbon, 6, GTMaterials.Hydrogen, 6, GTMaterials.Oxygen, 2)
                .buildAndRegister();
        //  25079 Nitryl Fluoride
        EPMaterials.NitrylFluoride = new Material.Builder("nitryl_fluoride")
                .fluid()
                .color(0x8B7EFF)
                .components(GTMaterials.Nitrogen, 1, GTMaterials.Oxygen, 2, GTMaterials.Fluorine, 1)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  25080 Dimethylamine Hydrochloride
        EPMaterials.DimethylamineHydrochloride = new Material.Builder("dimethylamine_hydrochloride")
                .fluid()
                .color(0xE3EBDC)
                .components(GTMaterials.Dimethylamine, 1, GTMaterials.HydrochloricAcid, 1)
                .buildAndRegister()
                .setFormula("C2H8NCl", true);
        //  25081 Potassium Formate
        EPMaterials.PotassiumFormate = new Material.Builder("potassium_formate")
                .dust()
                .color(0x74B5A9)
                .components(GTMaterials.Carbon, 1, GTMaterials.Hydrogen, 3, GTMaterials.Oxygen, 1, GTMaterials.Potassium, 1)
                .buildAndRegister();
        //  25082 Diethyl Suflide
        EPMaterials.DiethylSuflide = new Material.Builder("diethyl_sulfide")
                .fluid()
                .color(0xFF7E4B)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .components(GTMaterials.Ethylene, 2, GTMaterials.Sulfur, 1)
                .buildAndRegister()
                .setFormula("(C2H5)2S", true);
        //  25083 Dimethylcadmium
        EPMaterials.Dimethylcadmium = new Material.Builder("dimethylcadmium")
                .fluid()
                .color(0x5C037F)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .components(GTMaterials.Carbon, 2, GTMaterials.Hydrogen, 6, GTMaterials.Cadmium, 1)
                .buildAndRegister()
                .setFormula("(CH3)2Cd", true);
        //  25084 BETS Perrhenate
        EPMaterials.BETSPerrhenate = new Material.Builder("bets_perrhenate")
                .dust()
                .color(0x98E993)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .iconSet(MaterialIconSet.SHINY)
                .components(GTMaterials.Rhenium, 1, GTMaterials.Carbon, 10, GTMaterials.Hydrogen, 8, GTMaterials.Sulfur, 4, GTMaterials.Selenium, 4, GTMaterials.Oxygen, 4)
                .buildAndRegister();
        //  25085 Bisethylenedithiotetraselenafulvalene
        EPMaterials.Bisethylenedithiotetraselenafulvalene = new Material.Builder("bisethylenedithiotetraselenafulvalene")
                .dust()
                .color(0x98E993)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .iconSet(MaterialIconSet.ROUGH)
                .components(GTMaterials.Carbon, 10, GTMaterials.Hydrogen, 8, GTMaterials.Sulfur, 4, GTMaterials.Selenium, 4)
                .buildAndRegister();
        //  25086 Lithiumthiinediselenide
        EPMaterials.Lithiumthiinediselenide = new Material.Builder("lithiumthiinediselenide")
                .dust()
                .color(0x689E64)
                .iconSet(MaterialIconSet.DULL)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .components(GTMaterials.Carbon, 4, GTMaterials.Hydrogen, 4, GTMaterials.Sulfur, 2, GTMaterials.Lithium, 2, GTMaterials.Selenium, 2)
                .buildAndRegister();
        //  25087 Cyclopentadienyl Titanium Trichloride
        EPMaterials.CyclopentadienylTitaniumTrichloride = new Material.Builder("cyclopentadienyl_titanium_trichloride")
                .dust()
                .color(0x752C7A)
                .iconSet(MaterialIconSet.BRIGHT)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .components(GTMaterials.Carbon, 10, GTMaterials.Hydrogen, 10, GTMaterials.Chlorine, 2, GTMaterials.Titanium, 1)
                .buildAndRegister()
                .setFormula("(C5H5)2Cl2Ti", true);
        //  25088 Propadiene
        EPMaterials.Propadiene = new Material.Builder("propadiene")
                .fluid()
                .color(0xBD8F61)
                .components(GTMaterials.Carbon, 3, GTMaterials.Hydrogen, 4)
                .buildAndRegister();
        //  25089 Barium Triflate
        EPMaterials.BariumTriflate = new Material.Builder("barium_triflate")
                .dust()
                .color(0xFFC183)
                .iconSet(MaterialIconSet.BRIGHT)
                .components(GTMaterials.Barium, 1, GTMaterials.Oxygen, 6, GTMaterials.Carbon, 2, GTMaterials.Fluorine, 6)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .buildAndRegister()
                .setFormula("Ba(OSO2CF3)2", true);
        //  25090 Scandium Triflate
        EPMaterials.ScandiumTriflate = new Material.Builder("scandium_triflate")
                .dust()
                .color(0xCC9999)
                .iconSet(MaterialIconSet.BRIGHT)
                .components(GTMaterials.Scandium, 1, GTMaterials.Oxygen, 9, GTMaterials.Carbon, 3, GTMaterials.Fluorine, 9)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .buildAndRegister()
                .setFormula("Sc(OSO2CF3)3", true);
        //  25091 Barium Triflate Solution
        EPMaterials.BariumTriflateSolution = new Material.Builder("barium_triflate_solution")
                .fluid()
                .color(0xFFC183)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .buildAndRegister()
                .setFormula("C2BaF6O6S2Hg(H2O)3", true);
        //  25092 Biperfluoromethanedisulfide
        EPMaterials.Biperfluoromethanedisulfide = new Material.Builder("biperfluoromethanedisulfide")
                .fluid()
                .color(0x849648)
                .components(GTMaterials.Carbon, 2, GTMaterials.Fluorine, 6, GTMaterials.Sulfur, 2)
                .buildAndRegister();
        //  25093 Butyl Lithium
        EPMaterials.ButylLithium = new Material.Builder("butyl_lithium")
                .fluid()
                .color(0x96F6DF)
                .components(GTMaterials.Carbon, 4, GTMaterials.Hydrogen, 9, GTMaterials.Lithium, 1)
                .buildAndRegister();
        //  25094 Bromodihydrothiine
        EPMaterials.Bromodihydrothiine = new Material.Builder("bromodihydrothiine")
                .fluid()
                .color(0x66F36E)
                .components(GTMaterials.Carbon, 4, GTMaterials.Hydrogen, 4, GTMaterials.Sulfur, 2, GTMaterials.Bromine, 2)
                .buildAndRegister();
        //  25095 Chloroethane
        EPMaterials.Chloroethane = new Material.Builder("chloroethane")
                .fluid()
                .color(0xA55D80)
                .components(GTMaterials.Carbon, 2, GTMaterials.Hydrogen, 5, GTMaterials.Chlorine, 1)
                .buildAndRegister();
        //  25096 Dibromoacrolein
        EPMaterials.Dibromoacrolein = new Material.Builder("dibromoacrolein")
                .fluid()
                .color(0x7C4660)
                .components(GTMaterials.Carbon, 2, GTMaterials.Hydrogen, 2, GTMaterials.Bromine, 2, GTMaterials.Oxygen, 2)
                .buildAndRegister();
        //  25097 Formic Acid
        EPMaterials.FormicAcid = new Material.Builder("formic_acid")
                .fluid()
                .color(0xFFAA77)
                .components(GTMaterials.Carbon, 1, GTMaterials.Hydrogen, 2, GTMaterials.Oxygen, 2)
                .buildAndRegister();
        //  25098 Sodium Formate
        EPMaterials.SodiumFormate = new Material.Builder("sodium_formate")
                .fluid()
                .color(0x416CC0)
                .iconSet(MaterialIconSet.ROUGH)
                .components(GTMaterials.Carbon, 1, GTMaterials.Hydrogen, 1, GTMaterials.Oxygen, 2, GTMaterials.Sodium, 1)
                .buildAndRegister();
        //  25099 Ethylhexanol
        EPMaterials.Ethylhexanol = new Material.Builder("ethylhexanol")
                .fluid()
                .color(0xFEEA9A)
                .components(GTMaterials.Carbon, 8, GTMaterials.Hydrogen, 10, GTMaterials.Oxygen, 1)
                .buildAndRegister();
        //  25100 Diethylhexyl Phosphoric Acid
        EPMaterials.DiethylhexylPhosphoricAcid = new Material.Builder("diethylhexyl_phosphoric_acid")
                .fluid()
                .color(0xFFFF99)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .components(GTMaterials.Carbon, 16, GTMaterials.Hydrogen, 35, GTMaterials.Oxygen, 4, GTMaterials.Phosphorus, 1)
                .buildAndRegister()
                .setFormula("(C8H7O)2PO2H", true);
        //  25101 Dichloromethane
        EPMaterials.Dichloromethane = new Material.Builder("dichloromethane")
                .fluid()
                .color(0xB87FC7)
                .components(GTMaterials.Carbon, 1, GTMaterials.Hydrogen, 2, GTMaterials.Chlorine, 2)
                .buildAndRegister();
        //  25102 Tributylamine
        EPMaterials.Tributylamine = new Material.Builder("tributylamine")
                .fluid()
                .color(0x801a80)
                .components(GTMaterials.Carbon, 12, GTMaterials.Hydrogen, 27, GTMaterials.Nitrogen, 1)
                .buildAndRegister()
                .setFormula("(C4H9)3N", true);
        //  25103 Zylon
        EPMaterials.Zylon = new Material.Builder("zylon")
                .polymer()
                .color(0xFFE000)
                .iconSet(MaterialIconSet.SHINY)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION, MaterialFlags.NO_SMASHING, MaterialFlags.NO_SMELTING, MaterialFlags.GENERATE_PLATE, MaterialFlags.GENERATE_FOIL)
                .components(GTMaterials.Carbon, 14, GTMaterials.Hydrogen, 6, GTMaterials.Nitrogen, 2, GTMaterials.Oxygen, 2)
                .buildAndRegister();
        //  25104 Pre Zylon
        EPMaterials.PreZylon = new Material.Builder("pre_zylon")
                .dust()
                .color(0x623250)
                .iconSet(MaterialIconSet.DULL)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION, MaterialFlags.NO_SMASHING, MaterialFlags.NO_SMELTING)
                .components(GTMaterials.Carbon, 20, GTMaterials.Hydrogen, 22, GTMaterials.Nitrogen, 2, GTMaterials.Oxygen, 2)
                .buildAndRegister();
        //  25105 Terephthalaldehyde
        EPMaterials.Terephthalaldehyde = new Material.Builder("terephthalaldehyde")
                .dust()
                .color(0x567C2D)
                .iconSet(MaterialIconSet.ROUGH)
                .components(GTMaterials.Carbon, 8, GTMaterials.Hydrogen, 6, GTMaterials.Oxygen, 2)
                .buildAndRegister();
        //  25106 Dibromomethylbenzene
        EPMaterials.Dibromomethylbenzene = new Material.Builder("dibromomethylbenzene")
                .fluid()
                .color(0x9F4839)
                .components(GTMaterials.Carbon, 7, GTMaterials.Hydrogen, 6, GTMaterials.Bromine, 2)
                .buildAndRegister();
        //  25107 Isochloropropane
        EPMaterials.Isochloropropane = new Material.Builder("isochloropropane")
                .fluid()
                .color(0xC3AC65)
                .components(GTMaterials.Carbon, 3, GTMaterials.Hydrogen, 7, GTMaterials.Chlorine, 1)
                .buildAndRegister()
                .setFormula("CH3CHClCH3", true);
        //  25108 Dinitrodipropanyloxybenzene
        EPMaterials.Dinitrodipropanyloxybenzene = new Material.Builder("dinitrodipropanyloxybenzene")
                .fluid()
                .color(0x9FAD1D)
                .components(GTMaterials.Carbon, 12, GTMaterials.Hydrogen, 16, GTMaterials.Oxygen, 6, GTMaterials.Nitrogen, 2)
                .buildAndRegister()
                .setFormula("C12H16O2(NO2)2", true);
        //  25109 Hexanitrohexaaxaisowurtzitane
        EPMaterials.Hexanitrohexaaxaisowurtzitane = new Material.Builder("hexanitrohexaaxaisowurtzitane")
                .dust()
                .color(0x0B7222)
                .iconSet(MaterialIconSet.BRIGHT)
                .components(GTMaterials.Carbon, 6, GTMaterials.Hydrogen, 6, GTMaterials.Nitrogen, 12, GTMaterials.Oxygen, 12)
                .buildAndRegister();
        //  25110 Crude Hexanitrohexaaxaisowurtzitane
        EPMaterials.CrudeHexanitrohexaaxaisowurtzitane = new Material.Builder("crude_hexanitrohexaaxaisowurtzitane")
                .dust()
                .color(0x5799EC)
                .iconSet(MaterialIconSet.DULL)
                .components(GTMaterials.Carbon, 6, GTMaterials.Hydrogen, 6, GTMaterials.Nitrogen, 12, GTMaterials.Oxygen, 12)
                .buildAndRegister();
        //  25111 Tetraacetyldinitrosohexaazaisowurtzitane
        EPMaterials.Tetraacetyldinitrosohexaazaisowurtzitane = new Material.Builder("tetraacetyldinitrosohexaazaisowurtzitane")
                .dust()
                .color(0xEA7584)
                .iconSet(MaterialIconSet.ROUGH)
                .components(GTMaterials.Carbon, 14, GTMaterials.Hydrogen, 18, GTMaterials.Nitrogen, 8, GTMaterials.Oxygen, 6)
                .buildAndRegister();
        //  25112 Dibenzyltetraacetylhexaazaisowurtzitane
        EPMaterials.Dibenzyltetraacetylhexaazaisowurtzitane = new Material.Builder("dibenzyltetraacetylhexaazaisowurtzitane")
                .dust()
                .color(0xB7E8EE)
                .iconSet(MaterialIconSet.DULL)
                .components(GTMaterials.Carbon, 28, GTMaterials.Hydrogen, 32, GTMaterials.Nitrogen, 6, GTMaterials.Oxygen, 4)
                .buildAndRegister();
        //  25113 Succinimidyl Acetate
        EPMaterials.SuccinimidylAcetate = new Material.Builder("succinimidyl_acetate")
                .dust()
                .color(0x1D3605)
                .iconSet(MaterialIconSet.ROUGH)
                .components(GTMaterials.Carbon, 6, GTMaterials.Hydrogen, 7, GTMaterials.Nitrogen, 1, GTMaterials.Oxygen, 4)
                .buildAndRegister();
        //  25114 N-Hydroxysuccinimide
        EPMaterials.NHydroxysuccinimide = new Material.Builder("n_hydroxysuccinimide")
                .dust()
                .color(0x33BAFB)
                .iconSet(MaterialIconSet.DULL)
                .components(GTMaterials.Carbon, 4, GTMaterials.Hydrogen, 5, GTMaterials.Nitrogen, 1, GTMaterials.Oxygen, 3)
                .buildAndRegister()
                .setFormula("(CH2CO)2NOH", true);
        //  25115 Tetrahydrofuran
        EPMaterials.Tetrahydrofuran = new Material.Builder("tetrahydrofuran")
                .fluid()
                .color(0x0BCF52)
                .components(GTMaterials.Carbon, 4, GTMaterials.Hydrogen, 8, GTMaterials.Oxygen, 1)
                .buildAndRegister()
                .setFormula("(CH2)4O", true);
        //  25116 Succinic Anhydride
        EPMaterials.SuccinicAnhydride = new Material.Builder("succinic_anhydride")
                .dust()
                .color(0xA2569D)
                .components(GTMaterials.Carbon, 4, GTMaterials.Hydrogen, 4, GTMaterials.Oxygen, 3)
                .buildAndRegister()
                .setFormula("(CH2CO)2O");
        //  25117 Hexabenzylhexaazaisowurtzitane
        EPMaterials.Hexabenzylhexaazaisowurtzitane = new Material.Builder("hexabenzylhexaazaisowurtzitane")
                .dust()
                .color(0x48561E)
                .iconSet(MaterialIconSet.DULL)
                .components(GTMaterials.Carbon, 48, GTMaterials.Hydrogen, 48 , GTMaterials.Nitrogen, 6)
                .buildAndRegister();
        //  25118 Acetonitrile
        EPMaterials.Acetonitrile = new Material.Builder("acetonitrile")
                .dust()
                .color(0x7D82A3)
                .iconSet(MaterialIconSet.ROUGH)
                .components(GTMaterials.Carbon, 2, GTMaterials.Hydrogen, 3, GTMaterials.Nitrogen, 1)
                .buildAndRegister()
                .setFormula("CH3CN");
        //  25119 Acetamide
        EPMaterials.Acetamide = new Material.Builder("acetamide")
                .dust()
                .color(0x7D82A3)
                .iconSet(MaterialIconSet.DULL)
                .components(GTMaterials.Carbon, 2, GTMaterials.Hydrogen, 5, GTMaterials.Nitrogen, 1, GTMaterials.Oxygen, 1)
                .buildAndRegister()
                .setFormula("CH3CONH2", true);
        //  25120 Benzylamine
        EPMaterials.Benzylamine = new Material.Builder("benzylamine")
                .fluid()
                .color(0x527A92)
                .components(GTMaterials.Carbon, 7, GTMaterials.Hydrogen, 9, GTMaterials.Nitrogen, 1)
                .buildAndRegister();
        //  25121 Benzyl Chloride
        EPMaterials.BenzylChloride = new Material.Builder("benzyl_chloride")
                .fluid()
                .color(0x6699CC)
                .components(GTMaterials.Carbon, 7, GTMaterials.Hydrogen, 7, GTMaterials.Chlorine, 1)
                .buildAndRegister();
        //  25122 Hexamethylenetetramine
        EPMaterials.Hexamethylenetetramine = new Material.Builder("hexamethylenetetramine")
                .dust()
                .color(0x53576D)
                .iconSet(MaterialIconSet.DULL)
                .components(GTMaterials.Carbon, 6, GTMaterials.Hydrogen, 12, GTMaterials.Nitrogen, 4)
                .buildAndRegister()
                .setFormula("(CH2)6N4", true);
        //  25123 Dimethyl Carbonate
        EPMaterials.DimethylCarbonate = new Material.Builder("dimethyl_carbonate")
                .fluid()
                .color(0xC5EB9E)
                .components(GTMaterials.Carbon, 3, GTMaterials.Hydrogen, 6, GTMaterials.Oxygen, 3)
                .buildAndRegister()
                .setFormula("(CH3O)2CO", true);
        //  25124 Diphenyl Carbonate
        EPMaterials.DiphenylCarbonate = new Material.Builder("diphenyl_carbonate")
                .fluid()
                .color(EPMaterials.DimethylCarbonate.getMaterialRGB() + GTMaterials.Benzene.getMaterialRGB())
                .components(GTMaterials.Carbon, 13, GTMaterials.Hydrogen, 10, GTMaterials.Oxygen, 3)
                .buildAndRegister();
        //  25125 BPA Polycarbonate
        EPMaterials.BPAPolycarbonate = new Material.Builder("bpa_polycarbonate")
                .ingot()
                .fluid()
                .color(0xE3EBDA)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION, MaterialFlags.NO_SMASHING, MaterialFlags.NO_SMELTING, MaterialFlags.GENERATE_PLATE)
                .components(GTMaterials.Carbon, 16, GTMaterials.Hydrogen, 14, GTMaterials.Oxygen, 3)
                .buildAndRegister();
        //  25126 Isobutyric Acid
        EPMaterials.IsobutyricAcid = new Material.Builder("isobutyric_acid")
                .fluid()
                .color(GTMaterials.Propene.getMaterialRGB() + EPMaterials.Propadiene.getMaterialRGB())
                .components(GTMaterials.Carbon, 4, GTMaterials.Hydrogen, 8, GTMaterials.Oxygen, 2)
                .buildAndRegister();
        //  25127 Isobutyric Anhydride
        EPMaterials.IsobutyricAnhydride = new Material.Builder("isobutyric_anhydride")
                .fluid()
                .color(EPMaterials.IsobutyricAcid.getMaterialRGB()/* - AceticAnhydride.getMaterialRGB()*/)
                .components(GTMaterials.Carbon, 8, GTMaterials.Hydrogen, 14, GTMaterials.Oxygen, 3)
                .buildAndRegister();
        //  25128 Dimethylketene
        EPMaterials.Dimethylketene = new Material.Builder("dimethylketene")
                .fluid()
                .color(0x0925BE)
                .components(GTMaterials.Carbon, 4, GTMaterials.Hydrogen, 6, GTMaterials.Oxygen, 2)
                .buildAndRegister();
        //  25129 Tetramethylcyclobutanediol
        EPMaterials.Tetramethylcyclobutanediol = new Material.Builder("tetramethylcyclobutanediol")
                .fluid()
                .color(EPMaterials.Dimethylketene.getMaterialRGB() + GTMaterials.Hydrogen.getMaterialRGB())
                .components(GTMaterials.Carbon, 8, GTMaterials.Hydrogen, 16, GTMaterials.Oxygen, 2)
                .buildAndRegister();
        //  25130 CBDO Polycarbonate
        EPMaterials.CBDOPolycarbonate = new Material.Builder("cbdo_polycarbonate")
                .ingot()
                .fluid()
                .color(0xDFDFDF)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION, MaterialFlags.NO_SMASHING, MaterialFlags.NO_SMELTING, MaterialFlags.GENERATE_PLATE)
                .components(GTMaterials.Carbon, 9, GTMaterials.Hydrogen, 14, GTMaterials.Oxygen, 3)
                .buildAndRegister();
        //  25131 Nitrile Butadiene Rubber
        EPMaterials.NitrileButadieneRubber = new Material.Builder("nitrile_butadiene_rubber")
                .fluid(FluidStorageKeys.LIQUID, new FluidBuilder().temperature(433))
                .polymer()
                .color(0x211A18)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION, MaterialFlags.GENERATE_PLATE, MaterialFlags.GENERATE_RING)
                .components(GTMaterials.Carbon, 7, GTMaterials.Hydrogen, 9, GTMaterials.Nitrogen, 1)
                .buildAndRegister();
        //  25132 Poly (Phosphonitrile Fluoro) Rubber
        EPMaterials.PolyPhosphonitrileFluoroRubber = new Material.Builder("poly_phosphonitrile_fluoro_rubber")
                .polymer()
                .color(0x372B28)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION, MaterialFlags.GENERATE_PLATE, MaterialFlags.GENERATE_RING)
                .components(GTMaterials.Carbon, 24, GTMaterials.Hydrogen, 16, GTMaterials.Oxygen, 8, GTMaterials.Nitrogen, 4, GTMaterials.Phosphorus, 4, GTMaterials.Fluorine, 40)
                .buildAndRegister();
        //  25133 Acrylonitrile
        EPMaterials.Acrylonitrile = new Material.Builder("acrylonitrile")
                .fluid()
                .color(GTMaterials.Propene.getMaterialRGB())
                .components(GTMaterials.Carbon, 3, GTMaterials.Hydrogen, 3, GTMaterials.Nitrogen, 1)
                .buildAndRegister();
        //  25134 Phosphonitrilic Chloride Trimer
        EPMaterials.PhosphonitrilicChlorideTrimer = new Material.Builder("phosphonitrilic_chloride_trimer")
                .fluid()
                .color(0x082C38)
                .components(GTMaterials.Chlorine, 6, GTMaterials.Nitrogen, 3, GTMaterials.Phosphorus, 3)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  25135 Sodium Trifluoroethanolate
        EPMaterials.SodiumTrifluoroethanolate = new Material.Builder("sodium_trifluoroethanolate")
                .dust()
                .color(0x50083E)
                .iconSet(MaterialIconSet.ROUGH)
                .components(GTMaterials.Carbon, 2, GTMaterials.Hydrogen, 4, GTMaterials.Fluorine, 3, GTMaterials.Sodium, 1, GTMaterials.Oxygen, 1)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  25136 Octafluoro Pentanol
        EPMaterials.OctafluoroPentanol = new Material.Builder("octafluoro_pentanol")
                .fluid()
                .color(0xE5EBDE)
                .components(GTMaterials.Carbon, 5, GTMaterials.Hydrogen, 4, GTMaterials.Fluorine, 8, GTMaterials.Oxygen, 1)
                .buildAndRegister();
        //  25137 Tributyl Phosphate
        EPMaterials.TributylPhosphate = new Material.Builder("tributyl_phosphate")
                .fluid()
                .color(0xBED323)
                .components(GTMaterials.Carbon, 12, GTMaterials.Hydrogen, 27, GTMaterials.Phosphorus, 1, GTMaterials.Oxygen, 4)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .buildAndRegister()
                .setFormula("(C4H9)3PO4", true);
        //  25138 Methyl Isobutyl Ketone
        EPMaterials.MethylIsobutylKetone = new Material.Builder("methyl_isobutyl_ketone")
                .fluid()
                .color(0x2F5687)
                .components(GTMaterials.Carbon, 6, GTMaterials.Hydrogen, 12, GTMaterials.Oxygen, 1)
                .buildAndRegister();
        //  25139 tbp_mibk_solution
        EPMaterials.TBPMIBKSolution = new Material.Builder("tbp_mibk_solution")
                .fluid()
                .color(EPMaterials.TributylPhosphate.getMaterialRGB() + EPMaterials.MethylIsobutylKetone.getMaterialRGB())
                .components(EPMaterials.TributylPhosphate, 1, EPMaterials.MethylIsobutylKetone, 1)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  25140 Mesityl Oxide
        EPMaterials.MesitylOxide = new Material.Builder("mesityl_oxide")
                .fluid()
                .color(0x783E50)
                .components(GTMaterials.Carbon, 6, GTMaterials.Hydrogen, 10, GTMaterials.Oxygen, 1)
                .buildAndRegister();
        //  25141 Electrolyte Reflector Mixture
        EPMaterials.ElectrolyteReflectorMixture = new Material.Builder("electrolyte_reflector_mixture")
                .fluid(FluidStorageKeys.LIQUID, new FluidBuilder().temperature(209))
                .color(0xE62A35)
                .components(EPMaterials.ManganeseDifluoride, 1, GTMaterials.ZincSulfide, 1, EPMaterials.TantalumPentoxide, 1, GTMaterials.Rutile, 1, GTMaterials.Ethanol, 1)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  25142 Ethylene Dibromide
        EPMaterials.EthyleneDibromide = new Material.Builder("ethylene_dibromide")
                .fluid()
                .color(0x4F1743)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .components(GTMaterials.Carbon, 2, GTMaterials.Hydrogen, 4, GTMaterials.Bromine, 2)
                .buildAndRegister();
        //  25143 Grignard Reagent
        EPMaterials.GrignardReagent = new Material.Builder("grignard_reagent")
                .fluid()
                .color(0xA12AA1)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .components(GTMaterials.Carbon, 1, GTMaterials.Hydrogen, 3, GTMaterials.Magnesium, 1, GTMaterials.Bromine, 1)
                .buildAndRegister();
        //  25144 Fluorocarborane
        EPMaterials.Fluorocarborane = new Material.Builder("fluorocarborane")
                .dust()
                .color(0x59B35C)
                .iconSet(MaterialIconSet.BRIGHT)
                .components(GTMaterials.Carbon, 1, GTMaterials.Hydrogen, 2, GTMaterials.Boron, 11, GTMaterials.Fluorine, 11)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .buildAndRegister()
                .setFormula("HCHB11F11", true);
        //  25145 Perfluorobenzene
        EPMaterials.Perfluorobenzene = new Material.Builder("perfluorobenzene")
                .fluid()
                .color(0x39733B)
                .components(GTMaterials.Carbon, 6, GTMaterials.Fluorine, 6)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  25146 Trimethylsilane
        EPMaterials.Trimethylsilane = new Material.Builder("trimethylsilane")
                .fluid()
                .color(0xB366B0)
                .components(GTMaterials.Carbon, 3, GTMaterials.Hydrogen, 10, GTMaterials.Silicon, 1)
                .buildAndRegister();
        //  25147 Trimethylchlorosilane
        EPMaterials.Trimethylchlorosilane = new Material.Builder("trimethylchlorosilane")
                .fluid()
                .color(0x864D84)
                .components(GTMaterials.Carbon, 9, GTMaterials.Hydrogen, 9, GTMaterials.Silicon, 1, GTMaterials.Chlorine, 1)
                .buildAndRegister()
                .setFormula("(CH3)3SiCl", true);
        //  25148 Caesium Carborane Precursor
        EPMaterials.CaesiumCarboranePrecursor = new Material.Builder("caesium_carborane_precursor")
                .dust()
                .color(EPMaterials.CaesiumCarborane.getMaterialRGB())
                .iconSet(MaterialIconSet.SAND)
                .components(GTMaterials.Caesium, 1, GTMaterials.Boron, 10, GTMaterials.Hydrogen, 21, GTMaterials.Carbon, 4, GTMaterials.Nitrogen, 1, GTMaterials.Chlorine, 1)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .buildAndRegister()
                .setFormula("CsB10H12CN(CH3)3Cl", true);
        //  25149 Borane Dimethylsulfide
        EPMaterials.BoraneDimethylsulfide = new Material.Builder("borane_dimethylsulfide")
                .fluid()
                .color(GTMaterials.Lead.getMaterialRGB() + GTMaterials.Boron.getMaterialRGB())
                .components(GTMaterials.Caesium, 1, GTMaterials.Carbon, 1, GTMaterials.Boron, 11, GTMaterials.Hydrogen, 12)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  25150 Decaborane
        EPMaterials.Decaborane = new Material.Builder("decaborane")
                .dust()
                .color(0x4C994F)
                .iconSet(MaterialIconSet.ROUGH)
                .components(GTMaterials.Boron, 10, GTMaterials.Hydrogen, 14)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  25151 Diethyl Ether
        EPMaterials.DiethylEther = new Material.Builder("diethyl_ether")
                .fluid()
                .color(0xFFA4A3)
                .components(GTMaterials.Carbon, 4, GTMaterials.Hydrogen, 10, GTMaterials.Oxygen, 1)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .buildAndRegister()
                .setFormula("(C2H5)2O", true);
        //  25152 Boron Trifluoride Etherate
        EPMaterials.BoronTrifluorideEtherate = new Material.Builder("boron_trifluoride_etherate")
                .fluid()
                .color(0xBF6E6E)
                .components(GTMaterials.Boron, 1, GTMaterials.Fluorine, 3, GTMaterials.Carbon, 4, GTMaterials.Hydrogen, 7, GTMaterials.Oxygen, 1)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .buildAndRegister()
                .setFormula("(BF3)(C2H5)2O", true);
        //  25153 Dimethyl Sulfide
        EPMaterials.DimethylSulfide = new Material.Builder("dimethyl_sulfide")
                .fluid()
                .color(GTMaterials.SulfuricAcid.getMaterialRGB() + GTMaterials.Methanol.getMaterialRGB())
                .components(GTMaterials.Carbon, 2, GTMaterials.Hydrogen, 6, GTMaterials.Sulfur, 1)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .buildAndRegister()
                .setFormula("(CH3)2S", true);
        //  25154 Oxalic Acid
        EPMaterials.OxalicAcid = new Material.Builder("oxalic_acid")
                .fluid()
                .color(0xC5EB9E)
                .components(GTMaterials.Carbon, 2, GTMaterials.Hydrogen, 2, GTMaterials.Oxygen, 4)
                .buildAndRegister()
                .setFormula("HOOCCOOH", false);
        //  25155 Glucose
        EPMaterials.Glucose = new Material.Builder("glucose")
                .dust()
                .color(0xE3E3E3)
                .iconSet(MaterialIconSet.SAND)
                .components(GTMaterials.Carbon, 6, GTMaterials.Hydrogen, 12, GTMaterials.Oxygen, 6)
                .buildAndRegister();
        //  25156 Fructose
        EPMaterials.Fructose = new Material.Builder("fructose")
                .dust()
                .color(0xE3E3E3)
                .iconSet(MaterialIconSet.SAND)
                .components(GTMaterials.Carbon, 6, GTMaterials.Hydrogen, 12, GTMaterials.Oxygen, 6)
                .buildAndRegister();
        //  25157 Hexafluoropropylene
        EPMaterials.Hexafluoropropylene = new Material.Builder("hexafluoropropylene")
                .fluid()
                .color(0x141D6F)
                .components(GTMaterials.Carbon, 3, GTMaterials.Fluorine, 6)
                .buildAndRegister();
        //  25158 Fluorinated Ethylene Propylene
        EPMaterials.FluorinatedEthylenePropylene = new Material.Builder("fluorinated_ethylene_propylene")
                .polymer()
                .color(0xC8C8C8)
                .iconSet(MaterialIconSet.DULL)
                .components(GTMaterials.Carbon, 5, GTMaterials.Fluorine, 10)
                .buildAndRegister();
        //  25159 Polycyclic Aromatic Mixture
        EPMaterials.PolycyclicAromaticMixture = new Material.Builder("polycyclic_aromatic_mixture")
                .dust()
                .color(0x95A36C)
                .iconSet(MaterialIconSet.ROUGH)
                .components(GTMaterials.Carbon, 18, GTMaterials.Hydrogen, 12)
                .buildAndRegister();
        //  25160 Anthracene
        EPMaterials.Anthracene = new Material.Builder("anthracene")
                .fluid()
                .color(0xCCCC99)
                .components(GTMaterials.Carbon, 14, GTMaterials.Hydrogen, 10)
                .buildAndRegister();
        //  25161 Dihydroiodotetracene
        EPMaterials.Dihydroiodotetracene = new Material.Builder("dihydroiodotetracene")
                .fluid()
                .color(0xA1DF62)
                .components(GTMaterials.Carbon, 18, GTMaterials.Hydrogen, 11, GTMaterials.Hydrogen, 2, GTMaterials.Iodine, 1)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  25162 Dimethylnaphthalene
        EPMaterials.Dimethylnaphthalene = new Material.Builder("dimethylnaphthalene")
                .fluid()
                .color(0xF200FF)
                .components(GTMaterials.Carbon, 12, GTMaterials.Hydrogen, 12)
                .buildAndRegister();
        //  25163 Acetylating Reagent
        EPMaterials.AcetylatingReagent = new Material.Builder("acetylating_reagent")
                .fluid()
                .color(0x500C45)
                .components(GTMaterials.Carbon, 9, GTMaterials.Hydrogen, 12, GTMaterials.Silicon, 1, EPMaterials.MagnesiumBromide, 2)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  25164 Dichlorodicyanobenzoquinone
        EPMaterials.Dichlorodicyanobenzoquinone = new Material.Builder("dichlorodicyanobenzoquinone")
                .fluid()
                .color(0x47BFA6)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .components(GTMaterials.Carbon, 8, GTMaterials.Chlorine, 2, GTMaterials.Nitrogen, 2, GTMaterials.Oxygen, 2)
                .buildAndRegister();
        //  25165 Dichlorodicyanohydroquinone
        EPMaterials.Dichlorodicyanohydroquinone = new Material.Builder("dichlorodicyanohydroquinone")
                .fluid()
                .color(0x1BC3A2)
                .components(GTMaterials.Carbon, 8, GTMaterials.Chlorine, 2, GTMaterials.Nitrogen, 2, GTMaterials.Oxygen, 2, GTMaterials.Hydrogen, 2)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .buildAndRegister()
                .setFormula("C8Cl2N2(OH)2", true);
        //  25166 Isopropyl Alcohol
        EPMaterials.IsopropylAlcohol = new Material.Builder("isopropyl_alcohol")
                .fluid()
                .color(0xFF23D4)
                .components(GTMaterials.Carbon, 3, GTMaterials.Hydrogen, 8, GTMaterials.Oxygen, 1)
                .buildAndRegister();
        //  25167 Tetracene
        EPMaterials.Tetracene = new Material.Builder("tetracene")
                .dust()
                .color(0x9B8E35)
                .iconSet(MaterialIconSet.SHINY)
                .components(GTMaterials.Carbon, 18, GTMaterials.Hydrogen, 12)
                .buildAndRegister();
    }
}
