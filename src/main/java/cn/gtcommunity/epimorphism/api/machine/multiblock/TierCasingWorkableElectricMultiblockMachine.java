package cn.gtcommunity.epimorphism.api.machine.multiblock;

import cn.gtcommunity.epimorphism.api.structure.block.tier.ITierType;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableElectricMultiblockMachine;
import lombok.Getter;
import net.minecraft.MethodsReturnNonnullByDefault;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class TierCasingWorkableElectricMultiblockMachine extends WorkableElectricMultiblockMachine {
    @Getter
    private ITierType tierType = ITierType.TierBlockType.ULV;
    private final String typeName;

    public TierCasingWorkableElectricMultiblockMachine(IMachineBlockEntity holder, String typeName) {
        super(holder);
        this.typeName = typeName;
    }

    //////////////////////////////////////
    //***    Multiblock LifeCycle    ***//
    //////////////////////////////////////

    @Override
    public void onStructureFormed() {
        super.onStructureFormed();
        var type = getMultiblockState().getMatchContext().get(typeName);
        if (type instanceof ITierType data) {
            this.tierType = data;
        }
    }

    @Override
    public void onStructureInvalid() {
        super.onStructureInvalid();
        this.tierType = ITierType.TierBlockType.ULV;
    }

    //////////////////////////////////////
    //***       Multiblock Data      ***//
    //////////////////////////////////////

    public int getTier() {
        return tierType.tier();
    }
}
