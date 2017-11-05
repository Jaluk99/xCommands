package xcommands.listeners;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import xcommands.Main;
import xcommands.utils.Message;

public class CheckOP implements Listener {


    public boolean isOnList(String nick) {
        String search = nick;
        for(String str : Main.getOPList().getCfg().getStringList("op-players")) {
            if(str.trim().contains(search)) {
                return true;
            }
        }
        return false;
    }

    @EventHandler
    public void checkOP(PlayerJoinEvent e) {

        Player p = e.getPlayer();

        e.setJoinMessage(Message.formatMessage(e.getPlayer().getName(), "join-message", "%player%"));

        if(p.isOp()) {
            if(Main.getOPList().getCfg().getBoolean("Enabled")) {
                if(!isOnList(p.getName())) {
                    p.sendMessage(Message.formatMessage(p.getName(), "player-no-op-list", "%player%"));
                    p.setGameMode(GameMode.SURVIVAL);
                    p.setOp(false);
                }
            }
        }

    }
}
