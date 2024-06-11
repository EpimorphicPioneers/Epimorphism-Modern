package com.epimorphismmc.epimorphism.integration.kjs;

import com.epimorphismmc.epimorphism.common.data.EPBlocks;
import com.epimorphismmc.epimorphism.common.data.EPElements;
import com.epimorphismmc.epimorphism.common.data.EPItems;
import com.epimorphismmc.epimorphism.common.data.EPMachines;
import com.epimorphismmc.epimorphism.common.data.EPMaterials;
import com.epimorphismmc.epimorphism.common.data.EPRecipeModifiers;
import com.epimorphismmc.epimorphism.common.data.EPRecipeTypes;

import dev.latvian.mods.kubejs.KubeJSPlugin;
import dev.latvian.mods.kubejs.script.BindingsEvent;
import dev.latvian.mods.kubejs.script.ScriptType;
import dev.latvian.mods.kubejs.util.ClassFilter;

public class EPKubejsPlugin extends KubeJSPlugin {
    @Override
    public void registerClasses(ScriptType type, ClassFilter filter) {
        super.registerClasses(type, filter);
        filter.allow("com.epimorphismmc.epimorphism");
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
