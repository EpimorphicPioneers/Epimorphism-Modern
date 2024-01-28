package cn.gtcommunity.epimorphism.api.machine.feature.stats.tier;

import cn.gtcommunity.epimorphism.api.machine.trait.MultiblockStats;
import com.gregtechceu.gtceu.api.block.ICoilType;
import com.gregtechceu.gtceu.api.machine.MetaMachine;
import com.gregtechceu.gtceu.api.pattern.MultiblockState;
import com.gregtechceu.gtceu.common.block.CoilBlock;
import com.lowdragmc.lowdraglib.syncdata.field.ManagedFieldHolder;
import lombok.Getter;

public interface ICoilMachine {
    int getCoilTier();

    class CoilTierStats extends MultiblockStats implements ICoilMachine {

        protected static final ManagedFieldHolder MANAGED_FIELD_HOLDER = new ManagedFieldHolder(CoilTierStats.class, MultiblockStats.MANAGED_FIELD_HOLDER);

        @Getter
        private ICoilType coilType  = CoilBlock.CoilType.CUPRONICKEL;

        public CoilTierStats(MetaMachine machine) {
            super(machine);
        }

        @Override
        public void onStructureFormed(MultiblockState state) {
            var type = state.getMatchContext().get("CoilType");
            if (type instanceof ICoilType coil) {
                this.coilType = coil;
            }
        }

        @Override
        public void onStructureInvalid() {
            this.coilType = CoilBlock.CoilType.CUPRONICKEL;
        }

        @Override
        public int getCoilTier() {
            return coilType.getTier();
        }

        @Override
        public ManagedFieldHolder getFieldHolder() {
            return MANAGED_FIELD_HOLDER;
        }
    }
}
