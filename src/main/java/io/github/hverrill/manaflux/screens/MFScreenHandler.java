package io.github.hverrill.manaflux.screens;

import static io.github.hverrill.manaflux.Manaflux.id;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.screen.ScreenHandlerType;

public class MFScreenHandler {
    public static ScreenHandlerType<AlloyForgeScreenHandler> ALLOY_FORGE;

    static {
        ALLOY_FORGE = ScreenHandlerRegistry.registerSimple(id("alloy_forge"), AlloyForgeScreenHandler::new);
    }

    public static void init() {
        initializeClient();
    }

    @Environment(EnvType.CLIENT)
    public static void initializeClient() {
        ScreenRegistry.register(MFScreenHandler.ALLOY_FORGE, AlloyForgeScreenHandler::new);
    }
}
