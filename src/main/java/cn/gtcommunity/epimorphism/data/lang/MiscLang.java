package cn.gtcommunity.epimorphism.data.lang;

import net.minecraftforge.common.data.LanguageProvider;

import static cn.gtcommunity.epimorphism.data.lang.EPLangHelper.*;

public class MiscLang {
    public static void init(LanguageProvider provider) {

        add(provider, "epimorphism.universal.none",
                "None",
                "无");

        // Tooltip
        add(provider, "epimorphism.desc_extended_info",
                "§7Hold down Shift to show more information",
                "§7按住Shift显示更多信息");
    }
}
