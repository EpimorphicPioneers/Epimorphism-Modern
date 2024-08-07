package com.epimorphismmc.epimorphism.common.machine.multiblock.generator;

import com.epimorphismmc.epimorphism.common.data.EPMaterials;
import com.epimorphismmc.epimorphism.common.data.EPRecipeTypes;

import com.epimorphismmc.monomorphism.recipe.MORecipeHelper;
import com.epimorphismmc.monomorphism.utility.MOFormattingUtils;
import com.epimorphismmc.monomorphism.utility.MOTransferUtils;

import com.gregtechceu.gtceu.api.capability.recipe.FluidRecipeCapability;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableElectricMultiblockMachine;
import com.gregtechceu.gtceu.api.machine.trait.RecipeLogic;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;
import com.gregtechceu.gtceu.api.recipe.GTRecipeType;
import com.gregtechceu.gtceu.api.recipe.RecipeHelper;
import com.gregtechceu.gtceu.api.recipe.content.ContentModifier;

import com.lowdragmc.lowdraglib.syncdata.annotation.Persisted;
import com.lowdragmc.lowdraglib.syncdata.field.ManagedFieldHolder;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.network.chat.Component;

import org.jetbrains.annotations.Nullable;

import java.util.List;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class UniversalChemicalFuelEngineMachine extends WorkableElectricMultiblockMachine {

    private static final ManagedFieldHolder MANAGED_FIELD_HOLDER = new ManagedFieldHolder(
            UniversalChemicalFuelEngineMachine.class,
            WorkableElectricMultiblockMachine.MANAGED_FIELD_HOLDER);

    @Persisted
    private double efficiency;

    public UniversalChemicalFuelEngineMachine(IMachineBlockEntity holder, Object... args) {
        super(holder, args);
    }

    //////////////////////////////////////
    // ******     Recipe Logic    *******//
    //////////////////////////////////////

    @Override
    protected @Nullable GTRecipe getRealRecipe(GTRecipe recipe) {
        var list = RecipeHelper.getInputFluids(recipe);
        if (list.isEmpty()) return recipe;

        var inputFluid = list.get(0);
        var fuel =
                MOTransferUtils.drainFluid(getCapabilitiesProxy(), inputFluid.copy(Long.MAX_VALUE), true);
        var promoter = MOTransferUtils.drainFluid(
                getCapabilitiesProxy(), EPMaterials.CombustionPromoter.getFluid(Long.MAX_VALUE), true);

        if (fuel.isEmpty()) return recipe;
        GTRecipe copied = recipe.copy(
                ContentModifier.multiplier((double) fuel.getAmount() / inputFluid.getAmount()), false);
        copied.duration = 20;
        float factor = recipe.data.getFloat("efficiency_factor");
        if (promoter.isEmpty() || factor == 0F) {
            RecipeHelper.setOutputEUt(copied, 0);
            return copied;
        }

        double efficiency =
                1.5 * Math.pow(Math.E, -factor * ((double) fuel.getAmount() / promoter.getAmount()));
        RecipeHelper.setOutputEUt(copied, (long) (RecipeHelper.getOutputEUt(copied) * efficiency / 20));
        copied
                .getInputContents(FluidRecipeCapability.CAP)
                .add(MORecipeHelper.fluidContent(promoter, 1, 0));
        this.efficiency = efficiency;
        return copied;
    }

    @Override
    public boolean alwaysTryModifyRecipe() {
        return true;
    }

    @Override
    public GTRecipeType[] getRecipeTypes() {
        return new GTRecipeType[] {EPRecipeTypes.UNIVERSAL_CHEMICAL_FUELS};
    }

    @Override
    public GTRecipeType getRecipeType() {
        return getRecipeTypes()[getActiveRecipeType()];
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
                    "block.epimorphism.universal_chemical_fuel_engine.efficiency",
                    MOFormattingUtils.DECIMAL_FORMAT_1F.format(efficiency * 100)));
        }
    }

    @Override
    public ManagedFieldHolder getFieldHolder() {
        return MANAGED_FIELD_HOLDER;
    }
}
