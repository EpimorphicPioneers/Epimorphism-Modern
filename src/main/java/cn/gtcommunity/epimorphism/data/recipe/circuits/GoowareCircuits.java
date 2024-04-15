//package cn.gtcommunity.epimorphism.data.recipe.circuits;
//
//import cn.gtcommunity.epimorphism.common.recipe.NeutronKineticEnergyCondition;
//import com.gregtechceu.gtceu.api.machine.multiblock.CleanroomType;
//import net.minecraft.data.recipes.FinishedRecipe;
//
//import java.util.function.Consumer;
//
//import static cn.gtcommunity.epimorphism.common.data.EPMaterials.*;
//import static cn.gtcommunity.epimorphism.common.data.EPRecipeTypes.*;
//import static cn.gtcommunity.epimorphism.utils.EPMathUtil.K;
//import static com.gregtechceu.gtceu.api.GTValues.*;
//import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.*;
//import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
//import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.*;
//public class GoowareCircuits {
//    public static void init() {
//        //  Gooware Board
//        CVD_RECIPES.recipeBuilder("")
//                .inputItems(OrePrefix.plate, EPMaterials.KaptonE)
//                .inputItems(OrePrefix.foil, Materials.Europium, 4)
//                .inputFluids(FluorinatedEthylenePropylene.getFluid(L))
//                .outputItems(GOOWARE_BOARD)
//                .duration(40)
//                .EUt(VA[UV])
//                .temperature(493)
//                .glassTier(7)
//                .cleanroom(CleanroomType.CLEANROOM)
//                .save(provider);
//
//        //  Gooware Circuit Board
//        for (FluidStack stack : new FluidStack[]{
//                EPMaterials.TetramethylammoniumHydroxide.getFluid(2000),
//                EPMaterials.EDP.getFluid(500)}) {
//            CHEMICAL_RECIPES.recipeBuilder("")
//                    .inputItems(GOOWARE_BOARD)
//                    .inputItems(OrePrefix.foil, Materials.YttriumBariumCuprate, 48)
//                    .inputFluids(new FluidStack[]{stack})
//                    .outputItems(GOOWARE_CIRCUIT_BOARD)
//                    .cleanroom(CleanroomType.CLEANROOM)
//                    .duration(210)
//                    .EUt(GTValues.VA[EV])
//                    .save(provider);
//        }
//
//        //  BZ Reaction Chamber
//        ASSEMBLER_RECIPES.recipeBuilder("")
//                .inputs(FLUID_CELL_LARGE_STAINLESS_STEEL.getStackForm())
//                .inputItems(plate, Naquadah, 4)
//                .inputItems(plate, Ruridit, 2)
//                .inputItems(bolt, Trinium, 12)
//                .inputItems(stick, SamariumMagnetic)
//                .inputItems(rotor, Iridium)
//                .inputItems(ELECTRIC_MOTOR_LuV)
//                .inputFluids(SolderingAlloy.getFluid(L))
//                .outputs(BZ_REACTION_CHAMBER.getStackForm())
//                .duration(600)
//                .EUt(VA[UV])
//                .save(provider);
//
//        //  Non-linear Chemical Oscillator
//        CANNER_RECIPES.recipeBuilder("")
//                .inputs(BZ_REACTION_CHAMBER.getStackForm())
//                .inputFluids(BZMedium.getFluid(500))
//                .outputs(NONLINEAR_CHEMICAL_OSCILLATOR.getStackForm())
//                .duration(60)
//                .EUt(VA[IV])
//                .save(provider);
//
//        //  Gooware Processor (UV)
//        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder("")
//                .inputItems(GOOWARE_CIRCUIT_BOARD)
//                .inputItems(NONLINEAR_CHEMICAL_OSCILLATOR)
//                .inputItems(CRYSTAL_CENTRAL_PROCESSING_UNIT)
//                .inputItems(ADVANCED_SMD_CAPACITOR, 16)
//                .inputItems(ADVANCED_SMD_TRANSISTOR, 16)
//                .inputItems(wireFine, Europium, 8)
//                .solderMultiplier(1)
//                .outputItems(GOOWARE_PROCESSOR, 2)
//                .duration(200)
//                .EUt(VA[UV])
//                .cleanroom(CleanroomType.CLEANROOM)
//                .save(provider);
//
//        //  Gooware Processor (UHV)
//        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder("")
//                .inputItems(GOOWARE_CIRCUIT_BOARD)
//                .inputItems(NONLINEAR_CHEMICAL_OSCILLATOR)
//                .inputs(INTRAVITAL_SOC.getStackForm())
//                .inputItems(wireFine, Europium, 8)
//                .solderMultiplier(1)
//                .outputItems(GOOWARE_PROCESSOR, 2)
//                .duration(100)
//                .EUt(VA[UHV])
//                .cleanroom(CleanroomType.CLEANROOM)
//                .save(provider);
//
//        //  Gooware Assembly
//        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder("")
//                .inputItems(GOOWARE_CIRCUIT_BOARD)
//                .inputItems(GOOWARE_PROCESSOR, 2)
//                .inputItems(ADVANCED_SMD_INDUCTOR, 16)
//                .inputItems(ADVANCED_SMD_CAPACITOR, 32)
//                .inputItems(RANDOM_ACCESS_MEMORY, 40)
//                .inputItems(wireFine, Europium, 16)
//                .outputItems(GOOWARE_ASSEMBLY, 2)
//                .solderMultiplier(2)
//                .duration(400)
//                .EUt(VA[UV])
//                .cleanroom(CleanroomType.CLEANROOM)
//                .save(provider);
//
//        //  Gooware Computer
//        ASSEMBLY_LINE_RECIPES.recipeBuilder("")
//                .inputItems(GOOWARE_CIRCUIT_BOARD)
//                .inputItems(GOOWARE_ASSEMBLY, 2)
//                .inputItems(ADVANCED_SMD_DIODE, 10)
//                .inputItems(NOR_MEMORY_CHIP, 16)
//                .inputItems(RANDOM_ACCESS_MEMORY, 32)
//                .inputItems(wireFine, Europium, 24)
//                .inputItems(foil, KaptonK, 32)
//                .inputItems(plate, Americium, 4)
//                .inputFluids(SolderingAlloy.getFluid(L * 9))
//                .outputItems(GOOWARE_COMPUTER)
//                .duration(400)
//                .EUt(VA[UV])
//                .stationResearch(b -> b
//                        .researchStack(GOOWARE_ASSEMBLY.getStackForm())
//                        .CWUt(32)
//                        .EUt(VA[UV]))
//                .save(provider);
//
//        //  Gooware Mainframe
//        ASSEMBLY_LINE_RECIPES.recipeBuilder("")
//                .inputItems(frameGt, Darmstadtium, 2)
//                .inputItems(GOOWARE_COMPUTER, 2)
//                .inputItems(ADVANCED_SMD_DIODE, 64)
//                .inputItems(ADVANCED_SMD_CAPACITOR, 64)
//                .inputItems(ADVANCED_SMD_TRANSISTOR, 64)
//                .inputItems(ADVANCED_SMD_RESISTOR, 64)
//                .inputItems(ADVANCED_SMD_INDUCTOR, 64)
//                .inputItems(foil, KaptonK, 64)
//                .inputItems(RANDOM_ACCESS_MEMORY, 32)
//                .inputItems(wireGtDouble, QuantumAlloy, 16)
//                .inputItems(plate, Americium, 8)
//                .inputFluids(SolderingAlloy.getFluid(L * 20))
//                .inputFluids(KaptonE.getFluid(L * 9))
//                .outputItems(GOOWARE_MAINFRAME)
//                .duration(800)
//                .EUt(VA[UHV])
//                .stationResearch(b -> b
//                        .researchStack(GOOWARE_COMPUTER.getStackForm())
//                        .CWUt(192)
//                        .EUt(VA[UHV]))
//                .save(provider);
//    }
//}
