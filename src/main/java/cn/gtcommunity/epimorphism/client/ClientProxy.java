package cn.gtcommunity.epimorphism.client;

import cn.gtcommunity.epimorphism.client.model.GrindBallModel;
import cn.gtcommunity.epimorphism.client.particle.CropFX;
import cn.gtcommunity.epimorphism.common.CommonProxy;
import cn.gtcommunity.epimorphism.common.data.EPParticleTypes;
import com.epimorphismmc.monomorphism.proxy.base.IClientProxyBase;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.ModelEvent;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

@OnlyIn(Dist.CLIENT)
public class ClientProxy extends CommonProxy implements IClientProxyBase {

    public ClientProxy() {
        super();
    }

    @SubscribeEvent
    public void registerParticleFactories(RegisterParticleProvidersEvent event) {
        event.registerSpecial(EPParticleTypes.CROP, new CropFX.Factory());
    }

    @SubscribeEvent
    public void onModelBaking(ModelEvent.ModifyBakingResult event) {
        GrindBallModel.replaceModel(event.getModels());
    }

    @SubscribeEvent
    public void registerAdditionalModels(ModelEvent.RegisterAdditional event) {
        GrindBallModel.registerAdditionalModel(event::register);
    }
}
