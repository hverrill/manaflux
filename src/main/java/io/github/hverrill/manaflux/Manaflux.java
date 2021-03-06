package io.github.hverrill.manaflux;

import io.github.hverrill.manaflux.items.IngotUtils.Ingots;
import io.github.hverrill.manaflux.registry.ModBlocks;
import io.github.hverrill.manaflux.registry.ModItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class Manaflux implements ModInitializer {
	public static final String MOD_ID = "manaflux";
	public static final ItemGroup ITEMGROUP = FabricItemGroupBuilder.build(
			new Identifier(MOD_ID, "general"),
			() -> new ItemStack(Ingots.MANASTEEL_INGOT));

	@Override
	public void onInitialize() {
		ModItems.registerItems();
		ModBlocks.registerBlocks();
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		System.out.println("Manaflux Core Initialized");
	}
}
