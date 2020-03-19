package com.android.eventpractice2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class DialogExample extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_example);

        textView = findViewById(R.id.textView);

        Button button = findViewById(R.id.buttonDialog);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showMessage();
            }
        });

    }

    private void showMessage() { // 다이얼로그 출력
        // 대화상자를 만들기 위한 빌더 객체 생성
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("안내");
        builder.setMessage("종료하시겠습니까?");
        builder.setIcon(R.drawable.ic_launcher_foreground);

        builder.setPositiveButton("예", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String message = "예 버튼이 눌렸습니다";
                textView.setText(message);
            }
        });

        builder.setNegativeButton("아니오", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String message = "아니오 버튼이 눌렸습니다";
                textView.setText(message);
            }
        });

        builder.setNeutralButton("취소", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String message = "취소 버튼이 눌렸습니다";
                textView.setText(message);
            }
        });

        AlertDialog dialog = builder.create(); // 다이얼로그 객체 생성 후 보여주기
        dialog.show();

    }
}
