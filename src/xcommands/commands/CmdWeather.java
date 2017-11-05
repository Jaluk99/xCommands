package xcommands.commands;

import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import xcommands.Main;
import xcommands.utils.Message;

public class CmdWeather implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        String prefix = (String) Main.getMessages().getCfg().get("prefix");
        String error = (String) Main.getMessages().getCfg().get("error");

        if(cmd.getName().equalsIgnoreCase("weather")) {
            if(sender.hasPermission("xcommands.weather")) {
                if(args.length == 0) {
                    sender.sendMessage(prefix + Message.formatMessage(("use-weather")));
                    return false;
                } else if(args.length == 1) {
                    if(sender instanceof Player) {
                        if(args[0].equalsIgnoreCase("sun")) {
                            Player p = (Player) sender;
                            World w = p.getWorld();
                            w.setStorm(false);
                            p.sendMessage(prefix + Message.formatMessage(("use-weather-sun")));
                            return false;
                        }

                        if(args[0].equalsIgnoreCase("storm")) {
                            Player p1 = (Player) sender;
                            World w1 = p1.getWorld();
                            w1.setStorm(true);
                            p1.sendMessage(prefix + Message.formatMessage(("use-weather-storm")));
                            return false;
                        }
                    } else {
                        sender.sendMessage(prefix + Message.formatMessage(("you-must-be-a-player")));
                    }
                } else {
                    sender.sendMessage(prefix + Message.formatMessage(("use-weather")));
                }
            } else {
                sender.sendMessage(error + Message.formatMessage(("no-permission")));
            }
        }
        return false;
    }
}
