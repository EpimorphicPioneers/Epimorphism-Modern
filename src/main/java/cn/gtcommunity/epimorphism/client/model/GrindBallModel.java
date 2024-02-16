package cn.gtcommunity.epimorphism.client.model;

import cn.gtcommunity.epimorphism.Epimorphism;
import cn.gtcommunity.epimorphism.api.chemical.material.properties.EPPropertyKeys;
import cn.gtcommunity.epimorphism.common.item.behaviors.GrindBallBehaviour;
import com.gregtechceu.gtceu.api.GTCEuAPI;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.block.model.ItemOverrides;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;

@OnlyIn(Dist.CLIENT)
@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class GrindBallModel implements BakedModel {

    private static final ModelResourceLocation LOCATION = new ModelResourceLocation(Epimorphism.id("grind_ball"), "inventory");

    private final BakedModel model;

    protected GrindBallModel(BakedModel model) {
        this.model = model;
    }

    @Override
    public List<BakedQuad> getQuads(@Nullable BlockState state, @Nullable Direction direction, RandomSource random) {
        return model.getQuads(state, direction, random);
    }

    @Override
    public boolean useAmbientOcclusion() {
        return model.useAmbientOcclusion();
    }

    @Override
    public boolean isGui3d() {
        return model.isGui3d();
    }

    @Override
    public boolean usesBlockLight() {
        return model.usesBlockLight();
    }

    @Override
    public boolean isCustomRenderer() {
        return model.isCustomRenderer();
    }

    @Override
    public TextureAtlasSprite getParticleIcon() {
        return model.getParticleIcon();
    }

    @Override
    public ItemTransforms getTransforms() {
        return model.getTransforms();
    }

    @Override
    public ItemOverrides getOverrides() {
        return new BallMaterialOverrideHandler();
    }

    public static void registerAdditionalModel(Consumer<ResourceLocation> consumer) {
        GTCEuAPI.materialManager.getRegisteredMaterials().stream()
                .filter(mat -> mat.hasProperty(EPPropertyKeys.GRIND_BALL))
                .map(mat -> mat.getProperty(EPPropertyKeys.GRIND_BALL).getModel())
                .filter(Objects::nonNull)
                .forEach(consumer);
    }

    public static void replaceModel(Map<ResourceLocation, BakedModel> map) {
        if (map.containsKey(LOCATION)) {
            map.replace(LOCATION, new GrindBallModel(map.get(LOCATION)));
        }
    }

    private static final class BallMaterialOverrideHandler extends ItemOverrides {

        @Override
        public BakedModel resolve(BakedModel originalModel, ItemStack stack, @Nullable ClientLevel level, @Nullable LivingEntity entity, int seed) {
            var behavior = GrindBallBehaviour.getBehaviour(stack);
            if (behavior != null) {
                var location = behavior.getPartMaterial(stack).getProperty(EPPropertyKeys.GRIND_BALL).getModel();
                if (location != null) {
                    return Minecraft.getInstance().getModelManager().getModel(location);
                }
            }
            return originalModel;
        }
    }
}
