package entities;

import com.example.hatde.tennisrecord.TennisStatistic;

import java.util.ArrayList;

/**
 * Created by qtt on 6/7/2015.
 */
public class Player {
    private String name;
    private TennisStatistic playerStats;

    public Player()
    {
        playerStats = new TennisStatistic();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TennisStatistic getPlayerStats() {
        return playerStats;
    }

    public void setPlayerStats(TennisStatistic playerStats) {
        this.playerStats = playerStats;
    }
}
