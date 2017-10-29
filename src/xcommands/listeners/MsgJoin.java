package xcommands.listeners;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import xcommands.Main;

public class MsgJoin implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        String message = Main.getConfigFile().getConfig().getString("join-message:");
        message = ChatColor.translateAlternateColorCodes('&', message);
        message = message.replace("%player%", e.getPlayer().getName());
        e.setJoinMessage(message);
        //e.setJoinMessage(ChatColor.GOLD + "» " + ChatColor.GRAY + "Player " + ChatColor.AQUA + e.getPlayer().getName() + ChatColor.GRAY + " joined the server" );
    }
}
