package cn.gtcommunity.epimorphism.client;

import cn.gtcommunity.epimorphism.Epimorphism;
import cn.gtcommunity.epimorphism.common.data.EPParticleTypes;
import cn.gtcommunity.epimorphism.client.model.GrindBallModel;
import cn.gtcommunity.epimorphism.client.model.ItemCustomLayerModel;
import cn.gtcommunity.epimorphism.client.particle.CropFX;
import cn.gtcommunity.epimorphism.common.CommonProxy;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.ModelEvent;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

@OnlyIn(Dist.CLIENT)
public class ClientProxy extends CommonProxy {

    public ClientProxy() {
        super();
    }

    @Override
    public void init() {
        super.init();
    }

    @SubscribeEvent
    public void registerParticleFactories(RegisterParticleProvidersEvent event) {
        event.registerSpecial(EPParticleTypes.CROP, new CropFX.Factory());
    }

    @SubscribeEvent
    public void registerGeometryLoaders(ModelEvent.RegisterGeometryLoaders event) {
        event.register("item_custom_layers", ItemCustomLayerModel.Loader.INSTANCE);
    }

    @SubscribeEvent
    public void onModelBaking(ModelEvent.ModifyBakingResult event) {
        GrindBallModel.replaceModel(event.getModels());
    }

    @SubscribeEvent
    public void registerAdditionalModels(ModelEvent.RegisterAdditional event) {
        GrindBallModel.registerAdditionalModel(event::register);
        event.register(Epimorphism.id("block/obj/star_0"));
        event.register(Epimorphism.id("block/obj/star_1"));
        event.register(Epimorphism.id("block/obj/star_2"));
        event.register(Epimorphism.id("block/obj/space"));
        event.register(Epimorphism.id("block/obj/climber"));
    }
}
