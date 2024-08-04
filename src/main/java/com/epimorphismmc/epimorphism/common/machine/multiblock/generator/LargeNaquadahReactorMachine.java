package com.epimorphismmc.epimorphism.common.machine.multiblock.generator;

import com.epimorphismmc.epimorphism.common.data.EPRecipeTypes;

import com.gregtechceu.gtceu.api.capability.recipe.FluidRecipeCapability;
import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.feature.IExplosionMachine;
import com.gregtechceu.gtceu.api.machine.feature.IRecipeLogicMachine;
import com.gregtechceu.gtceu.api.machine.feature.multiblock.IMultiPart;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableElectricMultiblockMachine;
import com.gregtechceu.gtceu.api.machine.trait.RecipeLogic;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;
import com.gregtechceu.gtceu.api.recipe.GTRecipeType;
import com.gregtechceu.gtceu.api.recipe.RecipeHelper;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import com.gregtechceu.gtceu.common.data.GTRecipeModifiers;
import com.gregtechceu.gtceu.data.recipe.builder.GTRecipeBuilder;

import com.lowdragmc.lowdraglib.side.fluid.FluidHelper;
import com.lowdragmc.lowdraglib.side.fluid.FluidStack;
import com.lowdragmc.lowdraglib.side.fluid.IFluidTransfer;
import com.lowdragmc.lowdraglib.syncdata.annotation.Persisted;
import com.lowdragmc.lowdraglib.syncdata.field.ManagedFieldHolder;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.network.chat.Component;

import it.unimi.dsi.fastutil.longs.Long2ObjectMaps;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class LargeNaquadahReactorMachine extends WorkableElectricMultiblockMachine
        implements IExplosionMachine {

    private static final FluidStack AIR =
            GTMaterials.LiquidAir.getFluid((FluidHelper.getBucket() / 1000) * 2400);

    public LargeNaquadahReactorMachine(IMachineBlockEntity holder) {
        super(holder);
    }

    //////////////////////////////////////
    // ***    Multiblock LifeCycle    ***//
    //////////////////////////////////////
    @Override
    public void onStructureFormed() {
        super.onStructureFormed();
        var matchContext = getMultiblockState().getMatchContext();
        Map<Long, IO> ioMap = matchContext.getOrCreate("ioMap", Long2ObjectMaps::emptyMap);
        List<IMultiPart> parts = getParts();
        for (IMultiPart part : parts) {
            IO io = ioMap.getOrDefault(part.self().getPos().asLong(), IO.BOTH);
            if (io == IO.NONE) continue;
            for (var handler : part.getRecipeHandlers()) {
                var handlerIO = handler.getHandlerIO();
                // If IO not compatible
                if (io != IO.BOTH && handlerIO != IO.BOTH && io != handlerIO) continue;

                if (handler.getCapability() == FluidRecipeCapability.CAP
                        && handler instanceof IFluidTransfer) {
                    if (handlerIO == IO.IN || handlerIO == IO.BOTH) {
                        traitSubscriptions.add(handler.addChangedListener(this::markDirtySearching));
                    }
                }
            }
        }
    }

    //////////////////////////////////////
    // ******     Recipe Logic    *******//
    //////////////////////////////////////

    @Override
    public GTRecipeType[] getRecipeTypes() {
        return new GTRecipeType[] {EPRecipeTypes.LARGE_NAQUADAH_REACTOR_FUELS};
    }

    @Override
    protected RecipeLogic createRecipeLogic(Object... args) {
        return new ReactorLogic(this);
    }

    @Override
    protected @Nullable GTRecipe getRealRecipe(GTRecipe recipe) {
        if (!(recipe.recipeType == EPRecipeTypes.LARGE_NAQUADAH_REACTOR_FUELS)) return null;
        return getLogic().doModifyRecipe(recipe);
    }

    @Override
    public boolean alwaysTryModifyRecipe() {
        return true;
    }

    public long getRealEUt() {
        return getLogic().getRealEUt();
    }

    protected void markDirtySearching() {
        getLogic().markDirtySearching();
    }

    protected ReactorLogic getLogic() {
        return (ReactorLogic) getRecipeLogic();
    }

    //////////////////////////////////////
    // ***        Multiblock UI       ***//
    //////////////////////////////////////

    @Override
    public void addDisplayText(List<Component> textList) {
        super.addDisplayText(textList);
        if (isFormed()) {
            textList.add(Component.translatable(
                    "block.epimorphism.large_naquadah_reactor.real_eut", getRealEUt()));
        }
    }

    //////////////////////////////////////
    // ***      Multiblock Traits     ***//
    //////////////////////////////////////

    protected class ReactorLogic extends RecipeLogic {

        private static final ManagedFieldHolder MANAGED_FIELD_HOLDER =
                new ManagedFieldHolder(ReactorLogic.class, RecipeLogic.MANAGED_FIELD_HOLDER);

        @Persisted
        private GTRecipe lastSecondRecipe;

        @Persisted
        private GTRecipe lastExcitedRecipe;

        @Persisted
        private int parallel = 1;

        public ReactorLogic(IRecipeLogicMachine machine) {
            super(machine);
        }

        @Override
        public LargeNaquadahReactorMachine getMachine() {
            return (LargeNaquadahReactorMachine) super.getMachine();
        }

        @Override
        @Nullable protected Iterator<GTRecipe> searchRecipe() {
            var matches = super.searchRecipe();
            List<GTRecipe> list = new ArrayList<>();
            while (matches != null && matches.hasNext()) {
                GTRecipe match = matches.next();
                if (match == null) continue;
                list.add(match);
            }
            if (list.size() > 1) {
                getMachine().doExplosion(4 * 32);
                return null;
            }
            return list.iterator();
        }

        @Override
        public GTRecipe.ActionResult handleTickRecipe(GTRecipe recipe) {
            long totalContinuousRunningTime = getTotalContinuousRunningTime();
            if ((totalContinuousRunningTime == 0 || totalContinuousRunningTime % 20 == 19)) {
                var copied = recipe.copy();
                var airRecipe = getAirRecipe();
                if (!(airRecipe.matchRecipe(machine).isSuccess()
                        && airRecipe.handleRecipeIO(IO.IN, machine))) {
                    RecipeHelper.setOutputEUt(copied, 0);
                } else {
                    int efficiency = handleCoolant();
                    int parallel = 1;
                    if (lastExcitedRecipe != null
                            && lastExcitedRecipe.matchRecipe(machine).isSuccess()
                            && lastExcitedRecipe.handleRecipeIO(IO.IN, machine)) {
                        parallel = this.parallel;
                    }
                    long EUt = RecipeHelper.getOutputEUt(recipe) * efficiency * parallel / 100;
                    RecipeHelper.setOutputEUt(copied, EUt);
                }
                this.lastSecondRecipe = copied;
            }

            return super.handleTickRecipe(lastSecondRecipe != null ? lastSecondRecipe : recipe);
        }

        protected GTRecipe doModifyRecipe(GTRecipe recipe) {
            var maxParallel = handleExcitedFluid();
            var parallelResult = GTRecipeModifiers.fastParallel(getMachine(), recipe, maxParallel, false);
            this.parallel = parallelResult.getSecond();
            var modified = parallelResult.getFirst();
            RecipeHelper.setOutputEUt(modified, RecipeHelper.getOutputEUt(recipe));
            return modified;
        }

        private int handleExcitedFluid() {
            var matches = EPRecipeTypes.LARGE_NAQUADAH_EXCITED_FLUID_LIST.searchRecipe(machine);
            if (matches != null) {
                Map<GTRecipe, Integer> map = new HashMap<>();
                while (matches.hasNext()) {
                    GTRecipe match = matches.next();
                    if (match == null) continue;
                    map.put(match, match.data.getInt("parallel"));
                }
                for (Map.Entry<GTRecipe, Integer> entry : map.entrySet().stream()
                        .sorted(Collections.reverseOrder(Comparator.comparingInt(Map.Entry::getValue)))
                        .toList()) {
                    var recipe = entry.getKey();
                    if (recipe.matchRecipe(machine).isSuccess() && recipe.handleRecipeIO(IO.IN, machine)) {
                        this.lastExcitedRecipe = recipe;
                        return entry.getValue();
                    }
                }
            }
            this.lastExcitedRecipe = null;
            return 1;
        }

        private int handleCoolant() {
            var matches = EPRecipeTypes.LARGE_NAQUADAH_COOLANT_LIST.searchRecipe(machine);
            if (matches != null) {
                Map<GTRecipe, Integer> map = new HashMap<>();
                while (matches.hasNext()) {
                    GTRecipe match = matches.next();
                    if (match == null) continue;
                    map.put(match, match.data.getInt("efficiency"));
                }
                for (Map.Entry<GTRecipe, Integer> entry : map.entrySet().stream()
                        .sorted(Collections.reverseOrder(Comparator.comparingInt(Map.Entry::getValue)))
                        .toList()) {
                    var recipe = entry.getKey();
                    if (recipe.matchRecipe(machine).isSuccess() && recipe.handleRecipeIO(IO.IN, machine)) {
                        return entry.getValue();
                    }
                }
            }
            return 100;
        }

        private GTRecipe getAirRecipe() {
            return GTRecipeBuilder.ofRaw().inputFluids(AIR).buildRawRecipe();
        }

        public long getRealEUt() {
            if (lastSecondRecipe != null) {
                return RecipeHelper.getOutputEUt(lastSecondRecipe);
            } else if (lastRecipe != null) {
                return RecipeHelper.getOutputEUt(lastRecipe);
            }
            return 0;
        }

        protected void markDirtySearching() {
            // It's ugly, but I had to do it because of the logic issues with asynchronous thread recipe
            // searching
            if (!isIdle()) {
                this.lastOriginRecipe = null;
            }
        }

        @Override
        public ManagedFieldHolder getFieldHolder() {
            return MANAGED_FIELD_HOLDER;
        }
    }
}
