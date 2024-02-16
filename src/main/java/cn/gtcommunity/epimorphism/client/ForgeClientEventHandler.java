package cn.gtcommunity.epimorphism.client;

import cn.gtcommunity.epimorphism.Epimorphism;
import cn.gtcommunity.epimorphism.client.renderer.handler.StructureSelectRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.RenderLevelStageEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Epimorphism.MOD_ID,  bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
@OnlyIn(Dist.CLIENT)
public class ForgeClientEventHandler {

    @SubscribeEvent
    public static void onRenderWorldLast(RenderLevelStageEvent event) {
        var stage = event.getStage();
        if (stage == RenderLevelStageEvent.Stage.AFTER_TRIPWIRE_BLOCKS) {
            StructureSelectRenderer.renderStructureSelect(event.getPoseStack(), event.getCamera());
        }
    }

//    @SubscribeEvent
//    public static void registerItemStackCapabilities(RenderHighlightEvent.Block event) {
//        var blockEntity = Minecraft.getInstance().level.getBlockEntity(event.getTarget().getBlockPos());
//        if (blockEntity != null) {
//            blockEntity.getCapability(ForgeCapabilities.ITEM_HANDLER).ifPresent((handler) -> {
//                new VisualInventoryRenderer(blockEntity.getBlockState().getBlock().getDescriptionId(), Arrays.asList(Items.BAMBOO.getDefaultInstance(), Items.TNT.getDefaultInstance(), Items.ACACIA_BUTTON.getDefaultInstance()))
//                        .render(event.getTarget().getBlockPos().getCenter(), event.getPoseStack(), event.getCamera());
//            });
//        }
//    }
//    @SubscribeEvent
//    public static void onClientUpdate(TickEvent.ClientTickEvent event) {
//        RayTraceResult ray = Minecraft.getInstance().objectMouseOver;
//        if (ray == null) return;
//
//        if (ray.typeOfHit == RayTraceResult.Type.BLOCK)
//        {
//            final TileEntity tileEntity = world.getTileEntity(ray.getBlockPos());
//            if (tileEntity == null || !Helper.accept(tileEntity) || Helper.banned.contains(tileEntity.getClass().getCanonicalName())) return;
//            HoloInventory.getSnw().sendToServer(new TileRequest(world.provider.getDimension(), ray.getBlockPos()));
//        }
//        else if (ray.typeOfHit == RayTraceResult.Type.ENTITY && Helper.accept(ray.entityHit))
//        {
//            HoloInventory.getSnw().sendToServer(new EntityRequest(world.provider.getDimension(), ray.entityHit.getEntityId()));
//        }
//    }
}
