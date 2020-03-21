package com.android.doitmission08;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    EditText editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        editText2 = findViewById(R.id.editText2);



        Button button = findViewById(R.id.btnLogin);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = editText.getText().toString();
                String pwd = editText2.getText().toString();

                if(id.length()==0 || pwd.length()==0){ //오류 : id==null안먹힘, id랑 pwd를 onClick 안에서 선언해야함
                    Toast.makeText(getApplicationContext(),"아이디와 비밀번호를 입력하세요",Toast.LENGTH_LONG).show();
                } else{
                    Intent intent = new Intent(getApplicationContext(),MenuActivity.class);
                    intent.putExtra("id",id); //MenuActivity에 부가데이터 전달
                    intent.putExtra("pwd",pwd); //MenuActivity에 부가데이터 전달
                    startActivityForResult(intent,007);
                }

            }
        });

    }
}
