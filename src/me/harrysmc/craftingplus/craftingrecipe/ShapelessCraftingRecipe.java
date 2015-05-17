package me.harrysmc.craftingplus.craftingrecipe;

import me.harrysmc.craftingplus.CraftingPlus;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapelessRecipe;

/**
 * Created by HarrysMc on 17/05/2015.
 */
public class ShapelessCraftingRecipe extends CraftingRecipe {

    ShapelessRecipe recipe;

    public ShapelessCraftingRecipe(CraftingPlus plugin, String name, ItemStack itemStack) {
        super(plugin, name, itemStack);

        recipe = new ShapelessRecipe(itemStack);
    }

    public ShapelessCraftingRecipe addIngredient(int amount, Material ingredient){
        setIngredient(amount, ingredient, 0);
        return this;
    }

    public ShapelessCraftingRecipe setIngredient(int amount, Material ingredient, int data){
        recipe.addIngredient(amount, ingredient, data);
        return this;
    }


    @Override
    public Recipe getRecipe() {
        return recipe;
    }

}
