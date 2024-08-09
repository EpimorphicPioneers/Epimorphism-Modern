package com.epimorphismmc.epimorphism.data.recipe.chains.oreprocessing;

import com.epimorphismmc.epimorphism.common.recipe.CPCasingCondition;
import com.epimorphismmc.epimorphism.data.recipe.EPRecipeUtil;

import com.gregtechceu.gtceu.api.data.chemical.ChemicalHelper;
import com.gregtechceu.gtceu.api.machine.multiblock.CleanroomType;

import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

import static com.epimorphismmc.epimorphism.api.data.tag.EPTagPrefix.*;
import static com.epimorphismmc.epimorphism.common.data.EPMaterials.*;
import static com.epimorphismmc.epimorphism.common.data.EPRecipeTypes.*;
import static com.gregtechceu.gtceu.api.GTValues.*;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.*;

/**
 * Naquadah Processing
 *
 * @author Magic_Sweepy (2024/02/20)
 *
 * <p>Produces Enriched Naquadah and Naquadria from Naquadah.</p>
 *
 * <p>Main Products: Enriched Naquadah, Naquadria</p>
 * <p>Side Products: Trinium, Indium</p>
 */
public class NaquadahProcessing {

    //  TODO Some recipe should be deleted (e.g. original naquadah -> solutions large chemical
    // recipes).
    //  Another TODO is: some old material should be deleted.

    public static void init(Consumer<FinishedRecipe> provider) {
        NaquadahChain(provider);
        EnrichedNaquadahChain(provider);
        NaquadriaChain(provider);
    }

    //  This is a basic processing about naquadah, though we can get naquadah dust by naquadah ore,
    //  we need some new method to get enriched naquadah and naquadria.
    private static void NaquadahChain(Consumer<FinishedRecipe> provider) {

        //  Step1: 2Nq + 3(HNO3)(HCl2) -> Nq2O3?
        DIGESTER_RECIPES
                .recipeBuilder("naquadah_oxide_mixture")
                .inputItems(crushed, Naquadah, 2)
                .inputFluids(AquaRegia.getFluid(3000))
                .outputItems(dust, NaquadahOxideMixture, 2)
                .EUt(VA[IV])
                .duration(280)
                .save(provider);

        //  Step2: Nq2O3? + 3HSbF6 -> (Nq2O3)?·3(HNO3) + TiF4 + 2HCl2 (cycle)
        CHEMICAL_RECIPES
                .recipeBuilder("low_purity_naquadah_solution")
                .inputItems(dust, NaquadahOxideMixture, 2)
                .inputFluids(FluoroantimonicAcid.getFluid(3000))
                .outputItems(dust, TitaniumTrifluoride, 4)
                .outputFluids(LowPurityNaquadahSolution.getFluid(1000))
                .outputFluids(HydrochloricAcid.getFluid(2000))
                .EUt(VA[EV])
                .duration(40)
                .save(provider);

        //  Step3: (Nq2O3)?·3(HNO3) -> Nq2O3 + HNO3 (cycle)
        //  In this step, you can electrolyze Extractive Naquadah Oxide to get naquadah,
        //  Well...this is ridiculous, but it still exists in naquadah processing.
        //  If you regret letting naquadah processing continue, stop here!
        CENTRIFUGE_RECIPES
                .recipeBuilder("extractive_naquadah_oxide") // todo Chemical Dryer?
                .inputFluids(LowPurityNaquadahSolution.getFluid(1000))
                .outputItems(dust, ExtractiveNaquadahOxide, 5)
                .outputFluids(NitricAcid.getFluid(1000))
                .EUt(VA[MV])
                .duration(25)
                .save(provider);

        //  Step4: Nq2O3 + NaOH + 6C16H35O4P + 2H2O -> 10Nq(OH)3?
        MIXER_RECIPES
                .recipeBuilder("naquadah_hydroxides_solution")
                .inputItems(dust, ExtractiveNaquadahOxide, 5)
                .inputItems(dust, SodiumHydroxide, 3)
                .inputFluids(DiethylhexylPhosphoricAcid.getFluid(6000))
                .inputFluids(Water.getFluid(2000))
                .outputFluids(NaquadahHydroxidesSolution.getFluid(10000))
                .EUt(VA[IV])
                .duration(400)
                .save(provider);

        //  Sub chain of Step4, this sub chain produces Di-(2-ethylhexyl) phosphoric Acid.
        DiethylhexylPhosphoricAcidChain(provider);

        //  Step5: 5Nq(OH)3? -> Nq+Ke? + 3C16H35O4P (cycle)
        CENTRIFUGE_RECIPES
                .recipeBuilder("naquadah_hydroxides_solution_split")
                .inputFluids(NaquadahHydroxidesSolution.getFluid(5000))
                .outputItems(dust, ConcentrateEnrichedNaquadahMixture, 8)
                .outputFluids(ImpureNaquadahMixtureSolution.getFluid(1000))
                .outputFluids(DiethylhexylPhosphoricAcid.getFluid(3000))
                .EUt(VH[LuV])
                .duration(100)
                //                .addCondition(new NeutronKineticEnergyCondition(325 * K, 800 * K))
                .save(provider);
    }

    private static void EnrichedNaquadahChain(Consumer<FinishedRecipe> provider) {

        //  Step1: Nq+Ke? + 6F -> Nq+KeF6? + Fe2KeIn
        CHEMICAL_RECIPES
                .recipeBuilder("hexafluoride_enriched_naquadah_solution")
                .inputItems(dust, ConcentrateEnrichedNaquadahMixture, 8)
                .inputFluids(Fluorine.getFluid(6000))
                .outputItems(dust, DeepIron, 4)
                .outputFluids(HexafluorideEnrichedNaquadahSolution.getFluid(1000))
                .EUt(VA[IV])
                .duration(400)
                .save(provider);

        //  Step2: Nq+KeF6? + Xe -> XeNq+F6
        CHEMICAL_RECIPES
                .recipeBuilder("xenon_hexafluoro_enriched_naquadate")
                .inputFluids(HexafluorideEnrichedNaquadahSolution.getFluid(1000))
                .inputFluids(Xenon.getFluid(1000))
                .outputFluids(XenonHexafluoroEnrichedNaquadate.getFluid(1000))
                .EUt(VA[HV])
                .duration(200)
                .cleanroom(CleanroomType.CLEANROOM)
                .save(provider);

        //  Step3: AuF3 + XeNq+F6 + HSbF6 + 9H - Pd-C catalyst -> (solutions...) + 8H
        EPRecipeUtil.chemicalPlantRecipe(
                        "enriched_naquadah_solution",
                        CPCasingCondition.TUNGSTEN_STEEL,
                        ChemicalHelper.get(catalyst, PalladiumOnCarbon).getItem())
                .inputItems(dust, GoldTrifluoride, 4)
                .inputFluids(XenonHexafluoroEnrichedNaquadate.getFluid(1000))
                .inputFluids(FluoroantimonicAcid.getFluid(1000))
                .inputFluids(Hydrogen.getFluid(9000))
                .outputFluids(EnrichedNaquadahSolution.getFluid(1000))
                .outputFluids(EnrichedNaquadahResidueSolution.getFluid(1000))
                .outputFluids(HydrofluoricAcid.getFluid(8000))
                .EUt(VA[LuV])
                .duration(1200)
                .save(provider);

        //  Au + 3F -> AuF3
        CHEMICAL_RECIPES
                .recipeBuilder("gold_trifluoride")
                .inputItems(dust, Gold)
                .inputFluids(Fluorine.getFluid(3000))
                .circuitMeta(3)
                .outputItems(dust, GoldTrifluoride, 4)
                .EUt(VA[MV])
                .duration(90)
                .save(provider);

        //  Sub chain of Step3, this sub chain produces Pd-C catalyst.
        PdCCatalystChain(provider);

        //  XeAuSbF6S2? -> XeAuSbF6
        //  Just cycle of other materials
        CHEMICAL_RECIPES
                .recipeBuilder("xenoauric_fluoroantimonic_acid") // todo Chemical Dryer?
                .inputFluids(EnrichedNaquadahResidueSolution.getFluid(1000))
                .outputItems(dust, Sulfur, 2)
                .outputFluids(XenoauricFluoroantimonicAcid.getFluid(1000))
                .EUt(VA[EV])
                .duration(480)
                .save(provider);

        //  Then back to vanilla electrolyzer recipe.
    }

    private static void NaquadriaChain(Consumer<FinishedRecipe> provider) {

        //  Step1: Impure to pure for Naquadah Mixture Solution
        CENTRIFUGE_RECIPES
                .recipeBuilder("pure_naquadah_mixture_solution")
                .inputFluids(ImpureNaquadahMixtureSolution.getFluid(1000))
                .outputFluids(PureNaquadriaMixtureSolution.getFluid(1000))
                .EUt(VA[EV])
                .duration(200)
                .save(provider);

        //  Step2: *Nq*? + 6F -> *Nq*F6
        CHEMICAL_RECIPES
                .recipeBuilder("hexafluoride_naquadria_solution")
                .inputFluids(PureNaquadriaMixtureSolution.getFluid(1000))
                .inputFluids(Fluorine.getFluid(6000))
                .outputFluids(HexafluorideNaquadriaSolution.getFluid(1000))
                .EUt(VA[IV])
                .duration(400)
                .save(provider);

        //  Step3: *Nq*F6 + RnF2 -> Rn*Nq*F8 + InPS6?
        CHEMICAL_RECIPES
                .recipeBuilder("radon_naquadria_octafluoride")
                .inputFluids(HexafluorideNaquadriaSolution.getFluid(1000))
                .inputFluids(RadonDifluoride.getFluid(1000))
                .outputFluids(RadonNaquadriaOctafluoride.getFluid(1000))
                .outputFluids(NaquadriaResidueSolution.getFluid(1000))
                .EUt(VA[HV])
                .duration(800)
                .cleanroom(CleanroomType.CLEANROOM)
                .save(provider);

        //  Rn + 2F -> RnF2
        CHEMICAL_RECIPES
                .recipeBuilder("radon_difluoride")
                .inputFluids(Radon.getFluid(1000))
                .inputFluids(Fluorine.getFluid(2000))
                .circuitMeta(2)
                .outputFluids(RadonDifluoride.getFluid(1000))
                .EUt(VA[MV])
                .duration(100)
                .save(provider);

        NaquadriaResidueSolutionCycle(provider);

        //  Step4: Rn*Nq*F8 + CsXeO3F -> *Nq*CsXeF9 + RnO3
        CHEMICAL_RECIPES
                .recipeBuilder("naquadria_caesium_xenonnonfluoride")
                .inputFluids(RadonNaquadriaOctafluoride.getFluid(1000))
                .inputFluids(CaesiumXenontrioxideFluoride.getFluid(1000))
                .outputFluids(NaquadriaCaesiumXenonnonfluoride.getFluid(1000))
                .outputFluids(RadonTrioxide.getFluid(1000))
                .EUt(VA[IV])
                .duration(400)
                .cleanroom(CleanroomType.CLEANROOM)
                .save(provider);

        CaesiumXenontrioxideFluorideChain(provider);

        //  Step5: *Nq*CsXeF9 + NO2F -> *Nq*F2CsF + (NO2)2XeF8
        CHEMICAL_RECIPES
                .recipeBuilder("naquadria_caesiumfluoride") // todo Cryogenic Reacto?
                .inputFluids(NaquadriaCaesiumXenonnonfluoride.getFluid(1000))
                .inputFluids(NitrylFluoride.getFluid(2000))
                .outputFluids(NaquadriaCaesiumfluoride.getFluid(1000))
                .outputFluids(NitrosoniumOctafluoroxenate.getFluid(1000))
                .EUt(VA[EV])
                .duration(400)
                //  todo 75 K temperature
                .cleanroom(CleanroomType.CLEANROOM)
                .save(provider);

        //  NO2 + F -> NO2F
        CHEMICAL_RECIPES
                .recipeBuilder("nitryl_fluoride")
                .inputFluids(NitrogenDioxide.getFluid(1000))
                .inputFluids(Fluorine.getFluid(1000))
                .outputFluids(NitrylFluoride.getFluid(1000))
                .EUt(VA[MV])
                .duration(160)
                .save(provider);

        //  Step6: *Nq*F2CsF + 2H2SO4 -> 3*Nq*F2CsF(SO4)2
        MIXER_RECIPES
                .recipeBuilder("acidic_naquadria_caesiumfluoride")
                .inputFluids(NaquadriaCaesiumfluoride.getFluid(1000))
                .inputFluids(SulfuricAcid.getFluid(2000))
                .outputFluids(AcidicNaquadriaCaesiumfluoride.getFluid(3000))
                .EUt(VA[IV])
                .duration(360)
                .save(provider);

        //  *Nq*F2CsF(SO4)2 -> *NqSo4* + Cs + 3F
        ELECTROLYZER_RECIPES
                .recipeBuilder("acidic_naquadria_caesiumfluoride_cycle")
                .inputFluids(AcidicNaquadriaCaesiumfluoride.getFluid(1000))
                .outputItems(dust, NaquadriaSulfate, 6)
                .outputItems(dust, Caesium)
                .outputFluids(Fluorine.getFluid(3000))
                .EUt(VA[LuV])
                .duration(120)
                .save(provider);

        //  Acidic Naquadria Solution Cycle
        CHEMICAL_RECIPES
                .recipeBuilder("acidic_naquadria_solution_cycle") // todo Burner Reactor or Roaster?
                .inputFluids(AcidicNaquadriaSolution.getFluid(3000))
                .outputFluids(NaquadriaWaste.getFluid(1000))
                .outputFluids(ImpureEnrichedNaquadahSolution.getFluid(1000))
                .EUt(VA[ZPM])
                .duration(1000)
                //  todo 1280 K temperature
                .save(provider);
    }

    private static void DiethylhexylPhosphoricAcidChain(Consumer<FinishedRecipe> provider) {

        //  2C4H8O + 4H -> C8H18O + H2O (lost)
        MIXER_RECIPES
                .recipeBuilder("ethylhexanol")
                .inputFluids(Butyraldehyde.getFluid(2000))
                .inputFluids(Hydrogen.getFluid(4000))
                .outputFluids(Ethylhexanol.getFluid(1000))
                .EUt(VA[MV])
                .duration(80)
                .save(provider);

        //  5C8H18O + 0.5P4O10 -> 2C16H35O4P + 2C4H10 + 2O (lost)
        CHEMICAL_RECIPES
                .recipeBuilder("diethylhexyl_phosphoric_acid")
                .inputFluids(Ethylhexanol.getFluid(5000))
                .inputItems(dust, PhosphorusPentoxide, 7)
                .outputFluids(DiethylhexylPhosphoricAcid.getFluid(2000))
                .outputFluids(Butane.getFluid(2000))
                .EUt(16)
                .duration(600)
                .save(provider);
    }

    private static void PdCCatalystChain(Consumer<FinishedRecipe> provider) {

        //  Pd + 2Cl -> PdCl2
        CHEMICAL_RECIPES
                .recipeBuilder("palladium_chloride")
                .inputItems(dust, Palladium)
                .inputFluids(Chlorine.getFluid(2000))
                .circuitMeta(2)
                .outputItems(dust, PalladiumChloride, 3)
                .EUt(VA[MV])
                .duration(320)
                .save(provider);

        //  PdCl2 + C + CH2O + HCl -> Pd-C catalyst
        // TODO: 等待GTM更新后添加回来
        //        CHEMICAL_RECIPES.recipeBuilder("palladium_on_carbon")
        //                .inputItems(dust, PalladiumChloride)
        //                .inputItems(dust, Carbon)
        //                .inputFluids(Formaldehyde.getFluid(1000))
        //                .inputFluids(HydrochloricAcid.getFluid(1000))
        //                .outputItems(dust, PalladiumOnCarbon)
        //                .EUt(VH[EV])
        //                .duration(100)
        //                .save(provider);
    }

    private static void NaquadriaResidueSolutionCycle(Consumer<FinishedRecipe> provider) {

        CHEMICAL_RECIPES
                .recipeBuilder("naquadria_residue_solution_cycle") // todo Chemical Dryer or Burner Reactor?
                .inputFluids(NaquadriaResidueSolution.getFluid(2000))
                .outputItems(dust, IndiumPhosphide)
                .outputFluids(NaquadriaSolution.getFluid(1000))
                .EUt(VA[IV])
                .duration(1200)
                //  todo 880 K temperature
                .save(provider);

        CHEMICAL_RECIPES
                .recipeBuilder("naquadria_solution_cycle") // todo Chemical Dryer?
                .inputFluids(NaquadriaSolution.getFluid(3000))
                .outputItems(dust, Sulfur, 6)
                .outputFluids(NaquadriaWaste.getFluid(1000))
                .EUt(VA[HV])
                .duration(100)
                .save(provider);
    }

    private static void CaesiumXenontrioxideFluorideChain(Consumer<FinishedRecipe> provider) {

        //  Cs + F -> CsF
        CHEMICAL_RECIPES
                .recipeBuilder("caesium_fluoride")
                .inputItems(dust, Caesium)
                .inputFluids(Fluorine.getFluid(1000))
                .circuitMeta(1)
                .outputFluids(CaesiumFluoride.getFluid(1000))
                .EUt(VA[MV])
                .duration(100)
                .save(provider);

        //  Xe + O3 -> XeO3
        CHEMICAL_RECIPES
                .recipeBuilder("xenon_trioxide")
                .inputFluids(Xenon.getFluid(1000))
                .inputFluids(Oxygen.getFluid(3000))
                .outputFluids(XenonTrioxide.getFluid(1000))
                .EUt(VA[MV])
                .duration(100)
                .save(provider);

        //  CsF + XeO3 -> CsXeO3F
        CHEMICAL_RECIPES
                .recipeBuilder("caesium_xenontrioxide_fluoride")
                .inputFluids(CaesiumFluoride.getFluid(1000))
                .inputFluids(XenonTrioxide.getFluid(1000))
                .outputFluids(CaesiumXenontrioxideFluoride.getFluid(1000))
                .EUt(VA[MV])
                .duration(480)
                .save(provider);
    }
}
