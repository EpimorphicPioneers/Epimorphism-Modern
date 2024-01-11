package cn.gtcommunity.epimorphism.data;

import cn.gtcommunity.epimorphism.api.registry.EPRegistries;
import cn.gtcommunity.epimorphism.data.lang.LangHandler;
import com.tterrag.registrate.providers.ProviderType;

public class EPDatagen {
    public static void init() {
        EPRegistries.EP_REGISTRATE.addDataGenerator(ProviderType.LANG, LangHandler::init);
    }
}
