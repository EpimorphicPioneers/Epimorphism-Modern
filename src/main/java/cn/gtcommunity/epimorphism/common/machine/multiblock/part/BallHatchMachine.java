package cn.gtcommunity.epimorphism.common.machine.multiblock.part;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.feature.IMachineModifyDrops;
import com.gregtechceu.gtceu.api.machine.feature.multiblock.IWorkableMultiController;
import com.gregtechceu.gtceu.api.machine.multiblock.part.TieredPartMachine;
import com.gregtechceu.gtceu.api.syncdata.RequireRerender;
import com.lowdragmc.lowdraglib.syncdata.annotation.DescSynced;
import com.lowdragmc.lowdraglib.syncdata.annotation.Persisted;
import lombok.Getter;
import lombok.Setter;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class BallHatchMachine extends TieredPartMachine implements IMachineModifyDrops {

    @Getter @Setter
    @Persisted @DescSynced @RequireRerender
    private boolean isWorking;

    public BallHatchMachine(IMachineBlockEntity holder) {
        super(holder, GTValues.IV);
    }

    @Override
    public void beforeWorking(IWorkableMultiController controller) {
        super.beforeWorking(controller);
        this.isWorking = true;
    }

    @Override
    public void afterWorking(IWorkableMultiController controller) {
        super.afterWorking(controller);
        this.isWorking = false;
    }


    @Override
    public void onDrops(List<ItemStack> list, Player player) {

    }
}
