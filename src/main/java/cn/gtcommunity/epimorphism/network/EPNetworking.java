package cn.gtcommunity.epimorphism.network;

import cn.gtcommunity.epimorphism.Epimorphism;
import cn.gtcommunity.epimorphism.network.s2c.PacketVajraDestroy;
import com.lowdragmc.lowdraglib.networking.INetworking;
import com.lowdragmc.lowdraglib.networking.LDLNetworking;

public class EPNetworking {
    public static final INetworking NETWORK = LDLNetworking.createNetworking(Epimorphism.id("networking"), "0.0.1");

    public static void init() {
        NETWORK.registerS2C(PacketVajraDestroy.class);
    }
}
