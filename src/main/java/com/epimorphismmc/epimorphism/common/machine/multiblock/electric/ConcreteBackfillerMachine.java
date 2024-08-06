package com.epimorphismmc.epimorphism.common.machine.multiblock.electric;

import com.epimorphismmc.epimorphism.common.machine.trait.ConcreteBackfillerLogic;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.capability.IEnergyContainer;
import com.gregtechceu.gtceu.api.capability.recipe.EURecipeCapability;
import com.gregtechceu.gtceu.api.capability.recipe.FluidRecipeCapability;
import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.feature.multiblock.IMultiPart;
import com.gregtechceu.gtceu.api.machine.multiblock.MultiblockDisplayText;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableElectricMultiblockMachine;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableMultiblockMachine;
import com.gregtechceu.gtceu.api.machine.trait.RecipeLogic;
import com.gregtechceu.gtceu.api.misc.EnergyContainerList;
import com.gregtechceu.gtceu.common.data.GTBlocks;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import com.gregtechceu.gtceu.utils.GTTransferUtils;
import com.gregtechceu.gtceu.utils.GTUtil;

import com.lowdragmc.lowdraglib.misc.FluidTransferList;
import com.lowdragmc.lowdraglib.side.fluid.FluidStack;
import com.lowdragmc.lowdraglib.side.fluid.IFluidTransfer;
import com.lowdragmc.lowdraglib.syncdata.field.ManagedFieldHolder;

import net.minecraft.ChatFormatting;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.BlockHitResult;

import it.unimi.dsi.fastutil.longs.Long2ObjectMaps;
import lombok.Getter;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class ConcreteBackfillerMachine extends WorkableElectricMultiblockMachine {

    public static final ManagedFieldHolder MANAGED_FIELD_HOLDER = new ManagedFieldHolder(
            ConcreteBackfillerMachine.class, WorkableMultiblockMachine.MANAGED_FIELD_HOLDER);

    public static final int CHUNK_LENGTH = 16;

    @Getter
    private final int tier;

    @Nullable protected EnergyContainerList energyContainer;

    @Nullable protected FluidTransferList inputFluidInventory;

    public ConcreteBackfillerMachine(
            IMachineBlockEntity holder, int tier, int speed, int maximumChunkDiameter) {
        super(holder, speed, maximumChunkDiameter);
        this.tier = tier;
    }

    //////////////////////////////////////
    // *****    Initialization    ***** //
    //////////////////////////////////////

    @Override
    protected RecipeLogic createRecipeLogic(Object... args) {
        if (args[args.length - 2] instanceof Integer speed
                && args[args.length - 1] instanceof Integer maxRadius) {
            return new ConcreteBackfillerLogic(this, speed, maxRadius * CHUNK_LENGTH / 2);
        } else {
            throw new IllegalArgumentException("ConcreteBackfiller need args [speed, maxRadius]");
        }
    }

    @Override
    public ConcreteBackfillerLogic getRecipeLogic() {
        return (ConcreteBackfillerLogic) super.getRecipeLogic();
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
    public long getMaxVoltage() {
        return GTValues.V[getEnergyTier()];
    }

    //////////////////////////////////////
    // ******        Logic       ****** //
    //////////////////////////////////////
    @Override
    public void onStructureFormed() {
        super.onStructureFormed();
        initializeAbilities();
    }

    private void initializeAbilities() {
        List<IEnergyContainer> energyContainers = new ArrayList<>();
        List<IFluidTransfer> fluidTanks = new ArrayList<>();
        Map<Long, IO> ioMap =
                getMultiblockState().getMatchContext().getOrCreate("ioMap", Long2ObjectMaps::emptyMap);
        for (IMultiPart part : getParts()) {
            IO io = ioMap.getOrDefault(part.self().getPos().asLong(), IO.BOTH);
            if (io == IO.NONE) continue;
            for (var handler : part.getRecipeHandlers()) {
                if (io != IO.BOTH && handler.getHandlerIO() != IO.BOTH && io != handler.getHandlerIO())
                    continue;
                var handlerIO = io == IO.BOTH ? handler.getHandlerIO() : io;
                if (handlerIO == IO.IN
                        && handler.getCapability() == EURecipeCapability.CAP
                        && handler instanceof IEnergyContainer container) {
                    energyContainers.add(container);
                } else if (handlerIO == IO.IN
                        && handler.getCapability() == FluidRecipeCapability.CAP
                        && handler instanceof IFluidTransfer fluidTransfer) {
                    fluidTanks.add(fluidTransfer);
                }
            }
        }

        this.energyContainer = new EnergyContainerList(energyContainers);
        this.inputFluidInventory = new FluidTransferList(fluidTanks);

        getRecipeLogic().setVoltageTier(GTUtil.getTierByVoltage(energyContainer.getInputVoltage()));
        getRecipeLogic()
                .setOverclockAmount(Math.max(
                        1, GTUtil.getTierByVoltage(this.energyContainer.getInputVoltage()) - this.tier));
        getRecipeLogic().initPos(getRecipeLogic().getCenterPos(), getRecipeLogic().getCurrentRadius());
    }

    public int getEnergyTier() {
        if (energyContainer == null) return this.tier;
        return Math.min(
                this.tier + 1,
                Math.max(this.tier, GTUtil.getFloorTierByVoltage(energyContainer.getInputVoltage())));
    }

    public boolean drainInput(boolean simulate) {
        return drainEnergy(simulate) && drainFluid(getRecipeLogic().getOverclockAmount(), simulate);
    }

    public boolean drainEnergy(boolean simulate) {
        if (energyContainer != null && energyContainer.getEnergyStored() > 0) {
            long energyToDrain = GTValues.VA[getEnergyTier()];
            long resultEnergy = energyContainer.getEnergyStored() - energyToDrain;
            if (resultEnergy >= 0L && resultEnergy <= energyContainer.getEnergyCapacity()) {
                if (!simulate) {
                    energyContainer.changeEnergy(-energyToDrain);
                }
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean drainFluid(int times, boolean simulate) {
        if (inputFluidInventory != null && inputFluidInventory.transfers.length > 0) {
            FluidStack concreteFluid = GTMaterials.Concrete.getFluid(times * 144L);
            FluidStack fluidStack = inputFluidInventory.getFluidInTank(0);
            if (!fluidStack.isEmpty()
                    && fluidStack.isFluidEqual(concreteFluid)
                    && fluidStack.getAmount() >= concreteFluid.getAmount()) {
                if (!simulate) {
                    GTTransferUtils.drainFluidAccountNotifiableList(
                            inputFluidInventory, concreteFluid, false);
                }
                return true;
            } else {
                return false;
            }
        } else {
            return false;
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
                .addParallelsLine(getRecipeLogic().getOverclockAmount())
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
        if (isRemote() || !this.isFormed()) return InteractionResult.SUCCESS;

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

        return InteractionResult.SUCCESS;
    }
}
