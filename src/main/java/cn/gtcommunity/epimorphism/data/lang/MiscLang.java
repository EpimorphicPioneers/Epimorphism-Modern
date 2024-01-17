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
        add(provider, "epimorphism.universal.desc.max_eu_in",
                "Max EU input: %d",
                "§6最大EU输入：§r%d");
        add(provider, "epimorphism.universal.desc.max_eu_consume",
                "Max EU consumption: %d",
                "§6最大EU消耗：§r%d");
    }
}
