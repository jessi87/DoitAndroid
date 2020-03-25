package com.android.fragmentpractice2;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ListFragment extends Fragment {

    //인터페이스 생성이유 : 각 액티비티마다 다른 이름의 메서드를 만든다면
    //                   액티비티가 바뀔 때 해당 액티비티가 무엇인지 매번 확인해야 하기 때문에 번거로움
    public interface ImageSelectionCallback{
        void onImageSelected(int position);
    }

    public ImageSelectionCallback callback;

    @Override
    //프래그먼트가 액티비티 위에 올라오는 시점에 호출됨
    public void onAttach(Context context) {
        super.onAttach(context); //onAttach 메서드로 전달되는 파라미터를 참조하여 액티비티 참조

        if(context instanceof ImageSelectionCallback){ //context가 Image~~의 인스턴스이면
            callback = (ImageSelectionCallback) context; //액티비티 객체를 인터페이스 타입으로 참조
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_list,container,false);
        Button button = rootView.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(callback != null){
                    callback.onImageSelected(0);
                }
            }
        });

        Button button2 = rootView.findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(callback != null){
                    callback.onImageSelected(1);
                }
            }
        });

        Button button3 = rootView.findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(callback != null){
                    callback.onImageSelected(2);
                }
            }
        });

        return rootView;
    }
}
