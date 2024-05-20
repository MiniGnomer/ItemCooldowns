package me.minignomer.itemcooldowns.listeners;

import me.minignomer.itemcooldowns.ItemCooldowns;
import me.minignomer.itemcooldowns.config.ConfigManager;
import me.minignomer.itemcooldowns.config.CooldownType;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class FoodListener extends ConfigManager implements Listener {

    @EventHandler
    public void onGappleConsume(PlayerItemConsumeEvent e) {
        Player p = e.getPlayer();

        Material foodType;
        int cooldown;
        switch (e.getItem().getType()) {
            case GOLDEN_APPLE:
                foodType = Material.GOLDEN_APPLE;
                cooldown = getCooldown(CooldownType.GAPPLE);
                break;
            case ENCHANTED_GOLDEN_APPLE:
                foodType = Material.ENCHANTED_GOLDEN_APPLE;
                cooldown = getCooldown(CooldownType.GOD_APPLE);
                break;
            default:
                return;
        }
        p.setCooldown(foodType, cooldown * 20);
    }

}
