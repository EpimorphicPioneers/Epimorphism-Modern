package cn.gtcommunity.epimorphism.client.renderer.handler.item;

import cn.gtcommunity.epimorphism.client.ClientUtil;
import cn.gtcommunity.epimorphism.client.item.IRendererMetaInfo;
import cn.gtcommunity.epimorphism.common.item.behaviors.renderer.IHaloRenderBehavior;
import cn.gtcommunity.epimorphism.client.lib.AlphaVertexConsumer;
import cn.gtcommunity.epimorphism.client.utils.ColorHelper;
import cn.gtcommunity.epimorphism.utils.EPMathUtil;
import com.lowdragmc.lowdraglib.Platform;
import com.lowdragmc.lowdraglib.client.model.ModelFactory;
import com.lowdragmc.lowdraglib.client.renderer.IItemRendererProvider;
import com.lowdragmc.lowdraglib.client.renderer.IRenderer;
import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.*;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import org.joml.Matrix4f;

import java.util.*;
import java.util.function.Consumer;

public class HaloItemRenderer implements IRenderer {
    private static final Set<ResourceLocation> TEXTURES = new HashSet<>();
    public static final HaloItemRenderer INSTANCE = new HaloItemRenderer();

    public HaloItemRenderer() {
        if (Platform.isClient()) {
            registerEvent();
        }
    }

    @Environment(EnvType.CLIENT)
    public void addTexture(ResourceLocation resourceLocation) {
        TEXTURES.add(resourceLocation);
    }

    @Override
    @Environment(EnvType.CLIENT)
    public void renderItem(ItemStack stack,
                           ItemDisplayContext transformType,
                           boolean leftHand, PoseStack poseStack,
                           MultiBufferSource buffer, int combinedLight,
                           int combinedOverlay, BakedModel model) {
        model = ClientUtil.itemRenderer().getItemModelShaper().getItemModel(stack.getItem());
        if (transformType == ItemDisplayContext.GUI && stack.getItem() instanceof IRendererMetaInfo componentItem) {

            if (componentItem.getMetaInfo() instanceof IHaloRenderBehavior hri) {
                Tesselator tess = Tesselator.getInstance();
                BufferBuilder buf = tess.getBuilder();
                buf.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX);

                poseStack.pushPose();
                RenderSystem.enableBlend();
                RenderSystem.disableDepthTest();
                RenderSystem.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);

                poseStack.translate(-0.5F, -0.5F, -0.5F);

                if (hri.shouldDrawHalo()) {
                    int colour = hri.haloColour();
                    float r = ColorHelper.ARGB32.red(colour);
                    float g = ColorHelper.ARGB32.green(colour);
                    float b = ColorHelper.ARGB32.blue(colour);
                    float a = ColorHelper.ARGB32.alpha(colour);

                    RenderSystem.setShaderColor(r, g, b, a);
                    RenderSystem.setShader(GameRenderer::getPositionTexShader);
                    TextureAtlasSprite sprite = ModelFactory.getBlockSprite(hri.haloTexture());
                    ClientUtil.bindTexture(InventoryMenu.BLOCK_ATLAS);
                    float spread = hri.haloSize() / 16F;
                    float min = 0F - spread;
                    float max = 1F + spread;

                    float minU = sprite.getU0();
                    float maxU = sprite.getU1();
                    float minV = sprite.getV0();
                    float maxV = sprite.getV1();

                    Matrix4f pos = poseStack.last().pose();
                    buf.vertex(pos, max, max, 0).uv(maxU, minV).endVertex();
                    buf.vertex(pos, min, max, 0).uv(minU, minV).endVertex();
                    buf.vertex(pos, min, min, 0).uv(minU, maxV).endVertex();
                    buf.vertex(pos, max, min, 0).uv(maxU, maxV).endVertex();
                    tess.end();

                    RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
                    poseStack.popPose();
                }

                vanillaRender(stack, transformType, leftHand, poseStack, buffer, combinedLight, combinedOverlay, model);

                if (hri.shouldDrawPulse()) {
                    poseStack.pushPose();
                    poseStack.translate(-0.5F, -0.5F, -0.5F);
                    float scale = EPMathUtil.RAND.nextFloat() * 0.15F + 0.95F;
                    double trans = (1 - scale) / 2;
                    poseStack.translate(trans, trans, 0);
                    poseStack.scale(scale, scale, 1.0001F);

                    renderAlpha(stack, transformType, leftHand, poseStack, buffer, combinedLight, combinedOverlay, model, 0.6F);

                    poseStack.popPose();
                }
                RenderSystem.enableDepthTest();
                RenderSystem.disableBlend();

            }else {
                vanillaRender(stack, transformType, leftHand, poseStack, buffer, combinedLight, combinedOverlay, model);
            }

        }else {
            vanillaRender(stack, transformType, leftHand, poseStack, buffer, combinedLight, combinedOverlay, model);
        }
    }

    @Environment(EnvType.CLIENT)
    private void vanillaRender(ItemStack stack, ItemDisplayContext transformType, boolean leftHand, PoseStack poseStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay, BakedModel model) {
        IItemRendererProvider.disabled.set(true);
        Minecraft.getInstance().getItemRenderer().render(stack, transformType, leftHand, poseStack, buffer, combinedLight, combinedOverlay, model);
        IItemRendererProvider.disabled.set(false);
    }

    @Environment(EnvType.CLIENT)
    public static void renderAlpha(ItemStack stack, ItemDisplayContext modelTransformationMode, boolean leftHanded, PoseStack matrices, MultiBufferSource buffer, int light, int overlay, BakedModel model, float alphaOverride) {
        if (!stack.isEmpty()) {
            model.getTransforms().getTransform(modelTransformationMode).apply(leftHanded, matrices);
            RenderType renderType = ItemBlockRenderTypes.getRenderType(stack, true);
            VertexConsumer vertexConsumer = ItemRenderer.getFoilBufferDirect(buffer, renderType, true, stack.hasFoil());

            Minecraft.getInstance().getItemRenderer().renderModelLists(model, stack, light, overlay, matrices, new AlphaVertexConsumer(vertexConsumer, alphaOverride));
        }
    }

    @Override
    @Environment(EnvType.CLIENT)
    public void onPrepareTextureAtlas(ResourceLocation atlasName, Consumer<ResourceLocation> register) {
        if (atlasName.equals(InventoryMenu.BLOCK_ATLAS)) {
            TEXTURES.forEach(register);
        }
    }
}
