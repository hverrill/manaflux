package io.github.hverrill.manaflux.registry;

import io.github.hverrill.manaflux.blocks.SequenceWorkbench;
import io.github.hverrill.manaflux.items.AntennaUtils;
import io.github.hverrill.manaflux.items.CircuitUtils;
import io.github.hverrill.manaflux.items.CompositeUtils;
import io.github.hverrill.manaflux.items.IngotUtils;

public class ModItems {
    public static void registerItems(){
        
        IngotUtils.init();
        CompositeUtils.init();
        CircuitUtils.init();
        AntennaUtils.init();
    }
}
