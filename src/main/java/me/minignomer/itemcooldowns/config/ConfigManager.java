package me.minignomer.itemcooldowns.config;

import me.minignomer.itemcooldowns.ItemCooldowns;
import org.bukkit.configuration.Configuration;

public class ConfigManager {

    public Configuration getConfig() {
        return ItemCooldowns.plugin.getConfig();
    }
    public int getCooldown(CooldownType cooldownType) {
        return getConfig().getInt(cooldownType.toString());
    }

    public void setCooldown(CooldownType cooldownType, int amount) {
        getConfig().set(cooldownType.toString(), amount);
        ItemCooldowns.plugin.saveConfig();
        ItemCooldowns.plugin.reloadConfig();
    }

}
