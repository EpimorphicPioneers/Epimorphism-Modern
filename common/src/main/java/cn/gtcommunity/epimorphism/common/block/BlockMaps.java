package cn.gtcommunity.epimorphism.common.block;

import cn.gtcommunity.epimorphism.api.block.ITierGlassType;
import net.minecraft.world.level.block.Block;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class BlockMaps {
    public static final Map<ITierGlassType, Supplier<Block>> ALL_GLASSES = new HashMap<>();
}
