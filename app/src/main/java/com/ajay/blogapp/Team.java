package com.ajay.blogapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class Team extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team);
        android.support.v7.app.ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setSubtitle("United in a Common Goal");
            ab.setTitle("The Team");
        }
        JSONArray jsonArray=getJSonData("team.json");
        ArrayList<JSONObject> listItems=getArrayListFromJSONArray(jsonArray);
        ListView listV=(ListView)findViewById(R.id.listv);
        ListAdapter adapter=new ListAdapter(this,R.layout.list_layout,listItems);
        listV.setAdapter(adapter);
    }
    private JSONArray getJSonData(String fileName){
        JSONArray jsonArray=null;
        try {
            InputStream is = getResources().getAssets().open(fileName);
            int size = is.available();
            byte[] data = new byte[size];
            is.read(data);
            is.close();
            String json = new String(data, "UTF-8");
            jsonArray=new JSONArray(json);
        }catch (IOException e){
            e.printStackTrace();
        }catch (JSONException je){
            je.printStackTrace();
        }
        return jsonArray;
    }
    private ArrayList<JSONObject> getArrayListFromJSONArray(JSONArray jsonArray){
        ArrayList<JSONObject> aList=new ArrayList<JSONObject>();
        try {
            if (jsonArray != null) {
                for (int i = 0; i < jsonArray.length(); i++) {
                    aList.add(jsonArray.getJSONObject(i));
                }
            }
        }catch (JSONException je){je.printStackTrace();}
        return aList;
    }
}
