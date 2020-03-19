package com.android.eventpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class OrientationEx extends AppCompatActivity {

    String name;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); // Bundle 객체에 name 변수의 값이 포함되어 있음
        setContentView(R.layout.activity_orientation_ex);
        showToast("onCreate 호출됨");

        editText = findViewById(R.id.editText);
        Button button = findViewById((R.id.button));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = editText.getText().toString();
                showToast("입력된 값 저장 : " + name);
            }
        });

        // 이 화면이 초기화될 때 name 변수의 값 복원
        if(savedInstanceState != null){
            name = savedInstanceState.getString("name");
            showToast("값 복원 완료 : " + name);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        showToast("onStart 호출됨");
    }

    @Override
    protected void onStop() {
        super.onStop();
        showToast("onStop 호출됨");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        showToast("onDestroy 호출됨");
    }

    private void showToast(String data) {
        Toast.makeText(this,data,Toast.LENGTH_SHORT).show();
    }

    // 화면전환 시 액티비티가 종료되므로 그 때의 상태를 저장하고 새로운 액티비티에서 복원
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("name",name); // name 변수의 값 저장
    }
}
