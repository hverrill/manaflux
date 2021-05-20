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
        protected static final VoxelShape CENTRAL_BOOKSHELF = Block.createCuboidShape(1.0D, 0.0D, 1.0D, 15.0D, 12.0D, 15.0D);
        protected static final VoxelShape TOP_SURFACE = Block.createCuboidShape(0.0D, 12.0D, 0.0D, 16.0D, 14.0D, 16.0D);
        protected static final VoxelShape LEG_ONE = Block.createCuboidShape(0.0D, 0.0D, 0.0D, 3.0D, 12.0D, 3.0D);
        protected static final VoxelShape LEG_TWO = Block.createCuboidShape(13.0D, 0.0D, 0.0D, 16.0D, 12.0D, 3.0D);
        protected static final VoxelShape LEG_THREE = Block.createCuboidShape(0.0D, 0.0D, 13.0D, 3.0D, 12.0D, 16.0D);
        protected static final VoxelShape LEG_FOUR = Block.createCuboidShape(13.0D, 0.0D, 13.0D, 16.0D, 12.0D, 16.0D);
        protected static final VoxelShape PROJECTOR_CENTER = Block.createCuboidShape(5.0D, 14.0D, 5.0D, 11.0D, 15.0D, 11.0D);
        protected static final VoxelShape PROJECTOR_X = Block.createCuboidShape(5.0D, 14.0D, 7.0D, 11.0D, 15.0D, 9.0D);
        protected static final VoxelShape PROJECTOR_Z = Block.createCuboidShape(7.0D, 14.0D, 5.0D, 9.0D, 15.0D, 11.0D);
        protected static final VoxelShape DANGLE_TOP_X = Block.createCuboidShape(5.0D, 11.0D, 0.0D, 11.0D, 12.0D, 16.0D);
        protected static final VoxelShape DANGLE_TOP_Z = Block.createCuboidShape(0.0D, 11.0D, 5.0D, 16.0D, 12.0D, 11.0D);
        protected static final VoxelShape DANGLE_MID_X = Block.createCuboidShape(6.0D, 10.0D, 0.0D, 10.0D, 11.0D, 16.0D);
        protected static final VoxelShape DANGLE_MID_Z = Block.createCuboidShape(0.0D, 10.0D, 6.0D, 16.0D, 11.0D, 10.0D);
        protected static final VoxelShape DANGLE_LOW_X = Block.createCuboidShape(7.0D, 9.0D, 0.0D, 9.0D, 10.0D, 16.0D);
        protected static final VoxelShape DANGLE_LOW_Z = Block.createCuboidShape(0.0D, 9.0D, 7.0D, 16.0D, 10.0D, 9.0D);


        protected static final VoxelShape SHAPE = VoxelShapes.union(
                CENTRAL_BOOKSHELF,TOP_SURFACE,LEG_ONE,LEG_TWO,LEG_THREE,
                LEG_FOUR, PROJECTOR_CENTER, PROJECTOR_X, PROJECTOR_Z,
                DANGLE_TOP_X, DANGLE_TOP_Z, DANGLE_MID_X, DANGLE_MID_Z,
                DANGLE_LOW_X, DANGLE_LOW_Z);

        @Override
        @SuppressWarnings("deprecation")
        public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
            return SHAPE;
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

                                world.addParticle(ParticleTypes.ENCHANT, (double)pos.getX() + 0.5D, (double)pos.getY() + 2.0D, (double)pos.getZ() + 0.5D, (double)((float)i + random.nextFloat()) - 0.5D, (float)k - random.nextFloat() - 1.0F, (double)((float)j + random.nextFloat()) - 0.5D);
                            }
                        }
                    }
                }
            }
        }
    }
}
