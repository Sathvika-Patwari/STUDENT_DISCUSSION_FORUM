package com.example.internship;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class loginlogin extends AppCompatActivity {
    Button b1,b2;
    EditText ed1,ed2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginlogin);


        b1 = findViewById(R.id.button);
        ed1 = findViewById(R.id.username);
        ed2 = findViewById(R.id.editTextTextPassword);
        b2 =findViewById(R.id.button2);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = ed1.getText().toString();
                String password = ed2.getText().toString();
                String type = "login";


                background bg= new background(loginlogin.this);
                bg.execute(type,username,password);








            }

        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { AlertDialog.Builder build = new AlertDialog.Builder(loginlogin.this);
                build.setMessage("ARE YOU SURE YOU WANT TO SEND YOUR PASSWORD TO YOUR MAIL")
                        .setCancelable(false)
                        .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int i) {
                                dialog.cancel();
                            }
                        })
                        .setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int i) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert = build.create();
                alert.setTitle("CONFIRM!!");
                alert.show();

            }
        });





    }}
