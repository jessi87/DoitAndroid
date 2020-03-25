package com.android.fragmentpractice2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ViewerFragment extends Fragment {

    ImageView imgView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_viewer,container,false);

        imgView = rootView.findViewById(R.id.imageView);
        return rootView;
    }

    public void setImg(int resId){ // 액티비티에서 이 프래그먼트에 있는 이미지뷰에 이미지를 설정하도록
        imgView.setImageResource(resId);
    }
}
