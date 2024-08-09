package com.epimorphismmc.epimorphism.data.recipe;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.epimorphismmc.epimorphism.common.data.EPBlocks.*;
import static com.gregtechceu.gtceu.api.GTValues.*;
import static com.gregtechceu.gtceu.data.recipe.CraftingComponent.GLASS;

public final class CraftingComponentAddition {

    private CraftingComponentAddition() {}

    public static void init() {
        GLASS.appendIngredients(Stream.of(new Object[][] {
                    {UHV, PMMA_GLASS},
                    {UEV, PMMA_GLASS},
                    {UIV, CBDO_POLYCARBONATE_GLASS},
                    {UXV, CBDO_POLYCARBONATE_GLASS},
                    {OpV, CBDO_POLYCARBONATE_GLASS},
                    {MAX, CBDO_POLYCARBONATE_GLASS},
                })
                .collect(Collectors.toMap(data -> (Integer) data[0], data -> data[1])));
    }
}
