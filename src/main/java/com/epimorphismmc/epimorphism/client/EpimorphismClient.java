package com.epimorphismmc.epimorphism.client;

import com.epimorphismmc.epimorphism.EpimorphismCommon;
import com.epimorphismmc.epimorphism.client.model.GrindBallModel;
import com.epimorphismmc.epimorphism.client.particle.CropFX;
import com.epimorphismmc.epimorphism.common.data.EPParticleTypes;

import net.minecraftforge.client.event.ModelEvent;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class EpimorphismClient extends EpimorphismCommon {
    public EpimorphismClient() {
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
