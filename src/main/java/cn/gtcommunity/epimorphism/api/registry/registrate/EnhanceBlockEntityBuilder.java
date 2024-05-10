package cn.gtcommunity.epimorphism.api.registry.registrate;

import cn.gtcommunity.epimorphism.api.blockentity.EnhanceBlockEntityType;
import cn.gtcommunity.epimorphism.core.mixins.accessors.BlockEntityBuilderAccessor;
import com.tterrag.registrate.AbstractRegistrate;
import com.tterrag.registrate.builders.BlockEntityBuilder;
import com.tterrag.registrate.builders.BuilderCallback;
import com.tterrag.registrate.util.nullness.NonNullSupplier;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.function.Supplier;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class EnhanceBlockEntityBuilder<T extends BlockEntity, P> extends BlockEntityBuilder<T, P> {

    private boolean ticking = false;

    protected EnhanceBlockEntityBuilder(AbstractRegistrate<?> owner, P parent, String name, BuilderCallback callback, BlockEntityFactory<T> factory) {
        super(owner, parent, name, callback, factory);
    }

    public static <T extends BlockEntity, P> BlockEntityBuilder<T, P> create(AbstractRegistrate<?> owner, P parent,
                                                                             String name, BuilderCallback callback, BlockEntityFactory<T> factory) {
        return new EnhanceBlockEntityBuilder<>(owner, parent, name, callback, factory);
    }

    public BlockEntityBuilder<T, P> ticking() {
        this.ticking = true;
        return this;
    }

    @Override
    protected BlockEntityType<T> createEntry() {
        BlockEntityBuilderAccessor<T> accessor = (BlockEntityBuilderAccessor<T>) this;
        BlockEntityFactory<T> factory = accessor.getFactory();
        Supplier<BlockEntityType<T>> supplier = asSupplier();
        return EnhanceBlockEntityType.builder((pos, state) -> factory.create(supplier.get(), pos, state))
                .addBlocks(accessor.getValidBlocks().stream().map(NonNullSupplier::get).toArray(Block[]::new))
                .setTicking(ticking)
                .build();
    }

}
