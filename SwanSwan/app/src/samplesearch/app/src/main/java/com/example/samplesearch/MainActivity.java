package com.example.samplesearch;
import android.content.ContentValues;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Spinner spinner1;
    EditText e;
    InputStream is=null;
    String result=null;
    String line=null;
    HttpURLConnection urlConnection = null;

    String text;
    String [] city;


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build(); StrictMode.setThreadPolicy(policy);

        spinner1 = (Spinner) findViewById(R.id.spinner1);
        final List<String> list1 = new ArrayList<String>();
        e = (EditText) findViewById(R.id.editText);
        Button b = (Button) findViewById(R.id.search);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//Toast.makeText(getApplicationContext(), "Invalid IP Address",Toast.LENGTH_LONG).show();

                text = e.getText().toString(); //Here i am storing the entered text in the string format in text variable

                ContentValues values = new ContentValues();
                values.put("1", text);  // This will append the entered text in the url for filter purpose


                try {

                    URL url = new URL("http://172.20.10.8/search"+text);
                    urlConnection = (HttpURLConnection) url.openConnection();
                    urlConnection.setRequestMethod("POST");
                    urlConnection.connect();
                    is = urlConnection.getInputStream();
                }
                catch (Exception e)
                {
                    Log.e("Fail 1", e.toString());
                }

                try
                {
                    BufferedReader reader = new BufferedReader(new InputStreamReader(is,"iso-8859-1"),8);
                    StringBuilder sb = new StringBuilder();
                    while ((line = reader.readLine()) != null)
                    {
                        sb.append(line + "\n");
                    }
                    is.close();
                    result = sb.toString();
                }
                catch(Exception e)
                {
                    Log.e("Fail 2", e.toString());
                }


                try
                {
                    JSONArray JA=new JSONArray(result);
                    JSONObject json= null;

                    city = new String[JA.length()];


                    for(int i=0;i<JA.length();i++)
                    {
                        json=JA.getJSONObject(i);
                        city[i] = json.getString("city");

                    }
//                    Toast.makeText(getApplicationContext(), "Data Loaded", Toast.LENGTH_LONG).show();

                    for(int i=0;i<city.length;i++)
                    {
                        list1.add(city[i]);

                    }

                    spinner_fn();

                }
                catch(Exception e)
                {

                    Log.e("Fail 3", e.toString());


                }


            }
        });


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
// Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
// Handle action bar item clicks here. The action bar will
// automatically handle clicks on the Home/Up button, so long
// as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

//noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void spinner_fn() {
// TODO Auto-generated method stub

        ArrayAdapter<String> dataAdapter1 = new ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_spinner_item, city);
        dataAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(dataAdapter1);

    }

}