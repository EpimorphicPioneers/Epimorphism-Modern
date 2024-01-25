package cn.gtcommunity.epimorphism.common.machine.multiblock.part;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.gui.GuiTextures;
import com.gregtechceu.gtceu.api.gui.widget.ToggleButtonWidget;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.multiblock.part.TieredPartMachine;
import com.gregtechceu.gtceu.data.lang.LangHandler;
import com.lowdragmc.lowdraglib.gui.widget.*;
import com.lowdragmc.lowdraglib.syncdata.annotation.Persisted;
import com.lowdragmc.lowdraglib.syncdata.field.ManagedFieldHolder;
import com.lowdragmc.lowdraglib.utils.LocalizationUtils;
import com.lowdragmc.lowdraglib.utils.Position;
import com.lowdragmc.lowdraglib.utils.Size;
import lombok.Getter;
import lombok.Setter;
import net.minecraft.MethodsReturnNonnullByDefault;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class NeutronSensorMachine extends TieredPartMachine {
    protected static final ManagedFieldHolder MANAGED_FIELD_HOLDER = new ManagedFieldHolder(NeutronSensorMachine.class, TieredPartMachine.MANAGED_FIELD_HOLDER);

    @Persisted
    private String textMin, textMax = "";
    @Persisted
    @Setter @Getter
    private boolean isInverted;

    public NeutronSensorMachine(IMachineBlockEntity holder) {
        super(holder, GTValues.IV);
    }

    //////////////////////////////////////
    //**********     GUI     ***********//
    //////////////////////////////////////
    @Override
    public Widget createUIWidget() {
        var group = new WidgetGroup(Position.ORIGIN, new Size(176, 112));

        group.addWidget(new TextBoxWidget(8, 35, 65,
                List.of(LocalizationUtils.format("epimorphism.universal.desc.neutron_kinetic_energy.min", "KeV"))));

        group.addWidget(new TextBoxWidget(8, 80, 65,
                List.of(LocalizationUtils.format("epimorphism.universal.desc.neutron_kinetic_energy.max", "KeV"))));

        group.addWidget(new TextFieldWidget(80, 35, 85, 18,
                () -> textMin,
                this::setText));

        group.addWidget(new TextFieldWidget(80, 80, 85, 18,
                () -> textMin,
                this::setText));

        group.addWidget(new ToggleButtonWidget(
                8, 8, 20, 20,
                GuiTextures.INVERT_REDSTONE_BUTTON, this::isInverted, this::setInverted
        ) {
            @Override
            public void updateScreen() {
                super.updateScreen();
                setHoverTooltips(List.copyOf(LangHandler.getMultiLang(
                        "cover.advanced_fluid_detector.invert." + (isPressed ? "enabled" : "disabled")
                )));
            }
        });
        return group;
    }

    //////////////////////////////////////
    //**********     Data     **********//
    //////////////////////////////////////


    public void setText(String text) {
        this.textMin = text;
    }

    @Override
    public ManagedFieldHolder getFieldHolder() {
        return MANAGED_FIELD_HOLDER;
    }
}
