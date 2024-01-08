package cn.gtcommunity.epimorphism.client.fabric;

import cn.gtcommunity.epimorphism.client.ClientProxy;
import cn.gtcommunity.epimorphism.client.ClientUtil;
import cn.gtcommunity.epimorphism.client.renderer.handler.StructureSelectRenderer;
import cn.gtcommunity.epimorphism.core.mixins.accessors.client.MultiPlayerGameModeAccessor;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.WorldRenderEvents;

@Environment(EnvType.CLIENT)
public class ClientProxyImpl implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ClientProxy.init();
        WorldRenderEvents.AFTER_TRANSLUCENT.register((context) -> {
            StructureSelectRenderer.renderStructureSelect(context.matrixStack(), context.camera());
        });
//        ModelLoadingRegistry.INSTANCE.registerResourceProvider(mr -> ItemCustomLayerModel.Loader.INSTANCE);
    }

    public static void delayDestroy() {
        var gameMode = ClientUtil.mc().gameMode;
        if (gameMode != null) {
            ((MultiPlayerGameModeAccessor)gameMode).setDestroyDelay(5);
        }
    }
}
