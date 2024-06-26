package com.epimorphismmc.epimorphism.common.machine.multiblock.electric.advanced;

import com.epimorphismmc.epimorphism.common.data.EPMaterials;

import com.epimorphismmc.monomorphism.machine.multiblock.ParallelElectricMultiblockMachine;

import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;
import com.gregtechceu.gtceu.data.recipe.builder.GTRecipeBuilder;

import com.lowdragmc.lowdraglib.side.fluid.FluidHelper;
import com.lowdragmc.lowdraglib.side.fluid.FluidStack;

import net.minecraft.ChatFormatting;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;

import org.jetbrains.annotations.Nullable;

import java.util.List;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class IndustrialFreezerMachine extends ParallelElectricMultiblockMachine {

    private final FluidStack CRYOTHEUM_STACK =
            EPMaterials.GelidCryotheum.getFluid(FluidHelper.getBucket() / 1000);

    private boolean insufficient;

    public IndustrialFreezerMachine(IMachineBlockEntity holder, Object... args) {
        super(holder, machine -> 4, args);
    }

    //////////////////////////////////////
    // ******     Recipe Logic    *******//
    //////////////////////////////////////

    protected GTRecipe getCryotheumRecipe() {
        return GTRecipeBuilder.ofRaw().inputFluids(CRYOTHEUM_STACK).buildRawRecipe();
    }

    @Override
    public boolean onWorking() {
        long totalContinuousRunningTime = recipeLogic.getTotalContinuousRunningTime();
        if ((totalContinuousRunningTime == 1 || totalContinuousRunningTime % 2 == 0)) {
            var recipe = getCryotheumRecipe();
            if (!(recipe.matchRecipe(this).isSuccess() && recipe.handleRecipeIO(IO.IN, this))) {
                this.insufficient = true;
                return false;
            } else {
                this.insufficient = false;
                return true;
            }
        }
        return super.onWorking();
    }

    @Override
    protected @Nullable GTRecipe getRealRecipe(GTRecipe recipe) {
        var tRecipe = super.getRealRecipe(recipe);
        if (tRecipe != null) {
            var newRecipe = tRecipe.copy();
            newRecipe.duration /= 2;
            return newRecipe;
        }
        return null;
    }

    //////////////////////////////////////
    // *******        GUI        ********//
    //////////////////////////////////////

    @Override
    public void addDisplayText(List<Component> textList) {
        super.addDisplayText(textList);
        if (isFormed()) {
            if (this.isActive()) {
                if (insufficient) {
                    textList.add(Component.translatable(
                                    "block.epimorphism.industrial_vacuum_freezer.warning.gelid_cryotheum")
                            .withStyle(Style.EMPTY.withColor(ChatFormatting.RED)));
                } else {
                    textList.add(
                            Component.translatable("block.epimorphism.industrial_vacuum_freezer.gelid_cryotheum")
                                    .withStyle(Style.EMPTY.withColor(ChatFormatting.AQUA)));
                }
            }
        }
    }
}
