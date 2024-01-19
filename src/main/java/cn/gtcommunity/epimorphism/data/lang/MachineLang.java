package cn.gtcommunity.epimorphism.data.lang;

import com.gregtechceu.gtceu.api.GTValues;
import net.minecraftforge.common.data.LanguageProvider;

import java.util.List;

import static cn.gtcommunity.epimorphism.common.data.EPMachines.*;
import static cn.gtcommunity.epimorphism.data.lang.EPLangHelper.*;
import static com.gregtechceu.gtceu.common.data.GTMachines.*;

public class MachineLang {
    public static void init(LanguageProvider provider) {


        addBlockWithTooltip(provider, GENERAL_PROCESSING_PLANT::getBlock, "通用加工厂",
                List.of(
                        "§7Highly Integrated Machining",
                        "§e2.5§6 times faster than a single-block machine of the same voltage",
                        "§5Only §e80%% §5of the required power of the recipe needs to be used",
                        "§bFor each voltage level raised, §e8§b is added to the maximum number of parallels"
                ),
                List.of(
                        "§7高度集成加工",
                        "§6比相同电压的单方块机器快§e2.5§6倍",
                        "§5只需要使用配方要求功率的§e80%%",
                        "§b每提升一个电压等级，最大并行数加§e8"
                ));
        addBlockWithShiftTooltip(provider, GENERAL_PROCESSING_PLANT::getBlock,
                List.of(
                        "§7Use a programming circuit to control the recipe in the current mode",
                        "§4Mode A§r: §e20§r - compressor §e21§r - lathe §e22§r - two-pole magnetizer",
                        "§3Mode B§r: §e20§r - fermentation tank §e21§r - extractor §e22§r - canning machine",
                        "§2Mode C§r: §e20§r - Precision Laser Etching Machine §e21§r - Autoclave §e22§r - Fluid Curing Machine"
                ),
                List.of(
                        "§7使用编程电路控制当前模式下的配方",
                        "§4模式A§r：§e20§r-压缩机 §e21§r-车床 §e22§r-两极磁化机",
                        "§3模式B§r：§e20§r-发酵槽 §e21§r-提取机 §e22§r-装罐机",
                        "§2模式C§r：§e20§r-精密激光蚀刻机 §e21§r-高压釜 §e22§r-流体固化机"
                ));


        addBlockWithTooltip(provider, YOTTA_FLUID_TANK::getBlock, "YOT液体储罐",
                List.of(

                ),
                List.of(

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


        addTieredMachineName(provider, "neutron_accelerator", "中子加速器", ELECTRIC_TIERS);
        addBlockWithTooltip(provider, "neutron_accelerator",
                List.of(
                        "§7Input the EU and accelerate the neutron!",
                        "Each point of EU is converted into 10~20 eV neutron kinetic energy"
                ),
                List.of(
                        "§7输入EU，加速中子！",
                        "每点EU都会转化为10～20eV中子动能"
                ));

        addBlockWithTooltip(provider, NEUTRON_SENSOR::getBlock, "中子传感器",
                "§7Can be installed on §bNeutron Activator§r, which outputs a redstone signal based on §6neutron kinetic energy§r, and right-clicks to open the GUI to set it.",
                "§7可安装在§b中子活化器§7上，基于§6中子动能§7输出红石信号，右键以打开GUI进行设置。");

        addTieredMachineName(provider, "radiation_hatch", "放射仓", GTValues.tiersBetween(3, 13));
        addBlockWithTooltip(provider, "radiation_hatch",
                List.of(
                        "Input radioactive materials for Multiblock",
                        "§7Use a screwdriver to set the suppression level"
                ),
                List.of(
                        "为多方块结构输入放射性物品",
                        "§7使用螺丝刀设置抑制等级"
                ));


        addBlockWithTooltip(provider, INFINITY_CRATE::getBlock, "无尽板条箱",
                "§7Can hold §r2^31-1§7 items per slot, and cannot store items with §eNBT",
                "§7每格能容纳§r2^31-1§7个物品，不能存储带有§eNBT§7的物品");
    }
}
