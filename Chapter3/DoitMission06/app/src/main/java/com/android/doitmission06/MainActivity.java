package com.android.doitmission06;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    EditText text;
    SeekBar seekBar;
    ProgressBar progressBar;
    Button buttonChange;
    Button buttonClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBar = findViewById(R.id.seekBar);
        progressBar = findViewById(R.id.progressBar);
        text = findViewById(R.id.editText);
        buttonChange = findViewById(R.id.buttonChange);
        buttonClear = findViewById(R.id.buttonClear);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) { //드래그 하는중
               text.setText("값 : "+ progress); //오류 : editText 의 inputType 을 숫자로 해놓지 않아서
               progressBar.setProgress(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) { //최초 드래그 발생
                text.setText("Loading...");
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) { //드래그 멈출때
                int status = seekBar.getProgress(); //오류 : text.setText(seekBar.getProgress())
                text.setText("값 : "+status);
                progressBar.setProgress(status);
            }
        });

        buttonChange.setOnClickListener(new View.OnClickListener() { //숫자 입력시 seekbar, progressbar 값 변경
            @Override
            public void onClick(View view) {
                int status = Integer.parseInt(text.getText().toString());
                seekBar.setProgress(status);
            }
        });

        buttonClear.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                text.setText("");
            }
        });

    }
}
