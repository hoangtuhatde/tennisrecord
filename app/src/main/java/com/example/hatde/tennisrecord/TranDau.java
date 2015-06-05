package com.example.hatde.tennisrecord;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;


public class TranDau extends ActionBarActivity {

    GridView gridView;
    ActionAdapter actionAdapter;
    static final String[] startAction = new String[] {
            "Win", "Ace","Force error", "Unforce error" };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tran_dau);
        BangTiSo bangTiSo = (BangTiSo) findViewById(R.id.csBoard1);
        bangTiSo.setPlayer1("Adam");
        bangTiSo.setPlayer2("Zerk");
        bangTiSo.setNumSet(5);
        bangTiSo.setScore(1,1,5);

        gridView = (GridView) findViewById(R.id.gvAction);
        actionAdapter = new ActionAdapter(this, startAction);
        gridView.setAdapter(actionAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                //Sử lý khi chọn action
                String[] strAction = new String[] {
                        "Ace","Force error", "Unforce error" };
                actionAdapter.UpdateAction(strAction);
                actionAdapter.notifyDataSetChanged();
            }
        });
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
