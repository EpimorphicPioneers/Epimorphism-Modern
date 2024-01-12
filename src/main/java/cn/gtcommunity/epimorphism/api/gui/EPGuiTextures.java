package cn.gtcommunity.epimorphism.api.gui;

import com.lowdragmc.lowdraglib.gui.texture.ResourceTexture;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class EPGuiTextures {
    public static final ResourceTexture PROGRESS_BAR_NEUTRON_ACTIVATOR = createTexture("textures/gui/progress_bar/progress_bar_neutron_activator.png");

    public static final ResourceTexture TOGGLE_BUTTON_LOCK = createTexture("textures/gui/widget/button_lock.png");
    public static final ResourceTexture TOGGLE_BUTTON_VOID = createTexture("textures/gui/widget/button_void.png");

    private static ResourceTexture createTexture(String imageLocation) {
        return new ResourceTexture("epimorphism:%s".formatted(imageLocation));
    }
}
