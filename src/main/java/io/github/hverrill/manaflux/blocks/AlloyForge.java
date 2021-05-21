package io.github.hverrill.manaflux.blocks;

import io.github.hverrill.manaflux.Manaflux;
import io.github.hverrill.manaflux.blocks.entity.AlloyForgeBlockEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

import java.util.Random;

public class AlloyForge{
    public static final String id = "alloy_forge";
    public static Block ALLOY_FORGE = new AlloyForgeBlock(FabricBlockSettings
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

    public static class AlloyForgeBlock extends AbstractAlloyForgeBlock {
        protected AlloyForgeBlock(AbstractBlock.Settings settings) {
            super(settings);
        }

        public BlockEntity createBlockEntity(BlockView world) {
            return new AlloyForgeBlockEntity();
        }

        protected void openScreen(World world, BlockPos pos, PlayerEntity player) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof AlloyForgeBlockEntity) {
                player.openHandledScreen((NamedScreenHandlerFactory)blockEntity);
                //player.incrementStat(Stats.INTERACT_WITH_FURNACE);
            }

        }

        @Environment(EnvType.CLIENT)
        public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
            if (state.get(LIT)) {
                double d = (double)pos.getX() + 0.5D;
                double e = pos.getY();
                double f = (double)pos.getZ() + 0.5D;
                if (random.nextDouble() < 0.1D) {
                    world.playSound(d, e, f, SoundEvents.BLOCK_FURNACE_FIRE_CRACKLE, SoundCategory.BLOCKS, 1.0F, 1.0F, false);
                }

                Direction direction = state.get(FACING);
                Direction.Axis axis = direction.getAxis();
                double g = 0.52D;
                double h = random.nextDouble() * 0.6D - 0.3D;
                double i = axis == Direction.Axis.X ? (double)direction.getOffsetX() * 0.52D : h;
                double j = random.nextDouble() * 6.0D / 16.0D;
                double k = axis == Direction.Axis.Z ? (double)direction.getOffsetZ() * 0.52D : h;
                world.addParticle(ParticleTypes.SMOKE, d + i, e + j, f + k, 0.0D, 0.0D, 0.0D);
                world.addParticle(ParticleTypes.FLAME, d + i, e + j, f + k, 0.0D, 0.0D, 0.0D);
            }
        }
    }
}
