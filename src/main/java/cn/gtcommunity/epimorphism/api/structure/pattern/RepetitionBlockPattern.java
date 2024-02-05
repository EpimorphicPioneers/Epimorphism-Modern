package cn.gtcommunity.epimorphism.api.structure.pattern;

import com.gregtechceu.gtceu.api.pattern.BlockPattern;
import com.gregtechceu.gtceu.api.pattern.MultiblockState;
import com.gregtechceu.gtceu.api.pattern.TraceabilityPredicate;
import com.gregtechceu.gtceu.api.pattern.util.RelativeDirection;
import com.lowdragmc.lowdraglib.utils.BlockInfo;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.player.Player;

public class RepetitionBlockPattern extends BlockPattern {

    public RepetitionBlockPattern(TraceabilityPredicate[][][] predicatesIn, RelativeDirection[] structureDir, int[][] aisleRepetitions, int[] centerOffset) {
        super(predicatesIn, structureDir, aisleRepetitions, centerOffset);
    }

    @Override
    public boolean checkPatternAt(MultiblockState worldState, boolean savePredicate) {
        return super.checkPatternAt(worldState, savePredicate);
    }

    @Override
    public boolean checkPatternAt(MultiblockState worldState, BlockPos centerPos, Direction facing, boolean savePredicate) {
        return super.checkPatternAt(worldState, centerPos, facing, savePredicate);
    }

    @Override
    public void autoBuild(Player player, MultiblockState worldState) {
        super.autoBuild(player, worldState);
    }

    @Override
    public BlockInfo[][][] getPreview(int[] repetition) {
        return super.getPreview(repetition);
    }
}
