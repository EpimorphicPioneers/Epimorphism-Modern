package cn.gtcommunity.epimorphism.client.renderer.handler.machine;

import cn.gtcommunity.epimorphism.Epimorphism;
import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.capability.IWorkable;
import com.gregtechceu.gtceu.api.machine.MachineDefinition;
import com.gregtechceu.gtceu.api.machine.MetaMachine;
import com.gregtechceu.gtceu.client.model.WorkableOverlayModel;
import com.gregtechceu.gtceu.client.renderer.machine.MachineRenderer;
import com.gregtechceu.gtceu.client.renderer.machine.TransformerRenderer;
import com.lowdragmc.lowdraglib.client.bakedpipeline.FaceQuad;
import com.lowdragmc.lowdraglib.client.model.ModelFactory;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.model.ModelState;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.function.Consumer;

@MethodsReturnNonnullByDefault
public class LightningRodRenderer extends MachineRenderer {

    protected final WorkableOverlayModel overlayModel;

    public LightningRodRenderer(int tier, ResourceLocation workableModel) {
        super(Epimorphism.id("block/machine/hull_machine_top"));
        this.setTextureOverride(Map.of("bottom", GTCEu.id("block/casings/voltage/%s/bottom".formatted(GTValues.VN[tier].toLowerCase(Locale.ROOT))), "top", GTCEu.id("block/casings/fusion/fusion_casing"), "side", GTCEu.id("block/casings/voltage/%s/side".formatted(GTValues.VN[tier].toLowerCase(Locale.ROOT)))));
        this.overlayModel = new WorkableOverlayModel(workableModel);
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void renderMachine(List<BakedQuad> quads, MachineDefinition definition, @Nullable MetaMachine machine, Direction frontFacing, @Nullable Direction side, RandomSource rand, Direction modelFacing, ModelState modelState) {
        super.renderMachine(quads, definition, machine, frontFacing, side, rand, modelFacing, modelState);
        if (!(side == Direction.UP || side == Direction.DOWN) && modelFacing != null) {
            quads.add(FaceQuad.bakeFace(modelFacing, ModelFactory.getBlockSprite(TransformerRenderer.ENERGY_OUT_HI), modelState, 2));
        }

        if (machine instanceof IWorkable workable) {
            quads.addAll(this.overlayModel.bakeQuads(side, frontFacing, workable.isActive(), workable.isWorkingEnabled()));
        } else {
            quads.addAll(this.overlayModel.bakeQuads(side, frontFacing, false, false));
        }

    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public @NotNull TextureAtlasSprite getParticleTexture() {
        return Minecraft.getInstance().getTextureAtlas(InventoryMenu.BLOCK_ATLAS).apply(this.override.get("side"));
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void onPrepareTextureAtlas(ResourceLocation atlasName, Consumer<ResourceLocation> register) {
        super.onPrepareTextureAtlas(atlasName, register);
        if (atlasName.equals(TextureAtlas.LOCATION_BLOCKS)) {
            this.overlayModel.registerTextureAtlas(register);
        }
    }
}
