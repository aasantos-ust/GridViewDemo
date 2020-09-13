package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {
    Context context;
    ArrayList<AndroidVersion> androidList;

    CustomAdapter(Context c){
        this.context = c;
        androidList = new ArrayList<>();
        String[] codeNames = c.getResources().getStringArray(R.array.codeName);
        String[] apiLevels = c.getResources().getStringArray(R.array.apiLevel);
        int[] imageIDs = {R.drawable.cupcake, R.drawable.donut, R.drawable.eclair, R.drawable.froyo, R.drawable.gingerbread,
                         R.drawable.honeycomb, R.drawable.ics, R.drawable.jellybean, R.drawable.kitkat, R.drawable.lollipop};
        for(int i=0; i<codeNames.length; i++){
            androidList.add(new AndroidVersion(codeNames[i], apiLevels[i], imageIDs[i]));
        }
    }
    @Override
    public int getCount() {
        return androidList.size();
    }

    @Override
    public Object getItem(int i) {
        return androidList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View row = view;
        ViewHolder holder = null;

        if(row == null ){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.row, viewGroup, false);
            holder = new ViewHolder(row);
            row.setTag(holder);
        }else{
            holder = (ViewHolder) row.getTag();
        }
        AndroidVersion temp = androidList.get(i);
        holder.logoView.setImageResource(temp.imageID);
        return row;
    }
}
