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
// public class WetwareCircuits {
//    public static void init() {
//        //  Delete original recipe
//        GTRecipeHandler.removeRecipesByInputs(CIRCUIT_ASSEMBLER_RECIPES, new ItemStack[]{
//                        MULTILAYER_FIBER_BOARD.getStackForm(16),
//                        PETRI_DISH.getStackForm(),
//                        ELECTRIC_PUMP_LuV.getStackForm(),
//                        SENSOR_IV.getStackForm(),
//                        OreDictUnifier.get(circuit, MarkerMaterials.Tier.IV),
//                        OreDictUnifier.get(foil, NiobiumTitanium, 16)},
//                new FluidStack[]{SterileGrowthMedium.getFluid(4000)});
//
//        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder("")
//                .inputItems(plate, KaptonK, 16)
//                .inputItems(PETRI_DISH)
//                .inputItems(ELECTRIC_PUMP_LuV)
//                .inputItems(SENSOR_IV)
//                .inputItems(circuit, MarkerMaterials.Tier.IV)
//                .inputItems(foil, NiobiumTitanium, 16)
//                .inputFluids(SterileGrowthMedium.getFluid(4000))
//                .outputItems(WETWARE_BOARD, 16)
//                .cleanroom(CleanroomType.STERILE_CLEANROOM)
//                .duration(1200)
//                .EUt(VA[LuV])
//                .save(provider);
//    }
// }
