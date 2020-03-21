package com.android.doitmission08;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SalesMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sales_menu);

        Button btnToMenu = findViewById(R.id.btnToMenu);
        btnToMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MenuActivity.class);
                setResult(RESULT_OK,intent);
                finish();
            }
        });

        Button btnToLogin = findViewById(R.id.btnToLogin);
        btnToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); //중간 액티비티를 모두 종료하고 바로 호출한 액티비티로
                startActivity(intent);
                Toast.makeText(getApplicationContext(),"로그인으로",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
