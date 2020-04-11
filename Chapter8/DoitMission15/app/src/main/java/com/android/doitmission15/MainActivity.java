package com.android.doitmission15;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button;

    Animation leftAnim;
    Animation rightAnim;
    boolean isPageOpen = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        leftAnim = AnimationUtils.loadAnimation(this,R.anim.slide_left);
        rightAnim = AnimationUtils.loadAnimation(this,R.anim.slide_right);


        button = findViewById(R.id.button); //고객정보 화면 나오기
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),CustomerInfo.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_left,R.anim.main_left);
            }
        });

        Intent intent = getIntent(); //처음 화면 로딩시에 토스트 뜨는 것을 막고싶은데 방법을 모르겠음!!
        infoIntent(intent);

    }

    @Override
    protected void onNewIntent(Intent intent) {
        infoIntent(intent);
        super.onNewIntent(intent);
    }

    public void infoIntent(Intent intent){
        if(intent != null){
            String name = intent.getStringExtra("name");
            String age = intent.getStringExtra("age");
            String birth = intent.getStringExtra("birth");

            Toast.makeText(getApplicationContext(),"이름 : "+name+"\n나이 : "+age+"\n생일 : "+birth,Toast.LENGTH_LONG).show();
        }
    }
}
