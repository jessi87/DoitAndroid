package com.android.doitmission18;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    FrameLayout container;
    ItemGallery view1;
    ItemGallery view2;

    TextView num;
    int current;
    int total;

    Animation slideIn;
    Animation slideOut;
    Handler handler = new Handler();

    int viewNum = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        container = findViewById(R.id.container);

        view1 = new ItemGallery(this);
        view1.setName("김철수");
        view1.setPhone("010-4829-4912");
        view1.setAddress("서울시 강남구");
        container.addView(view1);

        view2 = new ItemGallery(this);
        view2.setName("이민호");
        view2.setPhone("010-9327-1286");
        view2.setAddress("서울시 송파구");
        container.addView(view2);


        slideIn = AnimationUtils.loadAnimation(this,R.anim.slide_in);
        slideOut = AnimationUtils.loadAnimation(this,R.anim.slide_out);

        AnimationThread thread = new AnimationThread();
        thread.start();
    }

    class AnimationThread extends Thread {
        public void run() {
            while (true) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        if (viewNum == 0) {
                            view1.startAnimation(slideIn);
                            view2.startAnimation(slideOut);
                            viewNum = 1;
                            numPerson.setText("1/2");
                        } else if (viewNum == 1) {
                            view1.startAnimation(slideOut);
                            view2.startAnimation(slideIn);
                            viewNum = 0;
                            numPerson.setText("2/2");
                        }
                    }
                });

                try {
                    Thread.sleep(5000);
                } catch (Exception e) {
                }
            }
        }
    }
}
