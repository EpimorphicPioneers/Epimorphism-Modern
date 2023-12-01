package cn.gtcommunity.epimorphism.common.block;

import cn.gtcommunity.epimorphism.api.block.ITierGlassType;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class BlockMaps {
    public static final Map<ITierGlassType, Supplier<TierGlassBlock>> ALL_GLASSES = new HashMap<>();
}
