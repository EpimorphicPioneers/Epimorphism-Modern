package cn.gtcommunity.epimorphism.client.renderer.handler.machine;

import cn.gtcommunity.epimorphism.common.machine.multiblock.electric.ChemicalPlantMachine;
import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.machine.MachineDefinition;
import com.gregtechceu.gtceu.api.machine.MetaMachine;
import com.gregtechceu.gtceu.client.model.SpriteOverrider;
import com.gregtechceu.gtceu.client.renderer.machine.WorkableCasingMachineRenderer;
import com.lowdragmc.lowdraglib.LDLib;
import com.lowdragmc.lowdraglib.client.model.ModelFactory;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ChemicalPlantRenderer extends WorkableCasingMachineRenderer {

    @OnlyIn(Dist.CLIENT)
    protected Map<ResourceLocation, Map<Direction, BakedModel>> tierBlockModels;

    public ChemicalPlantRenderer(ResourceLocation workableModel) {
        super(GTCEu.id("block/casings/solid/machine_casing_bronze_plated_bricks"), workableModel, false);
        if (LDLib.isClient()) {
            this.tierBlockModels = new ConcurrentHashMap<>();
        }
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void renderBaseModel(List<BakedQuad> quads, MachineDefinition definition, @Nullable MetaMachine machine, Direction frontFacing, @Nullable Direction side, RandomSource rand) {
        if (machine instanceof ChemicalPlantMachine chemicalPlant && chemicalPlant.isFormed()) {
            quads.addAll(getRotatedModel(frontFacing, ResourceLocation.tryParse(chemicalPlant.getLocation())).getQuads(definition.defaultBlockState(), side, rand));
        } else {
            super.renderBaseModel(quads, definition, machine, frontFacing, side, rand);
        }
    }

    @OnlyIn(Dist.CLIENT)
    private BakedModel getRotatedModel(Direction frontFacing, ResourceLocation location) {
        return tierBlockModels.computeIfAbsent(location, location1 -> {
            var map = new HashMap<Direction, BakedModel>();
            map.put(frontFacing, renderModel(frontFacing, location1));
            return map;
        }).computeIfAbsent(frontFacing, direction -> renderModel(direction, location));
    }

    @OnlyIn(Dist.CLIENT)
    private BakedModel renderModel(Direction frontFacing, ResourceLocation location) {
        return this.getModel().bake(ModelFactory.getModeBaker(), new SpriteOverrider(Map.of("all", location)), ModelFactory.getRotation(frontFacing), this.modelLocation);
    }
}
