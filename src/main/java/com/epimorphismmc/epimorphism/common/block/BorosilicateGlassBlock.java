package com.epimorphismmc.epimorphism.common.block;

import com.epimorphismmc.epimorphism.Epimorphism;
import com.epimorphismmc.epimorphism.api.block.tier.ITierGlassType;

import com.epimorphismmc.monomorphism.block.tier.ITierBlock;

import com.gregtechceu.gtceu.api.block.RendererGlassBlock;
import com.gregtechceu.gtceu.client.renderer.block.TextureOverrideRenderer;

import com.lowdragmc.lowdraglib.Platform;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Nonnull;

import static com.gregtechceu.gtceu.api.GTValues.EV;
import static com.gregtechceu.gtceu.api.GTValues.HV;
import static com.gregtechceu.gtceu.api.GTValues.IV;
import static com.gregtechceu.gtceu.api.GTValues.LuV;
import static com.gregtechceu.gtceu.api.GTValues.UHV;
import static com.gregtechceu.gtceu.api.GTValues.UIV;
import static com.gregtechceu.gtceu.api.GTValues.UV;
import static com.gregtechceu.gtceu.api.GTValues.ZPM;

public class BorosilicateGlassBlock extends RendererGlassBlock implements ITierBlock {

    public BorosilicateGlassBlock(Properties properties, Type glassType) {
        super(
                properties,
                Platform.isClient()
                        ? new TextureOverrideRenderer(
                                new ResourceLocation("block/cube_all"),
                                Map.of(
                                        "all",
                                        Epimorphism.id("block/casings/transparent/%s".formatted(glassType.typeName()))))
                        : null);
        setTierType(glassType);
    }

    @Override
    public void appendHoverText(
            @NotNull ItemStack stack,
            @Nullable BlockGetter level,
            @NotNull List<Component> tooltip,
            @NotNull TooltipFlag flag) {
        String id = stack.getDescriptionId();
        tooltip.add(Component.translatable(id + ".desc"));
        super.appendHoverText(stack, level, tooltip, flag);
    }

    public enum Type implements ITierGlassType {
        BOROSILICATE(HV),
        TITANIUM_BOROSILICATE(EV),
        TUNGSTEN_BOROSILICATE(IV),
        IRIDIUM_BOROSILICATE(LuV),
        OSMIUM_BOROSILICATE(ZPM),
        DURANIUM_BOROSILICATE(UV),
        NEUTRONIUM_BOROSILICATE(UHV),
        INFINITY_BOROSILICATE(UIV);

        private final int tier;

        Type(int tier) {
            this.tier = tier;
        }

        @Override
        public boolean isOpticalGlass() {
            return false;
        }

        @Override
        public int tier() {
            return tier;
        }

        @Override
        public String typeName() {
            return "%s_glass".formatted(name().toLowerCase(Locale.ROOT));
        }

        @Nonnull
        @Override
        public String toString() {
            return typeName();
        }
    }
}