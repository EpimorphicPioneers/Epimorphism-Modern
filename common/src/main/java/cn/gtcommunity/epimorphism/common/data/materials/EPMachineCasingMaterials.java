package cn.gtcommunity.epimorphism.common.data.materials;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.BlastProperty;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.ToolProperty;
import com.gregtechceu.gtceu.api.fluids.FluidBuilder;
import com.gregtechceu.gtceu.api.fluids.store.FluidStorageKeys;
import com.gregtechceu.gtceu.api.item.tool.GTToolType;

import static cn.gtcommunity.epimorphism.api.chemical.material.info.EPMaterialFlags.*;
import static com.gregtechceu.gtceu.api.GTValues.*;
import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags.*;
import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconSet.*;
import static cn.gtcommunity.epimorphism.common.data.EPMaterials.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;

public class EPMachineCasingMaterials {
    public static void register() {
        //  24501 Inconel-625
        Inconel625 = new Material.Builder("inconel_625")
                .ingot()
                .fluid(FluidStorageKeys.LIQUID, new FluidBuilder().temperature(3700))
                .fluidPipeProperties(5500, 340, true, true, true, false)
                .color(0x3fcc60)
                .iconSet(METALLIC)
                .flags(GENERATE_PLATE, GENERATE_ROD, GENERATE_RING, GENERATE_BOLT_SCREW, GENERATE_GEAR, GENERATE_CURVED_PLATE, GENERATE_ROTOR)
                .blastTemp(4850, BlastProperty.GasTier.HIGHEST, VA[IV], 1000)
                .components(Nickel, 8, /*Chrome, 6, */Molybdenum, 4, Niobium, 4, Titanium, 3, Iron, 2, Aluminium, 2)
                .buildAndRegister();
        //  24502 Hastelloy-N
        HastelloyN = new Material.Builder("hastelloy_n")
                .ingot()
                .fluid(FluidStorageKeys.LIQUID, new FluidBuilder().temperature(3980))
                .color(0x939554)
                .iconSet(DULL)
                .flags(GENERATE_GEAR, GENERATE_BOLT_SCREW, GENERATE_ROTOR, GENERATE_FRAME, GENERATE_CURVED_PLATE)
                .blastTemp(4550, BlastProperty.GasTier.HIGHER, VA[EV], 800)
                .components(Nickel, 15, Molybdenum, 4, /*Chrome, 2, */Titanium, 2, Yttrium, 2)
                .buildAndRegister();
        //  24503 Stellite
        Stellite = new Material.Builder("stellite")
                .ingot()
                .fluid(FluidStorageKeys.LIQUID, new FluidBuilder().temperature(4110))
                .color(0x9991A5)
                .iconSet(METALLIC)
                .blastTemp(4310, BlastProperty.GasTier.HIGHER, VA[EV], 1200)
                .components(/*Chrome, 9, */Cobalt, 9, Manganese, 5, Titanium, 2)
                .flags(GENERATE_PLATE, GENERATE_ROD, GENERATE_FRAME, GENERATE_GEAR, GENERATE_SMALL_GEAR)
                .buildAndRegister();
        //  24504 Quantum Alloy
        QuantumAlloy = new Material.Builder("quantum_alloy")
                .ingot()
                .fluid()
                .color(0x0F0F0F)
                .iconSet(SHINY)
                .blastTemp(10800, BlastProperty.GasTier.HIGHEST, VA[UHV], 1600)
                .components(Stellite, 15, Emerald, 5, Gallium, 5, Americium, 5, Germanium, 5, TitaniumTungstenCarbide, 5)
                .cableProperties(V[UHV], 24, 0, true)
                .flags(GENERATE_PLATE, GENERATE_FOIL, GENERATE_FINE_WIRE)
                .buildAndRegister();
        //  24505 Grisium
        Grisium = new Material.Builder("grisium")
                .ingot()
                .fluid()
                .color(0x355D6A)
                .iconSet(METALLIC)
                .blastTemp(11800, BlastProperty.GasTier.HIGHEST, VA[UEV], 2000)
                .components(BETSPerrhenate, 1, /*Trinaquadalloy, 4, */Vibranium, 2, Taranium, 1, TitaniumCarbide, 9, Potassium, 9, Lithium, 9, Sulfur, 6)
                .flags(GENERATE_FINE_WIRE)
                .cableProperties(V[UEV], 48, 0, true)
                .buildAndRegister();
        //  24506 HDCS (High Durability Compound Steel)
        Hdcs = new Material.Builder("hdcs")
                .ingot()
                .fluid()
                .color(0x334433)
                .iconSet(SHINY)
                .toolStats(new ToolProperty(20.0F, 10.0F, 18000, 18, GTToolType.values()))
                .blastTemp(11900, BlastProperty.GasTier.HIGHEST, VA[UEV], 2400)
                .components(TungstenSteel, 12, HSSS, 9, HSSG, 6, Ruridit, 3, MagnetoResonatic, 2, Plutonium241, 1)
                .flags(GENERATE_PLATE, GENERATE_ROD, GENERATE_LONG_ROD, GENERATE_RING, GENERATE_ROUND, GENERATE_BOLT_SCREW, GENERATE_FRAME, GENERATE_GEAR, GENERATE_SMALL_GEAR)
                .buildAndRegister();
        //  24507 Abyssalloy
        Abyssalloy = new Material.Builder("abyssalloy")
                .ingot()
                .fluid()
                .color(0x9E706A)
                .iconSet(METALLIC)
                .blastTemp(9625, BlastProperty.GasTier.HIGHEST, VA[UEV], 2250)
                .components(StainlessSteel, 5, TungstenCarbide, 5, Nichrome, 5, IncoloyMA956, 5, Germanium, 1, Rutherfordium, 1, Radon, 1)
                .cableProperties(V[UEV], 64, 64, false)
                .flags(GENERATE_FINE_WIRE, GENERATE_PLATE)
                .buildAndRegister();
        //  24508 Lafium
        Lafium = new Material.Builder("lafium")
                .ingot()
                .fluid()
                .color(0x0D0D60)
                .iconSet(SHINY)
                .blastTemp(9865, BlastProperty.GasTier.HIGHEST, VA[UEV], 1860)
                .components(HastelloyN, 8, Naquadria, 4, Samarium, 2, Tungsten, 4, Aluminium, 6, Nickel, 8, Titanium, 4, Carbon, 2, Argon, 2)
                .fluidPipeProperties(23000, 8000, true, true, true, true)
                .buildAndRegister();
        //  24509 Black Titanium
        BlackTitanium = new Material.Builder("black_titanium")
                .ingot()
                .fluid()
                .color(0x6C003B)
                .iconSet(SHINY)
                .blastTemp(11500, BlastProperty.GasTier.HIGHEST, VA[UEV], 4580)
                .flags(GENERATE_PLATE, GENERATE_ROD, GENERATE_FRAME)
                .components(Titanium, 26, Lanthanum, 6, TungstenSteel, 4, Cobalt, 3, Manganese, 2, Phosphorus, 2, Palladium, 2, Niobium, 1, Argon, 5)
                .toolStats(new ToolProperty(9.0F, 30.0F, 32000, 20, GTToolType.values()))
                .buildAndRegister();
        //  24510 Talonite
        Talonite = new Material.Builder("talonite")
                .ingot()
                .fluid()
                .color(0x9991A5)
                .iconSet(SHINY)
                .blastTemp(3454)
                .flags(GENERATE_PLATE)
                .components(Cobalt, 4,/* Chrome, 3, */Phosphorus, 2, Molybdenum, 1)
                .buildAndRegister();
        //  24511 Black Plutonium
        BlackPlutonium = new Material.Builder("black_plutonium")
                .ingot()
                .fluid()
                .color(0x060606)
                .iconSet(BRIGHT)
                .blastTemp(12960, BlastProperty.GasTier.HIGHEST, VA[UHV], 3600)
                .flags(GENERATE_PLATE, GENERATE_ROD, GENERATE_FRAME)
                .components(Plutonium244, 18, Cerium, 9, Gadolinium, 3, Dysprosium, 3, Thulium, 2, TungstenCarbide, 6, RedSteel, 6, Duranium, 2, Radon, 2)
                .buildAndRegister();
        //  24512 Maraging Steel-250
        MaragingSteel250 = new Material.Builder("maraging_steel_250")
                .ingot()
                .fluid()
                .color(0xA5ADB2)
                .iconSet(SHINY)
                .blastTemp(2413, BlastProperty.GasTier.MID, VA[EV], 680)
                .flags(GENERATE_PLATE, GENERATE_ROD, GENERATE_FRAME, GENERATE_GEAR)
                .components(Steel, 16, Molybdenum, 1, Titanium, 1, Nickel, 4, Cobalt, 2)
                .buildAndRegister();
        //  24513 Staballoy
        Staballoy = new Material.Builder("staballoy")
                .ingot()
                .fluid()
                .color(0x444B42)
                .iconSet(SHINY)
                .blastTemp(3450, BlastProperty.GasTier.HIGH, VA[EV], 462)
                .flags(GENERATE_PLATE, GENERATE_ROD, GENERATE_FRAME, GENERATE_CURVED_PLATE, GENERATE_ROTOR)
                .components(Uranium238, 9, Titanium, 1)
                .buildAndRegister();
        //  24514 Babbitt Alloy
        BabbittAlloy = new Material.Builder("babbitt_alloy")
                .ingot()
                .fluid()
                .color(0xA19CA4)
                .iconSet(SHINY)
                .components(Tin, 5, Lead, 36, Antimony, 8, Astatine, 1)
                .blastTemp(737, BlastProperty.GasTier.MID, VA[MV], 214)
                .flags(GENERATE_PLATE, GENERATE_ROD, GENERATE_FRAME)
                .buildAndRegister();
        //  24515 Zirconium Carbide
        ZirconiumCarbide = new Material.Builder("zirconium_carbide")
                .ingot()
                .fluid()
                .color(0xFFDACD)
                .iconSet(SHINY)
                .components(Zirconium, 1, Carbon, 1)
                .blastTemp(1200, BlastProperty.GasTier.MID, VA[HV], 344)
                .flags(GENERATE_PLATE, GENERATE_ROD, GENERATE_FRAME)
                .buildAndRegister();
        //  24516 Inconel-792
        Inconel792 = new Material.Builder("inconel_792")
                .ingot()
                .fluid()
                .color(0x6CF076)
                .iconSet(SHINY)
                .components(Nickel, 2, Niobium, 1, Aluminium, 2, Nichrome, 1)
                .blastTemp(6200, BlastProperty.GasTier.HIGHER, VA[IV], 1266)
                .flags(GENERATE_PLATE, GENERATE_ROD, GENERATE_BOLT_SCREW, GENERATE_CURVED_PLATE, GENERATE_ROTOR)
                .fluidPipeProperties(4900, 220, true, true, true, false)
                .buildAndRegister();
        //  24517 Incoloy-MA813
        IncoloyMA813 = new Material.Builder("incoloy_ma_813")
                .ingot()
                .fluid()
                .color(0x6CF076)
                .iconSet(SHINY)
                .components(VanadiumSteel, 4, Osmiridium, 2, HSSS, 3, Germanium, 4, Duranium, 5, Dubnium, 1)
                .blastTemp(9900, BlastProperty.GasTier.HIGHEST, VA[ZPM], 1277)
                .flags(GENERATE_PLATE, GENERATE_ROD, GENERATE_BOLT_SCREW, GENERATE_FRAME)
                .buildAndRegister();
        //  24518 Hastelloy-X78
        HastelloyX78 = new Material.Builder("hastelloy_x_78")
                .ingot()
                .fluid()
                .color(0x6BA3E3)
                .iconSet(SHINY)
                .blastTemp(12800, BlastProperty.GasTier.HIGHEST, VA[UHV], 4997)
                .components(NaquadahAlloy, 10, Rhenium, 5, Naquadria, 4, Gadolinium, 3, Strontium, 2, Polonium, 3, Rutherfordium, 2, Fermium, 1)
                .flags(GENERATE_PLATE, GENERATE_ROD, GENERATE_FRAME)
                .buildAndRegister();
        //  24519 Hastelloy-K243
        HastelloyK243 = new Material.Builder("hastelloy_k_243")
                .ingot()
                .fluid()
                .color(0xa4ff70)
                .iconSet(BRIGHT)
                .blastTemp(12400, BlastProperty.GasTier.HIGHEST, VA[UEV], 5032)
                .components(HastelloyX78, 5, NiobiumNitride, 2, Tritanium, 4, TungstenCarbide, 4, Promethium, 4, Mendelevium, 1)
                .buildAndRegister();
        //  24520 Mar-M200 Steel
        MARM200Steel = new Material.Builder("mar_m_200_steel")
                .ingot()
                .fluid()
                .color(0x515151)
                .iconSet(SHINY)
                .blastTemp(5000, BlastProperty.GasTier.HIGHER, VA[IV], 200)
                .components(Niobium, 2, /*Chrome, 9, */Aluminium, 5, Titanium, 2, Cobalt, 10, Tungsten, 13, Nickel, 18)
                .flags(GENERATE_PLATE, GENERATE_CURVED_PLATE, GENERATE_ROTOR, GENERATE_ROD, GENERATE_FRAME)
                .buildAndRegister();
        //  24521 Mar-M200-Ce Steel
        MARM200CeSteel = new Material.Builder("mar_m_200_ce_steel")
                .ingot()
                .fluid()
                .color(0x383030)
                .iconSet(BRIGHT)
                .blastTemp(7500, BlastProperty.GasTier.HIGHEST, VA[LuV], 432)
                .components(MARM200Steel, 18, Cerium, 1)
                .flags(GENERATE_PLATE)
                .buildAndRegister();
        //  24522 Tanmolyium Beta-C
        TanmolyiumBetaC = new Material.Builder("tanmolyium_beta_c")
                .ingot()
                .fluid()
                .color(0xc72fcc)
                .iconSet(METALLIC)
                .blastTemp(5300, BlastProperty.GasTier.HIGHER, VA[IV], 180)
                .components(Titanium, 5, Molybdenum, 5, Vanadium, 2, /*Chrome, 3, */Aluminium, 1)
                .flags(GENERATE_PLATE, GENERATE_ROD, GENERATE_GEAR, GENERATE_SMALL_GEAR)
                .buildAndRegister();
        //  24523 Hastelloy-C59
        HastelloyC59 = new Material.Builder("hastelloy_c_59")
                .ingot()
                .fluid()
                .color(0xD6D0F0)
                .iconSet(DULL)
                .blastTemp(7600, BlastProperty.GasTier.HIGHER, VA[LuV], 559)
                .components(Nickel, 18, /*Chrome, 16, */TinAlloy, 8, Cobalt, 6, Niobium, 4, Aluminium, 4, Silicon, 2, Phosphorus, 2)
                .flags(GENERATE_PLATE, GENERATE_ROD, GENERATE_FRAME)
                .buildAndRegister();
        //  24524 HMS-1J79 Alloy
        HMS1J79Alloy = new Material.Builder("hms_1_j_79_alloy")
                .ingot()
                .fluid()
                .color(0xD1CB0B)
                .iconSet(SHINY)
                .blastTemp(8100, BlastProperty.GasTier.HIGHEST, VA[LuV], 886)
                .components(Nickel, 14, Iron, 12, Molybdenum, 11, CobaltBrass, 8, /*Chrome, 6, */Silicon, 4)
                .flags(GENERATE_PLATE)
                .buildAndRegister();
        //  24525 High Strength Structural Steel-HY130-1
        HY1301 = new Material.Builder("hy_1301")
                .ingot()
                .fluid()
                .color(0x6F3E57)
                .iconSet(SHINY)
                .blastTemp(7850, BlastProperty.GasTier.HIGHER, VA[LuV], 766)
                .components(Nickel, 9, NickelZincFerrite, 6, /*Chrome, 4, */Nichrome, 4, Iron, 4, Molybdenum, 4, Rhenium, 2, Silicon, 1)
                .flags(GENERATE_PLATE, GENERATE_ROD, GENERATE_GEAR, GENERATE_SMALL_GEAR)
                .buildAndRegister();
        //  24526 Super Austenitic Stainless Steel-904L
        AusteniticStainlessSteel904L = new Material.Builder("super_austenitic_stainless_steel_904_l")
                .ingot()
                .fluid()
                .color(0x881357)
                .iconSet(METALLIC)
                .blastTemp(4960, BlastProperty.GasTier.MID, VA[EV], 344)
                .components(StainlessSteel, 8, NickelZincFerrite, 4, Kanthal, 4, Molybdenum, 4)
                .flags(GENERATE_PLATE, GENERATE_ROD, GENERATE_FRAME, GENERATE_BOLT_SCREW)
                .buildAndRegister();
        //  24527 Eglin Steel Base
        EglinSteelBase = new Material.Builder("eglin_steel_base")
                .dust()
                .color(0x8B4513)
                .iconSet(SAND)
                .components(Iron, 4, Kanthal, 1, Invar, 5)
                .buildAndRegister();
        //  24528 Eglin Steel
        EglinSteel = new Material.Builder("eglin_steel")
                .ingot()
                .fluid()
                .color(0x8B4513)
                .iconSet(METALLIC)
                .components(EglinSteelBase, 10, Sulfur, 1, Silicon, 1, Carbon, 1)
                .blastTemp(1048, BlastProperty.GasTier.LOW, VA[MV], 24)
                .flags(GENERATE_ROD, GENERATE_LONG_ROD, GENERATE_FRAME)
                .buildAndRegister();
        //  24529 Pikyonium-64B
        Pikyonium64B = new Material.Builder("pikyonium_64_b")
                .ingot()
                .fluid()
                .color(0x3467BA)
                .iconSet(SHINY)
                .blastTemp(10400, BlastProperty.GasTier.HIGHEST, VA[ZPM], 2487)
                .components(Inconel792, 8, EglinSteel, 5, NaquadahAlloy, 4, TungstenSteel, 4, Cerium, 3, Antimony, 2, Platinum, 2, Ytterbium, 1)
                .flags(GENERATE_PLATE, GENERATE_ROD, GENERATE_LONG_ROD, GENERATE_SPRING, GENERATE_SPRING_SMALL)
                .buildAndRegister();
        //  24530 Cinobite
        Cinobite = new Material.Builder("cinobite")
                .ingot()
                .fluid()
                .color(0x010101)
                .iconSet(SHINY)
                .blastTemp(11465, BlastProperty.GasTier.HIGHEST, VA[UV], 3608)
                .components(Zeron100, 8, Stellite100, 6, Titanium, 6, Naquadria, 4, Osmiridium, 3, Aluminium, 2, Tin, 1, Mercury, 1)
                .flags(GENERATE_ROD, GENERATE_FRAME)
                .buildAndRegister();
        //  24531 Titan Steel
        TitanSteel = new Material.Builder("titan_steel")
                .ingot()
                .fluid()
                .color(0xAA0D0D)
                .iconSet(SHINY)
                .blastTemp(12000, BlastProperty.GasTier.HIGHEST, VA[UHV], 4550)
                .components(TitaniumTungstenCarbide, 18, Ruridit, 9, AusteniticStainlessSteel904L, 6, Naquadah, 4, RedSteel, 4, BlueSteel, 4)
                .flags(GENERATE_PLATE, GENERATE_ROD, GENERATE_GEAR, GENERATE_SMALL_GEAR)
                .buildAndRegister();
        //  24532 Incoloy-DS
        IncoloyDS = new Material.Builder("incoloy_ds")
                .ingot()
                .fluid()
                .color(0x6746B7)
                .iconSet(BRIGHT)
                .blastTemp(5680, BlastProperty.GasTier.HIGHER, VA[IV], 680)
                .components(Iron, 23, Cobalt, 9, /*Chrome, 9, */Nickel, 9)
                .flags(GENERATE_PLATE)
                .buildAndRegister();
        //  24533 Inconel-690
        Inconel690 = new Material.Builder("inconel_690")
                .ingot()
                .fluid()
                .color(0x4FC050)
                .iconSet(SHINY)
                .components(/*Chrome, 1, */Niobium, 2, Molybdenum, 2, Nichrome, 3)
                .flags(GENERATE_ROD, GENERATE_BOLT_SCREW)
                .blastTemp(3440, BlastProperty.GasTier.MID, VA[HV], 45)
                .buildAndRegister();
        //  24534 Tantalloy61
        Tantalloy61 = new Material.Builder("tantalloy_61")
                .ingot()
                .fluid()
                .color(0x717171)
                .iconSet(METALLIC)
                .components(Tantalum, 13, Tungsten, 12, Titanium, 6, Yttrium, 4)
                .blastTemp(6900, BlastProperty.GasTier.HIGHER, VA[LuV], 801)
                .flags(GENERATE_PLATE, GENERATE_ROD, GENERATE_BOLT_SCREW, GENERATE_GEAR, GENERATE_SMALL_GEAR)
                .buildAndRegister();
        //  24535 Inconel-020
        Incoloy020 = new Material.Builder("incoloy_020")
                .ingot()
                .fluid()
                .color(0xF8BFFC)
                .iconSet(METALLIC)
                .components(Iron, 10, Nickel, 9, /*Chrome, 5, */Copper, 1)
                .blastTemp(3400, BlastProperty.GasTier.MID, VA[MV], 53)
                .flags(GENERATE_ROD, GENERATE_BOLT_SCREW)
                .buildAndRegister();
        //  24536 HG-1223
        HG1223 = new Material.Builder("hg_1223")
                .ingot()
                .fluid()
                .color(0x235497)
                .iconSet(SHINY)
                .components(Mercury, 1, Barium, 2, Calcium, 2, Copper, 3, Oxygen, 8)
                .blastTemp(5325, BlastProperty.GasTier.HIGH, VA[EV], 301)
                .flags(GENERATE_PLATE)
                .buildAndRegister();
        //  24537 HMS-1J22 Alloy
        HMS1J22Alloy = new Material.Builder("hms_1_j_22_alloy")
                .ingot()
                .fluid()
                .color(0x9E927D)
                .iconSet(DULL)
                .components(Nickel, 12, TinAlloy, 8, /*Chrome, 4, */Phosphorus, 2, Silicon, 2)
                .blastTemp(4330, BlastProperty.GasTier.MID, VA[EV], 290)
                .flags(GENERATE_PLATE, GENERATE_ROD, GENERATE_FRAME)
                .buildAndRegister();
        //  24538 Fullerene Superconductor
        FullereneSuperconductor = new Material.Builder("fullerene_superconductor")
                .ingot()
                .fluid()
                .color(0x8BF743)
                .iconSet(BRIGHT)
                .components(BoronFranciumMixture, 8, ActiniumSuperhydride, 13, Abyssalloy, 6, LanthanumFullereneNanotube, 4, MetastableOganesson, 4, Cinobite, 3, Radium, 2, Astatine, 2, Radon, 5)
                //  TODO UEV stage coil?
                .blastTemp(12960, BlastProperty.GasTier.HIGHEST, VA[UIV], 5560)
                .cableProperties(V[UIV], 256, 0, true)
                .buildAndRegister();
        //  24539 Legendarium
        Legendarium = new Material.Builder("legendarium")
                .ingot()
                .fluid()
                .color(0xF58FDA)
//                .iconSet(CUSTOM_LEGENDARIUM)
                .components(Naquadria, 1, Trinium, 1, Duranium, 1, Tritanium, 1, Orichalcum, 1, Adamantium, 1, Vibranium, 1, Taranium, 1)
                //  TODO UEV stage coil?
                .blastTemp(12960, BlastProperty.GasTier.HIGHEST, VA[UIV], 4998)
                .flags(GENERATE_PLATE, GENERATE_ROD, GENERATE_LONG_ROD, GENERATE_RING, GENERATE_ROUND, GENERATE_BOLT_SCREW, GENERATE_FRAME, GENERATE_GEAR, GENERATE_SMALL_GEAR)
                .buildAndRegister();
        //  24540 Superheavy-H Alloy
        SuperheavyHAlloy = new Material.Builder("superheavy_h_alloy")
                .ingot()
                .fluid()
                .color(0xE84B36)
                .iconSet(SHINY)
                .components(Copernicium, 1, Nihonium, 1, MetastableFlerovium, 1, Moscovium, 1, Livermorium, 1, Tennessine, 1, MetastableOganesson, 1)
                //  TODO UEV stage coil?
                .blastTemp(12960, BlastProperty.GasTier.HIGHEST, VA[UIV], 5236)
                .flags(GENERATE_FINE_WIRE)
                .cableProperties(V[UIV], 256, 64, false)
                .buildAndRegister();
        //  24541 Superheavy-L Alloy
        SuperheavyLAlloy = new Material.Builder("superheavy_l_alloy")
                .ingot()
                .fluid()
                .color(0x4D8BE9)
                .iconSet(SHINY)
                .components(Rutherfordium, 1, Dubnium, 1, Seaborgium, 1, Bohrium, 1, MetastableHassium, 1, Meitnerium, 1, Darmstadtium, 1, Roentgenium, 1)
                .blastTemp(10800, BlastProperty.GasTier.HIGHEST, VA[UEV], 4990)
                .flags(GENERATE_ROD, GENERATE_BOLT_SCREW, GENERATE_FINE_WIRE)
                .buildAndRegister();
        //  24542 Platinum-group Alloy
        PlatinumGroupAlloy = new Material.Builder("platinum_group_alloy")
                .ingot()
                .fluid()
                .color(Gold.getMaterialRGB() + Silver.getMaterialRGB() + Platinum.getMaterialRGB() + Palladium.getMaterialRGB() + Ruthenium.getMaterialRGB() + Rhodium.getMaterialRGB() + Iridium.getMaterialRGB() + Osmium.getMaterialRGB())
                .iconSet(BRIGHT)
                .components(Gold, 1, Silver, 1, Platinum, 1, Palladium, 1, Ruthenium, 1, Rhodium, 1, Iridium, 1, Osmium, 1)
                .blastTemp(10000, BlastProperty.GasTier.HIGHEST, VA[UV], 1800)
                .flags(GENERATE_PLATE)
                .buildAndRegister();
    }
}
