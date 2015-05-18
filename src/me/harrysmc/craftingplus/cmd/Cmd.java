package me.harrysmc.craftingplus.cmd;

import org.bukkit.entity.Player;

/**
 * Created by Hary on 18/05/2015.
 */
public abstract class Cmd {

    Player player;

    public Cmd(Player player){
        this.player = player;
        run();
    }

    protected abstract void run();

}
