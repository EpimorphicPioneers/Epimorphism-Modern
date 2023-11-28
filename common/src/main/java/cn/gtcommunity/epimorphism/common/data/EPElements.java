package cn.gtcommunity.epimorphism.common.data;

import com.gregtechceu.gtceu.api.data.chemical.Element;

import static com.gregtechceu.gtceu.common.data.GTElements.createAndRegister;

public class EPElements {
    //  Isotopes
    public static Element Plutonium244;
    public static Element Californium252;
    public static Element Ytterbium178;
    public static Element Bismuth209;
    public static Element Lead209;

    //  Fantasy Materials
    public static Element Draconium;
    public static Element AwakenedDraconium;
    public static Element ChaoticDraconium;
    public static Element Orichalcum;
    public static Element Vibranium;
    public static Element Adamantium;
    public static Element Taranium;
    public static Element CosmicNeutronium;
    public static Element Infinity;
    public static Element Rhugnor;
    public static Element Hypogen;
    public static Element AstralTitanium;
    public static Element CelestialTungsten;
    public static Element Ichorium;
    public static Element IchorLiquid;
    public static Element CrystalMatrix;
    public static Element VoidMetal;
    public static Element Mithril;

    public static void init() {
        Plutonium244 = createAndRegister(94, 152, -1, null, "Plutonium-244", "Pu-244", true);
        Californium252 = createAndRegister(98, 154, -1, null, "Californium-252", "Cf-252", true);
        Ytterbium178 = createAndRegister(70, 108, -1, null, "Ytterbium-178", "Yb-178", true);
        Bismuth209 = createAndRegister(83, 126, -1, null, "Bismuth-209", "Bi-209", true);
        Lead209 = createAndRegister(82, 127, -1, null, "Lead-209", "Pb-209", true);

        //  Fantasy Materials
        Draconium = createAndRegister(149, 264, -1, null, "Draconium", "Dc", false);
        AwakenedDraconium = createAndRegister(149, 267, -1, null, "AwakenedDraconium", "Dc+", false);
        ChaoticDraconium = createAndRegister(149, 270, -1, null, "ChaoticDraconium", "*Dc*", false);
        Orichalcum = createAndRegister(130, 200, -1, null, "Orichalcum", "Or", false);
        Vibranium = createAndRegister(152, 226, -1, null, "Vibranium", "Vb", false);
        Adamantium = createAndRegister(222, 580, -1, null, "Adamantium", "Ad", false);
        Taranium = createAndRegister(321, 478, -1, null, "Taranium", "Tn", false);
        CosmicNeutronium = createAndRegister(9999, 9999, -1, null, "CosmicNeutronium", "SpNt", false);
        Infinity = createAndRegister(999, 999, -1, null, "Infinity", "∞", false);
        Rhugnor = createAndRegister(184, 142, -1, null, "Rhugnor", "Fs⚶", false);
        Hypogen = createAndRegister(240, 251, -1, null, "Hypogen", "Hy⚶", false);
        AstralTitanium = createAndRegister(145, 133, -1, null, "AstralTitanium", "✧◇✧", false);
        CelestialTungsten = createAndRegister(160, 101, -1, null, "CelestialTungsten", "✦◆✦", false);
        Ichorium = createAndRegister(165, 280, -1, null, "Ichorium", "✦☯✧", false);
        IchorLiquid = createAndRegister(165, 279, -1, null, "IchorLiquid", "☯", false);
        CrystalMatrix = createAndRegister(888, 888, -1, null, "CrystalMatrix", "◊◇◊", false);
        VoidMetal = createAndRegister(165, 281, -1, null, "VoidMetal", "⚶", false);
        Mithril = createAndRegister(405, 564, -1, null, "Mithril", "Mh", false);
    }
}
