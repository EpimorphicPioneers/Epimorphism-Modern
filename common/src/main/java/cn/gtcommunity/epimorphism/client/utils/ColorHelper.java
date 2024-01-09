package cn.gtcommunity.epimorphism.client.utils;

import cn.gtcommunity.epimorphism.client.ClientUtil;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.util.Mth;
import org.joml.Vector4f;

@Environment(EnvType.CLIENT)
public class ColorHelper {
    public static class ARGB32 {
        public ARGB32() {
        }

        public static float alpha(int packedColor) {
            return (packedColor >>> 24) / 255.0F;
        }

        public static float red(int packedColor) {
            return (packedColor >> 16 & 255) / 255.0F;
        }

        public static float green(int packedColor) {
            return (packedColor >> 8 & 255) / 255.0F;
        }

        public static float blue(int packedColor) {
            return (packedColor & 255) / 255.0F;
        }

        public static int color(float alpha, float red, float green, float blue) {
            return (int) (alpha * 255) << 24 | (int) (red * 255) << 16 | (int) (green * 255) << 8 | (int) (blue * 255);
        }
    }

    public static int getDarkenedTextColour(int colour) {
        int r = (colour >> 16 & 255) / 4;
        int g = (colour >> 8 & 255) / 4;
        int b = (colour & 255) / 4;
        return r << 16 | g << 8 | b;
    }

    public static Vector4f pulseRGBAlpha(Vector4f rgba, int tickRate, float min, float max) {
        var player = ClientUtil.mc().player;
        if (player == null) return rgba;

        float f_alpha = player.tickCount % (tickRate * 2) / (float) tickRate;
        f_alpha = f_alpha > 1 ? 2 - f_alpha : f_alpha;

        return new Vector4f(rgba.x(), rgba.y(), rgba.z(), Mth.clamp(f_alpha, min, max));
    }
}