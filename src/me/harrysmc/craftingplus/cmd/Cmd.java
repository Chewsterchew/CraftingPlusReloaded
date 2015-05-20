package me.harrysmc.craftingplus.cmd;

import me.harrysmc.craftingplus.CraftingPlus;
import org.bukkit.entity.Player;

/**
 * Created by Hary on 18/05/2015.
 */
public abstract class Cmd {

    protected final Player player;
    protected final CraftingPlus plugin;

    public Cmd(CraftingPlus plugin, Player player){
        this.plugin = plugin;
        this.player = player;
        run();
    }

    protected abstract void run();

}
