package cn.gtcommunity.epimorphism.client.renderer.handler.item;

import cn.gtcommunity.epimorphism.client.ClientUtil;
import cn.gtcommunity.epimorphism.client.utils.RenderHelper;
import com.lowdragmc.lowdraglib.client.renderer.IRenderer;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.joml.Quaternionf;

public class StereoscopicItemRenderer implements IRenderer {

    public static final StereoscopicItemRenderer INSTANCE = new StereoscopicItemRenderer();

    @Override
    @OnlyIn(Dist.CLIENT)
    public void renderItem(ItemStack stack, ItemDisplayContext transformType, boolean leftHand, PoseStack poseStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay, BakedModel model) {
        model = ClientUtil.itemRenderer().getItemModelShaper().getItemModel(stack.getItem());
        poseStack.pushPose();
        if (transformType == ItemDisplayContext.GUI && model != null) {
            long millis = System.currentTimeMillis();
            poseStack.mulPose(new Quaternionf().fromAxisAngleDeg(0.3f, 0.5f, 0.2f, (millis / 25) % 360));
            poseStack.mulPose(Axis.XP.rotationDegrees(180));
        }
        RenderHelper.vanillaRender(stack, transformType, leftHand, poseStack, buffer, combinedLight, combinedOverlay, model);
        poseStack.popPose();
    }
}
