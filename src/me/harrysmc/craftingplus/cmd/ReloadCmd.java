package me.harrysmc.craftingplus.cmd;

import me.harrysmc.craftingplus.CraftingPlus;
import org.bukkit.entity.Player;

/**
 * Created by Hary on 18/05/2015.
 */
public class ReloadCmd extends Cmd{

    CraftingPlus plugin;

    public ReloadCmd(CraftingPlus plugin, Player player) {
        super(player);

        this.plugin = plugin;
    }

    @Override
    protected void run() {

        if(player.hasPermission("craftingplus.reload")){
            plugin.reloadData();
            player.sendMessage(plugin.getReloadSuccessMessage());
        }else{
            player.sendMessage(plugin.getPermissionMessage());
        }

    }
}
