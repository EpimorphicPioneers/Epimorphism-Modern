package cn.gtcommunity.epimorphism.data.recipe.circuits;

import com.gregtechceu.gtceu.api.machine.multiblock.CleanroomType;
import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

import static cn.gtcommunity.epimorphism.common.data.EPMaterials.*;
import static cn.gtcommunity.epimorphism.common.data.EPRecipeTypes.*;
import static com.gregtechceu.gtceu.api.GTValues.*;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.*;
import static com.gregtechceu.gtceu.api.GTValues.*;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.*;
import static com.gregtechceu.gtceu.common.data.GTBlocks.*;
import static com.gregtechceu.gtceu.common.data.GTItems.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.ASSEMBLER_RECIPES;

public class CosmicCircuits {
    public static void init(Consumer<FinishedRecipe> provider) {
        /*
         * Creates a recipe for the Cosmic Board.
         *
         * @author Xing_luo (2024/03/22)
         */

        //  Cosmic Board
        //  TODO Require Space Environment?
//        ASSEMBLER_RECIPES.recipeBuilder("cosmic_board")
//                .inputItems(plate, DegenerateRhenium, 3)
//                .inputItems(plate, HeavyQuarkDegenerateMatter, 2)
//                .inputItems(wireFine, Infinity, 6)
//                .inputFluids(CosmicComputingMixture.getFluid(1000))
//                .outputItems(COSMIC_INFORMATION_MODULE)
//                .EUt(VA[UIV])
//                .duration(350)
//                .save(provider);

        //  Cladded Optical Fiber Core
//        FORMING_PRESS_RECIPES.recipeBuilder("cladded_optical_fiber_core")
//                .inputItems(wireFine, ZBLANGlass)
//                .inputItems(plate, GSTGlass)
//                .inputItems(plate, Zylon, 2)
//                .outputItems(CLADDED_OPTICAL_FIBER_CORE)
//                .EUt(VA[LuV])
//                .duration(600)
//                .save(provider);

        //  Caesium + Iodine -> Caesium Iodide
        CHEMICAL_RECIPES.recipeBuilder("caesium_iodide")
                .inputItems(dust, Caesium)
                .inputItems(dust, Iodine)
                .outputItems(dust, CaesiumIodide, 2)
                .EUt(VA[MV])
                .duration(340)
                .save(provider);

        //  Caesium Iodide + Thallium + Thulium -> Tl-Tm-droped Caesium Iodide
        BLAST_RECIPES.recipeBuilder("tl_tm_droped_caesium_iodide")
                .inputItems(dust, CaesiumIodide)
                .inputItems(dustSmall, Thallium, 2)
                .inputItems(dustSmall, Thulium, 2)
                .outputItems(dust, TlTmDropedCaesiumIodide, 2)
                .EUt(VA[HV])
                .duration(260)
                .blastFurnaceTemp(2853)
                .save(provider);

        //  Anthracene
        DISTILLERY_RECIPES.recipeBuilder("anthracene")
                .inputFluids(HighlyPurifiedCoalTar.getFluid(20))
                .circuitMeta(0)
                .outputFluids(Anthracene.getFluid(5))
                .EUt(VA[MV])
                .duration(100)
                .save(provider);

        //  Dimethylnaphthalene
        CHEMICAL_RECIPES.recipeBuilder("dimethylnaphthalene")
                .inputFluids(Naphthalene.getFluid(1000))
                .inputFluids(Methanol.getFluid(2000))
                .outputFluids(Dimethylnaphthalene.getFluid(1000))
                .outputFluids(Water.getFluid(2000))
                .EUt(VA[EV])
                .duration(240)
                .save(provider);

        //  Acetylating Reagent
        LARGE_CHEMICAL_RECIPES.recipeBuilder("acetylating_reagent")
                .inputItems(dust, MagnesiumChloride, 6)
                .inputFluids(Acetylene.getFluid(3000))
                .inputFluids(Trimethylchlorosilane.getFluid(1000))
                .inputFluids(Bromine.getFluid(2000))
                .outputFluids(AcetylatingReagent.getFluid(1000))
                .outputFluids(Chlorine.getFluid(2000))
                .outputFluids(HydrochloricAcid.getFluid(3000))
                .EUt(VA[IV])
                .duration(350)
                .save(provider);

        //  Iodine Monochloride
        CHEMICAL_RECIPES.recipeBuilder("iodine_monochloride")
                .inputItems(dust, Iodine)
                .inputFluids(Chlorine.getFluid(1000))
                .outputFluids(IodineMonochloride.getFluid(1000))
                .EUt(VA[MV])
                .duration(240)
                .save(provider);

        //  Rh-Re-Nq Catalyst
        MIXER_RECIPES.recipeBuilder("rh_re_nq_catalyst")
                .inputItems(dust, Rhodium)
                .inputItems(dust, Rhenium)
                .inputItems(dust, Naquadah)
                .outputItems(dust, RhReNqCatalyst, 3)
                .EUt(VA[ZPM])
                .duration(260)
                .save(provider);

        //  Dihydroiodotetracene
//        CHEMICAL_PLANT_RECIPES.recipeBuilder("dihydroiodotetracene")
//                .notConsumable(dust, RhReNqCatalyst)
//                .inputItems(dust, BromoSuccinimide, 12)
//                .inputFluids(Dimethylnaphthalene.getFluid(1000))
//                .inputFluids(AcetylatingReagent.getFluid(1000))
//                .inputFluids(IodineMonochloride.getFluid(1000))
//                .inputFluids(Chlorine.getFluid(2000))
//                .outputItems(dust, MagnesiumChlorideBromide, 6)
//                .outputItems(dust, Succinimide, 12)
//                .outputFluids(Dihydroiodotetracene.getFluid(1000))
//                .outputFluids(Trimethylchlorosilane.getFluid(1000))
//                .outputFluids(HydrobromicAcid.getFluid(1000))
//                .EUt(VA[ZPM])
//                .duration(290)
//                .CasingTier(4)
//                .save(provider);

        //  Dichlorodicyanobenzoquinone
//        LARGE_CHEMICAL_RECIPES.recipeBuilder("dichlorodicyanobenzoquinone")
//                .inputFluids(Phenol.getFluid(1000))
//                .inputFluids(Chlorine.getFluid(10000))
//                .inputFluids(HydrogenCyanide.getFluid(2000))
//                .inputFluids(Oxygen.getFluid(1000))
//                .outputFluids(Dichlorodicyanobenzoquinone.getFluid(1000))
//                .outputFluids(HydrochloricAcid.getFluid(8000))
//                .EUt(VA[LuV])
//                .duration(250)
//                .save(provider);

        //  Dichlorodicyanohydroquinone -> Dichlorodicyanobenzoquinone cycle
        CHEMICAL_RECIPES.recipeBuilder("dichlorodicyanobenzoquinone_cycle")
                .notConsumable(dust, Vanadium)
                .inputFluids(Dichlorodicyanohydroquinone.getFluid(1000))
                .inputFluids(HydrogenPeroxide.getFluid(1000))
                .outputFluids(Dichlorodicyanobenzoquinone.getFluid(1000))
                .outputFluids(Water.getFluid(2000))
                .EUt(VA[EV])
                .duration(250)
                .save(provider);

        //  Isopropyl Alcohol
        CHEMICAL_RECIPES.recipeBuilder("isopropyl_alcohol")
                .notConsumable(dust, SodiumPhosphomolybdate)
                .notConsumable(dust, SodiumPhosphotungstate)
                .inputFluids(Propene.getFluid(1000))
                .inputFluids(Water.getFluid(1000))
                .outputFluids(IsopropylAlcohol.getFluid(1000))
                .EUt(VA[LuV])
                .duration(100)
                .save(provider);

        //  Tetracene
//        ULTRAVIOLET_LAMP_CHAMBER_RECIPES.recipeBuilder("tetracene")
//                .notConsumable(lens, Prasiolite)
//                .notConsumable(dust, Rutile) // TODO Nanoparticles?
//                .inputFluids(Dihydroiodotetracene.getFluid(2000))
//                .inputFluids(Dichlorodicyanobenzoquinone.getFluid(2000))
//                .inputFluids(IsopropylAlcohol.getFluid(1000))
//                .outputItems(dust, Tetracene, 60)
//                .outputItems(dust, Iodine, 2)
//                .outputFluids(Acetone.getFluid(1000))
//                .outputFluids(Dichlorodicyanohydroquinone.getFluid(2000))
//                .EUt(VA[UV])
//                .duration(260)
//                .cleanroom(CleanroomType.CLEANROOM)
//                .save(provider);

        //  Polycyclic Aromatic Mixture
        MIXER_RECIPES.recipeBuilder("polycyclic_aromatic_mixture")
                .inputItems(dust, Tetracene, 2)
                .inputFluids(Anthracene.getFluid(1000))
                .outputItems(dust, PolycyclicAromaticMixture, 3)
                .EUt(VA[IV])
                .duration(240)
                .save(provider);

        //  Cadmium Tungstate
        BLAST_RECIPES.recipeBuilder("cadmium_tungstate")
                .inputItems(dust, TungstenTrioxide, 4)
                .inputItems(dust, CadmiumSulfide, 2)
                .inputFluids(Oxygen.getFluid(3000))
                .outputItems(dust, CadmiumTungstate, 6)
                .outputFluids(SulfurDioxide.getFluid(1000))
                .EUt(VA[EV])
                .duration(320)
                .blastFurnaceTemp(2800)
                .save(provider);

        //  Bismuth Germanate
//        ULTRAVIOLET_LAMP_CHAMBER_RECIPES.recipeBuilder("bismuth_germanate")
//                .inputItems(dust, GermaniumDioxide, 3)
//                .notConsumable(lens, NdYAG)
//                .inputFluids(BismuthNitrateSolution.getFluid(4000))
//                .outputItems(dust, BismuthGermanate, 33)
//                .outputItems(dust, Potash, 18)
//                .outputFluids(NitrogenDioxide.getFluid(12000))
//                .outputFluids(Water.getFluid(4000))
//                .EUt(VA[UV])
//                .duration(80)
//                .save(provider);

        //  Scintillator Crystal
//        FORMING_PRESS_RECIPES.recipeBuilder("scintillator_crystal")
//                .inputItems(plate, Vibranium, 2)
//                .inputItems(dust, TlTmDropedCaesiumIodide)
//                .inputItems(dust, PolycyclicAromaticMixture)
//                .inputItems(dust, CadmiumTungstate)
//                .inputItems(dust, BismuthGermanate)
//                .outputItems(SCINTILLATOR_CRYSTAL)
//                .EUt(VA[UHV])
//                .duration(280)
//                .cleanroom(CleanroomType.CLEANROOM)
//                .save(provider);

        //  Scintillator
//        PRECISE_ASSEMBLER_RECIPES.recipeBuilder("scintillator")
//                .inputItems(SCINTILLATOR_CRYSTAL)
//                .inputItems(SEPARATION_ELECTROMAGNET)
//                .inputItems(plate, Zylon, 2)
//                .inputItems(screw, Hdcs, 4)
//                .inputFluids(SolderingAlloy.getFluid(L * 8))
//                .inputFluids(Kevlar.getFluid(L * 4))
//                .outputItems(SCINTILLATOR)
//                .EUt(VA[UHV])
//                .duration(120)
//                .CasingTier(3)
//                .save(provider);

        //  Nuclear Clock
//        PRECISE_ASSEMBLER_RECIPES.recipeBuilder("nuclear_clock")
//                .inputItems(SCINTILLATOR)
//                .inputItems(SENSOR_UIV, 2)
//                .inputItems(ND_YAG_LASER, 2)
//                .inputItems(lens, YttriumVanadateLuTm)
//                .inputFluids(Adamantium.getFluid(L * 9))
//                .inputFluids(Thorium.getFluid(L))
//                .outputItems(NUCLEAR_CLOCK)
//                .EUt(VA[UEV])
//                .duration(35)
//                .CasingTier(3)
//                .save(provider);

        //  Closed Time-like Curve Guidance Unit
//        PRECISE_ASSEMBLER_RECIPES.recipeBuilder("closed_time_like_curve_guidance_unit")
//                .inputItems(NUCLEAR_CLOCK)
//                .inputItems(TOOL_DATA_MODULE)
//                .inputItems(SPIN_TRANSFER_TORQUE_MEMORY, 16)
//                .inputItems(wireFine, Grisium, 8)
//                .inputFluids(Zylon.getFluid(L * 10))
//                .inputFluids(MagnetoHydrodynamicallyConstrainedStarMatter.getFluid(L))
//                .outputItems(CLOSED_TIMELIKE_CURVE_GUIDANCE_UNIT)
//                .EUt(VA[UIV])
//                .duration(400)
//                .CasingTier(3)
//                .save(provider);

        //  Manifold Oscillatory Power Cell
//        DIMENSIONAL_OSCILLATOR_RECIPES.recipeBuilder("manifold_oscillatory_power_cell")
//                .inputItems(QUANTUM_ANOMALY)
//                .inputItems(plate, HeavyQuarkDegenerateMatter)
//                .inputFluids(FreeElectronGas.getFluid(16000))
//                .inputFluids(Taranium.getFluid(L * 4))
//                .outputItems(MANIFOLD_OSCILLATORY_POWER_CELL, 16)
//                .EUt(VA[UEV])
//                .duration(200)
//                .save(provider);

        //  Closed Time-like Curve Computational Unit
//        ASSEMBLY_LINE_RECIPES.recipeBuilder("closed_time_like_curve_computational_unit")
//                .inputItems(frameGt, Neutronium)
//                .inputItems(CLOSED_TIMELIKE_CURVE_GUIDANCE_UNIT)
//                .inputItems(MANIFOLD_OSCILLATORY_POWER_CELL, 4)
//                .inputItems(plate, MagnetoHydrodynamicallyConstrainedStarMatter, 4)
//                .inputItems(plate, AstralTitanium, 4)
//                .inputItems(plate, CelestialTungsten, 4)
//                .inputItems(FIELD_GENERATOR_UHV, 2)
//                .inputItems(wireFine, CosmicNeutronium, 16)
//                .inputFluids(SuperheavyHAlloy.getFluid(L * 4))
//                .inputFluids(SuperheavyLAlloy.getFluid(L * 4))
//                .inputFluids(CosmicComputingMixture.getFluid(L * 2))
//                .inputFluids(CosmicNeutronium.getFluid(L))
//                .outputItems(CLOSED_TIMELIKE_CURVE_COMPUTATIONAL_UNIT)
//                .stationResearch(b -> b
//                        .researchStack(CLOSED_TIMELIKE_CURVE_GUIDANCE_UNIT.getStackForm())
//                        .EUt(VA[UIV])
//                        .CWUt(576))
//                .EUt(VA[UIV])
//                .duration(1000)
//                .save(provider);

        //  Cosmic Circuit Board
//        ASSEMBLY_LINE_RECIPES.recipeBuilder("cosmic_circuit_board")
//                .inputItems(COSMIC_INFORMATION_MODULE)
//                .inputItems(frameGt, BlackTitanium)
//                .inputItems(CLOSED_TIMELIKE_CURVE_COMPUTATIONAL_UNIT)
//                .inputItems(CLADDED_OPTICAL_FIBER_CORE, 8)
//                .inputItems(BOSE_EINSTEIN_CONDENSATE, 4)
//                .inputItems(wireGtSingle, BlackDwarfMatter, 8)
//                .inputFluids(SolderingAlloy.getFluid(L * 16))
//                .inputFluids(Zylon.getFluid(L * 10))
//                .inputFluids(QuantumAlloy.getFluid(L * 4))
//                .inputFluids(WhiteDwarfMatter.getFluid(L * 2))
//                .outputItems(HOLOGRAPHIC_INFORMATION_IMC)
//                .stationResearch(b -> b
//                        .researchStack(COSMIC_INFORMATION_MODULE.getStackForm())
//                        .EUt(VA[UIV])
//                        .CWUt(1024))
//                .EUt(VA[UIV])
//                .duration(200)
//                .save(provider);

        //  Cosmic SMDs
//        ASSEMBLER_RECIPES.recipeBuilder("cosmic_transistor")
//                .inputItems(wireFine, RutheniumTriniumAmericiumNeutronate, 8)
//                .inputItems(plate, DegenerateRhenium)
//                .inputItems(plate, MetastableHassium)
//                .inputFluids(Zylon.getFluid(L * 2))
//                .outputItems(COSMIC_TRANSISTOR, 32)
//                .EUt(VA[UEV])
//                .duration(160)
//                .cleanroom(CleanroomType.CLEANROOM)
//                .save(provider);

//        CVD_RECIPES.recipeBuilder("cosmic_resistor")
//                .inputItems(wireFine, SuperheavyLAlloy, 4)
//                .inputItems(dust, LanthanumFullereneNanotube)
//                .inputFluids(FullerenePolymerMatrix.getFluid(L * 2))
//                .outputItems(COSMIC_RESISTOR, 32)
//                .EUt(VA[UEV])
//                .duration(160)
//                .temperature(4960)
//                .cleanroom(CleanroomType.CLEANROOM)
//                .save(provider);

//        LASER_CVD_RECIPES.recipeBuilder("cosmic_capacitor")
//                .inputItems(wireFine, SuperheavyHAlloy, 8)
//                .inputItems(plate, Rhugnor)
//                .inputFluids(Zylon.getFluid(L * 2))
//                .outputItems(COSMIC_CAPACITOR, 32)
//                .EUt(VA[UEV])
//                .duration(160)
//                .temperature(5630)
//                .cleanroom(CleanroomType.CLEANROOM)
//                .save(provider);

//        ION_IMPLANTATER_RECIPES.recipeBuilder("cosmic_inductor")
//                .inputItems(ring, Legendarium)
//                .inputItems(wireFine, Infinity, 4)
//                .inputFluids(FullerenePolymerMatrix.getFluid(L * 2))
//                .outputItems(COSMIC_INDUCTOR, 32)
//                .EUt(VA[UEV])
//                .duration(160)
//                .cleanroom(CleanroomType.CLEANROOM)
//                .save(provider);

//        ASSEMBLER_RECIPES.recipeBuilder("cosmic_diode")
//                .inputItems(dust, BETSPerrhenate)
//                .inputItems(dust, BoronFranciumMixture)
//                .inputItems(wireFine, CosmicNeutronium, 8)
//                .inputFluids(Zylon.getFluid(L * 2))
//                .outputItems(COSMIC_DIODE, 32)
//                .EUt(VA[UEV])
//                .duration(160)
//                .cleanroom(CleanroomType.CLEANROOM)
//                .save(provider);

        //  Cosmic Processor
        //  TODO Require Space Environment?
//        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder("cosmic_processor")
//                .inputItems(HOLOGRAPHIC_INFORMATION_IMC)
//                .inputItems(INTRAVITAL_SOC)
//                .inputItems(COSMIC_RESISTOR, 8)
//                .inputItems(COSMIC_CAPACITOR, 8)
//                .inputItems(COSMIC_TRANSISTOR, 8)
//                .inputItems(wireFine, CosmicNeutronium, 8)
//                .solderMultiplier(1)
//                .outputItems(COSMIC_PROCESSOR, 2)
//                .EUt(VA[UIV])
//                .duration(200)
//                .cleanroom(CleanroomType.CLEANROOM)
//                .save(provider);

        //  Cosmic Assembly
        //  TODO Require Space Environment?
//        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder("cosmic_assembly")
//                .inputItems(COSMIC_INFORMATION_MODULE)
//                .inputItems(COSMIC_PROCESSOR, 2)
//                .inputItems(COSMIC_INDUCTOR, 6)
//                .inputItems(COSMIC_CAPACITOR, 12)
//                .inputItems(SPIN_TRANSFER_TORQUE_MEMORY, 24) //TODO new RAM
//                .inputItems(wireFine, CosmicNeutronium, 8)
//                .solderMultiplier(2)
//                .outputItems(COSMIC_ASSEMBLY, 2)
//                .EUt(VA[UIV])
//                .duration(400)
//                .cleanroom(CleanroomType.CLEANROOM)
//                .save(provider);
    }
}
