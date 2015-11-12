package com.madrid.parking.android.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.android.parking.myparking.R;


/**
 * Created by Marcin on 22/10/2015.
 */
public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        switchContent = R.id.content_frame;

        //requestDeviceOrientation();
        //this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_splash);

        goToMain();
    }


    private void goToMain(){

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                Intent i = new Intent(SplashActivity.this, MainActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(i);
            }
        }, 3000);

    }
}
