package com.android.doitmission12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        textView = findViewById(R.id.textView);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = editText.getText().toString();

                Intent intent = new Intent(getApplicationContext(),MyService.class);
                intent.putExtra("msg",message);

                startService(intent); //서비스 시작 -> 인텐트는 onStartCommand()로 전달
            }
        });

        Intent passedIntent = getIntent(); //액티비티가 새로 만들어질 때 전달된 인텐트 처리
        processIntent(passedIntent);
    }

    private void processIntent(Intent intent) {
        if(intent != null){
            String message = intent.getStringExtra("msg");
            textView.setText(message);
        }
    }

    @Override
    protected void onNewIntent(Intent intent) {
        processIntent(intent);
        super.onNewIntent(intent);
    }

}
