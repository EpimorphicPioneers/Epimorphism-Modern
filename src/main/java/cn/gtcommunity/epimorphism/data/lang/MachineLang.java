package cn.gtcommunity.epimorphism.data.lang;

import com.gregtechceu.gtceu.api.GTValues;
import net.minecraftforge.common.data.LanguageProvider;

import java.util.List;

import static cn.gtcommunity.epimorphism.common.data.EPMachines.*;
import static cn.gtcommunity.epimorphism.data.lang.EPLangHelper.*;
import static cn.gtcommunity.epimorphism.integration.ae2.machine.EPAEMachine.*;
import static com.gregtechceu.gtceu.api.GTValues.*;
import static com.gregtechceu.gtceu.common.data.GTMachines.*;

public class MachineLang {
    public static void init(LanguageProvider provider) {

        addBlockWithTooltip(provider, YOTTA_FLUID_TANK::getBlock, "YOT流体储罐",
                List.of(
                        "The maximum level of the fluid Cell Is Limited By The Glass Level",
                        "Fluid Tank Cell Can Be Stacked Up To 15 Blocks"),
                List.of(
                        "流体单元等级上限由玻璃等级限制",
                        "流体单元的堆叠高度上限为15格"));
        add(provider, "block.epimorphism.yotta_fluid_tank.fluid",
                "Fluid: %s",
                "液体：%s");
        add(provider, "block.epimorphism.yotta_fluid_tank.stored",
                "Stored: %s L",
                "存储：%s L");
        add(provider, "block.epimorphism.yotta_fluid_tank.capacity",
                "Capacity: %s L",
                "容量：%s L");

        addBlockWithTooltip(provider, TFFT::getBlock, "T.F.F.T",
                List.of(
                        "Technology Field Fluid Tank"),
                List.of(
                        "科技立场流体储罐"));

        addBlockWithTooltip(provider, NEUTRON_ACTIVATOR::getBlock, "中子活化器",
                List.of(
                        "§o§7Faster-than-light motion!",
                        "§6Additional high-speed tubing cn.gtcommunity.epimorphism.data.recipe.blocks provide recipe time reduction while reducing the efficiency of the neutron accelerator",
                        "§6When operating without a neutron accelerator, neutron kinetic energy decreases §e72KeV§6 neutron kinetic energy per second",
                        "§6Input graphite beryllium powder can immediately absorb §e10MeV§6 neutron kinetic energy",
                        "§6Neutron kinetic energy will explode when it exceeds §41200MeV§6!"),
                List.of(
                        "§o§7超光速运动!",
                        "§6额外的高速管道方块提供配方时间减免，同时降低中子加速器的效率",
                        "§6没有中子加速器运行时，中子动能每秒降低§e72KeV§6中子动能",
                        "§6输入石墨/铍粉可以立即吸收§e10MeV§6中子动能",
                        "§6当中子动能超过§41200MeV§6后将会爆炸！"));
        add(provider, "block.epimorphism.neutron_activator.ev",
                "Current Neutron Energy: %deV",
                "当前中子动能: %seV");
        add(provider, "block.epimorphism.neutron_activator.height",
                "Height: %s",
                "高度: %s");
        add(provider, "block.epimorphism.neutron_activator.efficiency",
                "Time-consuming: %s%%",
                "耗时: %s%%");

        addBlockWithTooltip(provider, EXTREME_INDUSTRIAL_GREENHOUSE::getBlock, "极限工业温室",
                List.of(

                ),
                List.of(

                ));

        addBlockWithTooltip(provider, BACTERIAL_CULTURE_TANK::getBlock, "细菌培养缸",
                List.of(

                ),
                List.of(

                ));

        addBlockWithTooltip(provider, CHEMICAL_PLANT::getBlock, "化工厂",
                List.of(

                ),
                List.of(

                ));

        addBlockWithTooltip(provider, COMPONENT_ASSEMBLY_LINE::getBlock, "部件装配线",
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

        addBlockWithTooltip(provider, GENERAL_PROCESSING_PLANT::getBlock, "通用加工厂",
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
        addBlockWithShiftTooltip(provider, GENERAL_PROCESSING_PLANT::getBlock,
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

        addBlockWithTooltip(provider, INDUSTRIAL_FISHING_POND::getBlock, "珠海渔场",
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

        add(provider, "block.epimorphism.industrial_fishing_pond.fishing_mode.0",
                "Fishing for Fish",
                "捕捞鱼类");
        add(provider, "block.epimorphism.industrial_fishing_pond.fishing_mode.1",
                "Fishing for Junk",
                "捕捞垃圾");
        add(provider, "block.epimorphism.industrial_fishing_pond.fishing_mode.2",
                "Fishing for Treasure",
                "捕捞宝藏");
        add(provider, "block.epimorphism.industrial_fishing_pond.warning.fill_water",
                "WARNING: Water Sources Are Insufficient.",
                "警告：水源不足");

        addBlockWithTooltip(provider, FERMENTATION_TANK::getBlock, "发酵罐",
                "",
                "");

        addBlockWithTooltip(provider, MEGA_CRACKING_UNIT::getBlock, "巨型裂化装置",
                List.of(

                ),
                List.of(

                ));

        addBlockWithTooltip(provider, MEGA_ALLOY_BLAST_SMELTER::getBlock, "巨型合金冶炼厂",
                List.of(

                ),
                List.of(

                ));

        addBlockWithTooltip(provider, VACUUM_DRYING_FURNACE::getBlock, "真空干燥炉",
                List.of(

                ),
                List.of(

                ));

        addBlockWithTooltip(provider, ISA_MILL::getBlock, "艾萨研磨机",
                List.of(

                ),
                List.of(

                ));

        addBlockWithTooltip(provider, ADVANCED_ELECTRIC_BLAST_FURNACE::getBlock, "炽焱高炉",
                List.of(
                        "§7Blazing power！",
                        "Available Recipe Types：§9Electric Blast Furnace",
                        "Need to provide §cBlazing Pyrotheum§b for work.",
                        "When no §cBlazing Pyrotheum§b are provided, Volcanus will shut down."
                ),
                List.of(
                        "§7烈焰之力！",
                        "可用配方类型：§9电力高炉",
                        "需要提供§c烈焰之炽焱§f以工作。",
                        "未提供§c烈焰之炽焱§f时，炽焱高炉将会停机。"
                ));
        addBlockWithCtrlTooltip(provider, ADVANCED_ELECTRIC_BLAST_FURNACE::getBlock,
                List.of(
                        "§6When running §9Electric Blast Furnace§6 recipes：",
                        "§6· §bDuration：§6-§f50%",
                        "§6· §5Parallel：§6+§e2^(Coil tier +4)"
                ),
                List.of(
                        "§6运行§9电力高炉§6配方时：",
                        "§6· §b耗时：§6-§e50%",
                        "§6· §5并行：§e2^(线圈等级-1)"
                ));
        add(provider, "block.epimorphism.advanced_electric_blast_furnace.warning.blazing_pyrotheum",
                "§4WARNING: Insufficient Blazing Pyrotheum",
                "§4警告：烈焰之炽焱不足");
        add(provider, "block.epimorphism.advanced_electric_blast_furnace.blazing_pyrotheum",
                "§cBlazing Pyrotheum are converting into heat!",
                "§c烈焰之炽焱正在转换为热量！");

        addBlockWithTooltip(provider, INDUSTRIAL_VACUUM_FREEZER::getBlock, "凛冰冷冻机",
                List.of(
                        "§7Gelid power！",
                        "Available Recipe Types：§9Vacuum Freezer",
                        "Need to provide §bGelid Cryotheum§b for work.",
                        "When no §bGelid Cryotheum§b are provided, Cryogenic Freezer will shut down."
                ),
                List.of(
                        "§7极寒之力！",
                        "可用配方类型：§9真空冷冻机",
                        "需要提供§b极寒之凛冰§f以工作。",
                        "未提供§b极寒之凛冰§f时，凛冰冷冻机将会停机。"
                ));
        addBlockWithCtrlTooltip(provider, INDUSTRIAL_VACUUM_FREEZER::getBlock,
                List.of(
                        "§6When running §9Vacuum Freezer§6 recipes：",
                        "§6· §bDuration：§6-§f50%",
                        "§6· §5Parallel：§6+§e3"
                ),
                List.of(
                        "§6运行§9真空冷冻机§6配方时：",
                        "§6· §b耗时：§6-§e50%",
                        "§6· §5并行：§e4"
                ));
        add(provider, "block.epimorphism.industrial_vacuum_freezer.warning.gelid_cryotheum",
                "§4WARNING: Insufficient Gelid Cryotheum",
                "§4警告：极寒之凛冰不足");
        add(provider, "block.epimorphism.industrial_vacuum_freezer.gelid_cryotheum",
                "§bGelid Cryotheum are absorbing surrounding heat!",
                "§b极寒之凛冰正在吸收周围的热量！");

        addBlockWithTooltip(provider, INDUSTRIAL_FLOTATION_CELL::getBlock, "工业级浮选机",
                List.of(

                ),
                List.of(

                ));

        addBlockWithTooltip(provider, PRECISE_ASSEMBLER::getBlock, "精密组装机",
                List.of(
                        "§7The error does not exceed 7 nm",
                        "Available Recipe Types：§9Assembler§r,§9Precision Assemble",
                        "Different Machine Housings Are Used To Determine The Machine Class"
                ),
                List.of(
                        "§7误差不超过7nm",
                        "可用配方类型：§9组装机§r，§9组装精密",
                        "使用不同的机器外壳判定机器等级"
                ));
        addBlockWithCtrlTooltip(provider, PRECISE_ASSEMBLER::getBlock,
                List.of(
                        "§6When running §9Assembler§6 recipes：",
                        "§6· §bDuration：§6-§f50%",
                        "§6· §5Parallel：§e2^(Machine tier +4)"
                ),
                List.of(
                        "§6运行§9组装机§6配方时：",
                        "§6· §b耗时：§6-§e50%",
                        "§6· §5并行：§e2^(机器等级+4)"
                ));

        addBlockWithTooltip(provider, DIGESTER::getBlock, "煮解池",
                List.of(

                ),
                List.of(

                ));

        addBlockWithTooltip(provider, INDUSTRIAL_DRILL::getBlock, "工业钻机",
                List.of(

                ),
                List.of(

                ));

        addBlockWithTooltip(provider, FRACKER::getBlock, "压裂机",
                List.of(

                ),
                List.of(

                ));

        addBlockWithTooltip(provider, INFINITE_FLUID_DRILLING_RIG::getBlock, "无尽流体钻机",
                List.of(

                ),
                List.of(

                ));

        addTieredMachineName(provider, "concrete_backfiller", "混凝土回填机", MV, EV);
        addBlockWithTooltip(provider, "concrete_backfiller",
                List.of(

                ),
                List.of(

                ));

        addBlockWithTooltip(provider, ROASTER::getBlock, "焙烧炉",
                List.of(
                        "§7Cook slowly over low heat.",
                        "For every 1 level above the recipe firebox  level, §bDuration §rmultiplied by §e50%§r."
                ),
                List.of(
                        "§7小火慢烹。",
                        "每超过配方所需燃烧室等级1级，§b耗时§r乘以§e50%§r。"
                ));

        addBlockWithTooltip(provider, NANOSCALE_FABRICATOR::getBlock, "纳米制造室",
                List.of(
                ),
                List.of(
                ));

        addBlockWithTooltip(provider, CRYSTALLIZATION_CRUCIBLE::getBlock, "结晶坩埚",
                List.of(
                ),
                List.of(
                ));

        addBlockWithTooltip(provider, STEAM_PISTON_HAMMER::getBlock, "蒸汽锻造锤",
                List.of(
                        "A Multiblock Piston Hammer at the Steam Age. ",
                        "Only use Steam Input/Output busses, And that only use Steam Hatch.",
                        "Available Recipe Types：§9Piston Hammer§r,§9Ore Milling"
                ),
                List.of(
                        "蒸汽时代的多方块锻造锤。",
                        "仅可使用输入/输出总线（蒸汽），并且只能用蒸汽仓供给蒸汽。",
                        "可用配方类型：§9锻造锤§r，§9矿石加工"
                ));
        addBlockWithCtrlTooltip(provider, STEAM_PISTON_HAMMER::getBlock,
                List.of(
                        "§6When running §9Piston Hammer§6 recipes：",
                        "§6· §bDuration：§6*§e150%",
                        "§6· §5Parallel：§e8"
                ),
                List.of(
                        "§6运行§9锻造锤§6配方时：",
                        "§6· §b耗时：§6*§e150%",
                        "§6· §5并行：§e8"
                ));

        addCN(provider, "block.epimorphism.uhv_fusion_reactor", "核聚变反应堆控制电脑 MK-IV");
        add(provider, "gtceu.multiblock.fusion_reactor.uhv.description",
                "The Fusion Reactor MK 4 is a large multiblock structure used for fusing elements into heavier ones. It can only use UHV and UEV Energy Hatches. For every Hatch it has, its buffer increases by 80M EU, and has a maximum of 1280M.",
                "核聚变反应堆 MK4是一台大型多方块结构，用于融合元素形成更重的元素。它只能使用§4UHV§r和§aUEV§r等级的能源仓。每个能源仓可增加80M EU的能量缓存，最大能量缓存为1280M。");

        addCN(provider, "block.epimorphism.uev_fusion_reactor", "核聚变反应堆控制电脑 MK-V");
        add(provider, "gtceu.multiblock.fusion_reactor.uev.description",
                "The Fusion Reactor MK 5 is a large multiblock structure used for fusing elements into heavier ones. It can only use UEV Energy Hatches. For every Hatch it has, its buffer increases by 160M EU, and has a maximum of 2560M.",
                "核聚变反应堆 MK5是一台大型多方块结构，用于融合元素形成更重的元素。它只能使用§aUEV§r等级的能源仓。每个能源仓可增加160M EU的能量缓存，最大能量缓存为2560M。");

        addBlockWithTooltip(provider, INFINITY_CRATE::getBlock, "无尽板条箱",
                "§7Can Hold §R 2^31 1§7 Items Per Slot, And Cannot Store Items With §eNBT",
                "§7每格能容纳§r2^31-1§7个物品，不能存储带有§eNBT§7的物品");

        // ############################################################################################################
        // Hatch
        addBlockWithTooltip(provider, INFINITE_WATER_HATCH::getBlock, "无限水仓",
                List.of(
                        "§7Minecraft Exclusive!",
                        "§bUnlimited Water For Multiblocks!",
                        "§4WARNING: Water In This Hatch Cannot Be Pumped Out!"),
                List.of(
                        "§7Minecraft 独家技术！",
                        "§b为多方块结构提供无穷无尽的水！",
                        "§4警告：该仓室中的水无法被抽出！"));

        addTieredMachineName(provider, "neutron_accelerator", "中子加速器", ELECTRIC_TIERS);
        addBlockWithTooltip(provider, "neutron_accelerator",
                List.of(
                        "§7Input The Eu And Accelerate The Neutron!",
                        "Each Point Of Eu Is Converted Into 10~20eV Neutron Kinetic Energy"),
                List.of(
                        "§7输入EU，加速中子！",
                        "每点EU都会转化为10～20eV中子动能"));

        addBlockWithTooltip(provider, NEUTRON_SENSOR::getBlock, "中子传感器",
                "§7Can Be Installed On §B Neutron Activator§R, Which Outputs A Redstone Signal Based On §6 Neutron Kinetic Energy§R, And Right Clicks To Open The Gui To Set It.",
                "§7可安装在§b中子活化器§7上，基于§6中子动能§7输出红石信号，右键以打开GUI进行设置。");

        addTieredMachineName(provider, "radiation_hatch", "放射仓", GTValues.tiersBetween(3, 13));
        addBlockWithTooltip(provider, "radiation_hatch",
                List.of(
                        "Input Radioactive Materials For Multiblock",
                        "§7Use A Screwdriver To Set The Suppression Level"),
                List.of(
                        "为多方块结构输入放射性物品",
                        "§7使用螺丝刀设置抑制等级"));

        addBlockWithTooltip(provider, GRIND_BALL_HATCH::getBlock, "研磨球仓",
                List.of(
                        "§7Watch Your Fingers!",
                        "§fGrind Balls Are Provided To Use For Multiblocks。",
                        "§eAllows The Input Of Grinding Balls From The Input Bus。"),
                List.of(
                        "§7小心你的手指！",
                        "§f为多方块结构提供研磨球来使用。",
                        "§e允许从输入总线输入研磨球。"));

        /*addBlockWithTooltip(provider, TANK_ACCESS_HATCH::getBlock, "储罐访问仓",
                List.of(

                        ),
                List.of(

                        ));*/

        addTieredMachineName(provider, "wireless_energy_input_hatch", "无线能源仓", ELECTRIC_TIERS);
        addBlockWithTooltip(provider, "wireless_energy_input_hatch",
                List.of(
                        "§7Wireless EU Network",
                        "Extracting energy from Wireless EU Network",
                        ""),
                List.of(
                        "§7无线电网",
                        "从无线电网中提取能量",
                        ""));

        addTieredMachineName(provider, "wireless_energy_output_hatch", "无线动力仓", ELECTRIC_TIERS);
        addBlockWithTooltip(provider, "wireless_energy_output_hatch",
                List.of(
                        "§7Wireless EU Network",
                        "Input energy to Wireless EU Network",
                        ""),
                List.of(
                        "§7无线电网",
                        "向无线电网输入能量",
                        ""));

    }
}
