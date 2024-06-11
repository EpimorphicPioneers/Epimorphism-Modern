// package cn.gtcommunity.epimorphism.data.recipe.circuits;
//
// import cn.gtcommunity.epimorphism.common.recipe.NeutronKineticEnergyCondition;
// import com.gregtechceu.gtceu.api.machine.multiblock.CleanroomType;
// import net.minecraft.data.recipes.FinishedRecipe;
//
// import java.util.function.Consumer;
//
// import static cn.gtcommunity.epimorphism.common.data.EPMaterials.*;
// import static cn.gtcommunity.epimorphism.common.data.EPRecipeTypes.*;
// import static cn.gtcommunity.epimorphism.utils.EPMathUtil.K;
// import static com.gregtechceu.gtceu.api.GTValues.*;
// import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.*;
// import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
// import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.*;
// public class SpintronicCircuits {
//    public static void init() {
//        //  Spintronic Board
//        CVD_RECIPES.recipeBuilder("")
//                .inputItems(plate, CarbonNanotube)
//                .inputItems(foil, Phosphorene, 4)
//                .inputFluids(FluorinatedEthylenePropylene.getFluid(L * 4))//  TODO Find better
// material
//                .outputItems(SPINTRONIC_BOARD)
//                .duration(40)
//                .EUt(VA[UEV])
//                .temperature(3580)
//                .glassTier(9)
//                .cleanroom(CleanroomType.CLEANROOM)
//                .save(provider);
//
//        //  Spintronic Circuit Board
//        for (FluidStack stack : new FluidStack[]{TetramethylammoniumHydroxide.getFluid(4000),
// EDP.getFluid(1000)}) {
//            CHEMICAL_RECIPES.recipeBuilder("")
//                    .inputItems(SPINTRONIC_BOARD)
//                    .inputItems(foil, Fullerene, 16)
//                    .inputFluids(stack)
//                    .outputItems(SPINTRONIC_CIRCUIT_BOARD)
//                    .cleanroom(CleanroomType.CLEANROOM)
//                    .duration(210)
//                    .EUt(VA[LuV])
//                    .save(provider);
//        }
//
//        //  STTRAM
//        FORMING_PRESS_RECIPES.recipeBuilder("")
//                .inputItems(RANDOM_ACCESS_MEMORY)
//                .inputItems(plate, ErbiumDopedZBLANGlass, 2)
//                .inputItems(plate, PraseodymiumDopedZBLANGlass, 2)
//                .inputItems(foil, Vibranium, 8)
//                .inputItems(wireFine, PedotPSS, 16)
//                .outputItems(SPIN_TRANSFER_TORQUE_MEMORY, 4)
//                .duration(200)
//                .EUt(VA[UEV])
//                .cleanroom(CleanroomType.CLEANROOM)
//                .save(provider);
//
//        //  MDNAND
//        FORMING_PRESS_RECIPES.recipeBuilder("")
//                .inputItems(NAND_MEMORY_CHIP)
//                .inputItems(dust, PedotTMA, 2)
//                .inputItems(foil, Abyssalloy, 8)
//                .inputItems(wireFine, CarbonNanotube, 16)
//                .outputItems(SPINTRONIC_NAND_MEMORY_CHIP, 4)
//                .duration(200)
//                .EUt(VA[UEV])
//                .cleanroom(CleanroomType.CLEANROOM)
//                .save(provider);
//
//        //  Quantum Dot
//        MIXER_RECIPES.recipeBuilder("")
//                .inputItems(dust, Cadmium)
//                .inputItems(dust, Selenium)
//                .outputItems(dust, CadmiumSelenide, 2)
//                .EUt(VA[EV])
//                .duration(120)
//                .save(provider);
//
//        //  Spintronic SMDs
//        CVD_RECIPES.recipeBuilder("")
//                .inputItems(wireFine, MercuryCadmiumTelluride, 4)
//                .inputItems(gem, HexagonalBoronNitride)
//                .outputItems(SPINTRONIC_RESISTOR, 16)
//                .inputFluids(Kevlar.getFluid(L * 2))
//                .duration(160)
//                .EUt(VA[UHV])
//                .temperature(2984)
//                .cleanroom(CleanroomType.CLEANROOM)
//                .save(provider);
//
//        ASSEMBLER_RECIPES.recipeBuilder("")
//                .inputItems(wireFine, CarbonNanotube, 8)
//                .inputItems(plate, AmorphousBoronNitride)
//                .inputFluids(Kevlar.getFluid(L))
//                .outputItems(SPINTRONIC_TRANSISTOR, 16)
//                .duration(160)
//                .EUt(VA[UHV])
//                .cleanroom(CleanroomType.CLEANROOM)
//                .save(provider);
//
//        LASER_CVD_RECIPES.recipeBuilder("")
//                .inputItems(wireGtSingle, CarbonNanotube, 2)
//                .inputItems(plate, CubicBoronNitride)
//                .inputFluids(Kevlar.getFluid(L / 4))
//                .outputItems(SPINTRONIC_CAPACITOR, 16)
//                .duration(160)
//                .EUt(VA[UHV])
//                .temperature(2755)
//                .cleanroom(CleanroomType.CLEANROOM)
//                .save(provider);
//
//        ASSEMBLER_RECIPES.recipeBuilder("")
//                .inputItems(dust, CadmiumSelenide)
//                .inputItems(wireFine, CarbonNanotube, 4)
//                .inputFluids(Kevlar.getFluid(L / 2))
//                .outputItems(SPINTRONIC_DIODE, 16)
//                .duration(160)
//                .EUt(VA[UHV])
//                .cleanroom(CleanroomType.CLEANROOM)
//                .save(provider);
//
//        ION_IMPLANTATER_RECIPES.recipeBuilder("")
//                .inputItems(ring, Fullerene)
//                .inputItems(wireFine, ThalliumCopperChloride, 4)
//                .inputFluids(Kevlar.getFluid(L))
//                .outputItems(SPINTRONIC_INDUCTOR, 16)
//                .duration(160)
//                .EUt(VA[UHV])
//                .cleanroom(CleanroomType.CLEANROOM)
//                .save(provider);
//
//        //  ESR Computation Unit
//        ASSEMBLER_RECIPES.recipeBuilder("")
//                .inputItems(SPINTRONIC_CIRCUIT_BOARD)
//                .inputItems(plate, PlutoniumPhosphide, 2)
//                .inputItems(plate, BismuthFerrite)
//                .inputItems(foil, BismuthChalcogenide, 2)
//                .inputItems(TOPOLOGICAL_INSULATOR_TUBE)
//                .inputItems(BOSE_EINSTEIN_CONDENSATE)
//                .inputItems(wireFine, ThalliumCopperChloride, 24)
//                .inputFluids(SolderingAlloy.getFluid(L))
//                .outputItems(ESR_COMPUTATION_UNIT)
//                .duration(600)
//                .EUt(VA[UEV])
//                .cleanroom(CleanroomType.CLEANROOM)
//                .save(provider);
//
//        //  Topological Insulator Tube
//        MOLECULAR_BEAM_RECIPES.recipeBuilder("")
//                .inputItems(dust, Bismuth)
//                .inputItems(dust, Antimony)
//                .inputItems(dust, Tellurium, 2)
//                .inputItems(dust, Sulfur)
//                .notConsumable(plate, CadmiumSulfide)
//                .outputItems(dust, BismuthChalcogenide, 5)
//                .duration(80)
//                .EUt(VA[UV])
//                .temperature(4876)
//                .save(provider);
//
//        MIXER_RECIPES.recipeBuilder("")
//                .inputItems(dust, Cadmium)
//                .inputItems(dust, Tellurium, 2)
//                .inputFluids(Mercury.getFluid(2000))
//                .circuitMeta(5)
//                .outputItems(dust, MercuryCadmiumTelluride, 5)
//                .duration(400)
//                .EUt(VA[UHV])
//                .cleanroom(CleanroomType.CLEANROOM)
//                .save(provider);
//
//        CANNER_RECIPES.recipeBuilder("")
//                .inputItems(wireFine, MercuryCadmiumTelluride, 16)
//                .inputItems(spring, CarbonNanotube)
//                .outputItems(TOPOLOGICAL_INSULATOR_TUBE)
//                .cleanroom(CleanroomType.CLEANROOM)
//                .duration(20)
//                .EUt(VA[HV])
//                .save(provider);
//
//        //  Bose-Einstein Condensate
//        ASSEMBLER_RECIPES.recipeBuilder("")
//                .inputItems(FIELD_GENERATOR_IV)
//                .inputItems(HELIUM_NEON_LASER)
//                .inputItems(plate, Trinium, 2)
//                .inputItems(cableGtSingle, Europium, 2)
//
// .inputs(MetaBlocks.TRANSPARENT_CASING.getItemVariant(BlockGlassCasing.CasingType.LAMINATED_GLASS,
// 2))
//                .outputItems(BOSE_EINSTEIN_CONDENSATE_CONTAINMENT_UNIT)
//                .duration(80)
//                .EUt(VA[UV])
//                .save(provider);
//
//        CANNER_RECIPES.recipeBuilder("")
//                .inputItems(BOSE_EINSTEIN_CONDENSATE_CONTAINMENT_UNIT)
//                .inputItems(dust, Rubidium, 8)
//                .outputItems(BOSE_EINSTEIN_CONDENSATE)
//                .cleanroom(CleanroomType.CLEANROOM)
//                .duration(20)
//                .EUt(VA[IV])
//                .save(provider);
//
//        //  Spintronic Processor
//        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder("")
//                .inputItems(ESR_COMPUTATION_UNIT)
//                .inputItems(CRYSTAL_SYSTEM_ON_CHIP)
//                .inputItems(SPINTRONIC_RESISTOR, 8)
//                .inputItems(SPINTRONIC_CAPACITOR, 8)
//                .inputItems(SPINTRONIC_TRANSISTOR, 8)
//                .inputItems(wireFine, CarbonNanotube, 8)
//                .outputItems(SPINTRONIC_PROCESSOR, 2)
//                .duration(200)
//                .EUt(VA[UEV])
//                .cleanroom(CleanroomType.CLEANROOM)
//                .save(provider);
//
//        //  Spintronic Assembly
//        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder("")
//                .inputItems(SPINTRONIC_CIRCUIT_BOARD)
//                .inputItems(SPINTRONIC_PROCESSOR, 2)
//                .inputItems(SPINTRONIC_INDUCTOR, 6)
//                .inputItems(SPINTRONIC_CAPACITOR, 12)
//                .inputItems(SPIN_TRANSFER_TORQUE_MEMORY, 24)
//                .inputItems(wireFine, CarbonNanotube, 16)
//                .outputItems(SPINTRONIC_ASSEMBLY, 2)
//                .solderMultiplier(2)
//                .duration(400)
//                .EUt(VA[UEV])
//                .cleanroom(CleanroomType.CLEANROOM)
//                .save(provider);
//
//        //  Spintronic Computer
//        ASSEMBLY_LINE_RECIPES.recipeBuilder("")
//                .inputItems(SPINTRONIC_CIRCUIT_BOARD)
//                .inputItems(SPINTRONIC_ASSEMBLY, 2)
//                .inputItems(SPINTRONIC_DIODE, 8)
//                .inputItems(SPINTRONIC_NAND_MEMORY_CHIP, 16)
//                .inputItems(SPIN_TRANSFER_TORQUE_MEMORY, 32)
//                .inputItems(wireFine, CarbonNanotube, 24)
//                .inputItems(foil, Fullerene, 32)
//                .inputItems(plate, PlutoniumPhosphide, 4)
//                .inputFluids(SolderingAlloy.getFluid(L * 12))
//                .inputFluids(Polyetheretherketone.getFluid(L * 6))
//                .inputFluids(Neutronium.getFluid(L * 3))
//                .outputItems(SPINTRONIC_COMPUTER)
//                .duration(400)
//                .EUt(VA[UEV])
//                .stationResearch(b -> b
//                        .researchStack(SPINTRONIC_ASSEMBLY.getStackForm())
//                        .CWUt(128)
//                        .EUt(VA[UEV]))
//                .save(provider);
//
//        ASSEMBLY_LINE_RECIPES.recipeBuilder("")
//                .inputItems(frameGt, Fullerene, 2)
//                .inputItems(SPINTRONIC_COMPUTER, 2)
//                .inputItems(SPINTRONIC_DIODE, 16)
//                .inputItems(SPINTRONIC_CAPACITOR, 16)
//                .inputItems(SPINTRONIC_TRANSISTOR, 16)
//                .inputItems(SPINTRONIC_RESISTOR, 16)
//                .inputItems(SPINTRONIC_INDUCTOR, 16)
//                .inputItems(foil, CarbonNanotube, 16)
//                .inputItems(SPIN_TRANSFER_TORQUE_MEMORY, 32)
//                .inputItems(wireGtDouble, FullereneSuperconductor, 16)
//                .inputItems(plate, NeptuniumAluminide, 8)
//                .inputFluids(SolderingAlloy.getFluid(L * 20))
//                .inputFluids(Zylon.getFluid(L * 15))
//                .inputFluids(Kevlar.getFluid(L * 12))
//                .inputFluids(Neutronium.getFluid(L * 9))
//                .outputItems(SPINTRONIC_MAINFRAME)
//                .duration(1600)
//                .EUt(VA[UIV])
//                .stationResearch(b -> b
//                        .researchStack(SPINTRONIC_COMPUTER.getStackForm())
//                        .CWUt(768)
//                        .EUt(VA[UIV]))
//                .save(provider);
//    }
// }
