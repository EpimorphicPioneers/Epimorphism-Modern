package com.epimorphismmc.epimorphism.client.renderer.handler.item;

import com.epimorphismmc.epimorphism.common.item.behaviors.GrindBallBehaviour;

import com.epimorphismmc.monomorphism.client.renderer.item.WrappedItemRenderer;

import com.gregtechceu.gtceu.api.item.component.ICustomRenderer;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import com.mojang.blaze3d.vertex.PoseStack;

import java.util.Optional;

public class GrindBallRenderer extends WrappedItemRenderer {

    public static final GrindBallRenderer INSTANCE = new GrindBallRenderer();

    @Override
    @OnlyIn(Dist.CLIENT)
    public void renderItem(
            ItemStack stack,
            ItemDisplayContext transformType,
            boolean leftHand,
            PoseStack poseStack,
            MultiBufferSource buffer,
            int combinedLight,
            int combinedOverlay,
            BakedModel model) {
        var tModel = getVanillaModel(stack, null, null);
        Optional.ofNullable(GrindBallBehaviour.getBehaviour(stack))
                .map(b -> b.getCustomRenderer(stack))
                .map(ICustomRenderer::getRenderer)
                .ifPresentOrElse(
                        r -> r.renderItem(
                                stack,
                                transformType,
                                leftHand,
                                poseStack,
                                buffer,
                                combinedLight,
                                combinedOverlay,
                                model),
                        () -> vanillaRender(
                                stack,
                                transformType,
                                leftHand,
                                poseStack,
                                buffer,
                                combinedLight,
                                combinedOverlay,
                                tModel));
    }
}
