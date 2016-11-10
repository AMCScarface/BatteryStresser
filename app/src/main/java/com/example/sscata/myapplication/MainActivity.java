package com.example.sscata.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Toast;
import android.widget.Button;

import static android.R.attr.value;

public class MainActivity extends AppCompatActivity {

    CheckBox vibration, gputest, rendering;
    RadioButton duration;
    Button start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vibration = (CheckBox) findViewById(R.id.cb_vibration);
        gputest = (CheckBox) findViewById(R.id.cb_gputest);
        rendering = (CheckBox) findViewById(R.id.cb_rendering);

        duration = (RadioButton) findViewById(R.id.rb_full);

                String cat = "";
                if(vibration.isChecked())
                {
                    cat += "vib=on ";
                }

                if(gputest.isChecked())
                {
                    cat += "gpu=on ";
                }

                if(rendering.isChecked())
                {
                    cat += "ren=on ";
                }

                if(duration.isChecked())
                {
                    cat += ">>>>full OK<<<<<";
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
        //Intent intent = new Intent(this, MyGLActivity.class);
        //startActivity(intent);

        Thread thread = new Thread( new Runnable() {
            @Override
            public void run() {
                try
                {
                    Intent intent = new Intent(MainActivity.this, MyGLActivity.class);
                    startActivity(intent);
                    Thread.sleep(10000);
                    Intent intent2 = new Intent(MainActivity.this, MyGLActivity.class);
                    startActivity(intent2);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
            finally {
                //finish();
            }
        }
    });

    thread.start();
    }

}
