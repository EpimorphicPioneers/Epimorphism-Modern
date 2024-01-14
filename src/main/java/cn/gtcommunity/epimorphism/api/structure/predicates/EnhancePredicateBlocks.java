package cn.gtcommunity.epimorphism.api.structure.predicates;

import cn.gtcommunity.epimorphism.api.structure.block.tier.ITierType;
import cn.gtcommunity.epimorphism.api.structure.utils.IValueContainer;
import com.gregtechceu.gtceu.api.pattern.predicates.PredicateBlocks;
import com.gregtechceu.gtceu.api.pattern.predicates.SimplePredicate;
import net.minecraft.world.level.block.Block;
import org.apache.commons.lang3.ArrayUtils;

import java.util.function.Supplier;

public class EnhancePredicateBlocks extends PredicateBlocks {
    private final String name;
    private final Supplier<IValueContainer<?>> containerSupplier;
    public EnhancePredicateBlocks(String name, Supplier<IValueContainer<?>> containerSupplier, Block... blocks) {
        super(blocks);
        this.name = name;
        this.containerSupplier = containerSupplier;
    }

    @Override
    public SimplePredicate buildPredicate() {
        super.buildPredicate();
        predicate = state -> {
            var block = state.getBlockState().getBlock();
            if (ArrayUtils.contains(blocks, block)) {
                IValueContainer<?> currentContainer = state.getMatchContext().getOrPut(name + "Value", containerSupplier.get());
                currentContainer.operate(block, ITierType.TierBlockType.DUMMY);
                return true;
            }
            return false;
        };
        return this;
    }
}
