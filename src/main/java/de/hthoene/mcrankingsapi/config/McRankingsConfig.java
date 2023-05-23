package de.hthoene.mcrankingsapi.config;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public class McRankingsConfig {

    private final File configurationFile = new File("plugins/mc-rankings", "mc-rankings.yml");
    private final YamlConfiguration config;

    public McRankingsConfig(JavaPlugin javaPlugin) {
        if(!configurationFile.exists()) {
            javaPlugin.getLogger().warning("Cannot access leaderboards without mc-rankings.yml");
            Bukkit.getPluginManager().disablePlugin(javaPlugin);
        }
        config = YamlConfiguration.loadConfiguration(configurationFile);
    }

    public String getServerName() {
        return config.getString("server-name");
    }

    private void saveConfig() {
        try {
            config.save(configurationFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
