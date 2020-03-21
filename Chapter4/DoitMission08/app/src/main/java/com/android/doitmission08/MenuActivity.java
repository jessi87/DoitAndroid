package com.android.doitmission08;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Intent loginIntent = getIntent(); //Intent 받기
        String id = loginIntent.getStringExtra("id");
        String pwd = loginIntent.getStringExtra("pwd");

        TextView idTxt = findViewById(R.id.idTxt);
        TextView pwdTxt = findViewById(R.id.pwdTxt);

        idTxt.setText("Id : "+id); //인텐트 객체의 데이터를 받아서 출력
        pwdTxt.setText("Pwd : "+pwd);

        Button btnCustomer = findViewById(R.id.btnCustomer);
        btnCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),CustomerMenu.class);
                startActivityForResult(intent,100);
            }
        });

        Button btnSales = findViewById(R.id.btnSales);
        btnSales.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),SalesMenu.class);
                startActivityForResult(intent,200);
            }
        });

        Button btnProduct = findViewById(R.id.btnProduct);
        btnProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),ProductMenu.class);
                startActivityForResult(intent,300);
            }
        });

    }

    @Override //응답받은 것을 처리하는 메소드
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 100){ //그 화면만 출력되도 만족
            if(resultCode == RESULT_OK){ //setResult()를 호출했을때 만족 (ex) back키를 누르면 실행되지 않음)
                Toast.makeText(getApplicationContext(),"고객 관리로부터",Toast.LENGTH_SHORT).show();
            }
        } else if(requestCode == 200){
            if(resultCode == RESULT_OK){
                Toast.makeText(getApplicationContext(),"매출 관리로부터",Toast.LENGTH_SHORT).show();
            }
        } else if(requestCode == 300) {
            if(resultCode == RESULT_OK){
                Toast.makeText(getApplicationContext(), "상품 관리로부터", Toast.LENGTH_SHORT).show();
            }
        } else{
            Toast.makeText(getApplicationContext(),"Nothing",Toast.LENGTH_SHORT).show();
        }
    }
}
