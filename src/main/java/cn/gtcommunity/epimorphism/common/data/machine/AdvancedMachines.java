package cn.gtcommunity.epimorphism.common.data.machine;

import cn.gtcommunity.epimorphism.Epimorphism;
import cn.gtcommunity.epimorphism.api.machine.multiblock.ParallelCoilCasingMultiblockMachine;
import cn.gtcommunity.epimorphism.api.machine.multiblock.ParallelGlassCoilMultiblockMachine;
import cn.gtcommunity.epimorphism.api.machine.multiblock.TierCasingElectricMultiblockMachine;
import cn.gtcommunity.epimorphism.api.pattern.EPPredicates;
import cn.gtcommunity.epimorphism.client.renderer.handler.machine.ProcessingArrayRenderer;
import cn.gtcommunity.epimorphism.common.data.EPMachines;
import cn.gtcommunity.epimorphism.common.data.EPRecipeModifiers;
import cn.gtcommunity.epimorphism.common.machine.multiblock.electric.advanced.*;
import cn.gtcommunity.epimorphism.config.EPConfigHolder;
import com.epimorphismmc.monomorphism.client.renderer.machine.CustomPartRenderer;
import com.epimorphismmc.monomorphism.client.renderer.machine.TierCasingMachineRenderer;
import com.epimorphismmc.monomorphism.machine.multiblock.ParallelCoilMultiblockMachine;
import com.epimorphismmc.monomorphism.pattern.FactoryMOPattern;
import com.epimorphismmc.monomorphism.pattern.MOBlockPattern;
import com.epimorphismmc.monomorphism.pattern.MOPredicates;
import com.epimorphismmc.monomorphism.pattern.utils.StructureUtil;
import com.epimorphismmc.monomorphism.utility.MOMathUtils;
import com.google.common.primitives.Ints;
import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.data.RotationState;
import com.gregtechceu.gtceu.api.data.chemical.ChemicalHelper;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.api.machine.MultiblockMachineDefinition;
import com.gregtechceu.gtceu.api.machine.multiblock.CoilWorkableElectricMultiblockMachine;
import com.gregtechceu.gtceu.api.machine.multiblock.PartAbility;
import com.gregtechceu.gtceu.api.pattern.FactoryBlockPattern;
import com.gregtechceu.gtceu.api.pattern.MultiblockShapeInfo;
import com.gregtechceu.gtceu.api.pattern.Predicates;
import com.gregtechceu.gtceu.api.recipe.OverclockingLogic;
import com.gregtechceu.gtceu.client.renderer.machine.LargeMinerRenderer;
import com.gregtechceu.gtceu.common.data.*;
import com.gregtechceu.gtceu.utils.FormattingUtil;
import com.gregtechceu.gtceu.utils.GTUtil;
import net.minecraft.ChatFormatting;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.phys.shapes.Shapes;
import org.joml.Math;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static cn.gtcommunity.epimorphism.Epimorphism.registrate;
import static cn.gtcommunity.epimorphism.api.pattern.EPPredicates.*;
import static cn.gtcommunity.epimorphism.common.block.BlockMaps.*;
import static cn.gtcommunity.epimorphism.common.data.EPBlocks.*;
import static cn.gtcommunity.epimorphism.common.data.EPMaterials.*;
import static cn.gtcommunity.epimorphism.common.data.EPRecipeTypes.*;
import static com.epimorphismmc.monomorphism.block.MOBlockMaps.*;
import static com.epimorphismmc.monomorphism.pattern.MOPredicates.coilBlock;
import static com.gregtechceu.gtceu.api.GTValues.*;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.*;
import static com.gregtechceu.gtceu.api.machine.multiblock.PartAbility.*;
import static com.gregtechceu.gtceu.api.pattern.Predicates.*;
import static com.gregtechceu.gtceu.common.data.GCyMBlocks.*;
import static com.gregtechceu.gtceu.common.data.GTBlocks.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.*;

public class AdvancedMachines {
    public final static MultiblockMachineDefinition[] PROCESSING_ARRAY = EPConfigHolder.INSTANCE.machines.doProcessingArray ? EPMachines.registerTieredEPMultis("ep_processing_array", ProcessingArrayMachine::new,
            (tier, builder) -> builder
                    .langValue(VNF[tier] + " Processing Array")
                    .rotationState(RotationState.NON_Y_AXIS)
                    .blockProp(p -> p.noOcclusion().isViewBlocking((state, level, pos) -> false))
                    .shape(Shapes.box(0.001, 0.001, 0.001, 0.999, 0.999, 0.999))
                    .appearanceBlock(() -> ProcessingArrayMachine.getCasingState(tier))
                    .recipeType(DUMMY_RECIPES)
                    .recipeModifier(ProcessingArrayMachine::recipeModifier, true)
                    .pattern(definition -> FactoryBlockPattern.start()
                            .aisle("XXX", "CCC", "XXX")
                            .aisle("XXX", "C#C", "XXX")
                            .aisle("XSX", "CCC", "XXX")
                            .where('S', Predicates.controller(blocks(definition.getBlock())))
                            .where('X', blocks(ProcessingArrayMachine.getCasingState(tier)).setMinGlobalLimited(4)
                                    .or(Predicates.abilities(PartAbility.IMPORT_ITEMS))
                                    .or(Predicates.abilities(PartAbility.EXPORT_ITEMS))
                                    .or(Predicates.abilities(PartAbility.IMPORT_FLUIDS))
                                    .or(Predicates.abilities(PartAbility.EXPORT_FLUIDS))
                                    .or(Predicates.abilities(PartAbility.INPUT_ENERGY))
                                    .or(Predicates.abilities(PartAbility.OUTPUT_ENERGY))
                                    .or(Predicates.autoAbilities(true, false, false)))
                            .where('C', blocks(CLEANROOM_GLASS.get()))
                            .where('#', Predicates.air())
                            .build())
                    .tooltips(Component.translatable("gtceu.universal.tooltip.parallel", ProcessingArrayMachine.getMachineLimit(tier)))
                    .renderer(() -> new ProcessingArrayRenderer(tier == IV ?
                            GTCEu.id("block/casings/solid/machine_casing_robust_tungstensteel") :
                            GTCEu.id("block/casings/solid/machine_casing_sturdy_hsse"),
                            Epimorphism.id("block/multiblock/processing_array")))
                    .register(),
            IV, LuV) : null;
    public final static MultiblockMachineDefinition COMPONENT_ASSEMBLY_LINE = registrate().multiblock("component_assembly_line", holder -> new TierCasingElectricMultiblockMachine(holder, "CACasing"))
            .langValue("Component Assembly Line")
            .tooltips(
                    Component.translatable("block.epimorphism.component_assembly_line.desc.0"),
                    Component.translatable("block.epimorphism.component_assembly_line.desc.1"),
                    Component.translatable("block.epimorphism.component_assembly_line.desc.2"),
                    Component.translatable("block.epimorphism.component_assembly_line.desc.3")
            )
            .rotationState(RotationState.ALL)
            .recipeType(COMPONENT_ASSEMBLY_LINE_RECIPES)
            .appearanceBlock(IRIDIUM_CASING)
            .pattern(definition -> FactoryMOPattern.start()
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
                    .where('A', blocks(OSMIR_BORON_SILICATE_GLASS.get()))
                    .where('H', blocks(IRIDIUM_CASING.get()))
                    .where('C', blocks(CASING_ASSEMBLY_LINE.get()))
                    .where('D', frames(MARM200Steel))
                    .where('G', blocks(CASING_POLYBENZIMIDAZOLE_PIPE.get()))
                    .where('E', blocks(ADVANCED_FILTER_CASING.get()))
                    .where('B', EPPredicates.componentAssemblyBlock())
                    .where('J', blocks(IRIDIUM_CASING.get())
                            .or(abilities(PartAbility.IMPORT_ITEMS)
                                    .setMaxGlobalLimited(6))
                            .or(abilities(PartAbility.IMPORT_FLUIDS)
                                    .setMaxGlobalLimited(6)))
                    .where('N', frames(GTMaterials.TungstenSteel)
                            .or(abilities(PartAbility.IMPORT_ITEMS)
                                    .setMaxGlobalLimited(2))
                            .or(abilities(PartAbility.IMPORT_FLUIDS)
                                    .setMaxGlobalLimited(2)))
                    .where('K', blocks(IRIDIUM_CASING.get())
                            .or(abilities(PartAbility.EXPORT_ITEMS)
                                    .setMaxGlobalLimited(3)
                                    .setPreviewCount(1)))
                    .where('L', blocks(IRIDIUM_CASING.get())
                            .or(abilities(PartAbility.INPUT_ENERGY)
                                    .setMaxGlobalLimited(2)))
                    .where('I', blocks(IRIDIUM_CASING.get())
                            .or(abilities(PartAbility.MAINTENANCE)
                                    .setExactLimit(1)))
                    .where('M', blocks(IRIDIUM_CASING.get())
                            .or(abilities(PartAbility.IMPORT_ITEMS)
                                    .setMaxGlobalLimited(6))
                            .or(abilities(PartAbility.IMPORT_FLUIDS)
                                    .setMaxGlobalLimited(6)))
                    .where('n', frames(GTMaterials.TungstenSteel))
                    .build()
            )
            .shapeInfos(definition -> new ArrayList<>(StructureUtil.getMatchingShapes((MOBlockPattern) definition.getPatternFactory().get(), ALL_CA_TIRED_CASINGS.size())))
            .partSorter(Comparator.comparingInt(a -> a.self().getPos().getY()))
            .workableCasingRenderer(Epimorphism.id("block/casings/solid/iridium_casing"),
                    Epimorphism.id("block/multiblock/component_assembly_line"), false)
            .register();
    public final static MultiblockMachineDefinition PRECISE_ASSEMBLER = registrate().multiblock("precise_assembler", PreciseAssemblerMachine::new)
            .langValue("Precise Assembler")
            .tooltips(
                    Component.translatable("block.epimorphism.precise_assembler.desc.0"),
                    Component.translatable("block.epimorphism.precise_assembler.desc.1"),
                    Component.translatable("block.epimorphism.precise_assembler.desc.2"),
                    Component.translatable("block.epimorphism.precise_assembler.desc.3"),
                    Component.translatable("block.epimorphism.precise_assembler.desc.4"))
            .rotationState(RotationState.NON_Y_AXIS)
            .recipeTypes(ASSEMBLER_RECIPES, PRECISE_ASSEMBLER_RECIPES)
            .recipeModifiers(EPRecipeModifiers.EP_PARALLEL, GTRecipeModifiers.ELECTRIC_OVERCLOCK.apply(OverclockingLogic.NON_PERFECT_OVERCLOCK))
            .appearanceBlock(PRECISE_ASSEMBLER_CASING_MK1)
            .pattern(definition -> FactoryMOPattern.start()
                    .aisle("DDDDDDDDD", "F       F", "F       F", "F       F", "DDDDDDDDD")
                    .aisle("CMMMMMMMC", "CGGGGGGGC", "CGGGGGGGC", "CGGGGGGGC", "DDDDDDDDD")
                    .aisle("CMMMMMMMC", "C       C", "C       C", "C       C", "DDDDDDDDD")
                    .aisle("CMMMMMMMC", "CGGGGGGGC", "CGGGGGGGC", "CGGGGGGGC", "DDDDDDDDD")
                    .aisle("DDDDSDDDD", "F       F", "F       F", "F       F", "DDDDDDDDD")
                    .where('S', controller(blocks(definition.get())))
                    .where('C', EPPredicates.PACasingBlock())
                    .where('D', EPPredicates.PACasingBlock().setMinGlobalLimited(42)
                            .or(autoAbilities(definition.getRecipeTypes()))
                            .or(autoAbilities(true, true, false)))
                    .where('F', frames(MARM200Steel))
                    .where('G', blocks(CASING_LAMINATED_GLASS.get()))
                    .where('M', MOPredicates.machineCasingBlock())
                    .build()
            )
            .shapeInfos(definition -> {
                ArrayList<MultiblockShapeInfo> shapeInfos = new ArrayList<>();
                int maxLength = Ints.max(ALL_PA_CASINGS.size(), ALL_MACHINE_CASINGS.size());
                shapeInfos.addAll(StructureUtil.getMatchingShapes((MOBlockPattern) definition.getPatternFactory().get(), maxLength));
                return shapeInfos;
            })
            .partSorter(Comparator.comparingInt(a -> a.self().getPos().getY()))
            .renderer(() -> new TierCasingMachineRenderer(Epimorphism.id("block/casings/solid/precise_assembler_casing_mk1"),
                    Epimorphism.id("block/multiblock/precise_assembler"), PreciseAssemblerMachine::locationGetter))
            .register();
    public final static MultiblockMachineDefinition GENERAL_PROCESSING_PLANT = registrate().multiblock("general_processing_plant", GeneralProcessingPlantMachine::new)
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
            .recipeModifiers(EPRecipeModifiers.EP_PARALLEL, GTRecipeModifiers.ELECTRIC_OVERCLOCK.apply(OverclockingLogic.NON_PERFECT_OVERCLOCK))
            .appearanceBlock(MARAGING_STEEL_CASING)
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
                    .where('C', blocks(MARAGING_STEEL_CASING.get())
                            .or(abilities(PartAbility.IMPORT_ITEMS))
                            .or(abilities(PartAbility.EXPORT_ITEMS))
                            .or(abilities(PartAbility.IMPORT_FLUIDS))
                            .or(abilities(PartAbility.EXPORT_FLUIDS))
                            .or(abilities(PartAbility.MAINTENANCE).setExactLimit(1)))
                    .where('G', blocks(MARAGING_STEEL_CASING.get()))
                    .where('E', blocks(MARAGING_STEEL_CASING.get()).or(abilities(PartAbility.INPUT_ENERGY).setMinGlobalLimited(1)))
                    .where('B', blocks(CASING_STEEL_GEARBOX.get()))
                    .where('P', blocks(GENERAL_PROCESSING_CASING.get()))
                    .where('L', blocks(ADVANCED_SUBSTRATE_CASING.get()))
                    .where('T', blocks(CASING_LAMINATED_GLASS.get()))
                    .where('F', frames(MaragingSteel250))
                    .build()
            )
            .shapeInfo(definition -> MultiblockShapeInfo.builder()
                    .aisle("AAHSCDM", "       ", "       ", "       ", "       ", "       ")
                    .aisle("GGGGGGG", "F     F", "F     F", "F     F", "F     F", "GGGEGGG")
                    .aisle("GGGGGGG", " PTTTP ", " PTTTP ", " PTTTP ", " PTTTP ", "GGGGGGG")
                    .aisle("GGGGGGG", " TB BT ", " T   T ", " T   T ", " T   T ", "GGGGGGG")
                    .aisle("GGGGGGG", " T L T ", " T   T ", " T B T ", " T B T ", "GGGGGGG")
                    .aisle("GGGGGGG", " TB BT ", " T   T ", " T   T ", " T   T ", "GGGGGGG")
                    .aisle("GGGGGGG", " PTTTP ", " PTTTP ", " PTTTP ", " PTTTP ", "GGGGGGG")
                    .aisle("GGGGGGG", "F     F", "F     F", "F     F", "F     F", "GGGGGGG")
                    .where('S', definition, Direction.NORTH)
                    .where('A', GTMachines.ITEM_IMPORT_BUS[4], Direction.NORTH)
                    .where('H', GTMachines.ITEM_EXPORT_BUS[4], Direction.NORTH)
                    .where('C', GTMachines.FLUID_IMPORT_HATCH[4], Direction.NORTH)
                    .where('D', GTMachines.FLUID_EXPORT_HATCH[4], Direction.NORTH)
                    .where('M', GTMachines.MAINTENANCE_HATCH, Direction.NORTH)
                    .where('G', MARAGING_STEEL_CASING.get())
                    .where('E', GTMachines.ENERGY_INPUT_HATCH[4], Direction.NORTH)
                    .where('B', CASING_STEEL_GEARBOX.get())
                    .where('P', GENERAL_PROCESSING_CASING.get())
                    .where('L', ADVANCED_SUBSTRATE_CASING.get())
                    .where('T', CASING_LAMINATED_GLASS.get())
                    .where('F', ChemicalHelper.getBlock(frameGt, MaragingSteel250)).build())
            .partSorter(Comparator.comparingInt(a -> a.self().getPos().getY()))
            .workableCasingRenderer(Epimorphism.id("block/casings/solid/maraging_steel_250_casing"),
                    Epimorphism.id("block/multiblock/general_processing_plant"), false)
            .register();
    public final static MultiblockMachineDefinition MEGA_CHEMICAL_REACTOR = registrate().multiblock("mega_chemical_reactor",
                    blockEntity -> new ParallelCoilMultiblockMachine(blockEntity, machine -> machine.getCoilTier() * 4))
            .langValue("Mega Chemical Reactor")
            .tooltips(Component.translatable("block.epimorphism.mega_chemical_reactor.desc.0"))
            .rotationState(RotationState.NON_Y_AXIS)
            .recipeType(LARGE_CHEMICAL_RECIPES)
            .appearanceBlock(CASING_PTFE_INERT)
            .pattern(definition -> FactoryMOPattern.start()
                    .aisle("X   X", "XXXXX", "X   X", "XXXXX", "X   X")
                    .aisle("XXXXX", "XCCCX", "XCCCX", "XCCCX", "XXXXX")
                    .aisle("X   X", "XPPPX", "XHHHX", "XPPPX", "X   X")
                    .aisle("XXXXX", "XCCCX", "XCCCX", "XCCCX", "XXXXX")
                    .aisle("X   X", "SXXXX", "X   X", "XXXXX", "X   X")
                    .where('S', controller(blocks(definition.get())))
                    .where('P', blocks(CASING_POLYTETRAFLUOROETHYLENE_PIPE.get()))
                    .where('C', coilBlock())
                    .where('H', blocks(HEAT_VENT.get()))
                    .where('X', blocks(CASING_PTFE_INERT.get())
                            .setMinGlobalLimited(50)
                            .or(autoAbilities(definition.getRecipeTypes()))
                            .or(autoAbilities(true, false, false)))
                    .build()
            )
            .shapeInfos(definition -> new ArrayList<>(StructureUtil.getMatchingShapes((MOBlockPattern) definition.getPatternFactory().get(), ALL_COIL_BLOCKS.size())))
            .partSorter(Comparator.comparingInt(a -> a.self().getPos().getY()))
            .workableCasingRenderer(GTCEu.id("block/casings/solid/machine_casing_inert_ptfe"),
                    Epimorphism.id("block/multiblock/mega_chemical_reactor"), false)
            .register();
    public final static MultiblockMachineDefinition MEGA_CRACKING_UNIT = registrate().multiblock("mega_cracking_unit",
                    blockEntity -> new ParallelGlassCoilMultiblockMachine(blockEntity, machine -> machine.getCoilTier() * 4))
            .langValue("Mega Oil Cracking Unit")
            .tooltips(Component.translatable("block.epimorphism.mega_cracking_unit.desc.0"))
            .rotationState(RotationState.NON_Y_AXIS)
            .recipeType(CRACKING_RECIPES)
            .appearanceBlock(CASING_STAINLESS_CLEAN)
            .pattern(definition -> FactoryMOPattern.start()
                    .aisle("CCCCCCCCCCCCC", " C         C ", " C         C ", " C         C ", " C         C ", " C         C ", " C         C ")
                    .aisle("CCCCCCCCCCCCC", "CCGGGGGGGGGCC", "CCGGGGGGGGGCC", "CCGGGGGGGGGCC", "CCGGGGGGGGGCC", "CCGGGGGGGGGCC", "CCGGGGGGGGGCC")
                    .aisle("CCCCCCCCCCCCC", " GALALALALAG ", " GALALALALAG ", " GALALALALAG ", " GALALALALAG ", " GALALALALAG ", " CGGGGGGGGGC ")
                    .aisle("CCCCCCCCCCCCC", " GALALALALAG ", " EAAAAAAAAAD ", " EALALALALAD ", " EAAAAAAAAAD ", " GALALALALAG ", " CGGGEEEGGGC ")
                    .aisle("CCCCCCCCCCCCC", " GALALALALAG ", " EALALALALAD ", " EALALALALAD ", " EALALALALAD ", " GALALALALAG ", " CGGGEEEGGGC ")
                    .aisle("CCCCCCCCCCCCC", " GALALALALAG ", " EAAAAAAAAAD ", " EALALALALAD ", " EAAAAAAAAAD ", " GALALALALAG ", " CGGGEEEGGGC ")
                    .aisle("CCCCCCCCCCCCC", " GALALALALAG ", " GALALALALAG ", " GALALALALAG ", " GALALALALAG ", " GALALALALAG ", " CGGGGGGGGGC ")
                    .aisle("CCCCCCCCCCCCC", "CCGGGGGGGGGCC", "CCGGGGGGGGGCC", "CCGGGGGGGGGCC", "CCGGGGGGGGGCC", "CCGGGGGGGGGCC", "CCGGGGGGGGGCC")
                    .aisle("CCCCCCSCCCCCC", " C         C ", " C         C ", " C         C ", " C         C ", " C         C ", " C         C ")
                    .where('S', controller(blocks(definition.getBlock())))
                    .where('C', blocks(CASING_STAINLESS_CLEAN.get()).setMinGlobalLimited(190)
                            .or(abilities(PartAbility.IMPORT_ITEMS))
                            .or(abilities(PartAbility.INPUT_ENERGY))
                            .or(abilities(PartAbility.MAINTENANCE)))
                    .where('G', EPPredicates.glass())
                    .where('L', coilBlock())
                    .where('D', blocks(CASING_STAINLESS_CLEAN.get())
                            .or(abilities(PartAbility.EXPORT_FLUIDS)))
                    .where('E', blocks(CASING_STAINLESS_CLEAN.get())
                            .or(abilities(PartAbility.IMPORT_FLUIDS)))
                    .where(' ', any())
                    .where('A', air())
                    .build()
            )
            .shapeInfos(definition -> {
                ArrayList<MultiblockShapeInfo> shapeInfos = new ArrayList<>();
                int maxLeng = Ints.max(SHAPE_GLASSES.size(), ALL_COIL_BLOCKS.size());
                shapeInfos.addAll(StructureUtil.getMatchingShapes((MOBlockPattern) definition.getPatternFactory().get(), maxLeng));
                return shapeInfos;
            })
            .partSorter(Comparator.comparingInt(a -> a.self().getPos().getY()))
            .workableCasingRenderer(GTCEu.id("block/casings/solid/machine_casing_clean_stainless_steel"),
                    Epimorphism.id("block/multiblock/mega_cracking_unit"), false)
            .register();
    public final static MultiblockMachineDefinition MEGA_ALLOY_BLAST_SMELTER = registrate().multiblock("mega_alloy_blast_smelter",
                    blockEntity -> new ParallelGlassCoilMultiblockMachine(blockEntity, machine -> machine.getCoilTier() * 4))
            .langValue("Mega Alloy Blast Smelter")
            .tooltips(Component.translatable("block.epimorphism.mega_alloy_blast_smelter.desc.0"))
            .rotationState(RotationState.NON_Y_AXIS)
            .recipeType(GCyMRecipeTypes.ALLOY_BLAST_RECIPES)
            .appearanceBlock(GCyMBlocks.CASING_HIGH_TEMPERATURE_SMELTING)
            .pattern(definition -> FactoryMOPattern.start()
                    .aisle("   BBBBB   ", "   CCCCC   ", "   CCCCC   ", "   CCCCC   ", "   BBBBB   ", "           ", "           ", "           ", "           ", "           ", "           ", "           ", "           ", "           ", "           ", "           ", "           ", "           ", "           ", "           ")
                    .aisle("  BDDDDDB  ", "  G     G  ", "  G     G  ", "  G     G  ", "  BDDDDDB  ", "   DDDDD   ", "   GGGGG   ", "   GGGGG   ", "   GGGGG   ", "   GGGGG   ", "   GGGGG   ", "   GGGGG   ", "   GGGGG   ", "   GGGGG   ", "   GGGGG   ", "   GGGGG   ", "   GGGGG   ", "   DDDDD   ", "   DDDDD   ", "           ")
                    .aisle(" BDDHHHDDB ", " G       G ", " G       G ", " G       G ", " BDDHHHDDB ", "  DWWWWWD  ", "  GWWWWWG  ", "  GWWWWWG  ", "  GWWWWWG  ", "  GWWWWWG  ", "  GWWWWWG  ", "  GWWWWWG  ", "  GWWWWWG  ", "  GWWWWWG  ", "  GWWWWWG  ", "  GWWWWWG  ", "  GWWWWWG  ", "  DWWWWWD  ", "  DWWWWWD  ", "   DDDDD   ")
                    .aisle("BDDDDDDDDDB", "C  VWWWV  C", "C  VBBBV  C", "C  VWWWV  C", "BDDVDDDVDDB", " DW     WD ", " GW     WG ", " GW     WG ", " GW     WG ", " GW     WG ", " GW     WG ", " GW     WG ", " GW     WG ", " GW     WG ", " GW     WG ", " GW     WG ", " GW     WG ", " DW     WD ", " DW     WD ", "  DDDDDDD  ")
                    .aisle("BDHDDDDDHDB", "C  W   W  C", "C  B   B  C", "C  W   W  C", "BDHD   DHDB", " DW     WD ", " GW     WG ", " GW     WG ", " GW     WG ", " GW     WG ", " GW     WG ", " GW     WG ", " GW     WG ", " GW     WG ", " GW     WG ", " GW     WG ", " GW     WG ", " DW     WD ", " DW     WD ", "  DDDDDDD  ")
                    .aisle("BDHDDDDDHDB", "C  W   W  C", "C  B   B  C", "C  W   W  C", "BDHD   DHDB", " DW     WD ", " GW     WG ", " GW     WG ", " GW     WG ", " GW     WG ", " GW     WG ", " GW     WG ", " GW     WG ", " GW     WG ", " GW     WG ", " GW     WG ", " GW     WG ", " DW     WD ", " DW     WD ", "  DDDMDDD  ")
                    .aisle("BDHDDDDDHDB", "C  W   W  C", "C  B   B  C", "C  W   W  C", "BDHD   DHDB", " DW     WD ", " GW     WG ", " GW     WG ", " GW     WG ", " GW     WG ", " GW     WG ", " GW     WG ", " GW     WG ", " GW     WG ", " GW     WG ", " GW     WG ", " GW     WG ", " DW     WD ", " DW     WD ", "  DDDDDDD  ")
                    .aisle("BDDDDDDDDDB", "C  VWWWV  C", "C  VBBBV  C", "C  VWWWV  C", "BDDVDDDVDDB", " DW     WD ", " GW     WG ", " GW     WG ", " GW     WG ", " GW     WG ", " GW     WG ", " GW     WG ", " GW     WG ", " GW     WG ", " GW     WG ", " GW     WG ", " GW     WG ", " DW     WD ", " DW     WD ", "  DDDDDDD  ")
                    .aisle(" BDDHHHDDB ", " G       G ", " G       G ", " G       G ", " BDDHHHDDB ", "  DWWWWWD  ", "  GWWWWWG  ", "  GWWWWWG  ", "  GWWWWWG  ", "  GWWWWWG  ", "  GWWWWWG  ", "  GWWWWWG  ", "  GWWWWWG  ", "  GWWWWWG  ", "  GWWWWWG  ", "  GWWWWWG  ", "  GWWWWWG  ", "  DWWWWWD  ", "  DWWWWWD  ", "   DDDDD   ")
                    .aisle("  BDDDDDB  ", "  G     G  ", "  G     G  ", "  G     G  ", "  BDDDDDB  ", "   DDDDD   ", "   GGGGG   ", "   GGGGG   ", "   GGGGG   ", "   GGGGG   ", "   GGGGG   ", "   GGGGG   ", "   GGGGG   ", "   GGGGG   ", "   GGGGG   ", "   GGGGG   ", "   GGGGG   ", "   DDDDD   ", "   DDDDD   ", "           ")
                    .aisle("   BBBBB   ", "   CCCCC   ", "   CCSCC   ", "   CCCCC   ", "   BBBBB   ", "           ", "           ", "           ", "           ", "           ", "           ", "           ", "           ", "           ", "           ", "           ", "           ", "           ", "           ", "           ")
                    .where('S', controller(blocks(definition.getBlock())))
                    .where('B', blocks(GCyMBlocks.HEAT_VENT.get()))
                    .where('D', blocks(GCyMBlocks.CASING_HIGH_TEMPERATURE_SMELTING.get()))
                    .where('G', EPPredicates.glass())
                    .where('H', blocks(GCyMBlocks.HEAT_VENT.get()))
                    .where('V', blocks(CASING_TUNGSTENSTEEL_PIPE.get()))
                    .where('W', coilBlock())
                    .where('C', blocks(GCyMBlocks.CASING_HIGH_TEMPERATURE_SMELTING.get()).setMinGlobalLimited(15)
                            .or(autoAbilities(definition.getRecipeTypes()))
                            .or(autoAbilities(true, false, false)))
                    .where('M', abilities(MUFFLER))
                    .where(' ', any())
                    .build()
            )
            .shapeInfos(definition -> {
                int maxLeng = Ints.max(ALL_COIL_BLOCKS.size(), SHAPE_GLASSES.size());
                return new ArrayList<>(StructureUtil.getMatchingShapes((MOBlockPattern) definition.getPatternFactory().get(), maxLeng));
            })
            .partSorter(Comparator.comparingInt(a -> a.self().getPos().getY()))
            .workableCasingRenderer(GTCEu.id("block/casings/gcym/high_temperature_smelting_casing"),
                    Epimorphism.id("block/multiblock/mega_alloy_blast_smelter"), false)
            .register();
    public final static MultiblockMachineDefinition ADVANCED_ELECTRIC_BLAST_FURNACE = registrate().multiblock("advanced_electric_blast_furnace", AdvancedEBFMachine::new)
            .langValue("Advanced Electric Blast Furnace")
            .tooltips(Component.translatable("gtceu.machine.electric_blast_furnace.tooltip.1"),
                    Component.translatable("gtceu.machine.electric_blast_furnace.tooltip.2")

            )
            .rotationState(RotationState.NON_Y_AXIS)
            .recipeType(BLAST_RECIPES)
            .recipeModifiers(EPRecipeModifiers.EP_PARALLEL, AdvancedEBFMachine::advEBFOverclock)
            .appearanceBlock(ADVANCED_INVAR_CASING)
            .pattern(definition -> FactoryMOPattern.start()
                    .aisle("XXX", "CCC", "CCC", "XXX")
                    .aisle("XXX", "C#C", "C#C", "XMX")
                    .aisle("XSX", "CCC", "CCC", "XXX")
                    .where('S', controller(blocks(definition.getBlock())))
                    .where('X', blocks(ADVANCED_INVAR_CASING.get()).setMinGlobalLimited(9)
                            .or(autoAbilities(definition.getRecipeTypes()))
                            .or(autoAbilities(true, false, false)))
                    .where('M', abilities(MUFFLER))
                    .where('C', coilBlock())
                    .where('#', air())
                    .build()
            )
            .shapeInfos(definition -> {
                List<MultiblockShapeInfo> shapeInfos = new ArrayList<>();
                shapeInfos.addAll(StructureUtil.getMatchingShapes((MOBlockPattern) definition.getPatternFactory().get(), ALL_COIL_BLOCKS.size()));
                return shapeInfos;
            })
            .recoveryItems(() -> new ItemLike[]{GTItems.MATERIAL_ITEMS.get(TagPrefix.dustTiny, GTMaterials.Ash).get()})
            .workableCasingRenderer(Epimorphism.id("block/casings/solid/advanced_invar_casing"),
                    Epimorphism.id("block/multiblock/advanced_electric_blast_furnace"), false)
            .additionalDisplay((controller, components) -> {
                if (controller instanceof CoilWorkableElectricMultiblockMachine coilMachine && controller.isFormed()) {
                    components.add(Component.translatable("gtceu.multiblock.blast_furnace.max_temperature",
                            Component.translatable(FormattingUtil.formatNumbers(coilMachine.getCoilType().getCoilTemperature() + 100L * Math.max(0, coilMachine.getTier() - MV)) + "K").setStyle(Style.EMPTY.withColor(ChatFormatting.RED))));
                }
            })
            .register();
    public final static MultiblockMachineDefinition INDUSTRIAL_VACUUM_FREEZER = registrate().multiblock("industrial_vacuum_freezer", IndustrialFreezerMachine::new)
            .langValue("Industrial Vacuum Freezer")
            .tooltips(
                    Component.translatable("block.epimorphism.industrial_vacuum_freezer.desc.0")
            )
            .rotationState(RotationState.NON_Y_AXIS)
            .recipeType(VACUUM_RECIPES)
            .recipeModifiers(EPRecipeModifiers.EP_PARALLEL, GTRecipeModifiers.ELECTRIC_OVERCLOCK.apply(OverclockingLogic.NON_PERFECT_OVERCLOCK))
            .appearanceBlock(ADVANCED_ALUMINIUM_CASING)
            .pattern(definition -> FactoryBlockPattern.start()
                    .aisle("XXX", "XXX", "XXX")
                    .aisle("XXX", "X#X", "XXX")
                    .aisle("XXX", "XSX", "XXX")
                    .where('S', Predicates.controller(blocks(definition.getBlock())))
                    .where('X', blocks(ADVANCED_ALUMINIUM_CASING.get()).setMinGlobalLimited(14)
                            .or(Predicates.autoAbilities(definition.getRecipeTypes()))
                            .or(Predicates.autoAbilities(true, false, false)))
                    .where('#', Predicates.air())
                    .build())
            .workableCasingRenderer(Epimorphism.id("block/casings/solid/advanced_aluminium_casing"),
                    Epimorphism.id("block/multiblock/industrial_vacuum_freezer"), false)
            .register();
    public final static MultiblockMachineDefinition COKING_TOWER = registrate().multiblock("coking_tower",
                    blockEntity -> new ParallelCoilCasingMultiblockMachine(blockEntity, "Firebox", machine -> machine.getCoilTier() * 4))
            .langValue("Coking Tower")
            .tooltips(Component.translatable("block.epimorphism.industrial_coke_oven.desc.0"))
            .rotationState(RotationState.NON_Y_AXIS)
            .recipeType(PYROLYSE_RECIPES)
            .appearanceBlock(CASING_STEEL_SOLID)
            .pattern(definition -> FactoryMOPattern.start()
                    .aisle("F   F", "FCCCF", "CCCCC", " CCC ", "     ", "     ", "     ", "     ", "     ")
                    .aisle(" DDD ", "CHHHC", "C###C", "CHHHC", " ccc ", "  c  ", "  c  ", "  c  ", "  c  ")
                    .aisle(" DDD ", "CHPHC", "V#P#V", "CHPHC", " cPc ", " cPc ", " cPc ", " cPc ", " cOc ")
                    .aisle(" DDD ", "CHHHC", "C###C", "CHHHC", " ccc ", "  c  ", "  c  ", "  c  ", "  c  ")
                    .aisle("F   F", "FCCCF", "CCSCC", " CCC ", "     ", "     ", "     ", "     ", "     ")

                    .where('S', controller(blocks(definition.get())))
                    .where('C', blocks(CASING_STEEL_SOLID.get()).setMinGlobalLimited(30)
                            .or(autoAbilities(definition.getRecipeTypes()))
                            .or(autoAbilities(true, false, false)))
                    .where('c', blocks(CASING_STEEL_SOLID.get()))
                    .where('F', frames(HSLASteel))
                    .where('D', fireboxBlock())
                    .where('V', blocks(HEAT_VENT.get()))
                    .where('P', blocks(CASING_STEEL_PIPE.get()))
                    .where('H', coilBlock())
                    .where('O', abilities(MUFFLER))
                    .where('#', air())
                    .where(' ', any())
                    .build()
            )
            .shapeInfos(definition -> {
                int maxLeng = Ints.max(ALL_FIREBOXS.size(), ALL_COIL_BLOCKS.size());
                return new ArrayList<>(StructureUtil.getMatchingShapes((MOBlockPattern) definition.getPatternFactory().get(), maxLeng));
            })
            .partSorter(Comparator.comparingInt(a -> a.self().getPos().getY()))
            .workableCasingRenderer(GTCEu.id("block/casings/solid/machine_casing_solid_steel"),
                    Epimorphism.id("block/multiblock/coking_tower"), false)
            .register();

    public final static MultiblockMachineDefinition INTEGRATED_ORE_FACTORY = registrate().multiblock("integrated_ore_factory", IntegratedOreFactoryMachine::new)
            .langValue("Integrated Ore Factory")
            .tooltips(
                    Component.translatable("block.epimorphism.integrated_ore_factory.desc.0")
            )
            .rotationState(RotationState.NON_Y_AXIS)
            .recipeType(DUMMY_RECIPES)
            .recipeModifier(GTRecipeModifiers.ELECTRIC_OVERCLOCK.apply(OverclockingLogic.NON_PERFECT_OVERCLOCK))
            .appearanceBlock(CASING_STAINLESS_CLEAN)
            .pattern(definition -> FactoryBlockPattern.start()
                    .aisle("EEEEEE     ", "IGGGGI     ", "IGGGGI     ", "IGGGGI     ", "IGGGGI     ", "IIIIII     ", "           ", "           ", "           ", "           ", "           ", "           ")
                    .aisle("EEEEEEEEEEE", "GT  T ICCCI", "GT  T ICCCI", "GT  T ICCCI", "GT  T ICCCI", "IOOOOIICCCI", "       CCC ", "       CCC ", "       CCC ", "       CCC ", "       CCC ", "           ")
                    .aisle("EEEEEEEEEEE", "G XX  C   D", "G XX  CPPPD", "G XX  C   C", "G XX  CPPPC", "IOOOOIC   C", "      CPPPC", "      C   C", "      CPPPC", "      C   C", "      CPPPC", "       WWW ")
                    .aisle("EEEEEEEEEEE", "G XX  C   D", "G XX  CPPPD", "G XX  C   C", "G XX  CPPPC", "IOOOOIC   C", "      CPPPC", "      C   C", "      CPPPC", "      C   C", "      CPPPC", "       WWW ")
                    .aisle("EEEEEEEEEEE", "GT  T ICCCI", "GT  T ICSCI", "GT  T ICCCI", "GT  T ICCCI", "IOOOOIICCCI", "       CCC ", "       CCC ", "       CCC ", "       CCC ", "       CCC ", "           ")
                    .aisle("EEEEEE     ", "IGGGGI     ", "IGGGGI     ", "IGGGGI     ", "IGGGGI     ", "IIIIII     ", "           ", "           ", "           ", "           ", "           ", "           ")
                    .where('S', controller(blocks(definition.get())))
                    .where('I', blocks(IRIDIUM_CASING.get()))
                    .where('C', blocks(CASING_STAINLESS_CLEAN.get()))
                    .where('P', blocks(CASING_TUNGSTENSTEEL_PIPE.get()))
                    .where('G', blocks(CASING_LAMINATED_GLASS.get()))
                    .where('T', frames(TungstenSteel))
                    .where('X', blocks(CASING_STEEL_GEARBOX.get()))
                    .where('E', blocks(IRIDIUM_CASING.get())
                            .or(abilities(PartAbility.INPUT_ENERGY).setMinGlobalLimited(1))
                            .or(abilities(MAINTENANCE).setMinGlobalLimited(1)))
                    .where('O', blocks(IRIDIUM_CASING.get())
                            .or(abilities(PartAbility.IMPORT_ITEMS)))
                    .where('W', blocks(CASING_STAINLESS_CLEAN.get())
                            .or(abilities(MUFFLER).setExactLimit(1))
                            .or(abilities(PartAbility.IMPORT_FLUIDS)))
                    .where('D', blocks(CASING_STAINLESS_CLEAN.get())
                            .or(abilities(PartAbility.EXPORT_ITEMS)))
                    .where(' ', any())
                    .build())
            .renderer(() -> new CustomPartRenderer(GTCEu.id("block/casings/solid/machine_casing_clean_stainless_steel"),
                    Epimorphism.id("block/multiblock/integrated_ore_factory"), IntegratedOreFactoryMachine::getBaseTexture))
            .register();

    //    public final static MultiblockMachineDefinition[] COMPRESSED_FUSION_REACTOR = registerTieredEPMultis("compressed_fusion_reactor", CompressedFusionReactorMachine::new, (tier, builder) -> builder
//            .rotationState(RotationState.NON_Y_AXIS)
//            .langValue("Compressed Fusion Reactor Computer MK %s".formatted(toRomanNumeral(tier - 5)))
//            .recipeType(FUSION_RECIPES)
//            .recipeModifier(FusionReactorMachine::recipeModifier)
//            .tooltips(
//                    Component.translatable("gtceu.machine.fusion_reactor.capacity", FusionReactorMachine.calculateEnergyStorageFactor(tier, 16) / 1000000L),
//                    Component.translatable("gtceu.machine.fusion_reactor.overclocking"),
//                    Component.translatable("gtceu.multiblock.fusion_reactor.%s.description".formatted(VN[tier].toLowerCase(Locale.ROOT))))
//            .appearanceBlock(() -> EPFusionCasingBlock.getCasingState(tier))
//            .pattern(definition -> FactoryBlockPattern.start()
//                    .aisle("                                               ", "                                               ", "                    FCCCCCF                    ", "                    FCIBICF                    ", "                    FCCCCCF                    ", "                                               ", "                                               ")
//                    .aisle("                                               ", "                    FCBBBCF                    ", "                   CC#####CC                   ", "                   CC#####CC                   ", "                   CC#####CC                   ", "                    FCBBBCF                    ", "                                               ")
//                    .aisle("                    FCBBBCF                    ", "                   CC#####CC                   ", "                CCCCC#####CCCCC                ", "                CCCHHHHHHHHHCCC                ", "                CCCCC#####CCCCC                ", "                   CC#####CC                   ", "                    FCBBBCF                    ")
//                    .aisle("                    FCIBICF                    ", "                CCCCC#####CCCCC                ", "              CCCCCHHHHHHHHHCCCCC              ", "              CCHHHHHHHHHHHHHHHCC              ", "              CCCCCHHHHHHHHHCCCCC              ", "                CCCCC#####CCCCC                ", "                    FCIBICF                    ")
//                    .aisle("                    FCBBBCF                    ", "              CCCCCCC#####CCCCCCC              ", "            CCCCHHHCC#####CCHHHCCCC            ", "            CCHHHHHHHHHHHHHHHHHHHCC            ", "            CCCCHHHCC#####CCHHHCCCC            ", "              CCCCCCC#####CCCCCCC              ", "                    FCBBBCF                    ")
//                    .aisle("                                               ", "            CCCCCCC FCBBBCF CCCCCCC            ", "           CCCHHCCCCC#####CCCCCHHCCC           ", "           CHHHHHHHCC#####CCHHHHHHHC           ", "           CCCHHCCCCC#####CCCCCHHCCC           ", "            CCCCCCC FCBBBCF CCCCCCC            ", "                                               ")
//                    .aisle("                                               ", "           CCCCC               CCCCC           ", "          ECHHCCCCC FCCCCCF CCCCCHHCE          ", "          CHHHHHCCC FCIBICF CCCHHHHHC          ", "          ECHHCCCCC FCCCCCF CCCCCHHCE          ", "           CCCCC               CCCCC           ", "                                               ")
//                    .aisle("                                               ", "          CCCC                   CCCC          ", "         CCHCCCC               CCCCHCC         ", "         CHHHHCC               CCHHHHC         ", "         CCHCCCC               CCCCHCC         ", "          CCCC                   CCCC          ", "                                               ")
//                    .aisle("                                               ", "         CCC                       CCC         ", "        CCHCCC                   CCCHCC        ", "        CHHHCC                   CCHHHC        ", "        CCHCCC                   CCCHCC        ", "         CCC                       CCC         ", "                                               ")
//                    .aisle("                                               ", "        CCC                         CCC        ", "       CCHCE                       ECHCC       ", "       CHHHC                       CHHHC       ", "       CCHCE                       ECHCC       ", "        CCC                         CCC        ", "                                               ")
//                    .aisle("                                               ", "       CCC                           CCC       ", "      ECHCC                         CCHCE      ", "      CHHHC                         CHHHC      ", "      ECHCC                         CCHCE      ", "       CCC                           CCC       ", "                                               ")
//                    .aisle("                                               ", "      CCC                             CCC      ", "     CCHCE                           ECHCC     ", "     CHHHC                           CHHHC     ", "     CCHCE                           ECHCC     ", "      CCC                             CCC      ", "                                               ")
//                    .aisle("                                               ", "     CCC                               CCC     ", "    CCHCC                             CCHCC    ", "    CHHHC                             CHHHC    ", "    CCHCC                             CCHCC    ", "     CCC                               CCC     ", "                                               ")
//                    .aisle("                                               ", "     CCC                               CCC     ", "    CCHCC                             CCHCC    ", "    CHHHC                             CHHHC    ", "    CCHCC                             CCHCC    ", "     CCC                               CCC     ", "                                               ")
//                    .aisle("                                               ", "    CCC                                 CCC    ", "   CCHCC                               CCHCC   ", "   CHHHC                               CHHHC   ", "   CCHCC                               CCHCC   ", "    CCC                                 CCC    ", "                                               ")
//                    .aisle("                                               ", "    CCC                                 CCC    ", "   CCHCC                               CCHCC   ", "   CHHHC                               CHHHC   ", "   CCHCC                               CCHCC   ", "    CCC                                 CCC    ", "                                               ")
//                    .aisle("                                               ", "   CCC                                   CCC   ", "  CCHCC                                 CCHCC  ", "  CHHHC                                 CHHHC  ", "  CCHCC                                 CCHCC  ", "   CCC                                   CCC   ", "                                               ")
//                    .aisle("                                               ", "   CCC                                   CCC   ", "  CCHCC                                 CCHCC  ", "  CHHHC                                 CHHHC  ", "  CCHCC                                 CCHCC  ", "   CCC                                   CCC   ", "                                               ")
//                    .aisle("                                               ", "   CCC                                   CCC   ", "  CCHCC                                 CCHCC  ", "  CHHHC                                 CHHHC  ", "  CCHCC                                 CCHCC  ", "   CCC                                   CCC   ", "                                               ")
//                    .aisle("                                               ", "  CCC                                     CCC  ", " CCHCC                                   CCHCC ", " CHHHC                                   CHHHC ", " CCHCC                                   CCHCC ", "  CCC                                     CCC  ", "                                               ")
//                    .aisle("  FFF                                     FFF  ", " FCCCF                                   FCCCF ", "FCCHCCF                                 FCCHCCF", "FCHHHCF                                 FCHHHCF", "FCCHCCF                                 FCCHCCF", " FCCCF                                   FCCCF ", "  FFF                                     FFF  ")
//                    .aisle("  CCC                                     CCC  ", " C###C                                   C###C ", "C##H##C                                 C##H##C", "C#HHH#C                                 C#HHH#C", "C##H##C                                 C##H##C", " C###C                                   C###C ", "  CCC                                     CCC  ")
//                    .aisle("  CIC                                     CIC  ", " B###B                                   B###B ", "C##H##C                                 C##H##C", "I#HHH#I                                 I#HHH#I", "C##H##C                                 C##H##C", " B###B                                   B###B ", "  CIC                                     CIC  ")
//                    .aisle("  CBC                                     CBC  ", " B###B                                   B###B ", "C##H##C                                 C##H##C", "B#HHH#B                                 B#HHH#B", "C##H##C                                 C##H##C", " B###B                                   B###B ", "  CBC                                     CBC  ")
//                    .aisle("  CIC                                     CIC  ", " B###B                                   B###B ", "C##H##C                                 C##H##C", "I#HHH#I                                 I#HHH#I", "C##H##C                                 C##H##C", " B###B                                   B###B ", "  CIC                                     CIC  ")
//                    .aisle("  CCC                                     CCC  ", " C###C                                   C###C ", "C##H##C                                 C##H##C", "C#HHH#C                                 C#HHH#C", "C##H##C                                 C##H##C", " C###C                                   C###C ", "  CCC                                     CCC  ")
//                    .aisle("  FFF                                     FFF  ", " FCCCF                                   FCCCF ", "FCCHCCF                                 FCCHCCF", "FCHHHCF                                 FCHHHCF", "FCCHCCF                                 FCCHCCF", " FCCCF                                   FCCCF ", "  FFF                                     FFF  ")
//                    .aisle("                                               ", "  CCC                                     CCC  ", " CCHCC                                   CCHCC ", " CHHHC                                   CHHHC ", " CCHCC                                   CCHCC ", "  CCC                                     CCC  ", "                                               ")
//                    .aisle("                                               ", "   CCC                                   CCC   ", "  CCHCC                                 CCHCC  ", "  CHHHC                                 CHHHC  ", "  CCHCC                                 CCHCC  ", "   CCC                                   CCC   ", "                                               ")
//                    .aisle("                                               ", "   CCC                                   CCC   ", "  CCHCC                                 CCHCC  ", "  CHHHC                                 CHHHC  ", "  CCHCC                                 CCHCC  ", "   CCC                                   CCC   ", "                                               ")
//                    .aisle("                                               ", "   CCC                                   CCC   ", "  CCHCC                                 CCHCC  ", "  CHHHC                                 CHHHC  ", "  CCHCC                                 CCHCC  ", "   CCC                                   CCC   ", "                                               ")
//                    .aisle("                                               ", "    CCC                                 CCC    ", "   CCHCC                               CCHCC   ", "   CHHHC                               CHHHC   ", "   CCHCC                               CCHCC   ", "    CCC                                 CCC    ", "                                               ")
//                    .aisle("                                               ", "    CCC                                 CCC    ", "   CCHCC                               CCHCC   ", "   CHHHC                               CHHHC   ", "   CCHCC                               CCHCC   ", "    CCC                                 CCC    ", "                                               ")
//                    .aisle("                                               ", "     CCC                               CCC     ", "    CCHCC                             CCHCC    ", "    CHHHC                             CHHHC    ", "    CCHCC                             CCHCC    ", "     CCC                               CCC     ", "                                               ")
//                    .aisle("                                               ", "     CCC                               CCC     ", "    CCHCC                             CCHCC    ", "    CHHHC                             CHHHC    ", "    CCHCC                             CCHCC    ", "     CCC                               CCC     ", "                                               ")
//                    .aisle("                                               ", "      CCC                             CCC      ", "     CCHCE                           ECHCC     ", "     CHHHC                           CHHHC     ", "     CCHCE                           ECHCC     ", "      CCC                             CCC      ", "                                               ")
//                    .aisle("                                               ", "       CCC                           CCC       ", "      ECHCC                         CCHCE      ", "      CHHHC                         CHHHC      ", "      ECHCC                         CCHCE      ", "       CCC                           CCC       ", "                                               ")
//                    .aisle("                                               ", "        CCC                         CCC        ", "       CCHCE                       ECHCC       ", "       CHHHC                       CHHHC       ", "       CCHCE                       ECHCC       ", "        CCC                         CCC        ", "                                               ")
//                    .aisle("                                               ", "         CCC                       CCC         ", "        CCHCCC                   CCCHCC        ", "        CHHHCC                   CCHHHC        ", "        CCHCCC                   CCCHCC        ", "         CCC                       CCC         ", "                                               ")
//                    .aisle("                                               ", "          CCCC                   CCCC          ", "         CCHCCCC               CCCCHCC         ", "         CHHHHCC               CCHHHHC         ", "         CCHCCCC               CCCCHCC         ", "          CCCC                   CCCC          ", "                                               ")
//                    .aisle("                                               ", "           CCCCC               CCCCC           ", "          ECHHCCCCC FCCCCCF CCCCCHHCE          ", "          CHHHHHCCC FCIBICF CCCHHHHHC          ", "          ECHHCCCCC FCCCCCF CCCCCHHCE          ", "           CCCCC               CCCCC           ", "                                               ")
//                    .aisle("                                               ", "            CCCCCCC FCBBBCF CCCCCCC            ", "           CCCHHCCCCC#####CCCCCHHCCC           ", "           CHHHHHHHCC#####CCHHHHHHHC           ", "           CCCHHCCCCC#####CCCCCHHCCC           ", "            CCCCCCC FCBBBCF CCCCCCC            ", "                                               ")
//                    .aisle("                    FCBBBCF                    ", "              CCCCCCC#####CCCCCCC              ", "            CCCCHHHCC#####CCHHHCCCC            ", "            CCHHHHHHHHHHHHHHHHHHHCC            ", "            CCCCHHHCC#####CCHHHCCCC            ", "              CCCCCCC#####CCCCCCC              ", "                    FCBBBCF                    ")
//                    .aisle("                    FCIBICF                    ", "                CCCCC#####CCCCC                ", "              CCCCCHHHHHHHHHCCCCC              ", "              CCHHHHHHHHHHHHHHHCC              ", "              CCCCCHHHHHHHHHCCCCC              ", "                CCCCC#####CCCCC                ", "                    FCIBICF                    ")
//                    .aisle("                    FCBBBCF                    ", "                   CC#####CC                   ", "                CCCCC#####CCCCC                ", "                CCCHHHHHHHHHCCC                ", "                CCCCC#####CCCCC                ", "                   CC#####CC                   ", "                    FCBBBCF                    ")
//                    .aisle("                                               ", "                    FCBBBCF                    ", "                   CC#####CC                   ", "                   CC#####CC                   ", "                   CC#####CC                   ", "                    FCBBBCF                    ", "                                               ")
//                    .aisle("                                               ", "                                               ", "                    FCCCCCF                    ", "                    FCISICF                    ", "                    FCCCCCF                    ", "                                               ", "                                               ")
//                    .where('S', controller(blocks(definition.get())))
//                    .where('B', blocks(FUSION_GLASS.get()))
//                    .where('C', blocks(EPFusionCasingBlock.getCasingState(tier)))
//                    .where('I', blocks(EPFusionCasingBlock.getCasingState(tier))
//                            .or(abilities(PartAbility.IMPORT_FLUIDS)
//                                    .setMinGlobalLimited(2)
//                                    .setPreviewCount(16))
//                            .or(abilities(PartAbility.EXPORT_FLUIDS)
//                                    .setMinGlobalLimited(2)
//                                    .setPreviewCount(16)))
//                    .where('F', frames(CompressedFusionReactorMachine.getFrameMaterial(tier)))
//                    .where('H', blocks(CompressedFusionReactorMachine.getCoilBlock(tier)))
//                    .where('E', blocks(EPFusionCasingBlock.getCasingState(tier))
//                            .or(blocks(PartAbility.INPUT_ENERGY.getBlockRange(tier, UEV).toArray(Block[]::new))
//                                    .setMinGlobalLimited(1)
//                                    .setPreviewCount(32)))
//                    .where('#', air())
//                    .where(' ', any())
//                    .build())
//                    .workableCasingRenderer(EPFusionCasingBlock.getCasingType(tier).getTexture(),
//                            GTCEu.id("block/multiblock/fusion_reactor"), false)
//                    .register(),
//            LuV, ZPM, UV, UHV, UEV);

    // Bedrock
    public final static MultiblockMachineDefinition INFINITE_FLUID_DRILLING_RIG = registrate().multiblock("infinite_fluid_drilling_rig", InfiniteFluidDrillingRigMachine::new)
            .langValue("Infinite Fluid Drilling Rig")
            .tooltips(
                    Component.translatable("block.epimorphism.industrial_drill.desc.0")
            )
            .rotationState(RotationState.NON_Y_AXIS)
            .recipeType(DUMMY_RECIPES)
            .appearanceBlock(NEUTRONIUM_MINING_CASING)
            .pattern(definition -> FactoryBlockPattern.start()
                    .aisle("XXX", "#F#", "#F#", "#F#", "###", "###", "###")
                    .aisle("XXX", "FCF", "FCF", "FCF", "#F#", "#F#", "#F#")
                    .aisle("XSX", "#F#", "#F#", "#F#", "###", "###", "###")
                    .where('S', controller(blocks(definition.get())))
                    .where('X', blocks(NEUTRONIUM_MINING_CASING.get()).setMinGlobalLimited(3)
                            .or(abilities(PartAbility.INPUT_ENERGY).setMinGlobalLimited(1).setMaxGlobalLimited(3))
                            .or(abilities(PartAbility.EXPORT_FLUIDS).setMaxGlobalLimited(1)))
                    .where('C', blocks(NEUTRONIUM_MINING_CASING.get()))
                    .where('F', frames(Neutronium))
                    .where('#', any())
                    .build())
            .renderer(() -> new LargeMinerRenderer(Epimorphism.id("block/casings/solid/neutronium_mining_casing"),
                    Epimorphism.id("block/multiblock/infinite_fluid_drilling_rig")))
            .register();

    public static void init() {

    }
}
