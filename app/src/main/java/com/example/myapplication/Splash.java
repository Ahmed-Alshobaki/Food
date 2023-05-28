package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;


import com.example.myapplication.databinding.ActivitySplashBinding;

public class Splash extends AppCompatActivity {
    ActivitySplashBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Thread thread =new Thread() {

            public void run() {
                try {
                    sleep(2000);
                    Intent intent = new Intent(Splash.this, Welcome.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e) {

                    e.printStackTrace();
                }
            }


        };
        thread.start();
    }
}