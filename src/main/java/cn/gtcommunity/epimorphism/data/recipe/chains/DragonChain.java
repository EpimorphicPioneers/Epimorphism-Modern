//package cn.gtcommunity.epimorphism.data.recipe.chains;
//
//import cn.gtcommunity.epimorphism.common.recipe.NeutronKineticEnergyCondition;
//import com.gregtechceu.gtceu.api.data.chemical.material.MarkerMaterials;
//import com.gregtechceu.gtceu.api.machine.multiblock.CleanroomType;
//import net.minecraft.data.recipes.FinishedRecipe;
//import net.minecraft.world.item.Items;
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
//public class DragonChain {
//    public static void init(Consumer<FinishedRecipe> provider) {
//
//        //  Dragon process Step1
//        ROASTER_RECIPES.recipeBuilder("dragon_process_step_1")
//                .inputItems(dust, DragonDust, 16)
//                .inputItems(dust, SodiumPerchlorate, 6)
//                .inputFluids(SulfurDioxide.getFluid(8000))
//                .inputFluids(NitricAcid.getFluid(L * 40))
//                .outputItems(dust, Astatine, 8)
//                .outputItems(dust, SeleniumDioxide, 24)
//                .outputFluids(NitratedDragonDustSolution.getFluid(4000))
//                .EUt(VA[ZPM])
//                .duration(270)
//                //.temperature(2440)
//                .save(provider);
//
//        //  Dragon process Step2
//        CHEMICAL_RECIPES.recipeBuilder("dragon_process_step_2")
//                .inputItems(dust, SodiumHydroxide, 36)
//                .inputFluids(NitratedDragonDustSolution.getFluid(2000))
//                .outputItems(dust, ActiniumDraconiumHydroxides, 29)
//                .outputItems(dust, SodiumSulfide, 12)
//                .outputFluids(ResidualDraconiumSolution.getFluid(2000))
//                .EUt(VA[UV])
//                .duration(190)
//                .save(provider);
//
////        //  Actinium Draconium Hydroxides -> Actinium Radium Hydroxide Solution
////        MIXER_RECIPES.recipeBuilder("actinium_radium_hydroxide_solution")
////                .inputItems(dust, ActiniumDraconiumHydroxides, 58)
////                .inputItems(dust, Radium)
////                .inputItems(PROTONATED_FULLERENE_SIEVING_MATRIX)
////                .inputFluids(Water.getFluid(2000))
////                .outputItems(SATURATED_FULLERENE_SIEVING_MATRIX)
////                .outputFluids(ActiniumRadiumHydroxideSolution.getFluid(2000))
////                .EUt(VA[UV])
////                .duration(210)
////                .save(provider);
//
//        //  Actinium Radium Hydroxide Solution -> Actinium Radium Nitrate Solution
//        DISSOLUTION_TANK_RECIPES.recipeBuilder("actinium_radium_nitrate_solution")
//                .inputFluids(ActiniumRadiumHydroxideSolution.getFluid(1000))
//                .inputFluids(NitricAcid.getFluid(12000))
//                .outputFluids(ActiniumRadiumNitrateSolution.getFluid(13000))
//                .EUt(VA[IV])
//                .duration(290)
//                .save(provider);
//
//        //  Actinium Radium Nitrate Solution -> Actinium Nitrate + Radium Nitrate + Th, Pa, Fr, Ra
//        CENTRIFUGE_RECIPES.recipeBuilder("actinium_nitrate_and_radium_nitrate_and_th_pa_fr_ra_1")
//                .inputFluids(ActiniumRadiumNitrateSolution.getFluid(13000))
//                .outputItems(dust, ActiniumNitrate, 26)
//                .outputItems(dust, RadiumNitrate, 27)
//                .outputItems(dustSmall, Thorium)
//                .outputItems(dustSmall, Protactinium)
//                .outputItems(dustSmall, Francium)
//                .outputItems(dustSmall, Radium)
//                .EUt(VA[ZPM])
//                .duration(240)
//                .save(provider);
//
//        ROASTER_RECIPES.recipeBuilder("actinium_nitrate_and_radium_nitrate_and_th_pa_fr_ra_2")
//                .inputItems(dust, ActiniumNitrate, 13)
//                .inputFluids(Water.getFluid(4000))
//                .outputItems(dust, Actinium)
//                .outputFluids(Nitrogen.getFluid(3000))
//                .outputFluids(Oxygen.getFluid(9000))
//                .outputFluids(Steam.getFluid(4000))
//                .EUt(VA[HV])
//                .duration(210)
//                //.temperature(1998)
//                .save(provider);
//
//        ROASTER_RECIPES.recipeBuilder("actinium_nitrate_and_radium_nitrate_and_th_pa_fr_ra_3")
//                .inputItems(dust, RadiumNitrate, 9)
//                .inputFluids(Water.getFluid(2000))
//                .outputItems(dust, Radium)
//                .outputFluids(Nitrogen.getFluid(2000))
//                .outputFluids(Oxygen.getFluid(6000))
//                .outputFluids(Steam.getFluid(2000))
//                .EUt(VA[HV])
//                .duration(210)
//                //.temperature(2137)
//                .save(provider);
//
//
////        //  Fullerene Sieving Matrix
////        VACUUM_CHAMBER_RECIPES.recipeBuilder("fullerene_sieving_matrix")
////                .inputItems(dust, Fluorocarborane, 50)
////                .inputItems(wireFine, Naquadah, 6)
////                .inputItems(dust, Osmium)
////                .inputFluids(Perfluorobenzene.getFluid(2000))
////                .outputItems(PROTONATED_FULLERENE_SIEVING_MATRIX)
////                .EUt(VA[UV])
////                .duration(380)
////                .cleanroom(CleanroomType.CLEANROOM)
////                .save(provider);
//
////        //  Saturated Fullerene Sieving Matrix cycle
////        CHEMICAL_RECIPES.recipeBuilder("saturated_fullerene_sieving_matrix_cycle")
////                .inputItems(SATURATED_FULLERENE_SIEVING_MATRIX)
////                .inputFluids(FluoroantimonicAcid.getFluid(8000))
////                .inputFluids(KryptonDifluoride.getFluid(16000))
////                .outputItems(dust, AntimonyTrifluoride, 32)
////                .outputItems(dust, Fluorocarborane, 50)
////                .outputFluids(Krypton.getFluid(16000))
////                .outputFluids(HeavyFluorinatedDraconiumSolution.getFluid(8000))
////                .EUt(VA[ZPM])
////                .duration(180)
////                .save(provider);
//
//        //  Heavy Fluorinated Draconium Solution
//        CENTRIFUGE_RECIPES.recipeBuilder("heavy_fluorinated_draconium_solution_1")
//                .inputFluids(HeavyFluorinatedDraconiumSolution.getFluid(8000))
//                .outputItems(dust, DraconiumTetrafluoride, 60)
//                .outputFluids(Fluorine.getFluid(16000))
//                .outputFluids(Perfluorobenzene.getFluid(2000))
//                .EUt(VA[LuV])
//                .duration(360)
//                .save(provider);
//
//        ELECTROLYZER_RECIPES.recipeBuilder("heavy_fluorinated_draconium_solution_2")
//                .inputItems(dust, DraconiumTetrafluoride, 5)
//                .inputFluids(Sodium.getFluid(500))
//                .outputItems(dust, Draconium)
//                .outputItems(dust, Sodium, 2)
//                .outputFluids(Fluorine.getFluid(6000))
//                .EUt(VA[EV])
//                .duration(120)
//                .save(provider);
//
//        //  Krypton Difluoride
//        ULTRAVIOLET_LAMP_CHAMBER_RECIPES.recipeBuilder("krypton_difluoride")
//                .notConsumable(lens, MarkerMaterials.Color.Green)
//                .inputFluids(Krypton.getFluid(1000))
//                .inputFluids(Fluorine.getFluid(2000))
//                .outputFluids(KryptonDifluoride.getFluid(1000))
//                .EUt(VA[HV])
//                .duration(170)
//                .save(provider);
//
//        //  Perfluorobenzene
//        CHEMICAL_RECIPES.recipeBuilder("perfluorobenzene")
//                .notConsumable(dust, Rhenium)
//                .inputItems(dust, PotassiumFluoride, 12)
//                .inputFluids(Benzene.getFluid(1000))
//                .inputFluids(Chlorine.getFluid(6000))
//                .outputItems(dust, RockSalt, 12)
//                .outputFluids(Perfluorobenzene.getFluid(1000))
//                .outputFluids(Hydrogen.getFluid(6000))
//                .EUt(VA[HV])
//                .duration(190)
//                .save(provider);
//
//        //  Fluorocarborane
//        CHEMICAL_PLANT_RECIPES.recipeBuilder("fluorocarborane")
//                .inputItems(dust, CaesiumCarborane, 50)
//                .inputItems(dust, SilverNitrate, 10)
//                .inputItems(dust, Iodine, 2)
//                .inputFluids(Fluorine.getFluid(44000))
//                .inputFluids(HydrochloricAcid.getFluid(1000))
//                .inputFluids(Trimethylsilane.getFluid(1000))
//                .outputItems(dust, Fluorocarborane, 50)
//                .outputItems(dust, CaesiumNitrate, 10)
//                .outputItems(dust, SilverIodide, 4)
//                .outputFluids(HydrofluoricAcid.getFluid(22000))
//                .outputFluids(Trimethylchlorosilane.getFluid(1000))
//                .EUt(VA[ZPM])
//                .duration(320)
//                //.CasingTier(5)
//                .cleanroom(CleanroomType.CLEANROOM)
//                .save(provider);
//
//
//        //  Silver Nitrate
//        CHEMICAL_RECIPES.recipeBuilder("silver_nitrate_1")
//                .inputItems(dust, Silver)
//                .inputFluids(NitricAcid.getFluid(2000))
//                .outputItems(dust, SilverNitrate, 5)
//                .outputFluids(NitrogenDioxide.getFluid(1000))
//                .outputFluids(Water.getFluid(1000))
//                .EUt(VA[MV])
//                .duration(150)
//                .save(provider);
//
//        CHEMICAL_RECIPES.recipeBuilder("silver_nitrate_2")
//                .inputItems(dust, SilverOxide)
//                .inputFluids(NitricAcid.getFluid(2000))
//                .outputItems(dust, SilverNitrate, 10)
//                .outputFluids(Water.getFluid(1000))
//                .EUt(VA[MV])
//                .duration(150)
//                .save(provider);
//
//        //  Caesium Carbonrane
//        CHEMICAL_PLANT_RECIPES.recipeBuilder("caesium_carbonrane")
//                .inputItems(dust, CaesiumCarboranePrecursor, 38)
//                .inputItems(dust, LithiumHydride)
//                .inputFluids(BoraneDimethylsulfide.getFluid(1000))
//                .inputFluids(Tetrahydrofuran.getFluid(1000))
//                .outputItems(dust, CaesiumCarborane, 25)
//                .outputItems(dust, LithiumChloride, 2)
//                .outputFluids(Trimethylamine.getFluid(1000))
//                .outputFluids(HydrogenSulfide.getFluid(1000))
//                .outputFluids(Methane.getFluid(2000))
//                .outputFluids(Tetrahydrofuran.getFluid(1000))
//                .EUt(VA[LuV])
//                .duration(260)
//                //.CasingTier(3)
//                .save(provider);
//
//        //  Caesium Carborane Precursor
//        CHEMICAL_PLANT_RECIPES.recipeBuilder("caesium_carborane_precursor")
//                .inputItems(dust, CaesiumHydroxide, 3)
//                .inputItems(dust, Decaborane, 24)
//                .inputItems(dust, SodiumCyanide, 1)
//                .inputFluids(HydrochloricAcid.getFluid(2000))
//                .inputFluids(Methanol.getFluid(3000))
//                .inputFluids(SulfuricAcid.getFluid(1000))
//                .outputItems(dust, CaesiumCarboranePrecursor, 38)
//                .outputItems(dust, Salt, 2)
//                .outputFluids(Water.getFluid(4000))
//                .outputFluids(SulfuricAcid.getFluid(1000))
//                .EUt(VA[IV])
//                .duration(240)
//                //.CasingTier(2)
//                .save(provider);
//
//        //  Caesium Hydroxide
//        CHEMICAL_BATH_RECIPES.recipeBuilder("caesium_hydroxide")
//                .inputItems(dust, Caesium, 2)
//                .inputFluids(HydrogenPeroxide.getFluid(1000))
//                .outputItems(dust, CaesiumHydroxide, 6)
//                .EUt(VA[HV])
//                .duration(180)
//                .save(provider);
//
//        //  Decaborane
//        CHEMICAL_PLANT_RECIPES.recipeBuilder("decaborane")
//                .inputItems(dust, SodiumBorohydride, 51)
//                .inputFluids(HydrofluoricAcid.getFluid(1000))
//                .inputFluids(HydrogenPeroxide.getFluid(2000))
//                .inputFluids(BoronTrifluorideEtherate.getFluid(10000))
//                .outputItems(dust, Decaborane, 24)
//                .outputItems(dust, SodiumFluoride, 2)
//                .outputItems(dust, SodiumTetrafluoroborate, 45)
//                .outputFluids(Water.getFluid(1000))
//                .outputFluids(Hydrogen.getFluid(20000))
//                .outputFluids(DiethylEther.getFluid(10000))
//                .EUt(VA[IV])
//                .duration(280)
//                //.CasingTier(4)
//                .save(provider);
//
//        //  Sodium Borohydride
//        LARGE_CHEMICAL_RECIPES.recipeBuilder("sodium_borohydride")
//                .inputItems(dust, Sodium, 8)
//                .inputItems(dust, LithiumHydride, 8)
//                .inputFluids(BoricAcid.getFluid(1000))
//                .inputFluids(Ethanol.getFluid(3000))
//                .chancedInput((SulfuricAcid.getFluid(1)),0,0)
//                .outputItems(dust, SodiumBorohydride, 6)
//                .outputItems(dust, SodiumEthoxide, 27) //TODO use of Sodium Ethoxide
//                .outputItems(dust, Lithium, 8)
//                .outputFluids(Water.getFluid(3000))
//                .EUt(VA[EV])
//                .duration(120)
//                .save(provider);
//
//        //  Sodium Tetrafluoroborate cycle
//        CHEMICAL_RECIPES.recipeBuilder("sodium_tetrafluoroborate_cycle")
//                .inputItems(dust, SodiumTetrafluoroborate, 6)
//                .circuitMeta(0)
//                .outputItems(dust, SodiumFluoride, 2)
//                .outputFluids(BoronTrifluoride.getFluid(1000))
//                .EUt(VA[MV])
//                .duration(120)
//                .save(provider);
//
//        //  Diethyl Ether -> Boron Trifluoride Etherate cycle
//        MIXER_RECIPES.recipeBuilder("boron_trifluoride_etherate_cycle")
//                .inputFluids(DiethylEther.getFluid(1000))
//                .inputFluids(BoronTrifluoride.getFluid(1000))
//                .outputFluids(BoronTrifluorideEtherate.getFluid(1000))
//                .EUt(VA[MV])
//                .duration(150)
//                .save(provider);
//
//        //  Borane Dimethylsulfide
//        DISSOLUTION_TANK_RECIPES.recipeBuilder("borane_dimethylsulfide_1")
//                .inputFluids(SulfuricAcid.getFluid(1000))
//                .inputFluids(Ethanol.getFluid(1000))
//                .outputFluids(DiethylEther.getFluid(1000))
//                .EUt(VA[EV])
//                .duration(120)
//                .save(provider);
//
//        CHEMICAL_RECIPES.recipeBuilder("borane_dimethylsulfide_2")
//                .inputFluids(Diborane.getFluid(1000))
//                .inputFluids(DimethylSulfide.getFluid(1000))
//                .outputFluids(BoraneDimethylsulfide.getFluid(2000))
//                .EUt(VA[LuV])
//                .duration(100)
//                .save(provider);
//
//        DISSOLUTION_TANK_RECIPES.recipeBuilder("borane_dimethylsulfide_3")
//                .inputFluids(Methanol.getFluid(2000))
//                .inputFluids(HydrogenSulfide.getFluid(1000))
//                .outputFluids(DimethylSulfide.getFluid(1000))
//                .outputFluids(Water.getFluid(2000))
//                .EUt(VA[EV])
//                .duration(1000)
//                .save(provider);
//
//        //  Trimethylsilane
//        CHEMICAL_RECIPES.recipeBuilder("trimethylsilane")
//                .inputItems(dust, Silicon)
//                .inputFluids(Chloromethane.getFluid(3000))
//                .outputFluids(Trimethylsilane.getFluid(1000))
//                .outputFluids(Chlorine.getFluid(1000))
//                .EUt(VA[EV])
//                .duration(180)
//                .save(provider);
//
//        //  Silver Iodide -> Iodine cycle
//        BLAST_RECIPES.recipeBuilder("iodine_cycle")
//                .inputItems(dust, SilverIodide, 4)
//                .inputFluids(Oxygen.getFluid(1000))
//                .outputItems(dust, SilverOxide, 3)
//                .outputItems(dust, Iodine, 2)
//                .EUt(VA[MV])
//                .duration(210)
//                .blastFurnaceTemp(1100)
//                .save(provider);
//
//        //  Trimethylchlorosilane -> Trimethylsilane cycle
//        CHEMICAL_RECIPES.recipeBuilder("trimethylsilane_cycle")
//                .inputItems(dust, LithiumHydride, 2)
//                .inputFluids(Trimethylchlorosilane.getFluid(1000))
//                .outputItems(dust, LithiumChloride, 2)
//                .outputFluids(Trimethylsilane.getFluid(1000))
//                .EUt(VA[EV])
//                .duration(170)
//                .save(provider);
//
//        //  Residual Draconium Solution
//        DRYER_RECIPES.recipeBuilder("residual_draconium_solution")
//                .inputFluids(ResidualDraconiumSolution.getFluid(2000))
//                .outputItems(dust, SodiumNitrate, 20)
//                .outputItems(dust, Salt)
//                .outputFluids(DraconiumSlagSolution.getFluid(500))
//                .EUt(VA[LuV])
//                .duration(240)
//                .save(provider);
//
//        //  Draconium Slag Solution -> Draconium dust
//        CENTRIFUGE_RECIPES.recipeBuilder("draconium_dust")
//                .inputFluids(DraconiumSlagSolution.getFluid(500))
//                .outputItems(dust, Draconium)
//                .chancedOutput(dustSmall, Draconium, 3, 2000, 0)
//                .chancedOutput(dustTiny, Draconium, 7, 3000, 0)
//                .EUt(VA[EV])
//                .duration(400)
//                .save(provider);
//
//        //  Dragon Breath compatibility
//        EXTRACTOR_RECIPES.recipeBuilder("dragon_breath_compatibility_1")
//                .inputItems(Items.DRAGON_BREATH)
//                .outputItems(Items.GLASS_BOTTLE)
//                .outputFluids(DragonBreath.getFluid(1000))
//                .EUt(VA[HV])
//                .duration(50)
//                .save(provider);
//
//        CANNER_RECIPES.recipeBuilder("dragon_breath_compatibility_2")
//                .inputItems(Items.GLASS_BOTTLE)
//                .inputFluids(DragonBreath.getFluid(1000))
//                .outputItems(Items.DRAGON_BREATH)
//                .EUt(VA[ULV])
//                .duration(100)
//                .save(provider);
//
//        //  Draconium + Dragon Breath -> Concentrate Dragon Breath
//        MIXER_RECIPES.recipeBuilder("concentrate_dragon_breath")
//                .inputItems(dust, Draconium)
//                .inputFluids(DragonBreath.getFluid(1000))
//                .outputFluids(ConcentrateDragonBreath.getFluid(1000))
//                .EUt(VA[IV])
//                .duration(240)
//                .cleanroom(CleanroomType.CLEANROOM)
//                .save(provider);
//    }
//}