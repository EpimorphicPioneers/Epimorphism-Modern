package com.epimorphismmc.epimorphism.common.data;

import com.epimorphismmc.epimorphism.Epimorphism;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class EPTags {
    public static class Blocks {
        public static final TagKey<Block> FILLER_REPLACEABLE = mod("filler_replaceable");

        public static TagKey<Block> forge(String path) {
            return TagKey.create(Registries.BLOCK, new ResourceLocation(path));
        }

        public static TagKey<Block> mod(String path) {
            return TagKey.create(Registries.BLOCK, Epimorphism.id(path));
        }
    }

    public static class Items {
        public static TagKey<Item> forge(String path) {
            return TagKey.create(Registries.ITEM, new ResourceLocation(path));
        }

        public static TagKey<Item> mod(String path) {
            return TagKey.create(Registries.ITEM, Epimorphism.id(path));
        }
    }
}
