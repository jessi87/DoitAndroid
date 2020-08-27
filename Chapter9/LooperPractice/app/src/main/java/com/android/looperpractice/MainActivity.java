package com.android.looperpractice;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    TextView textView;
    Handler handler = new Handler(); //메인 스레드의 핸들러

    ProcessThread thread;

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
                String input = editText.getText().toString();
                Message message = Message.obtain(); //메시지 객체 참조
                message.obj = input;

                thread.processHandler.sendMessage(message); //스레드 안에 있는 핸들러로 메시지 전송
            }
        });

        thread = new ProcessThread();
    }

    private class ProcessThread extends Thread{
        ProcessHandler processHandler = new ProcessHandler();

        public void run() {
            Looper.prepare(); //루퍼 설정
            Looper.loop();
        }

        class ProcessHandler extends Handler{ //스레드의 핸들러
            @Override
            public void handleMessage(@NonNull Message msg) {
                final String output = msg.obj+" from thread"; //스레드 내부에서 전달받은 메시지 처리
                handler.post(new Runnable() { //메인스레드로 전달,실행
                    @Override
                    public void run() {
                        textView.setText(output);
                    }
                });
            }
        }
    }
}
