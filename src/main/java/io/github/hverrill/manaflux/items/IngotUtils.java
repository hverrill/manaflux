package io.github.hverrill.manaflux.items;

import io.github.hverrill.manaflux.Manaflux;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;

import java.util.Locale;

public class IngotUtils {
    public enum Ingots implements ItemConvertible {
        ANCIENT_MANASTEEL_INGOT(Rarity.RARE, true), 
        MANASTEEL_INGOT(Rarity.UNCOMMON, false);

        public final String id;
        public final Item item;

        Ingots(Rarity itemRarity, boolean fireproof){
            id = this.toString().toLowerCase(Locale.ROOT);
            FabricItemSettings itemSettings = new FabricItemSettings().rarity(itemRarity).group(Manaflux.ITEMGROUP);
            if (fireproof) {
                itemSettings = itemSettings.fireproof();
            }
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
        for (Ingots ingot : Ingots.values()){
            System.out.println(ingot.id);
            Registry.register(Registry.ITEM,
                    new Identifier(Manaflux.MOD_ID, ingot.id),
                    ingot.asItem()
            );
        }
    }
}
