package com.android.intentpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CalllIntent extends AppCompatActivity {

    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calll_intent);

        editText = findViewById(R.id.editText);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                String data = editText.getText().toString();
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(data));
                startActivity(intent);
            }
        });

        Button button1 = findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                //컴포넌트 이름을 이용해 새로운 액티비티 출력
                ComponentName name = new ComponentName("com.android.intentpractice",
                        "com.android.intentpractice.MenuActivity"); //패키지이름, 클래스이름
                intent.setComponent(name); //인텐트 객체에 컴포넌트 저장
                startActivityForResult(intent,101);
            }
        });
    }
}
