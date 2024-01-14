package cn.gtcommunity.epimorphism.common.block;

import cn.gtcommunity.epimorphism.api.structure.block.tier.ITierType;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;

public class BlockMaps {
    // Glasses
    public static final Object2ObjectOpenHashMap<ITierType, Supplier<Block>> ALL_GLASSES = new Object2ObjectOpenHashMap<>();
    public static final Object2ObjectOpenHashMap<ITierType, Supplier<Block>> SHAPE_GLASSES = new Object2ObjectOpenHashMap<>();

    // Yotta Fluid Tank
    public static final Object2ObjectOpenHashMap<ITierType, Supplier<Block>> ALL_FLUID_CELLS = new Object2ObjectOpenHashMap<>();

    // TFFT
    public static final Object2ObjectOpenHashMap<ITierType, Supplier<Block>> ALL_FIELD_BLOCKS = new Object2ObjectOpenHashMap<>();

    // Component Assembly Line
    public static final Object2ObjectOpenHashMap<ITierType, Supplier<Block>> ALL_CA_TIRED_CASINGS = new Object2ObjectOpenHashMap<>();

    // Chemical Plant
    public static final Object2ObjectOpenHashMap<ITierType, Supplier<Block>> ALL_MACHINE_CASINGS = new Object2ObjectOpenHashMap<>();
    public static final Object2ObjectOpenHashMap<ITierType, Supplier<Block>> ALL_CP_CASINGS = new Object2ObjectOpenHashMap<>();
    public static final Object2ObjectOpenHashMap<ITierType, Supplier<Block>> ALL_CP_TUBES = new Object2ObjectOpenHashMap<>();
}
