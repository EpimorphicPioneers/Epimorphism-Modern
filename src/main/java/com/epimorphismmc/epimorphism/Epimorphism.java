package com.epimorphismmc.epimorphism;


import com.epimorphismmc.monomorphism.utility.DistLogger;
import com.gregtechceu.gtceu.utils.FormattingUtil;

import net.minecraft.resources.ResourceLocation;

import org.slf4j.Logger;


public interface Epimorphism {
    String MOD_ID = "epimorphism";
    String NAME = "Epimorphism";

    Logger LOGGER = new DistLogger(NAME);

    static Epimorphism instance() {
        return EpimorphismCommon.instance();
    }

    static ResourceLocation id(String path) {
        return new ResourceLocation(MOD_ID, FormattingUtil.toLowerCaseUnder(path));
    }
}
