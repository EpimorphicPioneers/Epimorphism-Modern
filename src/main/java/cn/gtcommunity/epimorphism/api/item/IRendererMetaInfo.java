package cn.gtcommunity.epimorphism.api.item;

import com.gregtechceu.gtceu.api.item.component.ICustomRenderer;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

public interface IRendererMetaInfo {
    ICustomRenderer getMetaInfo(@Nullable ItemStack itemStack);
}
