package com.epimorphismmc.epimorphism.data.lang;

import com.epimorphismmc.monomorphism.registry.registrate.providers.MOLangProvider;

public class MiscLang {
    public static void init(MOLangProvider provider) {
        provider.addCN("itemGroup.epimorphism.item", "Epimorphism丨物品");
        provider.addCN("itemGroup.epimorphism.block", "Epimorphism丨方块");
        provider.addCN("itemGroup.epimorphism.machine", "Epimorphism丨机器");
        provider.addCN("itemGroup.epimorphism.physics", "Epimorphism丨物理学");
        provider.addCN("itemGroup.epimorphism.biology", "Epimorphism丨生物学");
        provider.addCN("itemGroup.epimorphism.circuit_reform", "Epimorphism丨电路板改革");
        provider.addCN("itemGroup.epimorphism.material_block", "Epimorphism丨材料-方块");
        provider.addCN("itemGroup.epimorphism.material_item", "Epimorphism丨材料-物品");
        provider.addCN("itemGroup.epimorphism.material_pipe", "Epimorphism丨材料-管道");
        provider.addCN("itemGroup.epimorphism.material_fluid", "Epimorphism丨材料-流体");
        provider.addCN("itemGroup.epimorphism.tool", "Epimorphism丨工具");

        provider.add("epimorphism.universal.none", "None", "无");

        // Tooltip
        provider.add("epimorphism.universal.desc.tier", "§7Tier: %s", "§7等级：%s");

        provider.add(
                "epimorphism.universal.desc.intake_rate",
                "§6Air intake rate: §r%d mB/t",
                "§6进气速率：§r%d mB/t");

        provider.add(
                "epimorphism.universal.desc.max_power_in",
                "§6Max power input: §r%d EU",
                "§6最大能量输入：§r%d EU");
        provider.add(
                "epimorphism.universal.desc.max_power_consume",
                "§6Max power consumption: §r%d EU",
                "§6最大能量消耗：§r%d EU");
        provider.add(
                "epimorphism.universal.desc.power_cost", "§7Energy consumption: %s EU/t", "§7能耗：%s EU/t");

        provider.add("epimorphism.universal.desc.kg_capacity", "§6Capacity: §r%d kg", "§6容量：§r%d kg");
        provider.add("epimorphism.universal.desc.fluid_capacity", "§7Capacity: %s mB", "§7容量：%s mB");

        provider.add("epimorphism.universal.desc.amount", "§7Amount: %s", "§7数量：%s");

        provider.add("epimorphism.universal.desc.heat", "§cHeat Capacity: §f%d K", "§c热容：§f%d K");

        provider.add("epimorphism.universal.particle_type.desc", "Particle Type: %s", "粒子类型：%s");
        provider.add("particleType.epimorphism.quark", "§dQuark", "§d夸克");
        provider.add("particleType.epimorphism.boson", "§cBoson", "§c玻色子");
        provider.add("particleType.epimorphism.baryon", "§9Baryon", "§9重子");
        provider.add("particleType.epimorphism.lepton", "§aLepton", "§a轻子");
        provider.add("particleType.epimorphism.meson", "§rMeson", "§r介子");

        provider.add(
                "epimorphism.multiblock.pattern.direction",
                "§cThe direction the block is facing must be consistent",
                "§c方块朝向必须一致");

        provider.add("epimorphism.universal.desc.duration", "§bDuration: §f%s", "§b耗时：§f%s");
        provider.add("epimorphism.universal.desc.energ_usage", "§aEnergy Usage: §f%s", "§a耗能：§f%s");
        provider.add("epimorphism.universal.desc.parallel", "§dMax Parallel: §f%s", "§d最大并行: §f%s");

        // GUI
        provider.add("epimorphism.universal.desc.mass", "Mass: %s", "质量：%s");

        provider.add("epimorphism.universal.desc.sievert", "Dose: %s Sv", "辐射剂量：%s Sv");
        provider.add("epimorphism.universal.desc.radioactive_source", "Actinogen: %s", "放射源：%s");

        provider.add("epimorphism.universal.desc.time", "Time: %s", "时间：%s");

        provider.add(
                "epimorphism.universal.desc.neutron_kinetic_energy.min",
                "Min Energy\n(%s)",
                "最小中子动能\n(%s)");
        provider.add(
                "epimorphism.universal.desc.neutron_kinetic_energy.max",
                "Max Energy\n(%s)",
                "最大中子动能\n(%s)");

        provider.add(
                "gui.epimorphism.machine_parallel.title",
                "The number of current machine parallels",
                "当前机器并行");
        provider.add(
                "gui.epimorphism.change_parallel.desc",
                "Adjust the number of machine parallels",
                "调整机器并行数");

        provider.add("gui.epimorphism.fishing_mode.title", "Current Fishing Mode", "当前捕捞模式");
        provider.add("gui.epimorphism.fishing_mode.desc", "Adjust Fishing Mode", "调整捕捞模式");

        provider.add("gui.epimorphism.ore_processing_mode.title", "Current processing mode", "当前处理模式");
        provider.add(
                "gui.epimorphism.ore_processing_mode.desc", "Adjust the processing mode", "调整处理模式");

        provider.addMultilineLang(
                "gui.epimorphism.catalyst.desc",
                "Has a chance to be consumed during processing\nThe base cost chance is 100%%, and the probability decreases by 20%% for each level of pipe blocks",
                "有几率在加工中消耗\n基础消耗概率为100%%，管道方块每提高一级，概率降低20%%");

        provider.add("gui.epimorphism.intake_obstructed", "The air intake is blocked!", "进气口受阻！");

        provider.add("gui.epimorphism.content.catalyst", "Catalyst", "催化剂");

        provider.add(
                "gui.epimorphism.voiding_stone.desc.enabled", "Stone dust destruction is on", "石粉销毁已开启");
        provider.add(
                "gui.epimorphism.voiding_stone.desc.disabled",
                "Stone dust destruction is disabled",
                "石粉销毁已禁用");

        provider.add(
                "gui.epimorphism.backfiller.start",
                "Start Position: X: %d, Y: %d, Z: %d",
                "开始位置: X: %d, Y: %d, Z: %d");
        provider.add(
                "gui.epimorphism.backfiller.filling",
                "Filling Position: X: %d, Y: %d, Z: %d",
                "正在填充: X: %d, Y: %d, Z: %d");
        provider.add("gui.epimorphism.backfiller.done", "Done!", "完成！");

        provider.addMultilineLang(
                "gui.epimorphism.neutron_sensor.invert.enabled",
                "Output: Inverted\n\nToggle to invert the redstone logic\nBy default, redstone stops emitting when less than the minimum neutron kinetic energy, and starts emitting when greater than the min neutron kinetic energy up to the set maximum",
                "输出：反转\n\n切换以反转红石逻辑\n默认情况下，中子动能介于所设定的最小值和最大值之间时传感器将发出红石信号，小于最小值时则停止发出红石信号");
        provider.addMultilineLang(
                "gui.epimorphism.neutron_sensor.invert.disabled",
                "Output: Normal\n\nToggle to invert the redstone logic\nBy default, redstone stops emitting when less than the minimum neutron kinetic energy, and starts emitting when greater than the min neutron kinetic energy up to the set maximum",
                "输出：普通\n\n切换以反转红石逻辑\n默认情况下，中子动能介于所设定的最小值和最大值之间时传感器将发出红石信号，小于最小值时则停止发出红石信号");
    }
}
