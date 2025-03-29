package com.aelithron.teamManager;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
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

        return false;
    }

    private Inventory createMenu(Player player) {
        Inventory inv = plugin.getServer().createInventory(player, 9, "Team Menu");

        return inv;
    }
}
