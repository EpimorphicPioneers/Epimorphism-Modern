package cn.gtcommunity.epimorphism.core.mixins.gtm;

import cn.gtcommunity.epimorphism.Epimorphism;
import cn.gtcommunity.epimorphism.common.block.BlockMaps;
import com.gregtechceu.gtceu.api.data.worldgen.GTOreDefinition;
import com.gregtechceu.gtceu.api.data.worldgen.bedrockfluid.BedrockFluidDefinition;
import com.gregtechceu.gtceu.integration.GTOreVeinWidget;
import com.lowdragmc.lowdraglib.gui.texture.IGuiTexture;
import com.lowdragmc.lowdraglib.gui.widget.SlotWidget;
import com.lowdragmc.lowdraglib.gui.widget.WidgetGroup;
import com.lowdragmc.lowdraglib.jei.IngredientIO;
import com.lowdragmc.lowdraglib.misc.ItemStackTransfer;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Objects;
import java.util.Set;
import java.util.function.Supplier;

@Mixin(
        value = {GTOreVeinWidget.class},
        remap = false
)
public abstract class GTOreVeinWidgetMixin extends WidgetGroup {
    @Shadow
    @Final
    public static int width;
    @Shadow
    @Final
    private Set<ResourceKey<Level>> dimensionFilter;

    public GTOreVeinWidgetMixin() {
    }

    @Inject(
            method = {"setupText(Lcom/gregtechceu/gtceu/api/data/worldgen/GTOreDefinition;)V"},
            at = {@At(
                    value = "INVOKE",
                    target = "Lcom/gregtechceu/gtceu/integration/GTOreVeinWidget;addWidget(Lcom/lowdragmc/lowdraglib/gui/widget/Widget;)Lcom/lowdragmc/lowdraglib/gui/widget/WidgetGroup;",
                    ordinal = 5
            )},
            cancellable = true
    )
    private void setupText(GTOreDefinition oreDefinition, CallbackInfo ci) {
        if (this.dimensionFilter != null) {
            int rSlots = (width - 10) / 16 - 1;
            int interval = (width - 10 - 16 * rSlots) / (rSlots - 1);
            ItemStack[] dims = this.dimensionFilter.stream().map((dim) -> getItem(dim.location().getPath())).filter(Objects::nonNull).toArray((x$0) -> new ItemStack[x$0]);

            for(int i = 0; i < dims.length; ++i) {
                int raw = Math.floorDiv(i, rSlots);
                SlotWidget dimSlot = (new SlotWidget(new ItemStackTransfer(dims[i]), i, 5 + (16 + interval) * (i - raw * rSlots), 80 + 18 * raw, false, false)).setIngredientIO(IngredientIO.INPUT);
                this.addWidget(dimSlot.setBackgroundTexture(IGuiTexture.EMPTY));
            }

            ci.cancel();
        }

    }

    @Inject(
            method = {"setupText(Lcom/gregtechceu/gtceu/api/data/worldgen/bedrockfluid/BedrockFluidDefinition;)V"},
            at = {@At(
                    value = "INVOKE",
                    target = "Lcom/gregtechceu/gtceu/integration/GTOreVeinWidget;addWidget(Lcom/lowdragmc/lowdraglib/gui/widget/Widget;)Lcom/lowdragmc/lowdraglib/gui/widget/WidgetGroup;",
                    ordinal = 3
            )},
            cancellable = true
    )
    private void setupText(BedrockFluidDefinition fluid, CallbackInfo ci) {
        if (this.dimensionFilter != null) {
            int rSlots = (width - 10) / 16 - 1;
            int interval = (width - 10 - 16 * rSlots) / (rSlots - 1);
            ItemStack[] dims = this.dimensionFilter.stream().map((dim) -> getItem(dim.location().getPath())).filter(Objects::nonNull).toArray((x$0) -> new ItemStack[x$0]);

            for(int i = 0; i < dims.length; ++i) {
                int raw = Math.floorDiv(i, rSlots);
                SlotWidget dimSlot = (new SlotWidget(new ItemStackTransfer(dims[i]), i, 5 + (16 + interval) * (i - raw * rSlots), 60 + 18 * raw, false, false)).setIngredientIO(IngredientIO.INPUT);
                this.addWidget(dimSlot.setBackgroundTexture(IGuiTexture.EMPTY));
            }

            ci.cancel();
        }

    }

    @Unique
    private static ItemStack getItem(String dimension) {
        Supplier block = BlockMaps.ALL_DIM_DISPLAY_BLOCKS.get(dimension);
        if (block != null) {
            return new ItemStack((ItemLike)block.get());
        } else {
            if (dimension != null) {
                Epimorphism.LOGGER.warn("Unknown dimension queried for DimensionDisplay: " + dimension);
            }

            return null;
        }
    }
}
