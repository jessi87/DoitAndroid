package com.android.doitmission04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText inputBox;
    TextView countNum;
    Button submitButton;
    Button closeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputBox = findViewById(R.id.inputBox);
        countNum = findViewById(R.id.countNum);
        submitButton = findViewById(R.id.submitButton);
        closeButton = findViewById(R.id.closeButton);

        inputBox.addTextChangedListener(new TextWatcher(){ //문자수 세는 메소드

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String input = inputBox.getText().toString();
                countNum.setText(input.length()+" / 80 자");

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }

    public void setSubmitButton(View v){ //토스트 메시지 출력
        String input = inputBox.getText().toString();
        Toast.makeText(getApplicationContext(),input + "\n\n전송합니다", Toast.LENGTH_LONG).show();
    }

    public void setCloseButton(View v){ //앱 종료
        finish();

    }
}
