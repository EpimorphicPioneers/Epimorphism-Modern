package cn.gtcommunity.epimorphism.client;

import cn.gtcommunity.epimorphism.client.dimension.renderer.PlanetSkyRenderer;
import cn.gtcommunity.epimorphism.client.model.GrindBallModel;
import cn.gtcommunity.epimorphism.client.model.ItemCustomLayerModel;
import cn.gtcommunity.epimorphism.common.CommonProxy;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.ModelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.ArrayList;
import java.util.List;

@OnlyIn(Dist.CLIENT)
public class ClientProxy extends CommonProxy {
    public static List<PlanetSkyRenderer> skyRenderers = new ArrayList<>();

    public ClientProxy() {
        super();
    }

    @Override
    public void init() {
        super.init();
    }

    @SubscribeEvent
    public void onRegisterGeometryLoaders(ModelEvent.RegisterGeometryLoaders event) {
        event.register("item_custom_layers", ItemCustomLayerModel.Loader.INSTANCE);
    }

    @SubscribeEvent
    public void onModelBakingResult(ModelEvent.ModifyBakingResult event) {
        GrindBallModel.replaceModel(event.getModels());
    }

    @SubscribeEvent
    public void onModelRegistration(ModelEvent.RegisterAdditional event) {
        GrindBallModel.registerAdditionalModel(event::register);
    }
}
