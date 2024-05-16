package cn.gtcommunity.epimorphism.common.machine.generator;

import cn.gtcommunity.epimorphism.Epimorphism;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.MetaMachine;
import com.gregtechceu.gtceu.api.machine.feature.IMachineLife;
import com.gregtechceu.gtceu.api.machine.feature.IUIMachine;
import com.gregtechceu.gtceu.api.machine.trait.MachineTrait;
import com.lowdragmc.lowdraglib.gui.modular.ModularUI;
import java.util.Collections;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.Nullable;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class ReactorChamberMachine extends MetaMachine implements IUIMachine, IMachineLife {
    private NuclearReactorMachine nuclearReactor;

    public ReactorChamberMachine(IMachineBlockEntity holder) {
        super(holder);
    }

    @Override
    public void onMachinePlaced(@Nullable LivingEntity player, ItemStack stack) {
        IMachineLife.super.onMachinePlaced(player, stack);
        BlockPos pos = this.getPos();
        if (this.getLevel() instanceof ServerLevel serverLevel) {
            BlockPos[] neighbours = new BlockPos[]{pos.above(), pos.below(), pos.east(), pos.south(), pos.west(), pos.north()};
            for (BlockPos neighbour : neighbours) {
                if (getMachine(serverLevel, neighbour) instanceof NuclearReactorMachine) {
                    return;
                }
            }
            serverLevel.destroyBlock(this.getPos(), true);
        }
    }

    @Override
    public List<MachineTrait> getTraits() {
        return this.nuclearReactor == null ? Collections.emptyList() : this.nuclearReactor.getTraits();
    }

    @Override
    public MetaMachine self() {
        return this.nuclearReactor != null ? this.nuclearReactor.self() : super.self();
    }

    @Override
    public boolean shouldOpenUI(Player player, InteractionHand hand, BlockHitResult hit) {
        return this.nuclearReactor != null && IUIMachine.super.shouldOpenUI(player, hand, hit);
    }

    @Override
    public @Nullable ModularUI createUI(Player entityPlayer) {
        Epimorphism.logger().warn("'createUI' of the Reactor Chamber was incorrectly called!");
        return null;
    }

    public boolean setNuclearReactor(@Nullable NuclearReactorMachine nuclearReactor) {
        if (nuclearReactor == null) {
            this.nuclearReactor = null;
            if (this.getLevel() instanceof ServerLevel serverLevel) {
                serverLevel.destroyBlock(this.getPos(), true);
            }
            return true;
        } else {
            if (this.nuclearReactor == null) {
                this.nuclearReactor = nuclearReactor;
                return true;
            }

            if (this.nuclearReactor == nuclearReactor) {
                return true;
            }

            if (this.getLevel() instanceof ServerLevel serverLevel) {
                serverLevel.destroyBlock(this.getPos(), true);
            }
            return false;
        }

    }
}
