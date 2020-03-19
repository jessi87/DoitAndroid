package com.android.eventpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.Toast;

public class OrientationEx2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orientation_ex2);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        if(newConfig.orientation==Configuration.ORIENTATION_LANDSCAPE){ //가로
            Toast.makeText(this,"방향 : ORIENTATION_LANDSCAPE",Toast.LENGTH_SHORT).show();
        }
        else if(newConfig.orientation==Configuration.ORIENTATION_PORTRAIT){ //세로
            Toast.makeText(this,"방향 : ORIENTATION_PORTRAIT",Toast.LENGTH_SHORT).show();
        }
    }
}
