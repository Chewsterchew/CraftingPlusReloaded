package me.harrysmc.craftingplus.craftingrecipe;

import me.harrysmc.craftingplus.CraftingPlus;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;

import java.util.logging.Logger;

/**
 * Created by HarrysMc on 17/05/2015.
 */
public abstract class CraftingRecipe {


    CraftingPlus plugin;
    FileConfiguration config;
    Logger log;

    String name;


    public CraftingRecipe(CraftingPlus plugin, String name, ItemStack itemStack){

        this.plugin = plugin;
        this.name = name;

        log = plugin.getLogger();
        config = plugin.getConfig();
        config.addDefault("enabled." + name, true);
        plugin.saveConfig();

    }

    public void setup(){

        if(!(config.contains("enabled." + name))){
            plugin.getLogger().info("Error loading " + name + " option from config.");
            return;
        }

        if(config.getBoolean("enabled." + name)){
            addRecipe();
            log.info("HERE");
        }

        log.info("TEST 4");

    }

    public abstract void addRecipe();

}