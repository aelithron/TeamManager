package com.aelithron.teamManager;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public final class TeamManager extends JavaPlugin {
    // Files
    YamlConfiguration dataStore;
    // Actual "File" objects (used for reloading)
    private File dataStoreFile;

    @Override
    public void onEnable() {
        // Events
        getServer().getPluginManager().registerEvents(new TeamListener(this), this);
        // General Config
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        // Data Storage
        dataStoreFile = new File(getDataFolder(), "data.yml");
        if (!dataStoreFile.exists()) {
            saveResource("data.yml", false);
        }
        reloadDataStore();
        // Commands
        getCommand("team").setExecutor(new TeamCMD(this));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    Team readTeam(UUID teamID) {
        try {
            return (Team) dataStore.get(teamID.toString());
        } catch (ClassCastException e) {
            return null;
        }
    }

    boolean writeTeam(Team team) {
        try {
            reloadDataStore();
            dataStore.set(team.getId().toString(), team);
            saveDataStore();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    void reloadDataStore() {
        dataStore = YamlConfiguration.loadConfiguration(dataStoreFile);
    }
    void saveDataStore() {
        try {
            dataStore.save(new File(getDataFolder(), "data.yml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
