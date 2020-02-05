package com.example.layout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        Bundle Extras = getIntent().getExtras();

        if (Extras != null){
            if(Extras.getString("layout").equals("linear")){
                setContentView(R.layout.linear);
            }
            if(Extras.getString("layout").equals("frame")){
                setContentView(R.layout.frame);
            }
            if(Extras.getString("layout").equals("grid")){
                setContentView(R.layout.grid);
            }
            if(Extras.getString("layout").equals("relative")){
                setContentView(R.layout.relative);
            }
            if(Extras.getString("layout").equals("table")){
                setContentView(R.layout.table);
            }
        }

    }

}
