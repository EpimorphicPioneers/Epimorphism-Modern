package cn.gtcommunity.epimorphism.api.machine.feature.multiblock.stats.tier;

import cn.gtcommunity.epimorphism.api.block.tier.ITierGlassType;
import cn.gtcommunity.epimorphism.api.machine.multiblock.MultiStatsElectricMultiblockMachine;
import cn.gtcommunity.epimorphism.api.machine.trait.MultiblockStats;
import cn.gtcommunity.epimorphism.utils.EPUtil;
import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.machine.feature.IMachineFeature;
import com.gregtechceu.gtceu.api.pattern.MultiblockState;
import com.lowdragmc.lowdraglib.syncdata.field.ManagedFieldHolder;
import lombok.Getter;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public interface IGlassMachine extends IMachineFeature {
    int getGlassTier();

    class GlassTierStats extends MultiblockStats implements IGlassMachine {
        protected static final ManagedFieldHolder MANAGED_FIELD_HOLDER = new ManagedFieldHolder(GlassTierStats.class, MultiblockStats.MANAGED_FIELD_HOLDER);
        @Getter
        private int glassTier;

        public GlassTierStats(MultiStatsElectricMultiblockMachine machine) {
            super(machine);
            machine.addStats(this);
        }

        @Override
        public void onStructureFormed(MultiblockState state) {
            var type = state.getMatchContext().get("Glass");
            this.glassTier = EPUtil.getOrDefault(() -> type instanceof ITierGlassType,
                    () -> ((ITierGlassType)type).tier(), 0);
        }

        @Override
        public void onStructureInvalid() {
            super.onStructureInvalid();
            this.glassTier = 0;
        }

        @Override
        public void addDisplayText(@NotNull List<Component> textList) {
            var multiblock = getMultiblock();
            if (multiblock == null || !multiblock.isFormed()) return;

            if (glassTier > 0) {
                String tierName = GTValues.VNF[glassTier];
                textList.add(0, Component.translatable("epimorphism.machine.multiblock.glass_tier", glassTier, tierName));
            }
        }

        @Override
        public ManagedFieldHolder getFieldHolder() {
            return MANAGED_FIELD_HOLDER;
        }
    }
}
