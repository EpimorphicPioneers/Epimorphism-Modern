package com.epimorphismmc.epimorphism.api.pattern;

import com.epimorphismmc.epimorphism.api.machine.multiblock.EPPartAbility;
import com.epimorphismmc.epimorphism.api.pattern.utils.FluidTankCellContainer;
import com.epimorphismmc.epimorphism.api.pattern.utils.StorageFieldBlockContainer;
import com.epimorphismmc.epimorphism.common.block.BlockMaps;

import com.epimorphismmc.monomorphism.pattern.predicates.TierPredicateFactory;

import com.gregtechceu.gtceu.api.machine.MetaMachine;
import com.gregtechceu.gtceu.api.machine.feature.ITieredMachine;
import com.gregtechceu.gtceu.api.pattern.MultiblockState;
import com.gregtechceu.gtceu.api.pattern.TraceabilityPredicate;
import com.gregtechceu.gtceu.api.pattern.predicates.PredicateBlocks;

import net.minecraft.network.chat.Component;
import net.minecraft.world.level.block.Block;

public class EPPredicates {

    // Glasses
    public static TraceabilityPredicate glass() {
        return TierPredicateFactory.create("Glass")
                .map(BlockMaps.ALL_GLASSES)
                .candidatesMap(BlockMaps.SHAPE_GLASSES)
                .errorKey(Component.translatable("epimorphism.multiblock.pattern.error.glasses"))
                .strict(true)
                .build();
    }

    // Yotta Fluid Tank
    public static TraceabilityPredicate fluidTankCell() {
        return TierPredicateFactory.create("FluidTankCell")
                .map(BlockMaps.ALL_FLUID_CELLS)
                .container(FluidTankCellContainer::new)
                .build();
    }

    // TFFT
    public static TraceabilityPredicate storageFieldBlock() {
        return TierPredicateFactory.create("StorageFieldBlock")
                .map(BlockMaps.ALL_FIELD_BLOCKS)
                .container(StorageFieldBlockContainer::new)
                .build();
    }

    // Component Assembly Line
    public static TraceabilityPredicate componentAssemblyBlock() {
        return TierPredicateFactory.create("CACasing")
                .map(BlockMaps.ALL_CA_TIRED_CASINGS)
                .strict(true)
                .build();
    }

    // Chemical Plant
    public static TraceabilityPredicate CPCasingBlock() {
        return TierPredicateFactory.create("CPCasing")
                .map(BlockMaps.ALL_CP_CASINGS)
                .strict(true)
                .build();
    }

    public static TraceabilityPredicate CPPipeBlock() {
        return TierPredicateFactory.create("CPPipe")
                .map(BlockMaps.ALL_CP_TUBES)
                .strict(true)
                .build();
    }

    // Precise Assembler
    public static TraceabilityPredicate PACasingBlock() {
        return TierPredicateFactory.create("PACasing")
                .map(BlockMaps.ALL_PA_CASINGS)
                .strict(true)
                .build();
    }

    // Solar Tower
    //    public static TraceabilityPredicate mirrorBlock(int tier) {
    //        return tierOptionalPredicate("Mirror", tier,
    // Predicates.blocks(EPBlocks.TFFT_CASING.get()));
    //    }

    // Industrial Drill
    public static TraceabilityPredicate bedrockPredicate() {
        return new TraceabilityPredicate(
                state -> {
                    state.getMatchContext().set("Bedrock", state.getPos());
                    return true;
                },
                null);
    }

    // Eye of Harmony
    public static TraceabilityPredicate SCFieldGenerator() {
        return TierPredicateFactory.create("SCFieldGenerator")
                .map(BlockMaps.SC_FIELD_GENERATORS)
                .strict(true)
                .build();
    }

    public static TraceabilityPredicate STFieldGenerator() {
        return TierPredicateFactory.create("STFieldGenerator")
                .map(BlockMaps.ST_FIELD_GENERATORS)
                .strict(true)
                .build();
    }

    public static TraceabilityPredicate TAFieldGenerator() {
        return TierPredicateFactory.create("TAFieldGenerator")
                .map(BlockMaps.TA_FIELD_GENERATORS)
                .strict(true)
                .build();
    }

    public static TraceabilityPredicate tierReinforcedRotorBlock() {
        return new TraceabilityPredicate(
                new PredicateBlocks(
                        EPPartAbility.REINFORCED_ROTOR_HOLDER.getAllBlocks().toArray(Block[]::new)) {
                    @Override
                    public boolean test(MultiblockState blockWorldState) {
                        if (super.test(blockWorldState)) {
                            var level = blockWorldState.getWorld();
                            var pos = blockWorldState.getPos();
                            var machine = MetaMachine.getMachine(level, pos);
                            if (machine instanceof ITieredMachine tieredMachine) {
                                int tier = blockWorldState
                                        .getMatchContext()
                                        .getOrPut("ReinforcedRotor", tieredMachine.getTier());
                                if (tier != tieredMachine.getTier()) {
                                    return false;
                                }
                                return level
                                        .getBlockState(pos.relative(machine.getFrontFacing()))
                                        .isAir();
                            }
                        }
                        return false;
                    }
                });
    }

    // Univer

    public static TraceabilityPredicate fireboxBlock() {
        return TierPredicateFactory.create("Firebox")
                .map(BlockMaps.ALL_FIREBOXS)
                .strict(true)
                .build();
    }
}
