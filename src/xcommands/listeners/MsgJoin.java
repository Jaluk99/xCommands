package xcommands.listeners;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class MsgJoin implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        e.setJoinMessage(ChatColor.GOLD + "» " + ChatColor.GRAY + "Player " + ChatColor.AQUA + e.getPlayer().getName() + ChatColor.GRAY + " joined the server" );
    }
}
