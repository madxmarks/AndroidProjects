package com.example.activitylifecycle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Locale;

public class SecondActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Button thirdActivity = (Button) findViewById(R.id.button3);
        thirdActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchThirdActivity();
            }
        });

        makeNotification("onCreate");
    }

    @Override
    protected void onStart() {
        makeNotification("onStart");
        super.onStart();
    }

    @Override
    protected void onResume() {
        makeNotification("onResume");
        super.onResume();
    }

    @Override
    protected void onPause() {
        makeNotification("onPause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        makeNotification("onStop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        makeNotification("onDestroy");
        super.onDestroy();
    }

    private void launchThirdActivity(){
        Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
        //intent.putExtra("text", submitText);
        startActivity(intent);
    }

    String getDateTime(){
        long currentTimeMillis = System.currentTimeMillis();
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(currentTimeMillis);

        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH)+1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int hours = calendar.get(Calendar.HOUR);
        int minutes = calendar.get(Calendar.MINUTE);
        int seconds = calendar.get(Calendar.SECOND);
        return String.format(Locale.getDefault(), "%04d-%02d-%02d %02d:%02d:%02d:%03d",
                year, month, day, hours, minutes, seconds,currentTimeMillis%1000);
    }

    protected void makeNotification(String methodName)
    {
        String stringTime = getDateTime();
        String stringClassName = getClass().getSimpleName();

        Notification notify = new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher_round)
                .setContentTitle(stringClassName)
                .setContentText(methodName + ": " + stringTime)
                .build();
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify((int)System.currentTimeMillis(), notify);
    }

}
