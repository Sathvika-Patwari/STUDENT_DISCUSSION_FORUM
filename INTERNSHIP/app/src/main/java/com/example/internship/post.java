package com.example.internship;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.r0adkll.slidr.Slidr;
import com.r0adkll.slidr.model.SlidrInterface;

import java.util.HashMap;
import java.util.Map;

public class post extends AppCompatActivity {
    public SlidrInterface slider;
    Button button;
    EditText Name , Email,id;
    String server_url = "http://172.20.10.8/inputsample.php";
    AlertDialog.Builder builder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        slider = Slidr.attach(this);
        button = (Button) findViewById(R.id.postbtn);
        Name = (EditText) findViewById(R.id.titlepost);
        Email = (EditText) findViewById(R.id.postmatter);
        id = (EditText) findViewById(R.id.enterrollno);
        builder = new AlertDialog.Builder(post.this);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String name , email,p_id ;
                name =Name.getText().toString();
                email=Email.getText().toString();
                p_id=id.getText().toString();
                StringRequest stringRequest = new StringRequest(Request.Method.POST, server_url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        builder.setTitle("THANK YOU");
                        builder.setMessage("Response :"+response);
                        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Name.setText("");
                                Email.setText("");
                                id.setText("");
                            }
                        });
                        AlertDialog alertDialog = builder.create();
                        alertDialog.show();

                    }
                },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(post.this,"some error found .....",Toast.LENGTH_SHORT).show();
                                error.printStackTrace();

                            }
                        }){
                    @Override
                    protected Map<String, String> getParams()  {
                        Map <String,String> Params = new HashMap<String, String>();
                        Params.put("post_title",name);
                        Params.put("post_desc",email);
                        Params.put("posted_by",p_id);
                        return Params;

                    }
                };

                Mysingleton.getInstance(post.this).addTorequestque(stringRequest);
            }
        });

    }
}



