package com.example.internship;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;


public class splash extends AppCompatActivity {
    private static int SPLASH_TIME_OUT=3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {

                    Intent i = new Intent(splash.this,loginlogin.class);
                    startActivity(i);
                    finish();
                }
        },SPLASH_TIME_OUT);
    }
}