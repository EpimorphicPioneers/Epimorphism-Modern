package com.epimorphismmc.epimorphism.common.machine.multiblock.electric;

import com.epimorphismmc.epimorphism.common.machine.trait.ConcreteBackfillerLogic;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.feature.IDataInfoProvider;
import com.gregtechceu.gtceu.api.machine.multiblock.MultiblockDisplayText;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableElectricMultiblockMachine;
import com.gregtechceu.gtceu.api.machine.trait.RecipeLogic;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;
import com.gregtechceu.gtceu.common.data.GTBlocks;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import com.gregtechceu.gtceu.common.item.PortableScannerBehavior;

import net.minecraft.ChatFormatting;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.BlockHitResult;

import lombok.Getter;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class ConcreteBackfillerMachine extends WorkableElectricMultiblockMachine
        implements IDataInfoProvider {

    public static final int CHUNK_LENGTH = 16;

    @Getter
    private final int tier;

    public ConcreteBackfillerMachine(
            IMachineBlockEntity holder, int tier, int maximumChunkDiameter) {
        super(holder, maximumChunkDiameter);
        this.tier = tier;
    }

    //////////////////////////////////////
    // *****    Initialization    ***** //
    //////////////////////////////////////

    @Override
    public void onStructureFormed() {
        super.onStructureFormed();
        getRecipeLogic().initPos();
    }

    //////////////////////////////////////
    // ***      Multiblock Data     *** //
    //////////////////////////////////////

    public static Material getMaterial(int tier) {
        if (tier == GTValues.EV) return GTMaterials.Titanium;
        return GTMaterials.Steel;
    }

    public static Block getCasingState(int tier) {
        return GTBlocks.MATERIALS_TO_CASINGS.get(getMaterial(tier)).get();
    }

    @Override
    public List<Component> getDataInfo(PortableScannerBehavior.DisplayMode mode) {
        if (mode == PortableScannerBehavior.DisplayMode.SHOW_ALL
                || mode == PortableScannerBehavior.DisplayMode.SHOW_MACHINE_INFO) {
            int workingArea = getRecipeLogic().getCurrentRadius() * 2 + 1;
            return Collections.singletonList(
                    Component.translatable("gtceu.universal.tooltip.working_area", workingArea, workingArea));
        }
        return new ArrayList<>();
    }

    //////////////////////////////////////
    // ******        Logic       ****** //
    //////////////////////////////////////

    @Override
    protected RecipeLogic createRecipeLogic(Object... args) {
        if (args[args.length - 1] instanceof Integer maxRadius) {
            return new ConcreteBackfillerLogic(this, maxRadius * CHUNK_LENGTH / 2);
        } else {
            throw new IllegalArgumentException("ConcreteBackfiller need args [maxRadius]");
        }
    }

    @Override
    public ConcreteBackfillerLogic getRecipeLogic() {
        return (ConcreteBackfillerLogic) super.getRecipeLogic();
    }

    @Override
    public long getMaxVoltage() {
        return Math.max(GTValues.V[tier], super.getMaxVoltage());
    }

    @Override
    public long getOverclockVoltage() {
        return Math.max(GTValues.V[tier], super.getOverclockVoltage());
    }

    @Override
    public @Nullable GTRecipe fullModifyRecipe(GTRecipe recipe) {
        return doModifyRecipe(getRecipeLogic().modifyRecipe(recipe));
    }

    @Override
    public void setWorkingEnabled(boolean isWorkingAllowed) {
        super.setWorkingEnabled(isWorkingAllowed);
        if (getRecipeLogic().isDone()) {
            getRecipeLogic().resetArea();
        }
    }

    //////////////////////////////////////
    // ******         GUI        ****** //
    //////////////////////////////////////
    @Override
    public void addDisplayText(List<Component> textList) {
        MultiblockDisplayText.builder(textList, isFormed())
                .setWorkingStatus(getRecipeLogic().isWorkingEnabled(), getRecipeLogic().isActive())
                .addEnergyUsageLine(energyContainer)
                .addWorkingStatusLine()
                .addProgressLine(getRecipeLogic().getProgressPercent());
        getDefinition().getAdditionalDisplay().accept(this, textList);
        if (isFormed()) {
            textList.add(Component.translatable(
                    "gui.epimorphism.backfiller.start",
                    getRecipeLogic().getStartX() == Integer.MAX_VALUE
                            ? 0
                            : getRecipeLogic().getStartX(),
                    getRecipeLogic().getStartY() == Integer.MAX_VALUE
                            ? 0
                            : getRecipeLogic().getStartY(),
                    getRecipeLogic().getStartZ() == Integer.MAX_VALUE
                            ? 0
                            : getRecipeLogic().getStartZ()));
            textList.add(Component.translatable(
                    "gui.epimorphism.backfiller.filling",
                    getRecipeLogic().getFillX() == Integer.MAX_VALUE
                            ? 0
                            : getRecipeLogic().getFillX(),
                    getRecipeLogic().getFillY() == Integer.MAX_VALUE
                            ? 0
                            : getRecipeLogic().getFillY(),
                    getRecipeLogic().getFillZ() == Integer.MAX_VALUE
                            ? 0
                            : getRecipeLogic().getFillZ()));
            int workingArea = getRecipeLogic().getCurrentRadius() * 2 + 1;
            int maxWorkingArea = getRecipeLogic().getMaximumRadius() * 2 + 1;
            textList.add(
                    Component.translatable("gtceu.universal.tooltip.working_area", workingArea, workingArea));
            textList.add(Component.translatable(
                    "gtceu.universal.tooltip.working_area_max", maxWorkingArea, maxWorkingArea));
            if (getRecipeLogic().isDone()) {
                textList.add(Component.translatable("gui.epimorphism.backfiller.done")
                        .withStyle(ChatFormatting.GREEN));
            }
        }
    }

    //////////////////////////////////////
    // ******     Interaction    ****** //
    //////////////////////////////////////
    @Override
    protected InteractionResult onScrewdriverClick(
            Player playerIn, InteractionHand hand, Direction gridSide, BlockHitResult hitResult) {
        if (!isFormed()) return InteractionResult.PASS;

        if (isRemote()) return InteractionResult.sidedSuccess(true);

        if (!isActive()) {
            int currentRadius = getRecipeLogic().getCurrentRadius();
            int maximumRadius = getRecipeLogic().getMaximumRadius();
            if (currentRadius + 8 > maximumRadius) {
                currentRadius = 8;
            } else {
                currentRadius += 8;
            }
            getRecipeLogic().setCurrentRadius(currentRadius);
            int workingArea = currentRadius * 2 + 1;
            playerIn.sendSystemMessage(
                    Component.translatable("gtceu.universal.tooltip.working_area", workingArea, workingArea));
            getRecipeLogic().resetArea();
        } else {
            playerIn.sendSystemMessage(Component.translatable("gtceu.multiblock.large_miner.errorradius")
                    .withStyle(ChatFormatting.RED));
        }
        return InteractionResult.sidedSuccess(false);
    }
}
