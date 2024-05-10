package cn.gtcommunity.epimorphism.common.data.machine;

import cn.gtcommunity.epimorphism.Epimorphism;
import cn.gtcommunity.epimorphism.api.pattern.EPPredicates;
import cn.gtcommunity.epimorphism.api.pattern.EnhanceBlockPattern;
import cn.gtcommunity.epimorphism.api.pattern.FactoryEnhancePattern;
import cn.gtcommunity.epimorphism.api.pattern.utils.StructureUtil;
import cn.gtcommunity.epimorphism.common.machine.multiblock.electric.agriculture.ForestryGreenhouseMachine;
import cn.gtcommunity.epimorphism.common.machine.multiblock.electric.agriculture.IndustrialFishingPondMachine;
import cn.gtcommunity.epimorphism.common.machine.multiblock.electric.agriculture.IndustrialGreenhouseMachine;
import cn.gtcommunity.epimorphism.common.machine.multiblock.noenergy.AlgaeFarmMachine;
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

import static cn.gtcommunity.epimorphism.api.pattern.EPPredicates.machineCasingBlock;
import static cn.gtcommunity.epimorphism.common.registry.EPRegistration.EP_REGISTRATE;
import static cn.gtcommunity.epimorphism.common.block.BlockMaps.ALL_MACHINE_CASINGS;
import static cn.gtcommunity.epimorphism.common.block.BlockMaps.SHAPE_GLASSES;
import static cn.gtcommunity.epimorphism.common.data.EPBlocks.*;
import static com.gregtechceu.gtceu.api.pattern.Predicates.*;
import static com.gregtechceu.gtceu.common.data.GTBlocks.CASING_LAMINATED_GLASS;
import static com.gregtechceu.gtceu.common.data.GTBlocks.CASING_STAINLESS_CLEAN;
import static com.gregtechceu.gtceu.common.data.GTMaterials.HSLASteel;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.DUMMY_RECIPES;
import static net.minecraft.world.level.block.Blocks.GLASS;

public class AgricultureMachines {
    public static final MultiblockMachineDefinition EXTREME_INDUSTRIAL_GREENHOUSE = EP_REGISTRATE.multiblock("extreme_industrial_greenhouse", IndustrialGreenhouseMachine::new)
            .langValue("Extreme Industrial Greenhouse")
            .tooltips(Component.translatable("block.epimorphism.extreme_industrial_greenhouse.desc.0"))
            .rotationState(RotationState.NON_Y_AXIS)
            .recipeType(DUMMY_RECIPES)
            .appearanceBlock(CASING_STAINLESS_CLEAN)
            .pattern(definition -> FactoryEnhancePattern.start()
                    .aisle("AAAAA", "AAAAA", "CCCCC", "CCCCC", "AAAAA", "AAAAA")
                    .aisle("AGGGA", "ADDDA", "C   C", "C   C", "AEEEA", "AAAAA")
                    .aisle("AGGGA", "ADFDA", "C   C", "C   C", "AEEEA", "AAAAA")
                    .aisle("AGGGA", "ADDDA", "C   C", "C   C", "AEEEA", "AAAAA")
                    .aisle("AABAA", "AAAAA", "CCCCC", "CCCCC", "AAAAA", "AAAAA")
                    .where('B', controller(blocks(definition.getBlock())))
                    .where('A', blocks(CASING_STAINLESS_CLEAN.get()).setMinGlobalLimited(61)
                            .or(abilities(PartAbility.IMPORT_FLUIDS))
                            .or(abilities(PartAbility.IMPORT_ITEMS))
                            .or(abilities(PartAbility.INPUT_ENERGY))
                            .or(abilities(PartAbility.EXPORT_ITEMS))
                            .or(abilities(PartAbility.MAINTENANCE)))
                    .where('C', EPPredicates.glass())
                    .where('D', blocks(FERTILIZED_FARMLAND.get()))
                    .where('E', blocks(CASING_LAMINATED_GLASS.get()))
                    .where('F', blocks(Blocks.WATER))
                    .where('G', blocks(CASING_STAINLESS_CLEAN.get()))
                    .build()
            )
            .shapeInfos(definition -> {
                List<MultiblockShapeInfo> shapeInfos = new ArrayList<>();
//                MultiblockShapeInfo.ShapeInfoBuilder builder = MultiblockShapeInfo.builder()
//                        .aisle("AIBGH", "AAAAA", "CCCCC", "CCCCC", "AAAAA", "AAAAA")
//                        .aisle("AAAAA", "ADDDA", "C   C", "C   C", "AEEEA", "AAAAA")
//                        .aisle("AAAAA", "ADFDA", "C   C", "C   C", "AEEEA", "AAAAA")
//                        .aisle("AAAAA", "ADDDA", "C   C", "C   C", "AEEEA", "AAAAA")
//                        .aisle("AAJKA", "AAAAA", "CCCCC", "CCCCC", "AAAAA", "AAAAA")
//                        .where('B', definition, Direction.NORTH)
//                        .where('A', CASING_STAINLESS_CLEAN.get())
//                        .where('D', FERTILIZED_FARMLAND.get())
//                        .where('E', CASING_LAMINATED_GLASS.get())
//                        .where('F', Blocks.WATER.defaultBlockState())
//                        .where('G', GTMachines.FLUID_IMPORT_HATCH[ULV], Direction.NORTH)
//                        .where('H', GTMachines.ITEM_IMPORT_BUS[ULV], Direction.NORTH)
//                        .where('I', GTMachines.ITEM_EXPORT_BUS[ULV], Direction.NORTH)
//                        .where('J', GTMachines.MAINTENANCE_HATCH, Direction.SOUTH)
//                        .where('K', GTMachines.ENERGY_INPUT_HATCH[IV], Direction.SOUTH);
//                BlockMaps.SHAPE_GLASSES.entrySet().stream()
//                        .sorted(Comparator.comparingInt(entry -> entry.getKey().tier()))
//                        .map(Map.Entry::getValue)
//                        .forEach(blockSupplier -> shapeInfo.add(builder.where('C', blockSupplier.get()).build()));
                shapeInfos.addAll(StructureUtil.getMatchingShapes((EnhanceBlockPattern) definition.getPatternFactory().get(), SHAPE_GLASSES.size()));
                return shapeInfos;
            })
            .partSorter(Comparator.comparingInt(a -> a.self().getPos().getY()))
            .workableCasingRenderer(GTCEu.id("block/casings/solid/machine_casing_clean_stainless_steel"),
                    Epimorphism.id("block/multiblock/extreme_industrial_greenhouse"), false)
            .register();
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
            .pattern(definition -> FactoryEnhancePattern.start()
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
//                MultiblockShapeInfo.ShapeInfoBuilder builder = MultiblockShapeInfo.builder()
//                        .aisle("CCCISECCC", "CCCCCCCCC", "CCCCCCCCC")
//                        .aisle("CMMMMMMMC", "C#######C", "C#######C")
//                        .aisle("CMMMMMMMC", "C#######C", "C#######C")
//                        .aisle("CMMMMMMMC", "C#######C", "C#######C")
//                        .aisle("CMMMMMMMC", "C#######C", "C#######C")
//                        .aisle("CMMMMMMMC", "C#######C", "C#######C")
//                        .aisle("CMMMMMMMC", "C#######C", "C#######C")
//                        .aisle("CMMMMMMMC", "C#######C", "C#######C")
//                        .aisle("CCCCCCCCC", "CCCCCCCCC", "CCCCCCCCC")
//                        .where('S', definition, Direction.NORTH)
//                        .where('C', FARM_CASING.getDefaultState())
//                        .where('I', FLUID_IMPORT_HATCH[4], Direction.NORTH)
//                        .where('E', ITEM_EXPORT_BUS[4], Direction.NORTH)
//                        .where('#', AIR.defaultBlockState());
//                ALL_MACHINE_CASINGS.entrySet().stream()
//                        .sorted(Comparator.comparingInt(entry -> entry.getKey().tier()))
//                        .forEach(entry -> shapeInfo.add(builder.shallowCopy().where('M', entry.getValue().get()).build()));
                shapeInfos.addAll(StructureUtil.getMatchingShapes((EnhanceBlockPattern) definition.getPatternFactory().get(), ALL_MACHINE_CASINGS.size()));
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
