package cn.gtcommunity.epimorphism.api.structure.predicates;

import cn.gtcommunity.epimorphism.api.structure.block.tier.ITierType;
import cn.gtcommunity.epimorphism.api.structure.utils.IValueContainer;
import com.gregtechceu.gtceu.api.pattern.MultiblockState;
import com.gregtechceu.gtceu.api.pattern.TraceabilityPredicate;
import com.gregtechceu.gtceu.api.pattern.predicates.SimplePredicate;
import com.lowdragmc.lowdraglib.utils.BlockInfo;
import it.unimi.dsi.fastutil.objects.Object2ObjectMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.block.Block;

import javax.annotation.Nullable;
import java.util.Comparator;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LooselyTraceabilityPredicate extends TraceabilityPredicate {
    private final Object2ObjectOpenHashMap<ITierType, Supplier<Block>> map;
    private final String name;

    private Supplier<BlockInfo[]> candidatesCache;

    private final Comparator<ITierType> comparator;
    private final Predicate<ITierType> predicate;
    private final IValueContainer valueContainer;

    public LooselyTraceabilityPredicate(String name, Object2ObjectOpenHashMap<ITierType, Supplier<Block>> map, Comparator<ITierType> comparator, Predicate<ITierType> predicate, @Nullable Component tooltip, IValueContainer container){
        super();
        this.map = map;
        this.name = name;
        this.valueContainer = container;
        this.common.add(new SimplePredicate(predicate(), candidates()));
        this.comparator = comparator;
        this.predicate = predicate;
        this.addTooltips(tooltip);
    }

    private Predicate<MultiblockState> predicate() {
        return  (blockWorldState) -> {
            var blockState = blockWorldState.getBlockState();
            var objectIterator = map.object2ObjectEntrySet().fastIterator();
            while (objectIterator.hasNext()) {
                Object2ObjectMap.Entry<ITierType, Supplier<Block>> entry = objectIterator.next();
                if (blockState.is(entry.getValue().get())) {
                    IValueContainer currentContainer = blockWorldState.getMatchContext().getOrPut(name + "Value", valueContainer);
                    currentContainer.operate(blockState.getBlock(), entry.getKey());
                    return true;
                }
            }
            return false;
        };
    }

    private Supplier<BlockInfo[]> candidates(){
        if(candidatesCache == null) {
            candidatesCache = () -> map.keySet().stream()
                    .filter(predicate)
                    .sorted(comparator)
                    .map(type -> BlockInfo.fromBlockState(map.get(type).get().defaultBlockState()))
                    .toArray(BlockInfo[]::new);
        }
        return candidatesCache;
    }
}
