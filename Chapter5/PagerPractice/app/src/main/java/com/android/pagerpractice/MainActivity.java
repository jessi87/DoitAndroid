package com.android.pagerpractice;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(1); //버튼으로 화면 전환 시 setCurrentItem()
            }
        });

        viewPager = findViewById(R.id.pager);
        viewPager.setOffscreenPageLimit(3); //미리 로딩해 놓을 아이템의 개수

        MyPagerAdapter adapter = new MyPagerAdapter(getSupportFragmentManager());

        Fragment1 frag1 = new Fragment1();
        Fragment2 frag2 = new Fragment2();
        Fragment3 frag3 = new Fragment3();

        adapter.addItem(frag1); //어댑터 객체에 프래그먼트 추가
        adapter.addItem(frag2);
        adapter.addItem(frag3);

        viewPager.setAdapter(adapter); //뷰페이저에 어댑터 설정 -> 뷰페이저는 어댑터에 있는 프래그먼트들을 화면에 보여줌
    }

    // 어댑터 : 뷰페이저에 보여줄 각 프래그먼트를 관리
    class MyPagerAdapter extends FragmentStatePagerAdapter{
        ArrayList<Fragment> items = new ArrayList<Fragment>();

        public MyPagerAdapter(FragmentManager fm){
            super(fm);
        }

        public void addItem(Fragment item){
            items.add(item);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return items.get(position);
        }

        @Override
        public int getCount() {
            return items.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) { //타이틀스트립 설정
            return "페이지"+(position+1);
        }

    }
}
