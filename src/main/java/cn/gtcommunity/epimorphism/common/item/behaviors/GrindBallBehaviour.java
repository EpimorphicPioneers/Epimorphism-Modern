package cn.gtcommunity.epimorphism.common.item.behaviors;

import cn.gtcommunity.epimorphism.common.data.EPItems;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.item.ComponentItem;
import com.gregtechceu.gtceu.api.item.component.IMaterialPartItem;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

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

    @Nullable
    public static GrindBallBehaviour getBehaviour(@Nonnull ItemStack itemStack) {
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
