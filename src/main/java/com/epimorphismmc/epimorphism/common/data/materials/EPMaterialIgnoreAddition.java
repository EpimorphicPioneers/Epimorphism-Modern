package com.epimorphismmc.epimorphism.common.data.materials;

import com.epimorphismmc.epimorphism.common.data.EPBlocks;

import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.*;

public class EPMaterialIgnoreAddition {
    public static void init() {
        block.setIgnored(BorosilicateGlass, () -> EPBlocks.BOROSILICATE_GLASS);
    }
}
