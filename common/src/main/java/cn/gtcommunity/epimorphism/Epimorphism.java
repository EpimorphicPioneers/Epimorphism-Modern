package cn.gtcommunity.epimorphism;

import cn.gtcommunity.epimorphism.api.registry.EPRegistries;
import cn.gtcommunity.epimorphism.common.data.EPBlocks;
import cn.gtcommunity.epimorphism.common.data.EPCreativeModeTabs;
import cn.gtcommunity.epimorphism.common.data.EPDimensionTypes;
import cn.gtcommunity.epimorphism.common.data.EPItems;
import cn.gtcommunity.epimorphism.data.EPDatagen;
import com.google.common.base.Suppliers;
import com.gregtechceu.gtceu.config.ConfigHolder;
import com.gregtechceu.gtceu.utils.FormattingUtil;
import dev.architectury.registry.registries.RegistrarManager;
import net.minecraft.resources.ResourceLocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.Supplier;

public class Epimorphism {
    public static final String MOD_ID = "epimorphism";

    public static final String NAME = "Epimorphism";
    public static final Logger LOGGER = LoggerFactory.getLogger(NAME);

    // We can use this if we don't want to use DeferredRegister
    public static final Supplier<RegistrarManager> REGISTRIES = Suppliers.memoize(() -> RegistrarManager.get(MOD_ID));
    
    public static void init() {
        ConfigHolder.init();
        EPCreativeModeTabs.init();
        EPBlocks.init();
        EPItems.init();
        EPDatagen.init();
        EPRegistries.EP_REGISTRATE.registerRegistrate();
        EPDimensionTypes.init();
        System.out.println(ExampleExpectPlatform.getConfigDirectory().toAbsolutePath().normalize().toString());
        Epimorphism.LOGGER.info("Epimorphism's Initialization Completed!");
    }

    public static ResourceLocation id(String path) {
        return new ResourceLocation("epimorphism", FormattingUtil.toLowerCaseUnder(path));
    }
}
