package com.epimorphismmc.epimorphism.common.item;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public class EtchedItem extends Item {
    private final Supplier<ItemLike> itemSupplier;
    private final String type;

    public EtchedItem(Properties properties, Supplier<ItemLike> itemSupplier, String type) {
        super(properties);
        this.itemSupplier = itemSupplier;
        this.type = type;
    }

    @Override
    public @NotNull Component getDescription() {
        return Component.translatable("epimorphism.item." + type, itemSupplier.get().asItem().getDescription());
    }

    @Override
    public @NotNull Component getName(@NotNull ItemStack stack) {
        return getDescription();
    }
}
