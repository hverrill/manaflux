package io.github.hverrill.manaflux.blocks.entity;

import io.github.hverrill.manaflux.screens.AlloyForgeScreenHandler;
import io.github.hverrill.manaflux.screens.MFScreenHandler;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.recipe.RecipeType;
import net.minecraft.screen.FurnaceScreenHandler;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;

public class AlloyForgeBlockEntity extends AbstractAlloyForgeBlockEntity{
    public AlloyForgeBlockEntity() {
        super(BlockEntityType.FURNACE, RecipeType.SMELTING);
    }

    protected Text getContainerName() {
        return new TranslatableText("container.furnace");
    }

    protected ScreenHandler createScreenHandler(int syncId, PlayerInventory playerInventory) {
        return new AlloyForgeScreenHandler(syncId, playerInventory, this, this.propertyDelegate);
    }
}
