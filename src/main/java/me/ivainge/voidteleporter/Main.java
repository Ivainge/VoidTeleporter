package me.ivainge.voidteleporter;

import org.bstats.bukkit.Metrics;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class Main extends JavaPlugin {

    private final Logger log = Logger.getLogger("VoidTeleporter");

    @Override
    public void onEnable() {

        Config.getInstance().checkConfig(this);

        Bukkit.getPluginManager().registerEvents(new EventListener(),this);

        getCommand("voidteleporter").setExecutor(new MainCmd(this));
        getCommand("voidteleporter").setTabCompleter(new MainCmdTabCompliter());

        // bStats
        int pluginId = 16422; // <-- Replace with the id of your plugin!
        Metrics metrics = new Metrics(this, pluginId);

        log.info("§5§lVoid§9§lTeleporter§r §bby Ivainge §2Successful Enabled.");
    }

    @Override
    public void onDisable() {
        log.info("§5§lVoid§9§lTeleporter§r §bby Ivainge §cSuccessful Disabled.");
    }
}
