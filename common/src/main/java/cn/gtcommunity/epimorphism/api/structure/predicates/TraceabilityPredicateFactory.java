package cn.gtcommunity.epimorphism.api.structure.predicates;

import cn.gtcommunity.epimorphism.api.structure.block.tier.ITierType;
import cn.gtcommunity.epimorphism.api.structure.utils.IValueContainer;
import cn.gtcommunity.epimorphism.api.structure.utils.UniverUtil;
import com.gregtechceu.gtceu.api.pattern.TraceabilityPredicate;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.block.Block;

import java.util.Comparator;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class TraceabilityPredicateFactory {

    private final TraceabilityPredicateType type;
    private final String name;
    private Object2ObjectOpenHashMap<ITierType, Supplier<Block>> map;
    private Component errorKey;
    private Comparator<ITierType> comparator;
    private Predicate<ITierType> predicate;
    private IValueContainer container;

    protected TraceabilityPredicateFactory(TraceabilityPredicateType type, String name) {
        this.type = type;
        this.name = name;
    }

    public static TraceabilityPredicateFactory create(TraceabilityPredicateType type, String name) {
        return new TraceabilityPredicateFactory(type, name);
    }

    public TraceabilityPredicate build() {
        return switch (type) {
            case TIER -> new TierTraceabilityPredicate(name,
                    UniverUtil.getOrDefault(map, Object2ObjectOpenHashMap<ITierType, Supplier<Block>>::new),
                    UniverUtil.getOrDefault(comparator, () -> Comparator.comparingInt(ITierType::tier)),
                    UniverUtil.getOrDefault(predicate, () -> BlockState -> true),
                    UniverUtil.getOrDefault(errorKey, () -> Component.translatable("structure.multiblock.pattern.error.casing")),
                    UniverUtil.getOrDefault(container, IValueContainer::noop)
            );
            case LOOSE -> new LooselyTraceabilityPredicate(name,
                    UniverUtil.getOrDefault(map, Object2ObjectOpenHashMap<ITierType, Supplier<Block>>::new),
                    UniverUtil.getOrDefault(comparator, () -> Comparator.comparingInt(ITierType::tier)),
                    UniverUtil.getOrDefault(predicate, () -> BlockState -> true),
                    UniverUtil.getOrDefault(errorKey, () -> Component.translatable("structure.multiblock.pattern.error.casing")),
                    UniverUtil.getOrDefault(container, IValueContainer::noop)
            );
        };
    }

    public TraceabilityPredicateFactory map(Object2ObjectOpenHashMap<ITierType, Supplier<Block>> map) {
        this.map = map;
        return this;
    }

    public TraceabilityPredicateFactory errorKey(Component errorKey) {
        this.errorKey = errorKey;
        return this;
    }

    public TraceabilityPredicateFactory comparator(Comparator<ITierType> comparator) {
        this.comparator = comparator;
        return this;
    }

    public TraceabilityPredicateFactory predicate(Predicate<ITierType> predicate) {
        this.predicate = predicate;
        return this;
    }
    public TraceabilityPredicateFactory container(IValueContainer container) {
        this.container = container;
        return this;
    }
}
