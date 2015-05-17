package me.harrysmc.craftingplus.craftingrecipe;

import me.harrysmc.craftingplus.CraftingPlus;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapedRecipe;

/**
 * Created by HarrysMc on 17/05/2015.
 */
public class ShapedCraftingRecipe extends CraftingRecipe{

    ShapedRecipe recipe;


    public ShapedCraftingRecipe(CraftingPlus plugin, String name, ItemStack itemStack, String[] pattern){

        super(plugin, name, itemStack);

        recipe = new ShapedRecipe(itemStack);
        recipe.shape(pattern);

    }

    public ShapedCraftingRecipe setIngredient(char key, Material ingredient){

        setIngredient(key, ingredient, 0);

        return this;

    }

    public ShapedCraftingRecipe setIngredient(char key, Material ingredient, int data){

        recipe.setIngredient(key, ingredient, data);

        return this;

    }


    @Override
    public Recipe getRecipe() {
        return recipe;
    }
    
}
