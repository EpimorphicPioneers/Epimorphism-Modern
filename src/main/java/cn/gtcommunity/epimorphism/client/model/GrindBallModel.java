package cn.gtcommunity.epimorphism.client.model;

import cn.gtcommunity.epimorphism.api.chemical.material.properties.EPPropertyKeys;
import cn.gtcommunity.epimorphism.common.data.EPItems;
import cn.gtcommunity.epimorphism.common.item.behaviors.GrindBallBehaviour;
import com.gregtechceu.gtceu.api.GTCEuAPI;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.block.model.ItemOverrides;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.model.BakedModelWrapper;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;

@OnlyIn(Dist.CLIENT)
@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class GrindBallModel extends BakedModelWrapper<BakedModel> {

    protected GrindBallModel(BakedModel model) {
        super(model);
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
        var location = new ModelResourceLocation(EPItems.GRIND_BALL.getId(), "inventory");
        map.replace(location, new GrindBallModel(map.get(location)));
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
