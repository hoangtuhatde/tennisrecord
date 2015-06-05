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
        EditText etP1 = (EditText) findViewById(R.id.edPlayer1);
        EditText etP2 = (EditText) findViewById(R.id.edPlayer2);
        EditText etLocation = (EditText) findViewById(R.id.edLocation);
        Spinner spType = (Spinner) findViewById(R.id.spinner_Type);
        Spinner spHandicap = (Spinner) findViewById(R.id.spinner_handicap);
        final String p1 = etP1.getText().toString();
        final String p2 = etP2.getText().toString();
        final String location = etLocation.getText().toString();
        final String type = spType.getSelectedItem().toString();
        final String handicap = spHandicap.getSelectedItem().toString();

        btStartMatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(ThongTin.this, TranDau.class);
                myIntent.putExtra("p1", p1);
                myIntent.putExtra("p2", p2);
                myIntent.putExtra("location", location);
                myIntent.putExtra("type", location);
                myIntent.putExtra("handicap", location);
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
