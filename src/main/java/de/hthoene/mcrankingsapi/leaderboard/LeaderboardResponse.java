package de.hthoene.mcrankingsapi.leaderboard;

import java.util.List;

public class LeaderboardResponse {
    private int pages;
    private List<Ranking> entries;

    public int getPages() {
        return pages;
    }

    public List<Ranking> getEntries() {
        return entries;
    }
}