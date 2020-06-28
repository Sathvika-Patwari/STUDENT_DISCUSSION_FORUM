package com.example.s;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    Thread background = new Thread() {
        public void run() {
            try {
                // Thread will sleep for 5 seconds
                sleep(5*1000);

                // After 5 seconds redirect to another intent
                Intent i=new Intent(getBaseContext(),FirstScreen.class);
                startActivity(i);

                //Remove activity
                finish();
            } catch (Exception e) {
            }
        }
    };
    // start thread
        background.start();
}