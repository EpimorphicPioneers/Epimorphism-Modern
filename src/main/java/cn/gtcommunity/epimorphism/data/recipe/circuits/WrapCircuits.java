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
//
//public class WrapCircuits {
//    public static void init() {
//        PACKER_RECIPES.recipeBuilder("wrap_circuit_ulv")
//                .inputItems(circuit, MarkerMaterials.Tier.ULV, 64)
//                .circuitMeta(32)
//                .outputItems(WRAP_CIRCUIT_ULV)
//                .EUt(VA[ULV])
//                .duration(100)
//                .save(provider);
//
//        PACKER_RECIPES.recipeBuilder("wrap_circuit_lv")
//                .inputItems(circuit, MarkerMaterials.Tier.LV, 64)
//                .circuitMeta(32)
//                .outputItems(WRAP_CIRCUIT_LV)
//                .EUt(VA[ULV])
//                .duration(100)
//                .save(provider);
//
//        PACKER_RECIPES.recipeBuilder("wrap_circuit_mv")
//                .inputItems(circuit, MarkerMaterials.Tier.MV, 64)
//                .circuitMeta(32)
//                .outputItems(WRAP_CIRCUIT_MV)
//                .EUt(VA[ULV])
//                .duration(100)
//                .save(provider);
//
//        PACKER_RECIPES.recipeBuilder("wrap_circuit_hv")
//                .inputItems(circuit, MarkerMaterials.Tier.HV, 64)
//                .circuitMeta(32)
//                .outputItems(WRAP_CIRCUIT_HV)
//                .EUt(VA[ULV])
//                .duration(100)
//                .save(provider);
//
//        PACKER_RECIPES.recipeBuilder("wrap_circuit_ev")
//                .inputItems(circuit, MarkerMaterials.Tier.EV, 64)
//                .circuitMeta(32)
//                .outputItems(WRAP_CIRCUIT_EV)
//                .EUt(VA[ULV])
//                .duration(100)
//                .save(provider);
//
//        PACKER_RECIPES.recipeBuilder("wrap_circuit_iv")
//                .inputItems(circuit, MarkerMaterials.Tier.IV, 64)
//                .circuitMeta(32)
//                .outputItems(WRAP_CIRCUIT_IV)
//                .EUt(VA[ULV])
//                .duration(100)
//                .save(provider);
//
//        PACKER_RECIPES.recipeBuilder("wrap_circuit_lu_v")
//                .inputItems(circuit, MarkerMaterials.Tier.LuV, 64)
//                .circuitMeta(32)
//                .outputItems(WRAP_CIRCUIT_LuV)
//                .EUt(VA[ULV])
//                .duration(100)
//                .save(provider);
//
//        PACKER_RECIPES.recipeBuilder("wrap_circuit_zpm")
//                .inputItems(circuit, MarkerMaterials.Tier.ZPM, 64)
//                .circuitMeta(32)
//                .outputItems(WRAP_CIRCUIT_ZPM)
//                .EUt(VA[ULV])
//                .duration(100)
//                .save(provider);
//
//        PACKER_RECIPES.recipeBuilder("wrap_circuit_uv")
//                .inputItems(circuit, MarkerMaterials.Tier.UV, 64)
//                .circuitMeta(32)
//                .outputItems(WRAP_CIRCUIT_UV)
//                .EUt(VA[ULV])
//                .duration(100)
//                .save(provider);
//
//        PACKER_RECIPES.recipeBuilder("wrap_circuit_uhv")
//                .inputItems(circuit, MarkerMaterials.Tier.UHV, 64)
//                .circuitMeta(32)
//                .outputItems(WRAP_CIRCUIT_UHV)
//                .EUt(VA[ULV])
//                .duration(100)
//                .save(provider);
//
//        PACKER_RECIPES.recipeBuilder("wrap_circuit_uev")
//                .inputItems(circuit, MarkerMaterials.Tier.UEV, 64)
//                .circuitMeta(32)
//                .outputItems(WRAP_CIRCUIT_UEV)
//                .EUt(VA[ULV])
//                .duration(100)
//                .save(provider);
//
//        PACKER_RECIPES.recipeBuilder("wrap_circuit_uiv)
//                .inputItems(circuit, MarkerMaterials.Tier.UIV, 64)
//                .circuitMeta(32)
//                .outputItems(WRAP_CIRCUIT_UIV)
//                .EUt(VA[ULV])
//                .duration(100)
//                .save(provider);
//
//        PACKER_RECIPES.recipeBuilder("wrap_circuit_uxv")
//                .inputItems(circuit, MarkerMaterials.Tier.UXV, 64)
//                .circuitMeta(32)
//                .outputItems(WRAP_CIRCUIT_UXV)
//                .EUt(VA[ULV])
//                .duration(100)
//                .save(provider);
//
//        PACKER_RECIPES.recipeBuilder("wrap_circuit_op_v")
//                .inputItems(circuit, MarkerMaterials.Tier.OpV, 64)
//                .circuitMeta(32)
//                .outputItems(WRAP_CIRCUIT_OpV)
//                .EUt(VA[ULV])
//                .duration(100)
//                .save(provider);
//
//        PACKER_RECIPES.recipeBuilder("wrap_circuit_max")
//                .inputItems(circuit, MarkerMaterials.Tier.MAX, 64)
//                .circuitMeta(32)
//                .outputItems(WRAP_CIRCUIT_MAX)
//                .EUt(VA[ULV])
//                .duration(100)
//                .save(provider);
//    }
//}
