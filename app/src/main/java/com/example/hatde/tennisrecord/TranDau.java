package com.example.hatde.tennisrecord;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;


public class TranDau extends ActionBarActivity {

    GridView gridView;
    ActionAdapter actionAdapter;
    String p1;
    String p2;
    String location;
    Intent i;
    long turn;
    int nSet;
    int set;
    int p1GameScore;
    int p2GameScore;
    int p1SetScore;
    int p2SetScore;
    int p1nSetWin;
    int p2nSetWin;
    boolean firstServe;
    BangTiSo bangTiSo;
    TennisStatistic stats;

    //int[][] scoreboard;
    static final String[] startAction = new String[] {
            "null", "Ace","Force error", "Unforce error" };
    final String[] p1Serve = new String[] {
            "P1 Ace", "P2 Return Winner", "P1 Service Winner", "P2 Return Error", "P1 Fault", "Ball in play"};
    final String[] p2Serve = new String[] {
            "P1 Return Winner", "P2 Ace", "P1 Return Error", "P2 Service Winner", "P1 Ball in play", "P2 Fault"};
    final String[] bip = new String[] {
            "P1 Winner", "P2 Winner", "P1 Forced Error", "P2 Forced Error", "P1 Unforced Error", "P2 Unforced Error"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tran_dau);
        TextView name_p1 = (TextView)findViewById(R.id.tvNamePlayer1);
        TextView name_p2 = (TextView)findViewById(R.id.tvNamePlayer2);
        final TextView tvServe = (TextView)findViewById(R.id.tvServe);
        bangTiSo = (BangTiSo) findViewById(R.id.csBoard1);
        stats = new TennisStatistic();
        i = getIntent();
        Bundle extras = i.getExtras();
        p1 = extras.getString("p1");
        p2 = extras.getString("p2");
        turn = extras.getLong("turn");
        set = 1;
        nSet = 5;
        location = extras.getString("location");
        bangTiSo.setPlayer1(p1);
        name_p1.setText(p1);
        firstServe = true;
        p1GameScore = 0;
        p2GameScore = 0;
        p1SetScore = 0;
        p2SetScore = 0;
        p1nSetWin = 0;
        p2nSetWin = 0;
        bangTiSo.setPlayer2(p2);
        name_p2.setText(p2);
        bangTiSo.setNumSet(6);
        //bangTiSo.setScore(1, 1, "0");
        //bangTiSo.setScore(2, 1, "0");
        //scoreboard = new int[nSet + 1][nSet + 1];

        gridView = (GridView) findViewById(R.id.gvAction);
        if(turn == 0)
            actionAdapter = new ActionAdapter(this, p1Serve);
        else
            actionAdapter = new ActionAdapter(this, p2Serve);
        gridView.setAdapter(actionAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                String state = actionAdapter.tennisAction[position];
                if(state.equals("P1 Ace"))
                {
                    p1WinPoint();
                    updateGridView();
                    stats.getStats("Ace").i1++;
                }
                else if (state.equals("P1 Service Winner"))
                {
                    p1WinPoint();
                    updateGridView();
                    stats.getStats("Service Winner").i1++;
                }
                else if (state.equals("P1 Fault"))
                {
                    if(firstServe)
                    {
                        tvServe.setText("2nd serve");
                        firstServe = false;
                    }
                    else {
                        p2WinPoint();
                        updateGridView();
                        stats.getStats("Fault").i1++;
                        tvServe.setText("1st serve");
                        firstServe = true;
                    }
                }
                else if (state.equals("P1 Return Winner"))
                {
                    p1WinPoint();
                    updateGridView();
                    stats.getStats("Return Winner").i1++;
                }
                else if (state.equals("P1 Return Error"))
                {
                    p2WinPoint();
                    updateGridView();
                    stats.getStats("Return Error").i1++;
                }
                else if (state.equals("P1 Winner"))
                {
                    p1WinPoint();
                    updateGridView();
                    stats.getStats("Winner").i1++;
                }
                else if (state.equals("P1 Forced Error"))
                {
                    p2WinPoint();
                    updateGridView();
                    stats.getStats("Forced Error").i1++;
                }
                else if (state.equals("P1 Unforced Error"))
                {
                    p2WinPoint();
                    updateGridView();
                    stats.getStats("Unforced Error").i1++;
                }

                else if (state.equals("Ball in play"))
                {
                    actionAdapter.UpdateAction(bip);
                    actionAdapter.notifyDataSetChanged();
                }

                if(state.equals("P2 Ace"))
                {
                    p2WinPoint();
                    updateGridView();
                    stats.getStats("Ace").i2++;
                }
                else if (state.equals("P2 Service Winner"))
                {
                    p2WinPoint();
                    updateGridView();
                    stats.getStats("Service Winner").i2++;
                }
                else if (state.equals("P2 Fault"))
                {
                    if(firstServe)
                    {
                        tvServe.setText("2nd serve");
                        firstServe = false;
                    }
                    else {
                        p1WinPoint();
                        updateGridView();
                        stats.getStats("Fault").i2++;
                        tvServe.setText("1st serve");
                        firstServe = true;
                    }
                }
                else if (state.equals("P2 Return Winner"))
                {
                    p2WinPoint();
                    updateGridView();
                    stats.getStats("Return Winner").i2++;
                }
                else if (state.equals("P2 Return Error"))
                {
                    p1WinPoint();
                    updateGridView();
                    stats.getStats("Return Error").i2++;
                }
                else if (state.equals("P2 Winner"))
                {
                    p2WinPoint();
                    updateGridView();
                    stats.getStats("Winner").i2++;
                }
                else if (state.equals("P2 Forced Error"))
                {
                    p1WinPoint();
                    updateGridView();
                    stats.getStats("Forced Error").i2++;
                }
                else if (state.equals("P2 Unforced Error"))
                {
                    p1WinPoint();
                    updateGridView();
                    stats.getStats("Unforced Error").i2++;
                }
            }
        });
    }
    public void p1WinPoint() {
        if (p1GameScore == 0)
            p1GameScore = 15;
        else if (p1GameScore == 15)
            p1GameScore = 30;
        else if (p1GameScore == 30)
            p1GameScore = 40;
        else if (p1GameScore == 40)
        {
            if (p2GameScore == 40)
                p1GameScore = 45;
            else
                p1WinGame();
        }
        else if(p1GameScore == 45)
            p1WinGame();
        if(p1GameScore == 45) {
            bangTiSo.setScore(1, 1, "Adv");
            bangTiSo.setScore(2, 1, "");
        }
        else
            bangTiSo.setScore(1, 1, String.valueOf(p1GameScore));
    }
    public void p1WinGame()
    {
        if(p1SetScore <= 5)
            p1SetScore++;
        else if(p1SetScore == 6 && p2SetScore <= 5)
        {
            p1SetScore++;
            p1WinSet();
        }
        else if(p1SetScore == 6 && p2SetScore == 6)
        {
            tieBreak();
        }
        bangTiSo.setScore(1, nSet + 2 - set, String.valueOf(p1SetScore));
        p1GameScore = 0;
        p2GameScore = 0;
        bangTiSo.setScore(1, 1, "0");
        bangTiSo.setScore(2, 1, "0");
        changeTurn();
    }
    public void p1WinSet()
    {
        set++;
        p1nSetWin++;
        if (p1nSetWin > nSet / 2)
        {
            p1MatchWin();
            p1nSetWin = 0;
            p2nSetWin = 0;
        }

    }
    public void p1MatchWin()
    {
        //save data, end activity
    }
    public void p2WinPoint() {
        if (p2GameScore == 0)
            p2GameScore = 15;
        else if (p2GameScore == 15)
            p2GameScore = 30;
        else if (p2GameScore == 30)
            p2GameScore = 40;
        else if (p2GameScore == 40)
        {
            if (p1GameScore == 40)
                p2GameScore = 45;
            else
                p2WinGame();
        }
        else if(p2GameScore == 45)
            p2WinGame();
        if(p2GameScore == 45) {
            bangTiSo.setScore(2, 1, "Adv");
            bangTiSo.setScore(1, 1, "");
        }
        else
            bangTiSo.setScore(2, 1, String.valueOf(p2GameScore));
    }
    public void p2WinGame()
    {
        if(p2SetScore <= 5)
            p2SetScore++;
        else if(p2SetScore == 6 && p1SetScore <= 5)
        {
            p2SetScore++;
            p2WinSet();
        }
        else if(p2SetScore == 6 && p1SetScore == 6)
        {
            tieBreak();
        }
        bangTiSo.setScore(2, nSet + 2 - set, String.valueOf(p2SetScore));
        p2GameScore = 0;
        p1GameScore = 0;
        bangTiSo.setScore(1, 1, "0");
        bangTiSo.setScore(2, 1, "0");
        changeTurn();
    }
    public void p2WinSet()
    {
        set++;
        p2nSetWin++;
        if (p2nSetWin > nSet / 2) {
            p1nSetWin = 0;
            p2nSetWin = 0;
            p2MatchWin();
        }
    }
    public void p2MatchWin()
    {
        //save data, end activity
    }
    public void tieBreak()
    {
        //tiebreak
    }
    public void changeTurn()
    {
        if (turn == 0)
        {
            turn = 1;
            updateGridView();
        }
        else if (turn == 1)
        {
            turn = 0;
            updateGridView();
        }
    }
    public void updateGridView ()
    {
        if(turn == 0)
            actionAdapter.UpdateAction(p1Serve);
        if(turn == 1)
            actionAdapter.UpdateAction(p2Serve);
        actionAdapter.notifyDataSetChanged();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tran_dau, menu);
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
