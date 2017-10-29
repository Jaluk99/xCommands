package xcommands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import xcommands.commands.*;
import xcommands.file.ConfigFile;
import xcommands.listeners.MsgJoin;
import xcommands.listeners.MsgLeave;


public class Main extends JavaPlugin {

    private static ConfigFile config;
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
        configSystem();
        commandLoad();
        listenerLoad();

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

    //Command System
    public void commandLoad() {
        getCommand("kill").setExecutor(new CmdKill());
        getCommand("op").setExecutor(new CmdOP());
        getCommand("deop").setExecutor(new CmdDeOP());
        getCommand("gm").setExecutor(new CmdGameMode());
        getCommand("heal").setExecutor(new CmdHeal());
        getCommand("feed").setExecutor(new CmdFeed());
    }

    //Listener System
    public void listenerLoad() {
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new MsgJoin(), this);
        pm.registerEvents(new MsgLeave(), this);
    }

    //Config System
    public static ConfigFile getConfigFile() {
        return config;
    }

    private void configSystem() {
        if(!getDataFolder().exists()) {
            getDataFolder().mkdirs();
        }

        config = new ConfigFile(this, "op");
        config = new ConfigFile(this, "config");
        config = new ConfigFile(this, "users");
    }
}
