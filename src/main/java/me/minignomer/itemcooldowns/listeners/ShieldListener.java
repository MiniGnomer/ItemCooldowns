package me.minignomer.itemcooldowns.listeners;

import me.minignomer.itemcooldowns.ItemCooldowns;
import me.minignomer.itemcooldowns.config.ConfigManager;
import me.minignomer.itemcooldowns.config.CooldownType;
import org.bukkit.Material;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class ShieldListener extends ConfigManager implements Listener {

    @EventHandler
    public void onShieldDisable(EntityDamageByEntityEvent e) {
        if (!(e.getEntity() instanceof Player) || !(e.getDamager() instanceof LivingEntity)) return;
        Player p = (Player) e.getEntity();
        new BukkitRunnable() {
            @Override
            public void run() {
                if (p.getCooldown(Material.SHIELD) != 99) return;
                p.setCooldown(Material.SHIELD, getCooldown(CooldownType.SHIELD) * 20);
            }
        }.runTaskLater(ItemCooldowns.plugin, 1);
    }
}
