package cn.gtcommunity.epimorphism.client.renderer.handler.item;

import cn.gtcommunity.epimorphism.common.item.behaviors.renderer.TierRenderItemBehavior;
import com.epimorphismmc.monomorphism.item.component.IRendererItem;
import com.lowdragmc.lowdraglib.Platform;
import com.lowdragmc.lowdraglib.client.model.ModelFactory;
import com.lowdragmc.lowdraglib.client.renderer.IRenderer;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.*;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.joml.Matrix4f;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;

import static com.epimorphismmc.monomorphism.client.utils.ClientUtils.*;
import static com.epimorphismmc.monomorphism.client.utils.MORenderUtils.*;

public class TierItemRenderer implements IRenderer {
    private static final Set<ResourceLocation> TEXTURES = new HashSet<>();
    public static final TierItemRenderer INSTANCE = new TierItemRenderer();

    public TierItemRenderer() {
        if (Platform.isClient()) {
            registerEvent();
        }
    }

    @OnlyIn(Dist.CLIENT)
    public void addTexture(ResourceLocation resourceLocation) {
        TEXTURES.add(resourceLocation);
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void renderItem(ItemStack stack,
                           ItemDisplayContext transformType,
                           boolean leftHand, PoseStack poseStack,
                           MultiBufferSource buffer, int combinedLight,
                           int combinedOverlay, BakedModel model) {
        model = getVanillaModel(stack, null, null);

        if (transformType == ItemDisplayContext.GUI
                && stack.getItem() instanceof IRendererItem rendererItem
                && rendererItem.getRenderInfo(stack) instanceof TierRenderItemBehavior tri) {

            Tesselator tess = Tesselator.getInstance();

            var buffers = MultiBufferSource.immediate(tess.getBuilder());
            vanillaRender(stack, transformType, leftHand, poseStack, buffers, combinedLight, combinedOverlay, model);
            buffers.endBatch();

            BufferBuilder buf = tess.getBuilder();
            buf.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX);

            poseStack.pushPose();
            poseStack.translate(-0.5F, -0.5F, -0.5F);

            RenderSystem.setShader(GameRenderer::getPositionTexShader);
            TextureAtlasSprite sprite = ModelFactory.getBlockSprite(tri.tierTexture());
            bindTexture(InventoryMenu.BLOCK_ATLAS);

            float minU = sprite.getU0();
            float maxU = sprite.getU1();
            float minV = sprite.getV0();
            float maxV = sprite.getV1();

            Matrix4f pos = poseStack.last().pose();
            buf.vertex(pos, 1, 1, 0).uv(maxU, minV).endVertex();
            buf.vertex(pos, 0, 1, 0).uv(minU, minV).endVertex();
            buf.vertex(pos, 0, 0, 0).uv(minU, maxV).endVertex();
            buf.vertex(pos, 1, 0, 0).uv(maxU, maxV).endVertex();
            tess.end();

            poseStack.popPose();
        } else {
            vanillaRender(stack, transformType, leftHand, poseStack, buffer, combinedLight, combinedOverlay, model);
        }
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void onPrepareTextureAtlas(ResourceLocation atlasName, Consumer<ResourceLocation> register) {
        if (atlasName.equals(InventoryMenu.BLOCK_ATLAS)) {
            TEXTURES.forEach(register);
        }
    }
}

