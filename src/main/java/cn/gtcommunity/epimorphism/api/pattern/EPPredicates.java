package cn.gtcommunity.epimorphism.api.pattern;

import cn.gtcommunity.epimorphism.api.machine.multiblock.EPPartAbility;
import cn.gtcommunity.epimorphism.api.pattern.utils.containers.*;
import cn.gtcommunity.epimorphism.api.pattern.predicates.TierTraceabilityPredicateFactory;
import cn.gtcommunity.epimorphism.common.block.BlockMaps;
import cn.gtcommunity.epimorphism.common.data.EPBlocks;
import com.gregtechceu.gtceu.api.machine.MetaMachine;
import com.gregtechceu.gtceu.api.machine.feature.ITieredMachine;
import com.gregtechceu.gtceu.api.machine.multiblock.PartAbility;
import com.gregtechceu.gtceu.api.pattern.MultiblockState;
import com.gregtechceu.gtceu.api.pattern.Predicates;
import com.gregtechceu.gtceu.api.pattern.TraceabilityPredicate;
import com.gregtechceu.gtceu.api.pattern.predicates.PredicateBlocks;
import com.gregtechceu.gtceu.api.pattern.predicates.SimplePredicate;
import com.lowdragmc.lowdraglib.utils.BlockInfo;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class EPPredicates {

    // Glasses
    public static TraceabilityPredicate glass() {
        return TierTraceabilityPredicateFactory.create(TierTraceabilityPredicateFactory.TraceabilityPredicateType.TIER, "Glass")
                .map(BlockMaps.ALL_GLASSES)
                .candidatesMap(BlockMaps.SHAPE_GLASSES)
                .errorKey(Component.translatable("epimorphism.multiblock.pattern.error.glasses"))
                .build();
    }

    // Yotta Fluid Tank
    public static TraceabilityPredicate fluidTankCell() {
        return TierTraceabilityPredicateFactory.create(TierTraceabilityPredicateFactory.TraceabilityPredicateType.LOOSE, "FluidTankCell")
                .map(BlockMaps.ALL_FLUID_CELLS)
                .container(FluidTankCellContainer::new)
                .build();
    }

    // TFFT
    public static TraceabilityPredicate storageFieldBlock() {
        return TierTraceabilityPredicateFactory.create(TierTraceabilityPredicateFactory.TraceabilityPredicateType.LOOSE, "StorageFieldBlock")
                .map(BlockMaps.ALL_FIELD_BLOCKS)
                .container(StorageFieldBlockContainer::new)
                .build();
    }

    // Component Assembly Line
    public static TraceabilityPredicate componentAssemblyBlock() {
        return TierTraceabilityPredicateFactory.create(TierTraceabilityPredicateFactory.TraceabilityPredicateType.TIER, "CACasing")
                .map(BlockMaps.ALL_CA_TIRED_CASINGS)
                .build();
    }

    // Chemical Plant
    public static TraceabilityPredicate CPCasingBlock() {
        return TierTraceabilityPredicateFactory.create(TierTraceabilityPredicateFactory.TraceabilityPredicateType.TIER, "CPCasing")
                .map(BlockMaps.ALL_CP_CASINGS)
                .build();
    }

    public static TraceabilityPredicate CPPipeBlock() {
        return TierTraceabilityPredicateFactory.create(TierTraceabilityPredicateFactory.TraceabilityPredicateType.TIER, "CPPipe")
                .map(BlockMaps.ALL_CP_TUBES)
                .build();
    }

    // Precise Assembler
    public static TraceabilityPredicate PACasingBlock() {
        return TierTraceabilityPredicateFactory.create(TierTraceabilityPredicateFactory.TraceabilityPredicateType.TIER, "PACasing")
                .map(BlockMaps.ALL_PA_CASINGS)
                .build();
    }

    // Solar Tower
    public static TraceabilityPredicate mirrorBlock(int tier) {
        return tierOptionalPredicate("Mirror", tier, Predicates.blocks(EPBlocks.TFFT_CASING.get()));
    }

    // Industrial Drill
    public static TraceabilityPredicate bedrockPredicate() {
        return new TraceabilityPredicate(state -> {
            state.getMatchContext().set("Bedrock", state.getPos());
            return true;
        }, null);
    }

    // Eye of Harmony
    public static TraceabilityPredicate SCFieldGenerator() {
        return TierTraceabilityPredicateFactory.create(TierTraceabilityPredicateFactory.TraceabilityPredicateType.TIER, "SCFieldGenerator")
                .map(BlockMaps.SC_FIELD_GENERATORS)
                .build();
    }

    public static TraceabilityPredicate STFieldGenerator() {
        return TierTraceabilityPredicateFactory.create(TierTraceabilityPredicateFactory.TraceabilityPredicateType.TIER, "STFieldGenerator")
                .map(BlockMaps.ST_FIELD_GENERATORS)
                .build();
    }

    public static TraceabilityPredicate TAFieldGenerator() {
        return TierTraceabilityPredicateFactory.create(TierTraceabilityPredicateFactory.TraceabilityPredicateType.TIER, "TAFieldGenerator")
                .map(BlockMaps.TA_FIELD_GENERATORS)
                .build();
    }

    public static TraceabilityPredicate elevatorMotor() {
        return TierTraceabilityPredicateFactory.create(TierTraceabilityPredicateFactory.TraceabilityPredicateType.TIER, "ElevatorMotor")
                .map(BlockMaps.ALL_ELEVATOR_MOTORS)
                .build();
    }

    public static TraceabilityPredicate tierReinforcedRotorBlock() {
        return new TraceabilityPredicate(new PredicateBlocks(EPPartAbility.REINFORCED_ROTOR_HOLDER.getAllBlocks().toArray(Block[]::new)) {
            @Override
            public boolean test(MultiblockState blockWorldState) {
                if (super.test(blockWorldState)) {
                    var level = blockWorldState.getWorld();
                    var pos = blockWorldState.getPos();
                    var machine = MetaMachine.getMachine(level, pos);
                    if (machine instanceof ITieredMachine tieredMachine) {
                        int tier = blockWorldState.getMatchContext().getOrPut("ReinforcedRotor", tieredMachine.getTier());
                        if (tier != tieredMachine.getTier()) {
                            return false;
                        }
                        return level.getBlockState(pos.relative(machine.getFrontFacing())).isAir();
                    }
                }
                return false;
            }
        });
    }

    // Univer
    public static TraceabilityPredicate countBlock(String name, Block... blocks) {
        return enhancePredicate(name,
                () -> new SimpleValueContainer<>(0, (integer, block, tierType) -> ++integer), Predicates.blocks(blocks), null);
    }

    public static TraceabilityPredicate coilBlock() {
        return TierTraceabilityPredicateFactory.create(TierTraceabilityPredicateFactory.TraceabilityPredicateType.TIER, "Coil")
                .map(BlockMaps.ALL_COIL_BLOCKS)
                .errorKey(Component.translatable("gtceu.multiblock.pattern.error.coils"))
                .build();
    }

    public static TraceabilityPredicate machineCasingBlock() {
        return TierTraceabilityPredicateFactory.create(TierTraceabilityPredicateFactory.TraceabilityPredicateType.TIER, "MachineCasing")
                .map(BlockMaps.ALL_MACHINE_CASINGS)
                .build();
    }

    public static TraceabilityPredicate fireboxBlock() {
        return TierTraceabilityPredicateFactory.create(TierTraceabilityPredicateFactory.TraceabilityPredicateType.TIER, "Firebox")
                .map(BlockMaps.ALL_FIREBOXS)
                .build();
    }

    public static TraceabilityPredicate optionalPredicate(String mark, TraceabilityPredicate inner) {
        Predicate<MultiblockState> predicate = state -> {
            var context = state.getMatchContext();
            if (inner.test(state)) {
                return (context.getOrPut(mark, true));
            }
            return context.get(mark) == null;
        };
        BlockInfo[] candidates = inner.common.stream()
                .map(p -> p.candidates)
                .filter(Objects::nonNull)
                .map(Supplier::get)
                .flatMap(Arrays::stream)
                .toArray(BlockInfo[]::new);
        return new TraceabilityPredicate(new SimplePredicate(predicate, () -> candidates));
    }

    public static TraceabilityPredicate tierOptionalPredicate(String name, int tier, TraceabilityPredicate inner) {
        return enhancePredicate(name, TierOptionalContainer::new, optionalPredicate(name + tier, inner), tier);
    }

    public static TraceabilityPredicate enhancePredicate(String name, Supplier<IValueContainer<?>> containerSupplier, TraceabilityPredicate inner, @Nullable Object data) {
        Predicate<MultiblockState> predicate = state -> {
            if (inner.test(state)) {
                IValueContainer<?> currentContainer = state.getMatchContext().getOrPut(name + "Value", containerSupplier.get());
                currentContainer.operate(state.getBlockState().getBlock(), data);
                return true;
            }
            return false;
        };
        BlockInfo[] candidates = inner.common.stream()
                .map(p -> p.candidates)
                .filter(Objects::nonNull)
                .map(Supplier::get)
                .flatMap(Arrays::stream)
                .toArray(BlockInfo[]::new);
        return new TraceabilityPredicate(new SimplePredicate(predicate, () -> candidates));
    }

    public static TraceabilityPredicate tierAbilities(String name, PartAbility... abilities) {
        return new TraceabilityPredicate(new PredicateBlocks(Arrays.stream(abilities)
                .map(PartAbility::getAllBlocks)
                .flatMap(Collection::stream)
                .toArray(Block[]::new)) {
            @Override
            public boolean test(MultiblockState blockWorldState) {
                if (super.test(blockWorldState)) {
                    if (MetaMachine.getMachine(blockWorldState.getWorld(), blockWorldState.getPos()) instanceof ITieredMachine tieredMachine) {
                        int tier = blockWorldState.getMatchContext().getOrPut(name, tieredMachine.getTier());
                        return tier == tieredMachine.getTier();
                    }
                }
                return false;
            }
        });
    }
}
