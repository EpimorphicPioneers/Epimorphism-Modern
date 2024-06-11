// package cn.gtcommunity.epimorphism.data.recipe.chains;
//
// import net.minecraft.data.recipes.FinishedRecipe;
//
// import java.util.function.Consumer;
//
// import static cn.gtcommunity.epimorphism.common.data.EPMaterials.*;
// import static cn.gtcommunity.epimorphism.common.data.EPRecipeTypes.*;
// import static com.gregtechceu.gtceu.api.GTValues.*;
// import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.*;
// import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
// import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.*;
//
// public class NdYAGChain {
//    public static void init(Consumer<FinishedRecipe> provider) {
//        //  Potassium Permanganate + Ammonia + Hydrogen Cyanide + Sulfuric Acid -> Manganese
// Sulfate + Potassium Sulfate + Ammonium Cyanate
//        CHEMICAL_PLANT_RECIPES.recipeBuilder("")
//                .inputItems(dust, PotassiumPermanganate, 12)
//                .inputFluids(Ammonia.getFluid(5000))
//                .inputFluids(HydrogenCyanide.getFluid(5000))
//                .inputFluids(SulfuricAcid.getFluid(3000))
//                .outputItems(dust, ManganeseSulfate, 12)
//                .outputItems(dust, PotassiumSulfate, 7)
//                .outputFluids(AmmoniumCyanate.getFluid(5000))
//                .outputFluids(Water.getFluid(3000))
//                .EUt(VA[EV])
//                .duration(800)
//                .CasingTier(4)
//                .save(provider);
//
//        //  Carbamide (HV): Ammonium Cyanate -> Carbamide
//        DRYER_RECIPES.recipeBuilder("")
//                .inputFluids(AmmoniumCyanate.getFluid(1000))
//                .outputItems(dust, Carbamide, 8)
//                .EUt(VA[HV])
//                .duration(320)
//                .save(provider);
//
//        //  TODO Carbamide (IV): Carbon Dioxide + Ammonia --Chemical Reactor--> Ammonium Carbamate
// --Electric Blast Furnace--> Carbamide
//
//        //  Yttrium Oxide + Neodymium Oxide -> Nd:Y
//        ROASTER_RECIPES.recipeBuilder("")
//                .inputItems(dust, YttriumOxide, 45)
//                .inputItems(dust, NeodymiumOxide, 5)
//                .outputItems(dust, NeodymiumDopedYttriumOxide, 5)
//                .EUt(VA[IV])
//                .duration(220)
//                .temperature(1880)
//                .save(provider);
//
//        //  Zeolite + Butanol + Ammonia -> Tributylamine + Water
//        CHEMICAL_RECIPES.recipeBuilder("")
//                .notConsumable(dust, Zeolite)
//                .inputFluids(Butanol.getFluid(3000))
//                .inputFluids(Ammonia.getFluid(1000))
//                .outputFluids(Tributylamine.getFluid(1000))
//                .outputFluids(Water.getFluid(3000))
//                .EUt(VA[HV])
//                .duration(140)
//                .save(provider);
//
//        //  Alumina + Nitric Acid -> Aluminium Nitrate + Water
//        CHEMICAL_RECIPES.recipeBuilder("")
//                .inputItems(dust, Alumina, 5)
//                .inputFluids(NitricAcid.getFluid(6000))
//                .outputItems(dust, AluminiumNitrate, 26)
//                .outputFluids(Water.getFluid(3000))
//                .EUt(VA[LV])
//                .duration(190)
//                .save(provider);
//
//        //  Aluminiuim Nitrate + Dichloromethane + Tributylamine -> Crude Alumina Solution
//        MIXER_RECIPES.recipeBuilder("")
//                .inputItems(dust, AluminiumNitrate, 26)
//                .inputFluids(Dichloromethane.getFluid(1000))
//                .inputFluids(Tributylamine.getFluid(1000))
//                .outputFluids(CrudeAluminaSolution.getFluid(1000))
//                .EUt(VA[MV])
//                .duration(280)
//                .save(provider);
//
//        //  Crude Alumina Solution + Tributylamine + Hydrogen Peroxide -> Alumina Solution +
// Nitric Acid + Nitrogen Dioxide
//        DISSOLUTION_TANK_RECIPES.recipeBuilder("")
//                .inputFluids(CrudeAluminaSolution.getFluid(1000))
//                .inputFluids(Tributylamine.getFluid(1000))
//                .inputFluids(HydrogenPeroxide.getFluid(1000))
//                .outputFluids(AluminaSolution.getFluid(1000))
//                .outputFluids(NitricAcid.getFluid(2000))
//                .outputFluids(NitrogenDioxide.getFluid(1000))
//                .EUt(VA[HV])
//                .duration(210)
//                .save(provider);
//
//        //  Unprocessed Nd:YAG Solution
//        CHEMICAL_RECIPES.recipeBuilder("")
//                .inputItems(dust, Carbamide, 8)
//                .inputItems(dust, NeodymiumDopedYttriumOxide)
//                .inputFluids(AluminaSolution.getFluid(1000))
//                .outputFluids(UnprocessedNdYAGSolution.getFluid(2000))
//                .outputFluids(Tributylamine.getFluid(2000))
//                .EUt(VA[IV])
//                .duration(320)
//                .save(provider);
//
//        //  Nd:YAG
//        CVD_RECIPES.recipeBuilder("")
//                .inputFluids(UnprocessedNdYAGSolution.getFluid(1000))
//                .outputItems(gem, NdYAG)
//                .outputFluids(Dichloromethane.getFluid(1000))
//                .EUt(VA[ZPM])
//                .duration(550)
//                .temperature(1884)
//                .glassTier(9)
//                .save(provider);
//    }
// }
