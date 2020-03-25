package com.android.actionbarpractice;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ActionBar abar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //onCreate() 안에서는 getSupportActionBar() 사용
        abar = getSupportActionBar();
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abar.setLogo(R.drawable.home);
                //홈 아이콘 표시 | 홈 아이콘 부분에 로고 아이콘 사용
                abar.setDisplayOptions(ActionBar.DISPLAY_SHOW_HOME|ActionBar.DISPLAY_USE_LOGO);
            }
        });
    }


    @Override
    //화면에 메뉴 기능을 추가, 메뉴 xml 파일을 인플레이션
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);

        View v = menu.findItem(R.id.menu_search).getActionView(); //아이템을 뷰 객체로 참조
        if(v != null){
            EditText editText = v.findViewById(R.id.editText); //아이템 안에 정의한 입력상자 객체 참조
            if(editText != null){
                editText.setOnEditorActionListener(new TextView.OnEditorActionListener() { //입력상자 객체에 리스너 설정
                    @Override
                    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                        Toast.makeText(getApplicationContext(),"입력됨", Toast.LENGTH_SHORT).show();
                        return true;
                    }
                });
            }
        }
        return true;
    }

    @Override
    //메뉴를 선택했을 때 호출되는 메서드
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int curId = item.getItemId();
        switch (curId){
            case R.id.menu_refresh:
                Toast.makeText(this,"새로고침 메뉴",Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_search:
                Toast.makeText(this,"검색 메뉴",Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_settings:
                Toast.makeText(this,"설정 메뉴",Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
