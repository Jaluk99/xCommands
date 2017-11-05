package xcommands.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CmdOP implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        String prefix = ChatColor.GOLD + "xCommands | ";
        String error = ChatColor.RED + "xCommands | ";

        if(cmd.getName().equalsIgnoreCase("op")) {
            if(!(sender.hasPermission("xcommands.op"))) {
                sender.sendMessage(error + ChatColor.GRAY + "You don't have permission: " + ChatColor.AQUA + "xcommands.op");
            } else {
                if(args.length == 0) {
                    if(sender instanceof Player) {
                        if(!sender.isOp()){
                            Player p = (Player) sender;
                            p.setOp(true);
                            p.sendMessage(prefix + ChatColor.GRAY + "You are now " + ChatColor.AQUA + "OP");
                            return false;
                        } else {
                            sender.sendMessage(error + ChatColor.GRAY + "You already have " + ChatColor.AQUA + "OP");
                        }
                    } else {
                        sender.sendMessage(error + ChatColor.GRAY + "You are not a Player!");
                    }
                } else if(args.length == 1) {
                    Player p1 = Bukkit.getServer().getPlayer(args[0]);
                    if(p1 != null) {
                        if(!p1.isOp()){
                            p1.setOp(true);
                            sender.sendMessage(prefix + ChatColor.GRAY + "Player " + ChatColor.AQUA + args[0] + ChatColor.GRAY + " now " + ChatColor.AQUA + "OP");
                            p1.sendMessage(prefix + ChatColor.GRAY + "You are now " + ChatColor.AQUA + "OP " + ChatColor.GRAY + "by " + ChatColor.AQUA + sender.getName());
                            return false;
                        } else {
                            sender.sendMessage(error + ChatColor.GRAY + "Player " + ChatColor.AQUA + args[0] + ChatColor.GRAY + " already have " + ChatColor.AQUA + "OP");
                        }
                    } else {
                        sender.sendMessage(error + ChatColor.GRAY + "Player " + ChatColor.AQUA + args[0] + ChatColor.GRAY + " is not online!");
                    }
                } else if(args.length > 1) {
                    sender.sendMessage(error + ChatColor.GRAY + "Use " + ChatColor.AQUA + "/op [player]");
                }
            }
        }
        return false;
    }
}
