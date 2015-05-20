package me.harrysmc.craftingplus.cmd;

import me.harrysmc.craftingplus.CraftingPlus;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by Hary on 18/05/2015.
 */
public class CmdManager implements CommandExecutor{

    CraftingPlus plugin;

    public CmdManager(CraftingPlus plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(!(sender instanceof Player)){
            return false;
        }

        Player player = (Player) sender;

        if(cmd.getName().equalsIgnoreCase("craftingplus")){

            if(args.length == 0){
                plugin.getLogger().info("hi");
                new HelpCmd(plugin, player);
                return true;
            }

            if(args[0].equalsIgnoreCase("help") || args[0].equals("?")){


                new HelpCmd(plugin, player);

            }else if(args[0].equalsIgnoreCase("reload")){

                new ReloadCmd(plugin, player);

            }else{

                player.sendMessage(plugin.getInvalidCommandMessage());

            }

        }

        return false;
    }

}
