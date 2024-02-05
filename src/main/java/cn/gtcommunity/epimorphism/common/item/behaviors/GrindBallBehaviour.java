package cn.gtcommunity.epimorphism.common.item.behaviors;

import cn.gtcommunity.epimorphism.common.data.EPItems;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.item.ComponentItem;
import com.gregtechceu.gtceu.api.item.component.IMaterialPartItem;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import com.lowdragmc.lowdraglib.utils.LocalizationUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.List;

public class GrindBallBehaviour implements IMaterialPartItem {
    @Override
    public int getPartMaxDurability(ItemStack itemStack) {
        if(EPItems.GRINDBALL_SOAPSTONE.isIn(itemStack))
            return 50;
        else
            return 100;
    }

    public void applyBallDamage(ItemStack itemStack, int damageApplied) {
        int ballDurability = getPartMaxDurability(itemStack);
        int resultDamage = getPartDamage(itemStack) + damageApplied;
        if (resultDamage >= ballDurability) {
            itemStack.shrink(1);
        } else {
            setPartDamage(itemStack, resultDamage);
        }
    }

    @Override
    public Material getPartMaterial(ItemStack itemStack) {
        if(EPItems.GRINDBALL_ALUMINIUM.isIn(itemStack))
            return GTMaterials.Aluminium;
        else if (EPItems.GRINDBALL_SOAPSTONE.isIn(itemStack)) {
            return GTMaterials.Soapstone;
        }
        return GTMaterials.Neutronium;
    }

    @Override
    public void setPartMaterial(ItemStack itemStack, @NotNull Material material) {/**/}

    @Override
    public String getItemStackDisplayName(ItemStack itemStack) {
        return LocalizationUtils.format(itemStack.getItem().getDescriptionId());
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltipComponents, TooltipFlag isAdvanced) {
        tooltipComponents.add(Component.translatable("item.epimorphism.mill.grindball.desc"));
        IMaterialPartItem.super.appendHoverText(stack, level, tooltipComponents, isAdvanced);
    }

    @Nullable
    public static GrindBallBehaviour getBehaviour(@NotNull ItemStack itemStack) {
        if (itemStack.getItem() instanceof ComponentItem componentItem) {
            for (var component : componentItem.getComponents()) {
                if (component instanceof GrindBallBehaviour behaviour) {
                    return behaviour;
                }
            }
        }
        return null;
    }
}
