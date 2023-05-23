package de.hthoene.mcrankingsapi;

import de.hthoene.mcrankingsapi.leaderboard.LeaderboardConnection;
import de.hthoene.mcrankingsapi.config.McRankingsConfig;
import org.bukkit.plugin.java.JavaPlugin;

public class McRankingsAPI extends JavaPlugin {

    private String serverName;

    @Override
    public void onEnable() {
        McRankingsConfig config = new McRankingsConfig(this);
        this.serverName = config.getServerName();
    }

    public LeaderboardConnection getLeaderboard(String pluginName, int leaderboardId) {
        return new LeaderboardConnection(pluginName, leaderboardId, this, serverName);
    }

    public String getServerName() {
        return serverName;
    }
}
