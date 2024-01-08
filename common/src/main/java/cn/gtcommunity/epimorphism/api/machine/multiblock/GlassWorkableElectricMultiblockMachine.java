package cn.gtcommunity.epimorphism.api.machine.multiblock;

import cn.gtcommunity.epimorphism.api.block.ITierGlassType;
import cn.gtcommunity.epimorphism.utils.EPUniverUtil;
import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableElectricMultiblockMachine;
import lombok.Getter;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class GlassWorkableElectricMultiblockMachine extends WorkableElectricMultiblockMachine {
    @Getter
    private int glassTier;

    public GlassWorkableElectricMultiblockMachine(IMachineBlockEntity holder, Object... args) {
        super(holder, args);
    }

    //////////////////////////////////////
    //***    Multiblock LifeCycle    ***//
    //////////////////////////////////////

    @Override
    public void onStructureFormed() {
        super.onStructureFormed();
        var type = getMultiblockState().getMatchContext().get("Glass");
        this.glassTier = EPUniverUtil.getOrDefault(() -> type instanceof ITierGlassType,
                () -> ((ITierGlassType)type).tier(), 0);
    }

    @Override
    public void onStructureInvalid() {
        super.onStructureInvalid();
        this.glassTier = 0;
    }

    //////////////////////////////////////
    //***        Multiblock UI       ***//
    //////////////////////////////////////

    @Override
    public void addDisplayText(@NotNull List<Component> textList) {
        super.addDisplayText(textList);
        if (this.isFormed() && glassTier > 0) {
            String tierName = GTValues.VNF[glassTier];
            textList.add(0, Component.translatable("epimorphism.machine.multiblock.glass_tier", glassTier, tierName));
        }
    }
}
