package cn.gtcommunity.epimorphism.client.renderer.handler.machine;

import cn.gtcommunity.epimorphism.Epimorphism;
import cn.gtcommunity.epimorphism.client.ClientUtil;
import cn.gtcommunity.epimorphism.client.utils.RenderHelper;
import cn.gtcommunity.epimorphism.common.machine.multiblock.electric.IndustrialGreenhouseMachine;
import cn.gtcommunity.epimorphism.utils.EPDirectionUtil;
import cn.gtcommunity.epimorphism.utils.EPMathUtil;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.client.renderer.machine.WorkableCasingMachineRenderer;
import com.lowdragmc.lowdraglib.client.bakedpipeline.Quad;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.joml.Vector3f;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IndustrialGreenhouseRenderer extends WorkableCasingMachineRenderer {

    private static final Map<BlockState, List<BakedQuad>> plantQuads = new HashMap<>();

    public IndustrialGreenhouseRenderer(ResourceLocation baseCasing, ResourceLocation workableModel) {
        super(baseCasing, workableModel, false);
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public boolean hasTESR(BlockEntity blockEntity) {
        return true;
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void render(BlockEntity blockEntity, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
        Epimorphism.LOGGER.info("check");
        if (blockEntity instanceof IMachineBlockEntity machineBlockEntity && machineBlockEntity.getMetaMachine() instanceof IndustrialGreenhouseMachine machine && machine.isFormed()) {
            renderCrop(poseStack, buffer, getState(Items.WHEAT_SEEDS, 5), machine.getFrontFacing(), machine.getPos());
        }
    }

    @OnlyIn(Dist.CLIENT)
    public void renderCrop(PoseStack poseStack, MultiBufferSource buffer, BlockState crop, Direction frontFacing, BlockPos blockPos) {
        poseStack.pushPose();
        VertexConsumer builder = buffer.getBuffer(Sheets.cutoutBlockSheet());

        List<BakedQuad> plantQuadList = plantQuads.get(crop);
        if (plantQuadList == null) {
            plantQuadList = new ArrayList<>();

            for (var direction : EPDirectionUtil.VALUES) {
                List<BakedQuad> cropQuad = ClientUtil.blockRenderer().getBlockModel(crop).getQuads(crop, direction, ClientUtil.mc().level.random);
                for (var quad : cropQuad) {
                    for (int j = 0; j < 3; j++) {
                        for (int k = 0; k < 3; k++) {
                            var bakedQuad = Quad.from(quad);
                            for (int i = 0; i < 4; i++) {
                                var pos = bakedQuad.getVert(i);
                                var sideFacing = frontFacing.getClockWise();
                                float x = pos.x() - frontFacing.getStepX() + sideFacing.getStepX();
                                float y = pos.y + 2;
                                float z = pos.z() - frontFacing.getStepZ() + sideFacing.getStepZ();
                                bakedQuad = bakedQuad.withVert(i, new Vector3f(x - frontFacing.getStepX() * j - sideFacing.getStepX() * k, y, z - frontFacing.getStepZ() * j - sideFacing.getStepZ() * k));
                            }
                            plantQuadList.add(bakedQuad.rebake());
                        }
                    }
                }
            }
            List<BakedQuad> cropQuad = ClientUtil.blockRenderer().getBlockModel(crop).getQuads(crop, null, ClientUtil.mc().level.random);
            for (var quad : cropQuad) {
                for (int j = 0; j < 3; j++) {
                    for (int k = 0; k < 3; k++) {
                        var bakedQuad = Quad.from(quad);
                        for (int i = 0; i < 4; i++) {
                            var pos = bakedQuad.getVert(i);
                            var sideFacing = frontFacing.getClockWise();
                            float x = pos.x() - frontFacing.getStepX() + sideFacing.getStepX();
                            float y = pos.y + 2;
                            float z = pos.z() - frontFacing.getStepZ() + sideFacing.getStepZ();
                            bakedQuad = bakedQuad.withVert(i, new Vector3f(x - frontFacing.getStepX() * j - sideFacing.getStepX() * k, y, z - frontFacing.getStepZ() * j - sideFacing.getStepZ() * k));
                        }
                        plantQuadList.add(bakedQuad.rebake());
                    }
                }
            }
            Epimorphism.LOGGER.info(String.valueOf(plantQuadList.isEmpty()));
            plantQuads.put(crop, plantQuadList);
        }
        int col = ClientUtil.mc().getBlockColors().getColor(crop, null, blockPos, -1);
        RenderHelper.renderModelTESRFancy(plantQuadList, builder, poseStack, ClientUtil.mc().level, blockPos, false, col, LightTexture.FULL_BRIGHT);
        poseStack.popPose();
    }
//    @Override
//    @Environment(EnvType.CLIENT)
//    public void renderMachine(List<BakedQuad> quads, MachineDefinition definition, @Nullable MetaMachine machine, Direction frontFacing, @Nullable Direction side, RandomSource rand, Direction modelFacing, ModelState modelState) {
//        super.renderMachine(quads, definition, machine, frontFacing, side, rand, modelFacing, modelState);
//        if (machine instanceof IndustrialGreenhouseMachine greenhouse && greenhouse.isFormed()) {
//            BlockState state = getState(Items.WHEAT_SEEDS, 5);
////            List<BakedQuad> plantQuadList = plantQuads.get(state);
////            if (plantQuadList == null) {
//                List<BakedQuad> cropQuad = ClientUtil.blockRenderer().getBlockModel(state).getQuads(state, side, rand);
//                List<BakedQuad> quadList = new ArrayList<>();
//                for (var quad : cropQuad) {
//                    for (int j = 0; j < 3; j++) {
//                        for (int k = 0; k < 3; k++) {
//                            var bakedQuad = Quad.from(quad);
//                            for (int i = 0; i < 4; i++) {
//                                var pos = bakedQuad.getVert(i);
//                                var sideFacing = frontFacing.getClockWise();
//                                float x = pos.x() - frontFacing.getStepX() + sideFacing.getStepX();
//                                float y = pos.y + 2;
//                                float z = pos.z() - frontFacing.getStepZ() + sideFacing.getStepZ();
//                                bakedQuad = bakedQuad.withVert(i, new Vector3f(x - frontFacing.getStepX() * j - sideFacing.getStepX() * k, y, z - frontFacing.getStepZ() * j - sideFacing.getStepZ() * k));
//                            }
//                            quads.add(bakedQuad.rebake());
//                        }
//                    }
//                }
//                plantQuads.put(state, quadList);
////                plantQuadList = quadList;
////            }
////            quads.addAll(quadList);
//        }
//    }

    private BlockState getState(Item item, int age) {
        age = EPMathUtil.clamp(age, 0, 7);
        return Block.byItem(item).defaultBlockState().setValue(CropBlock.AGE, age);
    }

    @OnlyIn(Dist.CLIENT)
    public float reBakeCustomQuadsOffset() {
        return 0f;
    }
}
