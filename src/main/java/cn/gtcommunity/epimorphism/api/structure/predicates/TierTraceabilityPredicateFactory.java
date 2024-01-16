package cn.gtcommunity.epimorphism.api.structure.predicates;

import cn.gtcommunity.epimorphism.api.structure.block.tier.ITierType;
import cn.gtcommunity.epimorphism.api.structure.utils.IValueContainer;
import cn.gtcommunity.epimorphism.api.structure.utils.UniverUtil;
import com.gregtechceu.gtceu.api.pattern.MultiblockState;
import com.gregtechceu.gtceu.api.pattern.TraceabilityPredicate;
import com.gregtechceu.gtceu.api.pattern.error.PatternStringError;
import com.lowdragmc.lowdraglib.utils.BlockInfo;
import it.unimi.dsi.fastutil.objects.Object2ObjectMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import lombok.Setter;
import lombok.experimental.Accessors;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.block.Block;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class TierTraceabilityPredicateFactory {

    private final TraceabilityPredicateType type;
    private final String tName;
    @Setter @Accessors(fluent = true, chain = true)
    private Object2ObjectOpenHashMap<ITierType, Supplier<Block>> map;
    @Setter @Accessors(fluent = true, chain = true)
    private Component errorKey;
    @Setter @Accessors(fluent = true, chain = true)
    private Comparator<ITierType> comparator;
    @Setter @Accessors(fluent = true, chain = true)
    private Predicate<ITierType> predicate;
    @Setter @Accessors(fluent = true, chain = true)
    private Supplier<IValueContainer<?>> container;
    private static final Map<String, BlockInfo[]> CACHE = new HashMap<>();

    protected TierTraceabilityPredicateFactory(TraceabilityPredicateType type, String name) {
        this.type = type;
        this.tName = name;
    }

    public static TierTraceabilityPredicateFactory create(TraceabilityPredicateType type, String name) {
        return new TierTraceabilityPredicateFactory(type, name);
    }

    public TraceabilityPredicate build() {
        return switch (type) {
            case TIER -> new TraceabilityPredicate(
                    getTierPredicate(tName,
                            UniverUtil.getOrDefault(map, Object2ObjectOpenHashMap<ITierType, Supplier<Block>>::new),
                            UniverUtil.getOrDefault(container, () -> IValueContainer::noop),
                            UniverUtil.getOrDefault(errorKey, () -> Component.translatable("structure.multiblock.pattern.error.casing"))
                    ),
                    getCandidates(tName,
                            UniverUtil.getOrDefault(map, Object2ObjectOpenHashMap<ITierType, Supplier<Block>>::new),
                            UniverUtil.getOrDefault(comparator, () -> Comparator.comparingInt(ITierType::tier)),
                            UniverUtil.getOrDefault(predicate, () -> BlockState -> true)
                    ));
            case LOOSE -> new TraceabilityPredicate(
                    getLoosePredicate(tName,
                            UniverUtil.getOrDefault(map, Object2ObjectOpenHashMap<ITierType, Supplier<Block>>::new),
                            UniverUtil.getOrDefault(container, () -> IValueContainer::noop)
                    ),
                    getCandidates(tName,
                            UniverUtil.getOrDefault(map, Object2ObjectOpenHashMap<ITierType, Supplier<Block>>::new),
                            UniverUtil.getOrDefault(comparator, () -> Comparator.comparingInt(ITierType::tier)),
                            UniverUtil.getOrDefault(predicate, () -> BlockState -> true)
                    ));
        };
    }

    private Predicate<MultiblockState> getLoosePredicate(String name, Object2ObjectOpenHashMap<ITierType, Supplier<Block>> map, Supplier<IValueContainer<?>> containerSupplier) {
        return  (blockWorldState) -> {
            var blockState = blockWorldState.getBlockState();
            var objectIterator = map.object2ObjectEntrySet().fastIterator();
            while (objectIterator.hasNext()) {
                Object2ObjectMap.Entry<ITierType, Supplier<Block>> entry = objectIterator.next();
                if (blockState.is(entry.getValue().get())) {
                    IValueContainer<?> currentContainer = blockWorldState.getMatchContext().getOrPut(name + "Value", containerSupplier.get());
                    currentContainer.operate(blockState.getBlock(), entry.getKey());
                    return true;
                }
            }
            return false;
        };
    }

    private Predicate<MultiblockState> getTierPredicate(String name, Object2ObjectOpenHashMap<ITierType, Supplier<Block>> map, Supplier<IValueContainer<?>> containerSupplier, Component errorKey) {
        return  (blockWorldState) -> {
            var blockState = blockWorldState.getBlockState();
            var objectIterator = map.object2ObjectEntrySet().fastIterator();
            while (objectIterator.hasNext()) {
                Object2ObjectMap.Entry<ITierType, Supplier<Block>> entry = objectIterator.next();
                if (blockState.is(entry.getValue().get())) {
                    var stats = entry.getKey();
                    Object currentStats = blockWorldState.getMatchContext().getOrPut(name, stats);
                    if (!currentStats.equals(stats)) {
                        blockWorldState.setError(new PatternStringError(errorKey.getString()));
                        return false;
                    }
                    IValueContainer<?> currentContainer = blockWorldState.getMatchContext().getOrPut(name + "Value", containerSupplier.get());
                    currentContainer.operate(blockState.getBlock(), stats);
                    return true;
                }
            }
            return false;
        };
    }

    private Supplier<BlockInfo[]> getCandidates(String name, Object2ObjectOpenHashMap<ITierType, Supplier<Block>> map, Comparator<ITierType> comparator, Predicate<ITierType> predicate) {
        return () -> CACHE.computeIfAbsent(name, key -> map.keySet().stream()
                        .filter(predicate)
                        .sorted(comparator)
                        .map(type -> BlockInfo.fromBlockState(map.get(type).get().defaultBlockState()))
                        .toArray(BlockInfo[]::new));
    }

    public enum TraceabilityPredicateType {
        TIER,
        LOOSE
    }
}
