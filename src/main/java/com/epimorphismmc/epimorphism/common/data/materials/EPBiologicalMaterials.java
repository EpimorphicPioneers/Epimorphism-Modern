package com.epimorphismmc.epimorphism.common.data.materials;

import static com.epimorphismmc.epimorphism.common.data.EPMaterials.BrownAlgae;
import static com.epimorphismmc.epimorphism.common.data.EPMaterials.Builder;
import static com.epimorphismmc.epimorphism.common.data.EPMaterials.DryBrownAlgae;
import static com.epimorphismmc.epimorphism.common.data.EPMaterials.DryGoldenAlgae;
import static com.epimorphismmc.epimorphism.common.data.EPMaterials.DryGreenAlgae;
import static com.epimorphismmc.epimorphism.common.data.EPMaterials.DryRedAlgae;
import static com.epimorphismmc.epimorphism.common.data.EPMaterials.GoldenAlgae;
import static com.epimorphismmc.epimorphism.common.data.EPMaterials.GreenAlgae;
import static com.epimorphismmc.epimorphism.common.data.EPMaterials.RedAlgae;

public class EPBiologicalMaterials {
    public static void register() {
        //  25601 Dry Red Algae
        DryRedAlgae = Builder("dry_red_algae").dust().color(0x880808).buildAndRegister();
        //  25602 Red Algae
        RedAlgae = Builder("red_algae").dust().color(0xAA4A44).buildAndRegister();
        //  25603 Dry Green Algae
        DryGreenAlgae = Builder("dry_green_algae").dust().color(0x4F7942).buildAndRegister();
        //  25604 Green Algae
        GreenAlgae = Builder("green_algae").dust().color(0x5F8575).buildAndRegister();
        //  25605 Dry Golden Algae
        DryGoldenAlgae = Builder("dry_golden_algae").dust().color(0xDAA520).buildAndRegister();
        //  25606 Golden Algae
        GoldenAlgae = Builder("golden_algae").dust().color(0xEEDC82).buildAndRegister();
        //  25607 Dry Brown Algae
        DryBrownAlgae = Builder("dry_brown_algae").dust().color(0x5C4033).buildAndRegister();
        //  25608 Brown Algae
        BrownAlgae = Builder("brown_algae").dust().color(0x988558).buildAndRegister();
    }
}
