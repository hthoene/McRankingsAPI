package de.hthoene.mcrankingsapi.leaderboard;

import java.util.List;

public interface LeaderboardResult {

    void onSuccess(List<Ranking> rankings);

    void onFailure(String message);

}
