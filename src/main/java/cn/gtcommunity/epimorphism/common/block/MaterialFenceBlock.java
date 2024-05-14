package cn.gtcommunity.epimorphism.common.block;

import cn.gtcommunity.epimorphism.api.data.tag.EPTagPrefix;
import cn.gtcommunity.epimorphism.client.renderer.handler.block.FenceBlockRenderer;
import com.epimorphismmc.monomorphism.block.IMaterialBlock;
import com.gregtechceu.gtceu.api.block.IAppearance;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.lowdragmc.lowdraglib.Platform;
import lombok.Getter;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.color.block.BlockColor;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class MaterialFenceBlock extends FenceBlock implements IAppearance, IMaterialBlock {

    @Getter
    public final TagPrefix tagPrefix;
    @Getter
    public final Material material;

    public MaterialFenceBlock(Properties properties, Material material, boolean registerModel) {
        super(properties);
        this.material = material;
        this.tagPrefix = EPTagPrefix.fence;
        if (registerModel && Platform.isClient()) {
            FenceBlockRenderer.create(this);
        }
    }

    @Override
    public BlockState getAppearance(BlockState state, BlockAndTintGetter level, BlockPos pos, Direction side, @Nullable BlockState queryState, @Nullable BlockPos queryPos) {
        var appearance = this.getBlockAppearance(state, level, pos, side, queryState, queryPos);
        return appearance == null ? state : appearance;
    }

    @OnlyIn(Dist.CLIENT)
    public static BlockColor tintedColor() {
        return (state, reader, pos, tintIndex) -> {
            if (state.getBlock() instanceof IMaterialBlock block) {
                return block.getMaterial().getLayerARGB(tintIndex);
            }
            return -1;
        };
    }

    @Override
    public String getDescriptionId() {
        return tagPrefix.getUnlocalizedName(material);
    }

    @Override
    public MutableComponent getName() {
        return tagPrefix.getLocalizedName(material);
    }

    // FIXME Why does is(Tag) return false?
    @Override
    public boolean connectsTo(BlockState state, boolean isSideSolid, Direction direction) {
        Block block = state.getBlock();
        return block instanceof MaterialFenceBlock || super.connectsTo(state, isSideSolid, direction);
    }
}
