package com.android.parcelablepractice;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MenuActivity extends AppCompatActivity {

    TextView textView;
    public static final String KEY_SIMPLE_DATA = "data";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        textView = findViewById(R.id.textView);
        Button button = findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("name","Jessi");
                setResult(RESULT_OK,intent);

                finish();
            }
        });

        Intent intent = getIntent(); //메인 액티비티로부터 전달 받은 인텐트 객체 참조
        processIntent(intent);
    }

    private void processIntent(Intent intent) {
        if(intent != null){
            Bundle bundle = intent.getExtras(); //getExtras() : 번들 객체 반환
            SimpleData data = bundle.getParcelable(KEY_SIMPLE_DATA);
            if(intent != null){
                textView.setText("전달받은 데이터\n Number : "+data.number+"\n Message : "+data.message);
            }
        }
    }
}
