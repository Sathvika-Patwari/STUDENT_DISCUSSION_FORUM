package com.example.myapplication;

import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void playRingtone(View view) {
        try {
            Uri path = Uri.parse("android.resource://" + getPackageName() + "/raw/ringtone.mp3");
            RingtoneManager.setActualDefaultRingtoneUri(
                    getApplicationContext(), RingtoneManager.TYPE_RINGTONE, path
            );
            Ringtone r = RingtoneManager.getRingtone(getApplicationContext(), path);
            r.play();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}