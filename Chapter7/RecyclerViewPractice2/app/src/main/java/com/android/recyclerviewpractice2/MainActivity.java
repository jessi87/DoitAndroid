package com.android.recyclerviewpractice2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    PersonAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        GridLayoutManager manager = new GridLayoutManager(this,2); //그리드 방식으로 레이아웃 설정
        recyclerView.setLayoutManager(manager); //리싸이클러뷰에 레이아웃 매니저 설정

        adapter = new PersonAdapter();
        adapter.addItem(new Person("김철수","010-3458-9120"));
        adapter.addItem(new Person("이하늘","010-6974-0156"));
        adapter.addItem(new Person("최무신","010-0000-0000"));
        adapter.addItem(new Person("아무개","010-0000-0000"));
        adapter.addItem(new Person("아무개","010-0000-0000"));
        adapter.addItem(new Person("아무개","010-0000-0000"));
        adapter.addItem(new Person("아무개","010-0000-0000"));
        adapter.addItem(new Person("아무개","010-0000-0000"));
        adapter.addItem(new Person("아무개","010-0000-0000"));

        recyclerView.setAdapter(adapter); //리싸이클러뷰에 어댑터 설정
        //어댑터 클래스 외부에서 리스너 설정
        adapter.setOnItemClickListener(new OnPersonItemClickListener() {
            @Override
            public void onItemClick(PersonAdapter.ViewHolder holder, View view, int position) {
                Person item = adapter.getItem(position);
                Toast.makeText(getApplicationContext(),"아이템 선택됨 : "+item.getName(),Toast.LENGTH_LONG).show();
            }
        });
    }
}
