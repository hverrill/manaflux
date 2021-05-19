package io.github.hverrill.manaflux.registry;

import io.github.hverrill.manaflux.Manaflux;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ManafluxIngots {
    public static final Item MANASTEEL_INGOT = new Item(new FabricItemSettings().group(ItemGroup.MISC));
    public static final Item ANCIENT_MANASTEEL_INGOT = new Item(new FabricItemSettings().group(ItemGroup.MISC));

    public static void register(){
        Registry.register(Registry.ITEM,
                new Identifier(Manaflux.NAMESPACE, "manasteel_ingot"),
                MANASTEEL_INGOT
        );
        Registry.register(Registry.ITEM,
                new Identifier(Manaflux.NAMESPACE, "ancient_manasteel_ingot"),
                ANCIENT_MANASTEEL_INGOT
        );
    }
}
