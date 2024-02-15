package cn.gtcommunity.epimorphism.common.machine.multiblock.electric;

import cn.gtcommunity.epimorphism.api.machine.multiblock.ParallelCoilMultiblockMachine;
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

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

import static cn.gtcommunity.epimorphism.common.data.EPMaterials.BlazingPyrotheum;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class AdvancedEBFMachine extends ParallelCoilMultiblockMachine {
    private final FluidStack PYROTHEUM_STACK = BlazingPyrotheum.getFluid(FluidHelper.getBucket() / 1000);

    private boolean insufficient;

    public AdvancedEBFMachine(IMachineBlockEntity holder, Object... args) {
        super(holder, machine -> 8, args);
    }

    //////////////////////////////////////
    //******     Recipe Logic    *******//
    //////////////////////////////////////

    protected GTRecipe getPyrotheumRecipe() {
        return GTRecipeBuilder.ofRaw().inputFluids(PYROTHEUM_STACK).buildRawRecipe();
    }

    @Override
    public void onWorking() {
        super.onWorking();
        long totalContinuousRunningTime = recipeLogic.getTotalContinuousRunningTime();
        if ((totalContinuousRunningTime == 1 || totalContinuousRunningTime % 2 == 0)) {
            if (!getPyrotheumRecipe().handleRecipeIO(IO.IN, this)) {
                this.insufficient = true;
                recipeLogic.interruptRecipe();
            }
            this.insufficient = false;
        }
    }

    //////////////////////////////////////
    //*******        GUI        ********//
    //////////////////////////////////////

    @Override
    public void addDisplayText(List<Component> textList) {
        super.addDisplayText(textList);
        if (isFormed()) {
            if (this.isActive()) {
                if (insufficient) {
                    textList.add(Component.translatable("block.epimorphism.advanced_electric_blast_furnace.warning.blazing_pyrotheum").withStyle(Style.EMPTY.withColor(ChatFormatting.RED)));
                } else {
                    textList.add(Component.translatable("block.epimorphism.advanced_electric_blast_furnace.blazing_pyrotheum").withStyle(Style.EMPTY.withColor(ChatFormatting.GOLD)));
                }
            }
        }
    }
}
