package com.example.projswan1;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.core.app.NotificationCompat;


public class Notification_reciever extends BroadcastReceiver {
    public static final String CHANNEL_1_ID="channel1";
    @Override
    public void onReceive(Context context, Intent intent) {

        NotificationManager nm=(NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
        Intent ri=new Intent(context,time.class);
        ri.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent pendingIntent=PendingIntent.getActivity(context,100,ri,PendingIntent.FLAG_UPDATE_CURRENT);
        long[] pattern={0,1000,2000,3000,4000,5000,6000,7000,8000,9000,10000};
        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(context)
                        .setContentIntent(pendingIntent)
                        .setSmallIcon(R.drawable.ic_baseline_favorite_24)
                        .setContentTitle("BeD TiMe BoOcHi..")
                        .setContentText("Go to bed ra twaraga..^_^")
                        .setVibrate(pattern)
                        .setAutoCancel(false);

        nm.notify(100,builder.build());
    }

}
