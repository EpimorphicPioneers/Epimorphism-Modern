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
// public class BoronNitrideChain {
//    public static void init(Consumer<FinishedRecipe> provider) {
//        //  Borax + Hydrochloric Acid -> Boric Acid + Salt + Water
//        CHEMICAL_BATH_RECIPES.recipeBuilder("boric_acid_and_salt_and_water")
//                .inputItems(dust, Borax, 23)
//                .inputFluids(HydrochloricAcid.getFluid(2000))
//                .outputItems(dust, BoricAcid, 16)
//                .outputItems(dust, Salt, 4)
//                .outputFluids(Water.getFluid(5000))
//                .duration(300)
//                .EUt(VA[MV])
//                .save(provider);
//
//        //  Boric Acid -> Boron Trioxide + Water
//        DRYER_RECIPES.recipeBuilder("boron_trioxide_and_water")
//                .inputItems(dust, BoricAcid, 8)
//                .outputItems(dust, BoronTrioxide, 5)
//                .outputFluids(Water.getFluid(3000))
//                .duration(100)
//                .EUt(VA[MV])
//                .save(provider);
//
//        //  Boric Acid + Hydrofluoric Acid -> Boron Trifluoride + Water
//        CHEMICAL_RECIPES.recipeBuilder("boron_trifluoride_and_water")
//                .inputItems(dust, BoricAcid, 5)
//                .inputFluids(HydrofluoricAcid.getFluid(6000))
//                .outputFluids(BoronTrifluoride.getFluid(2000))
//                .outputFluids(Water.getFluid(3000))
//                .duration(160)
//                .EUt(VA[HV])
//                .save(provider);
//
//        //  Lithium + Hydrogen -> Lithium Hydride
//        BURNER_REACTOR_RECIPES.recipeBuilder("lithium_hydride")
//                .inputItems(dust, Lithium)
//                .inputFluids(Hydrogen.getFluid(1000))
//                .outputItems(ingot, LithiumHydride)
//                //.temperature(873)
//                .duration(300)
//                .EUt(VA[HV])
//                .save(provider);
//
//        //  Lithium Hydride + Boron Trifluoride -> Lithium Tetrafluoroborate + Diborane
//        CHEMICAL_RECIPES.recipeBuilder("lithium_tetrafluoroborate_and_diborane")
//                .inputItems(dust, LithiumHydride, 12)
//                .inputFluids(BoronTrifluoride.getFluid(8000))
//                .outputItems(dust, LithiumTetrafluoroborate, 36)
//                .outputFluids(Diborane.getFluid(1000))
//                .duration(640)
//                .EUt(VA[HV])
//                .save(provider);
//
//        //  Lithium Tetrafluoroborate -> LithiumHydride + Boron Trifluoride
//        DRYER_RECIPES.recipeBuilder("lithium_hydride_and_boron_trifluoride")
//                .inputItems(dust, LithiumTetrafluoroborate, 6)
//                .outputItems(ingot, LithiumHydride, 2)
//                .outputFluids(BoronTrifluoride.getFluid(1000))
//                .duration(80)
//                .EUt(VA[LV])
//                .save(provider);
//
//        //  Diborane + Ammonia -> Borazine + Hydrogen
//        CHEMICAL_RECIPES.recipeBuilder("borazine_and_hydrogen")
//                .inputFluids(Diborane.getFluid(3000))
//                .inputFluids(Ammonia.getFluid(6000))
//                .outputFluids(Borazine.getFluid(2000))
//                .outputFluids(Hydrogen.getFluid(24000))
//                .duration(400)
//                .EUt(VA[LuV])
//                .save(provider);
//
//        //  Boron Trioxide + Carbon dust + Chlorine -> Boron Trichloride + Carbon Monoxide
//        BURNER_REACTOR_RECIPES.recipeBuilder("boron_trichloride_and_carbon_monoxide")
//                .inputItems(dust, BoronTrioxide, 5)
//                .inputItems(dust, Carbon, 3)
//                .inputFluids(Chlorine.getFluid(6000))
//                .outputFluids(BoronTrichloride.getFluid(2000))
//                .outputFluids(CarbonMonoxide.getFluid(3000))
//                //.temperature(774)
//                .duration(90)
//                .EUt(VA[HV])
//                .save(provider);
//
//        //  Ammonium Chloride + Boron Trichloride -> Trichloroborazine + Hydrochloric Acid
//        CHEMICAL_RECIPES.recipeBuilder("trichloroborazine_and_hydrochloric_acid")
//                .inputItems(dust, AmmoniumChloride, 6)
//                .inputFluids(BoronTrichloride.getFluid(3000))
//                .outputFluids(Trichloroborazine.getFluid(1000))
//                .outputFluids(HydrochloricAcid.getFluid(9000))
//                .duration(400)
//                .EUt(VA[IV])
//                .save(provider);
//
//        //  Hexagonal Boron Nitride (UV) Borazine + Oxygen -> Hexagonal Boron Nitride + Water
//        CVD_RECIPES.recipeBuilder("hexagonal_boron_nitride_and_water")
//                .inputFluids(Borazine.getFluid(1000))
//                .inputFluids(Oxygen.getFluid(3000))
//                .outputItems(gem, HexagonalBoronNitride, 6)
//                .outputFluids(Water.getFluid(3000))
//                .duration(400)
//                .EUt(VA[UV])
//                //.temperature(1300)
//                .save(provider);
//
//        //  Hexagonal Boron Nitride (UEV) Nickel + Boron + Nitrogen -> Hexagonal Boron Nitride
//        MOLECULAR_BEAM_RECIPES.recipeBuilder("hexagonal_boron_nitride")
//                .inputItems(foil, Nickel, 8)
//                .inputItems(dust, Boron)
//                .inputFluids(Nitrogen.getFluid(1000))
//                .outputItems(gem, HexagonalBoronNitride, 2)
//                //.temperature(2900)
//                .duration(80)
//                .EUt(VA[UEV])
//                .save(provider);
//
//        //  Hexagonal Boron Nitride -> Cubic Boron Nitride
//        CVD_RECIPES.recipeBuilder("cubic_boron_nitride")
//                .inputItems(dust, HexagonalBoronNitride)
//                .outputItems(gem, CubicBoronNitride)
//                .duration(100)
//                .EUt(VA[UV])
//                //.temperature(3501)
//                .save(provider);
//
//        //  Caesium + Trichloroborazine -> Amorphous Boron Nitride + Hydrochloric Acid
//        CHEMICAL_RECIPES.recipeBuilder("amorphous_boron_nitride_and_hydrochloric_acid")
//                .inputItems(dust, Caesium)
//                .inputFluids(Trichloroborazine.getFluid(1000))
//                .outputItems(dust, AmorphousBoronNitride, 6)
//                .outputFluids(HydrochloricAcid.getFluid(3000))
//                .duration(200)
//                .EUt(VA[ZPM])
//                .save(provider);
//
//        //  Cubic Boron Nitride + Carbon -> Heterodiamond
//        IMPLOSION_RECIPES.recipeBuilder("heterodiamond_1")
//                .inputItems(dust, CubicBoronNitride)
//                .inputItems(dust, Carbon)
//                .outputItems(gem, Heterodiamond, 2)
//                .explosivesAmount(32)
//                .duration(20)
//                .EUt(VA[LV])
//                .save(provider);
//
//        IMPLOSION_RECIPES.recipeBuilder("heterodiamond_2")
//                .inputItems(dust, CubicBoronNitride)
//                .inputItems(dust, Carbon)
//                .outputItems(gem, Heterodiamond, 2)
//                .explosivesAmount(16)
//                .duration(20)
//                .EUt(VA[LV])
//                .save(provider);
//
//        //  Heterodiamond + Carbon -> Cubic Heterodiamond
//        CVD_RECIPES.recipeBuilder("cubic_heterodiamond")
//                .inputItems(dust, Heterodiamond)
//                .inputItems(dust, Carbon)
//                .outputItems(gem, CubicHeterodiamond)
//                .duration(400)
//                .EUt(VA[UHV])
//                //.temperature(2200)
//                .save(provider);
//    }
// }
