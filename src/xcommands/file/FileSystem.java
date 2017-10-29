package xcommands.file;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.craftbukkit.libs.jline.internal.InputStreamReader;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.io.UnsupportedEncodingException;

public abstract class FileSystem {

    private Plugin pl;
    private File file;
    private FileConfiguration config;

    public FileSystem(Plugin pl, String fileName) {
        this.pl = pl;
        this.file = new File(pl.getDataFolder(), fileName);

        if(!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        this.config = YamlConfiguration.loadConfiguration(file);
        Reader defaultConfigStream = null;
        try {
            defaultConfigStream = new InputStreamReader(pl.getResource(fileName), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        if(defaultConfigStream != null) {
            YamlConfiguration defaultConfig = YamlConfiguration.loadConfiguration(defaultConfigStream);
            config.setDefaults(defaultConfig);
            config.options().copyDefaults(true);
            this.save();
        }
    }
    public void save() {
        try {
            config.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public FileConfiguration getConfig() {
        return config;
    }
}
