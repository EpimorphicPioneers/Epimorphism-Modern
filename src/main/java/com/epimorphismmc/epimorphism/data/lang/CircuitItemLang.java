package com.epimorphismmc.epimorphism.data.lang;

import com.epimorphismmc.monomorphism.registry.registrate.providers.MOLangProvider;

public class CircuitItemLang {
    public static void init(MOLangProvider provider) {
        provider.add("epimorphism.item.etched", "Etched %s", "蚀刻%s");
        provider.add("epimorphism.item.etched_board", "Etched %s Board", "蚀刻%s基板");
        provider.add("epimorphism.item.etched_base", "Etched %s Base", "蚀刻%s基底");
    }
}
