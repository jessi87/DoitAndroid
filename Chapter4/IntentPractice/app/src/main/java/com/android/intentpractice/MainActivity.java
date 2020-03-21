package com.android.intentpractice;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final int REQUEST_CODE_MENU=100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MenuActivity.class); //새로운 액티비티 불러오기
                startActivityForResult(intent,REQUEST_CODE_MENU); //새 액티비티를 띄울 때 보낼 요청코드
            }
        });
    }

    //받은 응답을 처리하는 메소드
    //요청, 응답코드는 임의로 내가 정할 수 있다
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==REQUEST_CODE_MENU){
            Toast.makeText(getApplicationContext(),"onActivityResult 메소드 호출됨. 요청코드 : "+requestCode
            +", 결과코드 : "+resultCode,Toast.LENGTH_LONG).show();

            if (resultCode == RESULT_OK) {
                String name = data.getStringExtra("name"); //data : 새 액티비티를 부터 전달받은 인탠트
                Toast.makeText(getApplicationContext(),"응답으로 전달된 name : "+name,Toast.LENGTH_LONG).show();
            }
        }
    }
}
