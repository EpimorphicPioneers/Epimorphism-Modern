package cn.gtcommunity.epimorphism.utils;

import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.server.MinecraftServer;

public class EPLevelUtils {
    @ExpectPlatform
    public static MinecraftServer getCurrentServer() {throw new AssertionError();}
}
