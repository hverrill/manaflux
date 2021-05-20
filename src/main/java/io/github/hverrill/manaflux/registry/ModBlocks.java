package io.github.hverrill.manaflux.registry;

import io.github.hverrill.manaflux.blocks.CompositeBlocks;
import io.github.hverrill.manaflux.blocks.SequenceWorkbench;

public class ModBlocks {
    public static void registerBlocks(){
        SequenceWorkbench.init();
        CompositeBlocks.init();
    }
}
