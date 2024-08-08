package com.epimorphismmc.epimorphism.common.machine.trait;

import com.epimorphismmc.epimorphism.common.data.EPTags;
import com.epimorphismmc.epimorphism.common.machine.multiblock.electric.ConcreteBackfillerMachine;
import com.epimorphismmc.epimorphism.utils.EPUtil;

import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.machine.trait.RecipeLogic;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;
import com.gregtechceu.gtceu.api.recipe.RecipeHelper;
import com.gregtechceu.gtceu.api.recipe.modifier.ParallelLogic;
import com.gregtechceu.gtceu.common.block.SurfaceRockBlock;

import com.lowdragmc.lowdraglib.syncdata.annotation.Persisted;
import com.lowdragmc.lowdraglib.syncdata.field.ManagedFieldHolder;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.state.BlockState;

import lombok.Getter;
import lombok.Setter;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class ConcreteBackfillerLogic extends RecipeLogic {

    public static final ManagedFieldHolder MANAGED_FIELD_HOLDER =
            new ManagedFieldHolder(ConcreteBackfillerLogic.class, RecipeLogic.MANAGED_FIELD_HOLDER);

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

            var matches = searchRecipe();
            while (matches != null && matches.hasNext()) {
                GTRecipe match = matches.next();
                if (match == null) continue;

                int parallel = ParallelLogic.getMaxRecipeMultiplier(match, filler, getOverclockAmount());
            }

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

                // blocks may change during machine working, so let's check again
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
        var matches = searchRecipe();
        while (matches != null && matches.hasNext()) {
            GTRecipe match = matches.next();
            if (match == null) continue;

            if (match.matchRecipeContents(IO.IN, machine, match.inputs).isSuccess()) {
                if (handleRecipeIO(match, IO.IN)) {
                    var item = RecipeHelper.getOutputItems(match).get(0).getItem();
                    if (item instanceof BlockItem blockItem) {
                        level.setBlockAndUpdate(pos, blockItem.getBlock().defaultBlockState());
                        fillX = pos.getX();
                        fillY = pos.getY();
                        fillZ = pos.getZ();
                        return;
                    }
                }
            }
        }
    }

    @Override
    protected @Nullable Iterator<GTRecipe> searchRecipe() {
        if (!machine.hasProxies()) return null;
        var iterator = machine
                .getRecipeType()
                .getLookup()
                .getRecipeIterator(
                        machine,
                        recipe -> !recipe.isFuel
                                && recipe.matchRecipeContents(IO.IN, machine, recipe.inputs).isSuccess()
                                && recipe.matchRecipeContents(IO.IN, machine, recipe.tickInputs).isSuccess());

        boolean any = false;
        while (iterator.hasNext()) {
            GTRecipe recipe = iterator.next();
            if (recipe == null) continue;
            any = true;
            break;
        }
        if (any) {
            iterator.reset();
            return iterator;
        }
        return Collections.emptyIterator();
    }

    public void initPos() {
        this.initPos(getCenterPos(), currentRadius);
    }

    public void initPos(BlockPos pos, int currentRadius) {
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
        return state.isAir()
                || state.canBeReplaced()
                || state.is(EPTags.Blocks.FILLER_REPLACEABLE)
                || state.getBlock() instanceof SurfaceRockBlock;
    }

    private LinkedList<BlockPos> getPosesToFill() {
        LinkedList<BlockPos> poses = new LinkedList<>();

        double quotient = getQuotient(EPUtil.getMeanTickTime(getMachine().getLevel()));
        int calcAmount = quotient < 1 ? 1 : (int) (Math.min(quotient, Short.MAX_VALUE));

        int calculated = 0;
        while (calculated < calcAmount) {
            if (y <= getCenterPos().getY() - 1) {
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
            initPos();
        }
        return !isDone;
    }

    public void resetArea() {
        initPos();
        if (this.isDone) this.setWorkingEnabled(false);
        this.isDone = false;
    }

    /**
     * gets the quotient for determining the amount of blocks to mine
     *
     * @param base is a value used for calculation, intended to be the mean tick time of the world the filler is in
     * @return the quotient
     */
    private static double getQuotient(double base) {
        return DIVIDEND / Math.pow(base, POWER);
    }
}
