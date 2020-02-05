package com.example.layout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button frame = (Button) findViewById(R.id.frame);
        Button relative = (Button) findViewById(R.id.relative);
        Button grid = (Button) findViewById(R.id.grid);
        Button linear = (Button) findViewById(R.id.linear);
        Button table = (Button) findViewById(R.id.table);

        frame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchSecondActivity("frame");
                Log.d("","frame");
            }
        });

        grid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchSecondActivity("grid");
                Log.d("","grid");
            }
        });

        relative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchSecondActivity("relative");
                Log.d("","relative");
            }
        });

        linear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchSecondActivity("linear");
                Log.d("","linear");
            }
        });

        table.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchSecondActivity("table");
                Log.d("","table");
            }
        });
    }

    private void launchSecondActivity(String  layout) {
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        intent.putExtra("layout", layout);
        startActivity(intent);
    }
}