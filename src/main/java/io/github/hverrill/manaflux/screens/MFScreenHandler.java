package io.github.hverrill.manaflux.screens;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.screen.ScreenHandlerType;

public class MFScreenHandler {
    public static ScreenHandlerType<AlloyForgeScreenHandler> ALLOY_FORGE;

    static {
        //ALLOY_FORGE = ScreenHandlerRegistry.registerSimple(id("alloy_forge"), AlloyForgeScreenHandler::new);
    }

    public static void init() {
        initializeClient();
    }

    @Environment(EnvType.CLIENT)
    public static void initializeClient() {
        //ScreenRegistry.register(MFScreenHandler.ALLOY_FORGE, AlloyForgeScreenHandler::new);
    }
}
