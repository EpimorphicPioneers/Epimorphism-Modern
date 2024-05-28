package cn.gtcommunity.epimorphism.api.machine.fancyconfigurator;

import com.gregtechceu.gtceu.api.gui.fancy.IFancyConfiguratorButton;
import com.lowdragmc.lowdraglib.gui.texture.IGuiTexture;
import com.lowdragmc.lowdraglib.gui.util.ClickData;
import net.minecraft.network.chat.Component;

import java.util.List;
import java.util.function.Consumer;

public class ButtonConfigurator implements IFancyConfiguratorButton {

    IGuiTexture base;
    Consumer<ClickData> onClick;
    List<Component> tooltips;

    public ButtonConfigurator(IGuiTexture base, Consumer<ClickData> onClick, List<Component> tooltips) {
        this.base = base;
        this.onClick = onClick;
    }

    @Override
    public List<Component> getTooltips() {
        return tooltips;
    }

    @Override
    public IGuiTexture getIcon() {
        return base;
    }

    @Override
    public void onClick(ClickData clickData) {
        onClick.accept(clickData);
    }
}
