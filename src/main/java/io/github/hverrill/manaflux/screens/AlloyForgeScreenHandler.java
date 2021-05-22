package io.github.hverrill.manaflux.screens;

import io.github.hverrill.manaflux.blocks.entity.AlloyForgeBlockEntity;
import io.github.hverrill.manaflux.screens.slot.AlloyForgeFuelSlot;
import io.github.hverrill.manaflux.screens.slot.AlloyForgeOutputSlot;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.*;
import net.minecraft.recipe.book.RecipeBookCategory;
import net.minecraft.screen.*;
import net.minecraft.screen.slot.Slot;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.world.World;

public class AlloyForgeScreenHandler extends AbstractRecipeScreenHandler<Inventory> {
    private final Inventory inventory;
    /*
    private final PropertyDelegate propertyDelegate;*/
    protected final World world;/*
    private final RecipeType<? extends AbstractCookingRecipe> recipeType;*/
    private final RecipeBookCategory category = RecipeBookCategory.FURNACE;

    public AlloyForgeScreenHandler(int syncId, PlayerInventory inventory) {
        super(MFScreenHandler.ALLOY_FORGE, syncId);
        this.inventory = inventory;
        this.world = inventory.player.world;
    }

    public AlloyForgeScreenHandler(int syncId, PlayerInventory inventory, PacketByteBuf buf) {
        super(MFScreenHandler.ALLOY_FORGE, syncId);
        this.inventory = inventory;
        this.world = inventory.player.world;
    }

    protected AlloyForgeScreenHandler(ScreenHandlerType<?> type, RecipeType<? extends AbstractCookingRecipe> recipeType, RecipeBookCategory recipeBookCategory, int i, PlayerInventory playerInventory) {
        this(type, recipeType, recipeBookCategory, i, playerInventory, new SimpleInventory(3), new ArrayPropertyDelegate(4));
    }

    protected AlloyForgeScreenHandler(ScreenHandlerType<?> type, RecipeType<? extends AbstractCookingRecipe> recipeType, RecipeBookCategory recipeBookCategory, int i, PlayerInventory playerInventory, Inventory inventory, PropertyDelegate propertyDelegate) {
        super(type, i);
        //this.recipeType = recipeType;
        //this.category = recipeBookCategory;
        checkSize(inventory, 3);
        checkDataCount(propertyDelegate, 4);
        this.inventory = inventory;
        //this.propertyDelegate = propertyDelegate;
        this.world = playerInventory.player.world;
        this.addSlot(new Slot(inventory, 0, 56, 17));
        this.addSlot(new AlloyForgeFuelSlot(this, inventory, 1, 56, 53));
        this.addSlot(new AlloyForgeOutputSlot(playerInventory.player, inventory, 2, 116, 35));

        int l;
        for(l = 0; l < 3; ++l) {
            for(int k = 0; k < 9; ++k) {
                this.addSlot(new Slot(playerInventory, k + l * 9 + 9, 8 + k * 18, 84 + l * 18));
            }
        }

        for(l = 0; l < 9; ++l) {
            this.addSlot(new Slot(playerInventory, l, 8 + l * 18, 142));
        }

        this.addProperties(propertyDelegate);
    }

    public void populateRecipeFinder(RecipeFinder finder) {
        if (this.inventory instanceof RecipeInputProvider) {
            ((RecipeInputProvider)this.inventory).provideRecipeInputs(finder);
        }

    }

    public void clearCraftingSlots() {
        this.inventory.clear();
    }

    public void fillInputSlots(boolean craftAll, Recipe<?> recipe, ServerPlayerEntity player) {
        (new FurnaceInputSlotFiller(this)).fillInputSlots(player, recipe, craftAll);
    }

    public boolean matches(Recipe<? super Inventory> recipe) {
        return recipe.matches(this.inventory, this.world);
    }

    public int getCraftingResultSlotIndex() {
        return 2;
    }

    public int getCraftingWidth() {
        return 1;
    }

    public int getCraftingHeight() {
        return 1;
    }

    @Environment(EnvType.CLIENT)
    public int getCraftingSlotCount() {
        return 3;
    }

    public boolean canUse(PlayerEntity player) {
        return this.inventory.canPlayerUse(player);
    }

    public ItemStack transferSlot(PlayerEntity player, int index) {
        ItemStack itemStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);
        if (slot != null && slot.hasStack()) {
            ItemStack itemStack2 = slot.getStack();
            itemStack = itemStack2.copy();
            if (index == 2) {
                if (!this.insertItem(itemStack2, 3, 39, true)) {
                    return ItemStack.EMPTY;
                }

                slot.onStackChanged(itemStack2, itemStack);
            } else if (index != 1 && index != 0) {/*
                if (this.isSmeltable(itemStack2)) {
                    if (!this.insertItem(itemStack2, 0, 1, false)) {
                        return ItemStack.EMPTY;
                    }
                } else*/ if (this.isFuel(itemStack2)) {
                    if (!this.insertItem(itemStack2, 1, 2, false)) {
                        return ItemStack.EMPTY;
                    }
                } else if (index < 30) {
                    if (!this.insertItem(itemStack2, 30, 39, false)) {
                        return ItemStack.EMPTY;
                    }
                } else if (index < 39 && !this.insertItem(itemStack2, 3, 30, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.insertItem(itemStack2, 3, 39, false)) {
                return ItemStack.EMPTY;
            }

            if (itemStack2.isEmpty()) {
                slot.setStack(ItemStack.EMPTY);
            } else {
                slot.markDirty();
            }

            if (itemStack2.getCount() == itemStack.getCount()) {
                return ItemStack.EMPTY;
            }

            slot.onTakeItem(player, itemStack2);
        }

        return itemStack;
    }
/*
    protected boolean isSmeltable(ItemStack itemStack) {
        return this.world.getRecipeManager().getFirstMatch(this.recipeType, new SimpleInventory(itemStack), this.world).isPresent();
    }*/

    public boolean isFuel(ItemStack itemStack) {
        return AlloyForgeBlockEntity.canUseAsFuel(itemStack);
    }
/*
    @Environment(EnvType.CLIENT)
    public int getCookProgress() {
        int i = this.propertyDelegate.get(2);
        int j = this.propertyDelegate.get(3);
        return j != 0 && i != 0 ? i * 24 / j : 0;
    }

    @Environment(EnvType.CLIENT)
    public int getFuelProgress() {
        int i = this.propertyDelegate.get(1);
        if (i == 0) {
            i = 200;
        }

        return this.propertyDelegate.get(0) * 13 / i;
    }

    @Environment(EnvType.CLIENT)
    public boolean isBurning() {
        return this.propertyDelegate.get(0) > 0;
    }
*/
    @Environment(EnvType.CLIENT)
    public RecipeBookCategory getCategory() {
        return this.category;
    }
}
