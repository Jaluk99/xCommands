package xcommands.commands;

import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import xcommands.Main;
import xcommands.utils.Message;

public class CmdTime implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        String prefix = (String) Main.getMessages().getCfg().get("prefix");
        String error = (String) Main.getMessages().getCfg().get("error");

        if (cmd.getName().equalsIgnoreCase("time")) {
            if (sender.hasPermission("xcommands.time")) {
                if (args.length == 0) {
                    sender.sendMessage(prefix + Message.formatMessage(("use-time")));
                    return false;
                } else if (args.length == 1) {
                    if (sender instanceof Player) {
                        if (args[0].equalsIgnoreCase("day")) {
                            Player p = (Player) sender;
                            World w = p.getWorld();
                            w.setTime(24000);
                            p.sendMessage(prefix + Message.formatMessage(("use-time-day")));
                            return false;
                        }

                        if (args[0].equalsIgnoreCase("night")) {
                            Player p = (Player) sender;
                            World w = p.getWorld();
                            w.setTime(24000);
                            p.sendMessage(prefix + Message.formatMessage(("use-time-night")));
                            return false;
                        }
                    } else {
                        sender.sendMessage(prefix + Message.formatMessage(("you-must-be-a-player")));
                    }
                } else if (args.length == 2) {
                    if (args[0].equalsIgnoreCase("set")) {
                        Player p = (Player) sender;
                        World w = p.getWorld();
                        w.setTime(Long.parseLong(args[1]));
                        p.sendMessage(prefix + Message.formatMessage(("use-time-set")));
                        return false;
                    }
                } else {
                    sender.sendMessage(prefix + Message.formatMessage(("use-time")));
                }
            } else {
                sender.sendMessage(error + Message.formatMessage(("no-permission")));
            }
        }
        return false;
    }
}
