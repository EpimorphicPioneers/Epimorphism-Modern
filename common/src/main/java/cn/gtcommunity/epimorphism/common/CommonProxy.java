package cn.gtcommunity.epimorphism.common;

import cn.gtcommunity.epimorphism.api.registry.EPRegistries;
import cn.gtcommunity.epimorphism.common.data.*;
import cn.gtcommunity.epimorphism.data.EPDatagen;
import dev.architectury.injectables.annotations.ExpectPlatform;

public class CommonProxy {

    @ExpectPlatform
    public static void onGTCEuSetup() {
        throw new AssertionError();
    }
    public static void init() {
        EPCreativeModeTabs.init();
        EPBlocks.init();
        EPRecipeTypes.init();
        EPMachines.init();
        EPItems.init();
        EPDatagen.init();
        EPRegistries.EP_REGISTRATE.registerRegistrate();
    }
}
