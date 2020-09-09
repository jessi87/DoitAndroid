package com.android.httppractice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    TextView textView;
    Handler handler = new Handler(); //스레드에서 처리한 결과물을 화면에 표시할때 사용하기 위해

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        textView = findViewById(R.id.textView);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String urlInput = editText.getText().toString();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        request(urlInput); //스레드 안에서 호출
                    }
                }).start();
            }
        });
    }

    //응답 결과를 모아 화면에 출력
    private void request(String urlInput) {
        StringBuilder builder = new StringBuilder();
        try{
            URL url = new URL(urlInput); //URL 객체 생성
            HttpURLConnection conn = (HttpURLConnection) url.openConnection(); //Http 클라이언트 생성
            if (conn != null) {
                conn.setConnectTimeout(10000); //연결대기 시간
                conn.setRequestMethod("GET"); //요청방식 설정
                conn.setDoInput(true); //객체의 입력이 가능하도록

                int resCode = conn.getResponseCode(); //응답코드, 웹서버에 페이지를 요청하는 과정
                //입력데이터를 받기위한 Reader 객체생성(응답으로 들어온 스트림을 문자로 변환하여 반환)
                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String line = null;
                while (true) {
                    line = reader.readLine(); //스트림을 한 줄씩 읽어들임
                    if (line == null) {
                        break;
                    }
                    builder.append(line+"\n");
                }
                reader.close();
                conn.disconnect();
            }

        } catch (Exception e) {
            println("예외 발생함 : "+ e.toString());
            e.printStackTrace();
        }
        println("응답 -> "+builder.toString());
    }

    private void println(final String s) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                textView.append(s+"\n");
            }
        });

    }
}
