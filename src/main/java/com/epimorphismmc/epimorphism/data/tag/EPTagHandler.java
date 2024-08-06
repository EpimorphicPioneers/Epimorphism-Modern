package com.epimorphismmc.epimorphism.data.tag;

import com.epimorphismmc.epimorphism.common.data.EPTags;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import com.tterrag.registrate.providers.RegistrateTagsProvider;

public class EPTagHandler {
    public static void block(RegistrateTagsProvider<Block> provider) {
        provider.addTag(EPTags.Blocks.FILLER_REPLACEABLE).addTag(BlockTags.REPLACEABLE);
    }

    public static void item(RegistrateTagsProvider<Item> provider) {}
}
