package cn.gtcommunity.epimorphism.client.dimension.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Camera;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.DimensionSpecialEffects;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import org.joml.Matrix4f;

public class DimensionEffects extends DimensionSpecialEffects implements IDimensionRenderer{
    public DimensionEffects(float cloudLevel, boolean hasGround, SkyType skyType, boolean forceBrightLightmap, boolean constantAmbientLight) {
        super(cloudLevel, hasGround, skyType, forceBrightLightmap, constantAmbientLight);
    }

    @Override
    public boolean renderClouds(ClientLevel level, int ticks, float tickDelta, PoseStack poseStack, double cameraX, double cameraY, double cameraZ, Matrix4f projectionMatrix) {
        return false;
    }

    @Override
    public boolean renderSky(ClientLevel level, int ticks, float tickDelta, PoseStack poseStack, Camera camera, Matrix4f projectionMatrix, boolean foggy, Runnable setupFog) {
        return false;
    }

    @Override
    public boolean renderSnowAndRain(ClientLevel level, int ticks, float tickDelta, LightTexture manager, double cameraX, double cameraY, double cameraZ) {
        return false;
    }

    @Override
    public boolean shouldRenderClouds() {
        return false;
    }

    @Override
    public boolean shouldRenderSky() {
        return false;
    }

    @Override
    public boolean shouldRenderSnowAndRain() {
        return false;
    }

    @Override
    public @NotNull Vec3 getBrightnessDependentFogColor(@NotNull Vec3 fogColor, float brightness) {
        return null;
    }

    @Override
    public boolean isFoggyAt(int x, int y) {
        return false;
    }
}
