package com.epimorphismmc.epimorphism.common.machine.trait;

import com.epimorphismmc.epimorphism.common.data.EPTags;
import com.epimorphismmc.epimorphism.common.machine.multiblock.electric.ConcreteBackfillerMachine;
import com.gregtechceu.gtceu.api.data.worldgen.generator.indicators.SurfaceIndicatorGenerator;
import com.gregtechceu.gtceu.api.machine.trait.RecipeLogic;
import com.gregtechceu.gtceu.common.block.SurfaceRockBlock;
import com.gregtechceu.gtceu.common.data.GTBlocks;
import com.lowdragmc.lowdraglib.syncdata.annotation.Persisted;
import com.lowdragmc.lowdraglib.syncdata.field.ManagedFieldHolder;
import lombok.Getter;
import lombok.Setter;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

import java.util.LinkedList;
import java.util.Objects;

public class ConcreteBackfillerLogic extends RecipeLogic {

    public static final ManagedFieldHolder MANAGED_FIELD_HOLDER = new ManagedFieldHolder(ConcreteBackfillerLogic.class, RecipeLogic.MANAGED_FIELD_HOLDER);

    private static final short MAX_SPEED = Short.MAX_VALUE;
    private static final byte POWER = 5;
    private static final byte TICK_TOLERANCE = 20;
    private static final double DIVIDEND = MAX_SPEED * Math.pow(TICK_TOLERANCE, POWER);

    private final ConcreteBackfillerMachine filler;

    @Getter
    private final int speed;
    @Getter
    private final int maximumRadius;
    @Setter
    @Getter
    private int voltageTier;
    @Getter
    @Setter
    private int overclockAmount = 0;
    private final LinkedList<BlockPos> posesToFill = new LinkedList<>();
    @Getter
    private int minBuildHeight = Integer.MAX_VALUE;

    @Getter
    @Setter
    @Persisted
    private int currentRadius;

    // current fill xyz
    @Getter
    @Persisted
    protected int x = Integer.MAX_VALUE;
    @Getter
    @Persisted
    protected int y = Integer.MAX_VALUE;
    @Getter
    @Persisted
    protected int z = Integer.MAX_VALUE;

    // start xyz
    @Getter
    @Persisted
    protected int startX = Integer.MAX_VALUE;
    @Getter
    @Persisted
    protected int startY = Integer.MAX_VALUE;
    @Getter
    @Persisted
    protected int startZ = Integer.MAX_VALUE;

    // last fill xyz
    @Getter
    @Persisted
    protected int fillX = Integer.MAX_VALUE;
    @Getter
    @Persisted
    protected int fillZ = Integer.MAX_VALUE;
    @Getter
    @Persisted
    protected int fillY = Integer.MAX_VALUE;

    @Getter
    @Persisted
    private boolean isDone;

    public ConcreteBackfillerLogic(ConcreteBackfillerMachine machine, int speed, int maximumRadius) {
        super(machine);
        this.filler = machine;
        this.speed = speed;
        this.duration = speed;
        this.maximumRadius = maximumRadius;
        this.currentRadius = maximumRadius;
        this.isDone = false;
    }

    @Override
    public ManagedFieldHolder getFieldHolder() {
        return MANAGED_FIELD_HOLDER;
    }

    @Override
    public void resetRecipeLogic() {
        super.resetRecipeLogic();
        duration = speed;
        resetArea();
    }

    @Override
    public void serverTick() {
        // main logic
        if (!isSuspend() && filler.getLevel() instanceof ServerLevel level && checkCanFill()) {
            // checkCanFill already check energy, needn't simulate
            filler.drainEnergy(false);
            setStatus(Status.WORKING);

            checkPosToFill();

            if (progress >= duration && !posesToFill.isEmpty()) {
                for (int i = 0; i < getOverclockAmount(); i++) {
                    if (posesToFill.isEmpty()) {
                        break;
                    }
                    BlockPos pos = posesToFill.getFirst();
                    BlockState blockState = level.getBlockState(pos);
                    // check make sure here still can fill
                    while (!checkStateCanFill(blockState)) {
                        posesToFill.removeFirst();
                        if (posesToFill.isEmpty()) {
                            break;
                        }
                        pos = posesToFill.getFirst();
                        blockState = level.getBlockState(pos);
                    }

                    // has place to fill
                    if (checkStateCanFill(blockState)) {
                        fillAndDrainFluid(pos, level);
                        posesToFill.removeFirst();
                    }
                }
                progress = 0;
            }
            progress++;
            totalContinuousRunningTime++;

            if (posesToFill.isEmpty()) {
                x = fillX;
                y = fillY;
                z = fillZ;

                posesToFill.addAll(getPosesToFill());
                if (posesToFill.isEmpty()) {
                    isDone = true;
                    setStatus(Status.IDLE);
                }
            }
        } else {
            // machine isn't working enabled
            this.setStatus(Status.IDLE);
            if (subscription != null) {
                subscription.unsubscribe();
                subscription = null;
            }
        }
    }

    private void fillAndDrainFluid(BlockPos pos, ServerLevel level) {
        filler.drainFluid(1, false);
        level.setBlockAndUpdate(pos, GTBlocks.LIGHT_CONCRETE.getDefaultState());
        fillX = pos.getX();
        fillY = pos.getY();
        fillZ = pos.getZ();
    }

    public void initPos(@NotNull BlockPos pos, int currentRadius) {
        if (this.minBuildHeight == Integer.MAX_VALUE) {
            this.minBuildHeight = this.getMachine().getLevel().getMinBuildHeight();
        }
        x = pos.getX() - currentRadius;
        y = minBuildHeight;
        z = pos.getZ() - currentRadius;
        fillX = x;
        fillY = y;
        fillZ = z;
        startX = x;
        startY = y;
        startZ = z;
        posesToFill.clear();
    }

    public BlockPos getCenterPos() {
        return filler.getPos().relative(filler.getFrontFacing().getOpposite());
    }

    private void checkPosToFill() {
        if (posesToFill.isEmpty()) {
            posesToFill.addAll(getPosesToFill());
        }
    }

    private static boolean checkStateCanFill(BlockState state) {
        return state.isAir() || state.canBeReplaced() || state.is(EPTags.Blocks.FILLER_REPLACEABLE) || state.getBlock() instanceof SurfaceRockBlock;
    }

    private LinkedList<BlockPos> getPosesToFill() {
        LinkedList<BlockPos> poses = new LinkedList<>();

        double quotient = getQuotient(getMeanTickTime(getMachine().getLevel()));
        int calcAmount = quotient < 1 ? 1 : (int) (Math.min(quotient, Short.MAX_VALUE));

        int calculated = 0;
        while (calculated < calcAmount) {
            if (y < getCenterPos().getY() - 1) {
                if (z <= startZ + currentRadius * 2) {
                    if (x <= startX + currentRadius * 2) {
                        BlockPos pos = new BlockPos(x, y, z);
                        BlockState state = filler.getLevel().getBlockState(pos);
                        if (checkStateCanFill(state)) {
                            poses.addLast(pos);
                        }
                        // move to the next x position
                        ++x;
                    } else {
                        // reset x and move to the next z layer
                        x = startX;
                        ++z;
                    }
                } else {
                    // reset z and move to the next y layer
                    z = startZ;
                    ++y;
                }
            } else {
                return poses;
            }
            if (!poses.isEmpty()) {
                calculated++;
            }
        }
        return poses;
    }

    private boolean checkCoordinatesInvalid() {
        return x == Integer.MAX_VALUE && y == Integer.MAX_VALUE && z == Integer.MAX_VALUE;
    }

    private boolean checkCanFill() {
        if (!isDone() && checkCoordinatesInvalid()) {
            initPos(getCenterPos(), currentRadius);
        }
        return !isDone && filler.drainInput(true);
    }

    public void resetArea() {
        initPos(getCenterPos(), currentRadius);
        if (this.isDone) this.setWorkingEnabled(false);
        this.isDone = false;
    }

    /**
     * @param values to find the mean of
     * @return the mean value
     */
    private static long mean(long[] values) {
        if (values.length == 0L)
            return 0L;

        long sum = 0L;
        for (long v : values)
            sum += v;
        return sum / values.length;
    }

    /**
     * @param world the {@link Level} to get the average tick time of
     * @return the mean tick time
     */
    private static double getMeanTickTime(@NotNull Level world) {
        return mean(Objects.requireNonNull(world.getServer()).tickTimes) * 1.0E-6D;
    }

    /**
     * gets the quotient for determining the amount of blocks to mine
     *
     * @param base is a value used for calculation, intended to be the mean tick time of the world the miner is in
     * @return the quotient
     */
    private static double getQuotient(double base) {
        return DIVIDEND / Math.pow(base, POWER);
    }
}
