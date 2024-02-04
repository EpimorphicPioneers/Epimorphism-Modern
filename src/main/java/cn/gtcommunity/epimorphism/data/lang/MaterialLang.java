package cn.gtcommunity.epimorphism.data.lang;

import net.minecraftforge.common.data.LanguageProvider;

import static cn.gtcommunity.epimorphism.common.data.EPMaterials.*;
import static cn.gtcommunity.epimorphism.data.lang.EPLangHelper.*;

public class MaterialLang {
    public static void init(LanguageProvider provider) {
        addMaterial(provider, GrapheneOxide, "Graphene Oxide", "氧化石墨烯");
    }
}
