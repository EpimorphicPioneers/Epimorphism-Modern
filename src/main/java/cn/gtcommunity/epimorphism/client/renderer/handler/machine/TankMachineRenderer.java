package cn.gtcommunity.epimorphism.client.renderer.handler.machine;

import cn.gtcommunity.epimorphism.api.machine.feature.multiblock.ITankMachine;
import cn.gtcommunity.epimorphism.client.ClientUtil;
import cn.gtcommunity.epimorphism.client.model.geometry.Model3D;
import cn.gtcommunity.epimorphism.client.renderer.handler.CubeRenderer;
import cn.gtcommunity.epimorphism.client.utils.RenderHelper;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.feature.multiblock.IWorkableMultiController;
import com.gregtechceu.gtceu.client.renderer.machine.WorkableCasingMachineRenderer;
import com.lowdragmc.lowdraglib.client.utils.RenderUtils;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class TankMachineRenderer extends WorkableCasingMachineRenderer {
    public TankMachineRenderer(ResourceLocation baseCasing, ResourceLocation workableModel) {
        super(baseCasing, workableModel);
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public boolean hasTESR(BlockEntity blockEntity) {
        return true;
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void render(BlockEntity blockEntity, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
        if (blockEntity instanceof IMachineBlockEntity machineBlockEntity) {
            var metaMachine = machineBlockEntity.getMetaMachine();
            if (metaMachine instanceof IWorkableMultiController controller
                    && controller.isActive()
                    && metaMachine instanceof ITankMachine tank) {
                var frontFacing = metaMachine.getFrontFacing();
                var fluid = tank.getFluid();
                if (fluid == null) return;

                poseStack.pushPose();
                poseStack.translate(0.5, 0, 0.5);
                RenderUtils.rotateToFace(poseStack, frontFacing, null);
                poseStack.translate(-0.5, 0, -0.5);
                RenderHelper.renderStillFluidInWorld(fluid, new Model3D().bounds(-1, -3, -3, 2, -1, 0), poseStack, buffer, ClientUtil.camera(), LightTexture.FULL_BRIGHT, OverlayTexture.NO_OVERLAY, CubeRenderer.FaceDisplay.BACK);
                poseStack.popPose();
            }
        }
    }

}
