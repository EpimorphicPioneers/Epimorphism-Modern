package cn.gtcommunity.epimorphism.data.lang;

import net.minecraftforge.common.data.LanguageProvider;

import static cn.gtcommunity.epimorphism.data.lang.EPLangHelper.*;

public class MiscLang {
    public static void init(LanguageProvider provider) {
        addCN(provider, "itemGroup.epimorphism.item", "Epimorphism丨物品");
        addCN(provider, "itemGroup.epimorphism.block", "Epimorphism丨方块");
        addCN(provider, "itemGroup.epimorphism.machine", "Epimorphism丨机器");
        addCN(provider, "itemGroup.epimorphism.physics", "Epimorphism丨物理学");
        addCN(provider, "itemGroup.epimorphism.biology", "Epimorphism丨生物学");
        addCN(provider, "itemGroup.epimorphism.agriculture", "Epimorphism丨农业");
        addCN(provider, "itemGroup.epimorphism.galaxy", "Epimorphism丨银河");
        addCN(provider, "itemGroup.epimorphism.circuit_reform", "Epimorphism丨电路板改革");

        add(provider, "epimorphism.universal.none",
                "None",
                "无");

        // Tooltip
        add(provider, "epimorphism.desc_extended_info",
                "§7Hold down Shift to show more information",
                "§7按住§6SHIFT§7显示更多信息");

        add(provider, "epimorphism.universal.desc.tier",
                "§7Tier: %s",
                "§7等级：%s");

        add(provider, "epimorphism.universal.desc.max_power_in",
                "§6Max power input: §r%d",
                "§6最大能量输入：§r%d EU");
        add(provider, "epimorphism.universal.desc.max_power_consume",
                "§6Max power consumption: §r%d",
                "§6最大能量消耗：§r%d EU");
        add(provider, "epimorphism.universal.desc.power_cost",
                "§7Energy consumption: %s EU/t",
                "§7能耗：%s EU/t");

        add(provider, "epimorphism.universal.desc.kg_capacity",
                "§6Capacity: §r%d kg",
                "§6容量：§r%d kg");
        add(provider, "epimorphism.universal.desc.fluid_capacity",
                "§7Capacity: %s L",
                "§7容量：%s L");

        add(provider, "epimorphism.universal.desc.amount",
                "§7Amount: %s",
                "§7数量：%s");

        add(provider, "epimorphism.universal.desc.heat",
                "§cHeat Capacity: §f%d K",
                "§c热容：§f%d K");

        add(provider, "epimorphism.universal.particle_type.desc",
                "Particle Type: %s",
                "粒子类型：%s");
        add(provider, "particleType.epimorphism.quark",
                "§dQuark",
                "§d夸克");
        add(provider, "particleType.epimorphism.boson",
                "§cBoson",
                "§c玻色子");
        add(provider, "particleType.epimorphism.baryon",
                "§9Baryon",
                "§9重子");
        add(provider, "particleType.epimorphism.lepton",
                "§aLepton",
                "§a轻子");
        add(provider, "particleType.epimorphism.meson",
                "§rMeson",
                "§r介子");

        // GUI
        add(provider, "epimorphism.universal.desc.mass",
                "Mass: %s",
                "质量：%s");

        add(provider, "epimorphism.universal.desc.sievert",
                "Dose: %s Sv",
                "辐射剂量：%s Sv");
        add(provider, "epimorphism.universal.desc.radioactive_source",
                "Actinogen: %s",
                "放射源：%s");

        add(provider, "epimorphism.universal.desc.time",
                "Time: %s",
                "时间：%s");

        add(provider, "epimorphism.universal.desc.neutron_kinetic_energy.min",
                "Min Energy\n(%s)",
                "最小中子动能\n(%s)");
        add(provider, "epimorphism.universal.desc.neutron_kinetic_energy.max",
                "Max Energy\n(%s)",
                "最大中子动能\n(%s)");

        add(provider, "gui.epimorphism.machine_parallel.title",
                "The number of current machine parallels",
                "当前机器并行");
        add(provider, "gui.epimorphism.change_parallel.desc",
                "Adjust the number of machine parallels",
                "调整机器并行数");

        add(provider, "gui.epimorphism.fishing_mode.title",
                "Current Fishing Mode",
                "当前捕捞模式");
        add(provider, "gui.epimorphism.change_fishing_mode.desc",
                "Adjust Fishing Mode",
                "调整捕捞模式");

        addMultilineLang(provider, "gui.epimorphism.neutron_sensor.invert.enabled",
                "Output: Inverted\n\nToggle to invert the redstone logic\nBy default, redstone stops emitting when less than the minimum neutron kinetic energy, and starts emitting when greater than the min neutron kinetic energy up to the set maximum",
                "输出：反转\n\n切换以反转红石逻辑\n默认情况下，中子动能介于所设定的最小值和最大值之间时传感器将发出红石信号，小于最小值时则停止发出红石信号");
        addMultilineLang(provider, "gui.epimorphism.neutron_sensor.invert.disabled",
                "Output: Normal\n\nToggle to invert the redstone logic\nBy default, redstone stops emitting when less than the minimum neutron kinetic energy, and starts emitting when greater than the min neutron kinetic energy up to the set maximum",
                "输出：普通\n\n切换以反转红石逻辑\n默认情况下，中子动能介于所设定的最小值和最大值之间时传感器将发出红石信号，小于最小值时则停止发出红石信号");
    }
}
