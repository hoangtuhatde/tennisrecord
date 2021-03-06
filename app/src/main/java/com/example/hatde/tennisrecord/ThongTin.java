package com.example.hatde.tennisrecord;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import handler.AssetsManager;


public class ThongTin extends ActionBarActivity {

    String[] arrayLocation;
    String[] arrayPlayer;
    String p1;
    String p2;
    String location;
    int type;
    int deuce;
    String set;
    String game;
    long turn;
    int handicap;
    int whoHand;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_tin);

        Button btStartMatch = (Button)findViewById(R.id.btStartMatch_info);
        final AutoCompleteTextView atP1 = (AutoCompleteTextView) findViewById(R.id.atPlayer1);
        atP1.setThreshold(0);
        final AutoCompleteTextView atP2 = (AutoCompleteTextView) findViewById(R.id.atPlayer2);
        atP2.setThreshold(0);
        final AutoCompleteTextView atLocation = (AutoCompleteTextView) findViewById(R.id.spinner_Location);
        atLocation.setThreshold(0);

        AssetsManager manager = new AssetsManager(this.getApplicationContext());
        arrayPlayer = new String[manager.getPlayerList().size()];
        for(int i = 0; i< manager.getPlayerList().size();i++)
        {
            arrayPlayer[i] = manager.getPlayerList().get(i).getName();
        }
        //lay ds location da luu
        //arrayLocation = ...getListLocation
        arrayLocation = new String[manager.getLocationList().size()];
        for(int i = 0; i< manager.getLocationList().size();i++)
        {
            arrayLocation[i] = manager.getLocationList().get(i).getName();
        }
        atLocation.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, arrayLocation));

        //lay ds player da luu
        //arrayPlayer = ...getListLocation
        atP1.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, arrayPlayer));
        atP2.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, arrayPlayer));

        final Spinner spType = (Spinner) findViewById(R.id.spinner_Type);
        final Spinner spDeuce = (Spinner) findViewById(R.id.spinner_Deuce);
        final Spinner spHandicap = (Spinner) findViewById(R.id.spinner_handicap);
        final Spinner spWhoHand = (Spinner) findViewById(R.id.spinner_whoHand);
        final Spinner spTurn = (Spinner) findViewById(R.id.spinner_Turn);
        final EditText etNumSet = (EditText) findViewById(R.id.etNumSet);
        final EditText etNumGame = (EditText) findViewById(R.id.etNumGame);
        btStartMatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                p1 = atP1.getText().toString();
                p2 = atP2.getText().toString();
                location = atLocation.getText().toString();
                type = spType.getSelectedItemPosition();
                if (type == 0)
                    type = 0;
                else if (type == 1)
                    type = 0;
                deuce = spDeuce.getSelectedItemPosition();
                if (deuce == 0)
                    deuce = 1;
                else if (deuce == 1)
                    deuce = 0;
                set = etNumSet.getText().toString();
                game = etNumGame.getText().toString();
                turn = spTurn.getSelectedItemId();
                handicap = spHandicap.getSelectedItemPosition();
                whoHand = spWhoHand.getSelectedItemPosition();
                if(!check()) {
                    Toast t = Toast.makeText(getApplicationContext(), "Dữ liệu không hợp lệ", Toast.LENGTH_SHORT);
                    t.show();
                    return;
                }
                Intent myIntent = new Intent(ThongTin.this, TranDau.class);
                Bundle extras = new Bundle();
                extras.putString("p1", p1);
                extras.putString("p2", p2);
                extras.putString("location", location);
                extras.putInt("tiebreak", type);
                extras.putInt("deuce", deuce);
                extras.putLong("turn", turn);
                extras.putInt("handicap", handicap);
                extras.putInt("whoHand", whoHand);
                extras.putInt("set", Integer.valueOf(set));
                extras.putInt("game", Integer.valueOf(game));
                myIntent.putExtras(extras);
                ThongTin.this.startActivity(myIntent);
            }
        });
    }

    public boolean check()
    {
        if (Integer.valueOf(set) > 5 || Integer.valueOf(set) <= 0)
            return false;
        if (p1.equals(""))
            return false;
        if (p2.equals(""))
            return false;
        if (location.equals(""))
            return false;
        return true;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_thong_tin, menu);
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
