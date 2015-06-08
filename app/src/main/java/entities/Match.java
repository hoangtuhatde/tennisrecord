package entities;

import com.example.hatde.tennisrecord.BoardInfo;
import com.example.hatde.tennisrecord.TennisStatistic;

/**
 * Created by qtt on 6/7/2015.
 */
public class Match {
    private TennisStatistic matchStats;
    private BoardInfo boardInfo;

    public Match()
    {
        matchStats = new TennisStatistic();
        boardInfo = new BoardInfo();
    }

    public TennisStatistic getMatchStats() {
        return matchStats;
    }

    public void setMatchStats(TennisStatistic matchStats) {
        this.matchStats = matchStats;
    }

    public BoardInfo getBoardInfo() {
        return boardInfo;
    }

    public void setBoardInfo(BoardInfo boardInfo) {
        this.boardInfo = boardInfo;
    }
}
