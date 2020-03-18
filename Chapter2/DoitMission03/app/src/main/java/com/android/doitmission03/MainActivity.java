package com.android.doitmission03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;

public class MainActivity extends AppCompatActivity {

    ScrollView scrollUp;
    ScrollView scrollDown;
    Button upButton;
    Button downButton;
    ImageView upImg;
    ImageView downImg;

    BitmapDrawable bitmap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        upButton = findViewById(R.id.upButton);
        downButton = findViewById(R.id.downButton);
        upImg = findViewById(R.id.upImg);
        downImg = findViewById(R.id.downImg);

        setImage(upImg);
    }

    public void upButtonClicked(View v){

        setImage(upImg);
        downImg.setImageResource(0); //imageview 비우기

    }

    public void downButtonClicked(View v){

        setImage(downImg);
        upImg.setImageResource(0);

    }

    public void setImage(ImageView view){

        Resources res = getResources();
        bitmap = (BitmapDrawable) res.getDrawable(R.drawable.flower);
        int bitmapWidth = bitmap.getIntrinsicWidth();
        int bitmapHeight = bitmap.getIntrinsicHeight();

        view.setImageDrawable(bitmap); //이미지뷰에 이미지삽입
        view.getLayoutParams().width = bitmapWidth;
        view.getLayoutParams().height = bitmapHeight;

    }
}
