package de.hthoene.mcrankingsapi;

import de.hthoene.mcrankingsapi.leaderboard.LeaderboardConnection;
import de.hthoene.mcrankingsapi.leaderboard.LeaderboardResult;
import de.hthoene.mcrankingsapi.leaderboard.McRankingsConfig;
import de.hthoene.mcrankingsapi.leaderboard.Ranking;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

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

}
