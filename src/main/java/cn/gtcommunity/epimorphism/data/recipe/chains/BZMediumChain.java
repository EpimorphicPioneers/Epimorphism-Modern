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
//public class BZMediumChain {
//    public static void init(Consumer<FinishedRecipe> provider) {
//        //  Potassium Bromate + Malonic Acid + Cerium + Distilled Water -> BZ Medium
//        MIXER_RECIPES.recipeBuilder("bz_medium")
//                .inputItems(dust, PotassiumBromate, 4)
//                .inputItems(dust, MalonicAcid, 3)
//                .inputItems(dust, Cerium)
//                .inputFluids(DistilledWater.getFluid(1000))
//                .outputFluids(BZMedium.getFluid(1000))
//                .duration(100)
//                .EUt(VA[ZPM])
//                .save(provider);
//
//        //  Bromine + Potassium Hydroxide -> Potassium Bromate + Ice
//        CRYOGENIC_REACTOR_RECIPES.recipeBuilder("potassium_bromate_and_ice")
//                .inputFluids(Bromine.getFluid(3000))
//                .inputFluids(PotassiumHydroxide.getFluid(L * 9))
//                .outputItems(dust, PotassiumBromate, 5)
//                .outputFluids(Ice.getFluid(3000))
//                //.temperature(273)
//                .duration(200)
//                .EUt(VA[HV])
//                .save(provider);
//
//        //  Rock Salt + Water -> Potassium Hydroxide + Chlorine + Hydrogen
//        ELECTROLYZER_RECIPES.recipeBuilder("potassium_hydroxide_and_chlorine_and_hydrogen")
//                .inputItems(dust, RockSalt, 2)
//                .circuitMeta(2)
//                .inputFluids(Water.getFluid(1000))
//                .outputItems(dust, PotassiumHydroxide, 3)
//                .outputFluids(Chlorine.getFluid(1000))
//                .outputFluids(Hydrogen.getFluid(1000))
//                .duration(720)
//                .EUt(VA[LV])
//                .save(provider);
//
//        //  Bromine + Sulfur Dioxide + Water -> Sulfuric Acid + Hydrobromic Acid
//        LARGE_CHEMICAL_RECIPES.recipeBuilder("sulfuric_acid_and_hydrobromic_acid")
//                .inputFluids(Bromine.getFluid(2000))
//                .inputFluids(SulfurDioxide.getFluid(1000))
//                .inputFluids(Water.getFluid(2000))
//                .outputFluids(SulfuricAcid.getFluid(1000))
//                .outputFluids(HydrobromicAcid.getFluid(2000))
//                .duration(400)
//                .EUt(VA[HV])
//                .save(provider);
//
//        //  Soda Ash + Chloroacetic Acid + Water -> Malonic Acid + Sodium Hydroxide + Hypochlorous Acid
//        CHEMICAL_RECIPES.recipeBuilder("malonic_acid_and_sodium_hydroxide_and_hypochlorous_acid")
//                .inputItems(dust, SodaAsh, 6)
//                .inputItems(dust, ChloroaceticAcid, 8)
//                .inputFluids(Water.getFluid(2000))
//                .outputItems(dust, MalonicAcid, 11)
//                .outputItems(dust, SodiumHydroxide, 6)
//                .outputFluids(HypochlorousAcid.getFluid(1000))
//                .duration(400)
//                .EUt(VA[IV])
//                .save(provider);
//
//        //  Trichloroethylene + Water + Sulfuric Acid -> Chloroacetic Acid + Hydrochloric Acid
//        CHEMICAL_RECIPES.recipeBuilder("chloroacetic_acid_and_hydrochloric_acid")
//                .inputFluids(Trichloroethylene.getFluid(1000))
//                .inputFluids(Water.getFluid(2000))
//                .chancedInput((SulfuricAcid.getFluid(250)),0,0)
//                .outputItems(dust, ChloroaceticAcid, 8)
//                .outputFluids(HydrochloricAcid.getFluid(2000))
//                .duration(100)
//                .EUt(VA[EV])
//                .save(provider);
//    }
//}
