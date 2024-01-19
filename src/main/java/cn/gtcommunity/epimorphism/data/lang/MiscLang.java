package cn.gtcommunity.epimorphism.data.lang;

import net.minecraftforge.common.data.LanguageProvider;

import static cn.gtcommunity.epimorphism.data.lang.EPLangHelper.*;

public class MiscLang {
    public static void init(LanguageProvider provider) {
        addCN(provider, "itemGroup.epimorphism.item", "Epimorphism | 物品");
        addCN(provider, "itemGroup.epimorphism.block", "Epimorphism | 方块");
        addCN(provider, "itemGroup.epimorphism.circuit_reform", "Epimorphism | 电路板改革");

        add(provider, "epimorphism.universal.none",
                "None",
                "无");

        // Tooltip
        add(provider, "epimorphism.desc_extended_info",
                "§7Hold down Shift to show more information",
                "§7按住Shift显示更多信息");

        add(provider, "epimorphism.universal.desc.tier",
                "§7Tier: %s",
                "§7等级：%s");

        add(provider, "epimorphism.universal.desc.max_eu_in",
                "§6Max EU input: §r%d",
                "§6最大EU输入：§r%d");
        add(provider, "epimorphism.universal.desc.max_eu_consume",
                "§6Max EU consumption: §r%d",
                "§6最大EU消耗：§r%d");
        add(provider, "epimorphism.universal.desc.power_cost",
                "§7Energy consumption: %s EU/t",
                "§7能耗：%s EU/t");


        add(provider, "epimorphism.universal.desc.kg_capacity",
                "§6Capacity: §r%s Kg",
                "§6容量：§r%d千克");
        add(provider, "epimorphism.universal.desc.fluid_capacity",
                "§7Capacity: %s L",
                "§7容量：%s L");
    }
}
