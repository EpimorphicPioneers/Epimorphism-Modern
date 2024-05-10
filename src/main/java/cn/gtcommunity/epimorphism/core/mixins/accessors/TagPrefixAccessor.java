package cn.gtcommunity.epimorphism.core.mixins.accessors;

import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.api.data.tag.TagType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.List;

@Mixin(value = TagPrefix.class, remap = false)
public interface TagPrefixAccessor {

    @Accessor
    List<TagType> getTags();
}
