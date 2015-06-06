package com.example.hatde.tennisrecord;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.List;


public class ThongKe extends ActionBarActivity {
    public TennisStatistic stats;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_ke);
        stats = new TennisStatistic();
        stats.addStats("Ace", 1, 4, false);
        stats.addStats("Force", 2, 2, false);
        stats.addStats("Un Force", 2, 1, false);
        stats.getStats("Ace").i2 = 3;

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
