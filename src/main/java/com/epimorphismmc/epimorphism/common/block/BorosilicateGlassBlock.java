package com.epimorphismmc.epimorphism.common.block;

import com.epimorphismmc.epimorphism.Epimorphism;
import com.epimorphismmc.epimorphism.api.block.tier.ITierGlassType;

import com.epimorphismmc.monomorphism.block.tier.ITierBlock;

import com.gregtechceu.gtceu.api.block.AppearanceBlock;

import lombok.Getter;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;

import net.minecraft.world.level.block.GlassBlock;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Locale;

import javax.annotation.Nonnull;

import static com.gregtechceu.gtceu.api.GTValues.*;

@Getter
public class BorosilicateGlassBlock extends GlassBlock implements ITierBlock {

    public BorosilicateGlassBlock(Properties properties) {
        super(properties);
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
        COSMIC_NEUTRONIUM_BOROSILICATE(UEV),
        INFINITY_BOROSILICATE(UIV),
        TRANSCENDENT_METAL_BOROSILICATE(UXV),
        WHITE_DWARF_MATTER_BOROSILICATE(OpV);

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
