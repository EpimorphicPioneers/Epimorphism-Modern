package cn.gtcommunity.epimorphism.common.data;

import cn.gtcommunity.epimorphism.Epimorphism;
import cn.gtcommunity.epimorphism.api.machine.multiblock.TierCasingWorkableElectricMultiblockMachine;
import cn.gtcommunity.epimorphism.api.pattern.EPPredicates;
import cn.gtcommunity.epimorphism.api.pattern.LayerShapeInfo;
import cn.gtcommunity.epimorphism.client.renderer.handler.machine.IndustrialGreenhouseRenderer;
import cn.gtcommunity.epimorphism.common.block.BlockMaps;
import cn.gtcommunity.epimorphism.common.machine.multiblock.electric.BacterialCultureTankMachine;
import cn.gtcommunity.epimorphism.common.machine.multiblock.electric.IndustrialGreenhouseMachine;
import cn.gtcommunity.epimorphism.common.machine.multiblock.electric.NeutronActivatorMachine;
import cn.gtcommunity.epimorphism.common.machine.multiblock.part.InfiniteWaterHatchPartMachine;
import cn.gtcommunity.epimorphism.common.machine.multiblock.storage.TFFTMachine;
import cn.gtcommunity.epimorphism.common.machine.multiblock.storage.YottaFluidTankMachine;
import cn.gtcommunity.epimorphism.common.machine.storage.InfinityCrateMachine;
import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.data.RotationState;
import com.gregtechceu.gtceu.api.data.chemical.ChemicalHelper;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.api.machine.MachineDefinition;
import com.gregtechceu.gtceu.api.machine.MultiblockMachineDefinition;
import com.gregtechceu.gtceu.api.machine.multiblock.PartAbility;
import com.gregtechceu.gtceu.api.pattern.FactoryBlockPattern;
import com.gregtechceu.gtceu.api.pattern.MultiblockShapeInfo;
import com.gregtechceu.gtceu.api.pattern.util.RelativeDirection;
import com.gregtechceu.gtceu.client.renderer.block.TextureOverrideRenderer;
import com.gregtechceu.gtceu.common.data.GTBlocks;
import com.gregtechceu.gtceu.common.data.GTMachines;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import com.gregtechceu.gtceu.common.data.GTRecipeTypes;
import com.gregtechceu.gtceu.config.ConfigHolder;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import static cn.gtcommunity.epimorphism.api.registry.EPRegistries.*;
import static com.gregtechceu.gtceu.api.pattern.Predicates.*;

public class EPMachines {
    static {
        EP_REGISTRATE.creativeModeTab(() -> EPCreativeModeTabs.EP_BLOCK);
    }

    // Multiblocks
    public final static MultiblockMachineDefinition YOTTA_FLUID_TANK = EP_REGISTRATE.multiblock("yotta_fluid_tank", YottaFluidTankMachine::new)
            .rotationState(RotationState.NON_Y_AXIS)
            .recipeType(GTRecipeTypes.DUMMY_RECIPES)
            .tooltips(Component.translatable("item.epimorphism.debug.structure_writer.structural_scale"))
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
            .rotationState(RotationState.NON_Y_AXIS)
            .recipeType(GTRecipeTypes.DUMMY_RECIPES)
            .tooltips(Component.translatable("item.epimorphism.debug.structure_writer.structural_scale"))
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
            .rotationState(RotationState.NON_Y_AXIS)
            .recipeType(EPRecipeTypes.NEUTRON_ACTIVATOR_RECIPES)
            .tooltips(Component.translatable("item.epimorphism.debug.structure_writer.structural_scale"))
            .appearanceBlock(GTBlocks.CASING_STAINLESS_CLEAN)
            .pattern(definition -> FactoryBlockPattern.start(RelativeDirection.RIGHT, RelativeDirection.BACK, RelativeDirection.UP)
                    .aisle("AAGAA", "ADDDA", "ADDDA", "ADDDA", "AAAAA")
                    .aisle("B   B", " EEE ", " EFE ", " EEE ", "B   B").setRepeatable(4, 100)
                    .aisle("CCCCC", "CDDDC", "CDDDC", "CDDDC", "CCCCC")
                    .where('G', controller(blocks(definition.getBlock())))
                    .where('A', blocks(GTBlocks.CASING_STAINLESS_CLEAN.get())
                            .or(abilities(PartAbility.EXPORT_FLUIDS))
                            .or(abilities(PartAbility.EXPORT_ITEMS))
                            .or(abilities(PartAbility.MAINTENANCE)))
                    .where('B', frames(GTMaterials.Steel))
                    .where('C', blocks(GTBlocks.CASING_STAINLESS_CLEAN.get())
                            .or(abilities(PartAbility.IMPORT_FLUIDS))
                            .or(abilities(PartAbility.IMPORT_ITEMS)))
                    .where('D', blocks(EPBlocks.YOTTA_FLUID_TANK_CASING.get()))
                    .where('E', blocks(GTBlocks.CASING_LAMINATED_GLASS.get()))
                    .where('F', blocks(EPBlocks.SPEEDING_PIPE.get()))
                    .build()
            )
            .partSorter(Comparator.comparingInt(a -> a.self().getPos().getY()))
            .workableCasingRenderer(GTCEu.id("block/casings/solid/machine_casing_clean_stainless_steel"),
                    Epimorphism.id("block/multiblock/neutron_activator"), false)
            .register();

    public static final MultiblockMachineDefinition EXTREME_INDUSTRIAL_GREENHOUSE = EP_REGISTRATE.multiblock("extreme_industrial_greenhouse", IndustrialGreenhouseMachine::new)
            .rotationState(RotationState.NON_Y_AXIS)
            .recipeType(GTRecipeTypes.DUMMY_RECIPES)
            .tooltips(Component.translatable("item.epimorphism.debug.structure_writer.structural_scale"))
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

//    public final static MultiblockMachineDefinition BACTERIAL_CULTURE_TANK = EPRegistries.EP_REGISTRATE.multiblock("bacterial_culture_tank", BacterialCultureTankMachine::new)
//            .register();

    public final static MultiblockMachineDefinition COMPONENT_ASSEMBLY_LINE = EP_REGISTRATE.multiblock("component_assembly_line", holder -> new TierCasingWorkableElectricMultiblockMachine(holder, "CACasing"))
            .langValue("Component Assembly Line")
            .rotationState(RotationState.ALL)
            .recipeType(EPRecipeTypes.COMPONENT_ASSEMBLY_LINE_RECIPES)
            .tooltips(Component.translatable("item.epimorphism.debug.structure_writer.structural_scale"))
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
                                    .setMaxGlobalLimited(6)
                                    .setPreviewCount(3))
                            .or(abilities(PartAbility.IMPORT_FLUIDS)
                                    .setMaxGlobalLimited(6)
                                    .setPreviewCount(3)))
                    .where('N', frames(GTMaterials.TungstenSteel)
                            .or(abilities(PartAbility.IMPORT_ITEMS)
                                    .setMaxGlobalLimited(2)
                                    .setPreviewCount(0))
                            .or(abilities(PartAbility.IMPORT_FLUIDS)
                                    .setMaxGlobalLimited(2)
                                    .setPreviewCount(0)))
                    .where('K', blocks(EPBlocks.IRIDIUM_CASING.get())
                            .or(abilities(PartAbility.EXPORT_ITEMS)
                                    .setMaxGlobalLimited(3)
                                    .setPreviewCount(1)))
                    .where('L', blocks(EPBlocks.IRIDIUM_CASING.get())
                            .or(abilities(PartAbility.INPUT_ENERGY)
                                    .setMaxGlobalLimited(2)
                                    .setPreviewCount(1)))
                    .where('I', blocks(EPBlocks.IRIDIUM_CASING.get())
                            .or(abilities(PartAbility.MAINTENANCE)
                                    .setExactLimit(1)
                                    .setPreviewCount(1)))
                    .where('M', blocks(EPBlocks.IRIDIUM_CASING.get())
                            .or(abilities(PartAbility.IMPORT_ITEMS)
                                    .setMaxGlobalLimited(6)
                                    .setPreviewCount(0))
                            .or(abilities(PartAbility.IMPORT_FLUIDS)
                                    .setMaxGlobalLimited(6)
                                    .setPreviewCount(0)))
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
                                .where('I', /*() -> ConfigHolder.INSTANCE.machines.enableMaintenance ? */GTMachines.MAINTENANCE_HATCH/* : EPBlocks.IRIDIUM_CASING.get()*/, Direction.SOUTH)
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


    // Multiblock Parts
    public final static MachineDefinition INFINITE_WATER_HATCH = EP_REGISTRATE.machine("infinite_water_hatch", InfiniteWaterHatchPartMachine::new)
            .langValue("Infinite Water Hatch")
            .rotationState(RotationState.ALL)
            .abilities(PartAbility.IMPORT_FLUIDS)
            .overlayTieredHullRenderer("infinite_water_hatch")
            .tooltips(Component.translatable("gtceu.machine.fluid_hatch.export.tooltip"))
            .register();


    // Single Machines
    public final static MachineDefinition INFINITY_CRATE = EP_REGISTRATE.machine("infinity_crate", holder -> new InfinityCrateMachine(holder, EPMaterials.Infinity, 252))
            .langValue("Infinity Crate")
            .rotationState(RotationState.NONE)
            .tooltips(Component.translatable("gtceu.universal.tooltip.item_storage_capacity", 252))
            .tooltips(Component.translatable("block.epimorphism.infinity_crate.tooltip"))
            .renderer(() -> new TextureOverrideRenderer(new ResourceLocation("block/cube_all"), Map.of("all", Epimorphism.id("block/storage/crates/infinity_crate"))))
            .register();

    public static void init() {/**/}
}
