package cn.gtcommunity.epimorphism.api.gui;

import com.lowdragmc.lowdraglib.gui.texture.ResourceBorderTexture;
import com.lowdragmc.lowdraglib.gui.texture.ResourceTexture;

public class EPGuiTextures {
    public static final ResourceTexture PROGRESS_BAR_RADIATION_HATCH = createTexture("progress_bar/progress_bar_radiation_hatch.png");
    public static final ResourceTexture PROGRESS_BAR_SIEVERT = createTexture("progress_bar/progress_bar_sievert.png");

    public static final ResourceTexture BAR_CONTAINER_SIEVERT = createTexture("progress_bar/bar_container_sievert.png");
    public static final ResourceTexture PROGRESS_BAR_DECAY_TIME = createTexture("progress_bar/progress_bar_decay_time.png");
    public static final ResourceTexture BAR_CONTAINER_DECAY_TIME = createTexture("progress_bar/bar_container_decay_time.png");

    public static final ResourceBorderTexture BUTTON_NO_BORDER = createBorderTexture("widget/button_no_border.png", 32, 32, 1, 1);
    public static final ResourceBorderTexture BUTTON_HALF_NO_BORDER = createBorderTexture("widget/button_half_no_border.png", 32, 32, 1, 1);

    public static final ResourceTexture TOGGLE_BUTTON_LOCK = createTexture("widget/button_lock.png");
    public static final ResourceTexture TOGGLE_BUTTON_VOID = createTexture("widget/button_void.png");
    public static final ResourceTexture TOGGLE_BUTTON_SELECTED = createTexture("widget/button_selected.png");

    public static final ResourceTexture OVERLAY_PARALLEL_CONFIGURATOR = createTexture("overlay/parallel_configurator.png");

    private static ResourceTexture createTexture(String imageLocation) {
        return new ResourceTexture("epimorphism:textures/gui/%s".formatted(imageLocation));
    }

    private static ResourceBorderTexture createBorderTexture(String imageLocation, int imageWidth, int imageHeight, int cornerWidth, int cornerHeight) {
        return new ResourceBorderTexture("epimorphism:textures/gui/%s".formatted(imageLocation), imageWidth, imageHeight, cornerWidth, cornerHeight);
    }
}
