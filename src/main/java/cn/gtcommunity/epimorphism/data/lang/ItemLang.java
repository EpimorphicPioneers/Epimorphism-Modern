package cn.gtcommunity.epimorphism.data.lang;

import com.epimorphismmc.monomorphism.datagen.lang.MOLangProvider;
import com.gregtechceu.gtceu.api.GTValues;

import java.util.Locale;

import static cn.gtcommunity.epimorphism.common.data.EPItems.*;
import static cn.gtcommunity.epimorphism.common.data.items.EPBiologyItems.*;
import static cn.gtcommunity.epimorphism.common.data.items.EPChemistryItem.*;
import static cn.gtcommunity.epimorphism.common.data.items.EPPhysicsItems.*;

public class ItemLang {
    public static void init(MOLangProvider provider) {

        //////////////////////////////////////
        //*******    Circuit Items   *******//
        //////////////////////////////////////

        //  Boards
        provider.addItemWithTooltip(GOOWARE_BOARD,
                "Kapton™ Board",
                "Kapton™电路基板",
                "§7Dupont™ Pyralux® TK Laminate Film",
                "§7杜邦™ Pyralux® TK层压薄膜");
        provider.addItemWithTooltip(OPTICAL_BOARD,
                "Gallium Nitride Semiconducting Board",
                "氮化镓半导体材料电路基板",
                "§7Absolute ideal materials for Optoelectronic Devices",
                "§7绝对理想的光电器件材料");
        provider.addItemWithTooltip(SPINTRONIC_BOARD,
                "Carbon Nanotube Magnetic storage Board",
                "碳纳米管磁性存储电路基板",
                "§7Third generation Spintronic Technology",
                "§7第三代自旋电子技术");

        provider.addItemWithTooltip(GOOWARE_CIRCUIT_BOARD,
                "Super Circuit Board",
                "终极印刷电路基板",
                "§7Revitalization on circuit boards",
                "§7电路板上焕发生机");
        provider.addItemWithTooltip(OPTICAL_CIRCUIT_BOARD,
                "Ultimate Circuit Board",
                "究极印刷电路基板",
                "§7The Technology Star of the Semiconductor Industry",
                "§7半导体工业的技术之星");
        provider.addItemWithTooltip(SPINTRONIC_CIRCUIT_BOARD,
                "Infinite Circuit Board",
                "无尽印刷电路基板",
                "§7The Best Implementation of Spin Transfer Torque",
                "§7自旋转移矩效应的最好实现");

        //  Circuit Tier
        provider.addMultiLang(tier -> "item.epimorphism.circuit.%s.desc".formatted(GTValues.VN[tier].toLowerCase(Locale.ROOT)),
                tier -> "%s-Tier Circuit".formatted(GTValues.VNF[tier]),
                tier -> "%s级电路".formatted(GTValues.VNF[tier]), GTValues.tiersBetween(GTValues.ZPM, GTValues.MAX));

        //  Gooware Circuits
        provider.addItemWithTooltip(GOOWARE_PROCESSOR,
                "Gooware Processor",
                "生物活性处理器",
                "Viscous organic slurry adheres the board",
                "§7粘稠的有机浆液附着于表面");
        provider.addItemWithTooltip(GOOWARE_ASSEMBLY,
                "Gooware Assembly",
                "生物活性处理器集群",
                "Seems to be able to hear whispers",
                "§7似乎能听到窃窃私语");
        provider.addItemWithTooltip(GOOWARE_COMPUTER,
                "Gooware Supercomputer",
                "生物活性超级计算机",
                "Slime mold covered in metal",
                "§7金属之间布满了黏菌");
        provider.addItemWithTooltip(GOOWARE_MAINFRAME,
                "Gooware Mainframe",
                "生物活性主机",
                "Microbial Awareness Network",
                "§7菌群意识网络");

        //  Optical Circuits
        provider.addItemWithTooltip(OPTICAL_PROCESSOR,
                "Optical IMC Processor",
                "光学存算一体处理器",
                "§7Ultra efficient Photoelectron Transport",
                "§7超高效光电子载运");
        provider.addItemWithTooltip(OPTICAL_ASSEMBLY,
                "Optical IMC Assembly",
                "光学存算一体处理器集群",
                "§7Photon Surge",
                "§7光子涌流");
        provider.addItemWithTooltip(OPTICAL_COMPUTER,
                "Optical IMC Supercomputer",
                "光学存算一体超级计算机",
                "§7Ultra Large scale Computing data support",
                "§7超大规模计算数据支持");
        provider.addItemWithTooltip(OPTICAL_MAINFRAME,
                "Optical IMC Mainframe",
                "光学存算一体主机",
                "§7Calculating speed infinitely close to Light speed",
                "§7计算速度无限逼近于光速");

        //  Spintronic Circuits
        provider.addItemWithTooltip(SPINTRONIC_PROCESSOR,
                "Spintronic IMC Processor",
                "自旋电子存算一体处理器",
                "§7Super Magnetic Semiconductor Circuit",
                "§7超级磁性半导体电路");
        provider.addItemWithTooltip(SPINTRONIC_ASSEMBLY,
                "Spintronic IMC Assembly",
                "自旋电子存算一体处理器集群",
                "§7Quantum Random Walk",
                "§7量子随机游走");
        provider.addItemWithTooltip(SPINTRONIC_COMPUTER,
                "Spintronic IMC Supercomputer",
                "自旋电子存算一体超级计算机",
                "§7Control everything with Spin",
                "§7以自旋控制一切");
        provider.addItemWithTooltip(SPINTRONIC_MAINFRAME,
                "Spintronic IMC Mainframe",
                "自旋电子存算一体主机",
                "§7Circuit from the Future",
                "§7来自未来的电路");

        //  Cosmic Circuits
        provider.addItemWithTooltip(COSMIC_PROCESSOR,
                "Cosmic Planetary Processor",
                "寰宇行星级处理器",
                "§7Holding Star in Hand",
                "§7手握星辰");
        provider.addItemWithTooltip(COSMIC_ASSEMBLY,
                "Cosmic Planetary Assembly",
                "寰宇行星级处理器集群",
                "§7Rotate slightly",
                "§7于握揽微微转动");
        provider.addItemWithTooltip(COSMIC_COMPUTER,
                "Cosmic Planetary Supercomputer",
                "寰宇行星级超级计算机",
                "§7A small thing with a density approaching a Singularity",
                "§7密度趋近于奇点的小东西");
        provider.addItemWithTooltip(COSMIC_MAINFRAME,
                "Cosmic Planetary Mainframe",
                "寰宇行星级主机",
                "§7Simulate everything, Analyze everything, Understand everything",
                "§7模拟一切，分析一切，理解一切");

        //  Supracausal Circuits
        provider.addItemWithTooltip(SUPRACAUSAL_PROCESSOR,
                "Supracausal Galactic Processor",
                "超因果星系级处理器",
                "§7The laws of the Universe emerge here",
                "§7宇宙的法则涌现于此");
        provider.addItemWithTooltip(SUPRACAUSAL_ASSEMBLY,
                "Supracausal Galactic Assembly",
                "超因果星系级处理器集群",
                "§7Crossing the Barrier in front of the Gate of Truth",
                "§7跨过真理之门前的宏伟障壁");
        provider.addItemWithTooltip(SUPRACAUSAL_COMPUTER,
                "Supracausal Galactic Supercomputer",
                "超因果星系级超级计算机",
                "§7Beyond the Shadow of Time",
                "§7超越时间之影");
        provider.addItemWithTooltip(SUPRACAUSAL_MAINFRAME,
                "Supracausal Galactic Mainframe",
                "超因果星系级主机",
                "§7One of All Things,and the Original Miracle",
                "§7万物归一者，原初的神迹");

        //  Components
        provider.addItemWithTooltip(OPTICAL_TRANSISTOR,
                "Phototransistor",
                "光学晶体管",
                "§Optical Transistor",
                "§7光电子晶体管");
        provider.addItemWithTooltip(OPTICAL_RESISTOR,
                "Photoresistor",
                "光敏电阻",
                "§7Optical Resistor",
                "§7光电子电阻");
        provider.addItemWithTooltip(OPTICAL_CAPACITOR,
                "Optical Integrator",
                "光学整合器",
                "§7Optical Capacitor",
                "§7光电子电容");
        provider.addItemWithTooltip(OPTICAL_DIODE,
                "Optical Isolator",
                "光频隔离器",
                "§7Optical Diode",
                "§7光电子二极管");
        provider.addItemWithTooltip(OPTICAL_INDUCTOR,
                "Optical Polarizer",
                "光学偏振器",
                "§7Optical Inductor",
                "§7光电子电感");

        provider.addItemWithTooltip(SPINTRONIC_TRANSISTOR,
                "MOSFET",
                "自旋金属-氧半场效晶体管",
                "§7Spintronic Transistor",
                "§7自旋电子晶体管");
        provider.addItemWithTooltip(SPINTRONIC_RESISTOR,
                "Magnetoresistor",
                "磁阻器",
                "§7Spintronic Resistor",
                "§7自旋电子电阻");
        provider.addItemWithTooltip(SPINTRONIC_CAPACITOR,
                "Ultracapacitor",
                "超级电容",
                "§7Spintronic Capacitor",
                "§7自旋电子电容");
        provider.addItemWithTooltip(SPINTRONIC_DIODE,
                "Schottky Diode",
                "肖氏势垒二极管",
                "§7Spintronic Diode",
                "§7自旋电子二极管");
        provider.addItemWithTooltip(SPINTRONIC_INDUCTOR,
                "Spin Polarizer",
                "自旋偏振器",
                "§7Spintronic Inductor",
                "§7自旋电子电感");

        provider.addItemWithTooltip(COSMIC_TRANSISTOR,
                "Crystal Information Payload",
                "晶体信息载荷",
                "§7Cosmic Transistor",
                "§7寰宇晶体管");
        provider.addItemWithTooltip(COSMIC_RESISTOR,
                "Micro Interstellar material Information Wall",
                "微型星际物质信息壁",
                "§7Cosmic Resistor",
                "§7寰宇电阻");
        provider.addItemWithTooltip(COSMIC_CAPACITOR,
                "Holographic Energy Charge",
                "全息能量荷",
                "§7Cosmic Capacitor",
                "§7寰宇电容");
        provider.addItemWithTooltip(COSMIC_DIODE,
                "Cosmic Ion Diode",
                "宇宙离子极管",
                "§7Cosmic Diode",
                "§7寰宇二极管");
        provider.addItemWithTooltip(COSMIC_INDUCTOR,
                "Zenith Polarizer",
                "天顶星偏振器",
                "§7Cosmic Inductor",
                "§7寰宇电感");

        provider.addItemWithTooltip(SUPRACAUSAL_TRANSISTOR,
                "Kaluza-Klein Extradimensional Dilator Field Effect Transistor",
                "卡鲁扎-克莱因额外维胀子场效应管",
                "§7Supracausal Transistor",
                "§7超因果晶体管");
        provider.addItemWithTooltip(SUPRACAUSAL_RESISTOR,
                "Non anomalous Quantum Main Constraint Generator",
                "非反常量子主约束生成器",
                "§7Supracausal Resistor",
                "§7超因果电阻");
        provider.addItemWithTooltip(SUPRACAUSAL_CAPACITOR,
                "Energy-Momentum-Stress Tensor Memory",
                "能量-动量-应力张量存储器",
                "§7Supracausal Capacitor",
                "§7超因果电容");
        provider.addItemWithTooltip(SUPRACAUSAL_DIODE,
                "Spin network Carrier Diode",
                "自旋网络载波极管",
                "§7Supracausal Diode",
                "§7超因果二极管");
        provider.addItemWithTooltip(SUPRACAUSAL_INDUCTOR,
                "Supersymmetric Conformal Polarizer",
                "超对称共形偏振器",
                "§7Supracausal Inductor",
                "§7超因果电感");

        //  SoC
        provider.addItemWithTooltip(INTRAVITAL_SOC,
                "Intravital SoC",
                "活体SoC",
                "§7A wriggling Circuits",
                "§7蠕动着的电路");
        provider.addItemWithTooltip(PHOTOELECTRON_SOC,
                "Photoelectric SoC",
                "光电子SoC",
                "§7Luminous Circuits",
                "§7荧光电路");

        //  Gooware Components


        //  Optical Components
        provider.addItemWithTooltip(OPTICAL_IMC_BOARD,
                "Preassembled Photoelectric Circuit Board",
                "光学控制电路基板",
                "§7The Basis Point Of The Integration Of Storage And Computing",
                "§7存算一体的基点");

        //  Spintronic Components


        //  Cosmic Components


        //  Supracausal Components
        provider.addItemName(MANIFOLD_OSCILLATORY_POWER_CELL,
                "Manifold Oscillatory Power Cell",
                "流形震荡能量单元");

        //  Crystal Components
        provider.addItemWithTooltip(DIAMOND_CHIP,
                "Engraved Diamond Crystal Chip",
                "刻蚀钻石晶片",
                "§7Raw Crystal Logic Circuit",
                "§7晶体逻辑电路原料");
        provider.addItemWithTooltip(RUBY_CHIP,
                "Engraved Ruby Crystal Chip",
                "刻蚀红宝石晶片",
                "§7Raw Crystal Control Circuit",
                "§7晶体控制电路原料");
        provider.addItemWithTooltip(SAPPHIRE_CHIP,
                "Engraved Sapphire Crystal Chip",
                "刻蚀蓝宝石晶片",
                "§7Raw Crystal Conversion Circuit",
                "§7晶体转换电路原料");
        provider.addItemWithTooltip(DIAMOND_MODULATOR,
                "Diamond Crystal Modulator",
                "钻石晶体调节器",
                "§7Logic Processing Circuit",
                "§7逻辑处理电路");
        provider.addItemWithTooltip(RUBY_MODULATOR,
                "Ruby Crystal Modulator",
                "红宝石晶体调节器",
                "§7Control Processing Circuit",
                "§7控制处理电路");
        provider.addItemWithTooltip(SAPPHIRE_MODULATOR,
                "Sapphire Crystal Modulator",
                "蓝宝石晶体调节器",
                "§7Conversion Processing Circuit",
                "§7转换处理电路");

        //////////////////////////////////////
        //*******     Wafer Items    *******//
        //////////////////////////////////////

        //  Wafers
        provider.addItemWithTooltip(NANO_PIC_WAFER,
                "NPIC Wafer",
                "NPIC晶圆",
                "§7Raw Nano Power Circuit",
                "§7纳米功率集成电路原料");
        provider.addItemWithTooltip(NANO_PIC_CHIP,
                "NPIC",
                "NPIC芯片",
                "§7Nano Power Integrated Circuit",
                "§7纳米功率集成电路");
        provider.addItemWithTooltip(PICO_PIC_WAFER,
                "PPIC Wafer",
                "PPIC晶圆",
                "§7Raw Pico Power Circuit",
                "§7皮米功率集成电路原料");
        provider.addItemWithTooltip(PICO_PIC_CHIP,
                "PPIC",
                "PPIC芯片",
                "§7Pico Power Integrated Circuit",
                "§7皮米功率集成电路");
        provider.addItemWithTooltip(DUBNIUM_BOULE,
                "Dubnium-doped Monocrystalline Silicon Boule",
                "𬭊掺杂的单晶硅",
                "§7Raw Circuit",
                "§7电路原料");
        provider.addItemWithTooltip(DUBNIUM_WAFER,
                "Dubnium-doped Wafer",
                "𬭊掺杂的晶圆",
                "§7Raw Circuit",
                "§7电路原料");
        provider.addItemWithTooltip(CUBIC_ZIRCONIA_EUROPIUM_BOULE,
                "Europium-doped Monocrystalline Cubic Zirconia Boule",
                "铕掺杂的单晶立方氧化锆",
                "§7Raw Crystal",
                "§7晶体原料");
        provider.addItemWithTooltip(CUBIC_ZIRCONIA_EUROPIUM_WAFER,
                "Europium-doped Cubic Zirconia Wafer",
                "铕掺杂的立方氧化锆晶圆",
                "§7Raw Crystal",
                "§7晶体原料");
        provider.addItemWithTooltip(CRYSTAL_INTERFACE_WAFER,
                "Crystal Interface Wafer",
                "晶体接口晶圆",
                "§7Raw Crystal",
                "§7晶体原料");
        provider.addItemWithTooltip(STRONTIUM_CARBONATE_BOHRIUM_BOULE,
                "Bohrium-doped Monocrystalline Strontium Carbonate Boule",
                "𬭛掺杂的单晶碳酸锶",
                "§7Raw Optical Crystal",
                "§7光学晶体原料");
        provider.addItemWithTooltip(STRONTIUM_CARBONATE_BOHRIUM_WAFER,
                "Bohrium-doped Strontium Carbonate Wafer",
                "𬭛掺杂的碳酸锶晶圆",
                "§7Raw Optical Crystal",
                "§7光学晶体原料");
        provider.addItemWithTooltip(STRONTIUM_CARBONATE_OPTICAL_WAFER,
                "Coated Strontium Carbonate Wafer",
                "光聚合液涂覆的碳酸锶晶圆",
                "§7Pre-treatment Of Dielectric Reflective Wafer",
                "§7预处理电介质反射晶圆");

        //////////////////////////////////////
        //*******     Tool Items     *******//
        //////////////////////////////////////

        //  Tool
        provider.addItemWithTooltip(ORGANISM_CAPTURE_TOOL,
                "Organism Capture Tool",
                "生物捕捉工具",
                "§7It's really not a Poké Ball!",
                "§7这真的不是精灵球！");
        provider.add("item.epimorphism.organism_capture_tool.desc.info",
                "§7Creatures: §r%s",
                "§7生物：§r%s");
        provider.addItemWithTooltip(VAJRA,
                "Vajra",
                "金刚杵",
                "",
                "");

        // Grind Ball
        provider.addItemWithTooltip(GRIND_BALL,
                "Grind Ball",
                "研磨球",
                "§7Put it in an Isa grinder to process the minerals",
                "§7放入艾萨研磨机以处理矿物");
        provider.add("item.epimorphism.grind_ball.desc.yield_multiplier",
                "Yield Multiplier: %s",
                "产量系数：%s");
        provider.add("item.epimorphism.grind_ball.desc.energy_cons_multiplier",
                "Energy Cons Multiplier: %s",
                "耗能系数：%s");

        //  Debug
        provider.addItemWithTooltip(DEBUG_STRUCTURE_WRITER,
                "Debug Structure Writer",
                "多方块导出工具",
                "§7Because I need one...",
                "§7因为我需要一个...");
        provider.add("item.epimorphism.debug.structure_writer.structural_scale",
                "Structure size: X:%s Y:%s Z:%s",
                "结构规模： X:%s  Y:%s  Z:%s");
        provider.add("item.epimorphism.debug.structure_writer.export_order",
                "Export order: C:%s S:%s A:%s",
                "导出顺序： C:%s  S:%s  A:%s");
        provider.add("item.epimorphism.debug.structure_writer.export_to_log",
                "Export as a log",
                "导出为日志");
        provider.add("item.epimorphism.debug.structure_writer.export_to_file",
                "Export as a file",
                "导出为文件");
        provider.add("item.epimorphism.debug.structure_writer.rotate_along_x_axis",
                "Rotate along the X axis",
                "沿X轴旋转");
        provider.add("item.epimorphism.debug.structure_writer.rotate_along_y_axis",
                "Rotate along the Y axis",
                "沿Y轴旋转");

        //////////////////////////////////////
        //*******     Misc Items     *******//
        //////////////////////////////////////

        //  Coil
        provider.addItemWithTooltip(VOLTAGE_COIL_UHV,
                "Ultra High Voltage Coil",
                "极高压线圈",
                "Ultra Coil",
                "极致线圈");
        provider.addItemWithTooltip(VOLTAGE_COIL_UEV,
                "Ultra Excessive Voltage Coil",
                "极超压线圈",
                "Unreal Coil",
                "超凡线圈");
        provider.addItemWithTooltip(VOLTAGE_COIL_UIV,
                "Ultra Immense Voltage Coil",
                "极巨压线圈",
                "Insane Coil",
                "疯狂线圈");
        provider.addItemWithTooltip(VOLTAGE_COIL_UXV,
                "Ultra Extreme Voltage Coil",
                "极顶压线圈",
                "Epic Coil",
                "史诗线圈");
        provider.addItemWithTooltip(VOLTAGE_COIL_OPV,
                "Overpowered Voltage Coil",
                "过载压线圈",
                "Legendary Coil",
                "传奇线圈");

        //  Covers
        provider.addItemName(ELECTRIC_PUMP_MAX,
                "§c§lMAX§r Electric Pump",
                "§c§lMAX§r电动泵");
        provider.addItemName(FLUID_REGULATOR_MAX,
                "§c§lMAX§r Fluid Regulator",
                "§c§lMAX§r流体校准器");
        provider.addItemName(CONVEYOR_MODULE_MAX,
                "§c§lMAX§r Conveyor Module",
                "§c§lMAX§r传送带");
        provider.addItemName(ROBOT_ARM_MAX,
                "§c§lMAX§r Robot Arm",
                "§c§lMAX§r机械臂");
        provider.addItemName(ELECTRIC_MOTOR_MAX,
                "§c§lMAX§r Electric Motor",
                "§c§lMAX§r电动马达");
        provider.addItemName(ELECTRIC_PISTON_MAX,
                "§c§lMAX§r Electric Piston",
                "§c§lMAX§r电力活塞");
        provider.addItemName(EMITTER_MAX,
                "§c§lMAX§r Emitter",
                "§c§lMAX§r发射器");
        provider.addItemName(SENSOR_MAX,
                "§c§lMAX§r Sensor",
                "§c§lMAX§r传感器");
        provider.addItemName(FIELD_GENERATOR_MAX,
                "§c§lMAX§r Field Generator",
                "§c§lMAX§r力场发生器");

        //  Lasers
        provider.addItemWithTooltip(OPTICAL_FIBER,
                "Optical Fiber",
                "光纤",
                "§7Light-transmitting Glass",
                "§7透光玻璃");
        provider.addItemWithTooltip(DIELECTRIC_MIRROR,
                "Dielectric Mirror",
                "介电镜",
                "§7Bragg Mirror",
                "§7布氏镜");
        provider.addItemWithTooltip(EMPTY_LASER_ASSEMBLY,
                "Empty Laser Assembly",
                "空激光组件",
                "§7Fill this with some Laser Medium",
                "§7需要导光介质填充");
        provider.addItemName(HELIUM_LASER,
                "Helium Laser Emitter",
                "氦激光镭射器");
        provider.addItemName(NEON_LASER,
                "Neon Laser Emitter",
                "氖激光镭射器");
        provider.addItemName(ARGON_LASER,
                "Argon Laser Emitter",
                "氩激光镭射器");
        provider.addItemName(KRYPTON_LASER,
                "Krypton Laser Emitter",
                "氪激光镭射器");
        provider.addItemName(XENON_LASER,
                "Xenon Laser Emitter",
                "氙激光镭射器");
        provider.addItemWithTooltip(HELIUM_NEON_LASER,
                "Helium-Neon Laser",
                "氦-氖混合气激光镭射器",
                "§7Purpose: Weak Optical Appliances",
                "§7用于弱光学设备");
        provider.addItemWithTooltip(ND_YAG_LASER,
                "Nd:YAG Laser Emitter",
                "钕掺杂的钇铝榴石激光镭射器",
                "§7Purpose: Strong Optical Appliances",
                "§7用于强光学设备");

        //  Halide Lamps
        provider.addItemName(GREEN_LAMP_CORE,
                "Green Halide Lamp Core",
                "绿光卤素灯核心");
        provider.addItemName(GREEN_HALIDE_LAMP,
                "Green Halide Lamp",
                "绿光卤素灯");
        provider.addItemName(RED_LAMP_CORE,
                "Red Halide Lamp Core",
                "红光卤素灯核心");
        provider.addItemName(RED_HALIDE_LAMP,
                "Red Halide Lamp",
                "红光卤素灯");
        provider.addItemName(BLUE_LAMP_CORE,
                "Blue Halide Lamp Core",
                "蓝光卤素灯核心");
        provider.addItemName(BLUE_HALIDE_LAMP,
                "Blue Halide Lamp",
                "蓝光卤素灯");
        provider.addItemName(WHITE_LAMP_CORE,
                "White Halide Lamp Core",
                "白光卤素灯核心");
        provider.addItemName(WHITE_HALIDE_LAMP,
                "White Halide Lamp Core",
                "白光卤素灯");
        provider.addItemName(UVA_LAMP_CORE,
                "UVA Laser Emitter",
                "UVA卤素灯核心");

        provider.addItemWithTooltip(PERIODICALLY_POLED_LITHIUM_NIOBATE_BOULE,
                "Periodically Poled Lithium Niobate Boule",
                "周期性极化铌酸锂晶体",
                "§7Optical Superlattice Crystal",
                "§7光学超晶格晶体");
        provider.addItemWithTooltip(NON_LINEAR_OPTICAL_LENS,
                "Non-Linear Optical Lens",
                "非线性光学透镜",
                "§7Nonlinear Optical Frequency Conversion",
                "§7非线性光学频率转换");

        //  Condenser Components
        provider.addItemWithTooltip(BOSE_EINSTEIN_CONDENSATE_CONTAINMENT_UNIT,
                "Bose-Einstein Condensate Containment Unit",
                "凝聚态物质遏制装置",
                "§7Magnetic Evaporative Cooling",
                "§7电磁蒸发冷却");
        provider.addItemWithTooltip(BOSE_EINSTEIN_CONDENSATE,
                "Bose-Einstein Condensate",
                "玻色-爱因斯坦凝聚态物质遏制装置",
                "§72,000 §cRb-87§7 Atoms at §b170nK§7!",
                "§7在 §b170nK§7 下有整整 2,000 个 §cRb-87§7 原子！");

        provider.addItemName(PROTONATED_FULLERENE_SIEVING_MATRIX,
                "Protonated Fullerene Sieving Matrix",
                "质子化富勒烯筛分基质");
        provider.addItemName(SATURATED_FULLERENE_SIEVING_MATRIX,
                "Saturated Fullerene Sieving Matrix",
                "饱和富勒烯筛分基质");
        provider.addItemName(METASTABLE_SELF_HEALING_ADHESIVE,
                "Metastable Self-healing Adhesive",
                "超稳态自修复粘合剂");
        provider.addItemName(HYPERDIMENSIONAL_TACHYON_CONDENSED_MATTER,
                "Hyperdimensional Tachyon Condensed Matter",
                "超维度快子凝聚物质");

        //  Item
        provider.addItemName(LEPTON_TRAP_CRYSTAL,
                "Lepton Trap Crystal",
                "轻子阱晶体");
        provider.addItemName(CHARGED_LEPTON_TRAP_CRYSTAL,
                "Charged Lepton Trap Crystal",
                "带电轻子阱晶体");
        provider.addItemName(UNSTABLE_STAR,
                "Unstable Star",
                "易变之星");
        provider.addItemName(ZENITH_STAR,
                "Zenith Star",
                "天穹辉星");
        provider.addItemName(CLADDED_OPTICAL_FIBER_CORE,
                "Cladded Optical Fiber Core",
                "包层光导纤维内芯");
        provider.addItemWithTooltip(RADIOACTIVE_WASTE,
                "Radioactive Waste",
                "放射性废物",
                "§7Do not throw it away",
                "§7请勿随意丢弃");

        provider.addItemWithTooltip(NEUTRONIUM_SPHERET,
                "Neutronium Spheret",
                "中子素球体",
                "§7Extremely Heavy",
                "§7亿斤沉重");
        provider.addItemName(TRIPLET_NEUTRONIUM_SPHERET,
                "Triplet Neutronium Spheret",
                "三重态中子素球体");
        provider.addItemWithTooltip(CHARGED_TRIPLET_NEUTRONIUM_SPHERE,
                "Charged Triplet Neutronium Sphere",
                "带电三重态中子素球体",
                "§7Living Neutron Star",
                "§7活体中子星");

        provider.addItemName(SCINTILLATOR_CRYSTAL,
                "Scintillator Crystal",
                "闪烁晶体");

        provider.addItemName(CATALYST_CARRIER,
                "Catalyst Carrier",
                "催化剂载体");
        provider.addItemName(TI_AL_CATALYST,
                "Titanium-Aluminum Combined Catalyst",
                "钛-铝联合催化剂");
        provider.addItemName(PALLADIUM_CARBON_CATALYST,
                "Palladium on Carbon",
                "钯碳催化剂");

        //////////////////////////////////////
        //*******    Physics Items   *******//
        //////////////////////////////////////

        //  Particle Capsule
        provider.addItemWithTooltip(EMPTY_PARTICLE_CAPSULE,
                "Empty Particle Capsule",
                "空粒子胶囊",
                "§7A particle container constrained by a force field",
                "§7力场约束粒子容器"
        );

        //  High Energy Physics Items
        provider.addItemWithTooltip(PLASMA_CONTAINMENT_CELL,
                "Plasma Containment Cell",
                "等离子体遏制装置",
                "§7It is used to encapsulate plasma",
                "§7用于封装等离子体"
        );
        provider.addItemWithTooltip(RHENIUM_PLASMA_CONTAINMENT_CELL,
                "Rhenium Plasma Containment Cell",
                "铼等离子遏制装置",
                "§7Cooling is performed using §6Plasma Condenser",
                "§7使用§6等离子冷凝器§7进行冷却"
        );
        provider.addItemWithTooltip(NEUTRON_PLASMA_CONTAINMENT_CELL,
                "Neutron Plasma Containment Cell",
                "中子等离子遏制装置",
                "§7Cooling is performed using §6Plasma Condenser",
                "§7使用§6等离子冷凝器§7进行冷却"
        );
        provider.addItemWithTooltip(HYPOGEN_PLASMA_CONTAINMENT_CELL,
                "Hypogen Plasma Containment Cell",
                "海珀珍等离子遏制装置",
                "§7Cooling is performed using §6Plasma Condenser",
                "§7使用§6等离子冷凝器§7进行冷却"
        );
        provider.addItemWithTooltip(ACTINIUM_SUPERHYDRIDE_PLASMA_CONTAINMENT_CELL,
                "Actinium Superhydride Plasma Containment Cell",
                "超氢化锕等离子遏制装置",
                "§7Cooling is performed using §6Plasma Condenser",
                "§7使用§6等离子冷凝器§7进行冷却"
        );
        provider.addItemWithTooltip(QUANTUM_ANOMALY,
                "Quantum Anomaly",
                "量子反常",
                "§7Laser irradiation should probably be used",
                "§7或许应使用激光照射"
        );

        provider.add("item.epimorphism.reactor_component.desc.heat",
                "§fHeat: §a%d / %d",
                "§f热量: §a%d / %d");

        //////////////////////////////////////
        //*****    Agriculture Items   *****//
        //////////////////////////////////////

        //  Algae
        provider.addItemName(ORDINARY_ALGAE,
                "Ordinary Algae",
                "普通藻类");
        provider.addItemName(RED_ALGA,
                "Red Alga",
                "红藻");
        provider.addItemName(GREEN_ALGA,
                "Green Alga",
                "绿藻");
        provider.addItemName(CHRYSOPHYCEAE,
                "Golden Alga",
                "金藻");
        provider.addItemName(BROWN_ALGA,
                "Brown Alga",
                "褐藻");
        provider.addItemName(PINECONE,
                "Pinecone",
                "松果");


        //////////////////////////////////////
        //*******    Biology Items   *******//
        //////////////////////////////////////

        //  Biological Components
        provider.addItemWithTooltip(ELECTROCHEMICAL_GRADIENT_RECORDER,
                "Electrochemical Gradient Recorder",
                "电化学梯度记录仪",
                "§7Fundamentals of Biocomputing",
                "§7生物计算基础");
        provider.addItemWithTooltip(ULTRA_MICRO_PHASE_SEPARATOR,
                "Ultra-micro Phase Separator",
                "超微型相分离器",
                "§7Guardian of Biochemical Reactions",
                "§7生化反应守护者");
        provider.addItemWithTooltip(QUANTUM_TUNNELING_MICROTUBULE,
                "Quantum Tunneling Microtubule",
                "量子隧穿微管",
                "§7Biological Fusion has finally become a reality",
                "§7生物聚变终成现实");
        provider.addItemWithTooltip(HYPERRIBOSOME,
                "Hyperribosome",
                "超核糖体",
                "§7Protein Factory",
                "§7蛋白质工厂");
        provider.addItemWithTooltip(NEUTRON_ABSORBING_PROTEIN,
                "Neutron Absorbing Protein",
                "中子吸收蛋白",
                "§7Inconceivable",
                "§7不可思议");
        provider.addItemWithTooltip(SUPEREXCITED_CONDUCTIVE_POLYMER,
                "Superexcited Conductive Polymer",
                "超激发传导聚合体",
                "§7Biological High-voltage Line",
                "§7生物高压线");

        // Bacterium
        provider.addItemWithTooltip(STERILIZED_PETRI_DISH,
                "Sterilized Petri Dish",
                "无菌培养皿",
                "§7",
                "§7");

        WrapItemLang.init(provider);

    }
}
