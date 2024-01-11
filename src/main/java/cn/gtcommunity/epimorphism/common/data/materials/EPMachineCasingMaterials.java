package cn.gtcommunity.epimorphism.common.data.materials;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconSet;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.BlastProperty;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.ToolProperty;
import com.gregtechceu.gtceu.api.fluids.FluidBuilder;
import com.gregtechceu.gtceu.api.fluids.store.FluidStorageKeys;
import com.gregtechceu.gtceu.api.item.tool.GTToolType;
import com.gregtechceu.gtceu.common.data.GTMaterials;

import static cn.gtcommunity.epimorphism.api.chemical.material.info.EPMaterialFlags.*;
import static cn.gtcommunity.epimorphism.common.data.EPMaterials.*;

public class EPMachineCasingMaterials {
    public static void register() {
        //  24501 Inconel-625
        Inconel625 = new Material.Builder("inconel_625")
                .ingot()
                .fluid(FluidStorageKeys.LIQUID, new FluidBuilder().temperature(3700))
                .fluidPipeProperties(5500, 340, true, true, true, false)
                .color(0x3fcc60)
                .iconSet(MaterialIconSet.METALLIC)
                .flags(MaterialFlags.GENERATE_PLATE, MaterialFlags.GENERATE_ROD, MaterialFlags.GENERATE_RING, MaterialFlags.GENERATE_BOLT_SCREW, MaterialFlags.GENERATE_GEAR, GENERATE_CURVED_PLATE, MaterialFlags.GENERATE_ROTOR)
                .blastTemp(4850, BlastProperty.GasTier.HIGHEST, GTValues.VA[GTValues.IV], 1000)
                .components(GTMaterials.Nickel, 8, /*Chrome, 6, */GTMaterials.Molybdenum, 4, GTMaterials.Niobium, 4, GTMaterials.Titanium, 3, GTMaterials.Iron, 2, GTMaterials.Aluminium, 2)
                .buildAndRegister();
        //  24502 Hastelloy-N
        HastelloyN = new Material.Builder("hastelloy_n")
                .ingot()
                .fluid(FluidStorageKeys.LIQUID, new FluidBuilder().temperature(3980))
                .color(0x939554)
                .iconSet(MaterialIconSet.DULL)
                .flags(MaterialFlags.GENERATE_GEAR, MaterialFlags.GENERATE_BOLT_SCREW, MaterialFlags.GENERATE_ROTOR, MaterialFlags.GENERATE_FRAME, GENERATE_CURVED_PLATE)
                .blastTemp(4550, BlastProperty.GasTier.HIGHER, GTValues.VA[GTValues.EV], 800)
                .components(GTMaterials.Nickel, 15, GTMaterials.Molybdenum, 4, /*Chrome, 2, */GTMaterials.Titanium, 2, GTMaterials.Yttrium, 2)
                .buildAndRegister();
        //  24503 Stellite
        Stellite = new Material.Builder("stellite")
                .ingot()
                .fluid(FluidStorageKeys.LIQUID, new FluidBuilder().temperature(4110))
                .color(0x9991A5)
                .iconSet(MaterialIconSet.METALLIC)
                .blastTemp(4310, BlastProperty.GasTier.HIGHER, GTValues.VA[GTValues.EV], 1200)
                .components(/*Chrome, 9, */GTMaterials.Cobalt, 9, GTMaterials.Manganese, 5, GTMaterials.Titanium, 2)
                .flags(MaterialFlags.GENERATE_PLATE, MaterialFlags.GENERATE_ROD, MaterialFlags.GENERATE_FRAME, MaterialFlags.GENERATE_GEAR, MaterialFlags.GENERATE_SMALL_GEAR)
                .buildAndRegister();
        //  24504 Quantum Alloy
        QuantumAlloy = new Material.Builder("quantum_alloy")
                .ingot()
                .fluid()
                .color(0x0F0F0F)
                .iconSet(MaterialIconSet.SHINY)
                .blastTemp(10800, BlastProperty.GasTier.HIGHEST, GTValues.VA[GTValues.UHV], 1600)
                .components(Stellite, 15, GTMaterials.Emerald, 5, GTMaterials.Gallium, 5, GTMaterials.Americium, 5, GTMaterials.Germanium, 5, GTMaterials.TitaniumTungstenCarbide, 5)
                .cableProperties(GTValues.V[GTValues.UHV], 24, 0, true)
                .flags(MaterialFlags.GENERATE_PLATE, MaterialFlags.GENERATE_FOIL, MaterialFlags.GENERATE_FINE_WIRE)
                .buildAndRegister();
        //  24505 Grisium
        Grisium = new Material.Builder("grisium")
                .ingot()
                .fluid()
                .color(0x355D6A)
                .iconSet(MaterialIconSet.METALLIC)
                .blastTemp(11800, BlastProperty.GasTier.HIGHEST, GTValues.VA[GTValues.UEV], 2000)
                .components(BETSPerrhenate, 1, /*Trinaquadalloy, 4, */Vibranium, 2, Taranium, 1, GTMaterials.TitaniumCarbide, 9, GTMaterials.Potassium, 9, GTMaterials.Lithium, 9, GTMaterials.Sulfur, 6)
                .flags(MaterialFlags.GENERATE_FINE_WIRE)
                .cableProperties(GTValues.V[GTValues.UEV], 48, 0, true)
                .buildAndRegister();
        //  24506 HDCS (High Durability Compound Steel)
        Hdcs = new Material.Builder("hdcs")
                .ingot()
                .fluid()
                .color(0x334433)
                .iconSet(MaterialIconSet.SHINY)
                .toolStats(new ToolProperty(20.0F, 10.0F, 18000, 18, GTToolType.getTypes().values().toArray(GTToolType[]::new)))
                .blastTemp(11900, BlastProperty.GasTier.HIGHEST, GTValues.VA[GTValues.UEV], 2400)
                .components(GTMaterials.TungstenSteel, 12, GTMaterials.HSSS, 9, GTMaterials.HSSG, 6, GTMaterials.Ruridit, 3, MagnetoResonatic, 2, GTMaterials.Plutonium241, 1)
                .flags(MaterialFlags.GENERATE_PLATE, MaterialFlags.GENERATE_ROD, MaterialFlags.GENERATE_LONG_ROD, MaterialFlags.GENERATE_RING, MaterialFlags.GENERATE_ROUND, MaterialFlags.GENERATE_BOLT_SCREW, MaterialFlags.GENERATE_FRAME, MaterialFlags.GENERATE_GEAR, MaterialFlags.GENERATE_SMALL_GEAR)
                .buildAndRegister();
        //  24507 Abyssalloy
        Abyssalloy = new Material.Builder("abyssalloy")
                .ingot()
                .fluid()
                .color(0x9E706A)
                .iconSet(MaterialIconSet.METALLIC)
                .blastTemp(9625, BlastProperty.GasTier.HIGHEST, GTValues.VA[GTValues.UEV], 2250)
                .components(GTMaterials.StainlessSteel, 5, GTMaterials.TungstenCarbide, 5, GTMaterials.Nichrome, 5, GTMaterials.IncoloyMA956, 5, GTMaterials.Germanium, 1, GTMaterials.Rutherfordium, 1, GTMaterials.Radon, 1)
                .cableProperties(GTValues.V[GTValues.UEV], 64, 64, false)
                .flags(MaterialFlags.GENERATE_FINE_WIRE, MaterialFlags.GENERATE_PLATE)
                .buildAndRegister();
        //  24508 Lafium
        Lafium = new Material.Builder("lafium")
                .ingot()
                .fluid()
                .color(0x0D0D60)
                .iconSet(MaterialIconSet.SHINY)
                .blastTemp(9865, BlastProperty.GasTier.HIGHEST, GTValues.VA[GTValues.UEV], 1860)
                .components(HastelloyN, 8, GTMaterials.Naquadria, 4, GTMaterials.Samarium, 2, GTMaterials.Tungsten, 4, GTMaterials.Aluminium, 6, GTMaterials.Nickel, 8, GTMaterials.Titanium, 4, GTMaterials.Carbon, 2, GTMaterials.Argon, 2)
                .fluidPipeProperties(23000, 8000, true, true, true, true)
                .buildAndRegister();
        //  24509 Black Titanium
        BlackTitanium = new Material.Builder("black_titanium")
                .ingot()
                .fluid()
                .color(0x6C003B)
                .iconSet(MaterialIconSet.SHINY)
                .blastTemp(11500, BlastProperty.GasTier.HIGHEST, GTValues.VA[GTValues.UEV], 4580)
                .flags(MaterialFlags.GENERATE_PLATE, MaterialFlags.GENERATE_ROD, MaterialFlags.GENERATE_FRAME)
                .components(GTMaterials.Titanium, 26, GTMaterials.Lanthanum, 6, GTMaterials.TungstenSteel, 4, GTMaterials.Cobalt, 3, GTMaterials.Manganese, 2, GTMaterials.Phosphorus, 2, GTMaterials.Palladium, 2, GTMaterials.Niobium, 1, GTMaterials.Argon, 5)
                .toolStats(new ToolProperty(9.0F, 30.0F, 32000, 20, GTToolType.getTypes().values().toArray(GTToolType[]::new)))
                .buildAndRegister();
        //  24510 Talonite
        Talonite = new Material.Builder("talonite")
                .ingot()
                .fluid()
                .color(0x9991A5)
                .iconSet(MaterialIconSet.SHINY)
                .blastTemp(3454)
                .flags(MaterialFlags.GENERATE_PLATE)
                .components(GTMaterials.Cobalt, 4,/* Chrome, 3, */GTMaterials.Phosphorus, 2, GTMaterials.Molybdenum, 1)
                .buildAndRegister();
        //  24511 Black Plutonium
        BlackPlutonium = new Material.Builder("black_plutonium")
                .ingot()
                .fluid()
                .color(0x060606)
                .iconSet(MaterialIconSet.BRIGHT)
                .blastTemp(12960, BlastProperty.GasTier.HIGHEST, GTValues.VA[GTValues.UHV], 3600)
                .flags(MaterialFlags.GENERATE_PLATE, MaterialFlags.GENERATE_ROD, MaterialFlags.GENERATE_FRAME)
                .components(Plutonium244, 18, GTMaterials.Cerium, 9, GTMaterials.Gadolinium, 3, GTMaterials.Dysprosium, 3, GTMaterials.Thulium, 2, GTMaterials.TungstenCarbide, 6, GTMaterials.RedSteel, 6, GTMaterials.Duranium, 2, GTMaterials.Radon, 2)
                .buildAndRegister();
        //  24512 Maraging Steel-250
        MaragingSteel250 = new Material.Builder("maraging_steel_250")
                .ingot()
                .fluid()
                .color(0xA5ADB2)
                .iconSet(MaterialIconSet.SHINY)
                .blastTemp(2413, BlastProperty.GasTier.MID, GTValues.VA[GTValues.EV], 680)
                .flags(MaterialFlags.GENERATE_PLATE, MaterialFlags.GENERATE_ROD, MaterialFlags.GENERATE_FRAME, MaterialFlags.GENERATE_GEAR)
                .components(GTMaterials.Steel, 16, GTMaterials.Molybdenum, 1, GTMaterials.Titanium, 1, GTMaterials.Nickel, 4, GTMaterials.Cobalt, 2)
                .buildAndRegister();
        //  24513 Staballoy
        Staballoy = new Material.Builder("staballoy")
                .ingot()
                .fluid()
                .color(0x444B42)
                .iconSet(MaterialIconSet.SHINY)
                .blastTemp(3450, BlastProperty.GasTier.HIGH, GTValues.VA[GTValues.EV], 462)
                .flags(MaterialFlags.GENERATE_PLATE, MaterialFlags.GENERATE_ROD, MaterialFlags.GENERATE_FRAME, GENERATE_CURVED_PLATE, MaterialFlags.GENERATE_ROTOR)
                .components(GTMaterials.Uranium238, 9, GTMaterials.Titanium, 1)
                .buildAndRegister();
        //  24514 Babbitt Alloy
        BabbittAlloy = new Material.Builder("babbitt_alloy")
                .ingot()
                .fluid()
                .color(0xA19CA4)
                .iconSet(MaterialIconSet.SHINY)
                .components(GTMaterials.Tin, 5, GTMaterials.Lead, 36, GTMaterials.Antimony, 8, GTMaterials.Astatine, 1)
                .blastTemp(737, BlastProperty.GasTier.MID, GTValues.VA[GTValues.MV], 214)
                .flags(MaterialFlags.GENERATE_PLATE, MaterialFlags.GENERATE_ROD, MaterialFlags.GENERATE_FRAME)
                .buildAndRegister();
        //  24515 Zirconium Carbide
        ZirconiumCarbide = new Material.Builder("zirconium_carbide")
                .ingot()
                .fluid()
                .color(0xFFDACD)
                .iconSet(MaterialIconSet.SHINY)
                .components(GTMaterials.Zirconium, 1, GTMaterials.Carbon, 1)
                .blastTemp(1200, BlastProperty.GasTier.MID, GTValues.VA[GTValues.HV], 344)
                .flags(MaterialFlags.GENERATE_PLATE, MaterialFlags.GENERATE_ROD, MaterialFlags.GENERATE_FRAME)
                .buildAndRegister();
        //  24516 Inconel-792
        Inconel792 = new Material.Builder("inconel_792")
                .ingot()
                .fluid()
                .color(0x6CF076)
                .iconSet(MaterialIconSet.SHINY)
                .components(GTMaterials.Nickel, 2, GTMaterials.Niobium, 1, GTMaterials.Aluminium, 2, GTMaterials.Nichrome, 1)
                .blastTemp(6200, BlastProperty.GasTier.HIGHER, GTValues.VA[GTValues.IV], 1266)
                .flags(MaterialFlags.GENERATE_PLATE, MaterialFlags.GENERATE_ROD, MaterialFlags.GENERATE_BOLT_SCREW, GENERATE_CURVED_PLATE, MaterialFlags.GENERATE_ROTOR)
                .fluidPipeProperties(4900, 220, true, true, true, false)
                .buildAndRegister();
        //  24517 Incoloy-MA813
        IncoloyMA813 = new Material.Builder("incoloy_ma_813")
                .ingot()
                .fluid()
                .color(0x6CF076)
                .iconSet(MaterialIconSet.SHINY)
                .components(GTMaterials.VanadiumSteel, 4, GTMaterials.Osmiridium, 2, GTMaterials.HSSS, 3, GTMaterials.Germanium, 4, GTMaterials.Duranium, 5, GTMaterials.Dubnium, 1)
                .blastTemp(9900, BlastProperty.GasTier.HIGHEST, GTValues.VA[GTValues.ZPM], 1277)
                .flags(MaterialFlags.GENERATE_PLATE, MaterialFlags.GENERATE_ROD, MaterialFlags.GENERATE_BOLT_SCREW, MaterialFlags.GENERATE_FRAME)
                .buildAndRegister();
        //  24518 Hastelloy-X78
        HastelloyX78 = new Material.Builder("hastelloy_x_78")
                .ingot()
                .fluid()
                .color(0x6BA3E3)
                .iconSet(MaterialIconSet.SHINY)
                .blastTemp(12800, BlastProperty.GasTier.HIGHEST, GTValues.VA[GTValues.UHV], 4997)
                .components(GTMaterials.NaquadahAlloy, 10, GTMaterials.Rhenium, 5, GTMaterials.Naquadria, 4, GTMaterials.Gadolinium, 3, GTMaterials.Strontium, 2, GTMaterials.Polonium, 3, GTMaterials.Rutherfordium, 2, GTMaterials.Fermium, 1)
                .flags(MaterialFlags.GENERATE_PLATE, MaterialFlags.GENERATE_ROD, MaterialFlags.GENERATE_FRAME)
                .buildAndRegister();
        //  24519 Hastelloy-K243
        HastelloyK243 = new Material.Builder("hastelloy_k_243")
                .ingot()
                .fluid()
                .color(0xa4ff70)
                .iconSet(MaterialIconSet.BRIGHT)
                .blastTemp(12400, BlastProperty.GasTier.HIGHEST, GTValues.VA[GTValues.UEV], 5032)
                .components(HastelloyX78, 5, GTMaterials.NiobiumNitride, 2, GTMaterials.Tritanium, 4, GTMaterials.TungstenCarbide, 4, GTMaterials.Promethium, 4, GTMaterials.Mendelevium, 1)
                .buildAndRegister();
        //  24520 Mar-M200 Steel
        MARM200Steel = new Material.Builder("mar_m_200_steel")
                .ingot()
                .fluid()
                .color(0x515151)
                .iconSet(MaterialIconSet.SHINY)
                .blastTemp(5000, BlastProperty.GasTier.HIGHER, GTValues.VA[GTValues.IV], 200)
                .components(GTMaterials.Niobium, 2, /*Chrome, 9, */GTMaterials.Aluminium, 5, GTMaterials.Titanium, 2, GTMaterials.Cobalt, 10, GTMaterials.Tungsten, 13, GTMaterials.Nickel, 18)
                .flags(MaterialFlags.GENERATE_PLATE, GENERATE_CURVED_PLATE, MaterialFlags.GENERATE_ROTOR, MaterialFlags.GENERATE_ROD, MaterialFlags.GENERATE_FRAME)
                .buildAndRegister();
        //  24521 Mar-M200-Ce Steel
        MARM200CeSteel = new Material.Builder("mar_m_200_ce_steel")
                .ingot()
                .fluid()
                .color(0x383030)
                .iconSet(MaterialIconSet.BRIGHT)
                .blastTemp(7500, BlastProperty.GasTier.HIGHEST, GTValues.VA[GTValues.LuV], 432)
                .components(MARM200Steel, 18, GTMaterials.Cerium, 1)
                .flags(MaterialFlags.GENERATE_PLATE)
                .buildAndRegister();
        //  24522 Tanmolyium Beta-C
        TanmolyiumBetaC = new Material.Builder("tanmolyium_beta_c")
                .ingot()
                .fluid()
                .color(0xc72fcc)
                .iconSet(MaterialIconSet.METALLIC)
                .blastTemp(5300, BlastProperty.GasTier.HIGHER, GTValues.VA[GTValues.IV], 180)
                .components(GTMaterials.Titanium, 5, GTMaterials.Molybdenum, 5, GTMaterials.Vanadium, 2, /*Chrome, 3, */GTMaterials.Aluminium, 1)
                .flags(MaterialFlags.GENERATE_PLATE, MaterialFlags.GENERATE_ROD, MaterialFlags.GENERATE_GEAR, MaterialFlags.GENERATE_SMALL_GEAR)
                .buildAndRegister();
        //  24523 Hastelloy-C59
        HastelloyC59 = new Material.Builder("hastelloy_c_59")
                .ingot()
                .fluid()
                .color(0xD6D0F0)
                .iconSet(MaterialIconSet.DULL)
                .blastTemp(7600, BlastProperty.GasTier.HIGHER, GTValues.VA[GTValues.LuV], 559)
                .components(GTMaterials.Nickel, 18, /*Chrome, 16, */GTMaterials.TinAlloy, 8, GTMaterials.Cobalt, 6, GTMaterials.Niobium, 4, GTMaterials.Aluminium, 4, GTMaterials.Silicon, 2, GTMaterials.Phosphorus, 2)
                .flags(MaterialFlags.GENERATE_PLATE, MaterialFlags.GENERATE_ROD, MaterialFlags.GENERATE_FRAME)
                .buildAndRegister();
        //  24524 HMS-1J79 Alloy
        HMS1J79Alloy = new Material.Builder("hms_1_j_79_alloy")
                .ingot()
                .fluid()
                .color(0xD1CB0B)
                .iconSet(MaterialIconSet.SHINY)
                .blastTemp(8100, BlastProperty.GasTier.HIGHEST, GTValues.VA[GTValues.LuV], 886)
                .components(GTMaterials.Nickel, 14, GTMaterials.Iron, 12, GTMaterials.Molybdenum, 11, GTMaterials.CobaltBrass, 8, /*Chrome, 6, */GTMaterials.Silicon, 4)
                .flags(MaterialFlags.GENERATE_PLATE)
                .buildAndRegister();
        //  24525 High Strength Structural Steel-HY130-1
        HY1301 = new Material.Builder("hy_1301")
                .ingot()
                .fluid()
                .color(0x6F3E57)
                .iconSet(MaterialIconSet.SHINY)
                .blastTemp(7850, BlastProperty.GasTier.HIGHER, GTValues.VA[GTValues.LuV], 766)
                .components(GTMaterials.Nickel, 9, GTMaterials.NickelZincFerrite, 6, /*Chrome, 4, */GTMaterials.Nichrome, 4, GTMaterials.Iron, 4, GTMaterials.Molybdenum, 4, GTMaterials.Rhenium, 2, GTMaterials.Silicon, 1)
                .flags(MaterialFlags.GENERATE_PLATE, MaterialFlags.GENERATE_ROD, MaterialFlags.GENERATE_GEAR, MaterialFlags.GENERATE_SMALL_GEAR)
                .buildAndRegister();
        //  24526 Super Austenitic Stainless Steel-904L
        AusteniticStainlessSteel904L = new Material.Builder("super_austenitic_stainless_steel_904_l")
                .ingot()
                .fluid()
                .color(0x881357)
                .iconSet(MaterialIconSet.METALLIC)
                .blastTemp(4960, BlastProperty.GasTier.MID, GTValues.VA[GTValues.EV], 344)
                .components(GTMaterials.StainlessSteel, 8, GTMaterials.NickelZincFerrite, 4, GTMaterials.Kanthal, 4, GTMaterials.Molybdenum, 4)
                .flags(MaterialFlags.GENERATE_PLATE, MaterialFlags.GENERATE_ROD, MaterialFlags.GENERATE_FRAME, MaterialFlags.GENERATE_BOLT_SCREW)
                .buildAndRegister();
        //  24527 Eglin Steel Base
        EglinSteelBase = new Material.Builder("eglin_steel_base")
                .dust()
                .color(0x8B4513)
                .iconSet(MaterialIconSet.SAND)
                .components(GTMaterials.Iron, 4, GTMaterials.Kanthal, 1, GTMaterials.Invar, 5)
                .buildAndRegister();
        //  24528 Eglin Steel
        EglinSteel = new Material.Builder("eglin_steel")
                .ingot()
                .fluid()
                .color(0x8B4513)
                .iconSet(MaterialIconSet.METALLIC)
                .components(EglinSteelBase, 10, GTMaterials.Sulfur, 1, GTMaterials.Silicon, 1, GTMaterials.Carbon, 1)
                .blastTemp(1048, BlastProperty.GasTier.LOW, GTValues.VA[GTValues.MV], 24)
                .flags(MaterialFlags.GENERATE_ROD, MaterialFlags.GENERATE_LONG_ROD, MaterialFlags.GENERATE_FRAME)
                .buildAndRegister();
        //  24529 Pikyonium-64B
        Pikyonium64B = new Material.Builder("pikyonium_64_b")
                .ingot()
                .fluid()
                .color(0x3467BA)
                .iconSet(MaterialIconSet.SHINY)
                .blastTemp(10400, BlastProperty.GasTier.HIGHEST, GTValues.VA[GTValues.ZPM], 2487)
                .components(Inconel792, 8, EglinSteel, 5, GTMaterials.NaquadahAlloy, 4, GTMaterials.TungstenSteel, 4, GTMaterials.Cerium, 3, GTMaterials.Antimony, 2, GTMaterials.Platinum, 2, GTMaterials.Ytterbium, 1)
                .flags(MaterialFlags.GENERATE_PLATE, MaterialFlags.GENERATE_ROD, MaterialFlags.GENERATE_LONG_ROD, MaterialFlags.GENERATE_SPRING, MaterialFlags.GENERATE_SPRING_SMALL)
                .buildAndRegister();
        //  24530 Cinobite
        Cinobite = new Material.Builder("cinobite")
                .ingot()
                .fluid()
                .color(0x010101)
                .iconSet(MaterialIconSet.SHINY)
                .blastTemp(11465, BlastProperty.GasTier.HIGHEST, GTValues.VA[GTValues.UV], 3608)
                .components(GTMaterials.Zeron100, 8, GTMaterials.Stellite100, 6, GTMaterials.Titanium, 6, GTMaterials.Naquadria, 4, GTMaterials.Osmiridium, 3, GTMaterials.Aluminium, 2, GTMaterials.Tin, 1, GTMaterials.Mercury, 1)
                .flags(MaterialFlags.GENERATE_ROD, MaterialFlags.GENERATE_FRAME)
                .buildAndRegister();
        //  24531 Titan Steel
        TitanSteel = new Material.Builder("titan_steel")
                .ingot()
                .fluid()
                .color(0xAA0D0D)
                .iconSet(MaterialIconSet.SHINY)
                .blastTemp(12000, BlastProperty.GasTier.HIGHEST, GTValues.VA[GTValues.UHV], 4550)
                .components(GTMaterials.TitaniumTungstenCarbide, 18, GTMaterials.Ruridit, 9, AusteniticStainlessSteel904L, 6, GTMaterials.Naquadah, 4, GTMaterials.RedSteel, 4, GTMaterials.BlueSteel, 4)
                .flags(MaterialFlags.GENERATE_PLATE, MaterialFlags.GENERATE_ROD, MaterialFlags.GENERATE_GEAR, MaterialFlags.GENERATE_SMALL_GEAR)
                .buildAndRegister();
        //  24532 Incoloy-DS
        IncoloyDS = new Material.Builder("incoloy_ds")
                .ingot()
                .fluid()
                .color(0x6746B7)
                .iconSet(MaterialIconSet.BRIGHT)
                .blastTemp(5680, BlastProperty.GasTier.HIGHER, GTValues.VA[GTValues.IV], 680)
                .components(GTMaterials.Iron, 23, GTMaterials.Cobalt, 9, /*Chrome, 9, */GTMaterials.Nickel, 9)
                .flags(MaterialFlags.GENERATE_PLATE)
                .buildAndRegister();
        //  24533 Inconel-690
        Inconel690 = new Material.Builder("inconel_690")
                .ingot()
                .fluid()
                .color(0x4FC050)
                .iconSet(MaterialIconSet.SHINY)
                .components(/*Chrome, 1, */GTMaterials.Niobium, 2, GTMaterials.Molybdenum, 2, GTMaterials.Nichrome, 3)
                .flags(MaterialFlags.GENERATE_ROD, MaterialFlags.GENERATE_BOLT_SCREW)
                .blastTemp(3440, BlastProperty.GasTier.MID, GTValues.VA[GTValues.HV], 45)
                .buildAndRegister();
        //  24534 Tantalloy61
        Tantalloy61 = new Material.Builder("tantalloy_61")
                .ingot()
                .fluid()
                .color(0x717171)
                .iconSet(MaterialIconSet.METALLIC)
                .components(GTMaterials.Tantalum, 13, GTMaterials.Tungsten, 12, GTMaterials.Titanium, 6, GTMaterials.Yttrium, 4)
                .blastTemp(6900, BlastProperty.GasTier.HIGHER, GTValues.VA[GTValues.LuV], 801)
                .flags(MaterialFlags.GENERATE_PLATE, MaterialFlags.GENERATE_ROD, MaterialFlags.GENERATE_BOLT_SCREW, MaterialFlags.GENERATE_GEAR, MaterialFlags.GENERATE_SMALL_GEAR)
                .buildAndRegister();
        //  24535 Inconel-020
        Incoloy020 = new Material.Builder("incoloy_020")
                .ingot()
                .fluid()
                .color(0xF8BFFC)
                .iconSet(MaterialIconSet.METALLIC)
                .components(GTMaterials.Iron, 10, GTMaterials.Nickel, 9, /*Chrome, 5, */GTMaterials.Copper, 1)
                .blastTemp(3400, BlastProperty.GasTier.MID, GTValues.VA[GTValues.MV], 53)
                .flags(MaterialFlags.GENERATE_ROD, MaterialFlags.GENERATE_BOLT_SCREW)
                .buildAndRegister();
        //  24536 HG-1223
        HG1223 = new Material.Builder("hg_1223")
                .ingot()
                .fluid()
                .color(0x235497)
                .iconSet(MaterialIconSet.SHINY)
                .components(GTMaterials.Mercury, 1, GTMaterials.Barium, 2, GTMaterials.Calcium, 2, GTMaterials.Copper, 3, GTMaterials.Oxygen, 8)
                .blastTemp(5325, BlastProperty.GasTier.HIGH, GTValues.VA[GTValues.EV], 301)
                .flags(MaterialFlags.GENERATE_PLATE)
                .buildAndRegister();
        //  24537 HMS-1J22 Alloy
        HMS1J22Alloy = new Material.Builder("hms_1_j_22_alloy")
                .ingot()
                .fluid()
                .color(0x9E927D)
                .iconSet(MaterialIconSet.DULL)
                .components(GTMaterials.Nickel, 12, GTMaterials.TinAlloy, 8, /*Chrome, 4, */GTMaterials.Phosphorus, 2, GTMaterials.Silicon, 2)
                .blastTemp(4330, BlastProperty.GasTier.MID, GTValues.VA[GTValues.EV], 290)
                .flags(MaterialFlags.GENERATE_PLATE, MaterialFlags.GENERATE_ROD, MaterialFlags.GENERATE_FRAME)
                .buildAndRegister();
        //  24538 Fullerene Superconductor
        FullereneSuperconductor = new Material.Builder("fullerene_superconductor")
                .ingot()
                .fluid()
                .color(0x8BF743)
                .iconSet(MaterialIconSet.BRIGHT)
                .components(BoronFranciumMixture, 8, ActiniumSuperhydride, 13, Abyssalloy, 6, LanthanumFullereneNanotube, 4, MetastableOganesson, 4, Cinobite, 3, GTMaterials.Radium, 2, GTMaterials.Astatine, 2, GTMaterials.Radon, 5)
                //  TODO UEV stage coil?
                .blastTemp(12960, BlastProperty.GasTier.HIGHEST, GTValues.VA[GTValues.UIV], 5560)
                .cableProperties(GTValues.V[GTValues.UIV], 256, 0, true)
                .buildAndRegister();
        //  24539 Legendarium
        Legendarium = new Material.Builder("legendarium")
                .ingot()
                .fluid()
                .color(0xF58FDA)
//                .iconSet(CUSTOM_LEGENDARIUM)
                .components(GTMaterials.Naquadria, 1, GTMaterials.Trinium, 1, GTMaterials.Duranium, 1, GTMaterials.Tritanium, 1, Orichalcum, 1, Adamantium, 1, Vibranium, 1, Taranium, 1)
                //  TODO UEV stage coil?
                .blastTemp(12960, BlastProperty.GasTier.HIGHEST, GTValues.VA[GTValues.UIV], 4998)
                .flags(MaterialFlags.GENERATE_PLATE, MaterialFlags.GENERATE_ROD, MaterialFlags.GENERATE_LONG_ROD, MaterialFlags.GENERATE_RING, MaterialFlags.GENERATE_ROUND, MaterialFlags.GENERATE_BOLT_SCREW, MaterialFlags.GENERATE_FRAME, MaterialFlags.GENERATE_GEAR, MaterialFlags.GENERATE_SMALL_GEAR)
                .buildAndRegister();
        //  24540 Superheavy-H Alloy
        SuperheavyHAlloy = new Material.Builder("superheavy_h_alloy")
                .ingot()
                .fluid()
                .color(0xE84B36)
                .iconSet(MaterialIconSet.SHINY)
                .components(GTMaterials.Copernicium, 1, GTMaterials.Nihonium, 1, MetastableFlerovium, 1, GTMaterials.Moscovium, 1, GTMaterials.Livermorium, 1, GTMaterials.Tennessine, 1, MetastableOganesson, 1)
                //  TODO UEV stage coil?
                .blastTemp(12960, BlastProperty.GasTier.HIGHEST, GTValues.VA[GTValues.UIV], 5236)
                .flags(MaterialFlags.GENERATE_FINE_WIRE)
                .cableProperties(GTValues.V[GTValues.UIV], 256, 64, false)
                .buildAndRegister();
        //  24541 Superheavy-L Alloy
        SuperheavyLAlloy = new Material.Builder("superheavy_l_alloy")
                .ingot()
                .fluid()
                .color(0x4D8BE9)
                .iconSet(MaterialIconSet.SHINY)
                .components(GTMaterials.Rutherfordium, 1, GTMaterials.Dubnium, 1, GTMaterials.Seaborgium, 1, GTMaterials.Bohrium, 1, MetastableHassium, 1, GTMaterials.Meitnerium, 1, GTMaterials.Darmstadtium, 1, GTMaterials.Roentgenium, 1)
                .blastTemp(10800, BlastProperty.GasTier.HIGHEST, GTValues.VA[GTValues.UEV], 4990)
                .flags(MaterialFlags.GENERATE_ROD, MaterialFlags.GENERATE_BOLT_SCREW, MaterialFlags.GENERATE_FINE_WIRE)
                .buildAndRegister();
        //  24542 Platinum-group Alloy
        PlatinumGroupAlloy = new Material.Builder("platinum_group_alloy")
                .ingot()
                .fluid()
                .color(GTMaterials.Gold.getMaterialRGB() + GTMaterials.Silver.getMaterialRGB() + GTMaterials.Platinum.getMaterialRGB() + GTMaterials.Palladium.getMaterialRGB() + GTMaterials.Ruthenium.getMaterialRGB() + GTMaterials.Rhodium.getMaterialRGB() + GTMaterials.Iridium.getMaterialRGB() + GTMaterials.Osmium.getMaterialRGB())
                .iconSet(MaterialIconSet.BRIGHT)
                .components(GTMaterials.Gold, 1, GTMaterials.Silver, 1, GTMaterials.Platinum, 1, GTMaterials.Palladium, 1, GTMaterials.Ruthenium, 1, GTMaterials.Rhodium, 1, GTMaterials.Iridium, 1, GTMaterials.Osmium, 1)
                .blastTemp(10000, BlastProperty.GasTier.HIGHEST, GTValues.VA[GTValues.UV], 1800)
                .flags(MaterialFlags.GENERATE_PLATE)
                .buildAndRegister();
    }
}
