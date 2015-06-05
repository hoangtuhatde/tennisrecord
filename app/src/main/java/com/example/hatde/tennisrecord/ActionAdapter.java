package com.example.hatde.tennisrecord;

import android.app.Notification;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Saturn on 6/5/2015.
 */
public class ActionAdapter extends BaseAdapter {
    private Context context;
    private String[] tennisAction;

    public ActionAdapter(Context context, String[] TennisAction) {
        this.context = context;
        this.tennisAction = TennisAction;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View gridView;

        if (convertView == null) {
            gridView = new View(context);
        } else {
            gridView = (View) convertView;
        }
        if(tennisAction[position].equals("null"))
        {
            gridView = inflater.inflate(R.layout.null_button_action, null);
        }
        else {
            // get layout from mobile.xml
            gridView = inflater.inflate(R.layout.button_action, null);

            // set value into textview
            Button button = (Button) gridView
                    .findViewById(R.id.btAction);
            button.setText(tennisAction[position]);
        }
        return gridView;
    }
    public void UpdateAction(String[] TennisAction)
    {
        this.tennisAction = TennisAction;
    }
    @Override
    public int getCount() {
        return tennisAction.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
}
