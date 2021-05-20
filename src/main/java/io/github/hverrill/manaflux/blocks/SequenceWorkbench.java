package io.github.hverrill.manaflux.blocks;

import io.github.hverrill.manaflux.Manaflux;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class SequenceWorkbench {
    public static final String name = "sequence_workbench";
    public static final Block SEQUENCE_WORKBENCH = new Block(FabricBlockSettings
            /* Block Settings: */
            .of(Material.WOOD)
            .breakByHand(true)
            .strength(1.0f, 1.0f)
            .sounds(BlockSoundGroup.WOOD)
            .nonOpaque()
    );

    public static void init () {
        Registry.register(
                Registry.BLOCK,
                new Identifier(Manaflux.MOD_ID, name),
                SEQUENCE_WORKBENCH
        );
        Registry.register(
                Registry.ITEM,
                new Identifier(Manaflux.MOD_ID, name),
                new BlockItem(SEQUENCE_WORKBENCH,
                        new FabricItemSettings().group(Manaflux.ITEMGROUP))
        );
    }
}
