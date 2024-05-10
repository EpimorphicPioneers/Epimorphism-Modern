package cn.gtcommunity.epimorphism.common.machine.multiblock.electric.advanced;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.data.worldgen.bedrockfluid.BedrockFluidVeinSavedData;
import com.gregtechceu.gtceu.api.data.worldgen.bedrockfluid.FluidVeinWorldEntry;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableElectricMultiblockMachine;
import com.gregtechceu.gtceu.api.machine.trait.RecipeLogic;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;
import com.gregtechceu.gtceu.api.recipe.content.ContentModifier;
import com.gregtechceu.gtceu.data.recipe.builder.GTRecipeBuilder;
import com.lowdragmc.lowdraglib.side.fluid.FluidHelper;
import com.lowdragmc.lowdraglib.side.fluid.FluidStack;
import lombok.Getter;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.SectionPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.material.Fluid;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class InfiniteFluidDrillingRigMachine extends WorkableElectricMultiblockMachine {

    public static final int TIER = GTValues.UHV;

    public InfiniteFluidDrillingRigMachine(IMachineBlockEntity holder, Object... args) {
        super(holder, args);
    }

    //////////////////////////////////////
    //******     Recipe Logic    *******//
    //////////////////////////////////////

    @Override
    protected RecipeLogic createRecipeLogic(Object... args) {
        return new InfiniteFluidDrillLogic(this);
    }

    //////////////////////////////////////
    //***      Multiblock Traits     ***//
    //////////////////////////////////////

    protected class InfiniteFluidDrillLogic extends RecipeLogic {

        public static final int MAX_PROGRESS = 1;

        @Getter
        @Nullable
        private Fluid veinFluid;

        public InfiniteFluidDrillLogic(InfiniteFluidDrillingRigMachine machine) {
            super(machine);
        }

        @Override
        public void findAndHandleRecipe() {
            if (getLevel() instanceof ServerLevel serverLevel) {
                lastRecipe = null;
                var data = BedrockFluidVeinSavedData.getOrCreate(serverLevel);
                if (veinFluid == null) {
                    this.veinFluid = data.getFluidInChunk(getChunkX(), getChunkZ());
                    if (this.veinFluid == null) {
                        if (subscription != null) {
                            subscription.unsubscribe();
                            subscription = null;
                        }
                        return;
                    }
                }
                var match = getFluidDrillRecipe();
                if (match != null) {
                    var copied = match.copy(new ContentModifier(match.duration, 0));
                    if (match.matchRecipe(this.machine).isSuccess() && copied.matchTickRecipe(this.machine).isSuccess()) {
                        setupRecipe(match);
                    }
                }
            }
        }

        @Nullable
        private GTRecipe getFluidDrillRecipe() {
            if (getLevel() instanceof ServerLevel serverLevel && veinFluid != null) {
                var data = BedrockFluidVeinSavedData.getOrCreate(serverLevel);
                var recipe = GTRecipeBuilder.ofRaw()
                        .duration(MAX_PROGRESS)
                        .EUt(GTValues.VA[getEnergyTier()])
                        .outputFluids(FluidStack.create(veinFluid, getFluidToProduce(data.getFluidVeinWorldEntry(getChunkX(), getChunkZ()))))
                        .buildRawRecipe();
                if (recipe.matchRecipe(machine).isSuccess() && recipe.matchTickRecipe(machine).isSuccess()) {
                    return recipe;
                }
            }
            return null;
        }

        private long getFluidToProduce(FluidVeinWorldEntry entry) {
            var definition = entry.getDefinition();
            if (definition != null) {
                int depletedYield = definition.getDepletedYield();
                int regularYield = entry.getFluidYield() * 7 / 4;
                int remainingOperations = entry.getOperationsRemaining();

                int produced = Math.max(depletedYield, regularYield * remainingOperations / BedrockFluidVeinSavedData.MAXIMUM_VEIN_OPERATIONS);
                produced *= getRigMultiplier();
                return produced * FluidHelper.getBucket() / 1000;
            }
            return 0;
        }

        @Override
        public void onRecipeFinish() {
            machine.afterWorking();
            if (lastRecipe != null) {
                lastRecipe.postWorking(this.machine);
                lastRecipe.handleRecipeIO(IO.OUT, this.machine);
            }

            // try it again
            var match = getFluidDrillRecipe();
            if (match != null) {
                var copied = match.copy(new ContentModifier(match.duration, 0));
                if (match.matchRecipe(this.machine).isSuccess() && copied.matchTickRecipe(this.machine).isSuccess()) {
                    setupRecipe(match);
                    return;
                }
            }
            setStatus(Status.IDLE);
            progress = 0;
            duration = 0;
        }

        protected boolean isOverclocked() {
            return getEnergyTier() > getTier();
        }

        public int getRigMultiplier() {
            if (isOverclocked()) {
                return (int) (256 + Math.pow(2, getEnergyTier() - getTier()));
            }
            return 256;
        }

        public int getEnergyTier() {
            return Math.min(TIER + 1, Math.max(TIER, getOverclockTier()));
        }

        private int getChunkX() {
            return SectionPos.blockToSectionCoord(getPos().getX());
        }

        private int getChunkZ() {
            return SectionPos.blockToSectionCoord(getPos().getZ());
        }

    }
}
