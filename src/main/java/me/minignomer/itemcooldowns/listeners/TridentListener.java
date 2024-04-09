package me.minignomer.itemcooldowns.listeners;

import me.minignomer.itemcooldowns.config.ConfigManager;
import me.minignomer.itemcooldowns.config.CooldownType;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRiptideEvent;

public class TridentListener extends ConfigManager implements Listener {

    @EventHandler
    public void onPlayerRiptide(PlayerRiptideEvent e) {
        int cooldown = getCooldown(CooldownType.TRIDENT);
        if (cooldown <= 0) return;
        e.getPlayer().setCooldown(Material.TRIDENT, cooldown * 20);

    }
}
