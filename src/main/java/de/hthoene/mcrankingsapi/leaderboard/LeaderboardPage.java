package de.hthoene.mcrankingsapi.leaderboard;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Level;

public class LeaderboardPage {

    private final JavaPlugin javaPlugin;

    private static final String API_URL = "https://mc-rankings.com/api/v1/";

    public LeaderboardPage(JavaPlugin javaPlugin, String pluginName, int leaderboardId, int page, int pageSize,String serverName, LeaderboardResult result) {
        this.javaPlugin = javaPlugin;
        String url = "leaderboard/get/" + serverName + "/" + pluginName + "/" + leaderboardId + "?page=" + page + "&size=" + pageSize;
        sendRequest(url, result);
    }


    private void sendRequest(String endpoint, LeaderboardResult result) {
        Bukkit.getScheduler().runTaskAsynchronously(javaPlugin, new Runnable() {
            @Override
            public void run() {
                try {

                    URL url = new URL(API_URL + endpoint);
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.setRequestProperty("Accept", "application/json");
                    connection.setRequestProperty("User-Agent", "Mozilla/5.0");

                    int responseCode = connection.getResponseCode();
                    if (responseCode == HttpURLConnection.HTTP_OK) {
                        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                        StringBuilder response = new StringBuilder();
                        String line;

                        while ((line = reader.readLine()) != null) {
                            response.append(line);
                        }

                        reader.close();

                        try {
                            Gson gson = new Gson();
                            LeaderboardResponse leaderboardResponse = gson.fromJson(response.toString(), LeaderboardResponse.class);
                            result.onSuccess(leaderboardResponse.getEntries());
                        } catch (JsonSyntaxException e) {
                            result.onFailure("Failed to parse JSON response");
                        }
                    } else {
                        result.onFailure("Request failed with code: " + responseCode);
                    }

                } catch (IOException e) {
                    log(e.getMessage());
                }
            }
        });
    }

    private void log(String message) {
        javaPlugin.getLogger().log(Level.WARNING, message);
    }

}
