package cn.gtcommunity.epimorphism.data;

import cn.gtcommunity.epimorphism.common.registry.EPRegistration;
import cn.gtcommunity.epimorphism.data.lang.EPLangHandler;
import cn.gtcommunity.epimorphism.data.model.BlockStateHandler;
import com.tterrag.registrate.providers.ProviderType;

public class EPDatagen {
    public static void init() {
        EPRegistration.EP_REGISTRATE.addDataGenerator(ProviderType.LANG, EPLangHandler::init);
        EPRegistration.EP_REGISTRATE.addDataGenerator(EPProviderTypes.CN_LANG, EPLangHandler::init);
        EPRegistration.EP_REGISTRATE.addDataGenerator(ProviderType.BLOCKSTATE, BlockStateHandler::init);
    }
}
