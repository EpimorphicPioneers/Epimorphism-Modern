package com.epimorphismmc.epimorphism.core.mixins.accessors;

import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.models.blockstates.BlockStateGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(BlockModelGenerators.class)
public interface BlockModelGeneratorsAccessor {

    @Invoker
    static BlockStateGenerator callCreateFence(
            Block fenceBlock,
            ResourceLocation fencePostModelLocation,
            ResourceLocation fenceSideModelLocation) {
        throw new UnsupportedOperationException();
    }
}
