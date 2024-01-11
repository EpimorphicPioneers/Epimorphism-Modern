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
    private Object2ObjectOpenHashMap<ITierType, Supplier<Block>> tMap;
    private Component tErrorKey;
    private Comparator<ITierType> tComparator;
    private Predicate<ITierType> tPredicate;
    private Supplier<IValueContainer<?>> tContainerSupplier;
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
                            UniverUtil.getOrDefault(tMap, Object2ObjectOpenHashMap<ITierType, Supplier<Block>>::new),
                            UniverUtil.getOrDefault(tContainerSupplier, () -> IValueContainer::noop),
                            UniverUtil.getOrDefault(tErrorKey, () -> Component.translatable("structure.multiblock.pattern.error.casing"))
                    ),
                    getCandidates(tName,
                            UniverUtil.getOrDefault(tMap, Object2ObjectOpenHashMap<ITierType, Supplier<Block>>::new),
                            UniverUtil.getOrDefault(tComparator, () -> Comparator.comparingInt(ITierType::tier)),
                            UniverUtil.getOrDefault(tPredicate, () -> BlockState -> true)
                    ));
            case LOOSE -> new TraceabilityPredicate(
                    getLoosePredicate(tName,
                            UniverUtil.getOrDefault(tMap, Object2ObjectOpenHashMap<ITierType, Supplier<Block>>::new),
                            UniverUtil.getOrDefault(tContainerSupplier, () -> IValueContainer::noop)
                    ),
                    getCandidates(tName,
                            UniverUtil.getOrDefault(tMap, Object2ObjectOpenHashMap<ITierType, Supplier<Block>>::new),
                            UniverUtil.getOrDefault(tComparator, () -> Comparator.comparingInt(ITierType::tier)),
                            UniverUtil.getOrDefault(tPredicate, () -> BlockState -> true)
                    ));
        };
    }

    public TierTraceabilityPredicateFactory map(Object2ObjectOpenHashMap<ITierType, Supplier<Block>> map) {
        this.tMap = map;
        return this;
    }

    public TierTraceabilityPredicateFactory errorKey(Component errorKey) {
        this.tErrorKey = errorKey;
        return this;
    }

    public TierTraceabilityPredicateFactory comparator(Comparator<ITierType> comparator) {
        this.tComparator = comparator;
        return this;
    }

    public TierTraceabilityPredicateFactory predicate(Predicate<ITierType> predicate) {
        this.tPredicate = predicate;
        return this;
    }
    public TierTraceabilityPredicateFactory container(Supplier<IValueContainer<?>> container) {
        this.tContainerSupplier = container;
        return this;
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
