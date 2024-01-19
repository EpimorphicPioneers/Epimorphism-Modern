package cn.gtcommunity.epimorphism.api.machine.fancyconfigurator;

import cn.gtcommunity.epimorphism.api.machine.feature.IParallelMachine;
import com.gregtechceu.gtceu.api.gui.fancy.IFancyConfigurator;
import com.gregtechceu.gtceu.api.gui.widget.IntInputWidget;
import com.lowdragmc.lowdraglib.gui.texture.IGuiTexture;
import com.lowdragmc.lowdraglib.gui.widget.Widget;
import com.lowdragmc.lowdraglib.gui.widget.WidgetGroup;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;

import java.util.ArrayList;
import java.util.List;

import static cn.gtcommunity.epimorphism.api.gui.EPGuiTextures.*;

public class MachineParallelFancyConfigurator implements IFancyConfigurator {
    protected IParallelMachine machine;

    public MachineParallelFancyConfigurator(IParallelMachine machine) {
        this.machine = machine;
    }
    @Override
    public String getTitle() {
        return "gui.epimorphism.machine_parallel.title";
    }

    @Override
    public IGuiTexture getIcon() {
        return OVERLAY_PARALLEL_CONFIGURATOR;
    }

    @Override
    public Widget createConfigurator() {
        WidgetGroup parallelAmountGroup = new WidgetGroup(0, 0, 100, 20);
        parallelAmountGroup.addWidget(new IntInputWidget(machine::getParallelNumber, machine::setParallelNumber) {
            @Override
            public void writeInitialData(FriendlyByteBuf buffer) {
                super.writeInitialData(buffer);
                buffer.writeVarInt(machine.getMaxParallel());
                setMax(machine.getMaxParallel());
            }

            @Override
            public void readInitialData(FriendlyByteBuf buffer) {
                super.readInitialData(buffer);
                setMax(buffer.readVarInt());
            }

            @Override
            public void detectAndSendChanges() {
                super.detectAndSendChanges();
                if (isClientSideWidget) return;

                int newMaxParallel = machine.getMaxParallel();
                if (newMaxParallel != getMax()) {
                    setMax(newMaxParallel);
                    writeUpdateInfo(0, buf -> buf.writeVarInt(newMaxParallel));
                }
            }

            @Override
            public void readUpdateInfo(int id, FriendlyByteBuf buffer) {
                super.readUpdateInfo(id, buffer);
                if (!isClientSideWidget) return;

                if (id == 0) {
                    setMax(buffer.readVarInt());
                }
            }

        }.setMin(1));
        return parallelAmountGroup;
    }

    @Override
    public List<Component> getTooltips() {
        List<Component> tooltip = new ArrayList<>();
        tooltip.add(Component.translatable("gui.epimorphism.change_parallel.desc"));
        return tooltip;
    }
}
