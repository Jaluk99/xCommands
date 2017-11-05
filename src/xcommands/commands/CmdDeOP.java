package xcommands.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import xcommands.Main;

public class CmdDeOP implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        String prefix = (String) Main.getMessages().getCfg().get("prefix");
        String error = (String) Main.getMessages().getCfg().get("error");

        if(cmd.getName().equalsIgnoreCase("deop")) {
            if(!(sender.hasPermission("xcommands.deop"))) {
                sender.sendMessage(error + ChatColor.GRAY + "You don't have permission: " + ChatColor.AQUA + "xcommands.deop");
            } else {
                if(args.length == 0) {
                    if(sender instanceof Player) {
                        if(sender.isOp()){
                            Player p = (Player) sender;
                            p.setOp(false);
                            p.sendMessage(prefix + ChatColor.GRAY + "You are now not " + ChatColor.AQUA + "OP");
                            return false;
                        } else {
                            sender.sendMessage(error + ChatColor.GRAY + "You dont have " + ChatColor.AQUA + "OP");
                        }
                    } else {
                        sender.sendMessage(error + ChatColor.GRAY + "You are not a Player!");
                    }
                } else if(args.length == 1) {
                    Player p1 = Bukkit.getServer().getPlayer(args[0]);
                    if(p1 != null) {
                        if(p1.isOp()){
                            p1.setOp(false);
                            sender.sendMessage(prefix + ChatColor.GRAY + "Player " + ChatColor.AQUA + args[0] + ChatColor.GRAY + " now not " + ChatColor.AQUA + "OP");
                            p1.sendMessage(prefix + ChatColor.GRAY + "You were taken " + ChatColor.AQUA + "OP " + ChatColor.GRAY + "by " + ChatColor.AQUA + sender.getName());
                            return false;
                        } else {
                            sender.sendMessage(error + ChatColor.GRAY + "Player " + ChatColor.AQUA + args[0] + ChatColor.GRAY + " dont have " + ChatColor.AQUA + "OP");
                        }
                    } else {
                        sender.sendMessage(error + ChatColor.GRAY + "Player " + ChatColor.AQUA + args[0] + ChatColor.GRAY + " is not online!");
                    }
                } else if(args.length > 1) {
                    sender.sendMessage(error + ChatColor.GRAY + "Use " + ChatColor.AQUA + "/deop [player]");
                }
            }
        }
        return false;
    }
}
