package cn.gtcommunity.epimorphism.data;

import cn.gtcommunity.epimorphism.api.registry.EPRegistries;
import cn.gtcommunity.epimorphism.data.lang.EPLangHandler;
import com.tterrag.registrate.providers.ProviderType;

public class EPDatagen {
    public static void init() {
        EPRegistries.EP_REGISTRATE.addDataGenerator(ProviderType.LANG, EPLangHandler::init);
        EPRegistries.EP_REGISTRATE.addDataGenerator(EPProviderTypes.CN_LANG, EPLangHandler::init);
    }
}
