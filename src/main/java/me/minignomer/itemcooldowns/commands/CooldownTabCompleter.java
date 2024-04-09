package me.minignomer.itemcooldowns.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class CooldownTabCompleter implements TabCompleter {

    // /cooldown get/set/default pearl/trident/shield <amount_in_seconds>

    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] args) {
        if (args.length == 1) {
            List<String> options = new ArrayList<>();
            options.add("get");
            options.add("set");
            options.add("default");
            return options;
        }

        if (args.length == 2) {
            List<String> options = new ArrayList<>();
            options.add("pearl");
            options.add("trident");
            options.add("shield");
            return options;
        }

        if (args.length == 3 && args[0].equalsIgnoreCase("set")) {
            List<String> options = new ArrayList<>();
            options.add("<time in seconds>");
            return options;
        }
        return null;
    }
}
