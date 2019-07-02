package crafterryan04.me.cratesplugin;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Barrel;
import org.bukkit.block.Chest;
import org.bukkit.block.DoubleChest;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;
import java.util.Random;

import static crafterryan04.me.cratesplugin.Cratesplugin.*;

public class chest_event implements Listener {

    FileConfiguration config = plugin.getConfig();

    @EventHandler
    public void onOpenCChest(InventoryOpenEvent e) {
        if(e.getInventory().getHolder() instanceof Chest || e.getInventory().getHolder() instanceof DoubleChest) {
            return;
        }
        else if(e.getInventory().getHolder() instanceof Barrel) {
            String chestName = e.getView().getTitle();
            Inventory inventory = e.getPlayer().getInventory();
            int keyNum = 0;
            int cost;

            if(chestName.equals(ChatColor.translateAlternateColorCodes('&', "&r" + plugin.getConfig().getString("rare-crate-name")))) {
                e.setCancelled(true);
                cost = 1;
                ItemStack item = e.getPlayer().getInventory().getItemInMainHand();
                ItemStack air = new ItemStack(Material.AIR);
                if (e.getPlayer().getInventory().getItemInMainHand().equals(air)|| !item.getItemMeta().getDisplayName().equals(ChatColor.translateAlternateColorCodes('&', config.getString("rare-key-name")))) {
                    e.getPlayer().sendMessage(ChatColor.RED + "You need a " + ChatColor.translateAlternateColorCodes('&',config.getString("rare-key-name")) + " to Open this!");
                }
                else {
                    if(e.getPlayer().getInventory().getItemInMainHand().getAmount() >= cost) {
                        e.getPlayer().getInventory().getItemInMainHand().setAmount(e.getPlayer().getInventory().getItemInMainHand().getAmount() - cost);
                        e.getPlayer().sendMessage(ChatColor.LIGHT_PURPLE + "Opening Legendary Barrel...");
                        draw((Player) e.getPlayer(), "rare-crate");
                    }
                    else {
                        e.getPlayer().sendMessage(ChatColor.RED + "Sorry, you don't have enough keys!");
                    }
                }
            }




            else if (chestName.equals(ChatColor.translateAlternateColorCodes('&', "&r"+plugin.getConfig().getString("5-crate-name")))) {
                e.setCancelled(true);
                cost = 5;
                ItemStack item = e.getPlayer().getInventory().getItemInMainHand();
                ItemStack air = new ItemStack(Material.AIR);
                if (e.getPlayer().getInventory().getItemInMainHand().equals(air)|| !item.getItemMeta().getDisplayName().equals(ChatColor.translateAlternateColorCodes('&', config.getString("key-name")))) {
                    e.getPlayer().sendMessage(ChatColor.RED + "You need " + cost + " " + ChatColor.translateAlternateColorCodes('&', config.getString("key-name")) + "s" +ChatColor.RED + " to Open this!");
                }
                else {
                    if(e.getPlayer().getInventory().getItemInMainHand().getAmount() >= cost) {
                        e.getPlayer().getInventory().getItemInMainHand().setAmount(e.getPlayer().getInventory().getItemInMainHand().getAmount() - cost);
                        e.getPlayer().sendMessage(ChatColor.LIGHT_PURPLE + "Opening 5 Key Barrel...");
                        draw((Player) e.getPlayer(), cost+"-crate");
                    }
                    else {
                        e.getPlayer().sendMessage(ChatColor.RED + "Sorry, you don't have enough keys!");
                    }
                }
            }




            else if (chestName.equals(ChatColor.translateAlternateColorCodes('&', "&r"+plugin.getConfig().getString("10-crate-name")))) {
                e.setCancelled(true);
                cost = 10;
                ItemStack item = e.getPlayer().getInventory().getItemInMainHand();
                ItemStack air = new ItemStack(Material.AIR);
                if (e.getPlayer().getInventory().getItemInMainHand().equals(air)|| !item.getItemMeta().getDisplayName().equals(ChatColor.translateAlternateColorCodes('&', config.getString("key-name")))) {
                    e.getPlayer().sendMessage(ChatColor.RED + "You need " + cost + " " + ChatColor.translateAlternateColorCodes('&', config.getString("key-name")) + "s" +ChatColor.RED + " to Open this!");
                }
                else {
                    if(e.getPlayer().getInventory().getItemInMainHand().getAmount() >= cost) {
                        e.getPlayer().getInventory().getItemInMainHand().setAmount(e.getPlayer().getInventory().getItemInMainHand().getAmount() - cost);
                        e.getPlayer().sendMessage(ChatColor.LIGHT_PURPLE + "Opening 10 Key Barrel...");
                        draw((Player) e.getPlayer(), cost+"-crate");
                    }
                    else {
                        e.getPlayer().sendMessage(ChatColor.RED + "Sorry, you don't have enough keys!");
                    }
                }
            }




            else if (chestName.equals(ChatColor.translateAlternateColorCodes('&', "&r"+plugin.getConfig().getString("25-crate-name")))) {
                e.setCancelled(true);
                cost = 25;
                ItemStack item = e.getPlayer().getInventory().getItemInMainHand();
                ItemStack air = new ItemStack(Material.AIR);
                if (e.getPlayer().getInventory().getItemInMainHand().equals(air)|| !item.getItemMeta().getDisplayName().equals(ChatColor.translateAlternateColorCodes('&', config.getString("key-name")))) {
                    e.getPlayer().sendMessage(ChatColor.RED + "You need " + cost + " " + ChatColor.translateAlternateColorCodes('&', config.getString("key-name")) + "s" +ChatColor.RED + " to Open this!");
                }
                else {
                    if(e.getPlayer().getInventory().getItemInMainHand().getAmount() >= cost) {
                        e.getPlayer().getInventory().getItemInMainHand().setAmount(e.getPlayer().getInventory().getItemInMainHand().getAmount() - cost);
                        e.getPlayer().sendMessage(ChatColor.LIGHT_PURPLE + "Opening 25 Key Barrel...");
                        draw((Player) e.getPlayer(), cost+"-crate");
                    }
                    else {
                        e.getPlayer().sendMessage(ChatColor.RED + "Sorry, you don't have enough keys!");
                    }
                }
            }




            else if (chestName.equals(ChatColor.translateAlternateColorCodes('&', "&r"+plugin.getConfig().getString("50-crate-name")))) {
                e.setCancelled(true);
                cost = 50;
                ItemStack item = e.getPlayer().getInventory().getItemInMainHand();
                ItemStack air = new ItemStack(Material.AIR);
                if (e.getPlayer().getInventory().getItemInMainHand().equals(air)|| !item.getItemMeta().getDisplayName().equals(ChatColor.translateAlternateColorCodes('&', config.getString("key-name")))) {
                    e.getPlayer().sendMessage(ChatColor.RED + "You need " + cost + " " + ChatColor.translateAlternateColorCodes('&', config.getString("key-name")) + "s" +ChatColor.RED + " to Open this!");
                }
                else {
                    if(e.getPlayer().getInventory().getItemInMainHand().getAmount() >= cost) {
                        e.getPlayer().getInventory().getItemInMainHand().setAmount(e.getPlayer().getInventory().getItemInMainHand().getAmount() - cost);
                        e.getPlayer().sendMessage(ChatColor.LIGHT_PURPLE + "Opening 50 Key Barrel...");
                        draw((Player) e.getPlayer(), cost+"-crate");
                    }
                    else {
                        e.getPlayer().sendMessage(ChatColor.RED + "Sorry, you don't have enough keys!");
                    }
                }
            }
        }
    }


    public void draw_five(Player player) {
        int length = config.getConfigurationSection("rare-crate").getKeys(true).size();
        int r = (int) Math.rint((Math.random()*(length-1))+1);

        List<String> prizes = config.getStringList("rare-crate.prize"+r);

        player.sendMessage(ChatColor.GREEN + "You got:");
        player.sendMessage(ChatColor.GRAY +"-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        for (String item : prizes) {

            player.sendMessage(ChatColor.GREEN + item + " x ");


        }




    }
    public void draw(Player player, String file) {
        int length = config.getConfigurationSection(file).getKeys(false).size();
        int r = (int) Math.rint((Math.random() * (length - 1)) + 1);


        int length2 = config.getConfigurationSection(file+".prize"+r).getKeys(false).size();


        int x = 1;

        player.sendMessage(ChatColor.GRAY + "-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");

        while (x <= length2) {

            String itemStr = config.getString(file+".prize"+r+".item"+ x + ".item");
            String nameStr = config.getString(file+".prize"+r+".item" + x + ".name");
            int amount = Integer.valueOf(config.getString(file+".prize"+r+".item" + x + ".amount"));
            ItemStack item = new ItemStack(Material.getMaterial(itemStr), amount);
            ItemMeta itemData = item.getItemMeta();
            itemData.setDisplayName(ChatColor.translateAlternateColorCodes('&', nameStr));
            item.setItemMeta(itemData);
            player.getInventory().addItem(item);
            player.sendMessage(ChatColor.GREEN + itemStr + " x" + amount);
            x++;
        }
        player.sendMessage(ChatColor.GRAY + "-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
    }
}
