package cn.gtcommunity.epimorphism.common.machine.multiblock.storage;

import com.gregtechceu.gtceu.api.gui.GuiTextures;
import com.gregtechceu.gtceu.api.gui.fancy.IFancyUIProvider;
import com.gregtechceu.gtceu.api.gui.fancy.TooltipsPanel;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.feature.IFancyUIMachine;
import com.gregtechceu.gtceu.api.machine.feature.multiblock.IDisplayUIMachine;
import com.gregtechceu.gtceu.api.machine.feature.multiblock.IMultiPart;
import com.gregtechceu.gtceu.api.machine.multiblock.PartAbility;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableMultiblockMachine;
import com.gregtechceu.gtceu.api.pattern.BlockPattern;
import com.gregtechceu.gtceu.api.pattern.FactoryBlockPattern;
import com.gregtechceu.gtceu.api.pattern.Predicates;
import com.gregtechceu.gtceu.api.pattern.TraceabilityPredicate;
import com.gregtechceu.gtceu.common.data.GTBlocks;
import com.lowdragmc.lowdraglib.gui.modular.ModularUI;
import com.lowdragmc.lowdraglib.gui.widget.*;
import com.lowdragmc.lowdraglib.syncdata.annotation.Persisted;
import com.lowdragmc.lowdraglib.syncdata.field.ManagedFieldHolder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;
import java.util.Arrays;
import java.util.List;

import static com.gregtechceu.gtceu.api.pattern.Predicates.abilities;
import static com.gregtechceu.gtceu.api.pattern.Predicates.states;

public class AmazonWarehouseMachine extends WorkableMultiblockMachine implements IFancyUIMachine, IDisplayUIMachine {
    protected static final ManagedFieldHolder MANAGED_FIELD_HOLDER = new ManagedFieldHolder(AmazonWarehouseMachine.class, WorkableMultiblockMachine.MANAGED_FIELD_HOLDER);

    public static final int MIN = 3;
    @Persisted
    private int lDist = 0, rDist = 0, uDist = 0, dDist = 0;

    public AmazonWarehouseMachine(IMachineBlockEntity holder, Object... args) {
        super(holder, args);
    }

    //////////////////////////////////////
    //***    Multiblock LifeCycle    ***//
    //////////////////////////////////////

    @Override
    public void onStructureFormed() {
        super.onStructureFormed();
    }

    @Override
    public void onStructureInvalid() {
        super.onStructureInvalid();
    }

    public void updateStructureDimensions() {
        Level world = getLevel();
        Direction left = getFrontFacing().getCounterClockWise();
        Direction right = left.getOpposite();

        BlockPos.MutableBlockPos lPos = getPos().mutable();
        BlockPos.MutableBlockPos rPos = getPos().mutable();
        BlockPos.MutableBlockPos uPos = getPos().mutable();
        BlockPos.MutableBlockPos dPos = getPos().mutable();

        // find the distances from the controller to the plascrete blocks on one horizontal axis and the Y axis
        // repeatable aisles take care of the second horizontal axis
        int lDist = 0;
        int rDist = 0;
        int uDist = 0;
        int dDist = 0;

        for (int i = 1; i < 12; i++) {
            if (lDist == 0 && isBlockEdge(world, lPos, left)) lDist = i;
            if (rDist == 0 && isBlockEdge(world, rPos, right)) rDist = i;
            if (uDist == 0 && isBlockEdge(world, uPos, Direction.UP)) uDist = i;
            if (dDist == 0 && isBlockEdge(world, dPos, Direction.DOWN)) dDist = i;
            if (lDist != 0 && rDist != 0 && uDist != 0 && dDist != 0) break;
        }

        if (lDist + rDist != uDist + dDist || lDist + rDist + 1 < 3) {
            this.isFormed = false;
            return;
        }

        this.lDist = lDist;
        this.rDist = rDist;
        this.uDist = uDist;
        this.dDist = dDist;
    }

    /**
     * @param world     the world to check
     * @param pos       the pos to check and move
     * @param direction the direction to move
     * @return if a block is a valid wall block at pos moved in direction
     */
    public boolean isBlockEdge(@Nonnull Level world, @Nonnull BlockPos.MutableBlockPos pos, @Nonnull Direction direction) {
        return world.getBlockState(pos.move(direction)) == GTBlocks.PLASTCRETE.getDefaultState();
    }

    /**
     * @param world     the world to check
     * @param pos       the pos to check and move
     * @param direction the direction to move
     * @return if a block is a valid floor block at pos moved in direction
     */
    public boolean isBlockFloor(@Nonnull Level world, @Nonnull BlockPos.MutableBlockPos pos, @Nonnull Direction direction) {
        return isBlockEdge(world, pos, direction) || world.getBlockState(pos) == GTBlocks.CLEANROOM_GLASS.getDefaultState();
    }

//    @Nonnull
//    @Override
//    public BlockPattern getPattern() {
//        // return the default structure, even if there is no valid size found
//        // this means auto-build will still work, and prevents terminal crashes.
//        if (getLevel() != null) updateStructureDimensions();
//
//        if (this.getFrontFacing() == Direction.EAST || this.getFrontFacing() == Direction.WEST) {
//            int tmp = lDist;
//            lDist = rDist;
//            rDist = tmp;
//        }
//
//        // build each row of the structure
//        StringBuilder borderBuilder = new StringBuilder();     // BBBBB
//        StringBuilder wallBuilder = new StringBuilder();       // BXXXB
//        StringBuilder insideBuilder = new StringBuilder();     // X   X
//        StringBuilder roofBuilder = new StringBuilder();       // BFFFB
//        StringBuilder controllerBuilder = new StringBuilder(); // BFSFB
//        StringBuilder centerBuilder = new StringBuilder();     // BXKXB
//
//        // everything to the left of the controller
//        for (int i = 0; i < lDist; i++) {
//            borderBuilder.append("B");
//            if (i == 0) {
//                wallBuilder.append("B");
//                insideBuilder.append("X");
//                roofBuilder.append("B");
//                controllerBuilder.append("B");
//                centerBuilder.append("B");
//            } else {
//                insideBuilder.append(" ");
//                wallBuilder.append("X");
//                roofBuilder.append("F");
//                controllerBuilder.append("F");
//                centerBuilder.append("X");
//            }
//        }
//
//        // everything in-line with the controller
//        borderBuilder.append("B");
//        wallBuilder.append("X");
//        insideBuilder.append(" ");
//        roofBuilder.append("F");
//        controllerBuilder.append("S");
//        centerBuilder.append("K");
//
//        // everything to the right of the controller
//        for (int i = 0; i < rDist; i++) {
//            borderBuilder.append("B");
//            if (i == rDist - 1) {
//                wallBuilder.append("B");
//                insideBuilder.append("X");
//                roofBuilder.append("B");
//                controllerBuilder.append("B");
//                centerBuilder.append("B");
//            } else {
//                insideBuilder.append(" ");
//                wallBuilder.append("X");
//                roofBuilder.append("F");
//                controllerBuilder.append("F");
//                centerBuilder.append("X");
//            }
//        }
//
//        // build each slice of the structure
//        String[] wall = new String[hDist + 1]; // "BBBBB", "BXXXB", "BXXXB", "BXXXB", "BBBBB"
//        Arrays.fill(wall, wallBuilder.toString());
//        wall[0] = borderBuilder.toString();
//        wall[wall.length - 1] = borderBuilder.toString();
//
//        String[] slice = new String[hDist + 1]; // "BXXXB", "X   X", "X   X", "X   X", "BFFFB"
//        Arrays.fill(slice, insideBuilder.toString());
//        slice[0] = wallBuilder.toString();
//        slice[slice.length - 1] = roofBuilder.toString();
//
//        String[] center = Arrays.copyOf(slice, slice.length); // "BXKXB", "X   X", "X   X", "X   X", "BFSFB"
//        if (this.getFrontFacing() == Direction.NORTH || this.getFrontFacing() == Direction.SOUTH) {
//            center[0] = centerBuilder.reverse().toString();
//            center[center.length - 1] = controllerBuilder.reverse().toString();
//        } else {
//            center[0] = centerBuilder.toString();
//            center[center.length - 1] = controllerBuilder.toString();
//        }
//
//        TraceabilityPredicate wallPredicate = states(getCasingState(), getGlassState());
//        TraceabilityPredicate basePredicate = Predicates.autoAbilities(true, false, false)
//                .or(abilities(PartAbility.INPUT_ENERGY).setMinGlobalLimited(1).setMaxGlobalLimited(3));
//
//        // layer the slices one behind the next
//        return FactoryBlockPattern.start()
//                .aisle(wall)
//                .aisle(slice).setRepeatable(rDist + lDist - 1)
//                .aisle(center)
//                .where('S', Predicates.controller(Predicates.blocks(this.getDefinition().get())))
//                .where('B', states(getCasingState()).or(basePredicate))
//                .where('X', wallPredicate.or(basePredicate)
//                        .or(abilities(PartAbility.PASSTHROUGH_HATCH).setMaxGlobalLimited(30)))
//                .where('K', wallPredicate) // the block beneath the controller must only be a casing for structure dimension checks
//                .where('F', Predicates.cleanroomFilters())
//                .build();
//    }

    //////////////////////////////////////
    //***        Multiblock UI       ***//
    //////////////////////////////////////

    @Override
    public Widget createUIWidget() {
        var group = new WidgetGroup(0, 0, 170 + 8, 129 + 8);
        var container = new WidgetGroup(4, 4, 170, 129);
        container.addWidget(new DraggableScrollableWidgetGroup(4, 4, 162, 121).setBackground(getScreenTexture())
                .addWidget(new LabelWidget(4, 5, self().getBlockState().getBlock().getDescriptionId()))
                .addWidget(new ComponentPanelWidget(4, 17, this::addDisplayText)
                        .setMaxWidthLimit(150)
                        .clickHandler(this::handleDisplayClick)));
        container.setBackground(GuiTextures.BACKGROUND_INVERSE);
        group.addWidget(container);
        return group;
    }

    @Override
    public ModularUI createUI(Player entityPlayer) {
        return IFancyUIMachine.super.createUI(entityPlayer);
    }

    @Override
    public List<IFancyUIProvider> getSubTabs() {
        return getParts().stream().filter(IFancyUIProvider.class::isInstance).map(IFancyUIProvider.class::cast).toList();
    }

    @Override
    public void attachTooltips(TooltipsPanel tooltipsPanel) {
        for (IMultiPart part : getParts()) {
            part.attachFancyTooltipsToController(this, tooltipsPanel);
        }
    }

    @Override
    public void addDisplayText(List<Component> textList) {

    }

    //////////////////////////////////////
    //***       Multiblock Data      ***//
    //////////////////////////////////////

    @Override
    public @NotNull ManagedFieldHolder getFieldHolder() {
        return MANAGED_FIELD_HOLDER;
    }
}
