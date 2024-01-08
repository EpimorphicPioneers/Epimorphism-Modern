package cn.gtcommunity.epimorphism.forge;

import cn.gtcommunity.epimorphism.client.forge.ClientProxyImpl;
import cn.gtcommunity.epimorphism.common.forge.CommonProxyImpl;
import cn.gtcommunity.epimorphism.Epimorphism;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;

@Mod(Epimorphism.MOD_ID)
public class EpimorphismForge {
    public static CommonProxyImpl proxy;
    public EpimorphismForge() {
        Epimorphism.init();
        proxy = DistExecutor.unsafeRunForDist(() -> ClientProxyImpl::new, () -> CommonProxyImpl::new);
    }
}
