//package cn.gtcommunity.cn.gtcommunity.epimorphism.common.eunetwork;
//
//import cn.gtcommunity.cn.gtcommunity.epimorphism.api.eunetwork.AccessLevel;
//import net.fabricmc.api.EnvType;
//import net.fabricmc.api.Environment;
//import net.minecraft.world.entity.player.Player;
//
//import javax.annotation.Nonnull;
//
//@Environment(EnvType.CLIENT)
//public class ClientEUNetwork extends EUNetwork {
//    public ClientFluxNetwork(int ignored) {
//    }
//
//    @Override
//    public void onEndServerTick() {
//        throw new IllegalStateException();
//    }
//
//    @Nonnull
//    @Override
//    public List<TileFluxDevice> getLogicalDevices(int logic) {
//        throw new IllegalStateException();
//    }
//
//    @Override
//    public long getBufferLimiter() {
//        throw new IllegalStateException();
//    }
//
//    @Override
//    public boolean enqueueConnectionAddition(@Nonnull TileFluxDevice device) {
//        throw new IllegalStateException();
//    }
//
//    @Override
//    public void enqueueConnectionRemoval(@Nonnull TileFluxDevice device, boolean unload) {
//        throw new IllegalStateException();
//    }
//
//    @Override
//    public boolean isValid() {
//        return true;
//    }
//
//    @Nonnull
//    @Override
//    public AccessLevel getPlayerAccess(@Nonnull Player player) {
//        return super.getPlayerAccess(player);
//    }
//}
