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


    private final CraftingPlus plugin;
    private final FileConfiguration config;
    private final Logger log;

    private final String name;


    public CraftingRecipe(CraftingPlus plugin, String name){

        this.plugin = plugin;
        this.name = name;

        log = plugin.getLogger();
        config = plugin.getConfig();

    }

    public void setup(){

        if(!(config.contains("enabled." + name))){
            log.warning("ERROR finding: 'enabled." + name + "' in the config.");
            return;
        }

        if(config.getBoolean("enabled." + name)) {
            plugin.getServer().addRecipe(getRecipe());
        }

    }

    public abstract Recipe getRecipe();

}