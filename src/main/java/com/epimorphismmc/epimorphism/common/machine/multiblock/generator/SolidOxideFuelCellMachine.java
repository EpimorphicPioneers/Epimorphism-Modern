package com.epimorphismmc.epimorphism.common.machine.multiblock.generator;

import com.epimorphismmc.epimorphism.common.data.EPBlocks;

import com.epimorphismmc.monomorphism.recipe.MORecipeHelper;
import com.epimorphismmc.monomorphism.utility.MOFormattingUtils;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.capability.recipe.FluidRecipeCapability;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.multiblock.TieredWorkableElectricMultiblockMachine;
import com.gregtechceu.gtceu.api.machine.trait.RecipeLogic;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;
import com.gregtechceu.gtceu.api.recipe.RecipeHelper;
import com.gregtechceu.gtceu.api.recipe.content.ContentModifier;
import com.gregtechceu.gtceu.common.data.GTMaterials;

import com.lowdragmc.lowdraglib.side.fluid.FluidHelper;
import com.lowdragmc.lowdraglib.side.fluid.FluidStack;
import com.lowdragmc.lowdraglib.syncdata.annotation.Persisted;
import com.lowdragmc.lowdraglib.syncdata.field.ManagedFieldHolder;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;

import lombok.Getter;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import javax.annotation.ParametersAreNonnullByDefault;

import static com.gregtechceu.gtceu.api.GTValues.HV;
import static com.gregtechceu.gtceu.common.data.GTBlocks.CASING_STAINLESS_CLEAN;
import static com.gregtechceu.gtceu.common.data.GTBlocks.CASING_TUNGSTENSTEEL_ROBUST;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class SolidOxideFuelCellMachine extends TieredWorkableElectricMultiblockMachine {

    private static final ManagedFieldHolder MANAGED_FIELD_HOLDER = new ManagedFieldHolder(
            SolidOxideFuelCellMachine.class,
            TieredWorkableElectricMultiblockMachine.MANAGED_FIELD_HOLDER);

    private static final FluidStack MK1_STEAM =
            GTMaterials.Steam.getFluid(20 * FluidHelper.getBucket());

    private static final FluidStack MK2_STEAM =
            GTMaterials.Steam.getFluid(96 * FluidHelper.getBucket());

    private static final FluidStack MK1_OXYGEN =
            GTMaterials.Oxygen.getFluid(FluidHelper.getBucket() / 10);

    private static final FluidStack MK2_OXYGEN =
            GTMaterials.Oxygen.getFluid(2 * FluidHelper.getBucket());

    @Persisted
    @Getter
    private int efficiency;

    public SolidOxideFuelCellMachine(IMachineBlockEntity holder, int tier, Object... args) {
        super(holder, tier, args);
    }

    //////////////////////////////////////
    // ******     Recipe Logic    *******//
    //////////////////////////////////////

    @Override
    protected @Nullable GTRecipe getRealRecipe(GTRecipe recipe) {
        int expectedEfficiency = Math.min(1000, efficiency + 4);
        int calorificValue = getCalorificValue(getTier());
        long total = RecipeHelper.getOutputEUt(recipe) * recipe.duration;
        long EUt = (calorificValue / 20L) * expectedEfficiency / 1000;
        GTRecipe copied =
                recipe.copy(ContentModifier.multiplier((double) calorificValue / total), false);
        copied.duration = 20;
        RecipeHelper.setOutputEUt(copied, EUt);

        var inputContents = copied.getInputContents(FluidRecipeCapability.CAP);
        var oxygenContent = MORecipeHelper.fluidContent(getOxygen(getTier()), 1, 0);
        if (inputContents.isEmpty()) {
            copied.inputs.put(FluidRecipeCapability.CAP, List.of(oxygenContent));
        } else {
            inputContents.add(oxygenContent);
        }

        if (expectedEfficiency == 1000) {
            var outputContents = copied.getOutputContents(FluidRecipeCapability.CAP);
            var steamContent = MORecipeHelper.fluidContent(getSteam(getTier()), 1, 0);
            if (outputContents.isEmpty()) {
                copied.outputs.put(FluidRecipeCapability.CAP, List.of(steamContent));
            } else {
                outputContents.add(steamContent);
            }
        }
        return copied;
    }

    @Override
    public boolean beforeWorking(@Nullable GTRecipe recipe) {
        this.efficiency = Math.min(1000, efficiency + 4);
        return super.beforeWorking(recipe);
    }

    @Override
    public boolean alwaysTryModifyRecipe() {
        return true;
    }

    @Override
    public void notifyStatusChanged(RecipeLogic.Status oldStatus, RecipeLogic.Status newStatus) {
        super.notifyStatusChanged(oldStatus, newStatus);
        if (newStatus == RecipeLogic.Status.IDLE) {
            this.efficiency = 0;
        }
    }

    //////////////////////////////////////
    // ***        Multiblock UI       ***//
    //////////////////////////////////////

    @Override
    public void addDisplayText(List<Component> textList) {
        super.addDisplayText(textList);
        if (isFormed()) {
            textList.add(Component.translatable(
                    "block.epimorphism.solid_oxide_fuel_cell.efficiency",
                    MOFormattingUtils.DECIMAL_FORMAT_1F.format((double) efficiency / 10)));
        }
    }

    @Override
    public ManagedFieldHolder getFieldHolder() {
        return MANAGED_FIELD_HOLDER;
    }

    //////////////////////////////////////
    // **********     Misc     **********//
    //////////////////////////////////////

    public static int getTier(int tier) {
        return tier == HV ? 1 : 2;
    }

    public static int getCalorificValue(int tier) {
        if (tier == HV) {
            return 40960;
        } else {
            return 491520;
        }
    }

    public static FluidStack getSteam(int tier) {
        if (tier == HV) {
            return MK1_STEAM;
        } else {
            return MK2_STEAM;
        }
    }

    public static FluidStack getOxygen(int tier) {
        if (tier == HV) {
            return MK1_OXYGEN;
        } else {
            return MK2_OXYGEN;
        }
    }

    public static ResourceLocation getTexture(int tier) {
        return tier == HV
                ? GTCEu.id("block/casings/solid/machine_casing_clean_stainless_steel")
                : GTCEu.id("block/casings/solid/machine_casing_robust_tungstensteel");
    }

    public static Block getCasingState(int tier) {
        return tier == HV ? CASING_STAINLESS_CLEAN.get() : CASING_TUNGSTENSTEEL_ROBUST.get();
    }

    public static Block getElectrolyteUnitState(int tier) {
        return tier == HV
                ? EPBlocks.Y_ZR_CERAMIC_ELECTROLYTE_UNIT.get()
                : EPBlocks.GD_CE_CERAMIC_ELECTROLYTE_UNIT.get();
    }
}
