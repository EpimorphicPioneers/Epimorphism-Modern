package com.epimorphismmc.epimorphism.client.model;

import com.lowdragmc.lowdraglib.client.bakedpipeline.FaceQuad;
import com.lowdragmc.lowdraglib.client.bakedpipeline.Quad;
import com.lowdragmc.lowdraglib.client.model.ModelFactory;

import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import org.jetbrains.annotations.Nullable;
import org.joml.Vector3f;

import java.util.ArrayList;
import java.util.List;

public class SpikeModel {
    @OnlyIn(Dist.CLIENT)
    public List<BakedQuad> bakeQuads(@Nullable Direction side) {
        List<BakedQuad> quads = new ArrayList<>();
        if (side != null) {
            var sideSprite = ModelFactory.getBlockSprite(new ResourceLocation("block/diamond_block"));
            //            quads.add(FaceQuad.builder(side, sideSprite).cube(new AABB(0.0F, 0.0F, 0.0F,
            // 1.0F, 0.0625F, 1.0F)).cubeUV().tintIndex(0).bake());

            var builder = new Quad.Builder(sideSprite);
            builder.setQuadOrientation(side);
            builder.copyFrom(
                    FaceQuad.builder(side, sideSprite)
                            .cube(new AABB(0.0F, 0.0F, 0.0F, 1.0F, 0.0625F, 1.0F))
                            .cubeUV()
                            .tintIndex(0)
                            .bake(),
                    0);
            Quad quad = builder.build();
            if (side == Direction.EAST) {
                quad = quad.withVert(0, new Vector3f(0.0F, 0.0625F, 1.0F));
                quad = quad.withVert(1, new Vector3f(1.0F, 0.0625F, 1.0F));
                quad = quad.withVert(2, new Vector3f(0.5F, 1.0F, 0.5F));
                quad = quad.withVert(3, new Vector3f(0.5F, 1.0F, 0.5F));
            } else if (side == Direction.WEST) {
                quad = quad.withVert(0, new Vector3f(1.0F, 0.0625F, 0.0F));
                quad = quad.withVert(1, new Vector3f(1.0F, 0.0625F, 1.0F));
                quad = quad.withVert(2, new Vector3f(0.5F, 1.0F, 0.5F));
                quad = quad.withVert(3, new Vector3f(0.5F, 1.0F, 0.5F));
            } else if (side == Direction.NORTH) {
                quad = quad.withVert(1, new Vector3f(0.0F, 0.0625F, 1.0F));
                quad = quad.withVert(0, new Vector3f(0.0F, 0.0625F, 0.0F));
                quad = quad.withVert(2, new Vector3f(0.5F, 1.0F, 0.5F));
                quad = quad.withVert(3, new Vector3f(0.5F, 1.0F, 0.5F));
            } else if (side == Direction.SOUTH) {
                quad = quad.withVert(0, new Vector3f(1.0F, 0.0625F, 0.0F));
                quad = quad.withVert(1, new Vector3f(0.0F, 0.0625F, 0.0F));
                quad = quad.withVert(2, new Vector3f(0.5F, 1.0F, 0.5F));
                quad = quad.withVert(3, new Vector3f(0.5F, 1.0F, 0.5F));
            }
            quads.add(quad.rebake());
        }

        return quads;
        //        quads.add(new BakedQuad()0.0F, 0.0F, 0.0F, 1.0F, 0.0625F,
        // 1.0F).setTexture("spikes/spike_" + this.type.name() + "_base");
        //        for(int i = 0; i < 4; ++i) {
        //            model.add((new BoxSingleQuad(new UV[]{new UV(1.0F, 0.0625F, 0.0F, 0.0F, 0.0625F),
        // new UV(0.0F, 0.0625F, 0.0F, 1.0F, 0.0625F), new UV(0.5F, 1.0F, 0.5F, 0.5F, 1.0F), new
        // UV(0.5F, 1.0F, 0.5F, 0.5F, 1.0F)})).setDoubleSided(false).setTexture("spikes/spike_" +
        // this.type.name() + "_side").rotateY(i));
        //        }

    }
}
