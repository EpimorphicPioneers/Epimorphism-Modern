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
//public class CrystalCircuits {
//    public static void init() {
//        GTRecipeHandler.removeRecipesByInputs(LASER_ENGRAVER_RECIPES,
//                CRYSTAL_CENTRAL_PROCESSING_UNIT.getStackForm(),
//                OreDictUnifier.get(craftingLens, Blue)
//        );
//
//        //  Cubic Zirconia + Europium -> Europium-doped Cubic Zirconia Boule
//        CRYSTALLIZER_RECIPES.recipeBuilder("")
//                .notConsumable(EPMetablocks.EP_CRUCIBLE_CASING.getItemVariant(EPBlockCrucibleCasing.CrucibleType.GRAPHITE_CRUCIBLE))
//                .inputItems(dust, CubicZirconia, 64)
//                .inputItems(dust, Europium, 8)
//                .blastFurnaceTemp(3000)
//                .outputItems(CUBIC_ZIRCONIA_EUROPIUM_BOULE)
//                .duration(120)
//                .EUt(VA[MV])
//                .save(provider);
//
//        //  Europium-doped Cubic Zirconia Boule -> Europium-doped Cubic Zirconia Wafer
//        CUTTER_RECIPES.recipeBuilder("")
//                .inputItems(CUBIC_ZIRCONIA_EUROPIUM_BOULE)
//                .outputItems(CUBIC_ZIRCONIA_EUROPIUM_WAFER, 8)
//                .duration(100)
//                .EUt(VA[HV])
//                .cleanroom(CleanroomType.CLEANROOM)
//                .save(provider);
//
//        //  Europium-doped Cubic Zirconia Wafer -> Crystal Interface Wafer
//        LASER_ENGRAVER_RECIPES.recipeBuilder("")
//                .inputItems(CUBIC_ZIRCONIA_EUROPIUM_WAFER)
//                .notConsumable(craftingLens, LightBlue)
//                .outputItems(CRYSTAL_INTERFACE_WAFER)
//                .duration(20)
//                .EUt(VA[LuV])
//                .cleanroom(CleanroomType.CLEANROOM)
//                .save(provider);
//
//        //  Crystal Interface Wafer -> Crystal Interface Chip
//        CUTTER_RECIPES.recipeBuilder("")
//                .inputItems(CRYSTAL_INTERFACE_WAFER)
//                .outputItems(CRYSTAL_INTERFACE_CHIP, 8)
//                .duration(100)
//                .EUt(VA[HV])
//                .cleanroom(CleanroomType.CLEANROOM)
//                .save(provider);
//
//        //  Sapphire Crystal Chip
//        LASER_ENGRAVER_RECIPES.recipeBuilder("")
//                .inputItems(gemExquisite, Sapphire)
//                .notConsumable(craftingLens, Blue)
//                .outputItems(SAPPHIRE_CHIP)
//                .duration(1200)
//                .EUt(VA[HV])
//                .cleanroom(CleanroomType.CLEANROOM)
//                .save(provider);
//
//        //  Ruby Crystal Chip
//        LASER_ENGRAVER_RECIPES.recipeBuilder("")
//                .inputItems(gemExquisite, Ruby)
//                .notConsumable(craftingLens, Red)
//                .outputItems(RUBY_CHIP)
//                .duration(1200)
//                .EUt(VA[HV])
//                .cleanroom(CleanroomType.CLEANROOM)
//                .save(provider);
//
//        //  Diamond Crystal Chip
//        LASER_ENGRAVER_RECIPES.recipeBuilder("")
//                .inputItems(gemExquisite, Diamond)
//                .notConsumable(craftingLens, LightBlue)
//                .outputItems(DIAMOND_CHIP)
//                .duration(1200)
//                .EUt(VA[HV])
//                .cleanroom(CleanroomType.CLEANROOM)
//                .save(provider);
//
//        //  Sapphire Modulator
//        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder("")
//                .inputItems(SAPPHIRE_CHIP)
//                .inputItems(PLASTIC_CIRCUIT_BOARD)
//                .inputItems(wireFine, Palladium, 8)
//                .inputItems(bolt, Platinum, 4)
//                .outputItems(SAPPHIRE_MODULATOR, 8)
//                .solderMultiplier(1)
//                .duration(200)
//                .EUt(VA[IV])
//                .cleanroom(CleanroomType.CLEANROOM)
//                .save(provider);
//
//        //  Ruby Modulator
//        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder("")
//                .inputItems(RUBY_CHIP)
//                .inputItems(PLASTIC_CIRCUIT_BOARD)
//                .inputItems(wireFine, Palladium, 8)
//                .inputItems(bolt, Platinum, 4)
//                .outputItems(RUBY_MODULATOR, 8)
//                .duration(200)
//                .EUt(VA[IV])
//                .cleanroom(CleanroomType.CLEANROOM)
//                .save(provider);
//
//        //  Diamond Modulator
//        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder("")
//                .inputItems(DIAMOND_CHIP)
//                .inputItems(PLASTIC_CIRCUIT_BOARD)
//                .inputItems(wireFine, Palladium, 8)
//                .inputItems(bolt, Platinum, 4)
//                .outputItems(DIAMOND_MODULATOR, 8)
//                .duration(200)
//                .EUt(VA[IV])
//                .cleanroom(CleanroomType.CLEANROOM)
//                .save(provider);
//
//        //  Crystal SoC Socket
//        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder("")
//                .inputItems(CRYSTAL_INTERFACE_CHIP)
//                .inputItems(SAPPHIRE_MODULATOR)
//                .inputItems(RUBY_MODULATOR)
//                .inputItems(DIAMOND_MODULATOR)
//                .inputItems(wireFine, Europium, 4)
//                .outputItems(CRYSTAL_SOC_SOCKET)
//                .duration(100)
//                .EUt(VA[LuV])
//                .cleanroom(CleanroomType.CLEANROOM)
//                .save(provider);
//
//        //  Crystal SoC
//        FORMING_PRESS_RECIPES.recipeBuilder("")
//                .inputItems(CRYSTAL_SOC_SOCKET)
//                .inputItems(CRYSTAL_CENTRAL_PROCESSING_UNIT)
//                .outputItems(CRYSTAL_SYSTEM_ON_CHIP)
//                .duration(100)
//                .EUt(VA[ZPM])
//                .cleanroom(CleanroomType.CLEANROOM)
//                .save(provider);
//    }
//}
