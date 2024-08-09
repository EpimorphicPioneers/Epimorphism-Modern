package com.epimorphismmc.epimorphism.api.data.tag;

import static com.epimorphismmc.epimorphism.api.data.chemical.material.info.EPMaterialFlags.*;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.*;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.Conditions.*;

public class TagPrefixAddition {

    public static void init() {
        dustSmall.generationCondition(hasDustProperty.and(mat -> !mat.hasFlag(DISABLE_SMALL_DUST)));
        dustTiny.generationCondition(hasDustProperty.and(mat -> !mat.hasFlag(DISABLE_SMALL_DUST)));
    }
}
