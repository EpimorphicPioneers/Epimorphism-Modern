package cn.gtcommunity.epimorphism.api.pattern;

import cn.gtcommunity.epimorphism.api.pattern.utils.containers.FluidTankCellContainer;
import cn.gtcommunity.epimorphism.api.pattern.utils.containers.StorageFieldBlockContainer;
import cn.gtcommunity.epimorphism.api.structure.UniverTraceabilityPredicate;
import cn.gtcommunity.epimorphism.api.structure.predicates.TierTraceabilityPredicateFactory;
import cn.gtcommunity.epimorphism.api.structure.utils.SimpleValueContainer;
import cn.gtcommunity.epimorphism.common.block.BlockMaps;
import cn.gtcommunity.epimorphism.common.data.EPBlocks;
import com.gregtechceu.gtceu.api.pattern.Predicates;
import com.gregtechceu.gtceu.api.pattern.TraceabilityPredicate;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.block.Block;

public class EPPredicates {
    // Glasses
    public static TraceabilityPredicate glass() {
        return TierTraceabilityPredicateFactory.create(TierTraceabilityPredicateFactory.TraceabilityPredicateType.TIER, "Glass")
                .map(BlockMaps.ALL_GLASSES)
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

    public static TraceabilityPredicate CPMachineCasingBlock() {
        return TierTraceabilityPredicateFactory.create(TierTraceabilityPredicateFactory.TraceabilityPredicateType.TIER, "CPMachineCasing")
                .map(BlockMaps.ALL_MACHINE_CASINGS)
                .build();
    }

    // Solar Tower
    public static TraceabilityPredicate mirrorBlock(int tier) {
        return UniverTraceabilityPredicate.tierOptionalPredicate("Mirror", tier, Predicates.blocks(EPBlocks.TFFT_CASING.get()));
    }

    // Univer
    public static TraceabilityPredicate countBlock(String name, Block... blocks) {
        return UniverTraceabilityPredicate.enhancePredicate(name,
                () -> new SimpleValueContainer<>(0, (integer, block, tierType) -> ++integer), Predicates.blocks(blocks), null);
    }
}
