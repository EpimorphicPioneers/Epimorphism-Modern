package cn.gtcommunity.epimorphism.utils.fabric;

import lombok.Getter;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.minecraft.server.MinecraftServer;

public class ServerLifecycleHooks {
    @Getter
    private static MinecraftServer currentServer;

    public static void init() {
        ServerLifecycleEvents.SERVER_STARTING.register(server -> {
            currentServer = server;
            LogicalSidedProvider.setServer(() -> server);
        });
    }
}
