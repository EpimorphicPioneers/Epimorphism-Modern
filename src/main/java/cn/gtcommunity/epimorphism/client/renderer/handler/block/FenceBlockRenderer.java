package cn.gtcommunity.epimorphism.client.renderer.handler.block;

import cn.gtcommunity.epimorphism.api.data.tag.EPTagPrefix;
import cn.gtcommunity.epimorphism.common.block.MaterialFenceBlock;
import cn.gtcommunity.epimorphism.core.mixins.accessors.BlockModelGeneratorsAccessor;
import cn.gtcommunity.epimorphism.data.model.EPModelTemplates;
import com.gregtechceu.gtceu.data.pack.GTDynamicResourcePack;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.models.model.TextureMapping;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.HashSet;
import java.util.Set;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class FenceBlockRenderer {

    private static final Set<FenceBlockRenderer> MODELS = new HashSet<>();

    private final MaterialFenceBlock block;

    public static void create(MaterialFenceBlock block) {
        MODELS.add(new FenceBlockRenderer(block));
    }

    public FenceBlockRenderer(MaterialFenceBlock block) {
        this.block = block;
    }

    public static void reinitModels() {
        for (FenceBlockRenderer model : MODELS) {
            var blockId = BuiltInRegistries.BLOCK.getKey(model.block);
            var modelId = blockId.withPrefix("block/");
            var fencePostModelLocation = modelId.withSuffix("_fence_post");
            var fenceSideModelLocation = modelId.withSuffix("_fence_side");
            var texture = EPTagPrefix.fence.materialIconType().getBlockTexturePath(model.block.material.getMaterialIconSet(), true);

            EPModelTemplates.TINT_FENCE_POST.create(fencePostModelLocation, TextureMapping.defaultTexture(texture), GTDynamicResourcePack::addBlockModel);
            EPModelTemplates.TINT_FENCE_SIDE.create(fenceSideModelLocation, TextureMapping.defaultTexture(texture), GTDynamicResourcePack::addBlockModel);
            GTDynamicResourcePack.addBlockState(blockId, BlockModelGeneratorsAccessor.callCreateFence(model.block, fencePostModelLocation, fenceSideModelLocation));
            EPModelTemplates.TINT_FENCE_INVENTORY.create(BuiltInRegistries.ITEM.getKey(model.block.asItem()), TextureMapping.defaultTexture(texture), GTDynamicResourcePack::addItemModel);
        }
    }

}
