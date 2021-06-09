package io.github.hverrill.manaflux.items;

import io.github.hverrill.manaflux.Manaflux;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;

import java.util.Locale;

public class AntennaUtils {
    public static final Item SUBSPACE_ANTENNA = new Item(new FabricItemSettings().rarity(Rarity.RARE).group(Manaflux.ITEMGROUP));

    public static void init() {
        System.out.println("subspace_antenna");
        Registry.register(Registry.ITEM, new Identifier(Manaflux.MOD_ID, "subspace_antenna"), SUBSPACE_ANTENNA);

    }
}