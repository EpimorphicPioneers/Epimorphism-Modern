package cn.gtcommunity.epimorphism.api;

import static net.minecraft.ChatFormatting.*;

public class EPValues {
    public static final String MODID_BOTANIA = "botania";
    public static final String MODID_AD_ASTRA = "ad_astra";
    public static final String MODID_EMBERS = "embers";
    public static final String MODID_TWILIGHT_FOREST = "twilightforest";

    public static final String[] CVLVH = new String[]{
            "蒸汽", // not doing the gray color for these first two because it looks weird
            "基础",
            AQUA + "进阶",
            GOLD + "进阶",
            DARK_PURPLE + "进阶",
            BLUE + "精英",
            LIGHT_PURPLE + "精英",
            RED + "精英",
            DARK_AQUA + "终极",
            DARK_RED + "史诗",
            GREEN + "史诗",
            DARK_GREEN + "史诗",
            YELLOW + "史诗",
            BLUE.toString() + BOLD  + "传奇",
            RED.toString() + BOLD + "MAX"};
}
