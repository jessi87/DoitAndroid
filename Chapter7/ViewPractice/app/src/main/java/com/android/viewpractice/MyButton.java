package com.android.viewpractice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

import androidx.appcompat.widget.AppCompatButton;

public class MyButton extends AppCompatButton {

    //Context 객체 : UI를 만들 때 생성자에서 항상 Context 객체가 전달되어야함
    //AttributeSet 객체 : xml 레이아웃에서 태그에 추가하는 속성을 전달받기 위한 것, 이 뷰를 xml 레이아웃에 추가하는 경우 사용
    public MyButton(Context context) {
        super(context);
        init(context);
    }

    public MyButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        setBackgroundColor(Color.MAGENTA);
        setTextColor(Color.WHITE);

        float textSize = getResources().getDimension(R.dimen.text_size); //픽셀값으로 자동변환
        setTextSize(textSize); //픽셀단위만 설정가능, 하지만 sp 단위를 권장하므로 위의 메서드를 사용하여 변환
    }

    //뷰가 그려질 때 호출되는 함수
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.d("MyButton","onDraw() 호출됨");
    }

    //뷰가 터치될 때 호출되는 함수
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d("MyButton","onTouchEvent() 호출됨");

        int action = event.getAction();
        switch (action){
            case MotionEvent.ACTION_DOWN :
                setBackgroundColor(Color.CYAN);
                setTextColor(Color.YELLOW);
                break;
            case MotionEvent.ACTION_UP:
                setBackgroundColor(Color.MAGENTA);
                setTextColor(Color.WHITE);
                break;
            case MotionEvent.ACTION_CANCEL:
            case MotionEvent.ACTION_OUTSIDE:

        }

        invalidate(); //뷰의 변화가 있을 때 호출 -> onDraw() 자동호출 (뷰 다시 그리기)
        return true;
    }
}
