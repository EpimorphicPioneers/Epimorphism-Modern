package cn.gtcommunity.epimorphism.client;

import cn.gtcommunity.epimorphism.client.dimension.renderer.PlanetSkyRenderer;
import cn.gtcommunity.epimorphism.client.model.ItemCustomLayerModel;
import cn.gtcommunity.epimorphism.common.CommonProxy;
import cn.gtcommunity.epimorphism.core.mixins.accessors.client.MultiPlayerGameModeAccessor;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.ModelEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
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

    @Override
    public void onPlayerLeftClickBlock(PlayerInteractEvent.LeftClickBlock event) {
        if (event.getSide().isServer()) {
            super.onPlayerLeftClickBlock(event);
        }
    }

    public static void delayDestroy() {
        var gameMode = ClientUtil.mc().gameMode;
        if (gameMode != null) {
            ((MultiPlayerGameModeAccessor)gameMode).setDestroyDelay(5);
        }
    }
}
