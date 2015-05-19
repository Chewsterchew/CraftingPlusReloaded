package me.harrysmc.craftingplus;

import me.harrysmc.craftingplus.cmd.CmdManager;
import me.harrysmc.craftingplus.craftingrecipe.ShapedCraftingRecipe;
import me.harrysmc.craftingplus.craftingrecipe.ShapelessCraftingRecipe;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

/**
 * Created by HarrysMc on 17/05/2015.
 */

public class CraftingPlus extends JavaPlugin {

    private Logger log = getLogger();
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

    }

    private void setupConfig(){

        config.addDefault("permission-message", "&cYou do not have permission for this command!");
        config.addDefault("reload-success-message", "&aThe config has been successfully reloaded.");
        config.addDefault("invalid-command-message", "&cThat is an invalid command. Type '/craftingplus help' for help.");

        config.options().copyDefaults(true);
        saveConfig();

    }

    public void reloadData(){

        permissionMessage = ChatColor.translateAlternateColorCodes('&', config.getString("permission-message") );
        reloadSuccessMessage = ChatColor.translateAlternateColorCodes('&', config.getString("reload-success-message"));
        invalidCommandMessage = ChatColor.translateAlternateColorCodes('&', config.getString("invalid-command-message"));

    }

    public String getPermissionMessage(){ return permissionMessage; }
    public String getReloadSuccessMessage(){ return reloadSuccessMessage; }
    public String getInvalidCommandMessage(){ return invalidCommandMessage; }

}
