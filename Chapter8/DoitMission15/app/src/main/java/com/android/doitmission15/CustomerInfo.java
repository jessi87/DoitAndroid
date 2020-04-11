package com.android.doitmission15;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CustomerInfo extends AppCompatActivity {
    Button btnSave;
    Button btnBirth;
    EditText nameText;
    EditText ageText;
    EditText birthText;

    Calendar calendar = Calendar.getInstance();
    static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy년 MM월 dd일");


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cutomer_info);

        nameText = findViewById(R.id.editText);
        ageText = findViewById(R.id.editText2);
        birthText = findViewById(R.id.editText3);

        btnSave = findViewById(R.id.button2);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); //메인 액티비티 중복 생성 방지

                intent.putExtra("name",nameText.getText().toString());
                intent.putExtra("age",ageText.getText().toString());
                intent.putExtra("birth",birthText.getText().toString());

                startActivity(intent);
                finish(); //안 끝내면 계속 위에 쌓이게 된다

                overridePendingTransition(R.anim.main_right,R.anim.slide_right);
            }
        });


        btnBirth = findViewById(R.id.button3); //달력 다이얼로그
        btnBirth.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showDateDialog();
            }
        });
    }
    public void showDateDialog(){
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        //오류 : onClick()안에 넣었더니 context 오류가 생김 (getApplicationContext(),this 둘다 안됨) -> 메서드로 빼버림
        DatePickerDialog dialog = new DatePickerDialog(this,datePicker,year,month,day);
        dialog.show();
    }

    DatePickerDialog.OnDateSetListener datePicker = new DatePickerDialog.OnDateSetListener(){
        @Override
        public void onDateSet(DatePicker datePicker, int year, int month, int day) {
            calendar.set(Calendar.YEAR, year);
            calendar.set(Calendar.MONTH, month);
            calendar.set(Calendar.DAY_OF_MONTH, day);
            birthText.setText(dateFormat.format(calendar.getTime())); //생일란에 적용
        }
    };

}
