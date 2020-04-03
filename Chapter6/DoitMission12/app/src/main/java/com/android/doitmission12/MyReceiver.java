package com.android.doitmission12;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

public class MyReceiver extends BroadcastReceiver {
    public static final String TAG = "MyReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {

        Log.d(TAG,"onReceive() 호출됨");

        if(intent != null){
            String message = intent.getStringExtra("msg");

            Intent myIntent = new Intent(context,MainActivity.class);

            //브로드캐스트 수신자는 화면이 없으니 new_task, 중복 액티비티 생성 방지 clear_top, single_top
            myIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_SINGLE_TOP|Intent.FLAG_ACTIVITY_NEW_TASK);
            myIntent.putExtra("msg",message + " from receiver");

            context.startActivity(myIntent); //인텐트 전달
        }
    }
}
