package com.epimorphismmc.epimorphism.data.recipe.machine.multi;

import com.epimorphismmc.epimorphism.Epimorphism;
import com.epimorphismmc.epimorphism.common.data.EPMachines;

import com.gregtechceu.gtceu.api.data.chemical.material.stack.UnificationEntry;
import com.gregtechceu.gtceu.common.data.GTBlocks;
import com.gregtechceu.gtceu.common.data.GTItems;
import com.gregtechceu.gtceu.data.recipe.CustomTags;
import com.gregtechceu.gtceu.data.recipe.VanillaRecipeHelper;

import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

import static com.gregtechceu.gtceu.api.GTValues.*;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;

public class ConcreteBackfillerMachineRecipe {
    public static void init(Consumer<FinishedRecipe> provider) {
        VanillaRecipeHelper.addShapedRecipe(
                provider,
                true,
                Epimorphism.id("mv_concrete_backfiller"),
                EPMachines.CONCRETE_BACKFILLER[MV].asStack(1),
                "ABA",
                "CDC",
                "EFE",
                'A',
                new UnificationEntry(frameGt, Steel),
                'B',
                new UnificationEntry(pipeLargeFluid, Steel),
                'C',
                CustomTags.MV_CIRCUITS,
                'D',
                GTBlocks.MACHINE_CASING_MV.asStack(),
                'E',
                GTItems.ELECTRIC_MOTOR_MV,
                'F',
                GTItems.ELECTRIC_PUMP_MV);

        VanillaRecipeHelper.addShapedRecipe(
                provider,
                true,
                Epimorphism.id("ev_concrete_backfiller"),
                EPMachines.CONCRETE_BACKFILLER[EV].asStack(1),
                "ABA",
                "CDC",
                "EFE",
                'A',
                new UnificationEntry(frameGt, Titanium),
                'B',
                new UnificationEntry(pipeLargeFluid, Steel),
                'C',
                CustomTags.EV_CIRCUITS,
                'D',
                EPMachines.CONCRETE_BACKFILLER[MV].asStack(1),
                'E',
                GTItems.ELECTRIC_MOTOR_EV,
                'F',
                GTItems.ELECTRIC_PUMP_EV);
    }
}
