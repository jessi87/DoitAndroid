package com.android.recyclerviewpractice2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);             //세로방향 스크롤
        LinearLayoutManager manager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(manager); //리싸이클러뷰에 레이아웃 매니저 설정

        PersonAdapter adapter = new PersonAdapter();
        adapter.addItem(new Person("김철수","010-3458-9120"));
        adapter.addItem(new Person("이하늘","010-6974-0156"));
        adapter.addItem(new Person("최무신","010-9107-2687"));

        recyclerView.setAdapter(adapter); //리싸이클러뷰에 어댑터 설정
    }
}
