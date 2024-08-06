package com.epimorphismmc.epimorphism.common.machine.multiblock.electric;

import com.epimorphismmc.epimorphism.client.renderer.handler.machine.DigesterRenderer;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableElectricMultiblockMachine;

import com.lowdragmc.lowdraglib.side.fluid.FluidHelper;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.phys.Vec2;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.ParametersAreNonnullByDefault;

import static com.epimorphismmc.monomorphism.math.MOMath.randomRectanglePoint;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class DigesterMachine extends WorkableElectricMultiblockMachine {
    private static final int COLOR = FluidHelper.getColor(DigesterRenderer.STACK) | 0xff000000;

    public DigesterMachine(IMachineBlockEntity holder, Object... args) {
        super(holder, args);
    }

    //////////////////////////////////////
    // ***      Multiblock Render     ***//
    //////////////////////////////////////

    @Override
    @OnlyIn(Dist.CLIENT)
    public void clientTick() {
        super.clientTick();
        if (recipeLogic.isWorking()) {
            var pos = this.getPos();
            var facing = this.getFrontFacing().getOpposite();
            int stepX = facing.getStepX();
            int stepZ = facing.getStepZ();

            var randPos = randomRectanglePoint(
                    new Vec2(
                            stepX * 1.86F + pos.getX() + 0.5F + (Math.abs(stepX) - 1) * 1.26F,
                            stepZ * 1.86F + pos.getZ() + 0.5F + (Math.abs(stepZ) - 1) * 1.26F),
                    new Vec2(
                            stepX * 3.86F + pos.getX() + 0.5F - (Math.abs(stepX) - 1) * 1.26F,
                            stepZ * 3.86F + pos.getZ() + 0.5F - (Math.abs(stepZ) - 1) * 1.26F));

            float yPos = facing.getStepY() * 1.26F + pos.getY() + 0.25F;
            float ySpd = facing.getStepY() * 0.1F + 0.2F + 0.1F * GTValues.RNG.nextFloat();
            getLevel()
                    .addParticle(ParticleTypes.CAMPFIRE_COSY_SMOKE, randPos.x, yPos, randPos.y, 0, ySpd, 0);
        }
    }

    @Override
    public int tintColor(int index) {
        if (index == 2) {
            return COLOR;
        }
        return super.tintColor(index);
    }
}
