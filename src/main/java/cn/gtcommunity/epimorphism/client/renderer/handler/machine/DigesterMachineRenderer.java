package cn.gtcommunity.epimorphism.client.renderer.handler.machine;

import cn.gtcommunity.epimorphism.Epimorphism;
import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.capability.IWorkable;
import com.gregtechceu.gtceu.api.machine.MachineDefinition;
import com.gregtechceu.gtceu.api.machine.MetaMachine;
import com.gregtechceu.gtceu.client.renderer.machine.WorkableCasingMachineRenderer;
import com.lowdragmc.lowdraglib.client.bakedpipeline.FaceQuad;
import com.lowdragmc.lowdraglib.side.fluid.FluidHelper;
import com.lowdragmc.lowdraglib.side.fluid.FluidStack;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.resources.model.ModelState;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.Nullable;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DigesterMachineRenderer extends WorkableCasingMachineRenderer {

    public static final DigesterMachineRenderer INSTANCE = new DigesterMachineRenderer();

    public static final FluidStack STACK = FluidStack.create(Fluids.WATER, 1);
    public static final Set<AABB> BLOCKS;

    static {
        Set<AABB> tSet = new HashSet<>();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                tSet.add(new AABB(-2 + i, 1, 1 + j, -1 + i, 2, 2 + j));
            }
        }
        BLOCKS = Collections.unmodifiableSet(tSet);
    }

    private DigesterMachineRenderer() {
        super(GTCEu.id("block/casings/solid/machine_casing_robust_tungstensteel"), Epimorphism.id("block/multiblock/digester"), false);
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void renderMachine(List<BakedQuad> quads, MachineDefinition definition, @Nullable MetaMachine machine, Direction frontFacing, @Nullable Direction side, RandomSource rand, @Nullable Direction modelFacing, ModelState modelState) {
        super.renderMachine(quads, definition, machine, frontFacing, side, rand, modelFacing, modelState);
        if (machine instanceof IWorkable workable && workable.isActive() && side == null) {
            BLOCKS.forEach(aabb -> quads.add(FaceQuad.bakeFace(aabb, Direction.UP, FluidHelper.getStillTexture(STACK), modelState, 2, 5, true, true)));
        }
    }
}
