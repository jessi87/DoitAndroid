package com.android.intentpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("name","Jessi"); //name의 값을 부가데이터로 넣기
                setResult(RESULT_OK,intent); //응답 보내기 (새로 띄운 액티비티에서 이전 액티비티로 인텐트를 전달할때)
                finish(); //액티비티 종료
            }
        });
    }
}
