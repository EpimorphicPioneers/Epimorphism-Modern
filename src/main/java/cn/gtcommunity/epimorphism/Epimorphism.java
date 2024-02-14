package cn.gtcommunity.epimorphism;

import cn.gtcommunity.epimorphism.client.ClientProxy;
import cn.gtcommunity.epimorphism.common.CommonProxy;
import com.gregtechceu.gtceu.utils.FormattingUtil;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Mod(Epimorphism.MOD_ID)
public class Epimorphism {
    public static final String MOD_ID = "epimorphism";
    public static final String NAME = "Epimorphism";
    public static final Logger LOGGER = LoggerFactory.getLogger(NAME);

    public static CommonProxy proxy;

    public Epimorphism () {
        proxy = DistExecutor.unsafeRunForDist(() -> ClientProxy::new, () -> CommonProxy::new);
    }

    public static ResourceLocation id(String path) {
        return new ResourceLocation("epimorphism", FormattingUtil.toLowerCaseUnder(path));
    }
}
