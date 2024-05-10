package cn.gtcommunity.epimorphism.client;

/*
 * Referenced some code from Immersive Engineering
 *
 * https://github.com/BluSunrize/ImmersiveEngineering
 * */

import cn.gtcommunity.epimorphism.core.mixins.accessors.client.FontResourceManagerAccessor;
import cn.gtcommunity.epimorphism.core.mixins.accessors.client.MinecraftAccessor;
import com.google.common.base.Preconditions;
import com.lowdragmc.lowdraglib.client.model.ModelFactory;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.VertexFormat;
import com.mojang.blaze3d.vertex.VertexFormatElement;
import com.mojang.math.Transformation;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.font.FontManager;
import net.minecraft.client.gui.font.FontSet;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.renderer.block.ModelBlockRenderer;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.client.resources.model.ModelManager;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.apache.commons.compress.utils.IOUtils;
import org.joml.Quaternionf;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

@OnlyIn(Dist.CLIENT)
public class ClientUtil {
    // Render Commonly Used
    public static Minecraft mc() {
        return Minecraft.getInstance();
    }

    public static void bindTexture(ResourceLocation texture) {
        RenderSystem.setShaderTexture(0, texture);
    }

    public static Font font() {
        return mc().font;
    }

    public static MultiBufferSource bufferSource() {
        return mc().renderBuffers().bufferSource();
    }

    public static Camera camera() {
        return gameRenderer().getMainCamera();
    }

    public static ItemRenderer itemRenderer() {
        return mc().getItemRenderer();
    }

    public static BlockRenderDispatcher blockRenderer() {
        return mc().getBlockRenderer();
    }
    public static ModelBlockRenderer modelRenderer() {
        return blockRenderer().getModelRenderer();
    }

    public static GameRenderer gameRenderer() {
        return mc().gameRenderer;
    }

    public static TextureManager textureManager() {
        return mc().getTextureManager();
    }

    public static ModelManager modelManager() {
        return mc().getModelManager();
    }

    public static BakedModel getBakedModel(ResourceLocation resourceLocation) {
        return modelManager().getModel(resourceLocation);
    }

    public static float partialTicks() {
        return mc().getFrameTime();
    }

    // Image
    public static BufferedImage readBufferedImage(InputStream imageStream) throws IOException {
        BufferedImage bufferedimage;

        try {
            bufferedimage = ImageIO.read(imageStream);
        } finally {
            IOUtils.closeQuietly(imageStream);
        }

        return bufferedimage;
    }

    // Font
    private static Font unicodeRenderer;

    public static Font unicodeFontRender() {
        if(unicodeRenderer==null)
            unicodeRenderer = new Font(rl -> {
                FontManager resourceManager = ((MinecraftAccessor)Minecraft.getInstance()).getFontManager();
                Map<ResourceLocation, FontSet> fonts = ((FontResourceManagerAccessor)resourceManager).getFontSets();
                return fonts.get(Minecraft.UNIFORM_FONT);
            }, false);
        return unicodeRenderer;
    }

    // Offset
    public static int findOffset(VertexFormat vf, VertexFormatElement.Usage u, VertexFormatElement.Type t) {
        int offset = 0;
        for(VertexFormatElement element : vf.getElements()) {
            if(element.getUsage() == u && element.getType() == t) {
                Preconditions.checkState(offset % 4 == 0);
                return offset / 4;
            }
            offset += element.getByteSize();
        }
        throw new IllegalStateException();
    }

    public static int findTextureOffset(VertexFormat vf) {
        return findOffset(vf, VertexFormatElement.Usage.UV, VertexFormatElement.Type.FLOAT);
    }

    public static int findPositionOffset(VertexFormat vf) {
        return findOffset(vf, VertexFormatElement.Usage.POSITION, VertexFormatElement.Type.FLOAT);
    }

    // Rotation
    public static Quaternionf degreeToQuaterion(double x, double y, double z) {
        x = Math.toRadians(x);
        y = Math.toRadians(y);
        z = Math.toRadians(z);
        Quaternionf qYaw = new Quaternionf(0, (float)Math.sin(y/2), 0, (float)Math.cos(y/2));
        Quaternionf qPitch = new Quaternionf((float)Math.sin(x/2), 0, 0, (float)Math.cos(x/2));
        Quaternionf qRoll = new Quaternionf(0, 0, (float)Math.sin(z/2), (float)Math.cos(z/2));

        qYaw.mul(qRoll);
        qYaw.mul(qPitch);
        return qYaw;
    }

    public static Transformation rotateTo(Direction d) {
        return new Transformation(null).compose(ModelFactory.getRotation(d).getRotation());
    }
}
