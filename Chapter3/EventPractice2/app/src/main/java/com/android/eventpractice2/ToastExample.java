package com.android.eventpractice2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class ToastExample extends AppCompatActivity {
    EditText editText;
    EditText editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast_example);

        editText = findViewById(R.id.editText);
        editText2 = findViewById(R.id.editText2);
    }

    public void onButton1Clicked(View v){ // 토스트 위치 바꾸기
        try{
            Toast toastView = Toast.makeText(this,"위치가 바뀐 토스트 메시지",Toast.LENGTH_SHORT);

            int xOffset = Integer.parseInt(editText.getText().toString());
            int yOffset = Integer.parseInt(editText2.getText().toString());

            toastView.setGravity(Gravity.LEFT|Gravity.TOP,xOffset,yOffset);
            toastView.show();
        }
        catch (NumberFormatException e){
            e.printStackTrace();
        }
    }

    public void onButton2Clicked(View v){ // 토스트 모양 바꾸기
        LayoutInflater inflater = getLayoutInflater(); // 레이아웃 인플레이터 객체 참조

        View layout = inflater.inflate(R.layout.toastborder,(ViewGroup)findViewById(R.id.toast_layout_root));
        // 토스트 레이아웃을 메모리에 객체화 (resource, ViewGroup root)

        TextView text = layout.findViewById(R.id.text);

        Toast toast = new Toast(this);
        text.setText("모양 바꾼 토스트");

        toast.setGravity(Gravity.CENTER,0,-100);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout); //토스트가 보이는 뷰 설정
        toast.show();
    }

    public void onButton3Clicked(View v){ // 스낵바 사용(외부 라이브러리)
        Snackbar.make(v, "스낵바 띄우기",Snackbar.LENGTH_LONG).show();
    }
}
