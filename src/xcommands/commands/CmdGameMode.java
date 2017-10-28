package xcommands.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CmdGameMode implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        String prefix = ChatColor.GOLD + "xCommands | ";
        String error = ChatColor.RED + "xCommands | ";

        if(cmd.getName().equalsIgnoreCase("gm")) {
            if(!(sender.hasPermission("xcommands.gm"))) {
                sender.sendMessage(error + ChatColor.GRAY + "You don't have permission: " + ChatColor.AQUA + "xcommands.gm");
            } else {
                if(args.length == 0) {
                    sender.sendMessage(error + ChatColor.GRAY + "Use " + ChatColor.AQUA + "/gm <gamemode/list> [player]");
                    return false;
                } else if(args.length == 1) {
                    if(sender instanceof Player) {
                        Player p2 = (Player) sender;
                        int check;
                        switch (p2.getGameMode()) {
                            case SURVIVAL:
                                check = 1;
                                break;
                            case CREATIVE:
                                check = 2;
                                break;
                            case ADVENTURE:
                                check = 3;
                                break;
                            case SPECTATOR:
                                check = 4;
                                break;
                            default:
                                check = 1;
                        }
                        if(args[0].equalsIgnoreCase("survival") || args[0].equalsIgnoreCase("0")) {
                            Player p = (Player) sender;
                            p.setGameMode(GameMode.SURVIVAL);
                            p.sendMessage(prefix + ChatColor.GRAY + "Your gamemode change to " + ChatColor.AQUA + "Survival");
                            return false;
                        } else if(args[0].equalsIgnoreCase("creative") || args[0].equalsIgnoreCase("1")) {
                            Player p = (Player) sender;
                            p.setGameMode(GameMode.CREATIVE);
                            p.sendMessage(prefix + ChatColor.GRAY + "Your gamemode change to " + ChatColor.AQUA + "Creative");
                            return false;
                        } else if(args[0].equalsIgnoreCase("adventure") || args[0].equalsIgnoreCase("2")) {
                            Player p = (Player) sender;
                            p.setGameMode(GameMode.ADVENTURE);
                            p.sendMessage(prefix + ChatColor.GRAY + "Your gamemode change to " + ChatColor.AQUA + "Adventure");
                            return false;
                        } else if(args[0].equalsIgnoreCase("spectator") || args[0].equalsIgnoreCase("3")) {
                            Player p = (Player) sender;
                            p.setGameMode(GameMode.SPECTATOR);
                            p.sendMessage(prefix + ChatColor.GRAY + "Your gamemode change to " + ChatColor.AQUA + "Spectator");
                            return false;
                        } else if(args[0].equalsIgnoreCase("list")){
                            sender.sendMessage(ChatColor.GRAY + "List of " + ChatColor.AQUA + "gamemods:");
                            sender.sendMessage((check == 1 ? ChatColor.GREEN + "»" : ChatColor.RED + "»") + ChatColor.AQUA + " | " + ChatColor.GRAY + "[0] Survival");
                            sender.sendMessage((check == 2 ? ChatColor.GREEN + "»" : ChatColor.RED + "»") + ChatColor.AQUA + " | " + ChatColor.GRAY + "[1] Creative");
                            sender.sendMessage((check == 3 ? ChatColor.GREEN + "»" : ChatColor.RED + "»") + ChatColor.AQUA + " | " + ChatColor.GRAY + "[2] Adventure");
                            sender.sendMessage((check == 4 ? ChatColor.GREEN + "»" : ChatColor.RED + "»") + ChatColor.AQUA + " | " + ChatColor.GRAY + "[3] Spectator");
                        }
                    } else {
                        sender.sendMessage(error + ChatColor.GRAY + "You are not a Player!");
                    }
                } else if(args.length == 2) {
                    Player p2 = Bukkit.getServer().getPlayer(args[1]);
                    if(p2 != null) {
                        int check;
                        switch (p2.getGameMode()) {
                            case SURVIVAL:
                                check = 1;
                                break;
                            case CREATIVE:
                                check = 2;
                                break;
                            case ADVENTURE:
                                check = 3;
                                break;
                            case SPECTATOR:
                                check = 4;
                                break;
                            default:
                                check = 1;
                        }
                        if (args[0].equalsIgnoreCase("survival") || args[0].equalsIgnoreCase("0")) {
                            p2.setGameMode(GameMode.SURVIVAL);
                            p2.sendMessage(prefix + ChatColor.GRAY + "Your gamemode change to " + ChatColor.AQUA + "Survival " + ChatColor.GRAY + "by " + ChatColor.AQUA +
                                    sender.getName());
                            sender.sendMessage(prefix + ChatColor.GRAY + "You change gamemode to " + ChatColor.AQUA + "Survival" + ChatColor.GRAY + " for " + ChatColor.AQUA +
                                    args[1]);
                            return false;
                        } else if (args[0].equalsIgnoreCase("creative") || args[0].equalsIgnoreCase("1")) {
                            p2.setGameMode(GameMode.CREATIVE);
                            p2.sendMessage(prefix + ChatColor.GRAY + "Your gamemode change to " + ChatColor.AQUA + "Creative " + ChatColor.GRAY + "by " + ChatColor.AQUA +
                                    sender.getName());
                            sender.sendMessage(prefix + ChatColor.GRAY + "You change gamemode to " + ChatColor.AQUA + "Creative" + ChatColor.GRAY + " for " + ChatColor.AQUA +
                                    args[1]);
                            return false;
                        } else if (args[0].equalsIgnoreCase("adventure") || args[0].equalsIgnoreCase("2")) {
                            p2.setGameMode(GameMode.ADVENTURE);
                            p2.sendMessage(prefix + ChatColor.GRAY + "Your gamemode change to " + ChatColor.AQUA + "Adventure " + ChatColor.GRAY + "by " + ChatColor.AQUA +
                                    sender.getName());
                            sender.sendMessage(prefix + ChatColor.GRAY + "You change gamemode to " + ChatColor.AQUA + "Adventure" + ChatColor.GRAY + " for " + ChatColor.AQUA +
                                    args[1]);
                            return false;
                        } else if (args[0].equalsIgnoreCase("spectator") || args[0].equalsIgnoreCase("3")) {
                            p2.setGameMode(GameMode.SPECTATOR);
                            p2.sendMessage(prefix + ChatColor.GRAY + "Your gamemode change to " + ChatColor.AQUA + "Spectator " + ChatColor.GRAY + "by " + ChatColor.AQUA +
                                    sender.getName());
                            sender.sendMessage(prefix + ChatColor.GRAY + "You change gamemode to " + ChatColor.AQUA + "Spectator" + ChatColor.GRAY + " for " + ChatColor.AQUA +
                                    args[1]);
                            return false;
                        } else if (args[0].equalsIgnoreCase("list")) {
                            sender.sendMessage(ChatColor.GRAY + "Player " + ChatColor.AQUA + args[1] + ChatColor.GRAY + " list of " + ChatColor.AQUA + "gamemods:");
                            sender.sendMessage((check == 1 ? ChatColor.GREEN + "»" : ChatColor.RED + "»") + ChatColor.AQUA + " | " + ChatColor.GRAY + "[0] Survival");
                            sender.sendMessage((check == 2 ? ChatColor.GREEN + "»" : ChatColor.RED + "»") + ChatColor.AQUA + " | " + ChatColor.GRAY + "[1] Creative");
                            sender.sendMessage((check == 3 ? ChatColor.GREEN + "»" : ChatColor.RED + "»") + ChatColor.AQUA + " | " + ChatColor.GRAY + "[2] Adventure");
                            sender.sendMessage((check == 4 ? ChatColor.GREEN + "»" : ChatColor.RED + "»") + ChatColor.AQUA + " | " + ChatColor.GRAY + "[3] Spectator");
                        }
                    } else {
                        sender.sendMessage(error + ChatColor.GRAY + "Player " + ChatColor.AQUA + args[1] + ChatColor.GRAY + " is not online!");
                    }
                } else if(args.length > 2) {
                    sender.sendMessage(error + ChatColor.GRAY + "Use " + ChatColor.AQUA + "/gm <gamemode/list> [player]");
                }
            }
        }
        return false;
    }
}
