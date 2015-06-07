package com.example.hatde.tennisrecord;

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
public class MatchAdapter extends BaseAdapter {
    private Context context;
    public String[] tennisMatch;

    public MatchAdapter(Context context, String[] TennisAction) {
        this.context = context;
        this.tennisMatch = TennisAction;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View listView;

        if (convertView == null) {
            listView = new View(context);
        } else {
            listView = (View) convertView;
        }

            // get layout from mobile.xml
        listView = inflater.inflate(R.layout.item_match, null);

            // set value into textview
        TextView location = (TextView) listView
                    .findViewById(R.id.tvLocation);
        location.setText(tennisMatch[position]);

            /*button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Sử lý khi chọn action
                    String[] strAction = new String[] {
                            "Ace","Force error", "Unforce error" };
                    UpdateAction(strAction);
                    notifyDataSetChanged();
                }
            });*/
        return listView;
    }
    public void UpdateAction(String[] TennisAction)
    {
        this.tennisMatch = TennisAction;
    }
    @Override
    public int getCount() {
        return tennisMatch.length;
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
