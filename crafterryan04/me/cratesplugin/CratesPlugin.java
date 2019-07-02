package crafterryan04.me.cratesplugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Chest;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import static crafterryan04.me.cratesplugin.Cratesplugin.*;

public final class Cratesplugin extends JavaPlugin implements CommandExecutor {
    private String version = "3.2.04_BETA";

    public static Cratesplugin plugin;
    public void loadConfiguration() {
        //See "Creating you're defaults"
        this.getConfig().options().copyDefaults(true); // NOTE: You do not have to use "plugin." if the class extends the java plugin
        //Save the config whenever you manipulate it
        this.saveDefaultConfig();
    }
    @Override
    public void onEnable() {

        loadConfiguration();
        plugin = this;
        this.getServer().getPluginManager().registerEvents(new chest_event(), this);
        this.getServer().getPluginManager().registerEvents(new interact_event(), this);
    }
    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
    // COMMANDS //
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        // crate command

        if (label.equalsIgnoreCase("crates")) {
            if (args.length == 2) { // If there is only 1 argument
                if (args[0].equalsIgnoreCase("get")) { // if argument = "get"
                    if (sender instanceof Player) {
                        String crateName;
                        if (((Player) sender).getInventory().firstEmpty() != -1) { // If player has space
                            if(args[1].equalsIgnoreCase("rare")) {
                                crateName = this.getConfig().getString("rare-crate-name");
                            }
                            else if (args[1].equalsIgnoreCase("5")) {
                                crateName = this.getConfig().getString("5-crate-name");
                            }
                            else if (args[1].equalsIgnoreCase("10")) {
                                crateName = this.getConfig().getString("10-crate-name");
                            }
                            else if (args[1].equalsIgnoreCase("25")) {
                                crateName = this.getConfig().getString("25-crate-name");
                            }
                            else if (args[1].equalsIgnoreCase("50")) {
                                crateName = this.getConfig().getString("50-crate-name");
                            }
                            else {
                                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("invalid-crates-command")));
                                return true;
                            }

                            ItemStack crate = new ItemStack(Material.BARREL, 1);
                            ItemMeta crateMeta = crate.getItemMeta();
                            crateName = "&r" + crateName;
                            if(crateName.replace("&r","").equals("Barrel")) {
                                crateName = "&6Crate";
                            }
                            crateMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', crateName));
                            crate.setItemMeta(crateMeta);
                            ((Player) sender).getInventory().addItem(new ItemStack(crate));
                        } else { // if player has no inventory space
                            String errorMessage = this.getConfig().getString("not-enough-inventory-space");
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', errorMessage));
                        }
                    } else {
                        sender.sendMessage(ChatColor.RED + "You have to be a player to do this!");
                    }
                }
            }
            else {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("invalid-crates-command")));
            }
        }



        else if (label.equalsIgnoreCase("cratesversion")) {
            sender.sendMessage(ChatColor.DARK_AQUA+ "[Crates " + version + "]");
            if(this.getConfig().getString("version").equals(version)) {
              sender.sendMessage(ChatColor.GREEN + "Your config is up to date!");
            }
            else {
                sender.sendMessage(ChatColor.RED + "Your config is out of date, send me the file to update it :D");
            }

            sender.sendMessage(ChatColor.DARK_AQUA + "\nCrates Plugin made by: " +ChatColor.GREEN + "[CrafterRyan04]");
        }




        else if(label.equalsIgnoreCase("keys")) {
            if (args[0].equalsIgnoreCase("get")) {
                String usage = ChatColor.RED + "USAGE: /key get [common,rare] [amount]";
                if (args.length == 3 && Integer.valueOf(args[2]) != null) {
                    ItemStack key = new ItemStack(Material.TRIPWIRE_HOOK, Integer.valueOf(args[2]));
                    ItemMeta keyData = key.getItemMeta();
                    if (args[1].equalsIgnoreCase("common")) {
                        keyData.setDisplayName(ChatColor.translateAlternateColorCodes('&', getConfig().getString("key-name")));
                    } else if (args[1].equalsIgnoreCase("rare")) {
                        keyData.setDisplayName(ChatColor.translateAlternateColorCodes('&', getConfig().getString("rare-key-name")));
                    } else {
                        sender.sendMessage(usage);
                        return true;
                    }
                    key.setItemMeta(keyData);
                    if (((Player) sender).getInventory().firstEmpty() != -1) {
                        ((Player) sender).getInventory().addItem(key);
                        ((Player) sender).sendMessage(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("recieved-keys-message")));
                    } else {
                        String errorMessage = this.getConfig().getString("not-enough-inventory-space");
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', errorMessage));
                    }
                } else {
                    sender.sendMessage(usage);
                }
            } else if (args[0].equalsIgnoreCase("give")) {
                String usage = ChatColor.RED + "USAGE: /keys give [player] [common,rare] [amount]";
                if (args.length == 4 && Integer.valueOf(args[3]) != null) {
                    if (Bukkit.getPlayer(args[1]) instanceof Player) {
                        ItemStack key = new ItemStack(Material.TRIPWIRE_HOOK, Integer.valueOf(args[3]));
                        ItemMeta keyData = key.getItemMeta();
                        if (args[2].equalsIgnoreCase("common")) {
                            keyData.setDisplayName(ChatColor.translateAlternateColorCodes('&', getConfig().getString("key-name")));
                        } else if (args[2].equalsIgnoreCase("rare")) {
                            keyData.setDisplayName(ChatColor.translateAlternateColorCodes('&', getConfig().getString("rare-key-name")));
                        } else {
                            sender.sendMessage(usage);
                            return true;
                        }
                        key.setItemMeta(keyData);
                        if (Bukkit.getPlayer(args[1]).getInventory().firstEmpty() != -1) {
                            Bukkit.getPlayer(args[1]).getInventory().addItem(key);
                            sender.sendMessage(ChatColor.GREEN + "You've given " + args[3] +" " +args[2] + " key(s) to " + args[1]);
                            Bukkit.getPlayer(args[1]).sendMessage(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("recieved-keys-message")));
                        } else {
                            String errorMessage = this.getConfig().getString("not-enough-inventory-space");
                            Bukkit.getPlayer(args[1]).sendMessage(ChatColor.translateAlternateColorCodes('&', errorMessage));
                            sender.sendMessage(ChatColor.RED + "They do not have enough storage room!");
                        }
                    } else {
                        sender.sendMessage(usage);
                    }
                } else {
                    sender.sendMessage(usage);
                }
            }

        }
        else if (label.equalsIgnoreCase("cratesreload")) {
            plugin.reloadConfig();
            sender.sendMessage(ChatColor.GREEN + "Crates Successfully Reloaded!");
        }
        return true;
    }
}
