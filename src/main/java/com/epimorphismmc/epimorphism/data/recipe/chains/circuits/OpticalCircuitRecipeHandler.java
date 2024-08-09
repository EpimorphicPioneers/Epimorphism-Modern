package com.epimorphismmc.epimorphism.data.recipe.chains.circuits;

import com.epimorphismmc.epimorphism.data.recipe.EPRecipeUtil;

import com.gregtechceu.gtceu.api.machine.multiblock.CleanroomType;

import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

import static com.epimorphismmc.epimorphism.common.data.EPItems.*;
import static com.epimorphismmc.epimorphism.common.data.EPMaterials.*;
import static com.epimorphismmc.epimorphism.common.data.EPRecipeTypes.*;
import static com.epimorphismmc.epimorphism.common.data.items.EPPhysicsItems.ELECTRON_SOURCE;
import static com.gregtechceu.gtceu.api.GTValues.*;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.*;

public class OpticalCircuitRecipeHandler {
    public static void init(Consumer<FinishedRecipe> provider) {

        // Nb2O5 + Li2CO3 -> 2LiNbO3 + CO2
        BLAST_RECIPES
                .recipeBuilder("lithium_niobate_dust")
                .inputItems(dust, NiobiumPentoxide)
                .inputItems(dust, LithiumCarbonate)
                .outputItems(dust, LithiumNiobate, 2)
                .outputFluids(CarbonDioxide.getFluid(1000))
                .blastFurnaceTemp(4500)
                .duration(EPRecipeUtil.second(5))
                .EUt(VA[HV])
                .save(provider);

        CRYSTALLIZATION_RECIPES
                .recipeBuilder("lithium_niobate_boule")
                .inputItems(dust, LithiumNiobate, 8)
                .notConsumable(ROTATING_TRANSPARENT_SURFACE)
                .notConsumable(ELECTRON_SOURCE)
                .inputFluids(Xenon.getFluid(1000))
                .outputItems(PERIODICALLY_POLED_LITHIUM_NIOBATE_BOULE)
                .blastFurnaceTemp(6800)
                .duration(EPRecipeUtil.second(16))
                .EUt(VA[IV])
                .save(provider);

        LATHE_RECIPES
                .recipeBuilder("non_linear_optical_lens")
                .inputItems(PERIODICALLY_POLED_LITHIUM_NIOBATE_BOULE)
                .outputItems(NON_LINEAR_OPTICAL_LENS)
                .outputItems(dust, LithiumNiobate, 2)
                .duration(EPRecipeUtil.second(30))
                .EUt(VA[HV])
                .save(provider);

        //        //  Optical Board
        //        CVD_RECIPES.recipeBuilder("")
        //                .inputItems(plate, GalliumNitride)
        //                .inputItems(foil, Americium, 4)
        //                .inputFluids(FluorinatedEthylenePropylene.getFluid(L * 2))//  TODO Find better
        // material
        //                .outputItems(OPTICAL_BOARD)
        //                .duration(40)
        //                .EUt(VA[UHV])
        //                .temperature(980)
        //                .glassTier(8)
        //                .cleanroom(CleanroomType.CLEANROOM)
        //                .save(provider);
        //
        //        //  Optical Circuit Board
        //        for (FluidStack stack : new FluidStack[]{TetramethylammoniumHydroxide.getFluid(4000),
        // EDP.getFluid(1000)}) {
        //            CHEMICAL_RECIPES.recipeBuilder("")
        //                    .inputItems(OPTICAL_BOARD)
        //                    .inputItems(foil, Americium, 64)
        //                    .inputFluids(stack)
        //                    .outputItems(OPTICAL_CIRCUIT_BOARD)
        //                    .cleanroom(CleanroomType.CLEANROOM)
        //                    .duration(210)
        //                    .EUt(VA[IV])
        //                    .save(provider);
        //        }
        //
        //        //  ZBLAN Glasses
        //        ALLOY_BLAST_RECIPES.recipeBuilder("")
        //                .inputItems(dust, Zirconium, 5)
        //                .inputItems(dust, Barium, 2)
        //                .inputItems(dust, Lanthanum)
        //                .inputItems(dust, Aluminium)
        //                .inputItems(dust, Sodium, 2)
        //                .inputFluids(Fluorine.getFluid(6200))
        //                .circuitMeta(5)
        //                .outputFluids(ZBLANGlass.getFluid(L * 11))
        //                .blastFurnaceTemp(1073)
        //                .duration(1800)
        //                .EUt(VA[HV])
        //                .save(provider);
        //
        //        ALLOY_SMELTER_RECIPES.recipeBuilder("")
        //                .inputItems(ingot, ZBLANGlass)
        //                .inputItems(dust, Erbium)
        //                .outputItems(ingot, ErbiumDopedZBLANGlass, 2)
        //                .duration(200)
        //                .EUt(VA[HV])
        //                .save(provider);
        //
        //        ALLOY_SMELTER_RECIPES.recipeBuilder("")
        //                .inputItems(ingot, ZBLANGlass)
        //                .inputItems(dust, Praseodymium)
        //                .outputItems(ingot, PraseodymiumDopedZBLANGlass, 2)
        //                .duration(200)
        //                .EUt(VA[HV])
        //                .save(provider);
        //
        //        //  PRAM
        //        FORMING_PRESS_RECIPES.recipeBuilder("")
        //                .inputItems(RANDOM_ACCESS_MEMORY)
        //                .inputItems(plate, GSTGlass, 2)
        //                .inputItems(foil, Americium, 8)
        //                .outputItems(PHASE_CHANGE_MEMORY, 4)
        //                .duration(200)
        //                .EUt(VA[UHV])
        //                .cleanroom(CleanroomType.CLEANROOM)
        //                .save(provider);
        //
        //        //  ACNOR
        //        FORMING_PRESS_RECIPES.recipeBuilder("")
        //                .inputItems(NOR_MEMORY_CHIP)
        //                .inputItems(OPTICAL_FIBER, 2)
        //                .inputItems(foil, Trinium, 8)
        //                .outputItems(OPTICAL_NOR_MEMORY_CHIP, 4)
        //                .duration(200)
        //                .EUt(VA[UHV])
        //                .cleanroom(CleanroomType.CLEANROOM)
        //                .save(provider);
        //
        //        //  Optical Fiber: Germanium Tetrachloride + Phosphory Chloride + Silicon
        // Tetrachloride -> Optical Fiber
        //        LASER_CVD_RECIPES.recipeBuilder("")
        //                .inputFluids(GermaniumTetrachloride.getFluid(250))
        //                .inputFluids(PhosphorylChloride.getFluid(250))
        //                .inputFluids(SiliconTetrachloride.getFluid(1000))
        //                .notConsumable(SHAPE_EXTRUDER_WIRE)
        //                .outputItems(OPTICAL_FIBER, 8)
        //                .duration(400)
        //                .EUt(VA[LuV])
        //                .temperature(1800)
        //                .cleanroom(CleanroomType.CLEANROOM)
        //                .save(provider);
        //
        //        //  Dielectric Mirror: Erbium-doped ZBLAN Glass + Praseodymium-doped ZBLAN Glass +
        // Tantalum Pentoxide -> Dielectric Mirror
        //        MOLECULAR_BEAM_RECIPES.recipeBuilder("")
        //                .inputItems(foil, Polybenzimidazole)
        //                .inputItems(dust, ErbiumDopedZBLANGlass, 2)
        //                .inputItems(dust, PraseodymiumDopedZBLANGlass, 2)
        //                .inputItems(dust, TantalumPentoxide, 7)
        //                .inputFluids(ElectrolyteReflectorMixture.getFluid(500))
        //                .outputItems(DIELECTRIC_MIRROR)
        //                .duration(600)
        //                .EUt(VA[LuV])
        //                .temperature(2820)
        //                .cleanroom(CleanroomType.CLEANROOM)
        //                .save(provider);
        //
        //        //  Empty Laser
        //        VACUUM_CHAMBER_RECIPES.recipeBuilder("")
        //                .inputItems(DIELECTRIC_MIRROR)
        //                .inputItems(plate, SterlingSilver, 2)
        //                .inputItems(ring, TungstenSteel, 2)
        //                .inputItems(cableGtSingle, Platinum, 2)
        //                .inputFluids(BorosilicateGlass.getFluid(L * 2))
        //                .outputItems(EMPTY_LASER_ASSEMBLY)
        //                .duration(100)
        //                .EUt(VA[IV])
        //                .save(provider);
        //
        //        //  Nd:YAG Laser
        //        CANNER_RECIPES.recipeBuilder("")
        //                .inputItems(EMPTY_LASER_ASSEMBLY)
        //                .inputItems(gem, NdYAG)
        //                .outputItems(ND_YAG_LASER)
        //                .EUt(VA[HV])
        //                .duration(120)
        //                .cleanroom(CleanroomType.CLEANROOM)
        //                .save(provider);

        //  Optical SMDs
        ASSEMBLER_RECIPES
                .recipeBuilder("optical_resistor")
                .inputItems(wireFine, Naquadah, 4)
                .inputItems(dust, CadmiumSulfide)
                .outputItems(OPTICAL_RESISTOR, 16)
                .inputFluids(KaptonE.getFluid(L * 2))
                .duration(160)
                .EUt(VA[UV])
                .cleanroom(CleanroomType.CLEANROOM)
                .save(provider);

        ASSEMBLER_RECIPES
                .recipeBuilder("optical_transistor")
                .inputItems(wireFine, Iridium, 8)
                .inputItems(foil, Germanium)
                .inputFluids(KaptonE.getFluid(L))
                .outputItems(OPTICAL_TRANSISTOR, 16)
                .duration(160)
                .EUt(VA[UV])
                .cleanroom(CleanroomType.CLEANROOM)
                .save(provider);

        LASER_CVD_RECIPES
                .recipeBuilder("optical_capacitor")
                .inputItems(OPTICAL_FIBER, 2)
                .inputItems(plate, ErbiumDopedZBLANGlass)
                .inputFluids(KaptonE.getFluid(L / 4))
                .outputItems(OPTICAL_CAPACITOR, 16)
                .duration(160)
                .EUt(VA[UV])
                //                .temperature(487)
                .cleanroom(CleanroomType.CLEANROOM)
                .save(provider);

        ASSEMBLER_RECIPES
                .recipeBuilder("optical_diode")
                .inputItems(dust, Terbium)
                .inputItems(wireFine, BorosilicateGlass, 4)
                .inputFluids(KaptonE.getFluid(L / 2))
                .outputItems(OPTICAL_DIODE, 16)
                .duration(160)
                .EUt(VA[UV])
                .cleanroom(CleanroomType.CLEANROOM)
                .save(provider);

        //        ION_IMPLANTATER_RECIPES.recipeBuilder("OPTICAL_INDUCTOR")
        //                .inputItems(dust, Silver, 4)
        //                .inputItems(plate, PMMA)
        //                .inputFluids(KaptonE.getFluid(L))
        //                .outputItems(OPTICAL_INDUCTOR, 16)
        //                .duration(160)
        //                .EUt(VA[UV])
        //                .cleanroom(CleanroomType.CLEANROOM)
        //                .save(provider);

        //        //  Optical Laser Control Unit
        //        ASSEMBLER_RECIPES.recipeBuilder("")
        //                .inputItems(OPTICAL_CIRCUIT_BOARD)
        //                .inputItems(HELIUM_LASER)
        //                .inputItems(NEON_LASER)
        //                .inputItems(ARGON_LASER)
        //                .inputItems(KRYPTON_LASER)
        //                .inputItems(XENON_LASER)
        //                .inputItems(ND_YAG_LASER)
        //                .inputItems(lens, Diamond, 2)
        //                .inputFluids(SolderingAlloy.getFluid(L))
        //                .outputItems(OPTICAL_LASER_CONTROL_UNIT)
        //                .duration(600)
        //                .EUt(VA[UHV])
        //                .cleanroom(CleanroomType.CLEANROOM)
        //                .save(provider);
        //
        //        ASSEMBLER_RECIPES.recipeBuilder("")
        //                .inputItems(OPTICAL_CIRCUIT_BOARD)
        //                .inputItems(HELIUM_NEON_LASER)
        //                .inputItems(ARGON_LASER)
        //                .inputItems(KRYPTON_LASER)
        //                .inputItems(XENON_LASER)
        //                .inputItems(ND_YAG_LASER)
        //                .inputItems(lens, Diamond, 2)
        //                .inputFluids(SolderingAlloy.getFluid(L))
        //                .outputItems(OPTICAL_LASER_CONTROL_UNIT)
        //                .duration(600)
        //                .EUt(VA[UHV])
        //                .cleanroom(CleanroomType.CLEANROOM)
        //                .save(provider);
        //
        //        //  Optical SoC
        //        MIXER_RECIPES.recipeBuilder("")
        //                .inputItems(dust, ManganeseDifluoride, 3)
        //                .inputItems(dust, ZincSulfide, 2)
        //                .inputItems(dust, TantalumPentoxide, 7)
        //                .inputItems(dust, Rutile, 3)
        //                .inputFluids(Ethanol.getFluid(1000))
        //                .outputFluids(ElectrolyteReflectorMixture.getFluid(1000))
        //                .EUt(VA[UHV])
        //                .duration(270)
        //                .cleanroom(CleanroomType.CLEANROOM)
        //                .save(provider);
        //
        //        CRYSTALLIZER_RECIPES.recipeBuilder("")
        //
        // .notConsumable(EPMetablocks.EP_CRUCIBLE_CASING.getItemVariant(EPBlockCrucibleCasing.CrucibleType.BORON_NITRIDE_CRUCIBLE))
        //                .inputItems(dust, StrontiumCarbonate, 64)
        //                .inputItems(dust, Bohrium, 8)
        //                .outputItems(STRONTIUM_CARBONATE_BOHRIUM_BOULE)
        //                .EUt(VA[ZPM])
        //                .duration(120)
        //                .blastFurnaceTemp(6000)
        //                .save(provider);
        //
        //        CUTTER_RECIPES.recipeBuilder("")
        //                .inputItems(STRONTIUM_CARBONATE_BOHRIUM_BOULE)
        //                .inputFluids(Lubricant.getFluid(300)) // TODO Biological Lubricant?
        //                .outputs(STRONTIUM_CARBONATE_BOHRIUM_WAFER.getStackForm(6))
        //                .EUt(VA[EV])
        //                .duration(200)
        //                .cleanroom(CleanroomType.CLEANROOM)
        //                .save(provider);
        //
        //        CHEMICAL_BATH_RECIPES.recipeBuilder("")
        //                .inputItems(STRONTIUM_CARBONATE_BOHRIUM_WAFER)
        //                .inputFluids(ElectrolyteReflectorMixture.getFluid(200))
        //                .outputItems(STRONTIUM_CARBONATE_OPTICAL_WAFER)
        //                .EUt(VA[UV])
        //                .duration(120)
        //                .cleanroom(CleanroomType.CLEANROOM)
        //                .save(provider);
        //
        //        //  Optical SoC
        //        PRECISE_ASSEMBLER_RECIPES.recipeBuilder("")
        //                .inputItems(STRONTIUM_CARBONATE_OPTICAL_WAFER)
        //                .inputItems(plate, PedotTMA)
        //                .inputItems(lens, Celestite, 2)
        //                .inputItems(dust, ZBLANGlass, 4)
        //                .inputFluids(SolderingAlloy.getFluid(L * 2))
        //                .inputFluids(TinAlloy.getFluid(L * 2))
        //                .outputItems(OPTICAL_IMC_BOARD, 2)
        //                .EUt(VA[UEV])
        //                .duration(400)
        //                .CasingTier(3)
        //                .save(provider);
        //
        //        PRECISE_ASSEMBLER_RECIPES.recipeBuilder("")
        //                .inputItems(OPTICAL_IMC_BOARD)
        //                .inputItems(UHASOC_CHIP, 2)
        //                .inputItems(OPTICAL_FIBER, 4)
        //                .inputFluids(Glowstone.getFluid(L * 2))
        //                .outputItems(PHOTOELECTRON_SOC)
        //                .EUt(VA[UEV])
        //                .duration(200)
        //                .CasingTier(3)
        //                .save(provider);
        //
        //        //  Optical Processor
        //        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder("")
        //                .inputItems(OPTICAL_LASER_CONTROL_UNIT)
        //                .inputItems(CRYSTAL_CENTRAL_PROCESSING_UNIT)
        //                .inputItems(OPTICAL_RESISTOR, 8)
        //                .inputItems(OPTICAL_CAPACITOR, 8)
        //                .inputItems(OPTICAL_TRANSISTOR, 8)
        //                .inputItems(OPTICAL_FIBER, 8)
        //                .outputItems(OPTICAL_PROCESSOR, 2)
        //                .solderMultiplier(1)
        //                .duration(200)
        //                .EUt(VA[UHV])
        //                .cleanroom(CleanroomType.CLEANROOM)
        //                .save(provider);
        //
        //        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder("")
        //                .inputItems(OPTICAL_CIRCUIT_BOARD)
        //                .inputItems(PHOTOELECTRON_SOC)
        //                .inputItems(wireFine, PedotPSS, 8)
        //                .inputItems(bolt, Adamantium, 8)
        //                .outputItems(OPTICAL_PROCESSOR, 2)
        //                .solderMultiplier(1)
        //                .duration(100)
        //                .EUt(VA[UEV])
        //                .cleanroom(CleanroomType.CLEANROOM)
        //                .save(provider);
        //
        //        //  Optical Assembly
        //        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder("")
        //                .inputItems(OPTICAL_CIRCUIT_BOARD)
        //                .inputItems(OPTICAL_PROCESSOR, 2)
        //                .inputItems(OPTICAL_INDUCTOR, 6)
        //                .inputItems(OPTICAL_CAPACITOR, 12)
        //                .inputItems(PHASE_CHANGE_MEMORY, 24)
        //                .inputItems(OPTICAL_FIBER, 16)
        //                .outputItems(OPTICAL_ASSEMBLY, 2)
        //                .solderMultiplier(2)
        //                .duration(400)
        //                .EUt(VA[UHV])
        //                .cleanroom(CleanroomType.CLEANROOM)
        //                .save(provider);
        //
        //        //  Optical Computer
        //        ASSEMBLY_LINE_RECIPES.recipeBuilder("")
        //                .inputItems(OPTICAL_CIRCUIT_BOARD)
        //                .inputItems(OPTICAL_ASSEMBLY, 2)
        //                .inputItems(OPTICAL_DIODE, 8)
        //                .inputItems(OPTICAL_NOR_MEMORY_CHIP, 16)
        //                .inputItems(PHASE_CHANGE_MEMORY, 32)
        //                .inputItems(OPTICAL_FIBER, 24)
        //                .inputItems(foil, KaptonE, 32)
        //                .inputItems(plate, Tritanium, 4)
        //                .inputFluids(SolderingAlloy.getFluid(L * 12))
        //                .inputFluids(Draconium.getFluid(L * 3))
        //                .outputItems(OPTICAL_COMPUTER)
        //                .duration(400)
        //                .EUt(VA[UHV])
        //                .stationResearch(b -> b
        //                        .researchStack(OPTICAL_ASSEMBLY.getStackForm())
        //                        .CWUt(64)
        //                        .EUt(VA[UHV]))
        //                .save(provider);
        //
        //        //  Optical Mainframe
        //        ASSEMBLY_LINE_RECIPES.recipeBuilder("")
        //                .inputItems(frameGt, Draconium, 2)
        //                .inputItems(OPTICAL_COMPUTER, 2)
        //                .inputItems(OPTICAL_DIODE, 16)
        //                .inputItems(OPTICAL_CAPACITOR, 16)
        //                .inputItems(OPTICAL_TRANSISTOR, 16)
        //                .inputItems(OPTICAL_RESISTOR, 16)
        //                .inputItems(OPTICAL_INDUCTOR, 16)
        //                .inputItems(foil, KaptonE, 64)
        //                .inputItems(PHASE_CHANGE_MEMORY, 32)
        //                .inputItems(wireGtDouble, Grisium, 16)
        //                .inputItems(plate, Tritanium, 8)
        //                .inputFluids(SolderingAlloy.getFluid(L * 20))
        //                .inputFluids(Kevlar.getFluid(L * 12))
        //                .inputFluids(Polyetheretherketone.getFluid(L * 9))
        //                .inputFluids(Draconium.getFluid(L * 6))
        //                .outputItems(OPTICAL_MAINFRAME)
        //                .duration(1200)
        //                .EUt(VA[UEV])
        //                .stationResearch(b -> b
        //                        .researchStack(OPTICAL_COMPUTER.getStackForm())
        //                        .CWUt(384)
        //                        .EUt(VA[UEV]))
        //                .save(provider);
    }
}
