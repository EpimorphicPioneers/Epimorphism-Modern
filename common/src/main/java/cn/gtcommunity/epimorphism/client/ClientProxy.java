package cn.gtcommunity.epimorphism.client;

import cn.gtcommunity.epimorphism.client.dimension.renderer.PlanetSkyRenderer;
import dev.architectury.injectables.annotations.ExpectPlatform;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

import java.util.ArrayList;
import java.util.List;

@Environment(EnvType.CLIENT)
public class ClientProxy {
    public static List<PlanetSkyRenderer> skyRenderers = new ArrayList<>();

    public static void init() {

    }

    @ExpectPlatform
    public static void delayDestroy() {
        throw new AssertionError();
    }
}
