package xcommands.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import xcommands.utils.Message;

public class MsgLeave implements Listener {

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        e.setQuitMessage(Message.formatMessage(e.getPlayer().getName(), "quit-message", "%player%"));
    }
}
