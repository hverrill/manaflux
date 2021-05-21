package io.github.hverrill.manaflux.blocks;

import io.github.hverrill.manaflux.Manaflux;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
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

    public static class AlloyForgeBlock extends HorizontalFacingBlock {
        public AlloyForgeBlock(Settings settings) {
            super(settings);
            setDefaultState(this.stateManager.getDefaultState().with(Properties.HORIZONTAL_FACING, Direction.NORTH));
        }

        @Override
        protected void appendProperties(StateManager.Builder<Block, BlockState> stateManager) {
            stateManager.add(Properties.HORIZONTAL_FACING);
        }

        @Override
        @SuppressWarnings("deprecation")
        public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
            // Direction dir = state.get(FACING);
            return VoxelShapes.fullCube();
        }
        public BlockState getPlacementState(ItemPlacementContext ctx) {
            return (BlockState)this.getDefaultState().with(Properties.HORIZONTAL_FACING, ctx.getPlayerFacing().getOpposite());
        }
    }
}
