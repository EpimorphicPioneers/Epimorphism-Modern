package cn.gtcommunity.epimorphism.common.machine.multiblock.noenergy;

import cn.gtcommunity.epimorphism.api.machine.multiblock.NoEnergyMultiblockMachine;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.feature.IRecipeLogicMachine;
import com.gregtechceu.gtceu.api.machine.trait.RecipeLogic;
import net.minecraft.MethodsReturnNonnullByDefault;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class AlgaeFarmMachine extends NoEnergyMultiblockMachine {
    public AlgaeFarmMachine(IMachineBlockEntity holder, Object... args) {
        super(holder, args);
    }

    //////////////////////////////////////
    //******     Recipe Logic    *******//
    //////////////////////////////////////

    @Override
    protected RecipeLogic createRecipeLogic(Object... args) {
        return new FarmRecipeLogic(this);
    }

    protected FarmRecipeLogic getLogic() {
        return (FarmRecipeLogic) getRecipeLogic();
    }

    //////////////////////////////////////
    //***      Multiblock Traits     ***//
    //////////////////////////////////////

    protected class FarmRecipeLogic extends RecipeLogic {
        public FarmRecipeLogic(IRecipeLogicMachine machine) {
            super(machine);
        }


    }
}
