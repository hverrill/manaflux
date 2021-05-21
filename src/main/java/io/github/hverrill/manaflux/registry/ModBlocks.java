package io.github.hverrill.manaflux.registry;

import io.github.hverrill.manaflux.blocks.AlloyForge;
import io.github.hverrill.manaflux.blocks.CompositeBlockUtils;
import io.github.hverrill.manaflux.blocks.Plating;
import io.github.hverrill.manaflux.blocks.SequenceWorkbench;

public class ModBlocks {
    public static void registerBlocks(){
        SequenceWorkbench.init();
        CompositeBlockUtils.init();
        AlloyForge.init();
        Plating.init();
    }
}
