package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    TextView myView;
    ListView myList;
    SharedPreferences settings;
    SharedPreferences.Editor editor;
    int counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myView = findViewById(R.id.textView);
        myList = findViewById(R.id.listView);
        settings = getPreferences(MODE_PRIVATE);
        editor = settings.edit();

        pushData();
    }

    private void pushData() {
        ArrayList<String> list = new ArrayList<>();
        for (Map.Entry<String, ?> entry : settings.getAll().entrySet())
            list.add(entry.getValue().toString());
        setListData(list);
        counter = list.size();
        myView.setText(String.valueOf(counter));
    }

    private void setListData(ArrayList<String> data) {
        myList.setAdapter(new ArrayAdapter<>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                data
        ));
    }

    public void addData(View view) {
        editor.putString(String.valueOf(++counter), getDateTime());
        editor.commit();
        pushData();
    }

    public void deleteData(View view) {
        clearSetting();
        pushData();
    }

    private void clearSetting() {
        editor.remove(String.valueOf(counter));
        editor.commit();
    }

    private String getDateTime()
    {
        long currentTimeMillis = System.currentTimeMillis();
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(currentTimeMillis);

        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH)+1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int hours = calendar.get(Calendar.HOUR);
        int minutes = calendar.get(Calendar.MINUTE);
        int seconds = calendar.get(Calendar.SECOND);
        return String.format(Locale.ENGLISH, "%04d-%02d-%02d %02d:%02d:%02d:%03d",
                year, month, day, hours, minutes, seconds,currentTimeMillis%1000);
    }
}
