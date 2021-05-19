package io.github.hverrill.manaflux.registry;

import io.github.hverrill.manaflux.Manaflux;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;

import java.util.Locale;

public class CompositeUtils {
    public enum Composites implements ItemConvertible {
        MANAFLUX_COMPOSITE(Rarity.COMMON), 
        REACTIVE_COMPOSITE(Rarity.UNCOMMON),
        TRANSCENDENT_COMPOSITE(Rarity.RARE);

        public final String name;
        public final Item item;

        Composites(Rarity itemRarity){
            name = this.toString().toLowerCase(Locale.ROOT);
            FabricItemSettings itemSettings = new FabricItemSettings().rarity(itemRarity).group(Manaflux.ITEMGROUP);
            item = new Item(itemSettings);
        }

        public ItemStack getStack() {
            return new ItemStack(item);
        }

        public ItemStack getStack(int amount) {
            return new ItemStack(item, amount);
        }

        public boolean hasGlint(ItemStack stack){
            return true;
        }

        @Override
        public Item asItem() {
            return item;
        }
    }

    public static void init () {
        for (Composites ingot : Composites.values()){
            System.out.println(ingot.name);
            Registry.register(Registry.ITEM,
                    new Identifier(Manaflux.MOD_ID, ingot.name),
                    ingot.asItem()
            );
        }
    }
}
