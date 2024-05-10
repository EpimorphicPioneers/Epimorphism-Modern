package cn.gtcommunity.epimorphism.core.mixins.accessors;

import com.gregtechceu.gtceu.api.data.tag.TagType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value = TagType.class, remap = false)
public interface TagTypeAccessor {

    @Accessor
    String getTagPath();
}
