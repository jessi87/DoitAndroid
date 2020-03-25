package com.android.fragmentpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    MainFragment mainFragment;
    MenuFragment menuFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //프래그먼트는 뷰가 아니라 findViewById()로 찾을 수 없음
        mainFragment = (MainFragment) getSupportFragmentManager().findFragmentById(R.id.mainFragment);
        //메인프래그먼트와 달리 new 연산자로 객체 할당
        menuFragment = new MenuFragment();
    }

    public void onFragmentChanged(int index) {
        if(index == 0){
            //매니저 참조하기 -> 트랜젝션 시작 -> 트랜젝션 실행
            getSupportFragmentManager().beginTransaction().replace(R.id.container,mainFragment).commit();
        } else if(index == 1){
            getSupportFragmentManager().beginTransaction().replace(R.id.container,menuFragment).commit();
        }
    }
}
