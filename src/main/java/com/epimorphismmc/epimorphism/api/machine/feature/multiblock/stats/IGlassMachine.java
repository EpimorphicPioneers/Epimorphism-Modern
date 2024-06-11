package com.epimorphismmc.epimorphism.api.machine.feature.multiblock.stats;

import com.epimorphismmc.epimorphism.api.block.tier.ITierGlassType;

import com.epimorphismmc.monomorphism.machine.trait.MultiblockStats;
import com.epimorphismmc.monomorphism.utility.MOUtils;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.machine.feature.IMachineFeature;
import com.gregtechceu.gtceu.api.pattern.MultiblockState;

import com.lowdragmc.lowdraglib.syncdata.field.ManagedFieldHolder;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.network.chat.Component;

import lombok.Getter;
import org.jetbrains.annotations.NotNull;

import java.util.List;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public interface IGlassMachine extends IMachineFeature {
    int getGlassTier();

    class GlassTierStats extends MultiblockStats implements IGlassMachine {
        protected static final ManagedFieldHolder MANAGED_FIELD_HOLDER =
                new ManagedFieldHolder(GlassTierStats.class, MultiblockStats.MANAGED_FIELD_HOLDER);

        @Getter
        private int glassTier;

        public GlassTierStats(
                com.epimorphismmc.monomorphism.machine.multiblock.MultiStatsElectricMultiblockMachine
                        machine) {
            super(machine);
            machine.addStats(this);
        }

        @Override
        public void onStructureFormed(MultiblockState state) {
            var type = state.getMatchContext().get("Glass");
            this.glassTier = MOUtils.getOrDefault(
                    () -> type instanceof ITierGlassType, () -> ((ITierGlassType) type).tier(), 0);
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
                textList.add(
                        0,
                        Component.translatable(
                                "epimorphism.machine.multiblock.glass_tier", glassTier, tierName));
            }
        }

        @Override
        public ManagedFieldHolder getFieldHolder() {
            return MANAGED_FIELD_HOLDER;
        }
    }
}
