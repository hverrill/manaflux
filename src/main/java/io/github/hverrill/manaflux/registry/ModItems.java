package io.github.hverrill.manaflux.registry;

import io.github.hverrill.manaflux.items.CompositeUtils;
import io.github.hverrill.manaflux.items.ManasteelIngotsUtils;

public class ModItems {
    // Create Item Varibles


    public static void registerItems(){
        // Call register line
        ManasteelIngotsUtils.init();
        // IngotItems.register();
        CompositeUtils.init();
    }
}
