package cn.gtcommunity.epimorphism.api.item.armor;

import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public abstract class ItemEPArmor extends ArmorItem {
    protected ItemEPArmor(ArmorMaterial material, ArmorItem.Type armorType, Properties properties) {
        super(material, armorType, properties);
    }

    @Override
    public boolean isEnchantable(@NotNull ItemStack stack) {
        return material.getEnchantmentValue() > 0 && super.isEnchantable(stack);
    }
}
