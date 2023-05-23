package de.hthoene.mcrankingsapi.leaderboard;

import org.bukkit.plugin.java.JavaPlugin;

public class LeaderboardConnection {

    private final String pluginName;
    private final int leaderboardId;
    private final JavaPlugin javaPlugin;
    private final String serverName;

    public LeaderboardConnection(String pluginName, int leaderboardId, JavaPlugin javaPlugin, String serverName) {
        this.pluginName = pluginName;
        this.leaderboardId = leaderboardId;
        this.javaPlugin = javaPlugin;
        this.serverName = serverName;
    }

    public void getPage(int page, int pageSize, LeaderboardResult result) {
        LeaderboardPage leaderboardPage = new LeaderboardPage(javaPlugin, pluginName, leaderboardId, page, pageSize, serverName, result);
    }

}
