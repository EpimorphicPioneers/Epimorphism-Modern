package cn.gtcommunity.epimorphism.common.machine.multiblock.electric;

import cn.gtcommunity.epimorphism.utils.EPBlockUtil;
import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.capability.recipe.IRecipeHandler;
import com.gregtechceu.gtceu.api.capability.recipe.ItemRecipeCapability;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.feature.IRecipeLogicMachine;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableElectricMultiblockMachine;
import com.gregtechceu.gtceu.api.machine.trait.NotifiableItemStackHandler;
import com.gregtechceu.gtceu.api.machine.trait.RecipeLogic;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.ArrayList;
import java.util.List;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class IndustrialDrillMachine extends WorkableElectricMultiblockMachine {
    protected BlockPos targetBlock;
    protected NotifiableItemStackHandler inventory;

    public IndustrialDrillMachine(IMachineBlockEntity holder, Object... args) {
        super(holder, args);
    }

    //////////////////////////////////////
    //***    Multiblock LifeCycle    ***//
    //////////////////////////////////////
    @Override
    public void onStructureFormed() {
        super.onStructureFormed();
        this.inventory = new NotifiableItemStackHandler(this, 1, IO.IN, IO.NONE);
        if (getMultiblockState().getMatchContext().get("Bedrock") instanceof BlockPos pos) {
            this.inventory.setStackInSlot(0, EPBlockUtil.getBlockItem(getLevel().getBlockState(pos)));
        }

        if (!this.capabilitiesProxy.contains(IO.IN, ItemRecipeCapability.CAP)) {
            this.capabilitiesProxy.put(IO.IN, ItemRecipeCapability.CAP, new ArrayList<>());
        }
        List<IRecipeHandler<?>> list = this.capabilitiesProxy.get(IO.IN, ItemRecipeCapability.CAP);
        if (list != null) list.add(inventory);
    }

    @Override
    public void onStructureInvalid() {
        super.onStructureInvalid();
        this.inventory.setStackInSlot(0, ItemStack.EMPTY);
        this.targetBlock = null;
    }

    //////////////////////////////////////
    //******     Recipe Logic    *******//
    //////////////////////////////////////

    @Override
    protected RecipeLogic createRecipeLogic(Object... args) {
        return new IndustrialDrillRecipeLogic(this);
    }

    //////////////////////////////////////
    //***      Multiblock Traits     ***//
    //////////////////////////////////////

    protected class IndustrialDrillRecipeLogic extends RecipeLogic {

        public IndustrialDrillRecipeLogic(IRecipeLogicMachine machine) {
            super(machine);
        }

        @Override
        public IndustrialDrillMachine getMachine() {
            return (IndustrialDrillMachine) super.getMachine();
        }

        @Override
        public void setupRecipe(GTRecipe recipe) {
            if (this.handleFuelRecipe()) {
                this.machine.beforeWorking();
                recipe.preWorking(this.machine);
                if (handleRecipeInput(recipe)) {
                    this.recipeDirty = false;
                    this.lastRecipe = recipe;
                    this.setStatus(RecipeLogic.Status.WORKING);
                    this.progress = 0;
                    this.duration = recipe.duration;
                }
            }
        }

        private boolean handleRecipeInput(GTRecipe recipe) {
            // break the block in world if it is consumable
            if (!(recipe.getInputContents(ItemRecipeCapability.CAP).get(0).chance == 0F)) {
                var drill = getMachine();
                return drill.getLevel().destroyBlock(drill.targetBlock, false);
            }
            return true;
        }
    }
}
