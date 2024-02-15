package cn.gtcommunity.epimorphism.common.data.materials;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconSet;
import com.gregtechceu.gtceu.api.fluids.FluidBuilder;
import com.gregtechceu.gtceu.api.fluids.attribute.FluidAttributes;
import com.gregtechceu.gtceu.api.fluids.store.FluidStorageKeys;

import static cn.gtcommunity.epimorphism.common.data.EPMaterials.*;
import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;

public class EPOrganicChemistryMaterials {
    public static void register() {
        //  25000 Kapton-K
        KaptonK = Builder("kapton_k")
                .ingot()
                .fluid()
                .color(16764498)
                .flags(DISABLE_DECOMPOSITION, NO_SMASHING, NO_SMELTING, GENERATE_PLATE, GENERATE_FOIL)
                .components(Carbon, 12, Hydrogen, 12, Nitrogen, 2, Oxygen, 1)
                .buildAndRegister()
                .setFormula("(C7H2N2O4)(O(C6H4)2)", true);
        //  25001 Kapton-E
        KaptonE = Builder("kapton_e")
                .ingot()
                .fluid()
                .color(16768908)
                .flags(DISABLE_DECOMPOSITION, GENERATE_PLATE, NO_SMASHING, NO_SMELTING, GENERATE_FOIL)
                .components(Carbon, 12, Hydrogen, 12, Nitrogen, 2, Oxygen, 1)
                .buildAndRegister()
                .setFormula("O(C6H4NH2)2", true);
        //  25002  EDOT
        Edot = Builder("edot")
                .fluid()
                .color(11665367)
                .components(Carbon, 6, Hydrogen, 6, Oxygen, 2, Sulfur, 1)
                .buildAndRegister();
        //  25003 Polystyrene
        Polystyrene = Builder("polystyrene")
                .fluid()
                .color(14795458)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 8, Hydrogen, 8)
                .buildAndRegister();
        //  25004 PolystyreneSulfonate
        PolystyreneSulfonate = Builder("polystyrene_sulfonate")
                .ingot()
                .fluid()
                .color(14777458)
                .flags(DISABLE_DECOMPOSITION, GENERATE_PLATE)
                .components(Carbon, 8, Hydrogen, 8, Sulfur, 1, Oxygen, 3)
                .buildAndRegister();
        //  25005  PEDOT:PSS
        PedotPSS = Builder("pedot_pss")
                .ingot()
                .fluid()
                .color(14771623)
                .flags(DISABLE_DECOMPOSITION, GENERATE_FINE_WIRE)
                .components(Edot, 1, PolystyreneSulfonate, 1)
                .cableProperties(GTValues.V[GTValues.UHV], 24, 6, false)
                .buildAndRegister();
        //  25006  PMMA
        PMMA = Builder("polymethylmethacrylate")
                .ingot()
                .fluid()
                .color(9554657)
                .flags(DISABLE_DECOMPOSITION, NO_SMASHING, NO_SMELTING, GENERATE_PLATE)
                .components(Carbon, 5, Hydrogen, 8, Oxygen, 2)
                .buildAndRegister();
        //  25007  PEDOT-TMA
        PedotTMA = Builder("pedot_tma")
                .ingot()
                .fluid()
                .color(6201057)
                .flags(DISABLE_DECOMPOSITION, GENERATE_ROD, GENERATE_SPRING, GENERATE_LONG_ROD, GENERATE_FINE_WIRE)
                .components(Edot, 1, PMMA, 2)
                .cableProperties(GTValues.V[GTValues.UEV], 8, 6)
                .buildAndRegister();
        //  25008 Tetramethylammonium Hydroxide
        TetramethylammoniumHydroxide = Builder("tetramethylammonium_hydroxide")
                .fluid()
                .color(4259798)
                .flags(DISABLE_DECOMPOSITION)
                .components(Nitrogen, 1, Carbon, 4, Hydrogen, 12, Oxygen, 1, Hydrogen, 1)
                .buildAndRegister()
                .setFormula("N(CH3)4OH", true);
        //  25009 Potassium Hydroxide
        PotassiumHydroxide = Builder("potassium_hydroxide")
                .dust()
                .fluid(FluidStorageKeys.LIQUID, new FluidBuilder().temperature(633))
                .color(0xFA9849)
                .flags(DISABLE_DECOMPOSITION)
                .components(Potassium, 1, Oxygen, 1, Hydrogen, 1)
                .buildAndRegister();
        //  25010 Potassium Bromate
        PotassiumBromate = Builder("potassium_bromate")
                .dust()
                .color(0x782828)
                .flags(DISABLE_DECOMPOSITION)
                .iconSet(MaterialIconSet.ROUGH)
                .components(Potassium, 1, Bromine, 1, Oxygen, 3)
                .buildAndRegister();
        //  25011 Malonic Acid
        MalonicAcid = Builder("malonic_acid")
                .dust()
                .color(0x61932E)
                .flags(DISABLE_DECOMPOSITION)
                .iconSet(MaterialIconSet.SHINY)
                .components(Carbon, 3, Hydrogen, 4, Oxygen, 4)
                .buildAndRegister();
        //  25012 Chloroacetic Acid
        ChloroaceticAcid = Builder("chloroacetic_acid")
                .dust()
                .color(0x38541A)
                .flags(DISABLE_DECOMPOSITION)
                .iconSet(MaterialIconSet.SHINY)
                .components(Carbon, 2, Hydrogen, 3, Chlorine, 1, Oxygen, 2)
                .buildAndRegister();
        //  25013 Trichloroethylene
        Trichloroethylene = Builder("trichloroethylene")
                .fluid()
                .color(0xB685B1)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 2, Hydrogen, 1, Chlorine, 3)
                .buildAndRegister();
        //  25014 Dichloroethane
        Dichloroethane = Builder("dichloroethane")
                .fluid()
                .color(0xDAAED3)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 2, Hydrogen, 4, Chlorine, 2)
                .buildAndRegister();
        //  25015 Hydrobromic Acid
        HydrobromicAcid = Builder("hydrobromic_acid")
                .fluid(FluidStorageKeys.LIQUID, new FluidBuilder().attribute(FluidAttributes.ACID))
                .color(0x8D1212)
                .components(Hydrogen, 1, Bromine, 1)
                .buildAndRegister();
        //  25016 Butanediol
        Butanediol = Builder("butanediol")
                .fluid()
                .color(0xAAC4DA)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 4, Hydrogen, 10, Oxygen, 2)
                .buildAndRegister()
                .setFormula("C4H8(OH)2", true);
        //  25017 Diacetyl
        Diacetyl = Builder( "diacetyl")
                .fluid()
                .color(0xF7FF65)
                .components(Carbon, 4, Hydrogen, 6, Oxygen, 2)
                .buildAndRegister();
        //  25018 Ethylene Glycol
        EthyleneGlycol = Builder("ethylene_glycol")
                .fluid()
                .color(0x286632)
                .components(Carbon, 2, Hydrogen, 6, Oxygen, 2)
                .buildAndRegister()
                .setFormula("C2H4(OH)2", true);
        //  25019 Sulfur Dichloride
        SulfurDichloride = Builder("sulfur_dichloride")
                .fluid()
                .color(0x761410)
                .components(Sulfur, 1, Chlorine, 2)
                .buildAndRegister();
        //  25020 Acetone Cyanohydrin
        AcetoneCyanohydrin = Builder("acetone_cyanohydrin")
                .fluid()
                .color(0xA1FFD0)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 4, Hydrogen, 7, Nitrogen, 1, Oxygen, 1)
                .buildAndRegister();
        //  25021 Para Xylene
        ParaXylene = Builder("para_xylene")
                .fluid()
                .color(0x666040)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 8, Hydrogen, 10)
                .buildAndRegister()
                .setFormula("C6H4(CH3)2", true);
        //  25022 Cycloparaphenylene
        Cycloparaphenylene = Builder("cycloparaphenylene")
                .fluid()
                .color(0x60545A)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 6, Hydrogen, 4)
                .buildAndRegister();
        //  25023 Dichlorocyclooctadieneplatinium
        Dichlorocyclooctadieneplatinium = Builder("dichlorocyclooctadieneplatinium")
                .dust()
                .color(0xD4E982)
                .iconSet(MaterialIconSet.BRIGHT)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 8, Hydrogen, 12, Chlorine, 2, Platinum, 1)
                .buildAndRegister()
                .setFormula("C8H12Cl2Pt", true);
        //  25024 Diiodobiphenyl
        Diiodobiphenyl = Builder("diiodobiphenyl")
                .dust()
                .color(0x000C52)
                .iconSet(MaterialIconSet.METALLIC)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 12, Hydrogen, 8, Iodine, 2)
                .buildAndRegister()
                .setFormula("C12H8I2", true);
        //  25025 Bipyridine
        Bipyridine = Builder("bipyridine")
                .dust()
                .color(0x716449)
                .iconSet(MaterialIconSet.DULL)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 10, Hydrogen, 8, Nitrogen, 2)
                .buildAndRegister()
                .setFormula("C10H8N2", true);
        //  25026 Palladium Bisdibenzylidieneacetone
        PalladiumBisdibenzylidieneacetone = Builder("palladium_bisdibenzylidieneacetone")
                .dust()
                .color(0x996881)
                .iconSet(MaterialIconSet.METALLIC)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 51, Hydrogen, 42, Oxygen, 3, Palladium, 2)
                .buildAndRegister()
                .setFormula("C51H42O3Pd2", true);
        //  25027 1-Octene
        Octene = Builder("1_octene")
                .fluid()
                .color(0x818022)
                .components(Carbon, 8, Hydrogen, 16)
                .buildAndRegister();
        //  25028 Acetylene
        Acetylene = Builder("acetylene")
                .fluid()
                .color(0x959C60)
                .components(Carbon, 2, Hydrogen, 2)
                .buildAndRegister();
        //  25029 Cyclooctadiene
        Cyclooctadiene = Builder("cyclooctadiene")
                .fluid()
                .color(0x40AC40)
                .components(Carbon, 8, Hydrogen, 12)
                .buildAndRegister();
        //  25030 Pyridine
        Pyridine = Builder("pyridine")
                .fluid()
                .color(0x716449)
                .components(Carbon, 10, Hydrogen, 8, Nitrogen, 2)
                .buildAndRegister();
        //  25031 Formaldehyde
        Formaldehyde = Builder("formaldehyde")
                .fluid()
                .color(0x858F40)
                .components(Carbon, 1, Hydrogen, 2, Oxygen, 1)
                .buildAndRegister();
        //  25032 Dibenzylideneacetone
        Dibenzylideneacetone = Builder("dibenzylideneacetone")
                .fluid()
                .color(0xA44545)
                .components(Carbon, 17, Hydrogen, 14, Oxygen, 1)
                .buildAndRegister();
        //  25033 Benzaldehyde
        Benzaldehyde = Builder("benzaldehyde")
                .fluid()
                .color(0x957D53)
                .components(Carbon, 7, Hydrogen, 6, Oxygen, 1)
                .buildAndRegister();
        //  25034 Benzoyl Chloride
        BenzoylChloride = Builder("benzoyl_chloride")
                .fluid()
                .color(0xABE1FF)
                .components(Carbon, 7, Hydrogen, 5, Chlorine, 1, Oxygen, 1)
                .buildAndRegister();
        //  25035 Thionyl Chloride
        ThionylChloride = Builder("thionyl_chloride")
                .fluid()
                .color(0xDBC2C2)
                .components(Sulfur, 1, Oxygen, 1, Chlorine, 2)
                .buildAndRegister()
                .setFormula("SOCl2", true);
        //  25036 Polyetheretherketone (PEEK)
        Polyetheretherketone = Builder("polyetheretherketone")
                .polymer()
                .color(0x45433D)
                .flags(DISABLE_DECOMPOSITION, NO_SMASHING, NO_SMELTING, GENERATE_PLATE)
                .components(Carbon, 20, Hydrogen, 12, Oxygen, 3)
                .buildAndRegister();
        //  25037 Difluorobenzophenone
        Difluorobenzophenone = Builder("difluorobenzophenone")
                .dust()
                .color(0xC44DA5)
                .iconSet(MaterialIconSet.SHINY)
                .components(Carbon, 13, Hydrogen, 8, Oxygen, 1, Fluorine, 2)
                .buildAndRegister()
                .setFormula("(FC6H4)2CO", true);
        //  25038 Hydroquinone
        Hydroquinone = Builder("hydroquinone")
                .fluid()
                .color(0x83251A)
                .components(Carbon, 6, Hydrogen, 6, Oxygen, 2)
                .buildAndRegister()
                .setFormula("C6H4(OH)2", true);
        //  25039 Resorcinol
        Resorcinol = Builder("resorcinol")
                .fluid()
                .color(0x9DA38D)
                .components(Carbon, 6, Hydrogen, 6, Oxygen, 2)
                .buildAndRegister();
        //  25040 Fluorobenzene
        Fluorobenzene = Builder("fluorobenzene")
                .fluid()
                .color(0x7CCA88)
                .components(Carbon, 6, Hydrogen, 5, Fluorine, 1)
                .buildAndRegister();
        //  25041 Fluorotoluene
        Fluorotoluene = Builder("fluorotoluene")
                .fluid()
                .color(0x6EC5B8)
                .components(Carbon, 7, Hydrogen, 7, Fluorine, 1)
                .buildAndRegister();
        //  25042 Kevlar
        Kevlar = Builder("kevlar")
                .polymer()
                .color(0xF0F078)
                .flags(DISABLE_DECOMPOSITION, NO_SMASHING, NO_SMELTING, GENERATE_PLATE)
                .components(Carbon, 14, Hydrogen, 10, Nitrogen, 2, Oxygen, 2)
                .buildAndRegister()
                .setFormula("(C6H4)2(CO)2(NH)2", true);
        //  25043 Para Phenylenediamine
        ParaPhenylenediamine = Builder("para_phenylenediamine")
                .dust()
                .color(0x4A8E7B)
                .iconSet(MaterialIconSet.ROUGH)
                .components(Carbon, 6, Hydrogen, 8, Nitrogen, 2)
                .buildAndRegister()
                .setFormula("H2NC6H4NH2", true);
        //  25044 Terephthaloyl Chloride
        TerephthaloylChloride = Builder("terephthaloyl_chloride")
                .dust()
                .color(0xFAC4DA)
                .iconSet(MaterialIconSet.SHINY)
                .components(Carbon, 8, Hydrogen, 4, Oxygen, 2, Chlorine, 2)
                .buildAndRegister()
                .setFormula("C6H4(COCl)2", true);
        //  25045 N-Methyl Pyrrolidone
        NMethylPyrrolidone = Builder("n_methyl_pyrrolidone")
                .fluid()
                .color(0xA504D6)
                .components(Carbon, 5, Hydrogen, 9, Nitrogen, 1, Oxygen, 1)
                .buildAndRegister();
        //  25046 Nitroaniline
        Nitroaniline = Builder("nitroaniline")
                .fluid()
                .color(0x2A6E68)
                .components(Carbon, 6, Hydrogen, 6, Nitrogen, 2, Oxygen, 2)
                .buildAndRegister()
                .setFormula("H2NC6H4NO2", true);
        //  25047 Durene
        Durene = Builder("durene")
                .dust()
                .color(0x336040)
                .iconSet(MaterialIconSet.FINE)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 10, Hydrogen, 14)
                .buildAndRegister()
                .setFormula("C6H2(CH3)4", true);
        //  25048 Pyromellitic Dianhydride
        PyromelliticDianhydride = Builder("pyromellitic_dianhydride")
                .dust()
                .color(0xF0EAD6)
                .iconSet(MaterialIconSet.ROUGH)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 10, Hydrogen, 2, Oxygen, 6)
                .buildAndRegister()
                .setFormula("C6H2(C2O3)2", true);
        //  25049 Oxydianiline
        Oxydianiline = Builder("oxydianiline")
                .dust()
                .color(0xF0E130)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 12, Hydrogen, 12, Nitrogen, 2, Oxygen, 1)
                .buildAndRegister()
                .setFormula("O(C6H4NH2)2", true);
        //  25050 Dimethylformamide
        Dimethylformamide = Builder("dimethylformamide")
                .fluid()
                .color(0x42BDFF)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 3, Hydrogen, 7, Nitrogen, 1, Oxygen, 1)
                .buildAndRegister()
                .setFormula("(CH3)2NC(O)H", true);
        //  25051 Phthalic Anhydride
        PhthalicAnhydride = Builder("phthalic_anhydride")
                .dust()
                .color(0xEEAAEE)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 8, Hydrogen, 4, Oxygen, 3)
                .buildAndRegister()
                .setFormula("C6H4(CO)2O", true);
        //  25052 Biphenyl Tetracarboxylic Acid Dianhydride
        BiphenylTetracarboxylicAcidDianhydride = Builder("biphenyl_tetracarboxylic_acid_dianhydride")
                .dust()
                .color(0xFF7F50)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 16, Hydrogen, 6, Oxygen, 6)
                .buildAndRegister()
                .setFormula("(C8H3O3)2", true);
        //  25053 Bistrichloromethylbenzene
        Bistrichloromethylbenzene = Builder("bistrichloromethylbenzene")
                .fluid()
                .color(0xCF8498)
                .components(Carbon, 8, Hydrogen, 4, Chlorine, 6)
                .buildAndRegister()
                .setFormula("C6H4(CCl3)2", true);
        //  25054 Tetrabromoethane
        Tetrabromoethane = Builder("tetrabromoethane")
                .fluid()
                .color(0x5AAADA)
                .components(Carbon, 2, Hydrogen, 2, Bromine, 4)
                .buildAndRegister();
        //  25055 Terephthalic Acid
        TerephthalicAcid = Builder("terephthalic_acid")
                .dust()
                .color(0x5ACCDA)
                .iconSet(MaterialIconSet.ROUGH)
                .components(Carbon, 8, Hydrogen, 6, Oxygen, 4)
                .buildAndRegister()
                .setFormula("C6H4(CO2H)2", true);
        //  25056 γ-Butyrolactone
        GammaButyrolactone = Builder("gamma_butyrolactone")
                .fluid()
                .color(0xAF04D6)
                .components(Carbon, 4, Hydrogen, 6, Oxygen, 2)
                .buildAndRegister();
        //  25057 Methylamine
        Methylamine = Builder("methylamine")
                .gas()
                .color(0xAA6600)
                .components(Carbon, 1, Hydrogen, 5, Nitrogen, 1)
                .buildAndRegister()
                .setFormula("CH3NH2", true);
        //  25058 Trimethylaluminium
        Trimethylaluminium = Builder("trimethylaluminium")
                .fluid()
                .color(0x6ECCFF)
                .flags(DISABLE_DECOMPOSITION)
                .components(Aluminium, 2, Carbon, 6, Hydrogen, 18)
                .buildAndRegister()
                .setFormula("Al2(CH3)6", true);
        //  25059 Trimethylgallium
        Trimethylgallium = Builder("trimethylgallium")
                .fluid()
                .color(0x4F92FF)
                .flags(DISABLE_DECOMPOSITION)
                .components(Gallium, 1, Carbon, 3, Hydrogen, 9)
                .buildAndRegister()
                .setFormula("Ga(CH3)3", true);
        //  25060 Benzophenanthrenylacetonitrile
        Benzophenanthrenylacetonitrile = Builder("benzophenanthrenylacetonitrile")
                .dust()
                .color(0xBB58E9)
                .iconSet(MaterialIconSet.ROUGH)
                .components(Carbon, 20, Hydrogen, 13, Nitrogen, 1)
                .buildAndRegister();
        //  25061 Methylbenzophenanthrene
        Methylbenzophenanthrene = Builder("methylbenzophenanthrene")
                .dust()
                .color(0xEA236B)
                .iconSet(MaterialIconSet.DULL)
                .components(Carbon, 19, Hydrogen, 14)
                .buildAndRegister();
        //  25062 Bromo Succinimide
        BromoSuccinimide = Builder("bromo_succinimide")
                .dust()
                .color(0x00BF8C)
                .iconSet(MaterialIconSet.ROUGH)
                .components(Carbon, 4, Hydrogen, 4, Bromine, 1, Nitrogen, 1, Oxygen, 2)
                .buildAndRegister();
        //  25063 Succinimide
        Succinimide = Builder("succinimide")
                .dust()
                .color(0x1774B6)
                .iconSet(MaterialIconSet.ROUGH)
                .components(Carbon, 4, Hydrogen, 5, Nitrogen, 1, Oxygen, 2)
                .buildAndRegister();
        //  25064 Succinic Acid
        SuccinicAcid = Builder("succinic_acid")
                .dust()
                .color(0x0C3A5B)
                .iconSet(MaterialIconSet.DULL)
                .components(Carbon, 4, Hydrogen, 6, Oxygen, 4)
                .buildAndRegister();
        //  25065 Maleic Anhydride
        MaleicAnhydride = Builder("maleic_anhydride")
                .fluid()
                .color(0x610C2F)
                .components(Carbon, 4, Hydrogen, 2, Oxygen, 3)
                .buildAndRegister();
        //  25066 Naphthaldehyde
        Naphthaldehyde = Builder("naphthaldehyde")
                .fluid()
                .color(0x00FFED)
                .components(Carbon, 11, Hydrogen, 8, Oxygen, 1)
                .buildAndRegister()
                .setFormula("C10H7CHO", true);
        //  25067 Butanol
        Butanol = Builder("butanol")
                .fluid()
                .color(0xC7AF2E)
                .components(Carbon, 4, Hydrogen, 10, Oxygen, 1)
                .buildAndRegister()
                .setFormula("C4H9OH", true);
        //  25068 Bromobutane
        Bromobutane = Builder("bromobutane")
                .fluid()
                .color(0xAE0E39)
                .components(Carbon, 4, Hydrogen, 9, Bromine, 1)
                .buildAndRegister()
                .setFormula("CH3(CH2)3Br", true);
        //  25069 Cyanonaphthalene
        Cyanonaphthalene = Builder("cyanonaphthalene")
                .dust()
                .color(0xDE992D)
                .iconSet(MaterialIconSet.DULL)
                .components(Carbon, 11, Hydrogen, 7, Nitrogen, 1)
                .buildAndRegister();
        //  25070 Triphenylphosphine
        Triphenylphosphine = Builder("triphenylphosphine")
                .dust()
                .color(0x8F2C6B)
                .iconSet(MaterialIconSet.BRIGHT)
                .components(Carbon, 18, Hydrogen, 15, Phosphorus, 1)
                .buildAndRegister()
                .setFormula("(C6H5)3P", true);
        //  25071 Ethylanthraquinone
        Ethylanthraquinone = Builder("ethylanthraquinone")
                .fluid()
                .color(0xCC865A)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 16, Hydrogen, 12, Oxygen, 2)
                .buildAndRegister()
                .setFormula("C6H4(CO)2C6H3Et", true);
        //  25072 Ethylanthrahydroquinone
        Ethylanthrahydroquinone = Builder("ethylanthrahydroquinone")
                .fluid()
                .color(0xAD531A)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 16, Hydrogen, 18, Oxygen, 2)
                .buildAndRegister()
                .setFormula("C6H4(CH2OH)2C6H3Et", true);
        //  25073 Ethylenediamine
        Ethylenediamine = Builder("ethylenediamine")
                .fluid()
                .color(0xD00ED0)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 2, Hydrogen, 8, Nitrogen, 2)
                .buildAndRegister()
                .setFormula("C2H4(NH2)2", true);
        //  25074 Tetrasodium EDTA
        TetrasodiumEDTA = Builder("tetrasodium_edta")
                .dust()
                .color(0x8890E0)
                .iconSet(MaterialIconSet.SHINY)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 10, Hydrogen, 12, Nitrogen, 2, Oxygen, 8, Sodium, 4)
                .buildAndRegister();
        //  25075 EthylenediaminetetraaceticAcid
        EthylenediaminetetraaceticAcid = Builder("ethylenediaminetetraacetic_acid")
                .dust()
                .fluid()
                .color(0x87E6D9)
                .iconSet(MaterialIconSet.ROUGH)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 10, Hydrogen, 16, Nitrogen, 2, Oxygen, 8)
                .buildAndRegister();
        //  25076 Tetramethylammonium Chloride
        TetramethylammoniumChloride = Builder("tetramethylammonium_chloride")
                .dust()
                .color(0x27FF81)
                .flags(DISABLE_DECOMPOSITION)
                .iconSet(MaterialIconSet.METALLIC)
                .components(Carbon, 4, Hydrogen, 12, Nitrogen, 1, Chlorine, 1)
                .buildAndRegister()
                .setFormula("N(CH3)4Cl", true);
        //  25077 Trimethylamine
        Trimethylamine = Builder("trimethylamine")
                .gas()
                .color(0xBB7700)
                .components(Carbon, 3, Hydrogen, 9, Nitrogen, 1)
                .buildAndRegister()
                .setFormula("(CH3)3N", true);
        //  25078 Pyrocatechol
        Pyrocatechol = Builder("pyrocatechol")
                .dust()
                .color(0x784421)
                .flags(DISABLE_DECOMPOSITION)
                .iconSet(MaterialIconSet.DULL)
                .components(Carbon, 6, Hydrogen, 6, Oxygen, 2)
                .buildAndRegister();
        //  25079 Nitryl Fluoride
        NitrylFluoride = Builder("nitryl_fluoride")
                .fluid()
                .color(0x8B7EFF)
                .components(Nitrogen, 1, Oxygen, 2, Fluorine, 1)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  25080 Dimethylamine Hydrochloride
        DimethylamineHydrochloride = Builder("dimethylamine_hydrochloride")
                .fluid()
                .color(0xE3EBDC)
                .components(Dimethylamine, 1, HydrochloricAcid, 1)
                .buildAndRegister()
                .setFormula("C2H8NCl", true);
        //  25081 Potassium Formate
        PotassiumFormate = Builder("potassium_formate")
                .dust()
                .color(0x74B5A9)
                .components(Carbon, 1, Hydrogen, 3, Oxygen, 1, Potassium, 1)
                .buildAndRegister();
        //  25082 Diethyl Suflide
        DiethylSuflide = Builder("diethyl_sulfide")
                .fluid()
                .color(0xFF7E4B)
                .flags(DISABLE_DECOMPOSITION)
                .components(Ethylene, 2, Sulfur, 1)
                .buildAndRegister()
                .setFormula("(C2H5)2S", true);
        //  25083 Dimethylcadmium
        Dimethylcadmium = Builder("dimethylcadmium")
                .fluid()
                .color(0x5C037F)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 2, Hydrogen, 6, Cadmium, 1)
                .buildAndRegister()
                .setFormula("(CH3)2Cd", true);
        //  25084 BETS Perrhenate
        BETSPerrhenate = Builder("bets_perrhenate")
                .dust()
                .color(0x98E993)
                .flags(DISABLE_DECOMPOSITION)
                .iconSet(MaterialIconSet.SHINY)
                .components(Rhenium, 1, Carbon, 10, Hydrogen, 8, Sulfur, 4, Selenium, 4, Oxygen, 4)
                .buildAndRegister();
        //  25085 Bisethylenedithiotetraselenafulvalene
        Bisethylenedithiotetraselenafulvalene = Builder("bisethylenedithiotetraselenafulvalene")
                .dust()
                .color(0x98E993)
                .flags(DISABLE_DECOMPOSITION)
                .iconSet(MaterialIconSet.ROUGH)
                .components(Carbon, 10, Hydrogen, 8, Sulfur, 4, Selenium, 4)
                .buildAndRegister();
        //  25086 Lithiumthiinediselenide
        Lithiumthiinediselenide = Builder("lithiumthiinediselenide")
                .dust()
                .color(0x689E64)
                .iconSet(MaterialIconSet.DULL)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 4, Hydrogen, 4, Sulfur, 2, Lithium, 2, Selenium, 2)
                .buildAndRegister();
        //  25087 Cyclopentadienyl Titanium Trichloride
        CyclopentadienylTitaniumTrichloride = Builder("cyclopentadienyl_titanium_trichloride")
                .dust()
                .color(0x752C7A)
                .iconSet(MaterialIconSet.BRIGHT)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 10, Hydrogen, 10, Chlorine, 2, Titanium, 1)
                .buildAndRegister()
                .setFormula("(C5H5)2Cl2Ti", true);
        //  25088 Propadiene
        Propadiene = Builder("propadiene")
                .fluid()
                .color(0xBD8F61)
                .components(Carbon, 3, Hydrogen, 4)
                .buildAndRegister();
        //  25089 Barium Triflate
        BariumTriflate = Builder("barium_triflate")
                .dust()
                .color(0xFFC183)
                .iconSet(MaterialIconSet.BRIGHT)
                .components(Barium, 1, Oxygen, 6, Carbon, 2, Fluorine, 6)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister()
                .setFormula("Ba(OSO2CF3)2", true);
        //  25090 Scandium Triflate
        ScandiumTriflate = Builder("scandium_triflate")
                .dust()
                .color(0xCC9999)
                .iconSet(MaterialIconSet.BRIGHT)
                .components(Scandium, 1, Oxygen, 9, Carbon, 3, Fluorine, 9)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister()
                .setFormula("Sc(OSO2CF3)3", true);
        //  25091 Barium Triflate Solution
        BariumTriflateSolution = Builder("barium_triflate_solution")
                .fluid()
                .color(0xFFC183)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister()
                .setFormula("C2BaF6O6S2Hg(H2O)3", true);
        //  25092 Biperfluoromethanedisulfide
        Biperfluoromethanedisulfide = Builder("biperfluoromethanedisulfide")
                .fluid()
                .color(0x849648)
                .components(Carbon, 2, Fluorine, 6, Sulfur, 2)
                .buildAndRegister();
        //  25093 Butyl Lithium
        ButylLithium = Builder("butyl_lithium")
                .fluid()
                .color(0x96F6DF)
                .components(Carbon, 4, Hydrogen, 9, Lithium, 1)
                .buildAndRegister();
        //  25094 Bromodihydrothiine
        Bromodihydrothiine = Builder("bromodihydrothiine")
                .fluid()
                .color(0x66F36E)
                .components(Carbon, 4, Hydrogen, 4, Sulfur, 2, Bromine, 2)
                .buildAndRegister();
        //  25095 Chloroethane
        Chloroethane = Builder("chloroethane")
                .fluid()
                .color(0xA55D80)
                .components(Carbon, 2, Hydrogen, 5, Chlorine, 1)
                .buildAndRegister();
        //  25096 Dibromoacrolein
        Dibromoacrolein = Builder("dibromoacrolein")
                .fluid()
                .color(0x7C4660)
                .components(Carbon, 2, Hydrogen, 2, Bromine, 2, Oxygen, 2)
                .buildAndRegister();
        //  25097 Formic Acid
        FormicAcid = Builder("formic_acid")
                .fluid()
                .color(0xFFAA77)
                .components(Carbon, 1, Hydrogen, 2, Oxygen, 2)
                .buildAndRegister();
        //  25098 Sodium Formate
        SodiumFormate = Builder("sodium_formate")
                .fluid()
                .color(0x416CC0)
                .iconSet(MaterialIconSet.ROUGH)
                .components(Carbon, 1, Hydrogen, 1, Oxygen, 2, Sodium, 1)
                .buildAndRegister();
        //  25099 Ethylhexanol
        Ethylhexanol = Builder("ethylhexanol")
                .fluid()
                .color(0xFEEA9A)
                .components(Carbon, 8, Hydrogen, 10, Oxygen, 1)
                .buildAndRegister();
        //  25100 Diethylhexyl Phosphoric Acid
        DiethylhexylPhosphoricAcid = Builder("diethylhexyl_phosphoric_acid")
                .fluid()
                .color(0xFFFF99)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 16, Hydrogen, 35, Oxygen, 4, Phosphorus, 1)
                .buildAndRegister()
                .setFormula("(C8H7O)2PO2H", true);
        //  25101 Dichloromethane
        Dichloromethane = Builder("dichloromethane")
                .fluid()
                .color(0xB87FC7)
                .components(Carbon, 1, Hydrogen, 2, Chlorine, 2)
                .buildAndRegister();
        //  25102 Tributylamine
        Tributylamine = Builder("tributylamine")
                .fluid()
                .color(0x801a80)
                .components(Carbon, 12, Hydrogen, 27, Nitrogen, 1)
                .buildAndRegister()
                .setFormula("(C4H9)3N", true);
        //  25103 Zylon
        Zylon = Builder("zylon")
                .polymer()
                .color(0xFFE000)
                .iconSet(MaterialIconSet.SHINY)
                .flags(DISABLE_DECOMPOSITION, NO_SMASHING, NO_SMELTING, GENERATE_PLATE, GENERATE_FOIL)
                .components(Carbon, 14, Hydrogen, 6, Nitrogen, 2, Oxygen, 2)
                .buildAndRegister();
        //  25104 Pre Zylon
        PreZylon = Builder("pre_zylon")
                .dust()
                .color(0x623250)
                .iconSet(MaterialIconSet.DULL)
                .flags(DISABLE_DECOMPOSITION, NO_SMASHING, NO_SMELTING)
                .components(Carbon, 20, Hydrogen, 22, Nitrogen, 2, Oxygen, 2)
                .buildAndRegister();
        //  25105 Terephthalaldehyde
        Terephthalaldehyde = Builder("terephthalaldehyde")
                .dust()
                .color(0x567C2D)
                .iconSet(MaterialIconSet.ROUGH)
                .components(Carbon, 8, Hydrogen, 6, Oxygen, 2)
                .buildAndRegister();
        //  25106 Dibromomethylbenzene
        Dibromomethylbenzene = Builder("dibromomethylbenzene")
                .fluid()
                .color(0x9F4839)
                .components(Carbon, 7, Hydrogen, 6, Bromine, 2)
                .buildAndRegister();
        //  25107 Isochloropropane
        Isochloropropane = Builder("isochloropropane")
                .fluid()
                .color(0xC3AC65)
                .components(Carbon, 3, Hydrogen, 7, Chlorine, 1)
                .buildAndRegister()
                .setFormula("CH3CHClCH3", true);
        //  25108 Dinitrodipropanyloxybenzene
        Dinitrodipropanyloxybenzene = Builder("dinitrodipropanyloxybenzene")
                .fluid()
                .color(0x9FAD1D)
                .components(Carbon, 12, Hydrogen, 16, Oxygen, 6, Nitrogen, 2)
                .buildAndRegister()
                .setFormula("C12H16O2(NO2)2", true);
        //  25109 Hexanitrohexaaxaisowurtzitane
        Hexanitrohexaaxaisowurtzitane = Builder("hexanitrohexaaxaisowurtzitane")
                .dust()
                .color(0x0B7222)
                .iconSet(MaterialIconSet.BRIGHT)
                .components(Carbon, 6, Hydrogen, 6, Nitrogen, 12, Oxygen, 12)
                .buildAndRegister();
        //  25110 Crude Hexanitrohexaaxaisowurtzitane
        CrudeHexanitrohexaaxaisowurtzitane = Builder("crude_hexanitrohexaaxaisowurtzitane")
                .dust()
                .color(0x5799EC)
                .iconSet(MaterialIconSet.DULL)
                .components(Carbon, 6, Hydrogen, 6, Nitrogen, 12, Oxygen, 12)
                .buildAndRegister();
        //  25111 Tetraacetyldinitrosohexaazaisowurtzitane
        Tetraacetyldinitrosohexaazaisowurtzitane = Builder("tetraacetyldinitrosohexaazaisowurtzitane")
                .dust()
                .color(0xEA7584)
                .iconSet(MaterialIconSet.ROUGH)
                .components(Carbon, 14, Hydrogen, 18, Nitrogen, 8, Oxygen, 6)
                .buildAndRegister();
        //  25112 Dibenzyltetraacetylhexaazaisowurtzitane
        Dibenzyltetraacetylhexaazaisowurtzitane = Builder("dibenzyltetraacetylhexaazaisowurtzitane")
                .dust()
                .color(0xB7E8EE)
                .iconSet(MaterialIconSet.DULL)
                .components(Carbon, 28, Hydrogen, 32, Nitrogen, 6, Oxygen, 4)
                .buildAndRegister();
        //  25113 Succinimidyl Acetate
        SuccinimidylAcetate = Builder("succinimidyl_acetate")
                .dust()
                .color(0x1D3605)
                .iconSet(MaterialIconSet.ROUGH)
                .components(Carbon, 6, Hydrogen, 7, Nitrogen, 1, Oxygen, 4)
                .buildAndRegister();
        //  25114 N-Hydroxysuccinimide
        NHydroxysuccinimide = Builder("n_hydroxysuccinimide")
                .dust()
                .color(0x33BAFB)
                .iconSet(MaterialIconSet.DULL)
                .components(Carbon, 4, Hydrogen, 5, Nitrogen, 1, Oxygen, 3)
                .buildAndRegister()
                .setFormula("(CH2CO)2NOH", true);
        //  25115 Tetrahydrofuran
        Tetrahydrofuran = Builder("tetrahydrofuran")
                .fluid()
                .color(0x0BCF52)
                .components(Carbon, 4, Hydrogen, 8, Oxygen, 1)
                .buildAndRegister()
                .setFormula("(CH2)4O", true);
        //  25116 Succinic Anhydride
        SuccinicAnhydride = Builder("succinic_anhydride")
                .dust()
                .color(0xA2569D)
                .components(Carbon, 4, Hydrogen, 4, Oxygen, 3)
                .buildAndRegister()
                .setFormula("(CH2CO)2O");
        //  25117 Hexabenzylhexaazaisowurtzitane
        Hexabenzylhexaazaisowurtzitane = Builder("hexabenzylhexaazaisowurtzitane")
                .dust()
                .color(0x48561E)
                .iconSet(MaterialIconSet.DULL)
                .components(Carbon, 48, Hydrogen, 48 , Nitrogen, 6)
                .buildAndRegister();
        //  25118 Acetonitrile
        Acetonitrile = Builder("acetonitrile")
                .dust()
                .color(0x7D82A3)
                .iconSet(MaterialIconSet.ROUGH)
                .components(Carbon, 2, Hydrogen, 3, Nitrogen, 1)
                .buildAndRegister()
                .setFormula("CH3CN");
        //  25119 Acetamide
        Acetamide = Builder("acetamide")
                .dust()
                .color(0x7D82A3)
                .iconSet(MaterialIconSet.DULL)
                .components(Carbon, 2, Hydrogen, 5, Nitrogen, 1, Oxygen, 1)
                .buildAndRegister()
                .setFormula("CH3CONH2", true);
        //  25120 Benzylamine
        Benzylamine = Builder("benzylamine")
                .fluid()
                .color(0x527A92)
                .components(Carbon, 7, Hydrogen, 9, Nitrogen, 1)
                .buildAndRegister();
        //  25121 Benzyl Chloride
        BenzylChloride = Builder("benzyl_chloride")
                .fluid()
                .color(0x6699CC)
                .components(Carbon, 7, Hydrogen, 7, Chlorine, 1)
                .buildAndRegister();
        //  25122 Hexamethylenetetramine
        Hexamethylenetetramine = Builder("hexamethylenetetramine")
                .dust()
                .color(0x53576D)
                .iconSet(MaterialIconSet.DULL)
                .components(Carbon, 6, Hydrogen, 12, Nitrogen, 4)
                .buildAndRegister()
                .setFormula("(CH2)6N4", true);
        //  25123 Dimethyl Carbonate
        DimethylCarbonate = Builder("dimethyl_carbonate")
                .fluid()
                .color(0xC5EB9E)
                .components(Carbon, 3, Hydrogen, 6, Oxygen, 3)
                .buildAndRegister()
                .setFormula("(CH3O)2CO", true);
        //  25124 Diphenyl Carbonate
        DiphenylCarbonate = Builder("diphenyl_carbonate")
                .fluid()
                .color(DimethylCarbonate.getMaterialRGB() + Benzene.getMaterialRGB())
                .components(Carbon, 13, Hydrogen, 10, Oxygen, 3)
                .buildAndRegister();
        //  25125 BPA Polycarbonate
        BPAPolycarbonate = Builder("bpa_polycarbonate")
                .ingot()
                .fluid()
                .color(0xE3EBDA)
                .flags(DISABLE_DECOMPOSITION, NO_SMASHING, NO_SMELTING, GENERATE_PLATE)
                .components(Carbon, 16, Hydrogen, 14, Oxygen, 3)
                .buildAndRegister();
        //  25126 Isobutyric Acid
        IsobutyricAcid = Builder("isobutyric_acid")
                .fluid()
                .color(Propene.getMaterialRGB() + Propadiene.getMaterialRGB())
                .components(Carbon, 4, Hydrogen, 8, Oxygen, 2)
                .buildAndRegister();
        //  25127 Isobutyric Anhydride
        IsobutyricAnhydride = Builder("isobutyric_anhydride")
                .fluid()
                .color(IsobutyricAcid.getMaterialRGB()/* - AceticAnhydride.getMaterialRGB()*/)
                .components(Carbon, 8, Hydrogen, 14, Oxygen, 3)
                .buildAndRegister();
        //  25128 Dimethylketene
        Dimethylketene = Builder("dimethylketene")
                .fluid()
                .color(0x0925BE)
                .components(Carbon, 4, Hydrogen, 6, Oxygen, 2)
                .buildAndRegister();
        //  25129 Tetramethylcyclobutanediol
        Tetramethylcyclobutanediol = Builder("tetramethylcyclobutanediol")
                .fluid()
                .color(Dimethylketene.getMaterialRGB() + Hydrogen.getMaterialRGB())
                .components(Carbon, 8, Hydrogen, 16, Oxygen, 2)
                .buildAndRegister();
        //  25130 CBDO Polycarbonate
        CBDOPolycarbonate = Builder("cbdo_polycarbonate")
                .ingot()
                .fluid()
                .color(0xDFDFDF)
                .flags(DISABLE_DECOMPOSITION, NO_SMASHING, NO_SMELTING, GENERATE_PLATE)
                .components(Carbon, 9, Hydrogen, 14, Oxygen, 3)
                .buildAndRegister();
        //  25131 Nitrile Butadiene Rubber
        NitrileButadieneRubber = Builder("nitrile_butadiene_rubber")
                .fluid(FluidStorageKeys.LIQUID, new FluidBuilder().temperature(433))
                .polymer()
                .color(0x211A18)
                .flags(DISABLE_DECOMPOSITION, GENERATE_PLATE, GENERATE_RING)
                .components(Carbon, 7, Hydrogen, 9, Nitrogen, 1)
                .buildAndRegister();
        //  25132 Poly (Phosphonitrile Fluoro) Rubber
        PolyPhosphonitrileFluoroRubber = Builder("poly_phosphonitrile_fluoro_rubber")
                .polymer()
                .color(0x372B28)
                .flags(DISABLE_DECOMPOSITION, GENERATE_PLATE, GENERATE_RING)
                .components(Carbon, 24, Hydrogen, 16, Oxygen, 8, Nitrogen, 4, Phosphorus, 4, Fluorine, 40)
                .buildAndRegister();
        //  25133 Acrylonitrile
        Acrylonitrile = Builder("acrylonitrile")
                .fluid()
                .color(Propene.getMaterialRGB())
                .components(Carbon, 3, Hydrogen, 3, Nitrogen, 1)
                .buildAndRegister();
        //  25134 Phosphonitrilic Chloride Trimer
        PhosphonitrilicChlorideTrimer = Builder("phosphonitrilic_chloride_trimer")
                .fluid()
                .color(0x082C38)
                .components(Chlorine, 6, Nitrogen, 3, Phosphorus, 3)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  25135 Sodium Trifluoroethanolate
        SodiumTrifluoroethanolate = Builder("sodium_trifluoroethanolate")
                .dust()
                .color(0x50083E)
                .iconSet(MaterialIconSet.ROUGH)
                .components(Carbon, 2, Hydrogen, 4, Fluorine, 3, Sodium, 1, Oxygen, 1)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  25136 Octafluoro Pentanol
        OctafluoroPentanol = Builder("octafluoro_pentanol")
                .fluid()
                .color(0xE5EBDE)
                .components(Carbon, 5, Hydrogen, 4, Fluorine, 8, Oxygen, 1)
                .buildAndRegister();
        //  25137 Tributyl Phosphate
        TributylPhosphate = Builder("tributyl_phosphate")
                .fluid()
                .color(0xBED323)
                .components(Carbon, 12, Hydrogen, 27, Phosphorus, 1, Oxygen, 4)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister()
                .setFormula("(C4H9)3PO4", true);
        //  25138 Methyl Isobutyl Ketone
        MethylIsobutylKetone = Builder("methyl_isobutyl_ketone")
                .fluid()
                .color(0x2F5687)
                .components(Carbon, 6, Hydrogen, 12, Oxygen, 1)
                .buildAndRegister();
        //  25139 tbp_mibk_solution
        TBPMIBKSolution = Builder("tbp_mibk_solution")
                .fluid()
                .color(TributylPhosphate.getMaterialRGB() + MethylIsobutylKetone.getMaterialRGB())
                .components(TributylPhosphate, 1, MethylIsobutylKetone, 1)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  25140 Mesityl Oxide
        MesitylOxide = Builder("mesityl_oxide")
                .fluid()
                .color(0x783E50)
                .components(Carbon, 6, Hydrogen, 10, Oxygen, 1)
                .buildAndRegister();
        //  25141 Electrolyte Reflector Mixture
        ElectrolyteReflectorMixture = Builder("electrolyte_reflector_mixture")
                .fluid(FluidStorageKeys.LIQUID, new FluidBuilder().temperature(209))
                .color(0xE62A35)
                .components(ManganeseDifluoride, 1, ZincSulfide, 1, TantalumPentoxide, 1, Rutile, 1, Ethanol, 1)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  25142 Ethylene Dibromide
        EthyleneDibromide = Builder("ethylene_dibromide")
                .fluid()
                .color(0x4F1743)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 2, Hydrogen, 4, Bromine, 2)
                .buildAndRegister();
        //  25143 Grignard Reagent
        GrignardReagent = Builder("grignard_reagent")
                .fluid()
                .color(0xA12AA1)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 1, Hydrogen, 3, Magnesium, 1, Bromine, 1)
                .buildAndRegister();
        //  25144 Fluorocarborane
        Fluorocarborane = Builder("fluorocarborane")
                .dust()
                .color(0x59B35C)
                .iconSet(MaterialIconSet.BRIGHT)
                .components(Carbon, 1, Hydrogen, 2, Boron, 11, Fluorine, 11)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister()
                .setFormula("HCHB11F11", true);
        //  25145 Perfluorobenzene
        Perfluorobenzene = Builder("perfluorobenzene")
                .fluid()
                .color(0x39733B)
                .components(Carbon, 6, Fluorine, 6)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  25146 Trimethylsilane
        Trimethylsilane = Builder("trimethylsilane")
                .fluid()
                .color(0xB366B0)
                .components(Carbon, 3, Hydrogen, 10, Silicon, 1)
                .buildAndRegister();
        //  25147 Trimethylchlorosilane
        Trimethylchlorosilane = Builder("trimethylchlorosilane")
                .fluid()
                .color(0x864D84)
                .components(Carbon, 9, Hydrogen, 9, Silicon, 1, Chlorine, 1)
                .buildAndRegister()
                .setFormula("(CH3)3SiCl", true);
        //  25148 Caesium Carborane Precursor
        CaesiumCarboranePrecursor = Builder("caesium_carborane_precursor")
                .dust()
                .color(CaesiumCarborane.getMaterialRGB())
                .iconSet(MaterialIconSet.SAND)
                .components(Caesium, 1, Boron, 10, Hydrogen, 21, Carbon, 4, Nitrogen, 1, Chlorine, 1)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister()
                .setFormula("CsB10H12CN(CH3)3Cl", true);
        //  25149 Borane Dimethylsulfide
        BoraneDimethylsulfide = Builder("borane_dimethylsulfide")
                .fluid()
                .color(Lead.getMaterialRGB() + Boron.getMaterialRGB())
                .components(Caesium, 1, Carbon, 1, Boron, 11, Hydrogen, 12)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  25150 Decaborane
        Decaborane = Builder("decaborane")
                .dust()
                .color(0x4C994F)
                .iconSet(MaterialIconSet.ROUGH)
                .components(Boron, 10, Hydrogen, 14)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  25151 Diethyl Ether
        DiethylEther = Builder("diethyl_ether")
                .fluid()
                .color(0xFFA4A3)
                .components(Carbon, 4, Hydrogen, 10, Oxygen, 1)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister()
                .setFormula("(C2H5)2O", true);
        //  25152 Boron Trifluoride Etherate
        BoronTrifluorideEtherate = Builder("boron_trifluoride_etherate")
                .fluid()
                .color(0xBF6E6E)
                .components(Boron, 1, Fluorine, 3, Carbon, 4, Hydrogen, 7, Oxygen, 1)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister()
                .setFormula("(BF3)(C2H5)2O", true);
        //  25153 Dimethyl Sulfide
        DimethylSulfide = Builder("dimethyl_sulfide")
                .fluid()
                .color(SulfuricAcid.getMaterialRGB() + Methanol.getMaterialRGB())
                .components(Carbon, 2, Hydrogen, 6, Sulfur, 1)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister()
                .setFormula("(CH3)2S", true);
        //  25154 Oxalic Acid
        OxalicAcid = Builder("oxalic_acid")
                .fluid()
                .color(0xC5EB9E)
                .components(Carbon, 2, Hydrogen, 2, Oxygen, 4)
                .buildAndRegister()
                .setFormula("HOOCCOOH", false);
        //  25155 Glucose
        Glucose = Builder("glucose")
                .dust()
                .color(0xE3E3E3)
                .iconSet(MaterialIconSet.SAND)
                .components(Carbon, 6, Hydrogen, 12, Oxygen, 6)
                .buildAndRegister();
        //  25156 Fructose
        Fructose = Builder("fructose")
                .dust()
                .color(0xE3E3E3)
                .iconSet(MaterialIconSet.SAND)
                .components(Carbon, 6, Hydrogen, 12, Oxygen, 6)
                .buildAndRegister();
        //  25157 Hexafluoropropylene
        Hexafluoropropylene = Builder("hexafluoropropylene")
                .fluid()
                .color(0x141D6F)
                .components(Carbon, 3, Fluorine, 6)
                .buildAndRegister();
        //  25158 Fluorinated Ethylene Propylene
        FluorinatedEthylenePropylene = Builder("fluorinated_ethylene_propylene")
                .polymer()
                .color(0xC8C8C8)
                .iconSet(MaterialIconSet.DULL)
                .components(Carbon, 5, Fluorine, 10)
                .buildAndRegister();
        //  25159 Polycyclic Aromatic Mixture
        PolycyclicAromaticMixture = Builder("polycyclic_aromatic_mixture")
                .dust()
                .color(0x95A36C)
                .iconSet(MaterialIconSet.ROUGH)
                .components(Carbon, 18, Hydrogen, 12)
                .buildAndRegister();
        //  25160 Anthracene
        Anthracene = Builder("anthracene")
                .fluid()
                .color(0xCCCC99)
                .components(Carbon, 14, Hydrogen, 10)
                .buildAndRegister();
        //  25161 Dihydroiodotetracene
        Dihydroiodotetracene = Builder("dihydroiodotetracene")
                .fluid()
                .color(0xA1DF62)
                .components(Carbon, 18, Hydrogen, 11, Hydrogen, 2, Iodine, 1)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  25162 Dimethylnaphthalene
        Dimethylnaphthalene = Builder("dimethylnaphthalene")
                .fluid()
                .color(0xF200FF)
                .components(Carbon, 12, Hydrogen, 12)
                .buildAndRegister();
        //  25163 Acetylating Reagent
        AcetylatingReagent = Builder("acetylating_reagent")
                .fluid()
                .color(0x500C45)
                .components(Carbon, 9, Hydrogen, 12, Silicon, 1, MagnesiumBromide, 2)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  25164 Dichlorodicyanobenzoquinone
        Dichlorodicyanobenzoquinone = Builder("dichlorodicyanobenzoquinone")
                .fluid()
                .color(0x47BFA6)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 8, Chlorine, 2, Nitrogen, 2, Oxygen, 2)
                .buildAndRegister();
        //  25165 Dichlorodicyanohydroquinone
        Dichlorodicyanohydroquinone = Builder("dichlorodicyanohydroquinone")
                .fluid()
                .color(0x1BC3A2)
                .components(Carbon, 8, Chlorine, 2, Nitrogen, 2, Oxygen, 2, Hydrogen, 2)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister()
                .setFormula("C8Cl2N2(OH)2", true);
        //  25166 Isopropyl Alcohol
        IsopropylAlcohol = Builder("isopropyl_alcohol")
                .fluid()
                .color(0xFF23D4)
                .components(Carbon, 3, Hydrogen, 8, Oxygen, 1)
                .buildAndRegister();
        //  25167 Tetracene
        Tetracene = Builder("tetracene")
                .dust()
                .color(0x9B8E35)
                .iconSet(MaterialIconSet.SHINY)
                .components(Carbon, 18, Hydrogen, 12)
                .buildAndRegister();
    }
}
