package cn.gtcommunity.epimorphism.client.renderer.handler;

import cn.gtcommunity.epimorphism.client.ClientUtil;
import cn.gtcommunity.epimorphism.utils.EPLangUtil;
import com.lowdragmc.lowdraglib.utils.LocalizationUtils;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.joml.Quaternionf;

import java.util.ArrayList;
import java.util.List;

@OnlyIn(Dist.CLIENT)
public class VisualInventoryRenderer {

    public static final int TEXT_COLOR = 0xFFFFFFFF; //255 + (255 << 8) + (255 << 16) + (255 << 24);
    public static final int TEXT_COLOR_LIGHT = 0xFFFFFFFF; //255 + (255 << 8) + (255 << 16) + (255 << 24);

    private final String name;
    private final List<ItemStack> stacks;

    public VisualInventoryRenderer(final String name, List<ItemStack> input) {
        // Minecraft & Localization.
        String tmp = LocalizationUtils.format(name);
        if (!tmp.equals(name)) this.name = tmp;
        else {
            String name2 = name + ".name";
            tmp = LocalizationUtils.format(name2);
            if (!tmp.equals(name2)) this.name = tmp;
            else this.name = name;
        }

        this.stacks = new ArrayList<>(input.size());
        for (ItemStack stack : input)
            outer: {
                if (stack == null) continue;
                for (ItemStack stack2 : stacks) {
                    if (!ItemStack.isSameItemSameTags(stack, stack2) || !ItemStack.isSameItem(stack, stack2)) continue;
                    stack2.grow(stack.getCount());
                    break outer;
                }
                this.stacks.add(stack);
            }
    }

//    @Override
    public void render(/*WorldClient world, RayTraceResult hit,*/ Vec3 pos, PoseStack poseStack, Camera camera) {
        var mc = Minecraft.getInstance();
        var rm = mc.gameRenderer;
        var buffer = mc.renderBuffers().bufferSource();
        var pPos = camera.getPosition();
        ItemRenderer ri = mc.getItemRenderer();


        poseStack.translate(pos.x() - pPos.x(), pos.y() - pPos.y(), pos.z() - pPos.z());

        Quaternionf rotation = rm.getMainCamera().rotation();
        poseStack.mulPose(rotation);
        poseStack.translate(0, 0, -0.5);

        float d = (float) pos.distanceTo(pPos);

        if (d < 1.75) return;
        poseStack.scale(d * 0.2F, d * 0.2F, d * 0.2F);

        int cols;
        if (stacks.size() <= 9) cols = stacks.size();
        else if (stacks.size() <= 27) cols = 9;
        else if (stacks.size() <= 54) cols = 11;
        else if (stacks.size() <= 90) cols = 14;
        else if (stacks.size() <= 109) cols = 18;
        else cols = 21;
        int rows = 1 + ((stacks.size() % cols == 0) ? (stacks.size() / cols) - 1 : stacks.size() / cols);

        if (rows > 4) poseStack.scale(0.8F, 0.8F, 0.8F);

        // Draw name, with depth disabled
        {
            poseStack.pushPose();
            poseStack.mulPose(Axis.ZP.rotation(180));
            poseStack.translate(0, -0.6f -0.4f * (rows/2.0), 0);
            poseStack.translate(0, -1 - 0.5f * (rows/2.0), 0);
            poseStack.scale(0.03F, 0.03F, 0.03F);
            int w = mc.font.width(name);
            RenderSystem.disableDepthTest();
            mc.font.drawInBatch(name,  (float) -w /2, 0, 0xFFFFFF, false, poseStack.last().pose(), buffer, Font.DisplayMode.NORMAL, 0, LightTexture.FULL_BRIGHT);
            RenderSystem.enableDepthTest();
            poseStack.popPose();
        }

        int r = 0;
        int c = 0;
        for (final ItemStack stack : stacks) {
            renderStack(stack, poseStack, buffer, cols, c, rows, r);
            if (++c == cols)
            {
                r++;
                c = 0;
            }
        }
        // Draw stack sizes later, to draw over the items (disableDepth)
        r = 0;
        c = 0;
        RenderSystem.disableDepthTest();
        for (final ItemStack stack : stacks) {
            renderName(stack, poseStack, buffer, cols, c, rows, r, TEXT_COLOR);
            if (++c == cols) {
                r++;
                c = 0;
            }
        }
        RenderSystem.enableDepthTest();
    }

//    @Override
//    public boolean shouldRender()
//    {
//        return stacks.size() != 0;
//    }

    public static void renderName(ItemStack stack, PoseStack poseStack, MultiBufferSource multiBufferSource, int cols, int col, int rows, int row, int color) {
        Font fr = ClientUtil.font();
        poseStack.pushPose();
        poseStack.translate(0.4f * (cols / 2.0 - col) - 0.2f, 0.4f * (rows / 2.0 - row) - 0.15f, 0);
        poseStack.mulPose(Axis.ZP.rotation(180));
        poseStack.translate(0.2, 0, -0.1);
        poseStack.scale(0.01F, 0.01F, 0.01F);

        String size;
        if (stack.getCount() < 1000) size = String.valueOf(stack.getCount());
        else if (stack.getCount() > 1000) size = EPLangUtil.DECIMAL_FORMAT_1F.format(stack.getCount() / 1000.0) + "k";
        else size = EPLangUtil.DECIMAL_FORMAT_1F.format(stack.getCount() / (1000.0 * 1000.0)) + "M";

        int w = fr.width(size);
        fr.drawInBatch(size, -w, 0, color, false, poseStack.last().pose(), multiBufferSource, Font.DisplayMode.NORMAL, 0, LightTexture.FULL_BRIGHT);

        poseStack.popPose();
    }

    public static void renderStack(ItemStack stack, PoseStack poseStack, MultiBufferSource bufferSource, int cols, int col, int rows, int row) {
        ItemRenderer ri = ClientUtil.itemRenderer();
        poseStack.pushPose();
        poseStack.translate(0.4f * (cols / 2.0 - col) - 0.2f, 0.4f * (rows / 2.0 - row), 0);
        float millis = System.currentTimeMillis();
        float angle = ((millis / 45) % 360);
        poseStack.mulPose(Axis.YP.rotation(angle));
        poseStack.scale(0.45F, 0.45F, 0.45F);

        ri.renderStatic(stack, ItemDisplayContext.FIXED, LightTexture.FULL_BRIGHT, OverlayTexture.NO_OVERLAY, poseStack, bufferSource, Minecraft.getInstance().level, 0);

        poseStack.popPose();
    }
}
