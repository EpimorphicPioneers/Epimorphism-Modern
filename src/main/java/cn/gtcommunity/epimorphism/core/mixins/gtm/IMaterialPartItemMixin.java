package cn.gtcommunity.epimorphism.core.mixins.gtm;

import cn.gtcommunity.epimorphism.api.item.component.IDurabilityItem;
import com.gregtechceu.gtceu.api.item.component.*;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(value = IMaterialPartItem.class, remap = false)
public interface IMaterialPartItemMixin extends IItemComponent, IDurabilityBar, IAddInformation, ICustomDescriptionId, IDurabilityItem {
    @Shadow int getPartDamage(ItemStack itemStack);

    @Shadow void setPartDamage(ItemStack itemStack, int damage);

    @Shadow int getPartMaxDurability(ItemStack itemStack);

    @Override
    default int getDamage(ItemStack itemStack) {
        return getPartDamage(itemStack);
    }

    @Override
    default void setDamage(ItemStack itemStack, int damage) {
        setPartDamage(itemStack, damage);
    }

    @Override
    default int getMaxDurability(ItemStack itemStack) {
        return getPartMaxDurability(itemStack);
    }

    @Override
    default float getDurabilityForDisplay(ItemStack itemStack) {
        return IDurabilityItem.super.getDurabilityForDisplay(itemStack);
    }
}
