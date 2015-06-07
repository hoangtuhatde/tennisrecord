package com.example.hatde.tennisrecord;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Saturn on 6/6/2015.
 */
public class TennisStatistic {
    List<TennisStats> tnstats;
    public TennisStatistic()
    {
        tnstats = new ArrayList<TennisStats>();
    }
    public TennisStats getStats(String name)
    {
        for(int i = 0; i < tnstats.size(); i++)
        {
            if(tnstats.get(i).stats.equals(name))
            {
                return tnstats.get(i);
            }
        }
        return null;
    }
    public void addStats(String name)
    {
        TennisStats t = new TennisStats();
        t.stats = name;
        tnstats.add(t);
    }
    public void addStats(String name, boolean percent)
    {
        TennisStats t = new TennisStats();
        t.stats = name;
        t.percent = percent;
        tnstats.add(t);
    }
    public void addStats(String name,int i1, int i2, boolean percent)
    {
        TennisStats t = new TennisStats();
        t.stats = name;
        t.i1 = i1;
        t.i2 = i2;
        t.percent = percent;
        tnstats.add(t);
    }
}
class TennisStats{
    public String stats;
    public int i1;
    public int i2;
    public boolean percent;

    public void setStats(String stats)
    {
        this.stats = stats;
    }
    public void setP1(int i)
    {
        i1 = i;
    }
    public void setP2(int i)
    {
        i2 = i;
    }
    public String getStatsP1()
    {
        if(percent)
        {
            return i1*100/(i1+i2) + "%";
        }
        return  i1 + "";
    }
    public String getStatsP2()
    {
        if(percent)
        {
            return i2*100/(i1+i2) + "%";
        }
        return  i2 + "";
    }
}