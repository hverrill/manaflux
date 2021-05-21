package io.github.hverrill.manaflux.blocks;

import io.github.hverrill.manaflux.Manaflux;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;

import java.util.Locale;

public class CompositeBlockUtils {

    public enum CompositeBlocks implements ItemConvertible {
        COMPOSITE_BLOCK(Rarity.COMMON),
        REACTIVE_COMPOSITE_BLOCK(Rarity.UNCOMMON),
        TRANSCENDENT_COMPOSITE_BLOCK(Rarity.RARE);

        public final String id;
        public final Item item;
        public final Block block;

        CompositeBlocks(Rarity itemRarity){
            id = this.toString().toLowerCase(Locale.ROOT);
            block = new Block(FabricBlockSettings
                    /* Block Settings: */
                    .of(Material.METAL)
                    .breakByHand(false)
                    .strength(1.0f, 1.0f)
                    .sounds(BlockSoundGroup.GILDED_BLACKSTONE)
            );
            FabricItemSettings itemSettings = new FabricItemSettings().rarity(itemRarity).group(Manaflux.ITEMGROUP);
            item = new BlockItem(block,itemSettings);
        }

        @Override
        public Item asItem() {
            return item;
        }
    }

    public static void init () {
        for (CompositeBlocks compositeBlock : CompositeBlocks.values()){
            System.out.println(compositeBlock.id);
            Registry.register(
                    Registry.BLOCK,
                    new Identifier(Manaflux.MOD_ID, compositeBlock.id),
                    compositeBlock.block
            );
            Registry.register(Registry.ITEM,
                    new Identifier(Manaflux.MOD_ID, compositeBlock.id),
                    compositeBlock.asItem()
            );
        }
    }
}
