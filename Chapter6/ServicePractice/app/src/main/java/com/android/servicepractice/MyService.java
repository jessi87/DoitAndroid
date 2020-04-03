package com.android.servicepractice;

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
            return Service.START_STICKY; //서비스가 process kill 당했을 때 destroy 되지 않고 살아있게
        } else {
            processCommand(intent);
        }
        return super.onStartCommand(intent, flags, startId); // = Service.START_STICKY
    }

    private void processCommand(Intent intent) {
        String command = intent.getStringExtra("command");
        String name = intent.getStringExtra("name");

        Log.d(TAG, "command : "+command+", name : "+name);

        //5초동안 1초에 한번씩 로그출력
        for(int i=0; i<5; i++){
            try{
                Thread.sleep(1000);
            } catch (Exception e) {}
            Log.d(TAG,"Waiting "+i+" seconds.");
        }

        Intent showIntent = new Intent(getApplicationContext(),MainActivity.class);
        showIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_SINGLE_TOP);

        showIntent.putExtra("command","show");
        showIntent.putExtra("name",name+" from service");
        startActivity(showIntent); //서비스에서 액티비티로 인텐트 전달
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"onDestroy() 호출됨");
    }
}
