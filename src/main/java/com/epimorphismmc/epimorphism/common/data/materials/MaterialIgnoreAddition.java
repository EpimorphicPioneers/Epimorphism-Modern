package com.epimorphismmc.epimorphism.common.data.materials;

import com.epimorphismmc.epimorphism.common.data.EPBlocks;

import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;

public class MaterialIgnoreAddition {
    public static void init() {
        block.setIgnored(BorosilicateGlass, () -> EPBlocks.BOROSILICATE_GLASS);
    }
}
