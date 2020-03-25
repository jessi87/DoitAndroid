package com.android.fragmentpractice;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


public class MainFragment extends Fragment {

//    MainActivity activity;
//
//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        activity = (MainActivity) getActivity();
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        //최상위 레이아웃 -> 메인프래그먼트는 이 레이아웃을 화면에 보여주기 위한 틀
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_main, container, false);

        Button button = rootView.findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity activity = (MainActivity) getActivity(); // 프래그먼트가 올라가 있는 액티비티가 어떤 것인지 확인 메서드
                activity.onFragmentChanged(1); //프래그먼트 매니저를 이용해 프래그먼트를 전환하는 메서드

            }
        });

        return rootView;
    }


}
