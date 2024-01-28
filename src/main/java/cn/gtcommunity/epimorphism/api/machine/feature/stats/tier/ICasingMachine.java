package cn.gtcommunity.epimorphism.api.machine.feature.stats.tier;

import cn.gtcommunity.epimorphism.api.machine.trait.MultiblockStats;
import cn.gtcommunity.epimorphism.api.structure.block.tier.ITierType;
import com.gregtechceu.gtceu.api.machine.MetaMachine;
import com.gregtechceu.gtceu.api.pattern.MultiblockState;
import com.lowdragmc.lowdraglib.syncdata.field.ManagedFieldHolder;
import lombok.Getter;

public interface ICasingMachine {
    ITierType getTierType();

    int getCasingTier();

    class CasingTierStats extends MultiblockStats implements ICasingMachine {
        protected static final ManagedFieldHolder MANAGED_FIELD_HOLDER = new ManagedFieldHolder(CasingTierStats.class, MultiblockStats.MANAGED_FIELD_HOLDER);
        @Getter
        private ITierType tierType = ITierType.TierBlockType.ULV;
        private final String typeName;

        public CasingTierStats(MetaMachine machine, String typeName) {
            super(machine);
            this.typeName = typeName;
        }

        @Override
        public void onStructureFormed(MultiblockState state) {
            var type = state.getMatchContext().get(typeName);
            if (type instanceof ITierType data) {
                this.tierType = data;
            }
        }

        @Override
        public void onStructureInvalid() {
            this.tierType = ITierType.TierBlockType.ULV;
        }

        @Override
        public int getCasingTier() {
            return tierType.tier();
        }

        @Override
        public ManagedFieldHolder getFieldHolder() {
            return MANAGED_FIELD_HOLDER;
        }
    }
}
