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
// public class CalciumChain {
//    public static void init(Consumer<FinishedRecipe> provider) {
//        //  Quicklime + Carbon -> Calcium Carbide + Carbon Monoxide
//        ROASTER_RECIPES.recipeBuilder("calcium_carbide_and_carbon_monoxide")
//                .inputItems(dust, Quicklime, 2)
//                .inputItems(dust, Carbon, 3)
//                .outputItems(dust, CalciumCarbide, 3)
//                .outputFluids(CarbonMonoxide.getFluid(1000))
//                //.temperature(2473)
//                .duration(500)
//                .EUt(VA[MV])
//                .save(provider);
//
//        //  Quicklime + Coke -> Calcium Carbide + Carbon Monoxide
//        ROASTER_RECIPES.recipeBuilder("calcium_carbide_and_carbon_monoxide")
//                .inputItems(dust, Quicklime, 2)
//                .inputItems(gem, Coke)
//                .outputItems(dust, CalciumCarbide, 3)
//                .outputFluids(CarbonMonoxide.getFluid(1000))
//                //.temperature(2473)
//                .duration(200)
//                .EUt(VA[MV])
//                .save(provider);
//
//        //  Calcium Carbide + Water -> Calcium Hydroxide + Acetylene
//        CHEMICAL_RECIPES.recipeBuilder("calcium_hydroxide_and_acetylene")
//                .inputItems(dust, CalciumCarbide, 3)
//                .inputFluids(Water.getFluid(2000))
//                .outputItems(dust, CalciumHydroxide, 5)
//                .outputFluids(Acetylene.getFluid(1000))
//                .duration(80).EUt(VA[LV]).save(provider);
//
//        //  Calcium Hydroxide + Carbon Dioxide -> Calcite + Water
//        CHEMICAL_RECIPES.recipeBuilder("calcite_and_water")
//                .inputItems(dust, CalciumHydroxide, 5)
//                .inputFluids(CarbonDioxide.getFluid(1000))
//                .outputItems(dust, Calcite, 5)
//                .outputFluids(Water.getFluid(1000))
//                .duration(80)
//                .EUt(VA[LV])
//                .save(provider);
//    }
// }
