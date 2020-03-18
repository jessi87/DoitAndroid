package com.android.layoutpractice;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class FrameLayout extends AppCompatActivity {

    ImageView img1;
    ImageView img2;

    int imageIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.framelayout);

        img1 = findViewById(R.id.img1);
        img2 = findViewById(R.id.img2);

    }

    public void onButtonClicked(View v){
        changeView();
    }

    public void changeView(){ //버튼을 누르면 번갈아가면서 이미지가 표시됨

        if(imageIndex==0){
            img1.setVisibility(View.VISIBLE);
            img2.setVisibility(View.INVISIBLE);
            imageIndex = 1;
        }

        else if(imageIndex==1){
            img1.setVisibility(View.INVISIBLE);
            img2.setVisibility(View.VISIBLE);
            imageIndex = 0;
        }
    }
}
