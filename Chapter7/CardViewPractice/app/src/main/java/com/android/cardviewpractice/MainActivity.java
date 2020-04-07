package com.android.cardviewpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Layout1 layout1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout1 = findViewById(R.id.layout1);

        layout1.setImage(R.drawable.ic_launcher_foreground);
        layout1.setName("김민수");
        layout1.setMobile("010-1495-8563");

        Button button1 = findViewById(R.id.button);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                layout1.setImage(R.drawable.profile1);
                layout1.setName("박철강");
                layout1.setMobile("010-7264-9014");
            }
        });

        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                layout1.setImage(R.drawable.profile2);
                layout1.setName("이수현");
                layout1.setMobile("010-1947-6802");
            }
        });
    }
}
