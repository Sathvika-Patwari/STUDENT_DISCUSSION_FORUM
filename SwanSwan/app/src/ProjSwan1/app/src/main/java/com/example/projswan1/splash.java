package com.example.projswan1;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class splash extends AppCompatActivity {
    private static int SPLASH_TIME_OUT=3000;
    TextView t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Sw();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent in = new Intent(splash.this, MainActivity.class);
                startActivity(in);
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
    public void Sw()
    {
        String[] sath={"“To the world you may be one person, but to one person you are the world.”",
                "“Love takes off masks that we fear we cannot live without and know we cannot live within.”",
                "“You have found true love when you realize that you want to wake up beside your love every morning even when you have your differences.”",
                "“Love yourself first and everything else falls into line. You really have to love yourself to get anything done in this world.”",
                "“You are my paradise and I would happily get stranded on you for a lifetime.”",
                "“I’ve fallen in love many times…always with you.”",
                "“At the touch of love everyone becomes a poet.”",
                "“Thank you for always being my rainbow after the storm.”",
                "“In this crazy world, full of change and chaos, there is one thing of which I am certain, one thing which does not change: my love for you.”",
                "“The best and most beautiful things in this world cannot be seen or even heard, but must be felt with the heart.”",
                "“Sometimes I think,\n" +
                        "I need a spare heart to feel\n" +
                        "all the things I feel.”",
                "“The beautiful thing about love is that you just need to plant it once and nurture it and it shall bloom into blossoms that would cover the valleys.”",
                "“Two people in love, alone, isolated from the world, that’s beautiful.”",
                "“You are, and always have been, my dream.”",
                "“Love is a fire. But whether it is going to warm your hearth or burn down your house, you can never tell.”",
                "“Love is that condition in which the happiness of another person is essential to your own.”",
                "“You yourself, as much as anybody in the entire universe, deserve your love and affection.”"
        };
        int rand = (int)(Math.random()*(sath.length));
        TextView t1=(TextView)findViewById(R.id.textView);
        t1.setText(sath[rand]);
    }
}