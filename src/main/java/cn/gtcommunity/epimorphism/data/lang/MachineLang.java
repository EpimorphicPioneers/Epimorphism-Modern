package cn.gtcommunity.epimorphism.data.lang;

import com.gregtechceu.gtceu.api.GTValues;
import net.minecraftforge.common.data.LanguageProvider;

import java.util.List;

import static cn.gtcommunity.epimorphism.common.data.EPMachines.*;
import static cn.gtcommunity.epimorphism.data.lang.EPLangHelper.*;
import static com.gregtechceu.gtceu.common.data.GTMachines.*;

public class MachineLang {
    public static void init(LanguageProvider provider) {


        addBlockWithTooltip(provider, YOTTA_FLUID_TANK::getBlock, "YOT流体储罐",
                List.of(
                        "The maximum level of the fluid Cell Is Limited By The Glass Level",
                        "Fluid Tank Cell Can Be Stacked Up To 15 Blocks"
                ),
                List.of(
                        "流体单元等级上限由玻璃等级限制",
                        "流体单元的堆叠高度上限为15格"
                ));
        add(provider, "block.epimorphism.yotta_fluid_tank.fluid",
                "Fluid: %s",
                "液体：%s");
        add(provider, "block.epimorphism.yotta_fluid_tank.stored",
                "Stored: %s L",
                "存储：%s L");
        add(provider, "block.epimorphism.yotta_fluid_tank.capacity",
                "Capacity: %s L",
                "容量：%s L");

        addBlockWithTooltip(provider, TFFT::getBlock,"T.F.F.T",
                List.of(
                        "Technology Field Fluid Tank"
                ),
                List.of(
                        "科技立场流体储罐"
                ));

        addBlockWithTooltip(provider, NEUTRON_ACTIVATOR::getBlock, "中子活化器",
                List.of(
                        "§o§7Faster-than-light motion!",
                        "§6Additional high-speed tubing blocks provide recipe time reduction while reducing the efficiency of the neutron accelerator",
                        "§6When operating without a neutron accelerator, neutron kinetic energy decreases §e72KeV§6 neutron kinetic energy per second",
                        "§6Input graphite beryllium powder can immediately absorb §e10MeV§6 neutron kinetic energy",
                        "§6Neutron kinetic energy will explode when it exceeds §41200MeV§6!"
                ),
                List.of(
                        "§o§7超光速运动!",
                        "§6额外的高速管道方块提供配方时间减免，同时降低中子加速器的效率",
                        "§6没有中子加速器运行时，中子动能每秒降低§e72KeV§6中子动能",
                        "§6输入石墨/铍粉可以立即吸收§e10MeV§6中子动能",
                        "§6当中子动能超过§41200MeV§6后将会爆炸！"
                ));
        add(provider, "block.epimorphism.neutron_activator.ev",
                "Current Neutron Energy: %deV",
                "当前中子动能: %seV");
        add(provider, "block.epimorphism.neutron_activator.height",
                "Height: %s",
                "高度: %s");
        add(provider, "block.epimorphism.neutron_activator.efficiency",
                "Time-consuming: %s%%",
                "耗时: %s%%");

        addBlockWithTooltip(provider, EXTREME_INDUSTRIAL_GREENHOUSE::getBlock,"极限工业温室",
                List.of(

                ),
                List.of(

                ));

        addBlockWithTooltip(provider, BACTERIAL_CULTURE_TANK::getBlock,"细菌培养缸",
                List.of(

                ),
                List.of(

                ));

        addBlockWithTooltip(provider, CHEMICAL_PLANT::getBlock,"化工厂",
                List.of(

                ),
                List.of(

                ));

        addBlockWithTooltip(provider, COMPONENT_ASSEMBLY_LINE::getBlock,"部件装配线",
                List.of(
                        "Assemble A Wide Variety Of Parts In Batches",
                        "Efficiency Crushes The Same Level Of Assembly Machine/Assembly Line!",
                        "Requires §6 Component Assembly Line Casing§7 Of Different Grades",
                        "Component Assembly Line Enclosures Limit §rRecipe Level§7 That The Machine Can Execute"
                ),
                List.of(
                        "批量装配各式各样的零部件",
                        "效率碾压同等级组装机/装配线！",
                        "需要不同等级的§6装配线外壳§7",
                        "部件装配线外壳限制了机器可执行的§r配方等级§7"
                ));

        addBlockWithTooltip(provider, GENERAL_PROCESSING_PLANT::getBlock, "通用加工厂",
                List.of(
                        "§7Highly Integrated Machining",
                        "§e2.5§6 Times Faster Than A Single Block Machine Of The Same Voltage",
                        "§5Only §E 80%% §5 Of The Required Power Of The Recipe Needs To Be Used",
                        "§bFor Each Voltage Level Raised, §e8§b Is Added To The Maximum Number Of Parallels"
                ),
                List.of(
                        "§7高度集成加工",
                        "§6比相同电压的单方块机器快§e2.5§6倍",
                        "§5只需要使用配方要求功率的§e80%%",
                        "§b每提升一个电压等级，最大并行数加§e8"
                ));
        addBlockWithShiftTooltip(provider, GENERAL_PROCESSING_PLANT::getBlock,
                List.of(
                        "§7Use A Programming Circuit To Control The Recipe In The Current Mode",
                        "§4Mode A§r: §e20§r - Compressor §e21§r - Lathe §e22§r - Two Pole Magnetizer",
                        "§3Mode B§r: §e20§r - Fermentation Tank §e21§r - Extractor §e22§r - Canning Machine",
                        "§2Mode C§r: §e20§r - Precision Laser Etching Machine §e21§r - Autoclave §e22§r - Fluid Curing Machine"
                ),
                List.of(
                        "§7使用编程电路控制当前模式下的配方",
                        "§4模式A§r：§e20§r-压缩机 §e21§r-车床 §e22§r-两极磁化机",
                        "§3模式B§r：§e20§r-发酵槽 §e21§r-提取机 §e22§r-装罐机",
                        "§2模式C§r：§e20§r-精密激光蚀刻机 §e21§r-高压釜 §e22§r-流体固化机"
                ));

        addBlockWithTooltip(provider, INDUSTRIAL_FISHING_POND::getBlock, "珠海渔场",
                List.of(
                        "§7The Gift Of The Sea",
                        "Catch A Lot Of Seafood For You In Different Modes",
                        "§9The Inside Of The Multiblock Needs To Be Filled With Water",
                        "§bFor Each Voltage Level Raised, §E 8§B Is Added To The Maximum Number Of Parallels",
                        "§7Use A Screwdriver To Switch Fishing Modes",
                        "§7The Water In The Input Bin Is Automatically Filled Into The Structure"
                ),
                List.of(
                        "§7海之恩赐",
                        "以不同的模式为你捕捞大量水产",
                        "§9多方块的内部需要填满水",
                        "§b每提升一个电压等级，最大并行数加§e2",
                        "§7使用螺丝刀切换捕捞模式",
                        "§7输入仓中的水会自动填入结构"
                ));

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

        addBlockWithTooltip(provider, MEGA_CRACKING_UNIT::getBlock,"巨型裂化装置",
                List.of(

                ),
                List.of(

                ));

        addBlockWithTooltip(provider, MEGA_ALLOY_BLAST_SMELTER::getBlock,"巨型合金冶炼厂",
                List.of(

                ),
                List.of(

                ));

        addBlockWithTooltip(provider, VACUUM_DRYING_FURNACE::getBlock,"真空干燥炉",
                List.of(

                ),
                List.of(

                ));

        addBlockWithTooltip(provider, BLAZING_PYROTHEUM_BLAST_FURNACE::getBlock,"炽炎高炉",
                List.of(

                ),
                List.of(

                ));

        addBlockWithTooltip(provider, GELID_CRYOTHEUM_FREEZER::getBlock,"凛冰冷冻机",
                List.of(

                ),
                List.of(

                ));

        addBlockWithTooltip(provider, INDUSTRIAL_FLOTATION_CELL::getBlock,"工业级浮选机",
                List.of(

                ),
                List.of(

                ));

        addBlockWithTooltip(provider, INFINITY_CRATE::getBlock, "无尽板条箱",
                "§7Can Hold §R 2^31 1§7 Items Per Slot, And Cannot Store Items With §eNBT",
                "§7每格能容纳§r2^31-1§7个物品，不能存储带有§eNBT§7的物品");

        addBlockWithTooltip(provider, INFINITE_WATER_HATCH::getBlock, "无限水仓",
                List.of(
                        "§7Minecraft Exclusive!",
                        "§3Unlimited Water For Multiblocks!",
                        "§4WARNING: Water In This Hatch Cannot Be Pumped Out!"
                ),
                List.of(
                        "§7Minecraft 独家技术！",
                        "§3为多方块结构提供无限的水！",
                        "§4警告：该仓室中的水无法被抽出！"
                )
        );

        //  ############################################################################################################
        //  Hatch

        addTieredMachineName(provider, "neutron_accelerator", "中子加速器", ELECTRIC_TIERS);
        addBlockWithTooltip(provider, "neutron_accelerator",
                List.of(
                        "§7Input The Eu And Accelerate The Neutron!",
                        "Each Point Of Eu Is Converted Into 10~20eV Neutron Kinetic Energy"
                ),
                List.of(
                        "§7输入EU，加速中子！",
                        "每点EU都会转化为10～20eV中子动能"
                ));

        addBlockWithTooltip(provider, NEUTRON_SENSOR::getBlock, "中子传感器",
                "§7Can Be Installed On §B Neutron Activator§R, Which Outputs A Redstone Signal Based On §6 Neutron Kinetic Energy§R, And Right Clicks To Open The Gui To Set It.",
                "§7可安装在§b中子活化器§7上，基于§6中子动能§7输出红石信号，右键以打开GUI进行设置。");

        addTieredMachineName(provider, "radiation_hatch", "放射仓", GTValues.tiersBetween(3, 13));
        addBlockWithTooltip(provider, "radiation_hatch",
                List.of(
                        "Input Radioactive Materials For Multiblock",
                        "§7Use A Screwdriver To Set The Suppression Level"
                ),
                List.of(
                        "为多方块结构输入放射性物品",
                        "§7使用螺丝刀设置抑制等级"
                ));

        addTieredMachineName(provider, "wireless_energy_input_hatch", "无线能源仓", ELECTRIC_TIERS);
        addBlockWithTooltip(provider, "wireless_energy_input_hatch",
                List.of(
                        "§7Wireless EU Network",
                        "Extracting energy from Wireless EU Network",
                        ""
                ),
                List.of(
                        "§7无线电网",
                        "从无线电网中提取能量",
                        ""
                ));

        addTieredMachineName(provider, "wireless_energy_output_hatch", "无线动力仓", ELECTRIC_TIERS);
        addBlockWithTooltip(provider, "wireless_energy_output_hatch",
                List.of(
                        "§7Wireless EU Network",
                        "Input energy to Wireless EU Network",
                        ""
                ),
                List.of(
                        "§7无线电网",
                        "向无线电网输入能量",
                        ""
                ));

    }
}
