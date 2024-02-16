package cn.gtcommunity.epimorphism.api.chemical.material.info;

import cn.gtcommunity.epimorphism.client.item.IRendererMetaInfo;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconSet;
import com.gregtechceu.gtceu.api.item.component.ICustomRenderer;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class RenderMaterialIconSet extends MaterialIconSet implements IRendererMetaInfo {

    private final ICustomRenderer customRenderer;
    public RenderMaterialIconSet(@NotNull String name, ICustomRenderer customRenderer) {
        super(name);
        this.customRenderer = customRenderer;
    }

    public RenderMaterialIconSet(@NotNull String name, @NotNull MaterialIconSet parentIconset, ICustomRenderer customRenderer) {
        super(name, parentIconset);
        this.customRenderer = customRenderer;
    }

    public RenderMaterialIconSet(@NotNull String name, @Nullable MaterialIconSet parentIconset, boolean isRootIconset, ICustomRenderer customRenderer) {
        super(name, parentIconset, isRootIconset);
        this.customRenderer = customRenderer;
    }

    @Override
    public ICustomRenderer getMetaInfo(ItemStack itemStack) {
        return customRenderer;
    }
}
