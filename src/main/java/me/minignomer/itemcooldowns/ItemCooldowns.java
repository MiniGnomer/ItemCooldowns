package me.minignomer.itemcooldowns;

import me.minignomer.itemcooldowns.commands.CooldownCommand;
import me.minignomer.itemcooldowns.commands.CooldownTabCompleter;
import me.minignomer.itemcooldowns.listeners.FoodListener;
import me.minignomer.itemcooldowns.listeners.PearlListener;
import me.minignomer.itemcooldowns.listeners.ShieldListener;
import me.minignomer.itemcooldowns.listeners.TridentListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class ItemCooldowns extends JavaPlugin {

    public static ItemCooldowns plugin;

    @Override
    public void onEnable() {
        plugin = this;

        getCommand("cooldown").setExecutor(new CooldownCommand());
        getCommand("cooldown").setTabCompleter(new CooldownTabCompleter());

        getServer().getPluginManager().registerEvents(new PearlListener(), this);
        getServer().getPluginManager().registerEvents(new TridentListener(), this);
        getServer().getPluginManager().registerEvents(new ShieldListener(), this);
        getServer().getPluginManager().registerEvents(new FoodListener(), this);
    }
}
