package cn.gtcommunity.epimorphism.common.machine.multiblock.electric;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableElectricMultiblockMachine;
import com.gregtechceu.gtceu.api.machine.trait.RecipeLogic;
import com.gregtechceu.gtceu.common.data.GTBlocks;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.level.block.Block;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class ConcreteBackfillerMachine extends WorkableElectricMultiblockMachine {
    public ConcreteBackfillerMachine(IMachineBlockEntity holder, int tier, int speed, int maximumChunkDiameter, int drillingFluidConsumePerTick) {
        super(holder, speed, maximumChunkDiameter);
    }

    //////////////////////////////////////
    //******     Recipe Logic    *******//
    //////////////////////////////////////

    @Override
    protected RecipeLogic createRecipeLogic(Object... args) {
        return new ConcreteBackfillerLogic(this);
    }

    //////////////////////////////////////
    //***       Multiblock Data      ***//
    //////////////////////////////////////

    public static Material getMaterial(int tier) {
        if (tier == GTValues.EV) return GTMaterials.Titanium;
        return GTMaterials.Steel;
    }

    public static Block getCasingState(int tier) {
        return GTBlocks.MATERIALS_TO_CASINGS.get(getMaterial(tier)).get();
    }

    //////////////////////////////////////
    //***      Multiblock Traits     ***//
    //////////////////////////////////////

    private class ConcreteBackfillerLogic extends RecipeLogic {

        public ConcreteBackfillerLogic(ConcreteBackfillerMachine machine) {
            super(machine);
        }
    }
}
