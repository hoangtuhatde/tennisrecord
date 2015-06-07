package com.example.hatde.tennisrecord;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;


public class ThongTin extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_tin);
        Button btStartMatch = (Button)findViewById(R.id.btStartMatch_info);
        final EditText etP1 = (EditText) findViewById(R.id.edPlayer1);
        final EditText etP2 = (EditText) findViewById(R.id.edPlayer2);
        final EditText etLocation = (EditText) findViewById(R.id.edLocation);
        final Spinner spType = (Spinner) findViewById(R.id.spinner_Type);
        final Spinner spHandicap = (Spinner) findViewById(R.id.spinner_handicap);
        final Spinner spTurn = (Spinner) findViewById(R.id.spinner_Turn);

        btStartMatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String p1 = etP1.getText().toString();
                String p2 = etP2.getText().toString();
                String location = etLocation.getText().toString();
                String type = spType.getSelectedItem().toString();
                long turn = spTurn.getSelectedItemId();
                String handicap = spHandicap.getSelectedItem().toString();
                Intent myIntent = new Intent(ThongTin.this, TranDau.class);
                Bundle extras = new Bundle();
                extras.putString("p1", p1);
                extras.putString("p2", p2);
                extras.putString("location", location);
                extras.putString("type", type);
                extras.putLong("turn", turn);
                extras.putString("handicap", handicap);
                myIntent.putExtras(extras);
                ThongTin.this.startActivity(myIntent);
            }
        });
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
