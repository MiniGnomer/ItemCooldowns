package me.minignomer.itemcooldowns.listeners;

import me.minignomer.itemcooldowns.ItemCooldowns;
import me.minignomer.itemcooldowns.config.ConfigManager;
import me.minignomer.itemcooldowns.config.CooldownType;
import org.bukkit.Material;
import org.bukkit.entity.EnderPearl;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class PearlListener extends ConfigManager implements Listener {

    @EventHandler
    public void onEnderPearlThrow(ProjectileLaunchEvent e) {
        if (!(e.getEntity().getShooter() instanceof Player) || !(e.getEntity() instanceof EnderPearl)) return;
        Player p = (Player) e.getEntity().getShooter();
        new BukkitRunnable() {
            @Override
            public void run() {
                p.setCooldown(Material.ENDER_PEARL, getCooldown(CooldownType.PEARL) * 20);
            }
        }.runTaskLater(ItemCooldowns.plugin, 1L);
    }

}
