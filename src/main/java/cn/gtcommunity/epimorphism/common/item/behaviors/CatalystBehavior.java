package cn.gtcommunity.epimorphism.common.item.behaviors;

import cn.gtcommunity.epimorphism.api.item.component.IDurabilityItem;
import com.gregtechceu.gtceu.api.item.ComponentItem;
import com.gregtechceu.gtceu.api.item.component.IAddInformation;
import com.gregtechceu.gtceu.api.item.component.IItemComponent;
import net.minecraft.client.color.item.ItemColor;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Supplier;

public class CatalystBehavior implements IItemComponent, IDurabilityItem, IAddInformation {

    protected final int maxDurability;

    public CatalystBehavior(int maxDurability) {
        this.maxDurability = maxDurability;
    }

    @Nullable
    protected CompoundTag getCatalystStatsTag(ItemStack itemStack) {
        return itemStack.getTagElement("EP.CatalystStats");
    }

    protected CompoundTag getOrCreateCatalystStatsTag(ItemStack itemStack) {
        return itemStack.getOrCreateTagElement("EP.CatalystStats");
    }

    @Override
    public int getMaxDurability(ItemStack stack) {
        return maxDurability;
    }

    @Override
    public int getDamage(ItemStack itemStack) {
        var compound = getCatalystStatsTag(itemStack);
        if (compound == null || !compound.contains("Damage", Tag.TAG_ANY_NUMERIC)) {
            return 0;
        }
        return compound.getInt("Damage");
    }

    @Override
    public void setDamage(ItemStack itemStack, int damage) {
        var compound = getOrCreateCatalystStatsTag(itemStack);
        compound.putInt("Damage", Math.min(maxDurability, damage));
    }

    @Override
    public void appendHoverText(ItemStack itemStack, @Nullable Level level, List<Component> list, TooltipFlag tooltipFlag) {
        int damage = this.getDamage(itemStack);
        list.add(Component.translatable("metaitem.tool.tooltip.durability", maxDurability - damage, maxDurability));
    }

    @OnlyIn(Dist.CLIENT)
    public static Supplier<ItemColor> getItemStackColor(int color) {
        return () -> (ItemColor) (stack, i) -> i == 1 ? color : -1;
    }

    @Nullable
    public static CatalystBehavior getBehaviour(@NotNull ItemStack itemStack) {
        if (itemStack.getItem() instanceof ComponentItem componentItem) {
            for (var component : componentItem.getComponents()) {
                if (component instanceof CatalystBehavior behaviour) {
                    return behaviour;
                }
            }
        }
        return null;
    }
}
