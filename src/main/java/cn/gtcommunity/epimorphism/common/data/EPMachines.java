package cn.gtcommunity.epimorphism.common.data;

import cn.gtcommunity.epimorphism.Epimorphism;
import cn.gtcommunity.epimorphism.api.machine.multiblock.*;
import cn.gtcommunity.epimorphism.api.pattern.EPPredicates;
import cn.gtcommunity.epimorphism.api.pattern.LayerShapeInfo;
import cn.gtcommunity.epimorphism.api.structure.utils.StructureUtil;
import cn.gtcommunity.epimorphism.client.renderer.handler.machine.ChemicalPlantRenderer;
import cn.gtcommunity.epimorphism.client.renderer.handler.machine.IndustrialGreenhouseRenderer;
import cn.gtcommunity.epimorphism.common.block.BlockMaps;
import cn.gtcommunity.epimorphism.common.machine.multiblock.electric.*;
import cn.gtcommunity.epimorphism.common.machine.multiblock.part.*;
import cn.gtcommunity.epimorphism.common.machine.multiblock.storage.TFFTMachine;
import cn.gtcommunity.epimorphism.common.machine.multiblock.storage.YottaFluidTankMachine;
import cn.gtcommunity.epimorphism.common.machine.storage.InfinityCrateMachine;
import cn.gtcommunity.epimorphism.utils.EPUniverUtil;
import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.data.RotationState;
import com.gregtechceu.gtceu.api.data.chemical.ChemicalHelper;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.MachineDefinition;
import com.gregtechceu.gtceu.api.machine.MetaMachine;
import com.gregtechceu.gtceu.api.machine.MultiblockMachineDefinition;
import com.gregtechceu.gtceu.api.machine.multiblock.PartAbility;
import com.gregtechceu.gtceu.api.pattern.FactoryBlockPattern;
import com.gregtechceu.gtceu.api.pattern.MultiblockShapeInfo;
import com.gregtechceu.gtceu.api.pattern.Predicates;
import com.gregtechceu.gtceu.api.pattern.util.RelativeDirection;
import com.gregtechceu.gtceu.api.recipe.OverclockingLogic;
import com.gregtechceu.gtceu.api.registry.registrate.MachineBuilder;
import com.gregtechceu.gtceu.client.renderer.block.TextureOverrideRenderer;
import com.gregtechceu.gtceu.common.block.CoilBlock;
import com.gregtechceu.gtceu.common.data.*;
import com.gregtechceu.gtceu.config.ConfigHolder;
import com.gregtechceu.gtceu.utils.GTUtil;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiFunction;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import static cn.gtcommunity.epimorphism.api.registry.EPRegistries.*;
import static com.gregtechceu.gtceu.api.GTValues.VNF;
import static com.gregtechceu.gtceu.api.pattern.Predicates.*;
import static com.gregtechceu.gtceu.common.data.GTBlocks.ALL_COILS;
import static com.gregtechceu.gtceu.common.data.GTMachines.*;

public class EPMachines {
    public static final int[] NO_HIGH_TIERS = GTValues.tiersBetween(1, 8);
    static {
        EP_REGISTRATE.creativeModeTab(() -> EPCreativeModeTabs.EP_BLOCK);
    }

    // Multiblocks
    public final static MultiblockMachineDefinition YOTTA_FLUID_TANK = EP_REGISTRATE.multiblock("yotta_fluid_tank", YottaFluidTankMachine::new)
            .langValue("Yotta Fluid Tank")
            .tooltips(
                    Component.translatable("block.epimorphism.yotta_fluid_tank.desc.0"),
                    Component.translatable("block.epimorphism.yotta_fluid_tank.desc.1")
            )
            .rotationState(RotationState.NON_Y_AXIS)
            .recipeType(GTRecipeTypes.DUMMY_RECIPES)
            .appearanceBlock(EPBlocks.YOTTA_FLUID_TANK_CASING)
            .pattern(definition -> FactoryBlockPattern.start(RelativeDirection.RIGHT, RelativeDirection.BACK, RelativeDirection.UP)
                    .aisle("     ", " FFF ", " FFF ", " FFF ", "     ")
                    .aisle("AABAA", "AAAAA", "AAAAA", "AAAAA", "AAAAA")
                    .aisle("CCCCC", "CEEEC", "CEEEC", "CEEEC", "CCCCC").setRepeatable(1, 15)
                    .aisle("AAAAA", "AGGGA", "AGGGA", "AGGGA", "AAAAA")
                    .aisle("DDDDD", "D   D", "D   D", "D   D", "DDDDD")
                    .where('B', controller(blocks(definition.getBlock())))
                    .where('A', blocks(EPBlocks.YOTTA_FLUID_TANK_CASING.get()))
                    .where('C', EPPredicates.glass())
                    .where('D', frames(GTMaterials.Steel))
                    .where('E', EPPredicates.fluidTankCell())
                    .where('F', blocks(EPBlocks.YOTTA_FLUID_TANK_CASING.get())
                            .or(abilities(PartAbility.EXPORT_FLUIDS)))
                    .where('G', blocks(EPBlocks.YOTTA_FLUID_TANK_CASING.get())
                            .or(abilities(PartAbility.IMPORT_FLUIDS)))
                    .build())
            .shapeInfos(definition -> {
                List<MultiblockShapeInfo> shapeInfo = new ArrayList<>();
                MultiblockShapeInfo.ShapeInfoBuilder builder = LayerShapeInfo.builder()
                        .aisle("     ", " FFF ", " FFF ", " FFF ", "     ")
                        .aisle("AABAA", "AAAAA", "AAAAA", "AAAAA", "AAAAA")
                        .aisle("CCCCC", "CEEEC", "CEEEC", "CEEEC", "CCCCC")
                        .aisle("CCCCC", "CEEEC", "CEEEC", "CEEEC", "CCCCC")
                        .aisle("CCCCC", "CEEEC", "CEEEC", "CEEEC", "CCCCC")
                        .aisle("CCCCC", "CEEEC", "CEEEC", "CEEEC", "CCCCC")
                        .aisle("CCCCC", "CEEEC", "CEEEC", "CEEEC", "CCCCC")
                        .where('B', definition, Direction.NORTH)
                        .where('A', EPBlocks.YOTTA_FLUID_TANK_CASING.get())
                        .where('D', ChemicalHelper.getBlock(TagPrefix.frameGt, GTMaterials.Steel))
                        .where('F', GTMachines.FLUID_EXPORT_HATCH[GTValues.ULV], Direction.DOWN)
                        .where('G', GTMachines.FLUID_IMPORT_HATCH[GTValues.ULV], Direction.UP)
                        .where(' ', Blocks.AIR.defaultBlockState());
                var fluidCells = BlockMaps.ALL_FLUID_CELLS.entrySet().stream()
                        .sorted(Comparator.comparingInt(entry -> entry.getKey().tier()))
                        .map(Map.Entry::getValue)
                        .toList();
                var glass = BlockMaps.ALL_GLASSES.entrySet().stream()
                        .collect(Collectors.toMap(entry -> entry.getKey().tier(), Map.Entry::getValue, (a, b) -> a));
                TreeMap<Integer, Supplier<Block>> glasses = new TreeMap<>(glass);
                for (int i = 0; i < fluidCells.size(); i++) {
                    var info = builder
                            .aisle("CCCCC", "CEEEC", "CEEEC", "CEEEC", "CCCCC")
                            .where('C', glasses.ceilingEntry( i + 3).getValue())
                            .where('E', fluidCells.get(i))
                            .shallowCopy()
                            .aisle("AAAAA", "AGGGA", "AGGGA", "AGGGA", "AAAAA")
                            .aisle("DDDDD", "D   D", "D   D", "D   D", "DDDDD").build();
                    shapeInfo.add(info);
                }
                return shapeInfo;
            })
            .partSorter(Comparator.comparingInt(a -> a.self().getPos().getY()))
            .sidedWorkableCasingRenderer("block/casings/yotta_fluid_tank_casing",
                    Epimorphism.id("block/multiblock/yotta_fluid_tank"), false)
            .register();

    public final static MultiblockMachineDefinition TFFT = EP_REGISTRATE.multiblock("tfft", TFFTMachine::new)
            .langValue("T.F.F.T.")
            .tooltips(Component.translatable("block.epimorphism.tfft.desc.0"))
            .rotationState(RotationState.NON_Y_AXIS)
            .recipeType(GTRecipeTypes.DUMMY_RECIPES)
            .appearanceBlock(EPBlocks.TFFT_CASING)
            .pattern(definition -> FactoryBlockPattern.start(RelativeDirection.RIGHT, RelativeDirection.BACK, RelativeDirection.UP)
                    .aisle("AADAA", "AAAAA", "AAAAA", "AAAAA", "AAAAA")
                    .aisle("BBBBB", "BCCCB", "BCCCB", "BCCCB", "BBBBB").setRepeatable(1, 15)
                    .aisle("AAAAA", "AAAAA", "AAAAA", "AAAAA", "AAAAA")
                    .where('D', controller(blocks(definition.getBlock())))
                    .where('A', blocks(EPBlocks.TFFT_CASING.get())
                            .or(abilities(PartAbility.IMPORT_FLUIDS).setMinGlobalLimited(1).setMaxGlobalLimited(9))
                            .or(abilities(PartAbility.EXPORT_FLUIDS).setMinGlobalLimited(1).setMaxGlobalLimited(9))
                            .or(abilities(PartAbility.INPUT_ENERGY).setMinGlobalLimited(1).setMaxGlobalLimited(3))
                            .or(abilities(PartAbility.MAINTENANCE).setExactLimit(1)))
                    .where('B', blocks(GTBlocks.CASING_LAMINATED_GLASS.get()))
                    .where('C', EPPredicates.storageFieldBlock())
                    .build())
            .shapeInfos(definition -> {
                List<MultiblockShapeInfo> shapeInfo = new ArrayList<>();
                MultiblockShapeInfo.ShapeInfoBuilder builder = LayerShapeInfo.builder()
                        .aisle("AFDEA", "AAAAA", "AAAAA", "AAAAA", "AAGHA")
                        .aisle("BBBBB", "BCCCB", "BCCCB", "BCCCB", "BBBBB")
                        .aisle("BBBBB", "BCCCB", "BCCCB", "BCCCB", "BBBBB")
                        .aisle("BBBBB", "BCCCB", "BCCCB", "BCCCB", "BBBBB")
                        .aisle("BBBBB", "BCCCB", "BCCCB", "BCCCB", "BBBBB")
                        .aisle("BBBBB", "BCCCB", "BCCCB", "BCCCB", "BBBBB")
                        .where('D', definition, Direction.NORTH)
                        .where('A', EPBlocks.TFFT_CASING.get())
                        .where('B', GTBlocks.CASING_LAMINATED_GLASS.get())
                        .where('E', GTMachines.FLUID_EXPORT_HATCH[GTValues.ULV], Direction.NORTH)
                        .where('F', GTMachines.FLUID_IMPORT_HATCH[GTValues.ULV], Direction.NORTH)
                        .where('G', GTMachines.ENERGY_INPUT_HATCH[GTValues.EV], Direction.SOUTH)
                        .where('H', GTMachines.MAINTENANCE_HATCH, Direction.SOUTH)
                        .where(' ', Blocks.AIR.defaultBlockState());
                var fieldBlocks = BlockMaps.ALL_FIELD_BLOCKS.entrySet().stream()
                        .sorted(Comparator.comparingInt(entry -> entry.getKey().tier()))
                        .map(Map.Entry::getValue)
                        .toList();

                for (Supplier<Block> fieldBlock : fieldBlocks) {
                    var info = builder
                            .aisle("BBBBB", "BCCCB", "BCCCB", "BCCCB", "BBBBB")
                            .where('C', fieldBlock)
                            .shallowCopy()
                            .aisle("AAAAA", "AAAAA", "AAAAA", "AAAAA", "AAAAA").build();
                    shapeInfo.add(info);
                }
                return shapeInfo;
            })
            .partSorter(Comparator.comparingInt(a -> a.self().getPos().getY()))
            .workableCasingRenderer(Epimorphism.id("block/casings/solid/tfft_casing"),
                    Epimorphism.id("block/multiblock/tfft"), false)
            .register();

    public final static MultiblockMachineDefinition NEUTRON_ACTIVATOR = EP_REGISTRATE.multiblock("neutron_activator", NeutronActivatorMachine::new)
            .langValue("Neutron Activator")
            .tooltips(
                    Component.translatable("block.epimorphism.neutron_activator.desc.0"),
                    Component.translatable("block.epimorphism.neutron_activator.desc.1"),
                    Component.translatable("block.epimorphism.neutron_activator.desc.2"),
                    Component.translatable("block.epimorphism.neutron_activator.desc.3"),
                    Component.translatable("block.epimorphism.neutron_activator.desc.4")

            )
            .rotationState(RotationState.NON_Y_AXIS)
            .recipeType(EPRecipeTypes.NEUTRON_ACTIVATOR_RECIPES)
            .appearanceBlock(GTBlocks.CASING_STAINLESS_CLEAN)
            .pattern(definition -> FactoryBlockPattern.start(RelativeDirection.RIGHT, RelativeDirection.BACK, RelativeDirection.UP)
                    .aisle("AAGAA", "ADDDA", "ADDDA", "ADDDA", "AAAAA")
                    .aisle("B   B", " EEE ", " EFE ", " EEE ", "B   B").setRepeatable(4, 40)
                    .aisle("CCCCC", "CDDDC", "CDDDC", "CDDDC", "CCCCC")
                    .where('G', controller(blocks(definition.getBlock())))
                    .where('A', blocks(GTBlocks.CASING_STAINLESS_CLEAN.get())
                            .or(abilities(PartAbility.EXPORT_FLUIDS))
                            .or(abilities(PartAbility.EXPORT_ITEMS))
                            .or(abilities(EPPartAbility.NEUTRON_SENSOR))
                            .or(abilities(EPPartAbility.NEUTRON_ACCELERATOR).setMinGlobalLimited(1).setPreviewCount(1))
                            .or(abilities(PartAbility.MAINTENANCE).setExactLimit(1).setPreviewCount(1)))
                    .where('B', frames(GTMaterials.Steel))
                    .where('C', blocks(GTBlocks.CASING_STAINLESS_CLEAN.get())
                            .or(abilities(PartAbility.IMPORT_FLUIDS))
                            .or(abilities(PartAbility.IMPORT_ITEMS)))
                    .where('D', blocks(EPBlocks.PROCESS_MACHINE_CASING.get()))
                    .where('E', blocks(GTBlocks.CASING_LAMINATED_GLASS.get()))
                    .where('F', EPPredicates.countBlock("SpeedPipe", EPBlocks.SPEEDING_PIPE.get()))
                    .build()
            )
            .partSorter(Comparator.comparingInt(a -> a.self().getPos().getY()))
            .workableCasingRenderer(GTCEu.id("block/casings/solid/machine_casing_clean_stainless_steel"),
                    Epimorphism.id("block/multiblock/neutron_activator"), false)
            .register();

    public static final MultiblockMachineDefinition EXTREME_INDUSTRIAL_GREENHOUSE = EP_REGISTRATE.multiblock("extreme_industrial_greenhouse", IndustrialGreenhouseMachine::new)
            .langValue("Extreme Industrial Greenhouse")
            .tooltips(Component.translatable("block.epimorphism.extreme_industrial_greenhouse.desc.0"))
            .rotationState(RotationState.NON_Y_AXIS)
            .recipeType(GTRecipeTypes.DUMMY_RECIPES)
            .appearanceBlock(GTBlocks.CASING_STAINLESS_CLEAN)
            .pattern(definition -> FactoryBlockPattern.start()
                    .aisle("AAAAA", "AAAAA", "CCCCC", "CCCCC", "AAAAA", "AAAAA")
                    .aisle("AGGGA", "ADDDA", "C   C", "C   C", "AEEEA", "AAAAA")
                    .aisle("AGGGA", "ADFDA", "C   C", "C   C", "AEEEA", "AAAAA")
                    .aisle("AGGGA", "ADDDA", "C   C", "C   C", "AEEEA", "AAAAA")
                    .aisle("AABAA", "AAAAA", "CCCCC", "CCCCC", "AAAAA", "AAAAA")
                    .where('B', controller(blocks(definition.getBlock())))
                    .where('A', blocks(GTBlocks.CASING_STAINLESS_CLEAN.get()).setMinGlobalLimited(61)
                            .or(abilities(PartAbility.IMPORT_FLUIDS))
                            .or(abilities(PartAbility.IMPORT_ITEMS))
                            .or(abilities(PartAbility.INPUT_ENERGY))
                            .or(abilities(PartAbility.EXPORT_ITEMS))
                            .or(abilities(PartAbility.MAINTENANCE)))
                    .where('C', EPPredicates.glass())
                    .where('D', blocks(EPBlocks.FERTILIZED_FARMLAND.get()))
                    .where('E', blocks(GTBlocks.CASING_LAMINATED_GLASS.get()))
                    .where('F', blocks(Blocks.WATER))
                    .where('G', blocks(GTBlocks.CASING_STAINLESS_CLEAN.get()))
                    .build()
            )
            .shapeInfos(definition -> {
                List<MultiblockShapeInfo> shapeInfo = new ArrayList<>();
                MultiblockShapeInfo.ShapeInfoBuilder builder = MultiblockShapeInfo.builder()
                        .aisle("AIBGH", "AAAAA", "CCCCC", "CCCCC", "AAAAA", "AAAAA")
                        .aisle("AAAAA", "ADDDA", "C   C", "C   C", "AEEEA", "AAAAA")
                        .aisle("AAAAA", "ADFDA", "C   C", "C   C", "AEEEA", "AAAAA")
                        .aisle("AAAAA", "ADDDA", "C   C", "C   C", "AEEEA", "AAAAA")
                        .aisle("AAJKA", "AAAAA", "CCCCC", "CCCCC", "AAAAA", "AAAAA")
                        .where('B', definition, Direction.NORTH)
                        .where('A', GTBlocks.CASING_STAINLESS_CLEAN.get())
                        .where('D', EPBlocks.FERTILIZED_FARMLAND.get())
                        .where('E', GTBlocks.CASING_LAMINATED_GLASS.get())
                        .where('F', Blocks.WATER.defaultBlockState())
                        .where('G', GTMachines.FLUID_IMPORT_HATCH[GTValues.ULV], Direction.NORTH)
                        .where('H', GTMachines.ITEM_IMPORT_BUS[GTValues.ULV], Direction.NORTH)
                        .where('I', GTMachines.ITEM_EXPORT_BUS[GTValues.ULV], Direction.NORTH)
                        .where('J', GTMachines.MAINTENANCE_HATCH, Direction.SOUTH)
                        .where('K', GTMachines.ENERGY_INPUT_HATCH[GTValues.IV], Direction.SOUTH);
                BlockMaps.SHAPE_GLASSES.entrySet().stream()
                        .sorted(Comparator.comparingInt(entry -> entry.getKey().tier()))
                        .map(Map.Entry::getValue)
                        .forEach(blockSupplier -> shapeInfo.add(builder.where('C', blockSupplier.get()).build()));

                return shapeInfo;
            })
            .partSorter(Comparator.comparingInt(a -> a.self().getPos().getY()))
            .renderer(() -> new IndustrialGreenhouseRenderer(GTCEu.id("block/casings/solid/machine_casing_clean_stainless_steel"),
                    Epimorphism.id("block/multiblock/extreme_industrial_greenhouse")))
//            .workableCasingRenderer(GTCEu.id("block/casings/solid/machine_casing_clean_stainless_steel"),
//                    Epimorphism.id("block/multiblock/extreme_industrial_greenhouse"), false)
            .hasTESR(true)
            .register();

    public final static MultiblockMachineDefinition BACTERIAL_CULTURE_TANK = EP_REGISTRATE.multiblock("bacterial_culture_tank", BacterialCultureTankMachine::new)
            .langValue("Bacterial Culture Tank")
            .tooltips(Component.translatable("block.epimorphism.bacterial_culture_tank.desc.0"))
            .rotationState(RotationState.ALL)
            .recipeType(GTRecipeTypes.DUMMY_RECIPES)
            .appearanceBlock(GTBlocks.CASING_STAINLESS_CLEAN)
            .pattern(definition -> FactoryBlockPattern.start()
                    .aisle("AAAAA", "CCCCC", "CCCCC", "AAAAA")
                    .aisle("AAAAA", "C   C", "C   C", "AAAAA")
                    .aisle("AAAAA", "C   C", "C   C", "AAAAA")
                    .aisle("AAAAA", "C   C", "C   C", "AAAAA")
                    .aisle("AABAA", "CCCCC", "CCCCC", "AAAAA")
                    .where('B', controller(blocks(definition.getBlock())))
                    .where('A', blocks(GTBlocks.CASING_STAINLESS_CLEAN.get()).setMinGlobalLimited(19)
                            .or(abilities(PartAbility.IMPORT_FLUIDS).setMinGlobalLimited(1))
                            .or(abilities(PartAbility.EXPORT_FLUIDS).setMinGlobalLimited(1))
                            .or(abilities(PartAbility.IMPORT_ITEMS).setMinGlobalLimited(1))
                            .or(abilities(PartAbility.INPUT_ENERGY).setMinGlobalLimited(1))
                            .or(abilities(EPPartAbility.RADIATION).setExactLimit(1))
                            .or(abilities(PartAbility.MAINTENANCE).setExactLimit(1)))
                    .where('C', EPPredicates.glass())
                    .build()
            )
            .shapeInfos(definition -> {
                List<MultiblockShapeInfo> shapeInfos = new ArrayList<>();
                MultiblockShapeInfo.ShapeInfoBuilder builder = MultiblockShapeInfo.builder()
                        .aisle("AHIAA", "CCCCC", "CCCCC", "AAAAA")
                        .aisle("AAAAA", "C   C", "C   C", "AAAAA")
                        .aisle("AAAAA", "C   C", "C   C", "AAAAA")
                        .aisle("AAAAA", "C   C", "C   C", "AAAAA")
                        .aisle("DEBFG", "CCCCC", "CCCCC", "AAJAA")
                        .where('B', definition, Direction.SOUTH)
                        .where('A', GTBlocks.CASING_STAINLESS_CLEAN.get())
                        .where('D', GTMachines.FLUID_IMPORT_HATCH[4], Direction.SOUTH)
                        .where('E', GTMachines.ITEM_IMPORT_BUS[4], Direction.SOUTH)
                        .where('F', GTMachines.FLUID_EXPORT_HATCH[4], Direction.SOUTH)
                        .where('G', GTMachines.FLUID_EXPORT_HATCH[4], Direction.SOUTH)
                        .where('H', GTMachines.MAINTENANCE_HATCH, Direction.NORTH)
                        .where('I', GTMachines.ENERGY_INPUT_HATCH[5], Direction.NORTH)
                        .where('J', EPMachines.RADIATION_HATCH[3], Direction.SOUTH);
                BlockMaps.SHAPE_GLASSES.entrySet().stream()
                        .sorted(Comparator.comparingInt(entry -> entry.getKey().tier()))
                        .map(Map.Entry::getValue)
                        .forEach(blockSupplier -> shapeInfos.add(builder.where('C', blockSupplier.get()).build()));
                return shapeInfos;
            })
            .partSorter(Comparator.comparingInt(a -> a.self().getPos().getY()))
            .workableCasingRenderer(GTCEu.id("block/casings/solid/machine_casing_clean_stainless_steel"),
                    Epimorphism.id("block/multiblock/bacterial_culture_tank"), false)
            .register();

    public final static MultiblockMachineDefinition CHEMICAL_PLANT = EP_REGISTRATE.multiblock("chemical_plant", ChemicalPlantMachine::new)
            .langValue("Chemical Plant")
            .tooltips(Component.translatable("block.epimorphism.chemical_plant.desc.0"))
            .rotationState(RotationState.ALL)
            .recipeTypes(EPRecipeTypes.CHEMICAL_PLANT_RECIPES, GTRecipeTypes.LARGE_CHEMICAL_RECIPES)
            .appearanceBlock(GTBlocks.CASING_BRONZE_BRICKS)
            .pattern(definition -> FactoryBlockPattern.start()
                    .aisle("EEEEEEE", "C#####C", "C#####C", "C#####C", "C#####C", "C#####C", "CCCCCCC")
                    .aisle("EMMMMME", "#MMMMM#", "#######", "#######", "#######", "#MMMMM#", "CCCCCCC")
                    .aisle("EMMMMME", "#MXXXM#", "##TTT##", "##XXX##", "##TTT##", "#MXXXM#", "CCCCCCC")
                    .aisle("EMMMMME", "#MXAXM#", "##TAT##", "##XAX##", "##TAT##", "#MXAXM#", "CCCCCCC")
                    .aisle("EMMMMME", "#MXXXM#", "##TTT##", "##XXX##", "##TTT##", "#MXXXM#", "CCCCCCC")
                    .aisle("EMMMMME", "#MMMMM#", "#######", "#######", "#######", "#MMMMM#", "CCCCCCC")
                    .aisle("EEESEEE", "C#####C", "C#####C", "C#####C", "C#####C", "C#####C", "CCCCCCC")
                    .where('S', controller(blocks(definition.getBlock())))
                    .where('E', EPPredicates.CPCasingBlock()
                            .or(abilities(PartAbility.MAINTENANCE).setExactLimit(1))
                            .or(abilities(PartAbility.EXPORT_FLUIDS).setMinGlobalLimited(1))
                            .or(abilities(PartAbility.EXPORT_ITEMS).setMinGlobalLimited(1))
                            .or(abilities(PartAbility.IMPORT_ITEMS).setMinGlobalLimited(1))
                            .or(abilities(PartAbility.IMPORT_FLUIDS).setMinGlobalLimited(1))
//                            .or(abilities(PartAbility.CATALYST_MULTIBLOCK_ABILITY).setMaxGlobalLimited(2))
                            .or(abilities(PartAbility.INPUT_ENERGY).setMinGlobalLimited(1).setMaxGlobalLimited(2)))
                    .where('C', EPPredicates.CPCasingBlock())
                    .where('X', heatingCoils())
                    .where('M', EPPredicates.CPMachineCasingBlock())
                    .where('T', EPPredicates.CPPipeBlock())
                    .where('#', any())
                    .where('A',air())
                    .build()
            )
            .shapeInfos(definition -> {
                List<MultiblockShapeInfo> shapeInfo = new ArrayList<>();
                MultiblockShapeInfo.ShapeInfoBuilder builder = MultiblockShapeInfo.builder()
                        .aisle("CCCHJCC", "C#####C", "C#####C", "C#####C", "C#####C", "C#####C", "CCCCCCC")
                        .aisle("CMMMMMC", "#MMMMM#", "#######", "#######", "#######", "#MMMMM#", "CCCCCCC")
                        .aisle("CMMMMMC", "#MXXXM#", "##TTT##", "##XXX##", "##TTT##", "#MXXXM#", "CCCCCCC")
                        .aisle("CMMMMMC", "#MX#XM#", "##T#T##", "##X#X##", "##T#T##", "#MX#XM#", "CCCCCCC")
                        .aisle("CMMMMMC", "#MXXXM#", "##TTT##", "##XXX##", "##TTT##", "#MXXXM#", "CCCCCCC")
                        .aisle("CMMMMMC", "#MMMMM#", "#######", "#######", "#######", "#MMMMM#", "CCCCCCC")
                        .aisle("CVNSKLZ", "C#####C", "C#####C", "C#####C", "C#####C", "C#####C", "CCCCCCC")
                        .where('S', definition, Direction.SOUTH)
                        .where('V', GTMachines.FLUID_IMPORT_HATCH[4], Direction.SOUTH)
                        .where('N', GTMachines.FLUID_EXPORT_HATCH[4], Direction.SOUTH)
                        .where('K', GTMachines.ITEM_IMPORT_BUS[4], Direction.SOUTH)
                        .where('L', GTMachines.ITEM_EXPORT_BUS[4], Direction.SOUTH)
                        .where('Z', /*GTMachines.MULTIPART_CATALYST_HATCH*/GTMachines.ITEM_EXPORT_BUS[4], Direction.SOUTH)
                        .where('H', GTMachines.ENERGY_INPUT_HATCH[5], Direction.NORTH)
                        .where('#', Blocks.AIR)
                        .where('J', GTMachines.MAINTENANCE_HATCH, Direction.NORTH);
                List<CoilBlock> listCoil = GTBlocks.ALL_COILS.entrySet().stream()
                        .sorted(Comparator.comparingInt(entry -> entry.getKey().getTier()))
                        .map(entry -> entry.getValue().get())
                        .toList();
                List<Block> listCasing = BlockMaps.ALL_CP_CASINGS.entrySet().stream()
                        .sorted(Comparator.comparingInt(entry -> entry.getKey().tier()))
                        .map(entry -> entry.getValue().get())
                        .toList();
                List<Block> listTube = BlockMaps.ALL_CP_TUBES.entrySet().stream()
                        .sorted(Comparator.comparingInt(entry -> entry.getKey().tier()))
                        .map(entry -> entry.getValue().get())
                        .toList();
                List<Block> listMachineCasing = BlockMaps.ALL_MACHINE_CASINGS.entrySet().stream()
                        .sorted(Comparator.comparingInt(entry -> entry.getKey().tier()))
                        .map(entry -> entry.getValue().get())
                        .toList();
                int maxLeng = StructureUtil.maxLength(new List[] {
                    listCoil,
                    listCasing,
                    listTube,
                    listMachineCasing
                });

                for (int i = 0; i < maxLeng; ++i) {
                    builder.where('X', EPUniverUtil.getOrLast(listCoil, i));
                    builder.where('C', EPUniverUtil.getOrLast(listCasing, i));
                    builder.where('T', EPUniverUtil.getOrLast(listTube, i));
                    builder.where('M', EPUniverUtil.getOrLast(listMachineCasing, i));
                    shapeInfo.add(builder.build());
                }
                return shapeInfo;
            })
            .partSorter(Comparator.comparingInt(a -> a.self().getPos().getY()))
            .renderer(() -> new ChemicalPlantRenderer(Epimorphism.id("block/multiblock/chemical_plant")))
            .register();


    public final static MultiblockMachineDefinition COMPONENT_ASSEMBLY_LINE = EP_REGISTRATE.multiblock("component_assembly_line", holder -> new TierCasingElectricMultiblockMachine(holder, "CACasing"))
            .langValue("Component Assembly Line")
            .tooltips(
                    Component.translatable("block.epimorphism.component_assembly_line.desc.0"),
                    Component.translatable("block.epimorphism.component_assembly_line.desc.1"),
                    Component.translatable("block.epimorphism.component_assembly_line.desc.2"),
                    Component.translatable("block.epimorphism.component_assembly_line.desc.3")
            )
            .rotationState(RotationState.ALL)
            .recipeType(EPRecipeTypes.COMPONENT_ASSEMBLY_LINE_RECIPES)
            .appearanceBlock(EPBlocks.IRIDIUM_CASING)
            .pattern(definition -> FactoryBlockPattern.start()
                    .aisle("HHHHHHHHH", "H  KKK  H", "H       H", "H       H", "H       H", "H       H", "HH     HH", " HHHHHHH ", "         ", "         ")
                    .aisle("MHHHHHHHM", "A       A", "A  HHH  A", "A       A", "A       A", "A       A", "H       H", "E       E", " ELHHHLE ", "         ")
                    .aisle("MHHHHHHHM", "A       A", "A  HHH  A", "A D   D A", "AC     CA", "AC     CA", "HC     CH", "E       E", " EL   LE ", "   HBH   ")
                    .aisle("MHHHHHHHM", "A  n n  A", "A  HHH  A", "A       A", "A       A", "A       A", "H       H", "E       E", " EL   LE ", "   HBH   ")
                    .aisle("MHHHHHHHM", "AG     GA", "AG HHH GA", "AG     GA", "AG     GA", "AG  C  GA", "HGG D GGH", "E GGDGG E", " EL   LE ", "   BBB   ")
                    .aisle("MHHHHHHHM", "A       A", "A  HHH  A", "A       A", "A       A", "A       A", "H       H", "E       E", " EL   LE ", "   HBH   ")
                    .aisle("MHHHHHHHM", "A       A", "A  HHH  A", "A D   D A", "AC     CA", "AC     CA", "HC     CH", "E       E", " EL   LE ", "   HBH   ")
                    .aisle("MHHHHHHHM", "A       A", "A  HHH  A", "A       A", "A       A", "A       A", "H       H", "E       E", " EL   LE ", "   HBH   ")
                    .aisle("MHHHHHHHM", "HG     GH", "HG HHH GH", "HG     GH", "HG     GH", "HG  C  GH", "HGG D GGH", "E GGDGG E", " EL   LE ", "   BBB   ")
                    .aisle("MHHHHHHHM", "A       A", "A  HHH  A", "A       A", "A       A", "A       A", "H       H", "E       E", " EL   LE ", "   HBH   ")
                    .aisle("MHHHHHHHM", "A       A", "A  HHH  A", "A D   D A", "AC     CA", "AC     CA", "HC     CH", "E       E", " EL   LE ", "   HBH   ")
                    .aisle("MHHHHHHHM", "A       A", "A  HHH  A", "A       A", "A       A", "A       A", "H       H", "E       E", " EL   LE ", "   HBH   ")
                    .aisle("MHHHHHHHM", "AG     GA", "AG HHH GA", "AG     GA", "AG     GA", "AG  C  GA", "HGG D GGH", "E GGDGG E", " EL   LE ", "   BBB   ")
                    .aisle("MHHHHHHHM", "A       A", "A  HHH  A", "A       A", "A       A", "A       A", "H       H", "E       E", " EL   LE ", "   HBH   ")
                    .aisle("MHHHHHHHM", "A       A", "A  HHH  A", "A D   D A", "AC     CA", "AC     CA", "HC     CH", "E       E", " EL   LE ", "   HBH   ")
                    .aisle("MHHHHHHHM", "A       A", "A  HHH  A", "A       A", "A       A", "A       A", "H       H", "E       E", " EL   LE ", "   HBH   ")
                    .aisle("MHHHHHHHM", "HG     GH", "HG HHH GH", "HG     GH", "HG     GH", "HG  C  GH", "HGG D GGH", "E GGDGG E", " EL   LE ", "   BBB   ")
                    .aisle("MHHHHHHHM", "A       A", "A  HHH  A", "A       A", "A       A", "A       A", "H       H", "E       E", " EL   LE ", "   HBH   ")
                    .aisle("MHHHHHHHM", "A       A", "A  HHH  A", "A D   D A", "AC     CA", "AC     CA", "HC     CH", "E       E", " EL   LE ", "   HBH   ")
                    .aisle("MHHHHHHHM", "A       A", "A  HHH  A", "A       A", "A       A", "A       A", "H       H", "E       E", " EL   LE ", "   HBH   ")
                    .aisle("MHHHHHHHM", "AG     GA", "AG HHH GA", "AG     GA", "AG     GA", "AG  C  GA", "HGG D GGH", "E GGDGG E", " EL   LE ", "   BBB   ")
                    .aisle("MHHHHHHHM", "A       A", "A  HHH  A", "A       A", "A       A", "A       A", "H       H", "E       E", " EL   LE ", "   HBH   ")
                    .aisle("MHHHHHHHM", "A       A", "A  HHH  A", "A D   D A", "AC     CA", "AC     CA", "HC     CH", "E       E", " EL   LE ", "   HBH   ")
                    .aisle("MHHHHHHHM", "A       A", "A  HHH  A", "A       A", "A       A", "A       A", "H       H", "E       E", " EL   LE ", "   HBH   ")
                    .aisle("MHHHHHHHM", "HG     GH", "HG HHH GH", "HG     GH", "HG     GH", "HG  C  GH", "HGG D GGH", "E GGDGG E", " EL   LE ", "   BBB   ")
                    .aisle("MHHHHHHHM", "A       A", "A  HHH  A", "A       A", "A       A", "A       A", "H       H", "E       E", " EL   LE ", "   HBH   ")
                    .aisle("MHHHHHHHM", "A       A", "A  HHH  A", "A D   D A", "AC     CA", "AC     CA", "HC     CH", "E       E", " EL   LE ", "   HBH   ")
                    .aisle("MHHHHHHHM", "A       A", "A  HHH  A", "A       A", "A       A", "A       A", "H       H", "E       E", " EL   LE ", "   HBH   ")
                    .aisle("MHHHHHHHM", "AG     GA", "AG HHH GA", "AG     GA", "AG     GA", "AG  C  GA", "HGG D GGH", "E GGDGG E", " EL   LE ", "   BBB   ")
                    .aisle("MHHHHHHHM", "A       A", "A  HHH  A", "A       A", "A       A", "A       A", "H       H", "E       E", " EL   LE ", "   HBH   ")
                    .aisle("MHHHHHHHM", "A       A", "A  HHH  A", "A D   D A", "AC     CA", "AC     CA", "HC     CH", "E       E", " EL   LE ", "   HBH   ")
                    .aisle("MHHHHHHHM", "A       A", "A  HHH  A", "A       A", "A       A", "A       A", "H       H", "E       E", " ELHHHLE ", "         ")
                    .aisle("HHHHHHHHH", "H  N N  H", "H  JJJ  H", "H  JJJ  H", "H       H", "H       H", "HH III HH", " HHI~IHH ", "   III   ", "         ")
                    .where('~', controller(blocks(definition.getBlock())))
                    .where('A', blocks(EPBlocks.OSMIR_BORON_SILICATE_GLASS.get()))
                    .where('H', blocks(EPBlocks.IRIDIUM_CASING.get()))
                    .where('C', blocks(GTBlocks.CASING_ASSEMBLY_LINE.get()))
                    .where('D', frames(EPMaterials.MARM200Steel))
                    .where('G', blocks(EPBlocks.CASING_POLYBENZIMIDAZOLE_PIPE.get()))
                    .where('E', blocks(EPBlocks.ADVANCED_FILTER_CASING.get()))
                    .where('B', EPPredicates.componentAssemblyBlock())
                    .where('J', blocks(EPBlocks.IRIDIUM_CASING.get())
                            .or(abilities(PartAbility.IMPORT_ITEMS)
                                    .setMaxGlobalLimited(6))
                            .or(abilities(PartAbility.IMPORT_FLUIDS)
                                    .setMaxGlobalLimited(6)))
                    .where('N', frames(GTMaterials.TungstenSteel)
                            .or(abilities(PartAbility.IMPORT_ITEMS)
                                    .setMaxGlobalLimited(2))
                            .or(abilities(PartAbility.IMPORT_FLUIDS)
                                    .setMaxGlobalLimited(2)))
                    .where('K', blocks(EPBlocks.IRIDIUM_CASING.get())
                            .or(abilities(PartAbility.EXPORT_ITEMS)
                                    .setMaxGlobalLimited(3)
                                    .setPreviewCount(1)))
                    .where('L', blocks(EPBlocks.IRIDIUM_CASING.get())
                            .or(abilities(PartAbility.INPUT_ENERGY)
                                    .setMaxGlobalLimited(2)))
                    .where('I', blocks(EPBlocks.IRIDIUM_CASING.get())
                            .or(abilities(PartAbility.MAINTENANCE)
                                    .setExactLimit(1)))
                    .where('M', blocks(EPBlocks.IRIDIUM_CASING.get())
                            .or(abilities(PartAbility.IMPORT_ITEMS)
                                    .setMaxGlobalLimited(6))
                            .or(abilities(PartAbility.IMPORT_FLUIDS)
                                    .setMaxGlobalLimited(6)))
                    .where('n', frames(GTMaterials.TungstenSteel))
                    .build()
            )
            .shapeInfos(definition -> {
                        ArrayList<MultiblockShapeInfo> shapeInfo = new ArrayList<>();
                        MultiblockShapeInfo.ShapeInfoBuilder builder = MultiblockShapeInfo.builder()
                                .aisle("HHHHHHHHH", "H  HKH  H", "H       H", "H       H", "H       H", "H       H", "HH     HH", " HHHHHHH ", "         ", "         ")
                                .aisle("HHHHHHHHH", "A       A", "A  HHH  A", "A       A", "A       A", "A       A", "H       H", "E       E", " EHHHHHE ", "         ")
                                .aisle("HHHHHHHHH", "A       A", "A  HHH  A", "A D   D A", "AC     CA", "AC     CA", "HC     CH", "E       E", " EH   HE ", "   HBH   ")
                                .aisle("HHHHHHHHH", "A  N N  A", "A  HHH  A", "A       A", "A       A", "A       A", "H       H", "E       E", " EH   HE ", "   HBH   ")
                                .aisle("HHHHHHHHH", "AG     GA", "AG HHH GA", "AG     GA", "AG     GA", "AG  C  GA", "HGG D GGH", "E GGDGG E", " EH   HE ", "   BBB   ")
                                .aisle("HHHHHHHHH", "A       A", "A  HHH  A", "A       A", "A       A", "A       A", "H       H", "E       E", " EH   HE ", "   HBH   ")
                                .aisle("HHHHHHHHH", "A       A", "A  HHH  A", "A D   D A", "AC     CA", "AC     CA", "HC     CH", "E       E", " EH   HE ", "   HBH   ")
                                .aisle("HHHHHHHHH", "A       A", "A  HHH  A", "A       A", "A       A", "A       A", "H       H", "E       E", " EH   HE ", "   HBH   ")
                                .aisle("QHHHHHHHP", "HG     GH", "HG HHH GH", "HG     GH", "HG     GH", "HG  C  GH", "HGG D GGH", "E GGDGG E", " EH   HE ", "   BBB   ")
                                .aisle("HHHHHHHHH", "A       A", "A  HHH  A", "A       A", "A       A", "A       A", "H       H", "E       E", " EH   HE ", "   HBH   ")
                                .aisle("HHHHHHHHH", "A       A", "A  HHH  A", "A D   D A", "AC     CA", "AC     CA", "HC     CH", "E       E", " EH   HE ", "   HBH   ")
                                .aisle("HHHHHHHHH", "A       A", "A  HHH  A", "A       A", "A       A", "A       A", "H       H", "E       E", " EH   HE ", "   HBH   ")
                                .aisle("HHHHHHHHH", "AG     GA", "AG HHH GA", "AG     GA", "AG     GA", "AG  C  GA", "HGG D GGH", "E GGDGG E", " EH   HE ", "   BBB   ")
                                .aisle("HHHHHHHHH", "A       A", "A  HHH  A", "A       A", "A       A", "A       A", "H       H", "E       E", " EH   HE ", "   HBH   ")
                                .aisle("HHHHHHHHH", "A       A", "A  HHH  A", "A D   D A", "AC     CA", "AC     CA", "HC     CH", "E       E", " EH   HE ", "   HBH   ")
                                .aisle("HHHHHHHHH", "A       A", "A  HHH  A", "A       A", "A       A", "A       A", "H       H", "E       E", " EH   HE ", "   HBH   ")
                                .aisle("QHHHHHHHP", "HG     GH", "HG HHH GH", "HG     GH", "HG     GH", "HG  C  GH", "HGG D GGH", "E GGDGG E", " EH   HE ", "   BBB   ")
                                .aisle("HHHHHHHHH", "A       A", "A  HHH  A", "A       A", "A       A", "A       A", "H       H", "E       E", " EH   HE ", "   HBH   ")
                                .aisle("HHHHHHHHH", "A       A", "A  HHH  A", "A D   D A", "AC     CA", "AC     CA", "HC     CH", "E       E", " EH   HE ", "   HBH   ")
                                .aisle("HHHHHHHHH", "A       A", "A  HHH  A", "A       A", "A       A", "A       A", "H       H", "E       E", " EH   HE ", "   HBH   ")
                                .aisle("HHHHHHHHH", "AG     GA", "AG HHH GA", "AG     GA", "AG     GA", "AG  C  GA", "HGG D GGH", "E GGDGG E", " EH   HE ", "   BBB   ")
                                .aisle("HHHHHHHHH", "A       A", "A  HHH  A", "A       A", "A       A", "A       A", "H       H", "E       E", " EH   HE ", "   HBH   ")
                                .aisle("HHHHHHHHH", "A       A", "A  HHH  A", "A D   D A", "AC     CA", "AC     CA", "HC     CH", "E       E", " EH   HE ", "   HBH   ")
                                .aisle("HHHHHHHHH", "A       A", "A  HHH  A", "A       A", "A       A", "A       A", "H       H", "E       E", " EH   HE ", "   HBH   ")
                                .aisle("QHHHHHHHP", "HG     GH", "HG HHH GH", "HG     GH", "HG     GH", "HG  C  GH", "HGG D GGH", "E GGDGG E", " EH   HE ", "   BBB   ")
                                .aisle("HHHHHHHHH", "A       A", "A  HHH  A", "A       A", "A       A", "A       A", "H       H", "E       E", " EH   HE ", "   HBH   ")
                                .aisle("HHHHHHHHH", "A       A", "A  HHH  A", "A D   D A", "AC     CA", "AC     CA", "HC     CH", "E       E", " EH   HE ", "   HBH   ")
                                .aisle("HHHHHHHHH", "A       A", "A  HHH  A", "A       A", "A       A", "A       A", "H       H", "E       E", " EH   HE ", "   HBH   ")
                                .aisle("HHHHHHHHH", "AG     GA", "AG HHH GA", "AG     GA", "AG     GA", "AG  C  GA", "HGG D GGH", "E GGDGG E", " EH   HE ", "   BBB   ")
                                .aisle("HHHHHHHHH", "A       A", "A  HHH  A", "A       A", "A       A", "A       A", "H       H", "E       E", " EH   HE ", "   HBH   ")
                                .aisle("HHHHHHHHH", "A       A", "A  HHH  A", "A D   D A", "AC     CA", "AC     CA", "HC     CH", "E       E", " EH   HE ", "   HBH   ")
                                .aisle("HHHHHHHHH", "A       A", "A  HHH  A", "A       A", "A       A", "A       A", "H       H", "E       E", " ELHHHLE ", "         ")
                                .aisle("HHHHHHHHH", "H  N N  H", "H  XXX  H", "H  JJJ  H", "H       H", "H       H", "HH HIH HH", " HHH~HHH ", "   HHH   ", "         ")
                                .where('~', definition, Direction.SOUTH)
                                .where('A', EPBlocks.OSMIR_BORON_SILICATE_GLASS.get())
                                .where('H', EPBlocks.IRIDIUM_CASING.get())
                                .where('C', GTBlocks.CASING_ASSEMBLY_LINE.get())
                                .where('D', ChemicalHelper.getBlock(TagPrefix.frameGt, EPMaterials.MARM200Steel))
                                .where('G', EPBlocks.CASING_POLYBENZIMIDAZOLE_PIPE.get())
                                .where('E', EPBlocks.ADVANCED_FILTER_CASING.get())
                                .where('J', GTMachines.ITEM_IMPORT_BUS[4], Direction.SOUTH)
                                .where('X', GTMachines.FLUID_IMPORT_HATCH[4], Direction.SOUTH)
                                .where('N', ChemicalHelper.getBlock(TagPrefix.frameGt, GTMaterials.TungstenSteel))
                                .where('K', GTMachines.ITEM_EXPORT_BUS[4], Direction.NORTH)
                                .where('L', GTMachines.ENERGY_INPUT_HATCH[5], Direction.SOUTH)
                                .where('I', GTMachines.MAINTENANCE_HATCH, Direction.SOUTH)
                                .where('Q', GTMachines.ITEM_IMPORT_BUS[4], Direction.WEST)
                                .where('P', GTMachines.FLUID_IMPORT_HATCH[4], Direction.EAST);
                        BlockMaps.ALL_CA_TIRED_CASINGS.entrySet().stream()
                                .sorted(Comparator.comparingInt(entry -> entry.getKey().tier()))
                                .forEach(entry -> shapeInfo.add(builder.where('B', entry.getValue()).build()));
                        return shapeInfo;
                    })
                    .partSorter(Comparator.comparingInt(a -> a.self().getPos().getY()))
                    .workableCasingRenderer(Epimorphism.id("block/casings/solid/iridium_casing"),
                            Epimorphism.id("block/multiblock/component_assembly_line"), false)
                    .register();

    public final static MultiblockMachineDefinition GENERAL_PROCESSING_PLANT = EP_REGISTRATE.multiblock("general_processing_plant", GeneralProcessingPlantMachine::new)
            .langValue("General Processing Plant")
            .tooltipBuilder((itemStack, components) -> {
                components.add(Component.translatable("block.epimorphism.general_processing_plant.desc.0"));
                if (GTUtil.isShiftDown()) {
                    components.add(Component.translatable("block.epimorphism.general_processing_plant.shift_desc.0"));
                    components.add(Component.translatable("block.epimorphism.general_processing_plant.shift_desc.1"));
                    components.add(Component.translatable("block.epimorphism.general_processing_plant.shift_desc.2"));
                    components.add(Component.translatable("block.epimorphism.general_processing_plant.shift_desc.3"));
                } else {
                    components.add(Component.translatable("block.epimorphism.general_processing_plant.desc.1"));
                    components.add(Component.translatable("block.epimorphism.general_processing_plant.desc.2"));
                    components.add(Component.translatable("block.epimorphism.general_processing_plant.desc.3"));
                    components.add(Component.translatable("epimorphism.desc_extended_info"));
                }
            })
            .rotationState(RotationState.NON_Y_AXIS)
            .recipeTypes(GeneralProcessingPlantMachine.RECIPE_MAP)
            .recipeModifier(GTRecipeModifiers.ELECTRIC_OVERCLOCK.apply(OverclockingLogic.NON_PERFECT_OVERCLOCK))
            .appearanceBlock(EPBlocks.MARAGING_STEEL_CASING)
            .pattern(definition -> FactoryBlockPattern.start()
                    .aisle("GGGGGGG", "F     F", "F     F", "F     F", "F     F", "GGGEGGG")
                    .aisle("GGGGGGG", " PTTTP ", " PTTTP ", " PTTTP ", " PTTTP ", "GGGGGGG")
                    .aisle("GGGGGGG", " TB BT ", " T   T ", " T   T ", " T   T ", "GGGGGGG")
                    .aisle("GGGGGGG", " T L T ", " T   T ", " T B T ", " T B T ", "EGGGGGE")
                    .aisle("GGGGGGG", " TB BT ", " T   T ", " T   T ", " T   T ", "GGGGGGG")
                    .aisle("GGGGGGG", " PTTTP ", " PTTTP ", " PTTTP ", " PTTTP ", "GGGGGGG")
                    .aisle("GGGGGGG", "F     F", "F     F", "F     F", "F     F", "GGGEGGG")
                    .aisle("CCCSCCC", "       ", "       ", "       ", "       ", "       ")
                    .where('S', controller(blocks(definition.getBlock())))
                    .where('C', blocks(EPBlocks.MARAGING_STEEL_CASING.get())
                            .or(abilities(PartAbility.IMPORT_ITEMS))
                            .or(abilities(PartAbility.EXPORT_ITEMS))
                            .or(abilities(PartAbility.IMPORT_FLUIDS))
                            .or(abilities(PartAbility.EXPORT_FLUIDS))
                            .or(abilities(PartAbility.MAINTENANCE).setExactLimit(1)))
                    .where('G', blocks(EPBlocks.MARAGING_STEEL_CASING.get()))
                    .where('E', blocks(EPBlocks.MARAGING_STEEL_CASING.get()).or(abilities(PartAbility.INPUT_ENERGY).setMinGlobalLimited(1)))
                    .where('B', blocks(GTBlocks.CASING_STEEL_GEARBOX.get()))
                    .where('P', blocks(EPBlocks.GENERAL_PROCESSING_CASING.get()))
                    .where('L', blocks(EPBlocks.ADVANCED_SUBSTRATE_CASING.get()))
                    .where('T', blocks(GTBlocks.CASING_LAMINATED_GLASS.get()))
                    .where('F', frames(EPMaterials.MaragingSteel250))
                    .build()
            )
            .shapeInfo(definition -> MultiblockShapeInfo.builder()
                    .aisle("GGGGGGG", "F     F", "F     F", "F     F", "F     F", "GGGGGGG")
                    .aisle("GGGGGGG", " PTTTP ", " PTTTP ", " PTTTP ", " PTTTP ", "GGGGGGG")
                    .aisle("GGGGGGG", " TB BT ", " T   T ", " T   T ", " T   T ", "GGGGGGG")
                    .aisle("GGGGGGG", " T L T ", " T   T ", " T B T ", " T B T ", "GGGGGGG")
                    .aisle("GGGGGGG", " TB BT ", " T   T ", " T   T ", " T   T ", "GGGGGGG")
                    .aisle("GGGGGGG", " PTTTP ", " PTTTP ", " PTTTP ", " PTTTP ", "GGGGGGG")
                    .aisle("GGGGGGG", "F     F", "F     F", "F     F", "F     F", "GGGEGGG")
                    .aisle("AAHSCDM", "       ", "       ", "       ", "       ", "       ")
                    .where('S', definition, Direction.SOUTH)
                    .where('A', GTMachines.ITEM_IMPORT_BUS[4], Direction.SOUTH)
                    .where('H', GTMachines.ITEM_EXPORT_BUS[4], Direction.SOUTH)
                    .where('C', GTMachines.FLUID_IMPORT_HATCH[4], Direction.SOUTH)
                    .where('D', GTMachines.FLUID_EXPORT_HATCH[4], Direction.SOUTH)
                    .where('M', GTMachines.MAINTENANCE_HATCH, Direction.SOUTH)
                    .where('G', EPBlocks.MARAGING_STEEL_CASING.get())
                    .where('E', GTMachines.ENERGY_INPUT_HATCH[4], Direction.SOUTH)
                    .where('B', GTBlocks.CASING_STEEL_GEARBOX.get())
                    .where('P', EPBlocks.GENERAL_PROCESSING_CASING.get())
                    .where('L', EPBlocks.ADVANCED_SUBSTRATE_CASING.get())
                    .where('T', GTBlocks.CASING_LAMINATED_GLASS.get())
                    .where('F', ChemicalHelper.getBlock(TagPrefix.frameGt, EPMaterials.MaragingSteel250)).build())
            .partSorter(Comparator.comparingInt(a -> a.self().getPos().getY()))
            .workableCasingRenderer(Epimorphism.id("block/casings/solid/maraging_steel_250_casing"),
                    Epimorphism.id("block/multiblock/general_processing_plant"), false)
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
            .recipeType(GTRecipeTypes.DUMMY_RECIPES)
            .recipeModifier(GTRecipeModifiers.ELECTRIC_OVERCLOCK.apply(OverclockingLogic.NON_PERFECT_OVERCLOCK))
            .appearanceBlock(EPBlocks.BREEDING_CASING)
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
                    .where('X', blocks(EPBlocks.BREEDING_CASING.get()).setMinGlobalLimited(106)
                            .or(abilities(PartAbility.EXPORT_ITEMS).setExactLimit(1))
                            .or(abilities(PartAbility.IMPORT_FLUIDS).setMaxGlobalLimited(1))
                            .or(abilities(PartAbility.MAINTENANCE).setExactLimit(1)))
                    .where('E', blocks(EPBlocks.BREEDING_CASING.get())
                            .or(abilities(PartAbility.INPUT_ENERGY).setMinGlobalLimited(1).setMaxGlobalLimited(3)))
                    .where('#', any())
                    .build()
            )
            .partSorter(Comparator.comparingInt(a -> a.self().getPos().getY()))
            .workableCasingRenderer(Epimorphism.id("block/casings/solid/breeding_casing"),
                    Epimorphism.id("block/multiblock/industrial_fishing_pond"), false)
            .register();

    public final static MultiblockMachineDefinition FERMENTATION_TANK = EP_REGISTRATE.multiblock("fermentation_tank", FermentationTankMachine::new)
            .langValue("Fermentation Tank")
            .tooltips(Component.translatable("block.epimorphism.fermentation_tank.desc.0"))
            .rotationState(RotationState.NON_Y_AXIS)
            .recipeType(EPRecipeTypes.FERMENTATION_TANK_RECIPES)
            .appearanceBlock(GTBlocks.CASING_STAINLESS_CLEAN)
            .pattern(definition -> FactoryBlockPattern.start()
                    .aisle("FAAAF", "FXXXF", "FXGXF", "FXGXF", "FXGXF", "FXXXF", "AAAAA")
                    .aisle("AXXXA", "XEEEX", "XEEEX", "XEEEX", "XEEEX", "XEEEX", "AXXXA")
                    .aisle("AXXXA", "XEPEX", "GEPEG", "GEPEG", "GEPEG", "XEPEX", "AXXXA")
                    .aisle("AXXXA", "XEEEX", "XEEEX", "XEEEX", "XEEEX", "XEEEX", "AXXXA")
                    .aisle("FAAAF", "FXSXF", "FXGXF", "FXGXF", "FXGXF", "FXXXF", "AAAAA")
                    .where('S', controller(blocks(definition.getBlock())))
                    .where('X', blocks(GTBlocks.CASING_STAINLESS_CLEAN.get()).setMinGlobalLimited(42).or(autoAbilities(EPRecipeTypes.FERMENTATION_TANK_RECIPES)))
                    .where('G', blocks(EPBlocks.OSMIR_BORON_SILICATE_GLASS.get()))
                    .where('F', frames(GTMaterials.WatertightSteel))
                    .where('P', blocks(GTBlocks.CASING_POLYTETRAFLUOROETHYLENE_PIPE.get()))
                    .where('A', any())
                    .where('E', air())
                    .build()
            )
            .partSorter(Comparator.comparingInt(a -> a.self().getPos().getY()))
            .workableCasingRenderer(GTCEu.id("block/casings/solid/machine_casing_clean_stainless_steel"),
                    Epimorphism.id("block/multiblock/fermentation_tank"), false)
            .register();
    public final static MultiblockMachineDefinition MEGA_CRACKING_UNIT = EP_REGISTRATE.multiblock("mega_cracking_unit", blockEntity -> new ParallelGlassCoilMultiblockMachine(blockEntity, machine -> machine.getCoilTier() * 4))
            .langValue("Mega Oil Cracking Unit")
            .tooltips(Component.translatable("block.epimorphism.mega_cracking_unit.desc.0"))
            .rotationState(RotationState.NON_Y_AXIS)
            .recipeType(GTRecipeTypes.CRACKING_RECIPES)
            .appearanceBlock(GTBlocks.CASING_STAINLESS_CLEAN)
            .pattern(definition -> FactoryBlockPattern.start()
                    .aisle(
                            "CCCCCCCCCCCCC",
                            " C         C ",
                            " C         C ",
                            " C         C ",
                            " C         C ",
                            " C         C ",
                            " C         C "
                    )
                    .aisle(
                            "CCCCCCCCCCCCC",
                            "CCGGGGGGGGGCC",
                            "CCGGGGGGGGGCC",
                            "CCGGGGGGGGGCC",
                            "CCGGGGGGGGGCC",
                            "CCGGGGGGGGGCC",
                            "CCGGGGGGGGGCC"
                    )
                    .aisle(
                            "CCCCCCCCCCCCC",
                            " GALALALALAG ",
                            " GALALALALAG ",
                            " GALALALALAG ",
                            " GALALALALAG ",
                            " GALALALALAG ",
                            " CGGGGGGGGGC "
                    )
                    .aisle(
                            "CCCCCCCCCCCCC",
                            " GALALALALAG ",
                            " EAAAAAAAAAD ",
                            " EALALALALAD ",
                            " EAAAAAAAAAD ",
                            " GALALALALAG ",
                            " CGGGEEEGGGC "
                    )
                    .aisle(
                            "CCCCCCCCCCCCC",
                            " GALALALALAG ",
                            " EALALALALAD ",
                            " EALALALALAD ",
                            " EALALALALAD ",
                            " GALALALALAG ",
                            " CGGGEEEGGGC "
                    )
                    .aisle(
                            "CCCCCCCCCCCCC",
                            " GALALALALAG ",
                            " EAAAAAAAAAD ",
                            " EALALALALAD ",
                            " EAAAAAAAAAD ",
                            " GALALALALAG ",
                            " CGGGEEEGGGC "
                    )
                    .aisle(
                            "CCCCCCCCCCCCC",
                            " GALALALALAG ",
                            " GALALALALAG ",
                            " GALALALALAG ",
                            " GALALALALAG ",
                            " GALALALALAG ",
                            " CGGGGGGGGGC "
                    )
                    .aisle(
                            "CCCCCCCCCCCCC",
                            "CCGGGGGGGGGCC",
                            "CCGGGGGGGGGCC",
                            "CCGGGGGGGGGCC",
                            "CCGGGGGGGGGCC",
                            "CCGGGGGGGGGCC",
                            "CCGGGGGGGGGCC"
                    )
                    .aisle(
                            "CCCCCCSCCCCCC",
                            " C         C ",
                            " C         C ",
                            " C         C ",
                            " C         C ",
                            " C         C ",
                            " C         C "
                    )
                    .where('S', controller(blocks(definition.getBlock())))
                    .where('C', blocks(GTBlocks.CASING_STAINLESS_CLEAN.get()).setMinGlobalLimited(190)
                            .or(abilities(PartAbility.IMPORT_ITEMS))
                            .or(abilities(PartAbility.INPUT_ENERGY))
                            .or(abilities(PartAbility.MAINTENANCE)))
                    .where('G', EPPredicates.glass())
                    .where('L', Predicates.heatingCoils())
                    .where('D', blocks(GTBlocks.CASING_STAINLESS_CLEAN.get())
                            .or(abilities(PartAbility.EXPORT_FLUIDS)))
                    .where('E', blocks(GTBlocks.CASING_STAINLESS_CLEAN.get())
                            .or(abilities(PartAbility.IMPORT_FLUIDS)))
                    .where(' ', any())
                    .where('A', air())
                    .build()
            )
            .shapeInfos(definition -> {
                ArrayList<MultiblockShapeInfo> shapeInfo = new ArrayList<>();
                MultiblockShapeInfo.ShapeInfoBuilder builder = MultiblockShapeInfo.builder()
                        .aisle(
                                "CCCCCCJHCCCCC",
                                " CAAAAAAAAAC ",
                                " CAAAAAAAAAC ",
                                " CAAAAAAAAAC ",
                                " CAAAAAAAAAC ",
                                " CAAAAAAAAAC ",
                                " CAAAAAAAAAC "
                        )
                        .aisle(
                                "CCCCCCCCCCCCC",
                                "CCGGGGGGGGGCC",
                                "CCGGGGGGGGGCC",
                                "CCGGGGGGGGGCC",
                                "CCGGGGGGGGGCC",
                                "CCGGGGGGGGGCC",
                                "CCGGGGGGGGGCC"
                        )
                        .aisle(
                                "CCCCCCCCCCCCC",
                                " GALALALALAG ",
                                " GALALALALAG ",
                                " GALALALALAG ",
                                " GALALALALAG ",
                                " GALALALALAG ",
                                " CGGGGGGGGGC "
                        )
                        .aisle(
                                "CCCCCCCCCCCCC",
                                " GALALALALAG ",
                                " CAAAAAAAAAC ",
                                " CALALALALAC ",
                                " CAAAAAAAAAC ",
                                " GALALALALAG ",
                                " CGGGCCCGGGC "
                        )
                        .aisle(
                                "CCCCCCCCCCCCC",
                                " GALALALALAG ",
                                " CALALALALAC ",
                                " DALALALALAN ",
                                " CALALALALAC ",
                                " GALALALALAG ",
                                " CGGGCVCGGGC "
                        )
                        .aisle(
                                "CCCCCCCCCCCCC",
                                " GALALALALAG ",
                                " CAAAAAAAAAC ",
                                " CALALALALAC ",
                                " CAAAAAAAAAC ",
                                " GALALALALAG ",
                                " CGGGCCCGGGC "
                        )
                        .aisle(
                                "CCCCCCCCCCCCC",
                                " GALALALALAG ",
                                " GALALALALAG ",
                                " GALALALALAG ",
                                " GALALALALAG ",
                                " GALALALALAG ",
                                " CGGGGGGGGGC "
                        )
                        .aisle(
                                "CCCCCCCCCCCCC",
                                "CCGGGGGGGGGCC",
                                "CCGGGGGGGGGCC",
                                "CCGGGGGGGGGCC",
                                "CCGGGGGGGGGCC",
                                "CCGGGGGGGGGCC",
                                "CCGGGGGGGGGCC"
                        )
                        .aisle(
                                "CCCCCCSKCCCCC",
                                " CAAAAAAAAAC ",
                                " CAAAAAAAAAC ",
                                " CAAAAAAAAAC ",
                                " CAAAAAAAAAC ",
                                " CAAAAAAAAAC ",
                                " CAAAAAAAAAC "
                        )
                        .where('S', definition, Direction.SOUTH)
                        .where('C', GTBlocks.CASING_STAINLESS_CLEAN)
                        .where('V', GTMachines.FLUID_IMPORT_HATCH[4], Direction.UP)
                        .where('D', GTMachines.FLUID_IMPORT_HATCH[4], Direction.WEST)
                        .where('N', GTMachines.FLUID_EXPORT_HATCH[4], Direction.EAST)
                        .where('K', GTMachines.ITEM_IMPORT_BUS[4], Direction.SOUTH)
                        .where('H', GTMachines.ENERGY_INPUT_HATCH[5], Direction.NORTH)
                        .where('A', Blocks.AIR)
                        .where('J', GTMachines.MAINTENANCE_HATCH, Direction.NORTH);

                List<CoilBlock> coils = GTBlocks.ALL_COILS.entrySet().stream()
                        .sorted(Comparator.comparingInt(entry -> entry.getKey().getTier()))
                        .map(Map.Entry::getValue)
                        .map(Supplier::get)
                        .toList();
                List<Block> glasses = BlockMaps.SHAPE_GLASSES.entrySet().stream()
                        .sorted(Comparator.comparingInt(entry -> entry.getKey().tier()))
                        .map(Map.Entry::getValue)
                        .map(Supplier::get)
                        .toList();

                int maxLeng = StructureUtil.maxLength(new List[]{
                        coils,
                        glasses
                });

                for (int i = 0; i < maxLeng; ++i) {
                    builder.where('L', EPUniverUtil.getOrLast(coils, i));
                    builder.where('G', EPUniverUtil.getOrLast(glasses, i));
                    shapeInfo.add(builder.build());
                }
                return shapeInfo;
            })
            .partSorter(Comparator.comparingInt(a -> a.self().getPos().getY()))
            .workableCasingRenderer(GTCEu.id("block/casings/solid/machine_casing_clean_stainless_steel"),
                    Epimorphism.id("block/multiblock/mega_cracking_unit"), false)
            .register();

    public final static MultiblockMachineDefinition MEGA_ALLOY_BLAST_SMELTER = EP_REGISTRATE.multiblock("mega_alloy_blast_smelter", blockEntity -> new ParallelGlassCoilMultiblockMachine(blockEntity, machine -> machine.getCoilTier() * 4))
            .langValue("Mega Alloy Blast Smelter")
            .tooltips(Component.translatable("block.epimorphism.mega_alloy_blast_smelter.desc.0"))
            .rotationState(RotationState.NON_Y_AXIS)
            .recipeType(GCyMRecipeTypes.ALLOY_BLAST_RECIPES)
            .appearanceBlock(GCyMBlocks.CASING_HIGH_TEMPERATURE_SMELTING)
            .pattern(definition -> FactoryBlockPattern.start()
                    .aisle("   BBBBB   ", "   CCCCC   ", "   CCCCC   ", "   CCCCC   ", "   BBBBB   ", "           ", "           ", "           ", "           ", "           ", "           ", "           ", "           ", "           ", "           ", "           ", "           ", "           ", "           ", "           ")
                    .aisle("  BDDDDDB  ", "  G     G  ", "  G     G  ", "  G     G  ", "  BDDDDDB  ", "   DDDDD   ", "   GGGGG   ", "   GGGGG   ", "   GGGGG   ", "   GGGGG   ", "   GGGGG   ", "   GGGGG   ", "   GGGGG   ", "   GGGGG   ", "   GGGGG   ", "   GGGGG   ", "   GGGGG   ", "   DDDDD   ", "   DDDDD   ", "           ")
                    .aisle(" BDDHHHDDB ", " G       G ", " G       G ", " G       G ", " BDDHHHDDB ", "  DVVVVVD  ", "  GWWWWWG  ", "  GWWWWWG  ", "  GWWWWWG  ", "  GWWWWWG  ", "  GWWWWWG  ", "  GWWWWWG  ", "  GWWWWWG  ", "  GWWWWWG  ", "  GWWWWWG  ", "  GWWWWWG  ", "  GWWWWWG  ", "  DDDDDDD  ", "  DDDDDDD  ", "   DDDDD   ")
                    .aisle("BDDDDDDDDDB", "C  VWWWV  C", "C  VBBBV  C", "C  VBBBV  C", "BDDDDDDDDDB", " DVVVVVVVD ", " GWW   WWG ", " GWW   WWG ", " GWW   WWG ", " GWW   WWG ", " GWW   WWG ", " GWW   WWG ", " GWW   WWG ", " GWW   WWG ", " GWW   WWG ", " GWW   WWG ", " GWW   WWG ", " DDDDDDDDD ", " DDDDDDDDD ", "  DDDDDDD  ")
                    .aisle("BDHDDDDDHDB", "C  W   W  C", "C  B   B  C", "C  B   B  C", "BDHDDDDDHDB", " DVVVVVVVD ", " GW     WG ", " GW     WG ", " GW     WG ", " GW     WG ", " GW     WG ", " GW     WG ", " GW     WG ", " GW     WG ", " GW     WG ", " GW     WG ", " GW     WG ", " DDDDDDDDD ", " DDDDDDDDD ", "  DDDDDDD  ")
                    .aisle("BDHDDDDDHDB", "C  W V W  C", "C  B V B  C", "C  B V B  C", "BDHDDVDDHDB", " DVVVVVVVD ", " GW  V  WG ", " GW  V  WG ", " GW  V  WG ", " GW  V  WG ", " GW  V  WG ", " GW  V  WG ", " GW  V  WG ", " GW  V  WG ", " GW  V  WG ", " GW  V  WG ", " GW  V  WG ", " DDDDDDDDD ", " DDDDDDDDD ", "  DDDMDDD  ")
                    .aisle("BDHDDDDDHDB", "C  W   W  C", "C  B   B  C", "C  B   B  C", "BDHDDDDDHDB", " DVVVVVVVD ", " GW     WG ", " GW     WG ", " GW     WG ", " GW     WG ", " GW     WG ", " GW     WG ", " GW     WG ", " GW     WG ", " GW     WG ", " GW     WG ", " GW     WG ", " DDDDDDDDD ", " DDDDDDDDD ", "  DDDDDDD  ")
                    .aisle("BDDDDDDDDDB", "C  VWWWV  C", "C  VBBBV  C", "C  VBBBV  C", "BDDDDDDDDDB", " DVVVVVVVD ", " GWW   WWG ", " GWW   WWG ", " GWW   WWG ", " GWW   WWG ", " GWW   WWG ", " GWW   WWG ", " GWW   WWG ", " GWW   WWG ", " GWW   WWG ", " GWW   WWG ", " GWW   WWG ", " DDDDDDDDD ", " DDDDDDDDD ", "  DDDDDDD  ")
                    .aisle(" BDDHHHDDB ", " G       G ", " G       G ", " G       G ", " BDDHHHDDB ", "  DVVVVVD  ", "  GWWWWWG  ", "  GWWWWWG  ", "  GWWWWWG  ", "  GWWWWWG  ", "  GWWWWWG  ", "  GWWWWWG  ", "  GWWWWWG  ", "  GWWWWWG  ", "  GWWWWWG  ", "  GWWWWWG  ", "  GWWWWWG  ", "  DDDDDDD  ", "  DDDDDDD  ", "   DDDDD   ")
                    .aisle("  BDDDDDB  ", "  G     G  ", "  G     G  ", "  G     G  ", "  BDDDDDB  ", "   DDDDD   ", "   GGGGG   ", "   GGGGG   ", "   GGGGG   ", "   GGGGG   ", "   GGGGG   ", "   GGGGG   ", "   GGGGG   ", "   GGGGG   ", "   GGGGG   ", "   GGGGG   ", "   GGGGG   ", "   DDDDD   ", "   DDDDD   ", "           ")
                    .aisle("   BBBBB   ", "   CCCCC   ", "   CCSCC   ", "   CCCCC   ", "   BBBBB   ", "           ", "           ", "           ", "           ", "           ", "           ", "           ", "           ", "           ", "           ", "           ", "           ", "           ", "           ", "           ")
                    .where('S', controller(blocks(definition.getBlock())))
                    .where('B', blocks(GCyMBlocks.HEAT_VENT.get()))
                    .where('D', blocks(GCyMBlocks.CASING_HIGH_TEMPERATURE_SMELTING.get()))
                    .where('G', EPPredicates.glass())
                    .where('H', blocks(GCyMBlocks.HEAT_VENT.get()))
                    .where('V', blocks(EPBlocks.TFFT_CASING.get()))
                    .where('W', Predicates.heatingCoils())
                    .where('C', blocks(GCyMBlocks.CASING_HIGH_TEMPERATURE_SMELTING.get()).setMinGlobalLimited(15)
                            .or(autoAbilities(definition.getRecipeTypes()))
                            .or(autoAbilities(true, false, false)))
                    .where('M', abilities(PartAbility.MUFFLER))
                    .where(' ', any())
                    .build()
            )
            .shapeInfos(definition -> {
                ArrayList<MultiblockShapeInfo> shapeInfo = new ArrayList<>();
                MultiblockShapeInfo.ShapeInfoBuilder builder = MultiblockShapeInfo.builder()
                        .aisle("   BBBBB   ", "   CCENC   ", "   CCCCC   ", "   CCCCC   ", "   BBBBB   ", "           ", "           ", "           ", "           ", "           ", "           ", "           ", "           ", "           ", "           ", "           ", "           ", "           ", "           ", "           ")
                        .aisle("  BDDDDDB  ", "  G     G  ", "  G     G  ", "  G     G  ", "  BDDDDDB  ", "   DDDDD   ", "   GGGGG   ", "   GGGGG   ", "   GGGGG   ", "   GGGGG   ", "   GGGGG   ", "   GGGGG   ", "   GGGGG   ", "   GGGGG   ", "   GGGGG   ", "   GGGGG   ", "   GGGGG   ", "   DDDDD   ", "   DDDDD   ", "           ")
                        .aisle(" BDDHHHDDB ", " G       G ", " G       G ", " G       G ", " BDDHHHDDB ", "  DVVVVVD  ", "  GWWWWWG  ", "  GWWWWWG  ", "  GWWWWWG  ", "  GWWWWWG  ", "  GWWWWWG  ", "  GWWWWWG  ", "  GWWWWWG  ", "  GWWWWWG  ", "  GWWWWWG  ", "  GWWWWWG  ", "  GWWWWWG  ", "  DDDDDDD  ", "  DDDDDDD  ", "   DDDDD   ")
                        .aisle("BDDDDDDDDDB", "C  VWWWV  C", "C  VBBBV  C", "C  VBBBV  C", "BDDDDDDDDDB", " DVVVVVVVD ", " GWW   WWG ", " GWW   WWG ", " GWW   WWG ", " GWW   WWG ", " GWW   WWG ", " GWW   WWG ", " GWW   WWG ", " GWW   WWG ", " GWW   WWG ", " GWW   WWG ", " GWW   WWG ", " DDDDDDDDD ", " DDDDDDDDD ", "  DDDDDDD  ")
                        .aisle("BDHDDDDDHDB", "C  W   W  C", "C  B   B  C", "C  B   B  C", "BDHDDDDDHDB", " DVVVVVVVD ", " GW     WG ", " GW     WG ", " GW     WG ", " GW     WG ", " GW     WG ", " GW     WG ", " GW     WG ", " GW     WG ", " GW     WG ", " GW     WG ", " GW     WG ", " DDDDDDDDD ", " DDDDDDDDD ", "  DDDDDDD  ")
                        .aisle("BDHDDDDDHDB", "C  W V W  C", "C  B V B  C", "C  B V B  C", "BDHDDVDDHDB", " DVVVVVVVD ", " GW  V  WG ", " GW  V  WG ", " GW  V  WG ", " GW  V  WG ", " GW  V  WG ", " GW  V  WG ", " GW  V  WG ", " GW  V  WG ", " GW  V  WG ", " GW  V  WG ", " GW  V  WG ", " DDDDDDDDD ", " DDDDDDDDD ", "  DDDMDDD  ")
                        .aisle("BDHDDDDDHDB", "C  W   W  C", "C  B   B  C", "C  B   B  C", "BDHDDDDDHDB", " DVVVVVVVD ", " GW     WG ", " GW     WG ", " GW     WG ", " GW     WG ", " GW     WG ", " GW     WG ", " GW     WG ", " GW     WG ", " GW     WG ", " GW     WG ", " GW     WG ", " DDDDDDDDD ", " DDDDDDDDD ", "  DDDDDDD  ")
                        .aisle("BDDDDDDDDDB", "C  VWWWV  C", "C  VBBBV  C", "C  VBBBV  C", "BDDDDDDDDDB", " DVVVVVVVD ", " GWW   WWG ", " GWW   WWG ", " GWW   WWG ", " GWW   WWG ", " GWW   WWG ", " GWW   WWG ", " GWW   WWG ", " GWW   WWG ", " GWW   WWG ", " GWW   WWG ", " GWW   WWG ", " DDDDDDDDD ", " DDDDDDDDD ", "  DDDDDDD  ")
                        .aisle(" BDDHHHDDB ", " G       G ", " G       G ", " G       G ", " BDDHHHDDB ", "  DVVVVVD  ", "  GWWWWWG  ", "  GWWWWWG  ", "  GWWWWWG  ", "  GWWWWWG  ", "  GWWWWWG  ", "  GWWWWWG  ", "  GWWWWWG  ", "  GWWWWWG  ", "  GWWWWWG  ", "  GWWWWWG  ", "  GWWWWWG  ", "  DDDDDDD  ", "  DDDDDDD  ", "   DDDDD   ")
                        .aisle("  BDDDDDB  ", "  G     G  ", "  G     G  ", "  G     G  ", "  BDDDDDB  ", "   DDDDD   ", "   GGGGG   ", "   GGGGG   ", "   GGGGG   ", "   GGGGG   ", "   GGGGG   ", "   GGGGG   ", "   GGGGG   ", "   GGGGG   ", "   GGGGG   ", "   GGGGG   ", "   GGGGG   ", "   DDDDD   ", "   DDDDD   ", "           ")
                        .aisle("   BBBBB   ", "   ICXCJ   ", "   CCSCC   ", "   CCCCC   ", "   BBBBB   ", "           ", "           ", "           ", "           ", "           ", "           ", "           ", "           ", "           ", "           ", "           ", "           ", "           ", "           ", "           ")
                        .where('S', definition, Direction.SOUTH)
                        .where('B', GCyMBlocks.HEAT_VENT)
                        .where('D', GCyMBlocks.CASING_HIGH_TEMPERATURE_SMELTING)
                        .where('H', GCyMBlocks.HEAT_VENT)
                        .where('V', EPBlocks.TFFT_CASING)
                        .where('C', GCyMBlocks.CASING_HIGH_TEMPERATURE_SMELTING)
                        .where('E', GTMachines.ENERGY_INPUT_HATCH[5], Direction.NORTH)
                        .where('N', GTMachines.MAINTENANCE_HATCH, Direction.NORTH)
                        .where('I', GTMachines.FLUID_IMPORT_HATCH[4], Direction.SOUTH)
                        .where('X', GTMachines.ITEM_IMPORT_BUS[4], Direction.SOUTH)
                        .where('J', GTMachines.FLUID_EXPORT_HATCH[4], Direction.SOUTH)
                        .where('M', GTMachines.MUFFLER_HATCH[1], Direction.UP)
                        .where(' ', Blocks.AIR);

                List<CoilBlock> coils = GTBlocks.ALL_COILS.entrySet().stream()
                        .sorted(Comparator.comparingInt(entry -> entry.getKey().getTier()))
                        .map(Map.Entry::getValue)
                        .map(Supplier::get)
                        .toList();
                List<Block> glasses = BlockMaps.SHAPE_GLASSES.entrySet().stream()
                        .sorted(Comparator.comparingInt(entry -> entry.getKey().tier()))
                        .map(Map.Entry::getValue)
                        .map(Supplier::get)
                        .toList();

                int maxLeng = StructureUtil.maxLength(new List[]{
                        coils,
                        glasses
                });

                for (int i = 0; i < maxLeng; ++i) {
                    builder.where('W', EPUniverUtil.getOrLast(coils, i));
                    builder.where('G', EPUniverUtil.getOrLast(glasses, i));
                    shapeInfo.add(builder.build());
                }
                return shapeInfo;
            })
            .partSorter(Comparator.comparingInt(a -> a.self().getPos().getY()))
            .workableCasingRenderer(GTCEu.id("block/casings/gcym/high_temperature_smelting_casing"),
                    Epimorphism.id("block/multiblock/mega_alloy_blast_smelter"), false)
            .register();
    public final static MultiblockMachineDefinition VACUUM_DRYING_FURNACE = EP_REGISTRATE.multiblock("vacuum_drying_furnace", blockEntity -> new ParallelCoilMultiblockMachine(blockEntity, machine -> machine.getCoilTier() * 4))
            .langValue("Vacuum Drying Furnace")
            .tooltips(Component.translatable("block.epimorphism.vacuum_drying_furnace.desc.0"))
            .rotationState(RotationState.NON_Y_AXIS)
            .recipeType(EPRecipeTypes.VACUUM_DRYING_FURNACE_RECIPES)
            .appearanceBlock(EPBlocks.VACUUM_CASING)
            .pattern(definition -> FactoryBlockPattern.start()
                    .aisle("XXX", "CCC", "CCC", "CCC", "XXX")
                    .aisle("XXX", "C#C", "C#C", "C#C", "XMX")
                    .aisle("XSX", "CCC", "CCC", "CCC", "XXX")
                    .where('S', controller(blocks(definition.get())))
                    .where('X', blocks(EPBlocks.VACUUM_CASING.get())
                            .setMinGlobalLimited(9)
                            .or(autoAbilities(definition.getRecipeTypes()))
                            .or(autoAbilities(true, false, false)))
                    .where('M', abilities(PartAbility.MUFFLER))
                    .where('C', heatingCoils())
                    .where('#', air())
                    .build()
            )
            .shapeInfos(definition -> {
                ArrayList<MultiblockShapeInfo> shapeInfo = new ArrayList<>();
                MultiblockShapeInfo.ShapeInfoBuilder builder = MultiblockShapeInfo.builder()
                        .aisle("EEM", "CCC", "CCC", "CCC", "XXX")
                        .aisle("FXD", "C#C", "C#C", "C#C", "XHX")
                        .aisle("ISO", "CCC", "CCC", "CCC", "XXX")
                        .where('S', definition, Direction.SOUTH)
                        .where('X', EPBlocks.VACUUM_CASING)
                        .where('E', GTMachines.ENERGY_INPUT_HATCH[6], Direction.NORTH)
                        .where('I', GTMachines.ITEM_IMPORT_BUS[6], Direction.SOUTH)
                        .where('O', GTMachines.ITEM_EXPORT_BUS[6], Direction.SOUTH)
                        .where('F', GTMachines.FLUID_IMPORT_HATCH[6], Direction.WEST)
                        .where('D', GTMachines.FLUID_EXPORT_HATCH[6], Direction.EAST)
                        .where('H', GTMachines.MUFFLER_HATCH[1], Direction.UP)
                        .where('#', Blocks.AIR.defaultBlockState())
                        .where('M', GTMachines.MAINTENANCE_HATCH, Direction.NORTH);
                ALL_COILS.entrySet().stream()
                        .sorted(Comparator.comparingInt(entry -> entry.getKey().getTier()))
                        .forEach(coil -> shapeInfo.add(builder.shallowCopy().where('C', coil.getValue().get()).build()));
                return shapeInfo;
            })
            .partSorter(Comparator.comparingInt(a -> a.self().getPos().getY()))
            .workableCasingRenderer(Epimorphism.id("block/casings/solid/vacuum_casing"),
                    Epimorphism.id("block/multiblock/vacuum_drying_furnace"), false)
            .register();


    // Multiblock Parts
    public final static MachineDefinition INFINITE_WATER_HATCH = EP_REGISTRATE.machine("infinite_water_hatch", InfiniteWaterHatchPartMachine::new)
            .langValue("Infinite Water Hatch")
            .tier(GTValues.IV)
            .rotationState(RotationState.ALL)
            .abilities(PartAbility.IMPORT_FLUIDS)
            .overlayTieredHullRenderer("infinite_water_hatch")
            .tooltips(
                    Component.translatable("block.epimorphism.infinite_water_hatch.desc.0"),
                    Component.translatable("block.epimorphism.infinite_water_hatch.desc.1"),
                    Component.translatable("block.epimorphism.infinite_water_hatch.desc.2")
            )
            .register();

    public final static MachineDefinition NEUTRON_SENSOR = EP_REGISTRATE.machine("neutron_sensor", NeutronSensorMachine::new)
            .langValue("Neutron Sensor")
            .tier(GTValues.IV)
            .rotationState(RotationState.ALL)
            .abilities(EPPartAbility.NEUTRON_SENSOR)
            .overlayTieredHullRenderer("neutron_sensor")
            .tooltips(Component.translatable("block.epimorphism.neutron_sensor.desc"))
            .register();

    public static final MachineDefinition[] NEUTRON_ACCELERATOR = registerTieredEPMachines("neutron_accelerator", NeutronAcceleratorMachine::new,
            (tier, builder) -> builder
                    .langValue("%s §rNeutron Accelerator".formatted(VNF[tier]))
                    .rotationState(RotationState.ALL)
                    .abilities(EPPartAbility.NEUTRON_ACCELERATOR)
                    .overlayTieredHullRenderer("neutron_accelerator")
                    .tooltips(
                            Component.translatable("block.epimorphism.neutron_accelerator.desc.0"),
                            Component.translatable("block.epimorphism.neutron_accelerator.desc.1"),
                            Component.translatable("gtceu.universal.tooltip.max_voltage_in", GTValues.V[tier], VNF[tier]),
                            Component.translatable("epimorphism.universal.desc.max_power_consume", Math.round(GTValues.V[tier] * 0.8)),
                            Component.translatable("gtceu.universal.tooltip.energy_storage_capacity", GTValues.V[tier] * 72))
                    .register(),
            ELECTRIC_TIERS);
    public static final MachineDefinition[] RADIATION_HATCH = registerTieredEPMachines("radiation_hatch", RadiationHatchMachine::new,
            (tier, builder) -> builder
                    .langValue("%s §rRadiation Hatch".formatted(VNF[tier]))
                    .rotationState(RotationState.ALL)
                    .abilities(EPPartAbility.RADIATION)
                    .recipeType(EPRecipeTypes.RADIATION_HATCH_RECIPES)
                    .overlayTieredHullRenderer("radiation_hatch")
                    .tooltips(
                            Component.translatable("block.epimorphism.radiation_hatch.desc.0"),
                            Component.translatable("epimorphism.universal.desc.kg_capacity", Math.max(1, tier - 2)),
                            Component.translatable("block.epimorphism.radiation_hatch.desc.1")
                    )
                    .register(),
            GTValues.tiersBetween(3, 13));

//    public static final MachineDefinition[] WIRELESS_ENERGY_INPUT_HATCH = registerTieredEPMachines("wireless_energy_input_hatch",
//            (holder, tier) -> new WirelessEnergyHatchPartMachine(holder, tier, IO.IN, 2),
//            (tier, builder) -> builder
//                    .langValue("%s §rWireless Energy Input Hatch".formatted(VNF[tier]))
//                    .rotationState(RotationState.ALL)
//                    .abilities(PartAbility.INPUT_ENERGY)
//                    .workableTieredHullRenderer(Epimorphism.id("block/multiblock/part/wireless_energy_input_hatch"))
//                    .tooltips(
//                            Component.translatable("block.epimorphism.wireless_energy_input_hatch.desc.0"),
//                            Component.translatable("block.epimorphism.wireless_energy_input_hatch.desc.1"),
//                            Component.translatable("block.epimorphism.wireless_energy_input_hatch.desc.2")
//                    )
//                    .register(),
//            ELECTRIC_TIERS);

//    public static final MachineDefinition[] WIRELESS_ENERGY_OUTPUT_HATCH = registerTieredEPMachines("wireless_energy_output_hatch",
//            (holder, tier) -> new WirelessEnergyHatchPartMachine(holder, tier, IO.OUT, 2),
//            (tier, builder) -> builder
//                    .langValue("%s §rWireless Energy Output Hatch".formatted(VNF[tier]))
//                    .rotationState(RotationState.ALL)
//                    .abilities(PartAbility.OUTPUT_ENERGY)
//                    .workableTieredHullRenderer(Epimorphism.id("block/multiblock/part/wireless_energy_output_hatch"))
//                    .tooltips(
//                            Component.translatable("block.epimorphism.wireless_energy_output_hatch.desc.0"),
//                            Component.translatable("block.epimorphism.wireless_energy_output_hatch.desc.1"),
//                            Component.translatable("block.epimorphism.wireless_energy_output_hatch.desc.2")
//                    )
//                    .register(),
//            ELECTRIC_TIERS);

    // Single Machines
    public final static MachineDefinition INFINITY_CRATE = EP_REGISTRATE.machine("infinity_crate", holder -> new InfinityCrateMachine(holder, EPMaterials.Infinity, 252))
            .langValue("Infinity Crate")
            .rotationState(RotationState.NONE)
            .tooltips(Component.translatable("gtceu.universal.tooltip.item_storage_capacity", 252))
            .tooltips(Component.translatable("block.epimorphism.infinity_crate.desc"))
            .renderer(() -> new TextureOverrideRenderer(new ResourceLocation("block/cube_all"), Map.of("all", Epimorphism.id("block/storage/crates/infinity_crate"))))
            .register();

    public static void init() {/**/}

    private static MachineDefinition[] registerTieredEPMachines(String name,
                                                             BiFunction<IMachineBlockEntity, Integer, MetaMachine> factory,
                                                             BiFunction<Integer, MachineBuilder<MachineDefinition>, MachineDefinition> builder,
                                                             int... tiers) {
        MachineDefinition[] definitions = new MachineDefinition[GTValues.TIER_COUNT];
        for (int tier : tiers) {
            var register = EP_REGISTRATE.machine(GTValues.VN[tier].toLowerCase(Locale.ROOT) + "_" + name, holder -> factory.apply(holder, tier))
                    .tier(tier);
            definitions[tier] = builder.apply(tier, register);
        }
        return definitions;
    }
}
