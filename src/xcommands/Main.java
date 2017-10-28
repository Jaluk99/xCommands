package xcommands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;
import xcommands.commands.CmdDeOP;
import xcommands.commands.CmdKill;
import xcommands.commands.CmdOP;

public class Main extends JavaPlugin {

    PluginDescriptionFile pdf = this.getDescription();

    @Override
    public void onDisable() {
        Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.GOLD + "==========================================");
        Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.GOLD + "==============[ " + ChatColor.RED + "Stoping..." + ChatColor.GOLD + " ]==============");
        Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.GOLD + "==========================================");
        Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "Name " + ChatColor.AQUA + ">> " + ChatColor.RED + pdf.getName());
        Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "Version " + ChatColor.AQUA + ">> " + ChatColor.RED + pdf.getVersion());
        Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "Author " + ChatColor.AQUA + ">> " + ChatColor.RED + pdf.getAuthors());
        Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "Website " + ChatColor.AQUA + ">> " + ChatColor.RED + pdf.getWebsite());
        Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.GOLD + "==========================================");
    }

    @Override
    public void onEnable() {
        descriptionCheck();
        commandLoad();
    }

    public void descriptionCheck() {
        if(!(pdf.getAuthors().get(0).equalsIgnoreCase("Jaluk") && pdf.getName().equalsIgnoreCase("xCommands"))) {
            Bukkit.getPluginManager().disablePlugin(this);
        } else {
            Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.GOLD + "==========================================");
            Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.GOLD + "==============[ " + ChatColor.GREEN + "Running..." + ChatColor.GOLD + " ]==============");
            Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.GOLD + "==========================================");
            Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "Name " + ChatColor.AQUA + ">> " + ChatColor.RED + pdf.getName());
            Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "Version " + ChatColor.AQUA + ">> " + ChatColor.RED + pdf.getVersion());
            Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "Author " + ChatColor.AQUA + ">> " + ChatColor.RED + pdf.getAuthors());
            Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "Website " + ChatColor.AQUA + ">> " + ChatColor.RED + pdf.getWebsite());
            Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.GOLD + "==========================================");
        }
    }

    public void commandLoad() {
        getCommand("kill").setExecutor(new CmdKill());
        getCommand("op").setExecutor(new CmdOP());
        getCommand("deop").setExecutor(new CmdDeOP());

    }

}
