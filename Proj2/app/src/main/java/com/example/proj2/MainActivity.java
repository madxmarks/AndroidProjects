package com.example.proj2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.content.Intent;
import android.widget.ImageView;
import android.widget.RemoteViews;
import android.widget.TextView;
import android.view.LayoutInflater;
import android.widget.Toast;

import com.example.notifications.R;


public class MainActivity extends AppCompatActivity {

    private int clicks = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button basicNotification = (Button) findViewById(R.id.button);
        Button customNotification = (Button) findViewById(R.id.button3);
        Button basicToast = (Button) findViewById(R.id.button2);
        Button customToast = (Button) findViewById(R.id.button4);

        basicNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                clicks++;
                addNotification();
            }
        });

        customNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                clicks++;
                addCustomNotification();
            }
        });

        basicToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                clicks++;
                addToast();
            }
        });

        customToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                clicks++;
                addCustomToast();
            }
        });

    }

    private void addNotification() {
        // Builds your notification
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher_round)
                .setContentTitle("basic notification")
                .setContentText("Total clicks:" + clicks);

        // Creates the intent needed to show the notification
        Intent notificationIntent = new Intent(this, com.example.notifications.MainActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(contentIntent);

        // Add as notification
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(0, builder.build());
    }

    private void addCustomNotification() {
        // Builds your notification

        RemoteViews remoteViews = new RemoteViews(getPackageName(), R.layout.custom_not);
        remoteViews.setTextViewText(R.id.notif_title,"Total clicks:" + clicks);

        Intent notificationIntent = new Intent(this, com.example.notifications.MainActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(this, 1, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder customNotification = new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher_round)
                .setAutoCancel(true)
                .setCustomBigContentView(remoteViews)
                .setContentIntent(contentIntent);
        // Creates the intent needed to show the notification

        // Add as notification
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(1, customNotification.build());
    }

    private void addToast(){
        Toast.makeText(getApplicationContext(),"Total clicks:" + clicks, Toast.LENGTH_LONG).show();
    }

    private void addCustomToast(){
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.custom_toast, (ViewGroup) findViewById(R.id.toast_root));

        TextView toastText = layout.findViewById(R.id.toast_text);
        ImageView toastImage = layout.findViewById(R.id.imageView2);

        toastText.setText("Total clicks:" + clicks);
        toastImage.setImageResource(R.drawable.bell);

        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);

        toast.show();
    }
}
