package io.github.hverrill.manaflux.items;

import io.github.hverrill.manaflux.Manaflux;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;

import java.util.Locale;

public class CompositeUtils {
    public enum Composites implements ItemConvertible {
        MANAFLUX_COMPOSITE(Rarity.COMMON), 
        REACTIVE_COMPOSITE(Rarity.UNCOMMON),
        TRANSCENDENT_COMPOSITE(Rarity.RARE);

        public final String id;
        public final Item item;

        Composites(Rarity itemRarity){
            id = this.toString().toLowerCase(Locale.ROOT);
            FabricItemSettings itemSettings = new FabricItemSettings().rarity(itemRarity).group(Manaflux.ITEMGROUP);
            item = new Item(itemSettings);
        }

        @Override
        public Item asItem() {
            return item;
        }
    }

    public static void init () {
        for (Composites ingot : Composites.values()){
            System.out.println(ingot.id);
            Registry.register(Registry.ITEM,
                    new Identifier(Manaflux.MOD_ID, ingot.id),
                    ingot.asItem()
            );
        }
    }
}
