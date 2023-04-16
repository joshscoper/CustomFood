package com.joshscoper.customfood.commands;

import com.joshscoper.customfood.Main;
import com.joshscoper.customfood.util.StringBuilder;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CustomFoodCommand implements CommandExecutor {

    private final Main main;
    public CustomFoodCommand(Main main){
        this.main = main;
        main.getServer().getPluginCommand("customfood").setExecutor(this);
    }
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        Player sender = null;
        if (commandSender instanceof Player){
            sender = (Player) commandSender;
        }
        if (command.getLabel().equalsIgnoreCase("customfood")){
            if (strings.length > 0){
                //Reload Command
                if (strings[0].equalsIgnoreCase("reload")){
                    if (sender != null){
                        if (sender.hasPermission("customfood.admin")) {
                            main.saveConfig();
                            main.reloadConfig();
                            sender.sendMessage(StringBuilder.formatString(StringBuilder.parsePlaceholder("prefix", main.getLangManager().getFile().getString("reload"), main)));
                        } else {
                            sender.sendMessage(StringBuilder.formatString(StringBuilder.parsePlaceholder("prefix",main.getLangManager().getFile().getString("no-permission"),main)));
                        }
                    } else{
                        main.saveConfig();
                        main.reloadConfig();
                        Bukkit.getLogger().info("CustomFood Reload Successful");
                    }
                }
                return true;
            }
            return true;
        }
        return false;
    }
}
