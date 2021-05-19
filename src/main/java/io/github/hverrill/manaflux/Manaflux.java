package io.github.hverrill.manaflux;

import io.github.hverrill.manaflux.registry.ModItems;
import net.fabricmc.api.ModInitializer;

public class Manaflux implements ModInitializer {
	@Override
	public void onInitialize() {
		ModItems.registerItems();
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		System.out.println("Hello Fabric world!");
	}
}
