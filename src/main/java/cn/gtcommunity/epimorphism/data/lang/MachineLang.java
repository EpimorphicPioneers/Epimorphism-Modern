package cn.gtcommunity.epimorphism.data.lang;

import net.minecraftforge.common.data.LanguageProvider;

import static cn.gtcommunity.epimorphism.common.data.EPMachines.*;
import static cn.gtcommunity.epimorphism.data.lang.EPLangHelper.*;
import static com.gregtechceu.gtceu.common.data.GTMachines.*;

public class MachineLang {
    public static void init(LanguageProvider provider) {
        addTieredMachineName(provider, "neutron_accelerator", "中子加速器", ELECTRIC_TIERS);
        add(provider, "epimorphism.block.neutron_accelerator.desc0",
                "§7Input the EU and accelerate the neutron!",
                "§7输入EU，加速中子！");
        add(provider, "epimorphism.block.neutron_accelerator.desc1",
                "Each point of EU is converted into 10~20 eV neutron kinetic energy",
                "每点EU都会转化为10～20eV中子动能");

        addBlockWithTooltip(provider, NEUTRON_SENSOR::getBlock, "中子传感器",
                "§7Can be installed on §bNeutron Activator§r, which outputs a redstone signal based on §6neutron kinetic energy§r, and right-clicks to open the GUI to set it.",
                "§7可安装在§b中子活化器§7上，基于§6中子动能§7输出红石信号，右键以打开GUI进行设置。");
    }
}
