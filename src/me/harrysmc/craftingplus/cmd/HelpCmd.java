package me.harrysmc.craftingplus.cmd;

import me.harrysmc.craftingplus.CraftingPlus;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;

/**
 * Created by Hary on 18/05/2015.
 */
public class HelpCmd extends Cmd{

    CraftingPlus plugin;

    public HelpCmd(CraftingPlus plugin, Player player){

        super(player);

        this.plugin = plugin;

    }

    @Override
    protected void run() {

        plugin.getLogger().info("3");

        PluginDescriptionFile pdf = plugin.getDescription();

        player.sendMessage(ChatColor.GRAY + "+------------------+");
        player.sendMessage(ChatColor.GREEN + "Crafting" + ChatColor.GOLD + "+ " + ChatColor.WHITE + "v" + pdf.getVersion() + ChatColor.GREEN + " by " + ChatColor.GOLD + pdf.getAuthors() + "!");
        player.sendMessage(ChatColor.GRAY + "+------------------+");
        player.sendMessage(ChatColor.GREEN + "/craftingplus help|? -> This command gives you this text.");
        if(player.hasPermission("craftingplus.reload")){
            player.sendMessage(ChatColor.GREEN + "/craftingplus reload -> This command reloads config information " +
                    "excluding enabled/disabled items.");
        }
        player.sendMessage(ChatColor.GRAY + "+------------------+");

    }
}
