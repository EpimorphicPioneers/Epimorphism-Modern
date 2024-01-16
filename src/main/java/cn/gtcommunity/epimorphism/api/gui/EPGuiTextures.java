package cn.gtcommunity.epimorphism.api.gui;

import com.lowdragmc.lowdraglib.gui.texture.ResourceTexture;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class EPGuiTextures {
    public static final ResourceTexture PROGRESS_BAR_NEUTRON_ACTIVATOR = createTexture("progress_bar/progress_bar_neutron_activator.png");

    public static final ResourceTexture TOGGLE_BUTTON_LOCK = createTexture("widget/button_lock.png");
    public static final ResourceTexture TOGGLE_BUTTON_VOID = createTexture("widget/button_void.png");

    public static final ResourceTexture OVERLAY_PARALLEL_CONFIGURATOR = createTexture("overlay/parallel_configurator.png");

    private static ResourceTexture createTexture(String imageLocation) {
        return new ResourceTexture("epimorphism:textures/gui/%s".formatted(imageLocation));
    }
}
