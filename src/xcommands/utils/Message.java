package xcommands.utils;

import org.bukkit.ChatColor;
import xcommands.Main;


public class Message {

    public static String fix(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }

    public static String formatMessage(String message, String configMessagePath, String replacement) {
        return fix(Main.getMessages().getCfg().getString(configMessagePath).replace(replacement,message));
    }

    public static String formatMessage(String configMessagePath) {
        return fix(Main.getMessages().getCfg().getString(configMessagePath));
    }
}
