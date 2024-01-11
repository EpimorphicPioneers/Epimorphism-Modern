package cn.gtcommunity.epimorphism.core.mixins.accessors.client;

import net.minecraft.client.multiplayer.MultiPlayerGameMode;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(MultiPlayerGameMode.class)
public interface MultiPlayerGameModeAccessor {
    @Accessor
    int getDestroyDelay();

    @Accessor
    void setDestroyDelay(int value);
}
