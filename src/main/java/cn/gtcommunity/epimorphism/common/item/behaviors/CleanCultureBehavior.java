package cn.gtcommunity.epimorphism.common.item.behaviors;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.PropertyKey;
import com.gregtechceu.gtceu.api.item.ComponentItem;
import com.gregtechceu.gtceu.api.item.component.*;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import net.minecraft.client.color.item.ItemColor;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.Nullable;

import javax.annotation.Nonnull;
import java.util.List;

public class CleanCultureBehavior implements ISubItemHandler, IAddInformation, ICustomDescriptionId {

    @Override
    public void appendHoverText(ItemStack itemStack, @Nullable Level level, List<Component> list, TooltipFlag tooltipFlag) {

    }

    @Override
    public @Nullable Component getItemName(ItemStack stack) {
        return ICustomDescriptionId.super.getItemName(stack);
    }

    private CompoundTag getCultureStatsTag(ItemStack itemStack) {
        return itemStack.getTagElement("EP.CultureStats");
    }

    private CompoundTag getOrCreateCultureStatsTag(ItemStack itemStack) {
        return itemStack.getOrCreateTagElement("EP.CultureStats");
    }

    public Material getCultureMedium(ItemStack itemStack) {
        var compound = getCultureStatsTag(itemStack);
        var defaultMaterial = GTMaterials.Neutronium;
        if (compound == null || !compound.contains("Material", Tag.TAG_STRING)) {
            return defaultMaterial;
        }
        var materialName = compound.getString("Material");
        var material = GTMaterials.get(materialName);
        if (material == null || !material.hasProperty(PropertyKey.INGOT)) {
            return defaultMaterial;
        }
        return material;
    }

    public void setCultureMedium(ItemStack itemStack, @Nonnull Material material) {
        if (!material.hasProperty(PropertyKey.INGOT))
            throw new IllegalArgumentException("Part material must have an Ingot!");
        var compound = getOrCreateCultureStatsTag(itemStack);
        compound.putString("Material", material.getName());
    }

    @OnlyIn(Dist.CLIENT)
    static ItemColor getItemStackColor() {
        return (itemStack, i) -> {
            if (itemStack.getItem() instanceof ComponentItem componentItem) {
                for (IItemComponent component : componentItem.getComponents()) {
                    if (component instanceof CleanCultureBehavior cleanCulture) {
                        return cleanCulture.getCultureMedium(itemStack).getMaterialARGB();
                    }
                }
            }
            return -1;
        };
    }
}
