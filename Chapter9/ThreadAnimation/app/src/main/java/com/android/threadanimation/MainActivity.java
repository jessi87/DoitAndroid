package com.android.threadanimation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    ArrayList<Drawable> faceList = new ArrayList<>();

    Handler handler = new Handler();
    boolean isRunning = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources res = getResources();
        faceList.add(res.getDrawable(R.drawable.face1)); //ArrayList에 저장
        faceList.add(res.getDrawable(R.drawable.face2));
        faceList.add(res.getDrawable(R.drawable.face3));
        faceList.add(res.getDrawable(R.drawable.face4));
        faceList.add(res.getDrawable(R.drawable.face5));

        imageView = findViewById(R.id.imageView);
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AnimThread thread = new AnimThread();
                thread.start();
            }
        });

        //스레드 종료를 구현해보려 했는데 안 멈춰진다....ㅜㅜ
        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isRunning = false;
            }
        });

    }

    private class AnimThread extends Thread{
        public void run(){
            isRunning = true;
            while(isRunning){
                int index = 0;
                for (int i =0; i<100; i++) {
                    final Drawable drawable = faceList.get(index); //Drawable 객체로 이미지 받아오기
                    index += 1;
                    if(index > 4){ //마지막 그림에서 다시 처음 그림으로
                        index=0;
                    }
                    handler.post(new Runnable() { //UI에 접근하기 위해
                        @Override
                        public void run() {
                            imageView.setImageDrawable(drawable); //이미지뷰에 설정
                        }
                    });

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

//        public void setRunningState(boolean state) {
//            isRunning = state;
//
//        }
    }
}
