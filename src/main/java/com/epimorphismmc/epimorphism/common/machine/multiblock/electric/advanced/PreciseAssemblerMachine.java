package com.epimorphismmc.epimorphism.common.machine.multiblock.electric.advanced;

import com.epimorphismmc.epimorphism.Epimorphism;
import com.epimorphismmc.epimorphism.api.machine.multiblock.ParallelCasingMultiblockMachine;

import com.epimorphismmc.monomorphism.block.tier.ITierType;
import com.epimorphismmc.monomorphism.utility.MOUtils;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.MetaMachine;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;
import com.gregtechceu.gtceu.api.recipe.RecipeHelper;
import com.gregtechceu.gtceu.common.data.GTRecipeTypes;

import com.lowdragmc.lowdraglib.syncdata.annotation.DescSynced;
import com.lowdragmc.lowdraglib.syncdata.field.ManagedFieldHolder;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.resources.ResourceLocation;

import lombok.Getter;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class PreciseAssemblerMachine extends ParallelCasingMultiblockMachine {

    protected static final ManagedFieldHolder MANAGED_FIELD_HOLDER = new ManagedFieldHolder(
            PreciseAssemblerMachine.class, ParallelCasingMultiblockMachine.MANAGED_FIELD_HOLDER);

    private static final ResourceLocation MK1 =
            Epimorphism.id("block/casings/solid/precise_assembler_casing_mk1");
    private static final ResourceLocation MK2 =
            Epimorphism.id("block/casings/solid/precise_assembler_casing_mk2");
    private static final ResourceLocation MK3 =
            Epimorphism.id("block/casings/solid/precise_assembler_casing_mk3");

    @Getter
    @DescSynced
    private int PACasingTier;

    public PreciseAssemblerMachine(IMachineBlockEntity holder, Object... args) {
        super(
                holder,
                "MachineCasing",
                machine -> machine.getRecipeType() == GTRecipeTypes.ASSEMBLER_RECIPES
                        ? Math.max(machine.getTier() * 8 + 1, 1)
                        : 1,
                args);
    }

    //////////////////////////////////////
    // ***    Multiblock LifeCycle    ***//
    //////////////////////////////////////

    @Override
    public void onStructureFormed() {
        super.onStructureFormed();
        Object data = getMultiblockState().getMatchContext().get("PACasing");
        this.PACasingTier =
                MOUtils.getOrDefault(() -> data instanceof ITierType, () -> ((ITierType) data).tier(), 0);
    }

    @Override
    public void onStructureInvalid() {
        super.onStructureInvalid();
        this.PACasingTier = 0;
    }

    //////////////////////////////////////
    // ******     Recipe Logic    *******//
    //////////////////////////////////////

    @Override
    protected @Nullable GTRecipe getRealRecipe(GTRecipe recipe) {
        int voltageTier = getCasingTier();
        if (voltageTier < GTValues.UHV && RecipeHelper.getRecipeEUtTier(recipe) > voltageTier) {
            return null;
        }

        var modified = super.getRealRecipe(recipe);
        if (getRecipeType() == GTRecipeTypes.ASSEMBLER_RECIPES) {
            var copied = recipe == modified ? modified.copy() : modified;
            if (copied != null) {
                copied.duration /= 2;
            }
            return copied;
        }
        return modified;
    }

    //////////////////////////////////////
    // ***       Multiblock Data      ***//
    //////////////////////////////////////

    public static @Nullable ResourceLocation locationGetter(MetaMachine machine) {
        if (machine instanceof PreciseAssemblerMachine preciseAssemblerMachine
                && preciseAssemblerMachine.isFormed()) {
            return switch (preciseAssemblerMachine.getPACasingTier()) {
                case 1 -> MK1;
                case 2 -> MK2;
                case 3 -> MK3;
                default -> null;
            };
        }
        return null;
    }

    @Override
    public ManagedFieldHolder getFieldHolder() {
        return MANAGED_FIELD_HOLDER;
    }
}
