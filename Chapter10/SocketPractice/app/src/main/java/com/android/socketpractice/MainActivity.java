package com.android.socketpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    TextView client;
    TextView server;

    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        client = findViewById(R.id.textView2);
        server = findViewById(R.id.textView3);

        Button button = findViewById(R.id.button); //클라이언트
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String data = editText.getText().toString();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        send(data);
                    }
                }).start();
            }
        });

        Button button2 = findViewById(R.id.button2); //서버
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        startServer();
                    }
                }).start();
            }
        });

    }

    public void printClientLog(final String data){ //클라이언트 로그를 텍스트뷰에 출력하기 위해 핸들러사용
        Log.d("MainActivity",data);
        handler.post(new Runnable() {
            @Override
            public void run() {
                client.append(data+"\n");
            }
        });
    }

    public void printServerLog(final String data){
        Log.d("MainActivity",data);
        handler.post(new Runnable() {
            @Override
            public void run() {
                server.append(data+"\n");
            }
        });
    }

    public void send(String data){ //클라이언트에서 데이터 전송
        try{
            int portNumber = 5001;
            Socket socket = new Socket("localhost",portNumber); //소켓 객체 생성
            printClientLog("소켓 연결함");

            //소켓 객체로 데이터 보내기
            //일반적으로는 ObjectOutputStream(자바 전용) 보다는 DataOutputStream 사용
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            outputStream.writeObject(data);
            outputStream.flush();
            printClientLog("데이터 전송함");

            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            printClientLog("서버로부터 받음 : "+inputStream.readObject());
            socket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void startServer(){
        try{
           int portNumber = 5001;
            ServerSocket serverSocket = new ServerSocket(portNumber); //소켓 서버객체 생성
            printServerLog("서버 시작함 : "+portNumber);
            while(true){
                //클라이언트가 접속했을 때 만들어지는 소켓 객체 참조
                Socket socket = serverSocket.accept(); //클라이언트 접속요청이 왔을 때 accept()로 클라이언트 소켓의 연결 정보확인
                InetAddress clientHost = socket.getLocalAddress();
                int clientPort = socket.getPort();
                printServerLog("클라이언트 연결됨 : "+clientHost+" : "+clientPort);

                ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
                Object obj = inputStream.readObject();
                printServerLog("데이터 받음 : "+obj);

                ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
                outputStream.writeObject(obj+" from server");
                outputStream.flush();
                printServerLog("데이터 보냄");

                socket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
