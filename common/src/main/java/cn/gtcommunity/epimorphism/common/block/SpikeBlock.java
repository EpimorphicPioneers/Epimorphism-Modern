package cn.gtcommunity.epimorphism.common.block;

import cn.gtcommunity.epimorphism.client.model.SpikeModel;
import com.lowdragmc.lowdraglib.client.renderer.IBlockRendererProvider;
import com.lowdragmc.lowdraglib.client.renderer.IRenderer;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class SpikeBlock extends HorizontalDirectionalBlock implements IBlockRendererProvider {
    public SpikeBlock(Properties properties) {
        super(properties);
    }

    @Nullable
    @Override
    public IRenderer getRenderer(BlockState state) {
        return new IRenderer() {
            @Override
            public List<BakedQuad> renderModel(@Nullable BlockAndTintGetter level, @Nullable BlockPos pos, @Nullable BlockState state, @Nullable Direction side, RandomSource rand) {
                return new SpikeModel().bakeQuads(side);
            }
        };
    }
}
