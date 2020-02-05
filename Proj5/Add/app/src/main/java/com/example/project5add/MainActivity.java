package com.example.project5add;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    final String operation = "addition";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        showToast("Starting " + operation + " subactivity");
        Intent intent = getIntent();
        int[] data = intent.getIntArrayExtra(Intent.EXTRA_TEXT);
        if (data == null) {
            Handler handler = new Handler();
            handler.postDelayed(new Runnable()
            {
                @Override
                public void run()
                {
                    showToast("no arguments");
                }
            }, 3000);
            finish();
            return;
        }
        Handler handler = new Handler();
        final int first = data[0];
        final int second = data[1];
        handler.postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                showToast("arguments: " + first + ", " + second);
            }
        }, 3000);
        Intent result = new Intent();
        result.putExtra(Intent.EXTRA_TEXT, operation);
        result.putExtra("value", handle(data));
        setResult(Activity.RESULT_OK, result);
        finish();
    }

    private int handle(int[] data){
        return data[1] + data[0];
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }



}
