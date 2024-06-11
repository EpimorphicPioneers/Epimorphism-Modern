package com.epimorphismmc.epimorphism.data.lang;

import com.epimorphismmc.monomorphism.datagen.lang.MOLangProvider;

public class EPLangHandler {
    private EPLangHandler() {
        /**/
    }

    public static void init(MOLangProvider provider) {
        ItemLang.init(provider);
        BlockLang.init(provider);
        MaterialLang.init(provider);
        RecipeLang.init(provider);
        MachineLang.init(provider);
        MiscLang.init(provider);
    }
}
