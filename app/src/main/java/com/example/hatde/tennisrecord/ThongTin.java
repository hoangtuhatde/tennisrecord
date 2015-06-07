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


public class ThongTin extends ActionBarActivity {

    String[] arrayLocation = new String[] {
            "HCM", "HN","Lào"};
    String[] arrayPlayer = new String[] {
            "Adam", "Menic","Mimo"};
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
        //lay ds location da luu
        //arrayLocation = ...getListLocation

        atLocation.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, arrayLocation));

        //lay ds player da luu
        //arrayPlayer = ...getListLocation
        atP1.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, arrayPlayer));
        atP2.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, arrayPlayer));

        final Spinner spType = (Spinner) findViewById(R.id.spinner_Type);
        final Spinner spHandicap = (Spinner) findViewById(R.id.spinner_handicap);

        btStartMatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String p1 = atP1.getText().toString();
                final String p2 = atP2.getText().toString();
                final String location = atLocation.getText().toString();
                final String type = spType.getSelectedItem().toString();
                final String handicap = spHandicap.getSelectedItem().toString();
                Intent myIntent = new Intent(ThongTin.this, TranDau.class);
                Bundle extras = new Bundle();
                extras.putString("p1", p1);
                extras.putString("p2", p2);
                extras.putString("location", location);
                extras.putString("type", type);
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
