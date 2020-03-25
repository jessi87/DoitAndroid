package com.android.doitmission09;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import static android.app.DatePickerDialog.*;

public class InfoFragment extends Fragment {

    EditText name;
    EditText age;
    Button birthday;
    Button button;

    Context thisContext;
    Calendar calendar = Calendar.getInstance();
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy년 MM월 dd일"); //날짜형식 지정

    //DatePicker 리스너 정의 (오류내용 : 처음에 onClick()에 넣으려했지만 실패해서 따로 리스너만 빼서 적용)
    DatePickerDialog.OnDateSetListener datePicker = new DatePickerDialog.OnDateSetListener(){
        @Override
        public void onDateSet(DatePicker datePicker, int year, int month, int date) {
            calendar.set(Calendar.YEAR, year);
            calendar.set(Calendar.MONTH, month);
            calendar.set(Calendar.DAY_OF_MONTH, date);
            birthday.setText(dateFormat.format(calendar.getTime())); //선택한 날짜
        }
    };

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof MainActivity){ //액티비티의 context 가져오기 중요!!!!
            thisContext =  context;
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.info_fragment,container,false);
        name = rootView.findViewById(R.id.editText);
        age = rootView.findViewById(R.id.editText2);
        birthday = rootView.findViewById(R.id.button);

        //context = container.getContext(); //오류발생 이유먼지몰라아아앙 -> onAttach에서 가져옴

        birthday.setText(dateFormat.format(calendar.getTime())); //초기내용 : 오늘날짜
        birthday.setOnClickListener(new View.OnClickListener() { //날짜다이얼로그 출력
            @Override
            public void onClick(View view) {
               DatePickerDialog dialog =  new DatePickerDialog(thisContext,datePicker,calendar.get(Calendar.YEAR),
                       calendar.get(Calendar.MONTH),calendar.get(Calendar.DATE));
               dialog.show();
            }
        });
        button = rootView.findViewById(R.id.button2); //저장 버튼
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(thisContext,"이름 : "+name.getText()+"\n나이 : "+age.getText()
                        +"\n생일 : "+birthday.getText(),Toast.LENGTH_LONG).show();
            }
        });

        return rootView;
    }
}
