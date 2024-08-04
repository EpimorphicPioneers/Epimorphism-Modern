package com.epimorphismmc.epimorphism.common.machine.multiblock.part;

import com.epimorphismmc.monomorphism.recipe.MORecipeHelper;
import com.epimorphismmc.monomorphism.utility.MOFormattingUtils;
import com.epimorphismmc.monomorphism.math.MOMath;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.gui.GuiTextures;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.TickableSubscription;
import com.gregtechceu.gtceu.api.machine.multiblock.part.TieredIOPartMachine;
import com.gregtechceu.gtceu.api.machine.trait.NotifiableFluidTank;
import com.gregtechceu.gtceu.api.recipe.RecipeHelper;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import com.gregtechceu.gtceu.common.recipe.DimensionCondition;
import com.gregtechceu.gtceu.data.recipe.builder.GTRecipeBuilder;

import com.gregtechceu.gtceu.utils.GTMath;
import com.lowdragmc.lowdraglib.gui.editor.ColorPattern;
import com.lowdragmc.lowdraglib.gui.widget.*;
import com.lowdragmc.lowdraglib.side.fluid.FluidHelper;
import com.lowdragmc.lowdraglib.side.fluid.FluidStack;
import com.lowdragmc.lowdraglib.syncdata.ISubscription;
import com.lowdragmc.lowdraglib.syncdata.annotation.DescSynced;
import com.lowdragmc.lowdraglib.syncdata.annotation.Persisted;
import com.lowdragmc.lowdraglib.syncdata.field.ManagedFieldHolder;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.TickTask;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class IntakeHatchPartMachine extends TieredIOPartMachine {

    protected static final ManagedFieldHolder MANAGED_FIELD_HOLDER = new ManagedFieldHolder(
            IntakeHatchPartMachine.class, TieredIOPartMachine.MANAGED_FIELD_HOLDER);

    protected static final Map<ResourceLocation, Fluid> AIR_MAP = new HashMap<>();

    @Nullable protected TickableSubscription intakeSubs;

    @Nullable protected ISubscription tankSubs;

    @Persisted
    public final NotifiableFluidTank tank;

    @DescSynced
    @Persisted
    public boolean isWorking;

    public IntakeHatchPartMachine(IMachineBlockEntity holder, int tier) {
        super(holder, tier, IO.IN);
        this.tank = createTank();
        this.tankSubs = tank.addChangedListener(this::updateTankSubscription);
    }

    //////////////////////////////////////
    // *****     Initialization    ******//
    //////////////////////////////////////

    public static void initMap(GTRecipeBuilder recipeBuilder) {
        for (var condition : recipeBuilder.conditions) {
            if (condition instanceof DimensionCondition dimensionCondition) {
                var dim = dimensionCondition.getDimension();
                var fluids = RecipeHelper.getOutputFluids(recipeBuilder);
                if (!fluids.isEmpty()) {
                    AIR_MAP.put(dim, fluids.get(0).getFluid());
                    break;
                }
            }
        }
    }

    protected NotifiableFluidTank createTank(Object... args) {
        return new NotifiableFluidTank(this, 1, getTankCapacity(getTier()), io, IO.NONE);
    }

    public static long getTankCapacity(int tier) {
        return 8 * FluidHelper.getBucket() * (1L << Math.min(9, tier));
    }

    @Override
    public void onLoad() {
        super.onLoad();
        if (getLevel() instanceof ServerLevel serverLevel) {
            serverLevel.getServer().tell(new TickTask(0, this::updateTankSubscription));
        }
    }

    @Override
    public void onUnload() {
        super.onUnload();
        if (tankSubs != null) {
            tankSubs.unsubscribe();
            tankSubs = null;
        }
    }

    @Override
    public void onNeighborChanged(Block block, BlockPos fromPos, boolean isMoving) {
        super.onNeighborChanged(block, fromPos, isMoving);
        if (getPos().relative(getFrontFacing()).equals(fromPos)) {
            updateTankSubscription();
        }
    }

    protected boolean isFrontFaceFree() {
        var frontPos = self().getPos().relative(self().getFrontFacing());
        return self().getLevel().getBlockState(frontPos).isAir();
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void clientTick() {
        super.clientTick();
        if (isWorking && getOffsetTimer() % 2 == 0) {
            var facing = this.getFrontFacing();
            int stepX = facing.getStepX();
            int stepY = facing.getStepY();
            int stepZ = facing.getStepZ();
            double offset = 2 * GTValues.RNG.nextDouble() + 2;
            var pos = this.getPos().getCenter().add(stepX * 0.5, stepY * 0.5, stepZ * 0.5);
            var center = pos.add(stepX * offset, stepY * offset, stepZ * offset);
            var point = MOMath.randomCirclePoint(1.5F);
            var randPos = center.add(
                    stepY * point.y + stepZ * point.x,
                    stepX * point.x + stepZ * point.y,
                    stepX * point.y + stepY * point.x);
            var speed = pos.subtract(randPos).scale(0.055);
            getLevel()
                    .addParticle(
                            ParticleTypes.CLOUD, randPos.x, randPos.y, randPos.z, speed.x, speed.y, speed.z);
        }
    }

    //////////////////////////////////////
    // ******    Product Water    *******//
    //////////////////////////////////////

    protected void updateTankSubscription() {
        if (isWorkingEnabled() && isFrontFaceFree()) {
            intakeSubs = subscribeServerTick(intakeSubs, this::intake);
            this.isWorking = true;
        } else unsubscribe();
    }

    protected void intake() {
        var fluid = AIR_MAP.getOrDefault(getLevel().dimension().location(), GTMaterials.Air.getFluid());
        boolean isFilled =
                tank.fillInternal(FluidStack.create(fluid, getIntakeAmount(getTier())), false) == 0;
        if (isFilled) unsubscribe();
        else updateTankSubscription();
    }

    public static long getIntakeAmount(int tier) {
        return FluidHelper.getBucket() * (1L << GTMath.clamp(tier - 5, 0, 9));
    }

    private void unsubscribe() {
        if (intakeSubs != null) {
            intakeSubs.unsubscribe();
            intakeSubs = null;
            this.isWorking = false;
        }
    }

    //////////////////////////////////////
    // **********     GUI     ***********//
    //////////////////////////////////////

    @Override
    public Widget createUIWidget() {
        var group = new WidgetGroup(0, 0, 89, 63);

        group
                .addWidget(new ImageWidget(4, 4, 81, 55, GuiTextures.DISPLAY))
                .addWidget(new LabelWidget(8, 8, "gtceu.gui.fluid_amount"))
                .addWidget(new LabelWidget(
                                8,
                                18,
                                () -> MOFormattingUtils.abbreviate2F(tank.getFluidInTank(0).getAmount()) + " mB")
                        .setTextColor(-1)
                        .setDropShadow(true))
                .addWidget(new LabelWidget(
                                8, 28, () -> isFrontFaceFree() ? " " : "gui.epimorphism.intake_obstructed")
                        .setTextColor(ColorPattern.RED.color))
                .addWidget(new TankWidget(tank.getStorages()[0], 67, 22, false, false)
                        .setBackground(GuiTextures.FLUID_SLOT));

        group.setBackground(GuiTextures.BACKGROUND_INVERSE);
        return group;
    }

    //////////////////////////////////////
    // **********     Data     **********//
    //////////////////////////////////////

    @Override
    public void setWorkingEnabled(boolean workingEnabled) {
        super.setWorkingEnabled(workingEnabled);
        updateTankSubscription();
    }

    @Override
    public ManagedFieldHolder getFieldHolder() {
        return MANAGED_FIELD_HOLDER;
    }
}
