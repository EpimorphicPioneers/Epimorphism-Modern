package cn.gtcommunity.epimorphism.api.pattern;

import cn.gtcommunity.epimorphism.api.pattern.utils.containers.FluidTankCellContainer;
import cn.gtcommunity.epimorphism.api.pattern.utils.containers.StorageFieldBlockContainer;
import cn.gtcommunity.epimorphism.api.structure.predicates.TraceabilityPredicateFactory;
import cn.gtcommunity.epimorphism.api.structure.predicates.TraceabilityPredicateType;
import cn.gtcommunity.epimorphism.common.block.BlockMaps;
import com.gregtechceu.gtceu.api.pattern.TraceabilityPredicate;
import net.minecraft.network.chat.Component;

public class EPPredicates {
    public static TraceabilityPredicate glass() {
        return TraceabilityPredicateFactory.create(TraceabilityPredicateType.TIER, "Glass")
                .map(BlockMaps.ALL_GLASSES)
                .errorKey(Component.translatable("epimorphism.multiblock.pattern.error.glasses"))
                .build();
    }

    public static TraceabilityPredicate fluidTankCell() {
        return TraceabilityPredicateFactory.create(TraceabilityPredicateType.LOOSE, "FluidTankCell")
                .map(BlockMaps.ALL_FLUID_CELLS)
                .container(FluidTankCellContainer::new)
                .build();
    }

    public static TraceabilityPredicate storageFieldBlock() {
        return TraceabilityPredicateFactory.create(TraceabilityPredicateType.LOOSE, "StorageFieldBlock")
                .map(BlockMaps.ALL_FIELD_BLOCKS)
                .container(StorageFieldBlockContainer::new)
                .build();
    }
}
