package cn.gtcommunity.epimorphism.core.mixins.mc;

import cn.gtcommunity.epimorphism.Epimorphism;
import cn.gtcommunity.epimorphism.client.renderer.handler.block.FenceBlockRenderer;
import net.minecraft.client.resources.model.ModelManager;
import net.minecraft.server.packs.resources.PreparableReloadListener;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.util.profiling.ProfilerFiller;
import net.minecraftforge.fml.ModLoader;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

@Mixin(value = ModelManager.class)
public abstract class ModelManagerMixin {
    @Inject(method = "reload", at = @At(value = "HEAD"))
    private void loadDynamicModels(PreparableReloadListener.PreparationBarrier preparationBarrier, ResourceManager resourceManager, ProfilerFiller preparationsProfiler, ProfilerFiller reloadProfiler, Executor backgroundExecutor, Executor gameExecutor, CallbackInfoReturnable<CompletableFuture<Void>> cir) {
        if (!ModLoader.isLoadingStateValid()) return;

        long startTime = System.currentTimeMillis();
        // turns out these do have to be init in here after all, as they check for asset existence. whoops.
        FenceBlockRenderer.reinitModels();
        Epimorphism.logger().info("Epimorphism Model loading took {}ms", System.currentTimeMillis() - startTime);
    }
}
