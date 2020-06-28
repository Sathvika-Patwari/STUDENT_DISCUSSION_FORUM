package com.example.swanswan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class MainActivity extends AppCompatActivity {
    AutoCompleteTextView a;
    String[] countries={
            "India",
            "Korea",
            "Japan",
            "USA",
            "England",
            "Belgium",
            "South Africa",
            "Sri Lanka",
            "Afghanistan",
            "American Samoa"

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        a = (AutoCompleteTextView)findViewById(R.id.autoCompleteTextView);
        ArrayAdapter apd = new ArrayAdapter(this,android.R.layout.select_dialog_item,countries);

        a.setThreshold(1);
        a.setAdapter(apd);
    }
}