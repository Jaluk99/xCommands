package xcommands.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CmdKill implements CommandExecutor{

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        String prefix = ChatColor.GOLD + "xCommands | ";
        String error = ChatColor.RED + "xCommands | ";

        if(cmd.getName().equalsIgnoreCase("kill")) {
            if(!(sender.hasPermission("xcommands.kill"))) {
                sender.sendMessage(error + ChatColor.GRAY + "You don't have permission: " + ChatColor.AQUA + "xcommands.kill");
            } else {
                if(args.length == 0) {
                    if(sender instanceof  Player) {
                        Player p = (Player) sender;
                        p.setHealth(0);
                        p.sendMessage(prefix + ChatColor.GRAY + "You are dead!");
                        return false;
                    } else {
                        sender.sendMessage(error + ChatColor.GRAY + "You are not a Player!");
                    }
                } else if(args.length == 1) {
                    Player p1 = Bukkit.getServer().getPlayer(args[0]);
                    if(p1 != null) {
                        p1.setHealth(0);
                        sender.sendMessage(prefix + ChatColor.GRAY + "You are killed " + ChatColor.AQUA + args[0]);
                        p1.sendMessage(prefix + ChatColor.GRAY + "You are kill by " + ChatColor.AQUA + sender.getName());
                        return false;
                    } else {
                        sender.sendMessage(error + ChatColor.GRAY + "Player " + ChatColor.AQUA + args[0] + ChatColor.GRAY + " is not online!");
                    }
                } else if(args.length > 1) {
                    sender.sendMessage(error + ChatColor.GRAY + "Use " + ChatColor.AQUA + "/kill [player]");
                }
            }
        }
        return false;
    }
}