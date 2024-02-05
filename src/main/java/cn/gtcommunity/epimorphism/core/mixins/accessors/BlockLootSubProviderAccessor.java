package cn.gtcommunity.epimorphism.core.mixins.accessors;

import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(BlockLootSubProvider.class)
public interface BlockLootSubProviderAccessor {

    @Accessor("HAS_NO_SHEARS_OR_SILK_TOUCH")
    static LootItemCondition.Builder getHasNoShearsOrSilkTouch() {
        throw new UnsupportedOperationException();
    }
}
