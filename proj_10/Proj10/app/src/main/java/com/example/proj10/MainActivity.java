package com.example.proj10;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private Intent createIntent() {
        Intent intent = new Intent();
        intent.setAction("com.example.proj10.BROADCAST");
        intent.setType("text/plain");
        return intent;
    }

    public void asyncBroadcast(View view) {
        sendBroadcast(createIntent());
    }

    public void syncBroadcast(View view) {
        Intent intent = createIntent();
        intent.putExtra(Intent.EXTRA_TEXT, "ordered");
        sendOrderedBroadcast(intent, null, new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                Bundle results = getResultExtras(true);
                ArrayList<String[]> arrayResults = new ArrayList<>();
                for (String key : results.keySet()) {
                    arrayResults.add(new String[]{key, results.getString(key)});
                }
                fillList(arrayResults);
            }
        }, null, RESULT_OK, null, null);
    }

    private void fillList(ArrayList<String[]> data) {
        final ArrayList<String[]> theList = data;
        ListView listView = (ListView) findViewById(R.id.ListView);
        listView.setAdapter(
                new ArrayAdapter<String[]>(
                        this,
                        android.R.layout.simple_list_item_2,
                        android.R.id.text1,
                        theList
                ) {
                    @NonNull
                    @Override
                    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                        View view = super.getView(position, convertView, parent);
                        String[] entry = theList.get(position);
                        final TextView text1 = (TextView) view.findViewById(android.R.id.text1);
                        final TextView text2 = (TextView) view.findViewById(android.R.id.text2);
                        text1.setText(entry[0]);
                        text2.setText(entry[1]);
                        return view;
                    }
                }
        );
    }
}
