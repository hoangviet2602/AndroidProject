package com.example.phamxuantoan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class EnventAdapter extends ArrayAdapter<Envent> {

    private Context context;
    private int resource;
    private List<Envent> arrEv;

    public EnventAdapter(Context context, int resource, ArrayList<Envent> arrEv) {
        super(context, resource, arrEv);
        this.context = context;
        this.resource = resource;
        this.arrEv = arrEv;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.con_title = (TextView) convertView.findViewById(R.id.con_title);
            viewHolder.con_envent = (TextView) convertView.findViewById(R.id.con_envent);
            viewHolder.con_timecoundownt = (TextView) convertView.findViewById(R.id.con_timecoundownt);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Envent e = arrEv.get(position);

        viewHolder.con_title.setText(e.getTitle());
        viewHolder.con_envent.setText(e.getEnvent());
        viewHolder.con_timecoundownt.setText(e.getDate());
        return convertView;
    }

    public class ViewHolder {
        TextView con_title, con_envent, con_timecoundownt;
    }
}
