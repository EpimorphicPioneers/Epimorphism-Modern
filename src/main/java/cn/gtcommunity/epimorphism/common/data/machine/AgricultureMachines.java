package cn.gtcommunity.epimorphism.common.data.machine;

import cn.gtcommunity.epimorphism.Epimorphism;
import cn.gtcommunity.epimorphism.api.pattern.EPPredicates;
import cn.gtcommunity.epimorphism.common.machine.multiblock.electric.agriculture.ForestryGreenhouseMachine;
import cn.gtcommunity.epimorphism.common.machine.multiblock.electric.agriculture.IndustrialFishingPondMachine;
import cn.gtcommunity.epimorphism.common.machine.multiblock.electric.agriculture.IndustrialGreenhouseMachine;
import cn.gtcommunity.epimorphism.common.machine.multiblock.noenergy.AlgaeFarmMachine;
import com.epimorphismmc.monomorphism.pattern.FactoryMOPattern;
import com.epimorphismmc.monomorphism.pattern.MOBlockPattern;
import com.epimorphismmc.monomorphism.pattern.utils.StructureUtil;
import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.data.RotationState;
import com.gregtechceu.gtceu.api.machine.MultiblockMachineDefinition;
import com.gregtechceu.gtceu.api.machine.multiblock.PartAbility;
import com.gregtechceu.gtceu.api.pattern.FactoryBlockPattern;
import com.gregtechceu.gtceu.api.pattern.MultiblockShapeInfo;
import com.gregtechceu.gtceu.api.recipe.OverclockingLogic;
import com.gregtechceu.gtceu.common.data.GTRecipeModifiers;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.block.Blocks;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static cn.gtcommunity.epimorphism.common.registry.EPRegistration.EP_REGISTRATE;
import static cn.gtcommunity.epimorphism.common.block.BlockMaps.SHAPE_GLASSES;
import static cn.gtcommunity.epimorphism.common.data.EPBlocks.*;
import static com.epimorphismmc.monomorphism.block.MOBlockMaps.ALL_MACHINE_CASINGS;
import static com.epimorphismmc.monomorphism.pattern.MOPredicates.*;
import static com.gregtechceu.gtceu.api.pattern.Predicates.*;
import static com.gregtechceu.gtceu.common.data.GTBlocks.CASING_LAMINATED_GLASS;
import static com.gregtechceu.gtceu.common.data.GTBlocks.CASING_STAINLESS_CLEAN;
import static com.gregtechceu.gtceu.common.data.GTMaterials.HSLASteel;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.DUMMY_RECIPES;
import static net.minecraft.world.level.block.Blocks.GLASS;

public class AgricultureMachines {
//    public static final MultiblockMachineDefinition EXTREME_INDUSTRIAL_GREENHOUSE = EP_REGISTRATE.multiblock("extreme_industrial_greenhouse", IndustrialGreenhouseMachine::new)
//            .langValue("Extreme Industrial Greenhouse")
//            .tooltips(Component.translatable("block.epimorphism.extreme_industrial_greenhouse.desc.0"))
//            .rotationState(RotationState.NON_Y_AXIS)
//            .recipeType(DUMMY_RECIPES)
//            .appearanceBlock(CASING_STAINLESS_CLEAN)
//            .pattern(definition -> FactoryMOPattern.start()
//                    .aisle("AAAAA", "AAAAA", "CCCCC", "CCCCC", "AAAAA", "AAAAA")
//                    .aisle("AGGGA", "ADDDA", "C   C", "C   C", "AEEEA", "AAAAA")
//                    .aisle("AGGGA", "ADFDA", "C   C", "C   C", "AEEEA", "AAAAA")
//                    .aisle("AGGGA", "ADDDA", "C   C", "C   C", "AEEEA", "AAAAA")
//                    .aisle("AABAA", "AAAAA", "CCCCC", "CCCCC", "AAAAA", "AAAAA")
//                    .where('B', controller(blocks(definition.getBlock())))
//                    .where('A', blocks(CASING_STAINLESS_CLEAN.get()).setMinGlobalLimited(61)
//                            .or(abilities(PartAbility.IMPORT_FLUIDS))
//                            .or(abilities(PartAbility.IMPORT_ITEMS))
//                            .or(abilities(PartAbility.INPUT_ENERGY))
//                            .or(abilities(PartAbility.EXPORT_ITEMS))
//                            .or(abilities(PartAbility.MAINTENANCE)))
//                    .where('C', EPPredicates.glass())
//                    .where('D', blocks(FERTILIZED_FARMLAND.get()))
//                    .where('E', blocks(CASING_LAMINATED_GLASS.get()))
//                    .where('F', blocks(Blocks.WATER))
//                    .where('G', blocks(CASING_STAINLESS_CLEAN.get()))
//                    .build()
//            )
//            .shapeInfos(definition -> {
//                List<MultiblockShapeInfo> shapeInfos = new ArrayList<>();
//                shapeInfos.addAll(StructureUtil.getMatchingShapes((MOBlockPattern) definition.getPatternFactory().get(), SHAPE_GLASSES.size()));
//                return shapeInfos;
//            })
//            .partSorter(Comparator.comparingInt(a -> a.self().getPos().getY()))
//            .workableCasingRenderer(GTCEu.id("block/casings/solid/machine_casing_clean_stainless_steel"),
//                    Epimorphism.id("block/multiblock/extreme_industrial_greenhouse"), false)
//            .register();
    public final static MultiblockMachineDefinition FORESTRY_GREENHOUSE = EP_REGISTRATE.multiblock("forestry_greenhouse", ForestryGreenhouseMachine::new)
            .langValue("Forestry Greenhouse")
            .tooltips(Component.translatable("block.epimorphism.forestry_greenhouse.desc.0"))
            .rotationState(RotationState.NON_Y_AXIS)
            .recipeType(DUMMY_RECIPES)
            .appearanceBlock(CASING_STAINLESS_CLEAN)
            .pattern(definition -> FactoryBlockPattern.start()
                    .aisle("CCCCCCC", "XXXFXXX", "XXXFXXX", "XXXFXXX", "XXXFXXX", "XXXFXXX", "XXXFXXX", "XXXFXXX", "   F   ")
                    .aisle("CDDDDDC", "X#####X", "X#####X", "X#####X", "X#####X", "X#####X", "X#####X", "X#####X", " XXFXX ")
                    .aisle("CDDDDDC", "X#####X", "X#####X", "X#####X", "X#####X", "X#####X", "X#####X", "X#####X", " XXFXX ")
                    .aisle("CDDDDDC", "F#####F", "F#####F", "F#####F", "F#####F", "F#####F", "F#####F", "F#####F", "FFFFFFF")
                    .aisle("CDDDDDC", "X#####X", "X#####X", "X#####X", "X#####X", "X#####X", "X#####X", "X#####X", " XXFXX ")
                    .aisle("CDDDDDC", "X#####X", "X#####X", "X#####X", "X#####X", "X#####X", "X#####X", "X#####X", " XXFXX ")
                    .aisle("CCCSCCC", "XXXFXXX", "XXXFXXX", "XXXFXXX", "XXXFXXX", "XXXFXXX", "XXXFXXX", "XXXFXXX", "   F   ")
                    .where('S', controller(blocks(definition.get())))
                    .where('X', blocks(GLASS))
                    .where('F', frames(HSLASteel))
                    .where('D', blocks(Blocks.DIRT, Blocks.GRASS)
                            .or(blocks(ForestryGreenhouseMachine.GRASSES)))
                    .where('C', blocks(CASING_STAINLESS_CLEAN.get()).setMinGlobalLimited(10)
                            .or(abilities(PartAbility.IMPORT_FLUIDS))
                            .or(abilities(PartAbility.IMPORT_ITEMS))
                            .or(abilities(PartAbility.INPUT_ENERGY))
                            .or(abilities(PartAbility.EXPORT_ITEMS))
                            .or(abilities(PartAbility.MAINTENANCE)))
                    .where('#', air())
                    .where(' ', any())
                    .build())
            .partSorter(Comparator.comparingInt(a -> a.self().getPos().getY()))
            .workableCasingRenderer(GTCEu.id("block/casings/solid/machine_casing_clean_stainless_steel"),
                    Epimorphism.id("block/multiblock/forestry_greenhouse"), false)
            .register();
    public final static MultiblockMachineDefinition ALGAE_FARM = EP_REGISTRATE.multiblock("algae_farm", AlgaeFarmMachine::new)
            .langValue("Algae Farm")
            .tooltips(
            )
            .rotationState(RotationState.NON_Y_AXIS)
            .recipeType(DUMMY_RECIPES)
            .recipeModifier(GTRecipeModifiers.ELECTRIC_OVERCLOCK.apply(OverclockingLogic.NON_PERFECT_OVERCLOCK))
            .appearanceBlock(FARM_CASING)
            .pattern(definition -> FactoryMOPattern.start()
                    .aisle("XXXXXXXXX", "CCCCCCCCC", "CCCCCCCCC")
                    .aisle("XMMMMMMMX", "C#######C", "C#######C")
                    .aisle("XMMMMMMMX", "C#######C", "C#######C")
                    .aisle("XMMMMMMMX", "C#######C", "C#######C")
                    .aisle("XMMMMMMMX", "C#######C", "C#######C")
                    .aisle("XMMMMMMMX", "C#######C", "C#######C")
                    .aisle("XMMMMMMMX", "C#######C", "C#######C")
                    .aisle("XMMMMMMMX", "C#######C", "C#######C")
                    .aisle("XXXXSXXXX", "CCCCCCCCC", "CCCCCCCCC")
                    .where('S', controller(blocks(definition.getBlock())))
                    .where('X', blocks(FARM_CASING.get()).setMinGlobalLimited(18)
                            .or(abilities(PartAbility.EXPORT_ITEMS).setMinGlobalLimited(1))
                            .or(abilities(PartAbility.IMPORT_FLUIDS).setMaxGlobalLimited(1)))
                    .where('C', blocks(FARM_CASING.get()))
                    .where('M', machineCasingBlock())
                    .where('#', any())
                    .build()
            )
            .shapeInfos(definition -> {
                List<MultiblockShapeInfo> shapeInfos = new ArrayList<>();
                shapeInfos.addAll(StructureUtil.getMatchingShapes((MOBlockPattern) definition.getPatternFactory().get(), ALL_MACHINE_CASINGS.size()));
                return shapeInfos;
            })
            .partSorter(Comparator.comparingInt(a -> a.self().getPos().getY()))
            .workableCasingRenderer(Epimorphism.id("block/casings/solid/farm_casing"),
                    Epimorphism.id("block/multiblock/algae_farm"), false)
            .register();
    public final static MultiblockMachineDefinition INDUSTRIAL_FISHING_POND = EP_REGISTRATE.multiblock("industrial_fishing_pond", IndustrialFishingPondMachine::new)
            .langValue("Industrial Fishing Pond")
            .tooltips(
                    Component.translatable("block.epimorphism.industrial_fishing_pond.desc.0"),
                    Component.translatable("block.epimorphism.industrial_fishing_pond.desc.1"),
                    Component.translatable("block.epimorphism.industrial_fishing_pond.desc.2"),
                    Component.translatable("block.epimorphism.industrial_fishing_pond.desc.3"),
                    Component.translatable("block.epimorphism.industrial_fishing_pond.desc.4"),
                    Component.translatable("block.epimorphism.industrial_fishing_pond.desc.5")
            )
            .rotationState(RotationState.NON_Y_AXIS)
            .recipeType(DUMMY_RECIPES)
            .recipeModifier(GTRecipeModifiers.ELECTRIC_OVERCLOCK.apply(OverclockingLogic.NON_PERFECT_OVERCLOCK))
            .appearanceBlock(BREEDING_CASING)
            .pattern(definition -> FactoryBlockPattern.start()
                    .aisle("EEEEEEEEE", "XXXXXXXXX", "XXXXXXXXX")
                    .aisle("EXXXXXXXE", "X#######X", "X#######X")
                    .aisle("EXXXXXXXE", "X#######X", "X#######X")
                    .aisle("EXXXXXXXE", "X#######X", "X#######X")
                    .aisle("EXXXXXXXE", "X#######X", "X#######X")
                    .aisle("EXXXXXXXE", "X#######X", "X#######X")
                    .aisle("EXXXXXXXE", "X#######X", "X#######X")
                    .aisle("EXXXXXXXE", "X#######X", "X#######X")
                    .aisle("EEEEEEEEE", "XXXXSXXXX", "XXXXXXXXX")
                    .where('S', controller(blocks(definition.getBlock())))
                    .where('X', blocks(BREEDING_CASING.get()).setMinGlobalLimited(106)
                            .or(abilities(PartAbility.EXPORT_ITEMS).setMinGlobalLimited(1))
                            .or(abilities(PartAbility.IMPORT_FLUIDS).setMaxGlobalLimited(1))
                            .or(abilities(PartAbility.MAINTENANCE).setExactLimit(1)))
                    .where('E', blocks(BREEDING_CASING.get())
                            .or(abilities(PartAbility.INPUT_ENERGY).setMinGlobalLimited(1).setMaxGlobalLimited(3)))
                    .where('#', any())
                    .build())
            .partSorter(Comparator.comparingInt(a -> a.self().getPos().getY()))
            .workableCasingRenderer(Epimorphism.id("block/casings/solid/breeding_casing"),
                    Epimorphism.id("block/multiblock/industrial_fishing_pond"), false)
            .register();

    public static void init() {

    }
}
