package io.github.hverrill.manaflux.blocks;

import io.github.hverrill.manaflux.Manaflux;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

import java.util.Random;

public class Plating {
    public static final String id = "plating";
    public static Block PLATING = new Block(FabricBlockSettings
            /* Block Settings: */
            .of(Material.METAL)
            .strength(1.0f, 1.0f)
            .sounds(BlockSoundGroup.METAL)
    );

    public static void init () {
        Registry.register(
                Registry.BLOCK,
                new Identifier(Manaflux.MOD_ID, id),
                PLATING
        );
        Registry.register(
                Registry.ITEM,
                new Identifier(Manaflux.MOD_ID, id),
                new BlockItem(PLATING,
                        new FabricItemSettings().group(Manaflux.ITEMGROUP))
        );
    }
}
