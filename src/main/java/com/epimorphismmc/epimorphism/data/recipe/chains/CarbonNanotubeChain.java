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
// import com.gregtechceu.gtceu.api.fluids.store.FluidStorageKeys;
// public class CarbonNanotubeChain {
//    public static void init(Consumer<FinishedRecipe> provider) {
//        //  Carbon Nanotube ingot (UV)
//        PLASMA_CVD_RECIPES.recipeBuilder("carbon_nanotube_ingot_uv")
//                .notConsumable(plate, Rhenium)
//                .inputFluids(Acetylene.getFluid(3000))
//                .inputFluids(Cycloparaphenylene.getFluid(7000))
//                .inputFluids(Nitrogen.getFluid(FluidStorageKeys.PLASMA,10000))
//                .outputItems(ingot, CarbonNanotube)
//                .outputFluids(Ammonia.getFluid(10000))
//                //.temperature(993)
//                .duration(1200)
//                .EUt(VA[UV])
//                .save(provider);
//
//        //  Carbon Nanotube stick (UEV)
//        PLASMA_CVD_RECIPES.recipeBuilder("carbon_nanotube_ingot_uev")
//                .notConsumable(plateDouble, Rhenium)
//                .inputFluids(Acetylene.getFluid(24000))
//                .inputFluids(Cycloparaphenylene.getFluid(6000))
//                .inputFluids(Nitrogen.getFluid(FluidStorageKeys.PLASMA,16000))
//                .outputItems(rodLong, CarbonNanotube)
//                .outputFluids(Ammonia.getFluid(16000))
//                //.temperature(993)
//                .duration(1200)
//                .EUt(VA[UEV])
//                .save(provider);
//
//        //  Cycloparaphenylene
//        CHEMICAL_PLANT_RECIPES.recipeBuilder("cycloparaphenylene")
//                .inputItems(dust, Dichlorocyclooctadieneplatinium, 23)
//                .inputItems(dust, Diiodobiphenyl, 4)
//                .notConsumable(dust, Bipyridine)
//                .notConsumable(dust, PalladiumBisdibenzylidieneacetone)
//                .inputFluids(SilverTetrafluoroborate.getFluid(40000))
//                .inputFluids(TrimethyltinChloride.getFluid(40000))
//                .outputItems(dust, PlatinumRaw, 6)
//                .outputItems(dust, Iodine, 8)
//                .outputItems(dust, SilverChloride, 8)
//                .outputItems(dust, Tin, 4)
//                .outputFluids(Cycloparaphenylene.getFluid(10000))
//                .outputFluids(BoronTrifluoride.getFluid(4000))
//                .outputFluids(Octene.getFluid(3000))
//                .outputFluids(HydrofluoricAcid.getFluid(4000))
//                //.CasingTier(5)
//                .EUt(491520)
//                .duration(460)
//                .save(provider);
//
////        //  Cycloparaphenylene Cycle
////        FORMING_PRESS_RECIPES.recipeBuilder("")
////                .inputItems(foil, Graphene, 24)
////                .inputItems(dust, CarbonNanotube)
////                .outputItems(CARBON_ALLOTROPE)
////                .cleanroom(CleanroomType.CLEANROOM)
////                .duration(100)
////                .EUt(VA[ZPM])
////                .save(provider);
////
////        ELECTROMAGNETIC_SEPARATOR_RECIPES.recipeBuilder("")
////                .inputItems(CARBON_ALLOTROPE)
////                .outputItems(ingot, CarbonNanotube)
////                .outputItems(GRAPHENE_ALIGNED, 4)
////                .cleanroom(CleanroomType.CLEANROOM)
////                .duration(200)
////                .EUt(VA[UEV])
////                .save(provider);
////
////        EXTRACTOR_RECIPES.recipeBuilder("")
////                .inputItems(GRAPHENE_ALIGNED)
////                .outputItems(dust, Carbon, 3)
////                .outputFluids(Cycloparaphenylene.getFluid(2000))
////                .duration(800)
////                .EUt(VA[LuV])
////                .save(provider);
//
//        //  Decomposition
//        ELECTROLYZER_RECIPES.recipeBuilder("decomposition")
//                .inputItems(dust, CarbonNanotube)
//                .outputItems(dust, Carbon, 48)
//                .duration((int) Carbon.getMass() * 48)
//                .EUt(64)
//                .save(provider);
//
//        //  Potassium Tetrachloroplatinate + Cyclooctadiene -> Dichlorocyclooctadieneplatinium +
// Potassium Chloride
//
// LARGE_CHEMICAL_RECIPES.recipeBuilder("dichlorocyclooctadieneplatinium_and_potassium_chloride")
//                .inputItems(dust, PotassiumTetrachloroplatinate, 7)
//                .inputFluids(Cyclooctadiene.getFluid(1000))
//                .outputItems(dust, Dichlorocyclooctadieneplatinium, 23)
//                .outputItems(dust, RockSalt, 4)
//                .EUt(VA[HV])
//                .duration(360)
//                .save(provider);
//
//        //  Potassium dust + Chloroplatinic Acid -> Potassium Tetrachloroplatinate + Hydrochloric
// Acid
//        CHEMICAL_RECIPES.recipeBuilder("potassium_tetrachloroplatinate_and_hydrochloric_acid")
//                .inputItems(dust, Potassium, 2)
//                .inputFluids(ChloroplatinicAcid.getFluid(1000))
//                .outputItems(dust, PotassiumTetrachloroplatinate, 7)
//                .outputFluids(HydrochloricAcid.getFluid(2000))
//                .EUt(480)
//                .duration(300)
//                .save(provider);
//
//        //  Platinum dust + Hydrochloric Acid -> Raw Platinum dust + Chloroplatinic Acid
//        DRYER_RECIPES.recipeBuilder("raw_platinum_dust_and_chloroplatinic_acid")
//                .inputItems(dust, Platinum)
//                .inputFluids(HydrochloricAcid.getFluid(6000))
//                .outputItems(dust, PlatinumRaw)
//                .outputFluids(ChloroplatinicAcid.getFluid(1000))
//                .EUt(1920)
//                .duration(120)
//                .save(provider);
//
//        //  Nickel Triphenylphosphite + Butadiene -> Cyclooctadiene
//        CHEMICAL_RECIPES.recipeBuilder("cyclooctadiene")
//                .notConsumable(dust, NickelTriphenylphosphite)
//                .inputFluids(Butadiene.getFluid(2000))
//                .outputFluids(Cyclooctadiene.getFluid(1000))
//                .EUt(480)
//                .duration(80)
//                .save(provider);
//
//        //  Nickel Chloride + Phosphorus Trichloride + Phenol -> Nickel Triphenylphosphite +
// Hydrochloric Acid + Oxygen
//
// CHEMICAL_RECIPES.recipeBuilder("nickel_triphenylphosphite_and_hydrochloric_acid_and_oxygen")
//                .inputItems(dust, NickelChloride)
//                .inputFluids(PhosphorusTrichloride.getFluid(2000))
//                .inputFluids(Phenol.getFluid(6000))
//                .outputItems(dust, NickelTriphenylphosphite, 16)
//                .outputFluids(HydrochloricAcid.getFluid(6000))
//                .outputFluids(Oxygen.getFluid(6000))
//                .EUt(1920)
//                .duration(180)
//                .save(provider);
//
//        //  Nickel Chloride
//        CHEMICAL_RECIPES.recipeBuilder("nickel_chloride")
//                .inputItems(dust, Nickel)
//                .inputFluids(Chlorine.getFluid(2000))
//                .circuitMeta(2)
//                .outputItems(dust, NickelChloride)
//                .EUt(30)
//                .duration(60)
//                .save(provider);
//
//        //  Phosphorus dust + Chlorine -> Phosphorus Trichloride
//        CHEMICAL_RECIPES.recipeBuilder("phosphorus_trichloride")
//                .inputItems(dust, Phosphorus)
//                .inputFluids(Chlorine.getFluid(3000))
//                .circuitMeta(3)
//                .outputFluids(PhosphorusTrichloride.getFluid(1000))
//                .EUt(30)
//                .duration(60)
//                .save(provider);
//
//        //  Diiodobiphenyl
//        CHEMICAL_RECIPES.recipeBuilder("diiodobiphenyl")
//                .inputItems(dust, Biphenyl, 22)
//                .inputItems(dust, Iodine, 2)
//                .inputFluids(AmmoniumSulfate.getFluid(1000))
//                .inputFluids(SulfuricAcid.getFluid(1000))
//                .outputItems(dust, Diiodobiphenyl, 22)
//                .outputFluids(AmmoniumPersulfate.getFluid(1000))
//                .outputFluids(Hydrogen.getFluid(4000))
//                .EUt(480)
//                .duration(260)
//                .save(provider);
//
//        //  Another Ammonium Persulfate recipe
//        CHEMICAL_RECIPES.recipeBuilder("ammonium_persulfate_2")
//                .inputFluids(AmmoniumSulfate.getFluid(1000))
//                .inputFluids(SulfuricAcid.getFluid(1000))
//                .circuitMeta(0)
//                .outputFluids(AmmoniumPersulfate.getFluid(1000))
//                .outputFluids(Hydrogen.getFluid(2000))
//                .EUt(120)
//                .duration(220)
//                .save(provider);
//
//        //  Hydroxylamine Disulfate + Ammonia -> Hydroxylamine + Ammonium Sulfate
//        CHEMICAL_RECIPES.recipeBuilder("hydroxylamine_and_ammonium_sulfate")
//                .inputFluids(HydroxylamineDisulfate.getFluid(2000))
//                .inputFluids(Ammonia.getFluid(2000))
//                .circuitMeta(2)
//                .outputFluids(Hydroxylamine.getFluid(2000))
//                .outputFluids(AmmoniumSulfate.getFluid(2000))
//                .EUt(120)
//                .duration(180)
//                .save(provider);
//
//        //  Ammonium Nitrate + Sulfur Dioxide + Ammonia + Water -> Hydroxylamine Disulfate
//        LARGE_CHEMICAL_RECIPES.recipeBuilder("hydroxylamine_disulfate")
//                .inputFluids(AmmoniumNitrate.getFluid(1000))
//                .inputFluids(SulfurDioxide.getFluid(2000))
//                .inputFluids(Ammonia.getFluid(2000))
//                .inputFluids(Water.getFluid(3000))
//                .circuitMeta(22)
//                .outputFluids(HydroxylamineDisulfate.getFluid(2000))
//                .EUt(120)
//                .duration(360)
//                .save(provider);
//
//        //  Nitric Acid + Ammonia -> Ammonium Nitrate
//        CHEMICAL_RECIPES.recipeBuilder("ammonium_nitrate")
//                .inputFluids(NitricAcid.getFluid(1000))
//                .inputFluids(Ammonia.getFluid(1000))
//                .circuitMeta(1)
//                .outputFluids(AmmoniumNitrate.getFluid(1000))
//                .EUt(480)
//                .duration(120)
//                .save(provider);
//
//        //  Nickel dust + Aluminium dust + Pyridine -> Bipyridine + Hydrogen
//        CHEMICAL_RECIPES.recipeBuilder("bipyridine_and_hydrogen")
//                .notConsumable(dust, Nickel)
//                .notConsumable(dust, Aluminium)
//                .inputFluids(Pyridine.getFluid(2000))
//                .outputItems(dust, Bipyridine, 20)
//                .outputFluids(Hydrogen.getFluid(2000))
//                .EUt(1920)
//                .duration(300)
//                .save(provider);
//
//        //  Thallium Chloride + Formaldehyde + Acetaldehyde -> Pyridine + Hydrogen + Water
//        LARGE_CHEMICAL_RECIPES.recipeBuilder("pyridine_and_hydrogen_and_water")
//                .notConsumable(dust, ThalliumChloride)
//                .inputFluids(Formaldehyde.getFluid(1000))
//                //.inputFluids(Acetaldehyde.getFluid(2000))
//                .circuitMeta(21)
//                .outputFluids(Pyridine.getFluid(1000))
//                .outputFluids(Hydrogen.getFluid(2000))
//                .outputFluids(Water.getFluid(3000))
//                .EUt(1920)
//                .duration(240)
//                .save(provider);
//
//        //  Formaldehyde (IV)
//        CHEMICAL_RECIPES.recipeBuilder("formaldehyde_iv")
//                .inputItems(dust, SodiumPeriodate, 6)
//                .notConsumable(dust, OsmiumTetroxide)
//                .inputFluids(Acetone.getFluid(1000))
//                .outputItems(dust, SodiumIodate, 5)
//                .outputFluids(Formaldehyde.getFluid(1000))
//                //.outputFluids(Acetaldehyde.getFluid(1000))
//                .EUt(7680)
//                .duration(220)
//                .save(provider);
//
//        //  Formaldehyde (LuV)
//        CHEMICAL_RECIPES.recipeBuilder("formaldehyde_luv")
//                .notConsumable(dust, Silver)
//                .inputFluids(Methanol.getFluid(1000))
//                .inputFluids(Oxygen.getFluid(1000))
//                .circuitMeta(1)
//                .outputFluids(Formaldehyde.getFluid(1000))
//                .outputFluids(Water.getFluid(1000))
//                .EUt(30720)
//                .duration(200)
//                .save(provider);
//
//        //  PalladiumChloride + Dibenzylideneacetone -> Palladium Bisdibenzylidieneacetone
//        CHEMICAL_RECIPES.recipeBuilder("palladium_bisdibenzylidieneacetone")
//                .inputItems(dust, PalladiumChloride, 6)
//                .inputFluids(Dibenzylideneacetone.getFluid(3000))
//                .outputItems(dust, PalladiumBisdibenzylidieneacetone, 16)
//                .outputFluids(Chlorine.getFluid(4000))
//                .EUt(1920)
//                .duration(160)
//                .save(provider);
//
//        //  Palladium Chloride
//        CHEMICAL_RECIPES.recipeBuilder("palladium_chloride")
//                .inputItems(dust, Palladium)
//                .inputFluids(Chlorine.getFluid(2000))
//                .circuitMeta(2)
//                .outputItems(dust, PalladiumChloride, 3)
//                .EUt(30)
//                .duration(320)
//                .save(provider);
//
//        //  Acetone + Benzaldehyde -> Dibenzylideneacetone + Water
//        CHEMICAL_RECIPES.recipeBuilder("dibenzylideneacetone_and_water")
//                .inputFluids(Acetone.getFluid(1000))
//                .inputFluids(Benzaldehyde.getFluid(2000))
//                .outputFluids(Dibenzylideneacetone.getFluid(1000))
//                .outputFluids(Water.getFluid(2000))
//                .EUt(VA[HV])
//                .duration(440)
//                .save(provider);
//
//        //  Barite dust + Palladium on Carbon + Benzoyl Chloride + Hydrogen -> Benzaldehyde +
// DilutedHydrochloricAcid
//        CHEMICAL_RECIPES.recipeBuilder("benzaldehyde_and_diluted_hydrochloric_acid")
//                .notConsumable(dust, Barite)
//                .notConsumable(dust, PalladiumOnCarbon)
//                .inputFluids(BenzoylChloride.getFluid(2000))
//                .inputFluids(Hydrogen.getFluid(1000))
//                .outputFluids(Benzaldehyde.getFluid(1000))
//                .outputFluids(DilutedHydrochloricAcid.getFluid(1000))
//                .EUt(VA[HV])
//                .duration(260)
//                .save(provider);
//
//        //  Palladium Chloride + Carbon dust + Formaldehyde + Hydrochloric Acid -> Palladium on
// Carbon
//        CHEMICAL_RECIPES.recipeBuilder("palladium_on_carbon")
//                .inputItems(dust, PalladiumChloride)
//                .inputItems(dust, Carbon)
//                .inputFluids(Formaldehyde.getFluid(1000))
//                .inputFluids(HydrochloricAcid.getFluid(1000))
//                .outputItems(dust, PalladiumOnCarbon)
//                .EUt(1920)
//                .duration(100)
//                .save(provider);
//
//        //  Potassium Permanganate + Thionyl Chloride -> Benzoyl Chloride
//        CHEMICAL_PLANT_RECIPES.recipeBuilder("benzoyl_chloride")
//                .inputItems(dust, PotassiumPermanganate, 24)
//                .inputFluids(ThionylChloride.getFluid(1000))
//                .inputFluids(Toluene.getFluid(2000))
//                .outputItems(dust, Pyrolusite, 12)
//                .outputFluids(BenzoylChloride.getFluid(2000))
//                .outputFluids(SulfurDioxide.getFluid(1000))
//                .outputFluids(PotassiumHydroxide.getFluid(4000))
//                .outputFluids(Water.getFluid(1000))
//                //.CasingTier(3)
//                .EUt(VA[IV])
//                .duration(200)
//                .save(provider);
//
//        //  Thionyl Chloride
//        CHEMICAL_RECIPES.recipeBuilder("thionyl_chloride")
//                .inputItems(dust, Sulfur)
//                .inputFluids(SulfurTrioxide.getFluid(1000))
//                .inputFluids(Chlorine.getFluid(1000))
//                .outputFluids(ThionylChloride.getFluid(1000))
//                .outputFluids(SulfurDioxide.getFluid(1000))
//                .EUt(480)
//                .duration(320)
//                .save(provider);
//
//        //  Potassium + Oxygen -> Potash
//        CHEMICAL_RECIPES.recipeBuilder("potash")
//                .inputItems(dust, Potassium, 2)
//                .inputFluids(Oxygen.getFluid(1000))
//                .circuitMeta(1)
//                .outputItems(dust, Potash)
//                .EUt(VA[LV])
//                .duration(30)
//                .save(provider);
//
//        //  Potash + Sulfuric Acid -> Potassium Hydroxide + Sulfur Trioxide
//        ROASTER_RECIPES.recipeBuilder("potassium_hydroxide_and_sulfur_trioxide")
//                .inputItems(dust, Potash)
//                .inputFluids(SulfuricAcid.getFluid(1000))
//                .outputItems(dust, PotassiumHydroxide, 2)
//                .outputFluids(SulfurTrioxide.getFluid(1000))
//                //.temperature(299)
//                .EUt(VA[HV])
//                .duration(480)
//                .save(provider);
//
//        //  Potassium Manganate + Water -> Potassium Permanganate + Pyrolusite + Potassium
// Hydroxide
//
// ROASTER_RECIPES.recipeBuilder("potassium_permanganate_and_pyrolusite_and_potassium_hydroxide")
//                .inputItems(dust, PotassiumManganate, 21)
//                .inputFluids(Water.getFluid(2000))
//                .outputItems(dust, PotassiumPermanganate, 12)
//                .outputItems(dust, Pyrolusite, 3)
//                .outputFluids(PotassiumHydroxide.getFluid(4000))
//                //.temperature(720)
//                .EUt(120)
//                .duration(250)
//                .save(provider);
//
//        //  Pyrolusite + PotassiumHydroxide + Oxygen -> Potassium Manganate + Water
//        CHEMICAL_RECIPES.recipeBuilder("potassium_manganate_and_water")
//                .inputItems(dust, Pyrolusite, 3)
//                .inputFluids(PotassiumHydroxide.getFluid(2000))
//                .inputFluids(Oxygen.getFluid(1000))
//                .outputItems(dust, PotassiumManganate, 7)
//                .outputFluids(Water.getFluid(1000))
//                .EUt(30)
//                .duration(170)
//                .save(provider);
//
//        //  Silver Tetrafluoroborate
//        CHEMICAL_RECIPES.recipeBuilder("silver_tetrafluoroborate")
//                .inputItems(dust, SilverOxide, 9)
//                .inputFluids(BoronTrifluoride.getFluid(8000))
//                .chancedInput((Benzene.getFluid(1)),0,0)
//                .outputItems(dust, BoronTrioxide, 5)
//                .outputFluids(SilverTetrafluoroborate.getFluid(6000))
//                .EUt(7680)
//                .duration(650)
//                .save(provider);
//
//        //  Silver + Chlorine -> Silver Chloride
//        CHEMICAL_RECIPES.recipeBuilder("silver_chloride")
//                .inputItems(dust, Silver)
//                .inputFluids(Chlorine.getFluid(1000))
//                .circuitMeta(1)
//                .outputItems(dust, SilverChloride, 2)
//                .EUt(120)
//                .duration(40)
//                .save(provider);
//
//        //  Silver Chloride + Sodium Hydroxide + Water -> Silver Oxide + Hydrofluoric Acid
//        CHEMICAL_RECIPES.recipeBuilder("silver_oxide_and_hydrofluoric_acid")
//                .inputItems(dust, SilverChloride, 4)
//                .notConsumable(dust, SodiumHydroxide)
//                .inputFluids(Water.getFluid(1000))
//                .outputItems(dust, SilverOxide, 3)
//                .outputFluids(HydrofluoricAcid.getFluid(2000))
//                .EUt(VA[HV])
//                .duration(180)
//                .save(provider);
//
//        //  Tin Chloride + Magnesium + Iodine + Methane + Oxygen -> Trimethyltin Chloride +
// Diluted Hydrochloric Acid
//
// CHEMICAL_PLANT_RECIPES.recipeBuilder("trimethyltin_chloride_and_diluted_hydrochloric_acid")
//                .inputItems(dust, TinChloride)
//                .notConsumable(dust, Magnesium)
//                .notConsumable(dust, Iodine)
//                .inputFluids(Methane.getFluid(3000))
//                .inputFluids(Oxygen.getFluid(1000))
//                .outputFluids(TrimethyltinChloride.getFluid(1000))
//                .outputFluids(DilutedHydrochloricAcid.getFluid(2000))
//                //.CasingTier(2)
//                .EUt(1920)
//                .duration(260)
//                .save(provider);
//
//        //  Tin + Chlorine -> Tin Chlorine
//        CHEMICAL_RECIPES.recipeBuilder("tin_chlorine_3")
//                .inputItems(dust, Tin)
//                .inputFluids(Chlorine.getFluid(2000))
//                .circuitMeta(2)
//                .outputItems(dust, TinChloride, 3)
//                .EUt(VA[LV])
//                .duration(60)
//                .save(provider);
//    }
// }
