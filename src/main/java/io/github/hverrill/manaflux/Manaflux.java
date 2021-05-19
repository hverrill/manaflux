package io.github.hverrill.manaflux;

import io.github.hverrill.manaflux.registry.ModItems;
import net.fabricmc.api.ModInitializer;
import net.minecraft.item.ItemGroup;

public class Manaflux implements ModInitializer {
	public static final ItemGroup ITEMGROUP = ItemGroup.MISC;
	public static final String MOD_ID = "manaflux";

	@Override
	public void onInitialize() {
		ModItems.registerItems();
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		System.out.println("Hello Fabric world!");
	}
}
