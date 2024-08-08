package com.epimorphismmc.epimorphism.data.recipe.machine.multi;

import com.epimorphismmc.epimorphism.Epimorphism;
import com.epimorphismmc.epimorphism.common.data.EPBlocks;
import com.epimorphismmc.epimorphism.common.data.machine.AdvancedMachines;

import com.gregtechceu.gtceu.common.data.GTBlocks;
import com.gregtechceu.gtceu.common.data.GTItems;
import com.gregtechceu.gtceu.common.data.GTMachines;
import com.gregtechceu.gtceu.data.recipe.CustomTags;

import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

import static com.epimorphismmc.epimorphism.common.data.EPMaterials.*;
import static com.gregtechceu.gtceu.api.GTValues.*;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.*;

public class ComponentAssemblyLineMachineRecipe {
    public static void init(Consumer<FinishedRecipe> provider) {
        ASSEMBLY_LINE_RECIPES
                .recipeBuilder(Epimorphism.id("component_assembly_line"))
                .inputItems(GTMachines.ASSEMBLY_LINE)
                .inputItems(GTBlocks.CASING_ASSEMBLY_LINE.asStack(16))
                .inputItems(GTBlocks.CASING_ASSEMBLY_CONTROL.asStack(32))
                .inputItems(GTItems.ROBOT_ARM_UV, 16)
                .inputItems(GTItems.CONVEYOR_MODULE_UV, 32)
                .inputItems(GTItems.ELECTRIC_MOTOR_ZPM, 32)
                .inputItems(pipeNormalFluid, Polybenzimidazole, 16)
                .inputItems(plate, Iridium, 64)
                .inputItems(GTMachines.FLUID_SOLIDIFIER[ZPM], 16)
                .inputItems(CustomTags.UV_CIRCUITS, 16)
                .inputItems(CustomTags.ZPM_CIRCUITS, 20)
                .inputItems(CustomTags.LuV_CIRCUITS, 24)
                .inputFluids(Indalloy140.getFluid(1728))
                .inputFluids(NaquadahEnriched.getFluid(2304))
                .inputFluids(Lubricant.getFluid(5000))
                .outputItems(AdvancedMachines.COMPONENT_ASSEMBLY_LINE)
                .scannerResearch(b -> b.researchStack(EPBlocks.COMPONENT_ASSEMBLY_LINE_CASING_EV.asStack())
                        .EUt(VA[LV])
                        .duration(3600 * 20))
                .duration(30 * 20)
                .EUt(VA[UHV])
                .save(provider);
    }
}
