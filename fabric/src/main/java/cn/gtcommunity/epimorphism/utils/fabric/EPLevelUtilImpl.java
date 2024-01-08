package cn.gtcommunity.epimorphism.utils.fabric;

import io.github.fabricators_of_create.porting_lib.util.ServerLifecycleHooks;
import net.minecraft.server.MinecraftServer;

public class EPLevelUtilImpl {
    public static MinecraftServer getCurrentServer() {
        return ServerLifecycleHooks.getCurrentServer();
    }
}
