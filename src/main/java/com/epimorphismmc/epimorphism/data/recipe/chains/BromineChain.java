// package cn.gtcommunity.epimorphism.data.recipe.chains;
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
//
// public class BromineChain {
//    public static void init(Consumer<FinishedRecipe> provider) {
//        //  Brominated Brine + Sulfuric Acid -> Acidic Brominated Brine
//        MIXER_RECIPES.recipeBuilder("acidic_brominated_brine")
//                .inputFluids(BrominatedBrine.getFluid(1000))
//                .inputFluids(SulfuricAcid.getFluid(1000))
//                .outputFluids(AcidicBrominatedBrine.getFluid(1000))
//                .EUt(480)
//                .duration(200)
//                .save(provider);
//
//        //  Acidic Brominated Brine + Sulfur Dioxide + Water -> Bromine Sulfate Solution + Salt
// Water
//        CHEMICAL_RECIPES.recipeBuilder("bromine_sulfate_solution_and_salt_water")
//                .inputFluids(AcidicBrominatedBrine.getFluid(1000))
//                .inputFluids(SulfurDioxide.getFluid(1000))
//                .inputFluids(Water.getFluid(1000))
//                .circuitMeta(3)
//                .outputFluids(BromineSulfateSolution.getFluid(1000))
//                .outputFluids(SaltWater.getFluid(1000))
//                .EUt(480)
//                .duration(200)
//                .save(provider);
//
//        //  Bromine Sulfate Solution + Steam -> Overheated Bromine Sulfate Solution
//        ROASTER_RECIPES.recipeBuilder("overheated_bromine_sulfate_solution")
//                .inputFluids(BromineSulfateSolution.getFluid(2000))
//                .inputFluids(Steam.getFluid(1000))
//                .outputFluids(OverheatedBromineSulfateSolution.getFluid(3000))
//                //.temperature(2250)
//                .EUt(VA[HV])
//                .duration(400)
//                .save(provider);
//
//        //  Overheated Bromine Sulfate Solution
//        CENTRIFUGE_RECIPES.recipeBuilder("overheated_bromine_sulfate_solution")
//                .inputFluids(OverheatedBromineSulfateSolution.getFluid(3000))
//                .outputFluids(WetBromine.getFluid(1000))
//                .outputFluids(DebrominatedWater.getFluid(1000))
//                .outputFluids(Chlorine.getFluid(2000))
//                .outputFluids(SulfuricAcid.getFluid(1000))
//                .EUt(VA[HV])
//                .duration(280)
//                .save(provider);
//
//        //  Wet Bromine -> Bromine
//        DRYER_RECIPES.recipeBuilder("bromine")
//                .inputFluids(WetBromine.getFluid(1000))
//                .outputFluids(Bromine.getFluid(1000))
//                .EUt(360)
//                .duration(80)
//                .save(provider);
//
//        //  Debrominated Water -> Salt Water
//        DRYER_RECIPES.recipeBuilder("salt_water")
//                .inputFluids(DebrominatedWater.getFluid(1000))
//                .outputFluids(SaltWater.getFluid(100))
//                .EUt(360)
//                .duration(80)
//                .save(provider);
//    }
// }
