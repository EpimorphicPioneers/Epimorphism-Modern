package com.epimorphismmc.epimorphism.data.recipe.handler;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.DustProperty;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.FluidProperty;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.PropertyKey;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.api.machine.multiblock.CleanroomType;

import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

import static com.epimorphismmc.epimorphism.api.data.tag.EPTagPrefix.*;
import static com.epimorphismmc.epimorphism.common.data.EPItems.*;
import static com.epimorphismmc.epimorphism.common.data.items.EPChemistryItem.CATALYST_CARRIER;
import static com.gregtechceu.gtceu.api.GTValues.*;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.*;
import static com.gregtechceu.gtceu.api.fluids.store.FluidStorageKeys.GAS;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.*;

/**
 * 零件相关配方
 */
public class PartsRecipeHandler {

    private PartsRecipeHandler() {
        /**/
    }

    public static void init(Consumer<FinishedRecipe> provider) {
        laserEmitter.executeHandler(
                provider, PropertyKey.FLUID, PartsRecipeHandler::processLaserEmitter);
        catalyst.executeHandler(provider, PropertyKey.DUST, PartsRecipeHandler::processCatalyst);
    }

    private static void processLaserEmitter(
            TagPrefix stickPrefix,
            Material material,
            FluidProperty property,
            Consumer<FinishedRecipe> provider) {
        CANNER_RECIPES
                .recipeBuilder(material.getName() + "laser_emitter")
                .inputItems(EMPTY_GAS_LASER_EMITTER)
                .inputFluids(material.getFluid(GAS, 1000))
                .outputItems(stickPrefix, material)
                .EUt(VA[HV])
                .duration(120)
                .cleanroom(CleanroomType.CLEANROOM)
                .save(provider);
    }

    private static void processCatalyst(
            TagPrefix catalystPrefix,
            Material material,
            DustProperty property,
            Consumer<FinishedRecipe> provider) {
        ASSEMBLER_RECIPES
                .recipeBuilder(material.getName() + "_carrier")
                .inputItems(CATALYST_CARRIER)
                .inputItems(dust, material)
                .outputItems(catalystPrefix, material)
                .EUt(VA[HV])
                .duration(120)
                .save(provider);
    }
}
