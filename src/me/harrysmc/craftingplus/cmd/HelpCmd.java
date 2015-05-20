package me.harrysmc.craftingplus.cmd;

import me.harrysmc.craftingplus.CraftingPlus;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;

/**
 * Created by Hary on 18/05/2015.
 */
public class HelpCmd extends Cmd{

    public HelpCmd(CraftingPlus plugin, Player player){

        super(plugin, player);

    }

    @Override
    protected void run() {

        final PluginDescriptionFile pdf = plugin.getDescription();

        final String prefix = ChatColor.GRAY + ChatColor.ITALIC.toString() + "> ";
        final String splitter =  ChatColor.GRAY + "+---------------------+";

        player.sendMessage(splitter);
        player.sendMessage(ChatColor.GREEN + "Crafting" + ChatColor.GOLD + "+ " + ChatColor.WHITE + pdf.getVersion() + ChatColor.GREEN + " by " + ChatColor.GOLD + pdf.getAuthors().get(0) + "!");
        player.sendMessage(splitter);
        player.sendMessage(ChatColor.GREEN + "/craftingplus help|?");
        player.sendMessage(prefix + ChatColor.GRAY + "Brings you here.");

        if(player.hasPermission("craftingplus.reload")){
            player.sendMessage(ChatColor.GREEN + "/craftingplus reload");
            player.sendMessage(prefix + ChatColor.GRAY + "This command reloads config information excluding enabled/disabled items.");
        }

        player.sendMessage(splitter);

    }
}
