package cn.gtcommunity.epimorphism.common.machine.multiblock.electric;

import cn.gtcommunity.epimorphism.api.data.tag.EPTagPrefix;
import com.epimorphismmc.monomorphism.block.MOBlockProperties;
import com.epimorphismmc.monomorphism.pattern.FactoryMOPattern;
import com.epimorphismmc.monomorphism.pattern.utils.StructureUtil;
import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.data.chemical.ChemicalHelper;
import com.gregtechceu.gtceu.api.gui.GuiTextures;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.MachineDefinition;
import com.gregtechceu.gtceu.api.machine.feature.IMachineModifyDrops;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableElectricMultiblockMachine;
import com.gregtechceu.gtceu.api.machine.trait.NotifiableItemStackHandler;
import com.gregtechceu.gtceu.api.pattern.BlockPattern;
import com.gregtechceu.gtceu.api.pattern.MultiblockWorldSavedData;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;
import com.lowdragmc.lowdraglib.gui.widget.SlotWidget;
import com.lowdragmc.lowdraglib.gui.widget.Widget;
import com.lowdragmc.lowdraglib.gui.widget.WidgetGroup;
import com.lowdragmc.lowdraglib.misc.ItemStackTransfer;
import com.lowdragmc.lowdraglib.syncdata.ISubscription;
import com.lowdragmc.lowdraglib.syncdata.annotation.DescSynced;
import com.lowdragmc.lowdraglib.syncdata.annotation.Persisted;
import com.lowdragmc.lowdraglib.syncdata.field.ManagedFieldHolder;
import com.lowdragmc.lowdraglib.utils.TrackedDummyWorld;
import lombok.Getter;
import net.minecraft.ChatFormatting;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.server.TickTask;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static cn.gtcommunity.epimorphism.common.data.EPBlocks.*;
import static cn.gtcommunity.epimorphism.common.data.EPMaterials.*;
import static com.gregtechceu.gtceu.api.pattern.Predicates.*;
import static com.gregtechceu.gtceu.common.data.GTBlocks.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class NanoForgeMachine extends WorkableElectricMultiblockMachine implements IMachineModifyDrops {

    protected static final ManagedFieldHolder MANAGED_FIELD_HOLDER = new ManagedFieldHolder(NanoForgeMachine.class, WorkableElectricMultiblockMachine.MANAGED_FIELD_HOLDER);

    protected static final Map<Integer, BlockPattern> PATTERNS = new HashMap<>();

    @Getter
    @Persisted @DescSynced
    private int tier;
    @Getter @Persisted
    private final NotifiableItemStackHandler nanitesStorage;
    @Nullable
    private ISubscription nanitesChangedSubs;

    public NanoForgeMachine(IMachineBlockEntity holder, Object... args) {
        super(holder, args);
        this.nanitesStorage = createNanitesStorage(args);
    }

    //////////////////////////////////////
    //***    Multiblock LifeCycle    ***//
    //////////////////////////////////////

    @Override
    public void onLoad() {
        super.onLoad();
        if (!isRemote()) {
            this.nanitesChangedSubs = nanitesStorage.addChangedListener(this::onNanitesChanged);
        }
    }

    @Override
    public void onUnload() {
        super.onUnload();
        if (this.nanitesChangedSubs != null) {
            this.nanitesChangedSubs.unsubscribe();
        }
    }

    protected NotifiableItemStackHandler createNanitesStorage(Object... args) {
        return new NotifiableItemStackHandler(this, 1, IO.NONE, IO.NONE, slots -> new ItemStackTransfer(1) {
            @Override
            public int getSlotLimit(int slot) {
                return 1;
            }

            @Override
            public boolean isItemValid(int slot, @NotNull ItemStack stack) {
                var prefix = ChemicalHelper.getPrefix(stack.getItem());
                return prefix != null && prefix.equals(EPTagPrefix.nanites);
            }
        });
    }

    @Override
    public BlockPattern getPattern() {
        int multiblockTier = this.tier;
        if (getLevel() instanceof TrackedDummyWorld) {
            multiblockTier = getBlockState().getValue(MOBlockProperties.STRUCTURE_TIER);
        }
        return getBlockPattern(multiblockTier, getDefinition());
    }

    public static BlockPattern getBlockPattern(int tier, MachineDefinition definition) {
        var builder = FactoryMOPattern.start()
                .where('D', controller(blocks(definition.getBlock())))
                .where('#', air())
                .where('A', blocks(CASING_ASSEMBLY_LINE.get()))
                .where('B', blocks(NAQUADAH_ALLOY_CASING.get()))
                .where('E', blocks(NAQUADAH_ALLOY_CASING.get())
                        .or(autoAbilities(definition.getRecipeTypes()))
                        .or(autoAbilities(true, true, false)))
                .where('C', frames(StellarAlloy));
        return PATTERNS.computeIfAbsent(tier, t -> switch (t) {
            case 1 -> builder
                    .aisle("         ", "         ", "         ", "         ", "         ", "         ", "         ", "         ", "         ", "         ", "         ", "         ", "    B    ", "    B    ", "    B    ", "    B    ", "    B    ", "    B    ", "    B    ", "    B    ", "         ", "         ", "         ", "         ", "         ", "         ", "         ", "         ", "         ", "         ", "         ", "         ", "         ", "         ", "         ", "         ", "         ", "         ")
                    .aisle("  EEEEE  ", "         ", "         ", "         ", "         ", "         ", "         ", "         ", "   CBC   ", "   CBC   ", "   CBC   ", "   CBC   ", "   CBC   ", "   CBC   ", "   CBC   ", "   CBC   ", "   CBC   ", "   CBC   ", "   CBC   ", "   CBC   ", "   CBC   ", "   CBC   ", "   CBC   ", "   CBC   ", "         ", "         ", "         ", "         ", "         ", "         ", "         ", "         ", "         ", "         ", "         ", "         ", "         ", "         ")
                    .aisle(" EEEEEEE ", "   CBC   ", "   CBC   ", "   CBC   ", "   CBC   ", "   CBC   ", "   CBC   ", "   CBC   ", "  CB#BC  ", "  CB#BC  ", "  CB#BC  ", "  CB#BC  ", "  BB#BB  ", "  BB#BB  ", "  BB#BB  ", "  BB#BB  ", "  BB#BB  ", "  BB#BB  ", "  BB#BB  ", "  BB#BB  ", "  CB#BC  ", "  CB#BC  ", "  CB#BC  ", "  CB#BC  ", "   CBC   ", "   CBC   ", "   CBC   ", "   CBC   ", "   CBC   ", "   CBC   ", "   CBC   ", "   CBC   ", "   CBC   ", "    C    ", "    C    ", "    C    ", "    C    ", "    C    ")
                    .aisle("EEEEEEEEE", "   B#B   ", "   B#B   ", "   B#B   ", "   B#B   ", "   B#B   ", "   B B   ", "   B#B   ", "   B#B   ", "   B#B   ", "  B###B  ", "  B###B  ", "  B###B  ", "  B###B  ", "  B###B  ", " BB###BB ", " BB###BB ", "  B###B  ", "  B###B  ", "  B###B  ", "  B###B  ", "  B###B  ", "   B#B   ", "   B#B   ", "   B#B   ", "   B#B   ", "   B#B   ", "   B#B   ", "   B#B   ", "   B#B   ", "   B#B   ", "   B#B   ", "   B#B   ", "    B    ", "    B    ", "    B    ", "    B    ", "    B    ")
                    .aisle("EEEEEEEEE", "   B#B   ", "   B#B   ", "   B#B   ", "   B#B   ", "   B#B   ", "   B B   ", "   B#B   ", "   B#B   ", "   B#B   ", "  B###B  ", "  B###B  ", "  B###B  ", "  B###B  ", "  B###B  ", " BB###BB ", " BB###BB ", "  B###B  ", "  B###B  ", "  B###B  ", "  B###B  ", "  B###B  ", "   B#B   ", "   B#B   ", "   B#B   ", "   B#B   ", "   B#B   ", "   B#B   ", "   B#B   ", "   B#B   ", "   B#B   ", "   B#B   ", "   B#B   ", "    B    ", "    B    ", "    B    ", "    B    ", "    B    ")
                    .aisle("EEEEEEEEE", "   B#B   ", "   B#B   ", "   B#B   ", "   B#B   ", "   B#B   ", "   B B   ", "   B#B   ", "   B#B   ", "   B#B   ", "  B###B  ", "  B###B  ", "  B###B  ", "  B###B  ", "  B###B  ", " BB###BB ", " BB###BB ", "  B###B  ", "  B###B  ", "  B###B  ", "  B###B  ", "  B###B  ", "   B#B   ", "   B#B   ", "   B#B   ", "   B#B   ", "   B#B   ", "   B#B   ", "   B#B   ", "   B#B   ", "   B#B   ", "   B#B   ", "   B#B   ", "    B    ", "    B    ", "    B    ", "    B    ", "    B    ")
                    .aisle("EEEEEEEEE", "   B#B   ", "   B#B   ", "   B#B   ", "   B#B   ", "   B#B   ", "   B B   ", "   B#B   ", "   B#B   ", "   B#B   ", "  B###B  ", "  B###B  ", "  B###B  ", "  B###B  ", "  B###B  ", " BB###BB ", " BB###BB ", "  B###B  ", "  B###B  ", "  B###B  ", "  B###B  ", "  B###B  ", "   B#B   ", "   B#B   ", "   B#B   ", "   B#B   ", "   B#B   ", "   B#B   ", "   B#B   ", "   B#B   ", "   B#B   ", "   B#B   ", "   B#B   ", "    B    ", "    B    ", "    B    ", "    B    ", "    B    ")
                    .aisle(" EEEEEEE ", "   CBC   ", "   CBC   ", "   CBC   ", "   CBC   ", "   CBC   ", "   CBC   ", "   CBC   ", "  CB#BC  ", "  CB#BC  ", "  CB#BC  ", "  CB#BC  ", "  BB#BB  ", "  BB#BB  ", "  BB#BB  ", "  BB#BB  ", "  BB#BB  ", "  BB#BB  ", "  BB#BB  ", "  BB#BB  ", "  CB#BC  ", "  CB#BC  ", "  CB#BC  ", "  CB#BC  ", "   CBC   ", "   CBC   ", "   CBC   ", "   CBC   ", "   CBC   ", "   CBC   ", "   CBC   ", "   CBC   ", "   CBC   ", "    C    ", "    C    ", "    C    ", "    C    ", "    C    ")
                    .aisle("  EEDEE  ", "         ", "         ", "         ", "         ", "         ", "         ", "         ", "   CBC   ", "   CBC   ", "   CBC   ", "   CBC   ", "   CBC   ", "   CBC   ", "   CBC   ", "   CBC   ", "   CBC   ", "   CBC   ", "   CBC   ", "   CBC   ", "   CBC   ", "   CBC   ", "   CBC   ", "   CBC   ", "         ", "         ", "         ", "         ", "         ", "         ", "         ", "         ", "         ", "         ", "         ", "         ", "         ", "         ")
                    .aisle("         ", "         ", "         ", "         ", "         ", "         ", "         ", "         ", "         ", "         ", "         ", "         ", "    B    ", "    B    ", "    B    ", "    B    ", "    B    ", "    B    ", "    B    ", "    B    ", "         ", "         ", "         ", "         ", "         ", "         ", "         ", "         ", "         ", "         ", "         ", "         ", "         ", "         ", "         ", "         ", "         ", "         ")
                    .build(1);
            case 2 -> builder
                    .aisle("                   ", "                   ", "                   ", "                   ", "                   ", "                   ", "                   ", "                   ", "                   ", "                   ", "                   ", "                   ", "    B              ", "    B              ", "    B              ", "    B              ", "    B              ", "    B              ", "    B              ", "    B              ", "                   ", "                   ", "                   ", "                   ", "                   ", "                   ", "                   ", "                   ", "                   ", "                   ", "                   ", "                   ", "                   ", "                   ", "                   ", "                   ", "                   ", "                   ")
                    .aisle("  EEEEE            ", "                   ", "                   ", "                   ", "                   ", "                   ", "                   ", "                   ", "   CBC             ", "   CBC             ", "   CBC             ", "   CBC             ", "   CBC             ", "   CBC             ", "   CBC             ", "   CBC             ", "   CBC             ", "   CBC             ", "   CBC             ", "   CBC             ", "   CBC             ", "   CBC             ", "   CBC             ", "   CBC             ", "                   ", "                   ", "                   ", "                   ", "                   ", "                   ", "                   ", "                   ", "                   ", "                   ", "                   ", "                   ", "                   ", "                   ")
                    .aisle(" EEEEEEE           ", "   CBC             ", "   CBC             ", "   CBC             ", "   CBC             ", "   CBC             ", "   CBC             ", "   CBC             ", "  CB#BC            ", "  CB#BC            ", "  CB#BC            ", "  CB#BC            ", "  BB#BB            ", "  BB#BB            ", "  BB#BB            ", "  BB#BB            ", "  BB#BB            ", "  BB#BB            ", "  BB#BB            ", "  BB#BB            ", "  CB#BC            ", "  CB#BC            ", "  CB#BC            ", "  CB#BC            ", "   CBC             ", "   CBC             ", "   CBC             ", "   CBC             ", "   CBC             ", "   CBC             ", "   CBC             ", "   CBC             ", "   CBC             ", "    C              ", "    C              ", "    C              ", "    C              ", "    C              ")
                    .aisle("EEEEEEEEE          ", "   B#B             ", "   B#B             ", "   B#B             ", "   B#B             ", "   B#B             ", "   B#B             ", "   B#B             ", "   B#B             ", "   B#B             ", "  B###B            ", "  B###B            ", "  B###B            ", "  B###B            ", "  B###B            ", " BB###BB           ", " BB###BB           ", "  B###B            ", "  B###B            ", "  B###B            ", "  B###B            ", "  B###B            ", "   B#B             ", "   B#B             ", "   B#B             ", "   B#B             ", "   B#B             ", "   B#B             ", "   B#B             ", "   B#B             ", "   B#B             ", "   B#B             ", "   B#B             ", "    B              ", "    B              ", "    B              ", "    B              ", "    B              ")
                    .aisle("EEEEEEEEE          ", "   B#B             ", "   B#B             ", "   B#B             ", "   B#B             ", "   B#B             ", "   B#B             ", "   B#B             ", "   B#B             ", "   B#B             ", "  B###B            ", "  B###B            ", "  B###B            ", "  B###B            ", "  B###B            ", " BB###BB           ", " BB###BB           ", "  B###B            ", "  B###B            ", "  B###B            ", "  B###B            ", "  B###B            ", "   B#B             ", "   B#B             ", "   B#B             ", "   B#B             ", "   B#B             ", "   B#B             ", "   B#B             ", "   B#B             ", "   B#B             ", "   B#B             ", "   B#B             ", "    B              ", "    B              ", "    B              ", "    B              ", "    B              ")
                    .aisle("EEEEEEEEE   BBBBBB ", "   B#B             ", "   B#B             ", "   B#B             ", "   B#B             ", "   B#B             ", "   B#B             ", "   B#B             ", "   B#B             ", "   B#B             ", "  B###B            ", "  B###B            ", "  B###B            ", "  B###B            ", "  B###B            ", " BB###BB           ", " BB###BB           ", "  B###B            ", "  B###B            ", "  B###B            ", "  B###B            ", "  B###B            ", "   B#B             ", "   B#B             ", "   B#B             ", "   B#B             ", "   B#B             ", "   B#B             ", "   B#B             ", "   B#B             ", "   B#B             ", "   B#B             ", "   B#B             ", "    B              ", "    B              ", "    B              ", "    B              ", "    B              ")
                    .aisle("EEEEEEEEE  BBBBBBBB", "   B#B             ", "   B#B             ", "   B#B             ", "   B#B             ", "   B#B             ", "   B#B             ", "   B#B             ", "   B#B             ", "   B#B             ", "  B###B            ", "  B###B            ", "  B###B            ", "  B###B            ", "  B###B            ", " BB###BB           ", " BB###BB           ", "  B###B            ", "  B###B            ", "  B###B            ", "  B###B            ", "  B###B            ", "   B#B             ", "   B#B             ", "   B#B             ", "   B#B             ", "   B#B             ", "   B#B             ", "   B#B             ", "   B#B             ", "   B#B             ", "   B#B             ", "   B#B             ", "    B              ", "    B              ", "    B              ", "    B              ", "    B              ")
                    .aisle(" EEEEEEE   BBBBBBBB", "   CBC             ", "   CBC             ", "   CBC             ", "   CBC             ", "   CBC        BB   ", "   CBC        AA   ", "   CBC        BB   ", "  CB#BC            ", "  CB#BC            ", "  CB#BC            ", "  CB#BC            ", "  BB#BB       BB   ", "  BB#BB       AA   ", "  BB#BB       BB   ", "  BB#BB            ", "  BB#BB            ", "  BB#BB            ", "  BB#BB            ", "  BB#BB            ", "  CB#BC            ", "  CB#BC            ", "  CB#BC            ", "  CB#BC            ", "   CBC             ", "   CBC             ", "   CBC             ", "   CBC             ", "   CBC             ", "   CBC             ", "   CBC             ", "   CBC             ", "   CBC             ", "    C              ", "    C              ", "    C              ", "    C              ", "    C              ")
                    .aisle("  EEDEE    BBBBBBBB", "              BB   ", "              BB   ", "              BB   ", "              BB   ", "             BBBB  ", "             ABBA  ", "             BBBB  ", "   CBC        BB   ", "   CBC        BB   ", "   CBC        BB   ", "   CBC        BB   ", "   CBC       BBBB  ", "   CBC       ABBA  ", "   CBC       BBBB  ", "   CBC             ", "   CBC             ", "   CBC             ", "   CBC             ", "   CBC             ", "   CBC             ", "   CBC             ", "   CBC             ", "   CBC             ", "                   ", "                   ", "                   ", "                   ", "                   ", "                   ", "                   ", "                   ", "                   ", "                   ", "                   ", "                   ", "                   ", "                   ")
                    .aisle("           BBBBBBBB", "              BB   ", "              BB   ", "              BB   ", "              BB   ", "             BBBB  ", "             ABBA  ", "             BBBB  ", "              BB   ", "              BB   ", "              BB   ", "              BB   ", "    B        BBBB  ", "    B        ABBA  ", "    B        BBBB  ", "    B              ", "    B              ", "    B              ", "    B              ", "    B              ", "                   ", "                   ", "                   ", "                   ", "                   ", "                   ", "                   ", "                   ", "                   ", "                   ", "                   ", "                   ", "                   ", "                   ", "                   ", "                   ", "                   ", "                   ")
                    .aisle("           BBBBBBBB", "                   ", "                   ", "                   ", "                   ", "              BB   ", "              AA   ", "              BB   ", "                   ", "                   ", "                   ", "                   ", "              BB   ", "              AA   ", "              BB   ", "                   ", "                   ", "                   ", "                   ", "                   ", "                   ", "                   ", "                   ", "                   ", "                   ", "                   ", "                   ", "                   ", "                   ", "                   ", "                   ", "                   ", "                   ", "                   ", "                   ", "                   ", "                   ", "                   ")
                    .aisle("           BBBBBBBB", "                   ", "                   ", "                   ", "                   ", "                   ", "                   ", "                   ", "                   ", "                   ", "                   ", "                   ", "                   ", "                   ", "                   ", "                   ", "                   ", "                   ", "                   ", "                   ", "                   ", "                   ", "                   ", "                   ", "                   ", "                   ", "                   ", "                   ", "                   ", "                   ", "                   ", "                   ", "                   ", "                   ", "                   ", "                   ", "                   ", "                   ")
                    .aisle("            BBBBBB ", "                   ", "                   ", "                   ", "                   ", "                   ", "                   ", "                   ", "                   ", "                   ", "                   ", "                   ", "                   ", "                   ", "                   ", "                   ", "                   ", "                   ", "                   ", "                   ", "                   ", "                   ", "                   ", "                   ", "                   ", "                   ", "                   ", "                   ", "                   ", "                   ", "                   ", "                   ", "                   ", "                   ", "                   ", "                   ", "                   ", "                   ")
                    .build(2);
            case 3 -> builder
                    .aisle("                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "              B              ", "              B              ", "              B              ", "              B              ", "              B              ", "              B              ", "              B              ", "              B              ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ")
                    .aisle("            EEEEE            ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "             CBC             ", "             CBC             ", "             CBC             ", "             CBC             ", "             CBC             ", "             CBC             ", "             CBC             ", "             CBC             ", "             CBC             ", "             CBC             ", "             CBC             ", "             CBC             ", "             CBC             ", "             CBC             ", "             CBC             ", "             CBC             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ")
                    .aisle("           EEEEEEE           ", "             CBC             ", "             CBC             ", "             CBC             ", "             CBC             ", "             CBC             ", "             CBC             ", "             CBC             ", "            CB BC            ", "            CB BC            ", "            CB BC            ", "            CB BC            ", "            BB BB            ", "            BB BB            ", "            BB BB            ", "            BB BB            ", "            BB BB            ", "            BB BB            ", "            BB BB            ", "            BB BB            ", "            CB BC            ", "            CB BC            ", "            CB BC            ", "            CB BC            ", "             CBC             ", "             CBC             ", "             CBC             ", "             CBC             ", "             CBC             ", "             CBC             ", "             CBC             ", "             CBC             ", "             CBC             ", "              C              ", "              C              ", "              C              ", "              C              ", "              C              ")
                    .aisle("          EEEEEEEEE          ", "             B B             ", "             B B             ", "             B B             ", "             B B             ", "             B B             ", "             B B             ", "             B B             ", "             B B             ", "             B B             ", "            B   B            ", "            B   B            ", "            B   B            ", "            B   B            ", "            B   B            ", "           BB   BB           ", "           BB   BB           ", "            B   B            ", "            B   B            ", "            B   B            ", "            B   B            ", "            B   B            ", "             B B             ", "             B B             ", "             B B             ", "             B B             ", "             B B             ", "             B B             ", "             B B             ", "             B B             ", "             B B             ", "             B B             ", "             B B             ", "              B              ", "              B              ", "              B              ", "              B              ", "              B              ")
                    .aisle("          EEEEEEEEE          ", "             B B             ", "             B B             ", "             B B             ", "             B B             ", "             B B             ", "             B B             ", "             B B             ", "             B B             ", "             B B             ", "            B   B            ", "            B   B            ", "            B   B            ", "            B   B            ", "            B   B            ", "           BB   BB           ", "           BB   BB           ", "            B   B            ", "            B   B            ", "            B   B            ", "            B   B            ", "            B   B            ", "             B B             ", "             B B             ", "             B B             ", "             B B             ", "             B B             ", "             B B             ", "             B B             ", "             B B             ", "             B B             ", "             B B             ", "             B B             ", "              B              ", "              B              ", "              B              ", "              B              ", "              B              ")
                    .aisle(" BBBBBB   EEEEEEEEE   BBBBBB ", "             B B             ", "    CC       B B             ", "  CC         B B             ", "             B B             ", "             B B             ", "             B B             ", "             B B             ", "    CC       B B             ", "  CC         B B             ", "            B   B            ", "            B   B            ", "            B   B            ", "            B   B            ", "    CC      B   B            ", "  CC       BB   BB           ", "           BB   BB           ", "            B   B            ", "            B   B            ", "            B   B            ", "    CC      B   B            ", "  CC        B   B            ", "             B B             ", "             B B             ", "             B B             ", "             B B             ", "             B B             ", "             B B             ", "             B B             ", "             B B             ", "             B B             ", "             B B             ", "             B B             ", "              B              ", "              B              ", "              B              ", "              B              ", "              B              ")
                    .aisle("BBBBBBBB  EEEEEEEEE  BBBBBBBB", "      C      B B             ", "             B B             ", "             B B             ", " C           B B             ", "             B B             ", "             B B             ", "      C      B B             ", "             B B             ", "             B B             ", " C          B   B            ", "            B   B            ", "            B   B            ", "      C     B   B            ", "            B   B            ", "           BB   BB           ", " C         BB   BB           ", "            B   B            ", "            B   B            ", "      C     B   B            ", "            B   B            ", "            B   B            ", " C           B B             ", "             B B             ", "             B B             ", "             B B             ", "             B B             ", "             B B             ", "             B B             ", "             B B             ", "             B B             ", "             B B             ", "             B B             ", "              B              ", "              B              ", "              B              ", "              B              ", "              B              ")
                    .aisle("BBBBBBBB   EEEEEEE   BBBBBBBB", "             CBC             ", "             CBC             ", "             CBC             ", "   BB        CBC             ", "C  AA        CBC        BB   ", "   BB  C     CBC        AA   ", "             CBC        BB   ", "            CB BC            ", "            CB BC            ", "            CB BC            ", "C           CB BC            ", "       C    BB BB       BB   ", "            BB BB       AA   ", "   BB       BB BB       BB   ", "   BB       BB BB            ", "   BB       BB BB            ", "C  BB       BB BB            ", "       C    BB BB            ", "            BB BB            ", "            CB BC            ", "            CB BC            ", "            CB BC            ", "C           CB BC            ", "   BB  C     CBC             ", "   AACC      CBC             ", "   BB        CBC             ", "             CBC             ", "             CBC             ", "             CBC             ", "             CBC             ", "             CBC             ", "             CBC             ", "              C              ", "              C              ", "              C              ", "              C              ", "              C              ")
                    .aisle("BBBBBBBB    EEDEE    BBBBBBBB", "   BB                   BB   ", "   BB                   BB   ", "   BB                   BB   ", "  BBBB                  BB   ", "C ABBA                 BBBB  ", "  BBBB C               ABBA  ", "   BB                  BBBB  ", "   BB        CBC        BB   ", "   BB        CBC        BB   ", "   BB        CBC        BB   ", "C  BB        CBC        BB   ", "   BB  C     CBC       BBBB  ", "   BB        CBC       ABBA  ", "  BBBB       CBC       BBBB  ", "  BBBB       CBC             ", "  BBBB       CBC             ", "C BBBB       CBC             ", "   BB  C     CBC             ", "   BB        CBC             ", "   BB        CBC             ", "   BB        CBC             ", "   BB        CBC             ", "C  BB        CBC             ", "  BBBB C                     ", "  ABBA                       ", "  BBBB                       ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ")
                    .aisle("BBBBBBBB             BBBBBBBB", "   BB                   BB   ", "   BB                   BB   ", "   BB                   BB   ", "  BBBB                  BB   ", "  ABBA C               BBBB  ", "C BBBB                 ABBA  ", "   BB                  BBBB  ", "   BB                   BB   ", "   BB                   BB   ", "   BB                   BB   ", "   BB  C                BB   ", "C  BB         B        BBBB  ", "   BB         B        ABBA  ", "  BBBB        B        BBBB  ", "  BBBB        B              ", "  BBBB        B              ", "  BBBB C      B              ", "C  BB         B              ", "   BB         B              ", "   BB                        ", "   BB                        ", "   BB                        ", "   BB  C                     ", "C BBBB                       ", "  ABBA                       ", "  BBBB                       ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ")
                    .aisle("BBBBBBBB             BBBBBBBB", "                             ", "                             ", "                             ", "   BB                        ", "   AA  C                BB   ", "C  BB                   AA   ", "                        BB   ", "                             ", "                             ", "                             ", "       C                     ", "C                       BB   ", "                        AA   ", "   BB                   BB   ", "   BB                        ", "   BB                        ", "   BB  C                     ", "C                            ", "                             ", "                             ", "                             ", "                             ", "       C                     ", "C  BB                        ", " CCAA                        ", "   BB                        ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ")
                    .aisle("BBBBBBBB             BBBBBBBB", " C                           ", "                             ", "                             ", "      C                      ", "                             ", "                             ", " C                           ", "                             ", "                             ", "      C                      ", "                             ", "                             ", " C                           ", "                             ", "                             ", "      C                      ", "                             ", "                             ", " C                           ", "                             ", "                             ", "      C                      ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ")
                    .aisle(" BBBBBB               BBBBBB ", "                             ", "  CC                         ", "    CC                       ", "                             ", "                             ", "                             ", "                             ", "  CC                         ", "    CC                       ", "                             ", "                             ", "                             ", "                             ", "  CC                         ", "    CC                       ", "                             ", "                             ", "                             ", "                             ", "  CC                         ", "    CC                       ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ", "                             ")
                    .build(3);
            default -> StructureUtil.EMPTY_PATTERN;
        });
    }

    protected void onNanitesChanged() {
        this.tier = getNanitesTier();
        if (!isFormed) return;
        if (getLevel() instanceof ServerLevel serverLevel) {
            serverLevel.getServer().tell(new TickTask(1, () -> {
                if (checkPatternWithLock()) {
                    onStructureFormed();
                    if (getRecipeLogic().getLastRecipe() != null) {
                        getRecipeLogic().markLastRecipeDirty();
                    }
                } else {
                    onStructureInvalid();
                    var mwsd = MultiblockWorldSavedData.getOrCreate(serverLevel);
                    mwsd.removeMapping(getMultiblockState());
                    mwsd.addAsyncLogic(this);
                }
            }));
        }
    }

    //////////////////////////////////////
    //******     Recipe Logic    *******//
    //////////////////////////////////////

    @Override
    protected @Nullable GTRecipe getRealRecipe(GTRecipe recipe) {
        return super.getRealRecipe(recipe);
    }

    //////////////////////////////////////
    //***        Multiblock UI       ***//
    //////////////////////////////////////

    @Override
    public void addDisplayText(List<Component> textList) {
        super.addDisplayText(textList);
        if (isActive()) {
            textList.add(Component.translatable("gtceu.machine.machine_hatch.locked").withStyle(Style.EMPTY.withColor(ChatFormatting.RED)));
        }
    }

    @Override
    public Widget createUIWidget() {
        var widget = super.createUIWidget();
        if (widget instanceof WidgetGroup group) {
            var size = group.getSize();
            group.addWidget(new SlotWidget(nanitesStorage.storage, 0, size.width - 30, size.height - 30, true, true)
                    .setBackground(GuiTextures.SLOT));
        }
        return widget;
    }

    //////////////////////////////////////
    //***       Multiblock Data      ***//
    //////////////////////////////////////

    protected int getNanitesTier() {
        var stack = ChemicalHelper.getMaterial(nanitesStorage.getStackInSlot(0));
        if (stack == null) return 0;
        var material = stack.material();
        if (material == Carbon) {
            return 1;
        } else if (material == Neutronium) {
            return 2;
        } else if (material == TranscendentMental) {
            return 3;
        } else {
            return 0;
        }
    }

    @Override
    public void onDrops(List<ItemStack> list, Player player) {
        clearInventory(list, nanitesStorage.storage);
    }

    @Override
    public ManagedFieldHolder getFieldHolder() {
        return MANAGED_FIELD_HOLDER;
    }
}
