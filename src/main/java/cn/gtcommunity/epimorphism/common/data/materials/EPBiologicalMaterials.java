package cn.gtcommunity.epimorphism.common.data.materials;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import cn.gtcommunity.epimorphism.common.data.EPMaterials;

public class EPBiologicalMaterials {
    public static void register() {
        //  25601 Dry Red Algae
        EPMaterials.DryRedAlgae = new Material.Builder("dry_red_algae")
                .dust()
                .color(0x880808)
                .buildAndRegister();
        //  25602 Red Algae
        EPMaterials.RedAlgae = new Material.Builder("red_algae")
                .dust()
                .color(0xAA4A44)
                .buildAndRegister();
        //  25603 Dry Green Algae
        EPMaterials.DryGreenAlgae = new Material.Builder("dry_green_algae")
                .dust()
                .color(0x4F7942)
                .buildAndRegister();
        //  25604 Green Algae
        EPMaterials.GreenAlgae = new Material.Builder("green_algae")
                .dust()
                .color(0x5F8575)
                .buildAndRegister();
        //  25605 Dry Golden Algae
        EPMaterials.DryGoldenAlgae = new Material.Builder("dry_golden_algae")
                .dust()
                .color(0xDAA520)
                .buildAndRegister();
        //  25606 Golden Algae
        EPMaterials.GoldenAlgae = new Material.Builder("golden_algae")
                .dust()
                .color(0xEEDC82)
                .buildAndRegister();
        //  25607 Dry Brown Algae
        EPMaterials.DryBrownAlgae = new Material.Builder("dry_brown_algae")
                .dust()
                .color(0x5C4033)
                .buildAndRegister();
        //  25608 Brown Algae
        EPMaterials.BrownAlgae = new Material.Builder("brown_algae")
                .dust()
                .color(0x988558)
                .buildAndRegister();
    }
}
