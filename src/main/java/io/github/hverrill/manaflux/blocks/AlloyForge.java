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

public class AlloyForge {
    public static final String id = "alloy_forge";
    public static Block ALLOY_FORGE = new Block(FabricBlockSettings
            /* Block Settings: */
            .of(Material.METAL)
            .strength(1.0f, 1.0f)
            .sounds(BlockSoundGroup.NETHERITE)
    );

    public static void init () {
        Registry.register(
                Registry.BLOCK,
                new Identifier(Manaflux.MOD_ID, id),
                ALLOY_FORGE
        );
        Registry.register(
                Registry.ITEM,
                new Identifier(Manaflux.MOD_ID, id),
                new BlockItem(ALLOY_FORGE,
                        new FabricItemSettings().group(Manaflux.ITEMGROUP))
        );
    }
}
