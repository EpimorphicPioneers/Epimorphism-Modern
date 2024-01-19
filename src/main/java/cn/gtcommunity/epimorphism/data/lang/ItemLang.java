package cn.gtcommunity.epimorphism.data.lang;

import net.minecraftforge.common.data.LanguageProvider;

import static cn.gtcommunity.epimorphism.common.data.EPItems.*;
import static cn.gtcommunity.epimorphism.data.lang.EPLangHelper.*;

public class ItemLang {
    public static void init(LanguageProvider provider) {
        //  Boards
        addItemWithTooltip(provider, GOOWARE_BOARD, "Kapton™电路基板",
                "§7Dupont™ Pyralux® TK Laminate Film",
                "§7杜邦™ Pyralux® TK层压薄膜");
        addItemWithTooltip(provider, OPTICAL_BOARD, "氮化镓半导体材料电路基板",
                "§7Absolute ideal materials for Optoelectronic Devices",
                "§7绝对理想的光电器件材料");
        addItemWithTooltip(provider, SPINTRONIC_BOARD, "碳纳米管磁性存储电路基板",
                "§7Third generation Spintronic Technology",
                "§7第三代自旋电子技术");
        addItemWithTooltip(provider, GOOWARE_CIRCUIT_BOARD, "终极电路板",
                "§7Revitalization on circuit boards",
                "§7电路板上焕发生机");
        addItemWithTooltip(provider, OPTICAL_CIRCUIT_BOARD, "究极电路板",
                "§7The Technology Star of the Semiconductor Industry",
                "§7半导体工业的技术之星");
        addItemWithTooltip(provider, SPINTRONIC_CIRCUIT_BOARD, "无尽电路板",
                "§7The Best Implementation of Spin Transfer Torque",
                "§7自旋转移矩效应的最好实现");

        //  Circuits
        add(provider, "item.epimorphism.circuit.zpm.desc",
                "§cZPM-Tier Circuit",
                "§cZPM级电路");
        add(provider, "item.epimorphism.circuit.uv.desc",
                "§3UV-Tier Circuit",
                "§3UV级电路");
        add(provider, "item.epimorphism.circuit.uhv.desc",
                "§4UHV-Tier Circuit",
                "§4UHV级电路");
        add(provider, "item.epimorphism.circuit.uev.desc",
                "§aUEV-Tier Circuit",
                "§aUEV级电路");
        add(provider, "item.epimorphism.circuit.uiv.desc",
                "§2UIV-Tier Circuit",
                "§2UIV级电路");
        add(provider, "item.epimorphism.circuit.uxv.desc",
                "§eUXV-Tier Circuit",
                "§eUXV级电路");
        add(provider, "item.epimorphism.circuit.opv.desc",
                "§9OpV-Tier Circuit",
                "§9OpV级电路");
        add(provider, "item.epimorphism.circuit.max.desc",
                "§c§lMAX-Tier Circuit",
                "§c§lMAX级电路");

        addItemWithTooltip(provider,GOOWARE_PROCESSOR, "生物活性处理器",
                "Viscous organic slurry adheres the board",
                "§7粘稠的有机浆液附着于表面");
        addItemWithTooltip(provider,GOOWARE_ASSEMBLY, "生物活性处理器集群",
                "Seems to be able to hear whispers",
                "§7似乎能听到窃窃私语");
        addItemWithTooltip(provider,GOOWARE_COMPUTER, "生物活性超级处理器",
                "Slime mold covered in metal",
                "§7金属之间布满了黏菌");
        addItemWithTooltip(provider,GOOWARE_MAINFRAME, "生物活性主机",
                "Microbial Awareness Network",
                "§7菌群意识网络");

        //  Components
        addItemWithTooltip(provider, OPTICAL_TRANSISTOR, "光学晶体管",
                "§Optical Transistor",
                "§7光电子晶体管");
        addItemWithTooltip(provider, OPTICAL_RESISTOR, "光敏电阻",
                "§7Optical Resistor",
                "§7光电子电阻");
        addItemWithTooltip(provider, OPTICAL_CAPACITOR, "光学整合器",
                "§7Optical Capacitor",
                "§7光电子电容");
        addItemWithTooltip(provider, OPTICAL_DIODE, "光频隔离器",
                "§7Optical Diode",
                "§7光电子二极管");
        addItemWithTooltip(provider, OPTICAL_INDUCTOR, "光学偏振器",
                "§7Optical Inductor",
                "§7光电子电感");
        addItemWithTooltip(provider, SPINTRONIC_TRANSISTOR, "自旋金属-氧半场效晶体管",
                "§7Spintronic Transistor",
                "§7自旋电子晶体管");
        addItemWithTooltip(provider, SPINTRONIC_RESISTOR, "磁阻器",
                "§7Spintronic Resistor",
                "§7自旋电子电阻");
        addItemWithTooltip(provider, SPINTRONIC_CAPACITOR, "超级电容",
                "§7Spintronic Capacitor",
                "§7自旋电子电容");
        addItemWithTooltip(provider, SPINTRONIC_DIODE, "肖氏势垒二极管",
                "§7Spintronic Diode",
                "§7自旋电子二极管");
        addItemWithTooltip(provider, SPINTRONIC_INDUCTOR, "自旋偏振器",
                "§7Spintronic Inductor",
                "§7自旋电子电感");
        addItemWithTooltip(provider, COSMIC_TRANSISTOR, "晶体信息载荷",
                "§7Cosmic Transistor",
                "§7寰宇晶体管");
        addItemWithTooltip(provider, COSMIC_RESISTOR, "微型星际物质信息壁",
                "§7Cosmic Resistor",
                "§7寰宇电阻");
        addItemWithTooltip(provider, COSMIC_CAPACITOR, "全息能量荷",
                "§7Cosmic Capacitor",
                "§7寰宇电容");
        addItemWithTooltip(provider, COSMIC_DIODE, "宇宙离子极管",
                "§7Cosmic Diode",
                "§7寰宇二极管");
        addItemWithTooltip(provider, COSMIC_INDUCTOR, "天顶星偏振器",
                "§7Cosmic Inductor",
                "§7寰宇电感");

        //  Gooware Components

        //  Optical Components

        //  Spintronic Components

        //  Cosmic Components

        //  Supracausal Components

        //  Lasers
        addItemWithTooltip(provider, OPTICAL_FIBER, "光纤",
                "§7Light-transmitting Glass",
                "§7透光玻璃");
        addItemWithTooltip(provider, DIELECTRIC_MIRROR, "介电镜",
                "§7Bragg Mirror",
                "§7布氏镜");
        addItemWithTooltip(provider, EMPTY_LASER_ASSEMBLY, "空激光组件",
                "§7Fill this with some Laser Medium",
                "§7需要导光介质填充");
        addItemCNName(provider, HELIUM_LASER, "氦激光镭射器");
        addItemCNName(provider, NEON_LASER, "氖激光镭射器");
        addItemCNName(provider, ARGON_LASER, "氩激光镭射器");
        addItemCNName(provider, KRYPTON_LASER, "氪激光镭射器");
        addItemCNName(provider, XENON_LASER, "氙激光镭射器");
        addItemWithTooltip(provider, HELIUM_NEON_LASER, "氦-氖混合气激光镭射器",
                "§7Purpose: Weak Optical Appliances",
                "§7用于弱光学设备");
        addItemWithTooltip(provider, ND_YAG_LASER, "钕掺杂的钇铝榴石激光镭射器",
                "§7Purpose: Strong Optical Appliances",
                "§7用于强光学设备");

        //  Condenser Components

        //  Wafers

        //  Others

        //  Crystal Components
        addItemWithTooltip(provider, DIAMOND_CHIP, "刻蚀钻石晶片",
                "§7Raw Crystal Logic Circuit",
                "§7待处理晶体逻辑电路");
        addItemWithTooltip(provider, RUBY_CHIP, "刻蚀红宝石晶片",
                "§7Raw Crystal Control Circuit",
                "§7待处理晶体控制电路");
        addItemWithTooltip(provider, SAPPHIRE_CHIP, "刻蚀蓝宝石晶片",
                "§7Raw Crystal Conversion Circuit",
                "§7待处理晶体转换电路");

        //  High Energy Physics items

        //  Biological Components
        addItemWithTooltip(provider, ELECTROCHEMICAL_GRADIENT_RECORDER, "电化学梯度记录仪",
                "§7Fundamentals of Biocomputing",
                "§7生物计算基础");
        addItemWithTooltip(provider, ULTRA_MICRO_PHASE_SEPARATOR, "超微型相分离器",
                "§7Guardian of Biochemical Reactions",
                "§7生化反应守护者");
        addItemWithTooltip(provider, QUANTUM_TUNNELING_MICROTUBULE, "量子隧穿微管",
                "§7Biological Fusion has finally become a reality",
                "§7生物聚变终成现实");
        addItemWithTooltip(provider, HYPERRIBOSOME, "超核糖体",
                "§7Protein Factory",
                "§7蛋白质工厂");
        addItemWithTooltip(provider, NEUTRON_ABSORBING_PROTEIN, "中子吸收蛋白",
                "§7Inconceivable",
                "§7不可思议");
        addItemWithTooltip(provider, SUPEREXCITED_CONDUCTIVE_POLYMER, "超激发传导聚合体",
                "§7Biological High-voltage Line",
                "§7生物高压线");
        addItemCNName(provider, ORDINARY_ALGAE, "普通藻类");
        addItemCNName(provider, RED_ALGA, "红藻");
        addItemCNName(provider, GREEN_ALGA,"绿藻");
        addItemCNName(provider, CHRYSOPHYCEAE, "金藻");
        addItemCNName(provider, BROWN_ALGA, "褐藻");



        //  Covers
        addItemCNName(provider, ELECTRIC_PUMP_MAX, "§c§lMAX§r电动泵");
        addItemCNName(provider, FLUID_REGULATOR_MAX, "§c§lMAX§r流体校准器");
        addItemCNName(provider, CONVEYOR_MODULE_MAX, "§c§lMAX§r传送带");
        addItemCNName(provider, ROBOT_ARM_MAX, "§c§lMAX§r机械臂");
        addItemCNName(provider, ELECTRIC_MOTOR_MAX, "§c§lMAX§r电动马达");
        addItemCNName(provider, ELECTRIC_PISTON_MAX, "§c§lMAX§r电力活塞");
        addItemCNName(provider, EMITTER_MAX, "§c§lMAX§r发射器");
        addItemCNName(provider, SENSOR_MAX, "§c§lMAX§r传感器");
        addItemCNName(provider, FIELD_GENERATOR_MAX, "§c§lMAX§r力场发生器");

        //  Debug
        addItemWithTooltip(provider, DEBUG_STRUCTURE_WRITER, "多方块导出工具",
                "§7Because I need one...",
                "§7因为我需要一个...");
        addItemWithTooltip(provider, DEBUG_STRUCTURE_BUILDER, "多方块构建工具",
                "§7Because I need one...",
                "§7因为我需要一个...");
        add(provider, "item.epimorphism.debug.structure_writer.structural_scale",
                "Structure size: X:%s Y:%s Z:%s",
                "结构规模： X:%s  Y:%s  Z:%s");
        add(provider, "item.epimorphism.debug.structure_writer.export_order",
                "Export order: C:%s S:%s A:%s",
                "导出顺序： C:%s  S:%s  A:%s");
        add(provider, "item.epimorphism.debug.structure_writer.export_to_log",
                "Export as a log",
                "导出为日志");
        add(provider, "item.epimorphism.debug.structure_writer.export_to_file",
                "Export as a file",
                "导出为文件");
        add(provider, "item.epimorphism.debug.structure_writer.rotate_along_x_axis",
                "Rotate along the X axis",
                "沿X轴旋转");
        add(provider, "item.epimorphism.debug.structure_writer.rotate_along_y_axis",
                "Rotate along the Y axis",
                "沿Y轴旋转");

                //  Tool
        addItemWithTooltip(provider, ORGANISM_CAPTURE_TOOL, "生物捕捉工具",
                "§7It's really not a Poké Ball!",
                "§7这真的不是精灵球！");
        add(provider, "item.epimorphism.organism_capture_tool.desc.info",
                "§7Creatures: §r%s",
                "§7生物：§r%s");
    }
}
