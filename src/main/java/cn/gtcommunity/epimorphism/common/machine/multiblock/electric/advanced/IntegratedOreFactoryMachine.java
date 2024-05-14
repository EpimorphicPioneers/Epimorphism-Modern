package cn.gtcommunity.epimorphism.common.machine.multiblock.electric.advanced;

import cn.gtcommunity.epimorphism.Epimorphism;
import cn.gtcommunity.epimorphism.api.gui.EPGuiTextures;
import cn.gtcommunity.epimorphism.api.machine.fancyconfigurator.CustomModeFancyConfigurator;
import cn.gtcommunity.epimorphism.common.data.EPBlocks;
import cn.gtcommunity.epimorphism.common.machine.trait.OreProcessingRecipeLogic;
import com.epimorphismmc.monomorphism.machine.multiblock.ParallelElectricMultiblockMachine;
import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.capability.recipe.FluidRecipeCapability;
import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.capability.recipe.ItemRecipeCapability;
import com.gregtechceu.gtceu.api.gui.fancy.ConfiguratorPanel;
import com.gregtechceu.gtceu.api.gui.fancy.IFancyConfiguratorButton;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.feature.multiblock.IMaintenanceMachine;
import com.gregtechceu.gtceu.api.machine.feature.multiblock.IMultiPart;
import com.gregtechceu.gtceu.api.machine.trait.RecipeLogic;
import com.gregtechceu.gtceu.common.data.GTBlocks;
import com.gregtechceu.gtceu.common.machine.multiblock.part.EnergyHatchPartMachine;
import com.gregtechceu.gtceu.common.machine.multiblock.part.ItemBusPartMachine;
import com.lowdragmc.lowdraglib.gui.texture.*;
import com.lowdragmc.lowdraglib.misc.FluidTransferList;
import com.lowdragmc.lowdraglib.misc.ItemTransferList;
import com.lowdragmc.lowdraglib.side.fluid.IFluidTransfer;
import com.lowdragmc.lowdraglib.side.item.IItemTransfer;
import com.lowdragmc.lowdraglib.syncdata.annotation.Persisted;
import com.lowdragmc.lowdraglib.syncdata.field.ManagedFieldHolder;
import it.unimi.dsi.fastutil.longs.Long2ObjectMaps;
import lombok.Getter;
import lombok.Setter;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class IntegratedOreFactoryMachine extends ParallelElectricMultiblockMachine {

    protected static final ManagedFieldHolder MANAGED_FIELD_HOLDER = new ManagedFieldHolder(IntegratedOreFactoryMachine.class, ParallelElectricMultiblockMachine.MANAGED_FIELD_HOLDER);

    private static final int MAX_PARA = 1024;

    @Persisted
    @Getter @Setter
    private int mode;
    @Persisted
    @Getter @Setter
    private boolean isVoidStone;

    @Getter
    private ItemTransferList inputBuses;
    @Getter
    private FluidTransferList inputHatches;

    public IntegratedOreFactoryMachine(IMachineBlockEntity holder, Object... args) {
        super(holder, machine -> MAX_PARA, args);
    }

    @Override
    public void onStructureFormed() {
        super.onStructureFormed();
        List<IItemTransfer> inputItems = new ArrayList<>();
        List<IFluidTransfer> inputFluids = new ArrayList<>();
        Map<Long, IO> ioMap = getMultiblockState().getMatchContext().getOrCreate("ioMap", Long2ObjectMaps::emptyMap);
        for (IMultiPart part : getParts()) {
            IO io = ioMap.getOrDefault(part.self().getPos().asLong(), IO.BOTH);
            if (io == IO.NONE) continue;
            for (var handler : part.getRecipeHandlers()) {
                var handlerIO = handler.getHandlerIO();
                // If IO not compatible
                if (io != IO.BOTH && handlerIO != IO.BOTH && io != handlerIO) continue;

                if (handlerIO == IO.IN) {
                    if (handler.getCapability() == ItemRecipeCapability.CAP && handler instanceof IItemTransfer itemTransfer) {
                        inputItems.add(itemTransfer);
                    }

                    if (handler.getCapability() == FluidRecipeCapability.CAP && handler instanceof IFluidTransfer fluidTransfer) {
                        inputFluids.add(fluidTransfer);
                    }
                }
            }
        }
        this.inputBuses = new ItemTransferList(inputItems);
        this.inputHatches = new FluidTransferList(inputFluids);
    }

    @Override
    public void onStructureInvalid() {
        super.onStructureInvalid();
    }

    @Nullable
    @Override
    public BlockState getPartAppearance(IMultiPart part, Direction side, BlockState sourceState, BlockPos sourcePos) {
        if ((part instanceof ItemBusPartMachine bus && bus.getInventory().getHandlerIO() == IO.IN)
                || part instanceof IMaintenanceMachine
                || part instanceof EnergyHatchPartMachine) {
            return EPBlocks.IRIDIUM_CASING.getDefaultState();
        }
        return GTBlocks.CASING_STAINLESS_CLEAN.getDefaultState();
    }

    //////////////////////////////////////
    //******     Recipe Logic    *******//
    //////////////////////////////////////

    @Override
    public RecipeLogic createRecipeLogic(Object... args) {
        return new OreProcessingRecipeLogic(this);
    }

    //////////////////////////////////////
    //***        Multiblock UI       ***//
    //////////////////////////////////////

    @Override
    public void attachConfigurators(ConfiguratorPanel configuratorPanel) {
        configuratorPanel.attachConfigurators(new CustomModeFancyConfigurator("ore_processing_mode",
                new ResourceTexture("minecraft:textures/item/fishing_rod.png"), 5, true,
                "block.epimorphism.integrated_ore_factory.ore_processing_mode.%s"::formatted, this::getMode, this::setMode));
        configuratorPanel.attachConfigurators((new IFancyConfiguratorButton.Toggle(
                EPGuiTextures.TOGGLE_BUTTON_STONE.getSubTexture(0.0, 0.0, 1.0, 0.5),
                EPGuiTextures.TOGGLE_BUTTON_STONE.getSubTexture(0.0, 0.5, 1.0, 0.5),
                this::isVoidStone, (clickData, pressed) -> this.setVoidStone(pressed)))
                .setTooltipsSupplier(pressed -> List.of(Component.translatable(pressed ? "gui.epimorphism.voiding_stone.desc.enabled" : "gui.epimorphism.voiding_stone.desc.disabled"))));
        super.attachConfigurators(configuratorPanel);
    }

    //////////////////////////////////////
    //***      Multiblock Render     ***//
    //////////////////////////////////////

    public static ResourceLocation getBaseTexture(IMultiPart iMultiPart) {
        if ((iMultiPart instanceof ItemBusPartMachine bus && bus.getInventory().getHandlerIO() == IO.IN)
                || iMultiPart instanceof IMaintenanceMachine
                || iMultiPart instanceof EnergyHatchPartMachine) {
            return Epimorphism.id("block/casings/solid/iridium_casing");
        }
        return GTCEu.id("block/casings/solid/machine_casing_clean_stainless_steel");
    }

    //////////////////////////////////////
    //***       Multiblock Data      ***//
    //////////////////////////////////////

    @Override
    public ManagedFieldHolder getFieldHolder() {
        return MANAGED_FIELD_HOLDER;
    }
}
