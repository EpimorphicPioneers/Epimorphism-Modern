package cn.gtcommunity.epimorphism.api.gui;

import com.lowdragmc.lowdraglib.gui.texture.ResourceTexture;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class EPGuiTextures {
    public static final ResourceTexture PROGRESS_BAR_RADIATION_HATCH = createTexture("progress_bar/progress_bar_radiation_hatch.png");
    public static final ResourceTexture PROGRESS_BAR_SIEVERT = createTexture("progress_bar/progress_bar_sievert.png");
    public static final ResourceTexture BAR_CONTAINER_SIEVERT = createTexture("progress_bar/bar_container_sievert.png");
    public static final ResourceTexture PROGRESS_BAR_DECAY_TIME = createTexture("progress_bar/progress_bar_decay_time.png");
    public static final ResourceTexture BAR_CONTAINER_DECAY_TIME = createTexture("progress_bar/bar_container_decay_time.png");

    public static final ResourceTexture TOGGLE_BUTTON_LOCK = createTexture("widget/button_lock.png");
    public static final ResourceTexture TOGGLE_BUTTON_VOID = createTexture("widget/button_void.png");

    public static final ResourceTexture OVERLAY_PARALLEL_CONFIGURATOR = createTexture("overlay/parallel_configurator.png");

    private static ResourceTexture createTexture(String imageLocation) {
        return new ResourceTexture("epimorphism:textures/gui/%s".formatted(imageLocation));
    }
}
