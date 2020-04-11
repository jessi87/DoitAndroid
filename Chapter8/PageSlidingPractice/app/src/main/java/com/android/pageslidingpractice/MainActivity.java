package com.android.pageslidingpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    boolean isPageOpen = false;

    Animation leftAnim;
    Animation rightAnim;

    LinearLayout page;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        page = findViewById(R.id.page);

        leftAnim = AnimationUtils.loadAnimation(this,R.anim.translate_left);
        rightAnim = AnimationUtils.loadAnimation(this,R.anim.translate_right);

        SlidingPageAnimationListener animListener = new SlidingPageAnimationListener();
        leftAnim.setAnimationListener(animListener);
        rightAnim.setAnimationListener(animListener);

        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isPageOpen){
                    page.startAnimation(rightAnim);
                } else{
                    page.setVisibility(View.VISIBLE); //버튼을 누를 때 바로 보이고 애니메이션이 시작되야 하므로
                    page.startAnimation(leftAnim);
                }
            }
        });
    }

    //커스텀 애니메이션 리스너 생성
    private class SlidingPageAnimationListener implements Animation.AnimationListener{

        //애니메이션이 끝났을 때 호출
        @Override
        public void onAnimationEnd(Animation animation) {
            if(isPageOpen){
                page.setVisibility(View.INVISIBLE); //버튼 누를 때가 아니고 애니메이션이 끝나고 안보여야 하므로
                button.setText("Open");
                isPageOpen = false;
            } else {
                button.setText("Close");
                isPageOpen = true;
            }
        }
        @Override
        public void onAnimationStart(Animation animation) {}

        @Override
        public void onAnimationRepeat(Animation animation) {}
    }
}
