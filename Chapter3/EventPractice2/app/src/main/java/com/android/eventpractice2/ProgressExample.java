package com.android.eventpractice2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class ProgressExample extends AppCompatActivity {

    ProgressDialog dialog; // deprecated된 클래스 -> dialog를 커스텀해서 사용

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_example);

        ProgressBar progressBar = findViewById(R.id.progressBar); //프로그레스바 객체 참조
        progressBar.setIndeterminate(false);
        progressBar.setProgress(80);

        Button button = findViewById(R.id.buttonShow);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog = new ProgressDialog(ProgressExample.this); // 프로그레스 대화상자 객체 생성
                dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                dialog.setMessage("데이터를 확인하는 중입니다");

                dialog.show();
            }
        });

        Button button1 = findViewById(R.id.buttonClose); //
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(dialog != null){ //대화상자 없애기
                    dialog.dismiss();
                }
            }
        });
    }
}
