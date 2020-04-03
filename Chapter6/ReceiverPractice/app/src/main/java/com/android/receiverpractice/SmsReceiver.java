package com.android.receiverpractice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SmsReceiver extends BroadcastReceiver {

    public static final String TAG = "SmsReceiver";
    public SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i(TAG,"onReceive() 호출됨");

        Bundle bundle = intent.getExtras(); //인텐트에서 bundle 객체 가져오기
        SmsMessage[] messages = parseSmsMessage(bundle);

        if(messages != null && messages.length>0){ //메시지의 내용이 있다면
            String sender = messages[0].getOriginatingAddress(); //발신자 번호 확인
            Log.i(TAG,"SMS sender : "+sender);

            String contents = messages[0].getMessageBody().toString(); //문자 내용 확인
            Log.i(TAG,"SMS contents : "+contents);

            Date receivedDate = new Date(messages[0].getTimestampMillis()); //문자를 받은 시각 확인
            Log.i(TAG,"SMS received date : "+receivedDate.toString());

            sendToActivity(context,sender,contents,receivedDate); //받은 sms를 인텐트에 부가 데이터로 넣어 sms 액티비티로 전달
        }
    }

    private SmsMessage[] parseSmsMessage(Bundle bundle) {
        Object[] objs = (Object[]) bundle.get("pdus"); //bundle 객체에 있는 부가 데이터중 pdus 가져오기
        SmsMessage[] messages = new SmsMessage[objs.length];

        int smsCount = objs.length;
        for(int i=0; i<smsCount; i++){
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){ //단말 os 버전에 따라 다른 방식으로 호출(마시멜로보다 크거나 같으면)
                String format = bundle.getString("format");
                messages[i] = SmsMessage.createFromPdu((byte[]) objs[i], format); //sms 데이터 확인
            } else {
                messages[i] = SmsMessage.createFromPdu((byte[]) objs[i]);
            }
        }

        return messages;
    }

    private void sendToActivity(Context context, String sender, String contents, Date receivedDate) {
        Intent myIntent = new Intent(context,SmsActivity.class);

        //브로드캐스트 수신자는 화면이 없으니 new_task, 중복 액티비티 생성 방지 clear_top, single_top
        myIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_SINGLE_TOP|Intent.FLAG_ACTIVITY_NEW_TASK);

        myIntent.putExtra("sender",sender);
        myIntent.putExtra("contents",contents);
        myIntent.putExtra("receivedDate",format.format(receivedDate));

        context.startActivity(myIntent); //인텐트 전달
    }
}
