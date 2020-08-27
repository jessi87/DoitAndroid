package com.android.threadpractice;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    MainHandler handler;
    Handler handler2 = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        textView.setMovementMethod(new ScrollingMovementMethod()); //텍스트뷰 스크롤 처리

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BackgroundThread thread = new BackgroundThread(); //첫 번째 방법
                thread.start();

                Thread thread1 = new Thread(new Runnable() { //두 번째 방법
                    int value = 0;
                    @Override
                    public void run() {
                        for (int i = 0; i < 50; i++) {
                            try {
                                Thread.sleep(500);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            value +=1;
                            Log.d("Thread","value2 : "+value);
                            handler2.post(new Runnable() { //메시지 전송 방법 대신 사용가능
                                @Override
                                public void run() {
                                    textView.append("\nvalue2 값 : "+ value);
                                }
                            });
                        }
                    }
                });
                thread1.start();
            }
        });

        handler = new MainHandler(); //핸들러 객체 생성
    }

    class BackgroundThread extends Thread{
        public void run(){
            int value = 0;
            for (int i = 0; i < 50; i++) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                value +=1;
                Log.d("Thread","value1 : "+value);

                Message message = handler.obtainMessage(); //메시지 객체 참조
                Bundle bundle = new Bundle();
                bundle.putInt("value",value);
                message.setData(bundle); //메시지에 번들 객체를 넣기

                handler.sendMessage(message); //핸들러로 메시지 전달
            }
        }
    }

    private class MainHandler extends Handler {
        @Override
        //핸들러 안에서 전달받은 메시지 처리
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);

            Bundle bundle = msg.getData();
            int value = bundle.getInt("value");
            textView.append("\nvalue1 값 : " + value);
        }
    }
}
