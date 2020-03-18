package com.android.layoutpractice;

import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;

import androidx.appcompat.app.AppCompatActivity;


public class ScrollViewActivity extends AppCompatActivity {

    ScrollView scrollView1;
    ImageView imgView;
    BitmapDrawable bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll_view);

        scrollView1= findViewById(R.id.scrollView1);
        imgView = findViewById(R.id.imgView);
        scrollView1.setHorizontalScrollBarEnabled(true); //수평 스크롤바 사용 기능 설정

        //이미지 리소스와 이미지 크기 지정
        Resources res = getResources(); //getDrawable()사용을 위해 Resources객체 참조
        bitmap = (BitmapDrawable) res.getDrawable(R.drawable.img3); //이미지를 getDrawable()을 이용해 BitmapDrawable 객체로 생성
        int bitmapWidth = bitmap.getIntrinsicWidth(); //원본의 가로크기 리턴
        int bitmapHeight = bitmap.getIntrinsicHeight(); //원본의 세로크기 리턴

        imgView.setImageDrawable(bitmap); //이미지뷰에 이미지삽입
        imgView.getLayoutParams().width = bitmapWidth;
        imgView.getLayoutParams().height = bitmapHeight;

    }


    public void onButton1Clicked(View v) {
        changeImage();
    }

    private void changeImage() { //다른이미지로 변환

        Resources res = getResources();
        bitmap = (BitmapDrawable) res.getDrawable(R.drawable.img4);
        int bitmapWidth = bitmap.getIntrinsicWidth();
        int bitmapHeight = bitmap.getIntrinsicHeight();

        imgView.setImageDrawable(bitmap);
        imgView.getLayoutParams().width = bitmapWidth;
        imgView.getLayoutParams().height = bitmapHeight;

    }
}
