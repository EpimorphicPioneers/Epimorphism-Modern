package cn.gtcommunity.epimorphism.client.renderer.handler.item;

import cn.gtcommunity.epimorphism.client.utils.RenderHelper;
import cn.gtcommunity.epimorphism.common.item.behaviors.GrindBallBehaviour;
import com.gregtechceu.gtceu.api.item.component.ICustomRenderer;
import com.lowdragmc.lowdraglib.client.renderer.IRenderer;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Optional;
// TODO Maybe use IModelRenderer?
public class GrindBallRenderer implements IRenderer {

    public static final GrindBallRenderer INSTANCE = new GrindBallRenderer();

    @Override
    @OnlyIn(Dist.CLIENT)
    public void renderItem(ItemStack stack, ItemDisplayContext transformType, boolean leftHand, PoseStack poseStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay, BakedModel model) {
        var tModel = RenderHelper.getVanillaModel(stack, null, null);
        Optional.ofNullable(GrindBallBehaviour.getBehaviour(stack))
                .map(b -> b.getCustomRenderer(stack))
                .map(ICustomRenderer::getRenderer)
                .ifPresentOrElse(r -> r.renderItem(stack, transformType, leftHand, poseStack, buffer, combinedLight, combinedOverlay, model),
                        () -> RenderHelper.vanillaRender(stack, transformType, leftHand, poseStack, buffer, combinedLight, combinedOverlay, tModel));
    }
}
