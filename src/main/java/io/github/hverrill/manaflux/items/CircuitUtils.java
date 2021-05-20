package io.github.hverrill.manaflux.items;

import io.github.hverrill.manaflux.Manaflux;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;

import java.util.Locale;

public class CircuitUtils {
    public enum Circuits implements ItemConvertible {
        MANAFLUX_CIRCUIT(Rarity.COMMON), 
        CONDUCTIVE_CIRCUIT(Rarity.UNCOMMON),
        HIGH_BANDWIDTH_CIRCUIT(Rarity.RARE);

        public final String id;
        public final Item item;

        Circuits(Rarity itemRarity){
            id = this.toString().toLowerCase(Locale.ROOT);
            FabricItemSettings itemSettings = new FabricItemSettings().rarity(itemRarity).group(Manaflux.ITEMGROUP);
            item = new Item(itemSettings);
        }

        @Override
        public Item asItem() {
            return item;
        }
    }

    public static void init() {
        for (Circuits circuit : Circuits.values()){
            System.out.println(circuit.id);
            Registry.register(Registry.ITEM,
                    new Identifier(Manaflux.MOD_ID, circuit.id),
                    circuit.asItem()
            );
        }
    }
}
