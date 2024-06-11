package com.epimorphismmc.epimorphism.data.lang;

import com.epimorphismmc.epimorphism.Epimorphism;

import com.epimorphismmc.monomorphism.datagen.lang.MOLangHelper;

import net.minecraft.network.chat.MutableComponent;

import java.util.List;

public class EPLangHelper {
    public static String getBlockKey(String key) {
        return MOLangHelper.getBlockKey(Epimorphism.MOD_ID, key);
    }

    public static List<MutableComponent> getBlockTooltips(String name, int tooltips) {
        return MOLangHelper.getSubKeys(getBlockKey(name) + ".desc", tooltips);
    }
}
