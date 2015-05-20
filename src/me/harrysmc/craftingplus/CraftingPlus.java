package me.harrysmc.craftingplus;

import me.harrysmc.craftingplus.cmd.CmdManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

/**
 * Created by HarrysMc on 17/05/2015.
 */

public class CraftingPlus extends JavaPlugin {

    private final Logger log = getLogger();
    private FileConfiguration config = getConfig();

    private String permissionMessage;
    private String reloadSuccessMessage;
    private String invalidCommandMessage;

    @Override
    public void onEnable(){

        setupConfig();
        log.info("Config setup!");

        reloadData();
        log.info("Data reloaded!");

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
        getLogger().info("1");

    }

    private void setupConfig(){

        config.addDefault("permission-message", "&cYou do not have permission for this command!");
        config.addDefault("reload-success-message", "&aThe crafting+ config has been successfully reloaded.");
        config.addDefault("invalid-command-message", "&cThat is an invalid command. Type '/craftingplus help' for help.");

        config.options().copyDefaults(true);
        saveConfig();

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

}
