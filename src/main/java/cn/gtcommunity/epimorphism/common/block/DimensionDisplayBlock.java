package cn.gtcommunity.epimorphism.common.block;

import cn.gtcommunity.epimorphism.api.block.IDimensionDisplay;
import com.gregtechceu.gtceu.api.block.RendererBlock;
import com.lowdragmc.lowdraglib.client.renderer.IRenderer;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class DimensionDisplayBlock extends RendererBlock {
    private IDimensionDisplay display;

    public DimensionDisplayBlock(BlockBehaviour.Properties properties, IRenderer renderer, IDimensionDisplay dimension) {
        super(properties, renderer);
        this.display = dimension;
    }

    public int getDimensionTier() {
        return this.display.getTier();
    }

    public String getDimension() {
        return this.display.getDimension();
    }

    public IDimensionDisplay getDisplay() {
        return this.display;
    }

    public static enum Dimension implements IDimensionDisplay {
        OVERWORLD(0),
        THE_NETHER(0),
        THE_END(0),
        TWILIGHT_FOREST(0),
        MOON(1),
        DEIMOS(2),
        MARS(2),
        PHOBOS(2),
        CALLISTO(3),
        CERES(3),
        EUROPA(3),
        GANYMEDE(3),
        ROSS_128_B(3),
        ASTEROID_BELT(3),
        IO(4),
        VENUS(4),
        MERCURY(4),
        MIRANDA(5),
        OBERON(5),
        ENCELADUS(5),
        ROSS_128_BA(5),
        TITAN(5),
        PROTEUS(6),
        TRITON(6),
        HAUMEA(7),
        KUIPER_BELT(7),
        MAKEMAKE(7),
        PLUTO(7),
        BARNARDA_C(8),
        BARNARDA_E(8),
        BARNARDA_F(8),
        TAU_CETI_E(8),
        VEGA_B(8),
        CENTAURI_BB(8),
        SET(9),
        ANUBIS(9),
        HORUS(9),
        MAAHES(9),
        MEHEN_BELT(9),
        NEPERI(9),
        DEEP_DARK(10);

        private final int tier;

        private Dimension(int tier) {
            this.tier = tier;
        }

        public String getDimension() {
            return this.name().toLowerCase();
        }

        public int getTier() {
            return this.tier;
        }
    }
}
