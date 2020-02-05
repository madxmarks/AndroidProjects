package com.example.project5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    final int UNIQUE_KEY = 2020;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    protected  void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == UNIQUE_KEY && resultCode == RESULT_OK) {
            handleResult(data);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void handleResult(Intent result){
        TextView resultText = findViewById(R.id.resultText);
        TextView operationText = findViewById(R.id.operationText);

        operationText.setText(result.getStringExtra(Intent.EXTRA_TEXT));
        resultText.setText(String.valueOf(result.getIntExtra("value", 0)));
    }

    public void run(View view){
        Intent sendIntent = new Intent();
        sendIntent.setAction("com.example.project5");
        sendIntent.putExtra(Intent.EXTRA_TEXT, gatherData());
        sendIntent.setType("text/plain");
        startActivityForResult(sendIntent, UNIQUE_KEY);
    }

    private int[] gatherData(){
        TextView arg1 = findViewById(R.id.arg1);
        TextView arg2 = findViewById(R.id.arg2);
        return new int[] { Integer.parseInt(nullCheck(arg1.getText().toString())),
                           Integer.parseInt(nullCheck(arg2.getText().toString())) };

    }

    public String nullCheck(String txt) {
        return txt.equals("") ? "0" : txt;
    }
}
