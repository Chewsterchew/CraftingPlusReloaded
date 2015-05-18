package me.harrysmc.craftingplus.cmd;

import me.harrysmc.craftingplus.CraftingPlus;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

/**
 * Created by Hary on 18/05/2015.
 */
public class HelpCmd extends Cmd{

    public HelpCmd(Player player){

        super(player);

    }

    @Override
    protected void run() {

        player.sendMessage(ChatColor.GOLD + "**************** Crafting+ Help ****************");
        player.sendMessage(ChatColor.GREEN + "/craftingplus help|? -> This command gives you this text.");
        if(player.hasPermission("craftingplus.reload")){
            player.sendMessage(ChatColor.GREEN + "/craftingplus reload -> This command reloads config information " +
                    "excluding enabled/disabled items.");
        }

    }
}
