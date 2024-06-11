package com.epimorphismmc.epimorphism.common.machine.multiblock.part;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.gui.GuiTextures;
import com.gregtechceu.gtceu.api.gui.widget.ToggleButtonWidget;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.multiblock.part.TieredPartMachine;
import com.gregtechceu.gtceu.data.lang.LangHandler;
import com.gregtechceu.gtceu.utils.RedstoneUtil;

import com.lowdragmc.lowdraglib.gui.editor.ColorPattern;
import com.lowdragmc.lowdraglib.gui.widget.*;
import com.lowdragmc.lowdraglib.syncdata.annotation.DescSynced;
import com.lowdragmc.lowdraglib.syncdata.annotation.Persisted;
import com.lowdragmc.lowdraglib.syncdata.field.ManagedFieldHolder;
import com.lowdragmc.lowdraglib.utils.LocalizationUtils;
import com.lowdragmc.lowdraglib.utils.Position;
import com.lowdragmc.lowdraglib.utils.Size;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.Direction;
import net.minecraft.util.Mth;

import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import javax.annotation.ParametersAreNonnullByDefault;

import static com.epimorphismmc.monomorphism.MOValues.*;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class NeutronSensorPartMachine extends TieredPartMachine {
    protected static final ManagedFieldHolder MANAGED_FIELD_HOLDER = new ManagedFieldHolder(
            NeutronSensorPartMachine.class, TieredPartMachine.MANAGED_FIELD_HOLDER);

    @Setter
    @Persisted
    @DescSynced
    private int min, max;

    @Persisted
    @Setter
    @Getter
    private boolean isInverted;

    @Getter
    @Persisted
    protected int redstoneSignalOutput = 0;

    public NeutronSensorPartMachine(IMachineBlockEntity holder) {
        super(holder, GTValues.IV);
    }

    //////////////////////////////////////
    // **********     GUI     ***********//
    //////////////////////////////////////
    @Override
    public Widget createUIWidget() {
        var group = new WidgetGroup(Position.ORIGIN, new Size(176, 112));

        group.addWidget(new TextBoxWidget(
                8,
                35,
                65,
                List.of(LocalizationUtils.format(
                        "epimorphism.universal.desc.neutron_kinetic_energy.min", "KeV"))));

        group.addWidget(new TextBoxWidget(
                8,
                80,
                65,
                List.of(LocalizationUtils.format(
                        "epimorphism.universal.desc.neutron_kinetic_energy.max", "KeV"))));

        group.addWidget(
                new TextFieldWidget(
                        80,
                        35,
                        85,
                        18,
                        () -> toText(min),
                        stringValue -> setMin(Mth.clamp(fromText(stringValue), 0, max))) {
                    private int maxValue;

                    @Override
                    public void updateScreen() {
                        super.updateScreen();
                        if (maxValue != max) {
                            maxValue = max;
                            setNumbersOnly(0, maxValue);
                        }
                    }
                }.setNumbersOnly(0, max));

        group.addWidget(
                new TextFieldWidget(
                        80,
                        80,
                        85,
                        18,
                        () -> toText(max),
                        stringValue -> setMax(Mth.clamp(fromText(stringValue), min, 1200000))) {
                    private int minValue;

                    @Override
                    public void updateScreen() {
                        super.updateScreen();
                        if (minValue != min) {
                            minValue = min;
                            setNumbersOnly(minValue, 1200000);
                        }
                    }
                }.setNumbersOnly(min, 1200000));

        group.addWidget(
                new ToggleButtonWidget(
                        8, 8, 20, 20, GuiTextures.INVERT_REDSTONE_BUTTON, this::isInverted, this::setInverted) {
                    @Override
                    public void updateScreen() {
                        super.updateScreen();
                        setHoverTooltips(List.copyOf(LangHandler.getMultiLang(
                                "gui.epimorphism.neutron_sensor.invert." + (isPressed ? "enabled" : "disabled"))));
                    }
                });
        group.addWidget(new LabelWidget(80, 13, "1000 KeV = 1 MeV")
                .setTextColor(ColorPattern.BLACK.color)
                .setDropShadow(false));
        return group;
    }

    //////////////////////////////////////
    // ********     Redstone     ********//
    //////////////////////////////////////

    public void update(int energy) {
        int output = RedstoneUtil.computeRedstoneBetweenValues(energy, max * K, min * K, isInverted());
        if (redstoneSignalOutput != output) {
            setRedstoneSignalOutput(output);
        }
    }

    private void setRedstoneSignalOutput(int redstoneSignalOutput) {
        this.redstoneSignalOutput = redstoneSignalOutput;
        updateSignal();
    }

    @Override
    public int getOutputSignal(@Nullable Direction side) {
        if (side == getFrontFacing().getOpposite()) {
            return redstoneSignalOutput;
        }
        return 0;
    }

    @Override
    public boolean canConnectRedstone(Direction side) {
        return false;
    }

    //////////////////////////////////////
    // **********     Data     **********//
    //////////////////////////////////////
    private String toText(int num) {
        return String.valueOf(num);
    }

    private int fromText(String num) {
        return Integer.parseInt(num);
    }

    @Override
    public ManagedFieldHolder getFieldHolder() {
        return MANAGED_FIELD_HOLDER;
    }
}
