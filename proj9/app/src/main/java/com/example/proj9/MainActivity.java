package com.example.proj9;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    final Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


   public void funcRadio (View view)
    {
        // setup the alert builder
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Choose an animal");
// add a radio button list
        final String[] animals = {"horse", "cow", "camel", "sheep", "goat"};
        final String[] animal = {"none"};
        int checkedItem = 1; // cow
        builder.setSingleChoiceItems(animals, checkedItem, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                onFinishUserDialog(animals[which]);
                // user checked an item
                animal[0] = animals[which];
            }
        });
// add OK and Cancel buttons

        builder.setPositiveButton("ok", new
                DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // do something like...
                        onFinishUserDialog("ok " + animal[0]);
                    }
                });
        builder.setNeutralButton("cancel", new
                DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // do something like...
                        onFinishUserDialog("cancel");
                    }
                });
        builder.setNegativeButton("no", new
                DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // do something like...
                        onFinishUserDialog("no");
                    }
                });
// create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void funcCheckbox (View view)
    {
        // setup the alert builder
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Choose some animals");
// add a checkbox list
        final String[] animals = {"horse", "cow", "camel", "sheep", "goat"};
        boolean[] checkedItems = {true, false, false, true, false};
        builder.setMultiChoiceItems(animals, checkedItems, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                // user checked or unchecked a box
                String che;
                if (isChecked)
                 che = "checked";
                else
                    che = "unchecked";
                onFinishUserDialog(animals[which] + " " + che );
            }
        });
// add OK and Cancel buttons

        builder.setPositiveButton("ok", new
                DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // do something like...
                        onFinishUserDialog("ok ");
                    }
                });
        builder.setNeutralButton("cancel", new
                DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // do something like...
                        onFinishUserDialog("cancel");
                    }
                });
        builder.setNegativeButton("no", new
                DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // do something like...
                        onFinishUserDialog("no" );
                    }
                });
// create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }


    public void funcSimplList (View view) {
        // setup the alert builder
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Choose an animal");
        // add a list
        final String[] animals = {"horse", "cow", "camel", "sheep", "goat"};
        builder.setItems(animals, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                onFinishUserDialog( animals[which] );
                switch (which) {
                    case 0: // onFinishUserDialog( "horse" );
                    case 1:  // onFinishUserDialog( "cow" );
                    case 2: // camel
                    case 3: // sheep
                    case 4: // goat
                }

            }
        });

        builder.setPositiveButton("ok", new
                DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // do something like...
                        onFinishUserDialog("ok ");
                    }
                });
        builder.setNeutralButton("cancel", new
                DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // do something like...
                        onFinishUserDialog("cancel");
                    }
                });
        builder.setNegativeButton("no", new
                DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // do something like...
                        onFinishUserDialog("no");
                    }
                });
        // create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void onFinishUserDialog(String mess) {
        Toast.makeText(this, mess, Toast.LENGTH_SHORT).show();
    }

    public void funcSimpl (View view) {
        // setup the alert builder
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Notice");
        builder.setMessage("Launching this missile will destroy the entire universe. Is this what you intended to do?");
        // add the buttons
        builder.setPositiveButton("ok", new
        DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // do something like...
                onFinishUserDialog("ok");
            }
    });
        builder.setNeutralButton("cancel", new
                DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // do something like...
                        onFinishUserDialog("cancel");
                    }
                });
        builder.setNegativeButton("no", new
                DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // do something like...
                        onFinishUserDialog("no");
                    }
                });
        // create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void showAlertDialogButtonClicked(View view) {
        // create an alert builder
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Name");
        // set the custom layout
        final View customLayout = getLayoutInflater().inflate(R.layout.mylay, null);
        builder.setView(customLayout);
        // add a button
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // send data from the AlertDialog to the Activity
                final int[] val = new int[1];
                EditText editText = customLayout.findViewById(R.id.editText);
                EditText editText2 = customLayout.findViewById(R.id.editText2);
                SeekBar seekBar = customLayout.findViewById(R.id.seekBar);

                sendDialogDataToActivity(editText.getText().toString() +  "\n" + editText2.getText().toString()
                        +  "\n" + seekBar.getProgress() + " %");
            }
        });
        builder.setNeutralButton("cancel", new
                DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // do something like...
                        onFinishUserDialog("cancel");
                    }
                });
        builder.setNegativeButton("no", new
                DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // do something like...
                        onFinishUserDialog("no");
                    }
                });
        // create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }
    // do something with the data coming from the AlertDialog
    private void sendDialogDataToActivity(String data) {
        Toast.makeText(this, data, Toast.LENGTH_SHORT).show();
    }



}
