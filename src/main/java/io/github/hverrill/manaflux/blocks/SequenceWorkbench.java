package io.github.hverrill.manaflux.blocks;

import io.github.hverrill.manaflux.Manaflux;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

import java.util.Random;

public class SequenceWorkbench {
    public static final String id = "sequence_workbench";
    public static Block SEQUENCE_WORKBENCH = new SequenceWorkbenchBlock(FabricBlockSettings
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
                new Identifier(Manaflux.MOD_ID, id),
                SEQUENCE_WORKBENCH
        );
        Registry.register(
                Registry.ITEM,
                new Identifier(Manaflux.MOD_ID, id),
                new BlockItem(SEQUENCE_WORKBENCH,
                        new FabricItemSettings().group(Manaflux.ITEMGROUP))
        );
    }

    public static class SequenceWorkbenchBlock extends Block {
        public SequenceWorkbenchBlock(Settings settings) {
            super(settings);
        }

        @Environment(EnvType.CLIENT)
        public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
            super.randomDisplayTick(state, world, pos, random);

            for(int i = -2; i <= 2; ++i) {
                for(int j = -2; j <= 2; ++j) {
                    if (i > -2 && i < 2 && j == -1) {
                        j = 2;
                    }

                    if (random.nextInt(16) == 0) {
                        for(int k = 0; k <= 1; ++k) {
                            BlockPos blockPos = pos.add(i, k, j);
                            if (world.getBlockState(blockPos).isOf(Blocks.BOOKSHELF)) {
                                if (!world.isAir(pos.add(i / 2, 0, j / 2))) {
                                    break;
                                }

                                world.addParticle(ParticleTypes.ENCHANT, (double)pos.getX() + 0.5D, (double)pos.getY() + 2.0D, (double)pos.getZ() + 0.5D, (double)((float)i + random.nextFloat()) - 0.5D, (double)((float)k - random.nextFloat() - 1.0F), (double)((float)j + random.nextFloat()) - 0.5D);
                            }
                        }
                    }
                }
            }
        }
    }
}
