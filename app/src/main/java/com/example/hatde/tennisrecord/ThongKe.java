package com.example.hatde.tennisrecord;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.List;

import entities.Player;
import handler.AssetsManager;
import java.io.Serializable;

public class ThongKe extends ActionBarActivity {
    public TennisStatistic stats;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_ke);
        Intent inten = getIntent();
        Bundle extras = inten.getExtras();
        stats = new TennisStatistic();
        AssetsManager manager = new AssetsManager(this.getApplicationContext());
        String nameplayer = extras.getString("Player");
        TennisStatistic nstats = (TennisStatistic)extras.getSerializable("Stat");
        if(nameplayer != null) {
            for (int i = 0; i < manager.getPlayerList().size(); i++) {
                if(manager.getPlayerList().get(i).getName().equals(nameplayer))
                {
                    Player p = manager.getPlayerList().get(i);
                    stats = p.getPlayerStats();
                    ((TextView)findViewById(R.id.tvPlayer1_statist)).setText(nameplayer);
                    break;
                }
            }


        }
        else if(nstats != null)
        {
            stats = nstats;
            String p1 = extras.getString("P1");
            String p2 = extras.getString("P2");
            ((TextView)findViewById(R.id.tvPlayer1_statist)).setText(p1);
            ((TextView)findViewById(R.id.tvPlayer2_statist)).setText(p2);
        }
        TableLayout tbStats = (TableLayout)findViewById(R.id.tbStatist);
        for(int i = 0; i < stats.tnstats.size();i++)
        {
            TableRow row = (TableRow) LayoutInflater.from(ThongKe.this).inflate(R.layout.row, null);
            ((TextView)row.findViewById(R.id.tvScoreP1)).setText(stats.tnstats.get(i).getStatsP1());
            ((TextView)row.findViewById(R.id.tvNameStats)).setText(stats.tnstats.get(i).stats);
            ((TextView)row.findViewById(R.id.tvScoreP2)).setText(stats.tnstats.get(i).getStatsP2());
            tbStats.addView(row);
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_thong_ke, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
