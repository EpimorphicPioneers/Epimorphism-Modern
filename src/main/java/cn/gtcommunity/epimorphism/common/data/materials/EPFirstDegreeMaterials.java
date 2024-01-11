package cn.gtcommunity.epimorphism.common.data.materials;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconSet;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.BlastProperty;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.PropertyKey;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.ToolProperty;
import com.gregtechceu.gtceu.api.fluids.FluidBuilder;
import com.gregtechceu.gtceu.api.fluids.attribute.FluidAttributes;
import com.gregtechceu.gtceu.api.fluids.store.FluidStorageKeys;
import com.gregtechceu.gtceu.api.item.tool.GTToolType;
import cn.gtcommunity.epimorphism.common.data.EPMaterials;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import net.minecraft.ChatFormatting;

import static cn.gtcommunity.epimorphism.api.chemical.material.info.EPMaterialFlags.*;

public class EPFirstDegreeMaterials {
    public static void register() {
        //  24001 GrapheneOxide
        EPMaterials.GrapheneOxide = new Material.Builder("graphene_oxide")
                .dust()
                .color(0x777777)
                .iconSet(MaterialIconSet.ROUGH)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .components(GTMaterials.Graphene, 1, GTMaterials.Oxygen, 1)
                .buildAndRegister();
        //  24002 Hydrazine
        EPMaterials.Hydrazine = new Material.Builder("hydrazine")
                .fluid()
                .color(0xB50707)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .components(GTMaterials.Nitrogen, 2, GTMaterials.Hydrogen, 4)
                .buildAndRegister();

        //  24003 BerylliumOxide
        EPMaterials.BerylliumOxide = new Material.Builder("beryllium_oxide")
                .ingot()
                .color(0x54C757)
                .flags(MaterialFlags.GENERATE_ROD, MaterialFlags.GENERATE_RING)
                .components(GTMaterials.Beryllium, 1, GTMaterials.Oxygen, 1)
                .buildAndRegister();

        //  24004 Hydrogen Peroxide
        EPMaterials.HydrogenPeroxide = new Material.Builder("hydrogen_peroxide")
                .fluid()
                .color(0xD2FFFF)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .components(GTMaterials.Hydrogen, 2, GTMaterials.Oxygen, 2)
                .buildAndRegister();

        //  24005 Tungsten Trioxide
        EPMaterials.TungstenTrioxide = new Material.Builder("tungsten_trioxide")
                .dust()
                .color(0xC7D300)
                .iconSet(MaterialIconSet.DULL)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .components(GTMaterials.Tungsten, 1, GTMaterials.Oxygen, 3)
                .buildAndRegister();
        //  24006 Hexagonal Boron Nitride
        EPMaterials.HexagonalBoronNitride = new Material.Builder("hexagonal_boron_nitride")
                .gem()
                .color(0x6A6A72)
                .iconSet(MaterialIconSet.GEM_VERTICAL)
                .flags(MaterialFlags.GENERATE_PLATE, MaterialFlags.DISABLE_DECOMPOSITION)
                .components(GTMaterials.Boron, 1, GTMaterials.Nitrogen, 1)
                .buildAndRegister()
                .setFormula("h-BN", true);

        //  24007  Cubic Boron Nitride
        EPMaterials.CubicBoronNitride = new Material.Builder("cubic_boron_nitride")
                .gem()
                .color(0x545572)
                .iconSet(MaterialIconSet.DIAMOND)
                .flags(MaterialFlags.GENERATE_PLATE, MaterialFlags.DISABLE_DECOMPOSITION, DISABLE_CRYSTALLIZATION, MaterialFlags.FLAMMABLE, MaterialFlags.EXPLOSIVE)
                .components(GTMaterials.Boron, 1, GTMaterials.Nitrogen, 1)
                .toolStats(new ToolProperty(14.0F, 9.0F, 12400, 15, GTToolType.getTypes().values().toArray(GTToolType[]::new)))
                .buildAndRegister()
                .setFormula("c-BN", true);
        //  24008 Boric Acid
        EPMaterials.BoricAcid = new Material.Builder("boric_acid")
                .dust()
                .fluid()
                .color(0xFAFAFA)
                .iconSet(MaterialIconSet.SHINY)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .components(GTMaterials.Hydrogen, 3, GTMaterials.Boron, 1, GTMaterials.Oxygen, 3)
                .buildAndRegister();
        //  24009 Boron Trioxide
        EPMaterials.BoronTrioxide = new Material.Builder("boron_trioxide")
                .dust()
                .color(0xE9FAC0)
                .iconSet(MaterialIconSet.METALLIC)
                .components(GTMaterials.Boron, 2, GTMaterials.Oxygen, 3)
                .buildAndRegister();
        //  24010 Boron Trifluoride
        EPMaterials.BoronTrifluoride = new Material.Builder("boron_trifluoride")
                .gas()
                .color(0xFAF191)
                .components(GTMaterials.Boron, 1, GTMaterials.Fluorine, 3)
                .buildAndRegister();
        //  24011 Lithium Hydride
        EPMaterials.LithiumHydride = new Material.Builder("lithium_hydride")
                .ingot()
                .color(0x9BAFDB)
                .iconSet(MaterialIconSet.METALLIC)
                .components(GTMaterials.Lithium, 1, GTMaterials.Hydrogen, 1)
                .buildAndRegister();
        //  24012 Lithium Tetrafluoroborate
        EPMaterials.LithiumTetrafluoroborate = new Material.Builder("lithium_tetrafluoroborate")
                .dust()
                .color(0x90FAF6)
                .iconSet(MaterialIconSet.SHINY)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .components(GTMaterials.Lithium, 1, GTMaterials.Boron, 1, GTMaterials.Fluorine, 4)
                .buildAndRegister();
        //  24013 Diborane
        EPMaterials.Diborane = new Material.Builder("diborane")
                .gas()
                .color(0x3F3131)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .components(GTMaterials.Boron, 2, GTMaterials.Hydrogen, 6)
                .buildAndRegister();
        //  24014 Borazine
        EPMaterials.Borazine = new Material.Builder("borazine")
                .fluid()
                .color(0x542828)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .components(GTMaterials.Boron, 3, GTMaterials.Hydrogen, 6, GTMaterials.Nitrogen, 3)
                .buildAndRegister();
        //  24015 Boron Trichloride
        EPMaterials.BoronTrichloride = new Material.Builder("boron_trichloride")
                .gas()
                .color(0x033F1B)
                .components(GTMaterials.Boron, 1, GTMaterials.Chlorine, 3)
                .buildAndRegister();
        //  24016 Trichloroborazine
        EPMaterials.Trichloroborazine = new Material.Builder("trichloroborazine")
                .fluid()
                .color(0xD62929)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .components(GTMaterials.Boron, 3, GTMaterials.Chlorine, 3, GTMaterials.Hydrogen, 3, GTMaterials.Nitrogen, 3)
                .buildAndRegister();
        //  24017 Amorphous Boron Nitride
        EPMaterials.AmorphousBoronNitride = new Material.Builder("amorphous_boron_nitride")
                .ingot()
                .color(0x9193C5)
                .iconSet(MaterialIconSet.SHINY)
                .flags(MaterialFlags.GENERATE_PLATE, MaterialFlags.DISABLE_DECOMPOSITION, MaterialFlags.NO_SMASHING, MaterialFlags.NO_SMELTING)
                .components(GTMaterials.Boron, 1, GTMaterials.Nitrogen, 1)
                .buildAndRegister()
                .setFormula("a-BN", true);
        //  24018 Heterodiamond
        EPMaterials.Heterodiamond = new Material.Builder("heterodiamond")
                .gem()
                .color(0x512A72)
                .iconSet(MaterialIconSet.GEM_HORIZONTAL)
                .flags(MaterialFlags.GENERATE_PLATE, MaterialFlags.DISABLE_DECOMPOSITION)
                .components(GTMaterials.Boron, 1, GTMaterials.Carbon, 1, GTMaterials.Nitrogen, 1)
                .buildAndRegister();
        //  24019 Cubic Heterodiamond
        EPMaterials.CubicHeterodiamond = new Material.Builder("cubic_heterodiamond")
                .gem()
                .color(0x753DA6)
                .iconSet(MaterialIconSet.DIAMOND)
                .flags(MaterialFlags.GENERATE_PLATE, MaterialFlags.DISABLE_DECOMPOSITION)
                .components(GTMaterials.Boron, 1, GTMaterials.Carbon, 2, GTMaterials.Nitrogen, 1)
                .buildAndRegister()
                .setFormula("c-BC2N", true);
        //  24020 Carbon Nanotube
        EPMaterials.CarbonNanotube = new Material.Builder("carbon_nanotube")
                .ingot()
                .fluid()
                .color(0x05090C)
                .iconSet(MaterialIconSet.BRIGHT)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION, MaterialFlags.NO_SMELTING, MaterialFlags.GENERATE_PLATE, MaterialFlags.GENERATE_ROD, MaterialFlags.GENERATE_LONG_ROD, MaterialFlags.GENERATE_FINE_WIRE, MaterialFlags.GENERATE_SPRING, GENERATE_COIL)
                .cableProperties(GTValues.V[GTValues.UEV], 8, 6)
                .components(GTMaterials.Carbon, 48)
                .buildAndRegister()
                .setFormula("CNT", false);
        //  24021 Silver Tetrafluoroborate
        EPMaterials.SilverTetrafluoroborate = new Material.Builder("silver_tetrafluoroborate")
                .fluid()
                .color(0x818024)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .components(GTMaterials.Silver, 1, GTMaterials.Boron, 1, GTMaterials.Fluorine, 4)
                .buildAndRegister()
                .setFormula("AgBF4", true);
        //  24022 Trimethyltin Chloride
        EPMaterials.TrimethyltinChloride = new Material.Builder("trimethyltin_chloride")
                .fluid()
                .color(0x7F776F)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .components(GTMaterials.Carbon, 3, GTMaterials.Hydrogen, 6, GTMaterials.Tin, 1, GTMaterials.Chlorine, 1)
                .buildAndRegister()
                .setFormula("(CH3)3SnCl", true);
        //  24023 Silver Chloride
        EPMaterials.SilverChloride = new Material.Builder("silver_chloride")
                .dust()
                .color(0x8D8D8D)
                .iconSet(MaterialIconSet.METALLIC)
                .components(GTMaterials.Silver, 1, GTMaterials.Chlorine, 1)
                .buildAndRegister();
        //  24024 Chloroplatinic Acid
        EPMaterials.ChloroplatinicAcid = new Material.Builder("chloroplatinic_acid")
                .fluid(FluidStorageKeys.LIQUID, new FluidBuilder().attribute(FluidAttributes.ACID))
                .color(0xFFB546)
                .components(GTMaterials.Hydrogen, 2, GTMaterials.Platinum, 1, GTMaterials.Chlorine, 6)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24025 Potassium Tetrachloroplatinate
        EPMaterials.PotassiumTetrachloroplatinate = new Material.Builder("potassium_tetrachloroplatinate")
                .dust()
                .color(0xF1B04F)
                .iconSet(MaterialIconSet.SHINY)
                .components(GTMaterials.Potassium, 2, GTMaterials.Platinum, 1, GTMaterials.Chlorine, 4)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .buildAndRegister()
                .setFormula("K2PtCl4", true);
        //  24026 Nickel Triphenylphosphite
        EPMaterials.NickelTriphenylphosphite = new Material.Builder("nickel_triphenylphosphite")
                .dust()
                .color(0xCCCC66)
                .iconSet(MaterialIconSet.SHINY)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .components(GTMaterials.Carbon, 36, GTMaterials.Hydrogen, 30, GTMaterials.Chlorine, 2, GTMaterials.Nickel, 1, GTMaterials.Phosphorus, 2)
                .buildAndRegister()
                .setFormula("C36H30Cl2NiP2", true);
        //  24027 Nickel Chloride
        EPMaterials.NickelChloride = new Material.Builder("nickel_chloride")
                .dust()
                .color(0x898A07)
                .iconSet(MaterialIconSet.DULL)
                .components(GTMaterials.Nickel, 1, GTMaterials.Chlorine, 2)
                .buildAndRegister();
        //  24028 Phosphorus Trichloride
        EPMaterials.PhosphorusTrichloride = new Material.Builder("phosphorus_trichloride")
                .fluid()
                .color(0xD8D85B)
                .components(GTMaterials.Phosphorus, 1, GTMaterials.Chlorine, 3)
                .buildAndRegister();
        //  24029 Ammonium Sulfate
        EPMaterials.AmmoniumSulfate = new Material.Builder("ammonium_sulfate")
                .fluid()
                .color(0x5858F4)
                .buildAndRegister()
                .setFormula("(NH2)4SO4", true);
        //  24030 Ammonium Persulfate
        EPMaterials.AmmoniumPersulfate = new Material.Builder("ammonium_persulfate")
                .fluid()
                .color(0x4242B7)
                .buildAndRegister()
                .setFormula("(NH4)2S2O8", true);
        //  24031 Hydroxylamine Disulfate
        EPMaterials.HydroxylamineDisulfate = new Material.Builder("hydroxylamine_disulfate")
                .fluid()
                .color(0x91A6D2)
                .buildAndRegister()
                .setFormula("(NH3OH)2(NH4)2(SO4)2", true);
        //  24032 Hydroxylamine
        EPMaterials.Hydroxylamine = new Material.Builder("hydroxylamine")
                .fluid()
                .color(0x91C791)
                .components(GTMaterials.Hydrogen, 3, GTMaterials.Nitrogen, 1, GTMaterials.Oxygen, 1)
                .buildAndRegister()
                .setFormula("H3NO", true);
        //  24033 Ammonium Nitrate
        EPMaterials.AmmoniumNitrate = new Material.Builder("ammonium_nitrate")
                .fluid()
                .color(0x454066)
                .components(GTMaterials.Nitrogen, 2, GTMaterials.Hydrogen, 4, GTMaterials.Oxygen, 3)
                .buildAndRegister()
                .setFormula("NH4NO3", true);
        //  24034 Thallium Sulfate
        EPMaterials.ThalliumSulfate = new Material.Builder("thallium_sulfate")
                .dust()
                .color(0x9C222C)
                .iconSet(MaterialIconSet.METALLIC)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .components(GTMaterials.Thallium, 2, GTMaterials.Sulfur, 1, GTMaterials.Oxygen, 4)
                .buildAndRegister();
        //  24035 Thallium Chloride
        EPMaterials.ThalliumChloride = new Material.Builder("thallium_chloride")
                .dust()
                .color(0xCC5350)
                .iconSet(MaterialIconSet.SHINY)
                .components(GTMaterials.Thallium, 1, GTMaterials.Chlorine, 1)
                .buildAndRegister();
        //  24036 Iodized Brine
        EPMaterials.IodizedBrine = new Material.Builder("iodized_brine")
                .fluid()
                .color(0x525246)
                .buildAndRegister()
                .setFormula("I?", false);
        //  24037 Iodine Brine Mixture
        EPMaterials.IodineBrineMixture = new Material.Builder("iodine_brine_mixture")
                .fluid()
                .color(0x525234)
                .buildAndRegister()
                .setFormula("I?Cl", false);
        //  24038 Brominated Brine
        EPMaterials.BrominatedBrine = new Material.Builder("brominated_brine")
                .fluid()
                .color(0xA9A990)
                .buildAndRegister()
                .setFormula("Br?", false);
        //  24039 Iodine Slurry
        EPMaterials.IodineSlurry = new Material.Builder("iodine_slurry")
                .fluid()
                .color(0x292923)
                .buildAndRegister()
                .setFormula("I?", false);
        //  24040 Sodium Iodate
        EPMaterials.SodiumIodate = new Material.Builder("sodium_iodate")
                .dust()
                .color(0x0B0B47)
                .iconSet(MaterialIconSet.DULL)
                .components(GTMaterials.Sodium, 1, GTMaterials.Iodine, 1, GTMaterials.Oxygen, 3)
                .buildAndRegister();
        //  24041 Sodium Iodide
        EPMaterials.SodiumIodide = new Material.Builder("sodium_iodide")
                .dust()
                .color(0x1919A3)
                .iconSet(MaterialIconSet.METALLIC)
                .components(GTMaterials.Sodium, 1, GTMaterials.Iodine, 1)
                .buildAndRegister();
        //  24042 Sodium Hypochlorite
        EPMaterials.SodiumHypochlorite = new Material.Builder("sodium_hypochlorite")
                .dust()
                .color(0x2828FF)
                .components(GTMaterials.Sodium, 1, GTMaterials.Chlorine, 1, GTMaterials.Oxygen, 1)
                .buildAndRegister();
        //  24043 Sodium Periodate
        EPMaterials.SodiumPeriodate = new Material.Builder("sodium_periodate")
                .dust()
                .color(0x050547)
                .iconSet(MaterialIconSet.BRIGHT)
                .components(GTMaterials.Sodium, 1, GTMaterials.Iodine, 1, GTMaterials.Oxygen, 4)
                .buildAndRegister();
        //  24044 Acidic Brominated Brine
        EPMaterials.AcidicBrominatedBrine = new Material.Builder("acidic_brominated_brine")
                .fluid(FluidStorageKeys.LIQUID, new FluidBuilder().attribute(FluidAttributes.ACID))
                .color(0xC6A76F)
                .buildAndRegister()
                .setFormula("Br?(H2SO4)Cl", true);
        //  24045 Bromine Sulfate Solution
        EPMaterials.BromineSulfateSolution = new Material.Builder("bromine_sulfate_solution")
                .fluid()
                .color(0xCC9966)
                .buildAndRegister()
                .setFormula("H2SO4Br(H2O)Cl2", true);
        //  24046 Overheated Bromine Sulfate Solution
        EPMaterials.OverheatedBromineSulfateSolution = new Material.Builder("overheated_bromine_sulfate_solution")
                .fluid()
                .color(0xC69337)
                .iconSet(MaterialIconSet.DULL)
                .buildAndRegister()
                .setFormula("H2SO4Br(H2O)2Cl2", true);
        //  24047 Wet Bromine
        EPMaterials.WetBromine = new Material.Builder("wet_bromine")
                .fluid()
                .color(0xDB5C5C)
                .iconSet(MaterialIconSet.DULL)
                .buildAndRegister()
                .setFormula("Br(H2O)", true);
        //  24048 Debrominated Water
        EPMaterials.DebrominatedWater = new Material.Builder("debrominated_water")
                .fluid()
                .color(0x24A3A3)
                .components(GTMaterials.Hydrogen, 2, GTMaterials.Oxygen, 1)
                .buildAndRegister();
        //  24049 Palladium Chloride
        EPMaterials.PalladiumChloride = new Material.Builder("palladium_chloride")
                .dust()
                .color(0xAFB5BC)
                .iconSet(MaterialIconSet.SHINY)
                .components(GTMaterials.Palladium, 1, GTMaterials.Chlorine, 2)
                .buildAndRegister();
        //  24050 Palladium on Carbon
        EPMaterials.PalladiumOnCarbon = new Material.Builder("palladium_on_carbon")
                .dust()
                .color(0x480104)
                .iconSet(MaterialIconSet.DULL)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .components(GTMaterials.Palladium, 1, GTMaterials.Carbon, 1)
                .buildAndRegister();
        //  24051 Potassium Permanganate
        EPMaterials.PotassiumPermanganate = new Material.Builder("potassium_permanganate")
                .dust()
                .color(0x871D82)
                .iconSet(MaterialIconSet.DULL)
                .components(GTMaterials.Potassium, 1, GTMaterials.Manganese, 1, GTMaterials.Oxygen, 4)
                .buildAndRegister();
        //  24052 Potassium Manganate
        EPMaterials.PotassiumManganate = new Material.Builder("potassium_manganate")
                .dust()
                .color(0x873883)
                .iconSet(MaterialIconSet.METALLIC)
                .components(GTMaterials.Potassium, 2, GTMaterials.Manganese, 1, GTMaterials.Oxygen, 4)
                .buildAndRegister();
        //  24053 Tin Chloride
        EPMaterials.TinChloride = new Material.Builder("tin_chloride")
                .dust()
                .fluid()
                .color(0xDBDBDB)
                .iconSet(MaterialIconSet.METALLIC)
                .components(GTMaterials.Tin, 1, GTMaterials.Chlorine, 2)
                .buildAndRegister();
        //  24054 Silver Oxide
        EPMaterials.SilverOxide = new Material.Builder("silver_oxide")
                .dust()
                .color(0xA4A4A4)
                .components(GTMaterials.Silver, 2, GTMaterials.Oxygen, 1)
                .buildAndRegister();
        //  24055 Sodium Fluoride
        EPMaterials.SodiumFluoride = new Material.Builder("sodium_fluoride")
                .dust()
                .color(0x460012)
                .iconSet(MaterialIconSet.DULL)
                .components(GTMaterials.Sodium, 1, GTMaterials.Fluorine, 1)
                .buildAndRegister();
        //  24056 Zn-Fe-Al-Cl Catalyst
        EPMaterials.ZnFeAlClCatalyst = new Material.Builder("zn_fe_al_cl_catalyst")
                .dust()
                .color(0xC522A9)
                .iconSet(MaterialIconSet.DULL)
                .components(GTMaterials.Zinc, 1, GTMaterials.Iron, 1, GTMaterials.Aluminium, 1, GTMaterials.Chlorine, 1)
                .buildAndRegister();
        //  24057 Sodium Nitrite
        EPMaterials.SodiumNitrite = new Material.Builder("sodium_nitrite")
                .dust()
                .color(0x205CA4)
                .iconSet(MaterialIconSet.DULL)
                .components(GTMaterials.Sodium, 1, GTMaterials.Nitrogen, 1, GTMaterials.Oxygen, 2)
                .buildAndRegister();
        //  24058 Sodium Nitrate
        EPMaterials.SodiumNitrate = new Material.Builder("sodium_nitrate")
                .dust()
                .fluid()
                .color(0xEB9E3F)
                .iconSet(MaterialIconSet.METALLIC)
                .components(GTMaterials.Sodium, 1, GTMaterials.Nitrogen, 1, GTMaterials.Oxygen, 3)
                .buildAndRegister();
        //  24059 Fluoroboric Acid
        EPMaterials.FluoroboricAcid = new Material.Builder("fluoroboric_acid")
                .fluid(FluidStorageKeys.LIQUID, new FluidBuilder().attribute(FluidAttributes.ACID))
                .color(0xD5811B)
                .components(GTMaterials.Hydrogen, 1, GTMaterials.Boron, 1, GTMaterials.Fluorine, 4)
                .buildAndRegister();
        //  24060 Benzenediazonium Tetrafluoroborate
        EPMaterials.BenzenediazoniumTetrafluoroborate = new Material.Builder("benzenediazonium_tetrafluoroborate")
                .fluid()
                .color(0xD5C5B2)
                .components(GTMaterials.Carbon, 6, GTMaterials.Hydrogen, 5, GTMaterials.Boron, 1, GTMaterials.Fluorine, 4, GTMaterials.Nitrogen, 2)
                .buildAndRegister();
        //  24061 Gallium Trichloride
        EPMaterials.GalliumTrichloride = new Material.Builder("gallium_trichloride")
                .dust()
                .color(0x6EB4FF)
                .iconSet(MaterialIconSet.ROUGH)
                .components(GTMaterials.Gallium, 1, GTMaterials.Chlorine, 3)
                .buildAndRegister();
        //  24062 Aluminium Trichloride
        EPMaterials.AluminiumTrichloride = new Material.Builder("aluminium_trichloride")
                .dust()
                .color(0x78C3EB)
                .iconSet(MaterialIconSet.SHINY)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .components(GTMaterials.Aluminium, 1, GTMaterials.Chlorine, 3)
                .buildAndRegister();
        //  24063 Aluminium Hydroxide
        EPMaterials.AluminiumHydroxide = new Material.Builder("aluminium_hydroxide")
                .dust()
                .color(0xBEBEC8)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .components(GTMaterials.Aluminium, 1, GTMaterials.Oxygen, 3, GTMaterials.Hydrogen, 3)
                .buildAndRegister()
                .setFormula("Al(OH)3", true);
        //  24064 Alumina
        EPMaterials.Alumina = new Material.Builder("alumina")
                .dust()
                .color(0x78c3eb)
                .iconSet(MaterialIconSet.METALLIC)
                .components(GTMaterials.Aluminium, 2, GTMaterials.Oxygen, 3)
                .buildAndRegister();
        //  24065 Gallium Trioxide
        EPMaterials.GalliumTrioxide = new Material.Builder("gallium_trioxide")
                .dust()
                .fluid(FluidStorageKeys.LIQUID, new FluidBuilder().temperature(2170))
                .color(0xE4CDFF)
                .iconSet(MaterialIconSet.METALLIC)
                .components(GTMaterials.Gallium, 1, GTMaterials.Oxygen, 3)
                .buildAndRegister();
        //  24066 Gallium Nitride
        EPMaterials.GalliumNitride = new Material.Builder("gallium_nitride")
                .ingot()
                .color(0xFFF458)
                .iconSet(MaterialIconSet.SHINY)
                .flags(MaterialFlags.GENERATE_PLATE)
                .components(GTMaterials.Gallium, 1, GTMaterials.Nitrogen, 1)
                .buildAndRegister();
        //  24067 Fullerene
        EPMaterials.Fullerene = new Material.Builder("fullerene")
                .ingot()
                .color(0x72556A)
                .iconSet(MaterialIconSet.BRIGHT)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION, MaterialFlags.NO_SMELTING, MaterialFlags.GENERATE_PLATE, MaterialFlags.GENERATE_FOIL, MaterialFlags.GENERATE_ROD, MaterialFlags.GENERATE_RING, MaterialFlags.GENERATE_FRAME)
                .components(GTMaterials.Carbon, 60)
                .buildAndRegister();
        //  24068 Geodesic Polyarene
        EPMaterials.GeodesicPolyarene = new Material.Builder("geodesic_polyarene")
                .dust()
                .color(0x9E81A8)
                .iconSet(MaterialIconSet.METALLIC)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .components(GTMaterials.Carbon, 60, GTMaterials.Hydrogen, 30)
                .buildAndRegister();
        //  24069 Ti-Al Catalyst
        EPMaterials.TiAlCatalyst = new Material.Builder("ti_al_catalyst")
                .dust()
                .color(0x6600CC)
                .iconSet(MaterialIconSet.DULL)
                .components(GTMaterials.Titanium, 1, GTMaterials.Aluminium, 1)
                .buildAndRegister();
        //  24070 Potassium Cyanide
        EPMaterials.PotassiumCyanide = new Material.Builder("potassium_cyanide")
                .dust()
                .color(0x9EF3D0)
                .iconSet(MaterialIconSet.ROUGH)
                .components(GTMaterials.Potassium, 1, GTMaterials.Carbon, 1, GTMaterials.Nitrogen, 1)
                .buildAndRegister();
        //  24071 Potassium Bromide
        EPMaterials.PotassiumBromide = new Material.Builder("potassium_bromide")
                .dust()
                .color(0x615057)
                .iconSet(MaterialIconSet.DULL)
                .components(GTMaterials.Potassium, 1, GTMaterials.Bromine, 1)
                .buildAndRegister();
        //  24072 Bismuth Vanadate
        EPMaterials.BismuthVanadate = new Material.Builder("bismuth_vanadate")
                .dust()
                .color(0xFFAF33)
                .iconSet(MaterialIconSet.SHINY)
                .components(GTMaterials.Bismuth, 1, GTMaterials.Vanadium, 1, GTMaterials.Oxygen, 4)
                .buildAndRegister();
        //  24073 Bismuth Vanadate Solution
        EPMaterials.BismuthVanadateSolution = new Material.Builder("bismuth_vanadate_solution")
                .fluid()
                .color(0xFFAF33)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .components(GTMaterials.Bismuth, 1, GTMaterials.Vanadium, 1, GTMaterials.Hydrogen, 2, GTMaterials.Oxygen, 5)
                .buildAndRegister()
                .setFormula("BiVO4(H2O)", true);
        //  24074 Ammonium Vanadate
        EPMaterials.AmmoniumVanadate = new Material.Builder("ammonium_vanadate")
                .dust()
                .color(0xCC9933)
                .iconSet(MaterialIconSet.ROUGH)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .components(GTMaterials.Nitrogen, 1, GTMaterials.Hydrogen, 4, GTMaterials.Vanadium, 1, GTMaterials.Oxygen, 3)
                .buildAndRegister();
        //  24075 Vanadium Slag
        EPMaterials.VanadiumSlag = new Material.Builder("vanadium_slag")
                .dust()
                .color(0xCC9933)
                .iconSet(MaterialIconSet.DULL)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .components(GTMaterials.Vanadium, 1, GTMaterials.Oxygen, 1)
                .buildAndRegister();
        //  24076 Bismuth Nitrate Solution
        EPMaterials.BismuthNitrateSolution = new Material.Builder("bismuth_nitrate_solution")
                .fluid()
                .color(0x3ABF50)
                .components(GTMaterials.Bismuth, 1, GTMaterials.Nitrogen, 3, GTMaterials.Oxygen, 10, GTMaterials.Hydrogen, 2)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .buildAndRegister()
                .setFormula("Bi(NO3)3(H2O)");
        //  24077 Sodium Vanadate
        EPMaterials.SodiumVanadate = new Material.Builder("sodium_vanadate")
                .dust()
                .color(0xCC9933)
                .iconSet(MaterialIconSet.BRIGHT)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .components(GTMaterials.Sodium, 3, GTMaterials.Vanadium, 1, GTMaterials.Oxygen, 4)
                .buildAndRegister();
        //  24078 Vanadium Waste Solution
        EPMaterials.VanadiumWasteSolution = new Material.Builder("vanadium_waste_solution")
                .fluid()
                .color(0xA28097)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .buildAndRegister()
                .setFormula("NaCl(Na2SO4)(SiO2)(Al(OH)3)");
        //  24079 Sodium Bromide
        EPMaterials.SodiumBromide = new Material.Builder("sodium_bromide")
                .dust()
                .color(0x830B2B)
                .iconSet(MaterialIconSet.ROUGH)
                .components(GTMaterials.Sodium, 1, GTMaterials.Bromine, 1)
                .buildAndRegister();
        //  24080 White Phosphorus
        EPMaterials.WhitePhosphorus = new Material.Builder("white_phosphorus")
                .gem()
                .color(0xECEADD)
                .iconSet(MaterialIconSet.FLINT)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .components(GTMaterials.Phosphorus, 4)
                .buildAndRegister();
        //  24081 Red Phosphorus
        EPMaterials.RedPhosphorus = new Material.Builder("red_phosphorus")
                .gem()
                .color(0x77040E)
                .iconSet(MaterialIconSet.FLINT)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .components(GTMaterials.Phosphorus, 4)
                .buildAndRegister();
        //  24082 Violet Phosphorus
        EPMaterials.VioletPhosphorus = new Material.Builder("violet_phosphorus")
                .gem()
                .color(0x8000FF)
                .iconSet(MaterialIconSet.FLINT)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .components(GTMaterials.Phosphorus, 4)
                .buildAndRegister();
        //  24083 Black Phosphorus
        EPMaterials.BlackPhosphorus = new Material.Builder("black_phosphorus")
                .gem()
                .color(0x36454F)
                .iconSet(MaterialIconSet.FLINT)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .components(GTMaterials.Phosphorus, 4)
                .buildAndRegister();
        //  24084 Blue Phosphorus
        EPMaterials.BluePhosphorus = new Material.Builder("blue_phosphorus")
                .gem()
                .color(0x9BE3E4)
                .iconSet(MaterialIconSet.FLINT)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .components(GTMaterials.Phosphorus, 4)
                .buildAndRegister();
        //  24085 Wollastonite
        EPMaterials.Wollastonite = new Material.Builder("wollastonite")
                .dust()
                .color(0xF0F0F0)
                .flags(MaterialFlags.DECOMPOSITION_BY_CENTRIFUGING)
                .components(GTMaterials.Quicklime, 2, GTMaterials.SiliconDioxide, 3)
                .buildAndRegister()
                .setFormula("CaSiO3", true);
        //  24086 Phosphorene
        EPMaterials.Phosphorene = new Material.Builder("phosphorene")
                .ingot()
                .color(0x273239)
                .iconSet(MaterialIconSet.SHINY)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION, MaterialFlags.GENERATE_FOIL)
                .components(GTMaterials.Phosphorus, 4)
                .buildAndRegister();
        //  24087 Phosphoryl Chloride
        EPMaterials.PhosphorylChloride = new Material.Builder("phosphoryl_chloride")
                .fluid()
                .color(0xE8BB5B)
                .components(GTMaterials.Phosphorus, 1, GTMaterials.Oxygen, 1, GTMaterials.Chlorine, 3)
                .buildAndRegister();
        //  24088 Phosphine
        EPMaterials.Phosphine = new Material.Builder("phosphine")
                .gas()
                .color(0xACB330)
                .flags(MaterialFlags.DECOMPOSITION_BY_ELECTROLYZING, MaterialFlags.FLAMMABLE)
                .components(GTMaterials.Phosphorus, 1, GTMaterials.Hydrogen, 3)
                .buildAndRegister();
        //  24089 Copper Chloride
        EPMaterials.CopperChloride = new Material.Builder("copper_chloride")
                .dust()
                .color(0x3FB3B8)
                .iconSet(MaterialIconSet.ROUGH)
                .components(GTMaterials.Copper, 1, GTMaterials.Chlorine, 2)
                .buildAndRegister();
        //  24090 Lithium Hydroxide
        EPMaterials.LithiumHydroxide = new Material.Builder("lithium_hydroxide")
                .dust()
                .color(0xDECAFA)
                .iconSet(MaterialIconSet.FINE)
                .components(GTMaterials.Lithium, 1, GTMaterials.Oxygen, 1, GTMaterials.Hydrogen, 1)
                .buildAndRegister();

        //  24091 Lithiuim Amalgam
        EPMaterials.LithiumAmalgam = new Material.Builder("lithium_amalgam")
                .fluid()
                .color(0xAEA7D4)
                .iconSet(MaterialIconSet.FINE)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .components(GTMaterials.Mercury, 1, GTMaterials.Lithium, 1)
                .buildAndRegister();
        //  24092 Hexafluoride Enriched Naquadah Solution
        EPMaterials.HexafluorideEnrichedNaquadahSolution = new Material.Builder("hexafluoride_enriched_naquadah_solution")
                .fluid()
                .color(0x868D7F)
                .components(GTMaterials.NaquadahEnriched, 1, GTMaterials.Fluorine, 6)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24093 Xenon Hexafluoro Enriched Naquadate
        EPMaterials.XenonHexafluoroEnrichedNaquadate = new Material.Builder("xenon_hexafluoro_enriched_naquadate")
                .fluid()
                .color(0x255A55)
                .components(GTMaterials.Xenon, 1, GTMaterials.NaquadahEnriched, 1, GTMaterials.Fluorine, 6)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24094 Enriched Naquadah Residue Solution
        EPMaterials.EnrichedNaquadahResidueSolution = new Material.Builder("enriched_naquadah_residue_solution")
                .fluid()
                .color(0x868D7F)
                .iconSet(MaterialIconSet.DULL)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .buildAndRegister()
                .setFormula("XeAuSbKeF6S2?");
        //  24095 Xenoauric Fluoroantimonic Acid
        EPMaterials.XenoauricFluoroantimonicAcid = new Material.Builder("xenoauric_fluoroantimonic_acid")
                .fluid(FluidStorageKeys.LIQUID, new FluidBuilder().attribute(FluidAttributes.ACID))
                .color(0xE0BD74)
                .components(GTMaterials.Xenon, 1, GTMaterials.Gold, 1, GTMaterials.Antimony, 1, GTMaterials.Fluorine, 6)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24096 Gold Chloride
        EPMaterials.GoldChloride = new Material.Builder("gold_chloride")
                .fluid()
                .color(0xCCCC66)
                .components(GTMaterials.Gold, 2, GTMaterials.Chlorine, 6)
                .buildAndRegister();
        //  24097 Bromine Trifluoride
        EPMaterials.BromineTrifluoride = new Material.Builder("bromine_trifluoride")
                .fluid()
                .color(0xA88E57)
                .components(GTMaterials.Bromine, 1, GTMaterials.Fluorine, 3)
                .buildAndRegister();
        //  24098 Gold Trifluoride
        EPMaterials.GoldTrifluoride = new Material.Builder("gold_trifluoride")
                .dust()
                .color(0xE8C478)
                .iconSet(MaterialIconSet.BRIGHT)
                .components(GTMaterials.Gold, 1, GTMaterials.Fluorine, 3)
                .buildAndRegister();
        //  24099 Naquadria Caesiumfluoride
        EPMaterials.NaquadriaCaesiumfluoride = new Material.Builder("naquadria_caesiumfluoride")
                .fluid()
                .color(0xAAEB69)
                .components(GTMaterials.Naquadria, 1, GTMaterials.Fluorine, 3, GTMaterials.Caesium, 1)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .buildAndRegister()
                .setFormula("*Nq*F2CsF", true);
        //  24100 Acidic Naquadria Caesiumfluoride
        EPMaterials.AcidicNaquadriaCaesiumfluoride = new Material.Builder("acidic_naquadria_caesiumfluoride")
                .fluid()
                .color(0x75EB00)
                .components(GTMaterials.Naquadria, 1, GTMaterials.Fluorine, 3, GTMaterials.Caesium, 1, GTMaterials.Sulfur, 2, GTMaterials.Oxygen, 8)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .buildAndRegister()
                .setFormula("*Nq*F2CsF(SO4)2", true);
        //  24101 Nitrosonium Octafluoroxenate
        EPMaterials.NitrosoniumOctafluoroxenate = new Material.Builder("nitrosonium_octafluoroxenate")
                .fluid()
                .color(0x953D9F)
                .components(GTMaterials.NitrogenDioxide, 2, GTMaterials.Xenon, 1, GTMaterials.Fluorine, 8)
                .buildAndRegister()
                .setFormula("(NO2)2XeF8", true);
        //  24102 Naquadria Caesium Xenonnonfluoride
        EPMaterials.NaquadriaCaesiumXenonnonfluoride = new Material.Builder("naquadria_caesium_xenonnonfluoride")
                .fluid()
                .color(0x54C248)
                .components(GTMaterials.Naquadria, 1, GTMaterials.Caesium, 1, GTMaterials.Xenon, 1, GTMaterials.Fluorine, 9)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24103 Radon Naquadria Octafluoride
        EPMaterials.RadonNaquadriaOctafluoride = new Material.Builder("radon_naquadria_octafluoride")
                .fluid()
                .color(0x85F378)
                .components(GTMaterials.Radon, 1, GTMaterials.Naquadria, 1, GTMaterials.Fluorine, 8)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24104 Caesium Xenontrioxide Fluoride
        EPMaterials.CaesiumXenontrioxideFluoride = new Material.Builder("caesium_xenontrioxide_fluoride")
                .fluid()
                .color(0x5067D7)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .components(GTMaterials.Caesium, 1, GTMaterials.Xenon, 1, GTMaterials.Oxygen, 3, GTMaterials.Fluorine, 1)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24105 Radon Trioxide
        EPMaterials.RadonTrioxide = new Material.Builder("radon_trioxide")
                .fluid()
                .color(0x9A6DD7)
                .components(GTMaterials.Radon, 1, GTMaterials.Oxygen, 3)
                .buildAndRegister();
        //  24106 Cesium Fluoride
        EPMaterials.CaesiumFluoride = new Material.Builder("caesium_fluoride")
                .fluid()
                .color(0xFF7A5F)
                .components(GTMaterials.Caesium, 1, GTMaterials.Fluorine, 1)
                .buildAndRegister();
        //  24107 Xenon Trioxide
        EPMaterials.XenonTrioxide = new Material.Builder("xenon_trioxide")
                .fluid()
                .color(0x359FC3)
                .components(GTMaterials.Xenon, 1, GTMaterials.Oxygen, 3)
                .buildAndRegister();
        //  24108 Hexafluoride Naquadria Solution
        EPMaterials.HexafluorideNaquadriaSolution = new Material.Builder("hexafluoride_naquadria_solution")
                .fluid()
                .color(0x25C213)
                .components(GTMaterials.Naquadria, 1, GTMaterials.Fluorine, 6)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24109 Naquadria Residue Solution
        EPMaterials.NaquadriaResidueSolution = new Material.Builder("naquadria_residue_solution")
                .fluid()
                .color(0x25C213)
                .iconSet(MaterialIconSet.DULL)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .buildAndRegister()
                .setFormula("InPS6?", true);
        //  24110 Radon Difluoride
        EPMaterials.RadonDifluoride = new Material.Builder("radon_difluoride")
                .fluid()
                .color(0x8B7EFF)
                .components(GTMaterials.Radon, 1, GTMaterials.Fluorine, 2)
                .buildAndRegister();
        //  24111 Heavy Alkali Chloride Solution
        EPMaterials.HeavyAlkaliChlorideSolution = new Material.Builder("heavy_alkali_chloride_solution")
                .fluid()
                .color(0x8F5353)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .components(GTMaterials.Rubidium, 1, GTMaterials.Caesium, 2, GTMaterials.Chlorine, 6, GTMaterials.Water, 2)
                .buildAndRegister()
                .setFormula("RbCl(CsCl)2Cl3(H2O)2", true);
        //  24112 Stannic Chloride
        EPMaterials.StannicChloride = new Material.Builder("stannic_chloride")
                .fluid()
                .color(0x33BBF5)
                .components(GTMaterials.Tin, 1, GTMaterials.Chlorine, 4)
                .buildAndRegister();
        //  24113 Rubidium Chlorostannate
        EPMaterials.RubidiumChlorostannate = new Material.Builder("rubidium_chlorostannate")
                .dust()
                .color(0xBD888A)
                .iconSet(MaterialIconSet.METALLIC)
                .components(GTMaterials.Rubidium, 2, GTMaterials.Tin, 1, GTMaterials.Chlorine, 6)
                .buildAndRegister();
        //  24114 Caesium Chlorostannate
        EPMaterials.CaesiumChlorostannate = new Material.Builder("caesium_chlorostannate")
                .dust()
                .color(0xBDAD88)
                .iconSet(MaterialIconSet.SHINY)
                .components(GTMaterials.Caesium, 2, GTMaterials.Tin, 1, GTMaterials.Chlorine, 6)
                .buildAndRegister();
        //  24115 Germanium Dioxide
        EPMaterials.GermaniumDioxide = new Material.Builder("germanium_dioxide")
                .dust()
                .color(0x666666)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .components(GTMaterials.Germanium, 1, GTMaterials.Oxygen, 2)
                .buildAndRegister();
        //  24116 Roasted Sphalerite
        EPMaterials.RoastedSphalerite = new Material.Builder("roasted_sphalerite")
                .dust()
                .color(0xAC8B5C)
                .iconSet(MaterialIconSet.FINE)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .components(GTMaterials.Gallium, 1, EPMaterials.GermaniumDioxide, 1)
                .buildAndRegister();
        //  24117 Zinc Rich Sphalerite
        EPMaterials.ZincRichSphalerite = new Material.Builder("zinc_rich_sphalerite")
                .dust()
                .color(0xC3AC8F)
                .iconSet(MaterialIconSet.METALLIC)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .components(GTMaterials.Zinc, 2, EPMaterials.RoastedSphalerite, 3)
                .buildAndRegister()
                .setFormula("Zn2(GaGeO2)", true);
        //  24118 Zinc Oxide
        EPMaterials.ZincOxide = new Material.Builder("zinc_oxide")
                .dust()
                .color(0xB85C34)
                .flags(MaterialFlags.DECOMPOSITION_BY_ELECTROLYZING)
                .components(GTMaterials.Zinc, 1, GTMaterials.Oxygen, 1)
                .buildAndRegister();
        //  24119 Waelz Oxide
        EPMaterials.WaelzOxide = new Material.Builder("waelz_oxide")
                .dust()
                .color(0xB8B8B8)
                .iconSet(MaterialIconSet.FINE)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .components(GTMaterials.Zinc, 1, EPMaterials.GermaniumDioxide, 1)
                .buildAndRegister();
        //  24120 Waelz Slag
        EPMaterials.WaelzSlag = new Material.Builder("waelz_slag")
                .dust()
                .color(0xAC8B5C)
                .iconSet(MaterialIconSet.ROUGH)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .components(GTMaterials.Gallium, 1, GTMaterials.Zinc, 1, GTMaterials.Sulfur, 1, GTMaterials.Oxygen, 4)
                .buildAndRegister();
        //  24121 Impure Germanium Dioxide
        EPMaterials.ImpureGermaniumDioxide = new Material.Builder("impure_germanium_dioxide")
                .dust()
                .color(0x666666)
                .iconSet(MaterialIconSet.ROUGH)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .components(EPMaterials.GermaniumDioxide, 1)
                .buildAndRegister()
                .setFormula("GeO2?", true);
        //  24122 Germanium Tetrachloride
        EPMaterials.GermaniumTetrachloride = new Material.Builder("germanium_tetrachloride")
                .fluid()
                .color(0x787878)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .components(GTMaterials.Germanium, 1, GTMaterials.Chlorine, 4)
                .buildAndRegister();
        //  24123 Molybdenum Trioxide
        EPMaterials.MolybdenumTrioxide = new Material.Builder("molybdenum_trioxide")
                .dust()
                .color(0xCBCFDA)
                .iconSet(MaterialIconSet.ROUGH)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .components(GTMaterials.Molybdenum, 1, GTMaterials.Oxygen, 3)
                .buildAndRegister();
        //  24124 Lead Chloride
        EPMaterials.LeadChloride = new Material.Builder("lead_chloride")
                .dust()
                .color(0xF3F3F3)
                .iconSet(MaterialIconSet.ROUGH)
                .components(GTMaterials.Lead, 1, GTMaterials.Chlorine, 2)
                .buildAndRegister();
        //  24125 Perrhenic Acid
        EPMaterials.PerrhenicAcid = new Material.Builder("perrhenic_acid")
                .dust()
                .color(0xE6DC70)
                .iconSet(MaterialIconSet.SHINY)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .components(GTMaterials.Hydrogen, 1, GTMaterials.Rhenium, 1, GTMaterials.Oxygen, 4)
                .buildAndRegister();
        //  24126 Ammonium Perrhenate
        EPMaterials.AmmoniumPerrhenate = new Material.Builder("ammonium_perrhenate")
                .dust()
                .fluid()
                .color(0xA69970)
                .iconSet(MaterialIconSet.METALLIC)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .components(GTMaterials.Nitrogen, 1, GTMaterials.Hydrogen, 4, GTMaterials.Rhenium, 1, GTMaterials.Oxygen, 4)
                .buildAndRegister();
        //  24127 Niobium Pentoxide
        EPMaterials.NiobiumPentoxide = new Material.Builder("niobium_pentoxide")
                .dust()
                .color(0xBAB0C3)
                .iconSet(MaterialIconSet.ROUGH)
                .components(GTMaterials.Niobium, 2, GTMaterials.Oxygen, 5)
                .buildAndRegister();
        //  24128 Tantalum Pentoxide
        EPMaterials.TantalumPentoxide = new Material.Builder("tantalum_pentoxide")
                .dust()
                .color(0x72728A)
                .iconSet(MaterialIconSet.ROUGH)
                .components(GTMaterials.Tantalum, 2, GTMaterials.Oxygen, 5)
                .buildAndRegister();
        //  24129 Calcium Difluoride
        EPMaterials.CalciumDifluoride = new Material.Builder("calcium_difluoride")
                .dust()
                .color(0xFFFC9E)
                .iconSet(MaterialIconSet.ROUGH)
                .components(GTMaterials.Calcium, 1, GTMaterials.Fluorine, 2)
                .buildAndRegister();
        //  24130 Manganese Difluoride
        EPMaterials.ManganeseDifluoride = new Material.Builder("manganese_difluoride")
                .dust()
                .color(0xEF4B3D)
                .iconSet(MaterialIconSet.ROUGH)
                .components(GTMaterials.Manganese, 1, GTMaterials.Fluorine, 2)
                .buildAndRegister();
        //  24131 Calcium Carbide
        EPMaterials.CalciumCarbide = new Material.Builder("calcium_carbide")
                .dust()
                .color(0x807B70)
                .iconSet(MaterialIconSet.DULL)
                .components(GTMaterials.Calcium, 1, GTMaterials.Carbon, 2)
                .buildAndRegister();
        //  24132 Calcium Hydroxide
        EPMaterials.CalciumHydroxide = new Material.Builder("calcium_hydroxide")
                .dust()
                .color(0x5F8764)
                .iconSet(MaterialIconSet.ROUGH)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .components(GTMaterials.Calcium, 1, GTMaterials.Hydrogen, 2, GTMaterials.Oxygen, 2)
                .buildAndRegister()
                .setFormula("Ca(OH)2", true);
        //  24133 Sodium Tellurite
        EPMaterials.SodiumTellurite = new Material.Builder("sodium_tellurite")
                .dust()
                .color(0xC6C9BE)
                .iconSet(MaterialIconSet.ROUGH)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .components(GTMaterials.Sodium, 2, GTMaterials.Tellurium, 1, GTMaterials.Oxygen, 3)
                .buildAndRegister();
        //  24134 Selenium Dioxide
        EPMaterials.SeleniumDioxide = new Material.Builder("selenium_dioxide")
                .dust()
                .color(0xE0DDD8)
                .iconSet(MaterialIconSet.METALLIC)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .components(GTMaterials.Selenium, 1, GTMaterials.Oxygen, 2)
                .buildAndRegister();
        //  24135 Tellurium Dioxide
        EPMaterials.TelluriumDioxide = new Material.Builder("tellurium_dioxide")
                .dust()
                .color(0xE3DDB8)
                .iconSet(MaterialIconSet.METALLIC)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .components(GTMaterials.Tellurium, 1, GTMaterials.Oxygen, 2)
                .buildAndRegister();
        //  24136 Selenous Acid
        EPMaterials.SelenousAcid = new Material.Builder("selenous_acid")
                .dust()
                .color(0xE0E083)
                .iconSet(MaterialIconSet.SHINY)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .components(GTMaterials.Hydrogen, 2, GTMaterials.Selenium, 1, GTMaterials.Oxygen, 3)
                .buildAndRegister();
        //  24137 GST Glass
        EPMaterials.GSTGlass = new Material.Builder("gst_glass")
                .ingot()
                .fluid()
                .color(0xCFFFFF)
                .iconSet(MaterialIconSet.SHINY)
                .flags(MaterialFlags.GENERATE_PLATE, MaterialFlags.NO_SMASHING, MaterialFlags.NO_WORKING, MaterialFlags.DECOMPOSITION_BY_CENTRIFUGING)
                .components(GTMaterials.Germanium, 2, GTMaterials.Antimony, 2, GTMaterials.Tellurium, 5)
                .blastTemp(873, BlastProperty.GasTier.MID)
                .buildAndRegister();
        //  24138 ZBLAN Glass
        EPMaterials.ZBLANGlass = new Material.Builder("zblan_glass")
                .ingot()
                .fluid()
                .color(0xACB4BC)
                .iconSet(MaterialIconSet.SHINY)
                .flags(MaterialFlags.NO_SMASHING, MaterialFlags.NO_WORKING, MaterialFlags.DISABLE_DECOMPOSITION, MaterialFlags.GENERATE_FINE_WIRE)
                .components(GTMaterials.Zirconium, 5, GTMaterials.Barium, 2, GTMaterials.Lanthanum, 1, GTMaterials.Aluminium, 1, GTMaterials.Sodium, 2, GTMaterials.Fluorine, 6)
                .buildAndRegister()
                .setFormula("(ZrF4)5(BaF2)2(LaF3)(AlF3)(NaF)2", true);
        //  24139 Erbium-doped ZBLAN Glass
        EPMaterials.ErbiumDopedZBLANGlass = new Material.Builder("erbium_doped_zblan_glass")
                .ingot()
                .color(0x505444)
                .iconSet(MaterialIconSet.BRIGHT)
                .flags(MaterialFlags.NO_SMASHING, MaterialFlags.NO_WORKING, MaterialFlags.DISABLE_DECOMPOSITION, MaterialFlags.GENERATE_PLATE)
                .components(EPMaterials.ZBLANGlass, 1, GTMaterials.Erbium, 1)
                .buildAndRegister()
                .setFormula("(ZrF4)5(BaF2)2(LaF3)(AlF3)(NaF)2Er", true);
        //  24140 PraseodymiumDopedZBLANGlass
        EPMaterials.PraseodymiumDopedZBLANGlass = new Material.Builder("praseodymium_doped_zblan_glass")
                .ingot()
                .color(0xC5C88D)
                .iconSet(MaterialIconSet.BRIGHT)
                .flags(MaterialFlags.NO_SMASHING, MaterialFlags.NO_WORKING, MaterialFlags.DISABLE_DECOMPOSITION, MaterialFlags.GENERATE_PLATE)
                .components(EPMaterials.ZBLANGlass, 1, GTMaterials.Praseodymium, 1)
                .buildAndRegister()
                .setFormula("(ZrF4)5(BaF2)2(LaF3)(AlF3)(NaF)2Pr", true);
        //  24141 Silicon Tetrachloride
        EPMaterials.SiliconTetrachloride = new Material.Builder("silicon_tetrachloride")
                .fluid()
                .color(0x5B5B7A)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .components(GTMaterials.Silicon, 1, GTMaterials.Chlorine, 4)
                .buildAndRegister();
        //  24142 Cadmium Sulfide
        EPMaterials.CadmiumSulfide = new Material.Builder("cadmium_sulfide")
                .dust()
                .color(0xC8C43C)
                .flags(MaterialFlags.DECOMPOSITION_BY_ELECTROLYZING, MaterialFlags.GENERATE_PLATE)
                .iconSet(MaterialIconSet.METALLIC)
                .components(GTMaterials.Cadmium, 1, GTMaterials.Sulfur, 1)
                .buildAndRegister();
        //  24143 Silicon Carbide
        EPMaterials.SiliconCarbide = new Material.Builder("silicon_carbide")
                .dust()
                .fluid()
                .color(0x4D4D4D)
                .iconSet(MaterialIconSet.METALLIC)
                .flags(MaterialFlags.GENERATE_FINE_WIRE)
                .components(GTMaterials.Silicon, 1, GTMaterials.Carbon, 1)
                .blastTemp(2500, BlastProperty.GasTier.HIGH, GTValues.VA[GTValues.UV])
                .cableProperties(GTValues.V[GTValues.UHV], 6, 8)
                .buildAndRegister();
        //  24144 Chromium Germanium Telluride
        EPMaterials.ChromiumGermaniumTelluride = new Material.Builder("chromium_germanium_telluride")
                .ingot()
                .fluid()
                .color(0x8F103E)
                .iconSet(MaterialIconSet.METALLIC)
                .flags(MaterialFlags.GENERATE_ROD, MaterialFlags.GENERATE_LONG_ROD)
                .components(/*Chrome, 1, */GTMaterials.Germanium, 1, GTMaterials.Tellurium, 3)
                .blastTemp(2900, BlastProperty.GasTier.HIGHER)
                .buildAndRegister();
        //  24145 Magnetic Chromium Germanium Telluride
        EPMaterials.ChromiumGermaniumTellurideMagnetic = new Material.Builder("magnetic_chromium_germanium_telluride")
                .ingot()
                .color(0x8F103E)
                .iconSet(MaterialIconSet.MAGNETIC)
                .flags(MaterialFlags.GENERATE_ROD, MaterialFlags.GENERATE_LONG_ROD, MaterialFlags.IS_MAGNETIC)
                .components(EPMaterials.ChromiumGermaniumTelluride, 1)
                .ingotSmeltInto(EPMaterials.ChromiumGermaniumTelluride)
                .arcSmeltInto(EPMaterials.ChromiumGermaniumTelluride)
                .macerateInto(EPMaterials.ChromiumGermaniumTelluride)
                .buildAndRegister();
        EPMaterials.ChromiumGermaniumTelluride.getProperty(PropertyKey.INGOT).setMagneticMaterial(EPMaterials.ChromiumGermaniumTellurideMagnetic);
        //  24146 Lithium Fluoride
        EPMaterials.LithiumFluoride = new Material.Builder("lithium_fluoride")
                .dust()
                .color(0x9BAFDB)
                .iconSet(MaterialIconSet.ROUGH)
                .components(GTMaterials.Lithium, 1, GTMaterials.Fluorine, 1)
                .buildAndRegister();
        //  24147 Barium Carbonate
        EPMaterials.BariumCarbonate = new Material.Builder("barium_carbonate")
                .dust()
                .color(0x425A73)
                .iconSet(MaterialIconSet.ROUGH)
                .components(GTMaterials.Barium, 1, GTMaterials.Carbon, 1, GTMaterials.Oxygen, 3)
                .buildAndRegister();
        //  24148 Carbon Disulfide
        EPMaterials.CarbonDisulfide = new Material.Builder("carbon_disulfide")
                .fluid()
                .color(0x1F80C8)
                .components(GTMaterials.Carbon, 1, GTMaterials.Sulfur, 2)
                .buildAndRegister();
        //  24149 Sodium Thiosulfate
        EPMaterials.SodiumThiosulfate = new Material.Builder("sodium_thiosulfate")
                .dust()
                .color(0x1436A7)
                .iconSet(MaterialIconSet.ROUGH)
                .components(GTMaterials.Sodium, 2, GTMaterials.Sulfur, 2, GTMaterials.Oxygen, 3)
                .buildAndRegister();
        //  24150 Cadmium Selenide
        EPMaterials.CadmiumSelenide = new Material.Builder("cadmium_selenide")
                .dust()
                .color(0x983034)
                .flags(MaterialFlags.DECOMPOSITION_BY_ELECTROLYZING)
                .iconSet(MaterialIconSet.METALLIC)
                .components(GTMaterials.Cadmium, 1, GTMaterials.Selenium, 1)
                .buildAndRegister();
        //  24151 Thallium Copper Chloride Antiferromagnetic
        EPMaterials.ThalliumCopperChloride = new Material.Builder("thallium_copper_chloride")
                .ingot()
                .fluid()
                .color(0x3C5CB5)
                .iconSet(MaterialIconSet.MAGNETIC)
                .flags(MaterialFlags.GENERATE_FINE_WIRE)
                .components(GTMaterials.Thallium, 1, GTMaterials.Copper, 1, GTMaterials.Chlorine, 3)
                .buildAndRegister();
        //  24152 Plutonium Trihydride
        EPMaterials.PlutoniumTrihydride = new Material.Builder("plutonium_trihydride")
                .dust()
                .color(0x140002)
                .iconSet(MaterialIconSet.SHINY)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .components(GTMaterials.Plutonium239, 1, GTMaterials.Hydrogen, 3)
                .buildAndRegister()
                .setFormula("PuH3", true);
        //  24153 Plutonium Phosphide
        EPMaterials.PlutoniumPhosphide = new Material.Builder("plutonium_phosphide")
                .ingot()
                .color(0x1F0104)
                .iconSet(MaterialIconSet.MAGNETIC)
                .flags(MaterialFlags.GENERATE_PLATE, MaterialFlags.GENERATE_ROD, MaterialFlags.GENERATE_LONG_ROD)
                .components(GTMaterials.Plutonium239, 1, GTMaterials.Phosphorus, 1)
                .buildAndRegister()
                .setFormula("PuP", true);
        //  24154 Neptunium Aluminide
        EPMaterials.NeptuniumAluminide = new Material.Builder("neptunium_aluminide")
                .ingot()
                .fluid()
                .color(0x5E228F)
                .iconSet(MaterialIconSet.MAGNETIC)
                .flags(MaterialFlags.GENERATE_PLATE, MaterialFlags.GENERATE_ROD, MaterialFlags.GENERATE_LONG_ROD)
                .components(GTMaterials.Neptunium, 1, GTMaterials.Aluminium, 3)
                .blastTemp(1568, BlastProperty.GasTier.HIGHER, GTValues.VA[GTValues.ZPM])
                .buildAndRegister()
                .setFormula("NpAl3", true);
        //  24155 Bismuth Trioxide
        EPMaterials.BismuthTrioxide = new Material.Builder("bismuth_trioxide")
                .dust()
                .color(0xF5EF42)
                .iconSet(MaterialIconSet.FINE)
                .components(GTMaterials.Bismuth, 2, GTMaterials.Oxygen, 3)
                .buildAndRegister();
        //  24156 Ferric Oxide
        EPMaterials.FerricOxide = new Material.Builder("ferric_oxide")
                .dust()
                .color(0x915A5A)
                .iconSet(MaterialIconSet.ROUGH)
                .components(GTMaterials.Iron, 2, GTMaterials.Oxygen, 3)
                .buildAndRegister();
        //  24157 Bismuth Ferrite
        EPMaterials.BismuthFerrite = new Material.Builder("bismuth_ferrite")
                .gem()
                .color(0x43634B)
                .iconSet(MaterialIconSet.MAGNETIC)
                .flags(MaterialFlags.CRYSTALLIZABLE, MaterialFlags.GENERATE_PLATE)
                .components(EPMaterials.BismuthTrioxide, 2, EPMaterials.FerricOxide, 2)
                .buildAndRegister()
                .setFormula("BiFeO3", true);
        //  24158 Bismuth Chalcogenide
        EPMaterials.BismuthChalcogenide = new Material.Builder("bismuth_chalcogenide")
                .ingot()
                .color(0x91994D)
                .iconSet(MaterialIconSet.SHINY)
                .flags(MaterialFlags.GENERATE_PLATE, MaterialFlags.GENERATE_FOIL, MaterialFlags.DECOMPOSITION_BY_ELECTROLYZING)
                .components(GTMaterials.Bismuth, 1, GTMaterials.Antimony, 1, GTMaterials.Tellurium, 2, GTMaterials.Sulfur, 1)
                .buildAndRegister();
        //  24159 Mercury Cadmium Telluride
        EPMaterials.MercuryCadmiumTelluride = new Material.Builder("mercury_cadmium_telluride")
                .ingot()
                .fluid()
                .color(0x823C80)
                .iconSet(MaterialIconSet.BRIGHT)
                .flags(MaterialFlags.GENERATE_PLATE, MaterialFlags.GENERATE_FOIL, MaterialFlags.GENERATE_FINE_WIRE)
                .components(GTMaterials.Mercury, 2, GTMaterials.Cadmium, 1, GTMaterials.Tellurium, 2)
                .blastTemp(2170, BlastProperty.GasTier.HIGHER, GTValues.VA[GTValues.UHV])
                .buildAndRegister();
        //  24160 Cubic Zirconia
        EPMaterials.CubicZirconia = new Material.Builder("cubic_zirconia")
                .gem()
                .color(0xFFDFE2)
                .iconSet(MaterialIconSet.DIAMOND)
                .flags(MaterialFlags.CRYSTALLIZABLE, MaterialFlags.DISABLE_DECOMPOSITION)
                .components(GTMaterials.Zirconium, 1, GTMaterials.Oxygen, 2)
                .buildAndRegister();
        //  24161 Bismuth Tellurite
        EPMaterials.BismuthTellurite = new Material.Builder("bismuth_tellurite")
                .dust()
                .color(0x0E8933)
                .iconSet(MaterialIconSet.DULL)
                .components(GTMaterials.Bismuth, 2, GTMaterials.Tellurium, 3)
                .buildAndRegister();
        //  24162 Prasiolite
        EPMaterials.Prasiolite = new Material.Builder("prasiolite")
                .gem()
                .ore(1, 3, false)
                .addOreByproducts(GTMaterials.SiliconDioxide)
                .color(0x9EB749)
                .iconSet(MaterialIconSet.QUARTZ)
                .flags(MaterialFlags.CRYSTALLIZABLE, MaterialFlags.GENERATE_LENS)
                .components(GTMaterials.SiliconDioxide, 5, GTMaterials.Iron, 1)
                .buildAndRegister();
        //  24163 Magneto Resonatic
        EPMaterials.MagnetoResonatic = new Material.Builder("magneto_resonatic")
                .gem()
                .color(0xFF97FF)
                .iconSet(MaterialIconSet.MAGNETIC)
                .components(EPMaterials.Prasiolite, 3, EPMaterials.BismuthTellurite, 6, EPMaterials.CubicZirconia, 1, GTMaterials.SteelMagnetic, 1)
                .flags(MaterialFlags.GENERATE_LENS)
                .buildAndRegister();
        //  24164 Yttrium Trioxide
        EPMaterials.YttriumTrioxide = new Material.Builder("yttrium_trioxide")
                .dust()
                .color(0x765320)
                .iconSet(MaterialIconSet.DULL)
                .components(GTMaterials.Yttrium, 2, GTMaterials.Oxygen, 3)
                .buildAndRegister();
        //  24165 Heavy Taranium Fuel
        EPMaterials.HeavyTaraniumFuel = new Material.Builder("heavy_taranium_fuel")
                .fluid()
                .color(0x141414)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .components(EPMaterials.Taranium, 1)
                .buildAndRegister();
        //  24166 Medium Taranium Fuel
        EPMaterials.MediumTaraniumFuel = new Material.Builder("medium_taranium_fuel")
                .fluid()
                .color(0x181818)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .components(EPMaterials.Taranium, 1)
                .buildAndRegister();
        //  24167 Light Taraniumm Fuel
        EPMaterials.LightTaraniumFuel = new Material.Builder("light_taranium_fuel")
                .fluid()
                .color(0x1C1C1C)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .components(EPMaterials.Taranium, 1)
                .buildAndRegister();
        //  24168 Heavy Enriched Taranium Fuel
        EPMaterials.HeavyEnrichedTaraniumFuel = new Material.Builder("heavy_enriched_taranium_fuel")
                .fluid()
                .color(0x0F1414)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .components(EPMaterials.Taranium, 1)
                .buildAndRegister();
        //  24169 Medium Enriched Taranium Fuel
        EPMaterials.MediumEnrichedTaraniumFuel = new Material.Builder("medium_enriched_taranium_fuel")
                .fluid()
                .color(0x0F1818)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .components(EPMaterials.Taranium, 1)
                .buildAndRegister();
        //  24170 Light Enriched Taranium Fuel
        EPMaterials.LightEnrichedTaraniumFuel = new Material.Builder("light_enriched_taranium_fuel")
                .fluid()
                .color(0x0F1C1C)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .components(EPMaterials.Taranium, 1)
                .buildAndRegister();
        //  24171 Adamantite
        EPMaterials.Adamantite = new Material.Builder("adamantite")
                .dust()
                .color(0xC83C3C)
                .iconSet(MaterialIconSet.ROUGH)
                .components(EPMaterials.Adamantium, 3, GTMaterials.Oxygen, 4)
                .buildAndRegister();
        //  24172 Unstable Adamantium
        EPMaterials.AdamantiumUnstable = new Material.Builder("adamantium_unstable")
                .fluid()
                .color(0xFF763C)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .components(EPMaterials.Adamantium, 1)
                .buildAndRegister();
        //  24173 Energized Orichalcum
        EPMaterials.OrichalcumEnergized = new Material.Builder("orichalcum_energized")
                .dust()
                .color(0xF4FC0C)
                .iconSet(MaterialIconSet.BRIGHT)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .components(EPMaterials.Orichalcum, 1)
                .buildAndRegister();
        //  24174 Enriched Adamantium
        EPMaterials.AdamantiumEnriched = new Material.Builder("adamantium_enriched")
                .dust()
                .color(0x64B4FF)
                .iconSet(MaterialIconSet.ROUGH)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .components(EPMaterials.Vibranium, 1, GTMaterials.RareEarth, 1)
                .buildAndRegister();
        //  24175 Deep Iron
        EPMaterials.DeepIron = new Material.Builder("deep_iron")
                .dust()
                .color(0x968C8C)
                .iconSet(MaterialIconSet.METALLIC)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .components(GTMaterials.Iron, 2, GTMaterials.Trinium, 1, GTMaterials.Indium, 1)
                .buildAndRegister();
        //  24176 Unstable Vibranium
        EPMaterials.VibraniumUnstable = new Material.Builder("vibranium_unstable")
                .fluid()
                .color(0xFF7832)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .components(EPMaterials.Vibranium, 1)
                .buildAndRegister();
        //  24177 Lanthanum Oxide
        EPMaterials.LanthanumOxide = new Material.Builder("lanthanum_oxide")
                .dust()
                .color(0x5F7777)
                .iconSet(MaterialIconSet.SHINY)
                .components(GTMaterials.Lanthanum, 2, GTMaterials.Oxygen, 3)
                .buildAndRegister();
        //  24178 Praseodymium Oxide
        EPMaterials.PraseodymiumOxide = new Material.Builder("praseodymium_oxide")
                .dust()
                .color(0xD0D0D0)
                .iconSet(MaterialIconSet.METALLIC)
                .components(GTMaterials.Praseodymium, 2, GTMaterials.Oxygen, 3)
                .buildAndRegister();
        //  24179 Neodymium Oxide
        EPMaterials.NeodymiumOxide = new Material.Builder("neodymium_oxide")
                .dust()
                .color(0x868686)
                .components(GTMaterials.Neodymium, 2, GTMaterials.Oxygen, 3)
                .buildAndRegister();
        //  24180 Cerium Oxide
        EPMaterials.CeriumOxide = new Material.Builder("cerium_oxide")
                .dust()
                .color(0x10937F)
                .iconSet(MaterialIconSet.METALLIC)
                .components(GTMaterials.Cerium, 1, GTMaterials.Oxygen, 2)
                .buildAndRegister();
        //  24181 Scandium Oxide
        EPMaterials.ScandiumOxide = new Material.Builder("scandium_oxide")
                .dust()
                .color(0x43964F)
                .iconSet(MaterialIconSet.METALLIC)
                .components(GTMaterials.Scandium, 2, GTMaterials.Oxygen, 3)
                .buildAndRegister();
        //  24182 Europium Oxide
        EPMaterials.EuropiumOxide = new Material.Builder("europium_oxide")
                .dust()
                .color(0x20AAAA)
                .iconSet(MaterialIconSet.SHINY)
                .components(GTMaterials.Europium, 2, GTMaterials.Oxygen, 3)
                .buildAndRegister();
        //  24183 Gadolinium Oxide
        EPMaterials.GadoliniumOxide = new Material.Builder("gadolinium_oxide")
                .dust()
                .color(0xEEEEFF)
                .iconSet(MaterialIconSet.METALLIC)
                .components(GTMaterials.Gadolinium, 2, GTMaterials.Oxygen, 3)
                .buildAndRegister();
        //  24184 Samarium Oxide
        EPMaterials.SamariumOxide = new Material.Builder("samarium_oxide")
                .dust()
                .color(0xFFFFDD)
                .components(GTMaterials.Samarium, 2, GTMaterials.Oxygen, 3)
                .buildAndRegister();
        //  24185 Yttrium Oxide
        EPMaterials.YttriumOxide = new Material.Builder("yttrium_oxide")
                .dust()
                .color(0x78544E)
                .iconSet(MaterialIconSet.SHINY)
                .components(GTMaterials.Yttrium, 2, GTMaterials.Oxygen, 3)
                .buildAndRegister();
        //  24186 Terbium Oxide
        EPMaterials.TerbiumOxide = new Material.Builder("terbium_oxide")
                .dust()
                .color(0xA264A2)
                .iconSet(MaterialIconSet.METALLIC)
                .components(GTMaterials.Terbium, 2, GTMaterials.Oxygen, 3)
                .buildAndRegister();
        //  24187 Dysprosium Oxide
        EPMaterials.DysprosiumOxide = new Material.Builder("dysprosium_oxide")
                .dust()
                .color(0xD273D2)
                .iconSet(MaterialIconSet.METALLIC)
                .components(GTMaterials.Dysprosium, 2, GTMaterials.Oxygen, 3)
                .buildAndRegister();
        //  24188 Holmium Oxide
        EPMaterials.HolmiumOxide = new Material.Builder("holmium_oxide")
                .dust()
                .color(0xAF7F2A)
                .iconSet(MaterialIconSet.SHINY)
                .components(GTMaterials.Holmium, 2, GTMaterials.Oxygen, 3)
                .buildAndRegister();
        //  24189 Erbium Oxide
        EPMaterials.ErbiumOxide = new Material.Builder("erbium_oxide")
                .dust()
                .color(0xE07A32)
                .iconSet(MaterialIconSet.METALLIC)
                .components(GTMaterials.Erbium, 2, GTMaterials.Oxygen, 3)
                .buildAndRegister();
        //  24190 Thulium Oxide
        EPMaterials.ThuliumOxide = new Material.Builder("thulium_oxide")
                .dust()
                .color(0x3B9E8B)
                .components(GTMaterials.Thulium, 2, GTMaterials.Oxygen, 3)
                .buildAndRegister();
        //  24191 Ytterbium Oxide
        EPMaterials.YtterbiumOxide = new Material.Builder("ytterbium_oxide")
                .dust()
                .color(0xA9A9A9)
                .components(GTMaterials.Ytterbium, 2, GTMaterials.Oxygen, 3)
                .buildAndRegister();
        //  24192 Lutetium Oxide
        EPMaterials.LutetiumOxide = new Material.Builder("lutetium_oxide")
                .dust()
                .color(0x11BBFF)
                .iconSet(MaterialIconSet.METALLIC)
                .components(GTMaterials.Lutetium, 2, GTMaterials.Oxygen, 3)
                .buildAndRegister();
        //  24193 Manganese Sulfate
        EPMaterials.ManganeseSulfate = new Material.Builder("manganese_sulfate")
                .dust()
                .color(0xF0F895)
                .iconSet(MaterialIconSet.ROUGH)
                .components(GTMaterials.Manganese, 1, GTMaterials.Sulfur, 1, GTMaterials.Oxygen, 4)
                .buildAndRegister();
        //  24194 Potassium Sulfate
        EPMaterials.PotassiumSulfate = new Material.Builder("potassium_sulfate")
                .dust()
                .color(0xF4FBB0)
                .iconSet(MaterialIconSet.DULL)
                .components(GTMaterials.Potassium, 2, GTMaterials.Sulfur, 1, GTMaterials.Oxygen, 4)
                .buildAndRegister();
        //  24195 Ammonium Cyanate
        EPMaterials.AmmoniumCyanate = new Material.Builder("ammonium_cyanate")
                .fluid()
                .color(0x3a5dcf)
                .components(GTMaterials.Hydrogen, 4, GTMaterials.Nitrogen, 2, GTMaterials.Carbon, 1, GTMaterials.Oxygen, 1)
                .buildAndRegister()
                .setFormula("NH4CNO", true);
        //  24196 Carbamide
        EPMaterials.Carbamide = new Material.Builder("carbamide")
                .dust()
                .color(0x16EF57)
                .iconSet(MaterialIconSet.ROUGH)
                .components(GTMaterials.Carbon, 1, GTMaterials.Hydrogen, 4, GTMaterials.Nitrogen, 2, GTMaterials.Oxygen, 1)
                .buildAndRegister();
        //  24197 Neodymium-Doped Yttrium Oxide
        EPMaterials.NeodymiumDopedYttriumOxide = new Material.Builder("neodymium_doped_yttrium_oxide")
                .dust()
                .color(0x5AD55F)
                .iconSet(MaterialIconSet.DULL)
                .buildAndRegister()
                .setFormula("Nd:Y?", false);
        //  24198 Alumina Solution
        EPMaterials.AluminaSolution = new Material.Builder("alumina_solution")
                .fluid()
                .color(0x6C4DC1)
                .buildAndRegister()
                .setFormula("(Al2O3)(CH2Cl2)(C12H27N)2", true);
        //  24199 Crude Alumina Solution
        EPMaterials.CrudeAluminaSolution = new Material.Builder("crude_alumina_solution")
                .fluid()
                .color(0x8974C1)
                .buildAndRegister()
                .setFormula("(Al(NO3)3)2(CH2Cl2)(C12H27N)", true);
        //  24200 Carbon Tetrachloride
        EPMaterials.CarbonTetrachloride = new Material.Builder("carbon_tetrachloride")
                .fluid()
                .color(0x2d8020)
                .components(GTMaterials.Carbon, 1, GTMaterials.Chlorine, 4)
                .buildAndRegister();
        //  24201 Aluminium Nitrate
        EPMaterials.AluminiumNitrate = new Material.Builder("aluminium_nitrate")
                .dust()
                .color(0x3AB3AA)
                .iconSet(MaterialIconSet.SHINY)
                .components(GTMaterials.Aluminium, 1, GTMaterials.Nitrogen, 3, GTMaterials.Oxygen, 9)
                .buildAndRegister()
                .setFormula("Al(NO3)3", true);
        //  24202 Unprocessed Nd:YAG Solution
        EPMaterials.UnprocessedNdYAGSolution = new Material.Builder("unprocessed_nd_yag_solution")
                .fluid()
                .color(0x6f20af)
                .iconSet(MaterialIconSet.DULL)
                .buildAndRegister()
                .setFormula("Nd:YAG", false);
        //  24203 Nd:YAG
        EPMaterials.NdYAG = new Material.Builder("nd_yag")
                .gem()
                .color(0xD99DE4)
                .iconSet(MaterialIconSet.GEM_VERTICAL)
                .flags(MaterialFlags.CRYSTALLIZABLE, MaterialFlags.DECOMPOSITION_BY_CENTRIFUGING, MaterialFlags.GENERATE_LENS)
                .components(EPMaterials.YttriumOxide, 2, EPMaterials.NeodymiumOxide, 1, EPMaterials.Alumina, 5)
                .buildAndRegister()
                .setFormula("NdY2Al5O12", true);
        //  24204 Au-Pd-C Catalyst
        EPMaterials.AuPdCCatalyst = new Material.Builder("au_pd_c_catalyst")
                .dust()
                .color(0xB7B305)
                .iconSet(MaterialIconSet.SHINY)
                .components(GTMaterials.Gold, 1, EPMaterials.PalladiumOnCarbon, 1)
                .buildAndRegister();
        //  24205 Sodium Oxide
        EPMaterials.SodiumOxide = new Material.Builder("sodium_oxide")
                .dust()
                .color(0x2C96FC)
                .iconSet(MaterialIconSet.BRIGHT)
                .components(GTMaterials.Sodium, 2, GTMaterials.Oxygen, 1)
                .buildAndRegister();
        //  24206 Sodium Tungstate
        EPMaterials.SodiumTungstate = new Material.Builder("sodium_tungstate")
                .fluid()
                .color(0x595E54)
                .components(GTMaterials.Sodium, 1, GTMaterials.Tungsten, 1, GTMaterials.Oxygen, 4)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24207 Sodium Phosphotungstate
        EPMaterials.SodiumPhosphotungstate = new Material.Builder("sodium_phosphotungstate")
                .dust()
                .color(0x4D3635)
                .components(GTMaterials.Oxygen, 40, GTMaterials.Tungsten, 12, GTMaterials.Sodium, 3, GTMaterials.Phosphorus, 1)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .buildAndRegister()
                .setFormula("(WO3)12Na3PO4", true);
        //  24208 Sodium Molybdate
        EPMaterials.SodiumMolybdate = new Material.Builder("sodium_molybdate")
                .dust()
                .color(0xCCCC99)
                .iconSet(MaterialIconSet.ROUGH)
                .components(GTMaterials.Sodium, 2, GTMaterials.Molybdenum, 1, GTMaterials.Oxygen, 4)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24209 Sodium Phosphomolybdate
        EPMaterials.SodiumPhosphomolybdate = new Material.Builder("sodium_phosphomolybdate")
                .dust()
                .color(0xF3E0A8)
                .iconSet(MaterialIconSet.BRIGHT)
                .components(GTMaterials.Oxygen, 40, GTMaterials.Molybdenum, 12, GTMaterials.Sodium, 3, GTMaterials.Phosphorus, 1)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .buildAndRegister()
                .setFormula("(MoO3)12Na3PO4", true);
        //  24210 Sodium Acetate
        EPMaterials.SodiumAcetate = new Material.Builder("sodium_acetate")
                .fluid()
                .color(0xC5D624)
                .components(GTMaterials.SodiumHydroxide, 1, GTMaterials.Ethenone, 1)
                .buildAndRegister()
                .setFormula("C2H3NaO2", true);
        //  24211 Neutron Star Core Material
        EPMaterials.NeutronStarCoreMaterial = new Material.Builder("neutron_star_core_material")
                .ingot()
                .fluid(FluidStorageKeys.LIQUID, new FluidBuilder().temperature(2147483647))
                .color(0x70ecff)
                .iconSet(MaterialIconSet.BRIGHT)
                .flags(MaterialFlags.NO_SMASHING, MaterialFlags.NO_SMELTING, MaterialFlags.GENERATE_PLATE, GENERATE_CURVED_PLATE, MaterialFlags.GENERATE_ROTOR, MaterialFlags.GENERATE_FRAME)
                .buildAndRegister();
        //  24212 Magneto Hydrodynamically Constrained Star Matter
//        MagnetoHydrodynamicallyConstrainedStarMatter = new Material.Builder("magneto_hydrodynamically_constrained_star_matter")
//                .ingot()
//                .fluid(FluidStorageKeys.LIQUID, new FluidBuilder().temperature(600000000))
//                .iconSet(CUSTOM_MHCSM)
//                .flags(NO_SMELTING, GENERATE_PLATE, GENERATE_ROD, GENERATE_LONG_ROD, GENERATE_RING, GENERATE_ROUND, GENERATE_BOLT_SCREW, GENERATE_FRAME, GENERATE_GEAR, GENERATE_SMALL_GEAR)
//                .buildAndRegister();
        //  24213 White Dwarf Matter
        EPMaterials.WhiteDwarfMatter = new Material.Builder("white_dwarf_matter")
                .ingot()
                .fluid(FluidStorageKeys.LIQUID, new FluidBuilder().temperature(288000000))
                .iconSet(MaterialIconSet.MAGNETIC)
                .flags(MaterialFlags.GENERATE_ROD, MaterialFlags.GENERATE_LONG_ROD)
                .buildAndRegister();
        //  24214 BlackDwarfMatter
        EPMaterials.BlackDwarfMatter = new Material.Builder("black_dwarf_matter")
                .ingot()
                .fluid(FluidStorageKeys.LIQUID, new FluidBuilder().temperature(266000000))
                .color(0x000000)
                .iconSet(MaterialIconSet.BRIGHT)
                .cableProperties(GTValues.V[GTValues.UIV], 144, 72, false)
                .buildAndRegister();
        //  24215 Raw Star Matter
        EPMaterials.RawStarMatter = new Material.Builder("raw_star_matter")
                .fluid(FluidStorageKeys.LIQUID, new FluidBuilder().temperature(600000000))
                .buildAndRegister();
        //  24216 Dimensionally Transcendent Residue
        EPMaterials.DimensionallyTranscendentResidue = new Material.Builder("dimensionally_transcendent_residue")
                .fluid(FluidStorageKeys.LIQUID, new FluidBuilder().temperature(999999999))
                .buildAndRegister();
        //  24217 Heavy Lepton Mixture
        EPMaterials.HeavyLeptonMixture = new Material.Builder("heavy_lepton_mixture")
                .fluid(FluidStorageKeys.LIQUID, new FluidBuilder().temperature(524288))
                .buildAndRegister()
                .setFormula(ChatFormatting.OBFUSCATED  + "a" + ChatFormatting.RESET + "§e(t2)u" + ChatFormatting.OBFUSCATED  + "a", true);
        //  24218 Heavy Quarks
        EPMaterials.HeavyQuarks = new Material.Builder("heavy_quarks")
                .fluid(FluidStorageKeys.LIQUID, new FluidBuilder().temperature(131072))
                .buildAndRegister()
                .setFormula(ChatFormatting.OBFUSCATED + "a"  + ChatFormatting.RESET + "§e(u2)ds" + ChatFormatting.OBFUSCATED + "a" , true);
        //  24219 Gluons
        EPMaterials.Gluons = new Material.Builder("gluons")
                .fluid(FluidStorageKeys.LIQUID, new FluidBuilder().temperature(2097152))
                .buildAndRegister()
                .setFormula(ChatFormatting.OBFUSCATED  + "a" + ChatFormatting.RESET + "§eg" + ChatFormatting.OBFUSCATED  + "a", false);
        //  24220 Instantons
        EPMaterials.Instantons = new Material.Builder("instantons")
                .fluid(FluidStorageKeys.LIQUID, new FluidBuilder().temperature(8388608))
                .buildAndRegister()
                .setFormula(ChatFormatting.OBFUSCATED  + "a" + ChatFormatting.RESET + "§ei" + ChatFormatting.OBFUSCATED  + "a", false);
        //  24221 Temporal Fluid
        EPMaterials.TemporalFluid = new Material.Builder("temporal_fluid")
                .fluid(FluidStorageKeys.LIQUID, new FluidBuilder().temperature(134217728))
                .buildAndRegister()
                .setFormula(ChatFormatting.OBFUSCATED  + "a"  + ChatFormatting.RESET + "§et" + ChatFormatting.OBFUSCATED  + "a", false);
        //  24222 Higgs Bosons
        EPMaterials.HiggsBosons = new Material.Builder("higgs_bosons")
                .fluid(FluidStorageKeys.LIQUID, new FluidBuilder().temperature(/*0*/1))
                .buildAndRegister()
                .setFormula(ChatFormatting.OBFUSCATED  + "a" + ChatFormatting.RESET + "§eh" + ChatFormatting.OBFUSCATED + "a", false);
        //  24223 Cosmic Computing Mixture
        EPMaterials.CosmicComputingMixture = new Material.Builder("cosmic_computing_mixture")
                .fluid(FluidStorageKeys.LIQUID, new FluidBuilder().temperature(536870912))
                .components(EPMaterials.HeavyLeptonMixture, 32, EPMaterials.HeavyQuarks, 8, EPMaterials.Gluons, 8, EPMaterials.Instantons, 4, EPMaterials.TemporalFluid, 4, EPMaterials.HiggsBosons, 4)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .buildAndRegister()
                .setFormula(ChatFormatting.OBFUSCATED + "aaaaaa", false);
        //  24224 Silica Gel
        EPMaterials.SilicaGel = new Material.Builder("silica_gel")
                .dust()
                .color(0x9695FD)
                .iconSet(MaterialIconSet.SHINY)
                .components(GTMaterials.Silicon, 1, GTMaterials.Oxygen, 2)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24225 Silica Gel Base
        EPMaterials.SilicaGelBase = new Material.Builder("silica_gel_base")
                .fluid()
                .color(0x9695FD)
                .iconSet(MaterialIconSet.ROUGH)
                .components(GTMaterials.SiliconDioxide, 1, GTMaterials.HydrochloricAcid, 1, GTMaterials.SodiumHydroxide, 1, GTMaterials.Water, 1)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24226 Nitronium Tetrafluoroborate
        EPMaterials.NitroniumTetrafluoroborate = new Material.Builder("nitronium_tetrafluoroborate")
                .dust()
                .color(0x787449)
                .iconSet(MaterialIconSet.DULL)
                .components(GTMaterials.Sodium, 1, GTMaterials.Oxygen, 2, GTMaterials.Boron, 1, GTMaterials.Fluorine, 4)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24227 Nitrosonium Tetrafluoroborate
        EPMaterials.NitrosoniumTetrafluoroborate = new Material.Builder("nitrosonium_tetrafluoroborate")
                .dust()
                .color(0xA32A8C)
                .iconSet(MaterialIconSet.ROUGH)
                .components(GTMaterials.Sodium, 1, GTMaterials.Oxygen, 1, GTMaterials.Boron, 1, GTMaterials.Fluorine, 4)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24228 Tetrafluoroboric Acid
        EPMaterials.TetrafluoroboricAcid = new Material.Builder("tetrafluoroboric_acid")
                .fluid()
                .color(0x83A731)
                .components(GTMaterials.Hydrogen, 1, GTMaterials.Boron, 1, GTMaterials.Fluorine, 4)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24229 Nitrogen Monoxide
        EPMaterials.NitrogenMonoxide = new Material.Builder("nitrogen_monoxide")
                .fluid()
                .color(0x98BCDA)
                .components(GTMaterials.Nitrogen, 1, GTMaterials.Oxygen, 1)
                .buildAndRegister();
        //  24230 Hydroxylammonium Sulfate
        EPMaterials.HydroxylammoniumSulfate = new Material.Builder("hydroxylammonium_sulfate")
                .dust()
                .color(0x999933)
                .iconSet(MaterialIconSet.DULL)
                .components(GTMaterials.Nitrogen, 2, GTMaterials.Hydrogen, 8, GTMaterials.Oxygen, 6, GTMaterials.Sulfur, 1)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .buildAndRegister()
                .setFormula("(NH3OH)2SO4", true);
        //  24231 Potassium Hydroxylaminedisulfonate
        EPMaterials.PotassiumHydroxylaminedisulfonate = new Material.Builder("potassium_hydroxylaminedisulfonate")
                .dust()
                .color(0x627D25)
                .iconSet(MaterialIconSet.ROUGH)
                .components(GTMaterials.Potassium, 2, GTMaterials.Nitrogen, 1, GTMaterials.Hydrogen, 1, GTMaterials.Sulfur, 2, GTMaterials.Oxygen, 7)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24232 Potassium Bisulfite
        EPMaterials.PotassiumBisulfite = new Material.Builder("potassium_bisulfite")
                .dust()
                .color(344314)
                .iconSet(MaterialIconSet.DULL)
                .components(GTMaterials.Potassium, 1, GTMaterials.Hydrogen, 1, GTMaterials.Sulfur, 1, GTMaterials.Oxygen, 3)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24233 Potassium Carbonate
        EPMaterials.PotassiumCarbonate = new Material.Builder("potassium_carbonate")
                .dust()
                .color(0x7C89D9)
                .iconSet(MaterialIconSet.ROUGH)
                .components(GTMaterials.Potassium, 2, GTMaterials.Carbon, 1, GTMaterials.Oxygen, 3)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24234 Nitrous Acid
        EPMaterials.NitrousAcid = new Material.Builder("nitrous_acid")
                .fluid(FluidStorageKeys.LIQUID, new FluidBuilder().attribute(FluidAttributes.ACID))
                .color(0x7D82A3)
                .components(GTMaterials.Hydrogen, 1, GTMaterials.Nitrogen, 1, GTMaterials.Oxygen, 2)
                .buildAndRegister();
        //  24235 Potassium Nitrite
        EPMaterials.PotassiumNitrite = new Material.Builder("potassium_nitrite")
                .dust()
                .color(0xB9B9B9)
                .components(GTMaterials.Potassium, 1, GTMaterials.Nitrogen, 1, GTMaterials.Oxygen, 2)
                .buildAndRegister();
        //  24236 Barium Dichloride
        EPMaterials.BariumDichloride = new Material.Builder("barium_dichloride")
                .dust()
                .color(0xBF6700)
                .iconSet(MaterialIconSet.BRIGHT)
                .components(GTMaterials.Barium, 1, GTMaterials.Chlorine, 2)
                .buildAndRegister();
        //  24237 Hydroxylamine Hydrochloride
        EPMaterials.HydroxylamineHydrochloride = new Material.Builder("hydroxylamine_hydrochloride")
                .fluid()
                .color(0x893E28)
                .components(GTMaterials.Hydrogen, 4, GTMaterials.Oxygen, 1, GTMaterials.Nitrogen, 1, GTMaterials.Chlorine,1 )
                .buildAndRegister()
                .setFormula("HONH2HCl", true);
        //  24238 Barium Sulfate Suspension
        EPMaterials.BariumSulfateSuspension = new Material.Builder("barium_sulfate_suspension")
                .fluid()
                .color(0x71560B)
                .components(GTMaterials.Barium, 1, GTMaterials.Sulfur, 1, GTMaterials.Oxygen, 4, GTMaterials.Water, 1)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24239 Ammonium Acetate
        EPMaterials.AmmoniumAcetate = new Material.Builder("ammonium_acetate")
                .dust()
                .color(0x646882)
                .components(GTMaterials.Carbon, 2, GTMaterials.Hydrogen, 7, GTMaterials.Oxygen, 2, GTMaterials.Nitrogen, 1)
                .buildAndRegister()
                .setFormula("NH4CH3CO2", true);
        //  24240 Ammonium Carbonate
        EPMaterials.AmmoniumCarbonate = new Material.Builder("ammonium_carbonate")
                .dust()
                .color(0x7C89D9)
                .components(GTMaterials.Carbon, 1, GTMaterials.Hydrogen, 8, GTMaterials.Oxygen, 3, GTMaterials.Nitrogen, 2)
                .buildAndRegister()
                .setFormula("(NH4)2CO3", true);
        //  24241 Free Electron Gas
        EPMaterials.FreeElectronGas = new Material.Builder("free_electron_gas")
                .gas()
                .color(0x507BB3)
                .buildAndRegister()
                .setFormula(ChatFormatting.OBFUSCATED  + "a" + ChatFormatting.RESET + "§ee" + ChatFormatting.OBFUSCATED + "a", false);
        //  24242 Quark Gluon Plasma
        EPMaterials.QuarkGluonPlasma = new Material.Builder("quark_gluon_plasma")
                .fluid(FluidStorageKeys.PLASMA, new FluidBuilder().temperature((int) (GTValues.V[GTValues.ZPM] + GTValues.V[GTValues.UHV])/2))
                .color(EPMaterials.HeavyQuarks.getMaterialRGB() + EPMaterials.Gluons.getMaterialRGB())
                .buildAndRegister()
                .setFormula(ChatFormatting.OBFUSCATED  + "a" + ChatFormatting.RESET + "§e(u2)d(c2)s(t2)bg" + ChatFormatting.OBFUSCATED + "a", false);
        //  24243 Light Quarks
        EPMaterials.LightQuarks = new Material.Builder("light_quarks")
                .fluid(FluidStorageKeys.LIQUID, new FluidBuilder().temperature((GTValues.VA[GTValues.ZPM] + GTValues.VA[GTValues.UHV])/2))
                .color(EPMaterials.QuarkGluonPlasma.getMaterialRGB() - EPMaterials.HeavyQuarks.getMaterialRGB())
                .buildAndRegister()
                .setFormula(ChatFormatting.OBFUSCATED  + "a" + ChatFormatting.RESET + "§e(c2)(t2)b" + ChatFormatting.OBFUSCATED + "a", false);
        //  24244 Ferric Catalyst
        EPMaterials.FerricCatalyst = new Material.Builder("ferric_catalyst")
                .dust()
                .color(EPMaterials.FerricOxide.getMaterialRGB() + EPMaterials.HydrogenPeroxide.getMaterialRGB())
                .components(EPMaterials.FerricOxide, 1, EPMaterials.HydrogenPeroxide, 1)
                .buildAndRegister();
        //  24245 Neutron
        EPMaterials.Neutron = new Material.Builder("neutron")
                .fluid(FluidStorageKeys.PLASMA, new FluidBuilder().temperature((int) GTValues.V[GTValues.UXV]))
                .color(0xFCFCFC)
                .buildAndRegister()
                .setFormula(ChatFormatting.OBFUSCATED  + "a" + ChatFormatting.RESET + "n§e" + ChatFormatting.OBFUSCATED + "a", false);
        //  24246 Helium-Neon Gas
        EPMaterials.HeliumNeon = new Material.Builder("helium_neon")
                .gas()
                .color(0xFF0080)
                .flags(MaterialFlags.DECOMPOSITION_BY_CENTRIFUGING)
                .components(GTMaterials.Helium, 1, GTMaterials.Neon, 1)
                .buildAndRegister();
        //  24247 Polonium Nitrate
        EPMaterials.PoloniumNitrate = new Material.Builder("polonium_nitrate")
                .fluid()
                .color(GTMaterials.Polonium.getMaterialRGB() + GTMaterials.NitricAcid.getMaterialRGB())
                .components(GTMaterials.Polonium, 1, GTMaterials.Nitrogen, 4, GTMaterials.Oxygen, 12)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .buildAndRegister()
                .setFormula("Po(NO3)4", true);
        //  24248 Polonium Chloride
        EPMaterials.PoloniumChloride = new Material.Builder("polonium_chloride")
                .dust()
                .color(GTMaterials.Polonium.getMaterialRGB() + GTMaterials.Chlorine.getMaterialRGB())
                .components(GTMaterials.Polonium, 1, GTMaterials.Chlorine, 2)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24249 Celestite
        EPMaterials.Celestite = new Material.Builder("celestite")
                .gem()
                .color(0x4AE3E6)
                .iconSet(MaterialIconSet.OPAL)
                .components(GTMaterials.Strontium, 1, GTMaterials.Sulfur, 1, GTMaterials.Oxygen, 4)
                .flags(MaterialFlags.CRYSTALLIZABLE, MaterialFlags.DISABLE_DECOMPOSITION, MaterialFlags.GENERATE_LENS)
                .buildAndRegister();
        //  24250 Strontium Carbonate
        EPMaterials.StrontiumCarbonate = new Material.Builder("strontium_carbonate")
                .dust()
                .color(0x1DAFD3)
                .iconSet(MaterialIconSet.SAND)
                .components(GTMaterials.Strontium, 1, GTMaterials.Carbon, 1, GTMaterials.Oxygen, 3)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24251 Strontium Oxide
        EPMaterials.StrontiumOxide = new Material.Builder("stronium_oxide")
                .dust()
                .color(0x16839E)
                .iconSet(MaterialIconSet.BRIGHT)
                .components(GTMaterials.Strontium, 1, GTMaterials.Oxygen, 1)
                .buildAndRegister();
        //  24252 Acidic Pyrochlore
        EPMaterials.AcidicPyrochlore = new Material.Builder("acidic_pyrochlore")
                .dust()
                .color(GTMaterials.Pyrochlore.getMaterialRGB() + GTMaterials.SulfuricAcid.getMaterialRGB())
                .iconSet(MaterialIconSet.SHINY)
                .components(GTMaterials.Pyrochlore, 1, GTMaterials.SulfuricAcid, 1)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24253 Thorium-Uranium Solution
        EPMaterials.ThoriumUraniumSolution = new Material.Builder("thorium_uranium_solution")
                .fluid()
                .color(GTMaterials.Thorium.getMaterialRGB() + GTMaterials.Uranium235.getMaterialRGB())
                .iconSet(MaterialIconSet.DULL)
                .buildAndRegister()
                .setFormula("?SO4", true);
        //  24254 Leaching Pyrochlore
        EPMaterials.LeachingPyrochlore = new Material.Builder("leaching_pyrochlore")
                .dust()
                .color(0xE2502C)
                .iconSet(MaterialIconSet.BRIGHT)
                .buildAndRegister()
                .setFormula("(Nb2O5)9Ta2O5?", true);
        //  24255 Barium-Strontium-Radium Solution
        EPMaterials.BariumStrontiumRadiumSolution = new Material.Builder("barium_strontium_radium_solution")
                .fluid()
                .color(GTMaterials.Barite.getMaterialRGB())
                .components(GTMaterials.Barite, 1, GTMaterials.Gypsum, 1, EPMaterials.Celestite, 1, GTMaterials.Radium, 1, GTMaterials.Water, 4)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24256 Fluoroniobic Acid
        EPMaterials.FluoroniobicAcid = new Material.Builder("fluoroniobic_acid")
                .fluid(FluidStorageKeys.LIQUID, new FluidBuilder().attribute(FluidAttributes.ACID))
                .color(GTMaterials.Niobium.getMaterialRGB() + GTMaterials.HydrofluoricAcid.getMaterialRGB())
                .components(GTMaterials.Niobium, 1, GTMaterials.Hydrogen, 1, GTMaterials.Fluorine, 7)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24257 Oxypentafluoroniobate
        EPMaterials.Oxypentafluoroniobate = new Material.Builder("oxypentafluoroniobate")
                .fluid()
                .color(0x17F742)
                .components(GTMaterials.Hydrogen, 2, GTMaterials.Niobium, 1, GTMaterials.Oxygen, 1, GTMaterials.Fluorine, 5)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24258 Heptafluorotantalate
        EPMaterials.Heptafluorotantalate = new Material.Builder("heptafluorotantalate")
                .fluid()
                .color(0x16EB3F)
                .components(GTMaterials.Hydrogen, 2, GTMaterials.Tantalum, 1, GTMaterials.Fluorine, 7)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24259 Potassium Fluoride
        EPMaterials.PotassiumFluoride = new Material.Builder("potassium_fluoride")
                .dust()
                .color(GTMaterials.Potassium.getMaterialRGB() + GTMaterials.Fluorine.getMaterialRGB())
                .iconSet(MaterialIconSet.ROUGH)
                .components(GTMaterials.Potassium, 1, GTMaterials.Fluorine, 1)
                .buildAndRegister();
        //  24260 Potassium Fluoniobate
        EPMaterials.PotassiumFluoniobate = new Material.Builder("potassium_fluoniobate")
                .dust()
                .color(EPMaterials.PotassiumFluoride.getMaterialRGB() + EPMaterials.FluoroniobicAcid.getMaterialRGB())
                .iconSet(MaterialIconSet.BRIGHT)
                .components(GTMaterials.Potassium, 2, GTMaterials.Niobium, 1, GTMaterials.Fluorine, 7)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24261 Potassium Fluotantalate
        EPMaterials.PotassiumFluotantalate = new Material.Builder("potassium_fluotantalate")
                .dust()
                .color(GTMaterials.Tantalum.getMaterialRGB() + EPMaterials.PotassiumFluoniobate.getMaterialRGB())
                .iconSet(MaterialIconSet.BRIGHT)
                .components(GTMaterials.Potassium, 2, GTMaterials.Tantalum, 1, GTMaterials.Fluorine, 7)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24262 Uranium Thorium Nitrate
        EPMaterials.UraniumThoriumNitrate = new Material.Builder("uranium_thorium_nitrate")
                .dust()
                .color(GTMaterials.Uranium238.getMaterialRGB() + GTMaterials.Thorium.getMaterialRGB() + GTMaterials.Nitrogen.getMaterialRGB())
                .iconSet(MaterialIconSet.SHINY)
                .buildAndRegister()
                .setFormula("UO2(NO3)2Th(NO3)4", true);
        //  24263 Uranium Oxide Thorium Nitrate
        EPMaterials.UraniumOxideThoriumNitrate = new Material.Builder("uranium_oxide_thorium_nitrate")
                .dust()
                .color(GTMaterials.Uranium238.getMaterialRGB() + GTMaterials.Oxygen.getMaterialRGB())
                .iconSet(MaterialIconSet.SHINY)
                .buildAndRegister()
                .setFormula("UO2Th(NO3)4", true);
        //  24264 Thorium Nitrate Solution
        EPMaterials.ThoriumNitrateSolution = new Material.Builder("thorium_nitrate_solution")
                .fluid()
                .color(GTMaterials.Thorium.getMaterialRGB())
                .buildAndRegister()
                .setFormula("Th(NO3)4(H2O)", true);
        //  24265 Thorium Oxide
        EPMaterials.ThoriumOxide = new Material.Builder("thorium_oxide")
                .dust()
                .color(GTMaterials.Thorium.getMaterialRGB() + GTMaterials.Oxygen.getMaterialRGB())
                .components(GTMaterials.Thorium, 1, GTMaterials.Oxygen, 1)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24266 Gold Copper Mixture
        EPMaterials.GoldCopperMixture = new Material.Builder("gold_copper_mixture")
                .dust()
                .color(0xD2D242)
                .iconSet(MaterialIconSet.SHINY)
                .components(GTMaterials.Copper, 3, GTMaterials.Gold, 1)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .buildAndRegister()
                .setFormula("Cu3Au?", true);
        //  24267 Leaching Gold
        EPMaterials.LeachingGold = new Material.Builder("leaching_gold")
                .dust()
                .color(0xA7650F)
                .iconSet(MaterialIconSet.ROUGH)
                .components(GTMaterials.Copper, 3, GTMaterials.Gold, 1)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .buildAndRegister()
                .setFormula("Cu3Au?", true);
        //  24268 Chloroauric Acid
        EPMaterials.ChloroauricAcid = new Material.Builder("chloroauric_acid")
                .fluid()
                .color(EPMaterials.LeachingGold.getMaterialRGB() + GTMaterials.HydrochloricAcid.getMaterialRGB())
                .components(GTMaterials.Hydrogen, 1, GTMaterials.Gold, 1, GTMaterials.Chlorine, 1)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .buildAndRegister()
                .setFormula("HAuCl?", false);
        //  24269 Leaching Copper
        EPMaterials.LeachingCopper = new Material.Builder("leaching_copper")
                .dust()
                .color(GTMaterials.Copper.getMaterialRGB() + EPMaterials.LeachingGold.getMaterialRGB())
                .iconSet(MaterialIconSet.SHINY)
                .components(GTMaterials.Copper, 3)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .buildAndRegister()
                .setFormula("Cu3?", true);
        //  24270 Potassium Metabisulfite
        EPMaterials.PotassiumMetabisulfite = new Material.Builder("potassium_metabisulfite")
                .dust()
                .color(GTMaterials.Potassium.getMaterialRGB() + GTMaterials.Sulfur.getMaterialRGB())
                .iconSet(MaterialIconSet.SAND)
                .components(GTMaterials.Potassium, 2, GTMaterials.Sulfur, 2, GTMaterials.Oxygen, 5)
                .buildAndRegister();
        //  24271 Platinum Metal
        EPMaterials.PlatinumMetal = new Material.Builder("platinum_metal")
                .dust()
                .color(GTMaterials.PlatinumRaw.getMaterialRGB())
                .iconSet(MaterialIconSet.SAND)
                .components(GTMaterials.Platinum, 1)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .buildAndRegister()
                .setFormula("Pt?", false);
        //  24272 Platinum Slag
        EPMaterials.PlatinumSlag = new Material.Builder("platinum_slag")
                .dust()
                .color(GTMaterials.PlatinumRaw.getMaterialRGB())
                .iconSet(MaterialIconSet.DULL)
                .components(GTMaterials.Platinum, 1)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .buildAndRegister()
                .setFormula("Pt?", false);
        //  24273 Palladium Metal
        EPMaterials.PalladiumMetal = new Material.Builder("palladium_metal")
                .dust()
                .color(GTMaterials.Palladium.getMaterialRGB())
                .iconSet(MaterialIconSet.DULL)
                .components(GTMaterials.Palladium, 1)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .buildAndRegister()
                .setFormula("Pd?", false);
        //  24274 Concentrate Platinum
        EPMaterials.ConcentratePlatinum = new Material.Builder("concentrate_platinum")
                .fluid()
                .color(GTMaterials.Platinum.getMaterialRGB())
                .iconSet(MaterialIconSet.DULL)
                .components(GTMaterials.Platinum, 1)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .buildAndRegister()
                .setFormula("Pt?", false);
        //  24275 Crude Platinum
        EPMaterials.CrudePlatinum = new Material.Builder("crude_platinum")
                .dust()
                .color(GTMaterials.PlatinumRaw.getMaterialRGB())
                .iconSet(MaterialIconSet.SAND)
                .components(GTMaterials.Platinum, 1, GTMaterials.Chlorine, 2)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .buildAndRegister()
                .setFormula("PtCl2?", true);
        //  24276 Palladium Rich Ammonia
        EPMaterials.PalladiumRichAmmonia = new Material.Builder("palladium_rich_ammonia")
                .gas()
                .color(GTMaterials.Palladium.getMaterialRGB() + GTMaterials.Ammonia.getMaterialRGB())
                .components(GTMaterials.Palladium, 1, GTMaterials.Ammonia, 1)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .buildAndRegister()
                .setFormula("Pd(NH3)?", true);
        //  24277 Iridium Dioxide
        EPMaterials.IridiumDioxide = new Material.Builder("iridium_dioxide")
                .dust()
                .color(GTMaterials.Iridium.getMaterialRGB() + GTMaterials.Oxygen.getMaterialRGB())
                .iconSet(MaterialIconSet.SAND)
                .components(GTMaterials.Iridium, 1, GTMaterials.Oxygen, 2)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24278 Acidic Iridium Solution
        EPMaterials.AcidicIridiumSolution = new Material.Builder("acidic_iridium_solution")
                .fluid()
                .color(EPMaterials.IridiumDioxide.getMaterialRGB() + GTMaterials.HydrochloricAcid.getMaterialRGB())
                .components(EPMaterials.IridiumDioxide, 2, GTMaterials.HydrochloricAcid, 2)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24279 Osmium Tetrachloride
        EPMaterials.OsmiumTetrachloride = new Material.Builder("osmium_tetrachloride")
                .dust()
                .color(0x29080A)
                .iconSet(MaterialIconSet.METALLIC)
                .components(GTMaterials.Osmium, 1, GTMaterials.Chlorine, 4)
                .buildAndRegister();
        //  24280 Ruthenium Chloride
        EPMaterials.RutheniumChloride = new Material.Builder("ruthenium_chloride")
                .dust()
                .color(0x605C6C)
                .iconSet(MaterialIconSet.METALLIC)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .components(GTMaterials.Ruthenium, 1, GTMaterials.Chlorine, 3)
                .buildAndRegister();
        //  24281 Sodium Peroxide
        EPMaterials.SodiumPeroxide = new Material.Builder("sodium_peroxide")
                .dust()
                .color(0xECFF80)
                .iconSet(MaterialIconSet.ROUGH)
                .components(GTMaterials.Sodium, 2, GTMaterials.Oxygen, 2)
                .buildAndRegister();
        //  24282 Rhodium Oxide
        EPMaterials.RhodiumOxide = new Material.Builder("rhodium_oxide")
                .dust()
                .color(0xD93D16)
                .iconSet(MaterialIconSet.METALLIC)
                .components(GTMaterials.Rhodium, 2, GTMaterials.Oxygen, 3)
                .buildAndRegister();
        //  24283 Platinum Group Sludge Solution
        EPMaterials.PlatinumGroupSludgeSolution = new Material.Builder("platinum_group_sludge_solution")
                .fluid()
                .color(GTMaterials.PlatinumGroupSludge.getMaterialRGB())
                .iconSet(MaterialIconSet.DULL)
                .buildAndRegister();
        //  24284 Ammonium Hexachloro Platinum Group Sludge
        EPMaterials.AmmoniumHexachloroPlatinumGroupSludge = new Material.Builder("ammonium_hexachloro_platinum_group_sludge")
                .fluid()
                .color(0xFEF0C2)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24285 Leaching Nickel
        EPMaterials.LeachingNickel = new Material.Builder("leaching_nickel")
                .dust()
                .color(EPMaterials.LeachingCopper.getMaterialRGB() + GTMaterials.Nickel.getMaterialRGB())
                .iconSet(MaterialIconSet.BRIGHT)
                .components(GTMaterials.Nickel, 3)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .buildAndRegister()
                .setFormula("Ni3?", true);
        //  24286 Gold Nickel Mixture
        EPMaterials.GoldNickelMixture = new Material.Builder("gold_nickel_mixture")
                .dust()
                .color(EPMaterials.GoldCopperMixture.getMaterialRGB() + GTMaterials.Nickel.getMaterialRGB())
                .iconSet(MaterialIconSet.SAND)
                .components(GTMaterials.Nickel, 3, GTMaterials.Gold, 1)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .buildAndRegister()
                .setFormula("Ni3Au?", true);
        //  24287 Lanthanum Fullerene Mixture
        EPMaterials.LanthanumFullereneMixture = new Material.Builder("lanthanum_fullerene_mixture")
                .dust()
                .color(0xD26D8E)
                .iconSet(MaterialIconSet.BRIGHT)
                .components(GTMaterials.Lanthanum, 2, EPMaterials.GeodesicPolyarene, 2)
                .buildAndRegister();
        //  24288 Lanthanum Embedded Fullerene
        EPMaterials.LanthanumEmbeddedFullerene = new Material.Builder("lanthanum_embedded_fullerene")
                .dust()
                .color(0x84FFAC)
                .iconSet(MaterialIconSet.BRIGHT)
                .components(GTMaterials.Lanthanum, 2, EPMaterials.GeodesicPolyarene, 2)
                .buildAndRegister();
        //  24289 Lanthanum Fullerene Nanotube
        EPMaterials.LanthanumFullereneNanotube = new Material.Builder("lanthanum_fullerene_nanotube")
                .ingot()
                .color(0xD24473)
                .iconSet(MaterialIconSet.BRIGHT)
                .components(GTMaterials.Lanthanum, 2, EPMaterials.GeodesicPolyarene, 2, EPMaterials.CarbonNanotube, 1)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24290 HRA Magnesium
        EPMaterials.HRAMagnesium = new Material.Builder("hra_magnesium")
                .dust()
                .color(GTMaterials.Magnesium.getMaterialRGB())
                .iconSet(MaterialIconSet.SHINY)
                .components(GTMaterials.Magnesium, 1)
                .buildAndRegister();
        //  24291 Cadium Bromide
        EPMaterials.CadmiumBromide = new Material.Builder("cadmium_bromide")
                .dust()
                .color(0xFF1774)
                .iconSet(MaterialIconSet.SHINY)
                .components(GTMaterials.Cadmium, 1, GTMaterials.Bromine, 2)
                .buildAndRegister();
        //  24292 Magnesium Bromide
        EPMaterials.MagnesiumBromide = new Material.Builder("magnesium_bromide")
                .dust()
                .color(0x5F4C32)
                .iconSet(MaterialIconSet.METALLIC)
                .components(GTMaterials.Magnesium, 1, GTMaterials.Bromine, 2)
                .buildAndRegister();
        //  24293 Oganesson Breeding Base
        EPMaterials.OganessonBreedingBase = new Material.Builder("oganesson_breeding_base")
                .fluid()
                .color(0xA65A7F)
                .components(GTMaterials.Oganesson, 1)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24294 Hot Oganesson
        EPMaterials.HotOganesson = new Material.Builder("hot_oganesson")
                .fluid(FluidStorageKeys.LIQUID, new FluidBuilder().temperature(14118))
                .color(GTMaterials.Oganesson.getMaterialRGB())
                .components(GTMaterials.Oganesson, 1)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24295 Dragon Dust
        EPMaterials.DragonDust = new Material.Builder("dragon_dust")
                .ore(1, 1, true)
                .addOreByproducts(GTMaterials.Amethyst)
                .dust()
                .color(EPMaterials.Draconium.getMaterialRGB())
                .iconSet(MaterialIconSet.DULL)
                .buildAndRegister()
                .setFormula("Dc3Ac3Se4At4?", false);
        //  24296 Californium Nitrite
        EPMaterials.CaliforniumNitrite = new Material.Builder("californium_nitrite")
                .dust()
                .color(0x914626)
                .iconSet(MaterialIconSet.ROUGH)
                .components(GTMaterials.Californium, 1, GTMaterials.Nitrogen, 3, GTMaterials.Oxygen, 6)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .buildAndRegister()
                .setFormula("Cf(NO2)3", true);
        //  24297 Californium Dioxide
        EPMaterials.CaliforniumDioxide = new Material.Builder("californium_dioxide")
                .dust()
                .color(0x912D01)
                .iconSet(MaterialIconSet.DULL)
                .components(GTMaterials.Californium, 1, GTMaterials.Oxygen, 2)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24298 Californium Hexachloride
        EPMaterials.CaliforniumHexachloride = new Material.Builder("californium_hexachloride")
                .fluid()
                .color(GTMaterials.Californium.getMaterialRGB() + GTMaterials.Chlorine.getMaterialRGB())
                .components(GTMaterials.Californium, 2, GTMaterials.Chlorine, 6)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24299 Californium Hexafluoride
        EPMaterials.CaliforniumHexafluoride = new Material.Builder("californium_hexafluoride")
                .gas()
                .color(GTMaterials.Californium.getMaterialRGB() + GTMaterials.Fluorine.getMaterialRGB())
                .components(GTMaterials.Californium, 2, GTMaterials.Fluorine, 6)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24300 Californium-252 Hexafluoride
        EPMaterials.Californium252Hexafluoride = new Material.Builder("californium_252_hexafluoride")
                .gas()
                .color(EPMaterials.Californium252.getMaterialRGB() + GTMaterials.Fluorine.getMaterialRGB())
                .components(EPMaterials.Californium252, 2, GTMaterials.Fluorine, 6)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24301 Steam Cracked Californium-252 Hexafluoride
        EPMaterials.SteamCrackedCalifornium252Hexafluoride = new Material.Builder("steam_cracked_californium_252_hexafluoride")
                .gas()
                .color(EPMaterials.Californium252Hexafluoride.getMaterialRGB() + GTMaterials.Steam.getMaterialRGB())
                .components(EPMaterials.Californium252, 2, GTMaterials.Fluorine, 6)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24302 Californium-252 Dioxide
        EPMaterials.Californium252Dioxide = new Material.Builder("californium_252_dioxide")
                .dust()
                .color(0x912D01)
                .iconSet(MaterialIconSet.ROUGH)
                .components(EPMaterials.Californium252, 1, GTMaterials.Oxygen, 2)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24303 Actinium Draconium Hydroxides
        EPMaterials.ActiniumDraconiumHydroxides = new Material.Builder("actinium_draconium_hydroxides")
                .dust()
                .color(0xB613BF)
                .iconSet(MaterialIconSet.ROUGH)
                .components(EPMaterials.Draconium, 3, GTMaterials.Actinium, 2, GTMaterials.Oxygen, 12, GTMaterials.Hydrogen, 12)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .buildAndRegister()
                .setFormula("Dc3Ac3(OH)12", true);
        //  24304 Actinium Nitrate
        EPMaterials.ActiniumNitrate = new Material.Builder("actinium_nitrate")
                .dust()
                .color(GTMaterials.Actinium.getMaterialRGB() + GTMaterials.NitricAcid.getMaterialRGB())
                .iconSet(MaterialIconSet.ROUGH)
                .components(GTMaterials.Actinium, 1, GTMaterials.Nitrogen, 3, GTMaterials.Oxygen, 9)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .buildAndRegister()
                .setFormula("Ac(NO3)3", true);
        //  24305 Radium Nitrate
        EPMaterials.RadiumNitrate = new Material.Builder("radium_nitrate")
                .dust()
                .color(GTMaterials.Radium.getMaterialRGB() + GTMaterials.NitricAcid.getMaterialRGB())
                .iconSet(MaterialIconSet.SHINY)
                .components(GTMaterials.Radium, 1, GTMaterials.Nitrogen, 2, GTMaterials.Oxygen, 6)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .buildAndRegister()
                .setFormula("Ra(NO3)2", true);
        //  24306 Caesium Carborane
        EPMaterials.CaesiumCarborane = new Material.Builder("caesium_carborane")
                .dust()
                .color(GTMaterials.Caesium.getMaterialRGB() + GTMaterials.Carbon.getMaterialRGB())
                .iconSet(MaterialIconSet.DULL)
                .components(GTMaterials.Caesium, 1, GTMaterials.Carbon, 1, GTMaterials.Boron, 11, GTMaterials.Hydrogen, 12)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24307 Silver Nitrate
        EPMaterials.SilverNitrate = new Material.Builder("silver_nitrate")
                .dust()
                .color(GTMaterials.Silver.getMaterialRGB() + GTMaterials.NitricAcid.getMaterialRGB())
                .iconSet(MaterialIconSet.SHINY)
                .components(GTMaterials.Silver, 1, GTMaterials.Nitrogen, 1, GTMaterials.Oxygen, 3)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24308 Caesium Nitrate
        EPMaterials.CaesiumNitrate = new Material.Builder("caesium_nitrate")
                .dust()
                .color(GTMaterials.Caesium.getMaterialRGB() + GTMaterials.NitricAcid.getMaterialRGB())
                .iconSet(MaterialIconSet.ROUGH)
                .components(GTMaterials.Caesium, 1, GTMaterials.Nitrogen, 1, GTMaterials.Oxygen, 3)
                .flags(MaterialFlags.DECOMPOSITION_BY_ELECTROLYZING)
                .buildAndRegister();
        //  24309 Silver Iodide
        EPMaterials.SilverIodide = new Material.Builder("silver_iodide")
                .dust()
                .iconSet(MaterialIconSet.SHINY)
                .color(GTMaterials.Silver.getMaterialRGB() + GTMaterials.Iodine.getMaterialRGB())
                .components(GTMaterials.Silver, 1, GTMaterials.Iodine, 1)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24310 Caesium Hydroxide
        EPMaterials.CaesiumHydroxide = new Material.Builder("caesium_hydroxide")
                .dust()
                .color(GTMaterials.Caesium.getMaterialRGB() + GTMaterials.Hydrogen.getMaterialRGB() + GTMaterials.Oxygen.getMaterialRGB())
                .components(GTMaterials.Caesium, 1, GTMaterials.Oxygen, 1, GTMaterials.Hydrogen, 1)
                .flags(MaterialFlags.DECOMPOSITION_BY_ELECTROLYZING)
                .buildAndRegister();
        //  24311 Sodium Tetrafluoroborate
        EPMaterials.SodiumTetrafluoroborate = new Material.Builder("sodium_tetrafluoroborate")
                .dust()
                .color(GTMaterials.Sodium.getMaterialRGB() + EPMaterials.BoronTrifluoride.getMaterialRGB())
                .iconSet(MaterialIconSet.SAND)
                .components(GTMaterials.Sodium, 1, GTMaterials.Boron, 1, GTMaterials.Fluorine, 4)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24312 Sodium Borohydride
        EPMaterials.SodiumBorohydride = new Material.Builder("sodium_borohydride")
                .dust()
                .color(GTMaterials.Sodium.getMaterialRGB() + GTMaterials.Boron.getMaterialRGB())
                .iconSet(MaterialIconSet.ROUGH)
                .components(GTMaterials.Sodium, 1, GTMaterials.Boron, 1, GTMaterials.Hydrogen, 4)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24313 Sodium Ethoxide
        EPMaterials.SodiumEthoxide = new Material.Builder("sodium_ethoxide")
                .dust()
                .color(GTMaterials.Sodium.getMaterialRGB() + GTMaterials.Ethanol.getMaterialRGB())
                .iconSet(MaterialIconSet.DULL)
                .components(GTMaterials.Carbon, 2, GTMaterials.Hydrogen, 5, GTMaterials.Oxygen, 1, GTMaterials.Sodium, 1)
                .buildAndRegister();
        //  24314 Krypton Difluoride
        EPMaterials.KryptonDifluoride = new Material.Builder("krypton_difluoride")
                .gas()
                .color(GTMaterials.Krypton.getMaterialRGB() + GTMaterials.Fluorine.getMaterialRGB())
                .components(GTMaterials.Krypton, 1, GTMaterials.Fluorine, 2)
                .buildAndRegister();
        //  24315 Draconium Tetrafluoride
        EPMaterials.DraconiumTetrafluoride = new Material.Builder("draconium_tetrafluoride")
                .dust()
                .color(0xBA16A6)
                .iconSet(MaterialIconSet.DULL)
                .components(EPMaterials.Draconium, 1, GTMaterials.Fluorine, 4)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24316 Actinium Oxalate
        EPMaterials.ActiniumOxalate = new Material.Builder("actinium_oxalate")
                .dust()
                .color(0x7971BF)
                .iconSet(MaterialIconSet.SHINY)
                .components(GTMaterials.Actinium, 1, GTMaterials.Carbon, 4, GTMaterials.Oxygen, 8)
                .buildAndRegister()
                .setFormula("Ac(CO2)4", true);
        //  24317 Actinium Hydride
        EPMaterials.ActiniumHydride = new Material.Builder("actinium_hydride")
                .dust()
                .color(0x86DAF0)
                .iconSet(MaterialIconSet.BRIGHT)
                .components(GTMaterials.Actinium, 1, GTMaterials.Hydrogen, 3)
                .buildAndRegister();
        //  24318 Actinium Superhydride
        EPMaterials.ActiniumSuperhydride = new Material.Builder("actinium_superhydride")
                .dust()
                .plasma()
                .color(0xCC3300)
                .iconSet(MaterialIconSet.BRIGHT)
                .components(GTMaterials.Actinium, 1, GTMaterials.Hydrogen, 12)
                .buildAndRegister();
        //  24319 Francium Carbide
        EPMaterials.FranciumCarbide = new Material.Builder("francium_carbide")
                .dust()
                .color(GTMaterials.Francium.getMaterialRGB() + GTMaterials.Carbon.getMaterialRGB())
                .iconSet(MaterialIconSet.SHINY)
                .components(GTMaterials.Francium, 2, GTMaterials.Carbon, 2)
                .buildAndRegister();
        //  24320 Boron Francium Mixture
        EPMaterials.BoronFranciumMixture = new Material.Builder("boron_francium_mixture")
                .dust()
                .color(GTMaterials.Boron.getMaterialRGB() + EPMaterials.FranciumCarbide.getMaterialRGB())
                .iconSet(MaterialIconSet.BRIGHT)
                .components(EPMaterials.FranciumCarbide, 2, EPMaterials.CubicBoronNitride, 1, EPMaterials.AmorphousBoronNitride, 1)
                .buildAndRegister();
        //  24321 Flerovium-Ytterbium Plasma
        EPMaterials.FleroviumYtterbiumPlasma = new Material.Builder("flerovium_ytterbium_plasma")
                .fluid(FluidStorageKeys.PLASMA, new FluidBuilder().temperature(300))
                .components(EPMaterials.MetastableFlerovium, 1, EPMaterials.Ytterbium178, 1)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24322 Solar-Grade Silicon
        EPMaterials.SolarGradeSilicon = new Material.Builder("solar_grade_silicon")
                .ingot()
                .color(GTMaterials.Silicon.getMaterialRGB())
                .iconSet(MaterialIconSet.BRIGHT)
                .components(GTMaterials.Silicon, 1)
                .buildAndRegister();
        //  24323 Dense Hydrazine Mixture Fuel
        EPMaterials.DenseHydrazineMixtureFuel = new Material.Builder("dense_hydrazine_mixture_fuel")
                .fluid()
                .color(0x912565)
                .components(GTMaterials.Dimethylhydrazine, 1, GTMaterials.Methanol, 1)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24324 Highly Purified Coal Tar
        EPMaterials.HighlyPurifiedCoalTar = new Material.Builder("highly_purified_coal_tar")
                .fluid()
                .color(0x7F811D)
                .components(GTMaterials.CoalTar, 1)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24325 RP-1 Rocket Fuel
        EPMaterials.RP1RocketFuel = new Material.Builder("rp_1_rocket_fuel")
                .fluid()
                .color(0xFB2A08)
                .components(EPMaterials.HighlyPurifiedCoalTar, 1, GTMaterials.Oxygen/*LiquidOxygen*/, 1)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24326 Methylhydrazine
        EPMaterials.Methylhydrazine = new Material.Builder("methylhydrazine")
                .fluid()
                .color(0x321452)
                .components(GTMaterials.Carbon, 1, GTMaterials.Hydrogen, 6, GTMaterials.Nitrogen, 2)
                .buildAndRegister();
        //  24327 Methylhydrazine Nitrate Rocket Fuel
        EPMaterials.MethylhydrazineNitrateRocketFuel = new Material.Builder("methylhydrazine_nitrate_rocket_fuel")
                .fluid()
                .color(0x607186)
                .components(EPMaterials.Methylhydrazine, 1, GTMaterials.Tetranitromethane, 1)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24328 Lithium Niobate
        EPMaterials.LithiumNiobate = new Material.Builder("lithium_niobate")
                .ingot()
                .color(0xD27700)
                .iconSet(MaterialIconSet.SHINY)
                .components(GTMaterials.Lithium, 1, GTMaterials.Niobium, 1, GTMaterials.Oxygen, 4)
                .blastTemp(6700)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .flags(MaterialFlags.GENERATE_PLATE, MaterialFlags.GENERATE_LENS)
                .buildAndRegister();
        //  24329 Niobium Pentachloride
        EPMaterials.NiobiumPentachloride = new Material.Builder("niobium_pentachloride")
                .dust()
                .color(GTMaterials.Niobium.getMaterialRGB() + GTMaterials.Chlorine.getMaterialRGB())
                .iconSet(MaterialIconSet.SHINY)
                .components(GTMaterials.Niobium, 1, GTMaterials.Chlorine, 5)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24330 High Purity Sodium Vanadate
        EPMaterials.HighPuritySodiumVanadate = new Material.Builder("high_purity_sodium_vanadate")
                .dust()
                .color(0xE3E147)
                .iconSet(MaterialIconSet.BRIGHT)
                .components(GTMaterials.Sodium, 3, GTMaterials.Vanadium, 1, GTMaterials.Oxygen, 4)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24331 Lutetium Thulium Yttrium Chlorides Solution
        EPMaterials.LutetiumThuliumYttriumChloridesSolution = new Material.Builder("lutetium_thulium_yttrium_chlorides_solution")
                .fluid()
                .color(GTMaterials.Lutetium.getMaterialRGB() + GTMaterials.Thulium.getMaterialRGB() + GTMaterials.Yttrium.getMaterialRGB())
                .components(GTMaterials.Lutetium, 2, GTMaterials.Thulium, 2, GTMaterials.Yttrium, 6, GTMaterials.Chlorine, 30, GTMaterials.Hydrogen, 30, GTMaterials.Oxygen, 15)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .buildAndRegister()
                .setFormula("(LuCl3)2(TmCl3)2(YCl3)6(H2O)15", true);
        //  24332 Lu-Tm-droped Yttrium Vanadate Deposition
        EPMaterials.YttriumVanadateLuTmDeposition = new Material.Builder("yttrium_vanadate_lu_tm_deposition")
                .dust()
                .color(GTMaterials.Yttrium.getMaterialRGB() + GTMaterials.Vanadium.getMaterialRGB() + GTMaterials.Lutetium.getMaterialRGB() + GTMaterials.Thulium.getMaterialRGB())
                .iconSet(MaterialIconSet.DULL)
                .buildAndRegister()
                .setFormula("Lu/TM:YVO?", false);
        //  24333 Lu-Tm-droped Yttrium Vanadate
        EPMaterials.YttriumVanadateLuTm = new Material.Builder("yttrium_vanadate_lu_tm")
                .gem()
                .color(0x8C1B23)
                .iconSet(MaterialIconSet.GEM_HORIZONTAL)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION, MaterialFlags.GENERATE_LENS, MaterialFlags.CRYSTALLIZABLE)
                .components(GTMaterials.Yttrium, 1, GTMaterials.Vanadium, 1, GTMaterials.Oxygen, 1, GTMaterials.Lutetium, 1, GTMaterials.Thulium, 1)
                .buildAndRegister()
                .setFormula("Lu/Tm:YVO", false);
        //  24334 Heavy Quark Enriched Mixture
        EPMaterials.HeavyQuarkEnrichedMixture = new Material.Builder("heavy_quark_enriched_mixture")
                .fluid()
                .color(EPMaterials.HeavyQuarks.getMaterialRGB() + EPMaterials.LightQuarks.getMaterialRGB())
                .components(EPMaterials.LightQuarks, 1, EPMaterials.HeavyQuarks, 3)
                .flags(MaterialFlags.DECOMPOSITION_BY_CENTRIFUGING)
                .buildAndRegister()
                .setFormula(ChatFormatting.OBFUSCATED  + "a"  + ChatFormatting.RESET + "§e(u2)d(c2)s(t2)b" + ChatFormatting.OBFUSCATED  + "a" , true);
        //  24335 Deuterium-Superheavy Mixture
        EPMaterials.DeuteriumSuperHeavyMixture = new Material.Builder("deuterium_superheavy_mixture")
                .fluid()
                .color(0x7B9F8E)
                .components(GTMaterials.Deuterium, 2, EPMaterials.MetastableHassium, 1, EPMaterials.MetastableFlerovium, 1, EPMaterials.MetastableOganesson, 1)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24336 Heavy Quark Degenerate Matter
        EPMaterials.HeavyQuarkDegenerateMatter = new Material.Builder("heavy_quark_degenerate_matter")
                .ingot()
                .fluid()
                .plasma()
                .color(0x5DBD3A)
                .iconSet(MaterialIconSet.BRIGHT)
                .blastTemp(12960, BlastProperty.GasTier.HIGHEST, GTValues.VA[GTValues.UEV])
                .flags(MaterialFlags.DISABLE_DECOMPOSITION, MaterialFlags.GENERATE_PLATE)
                .buildAndRegister();
        //  24337 Fullerene Polymer Matrix
        EPMaterials.FullerenePolymerMatrix = new Material.Builder("fullerene_polymer_matrix")
                .fluid(FluidStorageKeys.LIQUID, new FluidBuilder().temperature(500))
                .polymer()
                .color(0x2F0B01)
                .iconSet(MaterialIconSet.SHINY)
                .components(GTMaterials.Lead, 1, GTMaterials.Iron, 1, GTMaterials.Carbon, 153, GTMaterials.Hydrogen, 36, GTMaterials.Nitrogen, 1, GTMaterials.Oxygen, 2)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION, MaterialFlags.NO_SMASHING, MaterialFlags.NO_SMELTING, MaterialFlags.GENERATE_PLATE, MaterialFlags.GENERATE_FOIL)
                .buildAndRegister();
        //  24338 Radium-Radon Mixture
        EPMaterials.RadiumRadonMixture = new Material.Builder("radium_radon_mixture")
                .fluid()
                .color(GTMaterials.Radium.getMaterialRGB() + GTMaterials.Radon.getMaterialRGB())
                .components(GTMaterials.Radium, 1, GTMaterials.Radon, 1)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24339 Scandium-Titanium Mixture
        EPMaterials.ScandiumTitaniumMixture = new Material.Builder("scandium_titanium_mixture")
                .fluid()
                .color(GTMaterials.Scandium.getMaterialRGB() + GTMaterials.Titanium.getMaterialRGB())
                .components(GTMaterials.Scandium, 1, GTMaterials.Titanium, 1)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24340 Caesium Iodide
        EPMaterials.CaesiumIodide = new Material.Builder("caesium_iodide")
                .dust()
                .color(GTMaterials.Caesium.getMaterialRGB() + GTMaterials.Iodine.getMaterialRGB())
                .iconSet(MaterialIconSet.SHINY)
                .components(GTMaterials.Caesium, 1, GTMaterials.Iodine, 1)
                .buildAndRegister();
        //  24341 Tl-Tm-Droped Caesium Iodide
        EPMaterials.TlTmDropedCaesiumIodide = new Material.Builder("tl_tm_droped_caesium_iodide")
                .dust()
                .color(GTMaterials.Thallium.getMaterialRGB() + GTMaterials.Thulium.getMaterialRGB() + EPMaterials.CaesiumIodide.getMaterialRGB())
                .iconSet(MaterialIconSet.BRIGHT)
                .components(GTMaterials.Thallium, 1, GTMaterials.Thulium, 1, EPMaterials.CaesiumIodide, 1)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .buildAndRegister()
                .setFormula("Tl/Tm:CsI");
        //  24342 Cadmium Tungstate
        EPMaterials.CadmiumTungstate = new Material.Builder("cadmium_tungstate")
                .dust()
                .color(GTMaterials.Cadmium.getMaterialRGB() + GTMaterials.Tungsten.getMaterialRGB())
                .iconSet(MaterialIconSet.BRIGHT)
                .components(GTMaterials.Cadmium, 1, GTMaterials.Tungsten, 1, GTMaterials.Oxygen, 4)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24343 Bismuth Germanate
        EPMaterials.BismuthGermanate = new Material.Builder("bismuth_germanate")
                .dust()
                .color(GTMaterials.Bismuth.getMaterialRGB() + GTMaterials.Germanium.getMaterialRGB())
                .iconSet(MaterialIconSet.ROUGH)
                .components(GTMaterials.Bismuth, 12, GTMaterials.Germanium, 1, GTMaterials.Oxygen, 20)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  24344 Iodine Monochloride
        EPMaterials.IodineMonochloride = new Material.Builder("iodine_monochloride")
                .fluid()
                .color(GTMaterials.Iodine.getMaterialRGB() + GTMaterials.Chlorine.getMaterialRGB())
                .components(GTMaterials.Iodine, 1, GTMaterials.Chlorine, 1)
                .buildAndRegister();
        //  24345 Magnesium Chloride Bromide
        EPMaterials.MagnesiumChlorideBromide = new Material.Builder("magnesium_chloride_bromide")
                .dust()
                .color(GTMaterials.Magnesium.getMaterialRGB() + GTMaterials.Chlorine.getMaterialRGB() + GTMaterials.Bromine.getMaterialRGB())
                .components(GTMaterials.Magnesium, 1, GTMaterials.Chlorine, 1, GTMaterials.Bromine, 1)
                .buildAndRegister();
        //  24346 Rh-Re-Nq Catalyst
        EPMaterials.RhReNqCatalyst = new Material.Builder("rh_re_nq_catalyst")
                .dust()
                .color(GTMaterials.Rhodium.getMaterialRGB() + GTMaterials.Rhenium.getMaterialRGB() + GTMaterials.Naquadah.getMaterialRGB())
                .iconSet(MaterialIconSet.SHINY)
                .components(GTMaterials.Rhodium, 1, GTMaterials.Rhenium, 1, GTMaterials.Naquadah, 1)
                .buildAndRegister();
        //  24347 Lithium Titanate
        EPMaterials.LithiumTitanate = new Material.Builder("lithium_titanate")
                .ingot()
                .fluid()
                .color(0xFE71A9)
                .iconSet(MaterialIconSet.SHINY)
                .blastTemp(3100)
                .components(GTMaterials.Lithium, 2, GTMaterials.Titanium, 1, GTMaterials.Oxygen, 3)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION, MaterialFlags.GENERATE_FINE_WIRE)
                .buildAndRegister();
        //  24348 Titanium Nitrate
        EPMaterials.TitaniumNitrate = new Material.Builder("titanium_nitrate")
                .dust()
                .color(GTMaterials.Titanium.getMaterialRGB() + GTMaterials.NitricAcid.getMaterialRGB())
                .iconSet(MaterialIconSet.DULL)
                .components(GTMaterials.Titanium, 1, GTMaterials.Nitrogen, 4, GTMaterials.Oxygen, 12)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .buildAndRegister()
                .setFormula("Ti(NO3)4", true);

        //  24349 PalladiumLoadedRutileNanoparticles

    }
}
