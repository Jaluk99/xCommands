package xcommands.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CmdDeOP implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        String prefix = ChatColor.GOLD + "xCommands | ";
        String error = ChatColor.RED + "xCommands | ";

        if(cmd.getName().equalsIgnoreCase("deop")) {
            if(sender.hasPermission("xcommands.deop")) {
                if(args.length == 0) {
                    if(sender instanceof Player) {
                        if(sender.isOp() == false){
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
                        if(p1.isOp() == false){
                            p1.setOp(false);
                            sender.sendMessage(prefix + ChatColor.GRAY + "Player " + ChatColor.AQUA + args[0] + ChatColor.GRAY + " now not " + ChatColor.AQUA + "OP");
                            p1.sendMessage(prefix + ChatColor.GRAY + "You were taken " + ChatColor.AQUA + "OP");
                            return false;
                        } else {
                            sender.sendMessage(error + ChatColor.GRAY + "Player " + ChatColor.AQUA + args[0] + ChatColor.GRAY + "dont have " + ChatColor.AQUA + "OP");
                        }
                    } else {
                        sender.sendMessage(error + ChatColor.GRAY + "Player " + ChatColor.AQUA + args[0] + ChatColor.GRAY + " is not online!");
                    }
                } else if(args.length > 1) {
                    sender.sendMessage(error + ChatColor.GRAY + "Use " + ChatColor.AQUA + "/deop [player]");
                }
            } else {
                sender.sendMessage(error + ChatColor.GRAY + "You don't have permission: " + ChatColor.AQUA + "xcommands.deop");
            }
        }
        return false;
    }
}
