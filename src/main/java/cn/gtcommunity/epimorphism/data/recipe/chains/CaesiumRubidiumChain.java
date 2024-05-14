//package cn.gtcommunity.epimorphism.data.recipe.chains;
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
//public class CaesiumRubidiumChain {
//    public static void init(Consumer<FinishedRecipe> provider) {
//        //  Pollucite + Hydrochloric Acid -> Alumina + Silicon Dioxide + Heavy Alkali Chloride Solution
//        CHEMICAL_BATH_RECIPES.recipeBuilder("alumina_and_silicon_dioxide_and_heavy_alkali_chloride_solution")
//                .inputItems(dust, Pollucite, 10)
//                .inputFluids(HydrochloricAcid.getFluid(3000))
//                .outputItems(dust, Alumina)
//                .outputItems(dust, SiliconDioxide, 4)
//                .outputFluids(HeavyAlkaliChlorideSolution.getFluid(1000))
//                .duration(400)
//                .EUt(VA[EV])
//                .save(provider);
//
//        //  Tin + Chlorine -> Tin Chloride
//        BURNER_REACTOR_RECIPES.recipeBuilder("tin_chloride_1")
//                .inputItems(dust, Tin)
//                .inputFluids(Chlorine.getFluid(2000))
//                .circuitMeta(1)
//                .outputFluids(TinChloride.getFluid(1000))
//                //.temperature(294)
//                .duration(100)
//                .EUt(VA[MV])
//                .save(provider);
//
//        //  Tin + Chlorine -> Stannic Chloride
//        BURNER_REACTOR_RECIPES.recipeBuilder("stannic_chloride")
//                .inputItems(dust, Tin)
//                .inputFluids(Chlorine.getFluid(4000))
//                .circuitMeta(2)
//                .outputFluids(StannicChloride.getFluid(1000))
//                .duration(100)
//                .EUt(VA[HV])
//                //.temperature(388)
//                .save(provider);
//
//        //  Stannic Chloride -> Tin Chloride
//        BURNER_REACTOR_RECIPES.recipeBuilder("tin_chloride_2")
//                .inputFluids(StannicChloride.getFluid(1000))
//                .circuitMeta(0)
//                .outputFluids(TinChloride.getFluid(1000))
//                .outputFluids(Chlorine.getFluid(2000))
//                .duration(250)
//                .EUt(VA[MV])
//                //.temperature(420)
//                .save(provider);
//
//        //  Tin Chloride + Chloride -> Stannic Chloride
//        BURNER_REACTOR_RECIPES.recipeBuilder("stannic_chloride")
//                .inputFluids(TinChloride.getFluid(1000))
//                .inputFluids(Chlorine.getFluid(2000))
//                .circuitMeta(0)
//                .outputFluids(StannicChloride.getFluid(1000))
//                .duration(200)
//                .EUt(VA[HV])
//                //.temperature(860)
//                .save(provider);
//
//        //  Heavy Alkali Chloride Solution + StannicChloride -> Rubidium Chlorostannate + Caesium Chlorostannate
//        CHEMICAL_RECIPES.recipeBuilder("rubidium_chlorostannate_and_caesium_chlorostannate")
//                .inputFluids(HeavyAlkaliChlorideSolution.getFluid(1000))
//                .inputFluids(StannicChloride.getFluid(1500))
//                .outputItems(dust, RubidiumChlorostannate, 4)
//                .outputItems(dust, CaesiumChlorostannate, 9)
//                .outputFluids(Water.getFluid(2000))
//                .duration(400)
//                .EUt(VA[EV])
//                .save(provider);
//    }
//}
