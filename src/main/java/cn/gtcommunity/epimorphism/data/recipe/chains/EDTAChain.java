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
//
//
//public class EDTAChain {
//    public static void init(Consumer<FinishedRecipe> provider) {
//
//        //  Ethylene + Chlorine + Iron (III) Chloride -> Dichloroethane
//        CHEMICAL_RECIPES.recipeBuilder("dichloroethane")
//                .inputFluids(Ethylene.getFluid(1000))
//                .inputFluids(Chlorine.getFluid(2000))
//                .chancedInput((Iron3Chloride.getFluid(1)),0,0)
//                .outputFluids(Dichloroethane.getFluid(1000))
//                .duration(80)
//                .EUt(VA[LV])
//                .save(provider);
//
//        //  Copper Chloride
//        CHEMICAL_RECIPES.recipeBuilder("copper_chloride")
//                .inputItems(dust, Copper)
//                .inputFluids(Chlorine.getFluid(2000))
//                .circuitMeta(2)
//                .outputItems(dust, CopperChloride, 3)
//                .EUt(VA[LV])
//                .duration(40)
//                .save(provider);
//
//        //  Ethylene + Hydrochloric Acid + Copper -> Dichloroethane + Hydrogen
//        CHEMICAL_RECIPES.recipeBuilder("dichloroethane_and_hydrogen")
//                .inputFluids(Ethylene.getFluid(1000))
//                .inputFluids(HydrochloricAcid.getFluid(2000))
//                .notConsumable(dust, CopperChloride)
//                .outputFluids(Dichloroethane.getFluid(1000))
//                .outputFluids(Hydrogen.getFluid(2000))
//                .duration(80)
//                .EUt(VA[LV])
//                .save(provider);
//
//        //  Dichloroethane -> Vinyl Chloride + Hydrochloric Acid
//        BURNER_REACTOR_RECIPES.recipeBuilder("vinyl_chloride_and_hydrochloric_acid")
//                .inputFluids(Dichloroethane.getFluid(1000))
//                .circuitMeta(1)
//                .outputFluids(VinylChloride.getFluid(1000))
//                .outputFluids(HydrochloricAcid.getFluid(1000))
//                //.temperature(773)
//                .duration(40)
//                .EUt(VA[MV])
//                .save(provider);
//
//        //  Dichloroethane + Chlorine -> Trichloroethylene + Hydrogen
//        BURNER_REACTOR_RECIPES.recipeBuilder("trichloroethylene_and_hydrogen")
//                .inputFluids(Dichloroethane.getFluid(1000))
//                .inputFluids(Chlorine.getFluid(1000))
//                .circuitMeta(0)
//                .outputFluids(Trichloroethylene.getFluid(1000))
//                .outputFluids(Hydrogen.getFluid(3000))
//                //.temperature(400)
//                .duration(100)
//                .EUt(VA[EV])
//                .save(provider);
//
//        //  Dichloroethane + Ammonia -> Ethylenediamine + Hydrochloric Acid
//        CHEMICAL_RECIPES.recipeBuilder("")
//                .inputFluids(Dichloroethane.getFluid(1000))
//                .inputFluids(Ammonia.getFluid(2000))
//                .outputFluids(Ethylenediamine.getFluid(1000))
//                .outputFluids(HydrochloricAcid.getFluid(2000))
//                .duration(80)
//                .EUt(VA[HV])
//                .save(provider);
//
//        //  Silver + Methanol -> Formaldehyde + Hydrogen
//        BURNER_REACTOR_RECIPES.recipeBuilder("formaldehyde_and_hydrogen")
//                .inputItems(dustTiny, Silver)
//                .inputFluids(Methanol.getFluid(1000))
//                .outputFluids(Formaldehyde.getFluid(1000))
//                .outputFluids(Hydrogen.getFluid(2000))
//                //.temperature(923)
//                .duration(180)
//                .EUt(VA[HV])
//                .save(provider);
//
//        //  Sodium + Ethylenediamine + Formaldehyde + Hydrogen Cyanide + Water -> TetrasodiumEDTA + Ammonia + Oxygen
//        LARGE_CHEMICAL_RECIPES.recipeBuilder("tetrasodium_edta_and_ammonia_and_oxygen")
//                .inputItems(dust, Sodium, 4)
//                .inputFluids(Ethylenediamine.getFluid(1000))
//                .inputFluids(Formaldehyde.getFluid(4000))
//                .inputFluids(HydrogenCyanide.getFluid(4000))
//                .inputFluids(Water.getFluid(4000))
//                .circuitMeta(8)
//                .outputItems(dust, TetrasodiumEDTA)
//                .outputFluids(Ammonia.getFluid(4000))
//                .outputFluids(Oxygen.getFluid(2000))
//                .duration(120)
//                .EUt(VA[HV])
//                .save(provider);
//
//        //  Tetrasodium EDTA + Hydrochloric Acid -> Ethylenediaminetetraacetic Acid
//        CHEMICAL_RECIPES.recipeBuilder("ethylenediaminetetraacetic_acid")
//                .inputItems(dust, TetrasodiumEDTA)
//                .inputFluids(HydrochloricAcid.getFluid(4000))
//                .outputItems(dust, EthylenediaminetetraaceticAcid, 32)
//                .outputItems(dust, Salt, 8)
//                .duration(100)
//                .EUt(VA[IV])
//                .save(provider);
//    }
//}
