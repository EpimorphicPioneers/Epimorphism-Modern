package cn.gtcommunity.epimorphism.data.lang;

import com.gregtechceu.gtceu.utils.FormattingUtil;
import net.minecraftforge.common.data.LanguageProvider;

import java.util.List;
import java.util.Locale;

import static cn.gtcommunity.epimorphism.common.data.EPBlocks.*;
import static cn.gtcommunity.epimorphism.data.lang.EPLangHelper.*;
import static com.gregtechceu.gtceu.api.GTValues.*;

public class BlockLang {
    public static void init(LanguageProvider provider) {
        //  Glass
        addBlockWithTooltip(provider, SILICATE_GLASS, "Boron Silicate Glass", "硼硅酸盐玻璃",
                "§7Better than Reinforced Glass",
                "§7比钢化玻璃更好");
        addBlockWithTooltip(provider, TI_BORON_SILICATE_GLASS, "Titanium-reinforced Boron Silicate Glass", "钛强化硼硅酸盐玻璃",
                "§7Pink Crystal",
                "§7粉红水晶");
        addBlockWithTooltip(provider, W_BORON_SILICATE_GLASS, "Tungsten-reinforced Boron Silicate Glass", "钨强化硼硅酸盐玻璃",
                "§7High-strength Glass",
                "§7高强玻璃");
        addBlockWithTooltip(provider, OSMIR_BORON_SILICATE_GLASS, "Osmiridium-reinforced Boron Silicate Glass", "铱锇合金强化硼硅酸盐玻璃",
                "§7Industrial Star",
                "§7工业之星");
        addBlockWithTooltip(provider, NAQ_BORON_SILICATE_GLASS, "Naquadah-reinforced Boron Silicate Glass", "硅岩强化硼硅酸盐玻璃",
                "§7Impact Resistance",
                "§7无惧冲击");
        addBlockWithTooltip(provider, THY_BORON_SILICATE_GLASS, "Thorium-reinforced Boron Silicate Glass", "钍强化的硼硅酸盐玻璃",
               "§7Glossy and Green",
               "§7绿油油");
        addBlockWithTooltip(provider, INFINITY_GLASS, "Infinity Glass", "无尽玻璃",
               "§7Force field Constrained Glass",
               "§7力场约束玻璃");
        addBlockWithTooltip(provider, PMMA_GLASS, "PMMA Glass", "PMMA玻璃",
               "§7Acrylic Glassr",
               "§7亚克力玻璃");
        addBlockWithTooltip(provider, NEU_PMMA_GLASS, "Neutronium-reinforced PMMA Glass", "中子素强化PMMA玻璃",
               "§7AT Field",
               "§7心之壁");
        addBlockWithTooltip(provider, BPA_POLYCARBONATE_GLASS, "BPA Polycarbonate Glass", "BPA聚碳酸酯玻璃",
               "§7Gray Quartz",
               "§7灰色石英");
        addBlockWithTooltip(provider, CBDO_POLYCARBONATE_GLASS, "CBDO Polycarbonate Glass", "CBDO聚碳酸酯玻璃",
               "§7It is not the Windshield",
               "§7并不是挡风玻璃");

        add(provider, "epimorphism.glass_tier.desc",
                "§7Glass Tier: %s",
                "§7玻璃等级：%s");

        addMultiLang(provider, "epimorphism.optical_glass_tier.desc",
                List.of(
                        "Crude Optical Glass",
                        "Ordinary Optical Glass",
                        "Modified Optical Glass",
                        "High-quality Optical Glass",
                        "Precision Optical Glass",
                        "Marvellous Optical Glass"
                ),
                List.of(
                        "粗制光学玻璃",
                        "普通光学玻璃",
                        "改良光学玻璃",
                        "优质光学玻璃",
                        "精密光学玻璃",
                        "精奇光学玻璃"
                ));

        //  Fluid Tank Cell Block
        addTieredBlock(provider, "fluid_tank_cell_%s"::formatted,
                "Fluid Tank Cell Block T%s"::formatted, "流体单元方块 T%s"::formatted, tiersBetween(1, 10));

        //  Storage Field Blocks
        addTieredBlock(provider, "storage_field_block_%s"::formatted,
                "Storage Field Block T%s"::formatted, "存储立场方块 T%s"::formatted, tiersBetween(1, 10));

        //  Component Assembly Line Casings
        addTieredBlockWithTooltip(provider, tier -> "component_assembly_line_casing_%s".formatted(VN[tier].toLowerCase(Locale.ROOT)),
                tier -> "Component Assembly Line Casing (%s§r)".formatted(VNF[tier]),
                tier -> "部件装配线外壳（%s§r）".formatted(VNF[tier]),
                tier -> "§7%s Assembly Unit".formatted(getCATier(tier, true)),
                tier -> "§7%s装配单元".formatted(getCATier(tier, false)), tiersBetween(LV, MAX));


        addTieredBlockWithTooltip(provider, "spacetime_compression_field_generator_%s"::formatted,
                tier -> "%s Spacetime Compression Field Generator".formatted(getFieldGeneratorTier(tier, true)),
                tier -> "%s压缩时空场发生器".formatted(getFieldGeneratorTier(tier, false)),
                tier -> "Supports an internal spacetime volume of up to %skm³.".formatted(FormattingUtil.formatNumbers(Math.pow(10, 4 + tier))),
                tier -> "支持高达%skm³的内部压缩时空。".formatted(FormattingUtil.formatNumbers(Math.pow(10, 4 + tier))), tiersBetween(1, 9));

        addTieredBlockWithTooltip(provider, "stabilisation_field_generator_%s"::formatted,
                tier -> "%s Stabilisation Field Generator".formatted(getFieldGeneratorTier(tier, true)),
                tier -> "%s稳定力场发生器".formatted(getFieldGeneratorTier(tier, false)),
                tier -> "§b§lIncreases stability of spacetime field.",
                tier -> "§b§l增加时空场的稳定性。", tiersBetween(1, 9));

        addTieredBlockWithTooltip(provider, "time_acceleration_field_generator_%s"::formatted,
                tier -> "%s Time Acceleration Field Generator".formatted(getFieldGeneratorTier(tier, true)),
                tier -> "%s时间膨胀场发生器".formatted(getFieldGeneratorTier(tier, false)),
                tier -> "§b§lTime dilation in a box.",
                tier -> "§b§l盒子里的时间膨胀。", tiersBetween(1, 9));

        addDimensionDisplay(provider, PLANET_OVERWORLD, "Overworld", "主世界");
        addDimensionDisplay(provider, PLANET_NETHER, "The Nether", "下界");
        addDimensionDisplay(provider, PLANET_THE_END, "The End", "末地");
        addDimensionDisplay(provider, PLANET_TWILIGHT_FOREST, "Twilight Forest", "暮色森林");
        addDimensionDisplay(provider, PLANET_MOON, "Moon", "月球");
        addDimensionDisplay(provider, PLANET_DEIMOS, "Deimos", "火卫二");
        addDimensionDisplay(provider, PLANET_MARS, "Mars", "火星");
        addDimensionDisplay(provider, PLANET_PHOBOS, "Phobos", "火卫一");
        addDimensionDisplay(provider, PLANET_CALLISTO, "Callisto", "木卫四");
        addDimensionDisplay(provider, PLANET_CERES, "Ceres", "谷神星");
        addDimensionDisplay(provider, PLANET_EUROPA, "Europa", "木卫二");
        addDimensionDisplay(provider, PLANET_GANYMEDE, "Ganymede", "木卫三");
        addDimensionDisplay(provider, PLANET_ROSS_128_B, "Ross 128 B", "罗斯128b");
        addDimensionDisplay(provider, PLANET_ASTEROID_BELT, "Asteroid Belt", "小行星带");
        addDimensionDisplay(provider, PLANET_IO, "Io", "木卫一");
        addDimensionDisplay(provider, PLANET_VENUS, "Venus", "金星");
        addDimensionDisplay(provider, PLANET_MERCURY, "Mercury", "水星");
        addDimensionDisplay(provider, PLANET_MIRANDA, "Miranda", "天卫五");
        addDimensionDisplay(provider, PLANET_OBERON, "Oberon", "天卫四");
        addDimensionDisplay(provider, PLANET_ENCELADUS, "Enceladus", "土卫二");
        addDimensionDisplay(provider, PLANET_ROSS_128_BA, "Ross 128 Ba", "罗斯128ba");
        addDimensionDisplay(provider, PLANET_TITAN, "Titan", "土卫六");
        addDimensionDisplay(provider, PLANET_PROTEUS, "Proteus", "海卫八");
        addDimensionDisplay(provider, PLANET_TRITON, "Triton", "海卫一");
        addDimensionDisplay(provider, PLANET_HAUMEA, "Haumea", "妊神星");
        addDimensionDisplay(provider, PLANET_KUIPER_BELT, "Kuiper Belt", "柯伊伯带");
        addDimensionDisplay(provider, PLANET_MAKEMAKE, "Makemake", "鸟神星");
        addDimensionDisplay(provider, PLANET_PLUTO, "Pluto", "冥王星");
        addDimensionDisplay(provider, PLANET_BARNARDA_C, "Barnarda C", "巴纳德C");
        addDimensionDisplay(provider, PLANET_BARNARDA_E, "Barnarda E", "巴纳德E");
        addDimensionDisplay(provider, PLANET_BARNARDA_F, "Barnarda F", "巴纳德F");
        addDimensionDisplay(provider, PLANET_TAU_CETI_E, "Tau Ceti E", "鲸鱼座T星E");
        addDimensionDisplay(provider, PLANET_VEGA_B, "Vega B", "织女一B");
        addDimensionDisplay(provider, PLANET_CENTAURI_BB, "Centauri Bb", "半人马Bb");
        addDimensionDisplay(provider, PLANET_SET, "Set", "塞特");
        addDimensionDisplay(provider, PLANET_ANUBIS, "Anubis", "阿努比斯");
        addDimensionDisplay(provider, PLANET_HORUS, "Horus", "荷鲁斯");
        addDimensionDisplay(provider, PLANET_MAAHES, "Maahes", "马赫斯");
        addDimensionDisplay(provider, PLANET_MEHEN_BELT, "Mehen Belt", "迈罕带");
        addDimensionDisplay(provider, PLANET_NEPERI, "Neperi", "奈佩里");
        addDimensionDisplay(provider, PLANET_DEEP_DARK, "Deep Dark", "漆黑世界");

        addBlock(provider, HYPER_CASING,"Hyper Casing","超级机械方块");
        addBlock(provider, IRIDIUM_CASING,"Iridium Casing","铱机械方块");
        addBlock(provider, BREEDING_CASING,"Breeding Casing","养殖机械方块");
        addBlock(provider, GENERAL_PROCESSING_CASING,"General Processing Casing","通用加工机械方块");
        addBlock(provider, MARAGING_STEEL_CASING,"Maraging Steel Casing","马氏体时效钢-250机械方块");
        addBlock(provider, NEUTRONIUM_MINING_CASING,"Neutronium Mining Casing","中子素采矿机械方块");
        addBlock(provider, PRECISE_ASSEMBLER_CASING_MK1,"Precise Assembler Casing Mk 1","精密装配机械方块 Mk-I");
        addBlock(provider, PRECISE_ASSEMBLER_CASING_MK2,"Precise Assembler Casing Mk 2","精密装配机械方块 Mk-II");
        addBlock(provider, PRECISE_ASSEMBLER_CASING_MK3,"Precise Assembler Casing Mk 3","精密装配机械方块 Mk-III");
        addBlock(provider, ADVANCED_FILTER_CASING,"Advanced Filter Casing","高级过滤器机械方块");
        addBlock(provider, TFFT_CASING,"TFFT Casing","TFFT机械方块");
        addBlock(provider, PROCESS_MACHINE_CASING,"Process Machine Casing","处理器机械方块");
        addBlock(provider, YOTTA_FLUID_TANK_CASING,"Yotta Fluid Tank Casing","YOT流体储罐机械方块");
        addBlock(provider, CASING_POLYBENZIMIDAZOLE_PIPE,"Casing Polybenzimidazole Pipe","聚苯并咪唑管道方块");
        addBlock(provider, SPEEDING_PIPE,"Speeding Pipe","高速管道");
        addBlock(provider, SUBSTRATE_CASING,"Substrate Casing","基材机械方块");
        addBlock(provider, ADVANCED_SUBSTRATE_CASING,"Advanced Substrate Casing","高级基材机械方块");
        addBlock(provider, ADVANCED_INVAR_CASING,"Advanced Invar Casing","殷钢高级隔热机械方块");
        addBlock(provider, ADVANCED_ALUMINIUM_CASING,"Advanced Aluminium Casing","铝制高级防冻机械方块");
        addBlock(provider, ISA_MILL_CASING,"Isa Mill Casing","艾萨研磨机械方块");
        addBlock(provider, CASING_ISA_MILL_PIPE,"Casing Isa Mill Pipe","艾萨研磨管道方块");
        addBlock(provider, CASING_ISA_MILL_GEARBOX,"Casing Isa Mill Gearbox","艾萨研磨齿轮箱");
        addBlock(provider, FLOTATION_CASING,"Flotation Casing","浮选机械方块");
        addBlock(provider, FLOTATION_CELL,"Flotation Cell","浮选槽");
        addBlock(provider, VACUUM_CASING,"Vacuum Casing","真空机械方块");
        addBlock(provider, DRILL_HEAD,"Drill Head","钻头");

        addBlockWithTooltip(provider, ADVANCED_HIGH_ENERGY_CASING, "Advanced High Energy Casing", "进阶高能机械方块",
                List.of(
                        "§7Used for Ultrahigh Energy Physics Experiment",
                        "§b§lThis block can last forever."
                ),
                List.of(
                        "§7用于超高能物理实验器件",
                        "§b§l这个方块可以持久不衰。"
                ));
        addBlockWithTooltip(provider, ULTIMATE_HIGH_ENERGY_CASING, "Ultimate High Energy Casing", "终极高能机械方块",
                List.of(
                        "§7Used for Ultrahigh Energy Physics Experiment in Extreme Situations",
                        "§b§lIt can survive at least one big bang of the universe, maybe even two..."
                ),
                List.of(
                        "§7用于极端情况下的超高能物理实验",
                        "§b§l至少能在一次宇宙大爆炸中幸存，也许是两次……"
                ));
        addBlockWithTooltip(provider, DIMENSIONAL_BRIDGE_CASING, "Dimensional Bridge Casing", "维度桥接机械方块",
                List.of(
                        "§7Used to connect Time and Space from Different Dimensions",
                        "§b§lIt's best not to touch it with your hands."
                ),
                List.of(
                        "§7用于连接不同维度的时间与空间",
                        "§b§l最好别用手碰它。"
                ));
        addBlockWithTooltip(provider, DIMENSIONAL_LINK_CASING, "Dimensional Link Casing", "维度联络机械方块",
                List.of(
                        "§7Multidimensional Operation",
                        "§b§lThe universe or someplace else."
                ),
                List.of(
                        "§7多维运算",
                        "§b§l宇宙或别的地方。"
                ));
        addBlockWithTooltip(provider, CONTAINMENT_FIELD_GENERATOR, "Containment Field Generator", "遏制场发生器",
                List.of(
                        "§7Generate a field...",
                        "§b§lIt can even block high-energy particles."
                ),
                List.of(
                        "§7产生一个场……",
                        "§b§l甚至可以阻止高能粒子。"
                ));
        addBlockWithTooltip(provider, ULTIMATE_CONTAINMENT_FIELD_GENERATOR, "Ultimate Containment Field Generator", "终极遏制场发生器",
                List.of(
                        "§7Black hole",
                        "§b§lHmm..."
                ),
                List.of(
                        "§7黑洞",
                        "§b§l嗯……"
                ));
        addBlockWithTooltip(provider, HOLLOW_CASING, "Hollow Structure Casing", "中空结构方块",
                List.of(
                        "§7Enhanced Accelerator Pipe",
                        "§b§lThe most advanced pipeline ever."
                ),
                List.of(
                        "§7强化加速器通道",
                        "§b§l有史以来最先进的管道。"
                ));
        addBlockWithTooltip(provider, SPACETIME_DISTORTION_CASING, "Spacetime Distortion Casing", "时空扭曲机械方块",
                List.of(
                        "§7Speed of Light no longer a Limit",
                        "§b§lCould potentially trigger temporal and spatial turbulence."
                ),
                List.of(
                        "§7光速不再是限制",
                        "§b§l可能引发时空乱流。"
                ));
        addBlockWithTooltip(provider, DIMENSIONAL_CASING, "Dimensional Casing", "维度机械方块",
                List.of(
                        "§7Resist the spacetime shearing caused by the expansion of the universe",
                        "§b§lProvide a stable barrier between spacetime regions."
                ),
                List.of(
                        "§7抵抗宇宙膨胀带来的时空剪切",
                        "§b§l在时空区域之间提供一道稳定的屏障。"
                ));
        addBlockWithTooltip(provider, HYPERDIMENSIONAL_CASING, "Hyperdimensional Casing", "超维度机械方块",
                List.of(
                        "§7Exists in all possible spacetime dimensions",
                        "§b§lMerely a projection in three-dimensional space..."
                ),
                List.of(
                        "§7存在于所有可能时空",
                        "§b§l仅仅是三维空间下的投影……"
                ));


        //  Agriculture
        addBlock(provider, FERTILIZED_DIRT,"Fertilized Dirt","肥沃土");
        addBlock(provider, FERTILIZED_FARMLAND,"Fertilized Farmland","肥沃耕地");
        addBlock(provider, PINE_SAPLING,"Pine Sapling","松树树苗");
        addBlock(provider, PINE_LOG,"Pine Log","松树原木");
        addBlock(provider, PINE_LEAVES,"Pine Leaves","松树树叶");
        addBlock(provider, PINE_PLANK,"Pine Plank","松树木板");

    }

    private static String getFieldGeneratorTier(int tier, boolean isEN) {
        return switch (tier) {
            case 1 -> isEN ? "Crude" : "粗制";
            case 2 -> isEN ? "Raw" : "原始";
            case 3 -> isEN ? "Stable" : "稳定";
            case 4 -> isEN ? "Advanced" : "先进";
            case 5 -> isEN ? "Excellence" : "卓越";
            case 6 -> isEN ? "Alien" : "异星";
            case 7 -> isEN ? "Perfect" : "完美";
            case 8 -> isEN ? "Taishu" : "太初";
            default -> isEN ? "§lHarmony§r" : "§l鸿蒙§r";
        };
    }

    private static String getCATier(int tier, boolean isEN) {
        return switch (tier) {
            case LV -> isEN ? "Simple" : "简易";
            case MV -> isEN ? "Crude" : "粗制";
            case HV -> isEN ? "Premium" : "优质";
            case EV -> isEN ? "Advanced" : "进阶";
            case IV -> isEN ? "High-quality" : "高级";
            case LuV -> isEN ? "High-precision" : "高精度";
            case ZPM -> isEN ? "Ultra-high Precision" : "超高精度";
            case UV -> isEN ? "Extreme Precision" : "极限精度";
            case UHV -> isEN ? "Extremely High-precision" : "极高精度";
            case UEV -> isEN ? "Structural" : "结构";
            case UIV -> isEN ? "Large-scale Structural" : "大尺度结构";
            case UXV -> isEN ? "Superstructural" : "超结构";
            case OpV -> isEN ? "Cosmic" : "宇宙";
            default -> isEN ? "Space-time" : "时空";
        };
    }
}
