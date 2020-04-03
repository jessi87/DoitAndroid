package com.android.servicepractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = editText.getText().toString();

                //인텐트 객체를 만들고 부가데이터 넣기
                Intent intent = new Intent(getApplicationContext(),MyService.class);
                intent.putExtra("command","show");
                intent.putExtra("name",name);

                startService(intent); //서비스 시작 -> 인텐트는 onStartCommand()로 전달
            }
        });

        Button btnQuit = findViewById(R.id.button2);
        btnQuit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MyService.class);
                stopService(intent); //서비스 종료
            }
        });

        Intent passedIntent = getIntent(); //액티비티가 새로 만들어질 때 전달된 인텐트 처리
        processIntent(passedIntent);
    }

    private void processIntent(Intent intent) {
        if(intent != null){
            String command = intent.getStringExtra("command");
            String name = intent.getStringExtra("name");

            Toast.makeText(this,"command : "+command+", name : "+name,Toast.LENGTH_LONG).show();
        }

    }

    //액티비티가 이미 만들어져 있을 때(재사용) 전달된 인텐트 처리
    @Override
    protected void onNewIntent(Intent intent) {
        processIntent(intent);
        super.onNewIntent(intent);
    }
}
