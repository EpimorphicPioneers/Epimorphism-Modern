package cn.gtcommunity.epimorphism.utils.fabric;

import net.minecraft.server.MinecraftServer;

public class EPLevelUtilsImpl {
    public static MinecraftServer getCurrentServer() {
        return ServerLifecycleHooks.getCurrentServer();
    }
}
