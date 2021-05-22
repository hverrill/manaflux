package io.github.hverrill.manaflux.screens.slot;

import io.github.hverrill.manaflux.screens.AlloyForgeScreenHandler;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.screen.slot.Slot;

public class AlloyForgeFuelSlot extends Slot {
    private final AlloyForgeScreenHandler handler;

    public AlloyForgeFuelSlot(AlloyForgeScreenHandler handler, Inventory inventory, int index, int x, int y) {
        super(inventory, index, x, y);
        this.handler = handler;
    }

    public boolean canInsert(ItemStack stack) {
        return this.handler.isFuel(stack) || isBucket(stack);
    }

    public int getMaxItemCount(ItemStack stack) {
        return isBucket(stack) ? 1 : super.getMaxItemCount(stack);
    }

    public static boolean isBucket(ItemStack stack) {
        return stack.getItem() == Items.BUCKET;
    }
}
