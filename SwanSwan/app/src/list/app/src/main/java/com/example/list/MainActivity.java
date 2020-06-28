package com.example.list;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.ListView;


import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;



public class MainActivity<HttpResponse, HttpClient, HttpPost, CustomerAdapter, BackTask> extends Activity{

    Activity context;

    HttpPost httppost;

    StringBuffer buffer;

    boolean response;

    HttpClient httpclient;

    ProgressDialog pd;

    CustomerAdapter adapter;

    ListView listProduct;

    ArrayList<Product> records;


    protected void onCreate(Bundle savedInstanceState) {

        //TODO Auto-generated method stub

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        context=this;

        records=new ArrayList<Product>();

        listProduct=(ListView)findViewById(R.id.product_list);

        adapter= (CustomerAdapter) new CustomAdapter(context, R.layout.list_item,R.id.pro_name, records);

        listProduct.setAdapter((ListAdapter) adapter);

    }

    protected  void o(){



        BackTask bt;
        bt = new ();

        bt.getClass();



    }






        protected void onPreExecute(){



            pd = new ProgressDialog(context);

            pd.setTitle("Retrieving data");

            pd.setMessage("Please wait.");

            pd.setCancelable(true);

            pd.setIndeterminate(true);

            pd.show();



        }



        protected <HttpEntity> String doInBackground(String...params){

            String i_url="http://172.20.10.8/listposts.php";

            InputStream is=null;

            String result="";

            try{



                response=httpclient.equals(httppost);

                HttpEntity entity = ((clone() response);

                is = entity.getContent();



            }catch(Exception e){



                if(pd!=null)

                    pd.dismiss(); //close the dialog if error occurs

                Log.e("ERROR", e.getMessage());



            }



            //convert response to string

            try{

                BufferedReader reader = new BufferedReader(new InputStreamReader(is,"utf-8"),8);

                StringBuilder sb = new StringBuilder();

                String line = null;

                while ((line = reader.readLine()) != null) {

                    sb.append(line+"\n");

                }

                is.close();

                result=sb.toString();

            }catch(Exception e){

                Log.e("ERROR", "Error converting result "+e.toString());



            }



            //parse json data

            try{



                        result=result.substring(result.indexOf("["));

                JSONArray jArray =new JSONArray(result);

                for(int i=0;i<jArray.length();i++){

                    JSONObject json_data =jArray.getJSONObject(i);

                    Product p=new Product();

                    p.setpName(json_data.getString("pname"));

                    p.setuPrice(json_data.getInt("uprice"));



                    records.add(p);



                }





            }

            catch(Exception e){

                Log.e("ERROR", "Error pasting data "+e.toString());





            }



            return null;

        }





        protected void onPostExecute(Void result) {


            if (pd != null) pd.dismiss(); //close dialog

            Log.e("size", records.size() + "");

            adapter.notify(); //notify the ListView to get new records





    }

}