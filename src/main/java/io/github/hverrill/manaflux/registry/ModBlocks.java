package io.github.hverrill.manaflux.registry;

import io.github.hverrill.manaflux.Manaflux;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks {
    public static final Block SEQUENCE_WORKBENCH = new Block(FabricBlockSettings
        /* Block Settings: */
        .of(Material.WOOD)
        .breakByHand(true)
        .strength(1.0f, 1.0f)
        .sounds(BlockSoundGroup.WOOD)
        .nonOpaque()
        );
    public static void registerBlocks(){
        Registry.register(Registry.BLOCK, new Identifier(Manaflux.MOD_ID, "sequence_workbench"), SEQUENCE_WORKBENCH);
    }
}
