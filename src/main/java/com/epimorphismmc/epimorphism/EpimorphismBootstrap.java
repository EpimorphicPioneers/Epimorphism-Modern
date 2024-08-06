package com.epimorphismmc.epimorphism;

import com.epimorphismmc.epimorphism.client.EpimorphismClient;

import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;

@Mod(Epimorphism.MOD_ID)
public class EpimorphismBootstrap {
    public EpimorphismBootstrap() {
        DistExecutor.unsafeRunForDist(() -> EpimorphismClient::new, () -> EpimorphismServer::new);
    }
}
