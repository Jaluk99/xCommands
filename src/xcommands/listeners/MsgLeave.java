package xcommands.listeners;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class MsgLeave implements Listener {

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        e.setQuitMessage(ChatColor.GOLD + "» " + ChatColor.GRAY + "Player " + ChatColor.AQUA + e.getPlayer().getName() + ChatColor.GRAY + " has left the server" );
    }
}
