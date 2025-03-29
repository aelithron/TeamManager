package com.aelithron.teamManager;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

public class TeamCMD implements CommandExecutor {
    private final TeamManager plugin;
    public TeamCMD(TeamManager plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(PluginTools.getInstance().getPrefix() + ChatColor.RED + "You must be a player to use this command!");
            return false;
        }
        Player player = (Player) sender;
        if (args.length == 0) {
            player.openInventory(createMainMenu(player));
            return true;
        }
        return false;
    }

    private Inventory createMainMenu(Player player) {
        Inventory inv = plugin.getServer().createInventory(player, 36, PluginTools.getInstance().getPrefix() + ChatColor.AQUA + "Team Menu");

        ItemStack placeholder = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
        ItemMeta placeholderMeta = placeholder.getItemMeta();
        placeholderMeta.setDisplayName(ChatColor.GRAY + " ");
        placeholder.setItemMeta(placeholderMeta);
        for (int i : new int[]{27, 29, 31, 33, 35}) {
            inv.setItem(i, placeholder);
        }

        ItemStack navArrow = new ItemStack(Material.ARROW);
        ItemMeta navArrowMeta = navArrow.getItemMeta();
        navArrowMeta.setDisplayName(ChatColor.RED + "Back");
        navArrow.setItemMeta(navArrowMeta);
        inv.setItem(28, navArrow);

        ItemStack createTeam = new ItemStack(Material.GREEN_DYE);
        ItemMeta createTeamMeta = createTeam.getItemMeta();
        createTeamMeta.setDisplayName(ChatColor.GREEN + "Create/Manage Team");
        createTeam.setItemMeta(createTeamMeta);
        inv.setItem(30, createTeam);

        ItemStack close = new ItemStack(Material.BARRIER);
        ItemMeta closeMeta = close.getItemMeta();
        closeMeta.setDisplayName(ChatColor.RED + "Close");
        close.setItemMeta(closeMeta);
        inv.setItem(32, close);

        ItemStack navArrow2 = new ItemStack(Material.ARROW);
        ItemMeta navArrowMeta2 = navArrow2.getItemMeta();
        navArrowMeta2.setDisplayName(ChatColor.GREEN + "Next");
        navArrow2.setItemMeta(navArrowMeta2);
        inv.setItem(34, navArrow2);

        return inv;
    }
}
