package com.android.gsonpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    TextView textView;

    static RequestQueue queue; //요청 큐는 한번만 만들어서 계속 사용

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
                makeRequest();
            }
        });

        if (queue == null) {
            queue = Volley.newRequestQueue(getApplicationContext()); //RequestQueue 객체 생성
        }
    }

    private void makeRequest() {
        String url = editText.getText().toString();
        //요청을 보내기 위한 StringRequest 객체 생성(요청방식,사이트주소,응답받을 리스너객체,에러시 호출될 리스너객체)
        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                println("응답 -> " + response);

                processResponse(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                println("에러 -> " + error.getMessage());
            }
        }) {
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<String,String>();
                return params;
            }
        };
        request.setShouldCache(false);//이전 캐시를 사용하지 않겠다
        queue.add(request); //요청 객체를 요청 큐에 넣음->요청 큐가 자동으로 요청, 응답과정 진행
        println("요청 보냄");
    }

    //Gson 객체를 이용해 응답 문자열을 MovieList 객체로 변환
    private void processResponse(String response) {
        Gson gson = new Gson();
        MovieList movieList = gson.fromJson(response,MovieList.class); //JSON 문자열을 MovieList 객체로 변환
        println("영화 정보의 수 : "+movieList.boxOfficeResult.dailyBoxOfficeList.size());
    }

    void println(String data){
        textView.append(data+"\n");
    }
}
