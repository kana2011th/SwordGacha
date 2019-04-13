package xyz.kana2011th.swordgacha;

import org.bukkit.Material;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Random;

class Listener implements org.bukkit.event.Listener {

    @EventHandler
    public void hitEnemy(EntityDamageByEntityEvent e) {

        // Hit by Player...
        if (e.getDamager() instanceof Player) {

            // LivingEntity is mob that living (Animal, Pet, Monster etc...)
            if (e.getEntity() instanceof LivingEntity) {

                // Let it random
                Random rng = new Random();

                // retrieve item that player holding...
                ItemStack handItem = ((Player) e.getDamager()).getInventory().getItemInMainHand();

                // retrieve item meta.
                ItemMeta meta = handItem.getItemMeta();

                // When random pass 50% (it gen between 0.0 up to 1.0)
                // and holding Diamond Sword
                if (rng.nextFloat() > 0.5 && handItem.getType() == Material.DIAMOND_SWORD) {

                    // when meta not null and item name have "poison" contained.
                    if (meta != null && meta.getDisplayName().toLowerCase().contains("poison")){

                        // tell player that you hit with poison effect.
                        e.getDamager().sendMessage("You damaged him with poison");

                        // add effect to hit entity...
                        ((LivingEntity) e.getEntity()).addPotionEffect(
                                new PotionEffect(PotionEffectType.POISON, 100, 1)
                        );
                    }
                }

            }
        }

    }
}
