package me.harrysmc.craftingplus.craftingrecipe;

import me.harrysmc.craftingplus.CraftingPlus;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
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

    }

    public void setup(){

        if(!(config.contains("enabled." + name))){
            log.warning("ERROR finding: 'enabled." + name + "' in the config.");
            return;
        }

        if(config.getBoolean("enabled." + name)) {
            plugin.getServer().addRecipe(getRecipe());
            log.info("Yep!");
        }

    }

    public abstract Recipe getRecipe();

}
