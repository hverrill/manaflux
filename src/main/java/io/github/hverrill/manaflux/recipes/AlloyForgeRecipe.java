package io.github.hverrill.manaflux.recipes;

import net.java.games.input.Component.Identifier;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.world.World;

public class AlloyForgeRecipe implements Recipe<CraftingInventory> {
	//You can add as much inputs as you want here.
	//It is important to always use Ingredient, so you can support tags.
	private final Ingredient leftIngot;
	private final Ingredient rightIngot;
    private final Ingredient composite;
	private final ItemStack result;
	private final Identifier id;
 
	public AlloyForgeRecipe(Identifier id, ItemStack result, 
            Ingredient leftIngot, Ingredient rightIngot, Ingredient composite) {
		this.id = id;
		this.leftIngot = leftIngot;
        this.rightIngot = rightIngot;
        this.composite = composite;
		this.result = result;
	}
 
	public Ingredient getLeftIngot() { return this.leftIngot; }
	public Ingredient getRightIngot() { return this.rightIngot; }
    public Ingredient getComposite() { return this.rightIngot; }
 
	@Override
	public ItemStack getOutput() {
		return this.result;
	}
 
	// @Override
	// public Identifier getId() {
	// 	return this.id;
	// }
	//[...]
    @Override
	public ItemStack craft(CraftingInventory inv) {
		return this.getOutput().copy();
	}
    @Override 
	public boolean matches(CraftingInventory inv, World world) {
		// if(inv.getInvSize(0 < 2) return false;
		// return leftIngot.test(inventory.getInvStack(0)) 
        //     && composite.test(inventory.getInvStack(1))
        //     && rightIngot.test(inventory.getInvStack(2));
        return false;
	}


    @Override
    public boolean fits(int width, int height) {
        // TODO Auto-generated method stub
        return false;
    }
    @Override
    public RecipeSerializer<?> getSerializer() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public RecipeType<?> getType() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public net.minecraft.util.Identifier getId() {
        // TODO Auto-generated method stub
        return null;
    }
}