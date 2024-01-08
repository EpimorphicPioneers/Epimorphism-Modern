package cn.gtcommunity.epimorphism;

import cn.gtcommunity.epimorphism.common.data.*;
import cn.gtcommunity.epimorphism.network.EPNetworking;
import com.gregtechceu.gtceu.config.ConfigHolder;
import com.gregtechceu.gtceu.utils.FormattingUtil;
import net.minecraft.resources.ResourceLocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Epimorphism {
    public static final String MOD_ID = "epimorphism";

    public static final String NAME = "Epimorphism";
    public static final Logger LOGGER = LoggerFactory.getLogger(NAME);
    
    public static void init() {
        ConfigHolder.init();
        EPNetworking.init();

        EPDimensionTypes.init();
        Epimorphism.LOGGER.info("Epimorphism's Initialization Completed!");
    }

    public static ResourceLocation id(String path) {
        return new ResourceLocation("epimorphism", FormattingUtil.toLowerCaseUnder(path));
    }
}
