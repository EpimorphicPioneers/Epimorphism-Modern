package cn.gtcommunity.epimorphism.common.data;

import cn.gtcommunity.epimorphism.Epimorphism;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.cover.CoverDefinition;
import com.gregtechceu.gtceu.api.registry.GTRegistries;
import com.gregtechceu.gtceu.client.renderer.cover.*;
import com.gregtechceu.gtceu.common.cover.ConveyorCover;
import com.gregtechceu.gtceu.common.cover.PumpCover;
import com.gregtechceu.gtceu.common.cover.RobotArmCover;
import it.unimi.dsi.fastutil.ints.Int2ObjectFunction;

import java.util.Arrays;
import java.util.Locale;

public class EPCovers {
    public final static CoverDefinition ELECTRIC_PUMP_ULV = register(
            "pump.ulv", (def, coverable, side) -> new PumpCover(def, coverable, side, GTValues.LV),
            PumpCoverRenderer.INSTANCE
    );

    public final static CoverDefinition FLUID_REGULATORS_ULV = register(
            "fluid_regulators.ulv", (def, coverable, side) -> new PumpCover(def, coverable, side, GTValues.LV),
            FluidRegulatorCoverRenderer.INSTANCE
    );

    public final static CoverDefinition CONVEYOR_MODULE_ULV = register(
            "conveyor.ulv", (def, coverable, side) -> new ConveyorCover(def, coverable, side, GTValues.LV),
            ConveyorCoverRenderer.INSTANCE
    );

    public final static CoverDefinition ROBOT_ARM_ULV = register(
            "robot_arm.ulv", (def, coverable, side) -> new RobotArmCover(def, coverable, side, GTValues.LV),
            RobotArmCoverRenderer.INSTANCE
    );

    public final static CoverDefinition ELECTRIC_PUMP_MAX = register(
            "pump.max", (def, coverable, side) -> new PumpCover(def, coverable, side, GTValues.MAX),
            PumpCoverRenderer.INSTANCE
    );

    public final static CoverDefinition FLUID_REGULATORS_MAX = register(
            "fluid_regulators.max", (def, coverable, side) -> new PumpCover(def, coverable, side, GTValues.MAX),
            FluidRegulatorCoverRenderer.INSTANCE
    );

    public final static CoverDefinition CONVEYOR_MODULE_MAX = register(
            "conveyor.max", (def, coverable, side) -> new ConveyorCover(def, coverable, side, GTValues.MAX),
            ConveyorCoverRenderer.INSTANCE
    );

    public final static CoverDefinition ROBOT_ARM_MAX = register(
            "robot_arm.max", (def, coverable, side) -> new RobotArmCover(def, coverable, side, GTValues.MAX),
            RobotArmCoverRenderer.INSTANCE
    );

    public static void init() {/**/}

    protected static CoverDefinition register(String id, CoverDefinition.CoverBehaviourProvider behaviorCreator) {
        return register(id, behaviorCreator, new SimpleCoverRenderer(Epimorphism.id("block/cover/" + id)));
    }

    protected static CoverDefinition register(String id, CoverDefinition.CoverBehaviourProvider behaviorCreator, ICoverRenderer coverRenderer) {
        var definition = new CoverDefinition(Epimorphism.id(id), behaviorCreator, coverRenderer);
        GTRegistries.COVERS.register(Epimorphism.id(id), definition);
        return definition;
    }

    protected static CoverDefinition[] registerTiered(String id, CoverDefinition.TieredCoverBehaviourProvider behaviorCreator, Int2ObjectFunction<ICoverRenderer> coverRenderer, int... tiers) {
        return Arrays.stream(tiers).mapToObj(tier -> {
            var name = id + "." + GTValues.VN[tier].toLowerCase(Locale.ROOT);
            return register(name, (def, coverable, side) -> behaviorCreator.create(def, coverable, side, tier), coverRenderer.apply(tier));
        }).toArray(CoverDefinition[]::new);
    }

    protected static CoverDefinition[] registerTiered(String id, CoverDefinition.TieredCoverBehaviourProvider behaviorCreator, int... tiers) {
        return Arrays.stream(tiers).mapToObj(tier -> {
            var name = id + "." + GTValues.VN[tier].toLowerCase(Locale.ROOT);
            return register(name, (def, coverable, side) -> behaviorCreator.create(def, coverable, side, tier));
        }).toArray(CoverDefinition[]::new);
    }
}
