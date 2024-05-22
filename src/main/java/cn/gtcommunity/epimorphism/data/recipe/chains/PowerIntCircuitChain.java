//package cn.gtcommunity.epimorphism.data.recipe.chains;
//
//import com.gregtechceu.gtceu.api.machine.multiblock.CleanroomType;
//
//import static cn.gtcommunity.epimorphism.common.data.EPItems.*;
//import static cn.gtcommunity.epimorphism.common.data.EPMaterials.*;
//import static com.gregtechceu.gtceu.api.GTValues.*;
//import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.*;
//import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
//import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.*;
//
//public class PowerIntCircuitChain {
//    public static void init() {
//        NanoPIC();
//        PicoPIC();
//    }
//
//    private static void NanoPIC() {
//        //  Niobium + Chlorine -> Niobium Pentachloride
//        CHEMICAL_RECIPES.recipeBuilder()
//                .input(dust, Niobium)
//                .fluidInputs(Chlorine.getFluid(5000))
//                .circuitMeta(5)
//                .output(dust, NiobiumPentachloride, 6)
//                .EUt(VA[MV])
//                .duration(290)
//                .buildAndRegister();
//
//        //  Niobium Pentachloride + Lithium Hydride -> Lithium Niobate + Sulfuric Acid (chlorine cycle, 5HCl -> Cl5 -> NbCl5)
//        BLAST_RECIPES.recipeBuilder()
//                .input(dust, NiobiumPentachloride, 6)
//                .input(dust, LithiumHydride, 2)
//                .notConsumable(dust, Hafnium)
//                .fluidInputs(HydrogenPeroxide.getFluid(2000))
//                .output(ingotHot, LithiumNiobate, 6)
//                .fluidOutputs(SulfuricAcid.getFluid(5000))
//                .EUt(VA[HV])
//                .duration(320)
//                .blastFurnaceTemp(4500)
//                .buildAndRegister();
//
//        //  Lithium Niobate Lens (plate recipe)
//        LATHE_RECIPES.recipeBuilder()
//                .input(plate, LithiumNiobate)
//                .output(lens, LithiumNiobate)
//                .output(dustSmall, LithiumNiobate)
//                .EUt(VA[MV])
//                .duration(1200)
//                .buildAndRegister();
//
//        //  Nano PIC
//        LASER_ENGRAVER_RECIPES.recipeBuilder()
//                .input(DUBNIUM_WAFER)
//                .notConsumable(lens, LithiumNiobate)
//                .output(NANO_PIC_WAFER)
//                .EUt(VA[UV])
//                .duration(20)
//                .cleanroom(CleanroomType.CLEANROOM)
//                .buildAndRegister();
//
//        CUTTER_RECIPES.recipeBuilder()
//                .input(NANO_PIC_WAFER)
//                .fluidInputs(Water.getFluid(1000))
//                .output(NANO_PIC_CHIP, 2)
//                .EUt(VA[ZPM])
//                .duration(1800)
//                .cleanroom(CleanroomType.CLEANROOM)
//                .buildAndRegister();
//
//        CUTTER_RECIPES.recipeBuilder()
//                .input(NANO_PIC_WAFER)
//                .fluidInputs(DistilledWater.getFluid(750))
//                .output(NANO_PIC_CHIP, 2)
//                .EUt(VA[ZPM])
//                .duration(1350)
//                .cleanroom(CleanroomType.CLEANROOM)
//                .buildAndRegister();
//
//        CUTTER_RECIPES.recipeBuilder()
//                .input(NANO_PIC_WAFER)
//                .fluidInputs(Lubricant.getFluid(250))
//                .output(NANO_PIC_CHIP, 2)
//                .EUt(VA[ZPM])
//                .duration(900)
//                .cleanroom(CleanroomType.CLEANROOM)
//                .buildAndRegister();
//    }
//
//    private static void PicoPIC() {
//
//        //  Ammonium Vanadate + Sodium Oxide + Salt -> High Purity Sodium Vanadate
//        BLAST_RECIPES.recipeBuilder()
//                .input(dust, AmmoniumVanadate, 9)
//                .input(dust, SodiumOxide, 3)
//                .input(dust, Salt, 2)
//                .output(dust, HighPuritySodiumVanadate, 8)
//                .fluidOutputs(AmmoniumChloride.getFluid(1000))
//                .EUt(VA[EV])
//                .duration(280)
//                .blastFurnaceTemp(700)
//                .buildAndRegister();
//
//        //  High Purity Sodium Vanadate + Carbamide + Lu-Tm-Y Chlorides Solution -> Lu-Tm-droped Yttrium Vanadate Deposition + Chlorine
//        CHEMICAL_RECIPES.recipeBuilder()
//                .input(dust, HighPuritySodiumVanadate, 8)
//                .input(dust, Carbamide, 16)
//                .fluidInputs(LutetiumThuliumYttriumChloridesSolution.getFluid(1000))
//                .output(dust, YttriumVanadateLuTmDeposition)
//                .fluidOutputs(Chlorine.getFluid(900))
//                .EUt(VA[ZPM])
//                .duration(120)
//                .cleanroom(CleanroomType.CLEANROOM)
//                .buildAndRegister();
//
//        //  Lu-Tm-droped Yttrium Vanadate deposition + Ethanol -> Lu/Tm:YVO + Ammonium Carbonate + Propene
//        DRYER_RECIPES.recipeBuilder()
//                .input(dust, YttriumVanadateLuTmDeposition)
//                .fluidInputs(Ethanol.getFluid(1000))
//                .output(dust, YttriumVanadateLuTm)
//                .output(dust, AmmoniumCarbonate, 14)
//                .fluidOutputs(Propene.getFluid(1000))
//                .EUt(VA[IV])
//                .duration(200)
//                .buildAndRegister();
//
//        //  Pico PIC
//        ULTRAVIOLET_LAMP_CHAMBER_RECIPES.recipeBuilder()
//                .input(NANO_PIC_WAFER)
//                .notConsumable(lens, YttriumVanadateLuTm)
//                .output(PICO_PIC_WAFER)
//                .EUt(VA[UHV])
//                .duration(40)
//                .cleanroom(CleanroomType.CLEANROOM)
//                .buildAndRegister();
//
//        CUTTER_RECIPES.recipeBuilder()
//                .input(PICO_PIC_WAFER)
//                .fluidInputs(Water.getFluid(1000))
//                .output(PICO_PIC_CHIP, 2)
//                .EUt(VA[UV])
//                .duration(1800)
//                .cleanroom(CleanroomType.CLEANROOM)
//                .buildAndRegister();
//
//        CUTTER_RECIPES.recipeBuilder()
//                .input(PICO_PIC_WAFER)
//                .fluidInputs(DistilledWater.getFluid(750))
//                .output(PICO_PIC_CHIP, 2)
//                .EUt(VA[UV])
//                .duration(1350)
//                .cleanroom(CleanroomType.CLEANROOM)
//                .buildAndRegister();
//
//        CUTTER_RECIPES.recipeBuilder()
//                .input(PICO_PIC_WAFER)
//                .fluidInputs(Lubricant.getFluid(250))
//                .output(PICO_PIC_CHIP, 2)
//                .EUt(VA[UV])
//                .duration(900)
//                .cleanroom(CleanroomType.CLEANROOM)
//                .buildAndRegister();
//    }
//}
