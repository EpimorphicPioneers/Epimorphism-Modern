package cn.gtcommunity.epimorphism.client.renderer.handler.block;

import cn.gtcommunity.epimorphism.Epimorphism;
import cn.gtcommunity.epimorphism.client.ClientUtil;
import com.gregtechceu.gtceu.client.model.SpriteOverrider;
import com.gregtechceu.gtceu.client.renderer.block.TextureOverrideRenderer;
import com.lowdragmc.lowdraglib.client.model.ModelFactory;
import com.mojang.blaze3d.vertex.PoseStack;
import java.util.Map;
import java.util.Objects;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.Font.DisplayMode;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.BlockModel;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.client.resources.model.BlockModelRotation;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.UnbakedModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.model.BakedModelWrapper;
import org.jetbrains.annotations.Nullable;

public class PlanetDisplayRenderer extends TextureOverrideRenderer {
    private final int tier;

    public PlanetDisplayRenderer(String planetName, int tier) {
        super(new ResourceLocation("block/cube"), Map.of("up", Epimorphism.id("block/planet/%s/top".formatted(planetName)), "down", Epimorphism.id("block/planet/%s/bottom".formatted(planetName)), "north", Epimorphism.id("block/planet/%s/back".formatted(planetName)), "south", Epimorphism.id("block/planet/%s/front".formatted(planetName)), "east", Epimorphism.id("block/planet/%s/right".formatted(planetName)), "west", Epimorphism.id("block/planet/%s/left".formatted(planetName)), "particle", Epimorphism.id("block/planet/%s/front".formatted(planetName))));
        this.tier = tier;
    }

    @OnlyIn(Dist.CLIENT)
    public void renderItem(ItemStack stack, ItemDisplayContext transformType, boolean leftHand, PoseStack poseStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay, BakedModel model) {
        super.renderItem(stack, transformType, leftHand, poseStack, buffer, combinedLight, combinedOverlay, model);
        if (transformType == ItemDisplayContext.GUI) {
            Font fontRender = ClientUtil.font();
            float smallTextScale = 0.75F;
            poseStack.pushPose();
            poseStack.scale(0.0625F, -0.0625F, 0.0625F);
            poseStack.translate(-8.0F, -8.0F, 50.0F);
            poseStack.scale(smallTextScale, smallTextScale, 1.0F);
            String subscript = "T" + this.tier;
            float var10003 = 16.0F / smallTextScale;
            Objects.requireNonNull(fontRender);
            fontRender.drawInBatch(subscript, 0.0F, var10003 - 9.0F + 1.0F, 16777215, true, poseStack.last().pose(), buffer, DisplayMode.NORMAL, 0, 15728880);
            poseStack.popPose();
        }

    }

    protected @Nullable BakedModel getItemBakedModel() {
        if (this.itemModel == null) {
            UnbakedModel model = this.getModel();
            if (model instanceof BlockModel) {
                BlockModel blockModel = (BlockModel)model;
                if (blockModel.getRootModel() == ModelBakery.GENERATION_MARKER) {
                    model = ModelFactory.ITEM_MODEL_GENERATOR.generateBlockModel(new SpriteOverrider(this.override), blockModel);
                }
            }

            BakedModel bakedModel = ((UnbakedModel)model).bake(ModelFactory.getModeBaker(), new SpriteOverrider(this.override), BlockModelRotation.X0_Y0, this.modelLocation);
            if (bakedModel != null) {
                this.itemModel = new BakedModelWrapper<BakedModel>(bakedModel) {
                    public boolean usesBlockLight() {
                        return false;
                    }

                    public boolean isGui3d() {
                        return false;
                    }
                };
            }
        }

        return this.itemModel;
    }
}
