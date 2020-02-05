package com.example.dialogs;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.content.pm.PackageManager;
import android.os.Bundle;

import android.Manifest;
import android.os.Environment;
import androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.OnLifecycleEvent;

import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import java.io.FileOutputStream;




public class MainActivity extends AppCompatActivity {

    private  static final int REQUEST_WRITE_STORAGE = 112;
    private static String appName;
    private  static String ExternalPublicPath;
    private static String ExternalPrivatePath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        appName = getResources().getString(R.string.app_name);              // " ourOwnDir"
        ExternalPublicPath = getExternalFilesDir(Environment.DIRECTORY_MUSIC).getPath() + "/" + appName;
        ExternalPrivatePath = getExternalFilesDir(Environment.DIRECTORY_DCIM).getPath()+"/"+ appName;
        writeInternal("internal message");
        writeExternalPrivate ("external private message");
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                requestStoragePermission();
            }
        }, 3000);


    }


    private void writeInternal(String s) {

        try{
            FileOutputStream fos = openFileOutput(appName, MODE_PRIVATE);
            fos.write(s.getBytes());
            fos.close();
            showDoneToast(s);
        }
        catch (Exception e)
        {
            showToast(e.getMessage());
        }

    }

    private void writeExternalPublic(String s) {

        try{
            FileOutputStream fos = new FileOutputStream(ExternalPublicPath);
            fos.write(s.getBytes());
            fos.close();
            showDoneToast(s);
        }
        catch (Exception e)
        {
            showToast(e.getMessage());
        }

    }

    private void writeExternalPrivate (String s) {

        try{
            FileOutputStream fos =  new FileOutputStream(ExternalPrivatePath);
            fos.write(s.getBytes());
            fos.close();
            showDoneToast(s);
        }
        catch (Exception e)
        {
            showToast(e.getMessage());
        }

    }

    private void showDoneToast(String s) {
        showToast("done " + s);

    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private void requestStoragePermission(){
        ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.READ_EXTERNAL_STORAGE}, REQUEST_WRITE_STORAGE);
    }

    @Override
    public void onRequestPermissionsResult (int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults){
        if (requestCode == REQUEST_WRITE_STORAGE && grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
        {
            writeExternalPublic("external public message");
            finish();
        }else{
            showToast("Permission Denied");
            finish();
        }
    }

}
