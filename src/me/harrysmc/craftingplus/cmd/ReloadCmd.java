package me.harrysmc.craftingplus.cmd;

import me.harrysmc.craftingplus.CraftingPlus;
import me.harrysmc.craftingplus.RecipeManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Recipe;

/**
 * Created by Hary on 18/05/2015.
 */
public class ReloadCmd extends Cmd{

    public ReloadCmd(CraftingPlus plugin, Player player) {

        super(plugin, player);

    }

    @Override
    protected void run() {

        if(player.hasPermission("craftingplus.reload")){

            plugin.reloadData();

            Bukkit.clearRecipes();
            for(Recipe recipe: plugin.getVanillaRecipes()){
                Bukkit.addRecipe(recipe);
            }
            new RecipeManager(plugin);

            player.sendMessage(plugin.getReloadSuccessMessage());

        }else{
            player.sendMessage(plugin.getPermissionMessage());
        }

    }
}
