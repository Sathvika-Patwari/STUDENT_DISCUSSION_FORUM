package com.example.internship;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.r0adkll.slidr.Slidr;
import com.r0adkll.slidr.model.SlidrInterface;

public class edit extends AppCompatActivity {
    private SlidrInterface slide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit);

        slide= Slidr.attach(this);
    }
}
