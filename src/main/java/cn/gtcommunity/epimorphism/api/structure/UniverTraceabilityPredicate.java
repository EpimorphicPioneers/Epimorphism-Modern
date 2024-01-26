package cn.gtcommunity.epimorphism.api.structure;

import cn.gtcommunity.epimorphism.api.structure.block.tier.ITierType;
import cn.gtcommunity.epimorphism.api.structure.utils.IValueContainer;
import com.gregtechceu.gtceu.api.machine.multiblock.PartAbility;
import com.gregtechceu.gtceu.api.pattern.MultiblockState;
import com.gregtechceu.gtceu.api.pattern.TraceabilityPredicate;
import com.gregtechceu.gtceu.api.pattern.predicates.SimplePredicate;
import com.lowdragmc.lowdraglib.utils.BlockInfo;
import net.minecraft.world.level.block.Block;
import org.apache.commons.lang3.ArrayUtils;

import java.util.*;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class UniverTraceabilityPredicate {
    //  Optional Traceability Predicates
    public static TraceabilityPredicate optionalStates(String mark, Block... blocks) {
        return new TraceabilityPredicate(blockWorldState -> {
            Block block = blockWorldState.getBlockState().getBlock();
            if (ArrayUtils.contains(blocks, block)) {
                return (blockWorldState.getMatchContext().getOrPut(mark, true));
            }
            return blockWorldState.getMatchContext().get(mark) == null;
        }, () -> Arrays.stream(blocks).map(BlockInfo::fromBlock).toArray(BlockInfo[]::new));
    }

    public static TraceabilityPredicate optionalAbilities(String mark, PartAbility... allowedAbilities) {
        return optionalStates(mark,
                Arrays.stream(allowedAbilities)
                        .map(PartAbility::getAllBlocks)
                        .flatMap(Collection::stream)
                        .toArray(Block[]::new));
    }

    public static TraceabilityPredicate enhancePredicate(String name, Supplier<IValueContainer<?>> containerSupplier, TraceabilityPredicate inner) {
        Predicate<MultiblockState> predicate = state -> {
            if (inner.test(state)) {
                IValueContainer<?> currentContainer = state.getMatchContext().getOrPut(name + "Value", containerSupplier.get());
                currentContainer.operate(state.getBlockState().getBlock(), ITierType.TierBlockType.DUMMY);
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
}
