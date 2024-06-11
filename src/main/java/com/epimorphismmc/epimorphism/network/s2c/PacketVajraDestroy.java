package com.epimorphismmc.epimorphism.network.s2c;

import com.epimorphismmc.epimorphism.core.mixins.accessors.client.MultiPlayerGameModeAccessor;

import com.lowdragmc.lowdraglib.networking.IHandlerContext;
import com.lowdragmc.lowdraglib.networking.IPacket;

import net.minecraft.client.Minecraft;
import net.minecraft.network.FriendlyByteBuf;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class PacketVajraDestroy implements IPacket {
    private boolean didHarvest;

    @Override
    public void encode(FriendlyByteBuf buf) {
        buf.writeBoolean(didHarvest);
    }

    @Override
    public void decode(FriendlyByteBuf buf) {
        this.didHarvest = buf.readBoolean();
    }

    @Override
    public void execute(IHandlerContext handler) {
        if (handler.isClient() && didHarvest) {
            var gameMode = Minecraft.getInstance().gameMode;
            if (gameMode != null) {
                ((MultiPlayerGameModeAccessor) gameMode).setDestroyDelay(5);
            }
        }
    }
}
