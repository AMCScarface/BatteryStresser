package com.example.sscata.myapplication;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.BatteryManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Toast;
import android.widget.Button;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import android.os.Environment;

import com.opencsv.CSVWriter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static android.R.attr.value;

public class MainActivity extends AppCompatActivity {

    Button start;

    public long myTime = System.currentTimeMillis();
    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        verifyStoragePermissions(this);

        setContentView(R.layout.activity_main);

                //Toast.makeText(MainActivity.this, cat, Toast.LENGTH_SHORT).show();
                //else
                //{
                //    Toast.makeText(MainActivity.this,"First checkbox Unchecked", Toast.LENGTH_SHORT).show();
                //}
                //Intent myIntent = new Intent(MainActivity.this, MyGLActivity.class);
                //myIntent.putExtra("key", value); //Optional parameters
                //MainActivity.this.startActivity(myIntent);
    }

    public void startTest(View view){

        Intent intent = new Intent(this, ShaActivity.class);
        startActivity(intent);
        //for(int i = 0; i < 10; i++) {
        //   Intent intent = new Intent(this, BlurActivity.class);
         //   startActivity(intent);
         //   Intent intent3 = new Intent(MainActivity.this, MyGLActivity.class);
         //   startActivity(intent3);
         //   Intent intent2 = new Intent(MainActivity.this, VibrationActivity.class);
         //   startActivity(intent2);
        //}
        //SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
        //Date d = null;
        //try {
        //    d = df.parse(myTime);
        //} catch (ParseException e) {
        //    e.printStackTrace();
        //}
        //Calendar cal = Calendar.getInstance();
        //cal.setTime(d);
        //cal.add(Calendar.MINUTE, 2);
        //cal.add(Calendar.SECOND, 30);
        //String newTime = df.format(cal.getTime());
        //myTime = newTime;

        //((System.currentTimeMillis() - myTime)/1000)

        Toast.makeText(MainActivity.this,"Battery :" + "ok", Toast.LENGTH_SHORT).show();
        CSVWriter writer = null;
        //try
        //{
           // writer = new CSVWriter(new FileWriter("/sdcard/myfile.csv"), ',');
            //String[] entries = "first#second#third".split("#"); // array of your values
           //writer.writeNext(entries);
           // writer.close();
       // }
        //catch (IOException e)
        //{
        //    e.printStackTrace();
        //}

    }

    public float getBatteryLevel() {
        Intent batteryIntent = registerReceiver(null, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
        int level = batteryIntent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
        int scale = batteryIntent.getIntExtra(BatteryManager.EXTRA_SCALE, -1);

        // Error checking that probably isn't needed but I added just in case.
        if(level == -1 || scale == -1) {
            return 50.0f;
        }

        return ((float)level / (float)scale) * 100.0f;
    }

    public static void verifyStoragePermissions(Activity activity) {
        // Check if we have read or write permission
        int writePermission = ActivityCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        int readPermission = ActivityCompat.checkSelfPermission(activity, Manifest.permission.READ_EXTERNAL_STORAGE);

        if (writePermission != PackageManager.PERMISSION_GRANTED || readPermission != PackageManager.PERMISSION_GRANTED) {
            // We don't have permission so prompt the user
            ActivityCompat.requestPermissions(
                    activity,
                    PERMISSIONS_STORAGE,
                    REQUEST_EXTERNAL_STORAGE
            );
        }
    }

}
