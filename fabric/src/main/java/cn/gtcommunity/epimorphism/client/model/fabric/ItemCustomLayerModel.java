//package cn.gtcommunity.epimorphism.client.model.fabric;
//
//import cn.gtcommunity.epimorphism.Epimorphism;
//import com.lowdragmc.lowdraglib.client.model.custommodel.CustomBakedModel;
//import com.lowdragmc.lowdraglib.client.model.fabric.LDLRendererModel;
//import com.lowdragmc.lowdraglib.client.renderer.IBlockRendererProvider;
//import com.lowdragmc.lowdraglib.client.renderer.IRenderer;
//import lombok.Setter;
//import net.fabricmc.fabric.api.client.model.ModelProviderContext;
//import net.fabricmc.fabric.api.client.model.ModelResourceProvider;
//import net.fabricmc.fabric.api.renderer.v1.model.FabricBakedModel;
//import net.fabricmc.fabric.api.renderer.v1.render.RenderContext;
//import net.minecraft.MethodsReturnNonnullByDefault;
//import net.minecraft.client.Minecraft;
//import net.minecraft.client.renderer.block.model.BakedQuad;
//import net.minecraft.client.renderer.block.model.ItemOverrides;
//import net.minecraft.client.renderer.block.model.ItemTransforms;
//import net.minecraft.client.renderer.texture.TextureAtlasSprite;
//import net.minecraft.client.resources.model.*;
//import net.minecraft.core.BlockPos;
//import net.minecraft.core.Direction;
//import net.minecraft.resources.ResourceLocation;
//import net.minecraft.server.packs.resources.ResourceManager;
//import net.minecraft.util.RandomSource;
//import net.minecraft.world.item.ItemStack;
//import net.minecraft.world.level.BlockAndTintGetter;
//import net.minecraft.world.level.block.state.BlockState;
//import org.intellij.lang.annotations.Identifier;
//
//import javax.annotation.Nullable;
//import javax.annotation.ParametersAreNonnullByDefault;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.Reader;
//import java.util.Collection;
//import java.util.Collections;
//import java.util.List;
//import java.util.function.Function;
//import java.util.function.Supplier;
//
//@ParametersAreNonnullByDefault
//@MethodsReturnNonnullByDefault
//public class ItemCustomLayerModel implements UnbakedModel {
//
//    public static final ItemCustomLayerModel INSTANCE = new ItemCustomLayerModel();
//
//    private ItemCustomLayerModel() {/**/}
//    @Override
//    public Collection<ResourceLocation> getDependencies() {
//        return Collections.emptyList();
//    }
//
//    @Override
//    public void resolveParents(Function<ResourceLocation, UnbakedModel> models) {
//
//    }
//
//    @Nullable
//    @Override
//    public BakedModel bake(ModelBaker baker, Function<Material, TextureAtlasSprite> spriteGetter, ModelState state, ResourceLocation location) {
//        return new LDLRendererModel.RendererBakedModel();
//    }
//
//    public static final class RendererBakedModel implements BakedModel, FabricBakedModel {
//        @Setter
//        private IRenderer renderer = IRenderer.EMPTY;
//
//        @Override
//        public List<BakedQuad> getQuads(@Nullable BlockState state, @Nullable Direction direction, RandomSource random) {
//            return Collections.emptyList();
//        }
//
//        @Override
//        public boolean useAmbientOcclusion() {
//            return false;
//        }
//
//        @Override
//        public boolean isGui3d() {
//            return true;
//        }
//
//        @Override
//        public boolean usesBlockLight() {
//            return false;
//        }
//
//        @Override
//        public boolean isCustomRenderer() {
//            return false;
//        }
//
//        @Override
//        public TextureAtlasSprite getParticleIcon() {
//            return renderer.getParticleTexture();
//        }
//
//        @Override
//        public ItemTransforms getTransforms() {
//            return ItemTransforms.NO_TRANSFORMS;
//        }
//
//        @Override
//        public ItemOverrides getOverrides() {
//            return ItemOverrides.EMPTY;
//        }
//
//
//        @Override
//        public boolean isVanillaAdapter() {
//            return false;
//        }
//
//        @Override
//        public void emitBlockQuads(BlockAndTintGetter blockView, BlockState state, BlockPos pos, Supplier<RandomSource> randomSupplier, RenderContext context) {
//            if (state.getBlock() instanceof IBlockRendererProvider rendererProvider) {
//                IRenderer renderer = rendererProvider.getRenderer(state);
//                if (renderer != null) {
//                    context.bakedModelConsumer().accept(new BakedModel() {
//                        @Override
//                        public List<BakedQuad> getQuads(@Nullable BlockState state, @Nullable Direction direction, RandomSource random) {
//                            var quads = renderer.renderModel(blockView, pos, state, direction, random);
//                            if (renderer.reBakeCustomQuads() && state != null) {
//                                return CustomBakedModel.reBakeCustomQuads(quads, blockView, pos, state, direction, renderer.reBakeCustomQuadsOffset());
//                            }
//                            return quads;
//                        }
//
//                        @Override
//                        public boolean useAmbientOcclusion() {
//                            return renderer.useAO(state);
//                        }
//
//                        @Override
//                        public boolean isGui3d() {
//                            return renderer.isGui3d();
//                        }
//
//                        @Override
//                        public boolean usesBlockLight() {
//                            return renderer.useBlockLight(ItemStack.EMPTY);
//                        }
//
//                        @Override
//                        public boolean isCustomRenderer() {
//                            return false;
//                        }
//
//                        @Override
//                        public TextureAtlasSprite getParticleIcon() {
//                            return renderer.getParticleTexture();
//                        }
//
//                        @Override
//                        public ItemTransforms getTransforms() {
//                            return ItemTransforms.NO_TRANSFORMS;
//                        }
//
//                        @Override
//                        public ItemOverrides getOverrides() {
//                            return ItemOverrides.EMPTY;
//                        }
//                    });
//                }
//            }
//        }
//
//        @Override
//        public void emitItemQuads(ItemStack stack, Supplier<RandomSource> randomSupplier, RenderContext context) {
//            /** use mixin {@link com.lowdragmc.lowdraglib.core.mixins.ItemRendererMixin}*/
//        }
//
//    }
//
//    public static final class Loader implements ModelResourceProvider {
//
//        public static final ItemCustomLayerModel.Loader INSTANCE = new ItemCustomLayerModel.Loader();
//        private Loader() {/**/}
//
//        @Override
//        public UnbakedModel loadModelResource(ResourceLocation resourceId, ModelProviderContext context) {
//            return resourceId.equals(new ResourceLocation("epimorphism:item/wrap_circuit")) ? ItemCustomLayerModel.INSTANCE : null;
//        }
//
//        private UnbakedModel loadResource(ResourceLocation resourceId, ModelProviderContext modelProviderContext) {
//            if(resourceId.getPath().endsWith(".obj")) {
//                ResourceManager resourceManager = Minecraft.getInstance().getResourceManager();
//
//                try (Reader reader = new InputStreamReader(resourceManager.getResource(new ResourceLocation(resourceId.getNamespace(), "models/" + resourceId.getPath())).get().open())) {
//                    return loadModel(reader, resourceId.getNamespace(), resourceManager);
//                } catch (IOException e) {
//                    Epimorphism.LOGGER.error("Unable to load OBJ Model, Source: " + resourceId, e);
//                }
//            }
//
//            return null;
//        }
//    }
//}
