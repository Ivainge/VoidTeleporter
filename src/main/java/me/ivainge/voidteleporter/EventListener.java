package me.ivainge.voidteleporter;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class EventListener implements Listener {

    // Teleport to spawn if height lower height in config
    @EventHandler
    public void event(PlayerMoveEvent event) {
        Config config = Config.getInstance();
        Player player = event.getPlayer();
        if(config.getLine("all-world-tp").equalsIgnoreCase("true") &&
                player.getLocation().getY() < config.getInt("tp-height")) {

            player.teleport(new Location(Bukkit.getWorld(config.getLine("spawn-world")),
                    config.getInt("X-spawn-coordinate"),
                    config.getInt("Y-spawn-coordinate"),
                    config.getInt("Z-spawn-coordinate"),
                    (float) config.getInt("spawn-yaw"),
                    (float) config.getInt("spawn-pitch")));
        }

        if(config.getLine("all-world-tp").equalsIgnoreCase("false") &&
                player.getLocation().getY() < config.getInt("tp-height") &&
                player.getWorld().getName().equalsIgnoreCase(config.getLine("tp-world"))) {

            player.teleport(new Location(Bukkit.getWorld(config.getLine("spawn-world")),
                    config.getInt("X-spawn-coordinate"),
                    config.getInt("Y-spawn-coordinate"),
                    config.getInt("Z-spawn-coordinate"),
                    (float) config.getInt("spawn-yaw"),
                    (float) config.getInt("spawn-pitch")));

            if(config.getLine("tp-player-message") != null) {
                player.sendMessage(config.getLine("tp-player-message"));
            }
        }
    }
}
