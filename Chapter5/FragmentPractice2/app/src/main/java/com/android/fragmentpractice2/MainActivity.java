package com.android.fragmentpractice2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements ListFragment.ImageSelectionCallback{

    ListFragment listFragment;
    ViewerFragment viewerFragment;

    int[] images = {R.drawable.pic1,R.drawable.pic2,R.drawable.pic3};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager manager = getSupportFragmentManager();
        listFragment = (ListFragment) manager.findFragmentById(R.id.listFragment);
        viewerFragment = (ViewerFragment) manager.findFragmentById(R.id.viewerFragment);
    }


    @Override
    //프래그먼트의 이미지를 바꾸려면 액티비티로 데이터를 전달해서 실행해야함
    public void onImageSelected(int position) {
        viewerFragment.setImg(images[position]);

    }
}
