package com.example.projswan1;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class time extends AppCompatActivity{
    TimePicker t1;
    Button b1;
    TextView t2;
    static final int DIALOG_ID=0;
    public int hr;
    public int min;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);
        showtime();
    }
    public void showtime(){
        TextView t2=(TextView)findViewById(R.id.textView3);
        Button b1=(Button)findViewById(R.id.button);
        TimePicker t1=(TimePicker)findViewById(R.id.timePicker1);
        t2.setText("ReMeMbEr SwE:\n" +
                "EARLY to BED,EARLY to RISE,makes a person HEALTHY,WEALTHY and WISE..");
        b1.setOnClickListener(
            new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    addNotification();




                }
            }
        );
    }
    private void addNotification() {

        TimePicker t1=(TimePicker)findViewById(R.id.timePicker1);
        hr=t1.getCurrentHour();
        min=t1.getCurrentMinute();

        Toast.makeText(this,"Bed time has been Saved to "+hr+" : "+min,Toast.LENGTH_LONG).show();
        Calendar calendar=Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY,hr);
        calendar.set(Calendar.MINUTE,min);
        calendar.set(Calendar.SECOND,0);
        Intent i=new Intent(getApplicationContext(),Notification_reciever.class);
        PendingIntent pd=PendingIntent.getBroadcast(getApplicationContext(),100,i,PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager am=(AlarmManager)getSystemService(ALARM_SERVICE);
        am.setRepeating(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),AlarmManager.INTERVAL_DAY,pd);

    }

}