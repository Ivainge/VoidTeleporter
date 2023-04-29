package me.ivainge.voidteleporter;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.logging.Logger;

public class MainCmd implements org.bukkit.command.CommandExecutor {

    Main plugin;
    Config config = Config.getInstance();
    public MainCmd(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

            if (args.length == 0) {
                sender.sendMessage("§5§lVoid§9§lTeleporter§r §bby Ivainge");
                if(sender.hasPermission("voidteleporter.reload")) {
                    sender.sendMessage("§3Type §b/" +label+ " reload §3for reload plugin.");
                }
                sender.sendMessage("§3Version: §b1.0.2");
                return true;
            }
            if (args[0].equalsIgnoreCase("reload")) {
                if(sender.hasPermission("voidteleporter.reload")) {
                    config.checkConfig(plugin);
                    Logger.getLogger("VoidTeleporter").info(config.getLine("plugin-reloaded"));
                    if(sender instanceof Player) sender.sendMessage(config.getLine("plugin-reloaded"));
                    return true;
                }
                sender.sendMessage(config.getLine("no-permission-message"));
            }
        return false;
    }
}