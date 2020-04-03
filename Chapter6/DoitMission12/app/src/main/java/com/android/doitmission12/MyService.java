package com.android.doitmission12;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    public static final String TAG = "MyService";

    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG,"onCreate() 호출됨");
    }

    //서비스로 전달된 인텐트 객체를 처리
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG,"onStartCommand() 호출됨");

        if(intent == null){
            return Service.START_STICKY;
        } else {
            processCommand(intent);
        }
        return super.onStartCommand(intent, flags, startId); // = Service.START_STICKY
    }

    private void processCommand(Intent intent) {
        String message = intent.getStringExtra("msg");

        Intent showIntent = new Intent(getApplicationContext(),MyReceiver.class);
        showIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_SINGLE_TOP);

        showIntent.putExtra("msg",message+" from service");
        sendBroadcast(showIntent); //서비스에서 브로드캐스트로 인텐트 전달
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"onDestroy() 호출됨");
    }
}
