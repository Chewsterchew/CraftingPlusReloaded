package me.harrysmc.craftingplus.craftingrecipe;

import me.harrysmc.craftingplus.CraftingPlus;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;

/**
 * Created by HarrysMc on 17/05/2015.
 */
public abstract class CraftingRecipe {


    CraftingPlus plugin;
    FileConfiguration config;

    String name;


    public CraftingRecipe(CraftingPlus plugin, String name, ItemStack itemStack){
        this.plugin = plugin;
        this.name = name;

        config = plugin.getConfig();
        config.addDefault("enabled." + name, true);
    }

    public void setup(){
        if(!(config.contains("enabled." + name))){
            plugin.getLogger().info("Error loading " + name + " option from config.");
            return;
        }

        if(config.getBoolean("enabled." + name)){
            Bukkit.addRecipe(getRecipe());
        }

    }

    public abstract Recipe getRecipe();

}
