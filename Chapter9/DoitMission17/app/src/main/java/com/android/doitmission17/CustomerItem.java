package com.android.doitmission17;

import android.content.Context;
import android.media.Image;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.android.doitmission17.R;

public class CustomerItem extends LinearLayout {
    ImageView profile;
    TextView name;
    TextView phone;
    TextView address;

    public CustomerItem(Context context) {
        super(context);
        init(context);
    }

    public CustomerItem(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public void init(Context context){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.customer_info,this,true);

        profile = findViewById(R.id.profilePic);
        name = findViewById(R.id.name);
        phone = findViewById(R.id.mobile);
        address = findViewById(R.id.address);

    }
    public void setProfile(int resId){
        profile.setImageResource(resId);
    }
    public void setName(String n){
        name.setText(n);
    }
    public void setPhone(String p){
        phone.setText(p);
    }
    public void setAddress(String a){
        address.setText(a);
    }
}
