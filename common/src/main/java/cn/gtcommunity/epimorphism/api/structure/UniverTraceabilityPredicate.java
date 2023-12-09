package cn.gtcommunity.epimorphism.api.structure;

import com.gregtechceu.gtceu.api.machine.multiblock.PartAbility;
import com.gregtechceu.gtceu.api.pattern.TraceabilityPredicate;
import com.lowdragmc.lowdraglib.utils.BlockInfo;
import net.minecraft.world.level.block.Block;
import org.apache.commons.lang3.ArrayUtils;

import java.util.*;

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
}
