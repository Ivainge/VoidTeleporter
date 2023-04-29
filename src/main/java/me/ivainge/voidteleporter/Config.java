package me.ivainge.voidteleporter;

import org.bukkit.configuration.file.FileConfiguration;

import java.io.File;

public class Config {

    private FileConfiguration config;
    private static Config instance;

    public static Config getInstance() {
        if (instance == null) instance = new Config();
        return instance;
    }

    public void checkConfig(Main plugin) {
        File configFile = new File(plugin.getDataFolder() + File.separator + "config.yml");

        if (!configFile.exists()) {
            plugin.saveDefaultConfig();
        }

        plugin.reloadConfig();
        config = plugin.getConfig();
    }

    public String getLine(String id) {
        return config.getString(id, "null")
                .replaceAll("&", "§");
    }

    public double getInt(String id) {
        return config.getDouble(id);
    }
}
