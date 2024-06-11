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
// public class BPAPolycarbonateChain {
//    public static void init(Consumer<FinishedRecipe> provider) {
//        //  Carbon Monoxide + Oxygen + Methanol - > Dimethyl Carbonate + Water
//        LARGE_CHEMICAL_RECIPES.recipeBuilder("")
//                .inputFluids(CarbonMonoxide.getFluid(1000))
//                .inputFluids(Oxygen.getFluid(1000))
//                .inputFluids(Methanol.getFluid(2000))
//                .circuitMeta(1)
//                .outputFluids(DimethylCarbonate.getFluid(1000))
//                .outputFluids(Water.getFluid(1000))
//                .EUt(VA[HV])
//                .duration(120)
//                .save(provider);
//
//        //  Dimethyl Carbonate + Phenol -> Diphenyl Carbonate + Methanol
//        CHEMICAL_RECIPES.recipeBuilder("diphenyl_carbonate_and_methanol")
//                .inputFluids(DimethylCarbonate.getFluid(1000))
//                .inputFluids(Phenol.getFluid(2000))
//                .outputFluids(DiphenylCarbonate.getFluid(1000))
//                .outputFluids(Methanol.getFluid(2000))
//                .EUt(VA[EV])
//                .duration(120)
//                .save(provider);
//
//        //  Diphenyl Carbonate + Bisphenol-A -> BPA Polycarbonate + Phenol
//        CHEMICAL_RECIPES.recipeBuilder("bpa_polycarbonate_and_phenol")
//                .inputFluids(DiphenylCarbonate.getFluid(1000))
//                .inputFluids(BisphenolA.getFluid(1000))
//                .outputFluids(BPAPolycarbonate.getFluid(144))
//                .outputFluids(Phenol.getFluid(2000))
//                .EUt(VA[IV])
//                .duration(160)
//                .save(provider);
//    }
// }
