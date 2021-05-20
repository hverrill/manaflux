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

import java.util.Locale;

public class CompositeBlocks {
    public static Block COMPOSITE_BLOCK = new Block(FabricBlockSettings
            /* Block Settings: */
            .of(Material.METAL)
            .breakByHand(false)
            .strength(1.0f, 1.0f)
            .sounds(BlockSoundGroup.GILDED_BLACKSTONE)
    );
    public static Block REACTIVE_COMPOSITE_BLOCK = new Block(FabricBlockSettings
            /* Block Settings: */
            .of(Material.METAL)
            .breakByHand(false)
            .strength(1.0f, 1.0f)
            .sounds(BlockSoundGroup.GILDED_BLACKSTONE)
    );
    public static Block TRANSCENDENT_COMPOSITE_BLOCK = new Block(FabricBlockSettings
            /* Block Settings: */
            .of(Material.METAL)
            .breakByHand(false)
            .strength(1.0f, 1.0f)
            .sounds(BlockSoundGroup.GILDED_BLACKSTONE)
    );
    public static void init () {
        //BLOCK
        Registry.register(
                Registry.BLOCK,
                new Identifier(Manaflux.MOD_ID, "composite_block"),
                COMPOSITE_BLOCK
        );
        Registry.register(
                Registry.BLOCK,
                new Identifier(Manaflux.MOD_ID, "reactive_composite_block"),
                REACTIVE_COMPOSITE_BLOCK
        );
        Registry.register(
                Registry.BLOCK,
                new Identifier(Manaflux.MOD_ID, "transcendent_composite_block"),
                TRANSCENDENT_COMPOSITE_BLOCK
        );

        //ITEM
        Registry.register(
                Registry.ITEM,
                new Identifier(Manaflux.MOD_ID, "composite_block"),
                new BlockItem(COMPOSITE_BLOCK,
                        new FabricItemSettings().group(Manaflux.ITEMGROUP))
        );
        Registry.register(
                Registry.ITEM,
                new Identifier(Manaflux.MOD_ID, "reactive_composite_block"),
                new BlockItem(REACTIVE_COMPOSITE_BLOCK,
                        new FabricItemSettings().group(Manaflux.ITEMGROUP))
        );
        Registry.register(
                Registry.ITEM,
                new Identifier(Manaflux.MOD_ID, "transcendent_composite_block"),
                new BlockItem(TRANSCENDENT_COMPOSITE_BLOCK,
                        new FabricItemSettings().group(Manaflux.ITEMGROUP))
        );
        
    }
}
