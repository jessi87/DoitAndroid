package com.android.doitmission13;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    PersonAdapter adapter;
    EditText editText1;
    EditText editText2;
    EditText editText3;
    TextView personCount;

    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        personCount = findViewById(R.id.textView2);

        editText1 = findViewById(R.id.editText);
        editText2 = findViewById(R.id.editText2); //날짜형태로 입력받는 것은 실패함!
        editText3 = findViewById(R.id.editText3);
        editText3.addTextChangedListener(new PhoneNumberFormattingTextWatcher()); //번호 입력시 자동으로 (-) 설정해주는 코드!

        recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager manager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false); //그리드 방식으로 레이아웃 설정
        recyclerView.setLayoutManager(manager); //리싸이클러뷰에 레이아웃 매니저 설정

        adapter = new PersonAdapter();

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String name = editText1.getText().toString();
                String birthday = editText2.getText().toString();
                String mobile = editText3.getText().toString();

                if(name.equals("")|birthday.equals("")|mobile.equals("")){ // 공백 시 추가되지 않는 기능 처리
                    Toast.makeText(getApplicationContext(),"값을 모두 입력하세요",Toast.LENGTH_LONG).show();
                } else{
                    adapter.addItem(new Person(name,birthday,mobile));
                    adapter.notifyDataSetChanged(); //없어도 되는거 같은데 몰것다

                    int size = adapter.getItemCount();
                    personCount.setText(size +"명");

                    editText1.setText(null);
                    editText2.setText(null);
                    editText3.setText(null);
                }

            }
        });
        recyclerView.setAdapter(adapter);//리싸이클러뷰에 어댑터 설정

    }
}
