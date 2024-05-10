package cn.gtcommunity.epimorphism.common.data.materials;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconSet;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.BlastProperty;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.PropertyKey;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.ToolProperty;
import com.gregtechceu.gtceu.api.fluids.FluidBuilder;
import com.gregtechceu.gtceu.api.fluids.attribute.FluidAttributes;
import com.gregtechceu.gtceu.api.fluids.store.FluidStorageKeys;
import com.gregtechceu.gtceu.api.item.tool.GTToolType;
import net.minecraft.ChatFormatting;

import static cn.gtcommunity.epimorphism.api.data.chemical.material.info.EPMaterialFlags.*;
import static cn.gtcommunity.epimorphism.common.data.EPMaterials.*;
import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags.*;
import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconSet.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;

public class EPFirstDegreeMaterials {
    public static void register() {
        //  24001 GrapheneOxide
        GrapheneOxide = Builder("graphene_oxide")
                .dust()
                .color(0x777777)
                .iconSet(ROUGH)
                .flags(DISABLE_DECOMPOSITION)
                .components(Graphene, 1, Oxygen, 1)
                .buildAndRegister();
        //  24002 Hydrazine
        Hydrazine = Builder("hydrazine")
                .fluid()
                .color(0xB50707)
                .flags(DISABLE_DECOMPOSITION)
                .components(Nitrogen, 2, Hydrogen, 4)
                .buildAndRegister();

        //  24003 BerylliumOxide
        BerylliumOxide = Builder("beryllium_oxide")
                .ingot()
                .color(0x54C757)
                .flags(GENERATE_ROD, GENERATE_RING)
                .components(Beryllium, 1, Oxygen, 1)
                .buildAndRegister();

        //  24004 Hydrogen Peroxide
        HydrogenPeroxide = Builder("hydrogen_peroxide")
                .fluid()
                .color(0xD2FFFF)
                .flags(DISABLE_DECOMPOSITION)
                .components(Hydrogen, 2, Oxygen, 2)
                .buildAndRegister();

        //  24005 Tungsten Trioxide
        TungstenTrioxide = Builder("tungsten_trioxide")
                .dust()
                .color(0xC7D300)
                .iconSet(MaterialIconSet.DULL)
                .flags(DISABLE_DECOMPOSITION)
                .components(Tungsten, 1, Oxygen, 3)
                .buildAndRegister();
        //  24006 Hexagonal Boron Nitride
        HexagonalBoronNitride = Builder("hexagonal_boron_nitride")
                .gem()
                .color(0x6A6A72)
                .iconSet(MaterialIconSet.GEM_VERTICAL)
                .flags(GENERATE_PLATE, DISABLE_DECOMPOSITION)
                .components(Boron, 1, Nitrogen, 1)
                .buildAndRegister()
                .setFormula("h-BN", true);

        //  24007  Cubic Boron Nitride
        CubicBoronNitride = Builder("cubic_boron_nitride")
                .gem()
                .color(0x545572)
                .iconSet(MaterialIconSet.DIAMOND)
                .flags(GENERATE_PLATE, DISABLE_DECOMPOSITION, DISABLE_CRYSTALLIZATION, FLAMMABLE, EXPLOSIVE)
                .components(Boron, 1, Nitrogen, 1)
                .toolStats(new ToolProperty(14.0F, 9.0F, 12400, 6, GTToolType.getTypes().values().toArray(GTToolType[]::new)))
                .buildAndRegister()
                .setFormula("c-BN", true);
        //  24008 Boric Acid
        BoricAcid = Builder("boric_acid")
                .dust()
                .fluid()
                .color(0xFAFAFA)
                .iconSet(MaterialIconSet.SHINY)
                .flags(DISABLE_DECOMPOSITION)
                .components(Hydrogen, 3, Boron, 1, Oxygen, 3)
                .buildAndRegister();
        //  24009 Boron Trioxide
        BoronTrioxide = Builder("boron_trioxide")
                .dust()
                .color(0xE9FAC0)
                .iconSet(MaterialIconSet.METALLIC)
                .components(Boron, 2, Oxygen, 3)
                .buildAndRegister();
        //  24010 Boron Trifluoride
        BoronTrifluoride = Builder("boron_trifluoride")
                .gas()
                .color(0xFAF191)
                .components(Boron, 1, Fluorine, 3)
                .buildAndRegister();
        //  24011 Lithium Hydride
        LithiumHydride = Builder("lithium_hydride")
                .ingot()
                .color(0x9BAFDB)
                .iconSet(MaterialIconSet.METALLIC)
                .components(Lithium, 1, Hydrogen, 1)
                .buildAndRegister();
        //  24012 Lithium Tetrafluoroborate
        LithiumTetrafluoroborate = Builder("lithium_tetrafluoroborate")
                .dust()
                .color(0x90FAF6)
                .iconSet(MaterialIconSet.SHINY)
                .flags(DISABLE_DECOMPOSITION)
                .components(Lithium, 1, Boron, 1, Fluorine, 4)
                .buildAndRegister();
        //  24013 Diborane
        Diborane = Builder("diborane")
                .gas()
                .color(0x3F3131)
                .flags(DISABLE_DECOMPOSITION)
                .components(Boron, 2, Hydrogen, 6)
                .buildAndRegister();
        //  24014 Borazine
        Borazine = Builder("borazine")
                .fluid()
                .color(0x542828)
                .flags(DISABLE_DECOMPOSITION)
                .components(Boron, 3, Hydrogen, 6, Nitrogen, 3)
                .buildAndRegister();
        //  24015 Boron Trichloride
        BoronTrichloride = Builder("boron_trichloride")
                .gas()
                .color(0x033F1B)
                .components(Boron, 1, Chlorine, 3)
                .buildAndRegister();
        //  24016 Trichloroborazine
        Trichloroborazine = Builder("trichloroborazine")
                .fluid()
                .color(0xD62929)
                .flags(DISABLE_DECOMPOSITION)
                .components(Boron, 3, Chlorine, 3, Hydrogen, 3, Nitrogen, 3)
                .buildAndRegister();
        //  24017 Amorphous Boron Nitride
        AmorphousBoronNitride = Builder("amorphous_boron_nitride")
                .ingot()
                .color(0x9193C5)
                .iconSet(MaterialIconSet.SHINY)
                .flags(GENERATE_PLATE, DISABLE_DECOMPOSITION, NO_SMASHING, NO_SMELTING)
                .components(Boron, 1, Nitrogen, 1)
                .buildAndRegister()
                .setFormula("a-BN", true);
        //  24018 Heterodiamond
        Heterodiamond = Builder("heterodiamond")
                .gem()
                .color(0x512A72)
                .iconSet(MaterialIconSet.GEM_HORIZONTAL)
                .flags(GENERATE_PLATE, DISABLE_DECOMPOSITION)
                .components(Boron, 1, Carbon, 1, Nitrogen, 1)
                .buildAndRegister();
        //  24019 Cubic Heterodiamond
        CubicHeterodiamond = Builder("cubic_heterodiamond")
                .gem()
                .color(0x753DA6)
                .iconSet(MaterialIconSet.DIAMOND)
                .flags(GENERATE_PLATE, DISABLE_DECOMPOSITION)
                .components(Boron, 1, Carbon, 2, Nitrogen, 1)
                .buildAndRegister()
                .setFormula("c-BC2N", true);
        //  24020 Carbon Nanotube
        CarbonNanotube = Builder("carbon_nanotube")
                .ingot()
                .fluid()
                .color(0x05090C)
                .iconSet(MaterialIconSet.BRIGHT)
                .flags(DISABLE_DECOMPOSITION, NO_SMELTING, GENERATE_PLATE, GENERATE_ROD, GENERATE_LONG_ROD, GENERATE_FINE_WIRE, GENERATE_SPRING)
                .cableProperties(GTValues.V[GTValues.UEV], 8, 6)
                .components(Carbon, 48)
                .buildAndRegister()
                .setFormula("CNT", false);
        //  24021 Silver Tetrafluoroborate
        SilverTetrafluoroborate = Builder("silver_tetrafluoroborate")
                .fluid()
                .color(0x818024)
                .flags(DISABLE_DECOMPOSITION)
                .components(Silver, 1, Boron, 1, Fluorine, 4)
                .buildAndRegister()
                .setFormula("AgBF4", true);
        //  24022 Trimethyltin Chloride
        TrimethyltinChloride = Builder("trimethyltin_chloride")
                .fluid()
                .color(0x7F776F)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 3, Hydrogen, 6, Tin, 1, Chlorine, 1)
                .buildAndRegister()
                .setFormula("(CH3)3SnCl", true);
        //  24023 Silver Chloride
        SilverChloride = Builder("silver_chloride")
                .dust()
                .color(0x8D8D8D)
                .iconSet(MaterialIconSet.METALLIC)
                .components(Silver, 1, Chlorine, 1)
                .buildAndRegister();
        //  24024 Chloroplatinic Acid
        ChloroplatinicAcid = Builder("chloroplatinic_acid")
                .fluid(FluidStorageKeys.LIQUID, new FluidBuilder().attribute(FluidAttributes.ACID))
                .color(0xFFB546)
                .components(Hydrogen, 2, Platinum, 1, Chlorine, 6)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24025 Potassium Tetrachloroplatinate
        PotassiumTetrachloroplatinate = Builder("potassium_tetrachloroplatinate")
                .dust()
                .color(0xF1B04F)
                .iconSet(MaterialIconSet.SHINY)
                .components(Potassium, 2, Platinum, 1, Chlorine, 4)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister()
                .setFormula("K2PtCl4", true);
        //  24026 Nickel Triphenylphosphite
        NickelTriphenylphosphite = Builder("nickel_triphenylphosphite")
                .dust()
                .color(0xCCCC66)
                .iconSet(MaterialIconSet.SHINY)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 36, Hydrogen, 30, Chlorine, 2, Nickel, 1, Phosphorus, 2)
                .buildAndRegister()
                .setFormula("C36H30Cl2NiP2", true);
        //  24027 Nickel Chloride
        NickelChloride = Builder("nickel_chloride")
                .dust()
                .color(0x898A07)
                .iconSet(MaterialIconSet.DULL)
                .components(Nickel, 1, Chlorine, 2)
                .buildAndRegister();
        //  24028 Phosphorus Trichloride
        PhosphorusTrichloride = Builder("phosphorus_trichloride")
                .fluid()
                .color(0xD8D85B)
                .components(Phosphorus, 1, Chlorine, 3)
                .buildAndRegister();
        //  24029 Ammonium Sulfate
        AmmoniumSulfate = Builder("ammonium_sulfate")
                .fluid()
                .color(0x5858F4)
                .buildAndRegister()
                .setFormula("(NH2)4SO4", true);
        //  24030 Ammonium Persulfate
        AmmoniumPersulfate = Builder("ammonium_persulfate")
                .fluid()
                .color(0x4242B7)
                .buildAndRegister()
                .setFormula("(NH4)2S2O8", true);
        //  24031 Hydroxylamine Disulfate
        HydroxylamineDisulfate = Builder("hydroxylamine_disulfate")
                .fluid()
                .color(0x91A6D2)
                .buildAndRegister()
                .setFormula("(NH3OH)2(NH4)2(SO4)2", true);
        //  24032 Hydroxylamine
        Hydroxylamine = Builder("hydroxylamine")
                .fluid()
                .color(0x91C791)
                .components(Hydrogen, 3, Nitrogen, 1, Oxygen, 1)
                .buildAndRegister()
                .setFormula("H3NO", true);
        //  24033 Ammonium Nitrate
        AmmoniumNitrate = Builder("ammonium_nitrate")
                .fluid()
                .color(0x454066)
                .components(Nitrogen, 2, Hydrogen, 4, Oxygen, 3)
                .buildAndRegister()
                .setFormula("NH4NO3", true);
        //  24034 Thallium Sulfate
        ThalliumSulfate = Builder("thallium_sulfate")
                .dust()
                .color(0x9C222C)
                .iconSet(MaterialIconSet.METALLIC)
                .flags(DISABLE_DECOMPOSITION)
                .components(Thallium, 2, Sulfur, 1, Oxygen, 4)
                .buildAndRegister();
        //  24035 Thallium Chloride
        ThalliumChloride = Builder("thallium_chloride")
                .dust()
                .color(0xCC5350)
                .iconSet(MaterialIconSet.SHINY)
                .components(Thallium, 1, Chlorine, 1)
                .buildAndRegister();
        //  24036 Iodized Brine
        IodizedBrine = Builder("iodized_brine")
                .fluid()
                .color(0x525246)
                .buildAndRegister()
                .setFormula("I?", false);
        //  24037 Iodine Brine Mixture
        IodineBrineMixture = Builder("iodine_brine_mixture")
                .fluid()
                .color(0x525234)
                .buildAndRegister()
                .setFormula("I?Cl", false);
        //  24038 Brominated Brine
        BrominatedBrine = Builder("brominated_brine")
                .fluid()
                .color(0xA9A990)
                .buildAndRegister()
                .setFormula("Br?", false);
        //  24039 Iodine Slurry
        IodineSlurry = Builder("iodine_slurry")
                .fluid()
                .color(0x292923)
                .buildAndRegister()
                .setFormula("I?", false);
        //  24040 Sodium Iodate
        SodiumIodate = Builder("sodium_iodate")
                .dust()
                .color(0x0B0B47)
                .iconSet(MaterialIconSet.DULL)
                .components(Sodium, 1, Iodine, 1, Oxygen, 3)
                .buildAndRegister();
        //  24041 Sodium Iodide
        SodiumIodide = Builder("sodium_iodide")
                .dust()
                .color(0x1919A3)
                .iconSet(MaterialIconSet.METALLIC)
                .components(Sodium, 1, Iodine, 1)
                .buildAndRegister();
        //  24042 Sodium Hypochlorite
        SodiumHypochlorite = Builder("sodium_hypochlorite")
                .dust()
                .color(0x2828FF)
                .components(Sodium, 1, Chlorine, 1, Oxygen, 1)
                .buildAndRegister();
        //  24043 Sodium Periodate
        SodiumPeriodate = Builder("sodium_periodate")
                .dust()
                .color(0x050547)
                .iconSet(MaterialIconSet.BRIGHT)
                .components(Sodium, 1, Iodine, 1, Oxygen, 4)
                .buildAndRegister();
        //  24044 Acidic Brominated Brine
        AcidicBrominatedBrine = Builder("acidic_brominated_brine")
                .fluid(FluidStorageKeys.LIQUID, new FluidBuilder().attribute(FluidAttributes.ACID))
                .color(0xC6A76F)
                .buildAndRegister()
                .setFormula("Br?(H2SO4)Cl", true);
        //  24045 Bromine Sulfate Solution
        BromineSulfateSolution = Builder("bromine_sulfate_solution")
                .fluid()
                .color(0xCC9966)
                .buildAndRegister()
                .setFormula("H2SO4Br(H2O)Cl2", true);
        //  24046 Overheated Bromine Sulfate Solution
        OverheatedBromineSulfateSolution = Builder("overheated_bromine_sulfate_solution")
                .fluid()
                .color(0xC69337)
                .iconSet(MaterialIconSet.DULL)
                .buildAndRegister()
                .setFormula("H2SO4Br(H2O)2Cl2", true);
        //  24047 Wet Bromine
        WetBromine = Builder("wet_bromine")
                .fluid()
                .color(0xDB5C5C)
                .iconSet(MaterialIconSet.DULL)
                .buildAndRegister()
                .setFormula("Br(H2O)", true);
        //  24048 Debrominated Water
        DebrominatedWater = Builder("debrominated_water")
                .fluid()
                .color(0x24A3A3)
                .components(Hydrogen, 2, Oxygen, 1)
                .buildAndRegister();
        //  24049 Palladium Chloride
        PalladiumChloride = Builder("palladium_chloride")
                .dust()
                .color(0xAFB5BC)
                .iconSet(MaterialIconSet.SHINY)
                .components(Palladium, 1, Chlorine, 2)
                .buildAndRegister();
        //  24050 Palladium on Carbon
        PalladiumOnCarbon = Builder("palladium_on_carbon")
                .dust()
                .color(0x480104)
                .iconSet(MaterialIconSet.DULL)
                .flags(DISABLE_DECOMPOSITION)
                .components(Palladium, 1, Carbon, 1)
                .buildAndRegister();
        //  24051 Potassium Permanganate
        PotassiumPermanganate = Builder("potassium_permanganate")
                .dust()
                .color(0x871D82)
                .iconSet(MaterialIconSet.DULL)
                .components(Potassium, 1, Manganese, 1, Oxygen, 4)
                .buildAndRegister();
        //  24052 Potassium Manganate
        PotassiumManganate = Builder("potassium_manganate")
                .dust()
                .color(0x873883)
                .iconSet(MaterialIconSet.METALLIC)
                .components(Potassium, 2, Manganese, 1, Oxygen, 4)
                .buildAndRegister();
        //  24053 Tin Chloride
        TinChloride = Builder("tin_chloride")
                .dust()
                .fluid()
                .color(0xDBDBDB)
                .iconSet(MaterialIconSet.METALLIC)
                .components(Tin, 1, Chlorine, 2)
                .buildAndRegister();
        //  24054 Silver Oxide
        SilverOxide = Builder("silver_oxide")
                .dust()
                .color(0xA4A4A4)
                .components(Silver, 2, Oxygen, 1)
                .buildAndRegister();
        //  24055 Sodium Fluoride
        SodiumFluoride = Builder("sodium_fluoride")
                .dust()
                .color(0x460012)
                .iconSet(MaterialIconSet.DULL)
                .components(Sodium, 1, Fluorine, 1)
                .buildAndRegister();
        //  24056 Zn-Fe-Al-Cl Catalyst
        ZnFeAlClCatalyst = Builder("zn_fe_al_cl_catalyst")
                .dust()
                .color(0xC522A9)
                .iconSet(MaterialIconSet.DULL)
                .components(Zinc, 1, Iron, 1, Aluminium, 1, Chlorine, 1)
                .buildAndRegister();
        //  24057 Sodium Nitrite
        SodiumNitrite = Builder("sodium_nitrite")
                .dust()
                .color(0x205CA4)
                .iconSet(MaterialIconSet.DULL)
                .components(Sodium, 1, Nitrogen, 1, Oxygen, 2)
                .buildAndRegister();
        //  24058 Sodium Nitrate
        SodiumNitrate = Builder("sodium_nitrate")
                .dust()
                .fluid()
                .color(0xEB9E3F)
                .iconSet(MaterialIconSet.METALLIC)
                .components(Sodium, 1, Nitrogen, 1, Oxygen, 3)
                .buildAndRegister();
        //  24059 Fluoroboric Acid
        FluoroboricAcid = Builder("fluoroboric_acid")
                .fluid(FluidStorageKeys.LIQUID, new FluidBuilder().attribute(FluidAttributes.ACID))
                .color(0xD5811B)
                .components(Hydrogen, 1, Boron, 1, Fluorine, 4)
                .buildAndRegister();
        //  24060 Benzenediazonium Tetrafluoroborate
        BenzenediazoniumTetrafluoroborate = Builder("benzenediazonium_tetrafluoroborate")
                .fluid()
                .color(0xD5C5B2)
                .components(Carbon, 6, Hydrogen, 5, Boron, 1, Fluorine, 4, Nitrogen, 2)
                .buildAndRegister();
        //  24061 Gallium Trichloride
        GalliumTrichloride = Builder("gallium_trichloride")
                .dust()
                .color(0x6EB4FF)
                .iconSet(ROUGH)
                .components(Gallium, 1, Chlorine, 3)
                .buildAndRegister();
        //  24062 Aluminium Trichloride
        AluminiumTrichloride = Builder("aluminium_trichloride")
                .dust()
                .color(0x78C3EB)
                .iconSet(MaterialIconSet.SHINY)
                .flags(DISABLE_DECOMPOSITION)
                .components(Aluminium, 1, Chlorine, 3)
                .buildAndRegister();
        //  24063 Aluminium Hydroxide
        AluminiumHydroxide = Builder("aluminium_hydroxide")
                .dust()
                .color(0xBEBEC8)
                .flags(DISABLE_DECOMPOSITION)
                .components(Aluminium, 1, Oxygen, 3, Hydrogen, 3)
                .buildAndRegister()
                .setFormula("Al(OH)3", true);
        //  24064 Alumina
        Alumina = Builder("alumina")
                .dust()
                .color(0x78c3eb)
                .iconSet(MaterialIconSet.METALLIC)
                .components(Aluminium, 2, Oxygen, 3)
                .buildAndRegister();
        //  24065 Gallium Trioxide
        GalliumTrioxide = Builder("gallium_trioxide")
                .dust()
                .fluid(FluidStorageKeys.LIQUID, new FluidBuilder().temperature(2170))
                .color(0xE4CDFF)
                .iconSet(MaterialIconSet.METALLIC)
                .components(Gallium, 1, Oxygen, 3)
                .buildAndRegister();
        //  24066 Gallium Nitride
        GalliumNitride = Builder("gallium_nitride")
                .ingot()
                .color(0xFFF458)
                .iconSet(MaterialIconSet.SHINY)
                .flags(GENERATE_PLATE)
                .components(Gallium, 1, Nitrogen, 1)
                .buildAndRegister();
        //  24067 Fullerene
        Fullerene = Builder("fullerene")
                .ingot()
                .color(0x72556A)
                .iconSet(MaterialIconSet.BRIGHT)
                .flags(DISABLE_DECOMPOSITION, NO_SMELTING, GENERATE_PLATE, GENERATE_FOIL, GENERATE_ROD, GENERATE_RING, GENERATE_FRAME)
                .components(Carbon, 60)
                .buildAndRegister();
        //  24068 Geodesic Polyarene
        GeodesicPolyarene = Builder("geodesic_polyarene")
                .dust()
                .color(0x9E81A8)
                .iconSet(MaterialIconSet.METALLIC)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 60, Hydrogen, 30)
                .buildAndRegister();
        //  24069 Ti-Al Catalyst
        TiAlCatalyst = Builder("ti_al_catalyst")
                .dust()
                .color(0x6600CC)
                .iconSet(MaterialIconSet.DULL)
                .components(Titanium, 1, Aluminium, 1)
                .buildAndRegister();
        //  24070 Potassium Cyanide
        PotassiumCyanide = Builder("potassium_cyanide")
                .dust()
                .color(0x9EF3D0)
                .iconSet(ROUGH)
                .components(Potassium, 1, Carbon, 1, Nitrogen, 1)
                .buildAndRegister();
        //  24071 Potassium Bromide
        PotassiumBromide = Builder("potassium_bromide")
                .dust()
                .color(0x615057)
                .iconSet(MaterialIconSet.DULL)
                .components(Potassium, 1, Bromine, 1)
                .buildAndRegister();
        //  24072 Bismuth Vanadate
        BismuthVanadate = Builder("bismuth_vanadate")
                .dust()
                .color(0xFFAF33)
                .iconSet(MaterialIconSet.SHINY)
                .components(Bismuth, 1, Vanadium, 1, Oxygen, 4)
                .buildAndRegister();
        //  24073 Bismuth Vanadate Solution
        BismuthVanadateSolution = Builder("bismuth_vanadate_solution")
                .fluid()
                .color(0xFFAF33)
                .flags(DISABLE_DECOMPOSITION)
                .components(Bismuth, 1, Vanadium, 1, Hydrogen, 2, Oxygen, 5)
                .buildAndRegister()
                .setFormula("BiVO4(H2O)", true);
        //  24074 Ammonium Vanadate
        AmmoniumVanadate = Builder("ammonium_vanadate")
                .dust()
                .color(0xCC9933)
                .iconSet(ROUGH)
                .flags(DISABLE_DECOMPOSITION)
                .components(Nitrogen, 1, Hydrogen, 4, Vanadium, 1, Oxygen, 3)
                .buildAndRegister();
        //  24075 Vanadium Slag
        VanadiumSlag = Builder("vanadium_slag")
                .dust()
                .color(0xCC9933)
                .iconSet(MaterialIconSet.DULL)
                .flags(DISABLE_DECOMPOSITION)
                .components(Vanadium, 1, Oxygen, 1)
                .buildAndRegister();
        //  24076 Bismuth Nitrate Solution
        BismuthNitrateSolution = Builder("bismuth_nitrate_solution")
                .fluid()
                .color(0x3ABF50)
                .components(Bismuth, 1, Nitrogen, 3, Oxygen, 10, Hydrogen, 2)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister()
                .setFormula("Bi(NO3)3(H2O)");
        //  24077 Sodium Vanadate
        SodiumVanadate = Builder("sodium_vanadate")
                .dust()
                .color(0xCC9933)
                .iconSet(MaterialIconSet.BRIGHT)
                .flags(DISABLE_DECOMPOSITION)
                .components(Sodium, 3, Vanadium, 1, Oxygen, 4)
                .buildAndRegister();
        //  24078 Vanadium Waste Solution
        VanadiumWasteSolution = Builder("vanadium_waste_solution")
                .fluid()
                .color(0xA28097)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister()
                .setFormula("NaCl(Na2SO4)(SiO2)(Al(OH)3)");
        //  24079 Sodium Bromide
        SodiumBromide = Builder("sodium_bromide")
                .dust()
                .color(0x830B2B)
                .iconSet(ROUGH)
                .components(Sodium, 1, Bromine, 1)
                .buildAndRegister();
        //  24080 White Phosphorus
        WhitePhosphorus = Builder("white_phosphorus")
                .gem()
                .color(0xECEADD)
                .iconSet(MaterialIconSet.FLINT)
                .flags(DISABLE_DECOMPOSITION)
                .components(Phosphorus, 4)
                .buildAndRegister();
        //  24081 Red Phosphorus
        RedPhosphorus = Builder("red_phosphorus")
                .gem()
                .color(0x77040E)
                .iconSet(MaterialIconSet.FLINT)
                .flags(DISABLE_DECOMPOSITION)
                .components(Phosphorus, 4)
                .buildAndRegister();
        //  24082 Violet Phosphorus
        VioletPhosphorus = Builder("violet_phosphorus")
                .gem()
                .color(0x8000FF)
                .iconSet(MaterialIconSet.FLINT)
                .flags(DISABLE_DECOMPOSITION)
                .components(Phosphorus, 4)
                .buildAndRegister();
        //  24083 Black Phosphorus
        BlackPhosphorus = Builder("black_phosphorus")
                .gem()
                .color(0x36454F)
                .iconSet(MaterialIconSet.FLINT)
                .flags(DISABLE_DECOMPOSITION)
                .components(Phosphorus, 4)
                .buildAndRegister();
        //  24084 Blue Phosphorus
        BluePhosphorus = Builder("blue_phosphorus")
                .gem()
                .color(0x9BE3E4)
                .iconSet(MaterialIconSet.FLINT)
                .flags(DISABLE_DECOMPOSITION)
                .components(Phosphorus, 4)
                .buildAndRegister();
        //  24085 Wollastonite
        Wollastonite = Builder("wollastonite")
                .dust()
                .color(0xF0F0F0)
                .flags(DECOMPOSITION_BY_CENTRIFUGING)
                .components(Quicklime, 2, SiliconDioxide, 3)
                .buildAndRegister()
                .setFormula("CaSiO3", true);
        //  24086 Phosphorene
        Phosphorene = Builder("phosphorene")
                .ingot()
                .color(0x273239)
                .iconSet(MaterialIconSet.SHINY)
                .flags(DISABLE_DECOMPOSITION, GENERATE_FOIL)
                .components(Phosphorus, 4)
                .buildAndRegister();
        //  24087 Phosphoryl Chloride
        PhosphorylChloride = Builder("phosphoryl_chloride")
                .fluid()
                .color(0xE8BB5B)
                .components(Phosphorus, 1, Oxygen, 1, Chlorine, 3)
                .buildAndRegister();
        //  24088 Phosphine
        Phosphine = Builder("phosphine")
                .gas()
                .color(0xACB330)
                .flags(DECOMPOSITION_BY_ELECTROLYZING, FLAMMABLE)
                .components(Phosphorus, 1, Hydrogen, 3)
                .buildAndRegister();
        //  24089 Copper Chloride
        CopperChloride = Builder("copper_chloride")
                .dust()
                .color(0x3FB3B8)
                .iconSet(ROUGH)
                .components(Copper, 1, Chlorine, 2)
                .buildAndRegister();
        //  24090 Lithium Hydroxide
        LithiumHydroxide = Builder("lithium_hydroxide")
                .dust()
                .color(0xDECAFA)
                .iconSet(MaterialIconSet.FINE)
                .components(Lithium, 1, Oxygen, 1, Hydrogen, 1)
                .buildAndRegister();

        //  24091 Lithiuim Amalgam
        LithiumAmalgam = Builder("lithium_amalgam")
                .fluid()
                .color(0xAEA7D4)
                .iconSet(MaterialIconSet.FINE)
                .flags(DISABLE_DECOMPOSITION)
                .components(Mercury, 1, Lithium, 1)
                .buildAndRegister();
        //  24092 Hexafluoride Enriched Naquadah Solution
        HexafluorideEnrichedNaquadahSolution = Builder("hexafluoride_enriched_naquadah_solution")
                .fluid()
                .color(0x868D7F)
                .components(NaquadahEnriched, 1, Trinium, 1, Fluorine, 6)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24093 Xenon Hexafluoro Enriched Naquadate
        XenonHexafluoroEnrichedNaquadate = Builder("xenon_hexafluoro_enriched_naquadate")
                .fluid()
                .color(0x255A55)
                .components(Xenon, 1, NaquadahEnriched, 1, Fluorine, 6)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24094 Enriched Naquadah Residue Solution
        EnrichedNaquadahResidueSolution = Builder("enriched_naquadah_residue_solution")
                .fluid()
                .color(0x868D7F)
                .iconSet(MaterialIconSet.DULL)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister()
                .setFormula("XeAuSbF6S2?");
        //  24095 Xenoauric Fluoroantimonic Acid
        XenoauricFluoroantimonicAcid = Builder("xenoauric_fluoroantimonic_acid")
                .fluid(FluidStorageKeys.LIQUID, new FluidBuilder().attribute(FluidAttributes.ACID))
                .color(0xE0BD74)
                .components(Xenon, 1, Gold, 1, Antimony, 1, Fluorine, 6)
                .buildAndRegister();
        //  24096 Gold Chloride
        GoldChloride = Builder("gold_chloride")
                .fluid()
                .color(0xCCCC66)
                .components(Gold, 2, Chlorine, 6)
                .buildAndRegister();
        //  24097 Bromine Trifluoride
        BromineTrifluoride = Builder("bromine_trifluoride")
                .fluid()
                .color(0xA88E57)
                .components(Bromine, 1, Fluorine, 3)
                .buildAndRegister();
        //  24098 Gold Trifluoride
        GoldTrifluoride = Builder("gold_trifluoride")
                .dust()
                .color(0xE8C478)
                .iconSet(MaterialIconSet.BRIGHT)
                .components(Gold, 1, Fluorine, 3)
                .buildAndRegister();
        //  24099 Naquadria Caesiumfluoride
        NaquadriaCaesiumfluoride = Builder("naquadria_caesiumfluoride")
                .fluid()
                .color(0xAAEB69)
                .components(Naquadria, 1, Fluorine, 3, Caesium, 1)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister()
                .setFormula("*Nq*F2CsF", true);
        //  24100 Acidic Naquadria Caesiumfluoride
        AcidicNaquadriaCaesiumfluoride = Builder("acidic_naquadria_caesiumfluoride")
                .fluid()
                .color(0x75EB00)
                .components(Naquadria, 1, Fluorine, 3, Caesium, 1, Sulfur, 2, Oxygen, 8)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister()
                .setFormula("*Nq*F2CsF(SO4)2", true);
        //  24101 Nitrosonium Octafluoroxenate
        NitrosoniumOctafluoroxenate = Builder("nitrosonium_octafluoroxenate")
                .fluid()
                .color(0x953D9F)
                .components(NitrogenDioxide, 2, Xenon, 1, Fluorine, 8)
                .buildAndRegister()
                .setFormula("(NO2)2XeF8", true);
        //  24102 Naquadria Caesium Xenonnonfluoride
        NaquadriaCaesiumXenonnonfluoride = Builder("naquadria_caesium_xenonnonfluoride")
                .fluid()
                .color(0x54C248)
                .components(Naquadria, 1, Caesium, 1, Xenon, 1, Fluorine, 9)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24103 Radon Naquadria Octafluoride
        RadonNaquadriaOctafluoride = Builder("radon_naquadria_octafluoride")
                .fluid()
                .color(0x85F378)
                .components(Radon, 1, Naquadria, 1, Fluorine, 8)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24104 Caesium Xenontrioxide Fluoride
        CaesiumXenontrioxideFluoride = Builder("caesium_xenontrioxide_fluoride")
                .fluid()
                .color(0x5067D7)
                .flags(DISABLE_DECOMPOSITION)
                .components(Caesium, 1, Xenon, 1, Oxygen, 3, Fluorine, 1)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24105 Radon Trioxide
        RadonTrioxide = Builder("radon_trioxide")
                .fluid()
                .color(0x9A6DD7)
                .components(Radon, 1, Oxygen, 3)
                .buildAndRegister();
        //  24106 Cesium Fluoride
        CaesiumFluoride = Builder("caesium_fluoride")
                .fluid()
                .color(0xFF7A5F)
                .components(Caesium, 1, Fluorine, 1)
                .buildAndRegister();
        //  24107 Xenon Trioxide
        XenonTrioxide = Builder("xenon_trioxide")
                .fluid()
                .color(0x359FC3)
                .components(Xenon, 1, Oxygen, 3)
                .buildAndRegister();
        //  24108 Hexafluoride Naquadria Solution
        HexafluorideNaquadriaSolution = Builder("hexafluoride_naquadria_solution")
                .fluid()
                .color(0x25C213)
                .components(Naquadria, 1, Fluorine, 6)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24109 Naquadria Residue Solution
        NaquadriaResidueSolution = Builder("naquadria_residue_solution")
                .fluid()
                .color(0x25C213)
                .iconSet(MaterialIconSet.DULL)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister()
                .setFormula("InPS6?", true);
        //  24110 Radon Difluoride
        RadonDifluoride = Builder("radon_difluoride")
                .fluid()
                .color(0x8B7EFF)
                .components(Radon, 1, Fluorine, 2)
                .buildAndRegister();
        //  24111 Heavy Alkali Chloride Solution
        HeavyAlkaliChlorideSolution = Builder("heavy_alkali_chloride_solution")
                .fluid()
                .color(0x8F5353)
                .flags(DISABLE_DECOMPOSITION)
                .components(Rubidium, 1, Caesium, 2, Chlorine, 6, Water, 2)
                .buildAndRegister()
                .setFormula("RbCl(CsCl)2Cl3(H2O)2", true);
        //  24112 Stannic Chloride
        StannicChloride = Builder("stannic_chloride")
                .fluid()
                .color(0x33BBF5)
                .components(Tin, 1, Chlorine, 4)
                .buildAndRegister();
        //  24113 Rubidium Chlorostannate
        RubidiumChlorostannate = Builder("rubidium_chlorostannate")
                .dust()
                .color(0xBD888A)
                .iconSet(MaterialIconSet.METALLIC)
                .components(Rubidium, 2, Tin, 1, Chlorine, 6)
                .buildAndRegister();
        //  24114 Caesium Chlorostannate
        CaesiumChlorostannate = Builder("caesium_chlorostannate")
                .dust()
                .color(0xBDAD88)
                .iconSet(MaterialIconSet.SHINY)
                .components(Caesium, 2, Tin, 1, Chlorine, 6)
                .buildAndRegister();
        //  24115 Germanium Dioxide
        GermaniumDioxide = Builder("germanium_dioxide")
                .dust()
                .color(0x666666)
                .flags(DISABLE_DECOMPOSITION)
                .components(Germanium, 1, Oxygen, 2)
                .buildAndRegister();
        //  24116 Roasted Sphalerite
        RoastedSphalerite = Builder("roasted_sphalerite")
                .dust()
                .color(0xAC8B5C)
                .iconSet(MaterialIconSet.FINE)
                .flags(DISABLE_DECOMPOSITION)
                .components(Gallium, 1, GermaniumDioxide, 1)
                .buildAndRegister();
        //  24117 Zinc Rich Sphalerite
        ZincRichSphalerite = Builder("zinc_rich_sphalerite")
                .dust()
                .color(0xC3AC8F)
                .iconSet(MaterialIconSet.METALLIC)
                .flags(DISABLE_DECOMPOSITION)
                .components(Zinc, 2, RoastedSphalerite, 3)
                .buildAndRegister()
                .setFormula("Zn2(GaGeO2)", true);
        //  24118 Zinc Oxide
        ZincOxide = Builder("zinc_oxide")
                .dust()
                .color(0xB85C34)
                .flags(DECOMPOSITION_BY_ELECTROLYZING)
                .components(Zinc, 1, Oxygen, 1)
                .buildAndRegister();
        //  24119 Waelz Oxide
        WaelzOxide = Builder("waelz_oxide")
                .dust()
                .color(0xB8B8B8)
                .iconSet(MaterialIconSet.FINE)
                .flags(DISABLE_DECOMPOSITION)
                .components(Zinc, 1, GermaniumDioxide, 1)
                .buildAndRegister();
        //  24120 Waelz Slag
        WaelzSlag = Builder("waelz_slag")
                .dust()
                .color(0xAC8B5C)
                .iconSet(ROUGH)
                .flags(DISABLE_DECOMPOSITION)
                .components(Gallium, 1, Zinc, 1, Sulfur, 1, Oxygen, 4)
                .buildAndRegister();
        //  24121 Impure Germanium Dioxide
        ImpureGermaniumDioxide = Builder("impure_germanium_dioxide")
                .dust()
                .color(0x666666)
                .iconSet(ROUGH)
                .flags(DISABLE_DECOMPOSITION)
                .components(GermaniumDioxide, 1)
                .buildAndRegister()
                .setFormula("GeO2?", true);
        //  24122 Germanium Tetrachloride
        GermaniumTetrachloride = Builder("germanium_tetrachloride")
                .fluid()
                .color(0x787878)
                .flags(DISABLE_DECOMPOSITION)
                .components(Germanium, 1, Chlorine, 4)
                .buildAndRegister();
        //  24123 Molybdenum Trioxide
        MolybdenumTrioxide = Builder("molybdenum_trioxide")
                .dust()
                .color(0xCBCFDA)
                .iconSet(ROUGH)
                .flags(DISABLE_DECOMPOSITION)
                .components(Molybdenum, 1, Oxygen, 3)
                .buildAndRegister();
        //  24124 Lead Chloride
        LeadChloride = Builder("lead_chloride")
                .dust()
                .color(0xF3F3F3)
                .iconSet(ROUGH)
                .components(Lead, 1, Chlorine, 2)
                .buildAndRegister();
        //  24125 Perrhenic Acid
        PerrhenicAcid = Builder("perrhenic_acid")
                .dust()
                .color(0xE6DC70)
                .iconSet(MaterialIconSet.SHINY)
                .flags(DISABLE_DECOMPOSITION)
                .components(Hydrogen, 1, Rhenium, 1, Oxygen, 4)
                .buildAndRegister();
        //  24126 Ammonium Perrhenate
        AmmoniumPerrhenate = Builder("ammonium_perrhenate")
                .dust()
                .fluid()
                .color(0xA69970)
                .iconSet(MaterialIconSet.METALLIC)
                .flags(DISABLE_DECOMPOSITION)
                .components(Nitrogen, 1, Hydrogen, 4, Rhenium, 1, Oxygen, 4)
                .buildAndRegister();
        //  24127 Niobium Pentoxide
        NiobiumPentoxide = Builder("niobium_pentoxide")
                .dust()
                .color(0xBAB0C3)
                .iconSet(ROUGH)
                .components(Niobium, 2, Oxygen, 5)
                .buildAndRegister();
        //  24128 Tantalum Pentoxide
        TantalumPentoxide = Builder("tantalum_pentoxide")
                .dust()
                .color(0x72728A)
                .iconSet(ROUGH)
                .components(Tantalum, 2, Oxygen, 5)
                .buildAndRegister();
        //  24129 Calcium Difluoride
        CalciumDifluoride = Builder("calcium_difluoride")
                .dust()
                .color(0xFFFC9E)
                .iconSet(ROUGH)
                .components(Calcium, 1, Fluorine, 2)
                .buildAndRegister();
        //  24130 Manganese Difluoride
        ManganeseDifluoride = Builder("manganese_difluoride")
                .dust()
                .color(0xEF4B3D)
                .iconSet(ROUGH)
                .components(Manganese, 1, Fluorine, 2)
                .buildAndRegister();
        //  24131 Calcium Carbide
        CalciumCarbide = Builder("calcium_carbide")
                .dust()
                .color(0x807B70)
                .iconSet(MaterialIconSet.DULL)
                .components(Calcium, 1, Carbon, 2)
                .buildAndRegister();
        //  24132 Calcium Hydroxide
        CalciumHydroxide = Builder("calcium_hydroxide")
                .dust()
                .color(0x5F8764)
                .iconSet(ROUGH)
                .flags(DISABLE_DECOMPOSITION)
                .components(Calcium, 1, Hydrogen, 2, Oxygen, 2)
                .buildAndRegister()
                .setFormula("Ca(OH)2", true);
        //  24133 Sodium Tellurite
        SodiumTellurite = Builder("sodium_tellurite")
                .dust()
                .color(0xC6C9BE)
                .iconSet(ROUGH)
                .flags(DISABLE_DECOMPOSITION)
                .components(Sodium, 2, Tellurium, 1, Oxygen, 3)
                .buildAndRegister();
        //  24134 Selenium Dioxide
        SeleniumDioxide = Builder("selenium_dioxide")
                .dust()
                .color(0xE0DDD8)
                .iconSet(MaterialIconSet.METALLIC)
                .flags(DISABLE_DECOMPOSITION)
                .components(Selenium, 1, Oxygen, 2)
                .buildAndRegister();
        //  24135 Tellurium Dioxide
        TelluriumDioxide = Builder("tellurium_dioxide")
                .dust()
                .color(0xE3DDB8)
                .iconSet(MaterialIconSet.METALLIC)
                .flags(DISABLE_DECOMPOSITION)
                .components(Tellurium, 1, Oxygen, 2)
                .buildAndRegister();
        //  24136 Selenous Acid
        SelenousAcid = Builder("selenous_acid")
                .dust()
                .color(0xE0E083)
                .iconSet(MaterialIconSet.SHINY)
                .flags(DISABLE_DECOMPOSITION)
                .components(Hydrogen, 2, Selenium, 1, Oxygen, 3)
                .buildAndRegister();
        //  24137 GST Glass
        GSTGlass = Builder("gst_glass")
                .ingot()
                .fluid()
                .color(0xCFFFFF)
                .iconSet(MaterialIconSet.SHINY)
                .flags(GENERATE_PLATE, NO_SMASHING, NO_WORKING, DECOMPOSITION_BY_CENTRIFUGING)
                .components(Germanium, 2, Antimony, 2, Tellurium, 5)
                .blastTemp(873, BlastProperty.GasTier.MID)
                .buildAndRegister();
        //  24138 ZBLAN Glass
        ZBLANGlass = Builder("zblan_glass")
                .ingot()
                .fluid()
                .color(0xACB4BC)
                .iconSet(MaterialIconSet.SHINY)
                .flags(NO_SMASHING, NO_WORKING, DISABLE_DECOMPOSITION, GENERATE_FINE_WIRE)
                .components(Zirconium, 5, Barium, 2, Lanthanum, 1, Aluminium, 1, Sodium, 2, Fluorine, 6)
                .buildAndRegister()
                .setFormula("(ZrF4)5(BaF2)2(LaF3)(AlF3)(NaF)2", true);
        //  24139 Erbium-doped ZBLAN Glass
        ErbiumDopedZBLANGlass = Builder("erbium_doped_zblan_glass")
                .ingot()
                .color(0x505444)
                .iconSet(MaterialIconSet.BRIGHT)
                .flags(NO_SMASHING, NO_WORKING, DISABLE_DECOMPOSITION, GENERATE_PLATE)
                .components(ZBLANGlass, 1, Erbium, 1)
                .buildAndRegister()
                .setFormula("(ZrF4)5(BaF2)2(LaF3)(AlF3)(NaF)2Er", true);
        //  24140 PraseodymiumDopedZBLANGlass
        PraseodymiumDopedZBLANGlass = Builder("praseodymium_doped_zblan_glass")
                .ingot()
                .color(0xC5C88D)
                .iconSet(MaterialIconSet.BRIGHT)
                .flags(NO_SMASHING, NO_WORKING, DISABLE_DECOMPOSITION, GENERATE_PLATE)
                .components(ZBLANGlass, 1, Praseodymium, 1)
                .buildAndRegister()
                .setFormula("(ZrF4)5(BaF2)2(LaF3)(AlF3)(NaF)2Pr", true);
        //  24141 Silicon Tetrachloride
        SiliconTetrachloride = Builder("silicon_tetrachloride")
                .fluid()
                .color(0x5B5B7A)
                .flags(DISABLE_DECOMPOSITION)
                .components(Silicon, 1, Chlorine, 4)
                .buildAndRegister();
        //  24142 Cadmium Sulfide
        CadmiumSulfide = Builder("cadmium_sulfide")
                .dust()
                .color(0xC8C43C)
                .flags(DECOMPOSITION_BY_ELECTROLYZING, GENERATE_PLATE)
                .iconSet(MaterialIconSet.METALLIC)
                .components(Cadmium, 1, Sulfur, 1)
                .buildAndRegister();
        //  24143 Silicon Carbide
        SiliconCarbide = Builder("silicon_carbide")
                .dust()
                .fluid()
                .color(0x4D4D4D)
                .iconSet(MaterialIconSet.METALLIC)
                .flags(GENERATE_FINE_WIRE)
                .components(Silicon, 1, Carbon, 1)
                .blastTemp(2500, BlastProperty.GasTier.HIGH, GTValues.VA[GTValues.UV])
                .cableProperties(GTValues.V[GTValues.UHV], 6, 8)
                .buildAndRegister();
        //  24144 Chromium Germanium Telluride
        ChromiumGermaniumTelluride = Builder("chromium_germanium_telluride")
                .ingot()
                .fluid()
                .color(0x8F103E)
                .iconSet(MaterialIconSet.METALLIC)
                .flags(GENERATE_ROD, GENERATE_LONG_ROD)
                .components(Chromium, 1, Germanium, 1, Tellurium, 3)
                .blastTemp(2900, BlastProperty.GasTier.HIGHER)
                .buildAndRegister();
        //  24145 Magnetic Chromium Germanium Telluride
        ChromiumGermaniumTellurideMagnetic = Builder("magnetic_chromium_germanium_telluride")
                .ingot()
                .color(0x8F103E)
                .iconSet(MaterialIconSet.MAGNETIC)
                .flags(GENERATE_ROD, GENERATE_LONG_ROD, IS_MAGNETIC)
                .components(ChromiumGermaniumTelluride, 1)
                .ingotSmeltInto(ChromiumGermaniumTelluride)
                .arcSmeltInto(ChromiumGermaniumTelluride)
                .macerateInto(ChromiumGermaniumTelluride)
                .buildAndRegister();
        ChromiumGermaniumTelluride.getProperty(PropertyKey.INGOT).setMagneticMaterial(ChromiumGermaniumTellurideMagnetic);
        //  24146 Lithium Fluoride
        LithiumFluoride = Builder("lithium_fluoride")
                .dust()
                .color(0x9BAFDB)
                .iconSet(ROUGH)
                .components(Lithium, 1, Fluorine, 1)
                .buildAndRegister();
        //  24147 Barium Carbonate
        BariumCarbonate = Builder("barium_carbonate")
                .dust()
                .color(0x425A73)
                .iconSet(ROUGH)
                .components(Barium, 1, Carbon, 1, Oxygen, 3)
                .buildAndRegister();
        //  24148 Carbon Disulfide
        CarbonDisulfide = Builder("carbon_disulfide")
                .fluid()
                .color(0x1F80C8)
                .components(Carbon, 1, Sulfur, 2)
                .buildAndRegister();
        //  24149 Sodium Thiosulfate
        SodiumThiosulfate = Builder("sodium_thiosulfate")
                .dust()
                .color(0x1436A7)
                .iconSet(ROUGH)
                .components(Sodium, 2, Sulfur, 2, Oxygen, 3)
                .buildAndRegister();
        //  24150 Cadmium Selenide
        CadmiumSelenide = Builder("cadmium_selenide")
                .dust()
                .color(0x983034)
                .flags(DECOMPOSITION_BY_ELECTROLYZING)
                .iconSet(MaterialIconSet.METALLIC)
                .components(Cadmium, 1, Selenium, 1)
                .buildAndRegister();
        //  24151 Thallium Copper Chloride Antiferromagnetic
        ThalliumCopperChloride = Builder("thallium_copper_chloride")
                .ingot()
                .fluid()
                .color(0x3C5CB5)
                .iconSet(MaterialIconSet.MAGNETIC)
                .flags(GENERATE_FINE_WIRE)
                .components(Thallium, 1, Copper, 1, Chlorine, 3)
                .buildAndRegister();
        //  24152 Plutonium Trihydride
        PlutoniumTrihydride = Builder("plutonium_trihydride")
                .dust()
                .color(0x140002)
                .iconSet(MaterialIconSet.SHINY)
                .flags(DISABLE_DECOMPOSITION)
                .components(Plutonium239, 1, Hydrogen, 3)
                .buildAndRegister()
                .setFormula("PuH3", true);
        //  24153 Plutonium Phosphide
        PlutoniumPhosphide = Builder("plutonium_phosphide")
                .ingot()
                .color(0x1F0104)
                .iconSet(MaterialIconSet.MAGNETIC)
                .flags(GENERATE_PLATE, GENERATE_ROD, GENERATE_LONG_ROD)
                .components(Plutonium239, 1, Phosphorus, 1)
                .buildAndRegister()
                .setFormula("PuP", true);
        //  24154 Neptunium Aluminide
        NeptuniumAluminide = Builder("neptunium_aluminide")
                .ingot()
                .fluid()
                .color(0x5E228F)
                .iconSet(MaterialIconSet.MAGNETIC)
                .flags(GENERATE_PLATE, GENERATE_ROD, GENERATE_LONG_ROD)
                .components(Neptunium, 1, Aluminium, 3)
                .blastTemp(1568, BlastProperty.GasTier.HIGHER, GTValues.VA[GTValues.ZPM])
                .buildAndRegister()
                .setFormula("NpAl3", true);
        //  24155 Bismuth Trioxide
        BismuthTrioxide = Builder("bismuth_trioxide")
                .dust()
                .color(0xF5EF42)
                .iconSet(MaterialIconSet.FINE)
                .components(Bismuth, 2, Oxygen, 3)
                .buildAndRegister();
        //  24156 Ferric Oxide
        FerricOxide = Builder("ferric_oxide")
                .dust()
                .color(0x915A5A)
                .iconSet(ROUGH)
                .components(Iron, 2, Oxygen, 3)
                .buildAndRegister();
        //  24157 Bismuth Ferrite
        BismuthFerrite = Builder("bismuth_ferrite")
                .gem()
                .color(0x43634B)
                .iconSet(MaterialIconSet.MAGNETIC)
                .flags(CRYSTALLIZABLE, GENERATE_PLATE)
                .components(BismuthTrioxide, 2, FerricOxide, 2)
                .buildAndRegister()
                .setFormula("BiFeO3", true);
        //  24158 Bismuth Chalcogenide
        BismuthChalcogenide = Builder("bismuth_chalcogenide")
                .ingot()
                .color(0x91994D)
                .iconSet(MaterialIconSet.SHINY)
                .flags(GENERATE_PLATE, GENERATE_FOIL, DECOMPOSITION_BY_ELECTROLYZING)
                .components(Bismuth, 1, Antimony, 1, Tellurium, 2, Sulfur, 1)
                .buildAndRegister();
        //  24159 Mercury Cadmium Telluride
        MercuryCadmiumTelluride = Builder("mercury_cadmium_telluride")
                .ingot()
                .fluid()
                .color(0x823C80)
                .iconSet(MaterialIconSet.BRIGHT)
                .flags(GENERATE_PLATE, GENERATE_FOIL, GENERATE_FINE_WIRE)
                .components(Mercury, 2, Cadmium, 1, Tellurium, 2)
                .blastTemp(2170, BlastProperty.GasTier.HIGHER, GTValues.VA[GTValues.UHV])
                .buildAndRegister();
        //  24160 Cubic Zirconia
        CubicZirconia = Builder("cubic_zirconia")
                .gem()
                .color(0xFFDFE2)
                .iconSet(MaterialIconSet.DIAMOND)
                .flags(CRYSTALLIZABLE, DISABLE_DECOMPOSITION)
                .components(Zirconium, 1, Oxygen, 2)
                .buildAndRegister();
        //  24161 Bismuth Tellurite
        BismuthTellurite = Builder("bismuth_tellurite")
                .dust()
                .color(0x0E8933)
                .iconSet(MaterialIconSet.DULL)
                .components(Bismuth, 2, Tellurium, 3)
                .buildAndRegister();
        //  24162 Prasiolite
        Prasiolite = Builder("prasiolite")
                .gem()
                .ore(1, 3, false)
                .addOreByproducts(SiliconDioxide)
                .color(0x9EB749)
                .iconSet(MaterialIconSet.QUARTZ)
                .flags(CRYSTALLIZABLE, GENERATE_LENS)
                .components(SiliconDioxide, 5, Iron, 1)
                .buildAndRegister();
        //  24163 Magneto Resonatic
        MagnetoResonatic = Builder("magneto_resonatic")
                .gem()
                .color(0xFF97FF)
                .iconSet(MaterialIconSet.MAGNETIC)
                .components(Prasiolite, 3, BismuthTellurite, 6, CubicZirconia, 1, SteelMagnetic, 1)
                .flags(GENERATE_LENS)
                .buildAndRegister();
        //  24164 Yttrium Trioxide
        YttriumTrioxide = Builder("yttrium_trioxide")
                .dust()
                .color(0x765320)
                .iconSet(MaterialIconSet.DULL)
                .components(Yttrium, 2, Oxygen, 3)
                .buildAndRegister();
        //  24165 Heavy Taranium Fuel
        HeavyTaraniumFuel = Builder("heavy_taranium_fuel")
                .fluid()
                .color(0x141414)
                .flags(DISABLE_DECOMPOSITION)
                .components(Taranium, 1)
                .buildAndRegister();
        //  24166 Medium Taranium Fuel
        MediumTaraniumFuel = Builder("medium_taranium_fuel")
                .fluid()
                .color(0x181818)
                .flags(DISABLE_DECOMPOSITION)
                .components(Taranium, 1)
                .buildAndRegister();
        //  24167 Light Taraniumm Fuel
        LightTaraniumFuel = Builder("light_taranium_fuel")
                .fluid()
                .color(0x1C1C1C)
                .flags(DISABLE_DECOMPOSITION)
                .components(Taranium, 1)
                .buildAndRegister();
        //  24168 Heavy Enriched Taranium Fuel
        HeavyEnrichedTaraniumFuel = Builder("heavy_enriched_taranium_fuel")
                .fluid()
                .color(0x0F1414)
                .flags(DISABLE_DECOMPOSITION)
                .components(Taranium, 1)
                .buildAndRegister();
        //  24169 Medium Enriched Taranium Fuel
        MediumEnrichedTaraniumFuel = Builder("medium_enriched_taranium_fuel")
                .fluid()
                .color(0x0F1818)
                .flags(DISABLE_DECOMPOSITION)
                .components(Taranium, 1)
                .buildAndRegister();
        //  24170 Light Enriched Taranium Fuel
        LightEnrichedTaraniumFuel = Builder("light_enriched_taranium_fuel")
                .fluid()
                .color(0x0F1C1C)
                .flags(DISABLE_DECOMPOSITION)
                .components(Taranium, 1)
                .buildAndRegister();
        //  24171 Adamantite
        Adamantite = Builder("adamantite")
                .dust()
                .color(0xC83C3C)
                .iconSet(ROUGH)
                .components(Adamantium, 3, Oxygen, 4)
                .buildAndRegister();
        //  24172 Unstable Adamantium
        AdamantiumUnstable = Builder("adamantium_unstable")
                .fluid()
                .color(0xFF763C)
                .flags(DISABLE_DECOMPOSITION)
                .components(Adamantium, 1)
                .buildAndRegister();
        //  24173 Energized Orichalcum
        OrichalcumEnergized = Builder("orichalcum_energized")
                .dust()
                .color(0xF4FC0C)
                .iconSet(MaterialIconSet.BRIGHT)
                .flags(DISABLE_DECOMPOSITION)
                .components(Orichalcum, 1)
                .buildAndRegister();
        //  24174 Enriched Adamantium
        AdamantiumEnriched = Builder("adamantium_enriched")
                .dust()
                .color(0x64B4FF)
                .iconSet(ROUGH)
                .flags(DISABLE_DECOMPOSITION)
                .components(Vibranium, 1, RareEarth, 1)
                .buildAndRegister();
        //  24175 Deep Iron
        DeepIron = Builder("deep_iron")
                .dust()
                .color(0x968C8C)
                .iconSet(MaterialIconSet.METALLIC)
                .components(Iron, 2, Trinium, 1, Indium, 1)
                .buildAndRegister();
        //  24176 Unstable Vibranium
        VibraniumUnstable = Builder("vibranium_unstable")
                .fluid()
                .color(0xFF7832)
                .flags(DISABLE_DECOMPOSITION)
                .components(Vibranium, 1)
                .buildAndRegister();
        //  24177 Lanthanum Oxide
        LanthanumOxide = Builder("lanthanum_oxide")
                .dust()
                .color(0x5F7777)
                .iconSet(MaterialIconSet.SHINY)
                .components(Lanthanum, 2, Oxygen, 3)
                .buildAndRegister();
        //  24178 Praseodymium Oxide
        PraseodymiumOxide = Builder("praseodymium_oxide")
                .dust()
                .color(0xD0D0D0)
                .iconSet(MaterialIconSet.METALLIC)
                .components(Praseodymium, 2, Oxygen, 3)
                .buildAndRegister();
        //  24179 Neodymium Oxide
        NeodymiumOxide = Builder("neodymium_oxide")
                .dust()
                .color(0x868686)
                .components(Neodymium, 2, Oxygen, 3)
                .buildAndRegister();
        //  24180 Cerium Oxide
        CeriumOxide = Builder("cerium_oxide")
                .dust()
                .color(0x10937F)
                .iconSet(MaterialIconSet.METALLIC)
                .components(Cerium, 1, Oxygen, 2)
                .buildAndRegister();
        //  24181 Scandium Oxide
        ScandiumOxide = Builder("scandium_oxide")
                .dust()
                .color(0x43964F)
                .iconSet(MaterialIconSet.METALLIC)
                .components(Scandium, 2, Oxygen, 3)
                .buildAndRegister();
        //  24182 Europium Oxide
        EuropiumOxide = Builder("europium_oxide")
                .dust()
                .color(0x20AAAA)
                .iconSet(MaterialIconSet.SHINY)
                .components(Europium, 2, Oxygen, 3)
                .buildAndRegister();
        //  24183 Gadolinium Oxide
        GadoliniumOxide = Builder("gadolinium_oxide")
                .dust()
                .color(0xEEEEFF)
                .iconSet(MaterialIconSet.METALLIC)
                .components(Gadolinium, 2, Oxygen, 3)
                .buildAndRegister();
        //  24184 Samarium Oxide
        SamariumOxide = Builder("samarium_oxide")
                .dust()
                .color(0xFFFFDD)
                .components(Samarium, 2, Oxygen, 3)
                .buildAndRegister();
        //  24185 Yttrium Oxide
        YttriumOxide = Builder("yttrium_oxide")
                .dust()
                .color(0x78544E)
                .iconSet(MaterialIconSet.SHINY)
                .components(Yttrium, 2, Oxygen, 3)
                .buildAndRegister();
        //  24186 Terbium Oxide
        TerbiumOxide = Builder("terbium_oxide")
                .dust()
                .color(0xA264A2)
                .iconSet(MaterialIconSet.METALLIC)
                .components(Terbium, 2, Oxygen, 3)
                .buildAndRegister();
        //  24187 Dysprosium Oxide
        DysprosiumOxide = Builder("dysprosium_oxide")
                .dust()
                .color(0xD273D2)
                .iconSet(MaterialIconSet.METALLIC)
                .components(Dysprosium, 2, Oxygen, 3)
                .buildAndRegister();
        //  24188 Holmium Oxide
        HolmiumOxide = Builder("holmium_oxide")
                .dust()
                .color(0xAF7F2A)
                .iconSet(MaterialIconSet.SHINY)
                .components(Holmium, 2, Oxygen, 3)
                .buildAndRegister();
        //  24189 Erbium Oxide
        ErbiumOxide = Builder("erbium_oxide")
                .dust()
                .color(0xE07A32)
                .iconSet(MaterialIconSet.METALLIC)
                .components(Erbium, 2, Oxygen, 3)
                .buildAndRegister();
        //  24190 Thulium Oxide
        ThuliumOxide = Builder("thulium_oxide")
                .dust()
                .color(0x3B9E8B)
                .components(Thulium, 2, Oxygen, 3)
                .buildAndRegister();
        //  24191 Ytterbium Oxide
        YtterbiumOxide = Builder("ytterbium_oxide")
                .dust()
                .color(0xA9A9A9)
                .components(Ytterbium, 2, Oxygen, 3)
                .buildAndRegister();
        //  24192 Lutetium Oxide
        LutetiumOxide = Builder("lutetium_oxide")
                .dust()
                .color(0x11BBFF)
                .iconSet(MaterialIconSet.METALLIC)
                .components(Lutetium, 2, Oxygen, 3)
                .buildAndRegister();
        //  24193 Manganese Sulfate
        ManganeseSulfate = Builder("manganese_sulfate")
                .dust()
                .color(0xF0F895)
                .iconSet(ROUGH)
                .components(Manganese, 1, Sulfur, 1, Oxygen, 4)
                .buildAndRegister();
        //  24194 Potassium Sulfate
        PotassiumSulfate = Builder("potassium_sulfate")
                .dust()
                .color(0xF4FBB0)
                .iconSet(MaterialIconSet.DULL)
                .components(Potassium, 2, Sulfur, 1, Oxygen, 4)
                .buildAndRegister();
        //  24195 Ammonium Cyanate
        AmmoniumCyanate = Builder("ammonium_cyanate")
                .fluid()
                .color(0x3a5dcf)
                .components(Hydrogen, 4, Nitrogen, 2, Carbon, 1, Oxygen, 1)
                .buildAndRegister()
                .setFormula("NH4CNO", true);
        //  24196 Carbamide
        Carbamide = Builder("carbamide")
                .dust()
                .color(0x16EF57)
                .iconSet(ROUGH)
                .components(Carbon, 1, Hydrogen, 4, Nitrogen, 2, Oxygen, 1)
                .buildAndRegister();
        //  24197 Neodymium-Doped Yttrium Oxide
        NeodymiumDopedYttriumOxide = Builder("neodymium_doped_yttrium_oxide")
                .dust()
                .color(0x5AD55F)
                .iconSet(MaterialIconSet.DULL)
                .buildAndRegister()
                .setFormula("Nd:Y?", false);
        //  24198 Alumina Solution
        AluminaSolution = Builder("alumina_solution")
                .fluid()
                .color(0x6C4DC1)
                .buildAndRegister()
                .setFormula("(Al2O3)(CH2Cl2)(C12H27N)2", true);
        //  24199 Crude Alumina Solution
        CrudeAluminaSolution = Builder("crude_alumina_solution")
                .fluid()
                .color(0x8974C1)
                .buildAndRegister()
                .setFormula("(Al(NO3)3)2(CH2Cl2)(C12H27N)", true);
        //  24200 Carbon Tetrachloride
        CarbonTetrachloride = Builder("carbon_tetrachloride")
                .fluid()
                .color(0x2d8020)
                .components(Carbon, 1, Chlorine, 4)
                .buildAndRegister();
        //  24201 Aluminium Nitrate
        AluminiumNitrate = Builder("aluminium_nitrate")
                .dust()
                .color(0x3AB3AA)
                .iconSet(MaterialIconSet.SHINY)
                .components(Aluminium, 1, Nitrogen, 3, Oxygen, 9)
                .buildAndRegister()
                .setFormula("Al(NO3)3", true);
        //  24202 Unprocessed Nd:YAG Solution
        UnprocessedNdYAGSolution = Builder("unprocessed_nd_yag_solution")
                .fluid()
                .color(0x6f20af)
                .iconSet(MaterialIconSet.DULL)
                .buildAndRegister()
                .setFormula("Nd:YAG", false);
        //  24203 Nd:YAG
        NdYAG = Builder("nd_yag")
                .gem()
                .color(0xD99DE4)
                .iconSet(MaterialIconSet.GEM_VERTICAL)
                .flags(CRYSTALLIZABLE, DECOMPOSITION_BY_CENTRIFUGING, GENERATE_LENS)
                .components(YttriumOxide, 2, NeodymiumOxide, 1, Alumina, 5)
                .buildAndRegister()
                .setFormula("NdY2Al5O12", true);
        //  24204 Au-Pd-C Catalyst
        AuPdCCatalyst = Builder("au_pd_c_catalyst")
                .dust()
                .color(0xB7B305)
                .iconSet(MaterialIconSet.SHINY)
                .components(Gold, 1, PalladiumOnCarbon, 1)
                .buildAndRegister();
        //  24205 Sodium Oxide
        SodiumOxide = Builder("sodium_oxide")
                .dust()
                .color(0x2C96FC)
                .iconSet(MaterialIconSet.BRIGHT)
                .components(Sodium, 2, Oxygen, 1)
                .buildAndRegister();
        //  24206 Sodium Tungstate
        SodiumTungstate = Builder("sodium_tungstate")
                .fluid()
                .color(0x595E54)
                .components(Sodium, 1, Tungsten, 1, Oxygen, 4)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24207 Sodium Phosphotungstate
        SodiumPhosphotungstate = Builder("sodium_phosphotungstate")
                .dust()
                .color(0x4D3635)
                .components(Oxygen, 40, Tungsten, 12, Sodium, 3, Phosphorus, 1)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister()
                .setFormula("(WO3)12Na3PO4", true);
        //  24208 Sodium Molybdate
        SodiumMolybdate = Builder("sodium_molybdate")
                .dust()
                .color(0xCCCC99)
                .iconSet(ROUGH)
                .components(Sodium, 2, Molybdenum, 1, Oxygen, 4)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24209 Sodium Phosphomolybdate
        SodiumPhosphomolybdate = Builder("sodium_phosphomolybdate")
                .dust()
                .color(0xF3E0A8)
                .iconSet(MaterialIconSet.BRIGHT)
                .components(Oxygen, 40, Molybdenum, 12, Sodium, 3, Phosphorus, 1)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister()
                .setFormula("(MoO3)12Na3PO4", true);
        //  24210 Sodium Acetate
        SodiumAcetate = Builder("sodium_acetate")
                .fluid()
                .color(0xC5D624)
                .components(SodiumHydroxide, 1, Ethenone, 1)
                .buildAndRegister()
                .setFormula("C2H3NaO2", true);
        //  24211 Neutron Star Core Material
        NeutronStarCoreMaterial = Builder("neutron_star_core_material")
                .ingot()
                .fluid(FluidStorageKeys.LIQUID, new FluidBuilder().temperature(2147483647))
                .color(0x70ecff)
                .iconSet(MaterialIconSet.BRIGHT)
                .flags(NO_SMASHING, NO_SMELTING, GENERATE_PLATE, GENERATE_ROTOR, GENERATE_FRAME)
                .buildAndRegister();
        //  24212 Magneto Hydrodynamically Constrained Star Matter
        MagnetoHydrodynamicallyConstrainedStarMatter = Builder("magneto_hydrodynamically_constrained_star_matter")
                .ingot()
                .fluid(FluidStorageKeys.LIQUID, new FluidBuilder().temperature(600000000))
//                .iconSet(CUSTOM_MHCSM)
                .flags(NO_SMELTING, GENERATE_PLATE, GENERATE_ROD, GENERATE_LONG_ROD, GENERATE_RING, GENERATE_ROUND, GENERATE_BOLT_SCREW, GENERATE_FRAME, GENERATE_GEAR, GENERATE_SMALL_GEAR)
                .buildAndRegister();
        //  24213 White Dwarf Matter
        WhiteDwarfMatter = Builder("white_dwarf_matter")
                .ingot()
                .fluid(FluidStorageKeys.LIQUID, new FluidBuilder().temperature(288000000))
                .iconSet(MaterialIconSet.MAGNETIC)
                .flags(GENERATE_ROD, GENERATE_LONG_ROD)
                .buildAndRegister();
        //  24214 BlackDwarfMatter
        BlackDwarfMatter = Builder("black_dwarf_matter")
                .ingot()
                .fluid(FluidStorageKeys.LIQUID, new FluidBuilder().temperature(266000000))
                .color(0x000000)
                .iconSet(MaterialIconSet.BRIGHT)
                .cableProperties(GTValues.V[GTValues.UIV], 144, 72, false)
                .buildAndRegister();
        //  24215 Raw Star Matter
        RawStarMatter = Builder("raw_star_matter")
                .fluid(FluidStorageKeys.LIQUID, new FluidBuilder().temperature(600000000))
                .buildAndRegister();
        //  24216 Dimensionally Transcendent Residue
        DimensionallyTranscendentResidue = Builder("dimensionally_transcendent_residue")
                .fluid(FluidStorageKeys.LIQUID, new FluidBuilder().temperature(999999999))
                .buildAndRegister();
        //  24217 Heavy Lepton Mixture
        HeavyLeptonMixture = Builder("heavy_lepton_mixture")
                .fluid(FluidStorageKeys.LIQUID, new FluidBuilder().temperature(524288))
                .buildAndRegister()
                .setFormula(ChatFormatting.OBFUSCATED  + "a" + ChatFormatting.RESET + "§e(t2)u" + ChatFormatting.OBFUSCATED  + "a", true);
        //  24218 Heavy Quarks
        HeavyQuarks = Builder("heavy_quarks")
                .fluid(FluidStorageKeys.LIQUID, new FluidBuilder().temperature(131072))
                .buildAndRegister()
                .setFormula(ChatFormatting.OBFUSCATED + "a"  + ChatFormatting.RESET + "§e(u2)ds" + ChatFormatting.OBFUSCATED + "a" , true);
        //  24219 Gluons
        Gluons = Builder("gluons")
                .fluid(FluidStorageKeys.LIQUID, new FluidBuilder().temperature(2097152))
                .buildAndRegister()
                .setFormula(ChatFormatting.OBFUSCATED  + "a" + ChatFormatting.RESET + "§eg" + ChatFormatting.OBFUSCATED  + "a", false);
        //  24220 Instantons
        Instantons = Builder("instantons")
                .fluid(FluidStorageKeys.LIQUID, new FluidBuilder().temperature(8388608))
                .buildAndRegister()
                .setFormula(ChatFormatting.OBFUSCATED  + "a" + ChatFormatting.RESET + "§ei" + ChatFormatting.OBFUSCATED  + "a", false);
        //  24221 Temporal Fluid
        TemporalFluid = Builder("temporal_fluid")
                .fluid(FluidStorageKeys.LIQUID, new FluidBuilder().temperature(134217728))
                .buildAndRegister()
                .setFormula(ChatFormatting.OBFUSCATED  + "a"  + ChatFormatting.RESET + "§et" + ChatFormatting.OBFUSCATED  + "a", false);
        //  24222 Higgs Bosons
        HiggsBosons = Builder("higgs_bosons")
                .fluid(FluidStorageKeys.LIQUID, new FluidBuilder().temperature(/*0*/1))
                .buildAndRegister()
                .setFormula(ChatFormatting.OBFUSCATED  + "a" + ChatFormatting.RESET + "§eh" + ChatFormatting.OBFUSCATED + "a", false);
        //  24223 Cosmic Computing Mixture
        CosmicComputingMixture = Builder("cosmic_computing_mixture")
                .fluid(FluidStorageKeys.LIQUID, new FluidBuilder().temperature(536870912))
                .components(HeavyLeptonMixture, 32, HeavyQuarks, 8, Gluons, 8, Instantons, 4, TemporalFluid, 4, HiggsBosons, 4)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister()
                .setFormula(ChatFormatting.OBFUSCATED + "aaaaaa", false);
        //  24224 Silica Gel
        SilicaGel = Builder("silica_gel")
                .dust()
                .color(0x9695FD)
                .iconSet(MaterialIconSet.SHINY)
                .components(Silicon, 1, Oxygen, 2)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24225 Silica Gel Base
        SilicaGelBase = Builder("silica_gel_base")
                .fluid()
                .color(0x9695FD)
                .iconSet(ROUGH)
                .components(SiliconDioxide, 1, HydrochloricAcid, 1, SodiumHydroxide, 1, Water, 1)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24226 Nitronium Tetrafluoroborate
        NitroniumTetrafluoroborate = Builder("nitronium_tetrafluoroborate")
                .dust()
                .color(0x787449)
                .iconSet(MaterialIconSet.DULL)
                .components(Sodium, 1, Oxygen, 2, Boron, 1, Fluorine, 4)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24227 Nitrosonium Tetrafluoroborate
        NitrosoniumTetrafluoroborate = Builder("nitrosonium_tetrafluoroborate")
                .dust()
                .color(0xA32A8C)
                .iconSet(ROUGH)
                .components(Sodium, 1, Oxygen, 1, Boron, 1, Fluorine, 4)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24228 Tetrafluoroboric Acid
        TetrafluoroboricAcid = Builder("tetrafluoroboric_acid")
                .fluid()
                .color(0x83A731)
                .components(Hydrogen, 1, Boron, 1, Fluorine, 4)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24229 Nitrogen Monoxide
        NitrogenMonoxide = Builder("nitrogen_monoxide")
                .fluid()
                .color(0x98BCDA)
                .components(Nitrogen, 1, Oxygen, 1)
                .buildAndRegister();
        //  24230 Hydroxylammonium Sulfate
        HydroxylammoniumSulfate = Builder("hydroxylammonium_sulfate")
                .dust()
                .color(0x999933)
                .iconSet(MaterialIconSet.DULL)
                .components(Nitrogen, 2, Hydrogen, 8, Oxygen, 6, Sulfur, 1)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister()
                .setFormula("(NH3OH)2SO4", true);
        //  24231 Potassium Hydroxylaminedisulfonate
        PotassiumHydroxylaminedisulfonate = Builder("potassium_hydroxylaminedisulfonate")
                .dust()
                .color(0x627D25)
                .iconSet(ROUGH)
                .components(Potassium, 2, Nitrogen, 1, Hydrogen, 1, Sulfur, 2, Oxygen, 7)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24232 Potassium Bisulfite
        PotassiumBisulfite = Builder("potassium_bisulfite")
                .dust()
                .color(344314)
                .iconSet(MaterialIconSet.DULL)
                .components(Potassium, 1, Hydrogen, 1, Sulfur, 1, Oxygen, 3)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24233 Potassium Carbonate
        PotassiumCarbonate = Builder("potassium_carbonate")
                .dust()
                .color(0x7C89D9)
                .iconSet(ROUGH)
                .components(Potassium, 2, Carbon, 1, Oxygen, 3)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24234 Nitrous Acid
        NitrousAcid = Builder("nitrous_acid")
                .fluid(FluidStorageKeys.LIQUID, new FluidBuilder().attribute(FluidAttributes.ACID))
                .color(0x7D82A3)
                .components(Hydrogen, 1, Nitrogen, 1, Oxygen, 2)
                .buildAndRegister();
        //  24235 Potassium Nitrite
        PotassiumNitrite = Builder("potassium_nitrite")
                .dust()
                .color(0xB9B9B9)
                .components(Potassium, 1, Nitrogen, 1, Oxygen, 2)
                .buildAndRegister();
        //  24236 Barium Dichloride
        BariumDichloride = Builder("barium_dichloride")
                .dust()
                .color(0xBF6700)
                .iconSet(MaterialIconSet.BRIGHT)
                .components(Barium, 1, Chlorine, 2)
                .buildAndRegister();
        //  24237 Hydroxylamine Hydrochloride
        HydroxylamineHydrochloride = Builder("hydroxylamine_hydrochloride")
                .fluid()
                .color(0x893E28)
                .components(Hydrogen, 4, Oxygen, 1, Nitrogen, 1, Chlorine,1 )
                .buildAndRegister()
                .setFormula("HONH2HCl", true);
        //  24238 Barium Sulfate Suspension
        BariumSulfateSuspension = Builder("barium_sulfate_suspension")
                .fluid()
                .color(0x71560B)
                .components(Barium, 1, Sulfur, 1, Oxygen, 4, Water, 1)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24239 Ammonium Acetate
        AmmoniumAcetate = Builder("ammonium_acetate")
                .dust()
                .color(0x646882)
                .components(Carbon, 2, Hydrogen, 7, Oxygen, 2, Nitrogen, 1)
                .buildAndRegister()
                .setFormula("NH4CH3CO2", true);
        //  24240 Ammonium Carbonate
        AmmoniumCarbonate = Builder("ammonium_carbonate")
                .dust()
                .color(0x7C89D9)
                .components(Carbon, 1, Hydrogen, 8, Oxygen, 3, Nitrogen, 2)
                .buildAndRegister()
                .setFormula("(NH4)2CO3", true);
        //  24241 Free Electron Gas
        FreeElectronGas = Builder("free_electron_gas")
                .gas()
                .color(0x507BB3)
                .buildAndRegister()
                .setFormula(ChatFormatting.OBFUSCATED  + "a" + ChatFormatting.RESET + "§ee" + ChatFormatting.OBFUSCATED + "a", false);
        //  24242 Quark Gluon Plasma
        QuarkGluonPlasma = Builder("quark_gluon_plasma")
                .fluid(FluidStorageKeys.PLASMA, new FluidBuilder().temperature((int) (GTValues.V[GTValues.ZPM] + GTValues.V[GTValues.UHV])/2))
                .color(HeavyQuarks.getMaterialRGB() + Gluons.getMaterialRGB())
                .buildAndRegister()
                .setFormula(ChatFormatting.OBFUSCATED  + "a" + ChatFormatting.RESET + "§e(u2)d(c2)s(t2)bg" + ChatFormatting.OBFUSCATED + "a", false);
        //  24243 Light Quarks
        LightQuarks = Builder("light_quarks")
                .fluid(FluidStorageKeys.LIQUID, new FluidBuilder().temperature((GTValues.VA[GTValues.ZPM] + GTValues.VA[GTValues.UHV])/2))
                .color(QuarkGluonPlasma.getMaterialRGB() - HeavyQuarks.getMaterialRGB())
                .buildAndRegister()
                .setFormula(ChatFormatting.OBFUSCATED  + "a" + ChatFormatting.RESET + "§e(c2)(t2)b" + ChatFormatting.OBFUSCATED + "a", false);
        //  24244 Ferric Catalyst
        FerricCatalyst = Builder("ferric_catalyst")
                .dust()
                .color(FerricOxide.getMaterialRGB() + HydrogenPeroxide.getMaterialRGB())
                .components(FerricOxide, 1, HydrogenPeroxide, 1)
                .buildAndRegister();
        //  24245 Neutron
        Neutron = Builder("neutron")
                .fluid(FluidStorageKeys.PLASMA, new FluidBuilder().temperature((int) GTValues.V[GTValues.UXV]))
                .color(0xFCFCFC)
                .buildAndRegister()
                .setFormula(ChatFormatting.OBFUSCATED  + "a" + ChatFormatting.RESET + "n§e" + ChatFormatting.OBFUSCATED + "a", false);
        //  24246 Helium-Neon Gas
        HeliumNeon = Builder("helium_neon")
                .gas()
                .color(0xFF0080)
                .flags(DECOMPOSITION_BY_CENTRIFUGING)
                .components(Helium, 1, Neon, 1)
                .buildAndRegister();
        //  24247 Polonium Nitrate
        PoloniumNitrate = Builder("polonium_nitrate")
                .fluid()
                .color(Polonium.getMaterialRGB() + NitricAcid.getMaterialRGB())
                .components(Polonium, 1, Nitrogen, 4, Oxygen, 12)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister()
                .setFormula("Po(NO3)4", true);
        //  24248 Polonium Chloride
        PoloniumChloride = Builder("polonium_chloride")
                .dust()
                .color(Polonium.getMaterialRGB() + Chlorine.getMaterialRGB())
                .components(Polonium, 1, Chlorine, 2)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24249 Celestite
        Celestite = Builder("celestite")
                .gem()
                .color(0x4AE3E6)
                .iconSet(MaterialIconSet.OPAL)
                .components(Strontium, 1, Sulfur, 1, Oxygen, 4)
                .flags(CRYSTALLIZABLE, DISABLE_DECOMPOSITION, GENERATE_LENS)
                .buildAndRegister();
        //  24250 Strontium Carbonate
        StrontiumCarbonate = Builder("strontium_carbonate")
                .dust()
                .color(0x1DAFD3)
                .iconSet(MaterialIconSet.SAND)
                .components(Strontium, 1, Carbon, 1, Oxygen, 3)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24251 Strontium Oxide
        StrontiumOxide = Builder("stronium_oxide")
                .dust()
                .color(0x16839E)
                .iconSet(MaterialIconSet.BRIGHT)
                .components(Strontium, 1, Oxygen, 1)
                .buildAndRegister();
        //  24252 Acidic Pyrochlore
        AcidicPyrochlore = Builder("acidic_pyrochlore")
                .dust()
                .color(Pyrochlore.getMaterialRGB() + SulfuricAcid.getMaterialRGB())
                .iconSet(MaterialIconSet.SHINY)
                .components(Pyrochlore, 1, SulfuricAcid, 1)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24253 Thorium-Uranium Solution
        ThoriumUraniumSolution = Builder("thorium_uranium_solution")
                .fluid()
                .color(Thorium.getMaterialRGB() + Uranium235.getMaterialRGB())
                .iconSet(MaterialIconSet.DULL)
                .buildAndRegister()
                .setFormula("?SO4", true);
        //  24254 Leaching Pyrochlore
        LeachingPyrochlore = Builder("leaching_pyrochlore")
                .dust()
                .color(0xE2502C)
                .iconSet(MaterialIconSet.BRIGHT)
                .buildAndRegister()
                .setFormula("(Nb2O5)9Ta2O5?", true);
        //  24255 Barium-Strontium-Radium Solution
        BariumStrontiumRadiumSolution = Builder("barium_strontium_radium_solution")
                .fluid()
                .color(Barite.getMaterialRGB())
                .components(Barite, 1, Gypsum, 1, Celestite, 1, Radium, 1, Water, 4)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24256 Fluoroniobic Acid
        FluoroniobicAcid = Builder("fluoroniobic_acid")
                .fluid(FluidStorageKeys.LIQUID, new FluidBuilder().attribute(FluidAttributes.ACID))
                .color(Niobium.getMaterialRGB() + HydrofluoricAcid.getMaterialRGB())
                .components(Niobium, 1, Hydrogen, 1, Fluorine, 7)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24257 Oxypentafluoroniobate
        Oxypentafluoroniobate = Builder("oxypentafluoroniobate")
                .fluid()
                .color(0x17F742)
                .components(Hydrogen, 2, Niobium, 1, Oxygen, 1, Fluorine, 5)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24258 Heptafluorotantalate
        Heptafluorotantalate = Builder("heptafluorotantalate")
                .fluid()
                .color(0x16EB3F)
                .components(Hydrogen, 2, Tantalum, 1, Fluorine, 7)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24259 Potassium Fluoride
        PotassiumFluoride = Builder("potassium_fluoride")
                .dust()
                .color(Potassium.getMaterialRGB() + Fluorine.getMaterialRGB())
                .iconSet(ROUGH)
                .components(Potassium, 1, Fluorine, 1)
                .buildAndRegister();
        //  24260 Potassium Fluoniobate
        PotassiumFluoniobate = Builder("potassium_fluoniobate")
                .dust()
                .color(PotassiumFluoride.getMaterialRGB() + FluoroniobicAcid.getMaterialRGB())
                .iconSet(MaterialIconSet.BRIGHT)
                .components(Potassium, 2, Niobium, 1, Fluorine, 7)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24261 Potassium Fluotantalate
        PotassiumFluotantalate = Builder("potassium_fluotantalate")
                .dust()
                .color(Tantalum.getMaterialRGB() + PotassiumFluoniobate.getMaterialRGB())
                .iconSet(MaterialIconSet.BRIGHT)
                .components(Potassium, 2, Tantalum, 1, Fluorine, 7)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24262 Uranium Thorium Nitrate
        UraniumThoriumNitrate = Builder("uranium_thorium_nitrate")
                .dust()
                .color(Uranium238.getMaterialRGB() + Thorium.getMaterialRGB() + Nitrogen.getMaterialRGB())
                .iconSet(MaterialIconSet.SHINY)
                .buildAndRegister()
                .setFormula("UO2(NO3)2Th(NO3)4", true);
        //  24263 Uranium Oxide Thorium Nitrate
        UraniumOxideThoriumNitrate = Builder("uranium_oxide_thorium_nitrate")
                .dust()
                .color(Uranium238.getMaterialRGB() + Oxygen.getMaterialRGB())
                .iconSet(MaterialIconSet.SHINY)
                .buildAndRegister()
                .setFormula("UO2Th(NO3)4", true);
        //  24264 Thorium Nitrate Solution
        ThoriumNitrateSolution = Builder("thorium_nitrate_solution")
                .fluid()
                .color(Thorium.getMaterialRGB())
                .buildAndRegister()
                .setFormula("Th(NO3)4(H2O)", true);
        //  24265 Thorium Oxide
        ThoriumOxide = Builder("thorium_oxide")
                .dust()
                .color(Thorium.getMaterialRGB() + Oxygen.getMaterialRGB())
                .components(Thorium, 1, Oxygen, 1)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24266 Gold Copper Mixture
        GoldCopperMixture = Builder("gold_copper_mixture")
                .dust()
                .color(0xD2D242)
                .iconSet(MaterialIconSet.SHINY)
                .components(Copper, 3, Gold, 1)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister()
                .setFormula("Cu3Au?", true);
        //  24267 Leaching Gold
        LeachingGold = Builder("leaching_gold")
                .dust()
                .color(0xA7650F)
                .iconSet(ROUGH)
                .components(Copper, 3, Gold, 1)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister()
                .setFormula("Cu3Au?", true);
        //  24268 Chloroauric Acid
        ChloroauricAcid = Builder("chloroauric_acid")
                .fluid()
                .color(LeachingGold.getMaterialRGB() + HydrochloricAcid.getMaterialRGB())
                .components(Hydrogen, 1, Gold, 1, Chlorine, 1)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister()
                .setFormula("HAuCl?", false);
        //  24269 Leaching Copper
        LeachingCopper = Builder("leaching_copper")
                .dust()
                .color(Copper.getMaterialRGB() + LeachingGold.getMaterialRGB())
                .iconSet(MaterialIconSet.SHINY)
                .components(Copper, 3)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister()
                .setFormula("Cu3?", true);
        //  24270 Potassium Metabisulfite
        PotassiumMetabisulfite = Builder("potassium_metabisulfite")
                .dust()
                .color(Potassium.getMaterialRGB() + Sulfur.getMaterialRGB())
                .iconSet(MaterialIconSet.SAND)
                .components(Potassium, 2, Sulfur, 2, Oxygen, 5)
                .buildAndRegister();
        //  24271 Platinum Metal
        PlatinumMetal = Builder("platinum_metal")
                .dust()
                .color(PlatinumRaw.getMaterialRGB())
                .iconSet(MaterialIconSet.SAND)
                .components(Platinum, 1)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister()
                .setFormula("Pt?", false);
        //  24272 Platinum Slag
        PlatinumSlag = Builder("platinum_slag")
                .dust()
                .color(PlatinumRaw.getMaterialRGB())
                .iconSet(MaterialIconSet.DULL)
                .components(Platinum, 1)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister()
                .setFormula("Pt?", false);
        //  24273 Palladium Metal
        PalladiumMetal = Builder("palladium_metal")
                .dust()
                .color(Palladium.getMaterialRGB())
                .iconSet(MaterialIconSet.DULL)
                .components(Palladium, 1)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister()
                .setFormula("Pd?", false);
        //  24274 Concentrate Platinum
        ConcentratePlatinum = Builder("concentrate_platinum")
                .fluid()
                .color(Platinum.getMaterialRGB())
                .iconSet(MaterialIconSet.DULL)
                .components(Platinum, 1)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister()
                .setFormula("Pt?", false);
        //  24275 Crude Platinum
        CrudePlatinum = Builder("crude_platinum")
                .dust()
                .color(PlatinumRaw.getMaterialRGB())
                .iconSet(MaterialIconSet.SAND)
                .components(Platinum, 1, Chlorine, 2)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister()
                .setFormula("PtCl2?", true);
        //  24276 Palladium Rich Ammonia
        PalladiumRichAmmonia = Builder("palladium_rich_ammonia")
                .gas()
                .color(Palladium.getMaterialRGB() + Ammonia.getMaterialRGB())
                .components(Palladium, 1, Ammonia, 1)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister()
                .setFormula("Pd(NH3)?", true);
        //  24277 Iridium Dioxide
        IridiumDioxide = Builder("iridium_dioxide")
                .dust()
                .color(Iridium.getMaterialRGB() + Oxygen.getMaterialRGB())
                .iconSet(MaterialIconSet.SAND)
                .components(Iridium, 1, Oxygen, 2)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24278 Acidic Iridium Solution
        AcidicIridiumSolution = Builder("acidic_iridium_solution")
                .fluid()
                .color(IridiumDioxide.getMaterialRGB() + HydrochloricAcid.getMaterialRGB())
                .components(IridiumDioxide, 2, HydrochloricAcid, 2)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24279 Osmium Tetrachloride
        OsmiumTetrachloride = Builder("osmium_tetrachloride")
                .dust()
                .color(0x29080A)
                .iconSet(MaterialIconSet.METALLIC)
                .components(Osmium, 1, Chlorine, 4)
                .buildAndRegister();
        //  24280 Ruthenium Chloride
        RutheniumChloride = Builder("ruthenium_chloride")
                .dust()
                .color(0x605C6C)
                .iconSet(MaterialIconSet.METALLIC)
                .flags(DISABLE_DECOMPOSITION)
                .components(Ruthenium, 1, Chlorine, 3)
                .buildAndRegister();
        //  24281 Sodium Peroxide
        SodiumPeroxide = Builder("sodium_peroxide")
                .dust()
                .color(0xECFF80)
                .iconSet(ROUGH)
                .components(Sodium, 2, Oxygen, 2)
                .buildAndRegister();
        //  24282 Rhodium Oxide
        RhodiumOxide = Builder("rhodium_oxide")
                .dust()
                .color(0xD93D16)
                .iconSet(MaterialIconSet.METALLIC)
                .components(Rhodium, 2, Oxygen, 3)
                .buildAndRegister();
        //  24283 Platinum Group Sludge Solution
        PlatinumGroupSludgeSolution = Builder("platinum_group_sludge_solution")
                .fluid()
                .color(PlatinumGroupSludge.getMaterialRGB())
                .iconSet(MaterialIconSet.DULL)
                .buildAndRegister();
        //  24284 Ammonium Hexachloro Platinum Group Sludge
        AmmoniumHexachloroPlatinumGroupSludge = Builder("ammonium_hexachloro_platinum_group_sludge")
                .fluid()
                .color(0xFEF0C2)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24285 Leaching Nickel
        LeachingNickel = Builder("leaching_nickel")
                .dust()
                .color(LeachingCopper.getMaterialRGB() + Nickel.getMaterialRGB())
                .iconSet(MaterialIconSet.BRIGHT)
                .components(Nickel, 3)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister()
                .setFormula("Ni3?", true);
        //  24286 Gold Nickel Mixture
        GoldNickelMixture = Builder("gold_nickel_mixture")
                .dust()
                .color(GoldCopperMixture.getMaterialRGB() + Nickel.getMaterialRGB())
                .iconSet(MaterialIconSet.SAND)
                .components(Nickel, 3, Gold, 1)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister()
                .setFormula("Ni3Au?", true);
        //  24287 Lanthanum Fullerene Mixture
        LanthanumFullereneMixture = Builder("lanthanum_fullerene_mixture")
                .dust()
                .color(0xD26D8E)
                .iconSet(MaterialIconSet.BRIGHT)
                .components(Lanthanum, 2, GeodesicPolyarene, 2)
                .buildAndRegister();
        //  24288 Lanthanum Embedded Fullerene
        LanthanumEmbeddedFullerene = Builder("lanthanum_embedded_fullerene")
                .dust()
                .color(0x84FFAC)
                .iconSet(MaterialIconSet.BRIGHT)
                .components(Lanthanum, 2, GeodesicPolyarene, 2)
                .buildAndRegister();
        //  24289 Lanthanum Fullerene Nanotube
        LanthanumFullereneNanotube = Builder("lanthanum_fullerene_nanotube")
                .ingot()
                .color(0xD24473)
                .iconSet(MaterialIconSet.BRIGHT)
                .components(Lanthanum, 2, GeodesicPolyarene, 2, CarbonNanotube, 1)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24290 HRA Magnesium
        HRAMagnesium = Builder("hra_magnesium")
                .dust()
                .color(Magnesium.getMaterialRGB())
                .iconSet(MaterialIconSet.SHINY)
                .components(Magnesium, 1)
                .buildAndRegister();
        //  24291 Cadium Bromide
        CadmiumBromide = Builder("cadmium_bromide")
                .dust()
                .color(0xFF1774)
                .iconSet(MaterialIconSet.SHINY)
                .components(Cadmium, 1, Bromine, 2)
                .buildAndRegister();
        //  24292 Magnesium Bromide
        MagnesiumBromide = Builder("magnesium_bromide")
                .dust()
                .color(0x5F4C32)
                .iconSet(MaterialIconSet.METALLIC)
                .components(Magnesium, 1, Bromine, 2)
                .buildAndRegister();
        //  24293 Oganesson Breeding Base
        OganessonBreedingBase = Builder("oganesson_breeding_base")
                .fluid()
                .color(0xA65A7F)
                .components(Oganesson, 1)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24294 Hot Oganesson
        HotOganesson = Builder("hot_oganesson")
                .fluid(FluidStorageKeys.LIQUID, new FluidBuilder().temperature(14118))
                .color(Oganesson.getMaterialRGB())
                .components(Oganesson, 1)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24295 Dragon Dust
        DragonDust = Builder("dragon_dust")
                .ore(1, 1, true)
                .addOreByproducts(Amethyst)
                .dust()
                .color(Draconium.getMaterialRGB())
                .iconSet(MaterialIconSet.DULL)
                .buildAndRegister()
                .setFormula("Dc3Ac3Se4At4?", false);
        //  24296 Californium Nitrite
        CaliforniumNitrite = Builder("californium_nitrite")
                .dust()
                .color(0x914626)
                .iconSet(ROUGH)
                .components(Californium, 1, Nitrogen, 3, Oxygen, 6)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister()
                .setFormula("Cf(NO2)3", true);
        //  24297 Californium Dioxide
        CaliforniumDioxide = Builder("californium_dioxide")
                .dust()
                .color(0x912D01)
                .iconSet(MaterialIconSet.DULL)
                .components(Californium, 1, Oxygen, 2)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24298 Californium Hexachloride
        CaliforniumHexachloride = Builder("californium_hexachloride")
                .fluid()
                .color(Californium.getMaterialRGB() + Chlorine.getMaterialRGB())
                .components(Californium, 2, Chlorine, 6)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24299 Californium Hexafluoride
        CaliforniumHexafluoride = Builder("californium_hexafluoride")
                .gas()
                .color(Californium.getMaterialRGB() + Fluorine.getMaterialRGB())
                .components(Californium, 2, Fluorine, 6)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24300 Californium-252 Hexafluoride
        Californium252Hexafluoride = Builder("californium_252_hexafluoride")
                .gas()
                .color(Californium252.getMaterialRGB() + Fluorine.getMaterialRGB())
                .components(Californium252, 2, Fluorine, 6)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24301 Steam Cracked Californium-252 Hexafluoride
        SteamCrackedCalifornium252Hexafluoride = Builder("steam_cracked_californium_252_hexafluoride")
                .gas()
                .color(Californium252Hexafluoride.getMaterialRGB() + Steam.getMaterialRGB())
                .components(Californium252, 2, Fluorine, 6)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24302 Californium-252 Dioxide
        Californium252Dioxide = Builder("californium_252_dioxide")
                .dust()
                .color(0x912D01)
                .iconSet(ROUGH)
                .components(Californium252, 1, Oxygen, 2)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24303 Actinium Draconium Hydroxides
        ActiniumDraconiumHydroxides = Builder("actinium_draconium_hydroxides")
                .dust()
                .color(0xB613BF)
                .iconSet(ROUGH)
                .components(Draconium, 3, Actinium, 2, Oxygen, 12, Hydrogen, 12)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister()
                .setFormula("Dc3Ac3(OH)12", true);
        //  24304 Actinium Nitrate
        ActiniumNitrate = Builder("actinium_nitrate")
                .dust()
                .color(Actinium.getMaterialRGB() + NitricAcid.getMaterialRGB())
                .iconSet(ROUGH)
                .components(Actinium, 1, Nitrogen, 3, Oxygen, 9)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister()
                .setFormula("Ac(NO3)3", true);
        //  24305 Radium Nitrate
        RadiumNitrate = Builder("radium_nitrate")
                .dust()
                .color(Radium.getMaterialRGB() + NitricAcid.getMaterialRGB())
                .iconSet(MaterialIconSet.SHINY)
                .components(Radium, 1, Nitrogen, 2, Oxygen, 6)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister()
                .setFormula("Ra(NO3)2", true);
        //  24306 Caesium Carborane
        CaesiumCarborane = Builder("caesium_carborane")
                .dust()
                .color(Caesium.getMaterialRGB() + Carbon.getMaterialRGB())
                .iconSet(MaterialIconSet.DULL)
                .components(Caesium, 1, Carbon, 1, Boron, 11, Hydrogen, 12)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24307 Silver Nitrate
        SilverNitrate = Builder("silver_nitrate")
                .dust()
                .color(Silver.getMaterialRGB() + NitricAcid.getMaterialRGB())
                .iconSet(MaterialIconSet.SHINY)
                .components(Silver, 1, Nitrogen, 1, Oxygen, 3)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24308 Caesium Nitrate
        CaesiumNitrate = Builder("caesium_nitrate")
                .dust()
                .color(Caesium.getMaterialRGB() + NitricAcid.getMaterialRGB())
                .iconSet(ROUGH)
                .components(Caesium, 1, Nitrogen, 1, Oxygen, 3)
                .flags(DECOMPOSITION_BY_ELECTROLYZING)
                .buildAndRegister();
        //  24309 Silver Iodide
        SilverIodide = Builder("silver_iodide")
                .dust()
                .iconSet(MaterialIconSet.SHINY)
                .color(Silver.getMaterialRGB() + Iodine.getMaterialRGB())
                .components(Silver, 1, Iodine, 1)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24310 Caesium Hydroxide
        CaesiumHydroxide = Builder("caesium_hydroxide")
                .dust()
                .color(Caesium.getMaterialRGB() + Hydrogen.getMaterialRGB() + Oxygen.getMaterialRGB())
                .components(Caesium, 1, Oxygen, 1, Hydrogen, 1)
                .flags(DECOMPOSITION_BY_ELECTROLYZING)
                .buildAndRegister();
        //  24311 Sodium Tetrafluoroborate
        SodiumTetrafluoroborate = Builder("sodium_tetrafluoroborate")
                .dust()
                .color(Sodium.getMaterialRGB() + BoronTrifluoride.getMaterialRGB())
                .iconSet(MaterialIconSet.SAND)
                .components(Sodium, 1, Boron, 1, Fluorine, 4)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24312 Sodium Borohydride
        SodiumBorohydride = Builder("sodium_borohydride")
                .dust()
                .color(Sodium.getMaterialRGB() + Boron.getMaterialRGB())
                .iconSet(ROUGH)
                .components(Sodium, 1, Boron, 1, Hydrogen, 4)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24313 Sodium Ethoxide
        SodiumEthoxide = Builder("sodium_ethoxide")
                .dust()
                .color(Sodium.getMaterialRGB() + Ethanol.getMaterialRGB())
                .iconSet(MaterialIconSet.DULL)
                .components(Carbon, 2, Hydrogen, 5, Oxygen, 1, Sodium, 1)
                .buildAndRegister();
        //  24314 Krypton Difluoride
        KryptonDifluoride = Builder("krypton_difluoride")
                .gas()
                .color(Krypton.getMaterialRGB() + Fluorine.getMaterialRGB())
                .components(Krypton, 1, Fluorine, 2)
                .buildAndRegister();
        //  24315 Draconium Tetrafluoride
        DraconiumTetrafluoride = Builder("draconium_tetrafluoride")
                .dust()
                .color(0xBA16A6)
                .iconSet(MaterialIconSet.DULL)
                .components(Draconium, 1, Fluorine, 4)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24316 Actinium Oxalate
        ActiniumOxalate = Builder("actinium_oxalate")
                .dust()
                .color(0x7971BF)
                .iconSet(MaterialIconSet.SHINY)
                .components(Actinium, 1, Carbon, 4, Oxygen, 8)
                .buildAndRegister()
                .setFormula("Ac(CO2)4", true);
        //  24317 Actinium Hydride
        ActiniumHydride = Builder("actinium_hydride")
                .dust()
                .color(0x86DAF0)
                .iconSet(MaterialIconSet.BRIGHT)
                .components(Actinium, 1, Hydrogen, 3)
                .buildAndRegister();
        //  24318 Actinium Superhydride
        ActiniumSuperhydride = Builder("actinium_superhydride")
                .dust()
                .plasma()
                .color(0xCC3300)
                .iconSet(MaterialIconSet.BRIGHT)
                .components(Actinium, 1, Hydrogen, 12)
                .buildAndRegister();
        //  24319 Francium Carbide
        FranciumCarbide = Builder("francium_carbide")
                .dust()
                .color(Francium.getMaterialRGB() + Carbon.getMaterialRGB())
                .iconSet(MaterialIconSet.SHINY)
                .components(Francium, 2, Carbon, 2)
                .buildAndRegister();
        //  24320 Boron Francium Mixture
        BoronFranciumMixture = Builder("boron_francium_mixture")
                .dust()
                .color(Boron.getMaterialRGB() + FranciumCarbide.getMaterialRGB())
                .iconSet(MaterialIconSet.BRIGHT)
                .components(FranciumCarbide, 2, CubicBoronNitride, 1, AmorphousBoronNitride, 1)
                .buildAndRegister();
        //  24321 Flerovium-Ytterbium Plasma
        FleroviumYtterbiumPlasma = Builder("flerovium_ytterbium_plasma")
                .fluid(FluidStorageKeys.PLASMA, new FluidBuilder().temperature(300))
                .components(MetastableFlerovium, 1, Ytterbium178, 1)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24322 Solar-Grade Silicon
        SolarGradeSilicon = Builder("solar_grade_silicon")
                .ingot()
                .color(Silicon.getMaterialRGB())
                .iconSet(MaterialIconSet.BRIGHT)
                .components(Silicon, 1)
                .buildAndRegister();
        //  24323 Dense Hydrazine Mixture Fuel
        DenseHydrazineMixtureFuel = Builder("dense_hydrazine_mixture_fuel")
                .fluid()
                .color(0x912565)
                .components(Dimethylhydrazine, 1, Methanol, 1)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24324 Highly Purified Coal Tar
        HighlyPurifiedCoalTar = Builder("highly_purified_coal_tar")
                .fluid()
                .color(0x7F811D)
                .components(CoalTar, 1)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24325 RP-1 Rocket Fuel
        RP1RocketFuel = Builder("rp_1_rocket_fuel")
                .fluid()
                .color(0xFB2A08)
                .components(HighlyPurifiedCoalTar, 1, Oxygen/*LiquidOxygen*/, 1)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24326 Methylhydrazine
        Methylhydrazine = Builder("methylhydrazine")
                .fluid()
                .color(0x321452)
                .components(Carbon, 1, Hydrogen, 6, Nitrogen, 2)
                .buildAndRegister();
        //  24327 Methylhydrazine Nitrate Rocket Fuel
        MethylhydrazineNitrateRocketFuel = Builder("methylhydrazine_nitrate_rocket_fuel")
                .fluid()
                .color(0x607186)
                .components(Methylhydrazine, 1, Tetranitromethane, 1)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();

        UDMHRocketFuel = Builder("udmh_rocket_fuel")
                .fluid()
                .color(0x2AA327)
                .iconSet(DULL)
                .buildAndRegister();

        UDMH = Builder("udmh")
                .fluid()
                .color(0x050543)
                .iconSet(DULL)
                .buildAndRegister();
        //  24328 Lithium Niobate
        LithiumNiobate = Builder("lithium_niobate")
                .ingot()
                .color(0xD27700)
                .iconSet(MaterialIconSet.SHINY)
                .components(Lithium, 1, Niobium, 1, Oxygen, 4)
                .blastTemp(6700)
                .flags(DISABLE_DECOMPOSITION)
                .flags(GENERATE_PLATE, GENERATE_LENS)
                .buildAndRegister();
        //  24329 Niobium Pentachloride
        NiobiumPentachloride = Builder("niobium_pentachloride")
                .dust()
                .color(Niobium.getMaterialRGB() + Chlorine.getMaterialRGB())
                .iconSet(MaterialIconSet.SHINY)
                .components(Niobium, 1, Chlorine, 5)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24330 High Purity Sodium Vanadate
        HighPuritySodiumVanadate = Builder("high_purity_sodium_vanadate")
                .dust()
                .color(0xE3E147)
                .iconSet(MaterialIconSet.BRIGHT)
                .components(Sodium, 3, Vanadium, 1, Oxygen, 4)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24331 Lutetium Thulium Yttrium Chlorides Solution
        LutetiumThuliumYttriumChloridesSolution = Builder("lutetium_thulium_yttrium_chlorides_solution")
                .fluid()
                .color(Lutetium.getMaterialRGB() + Thulium.getMaterialRGB() + Yttrium.getMaterialRGB())
                .components(Lutetium, 2, Thulium, 2, Yttrium, 6, Chlorine, 30, Hydrogen, 30, Oxygen, 15)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister()
                .setFormula("(LuCl3)2(TmCl3)2(YCl3)6(H2O)15", true);
        //  24332 Lu-Tm-droped Yttrium Vanadate Deposition
        YttriumVanadateLuTmDeposition = Builder("yttrium_vanadate_lu_tm_deposition")
                .dust()
                .color(Yttrium.getMaterialRGB() + Vanadium.getMaterialRGB() + Lutetium.getMaterialRGB() + Thulium.getMaterialRGB())
                .iconSet(MaterialIconSet.DULL)
                .buildAndRegister()
                .setFormula("Lu/TM:YVO?", false);
        //  24333 Lu-Tm-droped Yttrium Vanadate
        YttriumVanadateLuTm = Builder("yttrium_vanadate_lu_tm")
                .gem()
                .color(0x8C1B23)
                .iconSet(MaterialIconSet.GEM_HORIZONTAL)
                .flags(DISABLE_DECOMPOSITION, GENERATE_LENS, CRYSTALLIZABLE)
                .components(Yttrium, 1, Vanadium, 1, Oxygen, 1, Lutetium, 1, Thulium, 1)
                .buildAndRegister()
                .setFormula("Lu/Tm:YVO", false);
        //  24334 Heavy Quark Enriched Mixture
        HeavyQuarkEnrichedMixture = Builder("heavy_quark_enriched_mixture")
                .fluid()
                .color(HeavyQuarks.getMaterialRGB() + LightQuarks.getMaterialRGB())
                .components(LightQuarks, 1, HeavyQuarks, 3)
                .flags(DECOMPOSITION_BY_CENTRIFUGING)
                .buildAndRegister()
                .setFormula(ChatFormatting.OBFUSCATED  + "a"  + ChatFormatting.RESET + "§e(u2)d(c2)s(t2)b" + ChatFormatting.OBFUSCATED  + "a" , true);
        //  24335 Deuterium-Superheavy Mixture
        DeuteriumSuperHeavyMixture = Builder("deuterium_superheavy_mixture")
                .fluid()
                .color(0x7B9F8E)
                .components(Deuterium, 2, MetastableHassium, 1, MetastableFlerovium, 1, MetastableOganesson, 1)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24336 Heavy Quark Degenerate Matter
        HeavyQuarkDegenerateMatter = Builder("heavy_quark_degenerate_matter")
                .ingot()
                .fluid()
                .plasma()
                .color(0x5DBD3A)
                .iconSet(MaterialIconSet.BRIGHT)
                .blastTemp(12960, BlastProperty.GasTier.HIGHEST, GTValues.VA[GTValues.UEV])
                .flags(DISABLE_DECOMPOSITION, GENERATE_PLATE)
                .buildAndRegister();
        //  24337 Fullerene Polymer Matrix
        FullerenePolymerMatrix = Builder("fullerene_polymer_matrix")
                .fluid(FluidStorageKeys.LIQUID, new FluidBuilder().temperature(500))
                .polymer()
                .color(0x2F0B01)
                .iconSet(MaterialIconSet.SHINY)
                .components(Lead, 1, Iron, 1, Carbon, 153, Hydrogen, 36, Nitrogen, 1, Oxygen, 2)
                .flags(DISABLE_DECOMPOSITION, NO_SMASHING, NO_SMELTING, GENERATE_PLATE, GENERATE_FOIL)
                .buildAndRegister();
        //  24338 Radium-Radon Mixture
        RadiumRadonMixture = Builder("radium_radon_mixture")
                .fluid()
                .color(Radium.getMaterialRGB() + Radon.getMaterialRGB())
                .components(Radium, 1, Radon, 1)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24339 Scandium-Titanium Mixture
        ScandiumTitaniumMixture = Builder("scandium_titanium_mixture")
                .fluid()
                .color(Scandium.getMaterialRGB() + Titanium.getMaterialRGB())
                .components(Scandium, 1, Titanium, 1)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24340 Caesium Iodide
        CaesiumIodide = Builder("caesium_iodide")
                .dust()
                .color(Caesium.getMaterialRGB() + Iodine.getMaterialRGB())
                .iconSet(MaterialIconSet.SHINY)
                .components(Caesium, 1, Iodine, 1)
                .buildAndRegister();
        //  24341 Tl-Tm-Droped Caesium Iodide
        TlTmDropedCaesiumIodide = Builder("tl_tm_droped_caesium_iodide")
                .dust()
                .color(Thallium.getMaterialRGB() + Thulium.getMaterialRGB() + CaesiumIodide.getMaterialRGB())
                .iconSet(MaterialIconSet.BRIGHT)
                .components(Thallium, 1, Thulium, 1, CaesiumIodide, 1)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister()
                .setFormula("Tl/Tm:CsI");
        //  24342 Cadmium Tungstate
        CadmiumTungstate = Builder("cadmium_tungstate")
                .dust()
                .color(Cadmium.getMaterialRGB() + Tungsten.getMaterialRGB())
                .iconSet(MaterialIconSet.BRIGHT)
                .components(Cadmium, 1, Tungsten, 1, Oxygen, 4)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24343 Bismuth Germanate
        BismuthGermanate = Builder("bismuth_germanate")
                .dust()
                .color(Bismuth.getMaterialRGB() + Germanium.getMaterialRGB())
                .iconSet(ROUGH)
                .components(Bismuth, 12, Germanium, 1, Oxygen, 20)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24344 Iodine Monochloride
        IodineMonochloride = Builder("iodine_monochloride")
                .fluid()
                .color(Iodine.getMaterialRGB() + Chlorine.getMaterialRGB())
                .components(Iodine, 1, Chlorine, 1)
                .buildAndRegister();
        //  24345 Magnesium Chloride Bromide
        MagnesiumChlorideBromide = Builder("magnesium_chloride_bromide")
                .dust()
                .color(Magnesium.getMaterialRGB() + Chlorine.getMaterialRGB() + Bromine.getMaterialRGB())
                .components(Magnesium, 1, Chlorine, 1, Bromine, 1)
                .buildAndRegister();
        //  24346 Rh-Re-Nq Catalyst
        RhReNqCatalyst = Builder("rh_re_nq_catalyst")
                .dust()
                .color(Rhodium.getMaterialRGB() + Rhenium.getMaterialRGB() + Naquadah.getMaterialRGB())
                .iconSet(MaterialIconSet.SHINY)
                .components(Rhodium, 1, Rhenium, 1, Naquadah, 1)
                .buildAndRegister();
        //  24347 Lithium Titanate
        LithiumTitanate = Builder("lithium_titanate")
                .ingot()
                .fluid()
                .color(0xFE71A9)
                .iconSet(MaterialIconSet.SHINY)
                .blastTemp(3100)
                .components(Lithium, 2, Titanium, 1, Oxygen, 3)
                .flags(DISABLE_DECOMPOSITION, GENERATE_FINE_WIRE)
                .buildAndRegister();
        //  24348 Titanium Nitrate
        TitaniumNitrate = Builder("titanium_nitrate")
                .dust()
                .color(Titanium.getMaterialRGB() + NitricAcid.getMaterialRGB())
                .iconSet(MaterialIconSet.DULL)
                .components(Titanium, 1, Nitrogen, 4, Oxygen, 12)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister()
                .setFormula("Ti(NO3)4", true);

        //  Naquadah Oxide Mixture
        NaquadahOxideMixture = Builder("naquadah_oxide_mixture")
                .dust()
                .color(0x20142C)
                .iconSet(MaterialIconSet.DULL)
                .components(Naquadah, 2, Oxygen, 3)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister()
                .setFormula("Nq2O3?", true);

        //  Extractive Naquadah Oxide
        ExtractiveNaquadahOxide = Builder("extractive_naquadah_oxide")
                .dust(0x432937)
                .color(0x59434F)
                .iconSet(ROUGH)
                .components(Naquadah, 2, Oxygen, 3)
                .buildAndRegister();

        ThoriumBasedLiquidFuel = Builder("thorium_based_liquid_fuel")
                .fluid()
                .color(0x3b264d)
                .iconSet(METALLIC)
                .buildAndRegister()
                .setFormula("Th432Li4D2Hg");
        ThoriumBasedLiquidFuelExcited = Builder("thorium_based_liquid_fuel_excited")
                .fluid()
                .color(0x3f2850)
                .iconSet(METALLIC)
                .buildAndRegister()
                .setFormula("*(Th432Li4D2HG)*");
        ThoriumBasedLiquidFuelDepleted = Builder("thorium_based_liquid_fuel_depleted")
                .fluid()
                .color(0x5d5166)
                .iconSet(METALLIC)
                .buildAndRegister()
                .setFormula("Th?Pr?B?In?");
        UraniumBasedLiquidFuel = Builder("uranium_based_liquid_fuel")
                .fluid()
                .color(0x02ba05)
                .iconSet(METALLIC)
                .buildAndRegister()
                .setFormula("U36K8Qt4Rn");
        UraniumBasedLiquidFuelExcited = Builder("uranium_based_liquid_fuel_excited")
                .fluid()
                .color(0x04bc04)
                .iconSet(METALLIC)
                .buildAndRegister()
                .setFormula("*(U36K8Qt4Rn)*");
        UraniumBasedLiquidFuelDepleted = Builder("uranium_based_liquid_fuel_depleted")
                .fluid()
                .color(0x576d31)
                .iconSet(METALLIC)
                .buildAndRegister()
                .setFormula("PB?Bi?Ba?Xe?");
        PlutoniumBasedLiquidFuel = Builder("plutonium_based_liquid_fuel")
                .fluid()
                .color(0xb71213)
                .iconSet(METALLIC)
                .buildAndRegister()
                .setFormula("Pu45Nt8Cs16Nq2");
        PlutoniumBasedLiquidFuelExcited = Builder("plutonium_based_liquid_fuel_excited")
                .fluid()
                .color(0xb81312)
                .iconSet(METALLIC)
                .buildAndRegister()
                .setFormula("*(Pu45Nt8Cs16Nq2)*");
        PlutoniumBasedLiquidFuelDepleted = Builder("plutonium_based_liquid_fuel_depleted")
                .fluid()
                .color(0x4e1414)
                .iconSet(METALLIC)
                .buildAndRegister()
                .setFormula("Th?Ce?Au?Kr?");
        RadiationProtection = Builder("radiation_protection")
                .dust()
                .flags(GENERATE_FRAME)
                .color(0x4C4C4B)
                .iconSet(METALLIC)
                .buildAndRegister();
        NaquadahBasedLiquidFuel = Builder("naquadah_based_liquid_fuel")
                .fluid()
                .color(0x43b54a)
                .iconSet(METALLIC)
                .buildAndRegister()
                .setFormula("Nq42Ce16Nd16");
        NaquadahBasedLiquidFuelExcited = Builder("naquadah_based_liquid_fuel_excited")
                .fluid()
                .color(0x41b349)
                .iconSet(METALLIC)
                .buildAndRegister()
                .setFormula("*(Nq42Ce16Nd16)*");
        NaquadahBasedLiquidFuelDepleted = Builder("naquadah_based_liquid_fuel_depleted")
                .fluid()
                .color(0x215825)
                .iconSet(METALLIC)
                .buildAndRegister()
                .setFormula("Nq?Ke?Nd?");
    }
}
