package cn.gtcommunity.epimorphism.api.gui.utils;

import cn.gtcommunity.epimorphism.client.ClientUtil;
import com.lowdragmc.lowdraglib.gui.texture.IGuiTexture;
import com.lowdragmc.lowdraglib.utils.LocalizationUtils;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class EPWidgetUtil {
    public static IGuiTexture createCatalystOverlay() {
        return new IGuiTexture() {
            @Override
            @OnlyIn(Dist.CLIENT)
            public void draw(GuiGraphics graphics, int mouseX, int mouseY, float x, float y, int width, int height) {
                graphics.pose().pushPose();
                graphics.pose().translate(0, 0, 400);
                graphics.pose().scale(0.5f, 0.5f, 1);
                String s = LocalizationUtils.format("gui.epimorphism.content.catalyst");
                Font fontRenderer = ClientUtil.font();
                graphics.drawString(fontRenderer, s, (int) ((x + (width / 3f)) * 2 - fontRenderer.width(s) + 23), (int) ((y + (height / 3f) + 6) * 2 - height), 0xff0000, true);
                graphics.pose().popPose();
            }
        };
    }
}
