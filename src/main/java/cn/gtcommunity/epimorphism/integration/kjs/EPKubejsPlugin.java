package cn.gtcommunity.epimorphism.integration.kjs;

import cn.gtcommunity.epimorphism.common.data.EPBlocks;
import cn.gtcommunity.epimorphism.common.data.EPElements;
import cn.gtcommunity.epimorphism.common.data.EPItems;
import cn.gtcommunity.epimorphism.common.data.EPMachines;
import cn.gtcommunity.epimorphism.common.data.EPMaterials;
import cn.gtcommunity.epimorphism.common.data.EPRecipeModifiers;
import cn.gtcommunity.epimorphism.common.data.EPRecipeTypes;
import dev.latvian.mods.kubejs.KubeJSPlugin;
import dev.latvian.mods.kubejs.script.BindingsEvent;
import dev.latvian.mods.kubejs.script.ScriptType;
import dev.latvian.mods.kubejs.util.ClassFilter;

public class EPKubejsPlugin extends KubeJSPlugin {
    @Override
    public void registerClasses(ScriptType type, ClassFilter filter) {
        super.registerClasses(type, filter);
        filter.allow("cn.gtcommunity.epimorphism");
    }

    @Override
    public void registerBindings(BindingsEvent event) {
        super.registerBindings(event);

        event.add("EPMaterials", EPMaterials.class);
        event.add("EPElements", EPElements.class);
        event.add("EPBlocks", EPBlocks.class);
        event.add("EPItems", EPItems.class);
        event.add("EPMachines", EPMachines.class);
        event.add("EPRecipeTypes", EPRecipeTypes.class);
        event.add("EPRecipeModifiers", EPRecipeModifiers.class);
    }
}
