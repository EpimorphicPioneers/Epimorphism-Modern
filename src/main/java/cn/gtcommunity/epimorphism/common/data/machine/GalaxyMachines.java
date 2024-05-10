package cn.gtcommunity.epimorphism.common.data.machine;

import cn.gtcommunity.epimorphism.Epimorphism;
import cn.gtcommunity.epimorphism.api.pattern.EnhanceBlockPattern;
import cn.gtcommunity.epimorphism.api.pattern.utils.StructureUtil;
import cn.gtcommunity.epimorphism.common.block.BlockMaps;
import cn.gtcommunity.epimorphism.common.machine.multiblock.electric.galaxy.SpaceElevatorMachine;
import com.gregtechceu.gtceu.api.data.RotationState;
import com.gregtechceu.gtceu.api.machine.MultiblockMachineDefinition;
import com.gregtechceu.gtceu.api.pattern.MultiblockShapeInfo;

import java.util.ArrayList;
import java.util.List;

import static cn.gtcommunity.epimorphism.common.registry.EPRegistration.EP_REGISTRATE;
import static cn.gtcommunity.epimorphism.common.data.EPBlocks.AEROSPACE_CASING;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.DUMMY_RECIPES;

public class GalaxyMachines {

    public static final MultiblockMachineDefinition SPACE_ELEVATOR = EP_REGISTRATE.multiblock("space_elevator", SpaceElevatorMachine::new)
            .langValue("Space Elevator")
            .rotationState(RotationState.NON_Y_AXIS)
            .recipeTypes(DUMMY_RECIPES)
            .appearanceBlock(AEROSPACE_CASING)
            .pattern(StructureUtil::emptyPattern)
            .shapeInfos(definition -> {
                List<MultiblockShapeInfo> shapeInfos = new ArrayList<>();
                shapeInfos.addAll(StructureUtil.getMatchingShapes((EnhanceBlockPattern) SpaceElevatorMachine.getBlockPattern(0, definition), BlockMaps.ALL_ELEVATOR_MOTORS.size()));
                shapeInfos.addAll(StructureUtil.getTierMatchingShapes((EnhanceBlockPattern) SpaceElevatorMachine.getBlockPattern(1, definition), BlockMaps.ALL_ELEVATOR_MOTORS.size()));
                return shapeInfos;
            })
            .workableCasingRenderer(Epimorphism.id("block/casings/solid/aerospace_casing"),
                    Epimorphism.id("block/multiblock/space_elevator"), false)
            .register();

    public static void init() {

    }
}
