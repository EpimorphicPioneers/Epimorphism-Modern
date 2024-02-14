package cn.gtcommunity.epimorphism.common.machine.multiblock.electric;

import cn.gtcommunity.epimorphism.common.data.EPMaterials;
import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.data.worldgen.bedrockfluid.BedrockFluidDefinition;
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
public class FrackerMachine extends WorkableElectricMultiblockMachine {

    public static final int TIER = GTValues.ZPM;

    public FrackerMachine(IMachineBlockEntity holder, Object... args) {
        super(holder, args);
    }

    //////////////////////////////////////
    //******     Recipe Logic    *******//
    //////////////////////////////////////

    @Override
    protected RecipeLogic createRecipeLogic(Object... args) {
        return new FrackerLogic(this);
    }

    //////////////////////////////////////
    //***      Multiblock Traits     ***//
    //////////////////////////////////////

    private class FrackerLogic extends RecipeLogic {

        public static final int MAX_PROGRESS = 100;

        @Getter
        @Nullable
        private Fluid veinFluid;

        public FrackerLogic(FrackerMachine machine) {
            super(machine);
        }

        public static final FluidStack FRACKING_FLUID = EPMaterials.FracturingFluid.getFluid(FluidHelper.getBucket());

        @Override
        public FrackerMachine getMachine() {
            return (FrackerMachine)super.getMachine();
        }

        @Override
        public void findAndHandleRecipe() {
            if (getMachine().getLevel() instanceof ServerLevel serverLevel) {
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
                var match = getFrackingRecipe();
                if (match != null) {
                    var copied = match.copy(new ContentModifier(match.duration, 0));
                    if (match.matchRecipe(this.machine).isSuccess() && copied.matchTickRecipe(this.machine).isSuccess()) {
                        setupRecipe(match);
                    }
                }
            }
        }

        @Override
        public void onRecipeFinish() {
            machine.afterWorking();
            if (lastRecipe != null) {
                lastRecipe.postWorking(this.machine);
                lastRecipe.handleRecipeIO(IO.OUT, this.machine);
            }

            if (getMachine().getLevel() instanceof ServerLevel serverLevel && veinFluid != null) {
                var data = BedrockFluidVeinSavedData.getOrCreate(serverLevel);
                replenishVein(data.getFluidVeinWorldEntry(getChunkX(), getChunkZ()), false);
            }

            // try it again
            var match = getFrackingRecipe();
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

        @Nullable
        private GTRecipe getFrackingRecipe() {
            if (getMachine().getLevel() instanceof ServerLevel serverLevel) {
                var data = BedrockFluidVeinSavedData.getOrCreate(serverLevel);
                if (replenishVein(data.getFluidVeinWorldEntry(getChunkX(), getChunkZ()), true)) {
                    var recipe = GTRecipeBuilder.ofRaw()
                            .duration(MAX_PROGRESS)
                            .EUt(GTValues.VA[getEnergyTier()])
                            .inputFluids(FRACKING_FLUID)
                            .buildRawRecipe();

                    var newRecipe = machine.doModifyRecipe(recipe);
                    if (newRecipe != null) {
                        if (newRecipe.matchRecipe(machine).isSuccess() && newRecipe.matchTickRecipe(machine).isSuccess()) {
                            return newRecipe;
                        }
                    }
                    return recipe;
                }
            }
            return null;
        }

        protected boolean replenishVein(FluidVeinWorldEntry info, boolean simulate) {
            BedrockFluidDefinition definition = info.getDefinition();
            if (definition == null) return false;

            int amount = info.getOperationsRemaining() + definition.getDepletionAmount();
            if (amount <= BedrockFluidVeinSavedData.MAXIMUM_VEIN_OPERATIONS) {
                if (simulate) return true;
                info.setOperationsRemaining(amount);
            }
            return true;
        }

        public int getEnergyTier() {
            return Math.min(TIER + 1, Math.max(TIER, getOverclockTier()));
        }

        private int getChunkX() {
            return SectionPos.blockToSectionCoord(getMachine().getPos().getX());
        }

        private int getChunkZ() {
            return SectionPos.blockToSectionCoord(getMachine().getPos().getZ());
        }
    }
}
