package com.example.cypherswebapp.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.cypherswebapp.MainActivity;
import com.example.cypherswebapp.R;

public class SplashScreenActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        int SPLASH_DISPLAY_LENGTH = 1200; // 1.2초 동안 스플래시 스크린을 보여줍니다.

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                // 스플래시 스크린이 끝난 후에 메인 액티비티를 시작합니다.
                Intent mainIntent = new Intent(SplashScreenActivity.this, MainActivity.class);
                SplashScreenActivity.this.startActivity(mainIntent);
                SplashScreenActivity.this.finish();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }
}
