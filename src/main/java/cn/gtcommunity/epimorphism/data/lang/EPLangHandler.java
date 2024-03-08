package cn.gtcommunity.epimorphism.data.lang;

import com.tterrag.registrate.providers.RegistrateLangProvider;

public class EPLangHandler {
    public EPLangHandler() {/**/}

    public static void init(RegistrateLangProvider provider) {
        ItemLang.init(provider);
        BlockLang.init(provider);
        MaterialLang.init(provider);
        RecipeLang.init(provider);
        MachineLang.init(provider);
        MiscLang.init(provider);
    }

    public static void init(RegistrateCNLangProvider provider) {
        ItemLang.init(provider);
        BlockLang.init(provider);
        MaterialLang.init(provider);
        RecipeLang.init(provider);
        MachineLang.init(provider);
        MiscLang.init(provider);
    }
}