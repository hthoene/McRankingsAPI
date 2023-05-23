package de.hthoene.mcrankingsapi.leaderboard.entry;

import java.util.UUID;

public class Ranking {

    private final int index;
    private final String username;
    private final UUID uuid;

    public Ranking(int index, String username, UUID uuid) {
        this.index = index;
        this.username = username;
        this.uuid = uuid;
    }

    public int getIndex() {
        return index;
    }

    public String getUsername() {
        return username;
    }

    public UUID getUuid() {
        return uuid;
    }
}
