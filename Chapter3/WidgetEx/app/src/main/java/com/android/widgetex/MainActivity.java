package com.android.widgetex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawable_ex);
    }
}

// 체크박스, 라디오 버튼에서
// 버튼이 선택되어 있는지 확인 isChecked()
// 체크 상태를 지정 setChecked()
// 버튼의 상태변화 확인 onCheckedChanged()

// 이미지버튼은 버튼과 달리 눌린 상태와 눌리지 않은 상태가 표시X
// 따라서 Selector 를 만들어 사용

// EditText 에는 커서, 자동링크, 줄 간격 조정, 대소문자 표시, 줄임 표시,
// 힌트 표시, 편집 가능, 문자열 변경 처리 등 관련 속성들이 다양하게 존재함