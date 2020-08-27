package com.android.asynctaskpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {
    BackgroundTask task;
    int value;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = findViewById(R.id.progressBar);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                task = new BackgroundTask(); //AsyncTask 객체 만들어 실행
                task.execute();
            }
        });

        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                task.cancel(true);
            }
        });
    }

    //<> : doIn~, onProgress~, onPost~ 메서드의 파라미터를 결정
    private class BackgroundTask extends AsyncTask<Integer,Integer,Integer> {
        @Override
        protected Integer doInBackground(Integer ... values) { //백그라운드 작업 실행
            while(isCancelled()==false){ //task.cancel()하면 루프 빠져나옴
                value++;
                if(value>=100){
                    break; //100이상이면 루프 빠져나옴
                } else{
                    publishProgress(value); //중간 중간 진행 상태를 UI에 업데이트
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return value;
        }

        @Override
        protected void onPreExecute() { //초기화 단계, 백그라운드 작업 전에 호출
            value=0;
            progressBar.setProgress(value);
        }

        protected void onProgressUpdate(Integer ... values) { //publishProgress() 호출하면 호출됨
            progressBar.setProgress(values[0].intValue());
        }

        protected void onPostExecute(Integer result) { //백그라운드 작업 끝난 후에 호출
            progressBar.setProgress(0);
        }

        @Override
        protected void onCancelled() { //task.cancel() 호출시에 호출됨
            progressBar.setProgress(0);
        }
    }
}
