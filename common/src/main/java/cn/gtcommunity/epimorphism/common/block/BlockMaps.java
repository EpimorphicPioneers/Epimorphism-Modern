package cn.gtcommunity.epimorphism.common.block;

import cn.gtcommunity.epimorphism.api.structure.block.tier.ITierType;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;

public class BlockMaps {
    public static final Object2ObjectOpenHashMap<ITierType, Supplier<Block>> ALL_GLASSES = new Object2ObjectOpenHashMap<>();

    public static final Object2ObjectOpenHashMap<ITierType, Supplier<Block>> ALL_FLUID_CELLS = new Object2ObjectOpenHashMap<>();

    public static final Object2ObjectOpenHashMap<ITierType, Supplier<Block>> ALL_FIELD_BLOCKS = new Object2ObjectOpenHashMap<>();
}
