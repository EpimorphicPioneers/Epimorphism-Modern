package cn.gtcommunity.epimorphism.api.machine.fancyconfigurator;

import com.gregtechceu.gtceu.api.gui.GuiTextures;
import com.gregtechceu.gtceu.api.gui.fancy.IFancyConfigurator;
import com.gregtechceu.gtceu.data.lang.LangHandler;
import com.lowdragmc.lowdraglib.gui.editor.ColorPattern;
import com.lowdragmc.lowdraglib.gui.texture.GuiTextureGroup;
import com.lowdragmc.lowdraglib.gui.texture.IGuiTexture;
import com.lowdragmc.lowdraglib.gui.texture.ResourceBorderTexture;
import com.lowdragmc.lowdraglib.gui.texture.TextTexture;
import com.lowdragmc.lowdraglib.gui.widget.ButtonWidget;
import com.lowdragmc.lowdraglib.gui.widget.ImageWidget;
import com.lowdragmc.lowdraglib.gui.widget.Widget;
import com.lowdragmc.lowdraglib.gui.widget.WidgetGroup;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class CustomModeFancyConfigurator implements IFancyConfigurator {

    private final String name;
    private final IGuiTexture icon;
    public final int modes;
    public final boolean hasModeTooltip;

    private final Function<Integer, String> modeNameGetter;
    private final Supplier<Integer> modeGetter;
    private final Consumer<Integer> modeSetter;

    public CustomModeFancyConfigurator(String name, IGuiTexture icon, int modes, boolean hasModeTooltip,
                                       Function<Integer, String> modeNameGetter,
                                       Supplier<Integer> modeGetter,
                                       Consumer<Integer> modeSetter) {
        this.name = name;
        this.icon = icon;
        this.modes = modes;
        this.hasModeTooltip = hasModeTooltip;
        this.modeNameGetter = modeNameGetter;
        this.modeGetter = modeGetter;
        this.modeSetter = modeSetter;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("gui.epimorphism.%s.title".formatted(name));
    }

    @Override
    public IGuiTexture getIcon() {
        return icon;
    }

    @Override
    public Widget createConfigurator() {
        WidgetGroup group = new WidgetGroup(0, 0, 140, 20 * modes + 4);
        group.setBackground(GuiTextures.BACKGROUND_INVERSE);

        for (int i = 0; i < modes; ++i) {
            int tMode = i;
            var button = new ButtonWidget(2, 2 + i * 20, 136, 20, IGuiTexture.EMPTY, cd -> modeSetter.accept(tMode));
            if (hasModeTooltip) button.setHoverTooltips(List.copyOf(LangHandler.getSingleOrMultiLang((modeNameGetter.apply(tMode) + ".desc"))));
            group.addWidget(button);
            group.addWidget(new ImageWidget(2, 2 + i * 20, 136, 20,
                    () -> new GuiTextureGroup(ResourceBorderTexture.BUTTON_COMMON.copy()
                            .setColor(modeGetter.get() == tMode ? ColorPattern.CYAN.color : -1),
                            new TextTexture(modeNameGetter.apply(tMode))
                                    .setWidth(136)
                                    .setType(TextTexture.TextType.ROLL))));
        }

        return group;
    }

    @Override
    public List<Component> getTooltips() {
        return List.copyOf(LangHandler.getSingleOrMultiLang(("gui.epimorphism.%s.desc".formatted(name))));
    }

    @Override
    public void writeInitialData(FriendlyByteBuf buffer) {
        buffer.writeVarInt(modeGetter.get());
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void readInitialData(FriendlyByteBuf buffer) {
        modeSetter.accept(buffer.readVarInt());
    }

    @Override
    public void detectAndSendChange(BiConsumer<Integer, Consumer<FriendlyByteBuf>> sender) {
        sender.accept(0, buf -> buf.writeVarInt(modeGetter.get()));
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void readUpdateInfo(int id, FriendlyByteBuf buffer) {
        if (id == 0) {
           modeSetter.accept(buffer.readVarInt());
        }
    }
}
