package me.minignomer.itemcooldowns.commands;

import me.minignomer.itemcooldowns.config.ConfigManager;
import me.minignomer.itemcooldowns.config.CooldownType;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CooldownCommand extends ConfigManager implements CommandExecutor {

    // /cooldown get/set/default pearl/trident/shield <time_seconds>

    final String pearlDefault = "1 seconds";
    final String tridentDefault = "0 seconds";
    final String shieldDefault = "5 seconds";

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players can use this command!");
            return true;
        }
        Player p = (Player) sender;
        if (args.length < 1) {
            p.sendMessage(ChatColor.RED +
                    "Incorrect amount of arguments! Correct usage: /cooldown get/set pearl/trident/shield <time_seconds>");
            return true;
        }

        if (args[0].equalsIgnoreCase("get")) {
            if (args.length != 2) {
                p.sendMessage(ChatColor.RED +
                        "Incorrect amount of arguments! Correct usage: /cooldown get pearl/trident/shield");
                return true;
            }

            try {
                CooldownType cooldownType = CooldownType.valueOf(args[1].toUpperCase());
                p.sendMessage(ChatColor.GREEN + "The cooldown for " + args[1].toLowerCase() + " is " + getCooldown(cooldownType) + " seconds!");
            } catch (IllegalArgumentException exception) {
                p.sendMessage(ChatColor.RED +
                        "Couldn't find " + args[1].toLowerCase() + "! Correct usage: /cooldown get pearl/trident/shield");
            }
            return true;
        }

        if (args[0].equalsIgnoreCase("set")) {
            if (args.length != 3) {
                p.sendMessage(ChatColor.RED +
                        "Incorrect amount of arguments! Correct usage: /cooldown set pearl/trident/shield <time_seconds>");
                return true;
            }

            CooldownType cooldownType;
            try {
                cooldownType = CooldownType.valueOf(args[1].toUpperCase());
            } catch (IllegalArgumentException exception) {
                p.sendMessage(ChatColor.RED +
                        "Couldn't find " + args[1].toLowerCase() + "! Correct usage: /cooldown set pearl/trident/shield <time_seconds>");
                return true;
            }

            int amount;
            try {
                amount = Integer.parseInt(args[2]);
            } catch (NumberFormatException exception) {
                sender.sendMessage(ChatColor.RED + "\"" + args[2] + "\" is an invalid amount of time!");
                return true;
            }

            if (amount < 0) {
                sender.sendMessage(ChatColor.RED + "\"" + args[2] + "\" needs to be zero or higher!");
                return true;
            }

            setCooldown(cooldownType, amount);
            p.sendMessage(ChatColor.GREEN + "Cooldown successfully set to " + amount + "!");
            return true;
        }

        if (args[0].equalsIgnoreCase("default")) {
            if (args.length != 2) {
                p.sendMessage(ChatColor.RED +
                        "Incorrect amount of arguments! Correct usage: /cooldown default pearl/trident/shield");
                return true;
            }

            CooldownType cooldownType;
            try {
                cooldownType = CooldownType.valueOf(args[1].toUpperCase());
            } catch (IllegalArgumentException exception) {
                p.sendMessage(ChatColor.RED +
                        "Couldn't find " + args[1].toLowerCase() + "! Correct usage: /cooldown default pearl/trident/shield");
                return true;
            }
            switch (cooldownType) {
                case PEARL:
                    p.sendMessage(ChatColor.GREEN + "The default cooldown for " + args[1].toLowerCase() + " is " + pearlDefault + "!");
                    break;
                case TRIDENT:
                    p.sendMessage(ChatColor.GREEN + "The default cooldown for " + args[1].toLowerCase() + " is " + tridentDefault + "!");
                    break;
                case SHIELD:
                    p.sendMessage(ChatColor.GREEN + "The default cooldown for " + args[1].toLowerCase() + " is " + shieldDefault + "!");
                    break;
            }

            return true;
        }

        return true;
    }
}
