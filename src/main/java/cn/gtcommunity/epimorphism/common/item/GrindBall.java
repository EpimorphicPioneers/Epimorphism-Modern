package cn.gtcommunity.epimorphism.common.item;

import cn.gtcommunity.epimorphism.client.item.IRendererMetaInfo;
import cn.gtcommunity.epimorphism.common.item.behaviors.GrindBallBehaviour;
import com.gregtechceu.gtceu.api.item.ComponentItem;
import com.gregtechceu.gtceu.api.item.component.ICustomRenderer;
import com.gregtechceu.gtceu.api.item.component.IItemComponent;
import net.minecraft.world.item.ItemStack;

public class GrindBall extends ComponentItem implements IRendererMetaInfo {
    public GrindBall(Properties properties) {
        super(properties);
    }

    @Override
    public ICustomRenderer getMetaInfo(ItemStack itemStack) {
        for (IItemComponent component : components) {
            if (component instanceof GrindBallBehaviour grindBallBehaviour) {
                return grindBallBehaviour.getCustomRenderer(itemStack);
            }
        }
        return null;
    }
}
