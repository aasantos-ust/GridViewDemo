package com.example.myapplication;

import android.view.View;
import android.widget.ImageView;

public class ViewHolder {
    ImageView logoView;
    ViewHolder(View v){
        logoView = (ImageView) v.findViewById(R.id.imageView);
    }

}
