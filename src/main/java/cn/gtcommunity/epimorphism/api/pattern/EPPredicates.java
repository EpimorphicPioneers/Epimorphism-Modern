package cn.gtcommunity.epimorphism.api.pattern;

import cn.gtcommunity.epimorphism.api.pattern.utils.containers.FluidTankCellContainer;
import cn.gtcommunity.epimorphism.api.pattern.utils.containers.StorageFieldBlockContainer;
import cn.gtcommunity.epimorphism.api.structure.predicates.TierTraceabilityPredicateFactory;
import cn.gtcommunity.epimorphism.common.block.BlockMaps;
import com.gregtechceu.gtceu.api.pattern.TraceabilityPredicate;
import net.minecraft.network.chat.Component;

public class EPPredicates {
    public static TraceabilityPredicate glass() {
        return TierTraceabilityPredicateFactory.create(TierTraceabilityPredicateFactory.TraceabilityPredicateType.TIER, "Glass")
                .map(BlockMaps.ALL_GLASSES)
                .errorKey(Component.translatable("cn.gtcommunity.epimorphism.multiblock.pattern.error.glasses"))
                .build();
    }

    public static TraceabilityPredicate fluidTankCell() {
        return TierTraceabilityPredicateFactory.create(TierTraceabilityPredicateFactory.TraceabilityPredicateType.LOOSE, "FluidTankCell")
                .map(BlockMaps.ALL_FLUID_CELLS)
                .container(FluidTankCellContainer::new)
                .build();
    }

    public static TraceabilityPredicate storageFieldBlock() {
        return TierTraceabilityPredicateFactory.create(TierTraceabilityPredicateFactory.TraceabilityPredicateType.LOOSE, "StorageFieldBlock")
                .map(BlockMaps.ALL_FIELD_BLOCKS)
                .container(StorageFieldBlockContainer::new)
                .build();
    }

    public static TraceabilityPredicate componentAssemblyBlock() {
        return TierTraceabilityPredicateFactory.create(TierTraceabilityPredicateFactory.TraceabilityPredicateType.TIER, "CACasing")
                .map(BlockMaps.ALL_CA_TIRED_CASINGS)
                .build();
    }
}
