package com.ajay.blogapp;

/**
 * Created by ajay's on 28-03-2017.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ListAdapter extends ArrayAdapter<JSONObject>{
    int vg;
    ArrayList<JSONObject> list;
    Context context;
    public ListAdapter(Context context, int vg, ArrayList<JSONObject> list){
        super(context,vg,list);
        this.context=context;
        this.vg=vg;
        this.list=list;
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(vg, parent, false);
        TextView txtName=(TextView)itemView.findViewById(R.id.txtname);
        TextView txtSex=(TextView)itemView.findViewById(R.id.txtprofile);
        try {
            txtName.setText(list.get(position).getString("name"));
            txtSex.setText(list.get(position).getString("profile"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return itemView;
    }
}