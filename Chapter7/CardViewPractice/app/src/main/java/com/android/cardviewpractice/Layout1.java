package com.android.cardviewpractice;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class Layout1 extends LinearLayout {
    ImageView imageView;
    TextView textView1;
    TextView textView2;

    public Layout1(Context context) {
        super(context);
        init(context);
    }

    public Layout1(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    //xml 레이아웃 파일을 파라미터로 전달하면 인플레이션이 진행되면서 이 소스 파일에 설정(onCreate()같은 느낌)
    private void init(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.layout1,this,true);

        imageView = findViewById(R.id.imageView);
        textView1 = findViewById(R.id.textView);
        textView2 = findViewById(R.id.textView2);
    }

    public void setImage(int resId){
        imageView.setImageResource(resId);
    }

    public void setName(String name){
        textView1.setText(name);
    }

    public void setMobile(String mobile){
        textView2.setText(mobile);
    }
}
