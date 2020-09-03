package com.android.doitmission18;

import android.content.Context;
import android.media.Image;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class ItemGallery extends LinearLayout {
    ImageView pic;
    TextView date;

    public ItemGallery(Context context) {
        super(context);
        init(context);
    }

    public ItemGallery(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public void init(Context context){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.item_sample,this,true);

        pic = findViewById(R.id.pic);
        date = findViewById(R.id.date);
    }

    public void setPic(int resId) {
        pic.setImageResource(resId);
    }
    public void setDate(String d) {
        date.setText(d);
    }
}
