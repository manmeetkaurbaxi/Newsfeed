package tech.terx.newsfeed.m_UI;

/**
 * Created by Microsoft on 02-Mar-18.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import tech.terx.newsfeed.R;
import tech.terx.newsfeed.m_Model.Spacecraft;

import java.util.ArrayList;

/**
 * 1. where WE INFLATE OUR MODEL LAYOUT INTO VIEW ITEM
 * 2. THEN BIND DATA
 */

public class CustomAdapter extends BaseAdapter{
    Context c;
    ArrayList<Spacecraft> spacecrafts;

    public CustomAdapter(Context c, ArrayList<Spacecraft> spacecrafts) {
        this.c = c;
        this.spacecrafts = spacecrafts;
    }

    @Override
    public int getCount() {
        return spacecrafts.size();
    }

    @Override
    public Object getItem(int position) {
        return spacecrafts.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null)
        {
            convertView= LayoutInflater.from(c).inflate(R.layout.model,parent,false);
        }

        TextView headTxt= (TextView) convertView.findViewById(R.id.headTxt);
        TextView subheadTxt= (TextView) convertView.findViewById(R.id.subheadTxt);
        TextView detailTxt= (TextView) convertView.findViewById(R.id.detailTxt);

        final Spacecraft s= (Spacecraft) this.getItem(position);

        headTxt.setText(s.getHead());
        subheadTxt.setText(s.getSubhead());
        detailTxt.setText(s.getDetail());

        //ONITECLICK
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(c,s.getHead(),Toast.LENGTH_SHORT).show();
            }
        });
        return convertView;
    }
}
