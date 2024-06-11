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
// public class AmmoniaChain {
//    public static void init(Consumer<FinishedRecipe> provider) {
////        //  Delete original recipes
////        GTRecipeHandler.removeRecipesByInputs(CHEMICAL_RECIPES,
////                new ItemStack[]{IntCircuitIngredient.getIntegratedCircuit(1)},
////                new FluidStack[]{Nitrogen.getFluid(1000), Hydrogen.getFluid(3000)}
////        );
////
////        GTRecipeHandler.removeRecipesByInputs(LARGE_CHEMICAL_RECIPES,
////                new ItemStack[]{IntCircuitIngredient.getIntegratedCircuit(1)},
////                new FluidStack[]{Nitrogen.getFluid(1000), Hydrogen.getFluid(3000)}
////        );
//
//        //  Rich Nitrogen Mixture
//        MIXER_RECIPES.recipeBuilder("Rich_Nitrogen_Mixture")
//                .inputFluids(Methane.getFluid(1000))
//                .inputFluids(Air.getFluid(1500))
//                .outputFluids(RichNitrogenMixture.getFluid(2500))
//                .duration(80)
//                .EUt(VA[MV])
//                .save(provider);
//
//        //  Rich Ammonia Mixture
//        CHEMICAL_RECIPES.recipeBuilder("Rich_Ammonia_Mixture_1")
//                .notConsumable(dust, Chromium)
//                .inputFluids(RichNitrogenMixture.getFluid(2500))
//                .inputFluids(Water.getFluid(2000))
//                .outputFluids(RichAmmoniaMixture.getFluid(1000))
//                .outputFluids(Methane.getFluid(1000))
//                .duration(80)
//                .EUt(VA[MV])
//                .save(provider);
//
//        CHEMICAL_RECIPES.recipeBuilder("Rich_Ammonia_Mixture_2")
//                .notConsumable(dust, Ruthenium)
//                .inputFluids(RichNitrogenMixture.getFluid(2500))
//                .inputFluids(Water.getFluid(2000))
//                .outputFluids(RichAmmoniaMixture.getFluid(3000))
//                .outputFluids(Methane.getFluid(1000))
//                .duration(80)
//                .EUt(VA[EV])
//                .save(provider);
//
//        //  Ammonia
//        BREWING_RECIPES.recipeBuilder("Ammonia_1")
//                .notConsumable(dust, Magnetite)
//                .inputFluids(RichAmmoniaMixture.getFluid(1000))
//                .outputFluids(Ammonia.getFluid(1000))
//                .duration(160)
//                .EUt(VA[LV])
//                .save(provider);
//
//        BREWING_RECIPES.recipeBuilder("Ammonia_2")
//                .notConsumable(dust, Chromite)
//                .inputFluids(RichAmmoniaMixture.getFluid(1000))
//                .outputFluids(Ammonia.getFluid(3000))
//                .duration(160)
//                .EUt(VA[HV])
//                .save(provider);
//    }
// }
