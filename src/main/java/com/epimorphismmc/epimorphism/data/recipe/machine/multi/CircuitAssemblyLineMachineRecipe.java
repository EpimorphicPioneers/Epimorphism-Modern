package com.epimorphismmc.epimorphism.data.recipe.machine.multi;

import com.epimorphismmc.epimorphism.Epimorphism;
import com.epimorphismmc.epimorphism.common.data.machine.AdvancedMachines;

import com.gregtechceu.gtceu.api.fluids.store.FluidStorageKeys;
import com.gregtechceu.gtceu.common.data.GTItems;
import com.gregtechceu.gtceu.common.data.GTMachines;

import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

import static com.epimorphismmc.epimorphism.common.data.EPMaterials.*;
import static com.gregtechceu.gtceu.api.GTValues.*;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.*;

public class CircuitAssemblyLineMachineRecipe {
    public static void init(Consumer<FinishedRecipe> provider) {
        ASSEMBLY_LINE_RECIPES
                .recipeBuilder(Epimorphism.id("circuit_assembly_line"))
                .inputItems(GTMachines.CIRCUIT_ASSEMBLER[LuV])
                .inputItems(GTItems.ROBOT_ARM_LuV, 4)
                .inputItems(GTItems.ELECTRIC_MOTOR_LuV, 4)
                .inputItems(GTItems.FIELD_GENERATOR_LuV)
                .inputItems(GTItems.EMITTER_LuV)
                .inputItems(GTItems.SENSOR_LuV)
                .inputItems(plate, Rhodium, 8)
                .inputFluids(Indalloy140.getFluid(FluidStorageKeys.MOLTEN, 1440))
                .outputItems(AdvancedMachines.CIRCUIT_ASSEMBLY_LINE)
                .scannerResearch(b -> b.researchStack(GTMachines.CIRCUIT_ASSEMBLER[LuV].asStack())
                        .duration(1200 * 20)
                        .EUt(VA[LV]))
                .duration(1200 * 20)
                .EUt(VA[LuV])
                .save(provider);
    }
}
