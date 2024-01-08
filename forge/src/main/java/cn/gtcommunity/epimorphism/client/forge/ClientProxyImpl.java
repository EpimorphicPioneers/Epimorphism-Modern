package cn.gtcommunity.epimorphism.client.forge;

import cn.gtcommunity.epimorphism.client.ClientProxy;
import cn.gtcommunity.epimorphism.client.ClientUtil;
import cn.gtcommunity.epimorphism.client.model.forge.ItemCustomLayerModel;
import cn.gtcommunity.epimorphism.common.forge.CommonProxyImpl;
import cn.gtcommunity.epimorphism.core.mixins.accessors.client.MultiPlayerGameModeAccessor;
import com.lowdragmc.lowdraglib.syncdata.annotation.RPCMethod;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.ModelEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

@OnlyIn(Dist.CLIENT)
public class ClientProxyImpl extends CommonProxyImpl {
    public ClientProxyImpl() {
        super();
        ClientProxy.init();
    }

    @SubscribeEvent
    public void onRegisterGeometryLoaders(ModelEvent.RegisterGeometryLoaders event)
    {
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
