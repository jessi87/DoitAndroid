package com.android.doitmission16;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    LinearLayout layout;
    WebView webView;

    Animation upAnimaiton;
    Animation downAnimation;

    EditText searchText;
    Button searchButton;
    ImageButton openButton;

    boolean ispageOpen = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        layout = findViewById(R.id.searchLayout);
        searchText = findViewById(R.id.search_text);

        webView = findViewById(R.id.webView);
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);

        webView.setWebViewClient(new WebViewClient()); //오류 : 이거 안해주면 새창으로 인터넷이 뜬다

        upAnimaiton = AnimationUtils.loadAnimation(this,R.anim.slide_up);
        downAnimation = AnimationUtils.loadAnimation(this,R.anim.slide_down);

        //애니메이션 리스너 설정
        Animation.AnimationListener animationListener = new Animation.AnimationListener() {
            @Override
            public void onAnimationEnd(Animation animation) {
                if(ispageOpen){
                    layout.setVisibility(View.INVISIBLE);
                    openButton.setVisibility(View.VISIBLE);
                    ispageOpen = false;

                } else {
                    ispageOpen = true;
                }
            }
            @Override
            public void onAnimationStart(Animation animation) {}

            @Override
            public void onAnimationRepeat(Animation animation) {}
        };
        upAnimaiton.setAnimationListener(animationListener);
        downAnimation.setAnimationListener(animationListener);

        searchButton = findViewById(R.id.search_btn); //웹사이트 검색
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String page = searchText.getText().toString();
                if(page != "" && page.length()!=0){ //입력내용이 없으면 토스트창 띄우기
                    webView.loadUrl("http://"+page);
                    if(getCurrentFocus()!=null){ //입력이 끝나면 키보드 숨기기
                        InputMethodManager manager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                        manager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),0);
                    }
                    if(ispageOpen) {
                        layout.startAnimation(upAnimaiton);
                    }
                } else{
                    Toast.makeText(getApplicationContext(),"주소를 입력하세요.",Toast.LENGTH_LONG).show();
                }
            }
        });

        openButton = findViewById(R.id.open_btn); //검색바 열기
        openButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!ispageOpen){
                    openButton.setVisibility(View.INVISIBLE);
                    layout.setVisibility(View.VISIBLE);
                    layout.startAnimation(downAnimation);
                }

            }
        });
    }


}
