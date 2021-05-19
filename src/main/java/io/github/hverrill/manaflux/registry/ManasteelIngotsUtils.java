package io.github.hverrill.manaflux.registry;

import io.github.hverrill.manaflux.Manaflux;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;

import java.util.Locale;

public class ManasteelIngotsUtils {
    public enum ManasteelIngots implements ItemConvertible {
        ANCIENT_MANASTEEL_INGOT(Rarity.RARE), MANASTEEL_INGOT(Rarity.UNCOMMON);

        public final String name;
        public final Item item;

        ManasteelIngots(Rarity itemRarity){
            name = this.toString().toLowerCase(Locale.ROOT);
            item = new Item(new Item.Settings().rarity(itemRarity).group(Manaflux.ITEMGROUP));
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
        for (ManasteelIngots ingot : ManasteelIngots.values()){
            System.out.println(ingot.name);
            Registry.register(Registry.ITEM,
                    new Identifier(Manaflux.MOD_ID, ingot.name),
                    ingot.asItem()
            );
        }
    }
}
