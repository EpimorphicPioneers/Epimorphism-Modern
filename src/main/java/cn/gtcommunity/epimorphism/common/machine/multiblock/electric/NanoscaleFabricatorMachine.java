package cn.gtcommunity.epimorphism.common.machine.multiblock.electric;

import cn.gtcommunity.epimorphism.common.block.CrucibleBlock;
import cn.gtcommunity.epimorphism.common.data.EPBlocks;
import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.feature.multiblock.IMultiPart;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableElectricMultiblockMachine;
import com.gregtechceu.gtceu.api.pattern.TraceabilityPredicate;
import com.gregtechceu.gtceu.api.pattern.util.PatternMatchContext;
import com.gregtechceu.gtceu.common.machine.multiblock.part.ItemBusPartMachine;
import com.gregtechceu.gtceu.utils.FormattingUtil;
import com.lowdragmc.lowdraglib.utils.BlockInfo;
import com.tterrag.registrate.util.entry.BlockEntry;
import lombok.Getter;
import net.minecraft.ChatFormatting;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Comparator;
import java.util.List;

import static com.gregtechceu.gtceu.common.data.GCyMBlocks.*;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class NanoscaleFabricatorMachine extends WorkableElectricMultiblockMachine {

    @Getter
    private int heatCapacity;

    public NanoscaleFabricatorMachine(IMachineBlockEntity holder, Object... args) {
        super(holder, args);
    }

    //////////////////////////////////////
    //***    Multiblock LifeCycle    ***//
    //////////////////////////////////////

    @Override
    public void onStructureFormed() {
        super.onStructureFormed();
        var context = getMultiblockState().getMatchContext();
        int crucibleAmount = context.getInt("CrucibleAmount");
        if (crucibleAmount != 0) this.heatCapacity = context.getInt("HeatCapacity") / crucibleAmount;
        else this.heatCapacity = 0;
    }

    @Override
    public void onStructureInvalid() {
        super.onStructureInvalid();
        this.heatCapacity = 0;
    }

    //////////////////////////////////////
    //***    Multiblock Structure    ***//
    //////////////////////////////////////
    public static TraceabilityPredicate cruciblePredicate() {
        return new TraceabilityPredicate(blockWorldState -> {
            Block block = blockWorldState.getBlockState().getBlock();
            if (block instanceof CrucibleBlock crucible) {
                PatternMatchContext context = blockWorldState.getMatchContext();
                context.increment("HeatCapacity", crucible.getHeatCapacity());
                context.increment("CrucibleAmount", 1);
                return true;
            }
            return false;
        }, () -> EPBlocks.CRUCIBLE_BLOCKS.values().stream()
                .map(BlockEntry::get)
                .sorted(Comparator.comparingInt(CrucibleBlock::getHeatCapacity))
                .map(BlockInfo::fromBlock)
                .toArray(BlockInfo[]::new));
    }

    @Nullable
    @Override
    public BlockState getPartAppearance(IMultiPart part, Direction side, BlockState sourceState, BlockPos sourcePos) {
        if (part instanceof ItemBusPartMachine bus && bus.getInventory().getHandlerIO() == IO.IN) {
            return CASING_NONCONDUCTING.getDefaultState();
        }
        return CASING_LASER_SAFE_ENGRAVING.getDefaultState();
    }

    //////////////////////////////////////
    //***        Multiblock UI       ***//
    //////////////////////////////////////

    @Override
    public void addDisplayText(List<Component> textList) {
        super.addDisplayText(textList);
        if (isFormed()) {
            textList.add(Component.translatable("gtceu.multiblock.blast_furnace.max_temperature", ChatFormatting.RED + FormattingUtil.formatNumbers(heatCapacity) + "K"));
        }
    }

    //////////////////////////////////////
    //***      Multiblock Render     ***//
    //////////////////////////////////////

    public static ResourceLocation getBaseTexture(IMultiPart iMultiPart) {
        if (iMultiPart instanceof ItemBusPartMachine bus && bus.getInventory().getHandlerIO() == IO.IN) {
            return GTCEu.id("block/casings/gcym/nonconducting_casing");
        }
        return GTCEu.id("block/casings/gcym/laser_safe_engraving_casing");
    }
}
