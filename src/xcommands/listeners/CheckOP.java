package xcommands.listeners;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

public class CheckOP implements Listener {

    @EventHandler
    public void checkOP(PlayerLoginEvent e) {
        Player p = e.getPlayer();
        if(p.isOp()) {

        }
    }
}
