package cn.gtcommunity.epimorphism.common.data.materials;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.BlastProperty;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.PropertyKey;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.ToolProperty;
import com.gregtechceu.gtceu.api.fluids.FluidBuilder;
import com.gregtechceu.gtceu.api.fluids.attribute.FluidAttributes;
import com.gregtechceu.gtceu.api.fluids.store.FluidStorageKeys;
import com.gregtechceu.gtceu.api.item.tool.GTToolType;

import static cn.gtcommunity.epimorphism.api.chemical.material.info.EPMaterialFlags.*;
import static com.gregtechceu.gtceu.api.GTValues.*;
import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags.*;
import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconSet.*;
import static cn.gtcommunity.epimorphism.common.data.EPMaterials.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static net.minecraft.ChatFormatting.*;

public class EPFirstDegreeMaterials {
    public static void register() {
        //  24001 GrapheneOxide
        GrapheneOxide = new Material.Builder("graphene_oxide")
                .dust()
                .color(0x777777)
                .iconSet(ROUGH)
                .flags(DISABLE_DECOMPOSITION)
                .components(Graphene, 1, Oxygen, 1)
                .buildAndRegister();
        //  24002 Hydrazine
        Hydrazine = new Material.Builder("hydrazine")
                .fluid()
                .color(0xB50707)
                .flags(DISABLE_DECOMPOSITION)
                .components(Nitrogen, 2, Hydrogen, 4)
                .buildAndRegister();

        //  24003 BerylliumOxide
        BerylliumOxide = new Material.Builder("beryllium_oxide")
                .ingot()
                .color(0x54C757)
                .flags(GENERATE_ROD, GENERATE_RING)
                .components(Beryllium, 1, Oxygen, 1)
                .buildAndRegister();

        //  24004 Hydrogen Peroxide
        HydrogenPeroxide = new Material.Builder("hydrogen_peroxide")
                .fluid()
                .color(0xD2FFFF)
                .flags(DISABLE_DECOMPOSITION)
                .components(Hydrogen, 2, Oxygen, 2)
                .buildAndRegister();

        //  24005 Tungsten Trioxide
        TungstenTrioxide = new Material.Builder("tungsten_trioxide")
                .dust()
                .color(0xC7D300)
                .iconSet(DULL)
                .flags(DISABLE_DECOMPOSITION)
                .components(Tungsten, 1, Oxygen, 3)
                .buildAndRegister();
        //  24006 Hexagonal Boron Nitride
        HexagonalBoronNitride = new Material.Builder("hexagonal_boron_nitride")
                .gem()
                .color(0x6A6A72)
                .iconSet(GEM_VERTICAL)
                .flags(GENERATE_PLATE, DISABLE_DECOMPOSITION)
                .components(Boron, 1, Nitrogen, 1)
                .buildAndRegister()
                .setFormula("h-BN", true);

        //  24007  Cubic Boron Nitride
        CubicBoronNitride = new Material.Builder("cubic_boron_nitride")
                .gem()
                .color(0x545572)
                .iconSet(DIAMOND)
                .flags(GENERATE_PLATE, DISABLE_DECOMPOSITION, DISABLE_CRYSTALLIZATION, FLAMMABLE, EXPLOSIVE)
                .components(Boron, 1, Nitrogen, 1)
                .toolStats(new ToolProperty(14.0F, 9.0F, 12400, 15, GTToolType.values()))
                .buildAndRegister()
                .setFormula("c-BN", true);
        //  24008 Boric Acid
        BoricAcid = new Material.Builder("boric_acid")
                .dust()
                .fluid()
                .color(0xFAFAFA)
                .iconSet(SHINY)
                .flags(DISABLE_DECOMPOSITION)
                .components(Hydrogen, 3, Boron, 1, Oxygen, 3)
                .buildAndRegister();
        //  24009 Boron Trioxide
        BoronTrioxide = new Material.Builder("boron_trioxide")
                .dust()
                .color(0xE9FAC0)
                .iconSet(METALLIC)
                .components(Boron, 2, Oxygen, 3)
                .buildAndRegister();
        //  24010 Boron Trifluoride
        BoronTrifluoride = new Material.Builder("boron_trifluoride")
                .gas()
                .color(0xFAF191)
                .components(Boron, 1, Fluorine, 3)
                .buildAndRegister();
        //  24011 Lithium Hydride
        LithiumHydride = new Material.Builder("lithium_hydride")
                .ingot()
                .color(0x9BAFDB)
                .iconSet(METALLIC)
                .components(Lithium, 1, Hydrogen, 1)
                .buildAndRegister();
        //  24012 Lithium Tetrafluoroborate
        LithiumTetrafluoroborate = new Material.Builder("lithium_tetrafluoroborate")
                .dust()
                .color(0x90FAF6)
                .iconSet(SHINY)
                .flags(DISABLE_DECOMPOSITION)
                .components(Lithium, 1, Boron, 1, Fluorine, 4)
                .buildAndRegister();
        //  24013 Diborane
        Diborane = new Material.Builder("diborane")
                .gas()
                .color(0x3F3131)
                .flags(DISABLE_DECOMPOSITION)
                .components(Boron, 2, Hydrogen, 6)
                .buildAndRegister();
        //  24014 Borazine
        Borazine = new Material.Builder("borazine")
                .fluid()
                .color(0x542828)
                .flags(DISABLE_DECOMPOSITION)
                .components(Boron, 3, Hydrogen, 6, Nitrogen, 3)
                .buildAndRegister();
        //  24015 Boron Trichloride
        BoronTrichloride = new Material.Builder("boron_trichloride")
                .gas()
                .color(0x033F1B)
                .components(Boron, 1, Chlorine, 3)
                .buildAndRegister();
        //  24016 Trichloroborazine
        Trichloroborazine = new Material.Builder("trichloroborazine")
                .fluid()
                .color(0xD62929)
                .flags(DISABLE_DECOMPOSITION)
                .components(Boron, 3, Chlorine, 3, Hydrogen, 3, Nitrogen, 3)
                .buildAndRegister();
        //  24017 Amorphous Boron Nitride
        AmorphousBoronNitride = new Material.Builder("amorphous_boron_nitride")
                .ingot()
                .color(0x9193C5)
                .iconSet(SHINY)
                .flags(GENERATE_PLATE, DISABLE_DECOMPOSITION, NO_SMASHING, NO_SMELTING)
                .components(Boron, 1, Nitrogen, 1)
                .buildAndRegister()
                .setFormula("a-BN", true);
        //  24018 Heterodiamond
        Heterodiamond = new Material.Builder("heterodiamond")
                .gem()
                .color(0x512A72)
                .iconSet(GEM_HORIZONTAL)
                .flags(GENERATE_PLATE, DISABLE_DECOMPOSITION)
                .components(Boron, 1, Carbon, 1, Nitrogen, 1)
                .buildAndRegister();
        //  24019 Cubic Heterodiamond
        CubicHeterodiamond = new Material.Builder("cubic_heterodiamond")
                .gem()
                .color(0x753DA6)
                .iconSet(DIAMOND)
                .flags(GENERATE_PLATE, DISABLE_DECOMPOSITION)
                .components(Boron, 1, Carbon, 2, Nitrogen, 1)
                .buildAndRegister()
                .setFormula("c-BC2N", true);
        //  24020 Carbon Nanotube
        CarbonNanotube = new Material.Builder("carbon_nanotube")
                .ingot()
                .fluid()
                .color(0x05090C)
                .iconSet(BRIGHT)
                .flags(DISABLE_DECOMPOSITION, NO_SMELTING, GENERATE_PLATE, GENERATE_ROD, GENERATE_LONG_ROD, GENERATE_FINE_WIRE, GENERATE_SPRING, GENERATE_COIL)
                .cableProperties(V[UEV], 8, 6)
                .components(Carbon, 48)
                .buildAndRegister()
                .setFormula("CNT", false);
        //  24021 Silver Tetrafluoroborate
        SilverTetrafluoroborate = new Material.Builder("silver_tetrafluoroborate")
                .fluid()
                .color(0x818024)
                .flags(DISABLE_DECOMPOSITION)
                .components(Silver, 1, Boron, 1, Fluorine, 4)
                .buildAndRegister()
                .setFormula("AgBF4", true);
        //  24022 Trimethyltin Chloride
        TrimethyltinChloride = new Material.Builder("trimethyltin_chloride")
                .fluid()
                .color(0x7F776F)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 3, Hydrogen, 6, Tin, 1, Chlorine, 1)
                .buildAndRegister()
                .setFormula("(CH3)3SnCl", true);
        //  24023 Silver Chloride
        SilverChloride = new Material.Builder("silver_chloride")
                .dust()
                .color(0x8D8D8D)
                .iconSet(METALLIC)
                .components(Silver, 1, Chlorine, 1)
                .buildAndRegister();
        //  24024 Chloroplatinic Acid
        ChloroplatinicAcid = new Material.Builder("chloroplatinic_acid")
                .fluid(FluidStorageKeys.LIQUID, new FluidBuilder().attribute(FluidAttributes.ACID))
                .color(0xFFB546)
                .components(Hydrogen, 2, Platinum, 1, Chlorine, 6)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24025 Potassium Tetrachloroplatinate
        PotassiumTetrachloroplatinate = new Material.Builder("potassium_tetrachloroplatinate")
                .dust()
                .color(0xF1B04F)
                .iconSet(SHINY)
                .components(Potassium, 2, Platinum, 1, Chlorine, 4)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister()
                .setFormula("K2PtCl4", true);
        //  24026 Nickel Triphenylphosphite
        NickelTriphenylphosphite = new Material.Builder("nickel_triphenylphosphite")
                .dust()
                .color(0xCCCC66)
                .iconSet(SHINY)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 36, Hydrogen, 30, Chlorine, 2, Nickel, 1, Phosphorus, 2)
                .buildAndRegister()
                .setFormula("C36H30Cl2NiP2", true);
        //  24027 Nickel Chloride
        NickelChloride = new Material.Builder("nickel_chloride")
                .dust()
                .color(0x898A07)
                .iconSet(DULL)
                .components(Nickel, 1, Chlorine, 2)
                .buildAndRegister();
        //  24028 Phosphorus Trichloride
        PhosphorusTrichloride = new Material.Builder("phosphorus_trichloride")
                .fluid()
                .color(0xD8D85B)
                .components(Phosphorus, 1, Chlorine, 3)
                .buildAndRegister();
        //  24029 Ammonium Sulfate
        AmmoniumSulfate = new Material.Builder("ammonium_sulfate")
                .fluid()
                .color(0x5858F4)
                .buildAndRegister()
                .setFormula("(NH2)4SO4", true);
        //  24030 Ammonium Persulfate
        AmmoniumPersulfate = new Material.Builder("ammonium_persulfate")
                .fluid()
                .color(0x4242B7)
                .buildAndRegister()
                .setFormula("(NH4)2S2O8", true);
        //  24031 Hydroxylamine Disulfate
        HydroxylamineDisulfate = new Material.Builder("hydroxylamine_disulfate")
                .fluid()
                .color(0x91A6D2)
                .buildAndRegister()
                .setFormula("(NH3OH)2(NH4)2(SO4)2", true);
        //  24032 Hydroxylamine
        Hydroxylamine = new Material.Builder("hydroxylamine")
                .fluid()
                .color(0x91C791)
                .components(Hydrogen, 3, Nitrogen, 1, Oxygen, 1)
                .buildAndRegister()
                .setFormula("H3NO", true);
        //  24033 Ammonium Nitrate
        AmmoniumNitrate = new Material.Builder("ammonium_nitrate")
                .fluid()
                .color(0x454066)
                .components(Nitrogen, 2, Hydrogen, 4, Oxygen, 3)
                .buildAndRegister()
                .setFormula("NH4NO3", true);
        //  24034 Thallium Sulfate
        ThalliumSulfate = new Material.Builder("thallium_sulfate")
                .dust()
                .color(0x9C222C)
                .iconSet(METALLIC)
                .flags(DISABLE_DECOMPOSITION)
                .components(Thallium, 2, Sulfur, 1, Oxygen, 4)
                .buildAndRegister();
        //  24035 Thallium Chloride
        ThalliumChloride = new Material.Builder("thallium_chloride")
                .dust()
                .color(0xCC5350)
                .iconSet(SHINY)
                .components(Thallium, 1, Chlorine, 1)
                .buildAndRegister();
        //  24036 Iodized Brine
        IodizedBrine = new Material.Builder("iodized_brine")
                .fluid()
                .color(0x525246)
                .buildAndRegister()
                .setFormula("I?", false);
        //  24037 Iodine Brine Mixture
        IodineBrineMixture = new Material.Builder("iodine_brine_mixture")
                .fluid()
                .color(0x525234)
                .buildAndRegister()
                .setFormula("I?Cl", false);
        //  24038 Brominated Brine
        BrominatedBrine = new Material.Builder("brominated_brine")
                .fluid()
                .color(0xA9A990)
                .buildAndRegister()
                .setFormula("Br?", false);
        //  24039 Iodine Slurry
        IodineSlurry = new Material.Builder("iodine_slurry")
                .fluid()
                .color(0x292923)
                .buildAndRegister()
                .setFormula("I?", false);
        //  24040 Sodium Iodate
        SodiumIodate = new Material.Builder("sodium_iodate")
                .dust()
                .color(0x0B0B47)
                .iconSet(DULL)
                .components(Sodium, 1, Iodine, 1, Oxygen, 3)
                .buildAndRegister();
        //  24041 Sodium Iodide
        SodiumIodide = new Material.Builder("sodium_iodide")
                .dust()
                .color(0x1919A3)
                .iconSet(METALLIC)
                .components(Sodium, 1, Iodine, 1)
                .buildAndRegister();
        //  24042 Sodium Hypochlorite
        SodiumHypochlorite = new Material.Builder("sodium_hypochlorite")
                .dust()
                .color(0x2828FF)
                .components(Sodium, 1, Chlorine, 1, Oxygen, 1)
                .buildAndRegister();
        //  24043 Sodium Periodate
        SodiumPeriodate = new Material.Builder("sodium_periodate")
                .dust()
                .color(0x050547)
                .iconSet(BRIGHT)
                .components(Sodium, 1, Iodine, 1, Oxygen, 4)
                .buildAndRegister();
        //  24044 Acidic Brominated Brine
        AcidicBrominatedBrine = new Material.Builder("acidic_brominated_brine")
                .fluid(FluidStorageKeys.LIQUID, new FluidBuilder().attribute(FluidAttributes.ACID))
                .color(0xC6A76F)
                .buildAndRegister()
                .setFormula("Br?(H2SO4)Cl", true);
        //  24045 Bromine Sulfate Solution
        BromineSulfateSolution = new Material.Builder("bromine_sulfate_solution")
                .fluid()
                .color(0xCC9966)
                .buildAndRegister()
                .setFormula("H2SO4Br(H2O)Cl2", true);
        //  24046 Overheated Bromine Sulfate Solution
        OverheatedBromineSulfateSolution = new Material.Builder("overheated_bromine_sulfate_solution")
                .fluid()
                .color(0xC69337)
                .iconSet(DULL)
                .buildAndRegister()
                .setFormula("H2SO4Br(H2O)2Cl2", true);
        //  24047 Wet Bromine
        WetBromine = new Material.Builder("wet_bromine")
                .fluid()
                .color(0xDB5C5C)
                .iconSet(DULL)
                .buildAndRegister()
                .setFormula("Br(H2O)", true);
        //  24048 Debrominated Water
        DebrominatedWater = new Material.Builder("debrominated_water")
                .fluid()
                .color(0x24A3A3)
                .components(Hydrogen, 2, Oxygen, 1)
                .buildAndRegister();
        //  24049 Palladium Chloride
        PalladiumChloride = new Material.Builder("palladium_chloride")
                .dust()
                .color(0xAFB5BC)
                .iconSet(SHINY)
                .components(Palladium, 1, Chlorine, 2)
                .buildAndRegister();
        //  24050 Palladium on Carbon
        PalladiumOnCarbon = new Material.Builder("palladium_on_carbon")
                .dust()
                .color(0x480104)
                .iconSet(DULL)
                .flags(DISABLE_DECOMPOSITION)
                .components(Palladium, 1, Carbon, 1)
                .buildAndRegister();
        //  24051 Potassium Permanganate
        PotassiumPermanganate = new Material.Builder("potassium_permanganate")
                .dust()
                .color(0x871D82)
                .iconSet(DULL)
                .components(Potassium, 1, Manganese, 1, Oxygen, 4)
                .buildAndRegister();
        //  24052 Potassium Manganate
        PotassiumManganate = new Material.Builder("potassium_manganate")
                .dust()
                .color(0x873883)
                .iconSet(METALLIC)
                .components(Potassium, 2, Manganese, 1, Oxygen, 4)
                .buildAndRegister();
        //  24053 Tin Chloride
        TinChloride = new Material.Builder("tin_chloride")
                .dust()
                .fluid()
                .color(0xDBDBDB)
                .iconSet(METALLIC)
                .components(Tin, 1, Chlorine, 2)
                .buildAndRegister();
        //  24054 Silver Oxide
        SilverOxide = new Material.Builder("silver_oxide")
                .dust()
                .color(0xA4A4A4)
                .components(Silver, 2, Oxygen, 1)
                .buildAndRegister();
        //  24055 Sodium Fluoride
        SodiumFluoride = new Material.Builder("sodium_fluoride")
                .dust()
                .color(0x460012)
                .iconSet(DULL)
                .components(Sodium, 1, Fluorine, 1)
                .buildAndRegister();
        //  24056 Zn-Fe-Al-Cl Catalyst
        ZnFeAlClCatalyst = new Material.Builder("zn_fe_al_cl_catalyst")
                .dust()
                .color(0xC522A9)
                .iconSet(DULL)
                .components(Zinc, 1, Iron, 1, Aluminium, 1, Chlorine, 1)
                .buildAndRegister();
        //  24057 Sodium Nitrite
        SodiumNitrite = new Material.Builder("sodium_nitrite")
                .dust()
                .color(0x205CA4)
                .iconSet(DULL)
                .components(Sodium, 1, Nitrogen, 1, Oxygen, 2)
                .buildAndRegister();
        //  24058 Sodium Nitrate
        SodiumNitrate = new Material.Builder("sodium_nitrate")
                .dust()
                .fluid()
                .color(0xEB9E3F)
                .iconSet(METALLIC)
                .components(Sodium, 1, Nitrogen, 1, Oxygen, 3)
                .buildAndRegister();
        //  24059 Fluoroboric Acid
        FluoroboricAcid = new Material.Builder("fluoroboric_acid")
                .fluid(FluidStorageKeys.LIQUID, new FluidBuilder().attribute(FluidAttributes.ACID))
                .color(0xD5811B)
                .components(Hydrogen, 1, Boron, 1, Fluorine, 4)
                .buildAndRegister();
        //  24060 Benzenediazonium Tetrafluoroborate
        BenzenediazoniumTetrafluoroborate = new Material.Builder("benzenediazonium_tetrafluoroborate")
                .fluid()
                .color(0xD5C5B2)
                .components(Carbon, 6, Hydrogen, 5, Boron, 1, Fluorine, 4, Nitrogen, 2)
                .buildAndRegister();
        //  24061 Gallium Trichloride
        GalliumTrichloride = new Material.Builder("gallium_trichloride")
                .dust()
                .color(0x6EB4FF)
                .iconSet(ROUGH)
                .components(Gallium, 1, Chlorine, 3)
                .buildAndRegister();
        //  24062 Aluminium Trichloride
        AluminiumTrichloride = new Material.Builder("aluminium_trichloride")
                .dust()
                .color(0x78C3EB)
                .iconSet(SHINY)
                .flags(DISABLE_DECOMPOSITION)
                .components(Aluminium, 1, Chlorine, 3)
                .buildAndRegister();
        //  24063 Aluminium Hydroxide
        AluminiumHydroxide = new Material.Builder("aluminium_hydroxide")
                .dust()
                .color(0xBEBEC8)
                .flags(DISABLE_DECOMPOSITION)
                .components(Aluminium, 1, Oxygen, 3, Hydrogen, 3)
                .buildAndRegister()
                .setFormula("Al(OH)3", true);
        //  24064 Alumina
        Alumina = new Material.Builder("alumina")
                .dust()
                .color(0x78c3eb)
                .iconSet(METALLIC)
                .components(Aluminium, 2, Oxygen, 3)
                .buildAndRegister();
        //  24065 Gallium Trioxide
        GalliumTrioxide = new Material.Builder("gallium_trioxide")
                .dust()
                .fluid(FluidStorageKeys.LIQUID, new FluidBuilder().temperature(2170))
                .color(0xE4CDFF)
                .iconSet(METALLIC)
                .components(Gallium, 1, Oxygen, 3)
                .buildAndRegister();
        //  24066 Gallium Nitride
        GalliumNitride = new Material.Builder("gallium_nitride")
                .ingot()
                .color(0xFFF458)
                .iconSet(SHINY)
                .flags(GENERATE_PLATE)
                .components(Gallium, 1, Nitrogen, 1)
                .buildAndRegister();
        //  24067 Fullerene
        Fullerene = new Material.Builder("fullerene")
                .ingot()
                .color(0x72556A)
                .iconSet(BRIGHT)
                .flags(DISABLE_DECOMPOSITION, NO_SMELTING, GENERATE_PLATE, GENERATE_FOIL, GENERATE_ROD, GENERATE_RING, GENERATE_FRAME)
                .components(Carbon, 60)
                .buildAndRegister();
        //  24068 Geodesic Polyarene
        GeodesicPolyarene = new Material.Builder("geodesic_polyarene")
                .dust()
                .color(0x9E81A8)
                .iconSet(METALLIC)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 60, Hydrogen, 30)
                .buildAndRegister();
        //  24069 Ti-Al Catalyst
        TiAlCatalyst = new Material.Builder("ti_al_catalyst")
                .dust()
                .color(0x6600CC)
                .iconSet(DULL)
                .components(Titanium, 1, Aluminium, 1)
                .buildAndRegister();
        //  24070 Potassium Cyanide
        PotassiumCyanide = new Material.Builder("potassium_cyanide")
                .dust()
                .color(0x9EF3D0)
                .iconSet(ROUGH)
                .components(Potassium, 1, Carbon, 1, Nitrogen, 1)
                .buildAndRegister();
        //  24071 Potassium Bromide
        PotassiumBromide = new Material.Builder("potassium_bromide")
                .dust()
                .color(0x615057)
                .iconSet(DULL)
                .components(Potassium, 1, Bromine, 1)
                .buildAndRegister();
        //  24072 Bismuth Vanadate
        BismuthVanadate = new Material.Builder("bismuth_vanadate")
                .dust()
                .color(0xFFAF33)
                .iconSet(SHINY)
                .components(Bismuth, 1, Vanadium, 1, Oxygen, 4)
                .buildAndRegister();
        //  24073 Bismuth Vanadate Solution
        BismuthVanadateSolution = new Material.Builder("bismuth_vanadate_solution")
                .fluid()
                .color(0xFFAF33)
                .flags(DISABLE_DECOMPOSITION)
                .components(Bismuth, 1, Vanadium, 1, Hydrogen, 2, Oxygen, 5)
                .buildAndRegister()
                .setFormula("BiVO4(H2O)", true);
        //  24074 Ammonium Vanadate
        AmmoniumVanadate = new Material.Builder("ammonium_vanadate")
                .dust()
                .color(0xCC9933)
                .iconSet(ROUGH)
                .flags(DISABLE_DECOMPOSITION)
                .components(Nitrogen, 1, Hydrogen, 4, Vanadium, 1, Oxygen, 3)
                .buildAndRegister();
        //  24075 Vanadium Slag
        VanadiumSlag = new Material.Builder("vanadium_slag")
                .dust()
                .color(0xCC9933)
                .iconSet(DULL)
                .flags(DISABLE_DECOMPOSITION)
                .components(Vanadium, 1, Oxygen, 1)
                .buildAndRegister();
        //  24076 Bismuth Nitrate Solution
        BismuthNitrateSolution = new Material.Builder("bismuth_nitrate_solution")
                .fluid()
                .color(0x3ABF50)
                .components(Bismuth, 1, Nitrogen, 3, Oxygen, 10, Hydrogen, 2)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister()
                .setFormula("Bi(NO3)3(H2O)");
        //  24077 Sodium Vanadate
        SodiumVanadate = new Material.Builder("sodium_vanadate")
                .dust()
                .color(0xCC9933)
                .iconSet(BRIGHT)
                .flags(DISABLE_DECOMPOSITION)
                .components(Sodium, 3, Vanadium, 1, Oxygen, 4)
                .buildAndRegister();
        //  24078 Vanadium Waste Solution
        VanadiumWasteSolution = new Material.Builder("vanadium_waste_solution")
                .fluid()
                .color(0xA28097)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister()
                .setFormula("NaCl(Na2SO4)(SiO2)(Al(OH)3)");
        //  24079 Sodium Bromide
        SodiumBromide = new Material.Builder("sodium_bromide")
                .dust()
                .color(0x830B2B)
                .iconSet(ROUGH)
                .components(Sodium, 1, Bromine, 1)
                .buildAndRegister();
        //  24080 White Phosphorus
        WhitePhosphorus = new Material.Builder("white_phosphorus")
                .gem()
                .color(0xECEADD)
                .iconSet(FLINT)
                .flags(DISABLE_DECOMPOSITION)
                .components(Phosphorus, 4)
                .buildAndRegister();
        //  24081 Red Phosphorus
        RedPhosphorus = new Material.Builder("red_phosphorus")
                .gem()
                .color(0x77040E)
                .iconSet(FLINT)
                .flags(DISABLE_DECOMPOSITION)
                .components(Phosphorus, 4)
                .buildAndRegister();
        //  24082 Violet Phosphorus
        VioletPhosphorus = new Material.Builder("violet_phosphorus")
                .gem()
                .color(0x8000FF)
                .iconSet(FLINT)
                .flags(DISABLE_DECOMPOSITION)
                .components(Phosphorus, 4)
                .buildAndRegister();
        //  24083 Black Phosphorus
        BlackPhosphorus = new Material.Builder("black_phosphorus")
                .gem()
                .color(0x36454F)
                .iconSet(FLINT)
                .flags(DISABLE_DECOMPOSITION)
                .components(Phosphorus, 4)
                .buildAndRegister();
        //  24084 Blue Phosphorus
        BluePhosphorus = new Material.Builder("blue_phosphorus")
                .gem()
                .color(0x9BE3E4)
                .iconSet(FLINT)
                .flags(DISABLE_DECOMPOSITION)
                .components(Phosphorus, 4)
                .buildAndRegister();
        //  24085 Wollastonite
        Wollastonite = new Material.Builder("wollastonite")
                .dust()
                .color(0xF0F0F0)
                .flags(DECOMPOSITION_BY_CENTRIFUGING)
                .components(Quicklime, 2, SiliconDioxide, 3)
                .buildAndRegister()
                .setFormula("CaSiO3", true);
        //  24086 Phosphorene
        Phosphorene = new Material.Builder("phosphorene")
                .ingot()
                .color(0x273239)
                .iconSet(SHINY)
                .flags(DISABLE_DECOMPOSITION, GENERATE_FOIL)
                .components(Phosphorus, 4)
                .buildAndRegister();
        //  24087 Phosphoryl Chloride
        PhosphorylChloride = new Material.Builder("phosphoryl_chloride")
                .fluid()
                .color(0xE8BB5B)
                .components(Phosphorus, 1, Oxygen, 1, Chlorine, 3)
                .buildAndRegister();
        //  24088 Phosphine
        Phosphine = new Material.Builder("phosphine")
                .gas()
                .color(0xACB330)
                .flags(DECOMPOSITION_BY_ELECTROLYZING, FLAMMABLE)
                .components(Phosphorus, 1, Hydrogen, 3)
                .buildAndRegister();
        //  24089 Copper Chloride
        CopperChloride = new Material.Builder("copper_chloride")
                .dust()
                .color(0x3FB3B8)
                .iconSet(ROUGH)
                .components(Copper, 1, Chlorine, 2)
                .buildAndRegister();
        //  24090 Lithium Hydroxide
        LithiumHydroxide = new Material.Builder("lithium_hydroxide")
                .dust()
                .color(0xDECAFA)
                .iconSet(FINE)
                .components(Lithium, 1, Oxygen, 1, Hydrogen, 1)
                .buildAndRegister();

        //  24091 Lithiuim Amalgam
        LithiumAmalgam = new Material.Builder("lithium_amalgam")
                .fluid()
                .color(0xAEA7D4)
                .iconSet(FINE)
                .flags(DISABLE_DECOMPOSITION)
                .components(Mercury, 1, Lithium, 1)
                .buildAndRegister();
        //  24092 Hexafluoride Enriched Naquadah Solution
        HexafluorideEnrichedNaquadahSolution = new Material.Builder("hexafluoride_enriched_naquadah_solution")
                .fluid()
                .color(0x868D7F)
                .components(NaquadahEnriched, 1, Fluorine, 6)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24093 Xenon Hexafluoro Enriched Naquadate
        XenonHexafluoroEnrichedNaquadate = new Material.Builder("xenon_hexafluoro_enriched_naquadate")
                .fluid()
                .color(0x255A55)
                .components(Xenon, 1, NaquadahEnriched, 1, Fluorine, 6)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24094 Enriched Naquadah Residue Solution
        EnrichedNaquadahResidueSolution = new Material.Builder("enriched_naquadah_residue_solution")
                .fluid()
                .color(0x868D7F)
                .iconSet(DULL)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister()
                .setFormula("XeAuSbKeF6S2?");
        //  24095 Xenoauric Fluoroantimonic Acid
        XenoauricFluoroantimonicAcid = new Material.Builder("xenoauric_fluoroantimonic_acid")
                .fluid(FluidStorageKeys.LIQUID, new FluidBuilder().attribute(FluidAttributes.ACID))
                .color(0xE0BD74)
                .components(Xenon, 1, Gold, 1, Antimony, 1, Fluorine, 6)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24096 Gold Chloride
        GoldChloride = new Material.Builder("gold_chloride")
                .fluid()
                .color(0xCCCC66)
                .components(Gold, 2, Chlorine, 6)
                .buildAndRegister();
        //  24097 Bromine Trifluoride
        BromineTrifluoride = new Material.Builder("bromine_trifluoride")
                .fluid()
                .color(0xA88E57)
                .components(Bromine, 1, Fluorine, 3)
                .buildAndRegister();
        //  24098 Gold Trifluoride
        GoldTrifluoride = new Material.Builder("gold_trifluoride")
                .dust()
                .color(0xE8C478)
                .iconSet(BRIGHT)
                .components(Gold, 1, Fluorine, 3)
                .buildAndRegister();
        //  24099 Naquadria Caesiumfluoride
        NaquadriaCaesiumfluoride = new Material.Builder("naquadria_caesiumfluoride")
                .fluid()
                .color(0xAAEB69)
                .components(Naquadria, 1, Fluorine, 3, Caesium, 1)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister()
                .setFormula("*Nq*F2CsF", true);
        //  24100 Acidic Naquadria Caesiumfluoride
        AcidicNaquadriaCaesiumfluoride = new Material.Builder("acidic_naquadria_caesiumfluoride")
                .fluid()
                .color(0x75EB00)
                .components(Naquadria, 1, Fluorine, 3, Caesium, 1, Sulfur, 2, Oxygen, 8)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister()
                .setFormula("*Nq*F2CsF(SO4)2", true);
        //  24101 Nitrosonium Octafluoroxenate
        NitrosoniumOctafluoroxenate = new Material.Builder("nitrosonium_octafluoroxenate")
                .fluid()
                .color(0x953D9F)
                .components(NitrogenDioxide, 2, Xenon, 1, Fluorine, 8)
                .buildAndRegister()
                .setFormula("(NO2)2XeF8", true);
        //  24102 Naquadria Caesium Xenonnonfluoride
        NaquadriaCaesiumXenonnonfluoride = new Material.Builder("naquadria_caesium_xenonnonfluoride")
                .fluid()
                .color(0x54C248)
                .components(Naquadria, 1, Caesium, 1, Xenon, 1, Fluorine, 9)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24103 Radon Naquadria Octafluoride
        RadonNaquadriaOctafluoride = new Material.Builder("radon_naquadria_octafluoride")
                .fluid()
                .color(0x85F378)
                .components(Radon, 1, Naquadria, 1, Fluorine, 8)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24104 Caesium Xenontrioxide Fluoride
        CaesiumXenontrioxideFluoride = new Material.Builder("caesium_xenontrioxide_fluoride")
                .fluid()
                .color(0x5067D7)
                .flags(DISABLE_DECOMPOSITION)
                .components(Caesium, 1, Xenon, 1, Oxygen, 3, Fluorine, 1)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24105 Radon Trioxide
        RadonTrioxide = new Material.Builder("radon_trioxide")
                .fluid()
                .color(0x9A6DD7)
                .components(Radon, 1, Oxygen, 3)
                .buildAndRegister();
        //  24106 Cesium Fluoride
        CaesiumFluoride = new Material.Builder("caesium_fluoride")
                .fluid()
                .color(0xFF7A5F)
                .components(Caesium, 1, Fluorine, 1)
                .buildAndRegister();
        //  24107 Xenon Trioxide
        XenonTrioxide = new Material.Builder("xenon_trioxide")
                .fluid()
                .color(0x359FC3)
                .components(Xenon, 1, Oxygen, 3)
                .buildAndRegister();
        //  24108 Hexafluoride Naquadria Solution
        HexafluorideNaquadriaSolution = new Material.Builder("hexafluoride_naquadria_solution")
                .fluid()
                .color(0x25C213)
                .components(Naquadria, 1, Fluorine, 6)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24109 Naquadria Residue Solution
        NaquadriaResidueSolution = new Material.Builder("naquadria_residue_solution")
                .fluid()
                .color(0x25C213)
                .iconSet(DULL)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister()
                .setFormula("InPS6?", true);
        //  24110 Radon Difluoride
        RadonDifluoride = new Material.Builder("radon_difluoride")
                .fluid()
                .color(0x8B7EFF)
                .components(Radon, 1, Fluorine, 2)
                .buildAndRegister();
        //  24111 Heavy Alkali Chloride Solution
        HeavyAlkaliChlorideSolution = new Material.Builder("heavy_alkali_chloride_solution")
                .fluid()
                .color(0x8F5353)
                .flags(DISABLE_DECOMPOSITION)
                .components(Rubidium, 1, Caesium, 2, Chlorine, 6, Water, 2)
                .buildAndRegister()
                .setFormula("RbCl(CsCl)2Cl3(H2O)2", true);
        //  24112 Stannic Chloride
        StannicChloride = new Material.Builder("stannic_chloride")
                .fluid()
                .color(0x33BBF5)
                .components(Tin, 1, Chlorine, 4)
                .buildAndRegister();
        //  24113 Rubidium Chlorostannate
        RubidiumChlorostannate = new Material.Builder("rubidium_chlorostannate")
                .dust()
                .color(0xBD888A)
                .iconSet(METALLIC)
                .components(Rubidium, 2, Tin, 1, Chlorine, 6)
                .buildAndRegister();
        //  24114 Caesium Chlorostannate
        CaesiumChlorostannate = new Material.Builder("caesium_chlorostannate")
                .dust()
                .color(0xBDAD88)
                .iconSet(SHINY)
                .components(Caesium, 2, Tin, 1, Chlorine, 6)
                .buildAndRegister();
        //  24115 Germanium Dioxide
        GermaniumDioxide = new Material.Builder("germanium_dioxide")
                .dust()
                .color(0x666666)
                .flags(DISABLE_DECOMPOSITION)
                .components(Germanium, 1, Oxygen, 2)
                .buildAndRegister();
        //  24116 Roasted Sphalerite
        RoastedSphalerite = new Material.Builder("roasted_sphalerite")
                .dust()
                .color(0xAC8B5C)
                .iconSet(FINE)
                .flags(DISABLE_DECOMPOSITION)
                .components(Gallium, 1, GermaniumDioxide, 1)
                .buildAndRegister();
        //  24117 Zinc Rich Sphalerite
        ZincRichSphalerite = new Material.Builder("zinc_rich_sphalerite")
                .dust()
                .color(0xC3AC8F)
                .iconSet(METALLIC)
                .flags(DISABLE_DECOMPOSITION)
                .components(Zinc, 2, RoastedSphalerite, 3)
                .buildAndRegister()
                .setFormula("Zn2(GaGeO2)", true);
        //  24118 Zinc Oxide
        ZincOxide = new Material.Builder("zinc_oxide")
                .dust()
                .color(0xB85C34)
                .flags(DECOMPOSITION_BY_ELECTROLYZING)
                .components(Zinc, 1, Oxygen, 1)
                .buildAndRegister();
        //  24119 Waelz Oxide
        WaelzOxide = new Material.Builder("waelz_oxide")
                .dust()
                .color(0xB8B8B8)
                .iconSet(FINE)
                .flags(DISABLE_DECOMPOSITION)
                .components(Zinc, 1, GermaniumDioxide, 1)
                .buildAndRegister();
        //  24120 Waelz Slag
        WaelzSlag = new Material.Builder("waelz_slag")
                .dust()
                .color(0xAC8B5C)
                .iconSet(ROUGH)
                .flags(DISABLE_DECOMPOSITION)
                .components(Gallium, 1, Zinc, 1, Sulfur, 1, Oxygen, 4)
                .buildAndRegister();
        //  24121 Impure Germanium Dioxide
        ImpureGermaniumDioxide = new Material.Builder("impure_germanium_dioxide")
                .dust()
                .color(0x666666)
                .iconSet(ROUGH)
                .flags(DISABLE_DECOMPOSITION)
                .components(GermaniumDioxide, 1)
                .buildAndRegister()
                .setFormula("GeO2?", true);
        //  24122 Germanium Tetrachloride
        GermaniumTetrachloride = new Material.Builder("germanium_tetrachloride")
                .fluid()
                .color(0x787878)
                .flags(DISABLE_DECOMPOSITION)
                .components(Germanium, 1, Chlorine, 4)
                .buildAndRegister();
        //  24123 Molybdenum Trioxide
        MolybdenumTrioxide = new Material.Builder("molybdenum_trioxide")
                .dust()
                .color(0xCBCFDA)
                .iconSet(ROUGH)
                .flags(DISABLE_DECOMPOSITION)
                .components(Molybdenum, 1, Oxygen, 3)
                .buildAndRegister();
        //  24124 Lead Chloride
        LeadChloride = new Material.Builder("lead_chloride")
                .dust()
                .color(0xF3F3F3)
                .iconSet(ROUGH)
                .components(Lead, 1, Chlorine, 2)
                .buildAndRegister();
        //  24125 Perrhenic Acid
        PerrhenicAcid = new Material.Builder("perrhenic_acid")
                .dust()
                .color(0xE6DC70)
                .iconSet(SHINY)
                .flags(DISABLE_DECOMPOSITION)
                .components(Hydrogen, 1, Rhenium, 1, Oxygen, 4)
                .buildAndRegister();
        //  24126 Ammonium Perrhenate
        AmmoniumPerrhenate = new Material.Builder("ammonium_perrhenate")
                .dust()
                .fluid()
                .color(0xA69970)
                .iconSet(METALLIC)
                .flags(DISABLE_DECOMPOSITION)
                .components(Nitrogen, 1, Hydrogen, 4, Rhenium, 1, Oxygen, 4)
                .buildAndRegister();
        //  24127 Niobium Pentoxide
        NiobiumPentoxide = new Material.Builder("niobium_pentoxide")
                .dust()
                .color(0xBAB0C3)
                .iconSet(ROUGH)
                .components(Niobium, 2, Oxygen, 5)
                .buildAndRegister();
        //  24128 Tantalum Pentoxide
        TantalumPentoxide = new Material.Builder("tantalum_pentoxide")
                .dust()
                .color(0x72728A)
                .iconSet(ROUGH)
                .components(Tantalum, 2, Oxygen, 5)
                .buildAndRegister();
        //  24129 Calcium Difluoride
        CalciumDifluoride = new Material.Builder("calcium_difluoride")
                .dust()
                .color(0xFFFC9E)
                .iconSet(ROUGH)
                .components(Calcium, 1, Fluorine, 2)
                .buildAndRegister();
        //  24130 Manganese Difluoride
        ManganeseDifluoride = new Material.Builder("manganese_difluoride")
                .dust()
                .color(0xEF4B3D)
                .iconSet(ROUGH)
                .components(Manganese, 1, Fluorine, 2)
                .buildAndRegister();
        //  24131 Calcium Carbide
        CalciumCarbide = new Material.Builder("calcium_carbide")
                .dust()
                .color(0x807B70)
                .iconSet(DULL)
                .components(Calcium, 1, Carbon, 2)
                .buildAndRegister();
        //  24132 Calcium Hydroxide
        CalciumHydroxide = new Material.Builder("calcium_hydroxide")
                .dust()
                .color(0x5F8764)
                .iconSet(ROUGH)
                .flags(DISABLE_DECOMPOSITION)
                .components(Calcium, 1, Hydrogen, 2, Oxygen, 2)
                .buildAndRegister()
                .setFormula("Ca(OH)2", true);
        //  24133 Sodium Tellurite
        SodiumTellurite = new Material.Builder("sodium_tellurite")
                .dust()
                .color(0xC6C9BE)
                .iconSet(ROUGH)
                .flags(DISABLE_DECOMPOSITION)
                .components(Sodium, 2, Tellurium, 1, Oxygen, 3)
                .buildAndRegister();
        //  24134 Selenium Dioxide
        SeleniumDioxide = new Material.Builder("selenium_dioxide")
                .dust()
                .color(0xE0DDD8)
                .iconSet(METALLIC)
                .flags(DISABLE_DECOMPOSITION)
                .components(Selenium, 1, Oxygen, 2)
                .buildAndRegister();
        //  24135 Tellurium Dioxide
        TelluriumDioxide = new Material.Builder("tellurium_dioxide")
                .dust()
                .color(0xE3DDB8)
                .iconSet(METALLIC)
                .flags(DISABLE_DECOMPOSITION)
                .components(Tellurium, 1, Oxygen, 2)
                .buildAndRegister();
        //  24136 Selenous Acid
        SelenousAcid = new Material.Builder("selenous_acid")
                .dust()
                .color(0xE0E083)
                .iconSet(SHINY)
                .flags(DISABLE_DECOMPOSITION)
                .components(Hydrogen, 2, Selenium, 1, Oxygen, 3)
                .buildAndRegister();
        //  24137 GST Glass
        GSTGlass = new Material.Builder("gst_glass")
                .ingot()
                .fluid()
                .color(0xCFFFFF)
                .iconSet(SHINY)
                .flags(GENERATE_PLATE, NO_SMASHING, NO_WORKING, DECOMPOSITION_BY_CENTRIFUGING)
                .components(Germanium, 2, Antimony, 2, Tellurium, 5)
                .blastTemp(873, BlastProperty.GasTier.MID)
                .buildAndRegister();
        //  24138 ZBLAN Glass
        ZBLANGlass = new Material.Builder("zblan_glass")
                .ingot()
                .fluid()
                .color(0xACB4BC)
                .iconSet(SHINY)
                .flags(NO_SMASHING, NO_WORKING, DISABLE_DECOMPOSITION, GENERATE_FINE_WIRE)
                .components(Zirconium, 5, Barium, 2, Lanthanum, 1, Aluminium, 1, Sodium, 2, Fluorine, 6)
                .buildAndRegister()
                .setFormula("(ZrF4)5(BaF2)2(LaF3)(AlF3)(NaF)2", true);
        //  24139 Erbium-doped ZBLAN Glass
        ErbiumDopedZBLANGlass = new Material.Builder("erbium_doped_zblan_glass")
                .ingot()
                .color(0x505444)
                .iconSet(BRIGHT)
                .flags(NO_SMASHING, NO_WORKING, DISABLE_DECOMPOSITION, GENERATE_PLATE)
                .components(ZBLANGlass, 1, Erbium, 1)
                .buildAndRegister()
                .setFormula("(ZrF4)5(BaF2)2(LaF3)(AlF3)(NaF)2Er", true);
        //  24140 PraseodymiumDopedZBLANGlass
        PraseodymiumDopedZBLANGlass = new Material.Builder("praseodymium_doped_zblan_glass")
                .ingot()
                .color(0xC5C88D)
                .iconSet(BRIGHT)
                .flags(NO_SMASHING, NO_WORKING, DISABLE_DECOMPOSITION, GENERATE_PLATE)
                .components(ZBLANGlass, 1, Praseodymium, 1)
                .buildAndRegister()
                .setFormula("(ZrF4)5(BaF2)2(LaF3)(AlF3)(NaF)2Pr", true);
        //  24141 Silicon Tetrachloride
        SiliconTetrachloride = new Material.Builder("silicon_tetrachloride")
                .fluid()
                .color(0x5B5B7A)
                .flags(DISABLE_DECOMPOSITION)
                .components(Silicon, 1, Chlorine, 4)
                .buildAndRegister();
        //  24142 Cadmium Sulfide
        CadmiumSulfide = new Material.Builder("cadmium_sulfide")
                .dust()
                .color(0xC8C43C)
                .flags(DECOMPOSITION_BY_ELECTROLYZING, GENERATE_PLATE)
                .iconSet(METALLIC)
                .components(Cadmium, 1, Sulfur, 1)
                .buildAndRegister();
        //  24143 Silicon Carbide
        SiliconCarbide = new Material.Builder("silicon_carbide")
                .dust()
                .fluid()
                .color(0x4D4D4D)
                .iconSet(METALLIC)
                .flags(GENERATE_FINE_WIRE)
                .components(Silicon, 1, Carbon, 1)
                .blastTemp(2500, BlastProperty.GasTier.HIGH, VA[UV])
                .cableProperties(V[UHV], 6, 8)
                .buildAndRegister();
        //  24144 Chromium Germanium Telluride
        ChromiumGermaniumTelluride = new Material.Builder("chromium_germanium_telluride")
                .ingot()
                .fluid()
                .color(0x8F103E)
                .iconSet(METALLIC)
                .flags(GENERATE_ROD, GENERATE_LONG_ROD)
                .components(/*Chrome, 1, */Germanium, 1, Tellurium, 3)
                .blastTemp(2900, BlastProperty.GasTier.HIGHER)
                .buildAndRegister();
        //  24145 Magnetic Chromium Germanium Telluride
        ChromiumGermaniumTellurideMagnetic = new Material.Builder("magnetic_chromium_germanium_telluride")
                .ingot()
                .color(0x8F103E)
                .iconSet(MAGNETIC)
                .flags(GENERATE_ROD, GENERATE_LONG_ROD, IS_MAGNETIC)
                .components(ChromiumGermaniumTelluride, 1)
                .ingotSmeltInto(ChromiumGermaniumTelluride)
                .arcSmeltInto(ChromiumGermaniumTelluride)
                .macerateInto(ChromiumGermaniumTelluride)
                .buildAndRegister();
        ChromiumGermaniumTelluride.getProperty(PropertyKey.INGOT).setMagneticMaterial(ChromiumGermaniumTellurideMagnetic);
        //  24146 Lithium Fluoride
        LithiumFluoride = new Material.Builder("lithium_fluoride")
                .dust()
                .color(0x9BAFDB)
                .iconSet(ROUGH)
                .components(Lithium, 1, Fluorine, 1)
                .buildAndRegister();
        //  24147 Barium Carbonate
        BariumCarbonate = new Material.Builder("barium_carbonate")
                .dust()
                .color(0x425A73)
                .iconSet(ROUGH)
                .components(Barium, 1, Carbon, 1, Oxygen, 3)
                .buildAndRegister();
        //  24148 Carbon Disulfide
        CarbonDisulfide = new Material.Builder("carbon_disulfide")
                .fluid()
                .color(0x1F80C8)
                .components(Carbon, 1, Sulfur, 2)
                .buildAndRegister();
        //  24149 Sodium Thiosulfate
        SodiumThiosulfate = new Material.Builder("sodium_thiosulfate")
                .dust()
                .color(0x1436A7)
                .iconSet(ROUGH)
                .components(Sodium, 2, Sulfur, 2, Oxygen, 3)
                .buildAndRegister();
        //  24150 Cadmium Selenide
        CadmiumSelenide = new Material.Builder("cadmium_selenide")
                .dust()
                .color(0x983034)
                .flags(DECOMPOSITION_BY_ELECTROLYZING)
                .iconSet(METALLIC)
                .components(Cadmium, 1, Selenium, 1)
                .buildAndRegister();
        //  24151 Thallium Copper Chloride Antiferromagnetic
        ThalliumCopperChloride = new Material.Builder("thallium_copper_chloride")
                .ingot()
                .fluid()
                .color(0x3C5CB5)
                .iconSet(MAGNETIC)
                .flags(GENERATE_FINE_WIRE)
                .components(Thallium, 1, Copper, 1, Chlorine, 3)
                .buildAndRegister();
        //  24152 Plutonium Trihydride
        PlutoniumTrihydride = new Material.Builder("plutonium_trihydride")
                .dust()
                .color(0x140002)
                .iconSet(SHINY)
                .flags(DISABLE_DECOMPOSITION)
                .components(Plutonium239, 1, Hydrogen, 3)
                .buildAndRegister()
                .setFormula("PuH3", true);
        //  24153 Plutonium Phosphide
        PlutoniumPhosphide = new Material.Builder("plutonium_phosphide")
                .ingot()
                .color(0x1F0104)
                .iconSet(MAGNETIC)
                .flags(GENERATE_PLATE, GENERATE_ROD, GENERATE_LONG_ROD)
                .components(Plutonium239, 1, Phosphorus, 1)
                .buildAndRegister()
                .setFormula("PuP", true);
        //  24154 Neptunium Aluminide
        NeptuniumAluminide = new Material.Builder("neptunium_aluminide")
                .ingot()
                .fluid()
                .color(0x5E228F)
                .iconSet(MAGNETIC)
                .flags(GENERATE_PLATE, GENERATE_ROD, GENERATE_LONG_ROD)
                .components(Neptunium, 1, Aluminium, 3)
                .blastTemp(1568, BlastProperty.GasTier.HIGHER, VA[ZPM])
                .buildAndRegister()
                .setFormula("NpAl3", true);
        //  24155 Bismuth Trioxide
        BismuthTrioxide = new Material.Builder("bismuth_trioxide")
                .dust()
                .color(0xF5EF42)
                .iconSet(FINE)
                .components(Bismuth, 2, Oxygen, 3)
                .buildAndRegister();
        //  24156 Ferric Oxide
        FerricOxide = new Material.Builder("ferric_oxide")
                .dust()
                .color(0x915A5A)
                .iconSet(ROUGH)
                .components(Iron, 2, Oxygen, 3)
                .buildAndRegister();
        //  24157 Bismuth Ferrite
        BismuthFerrite = new Material.Builder("bismuth_ferrite")
                .gem()
                .color(0x43634B)
                .iconSet(MAGNETIC)
                .flags(CRYSTALLIZABLE, GENERATE_PLATE)
                .components(BismuthTrioxide, 2, FerricOxide, 2)
                .buildAndRegister()
                .setFormula("BiFeO3", true);
        //  24158 Bismuth Chalcogenide
        BismuthChalcogenide = new Material.Builder("bismuth_chalcogenide")
                .ingot()
                .color(0x91994D)
                .iconSet(SHINY)
                .flags(GENERATE_PLATE, GENERATE_FOIL, DECOMPOSITION_BY_ELECTROLYZING)
                .components(Bismuth, 1, Antimony, 1, Tellurium, 2, Sulfur, 1)
                .buildAndRegister();
        //  24159 Mercury Cadmium Telluride
        MercuryCadmiumTelluride = new Material.Builder("mercury_cadmium_telluride")
                .ingot()
                .fluid()
                .color(0x823C80)
                .iconSet(BRIGHT)
                .flags(GENERATE_PLATE, GENERATE_FOIL, GENERATE_FINE_WIRE)
                .components(Mercury, 2, Cadmium, 1, Tellurium, 2)
                .blastTemp(2170, BlastProperty.GasTier.HIGHER, VA[UHV])
                .buildAndRegister();
        //  24160 Cubic Zirconia
        CubicZirconia = new Material.Builder("cubic_zirconia")
                .gem()
                .color(0xFFDFE2)
                .iconSet(DIAMOND)
                .flags(CRYSTALLIZABLE, DISABLE_DECOMPOSITION)
                .components(Zirconium, 1, Oxygen, 2)
                .buildAndRegister();
        //  24161 Bismuth Tellurite
        BismuthTellurite = new Material.Builder("bismuth_tellurite")
                .dust()
                .color(0x0E8933)
                .iconSet(DULL)
                .components(Bismuth, 2, Tellurium, 3)
                .buildAndRegister();
        //  24162 Prasiolite
        Prasiolite = new Material.Builder("prasiolite")
                .gem()
                .ore(1, 3, false)
                .addOreByproducts(SiliconDioxide)
                .color(0x9EB749)
                .iconSet(QUARTZ)
                .flags(CRYSTALLIZABLE, GENERATE_LENS)
                .components(SiliconDioxide, 5, Iron, 1)
                .buildAndRegister();
        //  24163 Magneto Resonatic
        MagnetoResonatic = new Material.Builder("magneto_resonatic")
                .gem()
                .color(0xFF97FF)
                .iconSet(MAGNETIC)
                .components(Prasiolite, 3, BismuthTellurite, 6, CubicZirconia, 1, SteelMagnetic, 1)
                .flags(GENERATE_LENS)
                .buildAndRegister();
        //  24164 Yttrium Trioxide
        YttriumTrioxide = new Material.Builder("yttrium_trioxide")
                .dust()
                .color(0x765320)
                .iconSet(DULL)
                .components(Yttrium, 2, Oxygen, 3)
                .buildAndRegister();
        //  24165 Heavy Taranium Fuel
        HeavyTaraniumFuel = new Material.Builder("heavy_taranium_fuel")
                .fluid()
                .color(0x141414)
                .flags(DISABLE_DECOMPOSITION)
                .components(Taranium, 1)
                .buildAndRegister();
        //  24166 Medium Taranium Fuel
        MediumTaraniumFuel = new Material.Builder("medium_taranium_fuel")
                .fluid()
                .color(0x181818)
                .flags(DISABLE_DECOMPOSITION)
                .components(Taranium, 1)
                .buildAndRegister();
        //  24167 Light Taraniumm Fuel
        LightTaraniumFuel = new Material.Builder("light_taranium_fuel")
                .fluid()
                .color(0x1C1C1C)
                .flags(DISABLE_DECOMPOSITION)
                .components(Taranium, 1)
                .buildAndRegister();
        //  24168 Heavy Enriched Taranium Fuel
        HeavyEnrichedTaraniumFuel = new Material.Builder("heavy_enriched_taranium_fuel")
                .fluid()
                .color(0x0F1414)
                .flags(DISABLE_DECOMPOSITION)
                .components(Taranium, 1)
                .buildAndRegister();
        //  24169 Medium Enriched Taranium Fuel
        MediumEnrichedTaraniumFuel = new Material.Builder("medium_enriched_taranium_fuel")
                .fluid()
                .color(0x0F1818)
                .flags(DISABLE_DECOMPOSITION)
                .components(Taranium, 1)
                .buildAndRegister();
        //  24170 Light Enriched Taranium Fuel
        LightEnrichedTaraniumFuel = new Material.Builder("light_enriched_taranium_fuel")
                .fluid()
                .color(0x0F1C1C)
                .flags(DISABLE_DECOMPOSITION)
                .components(Taranium, 1)
                .buildAndRegister();
        //  24171 Adamantite
        Adamantite = new Material.Builder("adamantite")
                .dust()
                .color(0xC83C3C)
                .iconSet(ROUGH)
                .components(Adamantium, 3, Oxygen, 4)
                .buildAndRegister();
        //  24172 Unstable Adamantium
        AdamantiumUnstable = new Material.Builder("adamantium_unstable")
                .fluid()
                .color(0xFF763C)
                .flags(DISABLE_DECOMPOSITION)
                .components(Adamantium, 1)
                .buildAndRegister();
        //  24173 Energized Orichalcum
        OrichalcumEnergized = new Material.Builder("orichalcum_energized")
                .dust()
                .color(0xF4FC0C)
                .iconSet(BRIGHT)
                .flags(DISABLE_DECOMPOSITION)
                .components(Orichalcum, 1)
                .buildAndRegister();
        //  24174 Enriched Adamantium
        AdamantiumEnriched = new Material.Builder("adamantium_enriched")
                .dust()
                .color(0x64B4FF)
                .iconSet(ROUGH)
                .flags(DISABLE_DECOMPOSITION)
                .components(Vibranium, 1, RareEarth, 1)
                .buildAndRegister();
        //  24175 Deep Iron
        DeepIron = new Material.Builder("deep_iron")
                .dust()
                .color(0x968C8C)
                .iconSet(METALLIC)
                .flags(DISABLE_DECOMPOSITION)
                .components(Iron, 2, Trinium, 1, Indium, 1)
                .buildAndRegister();
        //  24176 Unstable Vibranium
        VibraniumUnstable = new Material.Builder("vibranium_unstable")
                .fluid()
                .color(0xFF7832)
                .flags(DISABLE_DECOMPOSITION)
                .components(Vibranium, 1)
                .buildAndRegister();
        //  24177 Lanthanum Oxide
        LanthanumOxide = new Material.Builder("lanthanum_oxide")
                .dust()
                .color(0x5F7777)
                .iconSet(SHINY)
                .components(Lanthanum, 2, Oxygen, 3)
                .buildAndRegister();
        //  24178 Praseodymium Oxide
        PraseodymiumOxide = new Material.Builder("praseodymium_oxide")
                .dust()
                .color(0xD0D0D0)
                .iconSet(METALLIC)
                .components(Praseodymium, 2, Oxygen, 3)
                .buildAndRegister();
        //  24179 Neodymium Oxide
        NeodymiumOxide = new Material.Builder("neodymium_oxide")
                .dust()
                .color(0x868686)
                .components(Neodymium, 2, Oxygen, 3)
                .buildAndRegister();
        //  24180 Cerium Oxide
        CeriumOxide = new Material.Builder("cerium_oxide")
                .dust()
                .color(0x10937F)
                .iconSet(METALLIC)
                .components(Cerium, 1, Oxygen, 2)
                .buildAndRegister();
        //  24181 Scandium Oxide
        ScandiumOxide = new Material.Builder("scandium_oxide")
                .dust()
                .color(0x43964F)
                .iconSet(METALLIC)
                .components(Scandium, 2, Oxygen, 3)
                .buildAndRegister();
        //  24182 Europium Oxide
        EuropiumOxide = new Material.Builder("europium_oxide")
                .dust()
                .color(0x20AAAA)
                .iconSet(SHINY)
                .components(Europium, 2, Oxygen, 3)
                .buildAndRegister();
        //  24183 Gadolinium Oxide
        GadoliniumOxide = new Material.Builder("gadolinium_oxide")
                .dust()
                .color(0xEEEEFF)
                .iconSet(METALLIC)
                .components(Gadolinium, 2, Oxygen, 3)
                .buildAndRegister();
        //  24184 Samarium Oxide
        SamariumOxide = new Material.Builder("samarium_oxide")
                .dust()
                .color(0xFFFFDD)
                .components(Samarium, 2, Oxygen, 3)
                .buildAndRegister();
        //  24185 Yttrium Oxide
        YttriumOxide = new Material.Builder("yttrium_oxide")
                .dust()
                .color(0x78544E)
                .iconSet(SHINY)
                .components(Yttrium, 2, Oxygen, 3)
                .buildAndRegister();
        //  24186 Terbium Oxide
        TerbiumOxide = new Material.Builder("terbium_oxide")
                .dust()
                .color(0xA264A2)
                .iconSet(METALLIC)
                .components(Terbium, 2, Oxygen, 3)
                .buildAndRegister();
        //  24187 Dysprosium Oxide
        DysprosiumOxide = new Material.Builder("dysprosium_oxide")
                .dust()
                .color(0xD273D2)
                .iconSet(METALLIC)
                .components(Dysprosium, 2, Oxygen, 3)
                .buildAndRegister();
        //  24188 Holmium Oxide
        HolmiumOxide = new Material.Builder("holmium_oxide")
                .dust()
                .color(0xAF7F2A)
                .iconSet(SHINY)
                .components(Holmium, 2, Oxygen, 3)
                .buildAndRegister();
        //  24189 Erbium Oxide
        ErbiumOxide = new Material.Builder("erbium_oxide")
                .dust()
                .color(0xE07A32)
                .iconSet(METALLIC)
                .components(Erbium, 2, Oxygen, 3)
                .buildAndRegister();
        //  24190 Thulium Oxide
        ThuliumOxide = new Material.Builder("thulium_oxide")
                .dust()
                .color(0x3B9E8B)
                .components(Thulium, 2, Oxygen, 3)
                .buildAndRegister();
        //  24191 Ytterbium Oxide
        YtterbiumOxide = new Material.Builder("ytterbium_oxide")
                .dust()
                .color(0xA9A9A9)
                .components(Ytterbium, 2, Oxygen, 3)
                .buildAndRegister();
        //  24192 Lutetium Oxide
        LutetiumOxide = new Material.Builder("lutetium_oxide")
                .dust()
                .color(0x11BBFF)
                .iconSet(METALLIC)
                .components(Lutetium, 2, Oxygen, 3)
                .buildAndRegister();
        //  24193 Manganese Sulfate
        ManganeseSulfate = new Material.Builder("manganese_sulfate")
                .dust()
                .color(0xF0F895)
                .iconSet(ROUGH)
                .components(Manganese, 1, Sulfur, 1, Oxygen, 4)
                .buildAndRegister();
        //  24194 Potassium Sulfate
        PotassiumSulfate = new Material.Builder("potassium_sulfate")
                .dust()
                .color(0xF4FBB0)
                .iconSet(DULL)
                .components(Potassium, 2, Sulfur, 1, Oxygen, 4)
                .buildAndRegister();
        //  24195 Ammonium Cyanate
        AmmoniumCyanate = new Material.Builder("ammonium_cyanate")
                .fluid()
                .color(0x3a5dcf)
                .components(Hydrogen, 4, Nitrogen, 2, Carbon, 1, Oxygen, 1)
                .buildAndRegister()
                .setFormula("NH4CNO", true);
        //  24196 Carbamide
        Carbamide = new Material.Builder("carbamide")
                .dust()
                .color(0x16EF57)
                .iconSet(ROUGH)
                .components(Carbon, 1, Hydrogen, 4, Nitrogen, 2, Oxygen, 1)
                .buildAndRegister();
        //  24197 Neodymium-Doped Yttrium Oxide
        NeodymiumDopedYttriumOxide = new Material.Builder("neodymium_doped_yttrium_oxide")
                .dust()
                .color(0x5AD55F)
                .iconSet(DULL)
                .buildAndRegister()
                .setFormula("Nd:Y?", false);
        //  24198 Alumina Solution
        AluminaSolution = new Material.Builder("alumina_solution")
                .fluid()
                .color(0x6C4DC1)
                .buildAndRegister()
                .setFormula("(Al2O3)(CH2Cl2)(C12H27N)2", true);
        //  24199 Crude Alumina Solution
        CrudeAluminaSolution = new Material.Builder("crude_alumina_solution")
                .fluid()
                .color(0x8974C1)
                .buildAndRegister()
                .setFormula("(Al(NO3)3)2(CH2Cl2)(C12H27N)", true);
        //  24200 Carbon Tetrachloride
        CarbonTetrachloride = new Material.Builder("carbon_tetrachloride")
                .fluid()
                .color(0x2d8020)
                .components(Carbon, 1, Chlorine, 4)
                .buildAndRegister();
        //  24201 Aluminium Nitrate
        AluminiumNitrate = new Material.Builder("aluminium_nitrate")
                .dust()
                .color(0x3AB3AA)
                .iconSet(SHINY)
                .components(Aluminium, 1, Nitrogen, 3, Oxygen, 9)
                .buildAndRegister()
                .setFormula("Al(NO3)3", true);
        //  24202 Unprocessed Nd:YAG Solution
        UnprocessedNdYAGSolution = new Material.Builder("unprocessed_nd_yag_solution")
                .fluid()
                .color(0x6f20af)
                .iconSet(DULL)
                .buildAndRegister()
                .setFormula("Nd:YAG", false);
        //  24203 Nd:YAG
        NdYAG = new Material.Builder("nd_yag")
                .gem()
                .color(0xD99DE4)
                .iconSet(GEM_VERTICAL)
                .flags(CRYSTALLIZABLE, DECOMPOSITION_BY_CENTRIFUGING, GENERATE_LENS)
                .components(YttriumOxide, 2, NeodymiumOxide, 1, Alumina, 5)
                .buildAndRegister()
                .setFormula("NdY2Al5O12", true);
        //  24204 Au-Pd-C Catalyst
        AuPdCCatalyst = new Material.Builder("au_pd_c_catalyst")
                .dust()
                .color(0xB7B305)
                .iconSet(SHINY)
                .components(Gold, 1, PalladiumOnCarbon, 1)
                .buildAndRegister();
        //  24205 Sodium Oxide
        SodiumOxide = new Material.Builder("sodium_oxide")
                .dust()
                .color(0x2C96FC)
                .iconSet(BRIGHT)
                .components(Sodium, 2, Oxygen, 1)
                .buildAndRegister();
        //  24206 Sodium Tungstate
        SodiumTungstate = new Material.Builder("sodium_tungstate")
                .fluid()
                .color(0x595E54)
                .components(Sodium, 1, Tungsten, 1, Oxygen, 4)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24207 Sodium Phosphotungstate
        SodiumPhosphotungstate = new Material.Builder("sodium_phosphotungstate")
                .dust()
                .color(0x4D3635)
                .components(Oxygen, 40, Tungsten, 12, Sodium, 3, Phosphorus, 1)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister()
                .setFormula("(WO3)12Na3PO4", true);
        //  24208 Sodium Molybdate
        SodiumMolybdate = new Material.Builder("sodium_molybdate")
                .dust()
                .color(0xCCCC99)
                .iconSet(ROUGH)
                .components(Sodium, 2, Molybdenum, 1, Oxygen, 4)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24209 Sodium Phosphomolybdate
        SodiumPhosphomolybdate = new Material.Builder("sodium_phosphomolybdate")
                .dust()
                .color(0xF3E0A8)
                .iconSet(BRIGHT)
                .components(Oxygen, 40, Molybdenum, 12, Sodium, 3, Phosphorus, 1)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister()
                .setFormula("(MoO3)12Na3PO4", true);
        //  24210 Sodium Acetate
        SodiumAcetate = new Material.Builder("sodium_acetate")
                .fluid()
                .color(0xC5D624)
                .components(SodiumHydroxide, 1, Ethenone, 1)
                .buildAndRegister()
                .setFormula("C2H3NaO2", true);
        //  24211 Neutron Star Core Material
        NeutronStarCoreMaterial = new Material.Builder("neutron_star_core_material")
                .ingot()
                .fluid(FluidStorageKeys.LIQUID, new FluidBuilder().temperature(2147483647))
                .color(0x70ecff)
                .iconSet(BRIGHT)
                .flags(NO_SMASHING, NO_SMELTING, GENERATE_PLATE, GENERATE_CURVED_PLATE, GENERATE_ROTOR, GENERATE_FRAME)
                .buildAndRegister();
        //  24212 Magneto Hydrodynamically Constrained Star Matter
//        MagnetoHydrodynamicallyConstrainedStarMatter = new Material.Builder("magneto_hydrodynamically_constrained_star_matter")
//                .ingot()
//                .fluid(FluidStorageKeys.LIQUID, new FluidBuilder().temperature(600000000))
//                .iconSet(CUSTOM_MHCSM)
//                .flags(NO_SMELTING, GENERATE_PLATE, GENERATE_ROD, GENERATE_LONG_ROD, GENERATE_RING, GENERATE_ROUND, GENERATE_BOLT_SCREW, GENERATE_FRAME, GENERATE_GEAR, GENERATE_SMALL_GEAR)
//                .buildAndRegister();
        //  24213 White Dwarf Matter
        WhiteDwarfMatter = new Material.Builder("white_dwarf_matter")
                .ingot()
                .fluid(FluidStorageKeys.LIQUID, new FluidBuilder().temperature(288000000))
                .iconSet(MAGNETIC)
                .flags(GENERATE_ROD, GENERATE_LONG_ROD)
                .buildAndRegister();
        //  24214 BlackDwarfMatter
        BlackDwarfMatter = new Material.Builder("black_dwarf_matter")
                .ingot()
                .fluid(FluidStorageKeys.LIQUID, new FluidBuilder().temperature(266000000))
                .color(0x000000)
                .iconSet(BRIGHT)
                .cableProperties(V[UIV], 144, 72, false)
                .buildAndRegister();
        //  24215 Raw Star Matter
        RawStarMatter = new Material.Builder("raw_star_matter")
                .fluid(FluidStorageKeys.LIQUID, new FluidBuilder().temperature(600000000))
                .buildAndRegister();
        //  24216 Dimensionally Transcendent Residue
        DimensionallyTranscendentResidue = new Material.Builder("dimensionally_transcendent_residue")
                .fluid(FluidStorageKeys.LIQUID, new FluidBuilder().temperature(999999999))
                .buildAndRegister();
        //  24217 Heavy Lepton Mixture
        HeavyLeptonMixture = new Material.Builder("heavy_lepton_mixture")
                .fluid(FluidStorageKeys.LIQUID, new FluidBuilder().temperature(524288))
                .buildAndRegister()
                .setFormula(OBFUSCATED  + "a" + RESET + "§e(t2)u" + OBFUSCATED  + "a", true);
        //  24218 Heavy Quarks
        HeavyQuarks = new Material.Builder("heavy_quarks")
                .fluid(FluidStorageKeys.LIQUID, new FluidBuilder().temperature(131072))
                .buildAndRegister()
                .setFormula(OBFUSCATED + "a"  + RESET + "§e(u2)ds" + OBFUSCATED + "a" , true);
        //  24219 Gluons
        Gluons = new Material.Builder("gluons")
                .fluid(FluidStorageKeys.LIQUID, new FluidBuilder().temperature(2097152))
                .buildAndRegister()
                .setFormula(OBFUSCATED  + "a" + RESET + "§eg" + OBFUSCATED  + "a", false);
        //  24220 Instantons
        Instantons = new Material.Builder("instantons")
                .fluid(FluidStorageKeys.LIQUID, new FluidBuilder().temperature(8388608))
                .buildAndRegister()
                .setFormula(OBFUSCATED  + "a" + RESET + "§ei" + OBFUSCATED  + "a", false);
        //  24221 Temporal Fluid
        TemporalFluid = new Material.Builder("temporal_fluid")
                .fluid(FluidStorageKeys.LIQUID, new FluidBuilder().temperature(134217728))
                .buildAndRegister()
                .setFormula(OBFUSCATED  + "a"  + RESET + "§et" + OBFUSCATED  + "a", false);
        //  24222 Higgs Bosons
        HiggsBosons = new Material.Builder("higgs_bosons")
                .fluid(FluidStorageKeys.LIQUID, new FluidBuilder().temperature(/*0*/1))
                .buildAndRegister()
                .setFormula(OBFUSCATED  + "a" + RESET + "§eh" + OBFUSCATED + "a", false);
        //  24223 Cosmic Computing Mixture
        CosmicComputingMixture = new Material.Builder("cosmic_computing_mixture")
                .fluid(FluidStorageKeys.LIQUID, new FluidBuilder().temperature(536870912))
                .components(HeavyLeptonMixture, 32, HeavyQuarks, 8, Gluons, 8, Instantons, 4, TemporalFluid, 4, HiggsBosons, 4)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister()
                .setFormula(OBFUSCATED + "aaaaaa", false);
        //  24224 Silica Gel
        SilicaGel = new Material.Builder("silica_gel")
                .dust()
                .color(0x9695FD)
                .iconSet(SHINY)
                .components(Silicon, 1, Oxygen, 2)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24225 Silica Gel Base
        SilicaGelBase = new Material.Builder("silica_gel_base")
                .fluid()
                .color(0x9695FD)
                .iconSet(ROUGH)
                .components(SiliconDioxide, 1, HydrochloricAcid, 1, SodiumHydroxide, 1, Water, 1)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24226 Nitronium Tetrafluoroborate
        NitroniumTetrafluoroborate = new Material.Builder("nitronium_tetrafluoroborate")
                .dust()
                .color(0x787449)
                .iconSet(DULL)
                .components(Sodium, 1, Oxygen, 2, Boron, 1, Fluorine, 4)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24227 Nitrosonium Tetrafluoroborate
        NitrosoniumTetrafluoroborate = new Material.Builder("nitrosonium_tetrafluoroborate")
                .dust()
                .color(0xA32A8C)
                .iconSet(ROUGH)
                .components(Sodium, 1, Oxygen, 1, Boron, 1, Fluorine, 4)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24228 Tetrafluoroboric Acid
        TetrafluoroboricAcid = new Material.Builder("tetrafluoroboric_acid")
                .fluid()
                .color(0x83A731)
                .components(Hydrogen, 1, Boron, 1, Fluorine, 4)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24229 Nitrogen Monoxide
        NitrogenMonoxide = new Material.Builder("nitrogen_monoxide")
                .fluid()
                .color(0x98BCDA)
                .components(Nitrogen, 1, Oxygen, 1)
                .buildAndRegister();
        //  24230 Hydroxylammonium Sulfate
        HydroxylammoniumSulfate = new Material.Builder("hydroxylammonium_sulfate")
                .dust()
                .color(0x999933)
                .iconSet(DULL)
                .components(Nitrogen, 2, Hydrogen, 8, Oxygen, 6, Sulfur, 1)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister()
                .setFormula("(NH3OH)2SO4", true);
        //  24231 Potassium Hydroxylaminedisulfonate
        PotassiumHydroxylaminedisulfonate = new Material.Builder("potassium_hydroxylaminedisulfonate")
                .dust()
                .color(0x627D25)
                .iconSet(ROUGH)
                .components(Potassium, 2, Nitrogen, 1, Hydrogen, 1, Sulfur, 2, Oxygen, 7)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24232 Potassium Bisulfite
        PotassiumBisulfite = new Material.Builder("potassium_bisulfite")
                .dust()
                .color(344314)
                .iconSet(DULL)
                .components(Potassium, 1, Hydrogen, 1, Sulfur, 1, Oxygen, 3)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24233 Potassium Carbonate
        PotassiumCarbonate = new Material.Builder("potassium_carbonate")
                .dust()
                .color(0x7C89D9)
                .iconSet(ROUGH)
                .components(Potassium, 2, Carbon, 1, Oxygen, 3)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24234 Nitrous Acid
        NitrousAcid = new Material.Builder("nitrous_acid")
                .fluid(FluidStorageKeys.LIQUID, new FluidBuilder().attribute(FluidAttributes.ACID))
                .color(0x7D82A3)
                .components(Hydrogen, 1, Nitrogen, 1, Oxygen, 2)
                .buildAndRegister();
        //  24235 Potassium Nitrite
        PotassiumNitrite = new Material.Builder("potassium_nitrite")
                .dust()
                .color(0xB9B9B9)
                .components(Potassium, 1, Nitrogen, 1, Oxygen, 2)
                .buildAndRegister();
        //  24236 Barium Dichloride
        BariumDichloride = new Material.Builder("barium_dichloride")
                .dust()
                .color(0xBF6700)
                .iconSet(BRIGHT)
                .components(Barium, 1, Chlorine, 2)
                .buildAndRegister();
        //  24237 Hydroxylamine Hydrochloride
        HydroxylamineHydrochloride = new Material.Builder("hydroxylamine_hydrochloride")
                .fluid()
                .color(0x893E28)
                .components(Hydrogen, 4, Oxygen, 1, Nitrogen, 1, Chlorine,1 )
                .buildAndRegister()
                .setFormula("HONH2HCl", true);
        //  24238 Barium Sulfate Suspension
        BariumSulfateSuspension = new Material.Builder("barium_sulfate_suspension")
                .fluid()
                .color(0x71560B)
                .components(Barium, 1, Sulfur, 1, Oxygen, 4, Water, 1)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24239 Ammonium Acetate
        AmmoniumAcetate = new Material.Builder("ammonium_acetate")
                .dust()
                .color(0x646882)
                .components(Carbon, 2, Hydrogen, 7, Oxygen, 2, Nitrogen, 1)
                .buildAndRegister()
                .setFormula("NH4CH3CO2", true);
        //  24240 Ammonium Carbonate
        AmmoniumCarbonate = new Material.Builder("ammonium_carbonate")
                .dust()
                .color(0x7C89D9)
                .components(Carbon, 1, Hydrogen, 8, Oxygen, 3, Nitrogen, 2)
                .buildAndRegister()
                .setFormula("(NH4)2CO3", true);
        //  24241 Free Electron Gas
        FreeElectronGas = new Material.Builder("free_electron_gas")
                .gas()
                .color(0x507BB3)
                .buildAndRegister()
                .setFormula(OBFUSCATED  + "a" + RESET + "§ee" + OBFUSCATED + "a", false);
        //  24242 Quark Gluon Plasma
        QuarkGluonPlasma = new Material.Builder("quark_gluon_plasma")
                .fluid(FluidStorageKeys.PLASMA, new FluidBuilder().temperature((int) (V[ZPM] + V[UHV])/2))
                .color(HeavyQuarks.getMaterialRGB() + Gluons.getMaterialRGB())
                .buildAndRegister()
                .setFormula(OBFUSCATED  + "a" + RESET + "§e(u2)d(c2)s(t2)bg" + OBFUSCATED + "a", false);
        //  24243 Light Quarks
        LightQuarks = new Material.Builder("light_quarks")
                .fluid(FluidStorageKeys.LIQUID, new FluidBuilder().temperature((VA[ZPM] + VA[UHV])/2))
                .color(QuarkGluonPlasma.getMaterialRGB() - HeavyQuarks.getMaterialRGB())
                .buildAndRegister()
                .setFormula(OBFUSCATED  + "a" + RESET + "§e(c2)(t2)b" + OBFUSCATED + "a", false);
        //  24244 Ferric Catalyst
        FerricCatalyst = new Material.Builder("ferric_catalyst")
                .dust()
                .color(FerricOxide.getMaterialRGB() + HydrogenPeroxide.getMaterialRGB())
                .components(FerricOxide, 1, HydrogenPeroxide, 1)
                .buildAndRegister();
        //  24245 Neutron
        Neutron = new Material.Builder("neutron")
                .fluid(FluidStorageKeys.PLASMA, new FluidBuilder().temperature((int) V[UXV]))
                .color(0xFCFCFC)
                .buildAndRegister()
                .setFormula(OBFUSCATED  + "a" + RESET + "n§e" + OBFUSCATED + "a", false);
        //  24246 Helium-Neon Gas
        HeliumNeon = new Material.Builder("helium_neon")
                .gas()
                .color(0xFF0080)
                .flags(DECOMPOSITION_BY_CENTRIFUGING)
                .components(Helium, 1, Neon, 1)
                .buildAndRegister();
        //  24247 Polonium Nitrate
        PoloniumNitrate = new Material.Builder("polonium_nitrate")
                .fluid()
                .color(Polonium.getMaterialRGB() + NitricAcid.getMaterialRGB())
                .components(Polonium, 1, Nitrogen, 4, Oxygen, 12)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister()
                .setFormula("Po(NO3)4", true);
        //  24248 Polonium Chloride
        PoloniumChloride = new Material.Builder("polonium_chloride")
                .dust()
                .color(Polonium.getMaterialRGB() + Chlorine.getMaterialRGB())
                .components(Polonium, 1, Chlorine, 2)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24249 Celestite
        Celestite = new Material.Builder("celestite")
                .gem()
                .color(0x4AE3E6)
                .iconSet(OPAL)
                .components(Strontium, 1, Sulfur, 1, Oxygen, 4)
                .flags(CRYSTALLIZABLE, DISABLE_DECOMPOSITION, GENERATE_LENS)
                .buildAndRegister();
        //  24250 Strontium Carbonate
        StrontiumCarbonate = new Material.Builder("strontium_carbonate")
                .dust()
                .color(0x1DAFD3)
                .iconSet(SAND)
                .components(Strontium, 1, Carbon, 1, Oxygen, 3)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24251 Strontium Oxide
        StrontiumOxide = new Material.Builder("stronium_oxide")
                .dust()
                .color(0x16839E)
                .iconSet(BRIGHT)
                .components(Strontium, 1, Oxygen, 1)
                .buildAndRegister();
        //  24252 Acidic Pyrochlore
        AcidicPyrochlore = new Material.Builder("acidic_pyrochlore")
                .dust()
                .color(Pyrochlore.getMaterialRGB() + SulfuricAcid.getMaterialRGB())
                .iconSet(SHINY)
                .components(Pyrochlore, 1, SulfuricAcid, 1)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24253 Thorium-Uranium Solution
        ThoriumUraniumSolution = new Material.Builder("thorium_uranium_solution")
                .fluid()
                .color(Thorium.getMaterialRGB() + Uranium235.getMaterialRGB())
                .iconSet(DULL)
                .buildAndRegister()
                .setFormula("?SO4", true);
        //  24254 Leaching Pyrochlore
        LeachingPyrochlore = new Material.Builder("leaching_pyrochlore")
                .dust()
                .color(0xE2502C)
                .iconSet(BRIGHT)
                .buildAndRegister()
                .setFormula("(Nb2O5)9Ta2O5?", true);
        //  24255 Barium-Strontium-Radium Solution
        BariumStrontiumRadiumSolution = new Material.Builder("barium_strontium_radium_solution")
                .fluid()
                .color(Barite.getMaterialRGB())
                .components(Barite, 1, Gypsum, 1, Celestite, 1, Radium, 1, Water, 4)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24256 Fluoroniobic Acid
        FluoroniobicAcid = new Material.Builder("fluoroniobic_acid")
                .fluid(FluidStorageKeys.LIQUID, new FluidBuilder().attribute(FluidAttributes.ACID))
                .color(Niobium.getMaterialRGB() + HydrofluoricAcid.getMaterialRGB())
                .components(Niobium, 1, Hydrogen, 1, Fluorine, 7)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24257 Oxypentafluoroniobate
        Oxypentafluoroniobate = new Material.Builder("oxypentafluoroniobate")
                .fluid()
                .color(0x17F742)
                .components(Hydrogen, 2, Niobium, 1, Oxygen, 1, Fluorine, 5)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24258 Heptafluorotantalate
        Heptafluorotantalate = new Material.Builder("heptafluorotantalate")
                .fluid()
                .color(0x16EB3F)
                .components(Hydrogen, 2, Tantalum, 1, Fluorine, 7)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24259 Potassium Fluoride
        PotassiumFluoride = new Material.Builder("potassium_fluoride")
                .dust()
                .color(Potassium.getMaterialRGB() + Fluorine.getMaterialRGB())
                .iconSet(ROUGH)
                .components(Potassium, 1, Fluorine, 1)
                .buildAndRegister();
        //  24260 Potassium Fluoniobate
        PotassiumFluoniobate = new Material.Builder("potassium_fluoniobate")
                .dust()
                .color(PotassiumFluoride.getMaterialRGB() + FluoroniobicAcid.getMaterialRGB())
                .iconSet(BRIGHT)
                .components(Potassium, 2, Niobium, 1, Fluorine, 7)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24261 Potassium Fluotantalate
        PotassiumFluotantalate = new Material.Builder("potassium_fluotantalate")
                .dust()
                .color(Tantalum.getMaterialRGB() + PotassiumFluoniobate.getMaterialRGB())
                .iconSet(BRIGHT)
                .components(Potassium, 2, Tantalum, 1, Fluorine, 7)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24262 Uranium Thorium Nitrate
        UraniumThoriumNitrate = new Material.Builder("uranium_thorium_nitrate")
                .dust()
                .color(Uranium238.getMaterialRGB() + Thorium.getMaterialRGB() + Nitrogen.getMaterialRGB())
                .iconSet(SHINY)
                .buildAndRegister()
                .setFormula("UO2(NO3)2Th(NO3)4", true);
        //  24263 Uranium Oxide Thorium Nitrate
        UraniumOxideThoriumNitrate = new Material.Builder("uranium_oxide_thorium_nitrate")
                .dust()
                .color(Uranium238.getMaterialRGB() + Oxygen.getMaterialRGB())
                .iconSet(SHINY)
                .buildAndRegister()
                .setFormula("UO2Th(NO3)4", true);
        //  24264 Thorium Nitrate Solution
        ThoriumNitrateSolution = new Material.Builder("thorium_nitrate_solution")
                .fluid()
                .color(Thorium.getMaterialRGB())
                .buildAndRegister()
                .setFormula("Th(NO3)4(H2O)", true);
        //  24265 Thorium Oxide
        ThoriumOxide = new Material.Builder("thorium_oxide")
                .dust()
                .color(Thorium.getMaterialRGB() + Oxygen.getMaterialRGB())
                .components(Thorium, 1, Oxygen, 1)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24266 Gold Copper Mixture
        GoldCopperMixture = new Material.Builder("gold_copper_mixture")
                .dust()
                .color(0xD2D242)
                .iconSet(SHINY)
                .components(Copper, 3, Gold, 1)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister()
                .setFormula("Cu3Au?", true);
        //  24267 Leaching Gold
        LeachingGold = new Material.Builder("leaching_gold")
                .dust()
                .color(0xA7650F)
                .iconSet(ROUGH)
                .components(Copper, 3, Gold, 1)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister()
                .setFormula("Cu3Au?", true);
        //  24268 Chloroauric Acid
        ChloroauricAcid = new Material.Builder("chloroauric_acid")
                .fluid()
                .color(LeachingGold.getMaterialRGB() + HydrochloricAcid.getMaterialRGB())
                .components(Hydrogen, 1, Gold, 1, Chlorine, 1)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister()
                .setFormula("HAuCl?", false);
        //  24269 Leaching Copper
        LeachingCopper = new Material.Builder("leaching_copper")
                .dust()
                .color(Copper.getMaterialRGB() + LeachingGold.getMaterialRGB())
                .iconSet(SHINY)
                .components(Copper, 3)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister()
                .setFormula("Cu3?", true);
        //  24270 Potassium Metabisulfite
        PotassiumMetabisulfite = new Material.Builder("potassium_metabisulfite")
                .dust()
                .color(Potassium.getMaterialRGB() + Sulfur.getMaterialRGB())
                .iconSet(SAND)
                .components(Potassium, 2, Sulfur, 2, Oxygen, 5)
                .buildAndRegister();
        //  24271 Platinum Metal
        PlatinumMetal = new Material.Builder("platinum_metal")
                .dust()
                .color(PlatinumRaw.getMaterialRGB())
                .iconSet(SAND)
                .components(Platinum, 1)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister()
                .setFormula("Pt?", false);
        //  24272 Platinum Slag
        PlatinumSlag = new Material.Builder("platinum_slag")
                .dust()
                .color(PlatinumRaw.getMaterialRGB())
                .iconSet(DULL)
                .components(Platinum, 1)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister()
                .setFormula("Pt?", false);
        //  24273 Palladium Metal
        PalladiumMetal = new Material.Builder("palladium_metal")
                .dust()
                .color(Palladium.getMaterialRGB())
                .iconSet(DULL)
                .components(Palladium, 1)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister()
                .setFormula("Pd?", false);
        //  24274 Concentrate Platinum
        ConcentratePlatinum = new Material.Builder("concentrate_platinum")
                .fluid()
                .color(Platinum.getMaterialRGB())
                .iconSet(DULL)
                .components(Platinum, 1)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister()
                .setFormula("Pt?", false);
        //  24275 Crude Platinum
        CrudePlatinum = new Material.Builder("crude_platinum")
                .dust()
                .color(PlatinumRaw.getMaterialRGB())
                .iconSet(SAND)
                .components(Platinum, 1, Chlorine, 2)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister()
                .setFormula("PtCl2?", true);
        //  24276 Palladium Rich Ammonia
        PalladiumRichAmmonia = new Material.Builder("palladium_rich_ammonia")
                .gas()
                .color(Palladium.getMaterialRGB() + Ammonia.getMaterialRGB())
                .components(Palladium, 1, Ammonia, 1)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister()
                .setFormula("Pd(NH3)?", true);
        //  24277 Iridium Dioxide
        IridiumDioxide = new Material.Builder("iridium_dioxide")
                .dust()
                .color(Iridium.getMaterialRGB() + Oxygen.getMaterialRGB())
                .iconSet(SAND)
                .components(Iridium, 1, Oxygen, 2)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24278 Acidic Iridium Solution
        AcidicIridiumSolution = new Material.Builder("acidic_iridium_solution")
                .fluid()
                .color(IridiumDioxide.getMaterialRGB() + HydrochloricAcid.getMaterialRGB())
                .components(IridiumDioxide, 2, HydrochloricAcid, 2)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24279 Osmium Tetrachloride
        OsmiumTetrachloride = new Material.Builder("osmium_tetrachloride")
                .dust()
                .color(0x29080A)
                .iconSet(METALLIC)
                .components(Osmium, 1, Chlorine, 4)
                .buildAndRegister();
        //  24280 Ruthenium Chloride
        RutheniumChloride = new Material.Builder("ruthenium_chloride")
                .dust()
                .color(0x605C6C)
                .iconSet(METALLIC)
                .flags(DISABLE_DECOMPOSITION)
                .components(Ruthenium, 1, Chlorine, 3)
                .buildAndRegister();
        //  24281 Sodium Peroxide
        SodiumPeroxide = new Material.Builder("sodium_peroxide")
                .dust()
                .color(0xECFF80)
                .iconSet(ROUGH)
                .components(Sodium, 2, Oxygen, 2)
                .buildAndRegister();
        //  24282 Rhodium Oxide
        RhodiumOxide = new Material.Builder("rhodium_oxide")
                .dust()
                .color(0xD93D16)
                .iconSet(METALLIC)
                .components(Rhodium, 2, Oxygen, 3)
                .buildAndRegister();
        //  24283 Platinum Group Sludge Solution
        PlatinumGroupSludgeSolution = new Material.Builder("platinum_group_sludge_solution")
                .fluid()
                .color(PlatinumGroupSludge.getMaterialRGB())
                .iconSet(DULL)
                .buildAndRegister();
        //  24284 Ammonium Hexachloro Platinum Group Sludge
        AmmoniumHexachloroPlatinumGroupSludge = new Material.Builder("ammonium_hexachloro_platinum_group_sludge")
                .fluid()
                .color(0xFEF0C2)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24285 Leaching Nickel
        LeachingNickel = new Material.Builder("leaching_nickel")
                .dust()
                .color(LeachingCopper.getMaterialRGB() + Nickel.getMaterialRGB())
                .iconSet(BRIGHT)
                .components(Nickel, 3)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister()
                .setFormula("Ni3?", true);
        //  24286 Gold Nickel Mixture
        GoldNickelMixture = new Material.Builder("gold_nickel_mixture")
                .dust()
                .color(GoldCopperMixture.getMaterialRGB() + Nickel.getMaterialRGB())
                .iconSet(SAND)
                .components(Nickel, 3, Gold, 1)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister()
                .setFormula("Ni3Au?", true);
        //  24287 Lanthanum Fullerene Mixture
        LanthanumFullereneMixture = new Material.Builder("lanthanum_fullerene_mixture")
                .dust()
                .color(0xD26D8E)
                .iconSet(BRIGHT)
                .components(Lanthanum, 2, GeodesicPolyarene, 2)
                .buildAndRegister();
        //  24288 Lanthanum Embedded Fullerene
        LanthanumEmbeddedFullerene = new Material.Builder("lanthanum_embedded_fullerene")
                .dust()
                .color(0x84FFAC)
                .iconSet(BRIGHT)
                .components(Lanthanum, 2, GeodesicPolyarene, 2)
                .buildAndRegister();
        //  24289 Lanthanum Fullerene Nanotube
        LanthanumFullereneNanotube = new Material.Builder("lanthanum_fullerene_nanotube")
                .ingot()
                .color(0xD24473)
                .iconSet(BRIGHT)
                .components(Lanthanum, 2, GeodesicPolyarene, 2, CarbonNanotube, 1)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24290 HRA Magnesium
        HRAMagnesium = new Material.Builder("hra_magnesium")
                .dust()
                .color(Magnesium.getMaterialRGB())
                .iconSet(SHINY)
                .components(Magnesium, 1)
                .buildAndRegister();
        //  24291 Cadium Bromide
        CadmiumBromide = new Material.Builder("cadmium_bromide")
                .dust()
                .color(0xFF1774)
                .iconSet(SHINY)
                .components(Cadmium, 1, Bromine, 2)
                .buildAndRegister();
        //  24292 Magnesium Bromide
        MagnesiumBromide = new Material.Builder("magnesium_bromide")
                .dust()
                .color(0x5F4C32)
                .iconSet(METALLIC)
                .components(Magnesium, 1, Bromine, 2)
                .buildAndRegister();
        //  24293 Oganesson Breeding Base
        OganessonBreedingBase = new Material.Builder("oganesson_breeding_base")
                .fluid()
                .color(0xA65A7F)
                .components(Oganesson, 1)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24294 Hot Oganesson
        HotOganesson = new Material.Builder("hot_oganesson")
                .fluid(FluidStorageKeys.LIQUID, new FluidBuilder().temperature(14118))
                .color(Oganesson.getMaterialRGB())
                .components(Oganesson, 1)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24295 Dragon Dust
        DragonDust = new Material.Builder("dragon_dust")
                .ore(1, 1, true)
                .addOreByproducts(Amethyst)
                .dust()
                .color(Draconium.getMaterialRGB())
                .iconSet(DULL)
                .buildAndRegister()
                .setFormula("Dc3Ac3Se4At4?", false);
        //  24296 Californium Nitrite
        CaliforniumNitrite = new Material.Builder("californium_nitrite")
                .dust()
                .color(0x914626)
                .iconSet(ROUGH)
                .components(Californium, 1, Nitrogen, 3, Oxygen, 6)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister()
                .setFormula("Cf(NO2)3", true);
        //  24297 Californium Dioxide
        CaliforniumDioxide = new Material.Builder("californium_dioxide")
                .dust()
                .color(0x912D01)
                .iconSet(DULL)
                .components(Californium, 1, Oxygen, 2)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24298 Californium Hexachloride
        CaliforniumHexachloride = new Material.Builder("californium_hexachloride")
                .fluid()
                .color(Californium.getMaterialRGB() + Chlorine.getMaterialRGB())
                .components(Californium, 2, Chlorine, 6)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24299 Californium Hexafluoride
        CaliforniumHexafluoride = new Material.Builder("californium_hexafluoride")
                .gas()
                .color(Californium.getMaterialRGB() + Fluorine.getMaterialRGB())
                .components(Californium, 2, Fluorine, 6)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24300 Californium-252 Hexafluoride
        Californium252Hexafluoride = new Material.Builder("californium_252_hexafluoride")
                .gas()
                .color(Californium252.getMaterialRGB() + Fluorine.getMaterialRGB())
                .components(Californium252, 2, Fluorine, 6)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24301 Steam Cracked Californium-252 Hexafluoride
        SteamCrackedCalifornium252Hexafluoride = new Material.Builder("steam_cracked_californium_252_hexafluoride")
                .gas()
                .color(Californium252Hexafluoride.getMaterialRGB() + Steam.getMaterialRGB())
                .components(Californium252, 2, Fluorine, 6)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24302 Californium-252 Dioxide
        Californium252Dioxide = new Material.Builder("californium_252_dioxide")
                .dust()
                .color(0x912D01)
                .iconSet(ROUGH)
                .components(Californium252, 1, Oxygen, 2)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24303 Actinium Draconium Hydroxides
        ActiniumDraconiumHydroxides = new Material.Builder("actinium_draconium_hydroxides")
                .dust()
                .color(0xB613BF)
                .iconSet(ROUGH)
                .components(Draconium, 3, Actinium, 2, Oxygen, 12, Hydrogen, 12)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister()
                .setFormula("Dc3Ac3(OH)12", true);
        //  24304 Actinium Nitrate
        ActiniumNitrate = new Material.Builder("actinium_nitrate")
                .dust()
                .color(Actinium.getMaterialRGB() + NitricAcid.getMaterialRGB())
                .iconSet(ROUGH)
                .components(Actinium, 1, Nitrogen, 3, Oxygen, 9)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister()
                .setFormula("Ac(NO3)3", true);
        //  24305 Radium Nitrate
        RadiumNitrate = new Material.Builder("radium_nitrate")
                .dust()
                .color(Radium.getMaterialRGB() + NitricAcid.getMaterialRGB())
                .iconSet(SHINY)
                .components(Radium, 1, Nitrogen, 2, Oxygen, 6)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister()
                .setFormula("Ra(NO3)2", true);
        //  24306 Caesium Carborane
        CaesiumCarborane = new Material.Builder("caesium_carborane")
                .dust()
                .color(Caesium.getMaterialRGB() + Carbon.getMaterialRGB())
                .iconSet(DULL)
                .components(Caesium, 1, Carbon, 1, Boron, 11, Hydrogen, 12)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24307 Silver Nitrate
        SilverNitrate = new Material.Builder("silver_nitrate")
                .dust()
                .color(Silver.getMaterialRGB() + NitricAcid.getMaterialRGB())
                .iconSet(SHINY)
                .components(Silver, 1, Nitrogen, 1, Oxygen, 3)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24308 Caesium Nitrate
        CaesiumNitrate = new Material.Builder("caesium_nitrate")
                .dust()
                .color(Caesium.getMaterialRGB() + NitricAcid.getMaterialRGB())
                .iconSet(ROUGH)
                .components(Caesium, 1, Nitrogen, 1, Oxygen, 3)
                .flags(DECOMPOSITION_BY_ELECTROLYZING)
                .buildAndRegister();
        //  24309 Silver Iodide
        SilverIodide = new Material.Builder("silver_iodide")
                .dust()
                .iconSet(SHINY)
                .color(Silver.getMaterialRGB() + Iodine.getMaterialRGB())
                .components(Silver, 1, Iodine, 1)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24310 Caesium Hydroxide
        CaesiumHydroxide = new Material.Builder("caesium_hydroxide")
                .dust()
                .color(Caesium.getMaterialRGB() + Hydrogen.getMaterialRGB() + Oxygen.getMaterialRGB())
                .components(Caesium, 1, Oxygen, 1, Hydrogen, 1)
                .flags(DECOMPOSITION_BY_ELECTROLYZING)
                .buildAndRegister();
        //  24311 Sodium Tetrafluoroborate
        SodiumTetrafluoroborate = new Material.Builder("sodium_tetrafluoroborate")
                .dust()
                .color(Sodium.getMaterialRGB() + BoronTrifluoride.getMaterialRGB())
                .iconSet(SAND)
                .components(Sodium, 1, Boron, 1, Fluorine, 4)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24312 Sodium Borohydride
        SodiumBorohydride = new Material.Builder("sodium_borohydride")
                .dust()
                .color(Sodium.getMaterialRGB() + Boron.getMaterialRGB())
                .iconSet(ROUGH)
                .components(Sodium, 1, Boron, 1, Hydrogen, 4)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24313 Sodium Ethoxide
        SodiumEthoxide = new Material.Builder("sodium_ethoxide")
                .dust()
                .color(Sodium.getMaterialRGB() + Ethanol.getMaterialRGB())
                .iconSet(DULL)
                .components(Carbon, 2, Hydrogen, 5, Oxygen, 1, Sodium, 1)
                .buildAndRegister();
        //  24314 Krypton Difluoride
        KryptonDifluoride = new Material.Builder("krypton_difluoride")
                .gas()
                .color(Krypton.getMaterialRGB() + Fluorine.getMaterialRGB())
                .components(Krypton, 1, Fluorine, 2)
                .buildAndRegister();
        //  24315 Draconium Tetrafluoride
        DraconiumTetrafluoride = new Material.Builder("draconium_tetrafluoride")
                .dust()
                .color(0xBA16A6)
                .iconSet(DULL)
                .components(Draconium, 1, Fluorine, 4)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24316 Actinium Oxalate
        ActiniumOxalate = new Material.Builder("actinium_oxalate")
                .dust()
                .color(0x7971BF)
                .iconSet(SHINY)
                .components(Actinium, 1, Carbon, 4, Oxygen, 8)
                .buildAndRegister()
                .setFormula("Ac(CO2)4", true);
        //  24317 Actinium Hydride
        ActiniumHydride = new Material.Builder("actinium_hydride")
                .dust()
                .color(0x86DAF0)
                .iconSet(BRIGHT)
                .components(Actinium, 1, Hydrogen, 3)
                .buildAndRegister();
        //  24318 Actinium Superhydride
        ActiniumSuperhydride = new Material.Builder("actinium_superhydride")
                .dust()
                .plasma()
                .color(0xCC3300)
                .iconSet(BRIGHT)
                .components(Actinium, 1, Hydrogen, 12)
                .buildAndRegister();
        //  24319 Francium Carbide
        FranciumCarbide = new Material.Builder("francium_carbide")
                .dust()
                .color(Francium.getMaterialRGB() + Carbon.getMaterialRGB())
                .iconSet(SHINY)
                .components(Francium, 2, Carbon, 2)
                .buildAndRegister();
        //  24320 Boron Francium Mixture
        BoronFranciumMixture = new Material.Builder("boron_francium_mixture")
                .dust()
                .color(Boron.getMaterialRGB() + FranciumCarbide.getMaterialRGB())
                .iconSet(BRIGHT)
                .components(FranciumCarbide, 2, CubicBoronNitride, 1, AmorphousBoronNitride, 1)
                .buildAndRegister();
        //  24321 Flerovium-Ytterbium Plasma
        FleroviumYtterbiumPlasma = new Material.Builder("flerovium_ytterbium_plasma")
                .fluid(FluidStorageKeys.PLASMA, new FluidBuilder().temperature(300))
                .components(MetastableFlerovium, 1, Ytterbium178, 1)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24322 Solar-Grade Silicon
        SolarGradeSilicon = new Material.Builder("solar_grade_silicon")
                .ingot()
                .color(Silicon.getMaterialRGB())
                .iconSet(BRIGHT)
                .components(Silicon, 1)
                .buildAndRegister();
        //  24323 Dense Hydrazine Mixture Fuel
        DenseHydrazineMixtureFuel = new Material.Builder("dense_hydrazine_mixture_fuel")
                .fluid()
                .color(0x912565)
                .components(Dimethylhydrazine, 1, Methanol, 1)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24324 Highly Purified Coal Tar
        HighlyPurifiedCoalTar = new Material.Builder("highly_purified_coal_tar")
                .fluid()
                .color(0x7F811D)
                .components(CoalTar, 1)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24325 RP-1 Rocket Fuel
        RP1RocketFuel = new Material.Builder("rp_1_rocket_fuel")
                .fluid()
                .color(0xFB2A08)
                .components(HighlyPurifiedCoalTar, 1, Oxygen/*LiquidOxygen*/, 1)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24326 Methylhydrazine
        Methylhydrazine = new Material.Builder("methylhydrazine")
                .fluid()
                .color(0x321452)
                .components(Carbon, 1, Hydrogen, 6, Nitrogen, 2)
                .buildAndRegister();
        //  24327 Methylhydrazine Nitrate Rocket Fuel
        MethylhydrazineNitrateRocketFuel = new Material.Builder("methylhydrazine_nitrate_rocket_fuel")
                .fluid()
                .color(0x607186)
                .components(Methylhydrazine, 1, Tetranitromethane, 1)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24328 Lithium Niobate
        LithiumNiobate = new Material.Builder("lithium_niobate")
                .ingot()
                .color(0xD27700)
                .iconSet(SHINY)
                .components(Lithium, 1, Niobium, 1, Oxygen, 4)
                .blastTemp(6700)
                .flags(DISABLE_DECOMPOSITION)
                .flags(GENERATE_PLATE, GENERATE_LENS)
                .buildAndRegister();
        //  24329 Niobium Pentachloride
        NiobiumPentachloride = new Material.Builder("niobium_pentachloride")
                .dust()
                .color(Niobium.getMaterialRGB() + Chlorine.getMaterialRGB())
                .iconSet(SHINY)
                .components(Niobium, 1, Chlorine, 5)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24330 High Purity Sodium Vanadate
        HighPuritySodiumVanadate = new Material.Builder("high_purity_sodium_vanadate")
                .dust()
                .color(0xE3E147)
                .iconSet(BRIGHT)
                .components(Sodium, 3, Vanadium, 1, Oxygen, 4)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24331 Lutetium Thulium Yttrium Chlorides Solution
        LutetiumThuliumYttriumChloridesSolution = new Material.Builder("lutetium_thulium_yttrium_chlorides_solution")
                .fluid()
                .color(Lutetium.getMaterialRGB() + Thulium.getMaterialRGB() + Yttrium.getMaterialRGB())
                .components(Lutetium, 2, Thulium, 2, Yttrium, 6, Chlorine, 30, Hydrogen, 30, Oxygen, 15)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister()
                .setFormula("(LuCl3)2(TmCl3)2(YCl3)6(H2O)15", true);
        //  24332 Lu-Tm-droped Yttrium Vanadate Deposition
        YttriumVanadateLuTmDeposition = new Material.Builder("yttrium_vanadate_lu_tm_deposition")
                .dust()
                .color(Yttrium.getMaterialRGB() + Vanadium.getMaterialRGB() + Lutetium.getMaterialRGB() + Thulium.getMaterialRGB())
                .iconSet(DULL)
                .buildAndRegister()
                .setFormula("Lu/TM:YVO?", false);
        //  24333 Lu-Tm-droped Yttrium Vanadate
        YttriumVanadateLuTm = new Material.Builder("yttrium_vanadate_lu_tm")
                .gem()
                .color(0x8C1B23)
                .iconSet(GEM_HORIZONTAL)
                .flags(DISABLE_DECOMPOSITION, GENERATE_LENS, CRYSTALLIZABLE)
                .components(Yttrium, 1, Vanadium, 1, Oxygen, 1, Lutetium, 1, Thulium, 1)
                .buildAndRegister()
                .setFormula("Lu/Tm:YVO", false);
        //  24334 Heavy Quark Enriched Mixture
        HeavyQuarkEnrichedMixture = new Material.Builder("heavy_quark_enriched_mixture")
                .fluid()
                .color(HeavyQuarks.getMaterialRGB() + LightQuarks.getMaterialRGB())
                .components(LightQuarks, 1, HeavyQuarks, 3)
                .flags(DECOMPOSITION_BY_CENTRIFUGING)
                .buildAndRegister()
                .setFormula(OBFUSCATED  + "a"  + RESET + "§e(u2)d(c2)s(t2)b" + OBFUSCATED  + "a" , true);
        //  24335 Deuterium-Superheavy Mixture
        DeuteriumSuperHeavyMixture = new Material.Builder("deuterium_superheavy_mixture")
                .fluid()
                .color(0x7B9F8E)
                .components(Deuterium, 2, MetastableHassium, 1, MetastableFlerovium, 1, MetastableOganesson, 1)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24336 Heavy Quark Degenerate Matter
        HeavyQuarkDegenerateMatter = new Material.Builder("heavy_quark_degenerate_matter")
                .ingot()
                .fluid()
                .plasma()
                .color(0x5DBD3A)
                .iconSet(BRIGHT)
                .blastTemp(12960, BlastProperty.GasTier.HIGHEST, VA[UEV])
                .flags(DISABLE_DECOMPOSITION, GENERATE_PLATE)
                .buildAndRegister();
        //  24337 Fullerene Polymer Matrix
        FullerenePolymerMatrix = new Material.Builder("fullerene_polymer_matrix")
                .fluid(FluidStorageKeys.LIQUID, new FluidBuilder().temperature(500))
                .polymer()
                .color(0x2F0B01)
                .iconSet(SHINY)
                .components(Lead, 1, Iron, 1, Carbon, 153, Hydrogen, 36, Nitrogen, 1, Oxygen, 2)
                .flags(DISABLE_DECOMPOSITION, NO_SMASHING, NO_SMELTING, GENERATE_PLATE, GENERATE_FOIL)
                .buildAndRegister();
        //  24338 Radium-Radon Mixture
        RadiumRadonMixture = new Material.Builder("radium_radon_mixture")
                .fluid()
                .color(Radium.getMaterialRGB() + Radon.getMaterialRGB())
                .components(Radium, 1, Radon, 1)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24339 Scandium-Titanium Mixture
        ScandiumTitaniumMixture = new Material.Builder("scandium_titanium_mixture")
                .fluid()
                .color(Scandium.getMaterialRGB() + Titanium.getMaterialRGB())
                .components(Scandium, 1, Titanium, 1)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24340 Caesium Iodide
        CaesiumIodide = new Material.Builder("caesium_iodide")
                .dust()
                .color(Caesium.getMaterialRGB() + Iodine.getMaterialRGB())
                .iconSet(SHINY)
                .components(Caesium, 1, Iodine, 1)
                .buildAndRegister();
        //  24341 Tl-Tm-Droped Caesium Iodide
        TlTmDropedCaesiumIodide = new Material.Builder("tl_tm_droped_caesium_iodide")
                .dust()
                .color(Thallium.getMaterialRGB() + Thulium.getMaterialRGB() + CaesiumIodide.getMaterialRGB())
                .iconSet(BRIGHT)
                .components(Thallium, 1, Thulium, 1, CaesiumIodide, 1)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister()
                .setFormula("Tl/Tm:CsI");
        //  24342 Cadmium Tungstate
        CadmiumTungstate = new Material.Builder("cadmium_tungstate")
                .dust()
                .color(Cadmium.getMaterialRGB() + Tungsten.getMaterialRGB())
                .iconSet(BRIGHT)
                .components(Cadmium, 1, Tungsten, 1, Oxygen, 4)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24343 Bismuth Germanate
        BismuthGermanate = new Material.Builder("bismuth_germanate")
                .dust()
                .color(Bismuth.getMaterialRGB() + Germanium.getMaterialRGB())
                .iconSet(ROUGH)
                .components(Bismuth, 12, Germanium, 1, Oxygen, 20)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24344 Iodine Monochloride
        IodineMonochloride = new Material.Builder("iodine_monochloride")
                .fluid()
                .color(Iodine.getMaterialRGB() + Chlorine.getMaterialRGB())
                .components(Iodine, 1, Chlorine, 1)
                .buildAndRegister();
        //  24345 Magnesium Chloride Bromide
        MagnesiumChlorideBromide = new Material.Builder("magnesium_chloride_bromide")
                .dust()
                .color(Magnesium.getMaterialRGB() + Chlorine.getMaterialRGB() + Bromine.getMaterialRGB())
                .components(Magnesium, 1, Chlorine, 1, Bromine, 1)
                .buildAndRegister();
        //  24346 Rh-Re-Nq Catalyst
        RhReNqCatalyst = new Material.Builder("rh_re_nq_catalyst")
                .dust()
                .color(Rhodium.getMaterialRGB() + Rhenium.getMaterialRGB() + Naquadah.getMaterialRGB())
                .iconSet(SHINY)
                .components(Rhodium, 1, Rhenium, 1, Naquadah, 1)
                .buildAndRegister();
        //  24347 Lithium Titanate
        LithiumTitanate = new Material.Builder("lithium_titanate")
                .ingot()
                .fluid()
                .color(0xFE71A9)
                .iconSet(SHINY)
                .blastTemp(3100)
                .components(Lithium, 2, Titanium, 1, Oxygen, 3)
                .flags(DISABLE_DECOMPOSITION, GENERATE_FINE_WIRE)
                .buildAndRegister();
        //  24348 Titanium Nitrate
        TitaniumNitrate = new Material.Builder("titanium_nitrate")
                .dust()
                .color(Titanium.getMaterialRGB() + NitricAcid.getMaterialRGB())
                .iconSet(DULL)
                .components(Titanium, 1, Nitrogen, 4, Oxygen, 12)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister()
                .setFormula("Ti(NO3)4", true);

        //  24349 PalladiumLoadedRutileNanoparticles

    }
}
