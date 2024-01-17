package cn.gtcommunity.epimorphism.common.machine.multiblock.part;

/*
 * Referenced some code from GoodGenerator
 *
 * https://github.com/GTNewHorizons/GoodGenerator
 * */

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.gui.GuiTextures;
import com.gregtechceu.gtceu.api.gui.UITemplate;
import com.gregtechceu.gtceu.api.gui.fancy.FancyMachineUIWidget;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.multiblock.part.MultiblockPartMachine;
import com.gregtechceu.gtceu.api.machine.multiblock.part.TieredIOPartMachine;
import com.gregtechceu.gtceu.api.machine.multiblock.part.TieredPartMachine;
import com.lowdragmc.lowdraglib.gui.modular.ModularUI;
import com.lowdragmc.lowdraglib.gui.widget.LabelWidget;
import com.lowdragmc.lowdraglib.gui.widget.TextFieldWidget;
import com.lowdragmc.lowdraglib.gui.widget.Widget;
import com.lowdragmc.lowdraglib.gui.widget.WidgetGroup;
import com.lowdragmc.lowdraglib.syncdata.annotation.DescSynced;
import com.lowdragmc.lowdraglib.syncdata.annotation.Persisted;
import com.lowdragmc.lowdraglib.syncdata.field.ManagedFieldHolder;
import com.lowdragmc.lowdraglib.utils.Position;
import com.lowdragmc.lowdraglib.utils.Size;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.entity.player.Player;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class NeutronSensorMachine extends TieredPartMachine {
    protected static final ManagedFieldHolder MANAGED_FIELD_HOLDER = new ManagedFieldHolder(NeutronSensorMachine.class, MultiblockPartMachine.MANAGED_FIELD_HOLDER);

    @Persisted
    private String text = "";

    public NeutronSensorMachine(IMachineBlockEntity holder) {
        super(holder, GTValues.IV);
    }

    //////////////////////////////////////
    //**********     GUI     ***********//
    //////////////////////////////////////
    @Override
    public Widget createUIWidget() {
        return new WidgetGroup(Position.ORIGIN, new Size(176, 112))
                .addWidget(new TextFieldWidget(8, 60, 100, 18,
                        () -> text,
                        this::setText));
    }

    //////////////////////////////////////
    //**********     Data     **********//
    //////////////////////////////////////


    public void setText(String text) {
        if (isValidSuffix(text)) {
            this.text = text;
        }
    }

    @Override
    public ManagedFieldHolder getFieldHolder() {
        return MANAGED_FIELD_HOLDER;
    }

    private boolean isValidSuffix(String string) {
        int index;
        index = string.length() - 1;
        if (index < 0) return false;

        if (string.charAt(index) != 'V' && string.charAt(index) != 'v') return false;

        index = string.length() - 2;
        if (index < 0) return false;

        if (string.charAt(index) != 'E' && string.charAt(index) != 'e') return false;

        index = string.length() - 3;
        if (index < 0) return false;

        return string.charAt(index) == 'M'
                || string.charAt(index) == 'm'
                || string.charAt(index) == 'K'
                || string.charAt(index) == 'k'
                || Character.isDigit(string.charAt(index));
    }
}
