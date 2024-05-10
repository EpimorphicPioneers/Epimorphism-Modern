package cn.gtcommunity.epimorphism.common.data.machine;

import cn.gtcommunity.epimorphism.Epimorphism;
import cn.gtcommunity.epimorphism.api.machine.multiblock.EPPartAbility;
import cn.gtcommunity.epimorphism.api.pattern.EPPredicates;
import cn.gtcommunity.epimorphism.api.pattern.EnhanceBlockPattern;
import cn.gtcommunity.epimorphism.api.pattern.FactoryEnhancePattern;
import cn.gtcommunity.epimorphism.api.pattern.utils.StructureUtil;
import cn.gtcommunity.epimorphism.client.renderer.handler.machine.TankMachineRenderer;
import cn.gtcommunity.epimorphism.common.machine.multiblock.electric.biology.BacterialCultureTankMachine;
import cn.gtcommunity.epimorphism.common.machine.multiblock.electric.biology.FermentationTankMachine;
import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.data.RotationState;
import com.gregtechceu.gtceu.api.machine.MultiblockMachineDefinition;
import com.gregtechceu.gtceu.api.machine.multiblock.PartAbility;
import com.gregtechceu.gtceu.api.pattern.FactoryBlockPattern;
import com.gregtechceu.gtceu.api.pattern.MultiblockShapeInfo;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import net.minecraft.network.chat.Component;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static cn.gtcommunity.epimorphism.common.registry.EPRegistration.EP_REGISTRATE;
import static cn.gtcommunity.epimorphism.common.block.BlockMaps.SHAPE_GLASSES;
import static cn.gtcommunity.epimorphism.common.data.EPBlocks.OSMIR_BORON_SILICATE_GLASS;
import static cn.gtcommunity.epimorphism.common.data.EPRecipeTypes.FERMENTATION_TANK_RECIPES;
import static com.gregtechceu.gtceu.api.pattern.Predicates.*;
import static com.gregtechceu.gtceu.common.data.GTBlocks.CASING_POLYTETRAFLUOROETHYLENE_PIPE;
import static com.gregtechceu.gtceu.common.data.GTBlocks.CASING_STAINLESS_CLEAN;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.DUMMY_RECIPES;

public class BiologyMachines {


    // Biology
    public final static MultiblockMachineDefinition BACTERIAL_CULTURE_TANK = EP_REGISTRATE.multiblock("bacterial_culture_tank", BacterialCultureTankMachine::new)
            .langValue("Bacterial Culture Tank")
            .tooltips(Component.translatable("block.epimorphism.bacterial_culture_tank.desc.0"))
            .rotationState(RotationState.ALL)
            .recipeType(DUMMY_RECIPES)
            .appearanceBlock(CASING_STAINLESS_CLEAN)
            .pattern(definition -> FactoryEnhancePattern.start()
                    .aisle("AAAAA", "CCCCC", "CCCCC", "AAAAA")
                    .aisle("AAAAA", "C   C", "C   C", "AAAAA")
                    .aisle("AAAAA", "C   C", "C   C", "AAAAA")
                    .aisle("AAAAA", "C   C", "C   C", "AAAAA")
                    .aisle("AABAA", "CCCCC", "CCCCC", "AAAAA")
                    .where('B', controller(blocks(definition.getBlock())))
                    .where('A', blocks(CASING_STAINLESS_CLEAN.get()).setMinGlobalLimited(19)
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
//                MultiblockShapeInfo.ShapeInfoBuilder builder = MultiblockShapeInfo.builder()
//                        .aisle("DEBFG", "CCCCC", "CCCCC", "AAJAA")
//                        .aisle("AAAAA", "C   C", "C   C", "AAAAA")
//                        .aisle("AAAAA", "C   C", "C   C", "AAAAA")
//                        .aisle("AAAAA", "C   C", "C   C", "AAAAA")
//                        .aisle("AHIAA", "CCCCC", "CCCCC", "AAAAA")
//                        .where('B', definition, Direction.NORTH)
//                        .where('A', CASING_STAINLESS_CLEAN.get())
//                        .where('D', GTMachines.FLUID_IMPORT_HATCH[4], Direction.NORTH)
//                        .where('E', GTMachines.ITEM_IMPORT_BUS[4], Direction.NORTH)
//                        .where('F', GTMachines.FLUID_EXPORT_HATCH[4], Direction.NORTH)
//                        .where('G', GTMachines.FLUID_EXPORT_HATCH[4], Direction.NORTH)
//                        .where('H', GTMachines.MAINTENANCE_HATCH, Direction.SOUTH)
//                        .where('I', GTMachines.ENERGY_INPUT_HATCH[5], Direction.SOUTH)
//                        .where('J', EPMachines.RADIATION_HATCH[3], Direction.NORTH);
//                BlockMaps.SHAPE_GLASSES.entrySet().stream()
//                        .sorted(Comparator.comparingInt(entry -> entry.getKey().tier()))
//                        .map(Map.Entry::getValue)
//                        .forEach(blockSupplier -> shapeInfos.add(builder.where('C', blockSupplier.get()).build()));
                shapeInfos.addAll(StructureUtil.getMatchingShapes((EnhanceBlockPattern) definition.getPatternFactory().get(), SHAPE_GLASSES.size()));
                return shapeInfos;
            })
            .partSorter(Comparator.comparingInt(a -> a.self().getPos().getY()))
            .renderer(() -> new TankMachineRenderer(GTCEu.id("block/casings/solid/machine_casing_clean_stainless_steel"),
                    Epimorphism.id("block/multiblock/bacterial_culture_tank")))
            .hasTESR(true)
            .register();
    public final static MultiblockMachineDefinition FERMENTATION_TANK = EP_REGISTRATE.multiblock("fermentation_tank", FermentationTankMachine::new)
            .langValue("Fermentation Tank")
            .tooltips(Component.translatable("block.epimorphism.fermentation_tank.desc.0"))
            .rotationState(RotationState.NON_Y_AXIS)
            .recipeType(FERMENTATION_TANK_RECIPES)
            .appearanceBlock(CASING_STAINLESS_CLEAN)
            .pattern(definition -> FactoryBlockPattern.start()
                    .aisle("FAAAF", "FXXXF", "FXGXF", "FXGXF", "FXGXF", "FXXXF", "AAAAA")
                    .aisle("AXXXA", "XEEEX", "XEEEX", "XEEEX", "XEEEX", "XEEEX", "AXXXA")
                    .aisle("AXXXA", "XEPEX", "GEPEG", "GEPEG", "GEPEG", "XEPEX", "AXXXA")
                    .aisle("AXXXA", "XEEEX", "XEEEX", "XEEEX", "XEEEX", "XEEEX", "AXXXA")
                    .aisle("FAAAF", "FXSXF", "FXGXF", "FXGXF", "FXGXF", "FXXXF", "AAAAA")
                    .where('S', controller(blocks(definition.getBlock())))
                    .where('X', blocks(CASING_STAINLESS_CLEAN.get()).setMinGlobalLimited(42).or(autoAbilities(FERMENTATION_TANK_RECIPES)))
                    .where('G', blocks(OSMIR_BORON_SILICATE_GLASS.get()))
                    .where('F', frames(GTMaterials.WatertightSteel))
                    .where('P', blocks(CASING_POLYTETRAFLUOROETHYLENE_PIPE.get()))
                    .where('A', any())
                    .where('E', air())
                    .build())
            .partSorter(Comparator.comparingInt(a -> a.self().getPos().getY()))
            .workableCasingRenderer(GTCEu.id("block/casings/solid/machine_casing_clean_stainless_steel"),
                    Epimorphism.id("block/multiblock/fermentation_tank"), false)
            .register();

    public static void init() {

    }
}
