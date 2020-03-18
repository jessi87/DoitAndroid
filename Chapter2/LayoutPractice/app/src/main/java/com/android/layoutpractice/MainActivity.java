package com.android.layoutpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(this, ScrollViewActivity.class);
        startActivity(intent);


        //레이아웃을 자바코드로도 구성할 수 있음
        //LinearLayout mainLayout = new LinearLayout(this);
        //mainLayout.setOrientation(LinearLayout.VERTICAL);
        //....
        //setContentView(mainLayout);
        // *this : Context 객체, AppCompatActivity 클래스는 Context를 상속받음
    }
}
