package cn.gtcommunity.epimorphism.data.lang;

import cn.gtcommunity.epimorphism.common.data.machine.AdvancedMachines;
import cn.gtcommunity.epimorphism.common.data.machine.BiologyMachines;
import cn.gtcommunity.epimorphism.common.data.machine.GeneratorMachines;
import com.epimorphismmc.monomorphism.datagen.lang.MOLangProvider;
import com.gregtechceu.gtceu.api.GTValues;

import java.util.List;

import static cn.gtcommunity.epimorphism.common.data.EPMachines.*;
import static cn.gtcommunity.epimorphism.common.data.machine.AdvancedMachines.*;
import static cn.gtcommunity.epimorphism.common.data.machine.EPAEMachines.*;
import static com.epimorphismmc.monomorphism.MOValues.CVLVH;
import static com.gregtechceu.gtceu.api.GTValues.*;
import static com.gregtechceu.gtceu.common.data.GTMachines.*;

public class MachineLang {
    public static void init(MOLangProvider provider) {

        provider.addBlockWithTooltip(GeneratorMachines.LARGE_NAQUADAH_REACTOR::getBlock,
                "大型硅岩反应堆",
                List.of(
                        ),
                List.of(
                        ));
        provider.add("block.epimorphism.large_naquadah_reactor.real_eut",
                "Energy output: %s EU/t",
                "能量输出：%s EU/t");

        provider.addBlockWithTooltip(GeneratorMachines.UNIVERSAL_CHEMICAL_FUEL_ENGINE::getBlock,
                "通用化学能引擎",
                List.of(
                ),
                List.of(
                ));
        provider.add("block.epimorphism.universal_chemical_fuel_engine.efficiency",
                "Efficiency: %s %%",
                "效率：%s %%");

        provider.addTieredMachineName("solid_oxide_fuel_cell", tier -> "固体氧化物燃料电池 MK%s".formatted(tier == HV ? 1 : 2), HV, IV);
        provider.add("block.epimorphism.solid_oxide_fuel_cell.efficiency",
                "Efficiency: %s %%",
                "效率：%s %%");

        provider.addBlockWithTooltip(YOTTA_FLUID_TANK::getBlock,
                "YOT流体储罐",
                List.of(
                        "The maximum level of the fluid Cell Is Limited By The Glass Level",
                        "Fluid Tank Cell Can Be Stacked Up To 15 Blocks"),
                List.of(
                        "流体单元等级上限由玻璃等级限制",
                        "流体单元的堆叠高度上限为15格"));
        provider.add("block.epimorphism.yotta_fluid_tank.fluid",
                "Fluid: %s",
                "液体：%s");
        provider.add("block.epimorphism.yotta_fluid_tank.stored",
                "Stored: %s L",
                "存储：%s L");
        provider.add("block.epimorphism.yotta_fluid_tank.capacity",
                "Capacity: %s L",
                "容量：%s L");

        provider.addBlockWithTooltip(TFFT::getBlock, "T.F.F.T",
                List.of(
                        "Technology Field Fluid Tank"),
                List.of(
                        "科技立场流体储罐"));

        provider.addBlockWithTooltip(NEUTRON_ACTIVATOR::getBlock,
                "中子活化器",
                List.of(
                        "§o§7Faster-than-light motion!",
                        "§6Additional high-speed tubing blocks provide recipe time reduction while reducing the efficiency of the neutron accelerator",
                        "§6When operating without a neutron accelerator, neutron kinetic energy decreases §e72KeV§6 neutron kinetic energy per second",
                        "§6Input graphite beryllium powder can immediately absorb §e10MeV§6 neutron kinetic energy",
                        "§6Neutron kinetic energy will explode when it exceeds §41200MeV§6!"),
                List.of(
                        "§o§7超光速运动!",
                        "§6额外的高速管道方块提供配方时间减免，同时降低中子加速器的效率",
                        "§6没有中子加速器运行时，中子动能每秒降低§e72KeV§6中子动能",
                        "§6输入石墨/铍粉可以立即吸收§e10MeV§6中子动能",
                        "§6当中子动能超过§41200MeV§6后将会爆炸！"));
        provider.add("block.epimorphism.neutron_activator.ev",
                "Current Neutron Energy: %deV",
                "当前中子动能: %seV");
        provider.add("block.epimorphism.neutron_activator.height",
                "Height: %s",
                "高度: %s");
        provider.add("block.epimorphism.neutron_activator.efficiency",
                "Time-consuming: %s%%",
                "耗时: %s%%");

        provider.addBlockWithTooltip(BiologyMachines.BACTERIAL_CULTURE_TANK::getBlock,
                "细菌培养缸",
                List.of(

                ),
                List.of(

                ));

        provider.addBlockWithTooltip(CATALYTIC_REFORMER::getBlock,
                "催化重整炉",
                List.of(

                ),
                List.of(

                ));

        provider.addBlockWithTooltip(CRYOGENIC_REACTOR::getBlock,
                "低温反应室",
                List.of(

                ),
                List.of(

                ));

        provider.addBlockWithTooltip(BURNER_REACTOR::getBlock,
                "燃烧反应室",
                List.of(

                ),
                List.of(

                ));

        provider.addBlockWithTooltip(CHEMICAL_PLANT::getBlock,
                "化工厂",
                List.of(

                ),
                List.of(

                ));
        provider.add("block.epimorphism.chemical_plant.voltage",
                "Recipe Voltage: %s",
                "配方电压: %s");
        provider.add("block.epimorphism.chemical_plant.speed",
                "Speed: %s%%",
                "速度: %s%%");
        provider.add("block.epimorphism.chemical_plant.chance",
                "Catalyst consumption probability: %s%%",
                "催化剂消耗概率: %s%%");

        provider.addBlockWithTooltip(AdvancedMachines.COMPONENT_ASSEMBLY_LINE::getBlock,
                "部件装配线",
                List.of(
                        "Assemble A Wide Variety Of Parts In Batches",
                        "Efficiency Crushes The Same Level Of Assembly Machine/Assembly Line!",
                        "Requires §6 Component Assembly Line Casing§7 Of Different Grades",
                        "Component Assembly Line Enclosures Limit §rRecipe Level§7 That The Machine Can Execute"),
                List.of(
                        "批量装配各式各样的零部件",
                        "效率碾压同等级组装机/装配线！",
                        "需要不同等级的§6装配线外壳§7",
                        "部件装配线外壳限制了机器可执行的§r配方等级§7"));

        provider.addBlockWithTooltip(AdvancedMachines.GENERAL_PROCESSING_PLANT::getBlock,
                "通用加工厂",
                List.of(
                        "§7Highly Integrated Machining",
                        "§e2.5§6 Times Faster Than A Single Block Machine Of The Same Voltage",
                        "§5Only §E 80%% §5 Of The Required Power Of The Recipe Needs To Be Used",
                        "§bFor Each Voltage Level Raised, §e8§b Is Added To The Maximum Number Of Parallels"),
                List.of(
                        "§7高度集成加工",
                        "§6比相同电压的单方块机器快§e2.5§6倍",
                        "§5只需要使用配方要求功率的§e80%%",
                        "§b每提升一个电压等级，最大并行数加§e8"));
        provider.addShiftTooltip(AdvancedMachines.GENERAL_PROCESSING_PLANT::getBlock,
                List.of(
                        "§7Use A Programming Circuit To Control The Recipe In The Current Mode",
                        "§4Mode A§r: §e20§r - Compressor §e21§r - Lathe §e22§r - Two Pole Magnetizer",
                        "§3Mode B§r: §e20§r - Fermentation Tank §e21§r - Extractor §e22§r - Canning Machine",
                        "§2Mode C§r: §e20§r - Precision Laser Etching Machine §e21§r - Autoclave §e22§r - Fluid Curing Machine"),
                List.of(
                        "§7使用编程电路控制当前模式下的配方",
                        "§4模式A§r：§e20§r-压缩机 §e21§r-车床 §e22§r-两极磁化机",
                        "§3模式B§r：§e20§r-发酵槽 §e21§r-提取机 §e22§r-装罐机",
                        "§2模式C§r：§e20§r-精密激光蚀刻机 §e21§r-高压釜 §e22§r-流体固化机"));

        provider.addBlockWithTooltip(BiologyMachines.INDUSTRIAL_FISHING_POND::getBlock,
                "珠海渔场",
                List.of(
                        "§7The Gift Of The Sea",
                        "Catch A Lot Of Seafood For You In Different Modes",
                        "§9The Inside Of The Multiblock Needs To Be Filled With Water",
                        "§bFor Each Voltage Level Raised, §E 8§B Is Added To The Maximum Number Of Parallels",
                        "§7Use A Screwdriver To Switch Fishing Modes",
                        "§7The Water In The Input Bin Is Automatically Filled Into The Structure"),
                List.of(
                        "§7海之恩赐",
                        "以不同的模式为你捕捞大量水产",
                        "§9多方块的内部需要填满水",
                        "§b每提升一个电压等级，最大并行数加§e2",
                        "§7使用螺丝刀切换捕捞模式",
                        "§7输入仓中的水会自动填入结构"));

        provider.add("block.epimorphism.industrial_fishing_pond.fishing_mode.0",
                "Fishing for Fish",
                "捕捞鱼类");
        provider.add("block.epimorphism.industrial_fishing_pond.fishing_mode.1",
                "Fishing for Junk",
                "捕捞垃圾");
        provider.add("block.epimorphism.industrial_fishing_pond.fishing_mode.2",
                "Fishing for Treasure",
                "捕捞宝藏");
        provider.add("block.epimorphism.industrial_fishing_pond.warning.fill_water",
                "WARNING: Water Sources Are Insufficient.",
                "警告：水源不足");

        provider.addBlockWithTooltip(BiologyMachines.FERMENTATION_TANK::getBlock,
                "发酵罐",
                "",
                "");

        provider.addBlockWithTooltip(AdvancedMachines.MEGA_CRACKING_UNIT::getBlock,
                "巨型裂化装置",
                List.of(

                ),
                List.of(

                ));

        provider.addBlockWithTooltip(AdvancedMachines.MEGA_ALLOY_BLAST_SMELTER::getBlock,
                "巨型合金冶炼厂",
                List.of(

                ),
                List.of(

                ));

        provider.addBlockWithTooltip(VACUUM_DRYING_FURNACE::getBlock,
                "真空干燥炉",
                List.of(

                ),
                List.of(

                ));

        provider.addBlockWithTooltip(ISA_MILL::getBlock,
                "艾萨研磨机",
                List.of(

                ),
                List.of(

                ));

        provider.addBlockWithTooltip(INTEGRATED_ORE_FACTORY::getBlock,
                "集成矿石处理厂",
                List.of(
                        ),
                List.of(
                        ));

        provider.addMultiLang("block.epimorphism.integrated_ore_factory.ore_processing_mode.%s"::formatted,
                tier -> "Processing Mode %s".formatted(tier + 1),
                tier -> "处理模式 %s".formatted(tier + 1), tiersBetween(0, 4));
        provider.addMultilineLang("block.epimorphism.integrated_ore_factory.ore_processing_mode.0.desc",
                "Grinding-washing-grinding-centrifugation\nTime: 15s",
                "研磨-洗矿-研磨-离心\n用时: 15s");
        provider.addMultilineLang("block.epimorphism.integrated_ore_factory.ore_processing_mode.1.desc",
                "Grinding-grinding-centrifugation\nTime: 10s",
                "研磨-研磨-离心\n用时: 10s");
        provider.addMultilineLang("block.epimorphism.integrated_ore_factory.ore_processing_mode.2.desc",
                "Grinding-washing-screening\nTime: 20s",
                "研磨-洗矿-筛选\n用时: 20s");
        provider.addMultilineLang("block.epimorphism.integrated_ore_factory.ore_processing_mode.3.desc",
                "Grinding-chemical dipping-grinding-centrifugation\nTime: 17s",
                "研磨-化学浸洗-研磨-离心\n用时: 17s");
        provider.addMultilineLang("block.epimorphism.integrated_ore_factory.ore_processing_mode.4.desc",
                "Grinding-washing-thermocentrifugation-grinding\nTime: 30s",
                "研磨-洗矿-热力离心-研磨\n用时: 30s");

        provider.addBlockWithTooltip(AdvancedMachines.ADVANCED_ELECTRIC_BLAST_FURNACE::getBlock, "炽炎高炉",
                List.of(

                ),
                List.of(

                ));
        provider.add("block.epimorphism.advanced_electric_blast_furnace.warning.blazing_pyrotheum",
                "§4WARNING: Insufficient Blazing Pyrotheum",
                "§4警告：烈焰之炽焱不足");
        provider.add("block.epimorphism.advanced_electric_blast_furnace.blazing_pyrotheum",
                "§cBlazing Pyrotheum are converting into heat!",
                "§c烈焰之炽焱正在转换为热量！");

        provider.addBlockWithTooltip(AdvancedMachines.INDUSTRIAL_VACUUM_FREEZER::getBlock, "凛冰冷冻机",
                List.of(

                ),
                List.of(

                ));
        provider.add("block.epimorphism.industrial_vacuum_freezer.warning.gelid_cryotheum",
                "§4WARNING: Insufficient Gelid Cryotheum",
                "§4警告：极寒之凛冰不足");
        provider.add("block.epimorphism.industrial_vacuum_freezer.gelid_cryotheum",
                "§bGelid Cryotheum are absorbing surrounding heat!",
                "§b极寒之凛冰正在吸收周围的热量！");

        provider.addBlockWithTooltip(INDUSTRIAL_FLOTATION_CELL::getBlock, "工业级浮选机",
                List.of(

                ),
                List.of(

                ));

        provider.addBlockWithTooltip(AdvancedMachines.PRECISE_ASSEMBLER::getBlock, "精密组装机",
                List.of(
                        "§7The error does not exceed 7 nm",
                        "Available Recipe Types：§9Assembler§r,§9Precision Assemble",
                        "Different Machine Housings Are Used To Determine The Machine Class",
                        "§6When running §9Assembler§6 recipes, §bDuration §6reduction §f50%§e6.",
                        "§6When running §9Assembler§6 recipes, §5Parallel §6add §e2^(machine enclosure level +4) §6.)"),
                List.of(
                        "§7误差不超过7nm",
                        "可用配方类型：§9组装机§r，§9组装精密",
                        "使用不同的机器外壳判定机器等级",
                        "§6运行§9组装机§6配方时，§b耗时§6减少§e50%§6。",
                        "§6运行§9组装机§6配方时，§5并行§6增加§e2^(机器外壳等级+4)§6。"));

        provider.addBlockWithTooltip(DIGESTER::getBlock, "煮解池",
                List.of(

                ),
                List.of(

                ));

        provider.addBlockWithTooltip(INDUSTRIAL_DRILL::getBlock, "工业钻机",
                List.of(

                ),
                List.of(

                ));

        provider.addBlockWithTooltip(FRACKER::getBlock, "压裂机",
                List.of(

                ),
                List.of(

                ));

        provider.addBlockWithTooltip(INFINITE_FLUID_DRILLING_RIG::getBlock, "无尽流体钻机",
                List.of(

                ),
                List.of(

                ));

        provider.addTieredMachineName("concrete_backfiller", "混凝土回填机", MV, EV);
        

        provider.addBlockWithTooltip(ROASTER::getBlock, "焙烧炉",
                List.of(
                        "§7Cook slowly over low heat.",
                        "For every 1 level above the recipe firebox  level, §bDuration §rmultiplied by §e50%§r."
                ),
                List.of(
                        "§7小火慢烹。",
                        "每超过配方所需燃烧室等级1级，§b耗时§r乘以§e50%§r。"
                ));

        provider.addBlockWithTooltip(CVD_UNIT::getBlock, "化学气相沉积单元",
                List.of(
                ),
                List.of(
                ));

        provider.addBlockWithTooltip(PLASMA_CVD::getBlock, "等离子体增强化学气相沉积单元",
                List.of(
                ),
                List.of(
                ));

        provider.addBlockWithTooltip(LASER_CVD::getBlock, "激光诱导化学气相沉积单元",
                List.of(
                ),
                List.of(
                ));

        provider.addBlockWithTooltip(NANOSCALE_FABRICATOR::getBlock, "纳米制造室",
                List.of(
                ),
                List.of(
                ));

        provider.addBlockWithTooltip(CRYSTALLIZATION_CRUCIBLE::getBlock, "结晶坩埚",
                List.of(
                ),
                List.of(
                ));

        provider.addBlockWithTooltip(STEAM_PISTON_HAMMER::getBlock, "蒸汽锻造锤",
                List.of(
                        "A Multiblock Piston Hammer at the Steam Age. ",
                        "Only use Steam Input/Output busses, And that only use Steam Hatch.",
                        "§bDuration：§e+50%",
                        "§dParallel：§e8"
                ),
                List.of(
                        "蒸汽时代的多方块锻造锤。",
                        "仅可使用输入/输出总线（蒸汽），并且只能用蒸汽仓供给蒸汽。",
                        "§b耗时：§e+50%",
                        "§d并行：§e8"
                ));

        provider.addBlockWithTooltip(STEAM_PRESSOR::getBlock, "蒸汽压缩机",
                List.of(
                        "A Multiblock Compressor at the Steam Age. ",
                        "Only use Steam Input/Output busses, And that only use Steam Hatch.",
                        "§bDuration：§e+50%",
                        "§dParallel：§e8"
                ),
                List.of(
                        "蒸汽时代的多方块压缩机。",
                        "仅可使用输入/输出总线（蒸汽），并且只能用蒸汽仓供给蒸汽。",
                        "§b耗时：§e+50%",
                        "§d并行：§e8"
                ));

        provider.addBlockWithTooltip(STEAM_SEPARATOR::getBlock, "蒸汽离心机",
                List.of(
                        "A Multiblock Centrifuge at the Steam Age. ",
                        "Only use Steam Input/Output busses, And that only use Steam Hatch.",
                        "§bDuration：§e+50%",
                        "§dParallel：§e8"
                ),
                List.of(
                        "蒸汽时代的多方块离心机。",
                        "仅可使用输入/输出总线（蒸汽），并且只能用蒸汽仓供给蒸汽。",
                        "§b耗时：§e+50%",
                        "§d并行：§e8"
                ));

        provider.addBlockWithTooltip(STEAM_FOUNDRY::getBlock, "蒸汽合金炉",
                List.of(
                        "A Multiblock Alloy Smelter at the Steam Age. ",
                        "Only use Steam Input/Output busses, And that only use Steam Hatch.",
                        "§bDuration：§e+50%",
                        "§dParallel：§e8"
                ),
                List.of(
                        "蒸汽时代的多方块合金炉。",
                        "仅可使用输入/输出总线（蒸汽），并且只能用蒸汽仓供给蒸汽。",
                        "§b耗时：§e+50%",
                        "§d并行：§e8"
                ));

        provider.addCN("block.epimorphism.uhv_fusion_reactor", "核聚变反应堆控制电脑 MK-IV");
        provider.add("gtceu.multiblock.fusion_reactor.uhv.description",
                "The Fusion Reactor MK 4 is a large multiblock structure used for fusing elements into heavier ones. It can only use UHV and UEV Energy Hatches. For every Hatch it has, its buffer increases by 80M EU, and has a maximum of 1280M.",
                "核聚变反应堆 MK4是一台大型多方块结构，用于融合元素形成更重的元素。它只能使用§4UHV§r和§aUEV§r等级的能源仓。每个能源仓可增加80M EU的能量缓存，最大能量缓存为1280M。");

        provider.addCN("block.epimorphism.uev_fusion_reactor", "核聚变反应堆控制电脑 MK-V");
        provider.add("gtceu.multiblock.fusion_reactor.uev.description",
                "The Fusion Reactor MK 5 is a large multiblock structure used for fusing elements into heavier ones. It can only use UEV Energy Hatches. For every Hatch it has, its buffer increases by 160M EU, and has a maximum of 2560M.",
                "核聚变反应堆 MK5是一台大型多方块结构，用于融合元素形成更重的元素。它只能使用§aUEV§r等级的能源仓。每个能源仓可增加160M EU的能量缓存，最大能量缓存为2560M。");

        provider.addBlockWithTooltip(INFINITY_CRATE::getBlock, "无尽板条箱",
                "§7Can Hold §R 2^31 1§7 Items Per Slot, And Cannot Store Items With §eNBT",
                "§7每格能容纳§r2^31-1§7个物品，不能存储带有§eNBT§7的物品");

        // ############################################################################################################
        // Machine
        provider.addTieredMachineName("lightning_rod", tier -> "%s避雷针 %s".formatted(CVLVH[tier], VLVT[tier]), tiersBetween(LuV, UV));


        // ############################################################################################################
        // Hatch
        provider.addBlockWithTooltip(INFINITE_WATER_HATCH::getBlock, "无限水仓",
                List.of(
                        "§7Minecraft Exclusive!",
                        "§bUnlimited Water For Multiblocks!",
                        "§4WARNING: Water In This Hatch Cannot Be Pumped Out!"),
                List.of(
                        "§7Minecraft 独家技术！",
                        "§b为多方块结构提供无穷无尽的水！",
                        "§4警告：该仓室中的水无法被抽出！"));

        provider.addTieredMachineName("intake_hatch", "进气仓", tiersBetween(IV, UHV));
        provider.addBlockWithTooltip("intake_hatch",
                List.of(
                        "§7Inhale air from your surroundings.",
                        "§lDo not block the air intake!"),
                List.of(
                        "§7从周围环境吸入空气。",
                        "§c§l切 勿 阻 隔 进 气 口！"));

        provider.addTieredMachineName("neutron_accelerator", "中子加速器", ELECTRIC_TIERS);
        provider.addBlockWithTooltip("neutron_accelerator",
                List.of(
                        "§7Input The Eu And Accelerate The Neutron!",
                        "Each Point Of Eu Is Converted Into 10~20eV Neutron Kinetic Energy"),
                List.of(
                        "§7输入EU，加速中子！",
                        "每点EU都会转化为10～20eV中子动能"));

        provider.addBlockWithTooltip(NEUTRON_SENSOR::getBlock, "中子传感器",
                "§7Can Be Installed On §B Neutron Activator§R, Which Outputs A Redstone Signal Based On §6 Neutron Kinetic Energy§R, And Right Clicks To Open The Gui To Set It.",
                "§7可安装在§b中子活化器§7上，基于§6中子动能§7输出红石信号，右键以打开GUI进行设置。");

        provider.addTieredMachineName("radiation_hatch", "放射仓", GTValues.tiersBetween(3, 13));
        provider.addBlockWithTooltip("radiation_hatch",
                List.of(
                        "Input Radioactive Materials For Multiblock",
                        "§7Use A Screwdriver To Set The Suppression Level"),
                List.of(
                        "为多方块结构输入放射性物品",
                        "§7使用螺丝刀设置抑制等级"));

        provider.addBlockWithTooltip(GRIND_BALL_HATCH::getBlock, "研磨球仓",
                List.of(
                        "§7Watch Your Fingers!",
                        "§fGrind Balls Are Provided To Use For Multiblocks。",
                        "§eAllows The Input Of Grinding Balls From The Input Bus。"),
                List.of(
                        "§7小心你的手指！",
                        "§f为多方块结构提供研磨球来使用。",
                        "§e允许从输入总线输入研磨球。"));

        provider.addBlockWithTooltip(TANK_ACCESS_HATCH::getBlock, "储罐访问仓",
                List.of(

                        ),
                List.of(

                        ));

        provider.addBlockWithTooltip(CRAFTING_INPUT_BUFFER::getBlock,
                "ME Crafting Input Buffer",
                "ME样板输入总成",
                List.of(

                ),
                List.of(

                ));

    }
}
