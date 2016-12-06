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

    CSVWriter writer = null;
    Button start;

    public long myTime;
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

        try {
            writer = new CSVWriter(new FileWriter("/sdcard/myfile.csv"), ',');
            String[] entries = "Timestamp#seconds#level".split("#"); // array of your values
            writer.writeNext(entries);
            entries = null;

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
        myTime =  System.currentTimeMillis();
                Intent intent = new Intent(this, ShaActivity.class);
                startActivityForResult(intent, 1);

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        Thread.sleep(150000);
                        String[] entries = null;
                        String prepare = "00:00:00#" + ((System.currentTimeMillis() - myTime) / 1000) + "#" + getBatteryLevel();
                        entries = prepare.split("#");

                        generateCsvFile("myfile.csv", entries[0], entries[1], entries[2]);

                        entries = null;
                        prepare = null;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        }).start();

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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // Check which request we're responding to
        //if (resultCode == 1) {
            // Make sure the request was successful

        if(requestCode == 1) {
          //  String[] entries = null;

            //String prepare = "00:00:00#" + ((System.currentTimeMillis() - myTime) / 1000) + "#" + getBatteryLevel();
         //   entries = prepare.split("#");

         //   generateCsvFile("myfile.csv", entries[0], entries[1], entries[2]);

            Intent intent2 = new Intent(MainActivity.this, VibrationActivity.class);
            startActivityForResult(intent2, 2);
        }

        if(requestCode == 2 ){
         //  String[] entries = null;

            //String prepare = "00:00:00#" + ((System.currentTimeMillis() - myTime) / 1000) + "#" + getBatteryLevel();
            //entries = prepare.split("#");

           // generateCsvFile("myfile.csv", entries[0], entries[1], entries[2]);

            Intent intent3 = new Intent(MainActivity.this, MyGLActivity.class);
            startActivityForResult(intent3,3);
        }

        if(requestCode == 3) {
           // String[] entries = null;

         //   String prepare = "00:00:00#" + ((System.currentTimeMillis() - myTime) / 1000) + "#" + getBatteryLevel();
           // entries = prepare.split("#");

           // generateCsvFile("myfile.csv", entries[0], entries[1], entries[2]);

            Intent intent4 = new Intent(this, ShaActivity.class);
            startActivityForResult(intent4,4);
        }

        if(requestCode == 4) {
           // String[] entries = null;

            //String prepare = "00:00:00#" + ((System.currentTimeMillis() - myTime) / 1000) + "#" + getBatteryLevel();
            //entries = prepare.split("#");

            //generateCsvFile("myfile.csv", entries[0], entries[1], entries[2]);

            Intent intent5 = new Intent(this, VideoActivity.class);
            startActivityForResult(intent5,5);
        }

        if(requestCode == 5) {
           // String[] entries = null;

           // String prepare = "00:00:00#" + ((System.currentTimeMillis() - myTime) / 1000) + "#" + getBatteryLevel();
           // entries = prepare.split("#");

           // generateCsvFile("myfile.csv", entries[0], entries[1], entries[2]);

            Intent intent = new Intent(this, BlurActivity.class);
            startActivityForResult(intent, 1);
        }

    }

    private  void generateCsvFile(String sFileName, String one, String two, String three)
    {
        //Toast.makeText(MainActivity.this,"Battery :" + "ok", Toast.LENGTH_SHORT).show();
        try
        {
            File root = Environment.getExternalStorageDirectory();
            File gpxfile = new File(root, sFileName);
            FileWriter writer = new FileWriter(gpxfile, true);

            writer.append(one);
            writer.append(',');
            writer.append(two);
            writer.append(',');
            writer.append(three);
            writer.append('\n');
            //generate whatever data you want

            writer.flush();
            writer.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

}
