package me.harrysmc.craftingplus;

import me.harrysmc.craftingplus.cmd.CmdManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.Recipe;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

/**
 * Created by HarrysMc on 17/05/2015.
 */

public class CraftingPlus extends JavaPlugin {

    private List<Recipe> vanillaRecipes;

    private final Logger log = getLogger();
    private FileConfiguration config = getConfig();

    private String permissionMessage;
    private String reloadSuccessMessage;
    private String invalidCommandMessage;

    @Override
    public void onEnable(){

        saveDefaultConfig();
        log.info("Config setup!");

        reloadData();
        log.info("Data reloaded!");

        iterateVanillaRecipes();
        new RecipeManager(this);
        log.info("All recipes setup!");

        addCommands();
        log.info("Commands setup!");

    }

    @Override
    public void onDisable(){

        Bukkit.getServer().clearRecipes();
        log.info("Recipes cleared!");

    }

    private void addCommands(){

        getCommand("craftingplus").setExecutor(new CmdManager(this));

    }

    private void iterateVanillaRecipes(){

        vanillaRecipes = new ArrayList<Recipe>();
        for(Iterator it = Bukkit.recipeIterator(); it.hasNext();){
            vanillaRecipes.add((Recipe) it.next());
        }

    }

    public void reloadData(){

        reloadConfig();
        config = getConfig();

        permissionMessage = ChatColor.translateAlternateColorCodes('&', config.getString("permission-message"));
        reloadSuccessMessage = ChatColor.translateAlternateColorCodes('&', config.getString("reload-success-message"));
        invalidCommandMessage = ChatColor.translateAlternateColorCodes('&', config.getString("invalid-command-message"));

    }

    public String getPermissionMessage(){ return permissionMessage; }
    public String getReloadSuccessMessage(){ return reloadSuccessMessage; }
    public String getInvalidCommandMessage(){ return invalidCommandMessage; }
    public List<Recipe> getVanillaRecipes(){ return vanillaRecipes; }


}
