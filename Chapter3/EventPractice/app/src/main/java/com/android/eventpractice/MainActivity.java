package com.android.eventpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    GestureDetector detector; // 제스처 이벤트를 처리해주는 클래스
    // 제스처 이벤트 : 터치 이벤트중에서 스크롤 등을 구별한 후 알려주는 이벤트

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);

        View view = findViewById(R.id.view);
        view.setOnTouchListener(new View.OnTouchListener() {  // 파라미터로 리스너 객체 전달

            // 리스터 객체의 메소드, MotionEvent 객체에는 액션 정보나 터치한 곳의 좌표 등이 들어있음
            // 액션 정보는 getAction() 메소드로 확인가능(리턴값 : 정수)
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int action = motionEvent.getAction();

                float curX = motionEvent.getX();
                float curY = motionEvent.getY();

                if(action==MotionEvent.ACTION_DOWN) { // 손가락이 눌렸을 때 (리턴값 0)
                    printText("손가락 눌림 : " + curX + "," + curY);
                }
                else if(action==MotionEvent.ACTION_UP) { // 손가락이 떼졌을 때 (리턴값 1)
                    printText("손가락 뗌 : " + curX + "," + curY);
                }
                else if(action==MotionEvent.ACTION_MOVE){ // 손가락이 움직였을 때 (리턴값 2)
                    printText("손가락 움직임 : " + curX + "," + curY);
                }

                return true;
            }
        });

        // 이 객체에 MotionEvent를 전달하면 각 상황에 맞는 메소드 호출
        detector = new GestureDetector(this, new GestureDetector.OnGestureListener() {
            @Override
            public boolean onDown(MotionEvent motionEvent) {
                printText("onDown() 호출됨");
                return true;
            }

            @Override
            public void onShowPress(MotionEvent motionEvent) {
                printText("onShowPress() 호출됨");
            }

            @Override
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                printText("onSingleTapUp() 호출됨");
                return true;
            }

            // 손가락으로 드래그
            @Override
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
                printText("onScroll() 호출됨" + v + "," + v1);
                return true;
            }

            @Override
            public void onLongPress(MotionEvent motionEvent) {
                printText("onLongPress() 호출됨");
           }

            // 빠른 속도로 스크롤
            @Override
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
                printText("onFling() 호출됨" + v + "," + v1);
                return true;
            }
        });

        View view2 = findViewById(R.id.view2);
        view2.setOnTouchListener(new View.OnTouchListener(){

            // GestureDetector 객체의 onTouchEvent() 메소드를 호출하며 MotionEvent 객체를 전달
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                detector.onTouchEvent(motionEvent);
                return true;
            }
        });


    }

    private void printText(String data) {

        textView.append(data + "\n");
    }

    // 키 이벤트 처리하기
    public boolean onKeyDown(int keyCode, KeyEvent event){
        if(keyCode==KeyEvent.KEYCODE_BACK){
            Toast.makeText(this,"뒤로가기 버튼눌림",Toast.LENGTH_SHORT).show();
            return true;
        }
        if(keyCode==KeyEvent.KEYCODE_VOLUME_UP){
            Toast.makeText(this,"소리 키움",Toast.LENGTH_SHORT).show();
            return true;
        }

        return false;
    }

}
