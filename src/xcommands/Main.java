package xcommands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import xcommands.commands.*;
import xcommands.file.Yamler;
import xcommands.listeners.CheckOP;
import xcommands.listeners.MsgLeave;

import java.io.File;


public class Main extends JavaPlugin {

    PluginDescriptionFile pdf = this.getDescription();

    private static Yamler config;
    private static Yamler oplist;
    private static Yamler users;
    private static Yamler messages;

    public static Yamler getUsers() {
        return users;
    }

    public static Yamler getMainConfig() {
        return config;
    }

    public static Yamler getOPList() {
        return oplist;
    }

    public static Yamler getMessages() {
        return messages;
    }

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
        if(!(pdf.getAuthors().get(0).equalsIgnoreCase("xDevoo") && pdf.getName().equalsIgnoreCase("xCommands"))) {
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
        getCommand("weather").setExecutor(new CmdWeather());
        getCommand("time").setExecutor(new CmdTime());
    }

    //Listener System
    public void listenerLoad() {
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new MsgLeave(), this);
        pm.registerEvents(new CheckOP(), this);
    }

    //Config System
    private void configSystem() {
        if(!getDataFolder().exists()) {
            getDataFolder().mkdirs();
        }

        File f1 = new File(this.getDataFolder(), "config.yml");
        File f2 = new File(this.getDataFolder(), "users.yml");
        File f3 = new File(this.getDataFolder(), "op.yml");
        File f4 = new File(this.getDataFolder(), "messages.yml");

        if(!f1.exists()) {
            config = new Yamler(f1);
            config.getCfg().options().copyDefaults(true);
            config.save();
        } else {
            config = new Yamler(f1);
        }

        if(!f2.exists()) {
            users = new Yamler(f2);
            users.save();
        } else {
            users = new Yamler(f2);
        }

        if(!f3.exists()) {
            oplist = new Yamler(f3);
            oplist.getCfg().set("Enabled", true);
            oplist.save();
        } else {
            oplist = new Yamler(f3);
        }

        if(!f4.exists()) {
            messages = new Yamler(f4);
            messages.getCfg().options().copyDefaults(true);
            messages.save();
        } else {
            messages = new Yamler(f4);
        }
    }
}
