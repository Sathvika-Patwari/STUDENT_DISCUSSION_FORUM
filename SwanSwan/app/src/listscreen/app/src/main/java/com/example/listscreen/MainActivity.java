package com.example.listscreen;

import android.content.Context;
import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText txtvalue;
    Button btnfetch;
    ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtvalue = (EditText)findViewById(R.id.editText);
        btnfetch = (Button)findViewById(R.id.buttonfetch);
        listview = (ListView)findViewById(R.id.listviewpost);
        btnfetch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getData();
            }
        });
    }


    private void getData() {

        String value = txtvalue.getText().toString().trim();

        if (value.equals("")) {
            Toast.makeText(this, "Please Enter Data Value", Toast.LENGTH_LONG).show();
            return;
        }

        String url = config5.DATA_URL + txtvalue.getText().toString().trim();



        StringRequest stringRequest = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                showJSON(response);
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, error.getMessage().toString(), Toast.LENGTH_LONG).show();
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }

    private void showJSON(String response) {
        ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
        try {
            JSONObject jsonObject = new JSONObject(response);
            JSONArray result = jsonObject.getJSONArray(config5.JSON_ARRAY);

            for (int i = 0; i < result.length(); i++) {
                JSONObject jo = result.getJSONObject(i);
                String title = jo.getString(config5.KEY_TITLE);
                String date = jo.getString(config5.KEY_DATE);
                String data = jo.getString(config5.KEY_DATA);
                String id = jo.getString(config5.KEY_ID);



                final HashMap<String, String> employees = new HashMap<>();
                employees.put(config5.KEY_TITLE,  "Date = "+title);
                employees.put(config5.KEY_DATE, date);
                employees.put(config5.KEY_DATA, data);
                employees.put(config5.KEY_ID, id);

                list.add(employees);

            }


        } catch (JSONException e) {
            e.printStackTrace();
        }
        ListAdapter adapter = new SimpleAdapter(
                getApplicationContext(), list, R.layout.activity_main,
                new String[]{config5.KEY_TITLE, config5.KEY_DATE, config5.KEY_DATA, config5.KEY_ID},
                new int[]{R.id.title, R.id.date, R.id.data, R.id.tvid});

        listview.setAdapter(adapter);

    }
}